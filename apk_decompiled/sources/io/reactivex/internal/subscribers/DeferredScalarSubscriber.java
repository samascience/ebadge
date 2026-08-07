package io.reactivex.internal.subscribers;

import defpackage.cw2;
import defpackage.dw2;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    protected boolean hasValue;
    protected dw2 upstream;

    public DeferredScalarSubscriber(cw2 cw2Var) {
        super(cw2Var);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, io.reactivex.internal.fuseable.QueueSubscription, defpackage.dw2
    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th) {
        this.value = null;
        this.downstream.onError(th);
    }

    public abstract /* synthetic */ void onNext(Object obj);

    public void onSubscribe(dw2 dw2Var) {
        if (SubscriptionHelper.validate(this.upstream, dw2Var)) {
            this.upstream = dw2Var;
            this.downstream.onSubscribe(this);
            dw2Var.request(Long.MAX_VALUE);
        }
    }
}
