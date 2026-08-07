package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class lj2 implements Iterable {
    c a;
    private c b;
    private final WeakHashMap c = new WeakHashMap();
    private int d = 0;

    static class a extends e {
        a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // lj2.e
        c b(c cVar) {
            return cVar.d;
        }

        @Override // lj2.e
        c c(c cVar) {
            return cVar.c;
        }
    }

    private static class b extends e {
        b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // lj2.e
        c b(c cVar) {
            return cVar.c;
        }

        @Override // lj2.e
        c c(c cVar) {
            return cVar.d;
        }
    }

    static class c implements Map.Entry {
        final Object a;
        final Object b;
        c c;
        c d;

        c(Object obj, Object obj2) {
            this.a = obj;
            this.b = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a.equals(cVar.a) && this.b.equals(cVar.b);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.a + "=" + this.b;
        }
    }

    public class d extends f implements Iterator {
        private c a;
        private boolean b = true;

        d() {
        }

        @Override // lj2.f
        void a(c cVar) {
            c cVar2 = this.a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.d;
                this.a = cVar3;
                this.b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.b) {
                this.b = false;
                this.a = lj2.this.a;
            } else {
                c cVar = this.a;
                this.a = cVar != null ? cVar.c : null;
            }
            return this.a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b) {
                return lj2.this.a != null;
            }
            c cVar = this.a;
            return (cVar == null || cVar.c == null) ? false : true;
        }
    }

    private static abstract class e extends f implements Iterator {
        c a;
        c b;

        e(c cVar, c cVar2) {
            this.a = cVar2;
            this.b = cVar;
        }

        private c e() {
            c cVar = this.b;
            c cVar2 = this.a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // lj2.f
        public void a(c cVar) {
            if (this.a == cVar && cVar == this.b) {
                this.b = null;
                this.a = null;
            }
            c cVar2 = this.a;
            if (cVar2 == cVar) {
                this.a = b(cVar2);
            }
            if (this.b == cVar) {
                this.b = e();
            }
        }

        abstract c b(c cVar);

        abstract c c(c cVar);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.b;
            this.b = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b != null;
        }
    }

    public static abstract class f {
        abstract void a(c cVar);
    }

    public Map.Entry a() {
        return this.a;
    }

    protected c b(Object obj) {
        c cVar = this.a;
        while (cVar != null && !cVar.a.equals(obj)) {
            cVar = cVar.c;
        }
        return cVar;
    }

    public d c() {
        d dVar = new d();
        this.c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry d() {
        return this.b;
    }

    public Iterator descendingIterator() {
        b bVar = new b(this.b, this.a);
        this.c.put(bVar, Boolean.FALSE);
        return bVar;
    }

    c e(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.d++;
        c cVar2 = this.b;
        if (cVar2 == null) {
            this.a = cVar;
            this.b = cVar;
            return cVar;
        }
        cVar2.c = cVar;
        cVar.d = cVar2;
        this.b = cVar;
        return cVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof lj2)) {
            return false;
        }
        lj2 lj2Var = (lj2) obj;
        if (size() != lj2Var.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = lj2Var.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public Object f(Object obj, Object obj2) {
        c cVarB = b(obj);
        if (cVarB != null) {
            return cVarB.b;
        }
        e(obj, obj2);
        return null;
    }

    public Object g(Object obj) {
        c cVarB = b(obj);
        if (cVarB == null) {
            return null;
        }
        this.d--;
        if (!this.c.isEmpty()) {
            Iterator it = this.c.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(cVarB);
            }
        }
        c cVar = cVarB.d;
        if (cVar != null) {
            cVar.c = cVarB.c;
        } else {
            this.a = cVarB.c;
        }
        c cVar2 = cVarB.c;
        if (cVar2 != null) {
            cVar2.d = cVar;
        } else {
            this.b = cVar;
        }
        cVarB.c = null;
        cVarB.d = null;
        return cVarB.b;
    }

    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += ((Map.Entry) it.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.a, this.b);
        this.c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
