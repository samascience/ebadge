package kotlinx.coroutines;

import defpackage.x30;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public final class JobKt {
    public static final CompletableJob Job(Job job) {
        return JobKt__JobKt.Job(job);
    }

    public static final Object cancelAndJoin(Job job, x30 x30Var) {
        return JobKt__JobKt.cancelAndJoin(job, x30Var);
    }

    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        JobKt__FutureKt.cancelFutureOnCancellation(cancellableContinuation, future);
    }

    @InternalCoroutinesApi
    public static final DisposableHandle cancelFutureOnCompletion(Job job, Future<?> future) {
        return JobKt__FutureKt.cancelFutureOnCompletion(job, future);
    }

    public static final DisposableHandle disposeOnCompletion(Job job, DisposableHandle disposableHandle) {
        return JobKt__JobKt.disposeOnCompletion(job, disposableHandle);
    }

    public static final void ensureActive(d dVar) {
        JobKt__JobKt.ensureActive(dVar);
    }

    public static final Job getJob(d dVar) {
        return JobKt__JobKt.getJob(dVar);
    }

    public static final boolean isActive(d dVar) {
        return JobKt__JobKt.isActive(dVar);
    }

    public static final void cancel(d dVar, CancellationException cancellationException) {
        JobKt__JobKt.cancel(dVar, cancellationException);
    }

    public static final void ensureActive(Job job) {
        JobKt__JobKt.ensureActive(job);
    }

    public static final void cancel(Job job, String str, Throwable th) {
        JobKt__JobKt.cancel(job, str, th);
    }

    public static final void cancelChildren(d dVar, CancellationException cancellationException) {
        JobKt__JobKt.cancelChildren(dVar, cancellationException);
    }

    public static final void cancelChildren(Job job, CancellationException cancellationException) {
        JobKt__JobKt.cancelChildren(job, cancellationException);
    }
}
