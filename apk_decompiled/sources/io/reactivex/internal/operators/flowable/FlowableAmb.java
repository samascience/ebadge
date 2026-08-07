package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import defpackage.dw2;
import defpackage.i92;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableAmb<T> extends Flowable<T> {
    final i92[] sources;
    final Iterable<? extends i92> sourcesIterable;

    static final class AmbCoordinator<T> implements dw2 {
        final cw2 downstream;
        final AmbInnerSubscriber<T>[] subscribers;
        final AtomicInteger winner = new AtomicInteger();

        AmbCoordinator(cw2 cw2Var, int i) {
            this.downstream = cw2Var;
            this.subscribers = new AmbInnerSubscriber[i];
        }

        @Override // defpackage.dw2
        public void cancel() {
            if (this.winner.get() != -1) {
                this.winner.lazySet(-1);
                for (AmbInnerSubscriber<T> ambInnerSubscriber : this.subscribers) {
                    ambInnerSubscriber.cancel();
                }
            }
        }

        @Override // defpackage.dw2
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                int i = this.winner.get();
                if (i > 0) {
                    this.subscribers[i - 1].request(j);
                    return;
                }
                if (i == 0) {
                    for (AmbInnerSubscriber<T> ambInnerSubscriber : this.subscribers) {
                        ambInnerSubscriber.request(j);
                    }
                }
            }
        }

        public void subscribe(i92[] i92VarArr) {
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.subscribers;
            int length = ambInnerSubscriberArr.length;
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                ambInnerSubscriberArr[i] = new AmbInnerSubscriber<>(this, i2, this.downstream);
                i = i2;
            }
            this.winner.lazySet(0);
            this.downstream.onSubscribe(this);
            for (int i3 = 0; i3 < length && this.winner.get() == 0; i3++) {
                i92VarArr[i3].subscribe(ambInnerSubscriberArr[i3]);
            }
        }

        public boolean win(int i) {
            int i2 = 0;
            if (this.winner.get() != 0 || !this.winner.compareAndSet(0, i)) {
                return false;
            }
            AmbInnerSubscriber<T>[] ambInnerSubscriberArr = this.subscribers;
            int length = ambInnerSubscriberArr.length;
            while (i2 < length) {
                int i3 = i2 + 1;
                if (i3 != i) {
                    ambInnerSubscriberArr[i2].cancel();
                }
                i2 = i3;
            }
            return true;
        }
    }

    static final class AmbInnerSubscriber<T> extends AtomicReference<dw2> implements FlowableSubscriber<T>, dw2 {
        private static final long serialVersionUID = -1185974347409665484L;
        final cw2 downstream;
        final int index;
        final AtomicLong missedRequested = new AtomicLong();
        final AmbCoordinator<T> parent;
        boolean won;

        AmbInnerSubscriber(AmbCoordinator<T> ambCoordinator, int i, cw2 cw2Var) {
            this.parent = ambCoordinator;
            this.index = i;
            this.downstream = cw2Var;
        }

        @Override // defpackage.dw2
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else if (!this.parent.win(this.index)) {
                get().cancel();
            } else {
                this.won = true;
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onError(Throwable th) {
            if (this.won) {
                this.downstream.onError(th);
            } else if (this.parent.win(this.index)) {
                this.won = true;
                this.downstream.onError(th);
            } else {
                get().cancel();
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onNext(T t) {
            if (this.won) {
                this.downstream.onNext(t);
            } else if (!this.parent.win(this.index)) {
                get().cancel();
            } else {
                this.won = true;
                this.downstream.onNext(t);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onSubscribe(dw2 dw2Var) {
            SubscriptionHelper.deferredSetOnce(this, this.missedRequested, dw2Var);
        }

        @Override // defpackage.dw2
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.missedRequested, j);
        }
    }

    public FlowableAmb(i92[] i92VarArr, Iterable<? extends i92> iterable) {
        this.sources = i92VarArr;
        this.sourcesIterable = iterable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(cw2 cw2Var) {
        int length;
        i92[] i92VarArr = this.sources;
        if (i92VarArr == null) {
            i92VarArr = new i92[8];
            try {
                length = 0;
                for (i92 i92Var : this.sourcesIterable) {
                    if (i92Var == null) {
                        EmptySubscription.error(new NullPointerException("One of the sources is null"), cw2Var);
                        return;
                    }
                    if (length == i92VarArr.length) {
                        i92[] i92VarArr2 = new i92[(length >> 2) + length];
                        System.arraycopy(i92VarArr, 0, i92VarArr2, 0, length);
                        i92VarArr = i92VarArr2;
                    }
                    int i = length + 1;
                    i92VarArr[length] = i92Var;
                    length = i;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, cw2Var);
                return;
            }
        } else {
            length = i92VarArr.length;
        }
        if (length == 0) {
            EmptySubscription.complete(cw2Var);
        } else if (length == 1) {
            i92VarArr[0].subscribe(cw2Var);
        } else {
            new AmbCoordinator(cw2Var, length).subscribe(i92VarArr);
        }
    }
}
