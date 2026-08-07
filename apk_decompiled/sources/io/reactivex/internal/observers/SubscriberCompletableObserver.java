package io.reactivex.internal.observers;

import defpackage.cw2;
import defpackage.dw2;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes4.dex */
public final class SubscriberCompletableObserver<T> implements CompletableObserver, dw2 {
    final cw2 subscriber;
    Disposable upstream;

    public SubscriberCompletableObserver(cw2 cw2Var) {
        this.subscriber = cw2Var;
    }

    @Override // defpackage.dw2
    public void cancel() {
        this.upstream.dispose();
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        this.subscriber.onComplete();
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable th) {
        this.subscriber.onError(th);
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.subscriber.onSubscribe(this);
        }
    }

    @Override // defpackage.dw2
    public void request(long j) {
    }
}
