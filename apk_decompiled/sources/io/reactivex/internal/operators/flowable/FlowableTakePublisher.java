package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import defpackage.i92;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableTakePublisher<T> extends Flowable<T> {
    final long limit;
    final i92 source;

    public FlowableTakePublisher(i92 i92Var, long j) {
        this.source = i92Var;
        this.limit = j;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(cw2 cw2Var) {
        this.source.subscribe(new FlowableTake.TakeSubscriber(cw2Var, this.limit));
    }
}
