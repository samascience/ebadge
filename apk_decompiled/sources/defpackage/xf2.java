package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class xf2 {
    public static wf2 a(wf2 wf2Var, wf2 wf2Var2) {
        if (wf2Var2 == null) {
            return wf2Var;
        }
        if (wf2Var == null) {
            return wf2Var2;
        }
        wf2.a aVarB = wf2.a.b(wf2Var);
        if (wf2Var2.b() != null) {
            aVarB.d(wf2Var2.b());
        }
        if (wf2Var2.d() != null) {
            aVarB.f(wf2Var2.d());
        }
        if (wf2Var2.c() != null) {
            aVarB.e(wf2Var2.c());
        }
        if (wf2Var2.a() != 0) {
            aVarB.c(wf2Var2.a());
        }
        return aVarB.a();
    }
}
