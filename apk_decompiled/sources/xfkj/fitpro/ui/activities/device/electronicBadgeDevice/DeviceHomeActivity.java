package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import com.baji.protocol.model.ProtocolConstants;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.iwellfitness.urllib.ManualUrlConfig;
import com.iwellfitness.urllib.UrlBuilderUtils;
import com.legend.sdk.cameralibray.Camera2Activity;
import com.legend.smartwatch.app.base.acitivity.BaseActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import defpackage.a4;
import defpackage.ar0;
import defpackage.d20;
import defpackage.e4;
import defpackage.ea;
import defpackage.ek;
import defpackage.f4;
import defpackage.g02;
import defpackage.gi0;
import defpackage.i02;
import defpackage.j3;
import defpackage.jf;
import defpackage.k83;
import defpackage.ng;
import defpackage.o10;
import defpackage.oy;
import defpackage.pv2;
import defpackage.py;
import defpackage.q2;
import defpackage.qm2;
import defpackage.rj2;
import defpackage.ug3;
import defpackage.v11;
import defpackage.wr2;
import defpackage.y90;
import defpackage.yq0;
import defpackage.zi2;
import defpackage.zm1;
import java.util.Objects;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import xfkj.fitpro.activity.ota.OTAHelper;
import xfkj.fitpro.activity.ota.OTAProxyUtils;
import xfkj.fitpro.activity.ota.event.OTAUpgradeEvent;
import xfkj.fitpro.activity.ota.manager.OTASDKManager;
import xfkj.fitpro.activity.ota.model.OTAInfo;
import xfkj.fitpro.activity.ota.utils.BleUtils;
import xfkj.fitpro.api.HttpHelper;
import xfkj.fitpro.model.Gps;
import xfkj.fitpro.ui.activities.bluetooth.BluetoothScanMvvmActivity;
import xfkj.fitpro.ui.activities.common.AboutActivity;
import xfkj.fitpro.ui.activities.debug.ProtocolDebugActivity;
import xfkj.fitpro.ui.activities.settings.MessageSettingActivity;

/* JADX INFO: loaded from: classes4.dex */
public class DeviceHomeActivity extends BaseActivity<j3> implements View.OnClickListener {
    private jf F;
    private f4 k;
    private v11 l;
    private View m;
    private View n;
    private TextView o;
    private TextView p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f397q;
    private TextView r;
    private Button s;
    private boolean t;
    private int u;
    private Handler v;
    private Runnable w;
    private Handler x;
    private Runnable y;
    private Class z;

    class a implements PermissionUtils.b {
        a() {
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onDenied() {
            ToastUtils.t(R.string.permission_refuse_tips);
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            DeviceHomeActivity.this.u0();
        }
    }

    class b implements PermissionUtils.b {
        b() {
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onDenied() {
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            DeviceHomeActivity.this.k.a(new Intent(((BaseActivity) DeviceHomeActivity.this).f, (Class<?>) BluetoothScanMvvmActivity.class));
        }
    }

    class c implements PermissionUtils.b {
        c() {
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onDenied() {
            Log.w("DeviceHomeActivity", "定位权限被拒绝，无法获取天气");
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            DeviceHomeActivity.this.b1();
        }
    }

    public DeviceHomeActivity() {
        super(R.layout.activity_device_home);
        this.t = false;
        this.u = -1;
    }

    private void A0() {
        OTAProxyUtils.registerOTAResultHandler(this, new yq0() { // from class: na0
            @Override // defpackage.yq0
            public final Object invoke() {
                return this.a.H0();
            }
        }, new ar0() { // from class: oa0
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return this.a.I0((String) obj);
            }
        }, new yq0() { // from class: da0
            @Override // defpackage.yq0
            public final Object invoke() {
                return this.a.J0();
            }
        }, true);
    }

