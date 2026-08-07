package xfkj.fitpro.ui.activities.debug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baji.protocol.event.BajiBaseEvent;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.legend.smartwatch.app.base.acitivity.BaseMvvmActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.ar0;
import defpackage.c92;
import defpackage.g02;
import defpackage.hg;
import defpackage.k83;
import defpackage.kr0;
import defpackage.p31;
import defpackage.p63;
import defpackage.tn;
import defpackage.v3;
import defpackage.v82;
import defpackage.vt1;
import defpackage.w82;
import defpackage.xr0;
import defpackage.y70;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import xfkj.fitpro.ui.activities.debug.ProtocolDebugActivity;
import xfkj.fitpro.ui.activities.debug.viewmodel.ProtocolDebugViewModel;

/* JADX INFO: loaded from: classes4.dex */
public final class ProtocolDebugActivity extends BaseMvvmActivity<v3, ProtocolDebugViewModel> implements tn {
    public static final a o = new a(null);
    private c92 m;
    private final ProtocolDebugActivity$broadcastReceiver$1 n;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements PermissionUtils.b {
        b() {
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onDenied() {
            ToastUtils.v("需要蓝牙权限才能使用协议调试功能", new Object[0]);
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            ProtocolDebugActivity.k0(ProtocolDebugActivity.this).D(v82.e.a);
        }
    }

    static final class c implements vt1, xr0 {
        private final /* synthetic */ ar0 a;

        c(ar0 ar0Var) {
            p31.f(ar0Var, "function");
            this.a = ar0Var;
        }

        @Override // defpackage.xr0
        public final kr0 a() {
            return this.a;
        }

        @Override // defpackage.vt1
        public final /* synthetic */ void b(Object obj) {
            this.a.invoke(obj);
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof vt1) && (obj instanceof xr0)) {
                return p31.a(a(), ((xr0) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [xfkj.fitpro.ui.activities.debug.ProtocolDebugActivity$broadcastReceiver$1] */
    public ProtocolDebugActivity() {
        super(R.layout.activity_protocol_debug);
        this.n = new BroadcastReceiver() { // from class: xfkj.fitpro.ui.activities.debug.ProtocolDebugActivity$broadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    this.a.n0(intent);
                }
            }
        };
    }

    private final void A0() {
        ((ProtocolDebugViewModel) Y()).C().i(this, new c(new ar0() { // from class: n82
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return ProtocolDebugActivity.B0(this.a, (w82) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 B0(ProtocolDebugActivity protocolDebugActivity, w82 w82Var) {
        if (w82Var != null) {
            protocolDebugActivity.F0(w82Var);
            protocolDebugActivity.H0(w82Var);
            protocolDebugActivity.G0(w82Var);
            protocolDebugActivity.E0(w82Var);
        }
        return k83.a;
    }

    private final void C0() {
        final String[] strArr = {"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        g02.n(null, new DialogInterface.OnClickListener() { // from class: l82
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ProtocolDebugActivity.D0(strArr, this, dialogInterface, i);
            }
        }, "协议调试", "需要蓝牙权限来调试协议通信");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(String[] strArr, ProtocolDebugActivity protocolDebugActivity, DialogInterface dialogInterface, int i) {
        PermissionUtils.y((String[]) Arrays.copyOf(strArr, strArr.length)).m(protocolDebugActivity.new b()).z();
    }

    private final void E0(w82 w82Var) {
        String strC = w82Var.c();
        if (strC != null) {
            ToastUtils.v(strC, new Object[0]);
            ((ProtocolDebugViewModel) Y()).D(v82.a.a);
        }
    }

    private final void F0(w82 w82Var) {
        ((v3) I()).N.setText(w82Var.e() ? "已连接" : "未连接");
        ((v3) I()).N.setTextColor(getColor(w82Var.e() ? R.color.green : R.color.red));
        ((v3) I()).F.setEnabled(!w82Var.e());
        ((v3) I()).G.setEnabled(w82Var.e());
    }

    private final void G0(w82 w82Var) {
        ((v3) I()).L.setVisibility(w82Var.f() ? 0 : 8);
    }

    private final void H0(w82 w82Var) {
        c92 c92Var = this.m;
        if (c92Var != null) {
            c92Var.e(w82Var.d());
        }
    }

    public static final /* synthetic */ ProtocolDebugViewModel k0(ProtocolDebugActivity protocolDebugActivity) {
        return (ProtocolDebugViewModel) protocolDebugActivity.Y();
    }

    private final void m0() {
        if (PermissionUtils.t((String[]) Arrays.copyOf(new String[]{"android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 4))) {
            ((ProtocolDebugViewModel) Y()).D(v82.e.a);
        } else {
            C0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(Intent intent) {
        Bundle extras = intent.getExtras();
        Serializable serializable = extras != null ? extras.getSerializable("Datas") : null;
        Map map = p63.d(serializable) ? (Map) serializable : null;
        Object obj = map != null ? map.get("event") : null;
        BajiBaseEvent bajiBaseEvent = obj instanceof BajiBaseEvent ? (BajiBaseEvent) obj : null;
        Log.d(K(), "收到协议事件: " + (bajiBaseEvent != null ? bajiBaseEvent.getClass().getSimpleName() : null));
        ((ProtocolDebugViewModel) Y()).E(bajiBaseEvent);
    }

    private final void o0(v82 v82Var) {
        if (v82Var instanceof v82.i) {
            ToastUtils.v("错误: " + ((v82.i) v82Var).a(), new Object[0]);
        }
    }

    private final void p0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baji.protocol.FILE_TRANSFER_START");
        intentFilter.addAction("com.baji.protocol.FILE_TRANSFER_PROGRESS");
        intentFilter.addAction("com.baji.protocol.FILE_TRANSFER_COMPLETE");
        intentFilter.addAction("com.baji.protocol.MEDIA_LIST_UPDATE");
        intentFilter.addAction("com.baji.protocol.DEVICE_INFO");
        intentFilter.addAction("com.baji.protocol.SYSTEM_ERROR");
        registerReceiver(this.n, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(ProtocolDebugActivity protocolDebugActivity, View view) {
        protocolDebugActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(ProtocolDebugActivity protocolDebugActivity, View view) {
        ((ProtocolDebugViewModel) protocolDebugActivity.Y()).D(v82.c.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(ProtocolDebugActivity protocolDebugActivity, View view) {
        ((ProtocolDebugViewModel) protocolDebugActivity.Y()).D(v82.d.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(ProtocolDebugActivity protocolDebugActivity, View view) {
        ((ProtocolDebugViewModel) protocolDebugActivity.Y()).D(v82.b.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(ProtocolDebugActivity protocolDebugActivity, View view) {
        ((ProtocolDebugViewModel) protocolDebugActivity.Y()).D(v82.h.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(ProtocolDebugActivity protocolDebugActivity, View view) {
        ((ProtocolDebugViewModel) protocolDebugActivity.Y()).D(v82.f.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(ProtocolDebugActivity protocolDebugActivity, View view) {
        ((ProtocolDebugViewModel) protocolDebugActivity.Y()).D(v82.g.a);
    }

    private final void x0() {
        this.m = new c92(new ArrayList());
        ((v3) I()).M.setLayoutManager(new LinearLayoutManager(this, 1, false));
        ((v3) I()).M.setAdapter(this.m);
    }

    private final void y0() {
        ((ProtocolDebugViewModel) Y()).A().i(this, new c(new ar0() { // from class: m82
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return ProtocolDebugActivity.z0(this.a, (v82) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 z0(ProtocolDebugActivity protocolDebugActivity, v82 v82Var) {
        if (v82Var != null) {
            protocolDebugActivity.o0(v82Var);
            ((ProtocolDebugViewModel) protocolDebugActivity.Y()).w();
        }
        return k83.a;
    }

    @Override // defpackage.tn
    public void g(BajiBaseEvent bajiBaseEvent) {
        p31.f(bajiBaseEvent, "event");
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("event", bajiBaseEvent);
            hg.d.e(linkedHashMap);
        } catch (Exception e) {
            Log.e(K(), "发送广播失败: " + e.getMessage());
        }
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initData(Bundle bundle) {
        x0();
        p0();
        m0();
        ((ProtocolDebugViewModel) Y()).J(this);
        A0();
        y0();
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initListener() {
        ((v3) I()).K.setOnClickListener(new View.OnClickListener() { // from class: o82
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProtocolDebugActivity.q0(this.a, view);
            }
        });
        ((v3) I()).F.setOnClickListener(new View.OnClickListener() { // from class: p82
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProtocolDebugActivity.r0(this.a, view);
            }
        });
        ((v3) I()).G.setOnClickListener(new View.OnClickListener() { // from class: q82
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProtocolDebugActivity.s0(this.a, view);
            }
        });
        ((v3) I()).z.setOnClickListener(new View.OnClickListener() { // from class: r82
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProtocolDebugActivity.t0(this.a, view);
            }
        });
        ((v3) I()).J.setOnClickListener(new View.OnClickListener() { // from class: s82
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProtocolDebugActivity.u0(this.a, view);
            }
        });
        ((v3) I()).H.setOnClickListener(new View.OnClickListener() { // from class: t82
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProtocolDebugActivity.v0(this.a, view);
            }
        });
        ((v3) I()).I.setOnClickListener(new View.OnClickListener() { // from class: u82
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProtocolDebugActivity.w0(this.a, view);
            }
        });
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.n);
        ((ProtocolDebugViewModel) Y()).u();
    }
}
