package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.SystemClock;
import com.jieli.jl_rcsp.constant.WatchConstant;
import defpackage.hm2;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.UUID;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuExtendedErrorException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes4.dex */
class SecureDfuImpl extends BaseCustomDfuImpl {
    static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    static final UUID DEFAULT_DFU_PACKET_UUID;
    static final UUID DEFAULT_DFU_SERVICE_UUID;
    static UUID DFU_CONTROL_POINT_UUID = null;
    static UUID DFU_PACKET_UUID = null;
    static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    private static final int MAX_ATTEMPTS = 3;
    private static final int OBJECT_COMMAND = 1;
    private static final int OBJECT_DATA = 2;
    private static final byte[] OP_CODE_CALCULATE_CHECKSUM;
    private static final int OP_CODE_CALCULATE_CHECKSUM_KEY = 3;
    private static final byte[] OP_CODE_CREATE_COMMAND;
    private static final byte[] OP_CODE_CREATE_DATA;
    private static final int OP_CODE_CREATE_KEY = 1;
    private static final byte[] OP_CODE_EXECUTE;
    private static final int OP_CODE_EXECUTE_KEY = 4;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 2;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 96;
    private static final byte[] OP_CODE_SELECT_OBJECT;
    private static final int OP_CODE_SELECT_OBJECT_KEY = 6;
    private final SecureBluetoothCallback mBluetoothCallback;
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private BluetoothGattCharacteristic mPacketCharacteristic;
    private long prepareObjectDelay;

    private static class ObjectChecksum {
        int CRC32;
        int offset;

        private ObjectChecksum() {
        }
    }

    private static class ObjectInfo extends ObjectChecksum {
        int maxSize;

        private ObjectInfo() {
            super();
        }
    }

