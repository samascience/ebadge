package io.reactivex.internal.operators.parallel;

import defpackage.cw2;
import defpackage.i92;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.parallel.ParallelFlowable;

/* JADX INFO: loaded from: classes4.dex */
public final class ParallelConcatMap<T, R> extends ParallelFlowable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends i92> mapper;
    final int prefetch;
    final ParallelFlowable<T> source;

    public ParallelConcatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends i92> function, int i, ErrorMode errorMode) {
        this.source = parallelFlowable;
        this.mapper = (Function) ObjectHelper.requireNonNull(function, "mapper");
        this.prefetch = i;
        this.errorMode = (ErrorMode) ObjectHelper.requireNonNull(errorMode, "errorMode");
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
                cw2VarArr2[i] = FlowableConcatMap.subscribe(cw2VarArr[i], this.mapper, this.prefetch, this.errorMode);
            }
            this.source.subscribe(cw2VarArr2);
        }
    }
}
