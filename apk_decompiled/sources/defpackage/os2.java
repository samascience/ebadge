package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class os2 {
    private static final Object a = new Object();

    public static final Object c(ns2 ns2Var, int i) {
        Object obj;
        p31.f(ns2Var, "<this>");
        int iA = r20.a(ns2Var.b, ns2Var.d, i);
        if (iA < 0 || (obj = ns2Var.c[iA]) == a) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ns2 ns2Var) {
        int i = ns2Var.d;
        int[] iArr = ns2Var.b;
        Object[] objArr = ns2Var.c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        ns2Var.a = false;
        ns2Var.d = i2;
    }
}