    protected class SecureBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        protected SecureBluetoothCallback() {
            super();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGattCharacteristic.getValue() == null || bluetoothGattCharacteristic.getValue().length < 3) {
                SecureDfuImpl.this.loge("Empty response: " + parse(bluetoothGattCharacteristic));
                SecureDfuImpl secureDfuImpl = SecureDfuImpl.this;
                secureDfuImpl.mError = DfuBaseService.ERROR_INVALID_RESPONSE;
                secureDfuImpl.notifyLock();
                return;
            }
            if (bluetoothGattCharacteristic.getIntValue(17, 0).intValue() != 96) {
                SecureDfuImpl.this.loge("Invalid response: " + parse(bluetoothGattCharacteristic));
                SecureDfuImpl.this.mError = DfuBaseService.ERROR_INVALID_RESPONSE;
            } else if (bluetoothGattCharacteristic.getIntValue(17, 1).intValue() == 3) {
                int iIntValue = bluetoothGattCharacteristic.getIntValue(20, 3).intValue();
                if (((int) (((ArchiveInputStream) SecureDfuImpl.this.mFirmwareStream).getCrc32() & 4294967295L)) == bluetoothGattCharacteristic.getIntValue(20, 7).intValue()) {
                    SecureDfuImpl.this.mProgressInfo.setBytesReceived(iIntValue);
                } else {
                    SecureDfuImpl secureDfuImpl2 = SecureDfuImpl.this;
                    if (secureDfuImpl2.mFirmwareUploadInProgress) {
                        secureDfuImpl2.mFirmwareUploadInProgress = false;
                        secureDfuImpl2.notifyLock();
                        return;
                    }
                }
                handlePacketReceiptNotification(bluetoothGatt, bluetoothGattCharacteristic);
            } else if (!SecureDfuImpl.this.mRemoteErrorOccurred) {
                if (bluetoothGattCharacteristic.getIntValue(17, 2).intValue() != 1) {
                    SecureDfuImpl.this.mRemoteErrorOccurred = true;
                }
                handleNotification(bluetoothGatt, bluetoothGattCharacteristic);
            }
            SecureDfuImpl.this.notifyLock();
        }
    }

    static {
        UUID uuid = new UUID(279658205548544L, -9223371485494954757L);
        DEFAULT_DFU_SERVICE_UUID = uuid;
        UUID uuid2 = new UUID(-8157989241631715488L, -6937650605005804976L);
        DEFAULT_DFU_CONTROL_POINT_UUID = uuid2;
        UUID uuid3 = new UUID(-8157989237336748192L, -6937650605005804976L);
        DEFAULT_DFU_PACKET_UUID = uuid3;
        DFU_SERVICE_UUID = uuid;
        DFU_CONTROL_POINT_UUID = uuid2;
        DFU_PACKET_UUID = uuid3;
        OP_CODE_CREATE_COMMAND = new byte[]{1, 1, 0, 0, 0, 0};
        OP_CODE_CREATE_DATA = new byte[]{1, 2, 0, 0, 0, 0};
        OP_CODE_PACKET_RECEIPT_NOTIF_REQ = new byte[]{2, 0, 0};
        OP_CODE_CALCULATE_CHECKSUM = new byte[]{3};
        OP_CODE_EXECUTE = new byte[]{4};
        OP_CODE_SELECT_OBJECT = new byte[]{6, 0};
    }

    SecureDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        this.mBluetoothCallback = new SecureBluetoothCallback();
    }

    private int getStatusCode(byte[] bArr, int i) throws UnknownResponseException {
        byte b;
        if (bArr != null && bArr.length >= 3 && bArr[0] == 96 && bArr[1] == i && ((b = bArr[2]) == 1 || b == 2 || b == 3 || b == 4 || b == 5 || b == 7 || b == 8 || b == 10 || b == 11)) {
            return b;
        }
        throw new UnknownResponseException("Invalid response received", bArr, 96, i);
    }

    private ObjectChecksum readChecksum() throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_CALCULATE_CHECKSUM);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 3);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Receiving Checksum failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Receiving Checksum failed", statusCode);
        }
        ObjectChecksum objectChecksum = new ObjectChecksum();
        objectChecksum.offset = unsignedBytesToInt(notificationResponse, 3);
        objectChecksum.CRC32 = unsignedBytesToInt(notificationResponse, 7);
        return objectChecksum;
    }

    private ObjectInfo selectObject(int i) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read object info: device disconnected");
        }
        byte[] bArr = OP_CODE_SELECT_OBJECT;
        bArr[1] = (byte) i;
        writeOpCode(this.mControlPointCharacteristic, bArr);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 6);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Selecting object failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Selecting object failed", statusCode);
        }
        ObjectInfo objectInfo = new ObjectInfo();
        objectInfo.maxSize = unsignedBytesToInt(notificationResponse, 3);
        objectInfo.offset = unsignedBytesToInt(notificationResponse, 7);
        objectInfo.CRC32 = unsignedBytesToInt(notificationResponse, 11);
        return objectInfo;
    }

    private void sendFirmware(BluetoothGatt bluetoothGatt) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        int i;
        String str;
        boolean z;
        long j;
        int i2 = this.mPacketsBeforeNotification;
        if (i2 > 0) {
            setPacketReceiptNotifications(i2);
            this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 2) sent (Value = " + i2 + ")");
        }
        logi("Setting object to Data (Op Code = 6, Type = 2)");
        ObjectInfo objectInfoSelectObject = selectObject(2);
        Locale locale = Locale.US;
        logi(String.format(locale, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(objectInfoSelectObject.maxSize), Integer.valueOf(objectInfoSelectObject.offset), Integer.valueOf(objectInfoSelectObject.CRC32)));
        this.mService.sendLogBroadcast(10, String.format(locale, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(objectInfoSelectObject.maxSize), Integer.valueOf(objectInfoSelectObject.offset), Integer.valueOf(objectInfoSelectObject.CRC32)));
        this.mProgressInfo.setMaxObjectSizeInBytes(objectInfoSelectObject.maxSize);
        int i3 = this.mImageSizeInBytes;
        int i4 = objectInfoSelectObject.maxSize;
        int i5 = ((i3 + i4) - 1) / i4;
        int i6 = objectInfoSelectObject.offset;
        if (i6 > 0) {
            try {
                i = i6 / i4;
                int i7 = i4 * i;
                int i8 = i6 - i7;
                if (i8 == 0) {
                    i7 -= i4;
                } else {
                    i4 = i8;
                }
                int i9 = i7;
                if (i9 > 0) {
                    this.mFirmwareStream.read(new byte[i9]);
                    this.mFirmwareStream.mark(objectInfoSelectObject.maxSize);
                }
                this.mFirmwareStream.read(new byte[i4]);
                str = ")";
                if (((int) (((ArchiveInputStream) this.mFirmwareStream).getCrc32() & 4294967295L)) == objectInfoSelectObject.CRC32) {
                    logi(objectInfoSelectObject.offset + " bytes of data sent before, CRC match");
                    this.mService.sendLogBroadcast(10, objectInfoSelectObject.offset + " bytes of data sent before, CRC match");
                    this.mProgressInfo.setBytesSent(objectInfoSelectObject.offset);
                    this.mProgressInfo.setBytesReceived(objectInfoSelectObject.offset);
                    if (i4 != objectInfoSelectObject.maxSize || objectInfoSelectObject.offset >= this.mImageSizeInBytes) {
                        z = true;
                    } else {
                        logi("Executing data object (Op Code = 4)");
                        try {
                            writeExecute();
                            this.mService.sendLogBroadcast(10, "Data object executed");
                        } catch (RemoteDfuException e) {
                            if (e.getErrorNumber() != 8) {
                                throw e;
                            }
                            this.mService.sendLogBroadcast(10, "Data object already executed");
                            this.mRemoteErrorOccurred = false;
                        }
                    }
                } else {
                    logi(objectInfoSelectObject.offset + " bytes sent before, CRC does not match");
                    this.mService.sendLogBroadcast(15, objectInfoSelectObject.offset + " bytes sent before, CRC does not match");
                    this.mProgressInfo.setBytesSent(i9);
                    this.mProgressInfo.setBytesReceived(i9);
                    objectInfoSelectObject.offset = objectInfoSelectObject.offset - i4;
                    objectInfoSelectObject.CRC32 = 0;
                    this.mFirmwareStream.reset();
                    logi("Resuming from byte " + objectInfoSelectObject.offset + "...");
                    this.mService.sendLogBroadcast(10, "Resuming from byte " + objectInfoSelectObject.offset + "...");
                }
                z = false;
            } catch (IOException e2) {
                loge("Error while reading firmware stream", e2);
                this.mService.terminateConnection(bluetoothGatt, 4100);
                return;
            }
        } else {
            str = ")";
            this.mProgressInfo.setBytesSent(0);
            z = false;
            i = 0;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (objectInfoSelectObject.offset < this.mImageSizeInBytes) {
            int i10 = 1;
            while (this.mProgressInfo.getAvailableObjectSizeIsBytes() > 0) {
                if (z) {
                    this.mService.sendLogBroadcast(10, "Resuming uploading firmware...");
                    z = false;
                } else {
                    int availableObjectSizeIsBytes = this.mProgressInfo.getAvailableObjectSizeIsBytes();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Creating Data object (Op Code = 1, Type = 2, Size = ");
                    sb.append(availableObjectSizeIsBytes);
                    sb.append(") (");
                    int i11 = i + 1;
                    sb.append(i11);
                    sb.append(WatchConstant.FAT_FS_ROOT);
                    sb.append(i5);
                    sb.append(str);
                    logi(sb.toString());
                    writeCreateRequest(2, availableObjectSizeIsBytes);
                    this.mService.sendLogBroadcast(10, "Data object (" + i11 + WatchConstant.FAT_FS_ROOT + i5 + ") created");
                    long j2 = this.prepareObjectDelay;
                    if (j2 > 0 || i5 == 0) {
                        DfuBaseService dfuBaseService = this.mService;
                        if (j2 <= 0) {
                            j2 = 400;
                        }
                        dfuBaseService.waitFor(j2);
                    }
                    this.mService.sendLogBroadcast(10, "Uploading firmware...");
                }
                try {
                    logi("Uploading firmware...");
                    uploadFirmwareImage(this.mPacketCharacteristic);
                    logi("Sending Calculate Checksum command (Op Code = 3)");
                    ObjectChecksum checksum = readChecksum();
                    Locale locale2 = Locale.US;
                    logi(String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(checksum.offset), Integer.valueOf(checksum.CRC32)));
                    this.mService.sendLogBroadcast(10, String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(checksum.offset), Integer.valueOf(checksum.CRC32)));
                    int bytesSent = this.mProgressInfo.getBytesSent() - checksum.offset;
                    if (bytesSent > 0) {
                        logw(bytesSent + " bytes were lost!");
                        this.mService.sendLogBroadcast(15, bytesSent + " bytes were lost");
                        try {
                            this.mFirmwareStream.reset();
                            this.mFirmwareStream.read(new byte[objectInfoSelectObject.maxSize - bytesSent]);
                            this.mProgressInfo.setBytesSent(checksum.offset);
                            int i12 = this.mPacketsBeforeNotification;
                            if (i12 == 0 || i12 > 1) {
                                this.mPacketsBeforeNotification = 1;
                                setPacketReceiptNotifications(1);
                                this.mService.sendLogBroadcast(10, "Packet Receipt Notif Req (Op Code = 2) sent (Value = 1)");
                            }
                        } catch (IOException e3) {
                            loge("Error while reading firmware stream", e3);
                            this.mService.terminateConnection(bluetoothGatt, 4100);
                            return;
                        } catch (Throwable th) {
                            loge("Progress lost. Bytes sent: " + this.mProgressInfo.getBytesSent(), th);
                            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_PROGRESS_LOST);
                            return;
                        }
                    }
                    i5 = i5;
                    int crc32 = (int) (((ArchiveInputStream) this.mFirmwareStream).getCrc32() & 4294967295L);
                    if (crc32 != checksum.CRC32) {
                        String str2 = String.format(locale2, "CRC does not match! Expected %08X but found %08X.", Integer.valueOf(crc32), Integer.valueOf(checksum.CRC32));
                        if (i10 >= 3) {
                            loge(str2);
                            this.mService.sendLogBroadcast(20, str2);
                            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_CRC_ERROR);
                            return;
                        }
                        i10++;
                        String str3 = str2 + String.format(locale2, " Retrying...(%d/%d)", Integer.valueOf(i10), 3);
                        logi(str3);
                        this.mService.sendLogBroadcast(15, str3);
                        try {
                            this.mFirmwareStream.reset();
                            this.mProgressInfo.setBytesSent(((ArchiveInputStream) this.mFirmwareStream).getBytesRead());
                        } catch (IOException e4) {
                            loge("Error while resetting the firmware stream", e4);
                            this.mService.terminateConnection(bluetoothGatt, 4100);
                            return;
                        }
                    } else if (bytesSent > 0) {
                        z = true;
                    } else {
                        logi("Executing data object (Op Code = 4)");
                        writeExecute(this.mProgressInfo.isComplete());
                        this.mService.sendLogBroadcast(10, "Data object executed");
                        i++;
                        this.mFirmwareStream.mark(0);
                        i10 = 1;
                    }
                } catch (DeviceDisconnectedException e5) {
                    loge("Disconnected while sending data");
                    throw e5;
                }
            }
            j = jElapsedRealtime;
        } else {
            j = jElapsedRealtime;
            logi("Executing data object (Op Code = 4)");
            writeExecute(true);
            this.mService.sendLogBroadcast(10, "Data object executed");
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Transfer of ");
        sb2.append(this.mProgressInfo.getBytesSent() - objectInfoSelectObject.offset);
        sb2.append(" bytes has taken ");
        long j3 = jElapsedRealtime2 - j;
        sb2.append(j3);
        sb2.append(" ms");
        logi(sb2.toString());
        this.mService.sendLogBroadcast(10, "Upload completed in " + j3 + " ms");
    }

    private void sendInitPacket(BluetoothGatt bluetoothGatt, boolean z) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        boolean z2;
        boolean z3;
        int i;
        IOException iOException;
        CRC32 crc32 = new CRC32();
        logi("Setting object to Command (Op Code = 6, Type = 1)");
        int i2 = 1;
        ObjectInfo objectInfoSelectObject = selectObject(1);
        Locale locale = Locale.US;
        logi(String.format(locale, "Command object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(objectInfoSelectObject.maxSize), Integer.valueOf(objectInfoSelectObject.offset), Integer.valueOf(objectInfoSelectObject.CRC32)));
        this.mService.sendLogBroadcast(10, String.format(locale, "Command object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(objectInfoSelectObject.maxSize), Integer.valueOf(objectInfoSelectObject.offset), Integer.valueOf(objectInfoSelectObject.CRC32)));
        int i3 = this.mInitPacketSizeInBytes;
        long j = 4294967295L;
        if (!z || (i = objectInfoSelectObject.offset) <= 0 || i > i3) {
            z2 = false;
            z3 = false;
        } else {
            try {
                byte[] bArr = new byte[i];
                this.mInitPacketStream.read(bArr);
                crc32.update(bArr);
                if (objectInfoSelectObject.CRC32 == ((int) (crc32.getValue() & 4294967295L))) {
                    logi("Init packet CRC is the same");
                    if (objectInfoSelectObject.offset == this.mInitPacketSizeInBytes) {
                        logi("-> Whole Init packet was sent before");
                        try {
                            this.mService.sendLogBroadcast(10, "Received CRC match Init packet");
                            z2 = true;
                            z3 = false;
                        } catch (IOException e) {
                            iOException = e;
                            z2 = true;
                            z3 = false;
                            loge("Error while reading " + objectInfoSelectObject.offset + " bytes from the init packet stream", iOException);
                            try {
                                this.mInitPacketStream.reset();
                                crc32.reset();
                                objectInfoSelectObject.offset = 0;
                            } catch (IOException e2) {
                                loge("Error while resetting the init packet stream", e2);
                                this.mService.terminateConnection(bluetoothGatt, 4100);
                                return;
                            }
                        }
                    } else {
                        logi("-> " + objectInfoSelectObject.offset + " bytes of Init packet were sent before");
                        try {
                            this.mService.sendLogBroadcast(10, "Resuming sending Init packet...");
                            z3 = true;
                            z2 = false;
                        } catch (IOException e3) {
                            iOException = e3;
                            z3 = true;
                            z2 = false;
                            loge("Error while reading " + objectInfoSelectObject.offset + " bytes from the init packet stream", iOException);
                            this.mInitPacketStream.reset();
                            crc32.reset();
                            objectInfoSelectObject.offset = 0;
                        }
                    }
                } else {
                    this.mInitPacketStream.reset();
                    crc32.reset();
                    objectInfoSelectObject.offset = 0;
                    z2 = false;
                    z3 = false;
                }
            } catch (IOException e4) {
                iOException = e4;
                z2 = false;
                z3 = false;
            }
        }
        if (!z2) {
            setPacketReceiptNotifications(0);
            this.mService.sendLogBroadcast(10, "Packet Receipt Notif disabled (Op Code = 2, Value = 0)");
            int i4 = 1;
            while (i4 <= 3) {
                if (!z3) {
                    logi("Creating Init packet object (Op Code = 1, Type = 1, Size = " + this.mInitPacketSizeInBytes + ")");
                    writeCreateRequest(i2, this.mInitPacketSizeInBytes);
                    this.mService.sendLogBroadcast(10, "Command object created");
                }
                try {
                    logi("Sending " + (this.mInitPacketSizeInBytes - objectInfoSelectObject.offset) + " bytes of init packet...");
                    writeInitData(this.mPacketCharacteristic, crc32);
                    int value = (int) (crc32.getValue() & j);
                    DfuBaseService dfuBaseService = this.mService;
                    Locale locale2 = Locale.US;
                    dfuBaseService.sendLogBroadcast(10, String.format(locale2, "Command object sent (CRC = %08X)", Integer.valueOf(value)));
                    logi("Sending Calculate Checksum command (Op Code = 3)");
                    ObjectChecksum checksum = readChecksum();
                    this.mService.sendLogBroadcast(10, String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(checksum.offset), Integer.valueOf(checksum.CRC32)));
                    logi(String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(checksum.offset), Integer.valueOf(checksum.CRC32)));
                    if (value == checksum.CRC32) {
                        break;
                    }
                    if (i4 >= 3) {
                        loge("CRC does not match!");
                        this.mService.sendLogBroadcast(20, "CRC does not match!");
                        this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_CRC_ERROR);
                        return;
                    }
                    i4++;
                    logi("CRC does not match! Retrying...(" + i4 + WatchConstant.FAT_FS_ROOT + "3)");
                    this.mService.sendLogBroadcast(15, "CRC does not match! Retrying...(" + i4 + WatchConstant.FAT_FS_ROOT + "3)");
                    try {
                        objectInfoSelectObject.offset = 0;
                        objectInfoSelectObject.CRC32 = 0;
                        this.mInitPacketStream.reset();
                        crc32.reset();
                        z3 = false;
                        i2 = 1;
                        j = 4294967295L;
                    } catch (IOException e5) {
                        loge("Error while resetting the init packet stream", e5);
                        this.mService.terminateConnection(bluetoothGatt, 4100);
                        return;
                    }
                } catch (DeviceDisconnectedException e6) {
                    loge("Disconnected while sending init packet");
                    throw e6;
                }
            }
        }
        logi("Executing init packet (Op Code = 4)");
        writeExecute();
        this.mService.sendLogBroadcast(10, "Command object executed");
    }

    private void setNumberOfPackets(byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    private void setObjectSize(byte[] bArr, int i) {
        bArr[2] = (byte) (i & 255);
        bArr[3] = (byte) ((i >> 8) & 255);
        bArr[4] = (byte) ((i >> 16) & 255);
        bArr[5] = (byte) ((i >> 24) & 255);
    }

    private void setPacketReceiptNotifications(int i) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
        logi("Sending the number of packets before notifications (Op Code = 2, Value = " + i + ")");
        byte[] bArr = OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
        setNumberOfPackets(bArr, i);
        writeOpCode(this.mControlPointCharacteristic, bArr);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 2);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Sending the number of packets failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Sending the number of packets failed", statusCode);
        }
    }

    private int unsignedBytesToInt(byte[] bArr, int i) {
        return (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8) + ((bArr[i + 2] & 255) << 16) + ((bArr[i + 3] & 255) << 24);
    }

    private void writeCreateRequest(int i, int i2) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to create object: device disconnected");
        }
        byte[] bArr = i == 1 ? OP_CODE_CREATE_COMMAND : OP_CODE_CREATE_DATA;
        setObjectSize(bArr, i2);
        writeOpCode(this.mControlPointCharacteristic, bArr);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 1);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Creating Command object failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Creating Command object failed", statusCode);
        }
    }

    private void writeExecute() throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        if (!this.mConnected) {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_EXECUTE);
        byte[] notificationResponse = readNotificationResponse();
        int statusCode = getStatusCode(notificationResponse, 4);
        if (statusCode == 11) {
            throw new RemoteDfuExtendedErrorException("Executing object failed", notificationResponse[3]);
        }
        if (statusCode != 1) {
            throw new RemoteDfuException("Executing object failed", statusCode);
        }
    }

    private void writeOpCode(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        writeOpCode(bluetoothGattCharacteristic, bArr, false);
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

    @Override // no.nordicsemi.android.dfu.BaseDfuImpl, no.nordicsemi.android.dfu.DfuService
    public boolean initialize(Intent intent, BluetoothGatt bluetoothGatt, int i, InputStream inputStream, InputStream inputStream2) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        if (inputStream2 != null) {
            return super.initialize(intent, bluetoothGatt, i, inputStream, inputStream2);
        }
        this.mService.sendLogBroadcast(20, "The Init packet is required by this version DFU Bootloader");
        this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_INIT_PACKET_REQUIRED);
        return false;
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

    @Override // no.nordicsemi.android.dfu.DfuService
    public void performDfu(Intent intent) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        logw("Secure DFU bootloader found");
        this.mProgressInfo.setProgress(-2);
        BluetoothGatt bluetoothGatt = this.mGatt;
        if (intent.hasExtra(DfuBaseService.EXTRA_MTU)) {
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_MTU, 517);
            logi("Requesting MTU = " + intExtra);
            requestMtu(intExtra);
        }
        this.prepareObjectDelay = intent.getLongExtra(DfuBaseService.EXTRA_DATA_OBJECT_DELAY, 0L);
        try {
            try {
                boolean z = true;
                enableCCCD(this.mControlPointCharacteristic, 1);
                this.mService.sendLogBroadcast(10, "Notifications enabled");
                if (intent.hasExtra(DfuBaseService.EXTRA_DISABLE_RESUME) && intent.getBooleanExtra(DfuBaseService.EXTRA_DISABLE_RESUME, false)) {
                    z = false;
                }
                if (!z) {
                    logi("Resume feature disabled. Performing fresh DFU");
                }
                try {
                    sendInitPacket(bluetoothGatt, z);
                } catch (RemoteDfuException e) {
                    if (this.mProgressInfo.isLastPart()) {
                        throw e;
                    }
                    this.mRemoteErrorOccurred = false;
                    logw("Sending SD+BL failed. Trying to send App only");
                    this.mService.sendLogBroadcast(15, "Invalid system components. Trying to send application");
                    this.mFileType = 4;
                    ArchiveInputStream archiveInputStream = (ArchiveInputStream) this.mFirmwareStream;
                    archiveInputStream.setContentType(4);
                    byte[] applicationInit = archiveInputStream.getApplicationInit();
                    this.mInitPacketStream = new ByteArrayInputStream(applicationInit);
                    this.mInitPacketSizeInBytes = applicationInit.length;
                    int iApplicationImageSize = archiveInputStream.applicationImageSize();
                    this.mImageSizeInBytes = iApplicationImageSize;
                    this.mProgressInfo.init(iApplicationImageSize, 2, 2);
                    sendInitPacket(bluetoothGatt, false);
                }
                sendFirmware(bluetoothGatt);
                this.mProgressInfo.setProgress(-5);
                this.mService.waitUntilDisconnected();
                this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
                finalize(intent, false);
            } catch (RemoteDfuException e2) {
                int errorNumber = e2.getErrorNumber();
                int i = errorNumber | 512;
                loge(e2.getMessage() + ": " + hm2.a(i));
                this.mService.sendLogBroadcast(20, String.format(Locale.US, "Remote DFU error: %s", hm2.a(i)));
                if (!(e2 instanceof RemoteDfuExtendedErrorException)) {
                    this.mService.terminateConnection(bluetoothGatt, errorNumber | 8704);
                    return;
                }
                RemoteDfuExtendedErrorException remoteDfuExtendedErrorException = (RemoteDfuExtendedErrorException) e2;
                int extendedErrorNumber = remoteDfuExtendedErrorException.getExtendedErrorNumber();
                int i2 = extendedErrorNumber | 1024;
                loge("Extended Error details: " + hm2.c(i2));
                this.mService.sendLogBroadcast(20, "Details: " + hm2.c(i2) + " (Code = " + remoteDfuExtendedErrorException.getExtendedErrorNumber() + ")");
                this.mService.terminateConnection(bluetoothGatt, extendedErrorNumber | 9216);
            }
        } catch (UnknownResponseException e3) {
            loge(e3.getMessage());
            this.mService.sendLogBroadcast(20, e3.getMessage());
            this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_INVALID_RESPONSE);
        } catch (UploadAbortedException e4) {
            throw e4;
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public BaseDfuImpl.BaseBluetoothGattCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    private void writeExecute(boolean z) throws UploadAbortedException, RemoteDfuException, UnknownResponseException, DfuException, DeviceDisconnectedException {
        try {
            writeExecute();
        } catch (RemoteDfuException e) {
            if (z && e.getErrorNumber() == 5) {
                logw(e.getMessage() + ": " + hm2.a(517));
                if (this.mFileType == 1) {
                    logw("Are you sure your new SoftDevice is API compatible with the updated one? If not, update the bootloader as well");
                }
                this.mService.sendLogBroadcast(15, String.format(Locale.US, "Remote DFU error: %s. SD busy? Retrying...", hm2.a(517)));
                logi("SD busy? Retrying...");
                logi("Executing data object (Op Code = 4)");
                writeExecute();
                return;
            }
            throw e;
        }
    }
}
