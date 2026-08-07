package io.reactivex.internal.operators.mixed;

import defpackage.cw2;
import defpackage.dw2;
import defpackage.i92;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletableAndThenPublisher<R> extends Flowable<R> {
    final i92 other;
    final CompletableSource source;

    public CompletableAndThenPublisher(CompletableSource completableSource, i92 i92Var) {
        this.source = completableSource;
        this.other = i92Var;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(cw2 cw2Var) {
        this.source.subscribe(new AndThenPublisherSubscriber(cw2Var, this.other));
    }

    static final class AndThenPublisherSubscriber<R> extends AtomicReference<dw2> implements FlowableSubscriber<R>, CompletableObserver, dw2 {
        private static final long serialVersionUID = -8948264376121066672L;
        final cw2 downstream;
        i92 other;
        final AtomicLong requested = new AtomicLong();
        Disposable upstream;

        AndThenPublisherSubscriber(cw2 cw2Var, i92 i92Var) {
            this.downstream = cw2Var;
            this.other = i92Var;
        }

        @Override // defpackage.dw2
        public void cancel() {
            this.upstream.dispose();
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onComplete() {
            i92 i92Var = this.other;
            if (i92Var == null) {
                this.downstream.onComplete();
            } else {
                this.other = null;
                i92Var.subscribe(this);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.dw2
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.requested, j);
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onSubscribe(dw2 dw2Var) {
            SubscriptionHelper.deferredSetOnce(this, this.requested, dw2Var);
        }
    }
}
