package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class nv0 {
    private final a a = new a();
    private final Map b = new HashMap();

    private static class a {
        final Object a;
        private List b;
        a c;
        a d;

        a() {
            this(null);
        }

        public void a(Object obj) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            this.b.add(obj);
        }

        public Object b() {
            int iC = c();
            if (iC > 0) {
                return this.b.remove(iC - 1);
            }
            return null;
        }

        public int c() {
            List list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(Object obj) {
            this.d = this;
            this.c = this;
            this.a = obj;
        }
    }

    nv0() {
    }

    private void b(a aVar) {
        e(aVar);
        a aVar2 = this.a;
        aVar.d = aVar2;
        aVar.c = aVar2.c;
        g(aVar);
    }

    private void c(a aVar) {
        e(aVar);
        a aVar2 = this.a;
        aVar.d = aVar2.d;
        aVar.c = aVar2;
        g(aVar);
    }

    private static void e(a aVar) {
        a aVar2 = aVar.d;
        aVar2.c = aVar.c;
        aVar.c.d = aVar2;
    }

    private static void g(a aVar) {
        aVar.c.d = aVar;
        aVar.d.c = aVar;
    }

    public Object a(g42 g42Var) {
        a aVar = (a) this.b.get(g42Var);
        if (aVar == null) {
            aVar = new a(g42Var);
            this.b.put(g42Var, aVar);
        } else {
            g42Var.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(g42 g42Var, Object obj) {
        a aVar = (a) this.b.get(g42Var);
        if (aVar == null) {
            aVar = new a(g42Var);
            c(aVar);
            this.b.put(g42Var, aVar);
        } else {
            g42Var.a();
        }
        aVar.a(obj);
    }

    public Object f() {
        for (a aVar = this.a.d; !aVar.equals(this.a); aVar = aVar.d) {
            Object objB = aVar.b();
            if (objB != null) {
                return objB;
            }
            e(aVar);
            this.b.remove(aVar.a);
            ((g42) aVar.a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.a.c;
        boolean z = false;
        while (!aVar.equals(this.a)) {
            sb.append('{');
            sb.append(aVar.a);
            sb.append(':');
            sb.append(aVar.c());
            sb.append("}, ");
            aVar = aVar.c;
            z = true;
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
