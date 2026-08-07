package org.greenrobot.greendao.async;

import android.os.Handler;
import android.os.Message;
import defpackage.e43;
import defpackage.s50;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
class a implements Runnable, Handler.Callback {
    private static ExecutorService e = Executors.newCachedThreadPool();
    private volatile boolean b;
    private final BlockingQueue a = new LinkedBlockingQueue();
    private volatile int c = 50;
    private volatile int d = 50;

    a() {
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                e43.a(this.a.poll(1L, TimeUnit.SECONDS));
                synchronized (this) {
                    e43.a(this.a.poll());
                    this.b = false;
                }
                this.b = false;
            } catch (InterruptedException e2) {
                s50.d(Thread.currentThread().getName() + " was interruppted", e2);
                this.b = false;
            }
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }
}
