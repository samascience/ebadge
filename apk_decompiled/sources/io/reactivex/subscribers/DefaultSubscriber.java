package io.reactivex.subscribers;

import defpackage.dw2;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {
    dw2 upstream;

    protected final void cancel() {
        dw2 dw2Var = this.upstream;
        this.upstream = SubscriptionHelper.CANCELLED;
        dw2Var.cancel();
    }

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    public abstract /* synthetic */ void onComplete();

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    public abstract /* synthetic */ void onError(Throwable th);

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    public abstract /* synthetic */ void onNext(Object obj);

    protected void onStart() {
        request(Long.MAX_VALUE);
    }

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    public final void onSubscribe(dw2 dw2Var) {
        if (EndConsumerHelper.validate(this.upstream, dw2Var, getClass())) {
            this.upstream = dw2Var;
            onStart();
        }
    }

    protected final void request(long j) {
        dw2 dw2Var = this.upstream;
        if (dw2Var != null) {
            dw2Var.request(j);
        }
    }
}
