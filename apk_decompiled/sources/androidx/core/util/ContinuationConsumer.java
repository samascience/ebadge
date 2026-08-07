package androidx.core.util;

import defpackage.x30;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import kotlin.Result;

/* JADX INFO: loaded from: classes.dex */
final class ContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {
    private final x30 continuation;

    public ContinuationConsumer(x30 x30Var) {
        super(false);
        this.continuation = x30Var;
    }

    @Override // java.util.function.Consumer
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
