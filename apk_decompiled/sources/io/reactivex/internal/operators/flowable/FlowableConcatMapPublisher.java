package io.reactivex.internal.operators.flowable;

import defpackage.cw2;
import defpackage.i92;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ErrorMode;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableConcatMapPublisher<T, R> extends Flowable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends i92> mapper;
    final int prefetch;
    final i92 source;

    public FlowableConcatMapPublisher(i92 i92Var, Function<? super T, ? extends i92> function, int i, ErrorMode errorMode) {
        this.source = i92Var;
        this.mapper = function;
        this.prefetch = i;
        this.errorMode = errorMode;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(cw2 cw2Var) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.source, cw2Var, this.mapper)) {
            return;
        }
        this.source.subscribe(FlowableConcatMap.subscribe(cw2Var, this.mapper, this.prefetch, this.errorMode));
    }
}
