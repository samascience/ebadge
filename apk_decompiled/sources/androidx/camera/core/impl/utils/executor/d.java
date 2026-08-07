package androidx.camera.core.impl.utils.executor;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class d implements Executor {
    private static volatile d a;

    d() {
    }

    static Executor a() {
        if (a != null) {
            return a;
        }
        synchronized (d.class) {
            try {
                if (a == null) {
                    a = new d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