    private void B0() {
        this.k = registerForActivityResult(new e4(), new a4() { // from class: ma0
            @Override // defpackage.a4
            public final void a(Object obj) {
                this.a.K0((ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(View view) {
        r0(PicturePushActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(View view) {
        r0(VideoPushActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(View view) {
        r0(SimultaneousTranslationActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(DialogInterface dialogInterface, int i) {
        PermissionUtils.y("CAMERA").m(new a()).z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(View view) {
        if (PermissionUtils.t("CAMERA")) {
            u0();
        } else {
            g02.n(null, new DialogInterface.OnClickListener() { // from class: ea0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.a.F0(dialogInterface, i);
                }
            }, getString(R.string.remote_photo), getString(R.string.camera_permission));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ k83 H0() {
        ToastUtils.u(getString(R.string.ota_upgrade_success));
        n0();
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ k83 I0(String str) {
        ToastUtils.u(getString(R.string.ota_upgrade_failed, str));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ k83 J0() {
        ToastUtils.u(getString(R.string.ota_upgrade_cancelled));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0(ActivityResult activityResult) {
        x0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(DialogInterface dialogInterface, int i) {
        if (zi2.i()) {
            zi2.m();
        } else {
            ToastUtils.u(getString(R.string.unconnected));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0() {
        if (this.t) {
            v0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0() {
        L();
        ToastUtils.u(getString(R.string.get_watchface_info_timeout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(DialogInterface dialogInterface, int i) {
        U0();
    }

    private void P0(boolean z, String str, int i) {
        d20.a = z ? 1 : 0;
        n0();
        if (!this.t || z) {
            return;
        }
        T0();
    }

    private void Q0(oy oyVar) {
        if (oyVar.a() != null && this.z != null) {
            t0();
            L();
            startActivity(new Intent(this.f, (Class<?>) this.z));
            this.z = null;
            return;
        }
        if (this.z != null) {
            t0();
            L();
            ToastUtils.u(getString(R.string.get_watchface_info_failed));
            this.z = null;
        }
    }

    private void R0(String str) {
        zm1.d0(str);
        n0();
    }

    private void S0(boolean z) {
        Runnable runnable;
        if (this.t) {
            this.t = false;
            L();
            Handler handler = this.v;
            if (handler != null && (runnable = this.w) != null) {
                handler.removeCallbacks(runnable);
            }
            if (!z) {
                ToastUtils.u(getString(R.string.device_unbind_failed_after_ack));
                return;
            }
            try {
                zi2.b();
                d1();
                s0();
                n0();
                ToastUtils.u(getString(R.string.device_unbind_success_after_ack));
            } catch (Exception e) {
                ToastUtils.u(getString(R.string.unbind_post_processing_failed, e.getMessage()));
            }
        }
    }

    private void T0() {
        try {
            zi2.t();
        } catch (Exception unused) {
        }
        try {
            d1();
            s0();
            n0();
            L();
            this.t = false;
            ToastUtils.u(getString(R.string.device_unbind_success));
        } catch (Exception e) {
            this.t = false;
            L();
            ToastUtils.u(getString(R.string.local_unbind_failed, e.getMessage()));
        }
    }

    private void U0() {
        try {
            V(getString(R.string.unbinding_device_please_wait));
            this.t = true;
            if (!zi2.i()) {
                T0();
                return;
            }
            try {
                zm1.b();
                this.u = w0(zi2.t());
                X0();
            } catch (Exception unused) {
                T0();
            }
        } catch (Exception e) {
            this.t = false;
            L();
            ToastUtils.u(getString(R.string.unbind_device_failed, e.getMessage()));
        }
    }

    private void V0() {
        try {
            Log.d("DeviceHomeActivity", "定位成功，开始请求天气数据");
            HttpHelper.g().j(false);
        } catch (Exception e) {
            Log.e("DeviceHomeActivity", "请求天气数据失败: " + e.getMessage(), e);
        }
    }

    private void W0() {
        new androidx.appcompat.app.b.a(this).s(R.string.device_reset_txt).h(R.string.confirm_reset_device_txt).o(R.string.ok, new DialogInterface.OnClickListener() { // from class: la0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.L0(dialogInterface, i);
            }
        }).k(R.string.cancel, null).v();
    }

    private void X0() {
        this.v = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() { // from class: fa0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.M0();
            }
        };
        this.w = runnable;
        this.v.postDelayed(runnable, ProtocolConstants.CONNECTION_TIMEOUT_MS);
    }

    private void Y0(Class cls) {
        this.z = cls;
        this.x = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() { // from class: ja0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.N0();
            }
        };
        this.y = runnable;
        this.x.postDelayed(runnable, ProtocolConstants.CONNECTION_TIMEOUT_MS);
    }

    private void Z0(OTAUpgradeEvent oTAUpgradeEvent) {
        OTAHelper.showLowBatteryTips(this, oTAUpgradeEvent.getOtaPath(), OTASDKManager.getInstance().getOTAInfo());
    }

    private void a1() {
        if (zm1.M()) {
            ((j3) this.g).F.setVisibility(0);
        } else {
            ((j3) this.g).F.setVisibility(8);
        }
        if (zm1.N()) {
            ((j3) this.g).P.setVisibility(0);
        } else {
            ((j3) this.g).P.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1() {
        try {
            if (this.F != null) {
                Log.d("DeviceHomeActivity", "开始定位以获取天气");
                this.F.d();
            } else {
                Log.e("DeviceHomeActivity", "定位工具未初始化");
            }
        } catch (Exception e) {
            Log.e("DeviceHomeActivity", "启动定位失败: " + e.getMessage(), e);
        }
    }

    private void c1() {
        String[] strArr = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
        if (i02.c()) {
            strArr = (String[]) ea.a(strArr, new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE"});
        }
        b bVar = new b();
        String string = getString(R.string.scan_blutooth_function);
        Objects.requireNonNull(strArr);
        g02.o(bVar, string, strArr);
    }

    private void d1() {
        try {
            OTAInfo oTAInfo = OTASDKManager.getInstance().getOTAInfo();
            String classicBluetoothMac = oTAInfo != null ? oTAInfo.getClassicBluetoothMac() : null;
            if (pv2.f(classicBluetoothMac)) {
                return;
            }
            BleUtils.unPairBRDevice(classicBluetoothMac);
        } catch (Exception e) {
            Log.w("DeviceHomeActivity", "unbindBRIfNeeded failed: " + e.getMessage());
        }
    }

    private void e1() {
        new androidx.appcompat.app.b.a(this).s(R.string.del_device_txt).h(R.string.confirm_remove_device_txt).o(R.string.ok, new DialogInterface.OnClickListener() { // from class: ka0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.O0(dialogInterface, i);
            }
        }).k(R.string.cancel, null).v();
    }

    private void n0() {
        String strD = rj2.d("bluetooth_name", Constants.STR_EMPTY);
        String strG = zm1.g();
        String strF = zm1.f();
        boolean zG = zm1.G();
        boolean zI = zi2.i();
        if (!zG) {
            View view = this.n;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.m;
            if (view2 != null) {
                view2.setVisibility(0);
                return;
            }
            return;
        }
        View view3 = this.m;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.n;
        if (view4 != null) {
            view4.setVisibility(0);
            TextView textView = this.o;
            if (textView != null) {
                textView.setText(strD);
            }
            TextView textView2 = this.p;
            if (textView2 != null) {
                textView2.setText(zI ? R.string.connection_state_connected : R.string.connection_state_disconnected);
            }
            TextView textView3 = this.r;
            if (textView3 != null) {
                textView3.setText(getString(R.string.device_version_txt) + ":" + strG);
            }
            TextView textView4 = this.f397q;
            if (textView4 != null) {
                if (pv2.f(strF)) {
                    strF = "N/A";
                }
                textView4.setText(strF);
            }
        }
    }

    private void p0() {
        if (!zm1.Q()) {
            Log.d("DeviceHomeActivity", "设备不支持天气功能，跳过天气同步");
        } else {
            if (!zm1.F()) {
                Log.d("DeviceHomeActivity", "距离上次天气同步时间不足，跳过天气同步");
                return;
            }
            g02.o(new c(), getString(R.string.scan_blutooth_function), "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");
        }
    }

    private void r0(Class cls) {
        if (!zi2.i()) {
            ToastUtils.u(getString(R.string.unconnected));
            return;
        }
        py pyVar = py.a;
        if (pyVar.b()) {
            startActivity(new Intent(this.f, (Class<?>) cls));
            return;
        }
        V(getString(R.string.query_clock_dial_info));
        pyVar.f();
        Y0(cls);
    }

    private void s0() {
        zm1.b0(Constants.STR_EMPTY);
        rj2.g("bluetooth_name", Constants.STR_EMPTY);
        zm1.a0(false);
        zm1.d0(Constants.STR_EMPTY);
        String strF = zm1.f();
        if (!pv2.f(strF)) {
            zm1.a(strF, Constants.STR_EMPTY);
        }
        d20.a = 0;
        rj2.b();
    }

    private void t0() {
        Runnable runnable;
        Handler handler = this.x;
        if (handler == null || (runnable = this.y) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        com.blankj.utilcode.util.a.m(Camera2Activity.class);
        if (d20.a == 1) {
            zi2.o(qm2.B(true), "开启拍照功能");
        }
    }

    private void v0() {
        Runnable runnable;
        if (this.t) {
            this.t = false;
            L();
            Handler handler = this.v;
            if (handler != null && (runnable = this.w) != null) {
                handler.removeCallbacks(runnable);
            }
            try {
                zi2.b();
                d1();
                s0();
                n0();
                ToastUtils.u(getString(R.string.force_unbind_success));
            } catch (Exception e) {
                ToastUtils.u(getString(R.string.force_unbind_failed, e.getMessage()));
            }
        }
    }

    private int w0(byte[] bArr) {
        if (bArr == null || bArr.length < 5) {
            return 0;
        }
        return gi0.a(bArr[3] & 255, (bArr.length >= 6 ? bArr[5] : bArr[4]) & 255);
    }

    private void x0() {
        n0();
    }

    private void y0() {
        v11 v11Var = this.l;
        this.m = v11Var.g;
        LinearLayout linearLayout = v11Var.e;
        this.n = linearLayout;
        this.o = (TextView) linearLayout.findViewById(R.id.tv_device_name);
        this.p = (TextView) this.n.findViewById(R.id.tv_device_connection_status);
        this.f397q = (TextView) this.n.findViewById(R.id.tv_device_mac_address);
        this.r = (TextView) this.n.findViewById(R.id.tv_device_version);
        this.s = (Button) this.n.findViewById(R.id.btn_unbind_device);
    }

    private void z0() {
        try {
            this.F = new jf(getApplication());
        } catch (Exception e) {
            Log.e("DeviceHomeActivity", "初始化定位工具失败: " + e.getMessage(), e);
        }
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initData(Bundle bundle) {
        this.l = ((j3) this.g).Q;
        y0();
        B0();
        A0();
        z0();
        n0();
        p0();
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initListener() {
        this.l.b.setOnClickListener(this);
        Button button = this.s;
        if (button != null) {
            button.setOnClickListener(this);
        }
        ((j3) this.g).M.setOnClickListener(this);
        ((j3) this.g).J.setOnClickListener(this);
        ((j3) this.g).N.setOnClickListener(this);
        ((j3) this.g).H.setOnClickListener(this);
        ((j3) this.g).O.setOnClickListener(this);
        ((j3) this.g).z.setOnClickListener(this);
        ((j3) this.g).L.setOnClickListener(this);
        ((j3) this.g).S.setOnClickListener(new View.OnClickListener() { // from class: ca0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.C0(view);
            }
        });
        ((j3) this.g).W.setOnClickListener(new View.OnClickListener() { // from class: ga0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.D0(view);
            }
        });
        ((j3) this.g).R.setOnClickListener(new View.OnClickListener() { // from class: ha0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.E0(view);
            }
        });
        ((j3) this.g).P.setOnClickListener(new View.OnClickListener() { // from class: ia0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.G0(view);
            }
        });
        ((j3) this.g).G.setOnClickListener(this);
        ((j3) this.g).I.setOnClickListener(this);
        ((j3) this.g).F.setOnClickListener(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onBluetoothAdapterStateEvent(ek ekVar) {
        if (ekVar.a()) {
            return;
        }
        P0(false, null, -1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.add_device) {
            c1();
            return;
        }
        if (view.getId() == R.id.btn_unbind_device) {
            e1();
            return;
        }
        if (view.getId() == R.id.cv_msg_push) {
            Intent intent = new Intent(this.f, (Class<?>) MessageSettingActivity.class);
            intent.putExtra("Title", getString(R.string.push_setting_txt));
            intent.putExtra(SocialConstants.PARAM_TYPE, R.string.push_setting_txt);
            startActivity(intent);
            return;
        }
        if (view.getId() == R.id.cv_find_device) {
            if (!zi2.i()) {
                Toast.makeText(this.f, getString(R.string.unconnected), 0).show();
                return;
            } else {
                Toast.makeText(this.f, getString(R.string.find_device_txt), 0).show();
                zi2.c();
                return;
            }
        }
        if (view.getId() == R.id.cv_online_upgrade) {
            q0();
            return;
        }
        if (view.getId() == R.id.cv_device_reset) {
            W0();
            return;
        }
        if (view.getId() == R.id.cv_protocol_debug) {
            com.blankj.utilcode.util.a.m(ProtocolDebugActivity.class);
            return;
        }
        if (view.getId() == R.id.cv_about) {
            com.blankj.utilcode.util.a.m(AboutActivity.class);
            return;
        }
        if (view.getId() == R.id.cv_manual) {
            String strBuildAppManualUrl = UrlBuilderUtils.buildAppManualUrl();
            Log.i("DeviceHomeActivity", "说明书:" + strBuildAppManualUrl);
            ManualUrlConfig.openUrl(this.f, strBuildAppManualUrl, getString(R.string.app_manual));
            return;
        }
        if (view.getId() == R.id.cv_device_manual) {
            if (pv2.f(zm1.q())) {
                ToastUtils.t(R.string.unconnected);
                return;
            }
            String strBuildDeviceManualUrl = UrlBuilderUtils.buildDeviceManualUrl();
            Log.i("DeviceHomeActivity", "设备说明书:" + strBuildDeviceManualUrl);
            ManualUrlConfig.openUrl(this.f, strBuildDeviceManualUrl, getString(R.string.equipment_instructions));
            return;
        }
        if (view.getId() != R.id.cv_faq_manual) {
            if (view.getId() == R.id.cv_common_contacts) {
                r0(SynContractsActivity.class);
            }
        } else {
            String strBuildFaqUrl = UrlBuilderUtils.buildFaqUrl();
            Log.i("DeviceHomeActivity", "FAQ:" + strBuildFaqUrl);
            ManualUrlConfig.openUrl(this.f, strBuildFaqUrl, getString(R.string.faq));
        }
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Runnable runnable;
        super.onDestroy();
        Handler handler = this.v;
        if (handler != null && (runnable = this.w) != null) {
            handler.removeCallbacks(runnable);
        }
        this.t = false;
        t0();
        this.z = null;
        OTAProxyUtils.unregisterOTAResultHandler();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLocationResult(Gps gps) {
        if (gps != null) {
            V0();
        }
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvents(ng ngVar) {
        if (ngVar instanceof q2) {
            q2 q2Var = (q2) ngVar;
            if (this.t && q2Var.a() == this.u) {
                S0(q2Var.c());
                return;
            }
            return;
        }
        if (ngVar instanceof o10) {
            o10 o10Var = (o10) ngVar;
            P0(o10Var.isConnected(), o10Var.getMacAddress(), o10Var.a());
            return;
        }
        if (ngVar instanceof wr2) {
            R0(((wr2) ngVar).a());
            return;
        }
        if (ngVar instanceof oy) {
            Q0((oy) ngVar);
        } else if (ngVar instanceof OTAUpgradeEvent) {
            Z0((OTAUpgradeEvent) ngVar);
        } else if (ngVar instanceof y90) {
            a1();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        a1();
    }

    public void q0() {
        if (pv2.f(ug3.c())) {
            ToastUtils.t(R.string.device_info_no_exist);
        } else if (NetworkUtils.c()) {
            OTAHelper.checkUpgrade(this);
        } else {
            ToastUtils.t(R.string.network_error);
        }
    }
}
