package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.SystemClock;
import defpackage.pa1;
import java.io.InputStream;
import java.util.Locale;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"MissingPermission"})
class LegacyDfuImpl extends BaseCustomDfuImpl {
    static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    static final UUID DEFAULT_DFU_PACKET_UUID;
    static final UUID DEFAULT_DFU_SERVICE_UUID;
    static final UUID DEFAULT_DFU_VERSION_UUID;
    static UUID DFU_CONTROL_POINT_UUID = null;
    static UUID DFU_PACKET_UUID = null;
    static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    static UUID DFU_VERSION_UUID = null;
    private static final byte[] OP_CODE_ACTIVATE_AND_RESET;
    private static final int OP_CODE_ACTIVATE_AND_RESET_KEY = 5;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_COMPLETE;
    private static final int OP_CODE_INIT_DFU_PARAMS_KEY = 2;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_START;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_KEY = 17;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 8;
    private static final byte[] OP_CODE_RECEIVE_FIRMWARE_IMAGE;
    private static final int OP_CODE_RECEIVE_FIRMWARE_IMAGE_KEY = 3;
    private static final byte[] OP_CODE_RESET;
    private static final int OP_CODE_RESET_KEY = 6;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 16;
    private static final byte[] OP_CODE_START_DFU;
    private static final int OP_CODE_START_DFU_KEY = 1;
    private static final byte[] OP_CODE_START_DFU_V1;
    private static final byte[] OP_CODE_VALIDATE;
    private static final int OP_CODE_VALIDATE_KEY = 4;
    private final LegacyBluetoothCallback mBluetoothCallback;
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private boolean mImageSizeInProgress;
    private BluetoothGattCharacteristic mPacketCharacteristic;

