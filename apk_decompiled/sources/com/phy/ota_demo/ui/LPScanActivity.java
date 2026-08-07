package com.phy.ota_demo.ui;

import android.annotation.SuppressLint;
import android.bluetooth.le.ScanResult;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bertsir.zbar.Qr.Config;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.phy.ota_demo.R$color;
import com.phy.ota_demo.R$drawable;
import com.phy.ota_demo.R$id;
import com.phy.ota_demo.R$layout;
import com.phy.ota_demo.R$menu;
import com.phy.ota_demo.basic.PhyActivity;
import com.phy.ota_demo.ui.LPScanActivity;
import com.phy.otalib.scan.PhyReceiver;
import defpackage.a4;
import defpackage.c4;
import defpackage.d4;
import defpackage.dk;
import defpackage.e4;
import defpackage.f4;
import defpackage.fv1;
import defpackage.i5;
import defpackage.jr2;
import defpackage.o02;
import defpackage.q02;
import defpackage.q30;
import defpackage.qd2;
import defpackage.r02;
import defpackage.ss1;
import defpackage.t02;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"MissingPermission"})
public abstract class LPScanActivity extends PhyActivity implements View.OnClickListener, t02, qd2, fv1 {
    private static final String TAG = "LPScanActivity";
    private MaterialButton btnEnableBluetooth;
    private MaterialButton btnEnableLocation;
    private MaterialButton btnRequestConnectPermission;
    private MaterialButton btnRequestLocationPermission;
    private MaterialButton btnRequestScanPermission;
    private MaterialButton btnSubmit;
    private View emptyLay;
    private f4 enableBluetooth;
    private View enableBluetoothLay;
    private f4 enableLocation;
    private View enableLocationLay;
    private q02 mAdapter;
    private ss1 otaCore;
    private View requestBluetoothConnectLay;
    private View requestBluetoothScanLay;
    private f4 requestConnect;
    private f4 requestLocation;
    private View requestLocationLay;
    private f4 requestScan;
    private RecyclerView rvDevice;
    private i5 submitDialog;
    private TimerTask task;
    private long timeMillis;
    private Timer timer;
    private MaterialToolbar toolbar;
    private TextView tvOperateInfo;
    private TextView tvScanStatus;
    private final List<o02> mList = new ArrayList();
    private final List<o02> temporaryList = new ArrayList();
    private final List<o02> selectedList = new ArrayList();
    private long time = 20000;
    private final int MSG_JUMP = Config.Y_DENSITY;
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: x91
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.a.X(message);
        }
    });

    class a extends TimerTask {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            LPScanActivity lPScanActivity = LPScanActivity.this;
            lPScanActivity.U(lPScanActivity.temporaryList);
            LPScanActivity.this.temporaryList.clear();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LPScanActivity.this.runOnUiThread(new Runnable() { // from class: com.phy.ota_demo.ui.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b();
                }
            });
        }
    }

    private int T(o02 o02Var, List list) {
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (o02Var.h().equals(((o02) it.next()).b().getAddress())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(List list) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            o02 o02Var = (o02) list.get(i);
            int iT = T(o02Var, this.mList);
            if (iT == -1) {
                this.mList.add(new o02(o02Var.m(), o02Var.h(), o02Var.n(), jCurrentTimeMillis, o02Var.b()));
            } else {
                this.mList.get(iT).H(o02Var.n());
                this.mList.get(iT).A(jCurrentTimeMillis);
            }
            for (int i2 = 0; i2 < this.mList.size(); i2++) {
                if (jCurrentTimeMillis - this.time > this.mList.get(i2).g()) {
                    this.mList.remove(i2);
                }
            }
        }
        Collections.sort(this.mList, new Comparator() { // from class: y91
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return LPScanActivity.W((o02) obj, (o02) obj2);
            }
        });
        this.emptyLay.setVisibility(this.mList.size() > 0 ? 8 : 0);
        this.mAdapter.notifyDataSetChanged();
    }

    private void V() {
        this.timer = new Timer();
        this.task = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int W(o02 o02Var, o02 o02Var2) {
        return o02Var2.n() - o02Var.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean X(Message message) {
        if (257 != message.what) {
            return false;
        }
        i0();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(Boolean bool) {
        if (bool.booleanValue()) {
            showMsg("可以打开蓝牙");
        } else {
            showMsg("Android12 中不授予此权限无法打开蓝牙");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(ActivityResult activityResult) {
        if (activityResult.b() == -1) {
            showMsg("蓝牙已打开");
            this.otaCore.N(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(Map map) {
        Boolean bool = Boolean.TRUE;
        boolean zEquals = bool.equals(map.get("android.permission.ACCESS_COARSE_LOCATION"));
        boolean zEquals2 = bool.equals(map.get("android.permission.ACCESS_FINE_LOCATION"));
        if (zEquals && zEquals2) {
            showMsg("定位权限已获取");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(ActivityResult activityResult) {
        if (activityResult.b() == -1) {
            showMsg("位置已打开");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(Boolean bool) {
        if (bool.booleanValue()) {
            showMsg("可以开始扫描设备了");
        } else {
            showMsg("Android12 中不授予此权限无法扫描蓝牙");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(View view) {
        r02.b().K(this.selectedList);
        jumpActivity(UpgradeActivity.class);
        this.submitDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(View view) {
        this.submitDialog.dismiss();
    }

    private void f0(o02 o02Var) {
        o02Var.J(!o02Var.t());
        int iT = T(o02Var, this.selectedList);
        if (iT == -1) {
            this.selectedList.add(o02Var);
        } else if (!o02Var.t()) {
            this.selectedList.remove(iT);
        }
        if (this.otaCore.D()) {
            j0();
        }
        this.mAdapter.notifyDataSetChanged();
    }

    private void g0() {
        int size = this.selectedList.size();
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.dialog_submit, (ViewGroup) null);
        int i = R$id.tv_submit;
        TextView textView = (TextView) viewInflate.findViewById(i);
        View viewFindViewById = viewInflate.findViewById(R$id.view1);
        textView.setVisibility(size > 0 ? 0 : 8);
        viewFindViewById.setVisibility(size > 0 ? 0 : 8);
        i5 i5VarB = new i5.a(this).a().d(viewInflate).c(true).f(R$id.tv_content, "选择了" + size + "个设备").g(jr2.a(this, 280.0f), -2).e(i, new View.OnClickListener() { // from class: z91
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.d0(view);
            }
        }).e(R$id.tv_cancel, new View.OnClickListener() { // from class: aa1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.e0(view);
            }
        }).b();
        this.submitDialog = i5VarB;
        i5VarB.show();
    }

    private void h0() {
        this.mList.clear();
        this.selectedList.clear();
        this.mAdapter.notifyDataSetChanged();
        this.otaCore.T();
        this.tvScanStatus.setText("停止");
        this.tvOperateInfo.setText("开始扫描设备！");
        V();
        this.timer.schedule(this.task, 0L, 1000L);
    }

    private void i0() {
        r02.b().K(this.selectedList);
        Intent intent = new Intent(this, (Class<?>) UpgradeActivity.class);
        intent.putExtra("path", getPath());
        startActivity(intent);
        finish();
    }

    private void j0() {
        this.otaCore.W();
        this.tvScanStatus.setText("搜索");
        this.tvOperateInfo.setText("已经停止扫描设备！");
        this.timer.cancel();
    }

    public static void setToolbarMoreIconCustomColor(Toolbar toolbar, int i) {
        Drawable drawableE;
        if (toolbar == null || (drawableE = q30.e(toolbar.getContext(), R$drawable.abc_ic_menu_overflow_material)) == null) {
            return;
        }
        drawableE.setColorFilter(q30.c(toolbar.getContext(), i), PorterDuff.Mode.SRC_ATOP);
        toolbar.setOverflowIcon(drawableE);
    }

    @Override // defpackage.qd2
    public void bluetoothClose() {
        if (this.otaCore.D()) {
            j0();
        }
    }

    @Override // com.phy.ota_demo.basic.PhyActivity
    protected int getLayout() {
        return R$layout.activity_scan;
    }

    protected abstract String getMacAddress();

    protected abstract String getPath();

    @Override // defpackage.qd2
    public void locationClose() {
        if (this.otaCore.D()) {
            j0();
        }
    }

    @Override // android.view.View.OnClickListener
    @SuppressLint({"NonConstantResourceId"})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.btn_request_connect_permission) {
            this.requestConnect.a("android.permission.BLUETOOTH_CONNECT");
            return;
        }
        if (id == R$id.btn_enable_bluetooth) {
            this.enableBluetooth.a(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));
            return;
        }
        if (id == R$id.btn_request_location_permission) {
            this.requestLocation.a(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"});
            return;
        }
        if (id == R$id.btn_enable_location) {
            this.enableLocation.a(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            return;
        }
        if (id == R$id.btn_request_scan_permission) {
            this.requestScan.a("android.permission.BLUETOOTH_SCAN");
            return;
        }
        if (id != R$id.tv_scan_status) {
            if (id == R$id.btn_submit) {
                g0();
            }
        } else if (this.otaCore.D()) {
            j0();
        } else {
            h0();
        }
    }

    @Override // com.phy.ota_demo.basic.PhyActivity
    protected void onCreate() {
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(R$id.toolbar);
        this.toolbar = materialToolbar;
        setToolbarMoreIconCustomColor(materialToolbar, R$color.white);
        setSupportActionBar(this.toolbar);
        this.otaCore = r02.b();
        this.requestBluetoothConnectLay = findViewById(R$id.request_bluetooth_connect_lay);
        this.btnRequestConnectPermission = (MaterialButton) findViewById(R$id.btn_request_connect_permission);
        this.btnEnableBluetooth = (MaterialButton) findViewById(R$id.btn_enable_bluetooth);
        this.btnRequestLocationPermission = (MaterialButton) findViewById(R$id.btn_request_location_permission);
        this.btnEnableLocation = (MaterialButton) findViewById(R$id.btn_enable_location);
        this.btnRequestScanPermission = (MaterialButton) findViewById(R$id.btn_request_scan_permission);
        this.tvScanStatus = (TextView) findViewById(R$id.tv_scan_status);
        this.btnSubmit = (MaterialButton) findViewById(R$id.btn_submit);
        this.rvDevice = (RecyclerView) findViewById(R$id.rv_device);
        this.emptyLay = findViewById(R$id.empty_lay);
        this.enableLocationLay = findViewById(R$id.enable_location_lay);
        this.requestLocationLay = findViewById(R$id.request_location_lay);
        this.requestBluetoothScanLay = findViewById(R$id.request_bluetooth_scan_lay);
        this.enableBluetoothLay = findViewById(R$id.enable_bluetooth_lay);
        this.tvOperateInfo = (TextView) findViewById(R$id.tv_operate_info);
        this.btnRequestConnectPermission.setOnClickListener(this);
        this.btnEnableBluetooth.setOnClickListener(this);
        this.btnRequestLocationPermission.setOnClickListener(this);
        this.btnEnableLocation.setOnClickListener(this);
        this.btnRequestScanPermission.setOnClickListener(this);
        this.tvScanStatus.setOnClickListener(this);
        this.btnSubmit.setOnClickListener(this);
        if (isOpenBluetooth()) {
            this.otaCore.N(this);
        }
        PhyReceiver phyReceiver = new PhyReceiver();
        phyReceiver.b(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.location.PROVIDERS_CHANGED");
        registerReceiver(phyReceiver, intentFilter);
        q02 q02Var = new q02(this, this.mList);
        this.mAdapter = q02Var;
        q02Var.g(this);
        this.rvDevice.setLayoutManager(new LinearLayoutManager(this));
        this.rvDevice.setAdapter(this.mAdapter);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R$menu.menu_main, menu);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(Config.Y_DENSITY);
    }

    @Override // defpackage.fv1
    public void onItemClick(View view, int i) {
        f0(this.mList.get(i));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        if (System.currentTimeMillis() - this.timeMillis > 2000) {
            this.timeMillis = System.currentTimeMillis();
            return false;
        }
        exitTheProgram();
        return false;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R$id.item_about) {
            return true;
        }
        showMsg("版本号：1.4");
        return true;
    }

    @Override // com.phy.ota_demo.basic.PhyActivity
    protected void onRegister() {
        this.requestConnect = registerForActivityResult(new d4(), new a4() { // from class: s91
            @Override // defpackage.a4
            public final void a(Object obj) {
                this.a.Y((Boolean) obj);
            }
        });
        this.enableBluetooth = registerForActivityResult(new e4(), new a4() { // from class: t91
            @Override // defpackage.a4
            public final void a(Object obj) {
                this.a.Z((ActivityResult) obj);
            }
        });
        this.requestLocation = registerForActivityResult(new c4(), new a4() { // from class: u91
            @Override // defpackage.a4
            public final void a(Object obj) {
                this.a.a0((Map) obj);
            }
        });
        this.enableLocation = registerForActivityResult(new e4(), new a4() { // from class: v91
            @Override // defpackage.a4
            public final void a(Object obj) {
                this.a.b0((ActivityResult) obj);
            }
        });
        this.requestScan = registerForActivityResult(new d4(), new a4() { // from class: w91
            @Override // defpackage.a4
            public final void a(Object obj) {
                this.a.c0((Boolean) obj);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (isAndroid12()) {
            this.requestLocationLay.setVisibility((hasCoarseLocation() && hasAccessFineLocation()) ? 8 : 0);
            this.enableLocationLay.setVisibility(isOpenLocation() ? 8 : 0);
            this.requestBluetoothConnectLay.setVisibility(hasBluetoothConnect() ? 8 : 0);
            this.enableBluetoothLay.setVisibility(isOpenBluetooth() ? 8 : 0);
            this.requestBluetoothScanLay.setVisibility(hasBluetoothScan() ? 8 : 0);
            if (!hasBluetoothConnect()) {
                Log.d(TAG, "onResume: 未获取蓝牙连接权限");
                return;
            } else if (!isOpenBluetooth()) {
                Log.d(TAG, "onResume: 未打开蓝牙");
                return;
            } else if (!hasBluetoothScan()) {
                Log.d(TAG, "onResume: 未获取蓝牙扫描权限");
                return;
            }
        } else {
            this.requestBluetoothConnectLay.setVisibility(8);
            this.requestBluetoothScanLay.setVisibility(8);
            this.enableBluetoothLay.setVisibility(isOpenBluetooth() ? 8 : 0);
            this.enableLocationLay.setVisibility(isOpenLocation() ? 8 : 0);
            this.requestLocationLay.setVisibility((hasCoarseLocation() && hasAccessFineLocation()) ? 8 : 0);
            if (!isOpenBluetooth()) {
                Log.d(TAG, "onResume: 未打开蓝牙");
                return;
            }
        }
        if (!hasAccessFineLocation()) {
            Log.d(TAG, "onResume: 未获取定位权限");
            return;
        }
        if (!isOpenLocation()) {
            Log.d(TAG, "onResume: 未打开位置");
            return;
        }
        this.tvScanStatus.setVisibility(0);
        if (this.otaCore.D()) {
            return;
        }
        h0();
    }

    @Override // defpackage.t02
    public void onScanResult(ScanResult scanResult) {
        o02 o02Var;
        String strH;
        Log.i(TAG, "onScanResult:" + scanResult.getDevice().getAddress());
        if (scanResult.getScanRecord().getDeviceName() == null || scanResult.getScanRecord().getDeviceName().isEmpty() || (strH = (o02Var = new o02(scanResult)).h()) == null) {
            return;
        }
        String macAddress = getMacAddress();
        String strA = dk.a(getMacAddress());
        if (strH.equalsIgnoreCase(macAddress) || strH.equalsIgnoreCase(strA)) {
            f0(o02Var);
            this.mHandler.sendEmptyMessageDelayed(Config.Y_DENSITY, 1000L);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.otaCore.D()) {
            j0();
        }
    }
}
