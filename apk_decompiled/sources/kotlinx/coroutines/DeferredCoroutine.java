package kotlinx.coroutines;

import defpackage.p31;
import defpackage.x30;
import kotlin.coroutines.d;
import kotlinx.coroutines.selects.SelectClause1;

/* JADX INFO: loaded from: classes4.dex */
class DeferredCoroutine<T> extends AbstractCoroutine<T> implements Deferred<T> {
    public DeferredCoroutine(d dVar, boolean z) {
        super(dVar, true, z);
    }

    static /* synthetic */ <T> Object await$suspendImpl(DeferredCoroutine<T> deferredCoroutine, x30 x30Var) throws Throwable {
        Object objAwaitInternal = deferredCoroutine.awaitInternal(x30Var);
        kotlin.coroutines.intrinsics.a.d();
        return objAwaitInternal;
    }

    @Override // kotlinx.coroutines.Deferred
    public Object await(x30 x30Var) {
        return await$suspendImpl(this, x30Var);
    }

    @Override // kotlinx.coroutines.Deferred
    public T getCompleted() {
        return (T) getCompletedInternal$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.Deferred
    public SelectClause1<T> getOnAwait() {
        SelectClause1<T> selectClause1 = (SelectClause1<T>) getOnAwaitInternal();
        p31.d(selectClause1, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.DeferredCoroutine>");
        return selectClause1;
    }
}
