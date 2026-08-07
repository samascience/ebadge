package com.baji.protocol.service;

import android.util.Log;
import com.baji.protocol.model.BackgroundInfo;
import com.baji.protocol.model.BatchPreviewInfo;
import com.baji.protocol.model.ErrorCode;
import com.baji.protocol.model.FileType;
import com.baji.protocol.model.MediaFileInfo;
import com.baji.protocol.model.MediaManagementCommand;
import com.baji.protocol.model.ModuleId;
import com.baji.protocol.model.PreviewInfo;
import com.baji.protocol.utils.ProtocolEncoder;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import defpackage.gx;
import defpackage.or0;
import defpackage.p31;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.d;
import kotlin.collections.u;
import kotlin.text.i;

/* JADX INFO: loaded from: classes.dex */
public final class MediaManagementService extends BaseProtocolService {
    private or0 dataSender;
    private MediaManagementCallback mediaCallback;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MediaManagementCommand.values().length];
            try {
                iArr[MediaManagementCommand.MEDIA_LIST_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_LIST_RESPONSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_INFO_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_INFO_RESPONSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_PREVIEW_REQUEST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_PREVIEW_RESPONSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_PREVIEW_PUSH_REQUEST.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_PREVIEW_PUSH_RESPONSE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_BACKGROUND_REQUEST.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_BACKGROUND_RESPONSE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_BACKGROUND_PUSH_REQUEST.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_BACKGROUND_PUSH_RESPONSE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_ID_REQUEST.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_ID_RESPONSE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_BATCH_PREVIEW_INFO_REQUEST.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_BATCH_PREVIEW_INFO_RESPONSE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_BATCH_PREVIEW_DATA_REQUEST.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[MediaManagementCommand.MEDIA_BATCH_PREVIEW_DATA_RESPONSE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void handleBatchPreviewDataRequest(byte[] bArr) {
        Log.d("MediaManagementService", "处理批量预览数据请求");
    }

    private final void handleBatchPreviewDataResponse(byte[] bArr) {
    }

    private final void handleBatchPreviewInfoRequest(byte[] bArr) {
        Log.d("MediaManagementService", "处理批量预览信息请求");
    }

    private final void handleBatchPreviewInfoResponse(byte[] bArr) {
        try {
            BatchPreviewInfo batchPreviewInfo = parseBatchPreviewInfo(bArr);
            MediaManagementCallback mediaManagementCallback = this.mediaCallback;
            if (mediaManagementCallback != null) {
                mediaManagementCallback.onBatchPreviewReceived(batchPreviewInfo);
            }
        } catch (Exception e) {
            MediaManagementCallback mediaManagementCallback2 = this.mediaCallback;
            if (mediaManagementCallback2 != null) {
                ErrorCode errorCode = ErrorCode.UNKNOWN_ERROR;
                String message = e.getMessage();
                if (message == null) {
                    message = "Parse error";
                }
                mediaManagementCallback2.onError("BATCH_PREVIEW_INFO", null, errorCode, message);
            }
        }
    }

    private final void handleMediaBackgroundPushRequest(byte[] bArr) {
        Log.d("MediaManagementService", "处理媒体背景推送请求");
    }

    private final void handleMediaBackgroundPushResponse(byte[] bArr) {
    }

    private final void handleMediaBackgroundRequest(byte[] bArr) {
        Log.d("MediaManagementService", "处理媒体背景请求");
    }

    private final void handleMediaBackgroundResponse(byte[] bArr) {
        try {
            ProtocolEncoder protocolEncoder = ProtocolEncoder.INSTANCE;
            long jBytesToLong = protocolEncoder.bytesToLong(bArr, 0);
            int iBytesToInt = protocolEncoder.bytesToInt(bArr, 8);
            BackgroundInfo backgroundInfo = new BackgroundInfo(jBytesToLong, iBytesToInt, bArr.length > 12 ? d.k(bArr, 12, iBytesToInt + 12) : null);
            MediaManagementCallback mediaManagementCallback = this.mediaCallback;
            if (mediaManagementCallback != null) {
                mediaManagementCallback.onBackgroundReceived(jBytesToLong, backgroundInfo);
            }
        } catch (Exception e) {
            MediaManagementCallback mediaManagementCallback2 = this.mediaCallback;
            if (mediaManagementCallback2 != null) {
                ErrorCode errorCode = ErrorCode.UNKNOWN_ERROR;
                String message = e.getMessage();
                if (message == null) {
                    message = "Parse error";
                }
                mediaManagementCallback2.onError("MEDIA_BACKGROUND", null, errorCode, message);
            }
        }
    }

    private final void handleMediaDelete(byte[] bArr) {
        try {
            long jBytesToLong = ProtocolEncoder.INSTANCE.bytesToLong(bArr, 0);
            boolean z = bArr[8] != 0;
            String str = bArr.length > 9 ? new String(bArr, 9, bArr.length - 9, gx.b) : Constants.STR_EMPTY;
            MediaManagementCallback mediaManagementCallback = this.mediaCallback;
            if (mediaManagementCallback != null) {
                mediaManagementCallback.onMediaDeleted(jBytesToLong, z, str);
            }
        } catch (Exception e) {
            MediaManagementCallback mediaManagementCallback2 = this.mediaCallback;
            if (mediaManagementCallback2 != null) {
                ErrorCode errorCode = ErrorCode.UNKNOWN_ERROR;
                String message = e.getMessage();
                if (message == null) {
                    message = "Parse error";
                }
                mediaManagementCallback2.onError("MEDIA_DELETE", null, errorCode, message);
            }
        }
    }

    private final void handleMediaIdRequest(byte[] bArr) {
        Log.d("MediaManagementService", "处理媒体ID请求");
    }

    private final void handleMediaIdResponse(byte[] bArr) {
        try {
            long jBytesToLong = ProtocolEncoder.INSTANCE.bytesToLong(bArr, 0);
            boolean z = bArr[8] != 0;
            String str = bArr.length > 9 ? new String(bArr, 9, bArr.length - 9, gx.b) : Constants.STR_EMPTY;
            MediaManagementCallback mediaManagementCallback = this.mediaCallback;
            if (mediaManagementCallback != null) {
                mediaManagementCallback.onMediaIdAllocated(jBytesToLong, z, str);
            }
        } catch (Exception e) {
            MediaManagementCallback mediaManagementCallback2 = this.mediaCallback;
            if (mediaManagementCallback2 != null) {
                ErrorCode errorCode = ErrorCode.UNKNOWN_ERROR;
                String message = e.getMessage();
                if (message == null) {
                    message = "Parse error";
                }
                mediaManagementCallback2.onError("MEDIA_ID", null, errorCode, message);
            }
        }
    }

    private final void handleMediaInfoRequest(byte[] bArr) {
        Log.d("MediaManagementService", "处理媒体信息请求");
    }

    private final void handleMediaInfoResponse(byte[] bArr) {
        try {
            MediaFileInfo mediaFileInfo = (MediaFileInfo) parseMediaInfo$default(this, bArr, 0, 2, null).component1();
            MediaManagementCallback mediaManagementCallback = this.mediaCallback;
            if (mediaManagementCallback != null) {
                mediaManagementCallback.onMediaInfoReceived(mediaFileInfo);
            }
        } catch (Exception e) {
            MediaManagementCallback mediaManagementCallback2 = this.mediaCallback;
            if (mediaManagementCallback2 != null) {
                ErrorCode errorCode = ErrorCode.UNKNOWN_ERROR;
                String message = e.getMessage();
                if (message == null) {
                    message = "Parse error";
                }
                mediaManagementCallback2.onError("MEDIA_INFO", null, errorCode, message);
            }
        }
    }

    private final void handleMediaListRequest(byte[] bArr) {
        Log.d("MediaManagementService", "处理媒体列表请求");
    }

    private final void handleMediaListResponse(byte[] bArr) {
        try {
            List<MediaFileInfo> mediaList = parseMediaList(bArr);
            MediaManagementCallback mediaManagementCallback = this.mediaCallback;
            if (mediaManagementCallback != null) {
                mediaManagementCallback.onMediaListReceived(mediaList);
            }
        } catch (Exception e) {
            MediaManagementCallback mediaManagementCallback2 = this.mediaCallback;
            if (mediaManagementCallback2 != null) {
                ErrorCode errorCode = ErrorCode.UNKNOWN_ERROR;
                String message = e.getMessage();
                if (message == null) {
                    message = "Parse error";
                }
                mediaManagementCallback2.onError("MEDIA_LIST", null, errorCode, message);
            }
        }
    }

    private final void handleMediaPreviewPushRequest(byte[] bArr) {
        Log.d("MediaManagementService", "处理媒体预览推送请求");
    }

    private final void handleMediaPreviewPushResponse(byte[] bArr) {
    }

    private final void handleMediaPreviewRequest(byte[] bArr) {
        Log.d("MediaManagementService", "处理媒体预览请求");
    }

    private final void handleMediaPreviewResponse(byte[] bArr) {
        try {
            ProtocolEncoder protocolEncoder = ProtocolEncoder.INSTANCE;
            long jBytesToLong = protocolEncoder.bytesToLong(bArr, 0);
            int iBytesToInt = protocolEncoder.bytesToInt(bArr, 8);
            PreviewInfo previewInfo = new PreviewInfo(jBytesToLong, iBytesToInt, bArr.length > 12 ? d.k(bArr, 12, iBytesToInt + 12) : null);
            MediaManagementCallback mediaManagementCallback = this.mediaCallback;
            if (mediaManagementCallback != null) {
                mediaManagementCallback.onPreviewReceived(jBytesToLong, previewInfo);
            }
        } catch (Exception e) {
            MediaManagementCallback mediaManagementCallback2 = this.mediaCallback;
            if (mediaManagementCallback2 != null) {
                ErrorCode errorCode = ErrorCode.UNKNOWN_ERROR;
                String message = e.getMessage();
                if (message == null) {
                    message = "Parse error";
                }
                mediaManagementCallback2.onError("MEDIA_PREVIEW", null, errorCode, message);
            }
        }
    }

    public static /* synthetic */ void initialize$default(MediaManagementService mediaManagementService, MediaManagementCallback mediaManagementCallback, PacketSendCallback packetSendCallback, or0 or0Var, int i, Object obj) {
        if ((i & 1) != 0) {
            mediaManagementCallback = null;
        }
        if ((i & 2) != 0) {
            packetSendCallback = null;
        }
        if ((i & 4) != 0) {
            or0Var = null;
        }
        mediaManagementService.initialize(mediaManagementCallback, packetSendCallback, or0Var);
    }

    private final BatchPreviewInfo parseBatchPreviewInfo(byte[] bArr) {
        int i;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iBytesToInt = ProtocolEncoder.INSTANCE.bytesToInt(bArr, 0);
        int i2 = 4;
        for (int i3 = 0; i3 < iBytesToInt; i3++) {
            arrayList.add(Long.valueOf(ProtocolEncoder.INSTANCE.bytesToLong(bArr, i2)));
            i2 += 8;
        }
        int iBytesToInt2 = ProtocolEncoder.INSTANCE.bytesToInt(bArr, i2);
        int i4 = i2 + 4;
        for (int i5 = 0; i5 < iBytesToInt2; i5++) {
            ProtocolEncoder protocolEncoder = ProtocolEncoder.INSTANCE;
            long jBytesToLong = protocolEncoder.bytesToLong(bArr, i4);
            int iBytesToInt3 = protocolEncoder.bytesToInt(bArr, i4 + 8);
            int i6 = i4 + 12;
            byte[] bArrK = (iBytesToInt3 <= 0 || (i = i6 + iBytesToInt3) > bArr.length) ? null : d.k(bArr, i6, i);
            i4 = i6 + iBytesToInt3;
            arrayList2.add(new PreviewInfo(jBytesToLong, iBytesToInt3, bArrK));
        }
        return new BatchPreviewInfo(arrayList, arrayList2);
    }

    private final Pair<MediaFileInfo, Integer> parseMediaInfo(byte[] bArr, int i) {
        FileType fileType;
        ProtocolEncoder protocolEncoder = ProtocolEncoder.INSTANCE;
        long jBytesToLong = protocolEncoder.bytesToLong(bArr, i);
        int iBytesToInt = protocolEncoder.bytesToInt(bArr, i + 8);
        int i2 = i + 12;
        String str = new String(bArr, i2, iBytesToInt, gx.b);
        int i3 = i2 + iBytesToInt;
        long jBytesToInt = protocolEncoder.bytesToInt(bArr, i3);
        int i4 = i3 + 4;
        FileType[] fileTypeArrValues = FileType.values();
        int length = fileTypeArrValues.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                fileType = null;
                break;
            }
            fileType = fileTypeArrValues[i5];
            if (fileType.getValue() == bArr[i4]) {
                break;
            }
            i5++;
        }
        FileType fileType2 = fileType == null ? FileType.IMAGE : fileType;
        ProtocolEncoder protocolEncoder2 = ProtocolEncoder.INSTANCE;
        int iBytesToInt2 = protocolEncoder2.bytesToInt(bArr, i3 + 5);
        long jBytesToInt2 = protocolEncoder2.bytesToInt(bArr, i3 + 9);
        int iBytesToInt3 = protocolEncoder2.bytesToInt(bArr, i3 + 13);
        int iBytesToInt4 = protocolEncoder2.bytesToInt(bArr, i3 + 17);
        int iBytesToInt5 = protocolEncoder2.bytesToInt(bArr, i3 + 21);
        int i6 = i3 + 25;
        return new Pair<>(new MediaFileInfo(jBytesToLong, str, jBytesToInt, fileType2, iBytesToInt2, jBytesToInt2, iBytesToInt3, iBytesToInt4, iBytesToInt5 > 0 ? parseMetadata(new String(bArr, i6, iBytesToInt5, gx.b)) : u.f()), Integer.valueOf(i6 + iBytesToInt5));
    }

    static /* synthetic */ Pair parseMediaInfo$default(MediaManagementService mediaManagementService, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return mediaManagementService.parseMediaInfo(bArr, i);
    }

    private final List<MediaFileInfo> parseMediaList(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        int iIntValue = 0;
        while (iIntValue < bArr.length) {
            Pair<MediaFileInfo, Integer> mediaInfo = parseMediaInfo(bArr, iIntValue);
            arrayList.add(mediaInfo.getFirst());
            iIntValue = mediaInfo.getSecond().intValue();
        }
        return arrayList;
    }

    private final Map<String, String> parseMetadata(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = i.y0(str, new String[]{";"}, false, 0, 6, null).iterator();
        while (it.hasNext()) {
            List listY0 = i.y0((String) it.next(), new String[]{"="}, false, 2, 2, null);
            if (listY0.size() == 2) {
                linkedHashMap.put(listY0.get(0), listY0.get(1));
            }
        }
        return linkedHashMap;
    }

    public final void deleteMedia(long j) {
        sendPacket(ModuleId.MEDIA_MANAGEMENT, MediaManagementCommand.MEDIA_DELETE.getValue(), ProtocolEncoder.INSTANCE.longToBytes(j));
    }

    @Override // com.baji.protocol.service.BaseProtocolService
    public ModuleId getModuleId() {
        return ModuleId.MEDIA_MANAGEMENT;
    }

    @Override // com.baji.protocol.service.BaseProtocolService
    public void handlePacket(byte b, byte[] bArr) {
        MediaManagementCommand mediaManagementCommand;
        p31.f(bArr, "payload");
        MediaManagementCommand[] mediaManagementCommandArrValues = MediaManagementCommand.values();
        int length = mediaManagementCommandArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                mediaManagementCommand = null;
                break;
            }
            mediaManagementCommand = mediaManagementCommandArrValues[i];
            if (mediaManagementCommand.getValue() == b) {
                break;
            } else {
                i++;
            }
        }
        switch (mediaManagementCommand == null ? -1 : WhenMappings.$EnumSwitchMapping$0[mediaManagementCommand.ordinal()]) {
            case -1:
                MediaManagementCallback mediaManagementCallback = this.mediaCallback;
                if (mediaManagementCallback != null) {
                    mediaManagementCallback.onError("UNKNOWN_COMMAND", null, ErrorCode.UNSUPPORTED_COMMAND, "Unknown command: " + ((int) b));
                    return;
                }
                return;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                handleMediaListRequest(bArr);
                return;
            case 2:
                handleMediaListResponse(bArr);
                return;
            case 3:
                handleMediaDelete(bArr);
                return;
            case 4:
                handleMediaInfoRequest(bArr);
                return;
            case 5:
                handleMediaInfoResponse(bArr);
                return;
            case 6:
                handleMediaPreviewRequest(bArr);
                return;
            case 7:
                handleMediaPreviewResponse(bArr);
                return;
            case 8:
                handleMediaPreviewPushRequest(bArr);
                return;
            case 9:
                handleMediaPreviewPushResponse(bArr);
                return;
            case 10:
                handleMediaBackgroundRequest(bArr);
                return;
            case 11:
                handleMediaBackgroundResponse(bArr);
                return;
            case 12:
                handleMediaBackgroundPushRequest(bArr);
                return;
            case 13:
                handleMediaBackgroundPushResponse(bArr);
                return;
            case 14:
                handleMediaIdRequest(bArr);
                return;
            case 15:
                handleMediaIdResponse(bArr);
                return;
            case 16:
                handleBatchPreviewInfoRequest(bArr);
                return;
            case 17:
                handleBatchPreviewInfoResponse(bArr);
                return;
            case 18:
                handleBatchPreviewDataRequest(bArr);
                return;
            case 19:
                handleBatchPreviewDataResponse(bArr);
                return;
        }
    }

    @Override // com.baji.protocol.service.BaseProtocolService
    public void initialize(PacketSendCallback packetSendCallback) {
        setPacketSendCallback(packetSendCallback);
    }

    public final void requestMediaBackground(long j) {
        sendPacket(ModuleId.MEDIA_MANAGEMENT, MediaManagementCommand.MEDIA_BACKGROUND_REQUEST.getValue(), ProtocolEncoder.INSTANCE.longToBytes(j));
    }

    public final void requestMediaId() {
        BaseProtocolService.sendPacket$default(this, ModuleId.MEDIA_MANAGEMENT, MediaManagementCommand.MEDIA_ID_REQUEST.getValue(), null, 4, null);
    }

    public final void requestMediaInfo(long j) {
        sendPacket(ModuleId.MEDIA_MANAGEMENT, MediaManagementCommand.MEDIA_INFO_REQUEST.getValue(), ProtocolEncoder.INSTANCE.longToBytes(j));
    }

    public final void requestMediaList() {
        BaseProtocolService.sendPacket$default(this, ModuleId.MEDIA_MANAGEMENT, MediaManagementCommand.MEDIA_LIST_REQUEST.getValue(), null, 4, null);
    }

    public final void requestMediaPreview(long j) {
        sendPacket(ModuleId.MEDIA_MANAGEMENT, MediaManagementCommand.MEDIA_PREVIEW_REQUEST.getValue(), ProtocolEncoder.INSTANCE.longToBytes(j));
    }

    @Override // com.baji.protocol.service.BaseProtocolService
    protected boolean sendDataToDevice(byte[] bArr, String str) {
        p31.f(bArr, "data");
        p31.f(str, SocialConstants.PARAM_COMMENT);
        or0 or0Var = this.dataSender;
        if (or0Var != null) {
            return ((Boolean) or0Var.invoke(bArr, str)).booleanValue();
        }
        return false;
    }

    public final void initialize(MediaManagementCallback mediaManagementCallback, PacketSendCallback packetSendCallback, or0 or0Var) {
        this.mediaCallback = mediaManagementCallback;
        setPacketSendCallback(packetSendCallback);
        this.dataSender = or0Var;
    }
}
