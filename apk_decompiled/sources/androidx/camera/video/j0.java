package androidx.camera.video;

import android.util.Size;
import defpackage.b52;
import defpackage.dh0;
import defpackage.ie;
import defpackage.ie0;
import defpackage.le0;
import defpackage.oe0;
import defpackage.p92;
import defpackage.q92;
import defpackage.r92;
import defpackage.s92;
import defpackage.va0;
import defpackage.vd3;
import defpackage.w92;
import defpackage.wr0;
import defpackage.zt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class j0 implements m0 {
    private final dh0 b;
    private final boolean c;
    private final Map d = new HashMap();
    private final Map e = new HashMap();

    j0(int i, zt ztVar, wr0 wr0Var) {
        b52.b(i == 0 || i == 1, "Not a supported video capabilities source: " + i);
        dh0 dh0VarL = ztVar.l();
        w92 w92VarB = va0.b();
        dh0 p92Var = new p92(dh0VarL, w92VarB, ztVar, wr0Var);
        dh0 r92Var = new r92(i == 1 ? new q92(p92Var, s.b(), Collections.singleton(ie0.d), ztVar.n(34), wr0Var) : p92Var, w92VarB);
        this.b = new s92(h(ztVar) ? new ie(r92Var, wr0Var) : r92Var, ztVar, w92VarB);
        for (ie0 ie0Var : ztVar.b()) {
            n nVar = new n(new le0(this.b, ie0Var));
            if (!nVar.f().isEmpty()) {
                this.d.put(ie0Var, nVar);
            }
        }
        this.c = ztVar.c();
    }

    private n e(ie0 ie0Var) {
        if (oe0.c(ie0Var, g())) {
            return new n(new le0(this.b, ie0Var));
        }
        return null;
    }

    private n f(ie0 ie0Var) {
        if (ie0Var.e()) {
            return (n) this.d.get(ie0Var);
        }
        if (this.e.containsKey(ie0Var)) {
            return (n) this.e.get(ie0Var);
        }
        n nVarE = e(ie0Var);
        this.e.put(ie0Var, nVarE);
        return nVarE;
    }

    private static boolean h(zt ztVar) {
        for (ie0 ie0Var : ztVar.b()) {
            Integer numValueOf = Integer.valueOf(ie0Var.b());
            int iA = ie0Var.a();
            if (numValueOf.equals(3) && iA == 10) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.m0
    public vd3 a(Size size, ie0 ie0Var) {
        n nVarF = f(ie0Var);
        if (nVarF == null) {
            return null;
        }
        return nVarF.b(size);
    }

    @Override // androidx.camera.video.m0
    public s b(Size size, ie0 ie0Var) {
        n nVarF = f(ie0Var);
        return nVarF == null ? s.g : nVarF.c(size);
    }

    @Override // androidx.camera.video.m0
    public List c(ie0 ie0Var) {
        n nVarF = f(ie0Var);
        return nVarF == null ? new ArrayList() : nVarF.f();
    }

    @Override // androidx.camera.video.m0
    public vd3 d(s sVar, ie0 ie0Var) {
        n nVarF = f(ie0Var);
        if (nVarF == null) {
            return null;
        }
        return nVarF.e(sVar);
    }

    public Set g() {
        return this.d.keySet();
    }
}
