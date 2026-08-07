package kotlinx.coroutines;

import defpackage.k83;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes4.dex */
public final class AbstractTimeSourceKt {
    private static AbstractTimeSource timeSource;

    private static final long currentTimeMillis() {
        AbstractTimeSource timeSource2 = getTimeSource();
        return timeSource2 != null ? timeSource2.currentTimeMillis() : System.currentTimeMillis();
    }

    public static final AbstractTimeSource getTimeSource() {
        return timeSource;
    }

    private static final long nanoTime() {
        AbstractTimeSource timeSource2 = getTimeSource();
        return timeSource2 != null ? timeSource2.nanoTime() : System.nanoTime();
    }

    private static final void parkNanos(Object obj, long j) {
        k83 k83Var;
        AbstractTimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.parkNanos(obj, j);
            k83Var = k83.a;
        } else {
            k83Var = null;
        }
        if (k83Var == null) {
            LockSupport.parkNanos(obj, j);
        }
    }

    private static final void registerTimeLoopThread() {
        AbstractTimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.registerTimeLoopThread();
        }
    }

    public static final void setTimeSource(AbstractTimeSource abstractTimeSource) {
        timeSource = abstractTimeSource;
    }

    private static final void trackTask() {
        AbstractTimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.trackTask();
        }
    }

    private static final void unTrackTask() {
        AbstractTimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.unTrackTask();
        }
    }

    private static final void unpark(Thread thread) {
        k83 k83Var;
        AbstractTimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.unpark(thread);
            k83Var = k83.a;
        } else {
            k83Var = null;
        }
        if (k83Var == null) {
            LockSupport.unpark(thread);
        }
    }

    private static final void unregisterTimeLoopThread() {
        AbstractTimeSource timeSource2 = getTimeSource();
        if (timeSource2 != null) {
            timeSource2.unregisterTimeLoopThread();
        }
    }

    private static final Runnable wrapTask(Runnable runnable) {
        Runnable runnableWrapTask;
        AbstractTimeSource timeSource2 = getTimeSource();
        return (timeSource2 == null || (runnableWrapTask = timeSource2.wrapTask(runnable)) == null) ? runnable : runnableWrapTask;
    }
}
