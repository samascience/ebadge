package defpackage;

import androidx.lifecycle.o;
import androidx.lifecycle.q;

/* JADX INFO: loaded from: classes.dex */
public final class h21 implements q.b {
    private final le3[] b;

    public h21(le3... le3VarArr) {
        p31.f(le3VarArr, "initializers");
        this.b = le3VarArr;
    }

    @Override // androidx.lifecycle.q.b
    public o b(Class cls, v40 v40Var) {
        p31.f(cls, "modelClass");
        p31.f(v40Var, "extras");
        o oVar = null;
        for (le3 le3Var : this.b) {
            if (p31.a(le3Var.a(), cls)) {
                Object objInvoke = le3Var.b().invoke(v40Var);
                oVar = objInvoke instanceof o ? (o) objInvoke : null;
            }
        }
        if (oVar != null) {
            return oVar;
        }
        throw new IllegalArgumentException("No initializer set for given class " + cls.getName());
    }
}
