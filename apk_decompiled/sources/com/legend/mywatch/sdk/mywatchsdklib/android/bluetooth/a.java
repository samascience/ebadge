package com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.util.Log;
import com.baji.protocol.model.ProtocolConstants;
import com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.a;
import com.legend.mywatch.sdk.mywatchsdklib.android.enm.BluetoothStatusEnum;
import com.legend.mywatch.sdk.mywatchsdklib.android.enm.PlatformTypeEnum;
import com.legend.mywatch.sdk.mywatchsdklib.android.excepion.NotSupportBluetoothException;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.i;
import com.tencent.connect.common.Constants;
import defpackage.ak;
import defpackage.e20;
import defpackage.f33;
import defpackage.f92;
import defpackage.hh;
import defpackage.i10;
import defpackage.o10;
import defpackage.o72;
import defpackage.pp;
import defpackage.qm2;
import defpackage.rv2;
import defpackage.tg3;
import defpackage.ug3;
import defpackage.w32;
import defpackage.wi;
import defpackage.wj;
import defpackage.wr2;
import defpackage.y90;
import defpackage.yc1;
import defpackage.yj;
import defpackage.zi2;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import xfkj.fitpro.activity.ota.constant.Constant;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static long A;
    public static Semaphore x = new Semaphore(1);
    private static wj y;
    private static a z;
    private Application a;
    private BluetoothManager c;
    private BluetoothAdapter d;
    private BluetoothGatt e;
    private CommandPool f;
    private com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.c g;
    private BluetoothGattCharacteristic h;
    private BluetoothGattCharacteristic k;
    private BluetoothGattCharacteristic l;
    private BluetoothGattCharacteristic m;
    private Date n;
    private c r;
    d s;
    h t;
    g u;
    f v;
    e w;
    private String b = "LeService";
    private int i = 0;
    private boolean j = false;
    private BluetoothGattCallback o = new C0096a();
    private boolean p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f286q = 20;

    /* JADX INFO: renamed from: com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.a$a, reason: collision with other inner class name */
    class C0096a extends BluetoothGattCallback {
        C0096a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            a.this.m0("onCharacteristicChanged", bluetoothGatt, bluetoothGattCharacteristic);
            a.this.j0("------收到数据包------>" + pp.d(bluetoothGattCharacteristic.getValue()));
            if (bluetoothGattCharacteristic.getUuid().equals(o72.j)) {
                byte[] value = bluetoothGattCharacteristic.getValue();
                a.this.l0(value, bluetoothGatt);
                a.this.j0("battery src1:" + com.legend.mywatch.sdk.mywatchsdklib.android.utils.d.a(value));
            } else {
                a.this.o0(bluetoothGattCharacteristic.getValue(), bluetoothGatt.getDevice().getAddress());
            }
            tg3.m().l().g();
            yj yjVarB = tg3.m().l().b();
            if (yjVarB != null) {
                byte[] value2 = bluetoothGattCharacteristic.getValue();
                yjVarB.a(value2, bluetoothGattCharacteristic.getUuid(), bluetoothGatt.getDevice().getAddress(), System.currentTimeMillis(), value2.length, true);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            a.this.m0("onCharacteristicRead", bluetoothGatt, bluetoothGattCharacteristic, Integer.valueOf(i));
            a.this.f.h();
            int iB = 1;
            if (bluetoothGattCharacteristic.getUuid().equals(o72.j)) {
                byte[] value = bluetoothGattCharacteristic.getValue();
                a.this.j0("battery service found:" + com.legend.mywatch.sdk.mywatchsdklib.android.utils.d.a(value));
                a.this.l0(new byte[]{value[0]}, bluetoothGatt);
                a.this.E(bluetoothGattCharacteristic, new byte[]{1}, "开启电量通知");
            } else if (bluetoothGattCharacteristic.getUuid().equals(o72.g)) {
                tg3.k(new wr2(pp.e(bluetoothGattCharacteristic.getValue())), bluetoothGatt.getDevice().getAddress());
                zi2.s();
                zi2.s();
                zi2.e().K(qm2.s(), "发送系统类型");
                Locale locale = Locale.getDefault();
                if (locale == Locale.CHINA) {
                    iB = 0;
                } else if (locale != Locale.ENGLISH) {
                    iB = locale == Locale.TAIWAN ? 2 : com.legend.mywatch.sdk.mywatchsdklib.android.utils.g.b(locale.getLanguage());
                }
                e20.a.K(qm2.E(iB), "设置语言");
            } else if (bluetoothGattCharacteristic.getUuid().equals(o72.h)) {
                tg3.k(f92.b(bluetoothGattCharacteristic.getValue()), bluetoothGatt.getDevice().getAddress());
            } else if (bluetoothGattCharacteristic.getUuid().equals(o72.k)) {
                String strE = pp.e(bluetoothGattCharacteristic.getValue());
                if (rv2.h(strE)) {
                    return;
                } else {
                    tg3.k(new y90(strE), bluetoothGatt.getDevice().getAddress());
                }
            }
            yj yjVarB = tg3.m().l().b();
            if (yjVarB != null && i == 0) {
                byte[] value2 = bluetoothGattCharacteristic.getValue();
                yjVarB.a(value2, bluetoothGattCharacteristic.getUuid(), bluetoothGatt.getDevice().getAddress(), System.currentTimeMillis(), value2.length, false);
                return;
            }
            if (yjVarB != null && i != 0) {
                yjVarB.b(i, "Characteristic read failed with status: " + i, bluetoothGatt.getDevice().getAddress(), bluetoothGattCharacteristic.getUuid());
                return;
            }
            if (bluetoothGattCharacteristic.getUuid().equals(o72.k)) {
                String strE2 = pp.e(bluetoothGattCharacteristic.getValue());
                if (rv2.h(strE2)) {
                    return;
                }
                String upperCase = strE2.toUpperCase();
                a.this.j0("device name:" + upperCase);
                if (upperCase.contains(Constant.RETECK_OTA_FLAG)) {
                    ug3.i(2);
                    a.this.n0(PlatformTypeEnum.RETECK, bluetoothGatt.getDevice().getAddress());
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            a.this.m0("onCharacteristicWrite", bluetoothGatt, bluetoothGattCharacteristic, Integer.valueOf(i));
            a.this.j0("onCharacteristicWrite");
            a.this.f.h();
            a.x.release(1);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            a.this.m0("onConnectionStateChange", bluetoothGatt, Integer.valueOf(i), Integer.valueOf(i2));
            a.this.j0("收到蓝牙连接状态变化onConnectionStateChange status(0正常):" + i + "  newState(0断开,2连接):" + i2);
            if (com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.b.a() && a.this.i == i2) {
                a.this.j0("onConnectionStateChange回调过快");
                return;
            }
            a.this.y0(i2);
            HashMap map = new HashMap();
            map.put("action", "state");
            map.put("what", 2121);
            a.y.q(false);
            a.this.z();
            a.this.y();
            if (i != 0) {
                a.this.B();
                yj yjVarB = tg3.m().l().b();
                if (yjVarB != null) {
                    yjVarB.b(i, "Connection failed with status: " + i, bluetoothGatt.getDevice().getAddress(), null);
                }
            } else {
                if (i2 == 2) {
                    if (rv2.f(ug3.c())) {
                        a.this.B();
                        return;
                    }
                    try {
                        Thread.sleep(800L);
                        a.this.t0();
                        a.this.j0("start discover");
                        a.this.E0();
                        e20.b = true;
                        if (a.this.f != null) {
                            a.this.f.o();
                            a.this.f = null;
                        }
                        a.this.f = new CommandPool(a.this.a, a.this.e);
                        e20.c.removeCallbacks(a.this.r);
                        e20.c.postDelayed(a.this.r, 200L);
                        map.put("state", "1");
                        yj yjVarB2 = tg3.m().l().b();
                        if (yjVarB2 != null) {
                            yjVarB2.c(true, bluetoothGatt.getDevice().getAddress(), i2);
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        a.this.j0("start get mtu exception");
                        a.this.B();
                        return;
                    }
                }
                if (i2 == 0) {
                    a.this.B();
                    map.put("state", "0");
                    a.y.l();
                    yj yjVarB3 = tg3.m().l().b();
                    if (yjVarB3 != null) {
                        yjVarB3.c(false, bluetoothGatt.getDevice().getAddress(), i2);
                    }
                } else {
                    a.this.B();
                }
            }
            tg3.i(e20.d, bluetoothGatt.getDevice().getAddress());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            a.this.m0("onDescriptorRead", bluetoothGatt, bluetoothGattDescriptor, Integer.valueOf(i));
            a.this.j0("onDescriptorRead:" + bluetoothGattDescriptor + ";" + i);
            a.this.f.h();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            a.this.m0("onDescriptorWrite", bluetoothGatt, bluetoothGattDescriptor, Integer.valueOf(i));
            a.this.j0("onDescriptorWrite:" + bluetoothGattDescriptor.getUuid().toString() + ";" + i);
            a.this.f.h();
            if (!bluetoothGattDescriptor.getUuid().equals(o72.c) || i == 0) {
                return;
            }
            a.this.j0("notify closed close ble");
            a.this.B();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            a.this.m0("onMtuChanged", bluetoothGatt, Integer.valueOf(i), Integer.valueOf(i2));
            super.onMtuChanged(bluetoothGatt, i, i2);
            a.this.y();
            a.this.j0("onMtuChanged mtu:" + i + ";status:" + i2);
            if (a.this.e != null) {
                if (i2 != 0) {
                    a.this.B();
                    return;
                }
                if (i > 500) {
                    a.this.f286q = i - tg3.m().l().f();
                } else {
                    a.this.f286q = i - 3;
                }
                a.this.D0();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            a.this.m0("onServicesDiscovered", bluetoothGatt, Integer.valueOf(i));
            a.this.j0("onServicesDiscovered status = " + i);
            a.this.z();
            if (i == 0) {
                a.this.b0(bluetoothGatt);
                return;
            }
            a.this.j0("获取蓝牙服务失败 onServicesDiscovered received: " + i);
            a.this.B();
        }
    }

    class b implements com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.c.a {
        final /* synthetic */ byte[] a;

        b(byte[] bArr) {
            this.a = bArr;
        }

        @Override // com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.c.a
        public byte[] a() {
            return this.a;
        }

        @Override // com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.c.a
        public void b(byte[] bArr) {
            a.this.v0(bArr);
        }
    }

    private class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f != null) {
                new Thread(a.this.f).start();
            }
        }

        private c() {
        }
    }

    private class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            a.this.j0("触发了连接超时机制");
            a.this.B();
        }

        private d() {
        }
    }

    private class e implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.p) {
                a.this.j0("isConnecting连接状态正常");
            } else {
                a.this.j0("isConnecting连接状态超时，关闭蓝牙");
                a.this.x0(false);
            }
        }

        private e() {
        }
    }

    private class f implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (e20.d == 1 || a.this.i != 2) {
                a.this.j0("本地连接状态正常");
            } else {
                a.this.j0("本地连接状态超时，关闭蓝牙");
                a.this.B();
            }
        }

        private f() {
        }
    }

    private class g implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            a.this.j0("MTU获取超时，关闭蓝牙");
            a.this.B();
        }

        private g() {
        }
    }

    private class h implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            a.this.j0("扫描服务超时，关闭蓝牙");
            a.this.B();
        }

        private h() {
        }
    }

    public a() {
        this.r = new c();
        this.s = new d();
        this.t = new h();
        this.u = new g();
        this.v = new f();
        this.w = new e();
    }

    private void B0() {
        v();
        e20.c.postDelayed(this.s, 30000L);
    }

    private void C(CommandPool.Type type, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, String str, int i) {
        D(type, bluetoothGattCharacteristic, bArr, str, i, false);
    }

    private void D(CommandPool.Type type, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, String str, int i, boolean z2) {
        this.f.c(type, bArr, bluetoothGattCharacteristic, str, i, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        H0();
        BluetoothGatt bluetoothGattV = V();
        if (bluetoothGattV == null) {
            j0("cannot startDiscoverBleService");
        } else {
            bluetoothGattV.discoverServices();
            j0("startDiscoverBleService");
        }
    }

    private void G0() {
        i10 i10VarL = tg3.m().l();
        final long jH = i10VarL.h() * 1000;
        final boolean zK = i10VarL.k();
        new Thread(new Runnable() { // from class: ui
            @Override // java.lang.Runnable
            public final void run() {
                a.i0(jH, zK);
            }
        }).start();
    }

    private void U(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BluetoothGattService bluetoothGattService = (BluetoothGattService) it.next();
            List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
            if (bluetoothGattService.getUuid().equals(o72.f)) {
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                    if (bluetoothGattCharacteristic.getUuid().equals(o72.g)) {
                        this.k = bluetoothGattCharacteristic;
                        r0();
                    } else if (bluetoothGattCharacteristic.getUuid().equals(o72.h)) {
                        this.l = bluetoothGattCharacteristic;
                        p0();
                    } else if (bluetoothGattCharacteristic.getUuid().equals(o72.k)) {
                        this.m = bluetoothGattCharacteristic;
                        q0();
                    }
                }
            } else if (bluetoothGattService.getUuid().equals(o72.i)) {
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : characteristics) {
                    if (bluetoothGattCharacteristic2.getUuid().equals(o72.j)) {
                        G(bluetoothGattCharacteristic2, new byte[]{1}, "读取电量");
                    }
                }
            } else if (bluetoothGattService.getUuid().equals(o72.l)) {
                j0("telink ota charic value");
                ug3.i(1);
                n0(PlatformTypeEnum.TELINK, ug3.c());
            } else if (bluetoothGattService.getUuid().equals(o72.m)) {
                j0("ly ota charic value");
                ug3.i(5);
                n0(PlatformTypeEnum.LY, ug3.c());
            } else if (bluetoothGattService.getUuid().equals(o72.n)) {
                j0("lp ota charic value");
                ug3.i(6);
                n0(PlatformTypeEnum.LP, ug3.c());
            } else if (g0(bluetoothGattService)) {
                j0("jli ota charic value");
                ug3.i(7);
                n0(PlatformTypeEnum.JLI, ug3.c());
            }
        }
    }

    public static synchronized a Z() {
        try {
            if (z == null) {
                z = new a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(BluetoothGatt bluetoothGatt) {
        List<BluetoothGattService> services = bluetoothGatt.getServices();
        UUID uuidT = T(services);
        if (uuidT == null) {
            k0(bluetoothGatt);
            return;
        }
        o72.b(uuidT);
        x0(false);
        x();
        tg3.i(BluetoothStatusEnum.CONNECTED.getValue(), bluetoothGatt.getDevice().getAddress());
        d0(services);
        U(services);
        this.n = f33.a();
    }

    private void d0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BluetoothGattService bluetoothGattService = (BluetoothGattService) it.next();
            List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
            if (bluetoothGattService.getUuid().equals(o72.a())) {
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                    j0("initNotifyAndWriteChannel BluetoothGattCharacteristic:" + bluetoothGattCharacteristic.getUuid());
                    if (bluetoothGattCharacteristic.getUuid().equals(o72.b)) {
                        j0("start uartWriteCharacteristicUUID:");
                        this.h = bluetoothGattCharacteristic;
                        if (!ug3.b()) {
                            H(bluetoothGattCharacteristic, qm2.r(), "android蓝牙配对");
                            ug3.f(true);
                        }
                    } else if (bluetoothGattCharacteristic.getUuid().equals(o72.c)) {
                        j0("start uartNotifyCharacteristicUUID:");
                        F(bluetoothGattCharacteristic, new byte[]{1}, "开启通知", true);
                    } else if (bluetoothGattCharacteristic.getUuid().equals(o72.e)) {
                        j0("start 开启接收log的数据通道:");
                        F(bluetoothGattCharacteristic, new byte[]{1}, "开启接收log的数据通道", true);
                    }
                }
            }
        }
    }

    public static boolean f0(String str) {
        String upperCase = str.toUpperCase();
        return upperCase.startsWith("7E4") && upperCase.endsWith("F393-E0A9-E50E24DCCA9D");
    }

    private static boolean g0(BluetoothGattService bluetoothGattService) {
        return bluetoothGattService.getUuid().toString().equalsIgnoreCase(o72.o.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(String str) {
        if (e20.d == 1) {
            j0("connect === 已连接");
            return;
        }
        j0("connect === 10秒之后还连接不上就直连:" + str);
        R(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Infinite loop detected, blocks: 12, insns: 0 */
    public static /* synthetic */ void i0(long j, boolean z2) {
        while (true) {
            try {
                Thread.sleep(j);
                if (z2) {
                    y.l();
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(String str) {
        yc1.a(this.b, str);
    }

    private void k0(BluetoothGatt bluetoothGatt) {
        j0("notMatchDevice");
        tg3.i(o10.b, bluetoothGatt.getDevice().getAddress());
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(byte[] bArr, BluetoothGatt bluetoothGatt) {
        int iG = pp.g(pp.d(bArr));
        Integer numValueOf = Integer.valueOf(iG);
        tg3.k(new hh(iG), bluetoothGatt.getDevice().getAddress());
        j0("onCharacteristicRead Value :设备信息  电量 " + numValueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x0081  */
    public void m0(String str, BluetoothGatt bluetoothGatt, Object... objArr) {
        List<BluetoothGattCallback> listC = tg3.m().l().c();
        if (listC == null || listC.isEmpty()) {
            return;
        }
        for (BluetoothGattCallback bluetoothGattCallback : listC) {
            try {
                switch (str) {
                    case "onConnectionStateChange":
                        bluetoothGattCallback.onConnectionStateChange(bluetoothGatt, ((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                        break;
                    case "onServicesDiscovered":
                        bluetoothGattCallback.onServicesDiscovered(bluetoothGatt, ((Integer) objArr[0]).intValue());
                        break;
                    case "onCharacteristicRead":
                        bluetoothGattCallback.onCharacteristicRead(bluetoothGatt, (BluetoothGattCharacteristic) objArr[0], ((Integer) objArr[1]).intValue());
                        break;
                    case "onCharacteristicWrite":
                        bluetoothGattCallback.onCharacteristicWrite(bluetoothGatt, (BluetoothGattCharacteristic) objArr[0], ((Integer) objArr[1]).intValue());
                        break;
                    case "onCharacteristicChanged":
                        bluetoothGattCallback.onCharacteristicChanged(bluetoothGatt, (BluetoothGattCharacteristic) objArr[0]);
                        break;
                    case "onMtuChanged":
                        bluetoothGattCallback.onMtuChanged(bluetoothGatt, ((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                        break;
                    case "onDescriptorRead":
                        bluetoothGattCallback.onDescriptorRead(bluetoothGatt, (BluetoothGattDescriptor) objArr[0], ((Integer) objArr[1]).intValue());
                        break;
                    case "onDescriptorWrite":
                        bluetoothGattCallback.onDescriptorWrite(bluetoothGatt, (BluetoothGattDescriptor) objArr[0], ((Integer) objArr[1]).intValue());
                        break;
                }
            } catch (Exception e2) {
                j0("External callback error in " + str + ": " + e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(PlatformTypeEnum platformTypeEnum, String str) {
        tg3.k(new w32(platformTypeEnum), str);
        j0("平台类型已识别: " + platformTypeEnum.getName() + " (类型: " + platformTypeEnum.getValue() + ")");
    }

    private synchronized void s0() {
        BluetoothGatt bluetoothGatt;
        try {
            Method method = BluetoothGatt.class.getMethod("refresh", null);
            if (method != null && (bluetoothGatt = this.e) != null) {
                j0("refreshDeviceCache, is success:  " + ((Boolean) method.invoke(bluetoothGatt, null)).booleanValue());
            }
        } catch (Exception e2) {
            j0("exception occur while refreshing device: " + e2.getMessage());
            e2.printStackTrace();
        }
    }

    private void v() {
        e20.c.removeCallbacks(this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(byte[] bArr) {
        byte b2;
        byte b3;
        j0("returnAck--------ack2------" + pp.d(bArr));
        if (bArr.length >= 8) {
            b2 = bArr[3];
            b3 = bArr[4];
        } else {
            b2 = 0;
            b3 = 0;
        }
        if (b2 == 33 && b3 == 3) {
            j0("游戏指令不回复ack");
        } else if (qm2.M(bArr)) {
            j0("suppress BLE write: product26 AI STREAM_FRAME CD ack (send-side policy)");
        } else {
            P(bArr, "ack");
        }
    }

    private void w() {
        j0("取消isConnecting连接状态超时机制");
        e20.c.removeCallbacks(this.w);
    }

    private void w0(final String str) {
        j0("========scanConnect");
        wj.m().q(true);
        e20.c.postDelayed(new Runnable() { // from class: ti
            @Override // java.lang.Runnable
            public final void run() {
                this.a.h0(str);
            }
        }, ProtocolConstants.CONNECTION_TIMEOUT_MS);
    }

    private void x() {
        j0("取消本地连接状态超时机制");
        e20.c.removeCallbacks(this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void x0(boolean z2) {
        try {
            this.p = z2;
            if (z2) {
                C0();
            } else {
                w();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        j0("cancelMtuGetTimeout");
        e20.c.removeCallbacks(this.u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        j0("cancelScanServicesTimeout");
        e20.c.removeCallbacks(this.t);
    }

    public boolean A() {
        BluetoothAdapter bluetoothAdapter;
        if (!tg3.m().l().k()) {
            j0("checkConnetGatt === 不允许自动重连");
            return false;
        }
        if (e20.e > 0 || e20.f > 0 || (bluetoothAdapter = this.d) == null || !bluetoothAdapter.isEnabled()) {
            return false;
        }
        if (e20.d == 1 || this.i == 2) {
            j0("checkConnetGatt->connetState:" + e20.d + ";localBleStatus:" + this.i);
            return true;
        }
        String strE = ug3.e();
        if (this.p) {
            j0("checkConnetGatt === 已经存在正在尝试连接进程1");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - A <= 15000) {
            j0("checkConnetGatt 两次连接之间的间隔不能少于15秒--");
            return false;
        }
        A = jCurrentTimeMillis;
        j0("尝试连接蓝牙地址checkConnetGatt->address:" + strE);
        if (rv2.f(strE)) {
            return false;
        }
        tg3.i(BluetoothStatusEnum.CONNECTING.getValue(), strE);
        if (!ak.i()) {
            j0("can not scan connect");
            return R(strE);
        }
        w0(strE);
        j0("can scan connect");
        return true;
    }

    public void A0(String str) {
        z0(this.d.getRemoteDevice(str));
    }

    public void B() {
        try {
            if (this.e == null) {
                x0(false);
                tg3.i(BluetoothStatusEnum.DISCONNECT.getValue(), Constants.STR_EMPTY);
                return;
            }
            j0("close------------------关闭BLE连接服务");
            S();
            s0();
            this.e.close();
            A = 0L;
            y0(0);
            x0(false);
            tg3.i(BluetoothStatusEnum.DISCONNECT.getValue(), this.e.getDevice().getAddress());
            this.e = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void C0() {
        w();
        j0("启动isConnecting连接状态超时机制");
        e20.c.postDelayed(this.w, 30000L);
    }

    public void E(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, String str) {
        F(bluetoothGattCharacteristic, bArr, str, false);
    }

    public void E0() {
        if (this.i == 2) {
            j0("启动本地连接状态超时机制");
            x();
            e20.c.postDelayed(this.v, 22000L);
        }
    }

    public void F(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, String str, boolean z2) {
        D(CommandPool.Type.setNotification, bluetoothGattCharacteristic, bArr, str, 20, z2);
    }

    public void F0() {
        y();
        j0("startMtuGetTimeout");
        e20.c.postDelayed(this.u, ProtocolConstants.CONNECTION_TIMEOUT_MS);
    }

    public void G(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, String str) {
        if (wi.a().b()) {
            j0("blocking other data: dial upgrade or preview in progress");
        } else {
            C(CommandPool.Type.read, bluetoothGattCharacteristic, bArr, str, 20);
        }
    }

    public void H(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, String str) {
        if (wi.a().b()) {
            j0("blocking other data: dial upgrade or preview in progress");
        } else {
            I(bluetoothGattCharacteristic, bArr, str, 20);
        }
    }

    public void H0() {
        j0("startScanServicesTimeout");
        z();
        e20.c.postDelayed(this.t, ProtocolConstants.CONNECTION_TIMEOUT_MS);
    }

    public void I(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, String str, int i) {
        J(bluetoothGattCharacteristic, bArr, str, i, false);
    }

    public void J(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, String str, int i, boolean z2) {
        if (this.d == null || this.e == null) {
            j0("commandPoolWrite mBluetoothAdapter is null or mBluetoothGatt is null");
            tg3.i(BluetoothStatusEnum.DISCONNECT.getValue(), Constants.STR_EMPTY);
            B();
        } else {
            if (W()) {
                if (this.d == null || this.e == null) {
                    j0("commandPoolWrite mBluetoothAdapter is null or mBluetoothGatt is null");
                    return;
                } else {
                    D(CommandPool.Type.write, bluetoothGattCharacteristic, bArr, str, i, z2);
                    return;
                }
            }
            j0("commandPoolWrite not hasWriteChar:" + str);
            zi2.e().B();
            tg3.i(BluetoothStatusEnum.DISCONNECT.getValue(), Constants.STR_EMPTY);
        }
    }

    public void K(byte[] bArr, String str) {
        I(this.h, bArr, str, a0());
    }

    public void L(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, String str, int i) {
        I(bluetoothGattCharacteristic, bArr, str, i);
    }

    public void M(byte[] bArr, String str) {
        L(this.h, bArr, str, a0());
    }

    public void N(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, String str, int i) {
        if (this.d == null || this.e == null) {
            j0("commandPoolWriteClockDialForStop: mBluetoothAdapter is null or mBluetoothGatt is null");
            return;
        }
        if (W()) {
            D(CommandPool.Type.write, bluetoothGattCharacteristic, bArr, str, i, true);
            Log.i(this.b, "commandPoolWriteClockDialForStop: command added with high priority");
        } else {
            j0("commandPoolWriteClockDialForStop: not hasWriteChar:" + str);
        }
    }

    public void O(byte[] bArr, String str) {
        Log.i(this.b, "commandPoolWriteClockDialForStop: mut = " + a0());
        N(this.h, bArr, str, a0());
    }

    public void P(byte[] bArr, String str) {
        J(this.h, bArr, str, a0(), true);
    }

    public synchronized boolean Q(BluetoothDevice bluetoothDevice) {
        String address = bluetoothDevice.getAddress();
        if (this.p) {
            j0("isconnectting");
            return false;
        }
        j0("connect:" + address);
        if (e20.d == 1) {
            x0(false);
            j0("checkConnetGatt->connetState:" + e20.d);
            return true;
        }
        if (!BluetoothAdapter.checkBluetoothAddress(address)) {
            x0(false);
            j0("不合法的mac地址:" + address + "--");
            return false;
        }
        if (this.d == null) {
            x0(false);
            j0("BluetoothAdapter not initialized or unspecified address." + address + "--");
            return false;
        }
        y.q(false);
        if (this.e != null) {
            S();
        }
        try {
            x0(true);
            j0("<<===================================================================>>");
            j0("connect 连接地址--" + address);
            B0();
            this.e = bluetoothDevice.connectGatt(i.a(), false, this.o, 2);
            v();
            try {
                if (this.e == null) {
                    x0(false);
                    B();
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        } catch (Exception e3) {
            j0("connect device exception:" + e3);
            v();
            x0(false);
            B();
            return false;
        }
    }

    public synchronized boolean R(String str) {
        BluetoothDevice remoteDevice = this.d.getRemoteDevice(str);
        if (remoteDevice == null) {
            return false;
        }
        return Q(remoteDevice);
    }

    public synchronized void S() {
        BluetoothGatt bluetoothGatt;
        try {
            j0("disconnect------------------断开连接");
            if (this.d == null || (bluetoothGatt = this.e) == null) {
                j0("BluetoothAdapter not initialized");
                return;
            }
            try {
                bluetoothGatt.disconnect();
                this.e.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public UUID T(List list) {
        if (!tg3.m().l().j()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                BluetoothGattService bluetoothGattService = (BluetoothGattService) it.next();
                if (o72.a().equals(bluetoothGattService.getUuid())) {
                    return bluetoothGattService.getUuid();
                }
            }
            return null;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            BluetoothGattService bluetoothGattService2 = (BluetoothGattService) it2.next();
            String string = bluetoothGattService2.getUuid().toString();
            if (f0(string)) {
                j0("isFindMainServiceUUID:" + string);
                return bluetoothGattService2.getUuid();
            }
        }
        return null;
    }

    public BluetoothGatt V() {
        return this.e;
    }

    public boolean W() {
        BluetoothGattService service;
        if (this.h != null) {
            return true;
        }
        if (!this.e.discoverServices() || (service = this.e.getService(o72.a())) == null) {
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(o72.b);
        this.h = characteristic;
        return characteristic != null;
    }

    public CommandPool X() {
        return this.f;
    }

    public Date Y() {
        return this.n;
    }

    public int a0() {
        return this.f286q;
    }

    public synchronized void c0() {
        if (!this.j) {
            this.a = i.a();
            e20.a = this;
            zi2.e().e0();
            this.g = new com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.c();
            y = wj.m();
            G0();
            this.j = true;
        }
    }

    public boolean e0() {
        if (!i.a().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            throw new NotSupportBluetoothException();
        }
        BluetoothManager bluetoothManager = (BluetoothManager) i.a().getSystemService("bluetooth");
        this.c = bluetoothManager;
        if (bluetoothManager == null) {
            j0("无法初始化蓝牙管理器.");
            return false;
        }
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        this.d = adapter;
        if (adapter != null) {
            return true;
        }
        throw new NotSupportBluetoothException("not find BluetoothAdapter");
    }

    public void o0(byte[] bArr, String str) {
        this.g.g0(new b(bArr), str);
    }

    public void p0() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.l;
        if (bluetoothGattCharacteristic != null) {
            G(bluetoothGattCharacteristic, new byte[]{1}, "读取自定义功能");
        } else {
            j0("mReadCustomFuncCharacteristic is null");
        }
    }

    public void q0() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.m;
        if (bluetoothGattCharacteristic != null) {
            G(bluetoothGattCharacteristic, new byte[]{1}, "读取设备名");
        } else {
            j0("mReadDeviceNameCharacteristic is null");
        }
    }

    public void r0() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.k;
        if (bluetoothGattCharacteristic != null) {
            G(bluetoothGattCharacteristic, new byte[]{1}, "读取版本号");
        } else {
            j0("mReadVersionCharacteristic is null");
        }
    }

    public void t0() {
        u0(512);
        F0();
    }

    public void u0(int i) {
        BluetoothGatt bluetoothGatt = this.e;
        if (bluetoothGatt != null) {
            bluetoothGatt.requestConnectionPriority(1);
            this.e.requestMtu(i);
        }
    }

    public synchronized void y0(int i) {
        this.i = i;
    }

    public void z0(BluetoothDevice bluetoothDevice) {
        String address = bluetoothDevice.getAddress();
        String name = bluetoothDevice.getName();
        x0(false);
        ug3.g(address);
        if (name != null && !name.isEmpty()) {
            ug3.h(name);
        }
        if (this.e != null) {
            S();
        }
        Q(bluetoothDevice);
    }
}
