package kotlinx.coroutines;

import defpackage.k83;
import defpackage.oi0;
import defpackage.p31;
import defpackage.x30;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.d;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DispatchedTask<T> extends Task {
    public int resumeMode;

    public DispatchedTask(int i) {
        this.resumeMode = i;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th) {
    }

    public abstract x30 getDelegate$kotlinx_coroutines_core();

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }

    public final void handleFatalException$kotlinx_coroutines_core(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            oi0.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        p31.c(th);
        CoroutineExceptionHandlerKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objM69constructorimpl;
        Object objM69constructorimpl2;
        TaskContext taskContext = this.taskContext;
        try {
            x30 delegate$kotlinx_coroutines_core = getDelegate$kotlinx_coroutines_core();
            p31.d(delegate$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate$kotlinx_coroutines_core;
            x30 x30Var = dispatchedContinuation.continuation;
            Object obj = dispatchedContinuation.countOrElement;
            d context = x30Var.getContext();
            Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context, obj);
            UndispatchedCoroutine<?> undispatchedCoroutineUpdateUndispatchedCompletion = objUpdateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(x30Var, context, objUpdateThreadContext) : null;
            try {
                d context2 = x30Var.getContext();
                Object objTakeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
                Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
                Job job = (exceptionalResult$kotlinx_coroutines_core == null && DispatchedTaskKt.isCancellableMode(this.resumeMode)) ? (Job) context2.get(Job.Key) : null;
                if (job != null && !job.isActive()) {
                    CancellationException cancellationException = job.getCancellationException();
                    cancelCompletedResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core, cancellationException);
                    Result.a aVar = Result.Companion;
                    x30Var.resumeWith(Result.m69constructorimpl(kotlin.d.a(cancellationException)));
                } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                    Result.a aVar2 = Result.Companion;
                    x30Var.resumeWith(Result.m69constructorimpl(kotlin.d.a(exceptionalResult$kotlinx_coroutines_core)));
                } else {
                    Result.a aVar3 = Result.Companion;
                    x30Var.resumeWith(Result.m69constructorimpl(getSuccessfulResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core)));
                }
                k83 k83Var = k83.a;
                if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
                }
                try {
                    taskContext.afterTask();
                    objM69constructorimpl2 = Result.m69constructorimpl(k83.a);
                } catch (Throwable th) {
                    Result.a aVar4 = Result.Companion;
                    objM69constructorimpl2 = Result.m69constructorimpl(kotlin.d.a(th));
                }
                handleFatalException$kotlinx_coroutines_core(null, Result.m72exceptionOrNullimpl(objM69constructorimpl2));
            } catch (Throwable th2) {
                if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                Result.a aVar5 = Result.Companion;
                taskContext.afterTask();
                objM69constructorimpl = Result.m69constructorimpl(k83.a);
            } catch (Throwable th4) {
                Result.a aVar6 = Result.Companion;
                objM69constructorimpl = Result.m69constructorimpl(kotlin.d.a(th4));
            }
            handleFatalException$kotlinx_coroutines_core(th3, Result.m72exceptionOrNullimpl(objM69constructorimpl));
        }
    }

    public abstract Object takeState$kotlinx_coroutines_core();
}
