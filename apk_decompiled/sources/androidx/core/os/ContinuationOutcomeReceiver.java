package androidx.core.os;

import android.os.OutcomeReceiver;
import defpackage.x30;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.d;

/* JADX INFO: loaded from: classes.dex */
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver {
    private final x30 continuation;

    public ContinuationOutcomeReceiver(x30 x30Var) {
        super(false);
        this.continuation = x30Var;
    }

    public void onError(E e) {
        if (compareAndSet(false, true)) {
            x30 x30Var = this.continuation;
            Result.a aVar = Result.Companion;
            x30Var.resumeWith(Result.m69constructorimpl(d.a(e)));
        }
    }

    public void onResult(R r) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(Result.m69constructorimpl(r));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
