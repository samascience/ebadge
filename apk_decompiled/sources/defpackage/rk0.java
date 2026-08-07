package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class rk0 extends lj2 {
    private final HashMap e = new HashMap();

    @Override // defpackage.lj2
    protected lj2.c b(Object obj) {
        return (lj2.c) this.e.get(obj);
    }

    public boolean contains(Object obj) {
        return this.e.containsKey(obj);
    }

    @Override // defpackage.lj2
    public Object f(Object obj, Object obj2) {
        lj2.c cVarB = b(obj);
        if (cVarB != null) {
            return cVarB.b;
        }
        this.e.put(obj, e(obj, obj2));
        return null;
    }

    @Override // defpackage.lj2
    public Object g(Object obj) {
        Object objG = super.g(obj);
        this.e.remove(obj);
        return objG;
    }

    public Map.Entry h(Object obj) {
        if (contains(obj)) {
            return ((lj2.c) this.e.get(obj)).d;
        }
        return null;
    }
}
