package io.reactivex.internal.operators.completable;

import defpackage.cw2;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.internal.observers.SubscriberCompletableObserver;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletableToFlowable<T> extends Flowable<T> {
    final CompletableSource source;

    public CompletableToFlowable(CompletableSource completableSource) {
        this.source = completableSource;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(cw2 cw2Var) {
        this.source.subscribe(new SubscriberCompletableObserver(cw2Var));
    }
}
