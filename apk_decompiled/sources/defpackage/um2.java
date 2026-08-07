package defpackage;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class um2 implements Executor {
    private final Executor b;
    private volatile Runnable d;
    private final ArrayDeque a = new ArrayDeque();
    private final Object c = new Object();

    static class a implements Runnable {
        final um2 a;
        final Runnable b;

        a(um2 um2Var, Runnable runnable) {
            this.a = um2Var;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } finally {
                this.a.b();
            }
        }
    }

    public um2(Executor executor) {
        this.b = executor;
    }

    public boolean a() {
        boolean z;
        synchronized (this.c) {
            z = !this.a.isEmpty();
        }
        return z;
    }

    void b() {
        synchronized (this.c) {
            try {
                Runnable runnable = (Runnable) this.a.poll();
                this.d = runnable;
                if (runnable != null) {
                    this.b.execute(this.d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        synchronized (this.c) {
            try {
                this.a.add(new a(this, runnable));
                if (this.d == null) {
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
