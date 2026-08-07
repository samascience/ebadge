package kotlinx.coroutines;

import defpackage.ar0;
import defpackage.j21;
import defpackage.j70;
import defpackage.x30;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* JADX INFO: loaded from: classes4.dex */
public final class CancellableContinuationKt {
    @InternalCoroutinesApi
    public static final void disposeOnCancellation(CancellableContinuation<?> cancellableContinuation, DisposableHandle disposableHandle) {
        cancellableContinuation.invokeOnCancellation(new DisposeOnCancel(disposableHandle));
    }

    public static final <T> CancellableContinuationImpl<T> getOrCreateCancellableContinuation(x30 x30Var) {
        if (!(x30Var instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl<>(x30Var, 1);
        }
        CancellableContinuationImpl<T> cancellableContinuationImplClaimReusableCancellableContinuation$kotlinx_coroutines_core = ((DispatchedContinuation) x30Var).claimReusableCancellableContinuation$kotlinx_coroutines_core();
        if (cancellableContinuationImplClaimReusableCancellableContinuation$kotlinx_coroutines_core != null) {
            if (!cancellableContinuationImplClaimReusableCancellableContinuation$kotlinx_coroutines_core.resetStateReusable()) {
                cancellableContinuationImplClaimReusableCancellableContinuation$kotlinx_coroutines_core = null;
            }
            if (cancellableContinuationImplClaimReusableCancellableContinuation$kotlinx_coroutines_core != null) {
                return cancellableContinuationImplClaimReusableCancellableContinuation$kotlinx_coroutines_core;
            }
        }
        return new CancellableContinuationImpl<>(x30Var, 2);
    }

    public static final <T> Object suspendCancellableCoroutine(ar0 ar0Var, x30 x30Var) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.a.c(x30Var), 1);
        cancellableContinuationImpl.initCancellability();
        ar0Var.invoke(cancellableContinuationImpl);
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.d()) {
            j70.c(x30Var);
        }
        return result;
    }

    private static final <T> Object suspendCancellableCoroutine$$forInline(ar0 ar0Var, x30 x30Var) {
        j21.c(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.a.c(x30Var), 1);
        cancellableContinuationImpl.initCancellability();
        ar0Var.invoke(cancellableContinuationImpl);
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.d()) {
            j70.c(x30Var);
        }
        j21.c(1);
        return result;
    }

    public static final <T> Object suspendCancellableCoroutineReusable(ar0 ar0Var, x30 x30Var) {
        CancellableContinuationImpl orCreateCancellableContinuation = getOrCreateCancellableContinuation(kotlin.coroutines.intrinsics.a.c(x30Var));
        try {
            ar0Var.invoke(orCreateCancellableContinuation);
            Object result = orCreateCancellableContinuation.getResult();
            if (result == kotlin.coroutines.intrinsics.a.d()) {
                j70.c(x30Var);
            }
            return result;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    private static final <T> Object suspendCancellableCoroutineReusable$$forInline(ar0 ar0Var, x30 x30Var) {
        j21.c(0);
        CancellableContinuationImpl orCreateCancellableContinuation = getOrCreateCancellableContinuation(kotlin.coroutines.intrinsics.a.c(x30Var));
        try {
            ar0Var.invoke(orCreateCancellableContinuation);
            Object result = orCreateCancellableContinuation.getResult();
            if (result == kotlin.coroutines.intrinsics.a.d()) {
                j70.c(x30Var);
            }
            j21.c(1);
            return result;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }
}
