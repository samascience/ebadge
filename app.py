import os
import io
import time
import struct
import asyncio
from datetime import datetime
from PIL import Image, ImageDraw, ImageFont, UnidentifiedImageError
from flask import Flask, render_template, request, jsonify
from bleak import BleakClient, BleakScanner

app = Flask(__name__)

# JieLi AC7076A GATT UUIDs
DISPLAY_WRITE_UUID = "0000aa01-0000-1000-8000-00805f9b34fb"  # JieLi Display Controller Characteristic (Handle 63)
OTA_WRITE_UUID = "0000ae01-0000-1000-8000-00805f9b34fb"      # JieLi OTA/Control Characteristic (Handle 5)
UART_WRITE_UUID = "7e400002-b5a3-f393-e0a9-e50e24dcca9d"     # JieLi UART Service Characteristic (Handle 46)
DEVICE_NAME_PREFIX = "E-Badge"  # Adjust based on your badge's BLE name

# State tracking for slot rotation to avoid flash overflow
active_slot = "slot_a.jpg"

def resolve_write_characteristic(client, preferred_uuid=None):
    """Dynamically resolves target write characteristic, prioritizing JieLi Display Service (aa01)."""
    # Priority 1: JieLi Display Characteristic (0000aa01) - Official WatchTheme3 Display Target
    try:
        char = client.services.get_characteristic(DISPLAY_WRITE_UUID)
        if char:
            return char
    except Exception:
        pass

    # Priority 2: JieLi Control/OTA Characteristic (0000ae01)
    try:
        char = client.services.get_characteristic(OTA_WRITE_UUID)
        if char:
            return char
    except Exception:
        pass

    if preferred_uuid:
        try:
            char = client.services.get_characteristic(preferred_uuid)
            if char:
                return char
        except Exception:
            pass

    # Priority 2: JieLi UART Characteristic (7e400002)
    try:
        char = client.services.get_characteristic(UART_WRITE_UUID)
        if char:
            return char
    except Exception:
        pass

    # Priority 3: Search for aa01, 7e400002, ae01
    for service in client.services:
        for c in service.characteristics:
            uuid_str = str(c.uuid).lower()
            if any(k in uuid_str for k in ["aa01", "7e400002", "ae01"]):
                props = c.properties
                if "write" in props or "write-without-response" in props:
                    return c

    # Fallback: First writable characteristic
    for service in client.services:
        for c in service.characteristics:
            props = c.properties
            if "write" in props or "write-without-response" in props:
                return c

    raise ValueError("No writeable GATT characteristic found on BLE device")

def create_jieli_packet(pkt_type: int, opcode: int, seq: int, payload: bytes) -> bytes:
    """Constructs a JieLi AC7076A frame: [FE DC BA] [Type] [Opcode] [Length BE] [Seq] [Payload] [EF]"""
    length = 1 + len(payload)
    header = (
        bytes.fromhex("fedcba") +
        bytes([pkt_type, opcode]) +
        length.to_bytes(2, byteorder='big') +
        bytes([seq & 0xFF])
    )
    return header + payload + b'\xef'

def calculate_crc16(data: bytes) -> int:
    """CRC16-CCITT implementation for JieLi header verification."""
    crc = 0xFFFF
    for byte in data:
        crc ^= (byte << 8)
        for _ in range(8):
            if crc & 0x8000:
                crc = ((crc << 1) ^ 0x1021) & 0xFFFF
            else:
                crc = (crc << 1) & 0xFFFF
    return crc

