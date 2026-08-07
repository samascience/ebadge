package no.nordicsemi.android.support.v18.scanner;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import defpackage.ek2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    private static b a;

    static class a {
        private final boolean b;
        private final boolean c;
        private final boolean d;
        final List f;
        final ScanSettings g;
        final ek2 h;
        final Handler i;
        private final Object a = new Object();
        private final List j = new ArrayList();
        private final Set k = new HashSet();
        private final Map l = new HashMap();
        private final Runnable m = new RunnableC0147a();
        private boolean e = false;

        /* JADX INFO: renamed from: no.nordicsemi.android.support.v18.scanner.b$a$a, reason: collision with other inner class name */
        class RunnableC0147a implements Runnable {
            RunnableC0147a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b(ScanResult scanResult) {
                a.this.h.onScanResult(4, scanResult);
            }

            @Override // java.lang.Runnable
            public void run() {
                long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                synchronized (a.this.a) {
                    try {
                        Iterator it = a.this.l.values().iterator();
                        while (it.hasNext()) {
                            final ScanResult scanResult = (ScanResult) it.next();
                            if (scanResult.d() < jElapsedRealtimeNanos - a.this.g.d()) {
                                it.remove();
                                a.this.i.post(new Runnable() { // from class: no.nordicsemi.android.support.v18.scanner.a
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.a.b(scanResult);
                                    }
                                });
                            }
                        }
                        if (!a.this.l.isEmpty()) {
                            a aVar = a.this;
                            aVar.i.postDelayed(this, aVar.g.e());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: no.nordicsemi.android.support.v18.scanner.b$a$b, reason: collision with other inner class name */
        class RunnableC0148b implements Runnable {
            final /* synthetic */ Handler a;

            RunnableC0148b(Handler handler) {
                this.a = handler;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.e) {
                    return;
                }
                a.this.e();
                this.a.postDelayed(this, a.this.g.i());
            }
        }

        a(boolean z, boolean z2, List list, ScanSettings scanSettings, ek2 ek2Var, Handler handler) {
            this.f = Collections.unmodifiableList(list);
            this.g = scanSettings;
            this.h = ek2Var;
            this.i = handler;
            boolean z3 = false;
            this.d = (scanSettings.b() == 1 || scanSettings.l()) ? false : true;
            this.b = (list.isEmpty() || (z2 && scanSettings.m())) ? false : true;
            long jI = scanSettings.i();
            if (jI > 0 && (!z || !scanSettings.k())) {
                z3 = true;
            }
            this.c = z3;
            if (z3) {
                handler.postDelayed(new RunnableC0148b(handler), jI);
            }
        }

        private boolean i(ScanResult scanResult) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                if (((ScanFilter) it.next()).k(scanResult)) {
                    return true;
                }
            }
            return false;
        }

        void d() {
            this.e = true;
            this.i.removeCallbacksAndMessages(null);
            synchronized (this.a) {
                this.l.clear();
                this.k.clear();
                this.j.clear();
            }
        }

        void e() {
            if (!this.c || this.e) {
                return;
            }
            synchronized (this.a) {
                this.h.onBatchScanResults(new ArrayList(this.j));
                this.j.clear();
                this.k.clear();
            }
        }

        void f(int i) {
            this.h.onScanFailed(i);
        }

        void g(int i, ScanResult scanResult) {
            boolean zIsEmpty;
            ScanResult scanResult2;
            if (this.e) {
                return;
            }
            if (this.f.isEmpty() || i(scanResult)) {
                String address = scanResult.a().getAddress();
                if (!this.d) {
                    if (!this.c) {
                        this.h.onScanResult(i, scanResult);
                        return;
                    }
                    synchronized (this.a) {
                        try {
                            if (!this.k.contains(address)) {
                                this.j.add(scanResult);
                                this.k.add(address);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                }
                synchronized (this.l) {
                    zIsEmpty = this.l.isEmpty();
                    scanResult2 = (ScanResult) this.l.put(address, scanResult);
                }
                if (scanResult2 == null && (this.g.b() & 2) > 0) {
                    this.h.onScanResult(2, scanResult);
                }
                if (!zIsEmpty || (this.g.b() & 4) <= 0) {
                    return;
                }
                this.i.removeCallbacks(this.m);
                this.i.postDelayed(this.m, this.g.e());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void h(List list) {
            if (this.e) {
                return;
            }
            if (this.b) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ScanResult scanResult = (ScanResult) it.next();
                    if (i(scanResult)) {
                        arrayList.add(scanResult);
                    }
                }
                list = arrayList;
            }
            this.h.onBatchScanResults(list);
        }
    }

    b() {
    }

    public static synchronized b a() {
        b bVar = a;
        if (bVar != null) {
            return bVar;
        }
        h hVar = new h();
        a = hVar;
        return hVar;
    }

    public final void b(List list, ScanSettings scanSettings, ek2 ek2Var) {
        if (ek2Var == null) {
            throw new IllegalArgumentException("callback is null");
        }
        Handler handler = new Handler(Looper.getMainLooper());
        if (list == null) {
            list = Collections.emptyList();
        }
        if (scanSettings == null) {
            scanSettings = new ScanSettings.b().a();
        }
        c(list, scanSettings, ek2Var, handler);
    }

    abstract void c(List list, ScanSettings scanSettings, ek2 ek2Var, Handler handler);

    public final void d(ek2 ek2Var) {
        if (ek2Var == null) {
            throw new IllegalArgumentException("callback is null");
        }
        e(ek2Var);
    }

    abstract void e(ek2 ek2Var);
}
