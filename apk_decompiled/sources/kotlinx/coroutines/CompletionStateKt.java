package kotlinx.coroutines;

import defpackage.ar0;
import defpackage.x30;
import kotlin.Result;
import kotlin.d;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletionStateKt {
    public static final <T> Object recoverResult(Object obj, x30 x30Var) {
        if (!(obj instanceof CompletedExceptionally)) {
            return Result.m69constructorimpl(obj);
        }
        Result.a aVar = Result.Companion;
        return Result.m69constructorimpl(d.a(((CompletedExceptionally) obj).cause));
    }

    public static final <T> Object toState(Object obj, ar0 ar0Var) {
        Throwable thM72exceptionOrNullimpl = Result.m72exceptionOrNullimpl(obj);
        if (thM72exceptionOrNullimpl == null) {
            return ar0Var != null ? new CompletedWithCancellation(obj, ar0Var) : obj;
        }
        return new CompletedExceptionally(thM72exceptionOrNullimpl, false, 2, null);
    }

    public static /* synthetic */ Object toState$default(Object obj, ar0 ar0Var, int i, Object obj2) {
        if ((i & 1) != 0) {
            ar0Var = null;
        }
        return toState(obj, ar0Var);
    }

    public static final <T> Object toState(Object obj, CancellableContinuation<?> cancellableContinuation) {
        Throwable thM72exceptionOrNullimpl = Result.m72exceptionOrNullimpl(obj);
        return thM72exceptionOrNullimpl == null ? obj : new CompletedExceptionally(thM72exceptionOrNullimpl, false, 2, null);
    }
}
