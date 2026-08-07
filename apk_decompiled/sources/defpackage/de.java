package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baji.protocol.model.ProtocolConstants;
import com.example.bluetoothlibrary.broadcastreceiver.BluetoothBroadcastReceiver;
import com.example.bluetoothlibrary.model.SearchDevice;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class de implements zx0 {
    private Context a;
    private dz2 b;
    private BluetoothManager c;
    private BluetoothAdapter d;
    private BluetoothLeScanner e;
    private ScanCallback f;
    private BluetoothBroadcastReceiver g;
    private yu1 h;
    private ru1 i;
    private BluetoothGatt j = null;
    private BluetoothDevice k = null;
    private boolean l = false;
    private boolean m = false;
    private List n = new ArrayList();
    private Set o = new HashSet();
    private Handler p = new c();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BluetoothAdapter.LeScanCallback f322q = new d();
    private Runnable r = new e();
    private Runnable s = new f();
    private BluetoothGattCallback t = new g();
    private Runnable u = new h();
    private Runnable v = new i();
    private Runnable w = new a();
    private boolean x = false;
    private Runnable y = new b();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (de.this.j != null) {
                de.this.j.disconnect();
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (de.this.i != null) {
                de.this.i.a("设置MTU 等待回调结果超时！");
            }
        }
    }

    class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    class d implements BluetoothAdapter.LeScanCallback {
        d() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (bluetoothDevice == null) {
                return;
            }
            if (bluetoothDevice.getName() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(bluetoothDevice.getName());
                sb.append("-->");
                sb.append(bluetoothDevice.getAddress());
                sb.append("广播数据：");
                sb.append((bArr == null || bArr.length == 0) ? "空" : l63.b(bArr));
                dd1.a("BLEManager", sb.toString());
            } else {
                dd1.a("BLEManager", "null-->" + bluetoothDevice.getAddress());
            }
            SearchDevice searchDevice = new SearchDevice(bluetoothDevice, i, bArr);
            if (de.this.h != null) {
                de.this.h.d(searchDevice);
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            de.this.y();
            if (de.this.h != null) {
                de.this.h.c();
            }
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            de.this.z();
            if (de.this.h != null) {
                de.this.h.c();
            }
        }
    }

    class g extends BluetoothGattCallback {
        g() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            byte[] value = bluetoothGattCharacteristic.getValue();
            dd1.c("TAG", "收到数据str:" + l63.c(value, value.length));
            if (de.this.i != null) {
                de.this.i.i(bluetoothGatt, bluetoothGatt.getDevice(), bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue());
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            if (i == 0) {
                dd1.c("BLEManager", "读取特征成功，status = " + i);
                return;
            }
            dd1.b("BLEManager", "读取特征失败，status = " + i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            if (bluetoothGattCharacteristic.getValue() == null) {
                dd1.b("BLEManager", "characteristic.getValue() == null");
                return;
            }
            String strC = l63.c(bluetoothGattCharacteristic.getValue(), bluetoothGattCharacteristic.getValue().length);
            if (i == 0) {
                dd1.c("BLEManager", "写入成功：" + strC);
                if (de.this.i != null) {
                    de.this.i.h(bluetoothGatt, bluetoothGatt.getDevice(), bluetoothGattCharacteristic.getValue());
                    return;
                }
                return;
            }
            if (i != 257) {
                if (i == 3) {
                    dd1.b("BLEManager", "没有权限！");
                    return;
                }
                return;
            }
            dd1.b("BLEManager", "写入失败：" + strC);
            if (de.this.i != null) {
                de.this.i.f(bluetoothGatt, bluetoothGatt.getDevice(), bluetoothGattCharacteristic.getValue(), "写入失败");
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            dd1.a("BLEManager", "status:" + i);
            dd1.a("BLEManager", "newState:" + i2);
            if (i == 0) {
                dd1.c("BLEManager", "BluetoothGatt.GATT_SUCCESS");
            } else if (i == 2) {
                dd1.c("BLEManager", "BluetoothGatt.GATT_READ_NOT_PERMITTED");
            } else if (i == 15) {
                dd1.c("BLEManager", "BluetoothGatt.GATT_INSUFFICIENT_ENCRYPTION");
            } else if (i == 143) {
                dd1.c("BLEManager", "BluetoothGatt.GATT_CONNECTION_CONGESTED");
            } else if (i == 257) {
                dd1.c("BLEManager", "BluetoothGatt.GATT_FAILURE");
            } else if (i == 5) {
                dd1.c("BLEManager", "BluetoothGatt.GATT_INSUFFICIENT_AUTHENTICATION");
            } else if (i == 6) {
                dd1.c("BLEManager", "BluetoothGatt.GATT_REQUEST_NOT_SUPPORTED");
            } else if (i == 7) {
                dd1.c("BLEManager", "BluetoothGatt.GATT_INVALID_OFFSET");
            }
            BluetoothDevice device = bluetoothGatt.getDevice();
            dd1.a("BLEManager", "连接的设备：" + device.getName() + "  " + device.getAddress());
            de.this.l = false;
            de.this.p.removeCallbacks(de.this.u);
            if (i2 == 2) {
                if (TextUtils.equals(device.getAddress().toUpperCase(), de.this.k.getAddress().toUpperCase())) {
                    dd1.c("BLEManager", "连接成功");
                    bluetoothGatt.discoverServices();
                    de.this.p.postDelayed(de.this.v, ProtocolConstants.CONNECTION_TIMEOUT_MS);
                    if (de.this.o.contains(bluetoothGatt)) {
                        dd1.b("BLEManager", "bluetoothGattSet.contains(gatt)!");
                        return;
                    } else {
                        if (de.this.i != null) {
                            de.this.i.c(bluetoothGatt, device, i);
                            return;
                        }
                        return;
                    }
                }
                dd1.b("BLEManager", "连接成功的设备：" + device.getAddress() + ",需要连接的设备" + de.this.k.getAddress());
                de.this.f(bluetoothGatt, null);
                uy.a(bluetoothGatt);
                if (de.this.i != null) {
                    de.this.i.e(bluetoothGatt, device, "连接设备与目标设备不一致！", -1);
                    dd1.b("BLEManager", "连接设备与目标设备不一致！");
                    return;
                }
                return;
            }
            if (i2 != 0) {
                if (i2 == 1) {
                    dd1.a("BLEManager", "正在连接...");
                    if (de.this.i != null) {
                        de.this.i.l(bluetoothGatt, device);
                        return;
                    }
                    return;
                }
                if (i2 == 3) {
                    dd1.a("BLEManager", "正在断开...");
                    if (de.this.i != null) {
                        de.this.i.k(bluetoothGatt, device);
                        return;
                    }
                    return;
                }
                return;
            }
            if (!TextUtils.equals(device.getAddress().toUpperCase(), de.this.k.getAddress().toUpperCase())) {
                dd1.b("BLEManager", "上报断开的设备：" + device.getAddress() + ",当前连接的设备" + de.this.k.getAddress());
                return;
            }
            de.this.k = null;
            de.this.p.removeCallbacks(de.this.y);
            de.this.p.removeCallbacks(de.this.v);
            de.this.p.removeCallbacks(de.this.w);
            uy.a(bluetoothGatt);
            dd1.b("BLEManager", "断开连接status:" + i);
            de.this.j.close();
            bluetoothGatt.close();
            de.this.o.remove(bluetoothGatt);
            if (i == 133) {
                if (de.this.i != null) {
                    bluetoothGatt.close();
                    de.this.i.e(bluetoothGatt, device, "连接异常！", i);
                    dd1.b("BLEManager", "连接失败status：" + i + "  " + device.getAddress());
                    return;
                }
                return;
            }
            if (i == 62) {
                if (de.this.i != null) {
                    bluetoothGatt.close();
                    de.this.i.e(bluetoothGatt, device, "连接成功服务未发现断开！", i);
                    dd1.b("BLEManager", "连接成功服务未发现断开status:" + i);
                    return;
                }
                return;
            }
            if (i == 0) {
                if (de.this.i != null) {
                    de.this.i.g(bluetoothGatt, device, i);
                }
            } else if (i == 8) {
                if (de.this.i != null) {
                    de.this.i.g(bluetoothGatt, device, i);
                }
            } else if (i == 34) {
                if (de.this.i != null) {
                    de.this.i.g(bluetoothGatt, device, i);
                }
            } else if (de.this.i != null) {
                de.this.i.g(bluetoothGatt, device, i);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
            if (i == 0) {
                dd1.c("BLEManager", "读取描述符成功，status" + i);
                return;
            }
            dd1.b("BLEManager", "读取描述符失败，status" + i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
            if (i == 0) {
                dd1.c("BLEManager", "描述符写入值成功，status" + i);
                return;
            }
            dd1.b("BLEManager", "描述符写入值失败，status" + i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onMtuChanged(bluetoothGatt, i, i2);
            de.this.p.removeCallbacks(de.this.y);
            if (i2 == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("设置MTU成功，新的MTU值：");
                int i3 = i - 3;
                sb.append(i3);
                sb.append(",status");
                sb.append(i2);
                dd1.c("BLEManager", sb.toString());
                if (de.this.i != null) {
                    de.this.i.b("设置后新的MTU值 = " + i3 + "   status = " + i2, i3);
                    return;
                }
                return;
            }
            if (i2 == 257) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("设置MTU值失败：");
                int i4 = i - 3;
                sb2.append(i4);
                sb2.append(",status");
                sb2.append(i2);
                dd1.b("BLEManager", sb2.toString());
                if (de.this.i != null) {
                    de.this.i.a("设置MTU值失败：" + i4 + "   status：" + i2);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyRead(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            super.onPhyRead(bluetoothGatt, i, i2, i3);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            super.onPhyUpdate(bluetoothGatt, i, i2, i3);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onReadRemoteRssi(bluetoothGatt, i, i2);
            if (i2 != 0) {
                if (i2 == 257) {
                    dd1.b("BLEManager", "读取RSSI值失败，status：" + i2);
                    return;
                }
                return;
            }
            dd1.c("BLEManager", "读取RSSI值成功，RSSI值：" + i + ",status" + i2);
            if (de.this.i != null) {
                de.this.i.j(bluetoothGatt, i, i2);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
            super.onReliableWriteCompleted(bluetoothGatt, i);
            if (i == 0) {
                dd1.c("BLEManager", "可靠的写入 执行成功，status = " + i);
                return;
            }
            dd1.c("BLEManager", "可靠的写入 执行失败，status = " + i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            super.onServicesDiscovered(bluetoothGatt, i);
            de.this.p.removeCallbacks(de.this.v);
            dd1.a("BLEManager", "移除发现服务超时");
            dd1.a("BLEManager", "发现服务");
            if (de.this.i != null) {
                de.this.i.d(bluetoothGatt, bluetoothGatt.getDevice(), i);
            }
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (de.this.j == null) {
                dd1.b("BLEManager", "connectOutTimeRunnable-->mBluetoothGatt == null");
                return;
            }
            de.this.l = false;
            de.this.j.disconnect();
            if (de.this.i != null) {
                de.this.i.e(de.this.j, de.this.k, "连接超时！", -1);
            }
        }
    }

    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (de.this.j == null) {
                dd1.b("BLEManager", "serviceDiscoverOutTimeRunnable-->mBluetoothGatt == null");
                return;
            }
            de.this.l = false;
            de.this.j.disconnect();
            if (de.this.i != null) {
                de.this.i.e(de.this.j, de.this.k, "发现服务超时！", -1);
            }
        }
    }

    class j implements Runnable {
        final /* synthetic */ BluetoothGatt a;

        j(BluetoothGatt bluetoothGatt) {
            this.a = bluetoothGatt;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.close();
        }
    }

    private static class k {
        private static de a = new de();
    }

    public static de A() {
        return k.a;
    }

    private void B(yu1 yu1Var) {
        if (this.d == null) {
            dd1.b("BLEManager", "initStartDiscovery()-->bluetooth4Adapter == null");
            return;
        }
        this.h = yu1Var;
        if (yu1Var != null) {
            yu1Var.a();
        }
        dd1.a("BLEManager", "开始扫描设备");
        this.d.startLeScan(this.f322q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.d == null) {
            dd1.b("BLEManager", "cancelDiscoveryDevice-->bluetooth4Adapter == null");
        } else if (this.f322q == null) {
            dd1.b("BLEManager", "cancelDiscoveryDevice-->leScanCallback == null");
        } else {
            dd1.a("BLEManager", "停止扫描设备");
            this.d.stopLeScan(this.f322q);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.e == null || this.f == null) {
            return;
        }
        dd1.a("BLEManager", "停止扫描设备Le");
        this.e.stopScan(this.f);
    }

    @Override // defpackage.zx0
    public List a() {
        if (this.d != null) {
            return new ArrayList(this.d.getBondedDevices());
        }
        dd1.b("BLEManager", "getBoundDeviceLists-->bluetooth4Adapter == null");
        return null;
    }

    @Override // defpackage.zx0
    public void b(Context context, boolean z) {
        dz2 dz2Var = this.b;
        if (dz2Var == null) {
            dd1.b("BLEManager", "openBluetooth-->systemBleCheck == null");
        } else {
            dz2Var.e(context, z);
        }
    }

    @Override // defpackage.zx0
    public void c(Context context) {
        this.a = context;
        dz2 dz2VarB = dz2.b();
        this.b = dz2VarB;
        dz2VarB.c(this.a);
        dz2 dz2Var = this.b;
        this.c = dz2Var.b;
        this.d = dz2Var.a;
        if (this.g == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
            BluetoothBroadcastReceiver bluetoothBroadcastReceiver = new BluetoothBroadcastReceiver();
            this.g = bluetoothBroadcastReceiver;
            this.a.registerReceiver(bluetoothBroadcastReceiver, intentFilter);
        }
        this.b.e(this.a, false);
    }

    @Override // defpackage.zx0
    public void d() {
        this.p.removeCallbacks(this.r);
        y();
        yu1 yu1Var = this.h;
        if (yu1Var != null) {
            yu1Var.b();
        }
    }

    @Override // defpackage.zx0
    public void e(yu1 yu1Var, long j2) {
        B(yu1Var);
        this.p.postDelayed(this.r, j2);
    }

    @Override // defpackage.zx0
    public void f(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGatt == null) {
            dd1.b("BLEManager", "disConnectDevice-->bluetoothGatt == null");
            return;
        }
        if (bluetoothGattCharacteristic == null) {
            bluetoothGatt.disconnect();
            this.p.postDelayed(new j(bluetoothGatt), 500L);
        } else {
            bluetoothGattCharacteristic.setValue(l63.h("AA55FF"));
            bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
            this.p.postDelayed(this.w, 2000L);
        }
    }

    @Override // defpackage.zx0
    public boolean g(int i2) {
        dd1.a("BLEManager", "正在设置mtu:" + i2);
        BluetoothGatt bluetoothGatt = this.j;
        if (bluetoothGatt == null) {
            dd1.b("BLEManager", "setMtuValue-->mBluetoothGatt == null");
            return false;
        }
        int i3 = i2 + 3;
        if (i3 < 23) {
            return false;
        }
        boolean zRequestMtu = bluetoothGatt.requestMtu(i3);
        if (zRequestMtu) {
            this.p.postDelayed(this.y, ProtocolConstants.CONNECTION_TIMEOUT_MS);
        } else {
            ru1 ru1Var = this.i;
            if (ru1Var != null) {
                ru1Var.a("设置MTU操作失败！");
            }
        }
        return zRequestMtu;
    }

    @Override // defpackage.zx0
    public boolean h(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        if (bluetoothGattCharacteristic == null) {
            dd1.b("BLEManager", "sendMessage(byte[])-->writeGattCharacteristic == null");
            return false;
        }
        if (bluetoothGatt == null) {
            dd1.b("BLEManager", "sendMessage(byte[])-->bluetoothGatt == null");
            return false;
        }
        Log.d("BLEManager", "写特征设置值结果：" + bluetoothGattCharacteristic.setValue(bArr));
        return bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    @Override // defpackage.zx0
    public void i(boolean z, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGatt == null) {
            dd1.b("BLEManager", "enableNotification-->gatt == null");
        } else if (bluetoothGattCharacteristic == null) {
            dd1.b("BLEManager", "enableNotification-->characteristic == null");
        } else {
            bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z);
        }
    }

    @Override // defpackage.zx0
    public void j(Context context, BluetoothDevice bluetoothDevice, long j2, ru1 ru1Var) {
        if (bluetoothDevice == null) {
            dd1.b("BLEManager", "addBLEConnectDevice-->bluetoothDevice == null");
            return;
        }
        if (this.d == null) {
            dd1.b("BLEManager", "addBLEConnectDevice-->bluetooth4Adapter == null");
            return;
        }
        y();
        z();
        this.i = ru1Var;
        this.k = bluetoothDevice;
        BluetoothGatt bluetoothGatt = this.j;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
        }
        dd1.a("BLEManager", "开始准备连接：" + bluetoothDevice.getName() + "-->" + bluetoothDevice.getAddress());
        try {
            this.j = bluetoothDevice.connectGatt(context, false, this.t, 2);
        } catch (Exception e2) {
            dd1.b("BLEManager", "e:" + e2.getMessage());
        }
        this.p.postDelayed(this.u, j2);
    }
}
