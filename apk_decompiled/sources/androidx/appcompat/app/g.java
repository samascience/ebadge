package androidx.appcompat.app;

import defpackage.tc1;
import java.util.LinkedHashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
abstract class g {
    private static tc1 a(tc1 tc1Var, tc1 tc1Var2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        while (i < tc1Var.f() + tc1Var2.f()) {
            Locale localeC = i < tc1Var.f() ? tc1Var.c(i) : tc1Var2.c(i - tc1Var.f());
            if (localeC != null) {
                linkedHashSet.add(localeC);
            }
            i++;
        }
        return tc1.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    static tc1 b(tc1 tc1Var, tc1 tc1Var2) {
        return (tc1Var == null || tc1Var.e()) ? tc1.d() : a(tc1Var, tc1Var2);
    }
}
