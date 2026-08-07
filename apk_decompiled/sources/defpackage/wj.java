package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.legend.mywatch.sdk.mywatchsdklib.android.enm.BluetoothStatusEnum;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.PermissionUtils;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class wj {
    private static volatile wj j = null;
    private static long k = 0;
    private static int l = 3000;
    c d;
    private d e;
    b f;
    private List g;
    private ScanFilter.Builder h;
    private ScanSettings.Builder i;
    private BroadcastReceiver b = new a();
    private BluetoothAdapter.LeScanCallback c = new BluetoothAdapter.LeScanCallback() { // from class: tj
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            this.a.o(bluetoothDevice, i, bArr);
        }
    };
    private BluetoothAdapter a = BluetoothAdapter.getDefaultAdapter();

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                yc1.a("BleManager", "蓝牙绑定广播");
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice == null) {
                    yc1.a("BleManager", "获取绑定设备为空");
                    return;
                } else {
                    if (intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", 12) == 12) {
                        yc1.a("BleManager", "开始连接绑定设备");
                        if (rv2.b(ug3.c(), bluetoothDevice.getAddress())) {
                            wj.this.p(bluetoothDevice.getAddress());
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
                if (intExtra == 10) {
                    yc1.a("BleManager", "监听蓝牙状态变化---->蓝牙关闭");
                    tg3.i(BluetoothStatusEnum.BLUETOOTH_NOT_OPENED.getValue(), Constants.STR_EMPTY);
                    if (zi2.e() != null) {
                        zi2.e().B();
                    }
                } else if (intExtra == 12) {
                    yc1.a("BleManager", "监听蓝牙状态变化---->蓝牙开启");
                    if (zi2.e() != null) {
                        zi2.e().B();
                        zi2.e().A();
                    }
                }
            }
            wj.this.l();
            HashMap map = new HashMap();
            map.put("action", "state");
            map.put("what", 2121);
            map.put("state", e20.d + Constants.STR_EMPTY);
            tg3.i(e20.d, ug3.e());
        }
    }

    private class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            yc1.a("BleManager", "startLeScan 自动搜索30秒后自动关闭: no find address");
            wj.this.q(false);
        }

        private b() {
        }
    }

    private class c extends ScanCallback {
        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i, ScanResult scanResult) {
            super.onScanResult(i, scanResult);
            if (scanResult == null) {
                yc1.a("BleManager", "scan result is null");
            } else {
                wj.this.k(scanResult.getDevice());
            }
        }

        private c() {
        }
    }

    private class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!ak.i()) {
                    yc1.a("BleManager", "============蓝牙或者gps没有打开，停止扫描");
                    return;
                }
                wj.this.r();
                if (!ak.h()) {
                    wj.this.a.startLeScan(wj.this.c);
                    yc1.a("BleManager", "============扫描页面扫描");
                } else {
                    if (rv2.f(ug3.c())) {
                        yc1.a("BleManager", "============设备不存在，不进行重连扫描设备操作");
                        return;
                    }
                    wj wjVar = wj.this;
                    if (wjVar.d == null) {
                        wjVar.d = new c();
                    }
                    wj.this.a.getBluetoothLeScanner().startScan(wj.this.i(), wj.this.j(), wj.this.d);
                    yc1.a("BleManager", "============正在进行后台扫描连接操作");
                }
                e20.c.postDelayed(wj.this.f, 30000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private d() {
        }
    }

    private wj() {
        this.e = new d();
        this.f = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List i() {
        this.g = new ArrayList();
        ScanFilter.Builder builder = new ScanFilter.Builder();
        this.h = builder;
        this.g.add(builder.build());
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ScanSettings j() {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        this.i = builder;
        builder.setScanMode(2);
        this.i.setMatchMode(1);
        this.i.setCallbackType(1);
        return this.i.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(BluetoothDevice bluetoothDevice) {
        if (!ak.h()) {
            yc1.a("BleManager", "cannot scan connect");
        } else {
            p(bluetoothDevice.getAddress());
            yc1.a("BleManager", "start scan connect");
        }
    }

    public static wj m() {
        if (j == null) {
            synchronized (wj.class) {
                try {
                    if (j == null) {
                        j = new wj();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return j;
    }

    public static boolean n() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = jCurrentTimeMillis - k <= ((long) l);
        k = jCurrentTimeMillis;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        yc1.a("BleManager", "scan below 8.1 mac:" + bluetoothDevice.getAddress());
        k(bluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str) {
        if (rv2.a(ug3.c(), str)) {
            int iE = ak.e(str);
            if (iE == 2) {
                yc1.a("BleManager", "设备已经连接:" + str);
                return;
            }
            if (iE == 1) {
                yc1.a("BleManager", "正在重连中......." + str);
                return;
            }
            if (iE != 0 || zi2.e() == null) {
                return;
            }
            yc1.a("BleManager", " SDKCmdManager.getCoreService() is empty");
            zi2.e().R(str);
            q(false);
            yc1.a("BleManager", "开始重连:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        BluetoothAdapter bluetoothAdapter;
        BluetoothLeScanner bluetoothLeScanner;
        if (this.d != null && (bluetoothAdapter = this.a) != null && (bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner()) != null) {
            bluetoothLeScanner.stopScan(this.d);
        }
        BluetoothAdapter.LeScanCallback leScanCallback = this.c;
        if (leScanCallback != null) {
            this.a.stopLeScan(leScanCallback);
        }
    }

    public void l() {
        if (Build.VERSION.SDK_INT >= 31 || PermissionUtils.v("android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN")) {
            String strE = ug3.e();
            BluetoothAdapter bluetoothAdapter = this.a;
            if (bluetoothAdapter == null) {
                tg3.i(BluetoothStatusEnum.NOT_SUPPORT_BLUETOOTH.getValue(), Constants.STR_EMPTY);
            } else if (!bluetoothAdapter.isEnabled()) {
                tg3.i(BluetoothStatusEnum.BLUETOOTH_NOT_OPENED.getValue(), Constants.STR_EMPTY);
                if (zi2.e() != null) {
                    zi2.e().B();
                }
            } else if (strE == Constants.STR_EMPTY || strE.equals(Constants.STR_EMPTY)) {
                tg3.i(BluetoothStatusEnum.DISCONNECT.getValue(), Constants.STR_EMPTY);
            } else if (e20.d == 1 && ak.f(strE) == 0) {
                tg3.i(BluetoothStatusEnum.DISCONNECT.getValue(), Constants.STR_EMPTY);
            }
            if (zi2.e() != null && e20.d != 1) {
                zi2.e().A();
            }
            yc1.a("BleManager", "蓝牙连接状态----2设备不支持蓝牙, -1蓝牙未打开, 0未连接, 1 已连接----:" + e20.d);
            tg3.i(e20.d, strE);
        }
    }

    public void q(boolean z) {
        int i;
        try {
            if (!com.legend.mywatch.sdk.mywatchsdklib.android.utils.c.a()) {
                yc1.a("BleManager", "App not foreground");
                return;
            }
            e20.c.removeCallbacks(this.f);
            e20.c.removeCallbacks(this.e);
            if (z) {
                if (n()) {
                    yc1.a("BleManager", "扫描过快，启动延迟启动扫描机制");
                    i = 2500;
                } else {
                    yc1.a("BleManager", "正常扫描");
                    i = 500;
                }
                e20.c.postDelayed(this.e, i);
            } else {
                r();
            }
            yc1.a("BleManager", "=========== scanLeDevice enable:" + z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
