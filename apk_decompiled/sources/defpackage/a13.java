package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes4.dex */
public final class a13 {
    private final b13 a;
    private final String b;
    private boolean c;
    private t03 d;
    private final List e;
    private boolean f;

    public a13(b13 b13Var, String str) {
        p31.f(b13Var, "taskRunner");
        p31.f(str, "name");
        this.a = b13Var;
        this.b = str;
        this.e = new ArrayList();
    }

    public static /* synthetic */ void j(a13 a13Var, t03 t03Var, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        a13Var.i(t03Var, j);
    }

    public final void a() {
        if (pa3.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this.a) {
            try {
                if (b()) {
                    this.a.h(this);
                }
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        t03 t03Var = this.d;
        if (t03Var != null) {
            p31.c(t03Var);
            if (t03Var.a()) {
                this.f = true;
            }
        }
        boolean z = false;
        for (int size = this.e.size() - 1; -1 < size; size--) {
            if (((t03) this.e.get(size)).a()) {
                t03 t03Var2 = (t03) this.e.get(size);
                if (b13.h.a().isLoggable(Level.FINE)) {
                    y03.c(t03Var2, this, "canceled");
                }
                this.e.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final t03 c() {
        return this.d;
    }

    public final boolean d() {
        return this.f;
    }

    public final List e() {
        return this.e;
    }

    public final String f() {
        return this.b;
    }

    public final boolean g() {
        return this.c;
    }

    public final b13 h() {
        return this.a;
    }

    public final void i(t03 t03Var, long j) {
        p31.f(t03Var, "task");
        synchronized (this.a) {
            if (!this.c) {
                if (k(t03Var, j, false)) {
                    this.a.h(this);
                }
                k83 k83Var = k83.a;
            } else if (t03Var.a()) {
                if (b13.h.a().isLoggable(Level.FINE)) {
                    y03.c(t03Var, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (b13.h.a().isLoggable(Level.FINE)) {
                    y03.c(t03Var, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean k(t03 t03Var, long j, boolean z) {
        String str;
        p31.f(t03Var, "task");
        t03Var.e(this);
        long jB = this.a.g().b();
        long j2 = jB + j;
        int iIndexOf = this.e.indexOf(t03Var);
        if (iIndexOf != -1) {
            if (t03Var.c() <= j2) {
                if (b13.h.a().isLoggable(Level.FINE)) {
                    y03.c(t03Var, this, "already scheduled");
                }
                return false;
            }
            this.e.remove(iIndexOf);
        }
        t03Var.g(j2);
        if (b13.h.a().isLoggable(Level.FINE)) {
            if (z) {
                str = "run again after " + y03.b(j2 - jB);
            } else {
                str = "scheduled after " + y03.b(j2 - jB);
            }
            y03.c(t03Var, this, str);
        }
        Iterator it = this.e.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (((t03) it.next()).c() - jB > j) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.e.size();
        }
        this.e.add(size, t03Var);
        return size == 0;
    }

    public final void l(t03 t03Var) {
        this.d = t03Var;
    }

    public final void m(boolean z) {
        this.f = z;
    }

    public final void n() {
        if (pa3.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this.a) {
            try {
                this.c = true;
                if (b()) {
                    this.a.h(this);
                }
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return this.b;
    }
}
