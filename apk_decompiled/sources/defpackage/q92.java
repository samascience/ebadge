package defpackage;

import android.util.Size;
import androidx.camera.video.n;
import androidx.camera.video.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class q92 implements dh0 {
    private final dh0 c;
    private final Set d;
    private final Set e;
    private final Set f;
    private final wr0 g;
    private final Map h = new HashMap();
    private final Map i = new HashMap();

    public q92(dh0 dh0Var, Collection collection, Collection collection2, Collection collection3, wr0 wr0Var) {
        c(collection2);
        this.c = dh0Var;
        this.d = new HashSet(collection);
        this.f = new HashSet(collection2);
        this.e = new HashSet(collection3);
        this.g = wr0Var;
    }

    private static void c(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            ie0 ie0Var = (ie0) it.next();
            if (!ie0Var.e()) {
                throw new IllegalArgumentException("Contains non-fully specified DynamicRange: " + ie0Var);
            }
        }
    }

    private eh0 d(s.b bVar) {
        vd3 vd3VarB;
        b52.a(this.d.contains(bVar));
        eh0 eh0VarB = this.c.b(bVar.e());
        for (Size size : bVar.d()) {
            if (this.e.contains(size)) {
                TreeMap treeMap = new TreeMap(new m00());
                ArrayList arrayList = new ArrayList();
                for (ie0 ie0Var : this.f) {
                    if (!i(eh0VarB, ie0Var) && (vd3VarB = f(ie0Var).b(size)) != null) {
                        eh0.c cVarK = vd3VarB.k();
                        pc3 pc3Var = (pc3) this.g.apply(yb3.f(cVarK));
                        if (pc3Var != null && pc3Var.a(size.getWidth(), size.getHeight())) {
                            treeMap.put(new Size(cVarK.k(), cVarK.h()), vd3VarB);
                            arrayList.add(jh0.a(cVarK, size, pc3Var.c()));
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    eh0 eh0Var = (eh0) ir2.a(size, treeMap);
                    Objects.requireNonNull(eh0Var);
                    eh0 eh0Var2 = eh0Var;
                    return eh0.b.h(eh0Var2.a(), eh0Var2.b(), eh0Var2.c(), arrayList);
                }
            }
        }
        return null;
    }

    private s.b e(int i) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            s.b bVar = (s.b) ((s) it.next());
            if (bVar.e() == i) {
                return bVar;
            }
        }
        return null;
    }

    private n f(ie0 ie0Var) {
        if (this.i.containsKey(ie0Var)) {
            n nVar = (n) this.i.get(ie0Var);
            Objects.requireNonNull(nVar);
            return nVar;
        }
        n nVar2 = new n(new le0(this.c, ie0Var));
        this.i.put(ie0Var, nVar2);
        return nVar2;
    }

    private eh0 g(int i) {
        if (this.h.containsKey(Integer.valueOf(i))) {
            return (eh0) this.h.get(Integer.valueOf(i));
        }
        eh0 eh0VarB = this.c.b(i);
        s.b bVarE = e(i);
        if (bVarE != null && !h(eh0VarB)) {
            eh0VarB = j(eh0VarB, d(bVarE));
        }
        this.h.put(Integer.valueOf(i), eh0VarB);
        return eh0VarB;
    }

    private boolean h(eh0 eh0Var) {
        if (eh0Var == null) {
            return false;
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            if (!i(eh0Var, (ie0) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean i(eh0 eh0Var, ie0 ie0Var) {
        if (eh0Var == null) {
            return false;
        }
        Iterator it = eh0Var.d().iterator();
        while (it.hasNext()) {
            if (me0.f((eh0.c) it.next(), ie0Var)) {
                return true;
            }
        }
        return false;
    }

    private static eh0 j(eh0 eh0Var, eh0 eh0Var2) {
        if (eh0Var == null && eh0Var2 == null) {
            return null;
        }
        int iA = eh0Var != null ? eh0Var.a() : eh0Var2.a();
        int iB = eh0Var != null ? eh0Var.b() : eh0Var2.b();
        List listC = eh0Var != null ? eh0Var.c() : eh0Var2.c();
        ArrayList arrayList = new ArrayList();
        if (eh0Var != null) {
            arrayList.addAll(eh0Var.d());
        }
        if (eh0Var2 != null) {
            arrayList.addAll(eh0Var2.d());
        }
        return eh0.b.h(iA, iB, listC, arrayList);
    }

    @Override // defpackage.dh0
    public boolean a(int i) {
        return g(i) != null;
    }

    @Override // defpackage.dh0
    public eh0 b(int i) {
        return g(i);
    }
}
