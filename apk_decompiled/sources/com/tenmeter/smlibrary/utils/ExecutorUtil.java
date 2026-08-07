package com.tenmeter.smlibrary.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class ExecutorUtil {
    private static Executor sIOExecutor;
    private static Executor sMainExecutor;
    private static Handler sMainHandler;

    public static synchronized Executor getIOExecutor() {
        try {
            if (sIOExecutor == null) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                sIOExecutor = threadPoolExecutor;
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
        } catch (Throwable th) {
            throw th;
        }
        return sIOExecutor;
    }

    private static synchronized Executor getMainExecutor() {
        try {
            if (sMainExecutor == null) {
                sMainHandler = new Handler(Looper.getMainLooper());
                sMainExecutor = new Executor() { // from class: com.tenmeter.smlibrary.utils.ExecutorUtil.1
                    @Override // java.util.concurrent.Executor
                    public void execute(Runnable runnable) {
                        ExecutorUtil.sMainHandler.post(runnable);
                    }
                };
            }
        } catch (Throwable th) {
            throw th;
        }
        return sMainExecutor;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            getMainExecutor().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static ThreadFactory threadFactory(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.tenmeter.smlibrary.utils.ExecutorUtil.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }
}
