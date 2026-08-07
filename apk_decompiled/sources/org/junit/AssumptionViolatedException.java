package org.junit;

import defpackage.eg1;

/* JADX INFO: loaded from: classes4.dex */
public class AssumptionViolatedException extends org.junit.internal.AssumptionViolatedException {
    private static final long serialVersionUID = 1;

    public <T> AssumptionViolatedException(T t, eg1 eg1Var) {
        super(t, eg1Var);
    }

    public <T> AssumptionViolatedException(String str, T t, eg1 eg1Var) {
        super(str, t, eg1Var);
    }

    public AssumptionViolatedException(String str) {
        super(str);
    }

    public AssumptionViolatedException(String str, Throwable th) {
        super(str, th);
    }
}
