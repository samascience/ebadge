package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.os0;
import defpackage.ub1;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class e extends AbstractExecutorService implements ScheduledExecutorService {
    private static ThreadLocal b = new a();
    private final Handler a;

    class a extends ThreadLocal {
        a() {
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ScheduledExecutorService initialValue() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return androidx.camera.core.impl.utils.executor.c.e();
            }
            if (Looper.myLooper() != null) {
                return new e(new Handler(Looper.myLooper()));
            }
            return null;
        }
    }

    class b implements Callable {
        final /* synthetic */ Runnable a;

        b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            this.a.run();
            return null;
        }
    }

    private static class c implements RunnableScheduledFuture {
        final AtomicReference a = new AtomicReference(null);
        private final long b;
        private final Callable c;
        private final ub1 d;

        class a implements CallbackToFutureAdapter.b {
            final /* synthetic */ Handler a;
            final /* synthetic */ Callable b;

            /* JADX INFO: renamed from: androidx.camera.core.impl.utils.executor.e$c$a$a, reason: collision with other inner class name */
            class RunnableC0008a implements Runnable {
                RunnableC0008a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.a.getAndSet(null) != null) {
                        a aVar = a.this;
                        aVar.a.removeCallbacks(c.this);
                    }
                }
            }

            a(Handler handler, Callable callable) {
                this.a = handler;
                this.b = callable;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public Object a(CallbackToFutureAdapter.a aVar) {
                aVar.a(new RunnableC0008a(), androidx.camera.core.impl.utils.executor.c.b());
                c.this.a.set(aVar);
                return "HandlerScheduledFuture-" + this.b.toString();
            }
        }

        c(Handler handler, long j, Callable callable) {
            this.b = j;
            this.c = callable;
            this.d = CallbackToFutureAdapter.a(new a(handler, callable));
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compareTo(Delayed delayed) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return Long.compare(getDelay(timeUnit), delayed.getDelay(timeUnit));
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return this.d.cancel(z);
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            return this.d.get();
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(this.b - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.d.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.d.isDone();
        }

        @Override // java.util.concurrent.RunnableScheduledFuture
        public boolean isPeriodic() {
            return false;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            CallbackToFutureAdapter.a aVar = (CallbackToFutureAdapter.a) this.a.getAndSet(null);
            if (aVar != null) {
                try {
                    aVar.c(this.c.call());
                } catch (Exception e) {
                    aVar.f(e);
                }
            }
        }

        @Override // java.util.concurrent.Future
        public Object get(long j, TimeUnit timeUnit) {
            return this.d.get(j, timeUnit);
        }
    }

    e(Handler handler) {
        this.a = handler;
    }

    private RejectedExecutionException a() {
        return new RejectedExecutionException(this.a + " is shutting down");
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(e.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (!this.a.post(runnable)) {
            throw a();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return schedule(new b(runnable), j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(e.class.getSimpleName() + " does not yet support fixed-rate scheduling.");
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(e.class.getSimpleName() + " does not yet support fixed-delay scheduling.");
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException(e.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        throw new UnsupportedOperationException(e.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        long jUptimeMillis = SystemClock.uptimeMillis() + TimeUnit.MILLISECONDS.convert(j, timeUnit);
        c cVar = new c(this.a, jUptimeMillis, callable);
        return this.a.postAtTime(cVar, jUptimeMillis) ? cVar : os0.o(a());
    }
}
