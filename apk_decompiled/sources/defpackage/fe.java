package defpackage;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.example.bluetoothlibrary.model.SearchDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class fe {
    private Context a;
    private BluetoothDevice b;
    private ay0 c;
    private zx0 d;
    private BluetoothGatt e;
    private BluetoothGattService f;
    private BluetoothGattCharacteristic g;
    private BluetoothGattCharacteristic h;
    private gw1 m;
    private wu1 n;
    private String i = null;
    private String j = null;
    private String k = null;
    private List l = new ArrayList();
    private boolean o = false;
    private boolean p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f332q = false;
    Handler r = new a();
    private yu1 s = new b();
    private boolean t = false;
    private String[] u = null;
    private cw1 v = new c();
    private nu1 w = new d();
    private ru1 x = new e();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    class b implements yu1 {
        b() {
        }

        @Override // defpackage.yu1
        public void a() {
            dd1.a("BTBluetooth", "开始扫描...");
            if (fe.this.m != null) {
                fe.this.m.a();
            }
        }

        @Override // defpackage.yu1
        public void b() {
            dd1.a("BTBluetooth", "扫描结束");
            if (fe.this.m != null) {
                fe.this.m.b();
            }
        }

        @Override // defpackage.yu1
        public void c() {
            if (fe.this.m != null) {
                fe.this.m.d();
            }
        }

        @Override // defpackage.yu1
        public void d(SearchDevice searchDevice) {
            if (searchDevice == null || searchDevice.bluetoothDevice == null) {
                dd1.b("BTBluetooth", "onDeviceSearchListener-->searchDevice == null");
                return;
            }
            if (fe.this.l.contains(searchDevice.bluetoothDevice)) {
                return;
            }
            fe.this.l.add(searchDevice.bluetoothDevice);
            dd1.a("BTBluetooth", "扫描到设备name:" + searchDevice.bluetoothDevice.getName() + "-->address:" + searchDevice.bluetoothDevice.getAddress());
            if (fe.this.m != null) {
                fe.this.m.c(searchDevice.bluetoothDevice, searchDevice.rssi, searchDevice.scanRecord);
            }
        }
    }

    class c implements cw1 {
        c() {
        }

        @Override // defpackage.cw1
        public void a(BluetoothDevice bluetoothDevice) {
        }

        @Override // defpackage.cw1
        public void b(BluetoothDevice bluetoothDevice) {
            if (fe.this.p) {
                return;
            }
            dd1.c("BTBluetooth", "OnRemoteDeviceConStateListener-->断开连接");
            fe.this.o = false;
            if (fe.this.n != null) {
                fe.this.n.i(0);
            }
        }
    }

    class d implements nu1 {
        d() {
        }

        @Override // defpackage.nu1
        public void a() {
            fe.this.o = false;
            dd1.b("BTBluetooth", "onBTConnectListener-->连接超时！");
            if (fe.this.n != null) {
                fe.this.n.f("连接超时", -1);
            }
        }
    }

    class e implements ru1 {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        e() {
        }

        @Override // defpackage.ru1
        public void a(String str) {
            dd1.b("BTBluetooth", "onBleConnectListener-->MTU设置-->" + str);
            if (fe.this.n != null) {
                fe.this.n.a(str);
            }
        }

        @Override // defpackage.ru1
        public void b(String str, int i) {
            dd1.c("BTBluetooth", "onBleConnectListener-->MTU设置-->" + str);
            if (fe.this.n != null) {
                fe.this.n.b(str, i);
            }
        }

        @Override // defpackage.ru1
        public void c(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice, int i) {
            dd1.c("BTBluetooth", "onBleConnectListener-->连接成功");
            fe.this.o = true;
        }

        @Override // defpackage.ru1
        public void d(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice, int i) {
            if (fe.this.n != null) {
                fe.this.n.e(bluetoothGatt);
            }
            fe.this.e = bluetoothGatt;
            if (!fe.this.f332q) {
                Log.d("BTBluetooth", "UUID未知");
                if (fe.this.n != null) {
                    fe.this.n.c();
                    return;
                }
                return;
            }
            Log.d("BTBluetooth", "已知UUID");
            boolean[] zArr = new boolean[1];
            if (fe.this.t) {
                fe.this.r.postDelayed(new b(), 1000L);
                zArr[0] = fe.this.v(bluetoothGatt);
            } else {
                fe.this.r.postDelayed(new a(), 1000L);
                zArr[0] = fe.this.u(bluetoothGatt);
            }
            if (zArr[0]) {
                fe.this.o = true;
                dd1.c("BTBluetooth", "onBleConnectListener-->连接成功、发现服务，且自定义服务特征获取成功！");
                if (fe.this.n != null) {
                    fe.this.n.c();
                    return;
                }
                return;
            }
            fe.this.o = false;
            dd1.c("BTBluetooth", "onBleConnectListener-->连接成功、发现服务，但自定义服务特征获取失败！");
            if (fe.this.n != null) {
                fe.this.n.f("自定义服务特征获取失败！", -1);
            }
        }

        @Override // defpackage.ru1
        public void e(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice, String str, int i) {
            fe.this.o = false;
            dd1.b("BTBluetooth", "onBleConnectListener-->" + str + "!-- status = " + i);
            if (fe.this.n != null) {
                fe.this.n.f(str, i);
            }
        }

        @Override // defpackage.ru1
        public void f(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice, byte[] bArr, String str) {
            dd1.b("BTBluetooth", "onBleConnectListener-->发送数据失败,长度" + bArr.length + "->" + l63.c(bArr, bArr.length));
            if (fe.this.n != null) {
                fe.this.n.g(bArr, str);
            }
        }

        @Override // defpackage.ru1
        public void g(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice, int i) {
            dd1.c("BTBluetooth", "onBleConnectListener-->断开连接");
            fe.this.o = false;
            if (fe.this.n != null) {
                fe.this.n.i(i);
            }
        }

        @Override // defpackage.ru1
        public void h(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice, byte[] bArr) {
            dd1.c("BTBluetooth", "onBleConnectListener-->发送数据成功,长度" + bArr.length + "->" + l63.c(bArr, bArr.length));
            if (fe.this.n != null) {
                fe.this.n.d(bArr);
            }
        }

        @Override // defpackage.ru1
        public void i(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            dd1.c("BTBluetooth", "onBleConnectListener-->成功收到数据,长度" + bArr.length + "->" + l63.c(bArr, bArr.length));
            if (fe.this.n != null) {
                fe.this.n.h(bluetoothGattCharacteristic, bArr);
            }
        }

        @Override // defpackage.ru1
        public void j(BluetoothGatt bluetoothGatt, int i, int i2) {
        }

        @Override // defpackage.ru1
        public void k(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice) {
            dd1.a("BTBluetooth", "onBleConnectListener-->正在断开...");
        }

        @Override // defpackage.ru1
        public void l(BluetoothGatt bluetoothGatt, BluetoothDevice bluetoothDevice) {
            if (fe.this.b != null) {
                dd1.a("BTBluetooth", "onBleConnectListener-->正在连接：" + fe.this.b.getName() + "-->" + fe.this.b.getAddress());
            }
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    private static class h {
        private static final fe a = new fe();
    }

    public static fe p() {
        return h.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt == null) {
            dd1.b("BTBluetooth", "setupService()-->bluetoothGatt == null");
            return false;
        }
        if (this.d == null) {
            dd1.b("BTBluetooth", "setupService()-->bleManager == null");
            return false;
        }
        if (this.i == null) {
            dd1.b("BTBluetooth", "setupService()-->serviceUUID == null");
            return false;
        }
        for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
            if (bluetoothGattService.getUuid().toString().equals(this.i)) {
                this.f = bluetoothGattService;
            }
        }
        if (this.f == null) {
            this.d.f(bluetoothGatt, null);
            dd1.b("BTBluetooth", "setupService()-->找不到该服务bluetoothGattService == null");
            return false;
        }
        dd1.a("BTBluetooth", "setupService-->bluetoothGattService = " + this.f.toString());
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.f.getCharacteristics()) {
            if (bluetoothGattCharacteristic.getUuid().toString().equals(this.j)) {
                this.g = bluetoothGattCharacteristic;
            } else if (bluetoothGattCharacteristic.getUuid().toString().equals(this.k)) {
                this.h = bluetoothGattCharacteristic;
            }
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic2 = this.g;
        if (bluetoothGattCharacteristic2 == null) {
            dd1.b("BTBluetooth", "setupService()-->readCharacteristic == null");
            return false;
        }
        if (this.h == null) {
            dd1.b("BTBluetooth", "setupService()-->writeCharacteristic == null");
            return false;
        }
        this.d.i(true, bluetoothGatt, bluetoothGattCharacteristic2);
        for (BluetoothGattDescriptor bluetoothGattDescriptor : this.g.getDescriptors()) {
            bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            bluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
        }
        this.r.postDelayed(new g(), 2000L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt == null) {
            dd1.b("BTBluetooth", "setupServiceWithMoreRead()-->bluetoothGatt == null");
            return false;
        }
        if (this.d == null) {
            dd1.b("BTBluetooth", "setupServiceWithMoreRead()-->bleManager == null");
            return false;
        }
        if (this.i == null) {
            dd1.b("BTBluetooth", "setupServiceWithMoreRead()-->serviceUUID == null");
            return false;
        }
        for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
            if (bluetoothGattService.getUuid().toString().equals(this.i)) {
                this.f = bluetoothGattService;
            }
        }
        if (this.f == null) {
            this.d.f(bluetoothGatt, null);
            dd1.b("BTBluetooth", "setupServiceWithMoreRead()-->找不到该服务bluetoothGattService == null");
            return false;
        }
        dd1.a("BTBluetooth", "setupService-->bluetoothGattService = " + this.f.toString());
        ArrayList arrayList = new ArrayList();
        for (String str : this.u) {
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.f.getCharacteristics()) {
                if (bluetoothGattCharacteristic.getUuid().toString().toLowerCase().equals(str.toLowerCase())) {
                    arrayList.add(bluetoothGattCharacteristic);
                }
            }
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : this.f.getCharacteristics()) {
            if (bluetoothGattCharacteristic2.getUuid().toString().equals(this.k)) {
                this.h = bluetoothGattCharacteristic2;
            }
        }
        if (arrayList.size() != this.u.length) {
            dd1.b("BTBluetooth", "setupServiceWithMoreRead()-->readCharacteristicList.size() != readUUIDs.length");
            return false;
        }
        if (this.h == null) {
            dd1.b("BTBluetooth", "setupServiceWithMoreRead()-->writeCharacteristic == null");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.d.i(true, bluetoothGatt, (BluetoothGattCharacteristic) it.next());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            for (BluetoothGattDescriptor bluetoothGattDescriptor : ((BluetoothGattCharacteristic) it2.next()).getDescriptors()) {
                bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                bluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
            }
        }
        this.r.postDelayed(new f(), 2000L);
        return true;
    }

    private boolean w(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt == null) {
            dd1.b("BTBluetooth", "setupService()-->bluetoothGatt == null");
            return false;
        }
        if (this.d == null) {
            dd1.b("BTBluetooth", "setupService()-->bleManager == null");
            return false;
        }
        if (this.i == null) {
            dd1.b("BTBluetooth", "setupService()-->serviceUUID == null");
            return false;
        }
        for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
            if (bluetoothGattService.getUuid().toString().equals(this.i)) {
                this.f = bluetoothGattService;
            }
        }
        if (this.f == null) {
            this.d.f(bluetoothGatt, null);
            dd1.b("BTBluetooth", "setupService()-->找不到该服务bluetoothGattService == null");
            return false;
        }
        dd1.a("BTBluetooth", "setupService-->bluetoothGattService = " + this.f.toString());
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.f.getCharacteristics()) {
            if (bluetoothGattCharacteristic.getUuid().toString().equals(this.k)) {
                this.h = bluetoothGattCharacteristic;
            }
        }
        if (this.h != null) {
            return true;
        }
        dd1.b("BTBluetooth", "setupService()-->writeCharacteristic == null");
        return false;
    }

    public void l(String str, String str2, String str3, BluetoothDevice bluetoothDevice, long j, wu1 wu1Var) {
        r(this.a, false);
        if (this.p) {
            if (str == null || str2 == null || str3 == null) {
                this.f332q = false;
            } else {
                this.f332q = true;
                this.i = str;
                this.j = str2;
                this.k = str3;
            }
            this.n = wu1Var;
            this.b = bluetoothDevice;
            if (this.d == null) {
                dd1.b("BTBluetooth", "connectBLEDevice()-->bleManager == null");
                return;
            }
            Log.d("BTBluetooth", "准备连接设备：" + bluetoothDevice.getName());
            this.d.j(this.a, bluetoothDevice, j, this.x);
        }
    }

    public void m() {
        if (this.p) {
            zx0 zx0Var = this.d;
            if (zx0Var == null) {
                dd1.b("BTBluetooth", "disConnectDevice()-->bleManager == null");
                return;
            } else {
                zx0Var.f(this.e, null);
                return;
            }
        }
        ay0 ay0Var = this.c;
        if (ay0Var == null) {
            dd1.b("BTBluetooth", "disConnectDevice()-->btManager == null");
        } else {
            ay0Var.f();
        }
    }

    public void n(gw1 gw1Var, long j) {
        r(this.a, false);
        List list = this.l;
        if (list == null) {
            this.l = new ArrayList();
        } else {
            list.clear();
        }
        if (this.p) {
            this.m = gw1Var;
            zx0 zx0Var = this.d;
            if (zx0Var == null) {
                dd1.b("BTBluetooth", "discoveryDevice()-->bleManager == null");
                return;
            } else {
                zx0Var.e(this.s, j);
                return;
            }
        }
        this.m = gw1Var;
        ay0 ay0Var = this.c;
        if (ay0Var == null) {
            dd1.b("BTBluetooth", "discoveryDevice()-->btManager == null");
        } else {
            ay0Var.e(this.s, j);
        }
    }

    public List o() {
        if (this.p) {
            zx0 zx0Var = this.d;
            if (zx0Var != null) {
                return zx0Var.a();
            }
            dd1.b("BTBluetooth", "getBoundDeviceList()-->bleManager == null");
            return null;
        }
        ay0 ay0Var = this.c;
        if (ay0Var != null) {
            return ay0Var.a();
        }
        dd1.b("BTBluetooth", "getBoundDeviceList()-->btManager == null");
        return null;
    }

    public void q(Context context, boolean z) {
        this.a = context;
        if (z) {
            this.p = true;
        } else {
            this.p = false;
        }
        if (this.p) {
            de deVarA = de.A();
            this.d = deVarA;
            deVarA.c(context);
        } else {
            ge geVarM = ge.m();
            this.c = geVarM;
            geVarM.c(context);
        }
    }

    public void r(Context context, boolean z) {
        if (this.p) {
            zx0 zx0Var = this.d;
            if (zx0Var == null) {
                dd1.b("BTBluetooth", "openBluetooth()-->bleManager == null");
                return;
            } else {
                zx0Var.b(context, z);
                return;
            }
        }
        ay0 ay0Var = this.c;
        if (ay0Var == null) {
            dd1.b("BTBluetooth", "openBluetooth()-->btManager == null");
        } else {
            ay0Var.b(context, z);
        }
    }

    public boolean s(byte[] bArr) {
        r(this.a, false);
        if (!this.p) {
            ay0 ay0Var = this.c;
            if (ay0Var != null) {
                return ay0Var.g(bArr);
            }
            dd1.b("BTBluetooth", "sendData()-->btManager == null");
            return false;
        }
        if (this.d == null) {
            dd1.b("BTBluetooth", "sendData()-->bleManager == null");
            return false;
        }
        Log.d("BLEManager", "isWriteOk ：" + w(this.e));
        boolean zH = this.d.h(this.e, this.h, bArr);
        Log.d("BLEManager", "4.0发送结果：" + zH);
        return zH;
    }

    public boolean t(int i) {
        if (this.p) {
            Log.d("BTBluetooth", "设置修改MTU = " + i);
            zx0 zx0Var = this.d;
            if (zx0Var == null) {
                dd1.b("BTBluetooth", "setMtuValue()-->bleManager == null");
                return false;
            }
            if (zx0Var.g(i)) {
                dd1.c("BTBluetooth", "setMtuValue()-->设置修改MTU操作成功！");
                return true;
            }
            dd1.b("BTBluetooth", "setMtuValue()-->设置修改MTU操作失败！");
        }
        return false;
    }

    public void x() {
        r(this.a, false);
        if (this.p) {
            zx0 zx0Var = this.d;
            if (zx0Var == null) {
                dd1.b("BTBluetooth", "stopDiscoveryDevice()-->bleManager == null");
                return;
            } else {
                zx0Var.d();
                return;
            }
        }
        ay0 ay0Var = this.c;
        if (ay0Var == null) {
            dd1.b("BTBluetooth", "stopDiscoveryDevice()-->btManager == null");
        } else {
            ay0Var.d();
        }
    }
}
