package kotlinx.coroutines.selects;

import defpackage.pr0;
import defpackage.y70;

/* JADX INFO: loaded from: classes4.dex */
public final class SelectClause0Impl implements SelectClause0 {
    private final Object clauseObject;
    private final pr0 onCancellationConstructor;
    private final pr0 processResFunc;
    private final pr0 regFunc;

    public SelectClause0Impl(Object obj, pr0 pr0Var, pr0 pr0Var2) {
        this.clauseObject = obj;
        this.regFunc = pr0Var;
        this.onCancellationConstructor = pr0Var2;
        this.processResFunc = SelectKt.DUMMY_PROCESS_RESULT_FUNCTION;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Object getClauseObject() {
        return this.clauseObject;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public pr0 getOnCancellationConstructor() {
        return this.onCancellationConstructor;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public pr0 getProcessResFunc() {
        return this.processResFunc;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public pr0 getRegFunc() {
        return this.regFunc;
    }

    public /* synthetic */ SelectClause0Impl(Object obj, pr0 pr0Var, pr0 pr0Var2, int i, y70 y70Var) {
        this(obj, pr0Var, (i & 4) != 0 ? null : pr0Var2);
    }
}
