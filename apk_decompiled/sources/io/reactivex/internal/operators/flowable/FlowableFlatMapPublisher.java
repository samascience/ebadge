package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import defpackage.i92;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableFlatMapPublisher<T, U> extends Flowable<U> {
    final int bufferSize;
    final boolean delayErrors;
    final Function<? super T, ? extends i92> mapper;
    final int maxConcurrency;
    final i92 source;

    public FlowableFlatMapPublisher(i92 i92Var, Function<? super T, ? extends i92> function, boolean z, int i, int i2) {
        this.source = i92Var;
        this.mapper = function;
        this.delayErrors = z;
        this.maxConcurrency = i;
        this.bufferSize = i2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(cw2 cw2Var) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, cw2Var, this.mapper)) {
            return;
        }
        this.source.subscribe(FlowableFlatMap.subscribe(cw2Var, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }
}
