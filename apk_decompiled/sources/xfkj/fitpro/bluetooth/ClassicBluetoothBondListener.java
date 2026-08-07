package xfkj.fitpro.bluetooth;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.blankj.utilcode.util.o;
import defpackage.ak;
import defpackage.ee;
import defpackage.p31;
import defpackage.y70;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public final class ClassicBluetoothBondListener {
    public static final c g = new c(null);
    private static volatile ClassicBluetoothBondListener h;
    private final Context a;
    private final ConcurrentHashMap b;
    private final Handler c;
    private Runnable d;
    private boolean e;
    private final ClassicBluetoothBondListener$bondStateReceiver$1 f;

    public interface a {
        void a(String str, String str2);

        void b(String str);
    }

    public static final class c {
        public /* synthetic */ c(y70 y70Var) {
            this();
        }

        public final ClassicBluetoothBondListener a() {
            ClassicBluetoothBondListener classicBluetoothBondListener = ClassicBluetoothBondListener.h;
            if (classicBluetoothBondListener == null) {
                synchronized (this) {
                    classicBluetoothBondListener = ClassicBluetoothBondListener.h;
                    if (classicBluetoothBondListener == null) {
                        classicBluetoothBondListener = new ClassicBluetoothBondListener(null);
                        ClassicBluetoothBondListener.h = classicBluetoothBondListener;
                    }
                }
            }
            return classicBluetoothBondListener;
        }

        private c() {
        }
    }

    public static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ClassicBluetoothBondListener.this.b.isEmpty()) {
                ClassicBluetoothBondListener.this.e = false;
                ClassicBluetoothBondListener.this.d = null;
                Log.d("ClassicBluetoothBondListener", "没有绑定任务，停止超时检查");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ConcurrentHashMap concurrentHashMap = ClassicBluetoothBondListener.this.b;
            ClassicBluetoothBondListener classicBluetoothBondListener = ClassicBluetoothBondListener.this;
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                String str = (String) entry.getKey();
                b bVar = (b) entry.getValue();
                if (!classicBluetoothBondListener.p(bVar)) {
                    Log.w("ClassicBluetoothBondListener", "设备 " + str + " 任务无效，清理任务");
                    classicBluetoothBondListener.r(str);
                    arrayList.add(str);
                    bVar.d();
                } else if (jCurrentTimeMillis - bVar.g() >= 30000) {
                    Log.w("ClassicBluetoothBondListener", "设备 " + str + " 绑定超时");
                    classicBluetoothBondListener.r(str);
                    classicBluetoothBondListener.l(bVar, "绑定超时");
                    arrayList.add(str);
                }
            }
            ClassicBluetoothBondListener classicBluetoothBondListener2 = ClassicBluetoothBondListener.this;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                classicBluetoothBondListener2.b.remove((String) it.next());
            }
            ClassicBluetoothBondListener.this.c.postDelayed(this, 5000L);
        }
    }

    public /* synthetic */ ClassicBluetoothBondListener(y70 y70Var) {
        this();
    }

    private final void k() {
        if (this.b.isEmpty() && this.e) {
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(final b bVar, String str) {
        int iIncrementAndGet = bVar.f().incrementAndGet();
        Log.w("ClassicBluetoothBondListener", "设备 " + bVar.e() + " 绑定失败: " + str + ", 重试次数: " + iIncrementAndGet);
        if (iIncrementAndGet <= 3) {
            r(bVar.e());
            bVar.d();
            this.c.postDelayed(new Runnable() { // from class: xfkj.fitpro.bluetooth.a
                @Override // java.lang.Runnable
                public final void run() {
                    ClassicBluetoothBondListener.m(this.a, bVar);
                }
            }, 2000L);
            return;
        }
        Log.e("ClassicBluetoothBondListener", "设备 " + bVar.e() + " 绑定失败，已达到最大重试次数");
        r(bVar.e());
        this.b.remove(bVar.e());
        bVar.d();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ClassicBluetoothBondListener classicBluetoothBondListener, b bVar) {
        if (classicBluetoothBondListener.b.containsKey(bVar.e())) {
            Log.d("ClassicBluetoothBondListener", "重试绑定设备: " + bVar.e());
            classicBluetoothBondListener.q(bVar.e());
            b bVar2 = (b) classicBluetoothBondListener.b.get(bVar.e());
            if (bVar2 != null) {
                bVar = bVar2;
            }
            classicBluetoothBondListener.s(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", 10);
        int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", 10);
        if (bluetoothDevice == null) {
            Log.w("ClassicBluetoothBondListener", "获取绑定设备为空");
        }
        String address = bluetoothDevice.getAddress();
        Log.d("ClassicBluetoothBondListener", "设备 " + address + " 绑定状态变化: " + intExtra2 + " -> " + intExtra);
        b bVar = (b) this.b.get(address);
        if (bVar == null) {
            return;
        }
        switch (intExtra) {
            case 10:
                if (intExtra2 == 11) {
                    Log.w("ClassicBluetoothBondListener", "设备 " + address + " 绑定失败");
                    l(bVar, "绑定失败");
                }
                break;
            case 11:
                Log.d("ClassicBluetoothBondListener", "设备 " + address + " 正在绑定中");
                break;
            case 12:
                Log.d("ClassicBluetoothBondListener", "设备 " + address + " 绑定成功");
                o(bVar);
                break;
        }
    }

    private final void o(b bVar) {
        Log.d("ClassicBluetoothBondListener", "设备 " + bVar.e() + " 绑定成功");
        this.b.remove(bVar.e());
        bVar.d();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p(b bVar) {
        if (System.currentTimeMillis() - bVar.g() > 30000) {
            Log.w("ClassicBluetoothBondListener", "任务 " + bVar.e() + " 已超时");
            return false;
        }
        if (bVar.h().get() == 0) {
            Log.w("ClassicBluetoothBondListener", "任务 " + bVar.e() + " 已标记为非活跃");
            return false;
        }
        BluetoothDevice bluetoothDeviceD = ak.d(bVar.e());
        if (bluetoothDeviceD == null || !ak.m(bluetoothDeviceD)) {
            return true;
        }
        Log.w("ClassicBluetoothBondListener", "设备 " + bVar.e() + " 已经绑定，任务无效");
        return false;
    }

    private final void s(b bVar) {
        try {
            Log.d("ClassicBluetoothBondListener", "执行绑定操作: " + bVar.e() + ", 重试次数: " + bVar.f().get());
            this.b.put(bVar.e(), b.b(bVar, null, null, 0L, null, null, System.currentTimeMillis(), null, 95, null));
            if (i.v(bVar.c(), bVar.e(), true)) {
                Log.d("ClassicBluetoothBondListener", "检测到BLE和BR MAC相同: " + bVar.e());
            } else {
                Log.d("ClassicBluetoothBondListener", "BLE和BR MAC不同: BLE=" + bVar.c() + ", BR=" + bVar.e());
            }
            t(bVar);
        } catch (Exception e) {
            Log.e("ClassicBluetoothBondListener", "绑定操作失败: " + e.getMessage());
            r(bVar.e());
            l(bVar, "绑定操作异常: " + e.getMessage());
        }
    }

    private final void t(b bVar) throws Exception {
        try {
            bVar.d();
            ak.q(ak.d(bVar.e()));
            ee.a(bVar.c(), bVar.e());
        } catch (Exception e) {
            Log.e("ClassicBluetoothBondListener", "正常配对流程失败: " + e.getMessage());
            throw e;
        }
    }

    private final void v() {
        if (this.e) {
            return;
        }
        this.d = new d();
        this.e = true;
        Log.d("ClassicBluetoothBondListener", "启动全局超时检查");
        Handler handler = this.c;
        Runnable runnable = this.d;
        p31.c(runnable);
        handler.post(runnable);
    }

    private final void w() {
        Runnable runnable = this.d;
        if (runnable != null) {
            Handler handler = this.c;
            p31.c(runnable);
            handler.removeCallbacks(runnable);
            this.d = null;
            this.e = false;
            Log.d("ClassicBluetoothBondListener", "停止超时检查");
        }
    }

    public final void q(String str) {
        p31.f(str, "macAddress");
        b bVar = (b) this.b.get(str);
        if (bVar != null) {
            bVar.h().set(1);
            Log.d("ClassicBluetoothBondListener", "重新激活任务 " + str);
        }
    }

    public final void r(String str) {
        p31.f(str, "macAddress");
        b bVar = (b) this.b.get(str);
        if (bVar != null) {
            bVar.h().set(0);
            Log.d("ClassicBluetoothBondListener", "标记任务 " + str + " 为非活跃状态");
        }
    }

    public final void u(String str, String str2, a aVar) {
        p31.f(str, "macAddress");
        p31.f(str2, "leAddress");
        if (i.Y(str)) {
            Log.w("ClassicBluetoothBondListener", "MAC地址为空，无法开始绑定");
            if (aVar != null) {
                aVar.a(str, "MAC地址为空");
                return;
            }
            return;
        }
        Log.d("ClassicBluetoothBondListener", "开始绑定经典蓝牙设备: " + str);
        b bVar = (b) this.b.get(str);
        if (bVar != null) {
            if (p(bVar)) {
                Log.w("ClassicBluetoothBondListener", "设备 " + str + " 正在绑定中，跳过重复请求");
                return;
            }
            Log.w("ClassicBluetoothBondListener", "设备 " + str + " 存在无效的绑定任务，清理后重新开始");
        }
        BluetoothDevice bluetoothDeviceD = ak.d(str);
        if (bluetoothDeviceD == null || !ak.m(bluetoothDeviceD)) {
            b bVar2 = new b(str, str2, System.currentTimeMillis(), null, aVar, 0L, null, 104, null);
            this.b.put(str, bVar2);
            s(bVar2);
            v();
            return;
        }
        Log.d("ClassicBluetoothBondListener", "设备 " + str + " 已经绑定");
        if (aVar != null) {
            aVar.b(str);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [xfkj.fitpro.bluetooth.ClassicBluetoothBondListener$bondStateReceiver$1] */
    private ClassicBluetoothBondListener() {
        Application applicationA = o.a();
        p31.e(applicationA, "getApp(...)");
        this.a = applicationA;
        this.b = new ConcurrentHashMap();
        this.c = new Handler(Looper.getMainLooper());
        this.f = new BroadcastReceiver() { // from class: xfkj.fitpro.bluetooth.ClassicBluetoothBondListener$bondStateReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                p31.f(context, "context");
                p31.f(intent, "intent");
                String action = intent.getAction();
                if (action != null && action.hashCode() == 2116862345 && action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                    this.a.n(intent);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class b {
        private final String a;
        private final String b;
        private final long c;
        private final AtomicInteger d;
        private final long e;
        private final AtomicInteger f;

        public b(String str, String str2, long j, AtomicInteger atomicInteger, a aVar, long j2, AtomicInteger atomicInteger2) {
            p31.f(str, "macAddress");
            p31.f(str2, "leAddress");
            p31.f(atomicInteger, "retryCount");
            p31.f(atomicInteger2, "isActive");
            this.a = str;
            this.b = str2;
            this.c = j;
            this.d = atomicInteger;
            this.e = j2;
            this.f = atomicInteger2;
        }

        public static /* synthetic */ b b(b bVar, String str, String str2, long j, AtomicInteger atomicInteger, a aVar, long j2, AtomicInteger atomicInteger2, int i, Object obj) {
            a aVar2;
            String str3 = (i & 1) != 0 ? bVar.a : str;
            String str4 = (i & 2) != 0 ? bVar.b : str2;
            long j3 = (i & 4) != 0 ? bVar.c : j;
            AtomicInteger atomicInteger3 = (i & 8) != 0 ? bVar.d : atomicInteger;
            if ((i & 16) != 0) {
                bVar.getClass();
                aVar2 = null;
            } else {
                aVar2 = aVar;
            }
            return bVar.a(str3, str4, j3, atomicInteger3, aVar2, (i & 32) != 0 ? bVar.e : j2, (i & 64) != 0 ? bVar.f : atomicInteger2);
        }

        public final b a(String str, String str2, long j, AtomicInteger atomicInteger, a aVar, long j2, AtomicInteger atomicInteger2) {
            p31.f(str, "macAddress");
            p31.f(str2, "leAddress");
            p31.f(atomicInteger, "retryCount");
            p31.f(atomicInteger2, "isActive");
            return new b(str, str2, j, atomicInteger, aVar, j2, atomicInteger2);
        }

        public final String c() {
            return this.b;
        }

        public final a d() {
            return null;
        }

        public final String e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return p31.a(this.a, bVar.a) && p31.a(this.b, bVar.b) && this.c == bVar.c && p31.a(this.d, bVar.d) && p31.a(null, null) && this.e == bVar.e && p31.a(this.f, bVar.f);
        }

        public final AtomicInteger f() {
            return this.d;
        }

        public final long g() {
            return this.c;
        }

        public final AtomicInteger h() {
            return this.f;
        }

        public int hashCode() {
            return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 961) + Long.hashCode(this.e)) * 31) + this.f.hashCode();
        }

        public String toString() {
            return "BondTask(macAddress=" + this.a + ", leAddress=" + this.b + ", startTime=" + this.c + ", retryCount=" + this.d + ", listener=" + ((Object) null) + ", lastActivityTime=" + this.e + ", isActive=" + this.f + ")";
        }

        public /* synthetic */ b(String str, String str2, long j, AtomicInteger atomicInteger, a aVar, long j2, AtomicInteger atomicInteger2, int i, y70 y70Var) {
            this(str, str2, j, (i & 8) != 0 ? new AtomicInteger(0) : atomicInteger, (i & 16) != 0 ? null : aVar, (i & 32) != 0 ? System.currentTimeMillis() : j2, (i & 64) != 0 ? new AtomicInteger(1) : atomicInteger2);
        }
    }
}
