# Changelog — E-Badge BLE Clock App

All technical changes, reverse-engineering discoveries, and protocol implementation details.

---

## Session: 2026-08-06 — Full WatchTheme3 Protocol Reverse Engineering & Implementation

### Summary

This session involved a complete reverse-engineering of the official **SuperBand / Legend E-Badge Android APK** to understand and implement the JieLi `0xDC` WatchTheme3 BLE protocol. The device (JieLi AC7076A chip) did not respond to several custom/guessed protocols, so we decompiled the APK and read the exact Java source code to extract the protocol specification.

---

## 1. APK Decompilation

- Decompiled `SuperBand_2.1.25_apkcombo.com.xapk` using **jadx-gui**.
- Key source files analyzed:
  - `defpackage/gh3.java` — `WatchTheme3Tools`: Core BLE packet builder & state machine
  - `defpackage/qm2.java` — `WatchTheme3Packet`: All BLE packet format constants
  - `xfkj/fitpro/manager/WatchThemeTransferManager.java` — High-level transfer orchestration
  - `xfkj/fitpro/manager/WatchThemeTransferManager$convertBitmapOfJIELI$2.java` — Image conversion (JieLi native `.bin` format)
  - `com/jieli/bmp_convert/BmpConvert.java` — Native library wrapper for `libjl_bmp_convert.so`
  - `defpackage/o72.java` — All GATT UUID constants
  - `com/legend/mywatch/sdk/mywatchsdklib/android/bluetooth/a.java` — BLE GATT management (`LeService`)
  - `com/legend/mywatch/sdk/mywatchsdklib/android/bluetooth/c.java` — Notification decoder

---

## 2. GATT Service Map (JieLi AC7076A)

| UUID | Handle | Properties | Role |
|---|---|---|---|
| `0000ae01-0000-1000-8000-00805f9b34fb` | 5 | write-without-response | OTA/Control Write |
| `0000ae02-0000-1000-8000-00805f9b34fb` | 7 | notify | OTA/Control Notify |
| `00004a02-0000-1000-8000-00805f9b34fb` | 41 | read, write, notify | BAJI Custom Protocol |
| `7e400002-b5a3-f393-e0a9-e50e24dcca9d` | 46 | write, write-without-response | **Active RCSP/UART Write** |
| `7e400003-b5a3-f393-e0a9-e50e24dcca9d` | 48 | notify | **Active RCSP/UART Notify** |
| `7e400004-b5a3-f393-e0a9-e50e24dcca9d` | 51 | read, notify, write-without-response | RCSP Extended |
| `0000aa01-0000-1000-8000-00805f9b34fb` | 63 | write, write-without-response | Display Data Write |
| `0000aa02-0000-1000-8000-00805f9b34fb` | 65 | notify, indicate | Display Response Notify |

**Key finding**: The official app routes **all WatchTheme3 protocol packets** through `7E400002` (Handle 46), the JieLi RCSP/UART characteristic — not directly to `aa01`.

---

## 3. WatchTheme3 Protocol (`0xDC`) — Full Specification

Extracted from `gh3.java` (WatchTheme3Tools) and `qm2.java`.

### Packet Frame Format

```
[0xDC] [pkt_len_hi] [pkt_len_lo] [group] [opcode] [sub] [payload_len_hi] [payload_len_lo] [payload...]
```

- `pkt_len` = `payload_len + 5`

### Opcodes (from `qm2.java`)

| Name | Group | Sub | Opcode | Description |
|---|---|---|---|---|
| `qm2.h` | `0x20` | `0x01` | `0x01` | Read Flash Status / Query |
| `qm2.g` | `0x1F` | `0x01` | `0x02` | Start Upgrade |
| `qm2.e` | `0x1F` | `0x01` | `0x01` | Chunk Data Transfer |
| `qm2.f` | `0x1F` | `0x01` | `0x03` | Finish Upgrade |
| `qm2.i` | `0x20` | `0x01` | `0x03` | Apply Display / Force Redraw |
| `qm2.l` | `0x21` | `0x01` | `0x02` | Select Custom Background Mode |

### Step 0: Status Query (`qm2.h`)
```python
bytes([0xDC, 0x00, 0x05, 0x20, 0x01, 0x01, 0x00, 0x00])
```

### Step 1: Start Upgrade (`qm2.g`)
Payload: `[ThemeID (4B BE)] + [Pos (1B=0)] + [Bitmask (1B=0x08)] + [RGB (3B=0xFF,0xFF,0xFF)] + [FileSize (4B BE)] + [StylePadding (4B=0x00)]`

- **ThemeID**: Must be `5538` (hardcoded in `WatchThemeTransferManager$buildWatchTheme3Body$2.java:L49` as `xg3VarG.o(5538)`)
- **Bitmask `0x08`**: Bit 3 = Custom Background Image flag
- **FileSize**: 4-byte Big-Endian total size of the payload (`4-byte length header + jpeg bytes`)

### Step 2: Chunk Transfer (`qm2.e`)
Each chunk: `[Seq (2B BE, 1-indexed)] + [ChunkData] + [4-byte BE unsigned byte sum checksum]`

- Chunk size: 200 bytes
- Checksum: `sum(all bytes in seq + chunk_data) & 0xFFFFFFFF`, packed as Big-Endian 4-byte int

### Step 3: Finish Upgrade (`qm2.f`)
Payload: `[4-byte BE unsigned byte sum checksum of entire theme_file_payload]`

