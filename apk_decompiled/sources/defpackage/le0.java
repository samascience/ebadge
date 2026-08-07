package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class le0 implements dh0 {
    private final dh0 c;
    private final ie0 d;
    private final Map e = new HashMap();

    public le0(dh0 dh0Var, ie0 ie0Var) {
        this.c = dh0Var;
        this.d = ie0Var;
    }

    private static eh0 c(eh0 eh0Var, ie0 ie0Var) {
        if (eh0Var == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (eh0.c cVar : eh0Var.d()) {
            if (me0.f(cVar, ie0Var)) {
                arrayList.add(cVar);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return eh0.b.h(eh0Var.a(), eh0Var.b(), eh0Var.c(), arrayList);
    }

    private eh0 d(int i) {
        if (this.e.containsKey(Integer.valueOf(i))) {
            return (eh0) this.e.get(Integer.valueOf(i));
        }
        if (!this.c.a(i)) {
            return null;
        }
        eh0 eh0VarC = c(this.c.b(i), this.d);
        this.e.put(Integer.valueOf(i), eh0VarC);
        return eh0VarC;
    }

    @Override // defpackage.dh0
    public boolean a(int i) {
        return this.c.a(i) && d(i) != null;
    }

    @Override // defpackage.dh0
    public eh0 b(int i) {
        return d(i);
    }
}
