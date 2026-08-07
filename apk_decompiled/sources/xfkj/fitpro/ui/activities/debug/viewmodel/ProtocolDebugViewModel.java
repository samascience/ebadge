package xfkj.fitpro.ui.activities.debug.viewmodel;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.lifecycle.p;
import com.baji.protocol.BajiProtocolManager;
import com.baji.protocol.event.BajiBaseEvent;
import com.baji.protocol.event.DeviceInfoEvent;
import com.baji.protocol.event.MediaListUpdateEvent;
import com.baji.protocol.event.SystemErrorEvent;
import com.baji.protocol.model.FileType;
import com.baji.protocol.model.FunctionType;
import com.baji.protocol.model.TransferFileInfo;
import com.baji.protocol.service.DeviceConnectionCallback;
import com.baji.protocol.service.PacketReceiveCallback;
import com.baji.protocol.service.PacketSendCallback;
import com.baji.protocol.service.SDKEventListener;
import defpackage.ar0;
import defpackage.d92;
import defpackage.im1;
import defpackage.ng;
import defpackage.p31;
import defpackage.tn;
import defpackage.v82;
import defpackage.w82;
import defpackage.y70;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.j;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import xfkj.fitpro.ui.activities.debug.model.LogType;
import xfkj.fitpro.ui.activities.debug.viewmodel.ProtocolDebugViewModel;

/* JADX INFO: loaded from: classes4.dex */
public final class ProtocolDebugViewModel extends com.legend.smartwatch.app.base.viewmodel.a implements tn {
    public static final a s = new a(null);
    private final im1 m;
    private final im1 n;
    private final im1 o;
    private final im1 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BajiProtocolManager f396q;
    private long r;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements DeviceConnectionCallback {
        b() {
        }

        @Override // com.baji.protocol.service.DeviceConnectionCallback
        public void onConnectionChanged(boolean z, String str) {
            ProtocolDebugViewModel.this.K(z, str);
        }
    }

    public static final class c implements PacketSendCallback {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence c(byte b) {
            String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            p31.e(str, "format(...)");
            return str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence d(byte b) {
            String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            p31.e(str, "format(...)");
            return str;
        }

        @Override // com.baji.protocol.service.PacketSendCallback
        public void onPacketSendFailed(byte[] bArr, String str) {
            p31.f(bArr, "data");
            p31.f(str, "error");
            ProtocolDebugViewModel protocolDebugViewModel = ProtocolDebugViewModel.this;
            protocolDebugViewModel.t(new d92(protocolDebugViewModel.B(), LogType.ERROR, System.currentTimeMillis(), "数据包发送失败", "错误: " + str, kotlin.collections.d.z(bArr, " ", null, null, 0, null, new ar0() { // from class: x82
                @Override // defpackage.ar0
                public final Object invoke(Object obj) {
                    return ProtocolDebugViewModel.c.c(((Byte) obj).byteValue());
                }
            }, 30, null)));
        }

        @Override // com.baji.protocol.service.PacketSendCallback
        public void onPacketSent(byte[] bArr) {
            p31.f(bArr, "data");
            ProtocolDebugViewModel protocolDebugViewModel = ProtocolDebugViewModel.this;
            protocolDebugViewModel.t(new d92(protocolDebugViewModel.B(), LogType.SEND, System.currentTimeMillis(), "数据包发送成功", "数据长度: " + bArr.length + " 字节", kotlin.collections.d.z(bArr, " ", null, null, 0, null, new ar0() { // from class: y82
                @Override // defpackage.ar0
                public final Object invoke(Object obj) {
                    return ProtocolDebugViewModel.c.d(((Byte) obj).byteValue());
                }
            }, 30, null)));
        }
    }

    public static final class d implements PacketReceiveCallback {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence b(byte b) {
            String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            p31.e(str, "format(...)");
            return str;
        }

        @Override // com.baji.protocol.service.PacketReceiveCallback
        public void onPacketReceived(byte[] bArr) {
            p31.f(bArr, "data");
            ProtocolDebugViewModel protocolDebugViewModel = ProtocolDebugViewModel.this;
            protocolDebugViewModel.t(new d92(protocolDebugViewModel.B(), LogType.RECEIVE, System.currentTimeMillis(), "接收到数据包", "数据长度: " + bArr.length + " 字节", kotlin.collections.d.z(bArr, " ", null, null, 0, null, new ar0() { // from class: z82
                @Override // defpackage.ar0
                public final Object invoke(Object obj) {
                    return ProtocolDebugViewModel.d.b(((Byte) obj).byteValue());
                }
            }, 30, null)));
            BajiProtocolManager bajiProtocolManager = ProtocolDebugViewModel.this.f396q;
            if (bajiProtocolManager != null) {
                bajiProtocolManager.handleReceivedPacket(bArr);
            }
        }
    }

    public static final class e implements SDKEventListener {
        e() {
        }

