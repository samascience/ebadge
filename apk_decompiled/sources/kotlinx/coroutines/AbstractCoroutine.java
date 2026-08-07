package kotlinx.coroutines;

import com.fasterxml.jackson.core.JsonFactory;
import defpackage.or0;
import defpackage.x30;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
@InternalCoroutinesApi
public abstract class AbstractCoroutine<T> extends JobSupport implements Job, x30, CoroutineScope {
    private final d context;

    public AbstractCoroutine(d dVar, boolean z, boolean z2) {
        super(z2);
        if (z) {
            initParentJob((Job) dVar.get(Job.Key));
        }
        this.context = dVar.plus(this);
    }

    public static /* synthetic */ void getContext$annotations() {
    }

    protected void afterResume(Object obj) {
        afterCompletion(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public String cancellationExceptionMessage() {
        return DebugStringsKt.getClassSimpleName(this) + " was cancelled";
    }

    @Override // defpackage.x30
    public final d getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public d getCoroutineContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void handleOnCompletionException$kotlinx_coroutines_core(Throwable th) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.context, th);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.JobSupport
    public String nameString$kotlinx_coroutines_core() {
        String coroutineName = CoroutineContextKt.getCoroutineName(this.context);
        if (coroutineName == null) {
            return super.nameString$kotlinx_coroutines_core();
        }
        return JsonFactory.DEFAULT_QUOTE_CHAR + coroutineName + "\":" + super.nameString$kotlinx_coroutines_core();
    }

    protected void onCancelled(Throwable th, boolean z) {
    }

    protected void onCompleted(T t) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    protected final void onCompletionInternal(Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            onCompleted(obj);
        } else {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            onCancelled(completedExceptionally.cause, completedExceptionally.getHandled());
        }
    }

    @Override // defpackage.x30
    public final void resumeWith(Object obj) {
        Object objMakeCompletingOnce$kotlinx_coroutines_core = makeCompletingOnce$kotlinx_coroutines_core(CompletionStateKt.toState$default(obj, null, 1, null));
        if (objMakeCompletingOnce$kotlinx_coroutines_core == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return;
        }
        afterResume(objMakeCompletingOnce$kotlinx_coroutines_core);
    }

    public final <R> void start(CoroutineStart coroutineStart, R r, or0 or0Var) {
        coroutineStart.invoke(or0Var, r, this);
    }
}
