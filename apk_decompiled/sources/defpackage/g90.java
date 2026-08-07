package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g90 {
    static final String d = fd1.f("DelayedWorkTracker");
    final kv0 a;
    private final pi2 b;
    private final Map c = new HashMap();

    class a implements Runnable {
        final /* synthetic */ xk3 a;

        a(xk3 xk3Var) {
            this.a = xk3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            fd1.c().a(g90.d, String.format("Scheduling work %s", this.a.a), new Throwable[0]);
            g90.this.a.e(this.a);
        }
    }

    public g90(kv0 kv0Var, pi2 pi2Var) {
        this.a = kv0Var;
        this.b = pi2Var;
    }

    public void a(xk3 xk3Var) {
        Runnable runnable = (Runnable) this.c.remove(xk3Var.a);
        if (runnable != null) {
            this.b.b(runnable);
        }
        a aVar = new a(xk3Var);
        this.c.put(xk3Var.a, aVar);
        this.b.a(xk3Var.a() - System.currentTimeMillis(), aVar);
    }

    public void b(String str) {
        Runnable runnable = (Runnable) this.c.remove(str);
        if (runnable != null) {
            this.b.b(runnable);
        }
    }
}
