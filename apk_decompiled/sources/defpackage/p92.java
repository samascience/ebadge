package defpackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class p92 implements dh0 {
    private final dh0 c;
    private Map d;

    public p92(dh0 dh0Var, w92 w92Var, zt ztVar, wr0 wr0Var) {
        this.c = dh0Var;
        List listC = w92Var.c(uj0.class);
        if (listC.isEmpty()) {
            return;
        }
        b52.i(listC.size() == 1);
        Map mapF = ((uj0) listC.get(0)).f(ztVar, dh0Var, wr0Var);
        if (mapF != null) {
            this.d = new HashMap(mapF);
        }
    }

    private eh0 c(int i) {
        Map map = this.d;
        return (map == null || !map.containsKey(Integer.valueOf(i))) ? this.c.b(i) : (eh0) this.d.get(Integer.valueOf(i));
    }

    @Override // defpackage.dh0
    public boolean a(int i) {
        return c(i) != null;
    }

    @Override // defpackage.dh0
    public eh0 b(int i) {
        return c(i);
    }
}
