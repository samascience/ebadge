package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import defpackage.i92;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableMapPublisher<T, U> extends Flowable<U> {
    final Function<? super T, ? extends U> mapper;
    final i92 source;

    public FlowableMapPublisher(i92 i92Var, Function<? super T, ? extends U> function) {
        this.source = i92Var;
        this.mapper = function;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(cw2 cw2Var) {
        this.source.subscribe(new FlowableMap.MapSubscriber(cw2Var, this.mapper));
    }
}
