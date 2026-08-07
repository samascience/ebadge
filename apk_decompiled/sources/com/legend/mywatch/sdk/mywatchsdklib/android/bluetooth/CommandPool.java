package com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;
import android.util.Log;
import defpackage.e20;
import defpackage.ez;
import defpackage.o72;
import defpackage.pp;
import defpackage.qm2;
import defpackage.rv2;
import defpackage.yc1;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class CommandPool implements Runnable {
    public static Semaphore m = new Semaphore(1);
    public static int n = 100;
    private static long o = 0;
    private static int p = 4000;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static c f285q;
    private Context b;
    private BluetoothGatt c;
    private b h;
    private String a = "CommandPool";
    private int e = 0;
    private boolean f = false;
    private boolean g = false;
    private int i = 10;
    private int j = n;
    private final AtomicBoolean k = new AtomicBoolean(false);
    private boolean l = false;
    private LinkedList d = new LinkedList();

    public enum Type {
        setNotification,
        read,
        write
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Type.values().length];
            a = iArr;
            try {
                iArr[Type.setNotification.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Type.read.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Type.write.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private class b {
        private int a;
        private int b = 0;
        private byte[] c;
        private Type d;
        private BluetoothGattCharacteristic e;
        private String f;

        b(Type type, byte[] bArr, BluetoothGattCharacteristic bluetoothGattCharacteristic, String str) {
            this.a = 0;
            this.c = bArr;
            this.e = bluetoothGattCharacteristic;
            this.d = type;
            this.f = str;
            this.a = CommandPool.this.e;
            CommandPool.this.e++;
        }

        String a() {
            return this.f;
        }

        int b() {
            return this.b;
        }

        int c() {
            return this.a;
        }

        BluetoothGattCharacteristic d() {
            return this.e;
        }

        Type e() {
            return this.d;
        }

        byte[] f() {
            return this.c;
        }

        void g(int i) {
            this.b = i;
        }

        public String toString() {
            return "Command{id=" + this.a + ", execute=" + this.b + ", value=" + Arrays.toString(this.c) + ", type=" + this.d + ", target=" + this.e + ", desc='" + this.f + "'}";
        }
    }

    public interface c {
        void a(String str, int i);
    }

    public CommandPool(Context context, BluetoothGatt bluetoothGatt) {
        this.c = bluetoothGatt;
        this.b = context;
    }

    private synchronized boolean d(Type type, byte[] bArr, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        boolean zL;
        try {
            int i = a.a[type.ordinal()];
            boolean z = true;
            zL = false;
            if (i == 1) {
                if (bArr.length <= 0) {
                    z = false;
                }
                zL = l(z, bluetoothGattCharacteristic);
            } else if (i == 2) {
                zL = j(bluetoothGattCharacteristic);
            } else if (i == 3) {
                zL = q(bluetoothGattCharacteristic, bArr);
            }
            o = System.currentTimeMillis();
        } catch (Throwable th) {
            throw th;
        }
        return zL;
    }

    private boolean e() {
        b bVar = this.h;
        if (bVar != null) {
            return bVar.a().toUpperCase().contains("ACK");
        }
        return false;
    }

    private void g() {
        if (this.l) {
            this.l = false;
            notify();
        }
    }

    private void i() {
        if (!this.d.contains(this.h)) {
            this.d.poll();
        } else {
            this.d.remove(this.h);
            this.h = null;
        }
    }

    private boolean j(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGatt = this.c;
        if (bluetoothGatt != null) {
            return bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
        }
        yc1.a(this.a, "BluetoothAdapter not initialized");
        this.d.poll();
        return false;
    }

    private boolean l(boolean z, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattDescriptor descriptor;
        BluetoothGatt bluetoothGatt = this.c;
        if (bluetoothGatt == null || bluetoothGattCharacteristic == null || !bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z) || (descriptor = bluetoothGattCharacteristic.getDescriptor(o72.d)) == null) {
            return false;
        }
        if (z) {
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        } else {
            descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        }
        boolean zWriteDescriptor = this.c.writeDescriptor(descriptor);
        for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
            if (z) {
                bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            } else {
                bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
            }
            this.c.writeDescriptor(bluetoothGattDescriptor);
        }
        return zWriteDescriptor;
    }

    public static void m(c cVar) {
        f285q = cVar;
    }

    public static void n(int i) {
        n = i;
    }

    private void p() throws InterruptedException {
        if (this.l) {
            return;
        }
        this.l = true;
        wait();
    }

    private boolean q(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        if (bluetoothGattCharacteristic == null || bArr == null || bArr.length == 0) {
            yc1.a(this.a, "指令或者设备有误，未能初始化");
            this.d.poll();
            return false;
        }
        try {
            m.acquire(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bluetoothGattCharacteristic.setValue(bArr);
        boolean zWriteCharacteristic = this.c.writeCharacteristic(bluetoothGattCharacteristic);
        if (!zWriteCharacteristic) {
            m.release();
        }
        return zWriteCharacteristic;
    }

    public synchronized void c(Type type, byte[] bArr, BluetoothGattCharacteristic bluetoothGattCharacteristic, String str, int i, boolean z) {
        if (bArr != null) {
            if (bArr.length != 0) {
                if (bluetoothGattCharacteristic == null) {
                    yc1.a(this.a, "addCommand: target is null, desc: " + str);
                    return;
                }
                if (type != Type.write) {
                    this.d.offer(new b(type, bArr, bluetoothGattCharacteristic, str));
                } else if (!z || bArr.length > i) {
                    int iRound = (int) Math.round(((double) (bArr.length / i)) + 0.5d);
                    for (int i2 = 0; i2 < iRound; i2++) {
                        int i3 = i2 * i;
                        int length = i3 + i;
                        if (length > bArr.length) {
                            length = bArr.length;
                        }
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i3, length);
                        if (bArrCopyOfRange == null || bArrCopyOfRange.length == 0) {
                            yc1.a(this.a, "addCommand: split packet value is null, i=" + i2 + ", desc: " + str);
                        } else {
                            this.d.offer(new b(type, bArrCopyOfRange, bluetoothGattCharacteristic, str));
                        }
                    }
                } else {
                    this.d.addFirst(new b(type, bArr, bluetoothGattCharacteristic, str));
                }
                g();
                return;
            }
        }
        yc1.a(this.a, "addCommand: value is null or empty, desc: " + str);
    }

    public boolean f() {
        long jCurrentTimeMillis = System.currentTimeMillis() - o;
        boolean z = jCurrentTimeMillis > ((long) p);
        yc1.a(this.a, "=================distTime:" + jCurrentTimeMillis + ";isCompleted:" + this.f + ";isDone:" + this.g);
        return z;
    }

    public void h() {
        this.f = true;
        m.release(1);
    }

    public synchronized int k(String str) {
        int i = 0;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    Iterator it = this.d.iterator();
                    while (it.hasNext()) {
                        b bVar = (b) it.next();
                        if (bVar != null && bVar.a() != null && bVar.a().startsWith(str)) {
                            it.remove();
                            i++;
                        }
                    }
                    if (i > 0) {
                        yc1.a(this.a, "Removed " + i + " commands with prefix: " + str);
                    }
                    return i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return 0;
    }

    public synchronized void o() {
        this.k.set(false);
        g();
    }

    @Override // java.lang.Runnable
    public void run() {
        String strA;
        this.k.set(true);
        while (this.k.get()) {
            Log.i(this.a, "command count size:" + ez.b(this.d) + ";sendSpaceDuraion:" + n + ";mThreadWaitDuration:" + this.j);
            synchronized (this) {
                try {
                    if (e20.d != 1) {
                        this.d = new LinkedList();
                        p();
                    } else {
                        if (this.d.peek() == null) {
                            this.h = null;
                            p();
                        } else {
                            boolean z = this.g;
                            if (z || !e20.b) {
                                boolean z2 = this.f;
                                if (z2 && z) {
                                    b bVar = this.h;
                                    if (bVar != null && f285q != null && (strA = bVar.a()) != null && strA.contains("实时预览图片数据")) {
                                        f285q.a(strA, this.h.c());
                                    }
                                    i();
                                    this.f = false;
                                    this.g = false;
                                } else if ((!z2 || !e20.b) && f()) {
                                    h();
                                    e20.b = true;
                                    yc1.a(this.a, "================>>处理超时");
                                }
                            } else {
                                if (this.h == null) {
                                    this.h = (b) this.d.peek();
                                }
                                if (this.h != null) {
                                    if (e()) {
                                        this.j = 10;
                                    } else {
                                        this.j = n;
                                    }
                                    int iB = this.h.b();
                                    if (iB >= this.i) {
                                        yc1.a(this.a, "--" + this.h.a() + "(ID:" + this.h.c() + ")命令执行失败次数超过" + iB + "次,跳过执行");
                                        this.g = true;
                                        this.f = true;
                                    } else {
                                        byte[] bArrG = rv2.b(this.h.a(), "设置系统时间") ? qm2.G() : this.h.f();
                                        if (bArrG == null || bArrG.length == 0) {
                                            yc1.a(this.a, "Command value is null before execute, ID: " + this.h.c() + ", desc: " + this.h.a());
                                            this.g = false;
                                        } else {
                                            this.g = d(this.h.e(), bArrG, this.h.d());
                                        }
                                        yc1.a(this.a, "--" + this.h.a() + "(ID:" + this.h.c() + ")命令已执行==类型" + this.h.e() + "==value:" + pp.d(this.h.f()) + "==命令结果==" + this.g);
                                        this.h.g(iB + 1);
                                    }
                                }
                            }
                        }
                        Thread.sleep(this.j);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    yc1.a(this.a, "================>>线程异常:" + e);
                }
            }
        }
        yc1.a(this.a, "================>> commandPool run:发送线程停止");
    }
}
