package kotlinx.coroutines.selects;

import defpackage.ar0;
import defpackage.j21;
import defpackage.j70;
import defpackage.x30;
import kotlin.Result;
import kotlin.coroutines.intrinsics.a;
import kotlin.d;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes4.dex */
public final class SelectOldKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void resumeUndispatched(CancellableContinuation<? super T> cancellableContinuation, T t) {
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) cancellableContinuation.getContext().get(CoroutineDispatcher.Key);
        if (coroutineDispatcher != null) {
            cancellableContinuation.resumeUndispatched(coroutineDispatcher, t);
        } else {
            cancellableContinuation.resumeWith(Result.m69constructorimpl(t));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resumeUndispatchedWithException(CancellableContinuation<?> cancellableContinuation, Throwable th) {
        CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) cancellableContinuation.getContext().get(CoroutineDispatcher.Key);
        if (coroutineDispatcher != null) {
            cancellableContinuation.resumeUndispatchedWithException(coroutineDispatcher, th);
        } else {
            Result.a aVar = Result.Companion;
            cancellableContinuation.resumeWith(Result.m69constructorimpl(d.a(th)));
        }
    }

    public static final <R> Object selectOld(ar0 ar0Var, x30 x30Var) {
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(x30Var);
        try {
            ar0Var.invoke(selectBuilderImpl);
        } catch (Throwable th) {
            selectBuilderImpl.handleBuilderException(th);
        }
        Object result = selectBuilderImpl.getResult();
        if (result == a.d()) {
            j70.c(x30Var);
        }
        return result;
    }

    private static final <R> Object selectOld$$forInline(ar0 ar0Var, x30 x30Var) {
        j21.c(0);
        SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(x30Var);
        try {
            ar0Var.invoke(selectBuilderImpl);
        } catch (Throwable th) {
            selectBuilderImpl.handleBuilderException(th);
        }
        Object result = selectBuilderImpl.getResult();
        if (result == a.d()) {
            j70.c(x30Var);
        }
        j21.c(1);
        return result;
    }

    public static final <R> Object selectUnbiasedOld(ar0 ar0Var, x30 x30Var) {
        UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl(x30Var);
        try {
            ar0Var.invoke(unbiasedSelectBuilderImpl);
        } catch (Throwable th) {
            unbiasedSelectBuilderImpl.handleBuilderException(th);
        }
        Object objInitSelectResult = unbiasedSelectBuilderImpl.initSelectResult();
        if (objInitSelectResult == a.d()) {
            j70.c(x30Var);
        }
        return objInitSelectResult;
    }

    private static final <R> Object selectUnbiasedOld$$forInline(ar0 ar0Var, x30 x30Var) {
        j21.c(0);
        UnbiasedSelectBuilderImpl unbiasedSelectBuilderImpl = new UnbiasedSelectBuilderImpl(x30Var);
        try {
            ar0Var.invoke(unbiasedSelectBuilderImpl);
        } catch (Throwable th) {
            unbiasedSelectBuilderImpl.handleBuilderException(th);
        }
        Object objInitSelectResult = unbiasedSelectBuilderImpl.initSelectResult();
        if (objInitSelectResult == a.d()) {
            j70.c(x30Var);
        }
        j21.c(1);
        return objInitSelectResult;
    }
}
