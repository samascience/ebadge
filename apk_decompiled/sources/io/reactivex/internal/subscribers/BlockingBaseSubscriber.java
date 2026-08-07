package io.reactivex.internal.subscribers;

import defpackage.dw2;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BlockingBaseSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T> {
    volatile boolean cancelled;
    Throwable error;
    dw2 upstream;
    T value;

    public BlockingBaseSubscriber() {
        super(1);
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                dw2 dw2Var = this.upstream;
                this.upstream = SubscriptionHelper.CANCELLED;
                if (dw2Var != null) {
                    dw2Var.cancel();
                }
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.error;
        if (th == null) {
            return this.value;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    public abstract /* synthetic */ void onError(Throwable th);

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    public abstract /* synthetic */ void onNext(Object obj);

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    public final void onSubscribe(dw2 dw2Var) {
        if (SubscriptionHelper.validate(this.upstream, dw2Var)) {
            this.upstream = dw2Var;
            if (this.cancelled) {
                return;
            }
            dw2Var.request(Long.MAX_VALUE);
            if (this.cancelled) {
                this.upstream = SubscriptionHelper.CANCELLED;
                dw2Var.cancel();
            }
        }
    }
}
