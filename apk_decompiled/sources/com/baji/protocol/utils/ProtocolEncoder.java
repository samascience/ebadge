package com.baji.protocol.utils;

import com.baji.protocol.model.ChunkInfo;
import com.baji.protocol.model.DeviceInfo;
import com.baji.protocol.model.FileInfo;
import com.baji.protocol.model.FileTransferCommand;
import com.baji.protocol.model.FileType;
import com.baji.protocol.model.MediaFileInfo;
import com.baji.protocol.model.MediaManagementCommand;
import com.baji.protocol.model.ModuleId;
import com.baji.protocol.model.PacketHeader;
import com.baji.protocol.model.SystemInfoCommand;
import com.baji.protocol.utils.ProtocolEncoder;
import defpackage.ar0;
import defpackage.gx;
import defpackage.p31;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;
import kotlin.collections.d;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes.dex */
public final class ProtocolEncoder {
    private static final int COMMAND_HEADER_SIZE = 4;
    private static final int MAX_PACKET_SIZE = 512;
    private static final int MAX_PAYLOAD_SIZE = 505;
    private static final int MIN_PACKET_SIZE = 7;
    private static final int PACKET_HEADER_SIZE = 3;
    private static final byte PACKET_START_MARKER = -51;
    private static final byte PRODUCT_ID = 37;
    private static final byte PROTOCOL_VERSION = 1;
    public static final ProtocolEncoder INSTANCE = new ProtocolEncoder();
    private static final ByteOrder BYTE_ORDER = ByteOrder.BIG_ENDIAN;

    private ProtocolEncoder() {
    }

    private final byte[] buildChunkPayload(ChunkInfo chunkInfo) {
        byte[] bArr = new byte[chunkInfo.getChunkData().length + 17];
        System.arraycopy(longToBytes(chunkInfo.getFileId()), 0, bArr, 0, 8);
        System.arraycopy(intToBytes(chunkInfo.getChunkIndex()), 0, bArr, 8, 4);
        System.arraycopy(intToBytes(chunkInfo.getChunkSize()), 0, bArr, 12, 4);
        bArr[16] = chunkInfo.isLastChunk();
        System.arraycopy(chunkInfo.getChunkData(), 0, bArr, 17, chunkInfo.getChunkData().length);
        return bArr;
    }

    private final byte[] buildDeviceInfoPayload(DeviceInfo deviceInfo) {
        byte[] bArrStringToBytes = stringToBytes(deviceInfo.getDeviceName());
        byte[] bArrStringToBytes2 = stringToBytes(deviceInfo.getDeviceVersion());
        byte[] bArrStringToBytes3 = stringToBytes(deviceInfo.getProtocolVersion());
        byte[] bArrStringToBytes4 = stringToBytes(j.N(deviceInfo.getFeatures(), ",", null, null, 0, null, null, 62, null));
        int size = deviceInfo.getSupportedFileTypes().size();
        byte[] bArr = new byte[size];
        int i = 0;
        for (Object obj : deviceInfo.getSupportedFileTypes()) {
            int i2 = i + 1;
            if (i < 0) {
                j.s();
            }
            bArr[i] = ((FileType) obj).getValue();
            i = i2;
        }
        byte[] bArr2 = new byte[bArrStringToBytes.length + 8 + bArrStringToBytes2.length + 4 + bArrStringToBytes3.length + 20 + size + 12 + bArrStringToBytes4.length];
        System.arraycopy(intToBytes(bArrStringToBytes.length), 0, bArr2, 0, 4);
        System.arraycopy(bArrStringToBytes, 0, bArr2, 4, bArrStringToBytes.length);
        int length = bArrStringToBytes.length;
        System.arraycopy(intToBytes(bArrStringToBytes2.length), 0, bArr2, 4 + length, 4);
        int i3 = length + 8;
        System.arraycopy(bArrStringToBytes2, 0, bArr2, i3, bArrStringToBytes2.length);
        int length2 = i3 + bArrStringToBytes2.length;
        System.arraycopy(intToBytes(bArrStringToBytes3.length), 0, bArr2, length2, 4);
        int i4 = length2 + 4;
        System.arraycopy(bArrStringToBytes3, 0, bArr2, i4, bArrStringToBytes3.length);
        int length3 = i4 + bArrStringToBytes3.length;
        System.arraycopy(longToBytes(deviceInfo.getStorageCapacity()), 0, bArr2, length3, 8);
        System.arraycopy(longToBytes(deviceInfo.getFreeStorage()), 0, bArr2, length3 + 8, 8);
        System.arraycopy(intToBytes(deviceInfo.getSupportedFileTypes().size()), 0, bArr2, length3 + 16, 4);
        int i5 = length3 + 20;
        System.arraycopy(bArr, 0, bArr2, i5, size);
        int i6 = i5 + size;
        System.arraycopy(longToBytes(deviceInfo.getMaxFileSize()), 0, bArr2, i6, 8);
        System.arraycopy(intToBytes(bArrStringToBytes4.length), 0, bArr2, i6 + 8, 4);
        System.arraycopy(bArrStringToBytes4, 0, bArr2, i6 + 12, bArrStringToBytes4.length);
        return bArr2;
    }

