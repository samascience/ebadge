package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import defpackage.dw2;
import defpackage.i92;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableUsing<T, D> extends Flowable<T> {
    final Consumer<? super D> disposer;
    final boolean eager;
    final Callable<? extends D> resourceSupplier;
    final Function<? super D, ? extends i92> sourceSupplier;

    static final class UsingSubscriber<T, D> extends AtomicBoolean implements FlowableSubscriber<T>, dw2 {
        private static final long serialVersionUID = 5904473792286235046L;
        final Consumer<? super D> disposer;
        final cw2 downstream;
        final boolean eager;
        final D resource;
        dw2 upstream;

        UsingSubscriber(cw2 cw2Var, D d, Consumer<? super D> consumer, boolean z) {
            this.downstream = cw2Var;
            this.resource = d;
            this.disposer = consumer;
            this.eager = z;
        }

        @Override // defpackage.dw2
        public void cancel() {
            disposeAfter();
            this.upstream.cancel();
        }

        void disposeAfter() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onComplete() {
            if (!this.eager) {
                this.downstream.onComplete();
                this.upstream.cancel();
                disposeAfter();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.downstream.onError(th);
                    return;
                }
            }
            this.upstream.cancel();
            this.downstream.onComplete();
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onError(Throwable th) {
            if (!this.eager) {
                this.downstream.onError(th);
                this.upstream.cancel();
                disposeAfter();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th2) {
                    th = th2;
                    Exceptions.throwIfFatal(th);
                }
            }
            th = null;
            this.upstream.cancel();
            if (th != null) {
                this.downstream.onError(new CompositeException(th, th));
            } else {
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
        public void onSubscribe(dw2 dw2Var) {
            if (SubscriptionHelper.validate(this.upstream, dw2Var)) {
                this.upstream = dw2Var;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // defpackage.dw2
        public void request(long j) {
            this.upstream.request(j);
        }
    }

    public FlowableUsing(Callable<? extends D> callable, Function<? super D, ? extends i92> function, Consumer<? super D> consumer, boolean z) {
        this.resourceSupplier = callable;
        this.sourceSupplier = function;
        this.disposer = consumer;
        this.eager = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(cw2 cw2Var) {
        try {
            D dCall = this.resourceSupplier.call();
            try {
                ((i92) ObjectHelper.requireNonNull(this.sourceSupplier.apply(dCall), "The sourceSupplier returned a null Publisher")).subscribe(new UsingSubscriber(cw2Var, dCall, this.disposer, this.eager));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                try {
                    this.disposer.accept(dCall);
                    EmptySubscription.error(th, cw2Var);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    EmptySubscription.error(new CompositeException(th, th2), cw2Var);
                }
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptySubscription.error(th3, cw2Var);
        }
    }
}
