package defpackage;

import android.content.Context;
import androidx.work.ListenableWorker;

/* JADX INFO: loaded from: classes.dex */
public class kk3 implements Runnable {
    static final String g = fd1.f("WorkForegroundRunnable");
    final mn2 a = mn2.t();
    final Context b;
    final xk3 c;
    final ListenableWorker d;
    final ep0 e;
    final w03 f;

    class a implements Runnable {
        final /* synthetic */ mn2 a;

        a(mn2 mn2Var) {
            this.a = mn2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.r(kk3.this.d.d());
        }
    }

    class b implements Runnable {
        final /* synthetic */ mn2 a;

        b(mn2 mn2Var) {
            this.a = mn2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                cp0 cp0Var = (cp0) this.a.get();
                if (cp0Var == null) {
                    throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", kk3.this.c.c));
                }
                fd1.c().a(kk3.g, String.format("Updating notification for %s", kk3.this.c.c), new Throwable[0]);
                kk3.this.d.m(true);
                kk3 kk3Var = kk3.this;
                kk3Var.a.r(kk3Var.e.a(kk3Var.b, kk3Var.d.e(), cp0Var));
            } catch (Throwable th) {
                kk3.this.a.q(th);
            }
        }
    }

    public kk3(Context context, xk3 xk3Var, ListenableWorker listenableWorker, ep0 ep0Var, w03 w03Var) {
        this.b = context;
        this.c = xk3Var;
        this.d = listenableWorker;
        this.e = ep0Var;
        this.f = w03Var;
    }

    public ub1 a() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.c.f444q || to.b()) {
            this.a.p(null);
            return;
        }
        mn2 mn2VarT = mn2.t();
        this.f.a().execute(new a(mn2VarT));
        mn2VarT.a(new b(mn2VarT), this.f.a());
    }
}
