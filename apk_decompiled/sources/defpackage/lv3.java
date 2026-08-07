package defpackage;

import com.google.android.gms.tasks.DuplicateTaskCompletionException;
import com.google.android.gms.tasks.RuntimeExecutionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class lv3 extends u03 {
    private final Object a = new Object();
    private final av3 b = new av3();
    private boolean c;
    private volatile boolean d;
    private Object e;
    private Exception f;

    lv3() {
    }

    private final void l() {
        a52.j(this.c, "Task is not yet complete");
    }

    private final void m() {
        if (this.d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void n() {
        if (this.c) {
            throw DuplicateTaskCompletionException.of(this);
        }
    }

    private final void o() {
        synchronized (this.a) {
            try {
                if (this.c) {
                    this.b.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.u03
    public final u03 a(Executor executor, tu1 tu1Var) {
        this.b.a(new ku3(executor, tu1Var));
        o();
        return this;
    }

    @Override // defpackage.u03
    public final Exception b() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f;
        }
        return exc;
    }

    @Override // defpackage.u03
    public final Object c() {
        Object obj;
        synchronized (this.a) {
            try {
                l();
                m();
                Exception exc = this.f;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                obj = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // defpackage.u03
    public final Object d(Class cls) {
        Object obj;
        synchronized (this.a) {
            try {
                l();
                m();
                if (cls.isInstance(this.f)) {
                    throw ((Throwable) cls.cast(this.f));
                }
                Exception exc = this.f;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                obj = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // defpackage.u03
    public final boolean e() {
        return this.d;
    }

    @Override // defpackage.u03
    public final boolean f() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    @Override // defpackage.u03
    public final boolean g() {
        boolean z;
        synchronized (this.a) {
            try {
                z = false;
                if (this.c && !this.d && this.f == null) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public final void h(Exception exc) {
        a52.h(exc, "Exception must not be null");
        synchronized (this.a) {
            n();
            this.c = true;
            this.f = exc;
        }
        this.b.b(this);
    }

    public final void i(Object obj) {
        synchronized (this.a) {
            n();
            this.c = true;
            this.e = obj;
        }
        this.b.b(this);
    }

    public final boolean j(Exception exc) {
        a52.h(exc, "Exception must not be null");
        synchronized (this.a) {
            try {
                if (this.c) {
                    return false;
                }
                this.c = true;
                this.f = exc;
                this.b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean k(Object obj) {
        synchronized (this.a) {
            try {
                if (this.c) {
                    return false;
                }
                this.c = true;
                this.e = obj;
                this.b.b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