def convert_jpeg_to_mjpeg_avi(jpeg_bytes: bytes, target_dim: int = 240) -> bytes:
    """Wraps baseline JPEG image into Motion-JPEG AVI file container matching official APK FFmpeg parameters."""
    pid = os.getpid()
    temp_jpg = f"/tmp/e_input_{pid}.jpg"
    temp_avi = f"/tmp/e_output_{pid}.avi"

    with open(temp_jpg, "wb") as f:
        f.write(jpeg_bytes)

    ffmpeg_bin = "/opt/homebrew/bin/ffmpeg" if os.path.exists("/opt/homebrew/bin/ffmpeg") else "ffmpeg"
    cmd = [
        ffmpeg_bin, "-y", "-loop", "1", "-i", temp_jpg,
        "-t", "0.1",
        "-vf", f"scale={target_dim}:{target_dim}:force_original_aspect_ratio=decrease,pad={target_dim}:{target_dim}:(ow-iw)/2:(oh-ih)/2:color=black,fps=1",
        "-c:v", "mjpeg", "-vtag", "mjpg", "-pix_fmt", "yuvj420p",
        "-coder", "1", "-flags", "+loop+global_header", "-pred", "1",
        "-qmin", "27", "-qmax", "31", "-vsync", "cfr", "-packetsize", "4096",
        "-f", "avi", temp_avi
    ]
    try:
        res = subprocess.run(cmd, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
        if res.returncode == 0 and os.path.exists(temp_avi):
            with open(temp_avi, "rb") as f:
                avi_bytes = f.read()
            try:
                os.remove(temp_jpg)
                os.remove(temp_avi)
            except Exception:
                pass
            return avi_bytes
    except Exception:
        pass

    if os.path.exists(temp_jpg):
        try:
            os.remove(temp_jpg)
        except Exception:
            pass
    return jpeg_bytes

def process_and_crop_image(image_bytes: bytes, target_dim: int = 240, quality: int = 50) -> bytes:
    """Center-crops image to target square (240x240) and exports raw baseline JPEG matching official TurboJpegCompressor parameters."""
    img = Image.open(io.BytesIO(image_bytes)).convert("RGB")
    width, height = img.size
    
    min_dim = min(width, height)
    left = (width - min_dim) // 2
    top = (height - min_dim) // 2
    right = left + min_dim
    bottom = top + min_dim
    
    img_cropped = img.crop((left, top, right, bottom))
    img_resized = img_cropped.resize((target_dim, target_dim), Image.Resampling.LANCZOS)
    
    output = io.BytesIO()
    img_resized.save(output, format="JPEG", quality=quality, subsampling=2, progressive=False)
    return output.getvalue()

def generate_clock_image(target_dim: int = 240, quality: int = 50) -> bytes:
    """Creates a square digital clock image frame (240x240) exported as raw baseline JPEG."""
    img = Image.new("RGB", (target_dim, target_dim), color=(15, 15, 20))
    draw = ImageDraw.Draw(img)
    
    now = datetime.now()
    time_str = now.strftime("%H:%M")
    date_str = now.strftime("%a, %b %d")
    
    center = target_dim // 2
    time_font_size = max(24, int(target_dim * 0.22))
    date_font_size = max(14, int(target_dim * 0.09))

    draw.text((center, int(target_dim * 0.42)), time_str, fill=(255, 255, 255), anchor="mm", font_size=time_font_size)
    draw.text((center, int(target_dim * 0.65)), date_str, fill=(0, 200, 255), anchor="mm", font_size=date_font_size)
    
    output = io.BytesIO()
    img.save(output, format="JPEG", quality=quality, subsampling=2, progressive=False)
    return output.getvalue()

async def write_pkt(client, target_char, pkt: bytes, log_fn):
    """Writes packet cleanly to the selected target characteristic."""
    props = target_char.properties
    use_response = "write" in props
    try:
        await client.write_gatt_char(target_char, pkt, response=use_response)
    except Exception:
        try:
            await client.write_gatt_char(target_char, pkt, response=False)
        except Exception as e:
            log_fn(f"Write error on {target_char.uuid}: {e}")

def encode_baji_packet(module_id: int, command_id: int, payload: bytes) -> bytes:
    """Constructs official BAJI/Legend E-Badge protocol frame extracted from decompiled ProtocolEncoder.java."""
    payload_len = len(payload)
    pkt_hdr = bytes([0xCD]) + struct.pack('>H', payload_len + 6)
    cmd_hdr = bytes([37, 1, module_id])  # ProductId=37, Version=1, ModuleId
    len_arr = struct.pack('>H', payload_len + 1)
    cmd_payload = bytes([command_id]) + payload
    return pkt_hdr + cmd_hdr + len_arr + cmd_payload

def calc_4byte_sum(data: bytes) -> bytes:
    """Calculates 4-byte Big-Endian unsigned byte sum checksum extracted from decompiled gh3.java (j/k/ks1.l)."""
    val = sum(b & 0xFF for b in data) & 0xFFFFFFFF
    return struct.pack('>I', val)

def build_official_theme_start_packet(theme_id: int, file_size: int) -> bytes:
    """Constructs official WatchTheme3 Start Upgrade Command (qm2.g / Opcode 0x1F 0x02) extracted from decompiled gh3.java."""
    theme_id_bytes = struct.pack('>I', theme_id)
    pos_byte = bytes([0])
    bitmask_byte = bytes([0x08])  # Bit 3 = Custom Background Image
    rgb_bytes = bytes([255, 255, 255])
    size_bytes = struct.pack('>I', file_size)
    style_bytes = bytes([0]*4)
    
    payload = theme_id_bytes + pos_byte + bitmask_byte + rgb_bytes + size_bytes + style_bytes
    payload_len = len(payload)
    pkt_len = payload_len + 5
    hdr = bytes([0xDC, (pkt_len >> 8) & 0xFF, pkt_len & 0xFF, 0x1F, 0x01, 0x02, (payload_len >> 8) & 0xFF, payload_len & 0xFF])
    return hdr + payload

def build_official_theme_chunk_packet(chunk_idx: int, chunk_data: bytes) -> bytes:
    """Constructs official WatchTheme3 Chunk Command (qm2.e / Opcode 0x1F 0x01) with 4-byte Big-Endian Checksum."""
    seq_bytes = struct.pack('>H', chunk_idx + 1)
    raw_payload = seq_bytes + chunk_data
    chk_sum_bytes = calc_4byte_sum(raw_payload)
    payload = raw_payload + chk_sum_bytes
    
    payload_len = len(payload)
    pkt_len = payload_len + 5
    hdr = bytes([0xDC, (pkt_len >> 8) & 0xFF, pkt_len & 0xFF, 0x1F, 0x01, 0x01, (payload_len >> 8) & 0xFF, payload_len & 0xFF])
    return hdr + payload

def build_official_theme_finish_packet(total_file_payload: bytes) -> bytes:
    """Constructs official WatchTheme3 Finish Command (qm2.f / Opcode 0x1F 0x03) with 4-byte Total Byte Sum Checksum."""
    payload = calc_4byte_sum(total_file_payload)
    payload_len = len(payload)
    pkt_len = payload_len + 5
    hdr = bytes([0xDC, (pkt_len >> 8) & 0xFF, pkt_len & 0xFF, 0x1F, 0x01, 0x03, (payload_len >> 8) & 0xFF, payload_len & 0xFF])
    return hdr + payload

async def send_to_badge_async(target_address: str, jpeg_data: bytes, target_filename: str, write_uuid: str = None):
    """Executes official WatchTheme3 BLE payload pipeline with exact Byte Sum Checksum and GATT write."""
    logs = []
    
    def log(msg: str):
        print(f"[BLE] {msg}")
        logs.append(msg)

    async with BleakClient(target_address, timeout=15.0) as client:
        log(f"Connected to {target_address}")
        
        # 1. Full GATT Service Discovery Dump
        log("--- DISCOVERED GATT SERVICES & CHARACTERISTICS ---")
        for service in client.services:
            log(f"Service: {service.uuid}")
            for c in service.characteristics:
                log(f"  Char: {c.uuid} (handle: {c.handle}, props: {c.properties})")
        log("--------------------------------------------------")

        target_char = resolve_write_characteristic(client, write_uuid)
        log(f"Selected Write Characteristic: {target_char.uuid} (handle: {target_char.handle}, props: {target_char.properties})")

        resume_chunk_offset = 0

        # 2. Subscribe to notifications / indications
        def notification_handler(sender, data: bytes):
            nonlocal resume_chunk_offset
            hex_str = data.hex()
            log(f"Notification from {sender}: {hex_str}")
            
            # Check for WatchTheme3 ACK response frame (0xDC ... 0x1F opcode)
            if len(data) >= 7 and data[0] == 0xDC and data[3] == 0x1F:
                resp_code = (data[5] << 8) | data[6]
                if resp_code >= 1000:
                    resume_chunk_offset = resp_code - 1000
                else:
                    resume_chunk_offset = resp_code
                log(f"[WATCHTHEME3 ACK] Device requested chunk offset: {resume_chunk_offset} (raw code: {resp_code})")

        # Ensure explicit notification subscription on Display Response Characteristic 0000aa02
        try:
            display_notify_char = client.services.get_characteristic("0000aa02-0000-1000-8000-00805f9b34fb")
            if display_notify_char:
                await client.start_notify(display_notify_char, notification_handler)
                log("Subscribed to Display Response Characteristic 0000aa02")
        except Exception as e:
            log(f"Display notify sub note: {e}")

        # Target active UART write characteristic (7e400002, Handle 46)
        active_write_char = client.services.get_characteristic("7e400002-b5a3-f393-e0a9-e50e24dcca9d")
        write_target = active_write_char if active_write_char else target_char

        log(f"Active Write Characteristic: {write_target.uuid} (handle: {write_target.handle})")

        # --- Official WatchTheme3 Protocol Transfer (Decompiled from gh3.java / WatchTheme3Tools) ---
        log("--- Official WatchTheme3 Protocol Transfer (0xDC) ---")
        
        # Step 0: Read Watch Theme Transfer Status (qm2.h / Opcode 0x20 0x01)
        read_status_pkt = bytes([0xDC, 0x00, 0x05, 0x20, 0x01, 0x01, 0x00, 0x00])
        log("WatchTheme3 Step 0: Querying device flash status (qm2.h)...")
        await write_pkt(client, write_target, read_status_pkt, log)
        await asyncio.sleep(0.2)

        theme_file_payload = struct.pack('>I', len(jpeg_data)) + jpeg_data # 4-byte Big-Endian Length Header + image bytes
        theme_total_size = len(theme_file_payload)
        
        # Hardcoded active custom theme slot ID = 5538 (from WatchThemeTransferManager line 49)
        theme_id = 5538
        wt_start_pkt = build_official_theme_start_packet(theme_id, theme_total_size)
        log(f"WatchTheme3 Step 1: Start Upgrade Command (ThemeID: {theme_id}, Total Payload Size: {theme_total_size}B)...")
        await write_pkt(client, write_target, wt_start_pkt, log)
        await asyncio.sleep(0.3)  # Wait for device response notification with resume chunk offset

        wt_chunk_size = 200
        wt_total_chunks = (theme_total_size + wt_chunk_size - 1) // wt_chunk_size
        start_chunk_idx = resume_chunk_offset if resume_chunk_offset < wt_total_chunks else 0
        
        log(f"WatchTheme3 Step 2: Streaming {theme_total_size}B in {wt_total_chunks} chunks to {write_target.uuid}...")
        
        for idx in range(start_chunk_idx, wt_total_chunks):
            i = idx * wt_chunk_size
            c_data = theme_file_payload[i:i + wt_chunk_size]
            wt_chunk_pkt = build_official_theme_chunk_packet(idx, c_data)
            await write_pkt(client, write_target, wt_chunk_pkt, log)
            await asyncio.sleep(0.02)

        log("WatchTheme3 Step 3: Finish Upgrade Command (0x1F 0x03)...")
        wt_finish_pkt = build_official_theme_finish_packet(theme_file_payload)
        await write_pkt(client, write_target, wt_finish_pkt, log)
        await asyncio.sleep(0.3)

        # Step 4: Display Refresh & Custom Background Activation (qm2.i & qm2.l - Group 0x20/0x21)
        log("WatchTheme3 Step 4: Activating Display & Switching Background (qm2.i / qm2.l)...")
        apply_theme_pkt = bytes([0xDC, 0x00, 0x05, 0x20, 0x01, 0x03, 0x00, 0x00]) # qm2.i - Apply Theme Display (0x20 0x03)
        select_bg_pkt = bytes([0xDC, 0x00, 0x05, 0x21, 0x01, 0x02, 0x00, 0x00])    # qm2.l - Select Custom Background (0x21 0x02)
        await write_pkt(client, write_target, apply_theme_pkt, log)
        await asyncio.sleep(0.2)
        await write_pkt(client, write_target, select_bg_pkt, log)
        await asyncio.sleep(0.2)

        # --- PIPELINE 2: BAJI / Legend Electronic Badge Protocol (0xCD) over 00004a02 ---
        baji_char = client.services.get_characteristic("00004a02-0000-1000-8000-00805f9b34fb")
        if baji_char:
            log("--- Official BAJI Protocol Transfer (0xCD) on 00004a02 ---")
            file_size = len(jpeg_data)
            checksum = calculate_crc16(jpeg_data)
            file_id = theme_id
            ts = int(time.time())
            filename_bytes = target_filename.encode('utf-8')
            metadata_bytes = b""
            
            start_payload = (
                struct.pack('>q', file_id) +
                struct.pack('>i', file_size) +
                bytes([1]) +  # FileType = Image
                struct.pack('>i', checksum) +
                struct.pack('>i', ts) +
                struct.pack('>i', len(filename_bytes)) +
                filename_bytes +
                struct.pack('>i', len(metadata_bytes)) +
                metadata_bytes
            )
            baji_start_pkt = encode_baji_packet(1, 0, start_payload) # Module 1, Cmd 0 (TRANSFER_START)
            log(f"BAJI Step 1: Transfer Start on 00004a02 (FileID: {file_id}, Size: {file_size}B)...")
            await write_pkt(client, baji_char, baji_start_pkt, log)
            await asyncio.sleep(0.15)

            # Stream BAJI Data Chunks (Cmd 10 - FILE_DATA)
            baji_chunk_size = 200
            baji_total_chunks = (file_size + baji_chunk_size - 1) // baji_chunk_size
            log(f"BAJI Step 2: Streaming {file_size}B in {baji_total_chunks} chunks to 00004a02...")
            
            for idx, i in enumerate(range(0, file_size, baji_chunk_size)):
                c_data = jpeg_data[i:i + baji_chunk_size]
                is_last = 1 if (i + baji_chunk_size) >= file_size else 0
                
                c_payload = (
                    struct.pack('>q', file_id) +
                    struct.pack('>i', idx) +
                    struct.pack('>i', len(c_data)) +
                    bytes([is_last]) +
                    c_data
                )
                baji_chunk_pkt = encode_baji_packet(1, 10, c_payload) # Module 1, Cmd 10 (FILE_DATA)
                await write_pkt(client, baji_char, baji_chunk_pkt, log)
                await asyncio.sleep(0.02)

            log("BAJI Step 3: Transfer Complete (Cmd 6) on 00004a02...")
            complete_payload = struct.pack('>q', file_id) + struct.pack('>i', checksum)
            baji_complete_pkt = encode_baji_packet(1, 6, complete_payload)
            await write_pkt(client, baji_char, baji_complete_pkt, log)
            await asyncio.sleep(0.2)
        log("Transfer sequence complete.")
        return logs

def generate_default_test_image(target_dim: int = 240, quality: int = 75) -> bytes:
    """Generates a high-visibility 240x240 color test pattern image (RGB grid, crosshairs, bold text)."""
    img = Image.new("RGB", (target_dim, target_dim), color=(0, 0, 0))
    draw = ImageDraw.Draw(img)
    
    half = target_dim // 2
    # Draw 4 color quadrants: Top-Left Red, Top-Right Green, Bottom-Left Blue, Bottom-Right Yellow
    draw.rectangle([0, 0, half, half], fill=(255, 50, 50))
    draw.rectangle([half, 0, target_dim, half], fill=(50, 220, 50))
    draw.rectangle([0, half, half, target_dim], fill=(50, 100, 255))
    draw.rectangle([half, half, target_dim, target_dim], fill=(255, 220, 50))
    
    # Center white circle & bold text
    radius = int(target_dim * 0.28)
    center = target_dim // 2
    draw.ellipse([center - radius, center - radius, center + radius, center + radius], fill=(255, 255, 255), outline=(0, 0, 0), width=4)
    
    font_size = max(18, int(target_dim * 0.12))
    draw.text((center, center - 10), "TEST", fill=(0, 0, 0), anchor="mm", font_size=font_size)
    draw.text((center, center + 15), "PATTERN", fill=(220, 0, 0), anchor="mm", font_size=int(font_size * 0.7))
    
    output = io.BytesIO()
    img.save(output, format="JPEG", quality=quality, subsampling=2, progressive=False)
    return output.getvalue()

@app.route("/")
def index():
    return render_template("index.html")

@app.route("/api/scan", methods=["GET"])
def scan_ble():
    """Scans for nearby BLE devices."""
    async def run_scan():
        devices = await BleakScanner.discover()
        return [{"name": d.name or "Unknown", "address": d.address} for d in devices if d.name]
    
    devices = asyncio.run(run_scan())
    return jsonify(devices)

@app.route("/api/upload", methods=["POST"])
def upload_image():
    global active_slot
    address = request.form.get("address")
    mode = request.form.get("mode", "custom")
    dim = int(request.form.get("dim", 240))
    quality = int(request.form.get("quality", 75))
    filename_override = request.form.get("filename")
    write_uuid = request.form.get("write_uuid")
    
    if not address:
        return jsonify({"status": "error", "message": "No BLE device selected"}), 400

    try:
        # Process source media into hardware Motion-JPEG AVI payload
        if mode == "official_watch":
            watch_path = os.path.join(os.path.dirname(__file__), "apk_extracted", "assets", "watch")
            with open(watch_path, "rb") as f:
                jpeg_bytes = f.read()
        elif mode == "clock":
            jpeg_bytes = generate_clock_image(target_dim=dim, quality=quality)
        elif mode == "test_pattern":
            jpeg_bytes = generate_default_test_image(target_dim=dim, quality=quality)
        else:
            file = request.files.get("image")
            if not file or not file.filename:
                return jsonify({"status": "error", "message": "No image uploaded"}), 400
            
            raw_bytes = file.read()
            if not raw_bytes:
                return jsonify({"status": "error", "message": "Uploaded image file is empty"}), 400
                
            jpeg_bytes = process_and_crop_image(raw_bytes, target_dim=dim, quality=quality)

        if filename_override:
            target_file = filename_override
        else:
            # Rotate slot filenames with hardware-native .avi extension
            active_slot = "slot_b.avi" if active_slot == "slot_a.avi" else "slot_a.avi"
            target_file = active_slot

        logs = asyncio.run(send_to_badge_async(address, jpeg_bytes, target_file, write_uuid=write_uuid))
        return jsonify({"status": "success", "slot": target_file, "size": len(jpeg_bytes), "logs": logs})
    except UnidentifiedImageError:
        return jsonify({"status": "error", "message": "Invalid or corrupted image format. Please upload a valid JPG/PNG file."}), 400
    except Exception as e:
        return jsonify({"status": "error", "message": str(e)}), 500

if __name__ == "__main__":
    port = int(os.environ.get("PORT", 5001))
    app.run(host="0.0.0.0", port=port, debug=True)
