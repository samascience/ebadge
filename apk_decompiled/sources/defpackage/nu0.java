package defpackage;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.open.SocialConstants;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class nu0 implements ExecutorService {
    private static final long b = TimeUnit.SECONDS.toMillis(10);
    private static volatile int c;
    private final ExecutorService a;

    public static final class a {
        private final boolean a;
        private int b;
        private int c;
        private c d = c.d;
        private String e;
        private long f;

        a(boolean z) {
            this.a = z;
        }

        public nu0 a() {
            if (TextUtils.isEmpty(this.e)) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.e);
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.b, this.c, this.f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(this.e, this.d, this.a));
            if (this.f != 0) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return new nu0(threadPoolExecutor);
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public a c(int i) {
            this.b = i;
            this.c = i;
            return this;
        }
    }

    private static final class b implements ThreadFactory {
        private final String a;
        final c b;
        final boolean c;
        private int d;

        class a extends Thread {
            a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                if (b.this.c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    b.this.b.a(th);
                }
            }
        }

        b(String str, c cVar, boolean z) {
            this.a = str;
            this.b = cVar;
            this.c = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            a aVar;
            aVar = new a(runnable, "glide-" + this.a + "-thread-" + this.d);
            this.d = this.d + 1;
            return aVar;
        }
    }

    public interface c {
        public static final c a = new a();
        public static final c b;
        public static final c c;
        public static final c d;

        class a implements c {
            a() {
            }

            @Override // nu0.c
            public void a(Throwable th) {
            }
        }

        class b implements c {
            b() {
            }

            @Override // nu0.c
            public void a(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        }

        /* JADX INFO: renamed from: nu0$c$c, reason: collision with other inner class name */
        class C0149c implements c {
            C0149c() {
            }

            @Override // nu0.c
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            b bVar = new b();
            b = bVar;
            c = new C0149c();
            d = bVar;
        }

        void a(Throwable th);
    }

    nu0(ExecutorService executorService) {
        this.a = executorService;
    }

    public static int a() {
        if (c == 0) {
            c = Math.min(4, ri2.a());
        }
        return c;
    }

    public static a b() {
        return new a(true).c(a() >= 4 ? 2 : 1).b("animation");
    }

    public static nu0 c() {
        return b().a();
    }

    public static a d() {
        return new a(true).c(1).b("disk-cache");
    }

    public static nu0 e() {
        return d().a();
    }

    public static a f() {
        return new a(false).c(a()).b(SocialConstants.PARAM_SOURCE);
    }

    public static nu0 g() {
        return f().a();
    }

    public static nu0 h() {
        return new nu0(new ThreadPoolExecutor(0, Integer.MAX_VALUE, b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b("source-unlimited", c.d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.a.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection) {
        return this.a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection) {
        return this.a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        return this.a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        return this.a.submit(runnable);
    }

    public String toString() {
        return this.a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection, long j, TimeUnit timeUnit) {
        return this.a.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection, long j, TimeUnit timeUnit) {
        return this.a.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return this.a.submit(runnable, obj);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        return this.a.submit(callable);
    }
}
