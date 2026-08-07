package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class vg2 {
    private final List a = new ArrayList();
    private final Map b = new HashMap();

    private static class a {
        private final Class a;
        final Class b;
        final ug2 c;

        public a(Class cls, Class cls2, ug2 ug2Var) {
            this.a = cls;
            this.b = cls2;
            this.c = ug2Var;
        }

        public boolean a(Class cls, Class cls2) {
            return this.a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
        }
    }

    private synchronized List c(String str) {
        List arrayList;
        try {
            if (!this.a.contains(str)) {
                this.a.add(str);
            }
            arrayList = (List) this.b.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.b.put(str, arrayList);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized void a(String str, ug2 ug2Var, Class cls, Class cls2) {
        c(str).add(new a(cls, cls2, ug2Var));
    }

    public synchronized List b(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            List<a> list = (List) this.b.get((String) it.next());
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized List d(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            List<a> list = (List) this.b.get((String) it.next());
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.b)) {
                        arrayList.add(aVar.b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(List list) {
        try {
            ArrayList<String> arrayList = new ArrayList(this.a);
            this.a.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.a.add((String) it.next());
            }
            for (String str : arrayList) {
                if (!list.contains(str)) {
                    this.a.add(str);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
