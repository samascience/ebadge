package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class b13 {
    public static final b h = new b(null);
    public static final b13 i = new b13(new c(pa3.M(pa3.i + " TaskRunner", true)));
    private static final Logger j;
    private final a a;
    private int b;
    private boolean c;
    private long d;
    private final List e;
    private final List f;
    private final Runnable g;

    public interface a {
        void a(b13 b13Var);

        long b();

        void c(b13 b13Var, long j);

        void execute(Runnable runnable);
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        public final Logger a() {
            return b13.j;
        }

        private b() {
        }
    }

    public static final class c implements a {
        private final ThreadPoolExecutor a;

        public c(ThreadFactory threadFactory) {
            p31.f(threadFactory, "threadFactory");
            this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // b13.a
        public void a(b13 b13Var) {
            p31.f(b13Var, "taskRunner");
            b13Var.notify();
        }

        @Override // b13.a
        public long b() {
            return System.nanoTime();
        }

        @Override // b13.a
        public void c(b13 b13Var, long j) throws InterruptedException {
            p31.f(b13Var, "taskRunner");
            long j2 = j / 1000000;
            long j3 = j - (1000000 * j2);
            if (j2 > 0 || j > 0) {
                b13Var.wait(j2, (int) j3);
            }
        }

        @Override // b13.a
        public void execute(Runnable runnable) {
            p31.f(runnable, "runnable");
            this.a.execute(runnable);
        }
    }

    public static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t03 t03VarD;
            long jB;
            while (true) {
                b13 b13Var = b13.this;
                synchronized (b13Var) {
                    t03VarD = b13Var.d();
                }
                if (t03VarD == null) {
                    return;
                }
                a13 a13VarD = t03VarD.d();
                p31.c(a13VarD);
                b13 b13Var2 = b13.this;
                boolean zIsLoggable = b13.h.a().isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jB = a13VarD.h().g().b();
                    y03.c(t03VarD, a13VarD, "starting");
                } else {
                    jB = -1;
                }
                try {
                    b13Var2.j(t03VarD);
                    try {
                        k83 k83Var = k83.a;
                        if (zIsLoggable) {
                            y03.c(t03VarD, a13VarD, "finished run in " + y03.b(a13VarD.h().g().b() - jB));
                        }
                    } catch (Throwable th) {
                        if (zIsLoggable) {
                            y03.c(t03VarD, a13VarD, "failed a run in " + y03.b(a13VarD.h().g().b() - jB));
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    b13Var2.g().execute(this);
                    throw th2;
                }
            }
        }
    }

    static {
        Logger logger = Logger.getLogger(b13.class.getName());
        p31.e(logger, "getLogger(TaskRunner::class.java.name)");
        j = logger;
    }

    public b13(a aVar) {
        p31.f(aVar, "backend");
        this.a = aVar;
        this.b = 10000;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new d();
    }

    private final void c(t03 t03Var, long j2) {
        if (pa3.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        a13 a13VarD = t03Var.d();
        p31.c(a13VarD);
        if (a13VarD.c() != t03Var) {
            throw new IllegalStateException("Check failed.");
        }
        boolean zD = a13VarD.d();
        a13VarD.m(false);
        a13VarD.l(null);
        this.e.remove(a13VarD);
        if (j2 != -1 && !zD && !a13VarD.g()) {
            a13VarD.k(t03Var, j2, true);
        }
        if (a13VarD.e().isEmpty()) {
            return;
        }
        this.f.add(a13VarD);
    }

    private final void e(t03 t03Var) {
        if (pa3.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        t03Var.g(-1L);
        a13 a13VarD = t03Var.d();
        p31.c(a13VarD);
        a13VarD.e().remove(t03Var);
        this.f.remove(a13VarD);
        a13VarD.l(t03Var);
        this.e.add(a13VarD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(t03 t03Var) {
        if (pa3.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(t03Var.b());
        try {
            long jF = t03Var.f();
            synchronized (this) {
                c(t03Var, jF);
                k83 k83Var = k83.a;
            }
        } finally {
            synchronized (this) {
                c(t03Var, -1L);
                k83 k83Var2 = k83.a;
                threadCurrentThread.setName(name);
            }
        }
    }

    public final t03 d() {
        boolean z;
        if (pa3.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        while (!this.f.isEmpty()) {
            long jB = this.a.b();
            Iterator it = this.f.iterator();
            long jMin = Long.MAX_VALUE;
            t03 t03Var = null;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                t03 t03Var2 = (t03) ((a13) it.next()).e().get(0);
                long jMax = Math.max(0L, t03Var2.c() - jB);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (t03Var != null) {
                        z = true;
                        break;
                    }
                    t03Var = t03Var2;
                }
            }
            if (t03Var != null) {
                e(t03Var);
                if (z || (!this.c && !this.f.isEmpty())) {
                    this.a.execute(this.g);
                }
                return t03Var;
            }
            if (this.c) {
                if (jMin < this.d - jB) {
                    this.a.a(this);
                }
                return null;
            }
            this.c = true;
            this.d = jB + jMin;
            try {
                try {
                    this.a.c(this, jMin);
                } catch (InterruptedException unused) {
                    f();
                }
                this.c = false;
            } catch (Throwable th) {
                this.c = false;
                throw th;
            }
        }
        return null;
    }

    public final void f() {
        int size = this.e.size();
        while (true) {
            size--;
            if (-1 >= size) {
                break;
            } else {
                ((a13) this.e.get(size)).b();
            }
        }
        for (int size2 = this.f.size() - 1; -1 < size2; size2--) {
            a13 a13Var = (a13) this.f.get(size2);
            a13Var.b();
            if (a13Var.e().isEmpty()) {
                this.f.remove(size2);
            }
        }
    }

    public final a g() {
        return this.a;
    }

    public final void h(a13 a13Var) {
        p31.f(a13Var, "taskQueue");
        if (pa3.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (a13Var.c() == null) {
            if (a13Var.e().isEmpty()) {
                this.f.remove(a13Var);
            } else {
                pa3.c(this.f, a13Var);
            }
        }
        if (this.c) {
            this.a.a(this);
        } else {
            this.a.execute(this.g);
        }
    }

    public final a13 i() {
        int i2;
        synchronized (this) {
            i2 = this.b;
            this.b = i2 + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('Q');
        sb.append(i2);
        return new a13(this, sb.toString());
    }
}
