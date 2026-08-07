package kotlin.coroutines.jvm.internal;

import defpackage.p31;
import defpackage.v00;
import defpackage.x30;
import kotlin.coroutines.c;
import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final d _context;
    private transient x30 intercepted;

    public ContinuationImpl(x30 x30Var, d dVar) {
        super(x30Var);
        this._context = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, defpackage.x30
    public d getContext() {
        d dVar = this._context;
        p31.c(dVar);
        return dVar;
    }

    public final x30 intercepted() {
        x30 x30VarInterceptContinuation = this.intercepted;
        if (x30VarInterceptContinuation == null) {
            c cVar = (c) getContext().get(c.E);
            if (cVar == null || (x30VarInterceptContinuation = cVar.interceptContinuation(this)) == null) {
                x30VarInterceptContinuation = this;
            }
            this.intercepted = x30VarInterceptContinuation;
        }
        return x30VarInterceptContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    protected void releaseIntercepted() {
        x30 x30Var = this.intercepted;
        if (x30Var != null && x30Var != this) {
            d.b bVar = getContext().get(c.E);
            p31.c(bVar);
            ((c) bVar).releaseInterceptedContinuation(x30Var);
        }
        this.intercepted = v00.a;
    }

    public ContinuationImpl(x30 x30Var) {
        this(x30Var, x30Var != null ? x30Var.getContext() : null);
    }
}