    private final byte[] buildFileInfoPayload(FileInfo fileInfo) {
        byte[] bArrStringToBytes = stringToBytes(fileInfo.getFileName());
        byte[] bArrStringToBytes2 = stringToBytes(j.N(fileInfo.getMetadata().entrySet(), ";", null, null, 0, null, new ar0() { // from class: b92
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return ProtocolEncoder.buildFileInfoPayload$lambda$0((Map.Entry) obj);
            }
        }, 30, null));
        byte[] bArr = new byte[bArrStringToBytes.length + 29 + bArrStringToBytes2.length];
        System.arraycopy(longToBytes(fileInfo.getFileId()), 0, bArr, 0, 8);
        System.arraycopy(intToBytes((int) fileInfo.getFileSize()), 0, bArr, 8, 4);
        bArr[12] = fileInfo.getFileType().getValue();
        System.arraycopy(intToBytes(fileInfo.getChecksum()), 0, bArr, 13, 4);
        System.arraycopy(intToBytes((int) fileInfo.getTimestamp()), 0, bArr, 17, 4);
        System.arraycopy(intToBytes(bArrStringToBytes.length), 0, bArr, 21, 4);
        System.arraycopy(bArrStringToBytes, 0, bArr, 25, bArrStringToBytes.length);
        int length = bArrStringToBytes.length;
        System.arraycopy(intToBytes(bArrStringToBytes2.length), 0, bArr, 25 + length, 4);
        System.arraycopy(bArrStringToBytes2, 0, bArr, length + 29, bArrStringToBytes2.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildFileInfoPayload$lambda$0(Map.Entry entry) {
        p31.f(entry, "it");
        return ((String) entry.getKey()) + '=' + ((String) entry.getValue());
    }

    private final byte[] buildMediaInfoPayload(MediaFileInfo mediaFileInfo) {
        byte[] bArrStringToBytes = stringToBytes(mediaFileInfo.getFileName());
        byte[] bArrStringToBytes2 = stringToBytes(j.N(mediaFileInfo.getMetadata().entrySet(), ";", null, null, 0, null, new ar0() { // from class: a92
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return ProtocolEncoder.buildMediaInfoPayload$lambda$1((Map.Entry) obj);
            }
        }, 30, null));
        byte[] bArr = new byte[bArrStringToBytes.length + 37 + bArrStringToBytes2.length];
        System.arraycopy(longToBytes(mediaFileInfo.getMediaId()), 0, bArr, 0, 8);
        System.arraycopy(intToBytes((int) mediaFileInfo.getFileSize()), 0, bArr, 8, 4);
        bArr[12] = mediaFileInfo.getFileType().getValue();
        System.arraycopy(intToBytes(mediaFileInfo.getChecksum()), 0, bArr, 13, 4);
        System.arraycopy(intToBytes((int) mediaFileInfo.getTimestamp()), 0, bArr, 17, 4);
        System.arraycopy(intToBytes(mediaFileInfo.getPreviewSize()), 0, bArr, 21, 4);
        System.arraycopy(intToBytes(mediaFileInfo.getBackgroundSize()), 0, bArr, 25, 4);
        System.arraycopy(intToBytes(bArrStringToBytes.length), 0, bArr, 29, 4);
        System.arraycopy(bArrStringToBytes, 0, bArr, 33, bArrStringToBytes.length);
        int length = bArrStringToBytes.length;
        System.arraycopy(intToBytes(bArrStringToBytes2.length), 0, bArr, 33 + length, 4);
        System.arraycopy(bArrStringToBytes2, 0, bArr, length + 37, bArrStringToBytes2.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildMediaInfoPayload$lambda$1(Map.Entry entry) {
        p31.f(entry, "it");
        return ((String) entry.getKey()) + '=' + ((String) entry.getValue());
    }

    public static /* synthetic */ byte[] buildPacket$default(ProtocolEncoder protocolEncoder, byte b, byte b2, byte[] bArr, int i, Object obj) {
        if ((i & 4) != 0) {
            bArr = new byte[0];
        }
        return protocolEncoder.buildPacket(b, b2, bArr);
    }

    public static /* synthetic */ int bytesToInt$default(ProtocolEncoder protocolEncoder, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return protocolEncoder.bytesToInt(bArr, i);
    }

    public static /* synthetic */ long bytesToLong$default(ProtocolEncoder protocolEncoder, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return protocolEncoder.bytesToLong(bArr, i);
    }

    public static /* synthetic */ short bytesToShort$default(ProtocolEncoder protocolEncoder, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return protocolEncoder.bytesToShort(bArr, i);
    }

    public static /* synthetic */ String bytesToString$default(ProtocolEncoder protocolEncoder, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return protocolEncoder.bytesToString(bArr, i, i2);
    }

    private final CommandHeader parseCommandHeader(byte[] bArr, int i) {
        if (bArr.length < i + 4) {
            return null;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, 4);
        byteBufferWrap.order(BYTE_ORDER);
        byte b = byteBufferWrap.get();
        if (b != 37) {
            return null;
        }
        return new CommandHeader(b, byteBufferWrap.get(), byteBufferWrap.get(), byteBufferWrap.get());
    }

    private final PacketHeader parsePacketHeader(byte[] bArr) {
        if (bArr.length < 3) {
            return null;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, 3);
        byteBufferWrap.order(BYTE_ORDER);
        byte b = byteBufferWrap.get();
        if (b != -51) {
            return null;
        }
        return new PacketHeader(b, (short) (byteBufferWrap.getShort() & 65535));
    }

    public final byte[] buildCommandHeader(byte b, byte b2) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(BYTE_ORDER);
        byteBufferAllocate.put((byte) 37);
        byteBufferAllocate.put((byte) 1);
        byteBufferAllocate.put(b);
        byteBufferAllocate.put(b2);
        byte[] bArrArray = byteBufferAllocate.array();
        p31.e(bArrArray, "array(...)");
        return bArrArray;
    }

    public final byte[] buildDeviceInfoPacket(DeviceInfo deviceInfo) {
        p31.f(deviceInfo, "deviceInfo");
        return buildPacket(ModuleId.SYSTEM_INFO.getValue(), SystemInfoCommand.DEVICE_INFO_RESPONSE.getValue(), buildDeviceInfoPayload(deviceInfo));
    }

    public final byte[] buildFileDataPacket(ChunkInfo chunkInfo) {
        p31.f(chunkInfo, "chunkInfo");
        return buildPacket(ModuleId.FILE_TRANSFER.getValue(), FileTransferCommand.FILE_DATA.getValue(), buildChunkPayload(chunkInfo));
    }

    public final byte[] buildFileInfoPacket(FileInfo fileInfo) {
        p31.f(fileInfo, "fileInfo");
        return buildPacket(ModuleId.FILE_TRANSFER.getValue(), FileTransferCommand.TRANSFER_START.getValue(), buildFileInfoPayload(fileInfo));
    }

    public final byte[] buildMediaInfoPacket(MediaFileInfo mediaFileInfo) {
        p31.f(mediaFileInfo, "mediaInfo");
        return buildPacket(ModuleId.MEDIA_MANAGEMENT.getValue(), MediaManagementCommand.MEDIA_INFO_RESPONSE.getValue(), buildMediaInfoPayload(mediaFileInfo));
    }

    public final byte[] buildPacket(byte b, byte b2, byte[] bArr) {
        p31.f(bArr, "payload");
        int length = bArr.length;
        byte[] bArrArray = ByteBuffer.allocate(2).order(BYTE_ORDER).putShort((short) (length + 1)).array();
        byte[] bArrBuildPacketHeader = buildPacketHeader(length + 6);
        byte[] bArrO = d.o(new byte[]{b2}, bArr);
        byte[] bArrO2 = d.o(d.o(d.o(bArrBuildPacketHeader, new byte[]{37}), new byte[]{1}), new byte[]{b});
        p31.c(bArrArray);
        return d.o(d.o(bArrO2, bArrArray), bArrO);
    }

    public final byte[] buildPacketHeader(int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(3);
        byteBufferAllocate.order(BYTE_ORDER);
        byteBufferAllocate.put((byte) -51);
        byteBufferAllocate.putShort((short) i);
        byte[] bArrArray = byteBufferAllocate.array();
        p31.e(bArrArray, "array(...)");
        return bArrArray;
    }

    public final int bytesToInt(byte[] bArr, int i) {
        p31.f(bArr, "data");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, 4);
        byteBufferWrap.order(BYTE_ORDER);
        return byteBufferWrap.getInt();
    }

