package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class pe1 {
    public static Executor g = Executors.newCachedThreadPool();
    private Thread a;
    private final Set b;
    private final Set c;
    private final Handler d;
    private final FutureTask e;
    private volatile oe1 f;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (pe1.this.f == null || pe1.this.e.isCancelled()) {
                return;
            }
            oe1 oe1Var = pe1.this.f;
            if (oe1Var.b() != null) {
                pe1.this.k(oe1Var.b());
            } else {
                pe1.this.i(oe1Var.a());
            }
        }
    }

    class b extends Thread {
        private boolean a;

        b(String str) {
            super(str);
            this.a = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!isInterrupted() && !this.a) {
                if (pe1.this.e.isDone()) {
                    try {
                        pe1 pe1Var = pe1.this;
                        pe1Var.n((oe1) pe1Var.e.get());
                    } catch (InterruptedException | ExecutionException e) {
                        pe1.this.n(new oe1(e));
                    }
                    this.a = true;
                    pe1.this.p();
                }
            }
        }
    }

    public pe1(Callable callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Throwable th) {
        ArrayList arrayList = new ArrayList(this.c);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((me1) it.next()).onResult(th);
        }
    }

    private void j() {
        this.d.post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Object obj) {
        Iterator it = new ArrayList(this.b).iterator();
        while (it.hasNext()) {
            ((me1) it.next()).onResult(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(oe1 oe1Var) {
        if (this.f != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f = oe1Var;
        j();
    }

    private synchronized void o() {
        if (!q() && this.f == null) {
            b bVar = new b("LottieTaskObserver");
            this.a = bVar;
            bVar.start();
            o91.b("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p() {
        try {
            if (q()) {
                if (this.b.isEmpty() || this.f != null) {
                    this.a.interrupt();
                    this.a = null;
                    o91.b("Stopping TaskObserver thread");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private boolean q() {
        Thread thread = this.a;
        return thread != null && thread.isAlive();
    }

    public synchronized pe1 g(me1 me1Var) {
        try {
            if (this.f != null && this.f.a() != null) {
                me1Var.onResult(this.f.a());
            }
            this.c.add(me1Var);
            o();
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized pe1 h(me1 me1Var) {
        try {
            if (this.f != null && this.f.b() != null) {
                me1Var.onResult(this.f.b());
            }
            this.b.add(me1Var);
            o();
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized pe1 l(me1 me1Var) {
        this.c.remove(me1Var);
        p();
        return this;
    }

    public synchronized pe1 m(me1 me1Var) {
        this.b.remove(me1Var);
        p();
        return this;
    }

    pe1(Callable callable, boolean z) {
        this.b = new LinkedHashSet(1);
        this.c = new LinkedHashSet(1);
        this.d = new Handler(Looper.getMainLooper());
        this.f = null;
        FutureTask futureTask = new FutureTask(callable);
        this.e = futureTask;
        if (!z) {
            g.execute(futureTask);
            o();
        } else {
            try {
                n((oe1) callable.call());
            } catch (Throwable th) {
                n(new oe1(th));
            }
        }
    }
}
