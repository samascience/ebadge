package defpackage;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
abstract class gf2 {

    private static class a implements ThreadFactory {
        private String a;
        private int b;

        /* JADX INFO: renamed from: gf2$a$a, reason: collision with other inner class name */
        private static class C0129a extends Thread {
            private final int a;

            C0129a(Runnable runnable, String str, int i) {
                super(runnable, str);
                this.a = i;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.a);
                super.run();
            }
        }

        a(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0129a(runnable, this.a, this.b);
        }
    }

    private static class b implements Executor {
        private final Handler a;

        b(Handler handler) {
            this.a = (Handler) b52.g(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.a.post((Runnable) b52.g(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.a + " is shutting down");
        }
    }

    private static class c implements Runnable {
        private Callable a;
        private q20 b;
        private Handler c;

        class a implements Runnable {
            final /* synthetic */ q20 a;
            final /* synthetic */ Object b;

            a(q20 q20Var, Object obj) {
                this.a = q20Var;
                this.b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.accept(this.b);
            }
        }

        c(Handler handler, Callable callable, q20 q20Var) {
            this.a = callable;
            this.b = q20Var;
            this.c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object objCall;
            try {
                objCall = this.a.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.c.post(new a(this.b, objCall));
        }
    }

    static ThreadPoolExecutor a(String str, int i, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i2, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static Executor b(Handler handler) {
        return new b(handler);
    }

    static void c(Executor executor, Callable callable, q20 q20Var) {
        executor.execute(new c(iq.a(), callable, q20Var));
    }

    static Object d(ExecutorService executorService, Callable callable, int i) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw e;
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
