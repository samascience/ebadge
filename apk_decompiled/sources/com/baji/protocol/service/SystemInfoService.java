package com.baji.protocol.service;

import android.util.Log;
import com.baji.protocol.model.DeviceInfo;
import com.baji.protocol.model.ErrorCode;
import com.baji.protocol.model.FileType;
import com.baji.protocol.model.ModuleId;
import com.baji.protocol.model.SystemInfoCommand;
import com.baji.protocol.utils.ProtocolEncoder;
import com.tencent.open.SocialConstants;
import defpackage.gx;
import defpackage.or0;
import defpackage.p31;
import java.nio.charset.Charset;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes.dex */
public final class SystemInfoService extends BaseProtocolService {
    private or0 dataSender;
    private SystemInfoCallback systemCallback;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SystemInfoCommand.values().length];
            try {
                iArr[SystemInfoCommand.DEVICE_INFO_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SystemInfoCommand.DEVICE_INFO_RESPONSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void handleDeviceInfoRequest(byte[] bArr) {
        Log.d("SystemInfoService", "处理设备信息请求");
    }

    private final void handleDeviceInfoResponse(byte[] bArr) {
        try {
            DeviceInfo deviceInfo = parseDeviceInfo(bArr);
            SystemInfoCallback systemInfoCallback = this.systemCallback;
            if (systemInfoCallback != null) {
                systemInfoCallback.onDeviceInfoReceived(deviceInfo);
            }
        } catch (Exception e) {
            SystemInfoCallback systemInfoCallback2 = this.systemCallback;
            if (systemInfoCallback2 != null) {
                ErrorCode errorCode = ErrorCode.UNKNOWN_ERROR;
                String message = e.getMessage();
                if (message == null) {
                    message = "Parse error";
                }
                systemInfoCallback2.onError(errorCode, message);
            }
        }
    }

    public static /* synthetic */ void initialize$default(SystemInfoService systemInfoService, SystemInfoCallback systemInfoCallback, PacketSendCallback packetSendCallback, or0 or0Var, int i, Object obj) {
        if ((i & 1) != 0) {
            systemInfoCallback = null;
        }
        if ((i & 2) != 0) {
            packetSendCallback = null;
        }
        if ((i & 4) != 0) {
            or0Var = null;
        }
        systemInfoService.initialize(systemInfoCallback, packetSendCallback, or0Var);
    }

    private final DeviceInfo parseDeviceInfo(byte[] bArr) {
        int i;
        FileType fileType;
        if (bArr.length == 0) {
            return null;
        }
        ProtocolEncoder protocolEncoder = ProtocolEncoder.INSTANCE;
        int iBytesToInt = protocolEncoder.bytesToInt(bArr, 0);
        Charset charset = gx.b;
        String str = new String(bArr, 4, iBytesToInt, charset);
        int iBytesToInt2 = protocolEncoder.bytesToInt(bArr, 4 + iBytesToInt);
        int i2 = iBytesToInt + 8;
        String str2 = new String(bArr, i2, iBytesToInt2, charset);
        int i3 = i2 + iBytesToInt2;
        int iBytesToInt3 = protocolEncoder.bytesToInt(bArr, i3);
        int i4 = i3 + 4;
        String str3 = new String(bArr, i4, iBytesToInt3, charset);
        int i5 = i4 + iBytesToInt3;
        long jBytesToLong = protocolEncoder.bytesToLong(bArr, i5);
        long jBytesToLong2 = protocolEncoder.bytesToLong(bArr, i5 + 8);
        int iBytesToInt4 = protocolEncoder.bytesToInt(bArr, i5 + 16);
        int i6 = i5 + 20;
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        while (i7 < iBytesToInt4) {
            byte b = bArr[i6];
            FileType[] fileTypeArrValues = FileType.values();
            int length = fileTypeArrValues.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    i = iBytesToInt4;
                    fileType = null;
                    break;
                }
                FileType fileType2 = fileTypeArrValues[i8];
                i = iBytesToInt4;
                if (fileType2.getValue() == b) {
                    fileType = fileType2;
                    break;
                }
                i8++;
                iBytesToInt4 = i;
            }
            if (fileType != null) {
                arrayList.add(fileType);
            }
            i6++;
            i7++;
            iBytesToInt4 = i;
        }
        ProtocolEncoder protocolEncoder2 = ProtocolEncoder.INSTANCE;
        long jBytesToLong3 = protocolEncoder2.bytesToLong(bArr, i6);
        int iBytesToInt5 = protocolEncoder2.bytesToInt(bArr, i6 + 8);
        ArrayList arrayList2 = new ArrayList();
        int i9 = i6 + 12;
        int i10 = 0;
        while (i10 < iBytesToInt5) {
            int iBytesToInt6 = ProtocolEncoder.INSTANCE.bytesToInt(bArr, i9);
            int i11 = i9 + 4;
            arrayList2.add(new String(bArr, i11, iBytesToInt6, gx.b));
            i9 = i11 + iBytesToInt6;
            i10++;
            iBytesToInt5 = iBytesToInt5;
            jBytesToLong3 = jBytesToLong3;
        }
        return new DeviceInfo(str, str2, str3, jBytesToLong, jBytesToLong2, arrayList, jBytesToLong3, arrayList2);
    }

    @Override // com.baji.protocol.service.BaseProtocolService
    public ModuleId getModuleId() {
        return ModuleId.SYSTEM_INFO;
    }

    @Override // com.baji.protocol.service.BaseProtocolService
    public void handlePacket(byte b, byte[] bArr) {
        SystemInfoCommand systemInfoCommand;
        p31.f(bArr, "payload");
        SystemInfoCommand[] systemInfoCommandArrValues = SystemInfoCommand.values();
        int length = systemInfoCommandArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                systemInfoCommand = null;
                break;
            }
            systemInfoCommand = systemInfoCommandArrValues[i];
            if (systemInfoCommand.getValue() == b) {
                break;
            } else {
                i++;
            }
        }
        int i2 = systemInfoCommand == null ? -1 : WhenMappings.$EnumSwitchMapping$0[systemInfoCommand.ordinal()];
        if (i2 != -1) {
            if (i2 == 1) {
                handleDeviceInfoRequest(bArr);
                return;
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                handleDeviceInfoResponse(bArr);
                return;
            }
        }
        SystemInfoCallback systemInfoCallback = this.systemCallback;
        if (systemInfoCallback != null) {
            systemInfoCallback.onError(ErrorCode.UNSUPPORTED_COMMAND, "Unknown command: " + ((int) b));
        }
    }

    @Override // com.baji.protocol.service.BaseProtocolService
    public void initialize(PacketSendCallback packetSendCallback) {
        setPacketSendCallback(packetSendCallback);
    }

    public final void requestDeviceCapability() {
    }

    public final void requestDeviceInfo() {
        BaseProtocolService.sendPacket$default(this, ModuleId.SYSTEM_INFO, SystemInfoCommand.DEVICE_INFO_REQUEST.getValue(), null, 4, null);
    }

    public final void requestStorageStatus() {
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

    public final void initialize(SystemInfoCallback systemInfoCallback, PacketSendCallback packetSendCallback, or0 or0Var) {
        this.systemCallback = systemInfoCallback;
        setPacketSendCallback(packetSendCallback);
        this.dataSender = or0Var;
    }
}
