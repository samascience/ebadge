package com.luck.picture.lib.thread;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PictureThreadUtils {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private static final Map b = new HashMap();
    private static final Map c = new ConcurrentHashMap();
    private static final int d = Runtime.getRuntime().availableProcessors();
    private static final Timer e = new Timer();
    private static Executor f;

    private static final class LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {
        private int mCapacity;
        private volatile f mPool;

        LinkedBlockingQueue4Util() {
            this.mCapacity = Integer.MAX_VALUE;
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(Runnable runnable) {
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer(runnable);
            }
            return false;
        }

        LinkedBlockingQueue4Util(boolean z) {
            this.mCapacity = Integer.MAX_VALUE;
            if (z) {
                this.mCapacity = 0;
            }
        }

        LinkedBlockingQueue4Util(int i) {
            this.mCapacity = i;
        }
    }

    static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        class a extends Thread {
            a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (Throwable th) {
                    Log.e("ThreadUtils", "Request threw uncaught throwable", th);
                }
            }
        }

        class b implements Thread.UncaughtExceptionHandler {
            b() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                System.out.println(th);
            }
        }

        UtilsThreadFactory(String str, int i) {
            this(str, i, false);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            a aVar = new a(runnable, this.namePrefix + getAndIncrement());
            aVar.setDaemon(this.isDaemon);
            aVar.setUncaughtExceptionHandler(new b());
            aVar.setPriority(this.priority);
            return aVar;
        }

        UtilsThreadFactory(String str, int i, boolean z) {
            this.namePrefix = str + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = i;
            this.isDaemon = z;
        }
    }

    class a extends TimerTask {
        final /* synthetic */ ExecutorService a;
        final /* synthetic */ e b;

        a(ExecutorService executorService, e eVar) {
            this.a = executorService;
            this.b = eVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.a.execute(this.b);
        }
    }

    class b extends TimerTask {
        final /* synthetic */ ExecutorService a;
        final /* synthetic */ e b;

        b(ExecutorService executorService, e eVar) {
            this.a = executorService;
            this.b = eVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.a.execute(this.b);
        }
    }

    class c implements Executor {
        c() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            PictureThreadUtils.m(runnable);
        }
    }

    public static abstract class d extends e {
        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        public void f() {
            Log.e("ThreadUtils", "onCancel: " + Thread.currentThread());
        }

        @Override // com.luck.picture.lib.thread.PictureThreadUtils.e
        public void h(Throwable th) {
            Log.e("ThreadUtils", "onFail: ", th);
        }
    }

    public static abstract class e implements Runnable {
        private final AtomicInteger a = new AtomicInteger(0);
        private volatile boolean b;
        private volatile Thread c;
        private Timer d;
        private Executor e;

        class a implements Runnable {
            final /* synthetic */ Object a;

            a(Object obj) {
                this.a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.i(this.a);
            }
        }

        class b implements Runnable {
            final /* synthetic */ Object a;

            b(Object obj) {
                this.a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.i(this.a);
                e.this.g();
            }
        }

        class c implements Runnable {
            final /* synthetic */ Throwable a;

            c(Throwable th) {
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.h(this.a);
                e.this.g();
            }
        }

        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f();
                e.this.g();
            }
        }

        private Executor e() {
            Executor executor = this.e;
            return executor == null ? PictureThreadUtils.i() : executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(boolean z) {
            this.b = z;
        }

        public void b() {
            c(true);
        }

        public void c(boolean z) {
            synchronized (this.a) {
                try {
                    if (this.a.get() > 1) {
                        return;
                    }
                    this.a.set(4);
                    if (z && this.c != null) {
                        this.c.interrupt();
                    }
                    e().execute(new d());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public abstract Object d();

        public abstract void f();

        protected void g() {
            PictureThreadUtils.c.remove(this);
            Timer timer = this.d;
            if (timer != null) {
                timer.cancel();
                this.d = null;
            }
        }

        public abstract void h(Throwable th);

        public abstract void i(Object obj);

        @Override // java.lang.Runnable
        public void run() {
            if (this.b) {
                if (this.c == null) {
                    if (!this.a.compareAndSet(0, 1)) {
                        return;
                    } else {
                        this.c = Thread.currentThread();
                    }
                } else if (this.a.get() != 1) {
                    return;
                }
            } else if (!this.a.compareAndSet(0, 1)) {
                return;
            } else {
                this.c = Thread.currentThread();
            }
            try {
                Object objD = d();
                if (this.b) {
                    if (this.a.get() != 1) {
                        return;
                    }
                    e().execute(new a(objD));
                } else if (this.a.compareAndSet(1, 3)) {
                    e().execute(new b(objD));
                }
            } catch (InterruptedException unused) {
                this.a.compareAndSet(4, 5);
            } catch (Throwable th) {
                if (this.a.compareAndSet(1, 2)) {
                    e().execute(new c(th));
                }
            }
        }
    }

    static final class f extends ThreadPoolExecutor {
        private final AtomicInteger a;
        private final LinkedBlockingQueue4Util b;

        f(int i, int i2, long j, TimeUnit timeUnit, LinkedBlockingQueue4Util linkedBlockingQueue4Util, ThreadFactory threadFactory) {
            super(i, i2, j, timeUnit, linkedBlockingQueue4Util, threadFactory);
            this.a = new AtomicInteger();
            linkedBlockingQueue4Util.mPool = this;
            this.b = linkedBlockingQueue4Util;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ExecutorService b(int i, int i2) {
            if (i == -8) {
                return new f(PictureThreadUtils.d + 1, (PictureThreadUtils.d * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cpu", i2));
            }
            if (i == -4) {
                return new f(5, 10, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(100), new UtilsThreadFactory("io", i2));
            }
            if (i == -2) {
                return new f(0, 128, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cached", i2));
            }
            if (i == -1) {
                return new f(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("single", i2));
            }
            return new f(i, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("fixed(" + i + ")", i2));
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable runnable, Throwable th) {
            this.a.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (isShutdown()) {
                return;
            }
            this.a.incrementAndGet();
            try {
                super.execute(runnable);
            } catch (RejectedExecutionException unused) {
                Log.e("ThreadUtils", "This will not happen!");
                this.b.offer(runnable);
            } catch (Throwable unused2) {
                this.a.decrementAndGet();
            }
        }
    }

    public static void d(e eVar) {
        if (eVar == null) {
            return;
        }
        eVar.b();
    }

    public static void e(ExecutorService executorService) {
        if (!(executorService instanceof f)) {
            Log.e("ThreadUtils", "The executorService is not ThreadUtils's pool.");
            return;
        }
        for (Map.Entry entry : c.entrySet()) {
            if (entry.getValue() == executorService) {
                d((e) entry.getKey());
            }
        }
    }

    private static void f(ExecutorService executorService, e eVar) {
        g(executorService, eVar, 0L, 0L, null);
    }

    private static void g(ExecutorService executorService, e eVar, long j, long j2, TimeUnit timeUnit) {
        Map map = c;
        synchronized (map) {
            try {
                if (map.get(eVar) != null) {
                    Log.e("ThreadUtils", "Task can only be executed once.");
                    return;
                }
                map.put(eVar, executorService);
                if (j2 != 0) {
                    eVar.j(true);
                    e.scheduleAtFixedRate(new b(executorService, eVar), timeUnit.toMillis(j), timeUnit.toMillis(j2));
                } else if (j == 0) {
                    executorService.execute(eVar);
                } else {
                    e.schedule(new a(executorService, eVar), timeUnit.toMillis(j));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void h(e eVar) {
        f(k(-4), eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Executor i() {
        if (f == null) {
            f = new c();
        }
        return f;
    }

    public static ExecutorService j() {
        return k(-4);
    }

    private static ExecutorService k(int i) {
        return l(i, 5);
    }

    private static ExecutorService l(int i, int i2) {
        ExecutorService executorServiceB;
        Map map = b;
        synchronized (map) {
            try {
                Map map2 = (Map) map.get(Integer.valueOf(i));
                if (map2 == null) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    executorServiceB = f.b(i, i2);
                    concurrentHashMap.put(Integer.valueOf(i2), executorServiceB);
                    map.put(Integer.valueOf(i), concurrentHashMap);
                } else {
                    executorServiceB = (ExecutorService) map2.get(Integer.valueOf(i2));
                    if (executorServiceB == null) {
                        executorServiceB = f.b(i, i2);
                        map2.put(Integer.valueOf(i2), executorServiceB);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorServiceB;
    }

    public static void m(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            a.post(runnable);
        }
    }
}
