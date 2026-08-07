package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.CommandPool;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public class m62 {
    private p52 c;
    private Runnable t;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private long h = 0;
    private int i = 2;
    private long j = 0;
    private int k = 0;
    private long l = 0;
    private final Queue m = new ArrayDeque();
    private b n = null;
    private Runnable o = null;
    private volatile boolean p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Runnable f355q = null;
    private Runnable r = null;
    private volatile boolean s = false;
    private int u = 0;
    private int v = 0;
    private final CommandPool.c w = new a();
    private final Handler a = new Handler(Looper.getMainLooper());
    private com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.a b = e20.a;

    class a implements CommandPool.c {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str) {
            m62.this.v(str);
        }

        @Override // com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.CommandPool.c
        public void a(final String str, int i) {
            if (str == null || !str.startsWith("实时预览图片数据 #")) {
                return;
            }
            m62.this.a.post(new Runnable() { // from class: l62
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c(str);
                }
            });
        }
    }

    private static class b {
        final byte[] a;
        final byte[] b;
        final int c;
        final long d = System.currentTimeMillis();

        b(byte[] bArr, byte[] bArr2, int i) {
            this.a = bArr;
            this.b = bArr2;
            this.c = i;
        }
    }

    private void g() {
        Runnable runnable = this.r;
        if (runnable != null) {
            this.a.removeCallbacks(runnable);
            this.r = null;
        }
    }

    private void h() {
        int iK;
        g();
        this.d = 0;
        this.e = false;
        this.f = false;
        this.i = 5;
        this.h = 0L;
        this.j = 0L;
        this.k = 0;
        this.l = 0L;
        this.u = 0;
        this.v = 0;
        CommandPool.m(null);
        com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.a aVar = this.b;
        if (aVar != null && aVar.X() != null && (iK = this.b.X().k("实时预览图片数据 #")) > 0) {
            Log.d("PreviewSender", "Cleared " + iK + " preview image commands from CommandPool");
        }
        synchronized (this.m) {
            this.m.clear();
            this.n = null;
        }
        CommandPool.n(100);
    }

    private static int i(int i, int i2) {
        if (i2 <= 0) {
            i2 = 20;
        }
        if (i <= 0) {
            return 1;
        }
        int iRound = (int) Math.round(((double) (i / i2)) + 0.5d);
        int i3 = 0;
        for (int i4 = 0; i4 < iRound; i4++) {
            int i5 = i4 * i2;
            if (Math.min(i5 + i2, i) > i5) {
                i3++;
            }
        }
        return Math.max(1, i3);
    }

    private void l() {
        Runnable runnable;
        b bVar = this.n;
        if (bVar == null) {
            return;
        }
        int i = bVar.c;
        if (i % 10 == 0) {
            Log.d("PreviewSender", "Frame #" + i + " send completed");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.j;
        if (j == 0) {
            this.j = jCurrentTimeMillis;
            this.k = i;
        } else {
            long j2 = jCurrentTimeMillis - j;
            if (j2 >= 1000) {
                int i2 = i - this.k;
                double d = j2;
                Log.i("PreviewSender", String.format("FPS: %.2f (实际发送完成 %d 帧，耗时 %.1fms，发送间隔: %dms)", Double.valueOf((((double) i2) * 1000.0d) / d), Integer.valueOf(i2), Double.valueOf(d), Integer.valueOf(this.i)));
                this.j = jCurrentTimeMillis;
                this.k = i;
            }
        }
        this.l = System.currentTimeMillis();
        p52 p52Var = this.c;
        if (p52Var != null) {
            p52Var.c(i);
        }
        synchronized (this.m) {
            this.n = null;
            this.e = false;
            this.u = 0;
            this.v = 0;
        }
        if (!this.p) {
            Runnable runnable2 = this.t;
            if (runnable2 != null) {
                runnable2.run();
            }
            w();
            return;
        }
        synchronized (this.m) {
            this.p = false;
            runnable = this.f355q;
            this.f355q = null;
        }
        g();
        h();
        if (runnable != null) {
            runnable.run();
        }
    }

    private boolean n() {
        return e20.a != null && e20.d == 1 && zi2.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(int i) {
        v("实时预览图片数据 #" + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(Runnable runnable) {
        boolean z;
        synchronized (this.m) {
            try {
                z = this.n == null && !this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z) {
            this.p = true;
            this.f355q = runnable;
            Log.d("PreviewSender", "Graceful preview reset armed, waiting for current frame writes to finish");
            z();
            return;
        }
        g();
        synchronized (this.m) {
            this.p = false;
            this.f355q = null;
        }
        h();
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        this.r = null;
        if (this.p) {
            Log.w("PreviewSender", "Graceful preview reset timed out, forcing clear");
            Runnable runnable = this.f355q;
            this.f355q = null;
            this.p = false;
            h();
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(byte[] bArr) {
        try {
            Log.d("PreviewSender", "Executing delayed stop command");
            if (!n()) {
                Log.e("PreviewSender", "Bluetooth not connected when sending delayed stop command");
                this.o = null;
                return;
            }
            this.b.O(bArr, "实时预览结束指令");
            this.b.O(bArr, "实时预览结束指令");
            this.b.O(bArr, "实时预览结束指令");
            this.b.O(bArr, "实时预览结束指令");
            Log.d("PreviewSender", "Stop command sent (delayed, high priority)");
            CommandPool.m(null);
            Log.d("PreviewSender", "Command complete listener unregistered");
            this.d = 0;
            this.e = false;
            this.f = false;
            this.n = null;
            this.j = 0L;
            this.k = 0;
            synchronized (this.m) {
                this.m.clear();
            }
            p52 p52Var = this.c;
            if (p52Var != null) {
                p52Var.d();
            }
            this.o = null;
        } catch (Exception e) {
            Log.e("PreviewSender", "Failed to send delayed stop command", e);
            u(1005, "Failed to send delayed stop command: " + e.getMessage());
            this.o = null;
        }
    }

    private void u(int i, String str) {
        p52 p52Var = this.c;
        if (p52Var != null) {
            p52Var.onError(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str) {
        try {
            int i = Integer.parseInt(str.substring(10).trim());
            synchronized (this.m) {
                b bVar = this.n;
                if (bVar != null && bVar.c == i) {
                    boolean z = true;
                    int i2 = this.v + 1;
                    this.v = i2;
                    if (i2 < this.u) {
                        z = false;
                    }
                    if (z) {
                        l();
                    }
                }
            }
        } catch (Exception e) {
            if (Log.isLoggable("PreviewSender", 3)) {
                Log.w("PreviewSender", "Failed to parse preview chunk desc: " + str, e);
            }
        }
    }

    private void w() {
        int i;
        int i2;
        if (this.p) {
            return;
        }
        if (this.g) {
            synchronized (this.m) {
                try {
                    b bVar = (b) this.m.poll();
                    this.n = bVar;
                    if (bVar != null) {
                        Log.d("PreviewSender", "Processing frame #" + this.n.c + " (debug mode)");
                        this.u = 1;
                        this.v = 0;
                        final int i3 = this.n.c;
                        this.a.postDelayed(new Runnable() { // from class: k62
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.q(i3);
                            }
                        }, 100L);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        synchronized (this.m) {
            b bVar2 = (b) this.m.poll();
            this.n = bVar2;
            if (bVar2 == null) {
                return;
            }
            try {
                byte[] bArr = bVar2.b;
                if (bArr != null && bArr.length != 0) {
                    if (!n()) {
                        Log.e("PreviewSender", "Bluetooth not connected, skipping frame #" + this.n.c);
                        this.u = 0;
                        this.v = 0;
                        this.n = null;
                        this.e = false;
                        w();
                        return;
                    }
                    if (this.h == 0) {
                        this.h = System.currentTimeMillis();
                    }
                    byte[] bArr2 = this.n.b;
                    if (bArr2 != null && bArr2.length != 0) {
                        this.v = 0;
                        com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.a aVar = this.b;
                        this.u = i(this.n.b.length, aVar != null ? aVar.a0() : 20);
                        this.b.M(this.n.b, "实时预览图片数据 #" + this.n.c);
                        this.e = true;
                        int i4 = this.n.c;
                        if (i4 % 20 == 0 && i4 > 0) {
                            long jCurrentTimeMillis = System.currentTimeMillis() - this.h;
                            if (jCurrentTimeMillis > 0) {
                                double d = (((double) this.n.c) * 1000.0d) / jCurrentTimeMillis;
                                if (d > 20.0d && (i2 = this.i) < 6) {
                                    int iMin = Math.min(i2 + 2, 6);
                                    this.i = iMin;
                                    CommandPool.n(iMin);
                                    Log.w("PreviewSender", "Send rate high (" + String.format("%.1f", Double.valueOf(d)) + " FPS), interval: " + this.i + "ms");
                                } else if (d < 8.0d && (i = this.i) > 5) {
                                    int iMax = Math.max(i - 1, 5);
                                    this.i = iMax;
                                    CommandPool.n(iMax);
                                }
                            }
                        }
                        return;
                    }
                    Log.e("PreviewSender", "Invalid image packet before send, frame #" + this.n.c);
                    this.u = 0;
                    this.v = 0;
                    this.n = null;
                    this.e = false;
                    w();
                    return;
                }
                Log.e("PreviewSender", "Invalid image packet for frame #" + this.n.c);
                this.u = 0;
                this.v = 0;
                this.n = null;
                this.e = false;
                w();
            } catch (Exception e) {
                Log.e("PreviewSender", "Failed to send frame #" + this.n.c, e);
                this.u = 0;
                this.v = 0;
                this.n = null;
                this.e = false;
                w();
            }
        }
    }

    private void z() {
        g();
        Runnable runnable = new Runnable() { // from class: j62
            @Override // java.lang.Runnable
            public final void run() {
                this.a.s();
            }
        };
        this.r = runnable;
        this.a.postDelayed(runnable, 4000L);
    }

    public boolean A(byte b2) {
        if (this.g) {
            q52.a(b2);
            StringBuilder sb = new StringBuilder();
            sb.append("End response sent (debug mode, simulated), status: ");
            sb.append(b2 == 0 ? "success" : "failed");
            Log.d("PreviewSender", sb.toString());
            return true;
        }
        if (!n()) {
            u(1006, "Bluetooth not connected");
            return false;
        }
        try {
            this.b.M(q52.a(b2), "实时预览结束响应");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("End response sent, status: ");
            sb2.append(b2 == 0 ? "success" : "failed");
            Log.d("PreviewSender", sb2.toString());
            return true;
        } catch (Exception e) {
            Log.e("PreviewSender", "Failed to send end response", e);
            u(1005, "Failed to send end response: " + e.getMessage());
            return false;
        }
    }

    public boolean B(byte[] bArr) {
        b bVar;
        if (bArr == null || bArr.length == 0) {
            Log.w("PreviewSender", "Image data is null or empty");
            return false;
        }
        if (!this.g && !n()) {
            u(1006, "Bluetooth not connected");
            return false;
        }
        if (this.p) {
            Log.d("PreviewSender", "sendImageData skipped (graceful reset draining)");
            return false;
        }
        if (this.s) {
            Log.d("PreviewSender", "sendImageData skipped (reject new preview frames)");
            return false;
        }
        byte[] bArrA = q01.a(bArr);
        int i = this.d + 1;
        this.d = i;
        b bVar2 = new b(bArr, bArrA, i);
        if (this.g) {
            synchronized (this.m) {
                try {
                    if (this.m.size() >= 4) {
                        b bVar3 = (b) this.m.poll();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Queue near full, removed old frame #");
                        sb.append(bVar3 != null ? Integer.valueOf(bVar3.c) : "?");
                        Log.d("PreviewSender", sb.toString());
                    }
                    this.m.offer(bVar2);
                    if (this.n == null) {
                        w();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        synchronized (this.m) {
            try {
                if (this.m.size() >= 4 && (bVar = (b) this.m.poll()) != null) {
                    Log.w("PreviewSender", "Queue near full (" + this.m.size() + WatchConstant.FAT_FS_ROOT + "5), removed frame #" + bVar.c);
                }
                this.m.offer(bVar2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (this.n == null) {
            w();
        }
        return true;
    }

    public boolean C() {
        if (this.g) {
            q52.b();
            this.f = true;
            Log.d("PreviewSender", "Start command sent (debug mode, simulated)");
            return true;
        }
        if (!n()) {
            u(1006, "Bluetooth not connected");
            return false;
        }
        try {
            this.b.M(q52.b(), "实时预览开始指令");
            this.f = true;
            Log.d("PreviewSender", "Start command sent");
            return true;
        } catch (Exception e) {
            Log.e("PreviewSender", "Failed to send start command", e);
            this.f = false;
            u(1005, "Failed to send start command: " + e.getMessage());
            return false;
        }
    }

    public boolean D() {
        int iK;
        int iK2;
        Log.d("PreviewSender", "sendStopCommand() called");
        if (this.g) {
            q52.c();
            Log.d("PreviewSender", "Stop command sent (debug mode, simulated)");
            CommandPool.n(100);
            Log.d("PreviewSender", "Restored send space duration to 100ms (debug mode)");
            CommandPool.m(null);
            Log.d("PreviewSender", "Command complete listener unregistered");
            com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.a aVar = this.b;
            if (aVar != null && aVar.X() != null && (iK2 = this.b.X().k("实时预览图片数据 #")) > 0) {
                Log.d("PreviewSender", "Cleared " + iK2 + " pending image data commands from CommandPool (debug mode)");
            }
            this.d = 0;
            this.e = false;
            this.f = false;
            this.n = null;
            this.j = 0L;
            this.k = 0;
            synchronized (this.m) {
                this.m.clear();
            }
            p52 p52Var = this.c;
            if (p52Var != null) {
                p52Var.d();
            }
            return true;
        }
        if (!n()) {
            Log.e("PreviewSender", "Bluetooth not connected, cannot send stop command");
            u(1006, "Bluetooth not connected");
            return false;
        }
        synchronized (this.m) {
            try {
                int size = this.m.size();
                this.m.clear();
                this.n = null;
                this.e = false;
                if (size > 0) {
                    Log.d("PreviewSender", "Cleared " + size + " pending frames from queue");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        CommandPool.n(100);
        Log.d("PreviewSender", "Restored send space duration to 100ms (before sending stop command)");
        com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.a aVar2 = this.b;
        if (aVar2 != null && aVar2.X() != null && (iK = this.b.X().k("实时预览图片数据 #")) > 0) {
            Log.d("PreviewSender", "Cleared " + iK + " pending image data commands from CommandPool");
        }
        final byte[] bArrC = q52.c();
        Runnable runnable = new Runnable() { // from class: i62
            @Override // java.lang.Runnable
            public final void run() {
                this.a.t(bArrC);
            }
        };
        this.o = runnable;
        this.a.postDelayed(runnable, 100L);
        Log.d("PreviewSender", "Stop command scheduled (will send in 50ms)");
        return true;
    }

    public void E(Runnable runnable) {
        this.t = runnable;
    }

    public void F(p52 p52Var) {
        this.c = p52Var;
    }

    public void G(boolean z) {
        this.s = z;
    }

    public int j() {
        return this.d;
    }

    public long k() {
        return this.l;
    }

    public void m(byte b2, int i, int i2) {
        this.f = false;
        this.s = false;
        if (b2 != 0) {
            Log.e("PreviewSender", "Start command response: failed");
            p52 p52Var = this.c;
            if (p52Var != null) {
                p52Var.onError(1003, "Device rejected start command");
                return;
            }
            return;
        }
        this.d = 0;
        this.e = false;
        this.i = 3;
        this.h = 0L;
        this.n = null;
        this.j = 0L;
        this.k = 0;
        synchronized (this.m) {
            this.m.clear();
        }
        Log.d("PreviewSender", "Start command response: success, device screen: " + i + "x" + i2);
        CommandPool.n(this.i);
        Log.d("PreviewSender", "Set send space duration to 5ms for preview");
        CommandPool.m(this.w);
        Log.d("PreviewSender", "Command complete listener registered");
        p52 p52Var2 = this.c;
        if (p52Var2 != null) {
            p52Var2.b();
        }
    }

    public boolean o() {
        return this.s;
    }

    public boolean p() {
        return this.f;
    }

    public void x(final Runnable runnable) {
        synchronized (this.m) {
            this.m.clear();
        }
        this.a.post(new Runnable() { // from class: h62
            @Override // java.lang.Runnable
            public final void run() {
                this.a.r(runnable);
            }
        });
    }

    public void y() {
        g();
        synchronized (this.m) {
            this.p = false;
            this.f355q = null;
        }
        this.s = false;
        if (this.o != null) {
            Log.d("PreviewSender", "Reset called, but stop command task is pending, keeping it");
        } else {
            this.a.removeCallbacksAndMessages(null);
        }
        h();
    }
}
