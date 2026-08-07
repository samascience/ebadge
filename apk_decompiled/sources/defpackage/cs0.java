package defpackage;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class cs0 implements ub1 {
    private final ub1 a;
    CallbackToFutureAdapter.a b;

    class a implements CallbackToFutureAdapter.b {
        a() {
        }

        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
        public Object a(CallbackToFutureAdapter.a aVar) {
            b52.j(cs0.this.b == null, "The result can only set once!");
            cs0.this.b = aVar;
            return "FutureChain[" + cs0.this + "]";
        }
    }

    cs0(ub1 ub1Var) {
        this.a = (ub1) b52.g(ub1Var);
    }

    public static cs0 b(ub1 ub1Var) {
        return ub1Var instanceof cs0 ? (cs0) ub1Var : new cs0(ub1Var);
    }

    @Override // defpackage.ub1
    public void a(Runnable runnable, Executor executor) {
        this.a.a(runnable, executor);
    }

    boolean c(Object obj) {
        CallbackToFutureAdapter.a aVar = this.b;
        if (aVar != null) {
            return aVar.c(obj);
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.a.cancel(z);
    }

    boolean d(Throwable th) {
        CallbackToFutureAdapter.a aVar = this.b;
        if (aVar != null) {
            return aVar.f(th);
        }
        return false;
    }

    public final cs0 e(wr0 wr0Var, Executor executor) {
        return (cs0) os0.G(this, wr0Var, executor);
    }

    public final cs0 f(ab abVar, Executor executor) {
        return (cs0) os0.H(this, abVar, executor);
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return this.a.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.a.isDone();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return this.a.get(j, timeUnit);
    }

    cs0() {
        this.a = CallbackToFutureAdapter.a(new a());
    }
}
