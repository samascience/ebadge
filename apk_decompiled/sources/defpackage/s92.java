package defpackage;

import androidx.camera.video.s;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class s92 implements dh0 {
    private static final Map f;
    private final dh0 c;
    private final zt d;
    private final w92 e;

    static {
        HashMap map = new HashMap();
        f = map;
        map.put(1, s.f);
        map.put(8, s.d);
        map.put(6, s.c);
        map.put(5, s.b);
        map.put(4, s.a);
        map.put(0, s.e);
    }

    public s92(dh0 dh0Var, zt ztVar, w92 w92Var) {
        this.c = dh0Var;
        this.d = ztVar;
        this.e = w92Var;
    }

    private boolean c(int i) {
        s sVar = (s) f.get(Integer.valueOf(i));
        if (sVar == null) {
            return true;
        }
        for (pd3 pd3Var : this.e.c(pd3.class)) {
            if (pd3Var != null && pd3Var.c(this.d, sVar) && !pd3Var.a()) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.dh0
    public boolean a(int i) {
        return this.c.a(i) && c(i);
    }

    @Override // defpackage.dh0
    public eh0 b(int i) {
        if (a(i)) {
            return this.c.b(i);
        }
        return null;
    }
}
