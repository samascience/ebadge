package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import defpackage.dw2;
import defpackage.i92;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableDelaySubscriptionOther<T, U> extends Flowable<T> {
    final i92 main;
    final i92 other;

    static final class MainSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, dw2 {
        private static final long serialVersionUID = 2259811067697317255L;
        final cw2 downstream;
        final i92 main;
        final MainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
        final AtomicReference<dw2> upstream = new AtomicReference<>();

        final class OtherSubscriber extends AtomicReference<dw2> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -3892798459447644106L;

            OtherSubscriber() {
            }

            @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
            public void onComplete() {
                if (get() != SubscriptionHelper.CANCELLED) {
                    MainSubscriber.this.next();
                }
            }

            @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
            public void onError(Throwable th) {
                if (get() != SubscriptionHelper.CANCELLED) {
                    MainSubscriber.this.downstream.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }

            @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
            public void onNext(Object obj) {
                dw2 dw2Var = get();
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (dw2Var != subscriptionHelper) {
                    lazySet(subscriptionHelper);
                    dw2Var.cancel();
                    MainSubscriber.this.next();
                }
            }

            @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
            public void onSubscribe(dw2 dw2Var) {
                if (SubscriptionHelper.setOnce(this, dw2Var)) {
                    dw2Var.request(Long.MAX_VALUE);
                }
            }
        }

        MainSubscriber(cw2 cw2Var, i92 i92Var) {
            this.downstream = cw2Var;
            this.main = i92Var;
        }

        @Override // defpackage.dw2
        public void cancel() {
            SubscriptionHelper.cancel(this.other);
            SubscriptionHelper.cancel(this.upstream);
        }

        void next() {
            this.main.subscribe(this);
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onSubscribe(dw2 dw2Var) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this, dw2Var);
        }

        @Override // defpackage.dw2
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                SubscriptionHelper.deferredRequest(this.upstream, this, j);
            }
        }
    }

    public FlowableDelaySubscriptionOther(i92 i92Var, i92 i92Var2) {
        this.main = i92Var;
        this.other = i92Var2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(cw2 cw2Var) {
        MainSubscriber mainSubscriber = new MainSubscriber(cw2Var, this.main);
        cw2Var.onSubscribe(mainSubscriber);
        this.other.subscribe(mainSubscriber.other);
    }
}
