package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class w92 {
    private final List a;

    public w92(List list) {
        this.a = new ArrayList(list);
    }

    public boolean a(Class cls) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(((v92) it.next()).getClass())) {
                return true;
            }
        }
        return false;
    }

    public v92 b(Class cls) {
        for (v92 v92Var : this.a) {
            if (v92Var.getClass() == cls) {
                return v92Var;
            }
        }
        return null;
    }

    public List c(Class cls) {
        ArrayList arrayList = new ArrayList();
        for (v92 v92Var : this.a) {
            if (cls.isAssignableFrom(v92Var.getClass())) {
                arrayList.add(v92Var);
            }
        }
        return arrayList;
    }
}
