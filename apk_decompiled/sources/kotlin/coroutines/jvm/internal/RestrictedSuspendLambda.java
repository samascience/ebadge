package kotlin.coroutines.jvm.internal;

import defpackage.ke2;
import defpackage.p31;
import defpackage.x30;
import defpackage.yr0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements yr0 {
    private final int arity;

    public RestrictedSuspendLambda(int i, x30 x30Var) {
        super(x30Var);
        this.arity = i;
    }

    @Override // defpackage.yr0
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strJ = ke2.j(this);
        p31.e(strJ, "renderLambdaToString(...)");
        return strJ;
    }

    public RestrictedSuspendLambda(int i) {
        this(i, null);
    }
}
