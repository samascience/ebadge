package defpackage;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class oe0 {
    public static final oe0 a = new oe0();

    private oe0() {
    }

    private final boolean a(ie0 ie0Var, ie0 ie0Var2) {
        b52.j(ie0Var2.e(), "Fully specified range is not actually fully specified.");
        return ie0Var.a() == 0 || ie0Var.a() == ie0Var2.a();
    }

    private final boolean b(ie0 ie0Var, ie0 ie0Var2) {
        b52.j(ie0Var2.e(), "Fully specified range is not actually fully specified.");
        int iB = ie0Var.b();
        if (iB == 0) {
            return true;
        }
        int iB2 = ie0Var2.b();
        return (iB == 2 && iB2 != 1) || iB == iB2;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0032 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0034 A[ORIG_RETURN, RETURN] */
    public static final boolean c(ie0 ie0Var, Set set) {
        p31.f(ie0Var, "dynamicRangeToTest");
        p31.f(set, "fullySpecifiedDynamicRanges");
        if (ie0Var.e()) {
            return set.contains(ie0Var);
        }
        for (Object obj : set) {
            if (a.d(ie0Var, (ie0) obj)) {
                if (obj != null) {
                    return true;
                }
                return false;
            }
        }
        obj = null;
        if (obj != null) {
            return true;
        }
        return false;
    }

    private final boolean d(ie0 ie0Var, ie0 ie0Var2) {
        return a(ie0Var, ie0Var2) && b(ie0Var, ie0Var2);
    }
}
