package defpackage;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
class oq3 extends Thread {
    Handler a;
    private Object b;
    private boolean c;

    oq3(String str) {
        super(str);
        this.a = null;
        this.b = new Object();
        this.c = false;
    }

    public void a() {
        if (ym3.a) {
            ym3.b("Looper thread quit()");
        }
        this.a.getLooper().quit();
    }

    public void b() {
        synchronized (this.b) {
            try {
                if (!this.c) {
                    this.b.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void c() {
        synchronized (this.b) {
            this.c = true;
            this.b.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.a = new Handler();
        if (ym3.a) {
            ym3.b("new Handler() finish!!");
        }
        Looper.loop();
        if (ym3.a) {
            ym3.b("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }
}
