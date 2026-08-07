package defpackage;

import androidx.camera.camera2.internal.t2;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class xo0 {
    private final pw a;

    public interface a {
        void a(t2 t2Var);
    }

    public xo0(w92 w92Var) {
        this.a = (pw) w92Var.b(pw.class);
    }

    private void a(Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            t2 t2Var = (t2) it.next();
            t2Var.c().q(t2Var);
        }
    }

    private void b(Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            t2 t2Var = (t2) it.next();
            t2Var.c().r(t2Var);
        }
    }

    public void c(t2 t2Var, List list, List list2, a aVar) {
        t2 t2Var2;
        t2 t2Var3;
        if (d()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = list.iterator();
            while (it.hasNext() && (t2Var3 = (t2) it.next()) != t2Var) {
                linkedHashSet.add(t2Var3);
            }
            b(linkedHashSet);
        }
        aVar.a(t2Var);
        if (d()) {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            Iterator it2 = list2.iterator();
            while (it2.hasNext() && (t2Var2 = (t2) it2.next()) != t2Var) {
                linkedHashSet2.add(t2Var2);
            }
            a(linkedHashSet2);
        }
    }

    public boolean d() {
        return this.a != null;
    }
}
