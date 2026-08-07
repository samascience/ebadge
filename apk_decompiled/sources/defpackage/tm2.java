package defpackage;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public class tm2 implements Executor {
    final Queue a = new ArrayDeque();
    final Executor b;
    Runnable c;

    class a implements Runnable {
        final /* synthetic */ Runnable a;

        a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } finally {
                tm2.this.a();
            }
        }
    }

    tm2(Executor executor) {
        this.b = executor;
    }

    protected synchronized void a() {
        Runnable runnable = (Runnable) this.a.poll();
        this.c = runnable;
        if (runnable != null) {
            this.b.execute(runnable);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        this.a.offer(new a(runnable));
        if (this.c == null) {
            a();
        }
    }
}
