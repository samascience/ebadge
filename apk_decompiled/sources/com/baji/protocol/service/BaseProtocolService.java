package com.baji.protocol.service;

import com.baji.protocol.model.ErrorCode;
import com.baji.protocol.model.ModuleId;
import com.baji.protocol.utils.ProtocolEncoder;
import defpackage.gx;
import defpackage.p31;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseProtocolService {
    private PacketSendCallback packetSendCallback;
    private final CoroutineScope serviceScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));

    private final byte[] buildErrorPayload(ErrorCode errorCode, String str) {
        byte[] bytes = str.getBytes(gx.b);
        p31.e(bytes, "getBytes(...)");
        byte[] bArr = new byte[bytes.length + 1];
        bArr[0] = errorCode.getValue();
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        return bArr;
    }

    public static /* synthetic */ void sendPacket$default(BaseProtocolService baseProtocolService, ModuleId moduleId, byte b, byte[] bArr, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendPacket");
        }
        if ((i & 4) != 0) {
            bArr = new byte[0];
        }
        baseProtocolService.sendPacket(moduleId, b, bArr);
    }

    public final void cleanup() {
        CoroutineScopeKt.cancel$default(this.serviceScope, null, 1, null);
    }

    public abstract ModuleId getModuleId();

    protected final PacketSendCallback getPacketSendCallback() {
        return this.packetSendCallback;
    }

    protected final CoroutineScope getServiceScope() {
        return this.serviceScope;
    }

    public abstract void handlePacket(byte b, byte[] bArr);

    public abstract void initialize(PacketSendCallback packetSendCallback);

    protected abstract boolean sendDataToDevice(byte[] bArr, String str);

    protected final void sendErrorResponse(byte b, ErrorCode errorCode, String str) {
        p31.f(errorCode, "errorCode");
        p31.f(str, "message");
        sendPacket(getModuleId(), b, buildErrorPayload(errorCode, str));
    }

    protected final void sendPacket(ModuleId moduleId, byte b, byte[] bArr) {
        p31.f(moduleId, "moduleId");
        p31.f(bArr, "payload");
        try {
            byte[] bArrBuildPacket = ProtocolEncoder.INSTANCE.buildPacket(moduleId.getValue(), b, bArr);
            if (sendDataToDevice(bArrBuildPacket, "电子吧唧协议数据")) {
                PacketSendCallback packetSendCallback = this.packetSendCallback;
                if (packetSendCallback != null) {
                    packetSendCallback.onPacketSent(bArrBuildPacket);
                }
            } else {
                PacketSendCallback packetSendCallback2 = this.packetSendCallback;
                if (packetSendCallback2 != null) {
                    packetSendCallback2.onPacketSendFailed(bArrBuildPacket, "发送失败");
                }
            }
        } catch (Exception e) {
            PacketSendCallback packetSendCallback3 = this.packetSendCallback;
            if (packetSendCallback3 != null) {
                byte[] bArr2 = new byte[0];
                String message = e.getMessage();
                if (message == null) {
                    message = "Unknown error";
                }
                packetSendCallback3.onPacketSendFailed(bArr2, message);
            }
        }
    }

    protected final void setPacketSendCallback(PacketSendCallback packetSendCallback) {
        this.packetSendCallback = packetSendCallback;
    }
}
