package kotlinx.coroutines;

import defpackage.or0;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BuildersKt__BuildersKt {
    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    public static final <T> T runBlocking(d dVar, or0 or0Var) throws InterruptedException {
        EventLoop eventLoopCurrentOrNull$kotlinx_coroutines_core;
        d dVarNewCoroutineContext;
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = (c) dVar.get(c.E);
        if (cVar == null) {
            eventLoopCurrentOrNull$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            dVarNewCoroutineContext = CoroutineContextKt.newCoroutineContext(GlobalScope.INSTANCE, dVar.plus(eventLoopCurrentOrNull$kotlinx_coroutines_core));
        } else {
            EventLoop eventLoop = cVar instanceof EventLoop ? (EventLoop) cVar : null;
            if (eventLoop == null) {
                eventLoopCurrentOrNull$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
            } else {
                EventLoop eventLoop2 = eventLoop.shouldBeProcessedFromContext() ? eventLoop : null;
                if (eventLoop2 == null) {
                    eventLoopCurrentOrNull$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
                } else {
                    eventLoopCurrentOrNull$kotlinx_coroutines_core = eventLoop2;
                }
            }
            dVarNewCoroutineContext = CoroutineContextKt.newCoroutineContext(GlobalScope.INSTANCE, dVar);
        }
        BlockingCoroutine blockingCoroutine = new BlockingCoroutine(dVarNewCoroutineContext, threadCurrentThread, eventLoopCurrentOrNull$kotlinx_coroutines_core);
        blockingCoroutine.start(CoroutineStart.DEFAULT, blockingCoroutine, or0Var);
        return (T) blockingCoroutine.joinBlocking();
    }

    public static /* synthetic */ Object runBlocking$default(d dVar, or0 or0Var, int i, Object obj) throws InterruptedException {
        if ((i & 1) != 0) {
            dVar = EmptyCoroutineContext.INSTANCE;
        }
        return BuildersKt.runBlocking(dVar, or0Var);
    }
}
