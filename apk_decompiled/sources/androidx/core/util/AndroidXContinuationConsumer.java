package androidx.core.util;

import defpackage.q20;
import defpackage.x30;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;

/* JADX INFO: loaded from: classes.dex */
final class AndroidXContinuationConsumer<T> extends AtomicBoolean implements q20 {
    private final x30 continuation;

    public AndroidXContinuationConsumer(x30 x30Var) {
        super(false);
        this.continuation = x30Var;
    }

    @Override // defpackage.q20
    public void accept(T t) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(Result.m69constructorimpl(t));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
