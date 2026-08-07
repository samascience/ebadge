package kotlinx.coroutines;

import defpackage.j21;
import defpackage.j70;
import defpackage.or0;
import defpackage.x30;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.d;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* JADX INFO: loaded from: classes4.dex */
public final class CoroutineScopeKt {
    public static final CoroutineScope CoroutineScope(d dVar) {
        if (dVar.get(Job.Key) == null) {
            dVar = dVar.plus(JobKt__JobKt.Job$default((Job) null, 1, (Object) null));
        }
        return new ContextScope(dVar);
    }

    public static final CoroutineScope MainScope() {
        return new ContextScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    }

    public static final void cancel(CoroutineScope coroutineScope, CancellationException cancellationException) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.Key);
        if (job != null) {
            job.cancel(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope).toString());
    }

    public static /* synthetic */ void cancel$default(CoroutineScope coroutineScope, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        cancel(coroutineScope, cancellationException);
    }

    public static final <R> Object coroutineScope(or0 or0Var, x30 x30Var) {
        ScopeCoroutine scopeCoroutine = new ScopeCoroutine(x30Var.getContext(), x30Var);
        Object objStartUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, or0Var);
        if (objStartUndispatchedOrReturn == kotlin.coroutines.intrinsics.a.d()) {
            j70.c(x30Var);
        }
        return objStartUndispatchedOrReturn;
    }

    public static final Object currentCoroutineContext(x30 x30Var) {
        return x30Var.getContext();
    }

    private static final Object currentCoroutineContext$$forInline(x30 x30Var) {
        j21.c(3);
        throw null;
    }

    public static final void ensureActive(CoroutineScope coroutineScope) {
        JobKt.ensureActive(coroutineScope.getCoroutineContext());
    }

    public static final boolean isActive(CoroutineScope coroutineScope) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.Key);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    public static /* synthetic */ void isActive$annotations(CoroutineScope coroutineScope) {
    }

    public static final CoroutineScope plus(CoroutineScope coroutineScope, d dVar) {
        return new ContextScope(coroutineScope.getCoroutineContext().plus(dVar));
    }

    public static /* synthetic */ void cancel$default(CoroutineScope coroutineScope, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        cancel(coroutineScope, str, th);
    }

    public static final void cancel(CoroutineScope coroutineScope, String str, Throwable th) {
        cancel(coroutineScope, ExceptionsKt.CancellationException(str, th));
    }
}