        @Override // com.baji.protocol.service.SDKEventListener
        public void onSDKEvent(ng ngVar) {
            if (ngVar != null) {
                ProtocolDebugViewModel protocolDebugViewModel = ProtocolDebugViewModel.this;
                protocolDebugViewModel.t(new d92(protocolDebugViewModel.B(), LogType.INFO, System.currentTimeMillis(), "SDK事件: " + ngVar.getClass().getSimpleName(), "事件详情: " + ngVar, null, 32, null));
            }
        }
    }

    public ProtocolDebugViewModel() {
        im1 im1Var = new im1(new w82(false, null, null, null, null, false, null, 127, null));
        this.m = im1Var;
        this.n = im1Var;
        im1 im1Var2 = new im1();
        this.o = im1Var2;
        this.p = im1Var2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long B() {
        long j = this.r + 1;
        this.r = j;
        return j;
    }

    private final void F() {
        w82 w82Var = (w82) this.m.f();
        w82 w82Var2 = w82Var == null ? new w82(false, null, null, null, null, false, null, 127, null) : w82Var;
        this.m.o(w82.b(w82Var2, false, null, null, null, null, true, null, 95, null));
        try {
            t(new d92(B(), LogType.INFO, System.currentTimeMillis(), "等待Context设置", "协议管理器将在Activity中初始化", null, 32, null));
            this.m.o(w82.b(w82Var2, false, null, null, null, null, false, null, 95, null));
        } catch (Exception e2) {
            com.legend.smartwatch.app.base.viewmodel.a.k(this, "协议管理器初始化失败: " + e2.getMessage(), null, 2, null);
            this.m.o(w82.b(w82Var2, false, null, null, null, null, false, "协议初始化失败: " + e2.getMessage(), 31, null));
        }
    }

    private final void G() {
        w82 w82Var = (w82) this.m.f();
        if (w82Var == null) {
            w82Var = new w82(false, null, null, null, null, false, null, 127, null);
        }
        if (!w82Var.e()) {
            this.o.o(new v82.i("设备未连接"));
            return;
        }
        t(new d92(B(), LogType.DEBUG, System.currentTimeMillis(), "请求设备信息", "发送设备信息查询命令", null, 32, null));
        BajiProtocolManager bajiProtocolManager = this.f396q;
        if (bajiProtocolManager != null) {
            bajiProtocolManager.requestDeviceInfo();
        }
    }

    private final void H() {
        w82 w82Var = (w82) this.m.f();
        if (w82Var == null) {
            w82Var = new w82(false, null, null, null, null, false, null, 127, null);
        }
        if (!w82Var.e()) {
            this.o.o(new v82.i("设备未连接"));
            return;
        }
        t(new d92(B(), LogType.DEBUG, System.currentTimeMillis(), "请求媒体列表", "发送媒体列表查询命令", null, 32, null));
        BajiProtocolManager bajiProtocolManager = this.f396q;
        if (bajiProtocolManager != null) {
            bajiProtocolManager.requestMediaList();
        }
    }

    private final void I() {
        w82 w82Var = (w82) this.m.f();
        if (w82Var == null) {
            w82Var = new w82(false, null, null, null, null, false, null, 127, null);
        }
        if (!w82Var.e()) {
            this.o.o(new v82.i("设备未连接"));
            return;
        }
        t(new d92(B(), LogType.DEBUG, System.currentTimeMillis(), "发送测试数据", "发送协议测试数据包", null, 32, null));
        TransferFileInfo transferFileInfo = new TransferFileInfo(-1, PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID, FileType.IMAGE, FunctionType.BACKGROUND, "/sdcard/test_debug.txt");
        BajiProtocolManager bajiProtocolManager = this.f396q;
        if (bajiProtocolManager != null) {
            bajiProtocolManager.startFileTransfer(transferFileInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(boolean z, String str) {
        w82 w82Var = (w82) this.m.f();
        if (w82Var == null) {
            w82Var = new w82(false, null, null, null, null, false, null, 127, null);
        }
        this.m.o(w82.b(w82Var, z, str, null, null, null, false, null, 124, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(d92 d92Var) {
        w82 w82Var = (w82) this.m.f();
        if (w82Var == null) {
            w82Var = new w82(false, null, null, null, null, false, null, 127, null);
        }
        w82 w82Var2 = w82Var;
        this.m.o(w82.b(w82Var2, false, null, j.R(w82Var2.d(), d92Var), null, null, false, null, 123, null));
    }

    private final void v() {
        w82 w82Var = (w82) this.m.f();
        if (w82Var == null) {
            w82Var = new w82(false, null, null, null, null, false, null, 127, null);
        }
        this.m.o(w82.b(w82Var, false, null, null, null, null, false, null, 63, null));
    }

    private final void x() {
        w82 w82Var = (w82) this.m.f();
        if (w82Var == null) {
            w82Var = new w82(false, null, null, null, null, false, null, 127, null);
        }
        this.m.o(w82.b(w82Var, false, null, j.j(), null, null, false, null, 123, null));
        t(new d92(B(), LogType.INFO, System.currentTimeMillis(), "日志已清空", "所有协议日志已被清除", null, 32, null));
    }

    private final void y() {
        w82 w82Var = (w82) this.m.f();
        if (w82Var == null) {
            w82Var = new w82(false, null, null, null, null, false, null, 127, null);
        }
        this.m.o(w82.b(w82Var, false, null, null, null, null, true, null, 95, null));
        t(new d92(B(), LogType.INFO, System.currentTimeMillis(), "开始连接设备", "正在搜索附近的蓝牙设备...", null, 32, null));
        BuildersKt__Builders_commonKt.launch$default(p.a(this), null, null, new ProtocolDebugViewModel$connectDevice$1(this, null), 3, null);
    }

    private final void z() {
        if (((w82) this.m.f()) == null) {
            new w82(false, null, null, null, null, false, null, 127, null);
        }
        long jB = B();
        LogType logType = LogType.INFO;
        t(new d92(jB, logType, System.currentTimeMillis(), "断开设备连接", "正在断开与设备的连接...", null, 32, null));
        BajiProtocolManager bajiProtocolManager = this.f396q;
        if (bajiProtocolManager != null) {
            bajiProtocolManager.disconnectDevice();
        }
        K(false, null);
        t(new d92(B(), logType, System.currentTimeMillis(), "设备已断开连接", "连接已断开", null, 32, null));
    }

    public final im1 A() {
        return this.p;
    }

    public final im1 C() {
        return this.n;
    }

    public final void D(v82 v82Var) {
        p31.f(v82Var, "event");
        if (v82Var instanceof v82.e) {
            F();
            return;
        }
        if (v82Var instanceof v82.c) {
            y();
            return;
        }
        if (v82Var instanceof v82.d) {
            z();
            return;
        }
        if (v82Var instanceof v82.h) {
            I();
            return;
        }
        if (v82Var instanceof v82.f) {
            G();
            return;
        }
        if (v82Var instanceof v82.g) {
            H();
            return;
        }
        if (v82Var instanceof v82.b) {
            x();
        } else if (v82Var instanceof v82.i) {
            this.o.o(v82Var);
        } else {
            if (!(v82Var instanceof v82.a)) {
                throw new NoWhenBranchMatchedException();
            }
            v();
        }
    }

    public final void E(BajiBaseEvent bajiBaseEvent) {
        if (bajiBaseEvent != null) {
            t(new d92(B(), LogType.RECEIVE, System.currentTimeMillis(), "协议事件: " + bajiBaseEvent.getClass().getSimpleName(), "事件数据: " + bajiBaseEvent, null, 32, null));
            if (bajiBaseEvent instanceof DeviceInfoEvent) {
                w82 w82Var = (w82) this.m.f();
                if (w82Var == null) {
                    w82Var = new w82(false, null, null, null, null, false, null, 127, null);
                }
                this.m.o(w82.b(w82Var, false, null, null, ((DeviceInfoEvent) bajiBaseEvent).getDeviceInfo(), null, false, null, 119, null));
                return;
            }
            if (!(bajiBaseEvent instanceof MediaListUpdateEvent)) {
                if (bajiBaseEvent instanceof SystemErrorEvent) {
                    this.o.o(new v82.i(((SystemErrorEvent) bajiBaseEvent).getErrorMessage()));
                }
            } else {
                w82 w82Var2 = (w82) this.m.f();
                if (w82Var2 == null) {
                    w82Var2 = new w82(false, null, null, null, null, false, null, 127, null);
                }
                this.m.o(w82.b(w82Var2, false, null, null, null, ((MediaListUpdateEvent) bajiBaseEvent).getMediaList(), false, null, 111, null));
            }
        }
    }

    public final void J(Context context) {
        p31.f(context, "context");
        try {
            BajiProtocolManager bajiProtocolManager = new BajiProtocolManager();
            bajiProtocolManager.initialize(context, this, new b(), new c(), new d(), new e());
            this.f396q = bajiProtocolManager;
            t(new d92(B(), LogType.INFO, System.currentTimeMillis(), "协议管理器初始化成功", "BajiProtocolManager已就绪", null, 32, null));
        } catch (Exception e2) {
            com.legend.smartwatch.app.base.viewmodel.a.k(this, "协议管理器初始化失败: " + e2.getMessage(), null, 2, null);
            t(new d92(B(), LogType.ERROR, System.currentTimeMillis(), "协议管理器初始化失败", "错误: " + e2.getMessage(), null, 32, null));
        }
    }

    @Override // defpackage.tn
    public void g(BajiBaseEvent bajiBaseEvent) {
        p31.f(bajiBaseEvent, "event");
        Log.d(h(), "发送广播事件: " + bajiBaseEvent.getClass().getSimpleName());
    }

    public final void u() {
        BajiProtocolManager bajiProtocolManager = this.f396q;
        if (bajiProtocolManager != null) {
            bajiProtocolManager.cleanup();
        }
        this.f396q = null;
    }

    public final void w() {
        this.o.o(null);
    }
}
