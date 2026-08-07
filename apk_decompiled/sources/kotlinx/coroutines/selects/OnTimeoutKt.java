package kotlinx.coroutines.selects;

import defpackage.ar0;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;

/* JADX INFO: loaded from: classes4.dex */
public final class OnTimeoutKt {
    @ExperimentalCoroutinesApi
    public static final <R> void onTimeout(SelectBuilder<? super R> selectBuilder, long j, ar0 ar0Var) {
        selectBuilder.invoke(new OnTimeout(j).getSelectClause(), ar0Var);
    }

    @ExperimentalCoroutinesApi
    /* JADX INFO: renamed from: onTimeout-8Mi8wO0, reason: not valid java name */
    public static final <R> void m161onTimeout8Mi8wO0(SelectBuilder<? super R> selectBuilder, long j, ar0 ar0Var) {
        onTimeout(selectBuilder, DelayKt.m82toDelayMillisLRDsOJo(j), ar0Var);
    }
}
