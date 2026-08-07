package io.reactivex.internal.fuseable;

import io.reactivex.FlowableSubscriber;

/* JADX INFO: loaded from: classes4.dex */
public interface ConditionalSubscriber<T> extends FlowableSubscriber<T> {
    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    /* synthetic */ void onComplete();

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    /* synthetic */ void onError(Throwable th);

    @Override // io.reactivex.FlowableSubscriber, defpackage.cw2
    /* synthetic */ void onNext(Object obj);

    boolean tryOnNext(T t);
}
