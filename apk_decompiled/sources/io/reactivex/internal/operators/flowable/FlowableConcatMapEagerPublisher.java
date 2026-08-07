package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import defpackage.i92;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ErrorMode;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableConcatMapEagerPublisher<T, R> extends Flowable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends i92> mapper;
    final int maxConcurrency;
    final int prefetch;
    final i92 source;

    public FlowableConcatMapEagerPublisher(i92 i92Var, Function<? super T, ? extends i92> function, int i, int i2, ErrorMode errorMode) {
        this.source = i92Var;
        this.mapper = function;
        this.maxConcurrency = i;
        this.prefetch = i2;
        this.errorMode = errorMode;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(cw2 cw2Var) {
        this.source.subscribe(new FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber(cw2Var, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }
}
