package io.reactivex.internal.operators.parallel;

import defpackage.cw2;
import defpackage.dw2;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes4.dex */
public final class ParallelPeek<T> extends ParallelFlowable<T> {
    final Consumer<? super T> onAfterNext;
    final Action onAfterTerminated;
    final Action onCancel;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;
    final LongConsumer onRequest;
    final Consumer<? super dw2> onSubscribe;
    final ParallelFlowable<T> source;

    static final class ParallelPeekSubscriber<T> implements FlowableSubscriber<T>, dw2 {
        boolean done;
        final cw2 downstream;
        final ParallelPeek<T> parent;
        dw2 upstream;

        ParallelPeekSubscriber(cw2 cw2Var, ParallelPeek<T> parallelPeek) {
            this.downstream = cw2Var;
            this.parent = parallelPeek;
        }

        @Override // defpackage.dw2
        public void cancel() {
            try {
                this.parent.onCancel.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.upstream.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            try {
                this.parent.onComplete.run();
                this.downstream.onComplete();
                try {
                    this.parent.onAfterTerminated.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(th2);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            try {
                this.parent.onError.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.downstream.onError(th);
            try {
                this.parent.onAfterTerminated.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(th3);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                this.parent.onNext.accept(t);
                this.downstream.onNext(t);
                try {
                    this.parent.onAfterNext.accept(t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                onError(th2);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onSubscribe(dw2 dw2Var) {
            if (SubscriptionHelper.validate(this.upstream, dw2Var)) {
                this.upstream = dw2Var;
                try {
                    this.parent.onSubscribe.accept(dw2Var);
                    this.downstream.onSubscribe(this);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    dw2Var.cancel();
                    this.downstream.onSubscribe(EmptySubscription.INSTANCE);
                    onError(th);
                }
            }
        }

        @Override // defpackage.dw2
        public void request(long j) {
            try {
                this.parent.onRequest.accept(j);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.upstream.request(j);
        }
    }

    public ParallelPeek(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Consumer<? super dw2> consumer4, LongConsumer longConsumer, Action action3) {
        this.source = parallelFlowable;
        this.onNext = (Consumer) ObjectHelper.requireNonNull(consumer, "onNext is null");
        this.onAfterNext = (Consumer) ObjectHelper.requireNonNull(consumer2, "onAfterNext is null");
        this.onError = (Consumer) ObjectHelper.requireNonNull(consumer3, "onError is null");
        this.onComplete = (Action) ObjectHelper.requireNonNull(action, "onComplete is null");
        this.onAfterTerminated = (Action) ObjectHelper.requireNonNull(action2, "onAfterTerminated is null");
        this.onSubscribe = (Consumer) ObjectHelper.requireNonNull(consumer4, "onSubscribe is null");
        this.onRequest = (LongConsumer) ObjectHelper.requireNonNull(longConsumer, "onRequest is null");
        this.onCancel = (Action) ObjectHelper.requireNonNull(action3, "onCancel is null");
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(cw2[] cw2VarArr) {
        if (validate(cw2VarArr)) {
            int length = cw2VarArr.length;
            cw2[] cw2VarArr2 = new cw2[length];
            for (int i = 0; i < length; i++) {
                cw2VarArr2[i] = new ParallelPeekSubscriber(cw2VarArr[i], this);
            }
            this.source.subscribe(cw2VarArr2);
        }
    }
}
