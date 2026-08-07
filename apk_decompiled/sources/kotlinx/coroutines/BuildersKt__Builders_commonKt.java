package kotlinx.coroutines;

import defpackage.j21;
import defpackage.j70;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BuildersKt__Builders_commonKt {
    private static final int RESUMED = 2;
    private static final int SUSPENDED = 1;
    private static final int UNDECIDED = 0;

    public static final <T> Deferred<T> async(CoroutineScope coroutineScope, d dVar, CoroutineStart coroutineStart, or0 or0Var) {
        d dVarNewCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, dVar);
        DeferredCoroutine lazyDeferredCoroutine = coroutineStart.isLazy() ? new LazyDeferredCoroutine(dVarNewCoroutineContext, or0Var) : new DeferredCoroutine(dVarNewCoroutineContext, true);
        ((AbstractCoroutine) lazyDeferredCoroutine).start(coroutineStart, lazyDeferredCoroutine, or0Var);
        return (Deferred<T>) lazyDeferredCoroutine;
    }

    public static /* synthetic */ Deferred async$default(CoroutineScope coroutineScope, d dVar, CoroutineStart coroutineStart, or0 or0Var, int i, Object obj) {
        if ((i & 1) != 0) {
            dVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.async(coroutineScope, dVar, coroutineStart, or0Var);
    }

    public static final <T> Object invoke(CoroutineDispatcher coroutineDispatcher, or0 or0Var, x30 x30Var) {
        return BuildersKt.withContext(coroutineDispatcher, or0Var, x30Var);
    }

    private static final <T> Object invoke$$forInline(CoroutineDispatcher coroutineDispatcher, or0 or0Var, x30 x30Var) throws Throwable {
        j21.c(0);
        Object objWithContext = BuildersKt.withContext(coroutineDispatcher, or0Var, x30Var);
        j21.c(1);
        return objWithContext;
    }

    public static final Job launch(CoroutineScope coroutineScope, d dVar, CoroutineStart coroutineStart, or0 or0Var) {
        d dVarNewCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, dVar);
        AbstractCoroutine lazyStandaloneCoroutine = coroutineStart.isLazy() ? new LazyStandaloneCoroutine(dVarNewCoroutineContext, or0Var) : new StandaloneCoroutine(dVarNewCoroutineContext, true);
        lazyStandaloneCoroutine.start(coroutineStart, lazyStandaloneCoroutine, or0Var);
        return lazyStandaloneCoroutine;
    }

    public static /* synthetic */ Job launch$default(CoroutineScope coroutineScope, d dVar, CoroutineStart coroutineStart, or0 or0Var, int i, Object obj) {
        if ((i & 1) != 0) {
            dVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.launch(coroutineScope, dVar, coroutineStart, or0Var);
    }

    public static final <T> Object withContext(d dVar, or0 or0Var, x30 x30Var) throws Throwable {
        Object result$kotlinx_coroutines_core;
        d context = x30Var.getContext();
        d dVarNewCoroutineContext = CoroutineContextKt.newCoroutineContext(context, dVar);
        JobKt.ensureActive(dVarNewCoroutineContext);
        if (dVarNewCoroutineContext == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(dVarNewCoroutineContext, x30Var);
            result$kotlinx_coroutines_core = UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, or0Var);
        } else {
            c.b bVar = c.E;
            if (p31.a(dVarNewCoroutineContext.get(bVar), context.get(bVar))) {
                UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(dVarNewCoroutineContext, x30Var);
                d context2 = undispatchedCoroutine.getContext();
                Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context2, null);
                try {
                    Object objStartUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(undispatchedCoroutine, undispatchedCoroutine, or0Var);
                    ThreadContextKt.restoreThreadContext(context2, objUpdateThreadContext);
                    result$kotlinx_coroutines_core = objStartUndispatchedOrReturn;
                } catch (Throwable th) {
                    ThreadContextKt.restoreThreadContext(context2, objUpdateThreadContext);
                    throw th;
                }
            } else {
                DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(dVarNewCoroutineContext, x30Var);
                CancellableKt.startCoroutineCancellable$default(or0Var, dispatchedCoroutine, dispatchedCoroutine, null, 4, null);
                result$kotlinx_coroutines_core = dispatchedCoroutine.getResult$kotlinx_coroutines_core();
            }
        }
        if (result$kotlinx_coroutines_core == kotlin.coroutines.intrinsics.a.d()) {
            j70.c(x30Var);
        }
        return result$kotlinx_coroutines_core;
    }
}
