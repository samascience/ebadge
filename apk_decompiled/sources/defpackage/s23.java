package defpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes4.dex */
public class s23 {
    private static final s23 c = new s23();
    private ExecutorService a;
    private final tm2 b;

    private s23() {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        this.a = executorServiceNewFixedThreadPool;
        this.b = new tm2(executorServiceNewFixedThreadPool);
    }

    public static s23 c() {
        return c;
    }

    public void a(Runnable runnable) {
        b(runnable, false);
    }

    public void b(Runnable runnable, boolean z) {
        if (z) {
            this.b.execute(runnable);
        } else {
            this.a.execute(runnable);
        }
    }
}
