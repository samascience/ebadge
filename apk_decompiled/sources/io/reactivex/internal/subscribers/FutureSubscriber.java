package io.reactivex.internal.subscribers;

import defpackage.dw2;
import defpackage.p62;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, dw2 {
    Throwable error;
    final AtomicReference<dw2> upstream;
    T value;

    public FutureSubscriber() {
        super(1);
        this.upstream = new AtomicReference<>();
    }

    @Override // defpackage.dw2
    public void cancel() {
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.error;
        if (th == null) {
            return this.value;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.upstream.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    public void onComplete() {
        dw2 dw2Var;
        if (this.value == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            dw2Var = this.upstream.get();
            if (dw2Var == this || dw2Var == SubscriptionHelper.CANCELLED) {
                return;
            }
        } while (!p62.a(this.upstream, dw2Var, this));
        countDown();
    }

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    public void onError(Throwable th) {
        dw2 dw2Var;
        do {
            dw2Var = this.upstream.get();
            if (dw2Var == this || dw2Var == SubscriptionHelper.CANCELLED) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
        } while (!p62.a(this.upstream, dw2Var, this));
        countDown();
    }

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    public void onNext(T t) {
        if (this.value == null) {
            this.value = t;
        } else {
            this.upstream.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    public void onSubscribe(dw2 dw2Var) {
        SubscriptionHelper.setOnce(this.upstream, dw2Var, Long.MAX_VALUE);
    }

    @Override // defpackage.dw2
    public void request(long j) {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        dw2 dw2Var;
        SubscriptionHelper subscriptionHelper;
        do {
            dw2Var = this.upstream.get();
            if (dw2Var == this || dw2Var == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
                return false;
            }
        } while (!p62.a(this.upstream, dw2Var, subscriptionHelper));
        if (dw2Var != null) {
            dw2Var.cancel();
        }
        countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            if (!await(j, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.timeoutMessage(j, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.error;
            if (th == null) {
                return this.value;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
