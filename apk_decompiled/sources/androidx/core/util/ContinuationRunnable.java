package androidx.core.util;

import defpackage.k83;
import defpackage.x30;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;

/* JADX INFO: loaded from: classes.dex */
final class ContinuationRunnable extends AtomicBoolean implements Runnable {
    private final x30 continuation;

    public ContinuationRunnable(x30 x30Var) {
        super(false);
        this.continuation = x30Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (compareAndSet(false, true)) {
            x30 x30Var = this.continuation;
            Result.a aVar = Result.Companion;
            x30Var.resumeWith(Result.m69constructorimpl(k83.a));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
