package androidx.camera.core.impl.utils.executor;

import android.os.Process;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class b implements Executor {
    private static volatile Executor b;
    private final ExecutorService a = Executors.newFixedThreadPool(2, new a());

    class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(0);

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Runnable runnable) {
            Process.setThreadPriority(-16);
            runnable.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable runnable) {
            Thread thread = new Thread(new Runnable() { // from class: androidx.camera.core.impl.utils.executor.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.a.b(runnable);
                }
            });
            thread.setName(String.format(Locale.US, "CameraX-camerax_audio_%d", Integer.valueOf(this.a.getAndIncrement())));
            return thread;
        }
    }

    static Executor a() {
        if (b != null) {
            return b;
        }
        synchronized (b.class) {
            try {
                if (b == null) {
                    b = new b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.execute(runnable);
    }
}
