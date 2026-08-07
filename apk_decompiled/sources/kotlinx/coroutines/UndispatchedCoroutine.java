package kotlinx.coroutines;

import defpackage.d63;
import defpackage.k83;
import defpackage.x30;
import kotlin.Pair;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes4.dex */
public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {
    private volatile boolean threadLocalIsSet;
    private final ThreadLocal<Pair<d, Object>> threadStateToRecover;

    /* JADX WARN: Illegal instructions before constructor call */
    public UndispatchedCoroutine(d dVar, x30 x30Var) {
        UndispatchedMarker undispatchedMarker = UndispatchedMarker.INSTANCE;
        super(dVar.get(undispatchedMarker) == null ? dVar.plus(undispatchedMarker) : dVar, x30Var);
        this.threadStateToRecover = new ThreadLocal<>();
        if (x30Var.getContext().get(c.E) instanceof CoroutineDispatcher) {
            return;
        }
        Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(dVar, null);
        ThreadContextKt.restoreThreadContext(dVar, objUpdateThreadContext);
        saveThreadContext(dVar, objUpdateThreadContext);
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.AbstractCoroutine
    protected void afterResume(Object obj) {
        if (this.threadLocalIsSet) {
            Pair<d, Object> pair = this.threadStateToRecover.get();
            if (pair != null) {
                ThreadContextKt.restoreThreadContext(pair.component1(), pair.component2());
            }
            this.threadStateToRecover.remove();
        }
        Object objRecoverResult = CompletionStateKt.recoverResult(obj, this.uCont);
        x30 x30Var = this.uCont;
        d context = x30Var.getContext();
        Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context, null);
        UndispatchedCoroutine<?> undispatchedCoroutineUpdateUndispatchedCompletion = objUpdateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(x30Var, context, objUpdateThreadContext) : null;
        try {
            this.uCont.resumeWith(objRecoverResult);
            k83 k83Var = k83.a;
        } finally {
            if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
            }
        }
    }

    public final boolean clearThreadContext() {
        boolean z = this.threadLocalIsSet && this.threadStateToRecover.get() == null;
        this.threadStateToRecover.remove();
        return !z;
    }

    public final void saveThreadContext(d dVar, Object obj) {
        this.threadLocalIsSet = true;
        this.threadStateToRecover.set(d63.a(dVar, obj));
    }
}