    protected class LegacyBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        protected LegacyBluetoothCallback() {
            super();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGattCharacteristic.getIntValue(17, 0).intValue() == 17) {
                LegacyDfuImpl.this.mProgressInfo.setBytesReceived(bluetoothGattCharacteristic.getIntValue(20, 1).intValue());
                handlePacketReceiptNotification(bluetoothGatt, bluetoothGattCharacteristic);
            } else if (!LegacyDfuImpl.this.mRemoteErrorOccurred) {
                if (bluetoothGattCharacteristic.getIntValue(17, 2).intValue() != 1) {
                    LegacyDfuImpl.this.mRemoteErrorOccurred = true;
                }
                handleNotification(bluetoothGatt, bluetoothGattCharacteristic);
            }
            LegacyDfuImpl.this.notifyLock();
        }

        @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl.BaseCustomBluetoothCallback
        protected void onPacketCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (LegacyDfuImpl.this.mImageSizeInProgress) {
                LegacyDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
                LegacyDfuImpl.this.mImageSizeInProgress = false;
            }
        }
    }

    static {
        UUID uuid = new UUID(23296205844446L, 1523193452336828707L);
        DEFAULT_DFU_SERVICE_UUID = uuid;
        UUID uuid2 = new UUID(23300500811742L, 1523193452336828707L);
        DEFAULT_DFU_CONTROL_POINT_UUID = uuid2;
        UUID uuid3 = new UUID(23304795779038L, 1523193452336828707L);
        DEFAULT_DFU_PACKET_UUID = uuid3;
        UUID uuid4 = new UUID(23313385713630L, 1523193452336828707L);
        DEFAULT_DFU_VERSION_UUID = uuid4;
        DFU_SERVICE_UUID = uuid;
        DFU_CONTROL_POINT_UUID = uuid2;
        DFU_PACKET_UUID = uuid3;
        DFU_VERSION_UUID = uuid4;
        OP_CODE_START_DFU = new byte[]{1, 0};
        OP_CODE_START_DFU_V1 = new byte[]{1};
        OP_CODE_INIT_DFU_PARAMS = new byte[]{2};
        OP_CODE_INIT_DFU_PARAMS_START = new byte[]{2, 0};
        OP_CODE_INIT_DFU_PARAMS_COMPLETE = new byte[]{2, 1};
        OP_CODE_RECEIVE_FIRMWARE_IMAGE = new byte[]{3};
        OP_CODE_VALIDATE = new byte[]{4};
        OP_CODE_ACTIVATE_AND_RESET = new byte[]{5};
        OP_CODE_RESET = new byte[]{6};
        OP_CODE_PACKET_RECEIPT_NOTIF_REQ = new byte[]{8, 0, 0};
    }

    LegacyDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        this.mBluetoothCallback = new LegacyBluetoothCallback();
    }

    private int getStatusCode(byte[] bArr, int i) throws UnknownResponseException {
        byte b;
        if (bArr == null || bArr.length != 3 || bArr[0] != 16 || bArr[1] != i || (b = bArr[2]) < 1 || b > 6) {
            throw new UnknownResponseException("Invalid response received", bArr, 16, i);
        }
        return b;
    }

    private int readVersion(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic != null) {
            return bluetoothGattCharacteristic.getIntValue(18, 0).intValue();
        }
        return 0;
    }

    private void resetAndRestart(BluetoothGatt bluetoothGatt, Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        this.mService.sendLogBroadcast(15, "Last upload interrupted. Restarting device...");
        this.mProgressInfo.setProgress(-5);
        logi("Sending Reset command (Op Code = 6)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
        this.mService.sendLogBroadcast(10, "Reset request sent");
        this.mService.waitUntilDisconnected();
        this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        BluetoothGattService service = bluetoothGatt.getService(BaseDfuImpl.GENERIC_ATTRIBUTE_SERVICE_UUID);
        this.mService.refreshDeviceCache(bluetoothGatt, !((service == null || service.getCharacteristic(BaseDfuImpl.SERVICE_CHANGED_UUID) == null) ? false : true));
        this.mService.close(bluetoothGatt);
        logi("Restarting the service");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, false);
    }

    private void setNumberOfPackets(byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0083  */
    /* JADX WARN: Code duplicated, block: B:29:0x0087  */
    /* JADX WARN: Code duplicated, block: B:31:0x008b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x008c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0096  */
    /* JADX WARN: Code duplicated, block: B:36:0x009e  */
    private void writeImageSize(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeInProgress = true;
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(new byte[4]);
        bluetoothGattCharacteristic.setValue(i, 20, 0);
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    try {
                        if (!this.mImageSizeInProgress || !this.mConnected || this.mError != 0 || this.mAborted) {
                            if (!this.mPaused) {
                                break;
                            }
                            loge("Sleeping interrupted", e);
                            if (!this.mAborted) {
                                throw new UploadAbortedException();
                            }
                            if (this.mConnected) {
                                throw new DeviceDisconnectedException("Unable to write Image Size: device disconnected");
                            }
                            if (this.mError == 0) {
                                throw new DfuException("Unable to write Image Size", this.mError);
                            }
                        }
                        this.mLock.wait();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mAborted) {
            throw new UploadAbortedException();
        }
        if (this.mConnected) {
            throw new DeviceDisconnectedException("Unable to write Image Size: device disconnected");
        }
        if (this.mError == 0) {
            throw new DfuException("Unable to write Image Size", this.mError);
        }
    }

    private void writeOpCode(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        byte b = bArr[0];
        writeOpCode(bluetoothGattCharacteristic, bArr, b == 6 || b == 5);
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    protected UUID getControlPointCharacteristicUUID() {
        return DFU_CONTROL_POINT_UUID;
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    protected UUID getDfuServiceUUID() {
        return DFU_SERVICE_UUID;
    }

    @Override // no.nordicsemi.android.dfu.BaseCustomDfuImpl
    protected UUID getPacketCharacteristicUUID() {
        return DFU_PACKET_UUID;
    }

    @Override // no.nordicsemi.android.dfu.DfuService
    public boolean isClientCompatible(Intent intent, BluetoothGatt bluetoothGatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = bluetoothGatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_PACKET_UUID);
        this.mPacketCharacteristic = characteristic2;
        return characteristic2 != null;
    }

    /* JADX WARN: Code duplicated, block: B:126:0x040b A[Catch: UnknownResponseException -> 0x01f4, UploadAbortedException -> 0x01fc, RemoteDfuException -> 0x03ff, TryCatch #1 {UploadAbortedException -> 0x01fc, blocks: (B:43:0x0134, B:45:0x0139, B:47:0x0142, B:51:0x01f0, B:76:0x0231, B:83:0x0241, B:85:0x026d, B:88:0x0328, B:124:0x0407, B:126:0x040b, B:128:0x0416, B:130:0x0486, B:133:0x04b5, B:134:0x04bc, B:129:0x0459, B:136:0x04bf, B:144:0x04cf, B:145:0x050d, B:146:0x052c, B:147:0x053f, B:149:0x059d, B:151:0x0651, B:155:0x0680, B:156:0x0685, B:157:0x068c, B:158:0x068d, B:159:0x0694, B:161:0x0696, B:162:0x069c, B:142:0x04cb, B:95:0x0339, B:97:0x033d, B:98:0x0340, B:111:0x0353, B:115:0x035d, B:117:0x03fb, B:163:0x069d, B:164:0x06a2, B:165:0x06a3, B:166:0x06a4, B:106:0x034c, B:108:0x034e, B:62:0x0212, B:64:0x0216, B:65:0x0219), top: B:182:0x0134 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x0416 A[Catch: UnknownResponseException -> 0x01f4, UploadAbortedException -> 0x01fc, RemoteDfuException -> 0x03ff, TryCatch #1 {UploadAbortedException -> 0x01fc, blocks: (B:43:0x0134, B:45:0x0139, B:47:0x0142, B:51:0x01f0, B:76:0x0231, B:83:0x0241, B:85:0x026d, B:88:0x0328, B:124:0x0407, B:126:0x040b, B:128:0x0416, B:130:0x0486, B:133:0x04b5, B:134:0x04bc, B:129:0x0459, B:136:0x04bf, B:144:0x04cf, B:145:0x050d, B:146:0x052c, B:147:0x053f, B:149:0x059d, B:151:0x0651, B:155:0x0680, B:156:0x0685, B:157:0x068c, B:158:0x068d, B:159:0x0694, B:161:0x0696, B:162:0x069c, B:142:0x04cb, B:95:0x0339, B:97:0x033d, B:98:0x0340, B:111:0x0353, B:115:0x035d, B:117:0x03fb, B:163:0x069d, B:164:0x06a2, B:165:0x06a3, B:166:0x06a4, B:106:0x034c, B:108:0x034e, B:62:0x0212, B:64:0x0216, B:65:0x0219), top: B:182:0x0134 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x0459 A[Catch: UnknownResponseException -> 0x01f4, UploadAbortedException -> 0x01fc, RemoteDfuException -> 0x03ff, TryCatch #1 {UploadAbortedException -> 0x01fc, blocks: (B:43:0x0134, B:45:0x0139, B:47:0x0142, B:51:0x01f0, B:76:0x0231, B:83:0x0241, B:85:0x026d, B:88:0x0328, B:124:0x0407, B:126:0x040b, B:128:0x0416, B:130:0x0486, B:133:0x04b5, B:134:0x04bc, B:129:0x0459, B:136:0x04bf, B:144:0x04cf, B:145:0x050d, B:146:0x052c, B:147:0x053f, B:149:0x059d, B:151:0x0651, B:155:0x0680, B:156:0x0685, B:157:0x068c, B:158:0x068d, B:159:0x0694, B:161:0x0696, B:162:0x069c, B:142:0x04cb, B:95:0x0339, B:97:0x033d, B:98:0x0340, B:111:0x0353, B:115:0x035d, B:117:0x03fb, B:163:0x069d, B:164:0x06a2, B:165:0x06a3, B:166:0x06a4, B:106:0x034c, B:108:0x034e, B:62:0x0212, B:64:0x0216, B:65:0x0219), top: B:182:0x0134 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:133:0x04b5 A[Catch: UnknownResponseException -> 0x01f4, UploadAbortedException -> 0x01fc, RemoteDfuException -> 0x03ff, TryCatch #1 {UploadAbortedException -> 0x01fc, blocks: (B:43:0x0134, B:45:0x0139, B:47:0x0142, B:51:0x01f0, B:76:0x0231, B:83:0x0241, B:85:0x026d, B:88:0x0328, B:124:0x0407, B:126:0x040b, B:128:0x0416, B:130:0x0486, B:133:0x04b5, B:134:0x04bc, B:129:0x0459, B:136:0x04bf, B:144:0x04cf, B:145:0x050d, B:146:0x052c, B:147:0x053f, B:149:0x059d, B:151:0x0651, B:155:0x0680, B:156:0x0685, B:157:0x068c, B:158:0x068d, B:159:0x0694, B:161:0x0696, B:162:0x069c, B:142:0x04cb, B:95:0x0339, B:97:0x033d, B:98:0x0340, B:111:0x0353, B:115:0x035d, B:117:0x03fb, B:163:0x069d, B:164:0x06a2, B:165:0x06a3, B:166:0x06a4, B:106:0x034c, B:108:0x034e, B:62:0x0212, B:64:0x0216, B:65:0x0219), top: B:182:0x0134 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x04bf A[Catch: UnknownResponseException -> 0x01f4, UploadAbortedException -> 0x01fc, RemoteDfuException -> 0x03ff, TryCatch #1 {UploadAbortedException -> 0x01fc, blocks: (B:43:0x0134, B:45:0x0139, B:47:0x0142, B:51:0x01f0, B:76:0x0231, B:83:0x0241, B:85:0x026d, B:88:0x0328, B:124:0x0407, B:126:0x040b, B:128:0x0416, B:130:0x0486, B:133:0x04b5, B:134:0x04bc, B:129:0x0459, B:136:0x04bf, B:144:0x04cf, B:145:0x050d, B:146:0x052c, B:147:0x053f, B:149:0x059d, B:151:0x0651, B:155:0x0680, B:156:0x0685, B:157:0x068c, B:158:0x068d, B:159:0x0694, B:161:0x0696, B:162:0x069c, B:142:0x04cb, B:95:0x0339, B:97:0x033d, B:98:0x0340, B:111:0x0353, B:115:0x035d, B:117:0x03fb, B:163:0x069d, B:164:0x06a2, B:165:0x06a3, B:166:0x06a4, B:106:0x034c, B:108:0x034e, B:62:0x0212, B:64:0x0216, B:65:0x0219), top: B:182:0x0134 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x04cb A[Catch: UnknownResponseException -> 0x01f4, UploadAbortedException -> 0x01fc, RemoteDfuException -> 0x03ff, TryCatch #1 {UploadAbortedException -> 0x01fc, blocks: (B:43:0x0134, B:45:0x0139, B:47:0x0142, B:51:0x01f0, B:76:0x0231, B:83:0x0241, B:85:0x026d, B:88:0x0328, B:124:0x0407, B:126:0x040b, B:128:0x0416, B:130:0x0486, B:133:0x04b5, B:134:0x04bc, B:129:0x0459, B:136:0x04bf, B:144:0x04cf, B:145:0x050d, B:146:0x052c, B:147:0x053f, B:149:0x059d, B:151:0x0651, B:155:0x0680, B:156:0x0685, B:157:0x068c, B:158:0x068d, B:159:0x0694, B:161:0x0696, B:162:0x069c, B:142:0x04cb, B:95:0x0339, B:97:0x033d, B:98:0x0340, B:111:0x0353, B:115:0x035d, B:117:0x03fb, B:163:0x069d, B:164:0x06a2, B:165:0x06a3, B:166:0x06a4, B:106:0x034c, B:108:0x034e, B:62:0x0212, B:64:0x0216, B:65:0x0219), top: B:182:0x0134 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x04cf A[Catch: UnknownResponseException -> 0x01f4, UploadAbortedException -> 0x01fc, RemoteDfuException -> 0x03ff, TryCatch #1 {UploadAbortedException -> 0x01fc, blocks: (B:43:0x0134, B:45:0x0139, B:47:0x0142, B:51:0x01f0, B:76:0x0231, B:83:0x0241, B:85:0x026d, B:88:0x0328, B:124:0x0407, B:126:0x040b, B:128:0x0416, B:130:0x0486, B:133:0x04b5, B:134:0x04bc, B:129:0x0459, B:136:0x04bf, B:144:0x04cf, B:145:0x050d, B:146:0x052c, B:147:0x053f, B:149:0x059d, B:151:0x0651, B:155:0x0680, B:156:0x0685, B:157:0x068c, B:158:0x068d, B:159:0x0694, B:161:0x0696, B:162:0x069c, B:142:0x04cb, B:95:0x0339, B:97:0x033d, B:98:0x0340, B:111:0x0353, B:115:0x035d, B:117:0x03fb, B:163:0x069d, B:164:0x06a2, B:165:0x06a3, B:166:0x06a4, B:106:0x034c, B:108:0x034e, B:62:0x0212, B:64:0x0216, B:65:0x0219), top: B:182:0x0134 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x059d A[Catch: UnknownResponseException -> 0x01f4, UploadAbortedException -> 0x01fc, RemoteDfuException -> 0x03ff, TryCatch #1 {UploadAbortedException -> 0x01fc, blocks: (B:43:0x0134, B:45:0x0139, B:47:0x0142, B:51:0x01f0, B:76:0x0231, B:83:0x0241, B:85:0x026d, B:88:0x0328, B:124:0x0407, B:126:0x040b, B:128:0x0416, B:130:0x0486, B:133:0x04b5, B:134:0x04bc, B:129:0x0459, B:136:0x04bf, B:144:0x04cf, B:145:0x050d, B:146:0x052c, B:147:0x053f, B:149:0x059d, B:151:0x0651, B:155:0x0680, B:156:0x0685, B:157:0x068c, B:158:0x068d, B:159:0x0694, B:161:0x0696, B:162:0x069c, B:142:0x04cb, B:95:0x0339, B:97:0x033d, B:98:0x0340, B:111:0x0353, B:115:0x035d, B:117:0x03fb, B:163:0x069d, B:164:0x06a2, B:165:0x06a3, B:166:0x06a4, B:106:0x034c, B:108:0x034e, B:62:0x0212, B:64:0x0216, B:65:0x0219), top: B:182:0x0134 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x0651 A[Catch: UnknownResponseException -> 0x01f4, UploadAbortedException -> 0x01fc, RemoteDfuException -> 0x03ff, TryCatch #1 {UploadAbortedException -> 0x01fc, blocks: (B:43:0x0134, B:45:0x0139, B:47:0x0142, B:51:0x01f0, B:76:0x0231, B:83:0x0241, B:85:0x026d, B:88:0x0328, B:124:0x0407, B:126:0x040b, B:128:0x0416, B:130:0x0486, B:133:0x04b5, B:134:0x04bc, B:129:0x0459, B:136:0x04bf, B:144:0x04cf, B:145:0x050d, B:146:0x052c, B:147:0x053f, B:149:0x059d, B:151:0x0651, B:155:0x0680, B:156:0x0685, B:157:0x068c, B:158:0x068d, B:159:0x0694, B:161:0x0696, B:162:0x069c, B:142:0x04cb, B:95:0x0339, B:97:0x033d, B:98:0x0340, B:111:0x0353, B:115:0x035d, B:117:0x03fb, B:163:0x069d, B:164:0x06a2, B:165:0x06a3, B:166:0x06a4, B:106:0x034c, B:108:0x034e, B:62:0x0212, B:64:0x0216, B:65:0x0219), top: B:182:0x0134 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x067d  */
    /* JADX WARN: Code duplicated, block: B:154:0x067f  */
    /* JADX WARN: Code duplicated, block: B:156:0x0685 A[Catch: UnknownResponseException -> 0x01f4, UploadAbortedException -> 0x01fc, RemoteDfuException -> 0x03ff, TryCatch #1 {UploadAbortedException -> 0x01fc, blocks: (B:43:0x0134, B:45:0x0139, B:47:0x0142, B:51:0x01f0, B:76:0x0231, B:83:0x0241, B:85:0x026d, B:88:0x0328, B:124:0x0407, B:126:0x040b, B:128:0x0416, B:130:0x0486, B:133:0x04b5, B:134:0x04bc, B:129:0x0459, B:136:0x04bf, B:144:0x04cf, B:145:0x050d, B:146:0x052c, B:147:0x053f, B:149:0x059d, B:151:0x0651, B:155:0x0680, B:156:0x0685, B:157:0x068c, B:158:0x068d, B:159:0x0694, B:161:0x0696, B:162:0x069c, B:142:0x04cb, B:95:0x0339, B:97:0x033d, B:98:0x0340, B:111:0x0353, B:115:0x035d, B:117:0x03fb, B:163:0x069d, B:164:0x06a2, B:165:0x06a3, B:166:0x06a4, B:106:0x034c, B:108:0x034e, B:62:0x0212, B:64:0x0216, B:65:0x0219), top: B:182:0x0134 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x068d A[Catch: UnknownResponseException -> 0x01f4, UploadAbortedException -> 0x01fc, RemoteDfuException -> 0x03ff, TryCatch #1 {UploadAbortedException -> 0x01fc, blocks: (B:43:0x0134, B:45:0x0139, B:47:0x0142, B:51:0x01f0, B:76:0x0231, B:83:0x0241, B:85:0x026d, B:88:0x0328, B:124:0x0407, B:126:0x040b, B:128:0x0416, B:130:0x0486, B:133:0x04b5, B:134:0x04bc, B:129:0x0459, B:136:0x04bf, B:144:0x04cf, B:145:0x050d, B:146:0x052c, B:147:0x053f, B:149:0x059d, B:151:0x0651, B:155:0x0680, B:156:0x0685, B:157:0x068c, B:158:0x068d, B:159:0x0694, B:161:0x0696, B:162:0x069c, B:142:0x04cb, B:95:0x0339, B:97:0x033d, B:98:0x0340, B:111:0x0353, B:115:0x035d, B:117:0x03fb, B:163:0x069d, B:164:0x06a2, B:165:0x06a3, B:166:0x06a4, B:106:0x034c, B:108:0x034e, B:62:0x0212, B:64:0x0216, B:65:0x0219), top: B:182:0x0134 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:128:0x0416, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:129:0x0459, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:144:0x04cf, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:149:0x059d, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v53 */
    @Override // no.nordicsemi.android.dfu.DfuService
    public void performDfu(Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        String str;
        String str2;
        UploadAbortedException uploadAbortedException;
        String str3;
        String str4;
        UnknownResponseException unknownResponseException;
        RemoteDfuException remoteDfuException;
        int i;
        int i2;
        int iApplicationImageSize;
        int iBootloaderImageSize;
        String str5;
        RemoteDfuException remoteDfuException2;
        boolean z;
        String str6;
        int i3;
        long jElapsedRealtime;
        long jElapsedRealtime2;
        int statusCode;
        int statusCode2;
        boolean z2;
        int i4;
        int statusCode3;
        String str7;
        ?? r5;
        RemoteDfuException remoteDfuException3;
        String str8;
        Intent intent2 = intent;
        String str9 = "Reset request sent";
        String str10 = "Sending Reset command (Op Code = 6)";
        logw("Legacy DFU bootloader found");
        this.mProgressInfo.setProgress(-2);
        if (intent2.hasExtra(DfuBaseService.EXTRA_MTU)) {
            int intExtra = intent2.getIntExtra(DfuBaseService.EXTRA_MTU, 517);
            logi("Requesting MTU = " + intExtra);
            requestMtu(intExtra);
        }
        BluetoothGatt bluetoothGatt = this.mGatt;
        int version = readVersion(bluetoothGatt.getService(DFU_SERVICE_UUID).getCharacteristic(DFU_VERSION_UUID));
        if (version >= 5 && this.mInitPacketStream == null) {
            logw("Init packet not set for the DFU Bootloader version " + version);
            this.mService.sendLogBroadcast(20, "The Init packet is required by this version DFU Bootloader");
            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_INIT_PACKET_REQUIRED);
            return;
        }
        try {
            try {
                try {
                    enableCCCD(this.mControlPointCharacteristic, 1);
                    this.mService.sendLogBroadcast(10, "Notifications enabled");
                    int i5 = this.mFileType;
                    if ((i5 & 1) > 0) {
                        try {
                            i = this.mImageSizeInBytes;
                        } catch (RemoteDfuException e) {
                            remoteDfuException = e;
                            str9 = "Reset request sent";
                            str10 = "Sending Reset command (Op Code = 6)";
                            int errorNumber = remoteDfuException.getErrorNumber();
                            int i6 = errorNumber | 256;
                            loge(remoteDfuException.getMessage() + ": " + pa1.a(i6));
                            this.mService.sendLogBroadcast(20, String.format(Locale.US, "Remote DFU error: %s", pa1.a(i6)));
                            logi(str10);
                            writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
                            this.mService.sendLogBroadcast(10, str9);
                            this.mService.terminateConnection(bluetoothGatt, errorNumber | 8448);
                            return;
                        } catch (UnknownResponseException e2) {
                            unknownResponseException = e2;
                            str3 = "Reset request sent";
                            str4 = "Sending Reset command (Op Code = 6)";
                            loge(unknownResponseException.getMessage());
                            this.mService.sendLogBroadcast(20, unknownResponseException.getMessage());
                            logi(str4);
                            writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
                            this.mService.sendLogBroadcast(10, str3);
                            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_INVALID_RESPONSE);
                            return;
                        } catch (UploadAbortedException e3) {
                            uploadAbortedException = e3;
                            str = "Reset request sent";
                            str2 = "Sending Reset command (Op Code = 6)";
                            logi(str2);
                            this.mAborted = false;
                            writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
                            this.mService.sendLogBroadcast(10, str);
                            throw uploadAbortedException;
                        }
                    } else {
                        i = 0;
                    }
                    int i7 = (i5 & 2) > 0 ? this.mImageSizeInBytes : 0;
                    int i8 = i5 & 4;
                    int i9 = i8 > 0 ? this.mImageSizeInBytes : 0;
                    InputStream inputStream = this.mFirmwareStream;
                    int i10 = i7;
                    if (inputStream instanceof ArchiveInputStream) {
                        ArchiveInputStream archiveInputStream = (ArchiveInputStream) inputStream;
                        if (archiveInputStream.isSecureDfuRequired()) {
                            loge("Secure DFU is required to upload selected firmware");
                            this.mService.sendLogBroadcast(20, "The device does not support given firmware.");
                            logi("Sending Reset command (Op Code = 6)");
                            writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
                            this.mService.sendLogBroadcast(10, "Reset request sent");
                            this.mService.terminateConnection(bluetoothGatt, 4099);
                            return;
                        }
                        int iSoftDeviceImageSize = archiveInputStream.softDeviceImageSize();
                        iBootloaderImageSize = archiveInputStream.bootloaderImageSize();
                        iApplicationImageSize = archiveInputStream.applicationImageSize();
                        i2 = iSoftDeviceImageSize;
                    } else {
                        i2 = i;
                        iApplicationImageSize = i9;
                        iBootloaderImageSize = i10;
                    }
                    try {
                        try {
                            try {
                                byte[] bArr = OP_CODE_START_DFU;
                                try {
                                    bArr[1] = (byte) i5;
                                    StringBuilder sb = new StringBuilder();
                                    try {
                                        try {
                                            try {
                                                sb.append("Sending Start DFU command (Op Code = 1, Upload Mode = ");
                                                sb.append(i5);
                                                sb.append(")");
                                                logi(sb.toString());
                                                writeOpCode(this.mControlPointCharacteristic, bArr);
                                                this.mService.sendLogBroadcast(10, "DFU Start sent (Op Code = 1, Upload Mode = " + i5 + ")");
                                                logi("Sending image size array to DFU Packet (" + i2 + "b, " + iBootloaderImageSize + "b, " + iApplicationImageSize + "b)");
                                                writeImageSize(this.mPacketCharacteristic, i2, iBootloaderImageSize, iApplicationImageSize);
                                                this.mService.sendLogBroadcast(10, "Firmware image size sent (" + i2 + "b, " + iBootloaderImageSize + "b, " + iApplicationImageSize + "b)");
                                                byte[] notificationResponse = readNotificationResponse();
                                                int statusCode4 = getStatusCode(notificationResponse, 1);
                                                this.mService.sendLogBroadcast(10, "Response received (Op Code = " + ((int) notificationResponse[1]) + " Status = " + statusCode4 + ")");
                                                if (statusCode4 != 2) {
                                                    intent2 = intent;
                                                    if (statusCode4 != 1) {
                                                        bluetoothGatt = bluetoothGatt;
                                                        str5 = "Starting DFU failed";
                                                        try {
                                                            throw new RemoteDfuException(str5, statusCode4);
                                                        } catch (RemoteDfuException e4) {
                                                            e = e4;
                                                        }
                                                    }
                                                    bluetoothGatt = bluetoothGatt;
                                                    str6 = ", Status = ";
                                                    z = true;
                                                    if (this.mInitPacketStream != null) {
                                                        this.mService.sendLogBroadcast(10, "Writing Initialize DFU Parameters...");
                                                        if (z) {
                                                            logi("Sending the Initialize DFU Parameters START (Op Code = 2, Value = 0)");
                                                            writeOpCode(this.mControlPointCharacteristic, OP_CODE_INIT_DFU_PARAMS_START);
                                                            logi("Sending " + this.mInitPacketSizeInBytes + " bytes of init packet");
                                                            writeInitData(this.mPacketCharacteristic, null);
                                                            logi("Sending the Initialize DFU Parameters COMPLETE (Op Code = 2, Value = 1)");
                                                            writeOpCode(this.mControlPointCharacteristic, OP_CODE_INIT_DFU_PARAMS_COMPLETE);
                                                            this.mService.sendLogBroadcast(10, "Initialize DFU Parameters completed");
                                                        } else {
                                                            logi("Sending the Initialize DFU Parameters (Op Code = 2)");
                                                            writeOpCode(this.mControlPointCharacteristic, OP_CODE_INIT_DFU_PARAMS);
                                                            logi("Sending " + this.mInitPacketSizeInBytes + " bytes of init packet");
                                                            writeInitData(this.mPacketCharacteristic, null);
                                                        }
                                                        byte[] notificationResponse2 = readNotificationResponse();
                                                        statusCode3 = getStatusCode(notificationResponse2, 2);
                                                        this.mService.sendLogBroadcast(10, "Response received (Op Code = " + ((int) notificationResponse2[1]) + str6 + statusCode3 + ")");
                                                        if (statusCode3 != 1) {
                                                            throw new RemoteDfuException("Device returned error after sending init packet", statusCode3);
                                                        }
                                                    }
                                                    if (!z || ((i4 = this.mPacketsBeforeNotification) > 0 && i4 <= 10)) {
                                                        i3 = this.mPacketsBeforeNotification;
                                                    } else {
                                                        i3 = 10;
                                                    }
                                                    if (i3 > 0) {
                                                        this.mPacketsBeforeNotification = i3;
                                                        logi("Sending the number of packets before notifications (Op Code = 8, Value = " + i3 + ")");
                                                        byte[] bArr2 = OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
                                                        setNumberOfPackets(bArr2, i3);
                                                        writeOpCode(this.mControlPointCharacteristic, bArr2);
                                                        this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 8) sent (Value = " + i3 + ")");
                                                    }
                                                    logi("Sending Receive Firmware Image request (Op Code = 3)");
                                                    writeOpCode(this.mControlPointCharacteristic, OP_CODE_RECEIVE_FIRMWARE_IMAGE);
                                                    this.mService.sendLogBroadcast(10, "Receive Firmware Image request sent");
                                                    jElapsedRealtime = SystemClock.elapsedRealtime();
                                                    this.mProgressInfo.setBytesSent(0);
                                                    try {
                                                        logi("Uploading firmware...");
                                                        this.mService.sendLogBroadcast(10, "Uploading firmware...");
                                                        uploadFirmwareImage(this.mPacketCharacteristic);
                                                        jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                                        byte[] notificationResponse3 = readNotificationResponse();
                                                        statusCode = getStatusCode(notificationResponse3, 3);
                                                        logi("Response received (Op Code = " + ((int) notificationResponse3[0]) + ", Req Op Code = " + ((int) notificationResponse3[1]) + str6 + ((int) notificationResponse3[2]) + ")");
                                                        DfuBaseService dfuBaseService = this.mService;
                                                        StringBuilder sb2 = new StringBuilder();
                                                        sb2.append("Response received (Op Code = ");
                                                        sb2.append((int) notificationResponse3[1]);
                                                        sb2.append(str6);
                                                        sb2.append(statusCode);
                                                        sb2.append(")");
                                                        dfuBaseService.sendLogBroadcast(10, sb2.toString());
                                                        if (statusCode != 1) {
                                                            throw new RemoteDfuException("Device returned error after sending file", statusCode);
                                                        }
                                                        StringBuilder sb3 = new StringBuilder();
                                                        sb3.append("Transfer of ");
                                                        sb3.append(this.mProgressInfo.getBytesSent());
                                                        sb3.append(" bytes has taken ");
                                                        long j = jElapsedRealtime2 - jElapsedRealtime;
                                                        sb3.append(j);
                                                        sb3.append(" ms");
                                                        logi(sb3.toString());
                                                        this.mService.sendLogBroadcast(10, "Upload completed in " + j + " ms");
                                                        logi("Sending Validate request (Op Code = 4)");
                                                        writeOpCode(this.mControlPointCharacteristic, OP_CODE_VALIDATE);
                                                        this.mService.sendLogBroadcast(10, "Validate request sent");
                                                        byte[] notificationResponse4 = readNotificationResponse();
                                                        statusCode2 = getStatusCode(notificationResponse4, 4);
                                                        logi("Response received (Op Code = " + ((int) notificationResponse4[0]) + ", Req Op Code = " + ((int) notificationResponse4[1]) + str6 + ((int) notificationResponse4[2]) + ")");
                                                        DfuBaseService dfuBaseService2 = this.mService;
                                                        StringBuilder sb4 = new StringBuilder();
                                                        sb4.append("Response received (Op Code = ");
                                                        sb4.append((int) notificationResponse4[1]);
                                                        sb4.append(str6);
                                                        sb4.append(statusCode2);
                                                        sb4.append(")");
                                                        dfuBaseService2.sendLogBroadcast(10, sb4.toString());
                                                        if (statusCode2 != 1) {
                                                            throw new RemoteDfuException("Device returned validation error", statusCode2);
                                                        }
                                                        this.mProgressInfo.setProgress(-5);
                                                        logi("Sending Activate and Reset request (Op Code = 5)");
                                                        writeOpCode(this.mControlPointCharacteristic, OP_CODE_ACTIVATE_AND_RESET);
                                                        this.mService.sendLogBroadcast(10, "Activate and Reset request sent");
                                                        this.mService.waitUntilDisconnected();
                                                        this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
                                                        if (version == 5) {
                                                            z2 = true;
                                                        } else {
                                                            z2 = false;
                                                        }
                                                        finalize(intent2, z2);
                                                        return;
                                                    } catch (DeviceDisconnectedException e5) {
                                                        loge("Disconnected while sending data");
                                                        throw e5;
                                                    }
                                                }
                                                intent2 = intent;
                                                bluetoothGatt = bluetoothGatt;
                                                try {
                                                    resetAndRestart(bluetoothGatt, intent2);
                                                    return;
                                                } catch (RemoteDfuException e6) {
                                                    remoteDfuException2 = e6;
                                                    str5 = "Starting DFU failed";
                                                }
                                            } catch (RemoteDfuException e7) {
                                                e = e7;
                                                intent2 = intent;
                                                str5 = "Starting DFU failed";
                                                bluetoothGatt = bluetoothGatt;
                                            } catch (UnknownResponseException e8) {
                                                e = e8;
                                                bluetoothGatt = bluetoothGatt;
                                                unknownResponseException = e;
                                                str3 = str9;
                                                str4 = str10;
                                                loge(unknownResponseException.getMessage());
                                                this.mService.sendLogBroadcast(20, unknownResponseException.getMessage());
                                                logi(str4);
                                                writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
                                                this.mService.sendLogBroadcast(10, str3);
                                                this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_INVALID_RESPONSE);
                                                return;
                                            }
                                            if (remoteDfuException2.getErrorNumber() != 3) {
                                                throw remoteDfuException2;
                                            }
                                            if (i8 <= 0 || (i5 & 3) <= 0) {
                                                throw remoteDfuException2;
                                            }
                                            try {
                                                try {
                                                    this.mRemoteErrorOccurred = false;
                                                    logw("DFU target does not support (SD/BL)+App update");
                                                    this.mService.sendLogBroadcast(15, "DFU target does not support (SD/BL)+App update");
                                                    i5 &= -5;
                                                    this.mFileType = i5;
                                                    byte[] bArr3 = OP_CODE_START_DFU;
                                                    bArr3[1] = (byte) i5;
                                                    this.mProgressInfo.setTotalPart(2);
                                                    ((ArchiveInputStream) this.mFirmwareStream).setContentType(i5);
                                                    String str11 = str5;
                                                    try {
                                                        this.mService.sendLogBroadcast(1, "Sending only SD/BL");
                                                        logi("Resending Start DFU command (Op Code = 1, Upload Mode = " + i5 + ")");
                                                        writeOpCode(this.mControlPointCharacteristic, bArr3);
                                                        this.mService.sendLogBroadcast(10, "DFU Start sent (Op Code = 1, Upload Mode = " + i5 + ")");
                                                        logi("Sending image size array to DFU Packet: [" + i2 + "b, " + iBootloaderImageSize + "b, 0b]");
                                                        writeImageSize(this.mPacketCharacteristic, i2, iBootloaderImageSize, 0);
                                                        this.mService.sendLogBroadcast(10, "Firmware image size sent [" + i2 + "b, " + iBootloaderImageSize + "b, 0b]");
                                                        byte[] notificationResponse5 = readNotificationResponse();
                                                        int statusCode5 = getStatusCode(notificationResponse5, 1);
                                                        this.mService.sendLogBroadcast(10, "Response received (Op Code = " + ((int) notificationResponse5[1]) + " Status = " + statusCode5 + ")");
                                                        if (statusCode5 != 2) {
                                                            if (statusCode5 != 1) {
                                                                throw new RemoteDfuException(str11, statusCode5);
                                                            }
                                                            bluetoothGatt = bluetoothGatt;
                                                            str6 = ", Status = ";
                                                            z = true;
                                                            if (this.mInitPacketStream != null) {
                                                                this.mService.sendLogBroadcast(10, "Writing Initialize DFU Parameters...");
                                                                if (z) {
                                                                    logi("Sending the Initialize DFU Parameters START (Op Code = 2, Value = 0)");
                                                                    writeOpCode(this.mControlPointCharacteristic, OP_CODE_INIT_DFU_PARAMS_START);
                                                                    logi("Sending " + this.mInitPacketSizeInBytes + " bytes of init packet");
                                                                    writeInitData(this.mPacketCharacteristic, null);
                                                                    logi("Sending the Initialize DFU Parameters COMPLETE (Op Code = 2, Value = 1)");
                                                                    writeOpCode(this.mControlPointCharacteristic, OP_CODE_INIT_DFU_PARAMS_COMPLETE);
                                                                    this.mService.sendLogBroadcast(10, "Initialize DFU Parameters completed");
                                                                } else {
                                                                    logi("Sending the Initialize DFU Parameters (Op Code = 2)");
                                                                    writeOpCode(this.mControlPointCharacteristic, OP_CODE_INIT_DFU_PARAMS);
                                                                    logi("Sending " + this.mInitPacketSizeInBytes + " bytes of init packet");
                                                                    writeInitData(this.mPacketCharacteristic, null);
                                                                }
                                                                byte[] notificationResponse6 = readNotificationResponse();
                                                                statusCode3 = getStatusCode(notificationResponse6, 2);
                                                                this.mService.sendLogBroadcast(10, "Response received (Op Code = " + ((int) notificationResponse6[1]) + str6 + statusCode3 + ")");
                                                                if (statusCode3 != 1) {
                                                                    throw new RemoteDfuException("Device returned error after sending init packet", statusCode3);
                                                                }
                                                            }
                                                            if (z) {
                                                                i3 = this.mPacketsBeforeNotification;
                                                            } else {
                                                                i3 = this.mPacketsBeforeNotification;
                                                            }
                                                            if (i3 > 0) {
                                                                this.mPacketsBeforeNotification = i3;
                                                                logi("Sending the number of packets before notifications (Op Code = 8, Value = " + i3 + ")");
                                                                byte[] bArr4 = OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
                                                                setNumberOfPackets(bArr4, i3);
                                                                writeOpCode(this.mControlPointCharacteristic, bArr4);
                                                                this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 8) sent (Value = " + i3 + ")");
                                                            }
                                                            logi("Sending Receive Firmware Image request (Op Code = 3)");
                                                            writeOpCode(this.mControlPointCharacteristic, OP_CODE_RECEIVE_FIRMWARE_IMAGE);
                                                            this.mService.sendLogBroadcast(10, "Receive Firmware Image request sent");
                                                            jElapsedRealtime = SystemClock.elapsedRealtime();
                                                            this.mProgressInfo.setBytesSent(0);
                                                            logi("Uploading firmware...");
                                                            this.mService.sendLogBroadcast(10, "Uploading firmware...");
                                                            uploadFirmwareImage(this.mPacketCharacteristic);
                                                            jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                                            byte[] notificationResponse7 = readNotificationResponse();
                                                            statusCode = getStatusCode(notificationResponse7, 3);
                                                            logi("Response received (Op Code = " + ((int) notificationResponse7[0]) + ", Req Op Code = " + ((int) notificationResponse7[1]) + str6 + ((int) notificationResponse7[2]) + ")");
                                                            DfuBaseService dfuBaseService3 = this.mService;
                                                            StringBuilder sb5 = new StringBuilder();
                                                            sb5.append("Response received (Op Code = ");
                                                            sb5.append((int) notificationResponse7[1]);
                                                            sb5.append(str6);
                                                            sb5.append(statusCode);
                                                            sb5.append(")");
                                                            dfuBaseService3.sendLogBroadcast(10, sb5.toString());
                                                            if (statusCode != 1) {
                                                                throw new RemoteDfuException("Device returned error after sending file", statusCode);
                                                            }
                                                            StringBuilder sb6 = new StringBuilder();
                                                            sb6.append("Transfer of ");
                                                            sb6.append(this.mProgressInfo.getBytesSent());
                                                            sb6.append(" bytes has taken ");
                                                            long j2 = jElapsedRealtime2 - jElapsedRealtime;
                                                            sb6.append(j2);
                                                            sb6.append(" ms");
                                                            logi(sb6.toString());
                                                            this.mService.sendLogBroadcast(10, "Upload completed in " + j2 + " ms");
                                                            logi("Sending Validate request (Op Code = 4)");
                                                            writeOpCode(this.mControlPointCharacteristic, OP_CODE_VALIDATE);
                                                            this.mService.sendLogBroadcast(10, "Validate request sent");
                                                            byte[] notificationResponse8 = readNotificationResponse();
                                                            statusCode2 = getStatusCode(notificationResponse8, 4);
                                                            logi("Response received (Op Code = " + ((int) notificationResponse8[0]) + ", Req Op Code = " + ((int) notificationResponse8[1]) + str6 + ((int) notificationResponse8[2]) + ")");
                                                            DfuBaseService dfuBaseService4 = this.mService;
                                                            StringBuilder sb7 = new StringBuilder();
                                                            sb7.append("Response received (Op Code = ");
                                                            sb7.append((int) notificationResponse8[1]);
                                                            sb7.append(str6);
                                                            sb7.append(statusCode2);
                                                            sb7.append(")");
                                                            dfuBaseService4.sendLogBroadcast(10, sb7.toString());
                                                            if (statusCode2 != 1) {
                                                                throw new RemoteDfuException("Device returned validation error", statusCode2);
                                                            }
                                                            this.mProgressInfo.setProgress(-5);
                                                            logi("Sending Activate and Reset request (Op Code = 5)");
                                                            writeOpCode(this.mControlPointCharacteristic, OP_CODE_ACTIVATE_AND_RESET);
                                                            this.mService.sendLogBroadcast(10, "Activate and Reset request sent");
                                                            this.mService.waitUntilDisconnected();
                                                            this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
                                                            if (version == 5) {
                                                                z2 = true;
                                                            } else {
                                                                z2 = false;
                                                            }
                                                            finalize(intent2, z2);
                                                            return;
                                                        }
                                                        try {
                                                            resetAndRestart(bluetoothGatt, intent2);
                                                            return;
                                                        } catch (RemoteDfuException e9) {
                                                            remoteDfuException3 = e9;
                                                            str8 = str11;
                                                        }
                                                    } catch (RemoteDfuException e10) {
                                                        e = e10;
                                                        r5 = str11;
                                                        remoteDfuException3 = e;
                                                        str8 = r5;
                                                    }
                                                } catch (RemoteDfuException e11) {
                                                    e = e11;
                                                    r5 = str5;
                                                    remoteDfuException3 = e;
                                                    str8 = r5;
                                                    if (remoteDfuException3.getErrorNumber() != 3) {
                                                        throw remoteDfuException3;
                                                    }
                                                    throw remoteDfuException3;
                                                }
                                                if (remoteDfuException3.getErrorNumber() != 3 || i5 != 4) {
                                                    throw remoteDfuException3;
                                                }
                                                this.mRemoteErrorOccurred = false;
                                                logw("DFU target does not support DFU v.2");
                                                this.mService.sendLogBroadcast(15, "DFU target does not support DFU v.2");
                                                this.mService.sendLogBroadcast(1, "Switching to DFU v.1");
                                                logi("Resending Start DFU command (Op Code = 1)");
                                                writeOpCode(this.mControlPointCharacteristic, OP_CODE_START_DFU_V1);
                                                this.mService.sendLogBroadcast(10, "DFU Start sent (Op Code = 1)");
                                                logi("Sending application image size to DFU Packet: " + this.mImageSizeInBytes + " bytes");
                                                writeImageSize(this.mPacketCharacteristic, this.mImageSizeInBytes);
                                                this.mService.sendLogBroadcast(10, str7 + this.mImageSizeInBytes + " bytes)");
                                                byte[] notificationResponse9 = readNotificationResponse();
                                                int statusCode6 = getStatusCode(notificationResponse9, 1);
                                                DfuBaseService dfuBaseService5 = this.mService;
                                                StringBuilder sb8 = new StringBuilder();
                                                sb8.append("Response received (Op Code = ");
                                                sb8.append((int) notificationResponse9[1]);
                                                str6 = ", Status = ";
                                                sb8.append(str6);
                                                sb8.append(statusCode6);
                                                sb8.append(")");
                                                dfuBaseService5.sendLogBroadcast(10, sb8.toString());
                                                if (statusCode6 == 2) {
                                                    resetAndRestart(bluetoothGatt, intent2);
                                                    return;
                                                }
                                                if (statusCode6 != 1) {
                                                    throw new RemoteDfuException(str8, statusCode6);
                                                }
                                                z = false;
                                                if (this.mInitPacketStream != null) {
                                                    this.mService.sendLogBroadcast(10, "Writing Initialize DFU Parameters...");
                                                    if (z) {
                                                        logi("Sending the Initialize DFU Parameters START (Op Code = 2, Value = 0)");
                                                        writeOpCode(this.mControlPointCharacteristic, OP_CODE_INIT_DFU_PARAMS_START);
                                                        logi("Sending " + this.mInitPacketSizeInBytes + " bytes of init packet");
                                                        writeInitData(this.mPacketCharacteristic, null);
                                                        logi("Sending the Initialize DFU Parameters COMPLETE (Op Code = 2, Value = 1)");
                                                        writeOpCode(this.mControlPointCharacteristic, OP_CODE_INIT_DFU_PARAMS_COMPLETE);
                                                        this.mService.sendLogBroadcast(10, "Initialize DFU Parameters completed");
                                                    } else {
                                                        logi("Sending the Initialize DFU Parameters (Op Code = 2)");
                                                        writeOpCode(this.mControlPointCharacteristic, OP_CODE_INIT_DFU_PARAMS);
                                                        logi("Sending " + this.mInitPacketSizeInBytes + " bytes of init packet");
                                                        writeInitData(this.mPacketCharacteristic, null);
                                                    }
                                                    byte[] notificationResponse10 = readNotificationResponse();
                                                    statusCode3 = getStatusCode(notificationResponse10, 2);
                                                    this.mService.sendLogBroadcast(10, "Response received (Op Code = " + ((int) notificationResponse10[1]) + str6 + statusCode3 + ")");
                                                    if (statusCode3 != 1) {
                                                        throw new RemoteDfuException("Device returned error after sending init packet", statusCode3);
                                                    }
                                                }
                                                if (z) {
                                                    i3 = this.mPacketsBeforeNotification;
                                                } else {
                                                    i3 = this.mPacketsBeforeNotification;
                                                }
                                                if (i3 > 0) {
                                                    this.mPacketsBeforeNotification = i3;
                                                    logi("Sending the number of packets before notifications (Op Code = 8, Value = " + i3 + ")");
                                                    byte[] bArr5 = OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
                                                    setNumberOfPackets(bArr5, i3);
                                                    writeOpCode(this.mControlPointCharacteristic, bArr5);
                                                    this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 8) sent (Value = " + i3 + ")");
                                                }
                                                logi("Sending Receive Firmware Image request (Op Code = 3)");
                                                writeOpCode(this.mControlPointCharacteristic, OP_CODE_RECEIVE_FIRMWARE_IMAGE);
                                                this.mService.sendLogBroadcast(10, "Receive Firmware Image request sent");
                                                jElapsedRealtime = SystemClock.elapsedRealtime();
                                                this.mProgressInfo.setBytesSent(0);
                                                logi("Uploading firmware...");
                                                this.mService.sendLogBroadcast(10, "Uploading firmware...");
                                                uploadFirmwareImage(this.mPacketCharacteristic);
                                                jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                                byte[] notificationResponse11 = readNotificationResponse();
                                                statusCode = getStatusCode(notificationResponse11, 3);
                                                logi("Response received (Op Code = " + ((int) notificationResponse11[0]) + ", Req Op Code = " + ((int) notificationResponse11[1]) + str6 + ((int) notificationResponse11[2]) + ")");
                                                DfuBaseService dfuBaseService6 = this.mService;
                                                StringBuilder sb9 = new StringBuilder();
                                                sb9.append("Response received (Op Code = ");
                                                sb9.append((int) notificationResponse11[1]);
                                                sb9.append(str6);
                                                sb9.append(statusCode);
                                                sb9.append(")");
                                                dfuBaseService6.sendLogBroadcast(10, sb9.toString());
                                                if (statusCode != 1) {
                                                    throw new RemoteDfuException("Device returned error after sending file", statusCode);
                                                }
                                                StringBuilder sb10 = new StringBuilder();
                                                sb10.append("Transfer of ");
                                                sb10.append(this.mProgressInfo.getBytesSent());
                                                sb10.append(" bytes has taken ");
                                                long j3 = jElapsedRealtime2 - jElapsedRealtime;
                                                sb10.append(j3);
                                                sb10.append(" ms");
                                                logi(sb10.toString());
                                                this.mService.sendLogBroadcast(10, "Upload completed in " + j3 + " ms");
                                                logi("Sending Validate request (Op Code = 4)");
                                                writeOpCode(this.mControlPointCharacteristic, OP_CODE_VALIDATE);
                                                this.mService.sendLogBroadcast(10, "Validate request sent");
                                                byte[] notificationResponse12 = readNotificationResponse();
                                                statusCode2 = getStatusCode(notificationResponse12, 4);
                                                logi("Response received (Op Code = " + ((int) notificationResponse12[0]) + ", Req Op Code = " + ((int) notificationResponse12[1]) + str6 + ((int) notificationResponse12[2]) + ")");
                                                DfuBaseService dfuBaseService7 = this.mService;
                                                StringBuilder sb11 = new StringBuilder();
                                                sb11.append("Response received (Op Code = ");
                                                sb11.append((int) notificationResponse12[1]);
                                                sb11.append(str6);
                                                sb11.append(statusCode2);
                                                sb11.append(")");
                                                dfuBaseService7.sendLogBroadcast(10, sb11.toString());
                                                if (statusCode2 != 1) {
                                                    throw new RemoteDfuException("Device returned validation error", statusCode2);
                                                }
                                                this.mProgressInfo.setProgress(-5);
                                                logi("Sending Activate and Reset request (Op Code = 5)");
                                                writeOpCode(this.mControlPointCharacteristic, OP_CODE_ACTIVATE_AND_RESET);
                                                this.mService.sendLogBroadcast(10, "Activate and Reset request sent");
                                                this.mService.waitUntilDisconnected();
                                                this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
                                                if (version == 5) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                finalize(intent2, z2);
                                                return;
                                            } catch (RemoteDfuException e12) {
                                                e = e12;
                                                remoteDfuException = e;
                                                int errorNumber2 = remoteDfuException.getErrorNumber();
                                                int i11 = errorNumber2 | 256;
                                                loge(remoteDfuException.getMessage() + ": " + pa1.a(i11));
                                                this.mService.sendLogBroadcast(20, String.format(Locale.US, "Remote DFU error: %s", pa1.a(i11)));
                                                logi(str10);
                                                writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
                                                this.mService.sendLogBroadcast(10, str9);
                                                this.mService.terminateConnection(bluetoothGatt, errorNumber2 | 8448);
                                                return;
                                            }
                                        } catch (RemoteDfuException e13) {
                                            e = e13;
                                        }
                                        str7 = "Firmware image size sent (";
                                        r5 = 3;
                                    } catch (RemoteDfuException e14) {
                                        e = e14;
                                        str7 = "Firmware image size sent (";
                                    }
                                } catch (RemoteDfuException e15) {
                                    e = e15;
                                    intent2 = intent;
                                    str5 = "Starting DFU failed";
                                }
                            } catch (UploadAbortedException e16) {
                                e = e16;
                                uploadAbortedException = e;
                                str = str9;
                                str2 = str10;
                                logi(str2);
                                this.mAborted = false;
                                writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
                                this.mService.sendLogBroadcast(10, str);
                                throw uploadAbortedException;
                            }
                        } catch (RemoteDfuException e17) {
                            e = e17;
                        }
                    } catch (UnknownResponseException e18) {
                        e = e18;
                    }
                    str5 = "Starting DFU failed";
                    remoteDfuException2 = e;
                } catch (UnknownResponseException e19) {
                    e = e19;
                    str9 = "Reset request sent";
                    str10 = "Sending Reset command (Op Code = 6)";
                } catch (UploadAbortedException e20) {
                    e = e20;
                    str9 = "Reset request sent";
                    str10 = "Sending Reset command (Op Code = 6)";
                }
            } catch (RemoteDfuException e21) {
                e = e21;
                str9 = "Reset request sent";
                str10 = "Sending Reset command (Op Code = 6)";
            }
        } catch (UnknownResponseException e22) {
            str3 = "Reset request sent";
            str4 = "Sending Reset command (Op Code = 6)";
            unknownResponseException = e22;
        } catch (UploadAbortedException e23) {
            str = "Reset request sent";
            str2 = "Sending Reset command (Op Code = 6)";
            uploadAbortedException = e23;
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public BaseCustomDfuImpl.BaseCustomBluetoothCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x008d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0091  */
    /* JADX WARN: Code duplicated, block: B:31:0x0095 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x0096  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a8  */
    private void writeImageSize(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i, int i2, int i3) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        this.mReceivedData = null;
        this.mError = 0;
        this.mImageSizeInProgress = true;
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(new byte[12]);
        bluetoothGattCharacteristic.setValue(i, 20, 0);
        bluetoothGattCharacteristic.setValue(i2, 20, 4);
        bluetoothGattCharacteristic.setValue(i3, 20, 8);
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    try {
                        if (!this.mImageSizeInProgress || !this.mConnected || this.mError != 0 || this.mAborted) {
                            if (!this.mPaused) {
                                break;
                            }
                            loge("Sleeping interrupted", e);
                            if (!this.mAborted) {
                                if (this.mConnected) {
                                    if (this.mError == 0) {
                                        throw new DfuException("Unable to write Image Sizes", this.mError);
                                    }
                                    return;
                                }
                                throw new DeviceDisconnectedException("Unable to write Image Sizes: device disconnected");
                            }
                            throw new UploadAbortedException();
                        }
                        this.mLock.wait();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        if (!this.mAborted) {
            if (this.mConnected) {
                if (this.mError == 0) {
                    throw new DfuException("Unable to write Image Sizes", this.mError);
                }
                return;
            }
            throw new DeviceDisconnectedException("Unable to write Image Sizes: device disconnected");
        }
        throw new UploadAbortedException();
    }
}
