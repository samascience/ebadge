package kotlinx.coroutines;

import defpackage.x30;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes4.dex */
public final class CancelledContinuation extends CompletedExceptionally {
    private static final AtomicIntegerFieldUpdater _resumed$FU = AtomicIntegerFieldUpdater.newUpdater(CancelledContinuation.class, "_resumed");
    private volatile int _resumed;

    public CancelledContinuation(x30 x30Var, Throwable th, boolean z) {
        if (th == null) {
            th = new CancellationException("Continuation " + x30Var + " was cancelled normally");
        }
        super(th, z);
        this._resumed = 0;
    }

    public final boolean makeResumed() {
        return _resumed$FU.compareAndSet(this, 0, 1);
    }
}
