# E-Badge BLE Clock App

A Python Flask web app for uploading custom images to a **JieLi AC7076A-based BLE E-Badge / Smart Watch** via Bluetooth Low Energy, implementing the full **WatchTheme3 (`0xDC`) protocol** reverse-engineered from the official Android APK.

---

## Features

- 🔵 **BLE Device Scanner** — Scans and lists nearby BLE devices
- 🖼️ **Custom Image Upload** — Auto center-crops and resizes images for the badge display
- 🎨 **Live Clock Mode** — Renders current time as an image and syncs every 60 seconds
- 🧪 **Test Pattern** — Sends a built-in colorful 4-quadrant test image
- 📦 **Official Watch Pack** — Streams the original firmware watch face pack directly from the official APK
- ⚙️ **WatchTheme3 Protocol** — Full implementation of the JieLi `0xDC` BLE protocol

---

## Setup

### Requirements

- Python 3.10+
- [`uv`](https://github.com/astral-sh/uv) (recommended) or `pip`
- macOS with Bluetooth enabled

### Install & Run

```bash
# Using uv (recommended)
uv run python app.py

# Or using pip
pip install -r requirements.txt
python app.py
```

Then open **http://127.0.0.1:5001** in your browser.

---

## Hardware

| Field | Value |
|---|---|
| Chip | JieLi AC7076A |
| BLE Write Characteristic (Control) | `7E400002-B5A3-F393-E0A9-E50E24DCCA9D` (Handle 46) |
| BLE Notify Characteristic (Response) | `7E400003-B5A3-F393-E0A9-E50E24DCCA9D` (Handle 48) |
| Display Data Characteristic | `0000AA01-0000-1000-8000-00805F9B34FB` (Handle 63) |
| Display Notify Characteristic | `0000AA02-0000-1000-8000-00805F9B34FB` (Handle 65) |
| Protocol Marker | `0xDC` (WatchTheme3 / JieLi RCSP) |
| Active Watch Face Slot ID | `5538` (0x15A2) |

---

## Protocol Notes

See [`CHANGELOG.md`](CHANGELOG.md) for a full technical breakdown of everything reverse-engineered and implemented.
