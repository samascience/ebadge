package com.telink.ota.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import com.tencent.connect.common.Constants;
import defpackage.vx1;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends BluetoothGattCallback {
    protected final Runnable h;
    protected final Runnable i;
    protected final Runnable j;
    protected final Runnable k;
    protected final Runnable l;
    protected BluetoothDevice o;
    protected BluetoothGatt p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected List f312q;
    protected boolean s;
    protected long v;
    private Context y;
    private int a = BluetoothConstant.RECEIVE_OTA_CMD_TIMEOUT;
    protected final Queue b = new ConcurrentLinkedQueue();
    protected final Queue c = new ConcurrentLinkedQueue();
    protected final Map d = new ConcurrentHashMap();
    protected final Handler e = new Handler(Looper.getMainLooper());
    protected final Handler f = new Handler(Looper.getMainLooper());
    protected final Handler g = new Handler(Looper.getMainLooper());
    private final Object m = new Object();
    private final Object n = new Object();
    protected Boolean r = Boolean.FALSE;
    protected int t = 5000;
    protected int u = 10000;
    private AtomicInteger w = new AtomicInteger(1);
    protected AtomicBoolean x = new AtomicBoolean(false);
    private boolean z = false;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Command.CommandType.values().length];
            a = iArr;
            try {
                iArr[Command.CommandType.READ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Command.CommandType.WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Command.CommandType.READ_DESCRIPTOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Command.CommandType.WRITE_NO_RESPONSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Command.CommandType.ENABLE_NOTIFY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Command.CommandType.DISABLE_NOTIFY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private final class b {
        public Command a;
        public Command.a b;

        public b(Command.a aVar, Command command) {
            this.b = aVar;
            this.a = command;
        }

        public void a() {
            this.a = null;
            this.b = null;
        }
    }

    /* JADX INFO: renamed from: com.telink.ota.ble.c$c, reason: collision with other inner class name */
    private final class RunnableC0107c implements Runnable {
        private RunnableC0107c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c.this.c) {
                c.this.I((b) c.this.c.peek());
            }
        }

        /* synthetic */ RunnableC0107c(c cVar, com.telink.ota.ble.b bVar) {
            this();
        }
    }

    private final class d implements Runnable {
        private d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c.this.c) {
                try {
                    b bVar = (b) c.this.c.peek();
                    if (bVar != null) {
                        Command command = bVar.a;
                        Command.a aVar = bVar.b;
                        if (c.this.l(bVar)) {
                            bVar.a = command;
                            bVar.b = aVar;
                            c.this.I(bVar);
                        } else {
                            c.this.c.poll();
                            c.this.g();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* synthetic */ d(c cVar, com.telink.ota.ble.b bVar) {
            this();
        }
    }

    private final class e implements Runnable {
        private e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.p()) {
                return;
            }
            c.this.A();
        }

        /* synthetic */ e(c cVar, com.telink.ota.ble.b bVar) {
            this();
        }
    }

    private final class f implements Runnable {
        private f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            vx1.c("disconnection timeout");
            c.this.w.set(1);
            c.this.A();
        }

        /* synthetic */ f(c cVar, com.telink.ota.ble.b bVar) {
            this();
        }
    }

    private final class g implements Runnable {
        private g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            if (cVar.s && cVar.x()) {
                BluetoothGatt bluetoothGatt = c.this.p;
                if (bluetoothGatt != null) {
                    bluetoothGatt.readRemoteRssi();
                }
                c cVar2 = c.this;
                cVar2.f.postDelayed(cVar2.h, cVar2.t);
            }
        }

        /* synthetic */ g(c cVar, com.telink.ota.ble.b bVar) {
            this();
        }
    }

    public c(Context context) {
        com.telink.ota.ble.b bVar = null;
        this.h = new g(this, bVar);
        this.i = new e(this, bVar);
        this.j = new f(this, bVar);
        this.k = new d(this, bVar);
        this.l = new RunnableC0107c(this, bVar);
        this.y = context;
    }

    private void E(List list) {
        D(list);
    }

    private void F(b bVar) {
        vx1.a("postCommand");
        this.b.add(bVar);
        synchronized (this.n) {
            try {
                if (!this.r.booleanValue()) {
                    H();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void G() {
        if (this.u <= 0) {
            return;
        }
        this.e.removeCallbacksAndMessages(null);
        this.e.postDelayed(this.k, this.u);
    }

    private void H() {
        vx1.a("processing : " + this.r);
        synchronized (this.b) {
            try {
                if (this.b.isEmpty()) {
                    return;
                }
                b bVar = (b) this.b.poll();
                if (bVar == null) {
                    return;
                }
                Command.CommandType commandType = bVar.a.d;
                if (commandType != Command.CommandType.ENABLE_NOTIFY && commandType != Command.CommandType.DISABLE_NOTIFY) {
                    this.c.add(bVar);
                    synchronized (this.n) {
                        try {
                            if (!this.r.booleanValue()) {
                                this.r = Boolean.TRUE;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                int i = bVar.a.g;
                if (i > 0) {
                    this.g.postDelayed(this.l, i);
                } else {
                    I(bVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void I(b bVar) {
        try {
            Command command = bVar.a;
            Command.CommandType commandType = command.d;
            vx1.a("processCommand : " + command.toString());
            switch (a.a[commandType.ordinal()]) {
                case 1:
                    G();
                    J(bVar, command.a, command.b);
                    break;
                case 2:
                    G();
                    N(bVar, command.a, command.b, 2, command.e);
                    break;
                case 3:
                    G();
                    K(bVar, command.a, command.b, command.c);
                    break;
                case 4:
                    G();
                    N(bVar, command.a, command.b, 1, command.e);
                    break;
                case 5:
                    r(bVar, command.a, command.b);
                    break;
                case 6:
                    o(bVar, command.a, command.b);
                    break;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void J(b bVar, UUID uuid, UUID uuid2) {
        String str;
        BluetoothGattService service = this.p.getService(uuid);
        boolean z = false;
        if (service != null) {
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
            str = "read characteristic error";
            if (characteristic != null && this.p.readCharacteristic(characteristic)) {
                z = true;
                str = Constants.STR_EMPTY;
            }
        } else {
            str = "service is not offered by the remote device";
        }
        if (z) {
            return;
        }
        i(str);
        g();
    }

    private void K(b bVar, UUID uuid, UUID uuid2, UUID uuid3) {
        String str;
        BluetoothGattService service = this.p.getService(uuid);
        boolean z = false;
        if (service != null) {
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
            if (characteristic != null) {
                BluetoothGattDescriptor descriptor = characteristic.getDescriptor(uuid3);
                str = "read descriptor error";
                if (descriptor != null && this.p.readDescriptor(descriptor)) {
                    z = true;
                    str = Constants.STR_EMPTY;
                }
            } else {
                str = "read characteristic error";
            }
        } else {
            str = "service is not offered by the remote device";
        }
        if (z) {
            return;
        }
        i(str);
        g();
    }

    private void N(b bVar, UUID uuid, UUID uuid2, int i, byte[] bArr) {
        String str;
        BluetoothGattService service = this.p.getService(uuid);
        boolean z = false;
        if (service != null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristicT = t(service, uuid2, i);
            if (bluetoothGattCharacteristicT != null) {
                bluetoothGattCharacteristicT.setValue(bArr);
                bluetoothGattCharacteristicT.setWriteType(i);
                if (this.p.writeCharacteristic(bluetoothGattCharacteristicT)) {
                    z = true;
                    str = Constants.STR_EMPTY;
                } else {
                    str = "write characteristic error";
                }
            } else {
                str = "no characteristic";
            }
        } else {
            str = "service is not offered by the remote device";
        }
        if (z) {
            return;
        }
        i(str);
        g();
    }

    private void e() {
        this.e.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        vx1.a("commandCompleted");
        synchronized (this.n) {
            try {
                if (this.r.booleanValue()) {
                    this.r = Boolean.FALSE;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        H();
    }

    private void h(b bVar, String str) {
        vx1.a("commandError");
        if (bVar != null) {
            Command command = bVar.a;
            Command.a aVar = bVar.b;
            bVar.a();
            if (aVar != null) {
                aVar.b(this, command, str);
            }
        }
    }

    private void i(String str) {
        h((b) this.c.poll(), str);
    }

    private void j(b bVar, Object obj) {
        vx1.a("commandSuccess");
        if (bVar != null) {
            Command command = bVar.a;
            Command.a aVar = bVar.b;
            bVar.a();
            if (aVar != null) {
                aVar.a(this, command, obj);
            }
        }
    }

    private void k(Object obj) {
        j((b) this.c.poll(), obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(b bVar) {
        vx1.a("commandTimeout");
        if (bVar == null) {
            return false;
        }
        Command command = bVar.a;
        Command.a aVar = bVar.b;
        bVar.a();
        if (aVar != null) {
            return aVar.c(this, command);
        }
        return false;
    }

    private void o(b bVar, UUID uuid, UUID uuid2) {
        String str;
        BluetoothGattService service = this.p.getService(uuid);
        boolean z = false;
        if (service != null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristicS = s(service, uuid2);
            if (bluetoothGattCharacteristicS != null) {
                this.d.remove(w(uuid, bluetoothGattCharacteristicS));
                if (this.p.setCharacteristicNotification(bluetoothGattCharacteristicS, false)) {
                    z = true;
                    str = Constants.STR_EMPTY;
                } else {
                    str = "disable notification error";
                }
            } else {
                str = "no characteristic";
            }
        } else {
            str = "service is not offered by the remote device";
        }
        if (z) {
            z();
        } else {
            h(bVar, str);
        }
        g();
    }

    private void r(b bVar, UUID uuid, UUID uuid2) {
        String str;
        BluetoothGattService service = this.p.getService(uuid);
        boolean z = false;
        if (service != null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristicS = s(service, uuid2);
            if (bluetoothGattCharacteristicS == null) {
                str = "no characteristic";
            } else if (this.p.setCharacteristicNotification(bluetoothGattCharacteristicS, true)) {
                this.d.put(w(uuid, bluetoothGattCharacteristicS), bVar);
                str = Constants.STR_EMPTY;
                z = true;
            } else {
                str = "enable notification error";
            }
        } else {
            str = "service is not offered by the remote device";
        }
        if (z) {
            B();
        } else {
            h(bVar, str);
        }
        g();
    }

    private BluetoothGattCharacteristic s(BluetoothGattService bluetoothGattService, UUID uuid) {
        BluetoothGattCharacteristic next;
        List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
        Iterator<BluetoothGattCharacteristic> it = characteristics.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if ((next.getProperties() & 16) != 0 && uuid.equals(next.getUuid())) {
                break;
            }
        }
        if (next != null) {
            return next;
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
            if ((bluetoothGattCharacteristic.getProperties() & 32) != 0 && uuid.equals(bluetoothGattCharacteristic.getUuid())) {
                return bluetoothGattCharacteristic;
            }
        }
        return next;
    }

    private BluetoothGattCharacteristic t(BluetoothGattService bluetoothGattService, UUID uuid, int i) {
        int i2 = i == 1 ? 4 : 8;
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
            if ((bluetoothGattCharacteristic.getProperties() & i2) != 0 && uuid.equals(bluetoothGattCharacteristic.getUuid())) {
                return bluetoothGattCharacteristic;
            }
        }
        return null;
    }

    private String v(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return w(bluetoothGattCharacteristic.getService().getUuid(), bluetoothGattCharacteristic);
    }

    protected void A() {
        this.g.removeCallbacks(this.j);
        q(false);
    }

    protected abstract void B();

    protected void C(byte[] bArr, UUID uuid, UUID uuid2, Object obj) {
    }

    protected void D(List list) {
    }

    public boolean L(Command.a aVar, Command command) {
        synchronized (this.m) {
            try {
                if (this.w.get() != 4) {
                    return false;
                }
                F(new b(aVar, command));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void M() {
        this.s = false;
        this.f.removeCallbacks(this.h);
        this.f.removeCallbacksAndMessages(null);
    }

    protected void f() {
        this.r = Boolean.FALSE;
        this.z = false;
        M();
        e();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.g.removeCallbacksAndMessages(null);
    }

    protected void m() {
        this.v = 0L;
        if (this.o != null && this.w.get() == 1) {
            vx1.c("connect start");
            this.w.set(2);
            BluetoothGatt bluetoothGattConnectGatt = this.o.connectGatt(this.y, false, this, 2);
            this.p = bluetoothGattConnectGatt;
            if (bluetoothGattConnectGatt != null) {
                this.g.postDelayed(this.i, this.a);
                return;
            }
            p();
            this.w.set(1);
            A();
        }
    }

    public void n(BluetoothDevice bluetoothDevice) {
        if (x() && bluetoothDevice.equals(this.o)) {
            y();
            List list = this.f312q;
            if (list != null) {
                E(list);
                return;
            }
            return;
        }
        this.o = bluetoothDevice;
        if (p()) {
            this.x.set(true);
        } else {
            m();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        b bVar = (b) this.d.get(v(bluetoothGattCharacteristic));
        if (bVar != null) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            Command command = bVar.a;
            C(value, command.a, command.b, command.f);
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        e();
        if (i == 0) {
            k(bluetoothGattCharacteristic.getValue());
        } else {
            i("read characteristic failed");
        }
        g();
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        e();
        if (i == 0) {
            k(null);
        } else {
            i("write characteristic fail");
        }
        vx1.a("onCharacteristicWrite newStatus : " + i);
        g();
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        vx1.a("onConnectionStateChange  status :" + i + " state : " + i2);
        if (i2 != 2) {
            synchronized (this.m) {
                try {
                    vx1.a("Close");
                    BluetoothGatt bluetoothGatt2 = this.p;
                    if (bluetoothGatt2 != null) {
                        bluetoothGatt2.close();
                    }
                    f();
                    this.w.set(1);
                    A();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        synchronized (this.m) {
            this.w.set(4);
        }
        BluetoothGatt bluetoothGatt3 = this.p;
        if (bluetoothGatt3 != null && bluetoothGatt3.discoverServices()) {
            y();
            return;
        }
        vx1.a("remote service discovery has been stopped status = " + i2);
        p();
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        e();
        if (i == 0) {
            k(bluetoothGattDescriptor.getValue());
        } else {
            i("read description failed");
        }
        g();
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
        e();
        if (i == 0) {
            k(null);
        } else {
            i("write description failed");
        }
        g();
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        super.onMtuChanged(bluetoothGatt, i, i2);
        vx1.a("mtu changed : " + i);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        super.onReadRemoteRssi(bluetoothGatt, i, i2);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
        super.onReliableWriteCompleted(bluetoothGatt, i);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        super.onServicesDiscovered(bluetoothGatt, i);
        if (i != 0) {
            vx1.a("Service discovery failed");
            p();
            return;
        }
        List<BluetoothGattService> services = bluetoothGatt.getServices();
        this.f312q = services;
        E(services);
        vx1.a("Service discovery success:" + services.size());
    }

    public boolean p() {
        vx1.c("disconnect  -- " + this.w.get());
        f();
        int i = this.w.get();
        if (i != 2 && i != 4 && i != 8) {
            return false;
        }
        BluetoothGatt bluetoothGatt = this.p;
        if (bluetoothGatt == null) {
            this.w.set(1);
            return false;
        }
        if (i == 4) {
            this.w.set(8);
            this.p.disconnect();
        } else if (i == 2) {
            bluetoothGatt.disconnect();
            this.p.close();
            this.w.set(1);
            return false;
        }
        this.g.postDelayed(this.j, 1500L);
        return true;
    }

    protected void q(boolean z) {
        if (z) {
            this.f.removeCallbacks(this.h);
            this.f.postDelayed(this.h, this.t);
        } else {
            this.f.removeCallbacks(this.h);
            this.f.removeCallbacksAndMessages(null);
        }
    }

    protected void u() {
        BluetoothGatt bluetoothGatt = this.p;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
            this.p.close();
        }
        this.w.set(1);
    }

    protected String w(UUID uuid, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return String.valueOf(uuid) + "|" + bluetoothGattCharacteristic.getUuid() + "|" + bluetoothGattCharacteristic.getInstanceId();
    }

    public boolean x() {
        boolean z;
        synchronized (this.m) {
            z = this.w.get() == 4;
        }
        return z;
    }

    protected void y() {
        this.g.removeCallbacks(this.i);
        q(this.s);
    }

    protected abstract void z();
}
