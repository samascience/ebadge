package com.bumptech.glide.load.engine;

import android.os.Process;
import defpackage.qg2;
import defpackage.w81;
import defpackage.z42;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
final class a {
    private final boolean a;
    private final Executor b;
    final Map c;
    private final ReferenceQueue d;
    private m.a e;
    private volatile boolean f;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.a$a, reason: collision with other inner class name */
    class ThreadFactoryC0062a implements ThreadFactory {

        /* JADX INFO: renamed from: com.bumptech.glide.load.engine.a$a$a, reason: collision with other inner class name */
        class RunnableC0063a implements Runnable {
            final /* synthetic */ Runnable a;

            RunnableC0063a(Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.a.run();
            }
        }

        ThreadFactoryC0062a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(new RunnableC0063a(runnable), "glide-active-resources");
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    static final class c extends WeakReference {
        final w81 a;
        final boolean b;
        qg2 c;

        c(w81 w81Var, m mVar, ReferenceQueue referenceQueue, boolean z) {
            super(mVar, referenceQueue);
            this.a = (w81) z42.d(w81Var);
            this.c = (mVar.d() && z) ? (qg2) z42.d(mVar.c()) : null;
            this.b = mVar.d();
        }

        void a() {
            this.c = null;
            clear();
        }
    }

    a(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactoryC0062a()));
    }

    synchronized void a(w81 w81Var, m mVar) {
        c cVar = (c) this.c.put(w81Var, new c(w81Var, mVar, this.d, this.a));
        if (cVar != null) {
            cVar.a();
        }
    }

    void b() {
        while (!this.f) {
            try {
                c((c) this.d.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void c(c cVar) {
        qg2 qg2Var;
        synchronized (this) {
            this.c.remove(cVar.a);
            if (cVar.b && (qg2Var = cVar.c) != null) {
                this.e.b(cVar.a, new m(qg2Var, true, false, cVar.a, this.e));
            }
        }
    }

    synchronized void d(w81 w81Var) {
        c cVar = (c) this.c.remove(w81Var);
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    synchronized m e(w81 w81Var) {
        c cVar = (c) this.c.get(w81Var);
        if (cVar == null) {
            return null;
        }
        m mVar = (m) cVar.get();
        if (mVar == null) {
            c(cVar);
        }
        return mVar;
    }

    void f(m.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.e = aVar;
            }
        }
    }

    a(boolean z, Executor executor) {
        this.c = new HashMap();
        this.d = new ReferenceQueue();
        this.a = z;
        this.b = executor;
        executor.execute(new b());
    }
}
