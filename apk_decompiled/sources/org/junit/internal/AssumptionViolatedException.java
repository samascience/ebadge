package org.junit.internal;

import defpackage.eg1;
import defpackage.mv2;
import defpackage.n90;
import defpackage.nm2;

/* JADX INFO: loaded from: classes4.dex */
public class AssumptionViolatedException extends RuntimeException implements nm2 {
    private static final long serialVersionUID = 2;
    private final String fAssumption;
    private final eg1 fMatcher;
    private final Object fValue;
    private final boolean fValueMatcher;

    @Deprecated
    public AssumptionViolatedException(String str, boolean z, Object obj, eg1 eg1Var) {
        this.fAssumption = str;
        this.fValue = obj;
        this.fValueMatcher = z;
        if (obj instanceof Throwable) {
            initCause((Throwable) obj);
        }
    }

    @Override // defpackage.nm2
    public void describeTo(n90 n90Var) {
        String str = this.fAssumption;
        if (str != null) {
            n90Var.a(str);
        }
        if (this.fValueMatcher) {
            if (this.fAssumption != null) {
                n90Var.a(": ");
            }
            n90Var.a("got: ");
            n90Var.b(this.fValue);
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return mv2.k(this);
    }

    @Deprecated
    public AssumptionViolatedException(Object obj, eg1 eg1Var) {
        this(null, true, obj, eg1Var);
    }

    @Deprecated
    public AssumptionViolatedException(String str, Object obj, eg1 eg1Var) {
        this(str, true, obj, eg1Var);
    }

    @Deprecated
    public AssumptionViolatedException(String str) {
        this(str, false, null, null);
    }

    @Deprecated
    public AssumptionViolatedException(String str, Throwable th) {
        this(str, false, null, null);
        initCause(th);
    }
}
