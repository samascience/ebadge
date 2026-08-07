package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
abstract class h {
    private static volatile ScheduledExecutorService a;

    static ScheduledExecutorService a() {
        if (a != null) {
            return a;
        }
        synchronized (h.class) {
            try {
                if (a == null) {
                    a = new e(new Handler(Looper.getMainLooper()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a;
    }
}
