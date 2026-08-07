package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import defpackage.i92;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableFromPublisher<T> extends Flowable<T> {
    final i92 publisher;

    public FlowableFromPublisher(i92 i92Var) {
        this.publisher = i92Var;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(cw2 cw2Var) {
        this.publisher.subscribe(cw2Var);
    }
}
