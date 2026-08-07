package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import defpackage.aj0;
import defpackage.ak0;
import defpackage.h42;
import defpackage.nu0;
import defpackage.qg2;
import defpackage.sg2;
import defpackage.tt2;
import defpackage.w81;
import defpackage.z42;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
class i implements DecodeJob.b, ak0.f {
    private static final c z = new c();
    final e a;
    private final tt2 b;
    private final m.a c;
    private final h42 d;
    private final c e;
    private final j f;
    private final nu0 g;
    private final nu0 h;
    private final nu0 i;
    private final nu0 j;
    private final AtomicInteger k;
    private w81 l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private qg2 f226q;
    DataSource r;
    private boolean s;
    GlideException t;
    private boolean u;
    m v;
    private DecodeJob w;
    private volatile boolean x;
    private boolean y;

    private class a implements Runnable {
        private final sg2 a;

        a(sg2 sg2Var) {
            this.a = sg2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.g()) {
                synchronized (i.this) {
                    try {
                        if (i.this.a.b(this.a)) {
                            i.this.f(this.a);
                        }
                        i.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    private class b implements Runnable {
        private final sg2 a;

        b(sg2 sg2Var) {
            this.a = sg2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.g()) {
                synchronized (i.this) {
                    try {
                        if (i.this.a.b(this.a)) {
                            i.this.v.b();
                            i.this.g(this.a);
                            i.this.r(this.a);
                        }
                        i.this.i();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    static class c {
        c() {
        }

        public m a(qg2 qg2Var, boolean z, w81 w81Var, m.a aVar) {
            return new m(qg2Var, z, true, w81Var, aVar);
        }
    }

    static final class d {
        final sg2 a;
        final Executor b;

        d(sg2 sg2Var, Executor executor) {
            this.a = sg2Var;
            this.b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    static final class e implements Iterable {
        private final List a;

        e() {
            this(new ArrayList(2));
        }

        private static d d(sg2 sg2Var) {
            return new d(sg2Var, aj0.a());
        }

        void a(sg2 sg2Var, Executor executor) {
            this.a.add(new d(sg2Var, executor));
        }

        boolean b(sg2 sg2Var) {
            return this.a.contains(d(sg2Var));
        }

        e c() {
            return new e(new ArrayList(this.a));
        }

        void clear() {
            this.a.clear();
        }

        void e(sg2 sg2Var) {
            this.a.remove(d(sg2Var));
        }

        boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.a.iterator();
        }

        int size() {
            return this.a.size();
        }

        e(List list) {
            this.a = list;
        }
    }

    i(nu0 nu0Var, nu0 nu0Var2, nu0 nu0Var3, nu0 nu0Var4, j jVar, m.a aVar, h42 h42Var) {
        this(nu0Var, nu0Var2, nu0Var3, nu0Var4, jVar, aVar, h42Var, z);
    }

    private nu0 j() {
        if (this.n) {
            return this.i;
        }
        return this.o ? this.j : this.h;
    }

    private boolean m() {
        return this.u || this.s || this.x;
    }

    private synchronized void q() {
        if (this.l == null) {
            throw new IllegalArgumentException();
        }
        this.a.clear();
        this.l = null;
        this.v = null;
        this.f226q = null;
        this.u = false;
        this.x = false;
        this.s = false;
        this.y = false;
        this.w.w(false);
        this.w = null;
        this.t = null;
        this.r = null;
        this.d.a(this);
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void a(GlideException glideException) {
        synchronized (this) {
            this.t = glideException;
        }
        n();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void b(DecodeJob decodeJob) {
        j().execute(decodeJob);
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void c(qg2 qg2Var, DataSource dataSource, boolean z2) {
        synchronized (this) {
            this.f226q = qg2Var;
            this.r = dataSource;
            this.y = z2;
        }
        o();
    }

    synchronized void d(sg2 sg2Var, Executor executor) {
        try {
            this.b.c();
            this.a.a(sg2Var, executor);
            if (this.s) {
                k(1);
                executor.execute(new b(sg2Var));
            } else if (this.u) {
                k(1);
                executor.execute(new a(sg2Var));
            } else {
                z42.a(!this.x, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ak0.f
    public tt2 e() {
        return this.b;
    }

    void f(sg2 sg2Var) {
        try {
            sg2Var.a(this.t);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    void g(sg2 sg2Var) {
        try {
            sg2Var.c(this.v, this.r, this.y);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    void h() {
        if (m()) {
            return;
        }
        this.x = true;
        this.w.a();
        this.f.a(this, this.l);
    }

    void i() {
        m mVar;
        synchronized (this) {
            try {
                this.b.c();
                z42.a(m(), "Not yet complete!");
                int iDecrementAndGet = this.k.decrementAndGet();
                z42.a(iDecrementAndGet >= 0, "Can't decrement below 0");
                if (iDecrementAndGet == 0) {
                    mVar = this.v;
                    q();
                } else {
                    mVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (mVar != null) {
            mVar.e();
        }
    }

    synchronized void k(int i) {
        m mVar;
        z42.a(m(), "Not yet complete!");
        if (this.k.getAndAdd(i) == 0 && (mVar = this.v) != null) {
            mVar.b();
        }
    }

    synchronized i l(w81 w81Var, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.l = w81Var;
        this.m = z2;
        this.n = z3;
        this.o = z4;
        this.p = z5;
        return this;
    }

    void n() {
        synchronized (this) {
            try {
                this.b.c();
                if (this.x) {
                    q();
                    return;
                }
                if (this.a.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.u) {
                    throw new IllegalStateException("Already failed once");
                }
                this.u = true;
                w81 w81Var = this.l;
                e<d> eVarC = this.a.c();
                k(eVarC.size() + 1);
                this.f.c(this, w81Var, null);
                for (d dVar : eVarC) {
                    dVar.b.execute(new a(dVar.a));
                }
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void o() {
        synchronized (this) {
            try {
                this.b.c();
                if (this.x) {
                    this.f226q.a();
                    q();
                    return;
                }
                if (this.a.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.s) {
                    throw new IllegalStateException("Already have resource");
                }
                this.v = this.e.a(this.f226q, this.m, this.l, this.c);
                this.s = true;
                e<d> eVarC = this.a.c();
                k(eVarC.size() + 1);
                this.f.c(this, this.l, this.v);
                for (d dVar : eVarC) {
                    dVar.b.execute(new b(dVar.a));
                }
                i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean p() {
        return this.p;
    }

    synchronized void r(sg2 sg2Var) {
        try {
            this.b.c();
            this.a.e(sg2Var);
            if (this.a.isEmpty()) {
                h();
                if (this.s || this.u) {
                    if (this.k.get() == 0) {
                        q();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void s(DecodeJob decodeJob) {
        try {
            this.w = decodeJob;
            (decodeJob.C() ? this.g : j()).execute(decodeJob);
        } catch (Throwable th) {
            throw th;
        }
    }

    i(nu0 nu0Var, nu0 nu0Var2, nu0 nu0Var3, nu0 nu0Var4, j jVar, m.a aVar, h42 h42Var, c cVar) {
        this.a = new e();
        this.b = tt2.a();
        this.k = new AtomicInteger();
        this.g = nu0Var;
        this.h = nu0Var2;
        this.i = nu0Var3;
        this.j = nu0Var4;
        this.f = jVar;
        this.c = aVar;
        this.d = h42Var;
        this.e = cVar;
    }
}
