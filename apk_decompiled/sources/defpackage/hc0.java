package defpackage;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class hc0 {
    private Runnable c;
    private ExecutorService d;
    private int a = 64;
    private int b = 5;
    private final ArrayDeque e = new ArrayDeque();
    private final ArrayDeque f = new ArrayDeque();
    private final ArrayDeque g = new ArrayDeque();

    private final gd2.a d(String str) {
        for (gd2.a aVar : this.f) {
            if (p31.a(aVar.d(), str)) {
                return aVar;
            }
        }
        for (gd2.a aVar2 : this.e) {
            if (p31.a(aVar2.d(), str)) {
                return aVar2;
            }
        }
        return null;
    }

    private final void e(Deque deque, Object obj) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.c;
            k83 k83Var = k83.a;
        }
        if (j() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private final boolean j() {
        int i;
        boolean z;
        if (pa3.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = this.e.iterator();
                p31.e(it, "readyAsyncCalls.iterator()");
                while (it.hasNext()) {
                    gd2.a aVar = (gd2.a) it.next();
                    if (this.f.size() >= this.a) {
                        break;
                    }
                    if (aVar.c().get() < this.b) {
                        it.remove();
                        aVar.c().incrementAndGet();
                        p31.e(aVar, "asyncCall");
                        arrayList.add(aVar);
                        this.f.add(aVar);
                    }
                }
                z = k() > 0;
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((gd2.a) arrayList.get(i)).a(c());
        }
        return z;
    }

    public final void a(gd2.a aVar) {
        gd2.a aVarD;
        p31.f(aVar, "call");
        synchronized (this) {
            try {
                this.e.add(aVar);
                if (!aVar.b().m() && (aVarD = d(aVar.d())) != null) {
                    aVar.e(aVarD);
                }
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        j();
    }

    public final synchronized void b(gd2 gd2Var) {
        p31.f(gd2Var, "call");
        this.g.add(gd2Var);
    }

    public final synchronized ExecutorService c() {
        ExecutorService executorService;
        try {
            if (this.d == null) {
                this.d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), pa3.M(pa3.i + " Dispatcher", false));
            }
            executorService = this.d;
            p31.c(executorService);
        } catch (Throwable th) {
            throw th;
        }
        return executorService;
    }

    public final void f(gd2.a aVar) {
        p31.f(aVar, "call");
        aVar.c().decrementAndGet();
        e(this.f, aVar);
    }

    public final void g(gd2 gd2Var) {
        p31.f(gd2Var, "call");
        e(this.g, gd2Var);
    }

    public final synchronized int h() {
        return this.a;
    }

    public final synchronized int i() {
        return this.b;
    }

    public final synchronized int k() {
        return this.f.size() + this.g.size();
    }

    public final void l(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(("max < 1: " + i).toString());
        }
        synchronized (this) {
            this.a = i;
            k83 k83Var = k83.a;
        }
        j();
    }

    public final void m(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(("max < 1: " + i).toString());
        }
        synchronized (this) {
            this.b = i;
            k83 k83Var = k83.a;
        }
        j();
    }
}
