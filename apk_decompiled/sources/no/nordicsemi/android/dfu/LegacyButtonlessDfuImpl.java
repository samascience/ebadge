package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.preference.PreferenceManager;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"MissingPermission"})
class LegacyButtonlessDfuImpl extends BaseButtonlessDfuImpl {
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private int mVersion;
    static UUID DFU_SERVICE_UUID = LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
    static UUID DFU_CONTROL_POINT_UUID = LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
    static UUID DFU_VERSION_UUID = LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
    private static final byte[] OP_CODE_ENTER_BOOTLOADER = {1, 4};

    LegacyButtonlessDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    private String getVersionFeatures(int i) {
        if (i == 0) {
            return "Bootloader from SDK 6.1 or older";
        }
        if (i == 1) {
            return "Application with Legacy buttonless update from SDK 7.0 or newer";
        }
        if (i == 5) {
            return "Bootloader from SDK 7.0 or newer. No bond sharing";
        }
        if (i == 6) {
            return "Bootloader from SDK 8.0 or newer. Bond sharing supported";
        }
        if (i != 7) {
            return i != 8 ? "Unknown version" : "Bootloader from SDK 9.0 or newer. Signature supported";
        }
        return "Bootloader from SDK 8.0 or newer. SHA-256 used instead of CRC-16 in the Init Packet";
    }

    /* JADX WARN: Code duplicated, block: B:25:0x005f A[Catch: all -> 0x0051, TryCatch #0 {all -> 0x0051, blocks: (B:12:0x0046, B:14:0x004a, B:25:0x005f, B:27:0x0063, B:28:0x006b, B:19:0x0053, B:21:0x0057, B:23:0x005b), top: B:54:0x0046, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0079  */
    /* JADX WARN: Code duplicated, block: B:38:0x007d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0083  */
    /* JADX WARN: Code duplicated, block: B:46:0x0098  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:58:0x006b A[EDGE_INSN: B:58:0x006b->B:28:0x006b BREAK  A[LOOP:0: B:54:0x0046->B:27:0x0063], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0063 A[SYNTHETIC] */
    private int readVersion(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read version number: device disconnected");
        }
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        if (bluetoothGattCharacteristic == null) {
            return 0;
        }
        this.mReceivedData = null;
        this.mError = 0;
        logi("Reading DFU version number...");
        this.mService.sendLogBroadcast(1, "Reading DFU version number...");
        bluetoothGattCharacteristic.setValue((byte[]) null);
        this.mService.sendLogBroadcast(0, "gatt.readCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    try {
                        if (this.mRequestCompleted && bluetoothGattCharacteristic.getValue() != null) {
                            if (this.mPaused) {
                                break;
                                break;
                            }
                            loge("Sleeping interrupted", e);
                            if (!this.mConnected) {
                                throw new DeviceDisconnectedException("Unable to read version number: device disconnected");
                            }
                            if (this.mError != 0) {
                                throw new DfuException("Unable to read version number", this.mError);
                            }
                            if (bluetoothGattCharacteristic.getValue() != null) {
                            }
                            return 0;
                        }
                        if (!this.mConnected || this.mError != 0 || this.mAborted) {
                            if (this.mPaused) {
                                break;
                            }
                            loge("Sleeping interrupted", e);
                            if (!this.mConnected) {
                                throw new DeviceDisconnectedException("Unable to read version number: device disconnected");
                            }
                            if (this.mError != 0) {
                                throw new DfuException("Unable to read version number", this.mError);
                            }
                            if (bluetoothGattCharacteristic.getValue() != null || bluetoothGattCharacteristic.getValue().length < 2) {
                                return 0;
                            }
                            return bluetoothGattCharacteristic.getIntValue(18, 0).intValue();
                        }
                        this.mRequestCompleted = false;
                        this.mLock.wait();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read version number: device disconnected");
        }
        if (this.mError != 0) {
            throw new DfuException("Unable to read version number", this.mError);
        }
        if (bluetoothGattCharacteristic.getValue() != null) {
        }
        return 0;
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean isClientCompatible(Intent intent, BluetoothGatt bluetoothGatt) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        BluetoothGattCharacteristic characteristic;
        int version;
        BluetoothGattService service = bluetoothGatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        this.mProgressInfo.setProgress(-2);
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_VERSION_UUID);
        if (characteristic2 != null) {
            version = readVersion(bluetoothGatt, characteristic2);
            this.mVersion = version;
            int i = version & 15;
            int i2 = version >> 8;
            logi("Version number read: " + i2 + FileUtils.FILE_EXTENSION_SEPARATOR + i + " -> " + getVersionFeatures(version));
            DfuBaseService dfuBaseService = this.mService;
            StringBuilder sb = new StringBuilder();
            sb.append("Version number read: ");
            sb.append(i2);
            sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            sb.append(i);
            dfuBaseService.sendLogBroadcast(10, sb.toString());
        } else {
            logi("No DFU Version characteristic found -> " + getVersionFeatures(0));
            this.mService.sendLogBroadcast(10, "DFU Version characteristic not found");
            version = 0;
        }
        boolean booleanExtra = PreferenceManager.getDefaultSharedPreferences(this.mService).getBoolean(DfuSettingsConstants.SETTINGS_ASSUME_DFU_NODE, false);
        if (intent.hasExtra(DfuBaseService.EXTRA_FORCE_DFU)) {
            booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_FORCE_DFU, false);
        }
        boolean z = bluetoothGatt.getServices().size() > 3;
        if (version == 0 && z) {
            logi("Additional services found -> Bootloader from SDK 6.1. Updating SD and BL supported, extended init packet not supported");
        }
        return version == 1 || (!booleanExtra && version == 0 && z);
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public void performDfu(Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        logw("Application with legacy buttonless update found");
        this.mService.sendLogBroadcast(15, "Application with buttonless update found");
        boolean z = true;
        this.mService.sendLogBroadcast(1, "Jumping to the DFU Bootloader...");
        if (intent.hasExtra(DfuBaseService.EXTRA_MTU)) {
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_MTU, 517);
            logi("Requesting MTU = " + intExtra);
            requestMtu(intExtra);
        }
        enableCCCD(this.mControlPointCharacteristic, 1);
        this.mService.sendLogBroadcast(10, "Notifications enabled");
        this.mProgressInfo.setProgress(-3);
        logi("Sending Start DFU command (Op Code = 1, Upload Mode = 4)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_ENTER_BOOTLOADER, true);
        this.mService.sendLogBroadcast(10, "Jump to bootloader sent (Op Code = 1, Upload Mode = 4)");
        BluetoothGatt bluetoothGatt = this.mGatt;
        boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_FORCE_SCANNING_FOR_BOOTLOADER_IN_LEGACY_DFU, false);
        if (booleanExtra || this.mVersion == 0) {
            this.mService.disconnect(bluetoothGatt);
        } else {
            this.mService.waitUntilDisconnected();
            this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        }
        logi("Device disconnected");
        if (!booleanExtra && this.mVersion != 0) {
            z = false;
        }
        finalize(intent, false, z);
    }
}
