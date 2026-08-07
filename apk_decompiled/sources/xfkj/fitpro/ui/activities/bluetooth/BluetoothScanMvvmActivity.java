package xfkj.fitpro.ui.activities.bluetooth;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import cn.bertsir.zbar.Qr.ScanResult;
import cn.bertsir.zbar.QrConfig;
import com.blankj.utilcode.util.ToastUtils;
import com.legend.smartwatch.app.base.acitivity.BaseMvvmActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.a4;
import defpackage.ak;
import defpackage.ar0;
import defpackage.c3;
import defpackage.c4;
import defpackage.d4;
import defpackage.e4;
import defpackage.f4;
import defpackage.jk;
import defpackage.k83;
import defpackage.kr0;
import defpackage.p31;
import defpackage.q30;
import defpackage.vt1;
import defpackage.xr0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import xfkj.fitpro.model.BluetoothDeviceInfo;
import xfkj.fitpro.ui.activities.bluetooth.BluetoothScanMvvmActivity;
import xfkj.fitpro.ui.viewmodels.bluetooth.BluetoothScanViewModel;

/* JADX INFO: loaded from: classes4.dex */
public final class BluetoothScanMvvmActivity extends BaseMvvmActivity<c3, BluetoothScanViewModel> {
    private jk m;
    private final f4 n;
    private final f4 o;
    private final f4 p;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[BluetoothScanViewModel.ConnectionState.values().length];
            try {
                iArr[BluetoothScanViewModel.ConnectionState.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BluetoothScanViewModel.ConnectionState.CONNECT_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BluetoothScanViewModel.ConnectionState.SYNC_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BluetoothScanViewModel.ConnectionState.DISCONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BluetoothScanViewModel.ConnectionState.CONNECTING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
            int[] iArr2 = new int[BluetoothScanViewModel.SyncState.values().length];
            try {
                iArr2[BluetoothScanViewModel.SyncState.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[BluetoothScanViewModel.SyncState.SYNCING.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[BluetoothScanViewModel.SyncState.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[BluetoothScanViewModel.SyncState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            b = iArr2;
        }
    }

    static final class b implements vt1, xr0 {
        private final /* synthetic */ ar0 a;

        b(ar0 ar0Var) {
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

    public BluetoothScanMvvmActivity() {
        super(R.layout.activity_bluetooth_scan_mvvm);
        f4 f4VarRegisterForActivityResult = registerForActivityResult(new c4(), new a4() { // from class: nm
            @Override // defpackage.a4
            public final void a(Object obj) {
                BluetoothScanMvvmActivity.H0(this.a, (Map) obj);
            }
        });
        p31.e(f4VarRegisterForActivityResult, "registerForActivityResult(...)");
        this.n = f4VarRegisterForActivityResult;
        f4 f4VarRegisterForActivityResult2 = registerForActivityResult(new e4(), new a4() { // from class: pm
            @Override // defpackage.a4
            public final void a(Object obj) {
                BluetoothScanMvvmActivity.v0(this.a, (ActivityResult) obj);
            }
        });
        p31.e(f4VarRegisterForActivityResult2, "registerForActivityResult(...)");
        this.o = f4VarRegisterForActivityResult2;
        f4 f4VarRegisterForActivityResult3 = registerForActivityResult(new d4(), new a4() { // from class: qm
            @Override // defpackage.a4
            public final void a(Object obj) {
                BluetoothScanMvvmActivity.w0(this.a, (Boolean) obj);
            }
        });
        p31.e(f4VarRegisterForActivityResult3, "registerForActivityResult(...)");
        this.p = f4VarRegisterForActivityResult3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(BluetoothScanMvvmActivity bluetoothScanMvvmActivity) {
        bluetoothScanMvvmActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(BluetoothScanMvvmActivity bluetoothScanMvvmActivity) {
        bluetoothScanMvvmActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(BluetoothScanMvvmActivity bluetoothScanMvvmActivity) {
        bluetoothScanMvvmActivity.finish();
    }

    private final void D0(Map map) {
        Collection collectionValues = map.values();
        if (collectionValues == null || !collectionValues.isEmpty()) {
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                if (!((Boolean) it.next()).booleanValue()) {
                    ToastUtils.v(getString(R.string.bluetooth_permission_required), new Object[0]);
                    finish();
                    return;
                }
            }
        }
        x0();
    }

    private final void E0() {
        cn.bertsir.zbar.b.b().d(new QrConfig.a().e(getString(R.string.scan_qrcode_des)).p(true).q(true).r(true).o(false).c(0).h(getResources().getColor(R.color.theme_color)).i(2000).l(1).m(1).d(13).k(true).j(true).g(true).u(getString(R.string.scan_qrcode)).t(getResources().getColor(R.color.theme_color)).v(-1).s(false).b(false).f(true).n(1).a());
    }

    private final void F0(BluetoothDeviceInfo bluetoothDeviceInfo) {
        if (bluetoothDeviceInfo.isConnected()) {
            Z0(bluetoothDeviceInfo);
        } else if (bluetoothDeviceInfo.isConnecting()) {
            ToastUtils.v(getString(R.string.device_connecting), new Object[0]);
        } else {
            ((BluetoothScanViewModel) Y()).B(bluetoothDeviceInfo);
        }
    }

    private final void G0() {
        if (((BluetoothScanViewModel) Y()).z()) {
            if (q30.a(this, "android.permission.CAMERA") != 0) {
                this.p.a("android.permission.CAMERA");
            } else {
                b1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(BluetoothScanMvvmActivity bluetoothScanMvvmActivity, Map map) {
        p31.c(map);
        bluetoothScanMvvmActivity.D0(map);
    }

    private final void I0() {
        if (((BluetoothScanViewModel) Y()).Q()) {
            ((BluetoothScanViewModel) Y()).X();
        } else {
            ToastUtils.v(getString(R.string.bluetooth_not_available), new Object[0]);
            ((c3) I()).I.setRefreshing(false);
        }
    }

    private final void J0() {
        setTitle(R.string.bluetooth_scan_title);
        ((c3) I()).J.c.setOnClickListener(new View.OnClickListener() { // from class: rm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BluetoothScanMvvmActivity.K0(this.a, view);
            }
        });
        ((c3) I()).J.f.setVisibility(0);
        ((c3) I()).J.f.setImageResource(R.mipmap.equipment_qr_code_icon);
        ((c3) I()).J.f.setOnClickListener(new View.OnClickListener() { // from class: sm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BluetoothScanMvvmActivity.L0(this.a, view);
            }
        });
        ((c3) I()).I.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: tm
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                BluetoothScanMvvmActivity.M0(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(BluetoothScanMvvmActivity bluetoothScanMvvmActivity, View view) {
        bluetoothScanMvvmActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(BluetoothScanMvvmActivity bluetoothScanMvvmActivity, View view) {
        bluetoothScanMvvmActivity.G0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(BluetoothScanMvvmActivity bluetoothScanMvvmActivity) {
        bluetoothScanMvvmActivity.I0();
    }

    private final void N0() {
        ((BluetoothScanViewModel) Y()).G().i(this, new b(new ar0() { // from class: um
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BluetoothScanMvvmActivity.V0(this.a, (List) obj);
            }
        }));
        ((BluetoothScanViewModel) Y()).T().i(this, new b(new ar0() { // from class: vm
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BluetoothScanMvvmActivity.W0(this.a, (Boolean) obj);
            }
        }));
        ((BluetoothScanViewModel) Y()).F().i(this, new b(new ar0() { // from class: wm
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BluetoothScanMvvmActivity.O0(this.a, (BluetoothScanViewModel.ConnectionState) obj);
            }
        }));
        ((BluetoothScanViewModel) Y()).F().i(this, new b(new ar0() { // from class: dm
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BluetoothScanMvvmActivity.P0(this.a, (BluetoothScanViewModel.ConnectionState) obj);
            }
        }));
        ((BluetoothScanViewModel) Y()).K().i(this, new b(new ar0() { // from class: em
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BluetoothScanMvvmActivity.Q0(this.a, (Map) obj);
            }
        }));
        ((BluetoothScanViewModel) Y()).I().i(this, new b(new ar0() { // from class: fm
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BluetoothScanMvvmActivity.R0((String) obj);
            }
        }));
        ((BluetoothScanViewModel) Y()).E().i(this, new b(new ar0() { // from class: gm
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BluetoothScanMvvmActivity.S0(this.a, (BluetoothDeviceInfo) obj);
            }
        }));
        ((BluetoothScanViewModel) Y()).H().i(this, new b(new ar0() { // from class: hm
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BluetoothScanMvvmActivity.T0((String) obj);
            }
        }));
        ((BluetoothScanViewModel) Y()).S().i(this, new b(new ar0() { // from class: im
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BluetoothScanMvvmActivity.U0((Boolean) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 O0(BluetoothScanMvvmActivity bluetoothScanMvvmActivity, BluetoothScanViewModel.ConnectionState connectionState) {
        p31.c(connectionState);
        bluetoothScanMvvmActivity.z0(connectionState);
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 P0(BluetoothScanMvvmActivity bluetoothScanMvvmActivity, BluetoothScanViewModel.ConnectionState connectionState) {
        p31.c(connectionState);
        bluetoothScanMvvmActivity.e1(connectionState);
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 Q0(BluetoothScanMvvmActivity bluetoothScanMvvmActivity, Map map) {
        p31.c(map);
        bluetoothScanMvvmActivity.g1(map);
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 R0(String str) {
        if (str != null) {
            ToastUtils.v(str, new Object[0]);
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 S0(BluetoothScanMvvmActivity bluetoothScanMvvmActivity, BluetoothDeviceInfo bluetoothDeviceInfo) {
        if (bluetoothDeviceInfo != null) {
            ToastUtils.v(bluetoothScanMvvmActivity.getString(R.string.device_connected_success, bluetoothDeviceInfo.getDisplayName()), new Object[0]);
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 T0(String str) {
        if (str != null) {
            ToastUtils.v(str, new Object[0]);
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 U0(Boolean bool) {
        if (bool.booleanValue()) {
            Log.d("BluetoothScanMvvmActivity", "开始二维码扫描");
        } else {
            Log.d("BluetoothScanMvvmActivity", "结束二维码扫描");
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 V0(BluetoothScanMvvmActivity bluetoothScanMvvmActivity, List list) {
        jk jkVar = bluetoothScanMvvmActivity.m;
        if (jkVar == null) {
            p31.t("deviceAdapter");
            jkVar = null;
        }
        p31.c(list);
        jkVar.f(list);
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 W0(BluetoothScanMvvmActivity bluetoothScanMvvmActivity, Boolean bool) {
        ((c3) bluetoothScanMvvmActivity.I()).I.setRefreshing(bool.booleanValue());
        return k83.a;
    }

    private final void X0() {
        jk jkVar = null;
        this.m = new jk(null, new ar0() { // from class: cm
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BluetoothScanMvvmActivity.Y0(this.a, (BluetoothDeviceInfo) obj);
            }
        }, 1, null);
        RecyclerView recyclerView = ((c3) I()).H;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        jk jkVar2 = this.m;
        if (jkVar2 == null) {
            p31.t("deviceAdapter");
        } else {
            jkVar = jkVar2;
        }
        recyclerView.setAdapter(jkVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 Y0(BluetoothScanMvvmActivity bluetoothScanMvvmActivity, BluetoothDeviceInfo bluetoothDeviceInfo) {
        p31.f(bluetoothDeviceInfo, "device");
        bluetoothScanMvvmActivity.F0(bluetoothDeviceInfo);
        return k83.a;
    }

    private final void Z0(BluetoothDeviceInfo bluetoothDeviceInfo) {
        new androidx.appcompat.app.b.a(this).t(getString(R.string.disconnect_dialog_title)).i(getString(R.string.disconnect_dialog_message, bluetoothDeviceInfo.getDisplayName())).p(getString(R.string.disconnect_button), new DialogInterface.OnClickListener() { // from class: km
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                BluetoothScanMvvmActivity.a1(this.a, dialogInterface, i);
            }
        }).l(getString(R.string.cancel_button), null).v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(BluetoothScanMvvmActivity bluetoothScanMvvmActivity, DialogInterface dialogInterface, int i) {
        ((BluetoothScanViewModel) bluetoothScanMvvmActivity.Y()).C();
    }

    private final void b1() {
        if (!ak.j()) {
            ToastUtils.v(getString(R.string.bluetooth_not_enabled_error), new Object[0]);
            return;
        }
        ((BluetoothScanViewModel) Y()).a0(true);
        E0();
        cn.bertsir.zbar.b.b().e(this, new cn.bertsir.zbar.b.c() { // from class: jm
            @Override // cn.bertsir.zbar.b.c
            public final void a(ScanResult scanResult) {
                BluetoothScanMvvmActivity.c1(this.a, scanResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(BluetoothScanMvvmActivity bluetoothScanMvvmActivity, ScanResult scanResult) {
        Log.i("BluetoothScanMvvmActivity", "二维码扫描结果: " + (scanResult != null ? scanResult.content : null));
        ((BluetoothScanViewModel) bluetoothScanMvvmActivity.Y()).a0(false);
        ((BluetoothScanViewModel) bluetoothScanMvvmActivity.Y()).M(scanResult != null ? scanResult.content : null);
    }

    private final void d1() {
        if (((BluetoothScanViewModel) Y()).Q()) {
            ((BluetoothScanViewModel) Y()).c0();
        } else {
            ToastUtils.v(getString(R.string.bluetooth_not_available), new Object[0]);
        }
    }

    private final void e1(BluetoothScanViewModel.ConnectionState connectionState) {
        int i = a.a[connectionState.ordinal()];
        if (i == 1) {
            ((c3) I()).z.setVisibility(0);
            ((c3) I()).I.setVisibility(8);
        } else if (i == 3) {
            ((c3) I()).z.setVisibility(0);
            ((c3) I()).I.setVisibility(8);
        } else if (i != 5) {
            ((c3) I()).z.setVisibility(8);
            ((c3) I()).I.setVisibility(0);
        } else {
            ((c3) I()).z.setVisibility(0);
            ((c3) I()).I.setVisibility(8);
        }
    }

    private final void f1(TextView textView, BluetoothScanViewModel.SyncState syncState) {
        int i = syncState == null ? -1 : a.b[syncState.ordinal()];
        if (i == -1) {
            textView.setText(getString(R.string.reinfecta_txt));
            textView.setTextColor(getResources().getColor(R.color.gray));
            return;
        }
        if (i == 1) {
            textView.setText(getString(R.string.reinfecta_txt));
            textView.setTextColor(getResources().getColor(R.color.gray));
            return;
        }
        if (i == 2) {
            textView.setText(getString(R.string.setting));
            textView.setTextColor(getResources().getColor(R.color.scan_page_pass_color));
        } else if (i == 3) {
            textView.setText(getString(R.string.completed_txt));
            textView.setTextColor(getResources().getColor(R.color.scan_page_pass_color));
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            textView.setText(getString(R.string.failed_txt));
            textView.setTextColor(getResources().getColor(R.color.red));
        }
    }

    private final void g1(Map map) {
        TextView textView = ((c3) I()).F;
        p31.e(textView, "connectionStocks");
        f1(textView, (BluetoothScanViewModel.SyncState) map.get("connection"));
        Collection collectionValues = map.values();
        if (collectionValues == null || !collectionValues.isEmpty()) {
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((BluetoothScanViewModel.SyncState) it.next()) != BluetoothScanViewModel.SyncState.COMPLETED) {
                    return;
                }
            }
        }
        ((BluetoothScanViewModel) Y()).U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(BluetoothScanMvvmActivity bluetoothScanMvvmActivity, ActivityResult activityResult) {
        if (activityResult.b() == -1) {
            bluetoothScanMvvmActivity.d1();
        } else {
            ToastUtils.v(bluetoothScanMvvmActivity.getString(R.string.bluetooth_enable_required), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(BluetoothScanMvvmActivity bluetoothScanMvvmActivity, Boolean bool) {
        if (bool.booleanValue()) {
            bluetoothScanMvvmActivity.b1();
        } else {
            ToastUtils.v(bluetoothScanMvvmActivity.getString(R.string.camera_permission_required), new Object[0]);
        }
    }

    private final void x0() {
        if (ak.j()) {
            d1();
        } else {
            this.o.a(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));
        }
    }

    private final void y0() {
        int i = 0;
        if (Build.VERSION.SDK_INT >= 31) {
            String[] strArr = {"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_FINE_LOCATION"};
            ArrayList arrayList = new ArrayList();
            while (i < 3) {
                String str = strArr[i];
                if (q30.a(this, str) != 0) {
                    arrayList.add(str);
                }
                i++;
            }
            if (arrayList.isEmpty()) {
                x0();
                return;
            } else {
                this.n.a(strArr);
                return;
            }
        }
        String[] strArr2 = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        ArrayList arrayList2 = new ArrayList();
        while (i < 2) {
            String str2 = strArr2[i];
            if (q30.a(this, str2) != 0) {
                arrayList2.add(str2);
            }
            i++;
        }
        if (arrayList2.isEmpty()) {
            x0();
        } else {
            this.n.a(strArr2);
        }
    }

    private final void z0(BluetoothScanViewModel.ConnectionState connectionState) {
        int i = a.a[connectionState.ordinal()];
        if (i == 1) {
            ToastUtils.v(getString(R.string.device_connection_success), new Object[0]);
            ((c3) I()).getRoot().postDelayed(new Runnable() { // from class: lm
                @Override // java.lang.Runnable
                public final void run() {
                    BluetoothScanMvvmActivity.A0(this.a);
                }
            }, 1000L);
        } else if (i == 2) {
            ToastUtils.v(getString(R.string.device_connection_failed), new Object[0]);
            ((c3) I()).getRoot().postDelayed(new Runnable() { // from class: mm
                @Override // java.lang.Runnable
                public final void run() {
                    BluetoothScanMvvmActivity.B0(this.a);
                }
            }, 2000L);
        } else {
            if (i != 3) {
                return;
            }
            ToastUtils.v(getString(R.string.device_connection_success), new Object[0]);
            ((c3) I()).getRoot().postDelayed(new Runnable() { // from class: om
                @Override // java.lang.Runnable
                public final void run() {
                    BluetoothScanMvvmActivity.C0(this.a);
                }
            }, 1000L);
        }
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public int H() {
        return R.color.white;
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void N(Bundle bundle) {
        super.N(bundle);
        X0();
        J0();
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initData(Bundle bundle) {
        super.initData(bundle);
        N0();
        y0();
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ((BluetoothScanViewModel) Y()).d0();
        ((BluetoothScanViewModel) Y()).A();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (p31.a(((BluetoothScanViewModel) Y()).T().f(), Boolean.TRUE)) {
            ((BluetoothScanViewModel) Y()).W();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (((BluetoothScanViewModel) Y()).Q()) {
            Object objF = ((BluetoothScanViewModel) Y()).R().f();
            Boolean bool = Boolean.TRUE;
            if (p31.a(objF, bool)) {
                ((BluetoothScanViewModel) Y()).Z();
            } else {
                if (p31.a(((BluetoothScanViewModel) Y()).T().f(), bool)) {
                    return;
                }
                d1();
            }
        }
    }
}
