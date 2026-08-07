package defpackage;

import android.os.Build;
import android.util.Range;
import android.util.Size;
import androidx.camera.video.x0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class uj0 implements v92 {
    private Map g(zt ztVar, dh0 dh0Var, wr0 wr0Var) {
        eh0 eh0VarB;
        eh0.c cVarB;
        if (!"1".equals(ztVar.d()) || dh0Var.a(4) || (cVarB = jh0.b((eh0VarB = dh0Var.b(1)))) == null) {
            return null;
        }
        Range rangeH = h(cVarB, wr0Var);
        Size size = ir2.d;
        eh0.b bVarH = eh0.b.h(eh0VarB.a(), eh0VarB.b(), eh0VarB.c(), Collections.singletonList(jh0.a(cVarB, size, rangeH)));
        HashMap map = new HashMap();
        map.put(4, bVarH);
        if (ir2.c(size) > ir2.c(new Size(cVarB.k(), cVarB.h()))) {
            map.put(1, bVarH);
        }
        return map;
    }

    private static Range h(eh0.c cVar, wr0 wr0Var) {
        pc3 pc3Var = (pc3) wr0Var.apply(yb3.f(cVar));
        return pc3Var != null ? pc3Var.c() : x0.b;
    }

    private static boolean i() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto c".equalsIgnoreCase(Build.MODEL);
    }

    static boolean j() {
        return i();
    }

    public Map f(zt ztVar, dh0 dh0Var, wr0 wr0Var) {
        return i() ? g(ztVar, dh0Var, wr0Var) : Collections.emptyMap();
    }
}
