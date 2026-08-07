package defpackage;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public abstract class os0 {
    private static final wr0 a = new b();

    class a implements ab {
        final /* synthetic */ wr0 a;

        a(wr0 wr0Var) {
            this.a = wr0Var;
        }

        @Override // defpackage.ab
        public ub1 apply(Object obj) {
            return os0.p(this.a.apply(obj));
        }
    }

    class b implements wr0 {
        b() {
        }

        @Override // defpackage.wr0
        public Object apply(Object obj) {
            return obj;
        }
    }

    class c implements bs0 {
        final /* synthetic */ CallbackToFutureAdapter.a a;
        final /* synthetic */ wr0 b;

        c(CallbackToFutureAdapter.a aVar, wr0 wr0Var) {
            this.a = aVar;
            this.b = wr0Var;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            this.a.f(th);
        }

        @Override // defpackage.bs0
        public void onSuccess(Object obj) {
            try {
                this.a.c(this.b.apply(obj));
            } catch (Throwable th) {
                this.a.f(th);
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ ub1 a;

        d(ub1 ub1Var) {
            this.a = ub1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.cancel(true);
        }
    }

    private static final class e implements Runnable {
        final Future a;
        final bs0 b;

        e(Future future, bs0 bs0Var) {
            this.a = future;
            this.b = bs0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.onSuccess(os0.l(this.a));
            } catch (Error e) {
                e = e;
                this.b.a(e);
            } catch (RuntimeException e2) {
                e = e2;
                this.b.a(e);
            } catch (ExecutionException e3) {
                Throwable cause = e3.getCause();
                if (cause == null) {
                    this.b.a(e3);
                } else {
                    this.b.a(cause);
                }
            }
        }

        public String toString() {
            return e.class.getSimpleName() + "," + this.b;
        }
    }

    public static ub1 A(final long j, final ScheduledExecutorService scheduledExecutorService, final Object obj, final boolean z, final ub1 ub1Var) {
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: ls0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return os0.v(ub1Var, scheduledExecutorService, obj, z, j, aVar);
            }
        });
    }

    public static ub1 B(final ub1 ub1Var) {
        b52.g(ub1Var);
        return ub1Var.isDone() ? ub1Var : CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: js0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return os0.w(ub1Var, aVar);
            }
        });
    }

    public static void C(ub1 ub1Var, CallbackToFutureAdapter.a aVar) {
        D(ub1Var, a, aVar, androidx.camera.core.impl.utils.executor.c.b());
    }

    public static void D(ub1 ub1Var, wr0 wr0Var, CallbackToFutureAdapter.a aVar, Executor executor) {
        E(true, ub1Var, wr0Var, aVar, executor);
    }

    private static void E(boolean z, ub1 ub1Var, wr0 wr0Var, CallbackToFutureAdapter.a aVar, Executor executor) {
        b52.g(ub1Var);
        b52.g(wr0Var);
        b52.g(aVar);
        b52.g(executor);
        j(ub1Var, new c(aVar, wr0Var), executor);
        if (z) {
            aVar.a(new d(ub1Var), androidx.camera.core.impl.utils.executor.c.b());
        }
    }

    public static ub1 F(Collection collection) {
        return new rb1(new ArrayList(collection), false, androidx.camera.core.impl.utils.executor.c.b());
    }

    public static ub1 G(ub1 ub1Var, wr0 wr0Var, Executor executor) {
        b52.g(wr0Var);
        return H(ub1Var, new a(wr0Var), executor);
    }

    public static ub1 H(ub1 ub1Var, ab abVar, Executor executor) {
        zw zwVar = new zw(abVar, ub1Var);
        ub1Var.a(zwVar, executor);
        return zwVar;
    }

    public static ub1 I(final ub1 ub1Var) {
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: fs0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return os0.y(ub1Var, aVar);
            }
        });
    }

    public static void j(ub1 ub1Var, bs0 bs0Var, Executor executor) {
        b52.g(bs0Var);
        ub1Var.a(new e(ub1Var, bs0Var), executor);
    }

    public static ub1 k(Collection collection) {
        return new rb1(new ArrayList(collection), true, androidx.camera.core.impl.utils.executor.c.b());
    }

    public static Object l(Future future) {
        b52.j(future.isDone(), "Future was expected to be done, " + future);
        return m(future);
    }

    public static Object m(Future future) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static ub1 n(Throwable th) {
        return new j11.a(th);
    }

    public static ScheduledFuture o(Throwable th) {
        return new j11.b(th);
    }

    public static ub1 p(Object obj) {
        return obj == null ? j11.b() : new j11.c(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean q(CallbackToFutureAdapter.a aVar, ub1 ub1Var, long j) {
        return Boolean.valueOf(aVar.f(new TimeoutException("Future[" + ub1Var + "] is not done within " + j + " ms.")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object s(final ub1 ub1Var, ScheduledExecutorService scheduledExecutorService, final long j, final CallbackToFutureAdapter.a aVar) {
        C(ub1Var, aVar);
        if (!ub1Var.isDone()) {
            final ScheduledFuture scheduledFutureSchedule = scheduledExecutorService.schedule(new Callable() { // from class: ms0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return os0.q(aVar, ub1Var, j);
                }
            }, j, TimeUnit.MILLISECONDS);
            ub1Var.a(new Runnable() { // from class: ns0
                @Override // java.lang.Runnable
                public final void run() {
                    scheduledFutureSchedule.cancel(true);
                }
            }, androidx.camera.core.impl.utils.executor.c.b());
        }
        return "TimeoutFuture[" + ub1Var + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(CallbackToFutureAdapter.a aVar, Object obj, boolean z, ub1 ub1Var) {
        aVar.c(obj);
        if (z) {
            ub1Var.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object v(final ub1 ub1Var, ScheduledExecutorService scheduledExecutorService, final Object obj, final boolean z, long j, final CallbackToFutureAdapter.a aVar) {
        C(ub1Var, aVar);
        if (!ub1Var.isDone()) {
            final ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new Runnable() { // from class: gs0
                @Override // java.lang.Runnable
                public final void run() {
                    os0.t(aVar, obj, z, ub1Var);
                }
            }, j, TimeUnit.MILLISECONDS);
            ub1Var.a(new Runnable() { // from class: hs0
                @Override // java.lang.Runnable
                public final void run() {
                    scheduledFutureSchedule.cancel(true);
                }
            }, androidx.camera.core.impl.utils.executor.c.b());
        }
        return "TimeoutFuture[" + ub1Var + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object w(ub1 ub1Var, CallbackToFutureAdapter.a aVar) {
        E(false, ub1Var, a, aVar, androidx.camera.core.impl.utils.executor.c.b());
        return "nonCancellationPropagating[" + ub1Var + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object y(ub1 ub1Var, final CallbackToFutureAdapter.a aVar) {
        ub1Var.a(new Runnable() { // from class: is0
            @Override // java.lang.Runnable
            public final void run() {
                aVar.c(null);
            }
        }, androidx.camera.core.impl.utils.executor.c.b());
        return "transformVoidFuture [" + ub1Var + "]";
    }

    public static ub1 z(final long j, final ScheduledExecutorService scheduledExecutorService, final ub1 ub1Var) {
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: ks0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return os0.s(ub1Var, scheduledExecutorService, j, aVar);
            }
        });
    }
}
