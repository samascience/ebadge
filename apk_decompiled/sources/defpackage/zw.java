package defpackage;

import androidx.camera.core.impl.utils.executor.c;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
class zw extends cs0 implements Runnable {
    private ab c;
    private final BlockingQueue d = new LinkedBlockingQueue(1);
    private final CountDownLatch e = new CountDownLatch(1);
    private ub1 f;
    volatile ub1 g;

    class a implements Runnable {
        final /* synthetic */ ub1 a;

        a(ub1 ub1Var) {
            this.a = ub1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    zw.this.c(os0.m(this.a));
                } catch (CancellationException unused) {
                    zw.this.cancel(false);
                } catch (ExecutionException e) {
                    zw.this.d(e.getCause());
                }
            } finally {
                zw.this.g = null;
            }
        }
    }

    zw(ab abVar, ub1 ub1Var) {
        this.c = (ab) b52.g(abVar);
        this.f = (ub1) b52.g(ub1Var);
    }

    private void g(Future future, boolean z) {
        if (future != null) {
            future.cancel(z);
        }
    }

    private void h(BlockingQueue blockingQueue, Object obj) {
        boolean z = false;
        while (true) {
            try {
                blockingQueue.put(obj);
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
    }

    private Object i(BlockingQueue blockingQueue) {
        Object objTake;
        boolean z = false;
        while (true) {
            try {
                objTake = blockingQueue.take();
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
        return objTake;
    }

    @Override // defpackage.cs0, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!super.cancel(z)) {
            return false;
        }
        h(this.d, Boolean.valueOf(z));
        g(this.f, z);
        g(this.g, z);
        return true;
    }

    @Override // defpackage.cs0, java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        if (!isDone()) {
            ub1 ub1Var = this.f;
            if (ub1Var != null) {
                ub1Var.get();
            }
            this.e.await();
            ub1 ub1Var2 = this.g;
            if (ub1Var2 != null) {
                ub1Var2.get();
            }
        }
        return super.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    try {
                        try {
                            ub1 ub1VarApply = this.c.apply(os0.m(this.f));
                            this.g = ub1VarApply;
                            if (!isCancelled()) {
                                ub1VarApply.a(new a(ub1VarApply), c.b());
                            } else {
                                ub1VarApply.cancel(((Boolean) i(this.d)).booleanValue());
                                this.g = null;
                            }
                        } catch (Exception e) {
                            d(e);
                        }
                    } catch (Error e2) {
                        d(e2);
                    }
                } finally {
                    this.c = null;
                    this.f = null;
                    this.e.countDown();
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e3) {
                d(e3.getCause());
            }
        } catch (UndeclaredThrowableException e4) {
            d(e4.getCause());
        }
    }

    @Override // defpackage.cs0, java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (!isDone()) {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (timeUnit != timeUnit2) {
                j = timeUnit2.convert(j, timeUnit);
                timeUnit = timeUnit2;
            }
            ub1 ub1Var = this.f;
            if (ub1Var != null) {
                long jNanoTime = System.nanoTime();
                ub1Var.get(j, timeUnit);
                j -= Math.max(0L, System.nanoTime() - jNanoTime);
            }
            long jNanoTime2 = System.nanoTime();
            if (this.e.await(j, timeUnit)) {
                j -= Math.max(0L, System.nanoTime() - jNanoTime2);
                ub1 ub1Var2 = this.g;
                if (ub1Var2 != null) {
                    ub1Var2.get(j, timeUnit);
                }
            } else {
                throw new TimeoutException();
            }
        }
        return super.get(j, timeUnit);
    }
}
