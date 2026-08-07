package io.reactivex.internal.util;

import defpackage.cw2;
import defpackage.dw2;
import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes4.dex */
public enum EmptyComponent implements FlowableSubscriber<Object>, Observer<Object>, MaybeObserver<Object>, SingleObserver<Object>, CompletableObserver, dw2, Disposable {
    INSTANCE;

    public static <T> Observer<T> asObserver() {
        return INSTANCE;
    }

    public static <T> cw2 asSubscriber() {
        return INSTANCE;
    }

    @Override // defpackage.dw2
    public void cancel() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    public void onComplete() {
    }

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    public void onError(Throwable th) {
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    public void onNext(Object obj) {
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        disposable.dispose();
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(Object obj) {
    }

    @Override // defpackage.dw2
    public void request(long j) {
    }

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    public void onSubscribe(dw2 dw2Var) {
        dw2Var.cancel();
    }
}
