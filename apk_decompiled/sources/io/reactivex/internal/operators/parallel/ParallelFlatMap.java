package io.reactivex.internal.operators.parallel;

import defpackage.cw2;
import defpackage.i92;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.parallel.ParallelFlowable;

/* JADX INFO: loaded from: classes4.dex */
public final class ParallelFlatMap<T, R> extends ParallelFlowable<R> {
    final boolean delayError;
    final Function<? super T, ? extends i92> mapper;
    final int maxConcurrency;
    final int prefetch;
    final ParallelFlowable<T> source;

    public ParallelFlatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends i92> function, boolean z, int i, int i2) {
        this.source = parallelFlowable;
        this.mapper = function;
        this.delayError = z;
        this.maxConcurrency = i;
        this.prefetch = i2;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.source.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(cw2[] cw2VarArr) {
        if (validate(cw2VarArr)) {
            int length = cw2VarArr.length;
            cw2[] cw2VarArr2 = new cw2[length];
            for (int i = 0; i < length; i++) {
                cw2VarArr2[i] = FlowableFlatMap.subscribe(cw2VarArr[i], this.mapper, this.delayError, this.maxConcurrency, this.prefetch);
            }
            this.source.subscribe(cw2VarArr2);
        }
    }
}
