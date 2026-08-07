package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.IOException;
import java.util.UUID;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.HexFileValidationException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"MissingPermission"})
abstract class BaseCustomDfuImpl extends BaseDfuImpl {
    boolean mFirmwareUploadInProgress;
    private boolean mInitPacketInProgress;
    int mPacketsBeforeNotification;
    private int mPacketsSentSinceNotification;
    boolean mRemoteErrorOccurred;

    class BaseCustomBluetoothCallback extends BaseDfuImpl.BaseBluetoothGattCallback {
        BaseCustomBluetoothCallback() {
            super();
        }

        void handleNotification(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Notification received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
            BaseCustomDfuImpl.this.mReceivedData = bluetoothGattCharacteristic.getValue();
            BaseCustomDfuImpl.this.mFirmwareUploadInProgress = false;
        }

        void handlePacketReceiptNotification(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            BaseCustomDfuImpl baseCustomDfuImpl = BaseCustomDfuImpl.this;
            if (!baseCustomDfuImpl.mFirmwareUploadInProgress) {
                handleNotification(bluetoothGatt, bluetoothGattCharacteristic);
                return;
            }
            BluetoothGattCharacteristic characteristic = bluetoothGatt.getService(baseCustomDfuImpl.getDfuServiceUUID()).getCharacteristic(BaseCustomDfuImpl.this.getPacketCharacteristicUUID());
            try {
                BaseCustomDfuImpl.this.mPacketsSentSinceNotification = 0;
                BaseCustomDfuImpl.this.waitIfPaused();
                BaseCustomDfuImpl baseCustomDfuImpl2 = BaseCustomDfuImpl.this;
                if (!baseCustomDfuImpl2.mAborted && baseCustomDfuImpl2.mError == 0 && !baseCustomDfuImpl2.mRemoteErrorOccurred && !baseCustomDfuImpl2.mResetRequestSent) {
                    boolean zIsComplete = baseCustomDfuImpl2.mProgressInfo.isComplete();
                    boolean zIsObjectComplete = BaseCustomDfuImpl.this.mProgressInfo.isObjectComplete();
                    if (!zIsComplete && !zIsObjectComplete) {
                        int availableObjectSizeIsBytes = BaseCustomDfuImpl.this.mProgressInfo.getAvailableObjectSizeIsBytes();
                        BaseCustomDfuImpl baseCustomDfuImpl3 = BaseCustomDfuImpl.this;
                        byte[] bArr = baseCustomDfuImpl3.mBuffer;
                        if (availableObjectSizeIsBytes < bArr.length) {
                            bArr = new byte[availableObjectSizeIsBytes];
                        }
                        BaseCustomDfuImpl.this.writePacket(bluetoothGatt, characteristic, bArr, baseCustomDfuImpl3.mFirmwareStream.read(bArr));
                        return;
                    }
                    BaseCustomDfuImpl baseCustomDfuImpl4 = BaseCustomDfuImpl.this;
                    baseCustomDfuImpl4.mFirmwareUploadInProgress = false;
                    baseCustomDfuImpl4.notifyLock();
                    return;
                }
                baseCustomDfuImpl2.mFirmwareUploadInProgress = false;
                baseCustomDfuImpl2.mService.sendLogBroadcast(15, "Upload terminated");
            } catch (HexFileValidationException unused) {
                BaseCustomDfuImpl.this.loge("Invalid HEX file");
                BaseCustomDfuImpl.this.mError = 4099;
            } catch (IOException e) {
                BaseCustomDfuImpl.this.loge("Error while reading the input stream", e);
                BaseCustomDfuImpl.this.mError = 4100;
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i != 0) {
                BaseCustomDfuImpl baseCustomDfuImpl = BaseCustomDfuImpl.this;
                if (baseCustomDfuImpl.mResetRequestSent) {
                    baseCustomDfuImpl.mRequestCompleted = true;
                } else {
                    baseCustomDfuImpl.loge("Characteristic write error: " + i);
                    BaseCustomDfuImpl.this.mError = i | 16384;
                }
            } else if (!bluetoothGattCharacteristic.getUuid().equals(BaseCustomDfuImpl.this.getPacketCharacteristicUUID())) {
                BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
                BaseCustomDfuImpl.this.mRequestCompleted = true;
            } else if (BaseCustomDfuImpl.this.mInitPacketInProgress) {
                BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bluetoothGattCharacteristic));
                BaseCustomDfuImpl.this.mInitPacketInProgress = false;
            } else {
                BaseCustomDfuImpl baseCustomDfuImpl2 = BaseCustomDfuImpl.this;
                if (baseCustomDfuImpl2.mFirmwareUploadInProgress) {
                    baseCustomDfuImpl2.mProgressInfo.addBytesSent(bluetoothGattCharacteristic.getValue().length);
                    BaseCustomDfuImpl.access$108(BaseCustomDfuImpl.this);
                    BaseCustomDfuImpl baseCustomDfuImpl3 = BaseCustomDfuImpl.this;
                    boolean z = baseCustomDfuImpl3.mPacketsBeforeNotification > 0 && baseCustomDfuImpl3.mPacketsSentSinceNotification >= BaseCustomDfuImpl.this.mPacketsBeforeNotification;
                    boolean zIsComplete = BaseCustomDfuImpl.this.mProgressInfo.isComplete();
                    boolean zIsObjectComplete = BaseCustomDfuImpl.this.mProgressInfo.isObjectComplete();
                    if (z) {
                        return;
                    }
                    if (zIsComplete || zIsObjectComplete) {
                        BaseCustomDfuImpl baseCustomDfuImpl4 = BaseCustomDfuImpl.this;
                        baseCustomDfuImpl4.mFirmwareUploadInProgress = false;
                        baseCustomDfuImpl4.notifyLock();
                        return;
                    }
                    try {
                        BaseCustomDfuImpl.this.waitIfPaused();
                        BaseCustomDfuImpl baseCustomDfuImpl5 = BaseCustomDfuImpl.this;
                        if (!baseCustomDfuImpl5.mAborted && baseCustomDfuImpl5.mError == 0 && !baseCustomDfuImpl5.mRemoteErrorOccurred && !baseCustomDfuImpl5.mResetRequestSent) {
                            int availableObjectSizeIsBytes = baseCustomDfuImpl5.mProgressInfo.getAvailableObjectSizeIsBytes();
                            BaseCustomDfuImpl baseCustomDfuImpl6 = BaseCustomDfuImpl.this;
                            byte[] bArr = baseCustomDfuImpl6.mBuffer;
                            if (availableObjectSizeIsBytes < bArr.length) {
                                bArr = new byte[availableObjectSizeIsBytes];
                            }
                            BaseCustomDfuImpl.this.writePacket(bluetoothGatt, bluetoothGattCharacteristic, bArr, baseCustomDfuImpl6.mFirmwareStream.read(bArr));
                            return;
                        }
                        baseCustomDfuImpl5.mFirmwareUploadInProgress = false;
                        baseCustomDfuImpl5.mService.sendLogBroadcast(15, "Upload terminated");
                        BaseCustomDfuImpl.this.notifyLock();
                        return;
                    } catch (HexFileValidationException unused) {
                        BaseCustomDfuImpl.this.loge("Invalid HEX file");
                        BaseCustomDfuImpl.this.mError = 4099;
                    } catch (IOException e) {
                        BaseCustomDfuImpl.this.loge("Error while reading the input stream", e);
                        BaseCustomDfuImpl.this.mError = 4100;
                    }
                } else {
                    onPacketCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
                }
            }
            BaseCustomDfuImpl.this.notifyLock();
        }

        protected void onPacketCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        }
    }

    BaseCustomDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        int i = 12;
        if (intent.hasExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED)) {
            boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED, false);
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_VALUE, 12);
            if (intExtra >= 0 && intExtra <= 65535) {
                i = intExtra;
            }
            this.mPacketsBeforeNotification = booleanExtra ? i : 0;
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(dfuBaseService);
        boolean z = defaultSharedPreferences.getBoolean(DfuSettingsConstants.SETTINGS_PACKET_RECEIPT_NOTIFICATION_ENABLED, false);
        try {
            int i2 = Integer.parseInt(defaultSharedPreferences.getString(DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS, String.valueOf(12)));
            if (i2 >= 0 && i2 <= 65535) {
                i = i2;
            }
        } catch (NumberFormatException unused) {
        }
        this.mPacketsBeforeNotification = z ? i : 0;
    }

    static /* synthetic */ int access$108(BaseCustomDfuImpl baseCustomDfuImpl) {
        int i = baseCustomDfuImpl.mPacketsSentSinceNotification;
        baseCustomDfuImpl.mPacketsSentSinceNotification = i + 1;
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b0  */
    private void writeInitPacket(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        if (bArr.length != i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            bArr = bArr2;
        }
        this.mReceivedData = null;
        this.mError = 0;
        this.mInitPacketInProgress = true;
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(bArr);
        logi("Sending init packet (Value = " + parse(bArr) + ")");
        this.mService.sendLogBroadcast(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        this.mService.sendLogBroadcast(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        this.mGatt.writeCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.mLock) {
                while (true) {
                    try {
                        if (!this.mInitPacketInProgress || !this.mConnected || this.mError != 0) {
                            if (!this.mPaused) {
                                break;
                            }
                            loge("Sleeping interrupted", e);
                            if (this.mConnected) {
                                throw new DeviceDisconnectedException("Unable to write Init DFU Parameters: device disconnected");
                            }
                            if (this.mError == 0) {
                                throw new DfuException("Unable to write Init DFU Parameters", this.mError);
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
        if (this.mConnected) {
            throw new DeviceDisconnectedException("Unable to write Init DFU Parameters: device disconnected");
        }
        if (this.mError == 0) {
            throw new DfuException("Unable to write Init DFU Parameters", this.mError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writePacket(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        if (i <= 0) {
            return;
        }
        if (bArr.length != i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            bArr = bArr2;
        }
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(bArr);
        bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    void finalize(Intent intent, boolean z) {
        boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_KEEP_BOND, false);
        this.mService.refreshDeviceCache(this.mGatt, z || !booleanExtra);
        this.mService.close(this.mGatt);
        if (this.mGatt.getDevice().getBondState() == 12) {
            boolean booleanExtra2 = intent.getBooleanExtra(DfuBaseService.EXTRA_RESTORE_BOND, false);
            if (booleanExtra2 || !booleanExtra) {
                removeBond();
                this.mService.waitFor(2000L);
            }
            if (booleanExtra2 && (this.mFileType & 4) > 0 && !createBond()) {
                logw("Creating bond failed");
            }
        }
        if (this.mProgressInfo.isLastPart()) {
            this.mProgressInfo.setProgress(-6);
            return;
        }
        logi("Starting service that will upload application");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        intent2.putExtra(DfuBaseService.EXTRA_FILE_MIME_TYPE, DfuBaseService.MIME_TYPE_ZIP);
        intent2.putExtra(DfuBaseService.EXTRA_FILE_TYPE, 4);
        intent2.putExtra(DfuBaseService.EXTRA_PART_CURRENT, this.mProgressInfo.getCurrentPart() + 1);
        intent2.putExtra(DfuBaseService.EXTRA_PARTS_TOTAL, this.mProgressInfo.getTotalParts());
        restartService(intent2, true);
    }

    protected abstract UUID getControlPointCharacteristicUUID();

    protected abstract UUID getDfuServiceUUID();

    protected abstract UUID getPacketCharacteristicUUID();

    /* JADX WARN: Code duplicated, block: B:33:0x0074  */
    /* JADX WARN: Code duplicated, block: B:35:0x0078 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0079  */
    /* JADX WARN: Code duplicated, block: B:38:0x0083  */
    void uploadFirmwareImage(BluetoothGattCharacteristic bluetoothGattCharacteristic) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (this.mAborted) {
            throw new UploadAbortedException();
        }
        this.mReceivedData = null;
        this.mError = 0;
        this.mFirmwareUploadInProgress = true;
        this.mPacketsSentSinceNotification = 0;
        try {
            int availableObjectSizeIsBytes = this.mProgressInfo.getAvailableObjectSizeIsBytes();
            byte[] bArr = this.mBuffer;
            if (availableObjectSizeIsBytes < bArr.length) {
                bArr = new byte[availableObjectSizeIsBytes];
            }
            int i = this.mFirmwareStream.read(bArr);
            this.mService.sendLogBroadcast(1, "Sending firmware to characteristic " + bluetoothGattCharacteristic.getUuid() + "...");
            writePacket(this.mGatt, bluetoothGattCharacteristic, bArr, i);
            try {
                synchronized (this.mLock) {
                    while (true) {
                        try {
                            if (!this.mFirmwareUploadInProgress || this.mReceivedData != null || !this.mConnected || this.mError != 0) {
                                if (!this.mPaused) {
                                    break;
                                }
                                loge("Sleeping interrupted", e);
                                if (this.mConnected) {
                                    throw new DeviceDisconnectedException("Uploading Firmware Image failed: device disconnected");
                                }
                                if (this.mError == 0) {
                                    throw new DfuException("Uploading Firmware Image failed", this.mError);
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
            if (this.mConnected) {
                throw new DeviceDisconnectedException("Uploading Firmware Image failed: device disconnected");
            }
            if (this.mError == 0) {
                throw new DfuException("Uploading Firmware Image failed", this.mError);
            }
        } catch (HexFileValidationException unused) {
            throw new DfuException("HEX file not valid", 4099);
        } catch (IOException unused2) {
            throw new DfuException("Error while reading file", 4100);
        }
    }

    void writeInitData(BluetoothGattCharacteristic bluetoothGattCharacteristic, CRC32 crc32) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        try {
            byte[] bArr = this.mBuffer;
            while (true) {
                int i = this.mInitPacketStream.read(bArr, 0, bArr.length);
                if (i == -1) {
                    return;
                }
                writeInitPacket(bluetoothGattCharacteristic, bArr, i);
                if (crc32 != null) {
                    crc32.update(bArr, 0, i);
                }
            }
        } catch (IOException e) {
            loge("Error while reading Init packet file", e);
            throw new DfuException("Error while reading Init packet file", 4098);
        }
    }
}
