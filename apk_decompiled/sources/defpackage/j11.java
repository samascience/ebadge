package defpackage;

import androidx.camera.core.x;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
abstract class j11 implements ub1 {

    static class a extends j11 {
        private final Throwable a;

        a(Throwable th) {
            this.a = th;
        }

        @Override // defpackage.j11, java.util.concurrent.Future
        public Object get() throws ExecutionException {
            throw new ExecutionException(this.a);
        }

        public String toString() {
            return super.toString() + "[status=FAILURE, cause=[" + this.a + "]]";
        }
    }

    static final class b extends a implements ScheduledFuture {
        b(Throwable th) {
            super(th);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(Delayed delayed) {
            return -1;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return 0L;
        }
    }

    static final class c extends j11 {
        static final j11 b = new c(null);
        private final Object a;

        c(Object obj) {
            this.a = obj;
        }

        @Override // defpackage.j11, java.util.concurrent.Future
        public Object get() {
            return this.a;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.a + "]]";
        }
    }

    j11() {
    }

    public static ub1 b() {
        return c.b;
    }

    @Override // defpackage.ub1
    public void a(Runnable runnable, Executor executor) {
        b52.g(runnable);
        b52.g(executor);
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            x.d("ImmediateFuture", "Experienced RuntimeException while attempting to notify " + runnable + " on Executor " + executor, e);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public abstract Object get();

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        b52.g(timeUnit);
        return get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }
}
