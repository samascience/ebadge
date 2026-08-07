package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import io.reactivex.Flowable;
import io.reactivex.internal.subscriptions.EmptySubscription;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableNever extends Flowable<Object> {
    public static final Flowable<Object> INSTANCE = new FlowableNever();

    private FlowableNever() {
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(cw2 cw2Var) {
        cw2Var.onSubscribe(EmptySubscription.INSTANCE);
    }
}
