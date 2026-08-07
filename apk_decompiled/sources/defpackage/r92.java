package defpackage;

import android.util.Size;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class r92 implements dh0 {
    private final dh0 c;
    private final w92 d;
    private final Map e = new HashMap();

    public r92(dh0 dh0Var, w92 w92Var) {
        this.c = dh0Var;
        this.d = w92Var;
    }

    private eh0 c(eh0 eh0Var, Size size) {
        ArrayList arrayList = new ArrayList();
        Iterator it = eh0Var.d().iterator();
        while (it.hasNext()) {
            arrayList.add(d((eh0.c) it.next(), size));
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return eh0.b.h(eh0Var.a(), eh0Var.b(), eh0Var.c(), arrayList);
    }

    private static eh0.c d(eh0.c cVar, Size size) {
        return eh0.c.a(cVar.e(), cVar.i(), cVar.c(), cVar.f(), size.getWidth(), size.getHeight(), cVar.j(), cVar.b(), cVar.d(), cVar.g());
    }

    private Size e(int i) {
        for (jv2 jv2Var : this.d.c(jv2.class)) {
            if (jv2Var != null) {
                return jv2Var.f(i);
            }
        }
        return null;
    }

    private eh0 f(int i) {
        eh0 eh0VarC;
        if (this.e.containsKey(Integer.valueOf(i))) {
            return (eh0) this.e.get(Integer.valueOf(i));
        }
        if (this.c.a(i)) {
            eh0 eh0VarB = this.c.b(i);
            Objects.requireNonNull(eh0VarB);
            eh0VarC = eh0VarB;
            Size sizeE = e(i);
            if (sizeE != null) {
                eh0VarC = c(eh0VarC, sizeE);
            }
        } else {
            eh0VarC = null;
        }
        this.e.put(Integer.valueOf(i), eh0VarC);
        return eh0VarC;
    }

    @Override // defpackage.dh0
    public boolean a(int i) {
        return this.c.a(i) && f(i) != null;
    }

    @Override // defpackage.dh0
    public eh0 b(int i) {
        return f(i);
    }
}