### Step 4: Display Activation (`qm2.i` + `qm2.l`)
```python
# Apply Theme / Force Display Redraw
bytes([0xDC, 0x00, 0x05, 0x20, 0x01, 0x03, 0x00, 0x00])
# Select Custom Background Mode
bytes([0xDC, 0x00, 0x05, 0x21, 0x01, 0x02, 0x00, 0x00])
```

---

## 4. Theme File Payload Format

The image data sent is **not raw JPEG** alone. It includes a 4-byte Big-Endian length header:

```
theme_file_payload = struct.pack('>I', len(jpeg_data)) + jpeg_data
```

- This matches `gh3.java:S()` method which prepends file size as a 4-byte BE integer before the image bytes.
- The official app uses `TurboJpegCompressor` with **quality=50** and **subsampling=2 (YUV420)**. Our app uses `quality=75` by default.

---

## 5. Image Requirements

| Parameter | Value |
|---|---|
| Format | JPEG |
| Quality | 50 (official) / 75 (our default) |
| Subsampling | YUV420 (chroma subsampling=2) |
| Size | Typically 128×128 or 240×240 px |
| Max Transfer Size | ~6–12 KB recommended |

The official app passes images through native `BmpConvert.bitmapConvert()` (JNI `libjl_bmp_convert.so`). For watchface type 3 (`algorithm==3`), it uses **conversion type 6** (`TYPE_707N_ARGB`), which produces a proprietary JieLi `.bin` format — not plain JPEG. For all other types, JPEG is used.

---

## 6. Device Response Codes

Parsed by `gh3.java:N()` via `ks1.b()` (reads 4-byte BE int from hex notification):

| Code | Meaning |
|---|---|
| `0` | ACK / Ready to receive chunk at index 0 |
| `1` | Checksum failed |
| `2` | **Update success** ✅ |
| `3` | Error 1008 |
| `4` | Error 1009 |
| `5` | Error 1010 — Insufficient flash space (file too large) |
| `6` | Error 1011 |
| `7` | Error 1012 — Duplicate payload (same checksum cached) |
| `8` | Error 1013 |
| `1000 + N` | Resume from chunk index N |

---

## 7. Changes to `app.py`

### New Functions Added

| Function | Description |
|---|---|
| `calc_4byte_sum(data)` | 4-byte Big-Endian unsigned byte sum checksum (from `gh3.java:j/k/ks1.l`) |
| `build_official_theme_start_packet(theme_id, file_size)` | Builds `qm2.g` Start Upgrade packet |
| `build_official_theme_chunk_packet(chunk_idx, chunk_data)` | Builds `qm2.e` 200-byte chunk packet with checksum |
| `build_official_theme_finish_packet(payload)` | Builds `qm2.f` Finish Upgrade packet with total checksum |
| `encode_baji_packet(module_id, cmd_id, payload)` | Builds BAJI `0xCD` protocol frame for `00004a02` channel |
| `calculate_crc16(data)` | CRC-16 checksum for BAJI protocol |
| `write_pkt(client, char, pkt, log_fn)` | Async BLE write with write-with-response fallback |

### Pipeline Architecture

```
Step 0: Status Query → 7e400002 (RCSP Write)
Step 1: Start Upgrade (ThemeID=5538) → 7e400002
Step 2: 200-byte Chunks (0-indexed, 1-indexed SEQ) → 7e400002
Step 3: Finish Upgrade (total checksum) → 7e400002
Step 4: Apply Display Refresh + Custom Background → 7e400002
Step 5 (optional): BAJI protocol on 00004a02 (parallel channel)
```

### Key Design Decisions

1. **ThemeID = 5538**: Hardcoded from `WatchThemeTransferManager$buildWatchTheme3Body$2.java:L49`. This targets the active custom watch face slot on the device.

2. **Target Characteristic = `7e400002`**: All packets route through the JieLi RCSP/UART active write channel, matching how `LeService` (`a.java`) operates in the official app.

3. **Dynamic resume offset**: The `send_to_badge_async()` function listens to `0000aa02` notifications during streaming. If a `1000+N` resume code is received, streaming resumes from chunk `N`.

4. **BAJI secondary pipeline**: After WatchTheme3 completes, an optional BAJI `0xCD` transfer is also issued over `00004a02` as a secondary display trigger.

---

## 8. UI Changes (`templates/index.html`)

- Added **"Send Official Watch Pack"** (purple) button — streams `apk_extracted/assets/watch` (268,720-byte official watch face binary from the APK) directly.
- Existing buttons: Send Uploaded Image, Send Default Test Pattern.
- Live Clock Mode toggle remains.

---

## 9. What Still Needs Investigation

- [ ] The official app uses `libjl_bmp_convert.so` JNI for `algorithm==3` (type 6 = `TYPE_707N_ARGB`). We do not replicate this native conversion — we send JPEG. If the device expects a proprietary `.bin` format, images may not render.
- [ ] The `assets/watch` pack is a JieLi `PackResFormat` container (not raw JPEG). The actual image resolution of the built-in watch face is unknown — it likely must match the hardware display size exactly.
- [ ] Confirm correct display resolution from device or by intercepting the official app's BLE traffic with a sniffer.
- [ ] Consider using a BLE sniffer (nRF Sniffer for Bluetooth LE) while running the official Android app to capture the exact bytes sent when changing the watch face.
