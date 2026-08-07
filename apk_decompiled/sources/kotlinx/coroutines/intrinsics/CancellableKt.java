package kotlinx.coroutines.intrinsics;

import defpackage.ar0;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import defpackage.yq0;
import kotlin.Result;
import kotlin.coroutines.intrinsics.a;
import kotlin.d;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

/* JADX INFO: loaded from: classes4.dex */
public final class CancellableKt {
    private static final void dispatcherFailure(x30 x30Var, Throwable th) throws Throwable {
        Result.a aVar = Result.Companion;
        x30Var.resumeWith(Result.m69constructorimpl(d.a(th)));
        throw th;
    }

    private static final void runSafely(x30 x30Var, yq0 yq0Var) throws Throwable {
        try {
            yq0Var.invoke();
        } catch (Throwable th) {
            dispatcherFailure(x30Var, th);
        }
    }

    @InternalCoroutinesApi
    public static final <T> void startCoroutineCancellable(ar0 ar0Var, x30 x30Var) throws Throwable {
        try {
            x30 x30VarC = a.c(a.a(ar0Var, x30Var));
            Result.a aVar = Result.Companion;
            DispatchedContinuationKt.resumeCancellableWith$default(x30VarC, Result.m69constructorimpl(k83.a), null, 2, null);
        } catch (Throwable th) {
            dispatcherFailure(x30Var, th);
        }
    }

    public static /* synthetic */ void startCoroutineCancellable$default(or0 or0Var, Object obj, x30 x30Var, ar0 ar0Var, int i, Object obj2) throws Throwable {
        if ((i & 4) != 0) {
            ar0Var = null;
        }
        startCoroutineCancellable(or0Var, obj, x30Var, ar0Var);
    }

    public static final <R, T> void startCoroutineCancellable(or0 or0Var, R r, x30 x30Var, ar0 ar0Var) throws Throwable {
        try {
            x30 x30VarC = a.c(a.b(or0Var, r, x30Var));
            Result.a aVar = Result.Companion;
            DispatchedContinuationKt.resumeCancellableWith(x30VarC, Result.m69constructorimpl(k83.a), ar0Var);
        } catch (Throwable th) {
            dispatcherFailure(x30Var, th);
        }
    }

    public static final void startCoroutineCancellable(x30 x30Var, x30 x30Var2) throws Throwable {
        try {
            x30 x30VarC = a.c(x30Var);
            Result.a aVar = Result.Companion;
            DispatchedContinuationKt.resumeCancellableWith$default(x30VarC, Result.m69constructorimpl(k83.a), null, 2, null);
        } catch (Throwable th) {
            dispatcherFailure(x30Var2, th);
        }
    }
}
