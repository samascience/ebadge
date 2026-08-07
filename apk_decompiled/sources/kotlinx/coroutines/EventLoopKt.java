package kotlinx.coroutines;

import defpackage.yq0;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* JADX INFO: loaded from: classes4.dex */
public final class EventLoopKt {
    public static final EventLoop createEventLoop() {
        return new BlockingEventLoop(Thread.currentThread());
    }

    @InternalCoroutinesApi
    @DelicateCoroutinesApi
    public static final boolean isIoDispatcherThread(Thread thread) {
        if (thread instanceof CoroutineScheduler.Worker) {
            return ((CoroutineScheduler.Worker) thread).isIo();
        }
        return false;
    }

    public static final void platformAutoreleasePool(yq0 yq0Var) {
        yq0Var.invoke();
    }

    @InternalCoroutinesApi
    public static final long processNextEventInCurrentThread() {
        EventLoop eventLoopCurrentOrNull$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
        if (eventLoopCurrentOrNull$kotlinx_coroutines_core != null) {
            return eventLoopCurrentOrNull$kotlinx_coroutines_core.processNextEvent();
        }
        return Long.MAX_VALUE;
    }

    @InternalCoroutinesApi
    @DelicateCoroutinesApi
    public static final long runSingleTaskFromCurrentSystemDispatcher() {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread instanceof CoroutineScheduler.Worker) {
            return ((CoroutineScheduler.Worker) threadCurrentThread).runSingleTask();
        }
        throw new IllegalStateException("Expected CoroutineScheduler.Worker, but got " + threadCurrentThread);
    }
}
