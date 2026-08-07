package io.reactivex.internal.subscriptions;

import defpackage.cw2;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.QueueSubscription;

/* JADX INFO: loaded from: classes4.dex */
public enum EmptySubscription implements QueueSubscription<Object> {
    INSTANCE;

    public static void complete(cw2 cw2Var) {
        cw2Var.onSubscribe(INSTANCE);
        cw2Var.onComplete();
    }

    public static void error(Throwable th, cw2 cw2Var) {
        cw2Var.onSubscribe(INSTANCE);
        cw2Var.onError(th);
    }

    @Override // io.reactivex.internal.fuseable.QueueSubscription, defpackage.dw2
    public void cancel() {
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public Object poll() {
        return null;
    }

    @Override // io.reactivex.internal.fuseable.QueueSubscription, defpackage.dw2
    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int i) {
        return i & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
