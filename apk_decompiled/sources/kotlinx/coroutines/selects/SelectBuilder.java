package kotlinx.coroutines.selects;

import defpackage.ar0;
import defpackage.or0;
import kotlinx.coroutines.ExperimentalCoroutinesApi;

/* JADX INFO: loaded from: classes4.dex */
public interface SelectBuilder<R> {

    public static final class DefaultImpls {
        public static <R, P, Q> void invoke(SelectBuilder<? super R> selectBuilder, SelectClause2<? super P, ? extends Q> selectClause2, or0 or0Var) {
            selectBuilder.invoke(selectClause2, null, or0Var);
        }

        @ExperimentalCoroutinesApi
        public static <R> void onTimeout(SelectBuilder<? super R> selectBuilder, long j, ar0 ar0Var) {
            OnTimeoutKt.onTimeout(selectBuilder, j, ar0Var);
        }
    }

    void invoke(SelectClause0 selectClause0, ar0 ar0Var);

    <Q> void invoke(SelectClause1<? extends Q> selectClause1, or0 or0Var);

    <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, P p, or0 or0Var);

    <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, or0 or0Var);

    @ExperimentalCoroutinesApi
    void onTimeout(long j, ar0 ar0Var);
}
