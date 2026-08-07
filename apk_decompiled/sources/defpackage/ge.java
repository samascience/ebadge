package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.example.bluetoothlibrary.broadcastreceiver.BluetoothBroadcastReceiver;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ge implements ay0 {
    private Context a;
    private ez2 b;
    private BluetoothAdapter c;
    private BluetoothBroadcastReceiver d;
    private nu1 e;
    private yu1 i;
    private boolean f = false;
    private boolean g = false;
    private Handler h = new a();
    private Runnable j = new b();
    private Runnable k = new c();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ge.this.l();
            if (ge.this.i != null) {
                ge.this.i.c();
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            dd1.b("BTManager", "startConnectDevice-->连接超时");
            if (ge.this.e != null) {
                ge.this.e.a();
            }
            ge.this.f = false;
            ge.this.f();
        }
    }

    private static class d {
        private static ge a = new ge();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.c == null) {
            dd1.b("BTManager", "cancelDiscoveryDevice-->bluetooth3Adapter == null");
        } else {
            dd1.a("BTManager", "停止扫描设备");
            this.c.cancelDiscovery();
        }
    }

    public static ge m() {
        return d.a;
    }

    private void n(yu1 yu1Var) {
        BluetoothBroadcastReceiver bluetoothBroadcastReceiver = this.d;
        if (bluetoothBroadcastReceiver == null) {
            dd1.b("BTManager", "initStartDiscovery-->bluetoothBroadcastReceiver == null");
            return;
        }
        this.i = yu1Var;
        bluetoothBroadcastReceiver.a(yu1Var);
        BluetoothAdapter bluetoothAdapter = this.c;
        if (bluetoothAdapter == null) {
            dd1.b("BTManager", "initStartDiscovery-->bluetooth3Adapter == null");
        } else if (bluetoothAdapter.isDiscovering()) {
            dd1.b("BTManager", "initStartDiscovery-->正在扫描中...");
        } else {
            dd1.a("BTManager", "开始扫描设备");
            this.c.startDiscovery();
        }
    }

    @Override // defpackage.ay0
    public List a() {
        if (this.c != null) {
            return new ArrayList(this.c.getBondedDevices());
        }
        dd1.b("BTManager", "getBoundDeviceList-->bluetooth3Adapter == null");
        return null;
    }

    @Override // defpackage.ay0
    public void b(Context context, boolean z) {
        ez2 ez2Var = this.b;
        if (ez2Var == null) {
            dd1.b("BTManager", "openBluetooth-->systemBtCheck == null");
        } else {
            ez2Var.e(context, z);
        }
    }

    @Override // defpackage.ay0
    public void c(Context context) {
        this.a = context;
        ez2 ez2VarB = ez2.b();
        this.b = ez2VarB;
        ez2VarB.c(this.a);
        this.c = this.b.a;
        if (this.d == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.FOUND");
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            intentFilter.addAction("android.bluetooth.adapter.action.SCAN_MODE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
            intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.NAME_CHANGED");
            BluetoothBroadcastReceiver bluetoothBroadcastReceiver = new BluetoothBroadcastReceiver();
            this.d = bluetoothBroadcastReceiver;
            this.a.registerReceiver(bluetoothBroadcastReceiver, intentFilter);
        }
        this.b.e(this.a, false);
    }

    @Override // defpackage.ay0
    public void d() {
        this.h.removeCallbacks(this.j);
        l();
    }

    @Override // defpackage.ay0
    public void e(yu1 yu1Var, long j) {
        n(yu1Var);
        this.h.postDelayed(this.j, j);
    }

    @Override // defpackage.ay0
    public void f() {
        dd1.a("BTManager", "clearConnectedThread-->即将断开");
        dd1.b("BTManager", "clearConnectedThread-->connectedThread == null");
    }

    @Override // defpackage.ay0
    public boolean g(byte[] bArr) {
        dd1.b("BTManager", "sendData:byte[]-->connectedThread == null");
        return false;
    }
}
