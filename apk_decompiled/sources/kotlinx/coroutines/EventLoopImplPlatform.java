package kotlinx.coroutines;

import defpackage.k83;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EventLoopImplPlatform extends EventLoop {
    protected abstract Thread getThread();

    protected void reschedule(long j, EventLoopImplBase.DelayedTask delayedTask) {
        DefaultExecutor.INSTANCE.schedule(j, delayedTask);
    }

    protected final void unpark() {
        k83 k83Var;
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
            if (timeSource != null) {
                timeSource.unpark(thread);
                k83Var = k83.a;
            } else {
                k83Var = null;
            }
            if (k83Var == null) {
                LockSupport.unpark(thread);
            }
        }
    }
}
