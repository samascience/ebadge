package kotlin.coroutines.jvm.internal;

import defpackage.x30;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(x30 x30Var) {
        super(x30Var);
        if (x30Var != null && x30Var.getContext() != EmptyCoroutineContext.INSTANCE) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, defpackage.x30
    public d getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
