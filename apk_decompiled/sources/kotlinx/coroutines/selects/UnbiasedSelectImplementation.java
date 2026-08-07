package kotlinx.coroutines.selects;

import defpackage.ar0;
import defpackage.or0;
import defpackage.x30;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public class UnbiasedSelectImplementation<R> extends SelectImplementation<R> {
    private final List<SelectImplementation<R>.ClauseData> clausesToRegister;

    public UnbiasedSelectImplementation(d dVar) {
        super(dVar);
        this.clausesToRegister = new ArrayList();
    }

    static /* synthetic */ <R> Object doSelect$suspendImpl(UnbiasedSelectImplementation<R> unbiasedSelectImplementation, x30 x30Var) {
        unbiasedSelectImplementation.shuffleAndRegisterClauses();
        return super.doSelect(x30Var);
    }

    private final void shuffleAndRegisterClauses() {
        try {
            Collections.shuffle(this.clausesToRegister);
            Iterator<T> it = this.clausesToRegister.iterator();
            while (it.hasNext()) {
                SelectImplementation.register$default(this, (SelectImplementation.ClauseData) it.next(), false, 1, null);
            }
            this.clausesToRegister.clear();
        } catch (Throwable th) {
            this.clausesToRegister.clear();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation
    public Object doSelect(x30 x30Var) {
        return doSelect$suspendImpl((UnbiasedSelectImplementation) this, x30Var);
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation, kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause0 selectClause0, ar0 ar0Var) {
        this.clausesToRegister.add(new SelectImplementation.ClauseData(selectClause0.getClauseObject(), selectClause0.getRegFunc(), selectClause0.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), ar0Var, selectClause0.getOnCancellationConstructor()));
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation, kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(SelectClause1<? extends Q> selectClause1, or0 or0Var) {
        this.clausesToRegister.add(new SelectImplementation.ClauseData(selectClause1.getClauseObject(), selectClause1.getRegFunc(), selectClause1.getProcessResFunc(), null, or0Var, selectClause1.getOnCancellationConstructor()));
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation, kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> selectClause2, P p, or0 or0Var) {
        this.clausesToRegister.add(new SelectImplementation.ClauseData(selectClause2.getClauseObject(), selectClause2.getRegFunc(), selectClause2.getProcessResFunc(), p, or0Var, selectClause2.getOnCancellationConstructor()));
    }
}
