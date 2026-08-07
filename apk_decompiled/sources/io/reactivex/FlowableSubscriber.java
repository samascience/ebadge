package io.reactivex;

import defpackage.cw2;
import defpackage.dw2;
import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public interface FlowableSubscriber<T> extends cw2 {
    @Override // defpackage.cw2
    /* synthetic */ void onComplete();

    @Override // defpackage.cw2
    /* synthetic */ void onError(Throwable th);

    @Override // defpackage.cw2
    /* synthetic */ void onNext(Object obj);

    @Override // defpackage.cw2
    void onSubscribe(@NonNull dw2 dw2Var);
}
