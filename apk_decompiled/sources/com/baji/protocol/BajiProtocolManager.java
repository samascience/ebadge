package com.baji.protocol;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baji.protocol.BajiProtocolManager;
import com.baji.protocol.event.BajiBaseEvent;
import com.baji.protocol.event.BatchPreviewInfoEvent;
import com.baji.protocol.event.DeviceCapabilityEvent;
import com.baji.protocol.event.DeviceConnectionEvent;
import com.baji.protocol.event.DeviceInfoEvent;
import com.baji.protocol.event.DeviceStorageEvent;
import com.baji.protocol.event.FileTransferCancelEvent;
import com.baji.protocol.event.FileTransferErrorEvent;
import com.baji.protocol.event.FileTransferProgressEvent;
import com.baji.protocol.event.FileTransferStartEvent;
import com.baji.protocol.event.FileTransferStatusEvent;
import com.baji.protocol.event.MediaBackgroundEvent;
import com.baji.protocol.event.MediaDeleteEvent;
import com.baji.protocol.event.MediaIdAllocationEvent;
import com.baji.protocol.event.MediaInfoEvent;
import com.baji.protocol.event.MediaListUpdateEvent;
import com.baji.protocol.event.MediaManagementErrorEvent;
import com.baji.protocol.event.MediaPreviewEvent;
import com.baji.protocol.event.SystemErrorEvent;
import com.baji.protocol.model.BackgroundInfo;
import com.baji.protocol.model.BatchPreviewInfo;
import com.baji.protocol.model.DeviceInfo;
import com.baji.protocol.model.ErrorCode;
import com.baji.protocol.model.FileInfo;
import com.baji.protocol.model.FileType;
import com.baji.protocol.model.FunctionType;
import com.baji.protocol.model.MediaFileInfo;
import com.baji.protocol.model.ModuleId;
import com.baji.protocol.model.PreviewInfo;
import com.baji.protocol.model.TransferFileInfo;
import com.baji.protocol.model.TransferProgress;
import com.baji.protocol.model.TransferStatusInfo;
import com.baji.protocol.service.DeviceConnectionCallback;
import com.baji.protocol.service.FileTransferService;
import com.baji.protocol.service.MediaManagementCallback;
import com.baji.protocol.service.MediaManagementService;
import com.baji.protocol.service.PacketReceiveCallback;
import com.baji.protocol.service.PacketSendCallback;
import com.baji.protocol.service.SDKEventListener;
import com.baji.protocol.service.SystemInfoCallback;
import com.baji.protocol.service.SystemInfoService;
import com.baji.protocol.service.TransferErrorCallback;
import com.baji.protocol.service.TransferProgressCallback;
import com.baji.protocol.service.TransferStatusCallback;
import com.baji.protocol.utils.CommandHeader;
import com.baji.protocol.utils.PacketParseResult;
import com.baji.protocol.utils.PacketValidationResult;
import com.baji.protocol.utils.ProtocolEncoder;
import com.legend.mywatch.sdk.mywatchsdklib.android.enm.BluetoothStatusEnum;
import com.tencent.open.SocialConstants;
import defpackage.aa0;
import defpackage.i10;
import defpackage.ng;
import defpackage.o10;
import defpackage.or0;
import defpackage.p31;
import defpackage.sj2;
import defpackage.tg3;
import defpackage.tn;
import defpackage.ug3;
import defpackage.yj;
import defpackage.zi2;
import java.io.File;
import java.util.List;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes.dex */
public final class BajiProtocolManager {
    private tn broadcastSender;
    private DeviceConnectionCallback connectionCallback;
    private Context context;
    private boolean isConnected;
    private boolean isInitialized;
    private boolean isSDKInitialized;
    private PacketReceiveCallback packetReceiveCallback;
    private PacketSendCallback packetSendCallback;
    private SDKEventListener sdkEventListener;
    private final FileTransferService fileTransferService = new FileTransferService();
    private final MediaManagementService mediaManagementService = new MediaManagementService();
    private final SystemInfoService systemInfoService = new SystemInfoService();
    private final CoroutineScope managerScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    private final b bleRawDataListener = new b();

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ModuleId.values().length];
            try {
                iArr[ModuleId.FILE_TRANSFER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ModuleId.MEDIA_MANAGEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ModuleId.SYSTEM_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final class b implements yj {
        b() {
        }

        @Override // defpackage.yj
        public void a(byte[] bArr, UUID uuid, String str, long j, int i, boolean z) {
            p31.f(bArr, "data");
            p31.f(uuid, "uuid");
            p31.f(str, "macAddress");
            BajiProtocolManager.this.handleReceivedPacket(bArr);
        }

        @Override // defpackage.yj
        public void b(int i, String str, String str2, UUID uuid) {
            p31.f(str, "errorMessage");
            p31.f(str2, "macAddress");
            BajiProtocolManager.this.sendBroadcastEvent(new SystemErrorEvent(ErrorCode.UNKNOWN_ERROR, "BLE数据错误: " + i + " - " + str, null, 4, null));
        }

        @Override // defpackage.yj
        public void c(boolean z, String str, int i) {
            p31.f(str, "macAddress");
            BajiProtocolManager.this.isConnected = z;
            DeviceConnectionCallback deviceConnectionCallback = BajiProtocolManager.this.connectionCallback;
            if (deviceConnectionCallback != null) {
                deviceConnectionCallback.onConnectionChanged(z, str);
            }
        }
    }

    public static final class c implements TransferProgressCallback {
        c() {
        }

        @Override // com.baji.protocol.service.TransferProgressCallback
        public void onProgress(TransferProgress transferProgress) {
            p31.f(transferProgress, "progress");
            BajiProtocolManager.this.sendBroadcastEvent(new FileTransferProgressEvent(transferProgress));
        }
    }

    public static final class d implements TransferStatusCallback {
        d() {
        }

        @Override // com.baji.protocol.service.TransferStatusCallback
        public void onStatusChanged(TransferStatusInfo transferStatusInfo) {
            p31.f(transferStatusInfo, "statusInfo");
            BajiProtocolManager.this.sendBroadcastEvent(new FileTransferStatusEvent(transferStatusInfo));
        }
    }

    public static final class e implements TransferErrorCallback {
        e() {
        }

        @Override // com.baji.protocol.service.TransferErrorCallback
        public void onError(long j, ErrorCode errorCode, String str) {
            p31.f(errorCode, "errorCode");
            p31.f(str, "message");
            BajiProtocolManager.this.sendBroadcastEvent(new FileTransferErrorEvent(j, errorCode, str));
        }
    }

    public static final class f implements MediaManagementCallback {
        f() {
        }

        @Override // com.baji.protocol.service.MediaManagementCallback
        public void onBackgroundReceived(long j, BackgroundInfo backgroundInfo) {
            BajiProtocolManager.this.sendBroadcastEvent(new MediaBackgroundEvent(j, backgroundInfo));
        }

        @Override // com.baji.protocol.service.MediaManagementCallback
        public void onBatchPreviewReceived(BatchPreviewInfo batchPreviewInfo) {
            p31.f(batchPreviewInfo, "batchInfo");
            BajiProtocolManager.this.sendBroadcastEvent(new BatchPreviewInfoEvent(batchPreviewInfo));
        }

        @Override // com.baji.protocol.service.MediaManagementCallback
        public void onError(String str, Long l, ErrorCode errorCode, String str2) {
            p31.f(str, "operation");
            p31.f(errorCode, "errorCode");
            p31.f(str2, "message");
            BajiProtocolManager.this.sendBroadcastEvent(new MediaManagementErrorEvent(str, l, errorCode, str2));
        }

        @Override // com.baji.protocol.service.MediaManagementCallback
        public void onMediaDeleted(long j, boolean z, String str) {
            p31.f(str, "message");
            BajiProtocolManager.this.sendBroadcastEvent(new MediaDeleteEvent(j, z, str));
        }

        @Override // com.baji.protocol.service.MediaManagementCallback
        public void onMediaIdAllocated(long j, boolean z, String str) {
            p31.f(str, "message");
            BajiProtocolManager.this.sendBroadcastEvent(new MediaIdAllocationEvent(j, z, str));
            BajiProtocolManager.this.fileTransferService.handleMediaIdAllocation(j, z, str);
        }

        @Override // com.baji.protocol.service.MediaManagementCallback
        public void onMediaInfoReceived(MediaFileInfo mediaFileInfo) {
            BajiProtocolManager.this.sendBroadcastEvent(new MediaInfoEvent(mediaFileInfo));
        }

        @Override // com.baji.protocol.service.MediaManagementCallback
        public void onMediaListReceived(List list) {
            p31.f(list, "mediaList");
            BajiProtocolManager.this.sendBroadcastEvent(new MediaListUpdateEvent(list));
        }

        @Override // com.baji.protocol.service.MediaManagementCallback
        public void onPreviewReceived(long j, PreviewInfo previewInfo) {
            BajiProtocolManager.this.sendBroadcastEvent(new MediaPreviewEvent(j, previewInfo));
        }
    }

    public static final class g implements SystemInfoCallback {
        g() {
        }

        @Override // com.baji.protocol.service.SystemInfoCallback
        public void onCapabilityReceived(List list, long j, List list2) {
            p31.f(list, "supportedFileTypes");
            p31.f(list2, "features");
            BajiProtocolManager.this.sendBroadcastEvent(new DeviceCapabilityEvent(list, j, list2));
        }

        @Override // com.baji.protocol.service.SystemInfoCallback
        public void onDeviceInfoReceived(DeviceInfo deviceInfo) {
            BajiProtocolManager.this.sendBroadcastEvent(new DeviceInfoEvent(deviceInfo));
        }

        @Override // com.baji.protocol.service.SystemInfoCallback
        public void onError(ErrorCode errorCode, String str) {
            p31.f(errorCode, "errorCode");
            p31.f(str, "message");
            BajiProtocolManager.this.sendBroadcastEvent(new SystemErrorEvent(errorCode, str, null, 4, null));
        }

        @Override // com.baji.protocol.service.SystemInfoCallback
        public void onStorageStatusReceived(long j, long j2) {
            BajiProtocolManager.this.sendBroadcastEvent(new DeviceStorageEvent(j, j2, j - j2));
        }
    }

    public static final class h implements tg3.b {
        h() {
        }

        @Override // tg3.b
        public void a(ng ngVar) {
            BajiProtocolManager.this.handleSDKEvent(ngVar);
        }
    }

    public static final class i implements i10.b {
        i() {
        }

        @Override // i10.b
        public void a(String str, String str2) {
            p31.f(str, "tag");
            p31.f(str2, "log");
            Log.d("BajiProtocol", '[' + str + "] " + str2);
        }
    }

    public static /* synthetic */ void cancelFileTransfer$default(BajiProtocolManager bajiProtocolManager, long j, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "User cancelled";
        }
        bajiProtocolManager.cancelFileTransfer(j, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSDKEvent(ng ngVar) {
        SDKEventListener sDKEventListener = this.sdkEventListener;
        if (sDKEventListener != null) {
            sDKEventListener.onSDKEvent(ngVar);
        }
        if (ngVar instanceof o10) {
            o10 o10Var = (o10) ngVar;
            int iA = o10Var.a();
            if (iA == BluetoothStatusEnum.CONNECTED.getValue()) {
                this.isConnected = true;
                DeviceConnectionCallback deviceConnectionCallback = this.connectionCallback;
                if (deviceConnectionCallback != null) {
                    deviceConnectionCallback.onConnectionChanged(true, o10Var.getMacAddress());
                }
                setConnectionStatus(true, o10Var.getMacAddress(), ug3.d());
                return;
            }
            if (iA != BluetoothStatusEnum.DISCONNECT.getValue()) {
                if (iA == BluetoothStatusEnum.CONNECT_FAILED.getValue()) {
                    this.isConnected = false;
                    return;
                }
                return;
            } else {
                this.isConnected = false;
                DeviceConnectionCallback deviceConnectionCallback2 = this.connectionCallback;
                if (deviceConnectionCallback2 != null) {
                    deviceConnectionCallback2.onConnectionChanged(false, o10Var.getMacAddress());
                    return;
                }
                return;
            }
        }
        if (ngVar instanceof aa0) {
            boolean zK = ((aa0) ngVar).k();
            Log.i("BajiProtocol", "handleSDKEvent: 广告显示状态:" + zK);
            sj2.h("show_adv", zK ? "1" : "0");
            return;
        }
        String str = "收到SDK事件: " + (ngVar != null ? ngVar.getClass().getSimpleName() : "UnknownEvent");
        Log.d("BajiProtocol", str);
        sendBroadcastEvent(new SystemErrorEvent(ErrorCode.SUCCESS, str, null, 4, null));
        PacketReceiveCallback packetReceiveCallback = this.packetReceiveCallback;
        if (packetReceiveCallback != null) {
            packetReceiveCallback.onPacketReceived(new byte[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialize$lambda$0(BajiProtocolManager bajiProtocolManager, byte[] bArr, String str) {
        p31.f(bArr, "data");
        p31.f(str, SocialConstants.PARAM_COMMENT);
        return bajiProtocolManager.sendDataToDevice(bArr, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialize$lambda$1(BajiProtocolManager bajiProtocolManager, byte[] bArr, String str) {
        p31.f(bArr, "data");
        p31.f(str, SocialConstants.PARAM_COMMENT);
        return bajiProtocolManager.sendDataToDevice(bArr, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initialize$lambda$2(BajiProtocolManager bajiProtocolManager, byte[] bArr, String str) {
        p31.f(bArr, "data");
        p31.f(str, SocialConstants.PARAM_COMMENT);
        return bajiProtocolManager.sendDataToDevice(bArr, str);
    }

    private final void initializeMyWatchSDK(Context context) {
        try {
            i10 i10VarM = new i10().o(true).p(30).l(this.bleRawDataListener).n(30).m(new i());
            tg3 tg3VarV = tg3.g.d().o((Application) context.getApplicationContext()).v(new h());
            p31.c(i10VarM);
            tg3VarV.t(i10VarM);
            this.isSDKInitialized = true;
            sendBroadcastEvent(new SystemErrorEvent(ErrorCode.SUCCESS, "MyWatch SDK初始化成功", null, 4, null));
        } catch (Exception e2) {
            sendBroadcastEvent(new SystemErrorEvent(ErrorCode.UNKNOWN_ERROR, "MyWatch SDK初始化失败: " + e2.getMessage(), null, 4, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendBroadcastEvent(BajiBaseEvent bajiBaseEvent) {
        tn tnVar = this.broadcastSender;
        if (tnVar != null) {
            tnVar.g(bajiBaseEvent);
        }
    }

    public static /* synthetic */ boolean sendDataToDevice$default(BajiProtocolManager bajiProtocolManager, byte[] bArr, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "电子吧唧协议数据";
        }
        return bajiProtocolManager.sendDataToDevice(bArr, str);
    }

    private final void setConnectionStatus(boolean z, String str, String str2) {
        this.isConnected = z;
        DeviceConnectionEvent deviceConnectionEvent = new DeviceConnectionEvent(z, str2, 0L, 4, null);
        deviceConnectionEvent.setMacAddress(str);
        sendBroadcastEvent(deviceConnectionEvent);
        DeviceConnectionCallback deviceConnectionCallback = this.connectionCallback;
        if (deviceConnectionCallback != null) {
            deviceConnectionCallback.onConnectionChanged(z, str2);
        }
    }

    static /* synthetic */ void setConnectionStatus$default(BajiProtocolManager bajiProtocolManager, boolean z, String str, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        bajiProtocolManager.setConnectionStatus(z, str, str2);
    }

    public final void cancelFileTransfer(long j, String str) {
        p31.f(str, "reason");
        this.fileTransferService.cancelTransfer(j, str);
        sendBroadcastEvent(new FileTransferCancelEvent(j, str));
    }

    public final void cleanup() {
        CoroutineScopeKt.cancel$default(this.managerScope, null, 1, null);
        this.fileTransferService.cleanup();
        this.mediaManagementService.cleanup();
        this.systemInfoService.cleanup();
        if (this.isSDKInitialized && this.isConnected) {
            try {
                zi2.b();
            } catch (Exception unused) {
            }
        }
        this.isSDKInitialized = false;
        this.isInitialized = false;
        this.isConnected = false;
    }

    public final void connectDevice(String str) {
        p31.f(str, "macAddress");
        if (!this.isSDKInitialized) {
            sendBroadcastEvent(new SystemErrorEvent(ErrorCode.DEVICE_BUSY, "SDK未初始化", null, 4, null));
            return;
        }
        try {
            zi2.a(str);
            sendBroadcastEvent(new SystemErrorEvent(ErrorCode.SUCCESS, "开始连接设备: " + str, null, 4, null));
        } catch (Exception e2) {
            sendBroadcastEvent(new SystemErrorEvent(ErrorCode.UNKNOWN_ERROR, "连接设备失败: " + e2.getMessage(), null, 4, null));
        }
    }

    public final void deleteMedia(long j) {
        if (this.isInitialized && this.isConnected) {
            this.mediaManagementService.deleteMedia(j);
        }
    }

    public final void disconnectDevice() {
        if (!this.isSDKInitialized) {
            sendBroadcastEvent(new SystemErrorEvent(ErrorCode.DEVICE_BUSY, "SDK未初始化", null, 4, null));
            return;
        }
        try {
            zi2.b();
            sendBroadcastEvent(new SystemErrorEvent(ErrorCode.SUCCESS, "断开设备连接", null, 4, null));
        } catch (Exception e2) {
            sendBroadcastEvent(new SystemErrorEvent(ErrorCode.UNKNOWN_ERROR, "断开连接失败: " + e2.getMessage(), null, 4, null));
        }
    }

    public final List<TransferStatusInfo> getTransferStatus() {
        return this.fileTransferService.getTransferStatus();
    }

    public final void handleReceivedPacket(byte[] bArr) {
        ModuleId moduleId;
        p31.f(bArr, "data");
        if (this.isInitialized) {
            ProtocolEncoder protocolEncoder = ProtocolEncoder.INSTANCE;
            PacketValidationResult packetValidationResultValidatePacket = protocolEncoder.validatePacket(bArr);
            if (!packetValidationResultValidatePacket.isValid()) {
                sendBroadcastEvent(new SystemErrorEvent(ErrorCode.INVALID_PACKET, packetValidationResultValidatePacket.getErrorMessage(), null, 4, null));
                return;
            }
            PacketParseResult packet = protocolEncoder.parsePacket(bArr);
            if (packet == null) {
                sendBroadcastEvent(new SystemErrorEvent(ErrorCode.INVALID_PACKET, "Invalid packet format", null, 4, null));
                return;
            }
            CommandHeader commandHeader = packet.getCommandHeader();
            byte[] payload = packet.getPayload();
            ModuleId[] moduleIdArrValues = ModuleId.values();
            int length = moduleIdArrValues.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    moduleId = null;
                    break;
                }
                moduleId = moduleIdArrValues[i2];
                if (moduleId.getValue() == commandHeader.getModuleId()) {
                    break;
                } else {
                    i2++;
                }
            }
            int i3 = moduleId == null ? -1 : a.a[moduleId.ordinal()];
            if (i3 == -1) {
                sendBroadcastEvent(new SystemErrorEvent(ErrorCode.UNSUPPORTED_COMMAND, "Unknown module ID: " + ((int) commandHeader.getModuleId()), null, 4, null));
            } else if (i3 == 1) {
                this.fileTransferService.handlePacket(commandHeader.getCommandId(), payload);
            } else if (i3 == 2) {
                this.mediaManagementService.handlePacket(commandHeader.getCommandId(), payload);
            } else {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                this.systemInfoService.handlePacket(commandHeader.getCommandId(), payload);
            }
            PacketReceiveCallback packetReceiveCallback = this.packetReceiveCallback;
            if (packetReceiveCallback != null) {
                packetReceiveCallback.onPacketReceived(bArr);
            }
        }
    }

    public final void initialize(Context context, tn tnVar, DeviceConnectionCallback deviceConnectionCallback, PacketSendCallback packetSendCallback, PacketReceiveCallback packetReceiveCallback, SDKEventListener sDKEventListener) {
        p31.f(context, "context");
        p31.f(tnVar, "broadcastSender");
        this.context = context;
        this.broadcastSender = tnVar;
        this.connectionCallback = deviceConnectionCallback;
        this.packetSendCallback = packetSendCallback;
        this.packetReceiveCallback = packetReceiveCallback;
        this.sdkEventListener = sDKEventListener;
        initializeMyWatchSDK(context);
        this.fileTransferService.initialize(new c(), new d(), new e(), packetSendCallback, new or0() { // from class: lf
            @Override // defpackage.or0
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(BajiProtocolManager.initialize$lambda$0(this.a, (byte[]) obj, (String) obj2));
            }
        }, this.mediaManagementService);
        this.mediaManagementService.initialize(new f(), packetSendCallback, new or0() { // from class: mf
            @Override // defpackage.or0
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(BajiProtocolManager.initialize$lambda$1(this.a, (byte[]) obj, (String) obj2));
            }
        });
        this.systemInfoService.initialize(new g(), packetSendCallback, new or0() { // from class: nf
            @Override // defpackage.or0
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(BajiProtocolManager.initialize$lambda$2(this.a, (byte[]) obj, (String) obj2));
            }
        });
        this.isInitialized = true;
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isDeviceConnected() {
        if (!this.isSDKInitialized) {
            return false;
        }
        try {
            return zi2.i();
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean isInitialized() {
        return this.isInitialized;
    }

    public final void requestDeviceCapability() {
        if (this.isInitialized && this.isConnected) {
            this.systemInfoService.requestDeviceCapability();
        }
    }

    public final void requestDeviceInfo() {
        if (this.isInitialized && this.isConnected) {
            this.systemInfoService.requestDeviceInfo();
        }
    }

    public final void requestMediaBackground(long j) {
        if (this.isInitialized && this.isConnected) {
            this.mediaManagementService.requestMediaBackground(j);
        }
    }

    public final void requestMediaId() {
        if (this.isInitialized && this.isConnected) {
            this.mediaManagementService.requestMediaId();
        }
    }

    public final void requestMediaInfo(long j) {
        if (this.isInitialized && this.isConnected) {
            this.mediaManagementService.requestMediaInfo(j);
        }
    }

    public final void requestMediaList() {
        if (this.isInitialized && this.isConnected) {
            this.mediaManagementService.requestMediaList();
        }
    }

    public final void requestMediaPreview(long j) {
        if (this.isInitialized && this.isConnected) {
            this.mediaManagementService.requestMediaPreview(j);
        }
    }

    public final void requestStorageStatus() {
        if (this.isInitialized && this.isConnected) {
            this.systemInfoService.requestStorageStatus();
        }
    }

    public final boolean sendDataToDevice(byte[] bArr, String str) {
        p31.f(bArr, "data");
        p31.f(str, SocialConstants.PARAM_COMMENT);
        try {
            if (!this.isSDKInitialized) {
                sendBroadcastEvent(new SystemErrorEvent(ErrorCode.DEVICE_BUSY, "SDK未初始化", null, 4, null));
                return false;
            }
            if (!this.isConnected) {
                sendBroadcastEvent(new SystemErrorEvent(ErrorCode.DEVICE_BUSY, "设备未连接", null, 4, null));
                return false;
            }
            zi2.e().K(bArr, str);
            PacketSendCallback packetSendCallback = this.packetSendCallback;
            if (packetSendCallback != null) {
                packetSendCallback.onPacketSent(bArr);
            }
            return true;
        } catch (Exception e2) {
            PacketSendCallback packetSendCallback2 = this.packetSendCallback;
            if (packetSendCallback2 != null) {
                String message = e2.getMessage();
                if (message == null) {
                    message = "发送失败";
                }
                packetSendCallback2.onPacketSendFailed(bArr, message);
            }
            sendBroadcastEvent(new SystemErrorEvent(ErrorCode.UNKNOWN_ERROR, "数据发送失败: " + e2.getMessage(), null, 4, null));
            return false;
        }
    }

    public final void setSDKEventListener(SDKEventListener sDKEventListener) {
        this.sdkEventListener = sDKEventListener;
    }

    public final void startFileTransfer(int i2, long j, FileType fileType, FunctionType functionType, String str) {
        p31.f(fileType, "fileType");
        p31.f(functionType, "functionType");
        p31.f(str, "filePath");
        if (!this.isInitialized || !this.isConnected) {
            sendBroadcastEvent(new FileTransferErrorEvent(i2, ErrorCode.DEVICE_BUSY, "Not connected"));
            return;
        }
        String name = new File(str).getName();
        p31.e(name, "getName(...)");
        sendBroadcastEvent(new FileTransferStartEvent(new FileInfo(i2, name, j, fileType, 0, System.currentTimeMillis(), null, str, 64, null)));
        this.fileTransferService.startTransfer(i2, j, fileType, functionType, str);
    }

    public final void stopFileTransfer(long j) {
        this.fileTransferService.stopTransfer(j);
    }

    public final void startFileTransfer(TransferFileInfo transferFileInfo) {
        p31.f(transferFileInfo, "transferInfo");
        if (this.isInitialized && this.isConnected) {
            long mediaId = transferFileInfo.getMediaId();
            String name = new File(transferFileInfo.getFilePath()).getName();
            p31.e(name, "getName(...)");
            sendBroadcastEvent(new FileTransferStartEvent(new FileInfo(mediaId, name, transferFileInfo.getFileSize(), transferFileInfo.getFileType(), 0, System.currentTimeMillis(), null, transferFileInfo.getFilePath(), 64, null)));
            this.fileTransferService.startTransfer(transferFileInfo);
            return;
        }
        sendBroadcastEvent(new FileTransferErrorEvent(transferFileInfo.getMediaId(), ErrorCode.DEVICE_BUSY, "Not connected"));
    }
}
