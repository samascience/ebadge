package kotlinx.coroutines.internal;

import defpackage.p40;
import defpackage.x30;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CompletionStateKt;

/* JADX INFO: loaded from: classes4.dex */
public class ScopeCoroutine<T> extends AbstractCoroutine<T> implements p40 {
    public final x30 uCont;

    public ScopeCoroutine(d dVar, x30 x30Var) {
        super(dVar, true, true);
        this.uCont = x30Var;
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void afterCompletion(Object obj) {
        DispatchedContinuationKt.resumeCancellableWith$default(a.c(this.uCont), CompletionStateKt.recoverResult(obj, this.uCont), null, 2, null);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void afterResume(Object obj) {
        x30 x30Var = this.uCont;
        x30Var.resumeWith(CompletionStateKt.recoverResult(obj, x30Var));
    }

    @Override // defpackage.p40
    public final p40 getCallerFrame() {
        x30 x30Var = this.uCont;
        if (x30Var instanceof p40) {
            return (p40) x30Var;
        }
        return null;
    }

    @Override // defpackage.p40
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.JobSupport
    protected final boolean isScopedCoroutine() {
        return true;
    }
}
