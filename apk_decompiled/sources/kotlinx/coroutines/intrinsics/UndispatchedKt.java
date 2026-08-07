package kotlinx.coroutines.intrinsics;

import defpackage.ar0;
import defpackage.j70;
import defpackage.or0;
import defpackage.p63;
import defpackage.x30;
import defpackage.yq0;
import kotlin.Result;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.a;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes4.dex */
public final class UndispatchedKt {
    public static final <T> void startCoroutineUndispatched(ar0 ar0Var, x30 x30Var) {
        x30 x30VarA = j70.a(x30Var);
        try {
            d context = x30Var.getContext();
            Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            try {
                Object objInvoke = ((ar0) p63.a(ar0Var, 1)).invoke(x30VarA);
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
                if (objInvoke != a.d()) {
                    x30VarA.resumeWith(Result.m69constructorimpl(objInvoke));
                }
            } catch (Throwable th) {
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
                throw th;
            }
        } catch (Throwable th2) {
            Result.a aVar = Result.Companion;
            x30VarA.resumeWith(Result.m69constructorimpl(kotlin.d.a(th2)));
        }
    }

    public static final <T> void startCoroutineUnintercepted(ar0 ar0Var, x30 x30Var) {
        x30 x30VarA = j70.a(x30Var);
        try {
            Object objInvoke = ((ar0) p63.a(ar0Var, 1)).invoke(x30VarA);
            if (objInvoke != a.d()) {
                x30VarA.resumeWith(Result.m69constructorimpl(objInvoke));
            }
        } catch (Throwable th) {
            Result.a aVar = Result.Companion;
            x30VarA.resumeWith(Result.m69constructorimpl(kotlin.d.a(th)));
        }
    }

    private static final <T> void startDirect(x30 x30Var, ar0 ar0Var) {
        x30 x30VarA = j70.a(x30Var);
        try {
            Object objInvoke = ar0Var.invoke(x30VarA);
            if (objInvoke != a.d()) {
                x30VarA.resumeWith(Result.m69constructorimpl(objInvoke));
            }
        } catch (Throwable th) {
            Result.a aVar = Result.Companion;
            x30VarA.resumeWith(Result.m69constructorimpl(kotlin.d.a(th)));
        }
    }

    public static final <T, R> Object startUndispatchedOrReturn(ScopeCoroutine<? super T> scopeCoroutine, R r, or0 or0Var) {
        Object completedExceptionally;
        Object objMakeCompletingOnce$kotlinx_coroutines_core;
        try {
            completedExceptionally = ((or0) p63.a(or0Var, 2)).invoke(r, scopeCoroutine);
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        }
        if (completedExceptionally != a.d() && (objMakeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally)) != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            if (objMakeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                throw ((CompletedExceptionally) objMakeCompletingOnce$kotlinx_coroutines_core).cause;
            }
            return JobSupportKt.unboxState(objMakeCompletingOnce$kotlinx_coroutines_core);
        }
        return a.d();
    }

    public static final <T, R> Object startUndispatchedOrReturnIgnoreTimeout(ScopeCoroutine<? super T> scopeCoroutine, R r, or0 or0Var) throws Throwable {
        Object completedExceptionally;
        Object objMakeCompletingOnce$kotlinx_coroutines_core;
        try {
            completedExceptionally = ((or0) p63.a(or0Var, 2)).invoke(r, scopeCoroutine);
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        }
        if (completedExceptionally != a.d() && (objMakeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally)) != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            if (objMakeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                Throwable th2 = ((CompletedExceptionally) objMakeCompletingOnce$kotlinx_coroutines_core).cause;
                if (!(th2 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th2).coroutine != scopeCoroutine) {
                    throw th2;
                }
                if (completedExceptionally instanceof CompletedExceptionally) {
                    throw ((CompletedExceptionally) completedExceptionally).cause;
                }
            } else {
                completedExceptionally = JobSupportKt.unboxState(objMakeCompletingOnce$kotlinx_coroutines_core);
            }
            return completedExceptionally;
        }
        return a.d();
    }

    private static final <T> Object undispatchedResult(ScopeCoroutine<? super T> scopeCoroutine, ar0 ar0Var, yq0 yq0Var) throws Throwable {
        Object completedExceptionally;
        Object objMakeCompletingOnce$kotlinx_coroutines_core;
        try {
            completedExceptionally = yq0Var.invoke();
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        }
        if (completedExceptionally != a.d() && (objMakeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally)) != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            if (!(objMakeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                return JobSupportKt.unboxState(objMakeCompletingOnce$kotlinx_coroutines_core);
            }
            CompletedExceptionally completedExceptionally2 = (CompletedExceptionally) objMakeCompletingOnce$kotlinx_coroutines_core;
            if (((Boolean) ar0Var.invoke(completedExceptionally2.cause)).booleanValue()) {
                throw completedExceptionally2.cause;
            }
            if (completedExceptionally instanceof CompletedExceptionally) {
                throw ((CompletedExceptionally) completedExceptionally).cause;
            }
            return completedExceptionally;
        }
        return a.d();
    }

    public static final <R, T> void startCoroutineUndispatched(or0 or0Var, R r, x30 x30Var) {
        x30 x30VarA = j70.a(x30Var);
        try {
            d context = x30Var.getContext();
            Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            try {
                Object objInvoke = ((or0) p63.a(or0Var, 2)).invoke(r, x30VarA);
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
                if (objInvoke != a.d()) {
                    x30VarA.resumeWith(Result.m69constructorimpl(objInvoke));
                }
            } catch (Throwable th) {
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
                throw th;
            }
        } catch (Throwable th2) {
            Result.a aVar = Result.Companion;
            x30VarA.resumeWith(Result.m69constructorimpl(kotlin.d.a(th2)));
        }
    }
}
