package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import defpackage.dw2;
import defpackage.i92;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableRetryWhen<T> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super Flowable<Throwable>, ? extends i92> handler;

    static final class RetryWhenSubscriber<T> extends FlowableRepeatWhen.WhenSourceSubscriber<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        RetryWhenSubscriber(cw2 cw2Var, FlowableProcessor<Throwable> flowableProcessor, dw2 dw2Var) {
            super(cw2Var, flowableProcessor, dw2Var);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRepeatWhen.WhenSourceSubscriber, io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onComplete() {
            this.receiver.cancel();
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRepeatWhen.WhenSourceSubscriber, io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onError(Throwable th) {
            again(th);
        }
    }

    public FlowableRetryWhen(Flowable<T> flowable, Function<? super Flowable<Throwable>, ? extends i92> function) {
        super(flowable);
        this.handler = function;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(cw2 cw2Var) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(cw2Var);
        FlowableProcessor<T> serialized = UnicastProcessor.create(8).toSerialized();
        try {
            i92 i92Var = (i92) ObjectHelper.requireNonNull(this.handler.apply(serialized), "handler returned a null Publisher");
            FlowableRepeatWhen.WhenReceiver whenReceiver = new FlowableRepeatWhen.WhenReceiver(this.source);
            RetryWhenSubscriber retryWhenSubscriber = new RetryWhenSubscriber(serializedSubscriber, serialized, whenReceiver);
            whenReceiver.subscriber = retryWhenSubscriber;
            cw2Var.onSubscribe(retryWhenSubscriber);
            i92Var.subscribe(whenReceiver);
            whenReceiver.onNext(0);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, cw2Var);
        }
    }
}
