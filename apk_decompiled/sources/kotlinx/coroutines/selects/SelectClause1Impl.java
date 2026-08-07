package kotlinx.coroutines.selects;

import defpackage.pr0;
import defpackage.y70;

/* JADX INFO: loaded from: classes4.dex */
public final class SelectClause1Impl<Q> implements SelectClause1<Q> {
    private final Object clauseObject;
    private final pr0 onCancellationConstructor;
    private final pr0 processResFunc;
    private final pr0 regFunc;

    public SelectClause1Impl(Object obj, pr0 pr0Var, pr0 pr0Var2, pr0 pr0Var3) {
        this.clauseObject = obj;
        this.regFunc = pr0Var;
        this.processResFunc = pr0Var2;
        this.onCancellationConstructor = pr0Var3;
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

    public /* synthetic */ SelectClause1Impl(Object obj, pr0 pr0Var, pr0 pr0Var2, pr0 pr0Var3, int i, y70 y70Var) {
        this(obj, pr0Var, pr0Var2, (i & 8) != 0 ? null : pr0Var3);
    }
}