    public final long bytesToLong(byte[] bArr, int i) {
        p31.f(bArr, "data");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, 8);
        byteBufferWrap.order(BYTE_ORDER);
        return byteBufferWrap.getLong();
    }

    public final short bytesToShort(byte[] bArr, int i) {
        p31.f(bArr, "data");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, 2);
        byteBufferWrap.order(BYTE_ORDER);
        return byteBufferWrap.getShort();
    }

    public final String bytesToString(byte[] bArr, int i, int i2) {
        p31.f(bArr, "data");
        return new String(bArr, i, i2, gx.b);
    }

    public final byte[] intToBytes(int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(BYTE_ORDER);
        byteBufferAllocate.putInt(i);
        byte[] bArrArray = byteBufferAllocate.array();
        p31.e(bArrArray, "array(...)");
        return bArrArray;
    }

    public final byte[] longToBytes(long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(BYTE_ORDER);
        byteBufferAllocate.putLong(j);
        byte[] bArrArray = byteBufferAllocate.array();
        p31.e(bArrArray, "array(...)");
        return bArrArray;
    }

    public final PacketParseResult parsePacket(byte[] bArr) {
        PacketHeader packetHeader;
        int i;
        p31.f(bArr, "data");
        if (bArr.length < 7 || (packetHeader = parsePacketHeader(bArr)) == null) {
            return null;
        }
        if (bArr.length < packetHeader.getDataLength() + 3 || bArr[3] != 37) {
            return null;
        }
        byte b = bArr[4];
        byte b2 = bArr[5];
        int i2 = (bArr[7] & 255) | ((bArr[6] & 255) << 8);
        return new PacketParseResult(packetHeader, new CommandHeader((byte) 37, b, b2, bArr[8]), (i2 <= 0 || (i = i2 + 8) > bArr.length) ? new byte[0] : d.k(bArr, 8, i));
    }

    public final byte[] shortToBytes(short s) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(2);
        byteBufferAllocate.order(BYTE_ORDER);
        byteBufferAllocate.putShort(s);
        byte[] bArrArray = byteBufferAllocate.array();
        p31.e(bArrArray, "array(...)");
        return bArrArray;
    }

    public final byte[] stringToBytes(String str) {
        p31.f(str, "value");
        byte[] bytes = str.getBytes(gx.b);
        p31.e(bytes, "getBytes(...)");
        return bytes;
    }

    public final PacketValidationResult validatePacket(byte[] bArr) {
        p31.f(bArr, "data");
        if (parsePacket(bArr) == null) {
            return new PacketValidationResult(false, PacketValidationError.INVALID_FORMAT, "数据包格式无效");
        }
        return bArr.length > 512 ? new PacketValidationResult(false, PacketValidationError.PACKET_TOO_LARGE, "数据包过大") : new PacketValidationResult(true, PacketValidationError.NONE, "数据包有效");
    }
}
