package kotlinx.coroutines;

import defpackage.k83;

/* JADX INFO: loaded from: classes4.dex */
final class ResumeUndispatchedRunnable implements Runnable {
    private final CancellableContinuation<k83> continuation;
    private final CoroutineDispatcher dispatcher;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeUndispatchedRunnable(CoroutineDispatcher coroutineDispatcher, CancellableContinuation<? super k83> cancellableContinuation) {
        this.dispatcher = coroutineDispatcher;
        this.continuation = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.continuation.resumeUndispatched(this.dispatcher, k83.a);
    }
}
