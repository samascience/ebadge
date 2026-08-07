package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public abstract class ThreadUtils {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private static final Map b = new HashMap();
    private static final Map c = new ConcurrentHashMap();
    private static final int d = Runtime.getRuntime().availableProcessors();
    private static final Timer e = new Timer();

    private static final class LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {
        private int mCapacity;
        private volatile a mPool;

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

    static final class a extends ThreadPoolExecutor {
        private final AtomicInteger a;
        private LinkedBlockingQueue4Util b;

        a(int i, int i2, long j, TimeUnit timeUnit, LinkedBlockingQueue4Util linkedBlockingQueue4Util, ThreadFactory threadFactory) {
            super(i, i2, j, timeUnit, linkedBlockingQueue4Util, threadFactory);
            this.a = new AtomicInteger();
            linkedBlockingQueue4Util.mPool = this;
            this.b = linkedBlockingQueue4Util;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ExecutorService b(int i, int i2) {
            if (i == -8) {
                return new a(ThreadUtils.d + 1, (ThreadUtils.d * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cpu", i2));
            }
            if (i == -4) {
                return new a((ThreadUtils.d * 2) + 1, (ThreadUtils.d * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("io", i2));
            }
            if (i == -2) {
                return new a(0, 128, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cached", i2));
            }
            if (i == -1) {
                return new a(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("single", i2));
            }
            return new a(i, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("fixed(" + i + ")", i2));
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

    public static ExecutorService b() {
        return c(-2);
    }

    private static ExecutorService c(int i) {
        return d(i, 5);
    }

    private static ExecutorService d(int i, int i2) {
        ExecutorService executorServiceB;
        Map map = b;
        synchronized (map) {
            try {
                Map map2 = (Map) map.get(Integer.valueOf(i));
                if (map2 == null) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    executorServiceB = a.b(i, i2);
                    concurrentHashMap.put(Integer.valueOf(i2), executorServiceB);
                    map.put(Integer.valueOf(i), concurrentHashMap);
                } else {
                    executorServiceB = (ExecutorService) map2.get(Integer.valueOf(i2));
                    if (executorServiceB == null) {
                        executorServiceB = a.b(i, i2);
                        map2.put(Integer.valueOf(i2), executorServiceB);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorServiceB;
    }

    public static void e(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            a.post(runnable);
        }
    }

    public static void f(Runnable runnable, long j) {
        a.postDelayed(runnable, j);
    }
}
