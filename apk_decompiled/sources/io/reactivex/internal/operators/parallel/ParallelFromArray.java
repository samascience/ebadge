package io.reactivex.internal.operators.parallel;

import defpackage.cw2;
import defpackage.i92;
import io.reactivex.parallel.ParallelFlowable;

/* JADX INFO: loaded from: classes4.dex */
public final class ParallelFromArray<T> extends ParallelFlowable<T> {
    final i92[] sources;

    public ParallelFromArray(i92[] i92VarArr) {
        this.sources = i92VarArr;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.sources.length;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(cw2[] cw2VarArr) {
        if (validate(cw2VarArr)) {
            int length = cw2VarArr.length;
            for (int i = 0; i < length; i++) {
                this.sources[i].subscribe(cw2VarArr[i]);
            }
        }
    }
}
