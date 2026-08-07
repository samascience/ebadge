package kotlinx.coroutines.selects;

import defpackage.ar0;
import defpackage.j21;
import defpackage.x30;

/* JADX INFO: loaded from: classes4.dex */
public final class SelectUnbiasedKt {
    public static final <R> Object selectUnbiased(ar0 ar0Var, x30 x30Var) {
        UnbiasedSelectImplementation unbiasedSelectImplementation = new UnbiasedSelectImplementation(x30Var.getContext());
        ar0Var.invoke(unbiasedSelectImplementation);
        return unbiasedSelectImplementation.doSelect(x30Var);
    }

    private static final <R> Object selectUnbiased$$forInline(ar0 ar0Var, x30 x30Var) {
        j21.c(3);
        throw null;
    }
}
