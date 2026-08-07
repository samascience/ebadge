package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import defpackage.fd1;
import defpackage.fk3;
import defpackage.gk3;
import defpackage.mn2;
import defpackage.nk3;
import defpackage.ub1;
import defpackage.w03;
import defpackage.xk3;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintTrackingWorker extends ListenableWorker implements fk3 {
    private static final String k = fd1.f("ConstraintTrkngWrkr");
    private WorkerParameters f;
    final Object g;
    volatile boolean h;
    mn2 i;
    private ListenableWorker j;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ConstraintTrackingWorker.this.u();
        }
    }

    class b implements Runnable {
        final /* synthetic */ ub1 a;

        b(ub1 ub1Var) {
            this.a = ub1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (ConstraintTrackingWorker.this.g) {
                try {
                    if (ConstraintTrackingWorker.this.h) {
                        ConstraintTrackingWorker.this.t();
                    } else {
                        ConstraintTrackingWorker.this.i.r(this.a);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f = workerParameters;
        this.g = new Object();
        this.h = false;
        this.i = mn2.t();
    }

    @Override // defpackage.fk3
    public void b(List list) {
        fd1.c().a(k, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.g) {
            this.h = true;
        }
    }

    @Override // defpackage.fk3
    public void f(List list) {
    }

    @Override // androidx.work.ListenableWorker
    public boolean i() {
        ListenableWorker listenableWorker = this.j;
        return listenableWorker != null && listenableWorker.i();
    }

    @Override // androidx.work.ListenableWorker
    public void l() {
        super.l();
        ListenableWorker listenableWorker = this.j;
        if (listenableWorker == null || listenableWorker.j()) {
            return;
        }
        this.j.p();
    }

    @Override // androidx.work.ListenableWorker
    public ub1 o() {
        c().execute(new a());
        return this.i;
    }

    public w03 q() {
        return nk3.j(a()).o();
    }

    public WorkDatabase r() {
        return nk3.j(a()).n();
    }

    void s() {
        this.i.p(ListenableWorker.a.a());
    }

    void t() {
        this.i.p(ListenableWorker.a.b());
    }

    void u() {
        String strI = g().i("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(strI)) {
            fd1.c().b(k, "No worker to delegate to.", new Throwable[0]);
            s();
            return;
        }
        ListenableWorker listenableWorkerB = h().b(a(), strI, this.f);
        this.j = listenableWorkerB;
        if (listenableWorkerB == null) {
            fd1.c().a(k, "No worker to delegate to.", new Throwable[0]);
            s();
            return;
        }
        xk3 xk3VarM = r().k().m(e().toString());
        if (xk3VarM == null) {
            s();
            return;
        }
        gk3 gk3Var = new gk3(a(), q(), this);
        gk3Var.d(Collections.singletonList(xk3VarM));
        if (!gk3Var.c(e().toString())) {
            fd1.c().a(k, String.format("Constraints not met for delegate %s. Requesting retry.", strI), new Throwable[0]);
            t();
            return;
        }
        fd1.c().a(k, String.format("Constraints met for delegate %s", strI), new Throwable[0]);
        try {
            ub1 ub1VarO = this.j.o();
            ub1VarO.a(new b(ub1VarO), c());
        } catch (Throwable th) {
            fd1 fd1VarC = fd1.c();
            String str = k;
            fd1VarC.a(str, String.format("Delegated worker %s threw exception in startWork.", strI), th);
            synchronized (this.g) {
                try {
                    if (this.h) {
                        fd1.c().a(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                        t();
                    } else {
                        s();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }
}
