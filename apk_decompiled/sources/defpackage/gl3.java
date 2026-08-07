package defpackage;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkInfo$State;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public class gl3 implements Runnable {
    static final String t = fd1.f("WorkerWrapper");
    Context a;
    private String b;
    private List c;
    private WorkerParameters.a d;
    xk3 e;
    ListenableWorker f;
    w03 g;
    private androidx.work.a i;
    private dp0 j;
    private WorkDatabase k;
    private yk3 l;
    private k90 m;
    private bl3 n;
    private List o;
    private String p;
    private volatile boolean s;
    ListenableWorker.a h = ListenableWorker.a.a();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    mn2 f339q = mn2.t();
    ub1 r = null;

    class a implements Runnable {
        final /* synthetic */ ub1 a;
        final /* synthetic */ mn2 b;

        a(ub1 ub1Var, mn2 mn2Var) {
            this.a = ub1Var;
            this.b = mn2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.get();
                fd1.c().a(gl3.t, String.format("Starting work for %s", gl3.this.e.c), new Throwable[0]);
                gl3 gl3Var = gl3.this;
                gl3Var.r = gl3Var.f.o();
                this.b.r(gl3.this.r);
            } catch (Throwable th) {
                this.b.q(th);
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ mn2 a;
        final /* synthetic */ String b;

        b(mn2 mn2Var, String str) {
            this.a = mn2Var;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    ListenableWorker.a aVar = (ListenableWorker.a) this.a.get();
                    if (aVar == null) {
                        fd1.c().b(gl3.t, String.format("%s returned a null result. Treating it as a failure.", gl3.this.e.c), new Throwable[0]);
                    } else {
                        fd1.c().a(gl3.t, String.format("%s returned a %s result.", gl3.this.e.c, aVar), new Throwable[0]);
                        gl3.this.h = aVar;
                    }
                } catch (InterruptedException e) {
                    e = e;
                    fd1.c().b(gl3.t, String.format("%s failed because it threw an exception/error", this.b), e);
                } catch (CancellationException e2) {
                    fd1.c().d(gl3.t, String.format("%s was cancelled", this.b), e2);
                } catch (ExecutionException e3) {
                    e = e3;
                    fd1.c().b(gl3.t, String.format("%s failed because it threw an exception/error", this.b), e);
                }
                gl3.this.f();
            } catch (Throwable th) {
                gl3.this.f();
                throw th;
            }
        }
    }

    public static class c {
        Context a;
        ListenableWorker b;
        dp0 c;
        w03 d;
        androidx.work.a e;
        WorkDatabase f;
        String g;
        List h;
        WorkerParameters.a i = new WorkerParameters.a();

        public c(Context context, androidx.work.a aVar, w03 w03Var, dp0 dp0Var, WorkDatabase workDatabase, String str) {
            this.a = context.getApplicationContext();
            this.d = w03Var;
            this.c = dp0Var;
            this.e = aVar;
            this.f = workDatabase;
            this.g = str;
        }

        public gl3 a() {
            return new gl3(this);
        }

        public c b(WorkerParameters.a aVar) {
            if (aVar != null) {
                this.i = aVar;
            }
            return this;
        }

        public c c(List list) {
            this.h = list;
            return this;
        }
    }

    gl3(c cVar) {
        this.a = cVar.a;
        this.g = cVar.d;
        this.j = cVar.c;
        this.b = cVar.g;
        this.c = cVar.h;
        this.d = cVar.i;
        this.f = cVar.b;
        this.i = cVar.e;
        WorkDatabase workDatabase = cVar.f;
        this.k = workDatabase;
        this.l = workDatabase.k();
        this.m = this.k.c();
        this.n = this.k.l();
    }

    private String a(List list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.b);
        sb.append(", tags={ ");
        Iterator it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    private void c(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            fd1.c().d(t, String.format("Worker result SUCCESS for %s", this.p), new Throwable[0]);
            if (this.e.d()) {
                h();
                return;
            } else {
                m();
                return;
            }
        }
        if (aVar instanceof ListenableWorker.a.b) {
            fd1.c().d(t, String.format("Worker result RETRY for %s", this.p), new Throwable[0]);
            g();
            return;
        }
        fd1.c().d(t, String.format("Worker result FAILURE for %s", this.p), new Throwable[0]);
        if (this.e.d()) {
            h();
        } else {
            l();
        }
    }

    private void e(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.l.l(str2) != WorkInfo$State.CANCELLED) {
                this.l.b(WorkInfo$State.FAILED, str2);
            }
            linkedList.addAll(this.m.a(str2));
        }
    }

    private void g() {
        this.k.beginTransaction();
        try {
            this.l.b(WorkInfo$State.ENQUEUED, this.b);
            this.l.r(this.b, System.currentTimeMillis());
            this.l.c(this.b, -1L);
            this.k.setTransactionSuccessful();
        } finally {
            this.k.endTransaction();
            i(true);
        }
    }

    private void h() {
        this.k.beginTransaction();
        try {
            this.l.r(this.b, System.currentTimeMillis());
            this.l.b(WorkInfo$State.ENQUEUED, this.b);
            this.l.n(this.b);
            this.l.c(this.b, -1L);
            this.k.setTransactionSuccessful();
        } finally {
            this.k.endTransaction();
            i(false);
        }
    }

    private void i(boolean z) {
        ListenableWorker listenableWorker;
        this.k.beginTransaction();
        try {
            if (!this.k.k().j()) {
                sy1.a(this.a, RescheduleReceiver.class, false);
            }
            if (z) {
                this.l.b(WorkInfo$State.ENQUEUED, this.b);
                this.l.c(this.b, -1L);
            }
            if (this.e != null && (listenableWorker = this.f) != null && listenableWorker.i()) {
                this.j.b(this.b);
            }
            this.k.setTransactionSuccessful();
            this.k.endTransaction();
            this.f339q.p(Boolean.valueOf(z));
        } catch (Throwable th) {
            this.k.endTransaction();
            throw th;
        }
    }

    private void j() {
        WorkInfo$State workInfo$StateL = this.l.l(this.b);
        if (workInfo$StateL == WorkInfo$State.RUNNING) {
            fd1.c().a(t, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.b), new Throwable[0]);
            i(true);
        } else {
            fd1.c().a(t, String.format("Status for %s is %s; not doing any work", this.b, workInfo$StateL), new Throwable[0]);
            i(false);
        }
    }

    private void k() {
        androidx.work.b bVarB;
        if (n()) {
            return;
        }
        this.k.beginTransaction();
        try {
            xk3 xk3VarM = this.l.m(this.b);
            this.e = xk3VarM;
            if (xk3VarM == null) {
                fd1.c().b(t, String.format("Didn't find WorkSpec for id %s", this.b), new Throwable[0]);
                i(false);
                this.k.setTransactionSuccessful();
                this.k.endTransaction();
                return;
            }
            if (xk3VarM.b != WorkInfo$State.ENQUEUED) {
                j();
                this.k.setTransactionSuccessful();
                fd1.c().a(t, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.e.c), new Throwable[0]);
                this.k.endTransaction();
                return;
            }
            if (xk3VarM.d() || this.e.c()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                xk3 xk3Var = this.e;
                if (xk3Var.n != 0 && jCurrentTimeMillis < xk3Var.a()) {
                    fd1.c().a(t, String.format("Delaying execution for %s because it is being executed before schedule.", this.e.c), new Throwable[0]);
                    i(true);
                    this.k.setTransactionSuccessful();
                    this.k.endTransaction();
                    return;
                }
            }
            this.k.setTransactionSuccessful();
            this.k.endTransaction();
            if (this.e.d()) {
                bVarB = this.e.e;
            } else {
                s21 s21VarB = this.i.f().b(this.e.d);
                if (s21VarB == null) {
                    fd1.c().b(t, String.format("Could not create Input Merger %s", this.e.d), new Throwable[0]);
                    l();
                    return;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.e.e);
                    arrayList.addAll(this.l.p(this.b));
                    bVarB = s21VarB.b(arrayList);
                }
            }
            WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.b), bVarB, this.o, this.d, this.e.k, this.i.e(), this.g, this.i.m(), new vk3(this.k, this.g), new lk3(this.k, this.j, this.g));
            if (this.f == null) {
                this.f = this.i.m().b(this.a, this.e.c, workerParameters);
            }
            ListenableWorker listenableWorker = this.f;
            if (listenableWorker == null) {
                fd1.c().b(t, String.format("Could not create Worker %s", this.e.c), new Throwable[0]);
                l();
                return;
            }
            if (listenableWorker.k()) {
                fd1.c().b(t, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.e.c), new Throwable[0]);
                l();
                return;
            }
            this.f.n();
            if (!o()) {
                j();
                return;
            }
            if (n()) {
                return;
            }
            mn2 mn2VarT = mn2.t();
            kk3 kk3Var = new kk3(this.a, this.e, this.f, workerParameters.b(), this.g);
            this.g.a().execute(kk3Var);
            ub1 ub1VarA = kk3Var.a();
            ub1VarA.a(new a(ub1VarA, mn2VarT), this.g.a());
            mn2VarT.a(new b(mn2VarT, this.p), this.g.c());
        } catch (Throwable th) {
            this.k.endTransaction();
            throw th;
        }
    }

    private void m() {
        this.k.beginTransaction();
        try {
            this.l.b(WorkInfo$State.SUCCEEDED, this.b);
            this.l.h(this.b, ((ListenableWorker.a.c) this.h).e());
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (String str : this.m.a(this.b)) {
                if (this.l.l(str) == WorkInfo$State.BLOCKED && this.m.b(str)) {
                    fd1.c().d(t, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                    this.l.b(WorkInfo$State.ENQUEUED, str);
                    this.l.r(str, jCurrentTimeMillis);
                }
            }
            this.k.setTransactionSuccessful();
        } finally {
            this.k.endTransaction();
            i(false);
        }
    }

    private boolean n() {
        if (!this.s) {
            return false;
        }
        fd1.c().a(t, String.format("Work interrupted for %s", this.p), new Throwable[0]);
        WorkInfo$State workInfo$StateL = this.l.l(this.b);
        if (workInfo$StateL == null) {
            i(false);
        } else {
            i(!workInfo$StateL.isFinished());
        }
        return true;
    }

    private boolean o() {
        boolean z;
        this.k.beginTransaction();
        try {
            if (this.l.l(this.b) == WorkInfo$State.ENQUEUED) {
                this.l.b(WorkInfo$State.RUNNING, this.b);
                this.l.q(this.b);
                z = true;
            } else {
                z = false;
            }
            this.k.setTransactionSuccessful();
            return z;
        } finally {
            this.k.endTransaction();
        }
    }

    public ub1 b() {
        return this.f339q;
    }

    public void d() {
        boolean zIsDone;
        this.s = true;
        n();
        ub1 ub1Var = this.r;
        if (ub1Var != null) {
            zIsDone = ub1Var.isDone();
            this.r.cancel(true);
        } else {
            zIsDone = false;
        }
        ListenableWorker listenableWorker = this.f;
        if (listenableWorker != null && !zIsDone) {
            listenableWorker.p();
        } else {
            fd1.c().a(t, String.format("WorkSpec %s is already done. Not interrupting.", this.e), new Throwable[0]);
        }
    }

    void f() {
        if (!n()) {
            this.k.beginTransaction();
            try {
                WorkInfo$State workInfo$StateL = this.l.l(this.b);
                this.k.j().a(this.b);
                if (workInfo$StateL == null) {
                    i(false);
                } else if (workInfo$StateL == WorkInfo$State.RUNNING) {
                    c(this.h);
                } else if (!workInfo$StateL.isFinished()) {
                    g();
                }
                this.k.setTransactionSuccessful();
                this.k.endTransaction();
            } catch (Throwable th) {
                this.k.endTransaction();
                throw th;
            }
        }
        List list = this.c;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((rk2) it.next()).d(this.b);
            }
            sk2.b(this.i, this.k, this.c);
        }
    }

    void l() {
        this.k.beginTransaction();
        try {
            e(this.b);
            this.l.h(this.b, ((ListenableWorker.a.C0041a) this.h).e());
            this.k.setTransactionSuccessful();
        } finally {
            this.k.endTransaction();
            i(false);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        List listB = this.n.b(this.b);
        this.o = listB;
        this.p = a(listB);
        k();
    }
}
