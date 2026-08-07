package defpackage;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.d;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes.dex */
public final class y9 implements Collection, Set, k81 {
    private int[] a;
    private Object[] b;
    private int c;

    private final class a extends a21 {
        public a() {
            super(y9.this.e());
        }

        @Override // defpackage.a21
        protected Object a(int i) {
            return y9.this.j(i);
        }

        @Override // defpackage.a21
        protected void b(int i) {
            y9.this.f(i);
        }
    }

    public y9() {
        this(0, 1, null);
    }

    public final void a(int i) {
        int iE = e();
        if (c().length < i) {
            int[] iArrC = c();
            Object[] objArrB = b();
            aa.a(this, i);
            if (e() > 0) {
                d.i(iArrC, c(), 0, 0, e(), 6, null);
                d.j(objArrB, b(), 0, 0, e(), 6, null);
            }
        }
        if (e() != iE) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i;
        int iC;
        int iE = e();
        if (obj == null) {
            iC = aa.d(this);
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iC = aa.c(this, obj, iHashCode);
        }
        if (iC >= 0) {
            return false;
        }
        int i2 = ~iC;
        if (iE >= c().length) {
            int i3 = 8;
            if (iE >= 8) {
                i3 = (iE >> 1) + iE;
            } else if (iE < 4) {
                i3 = 4;
            }
            int[] iArrC = c();
            Object[] objArrB = b();
            aa.a(this, i3);
            if (iE != e()) {
                throw new ConcurrentModificationException();
            }
            if (!(c().length == 0)) {
                d.i(iArrC, c(), 0, 0, iArrC.length, 6, null);
                d.j(objArrB, b(), 0, 0, objArrB.length, 6, null);
            }
        }
        if (i2 < iE) {
            int i4 = i2 + 1;
            d.e(c(), c(), i4, i2, iE);
            d.g(b(), b(), i4, i2, iE);
        }
        if (iE != e() || i2 >= c().length) {
            throw new ConcurrentModificationException();
        }
        c()[i2] = i;
        b()[i2] = obj;
        i(e() + 1);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        p31.f(collection, "elements");
        a(e() + collection.size());
        Iterator it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final Object[] b() {
        return this.b;
    }

    public final int[] c() {
        return this.a;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (e() != 0) {
            h(r20.a);
            g(r20.c);
            i(0);
        }
        if (e() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        p31.f(collection, "elements");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int d() {
        return this.c;
    }

    public final int e() {
        return this.c;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Set) && size() == ((Set) obj).size()) {
            try {
                int iE = e();
                for (int i = 0; i < iE; i++) {
                    if (((Set) obj).contains(j(i))) {
                    }
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public final Object f(int i) {
        int iE = e();
        Object obj = b()[i];
        if (iE <= 1) {
            clear();
        } else {
            int i2 = iE - 1;
            if (c().length <= 8 || e() >= c().length / 3) {
                if (i < i2) {
                    int i3 = i + 1;
                    d.e(c(), c(), i, i3, iE);
                    d.g(b(), b(), i, i3, iE);
                }
                b()[i2] = null;
            } else {
                int iE2 = e() > 8 ? e() + (e() >> 1) : 8;
                int[] iArrC = c();
                Object[] objArrB = b();
                aa.a(this, iE2);
                if (i > 0) {
                    d.i(iArrC, c(), 0, 0, i, 6, null);
                    d.j(objArrB, b(), 0, 0, i, 6, null);
                }
                if (i < i2) {
                    int i4 = i + 1;
                    d.e(iArrC, c(), i, i4, iE);
                    d.g(objArrB, b(), i, i4, iE);
                }
            }
            if (iE != e()) {
                throw new ConcurrentModificationException();
            }
            i(i2);
        }
        return obj;
    }

    public final void g(Object[] objArr) {
        p31.f(objArr, "<set-?>");
        this.b = objArr;
    }

    public final void h(int[] iArr) {
        p31.f(iArr, "<set-?>");
        this.a = iArr;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArrC = c();
        int iE = e();
        int i = 0;
        for (int i2 = 0; i2 < iE; i2++) {
            i += iArrC[i2];
        }
        return i;
    }

    public final void i(int i) {
        this.c = i;
    }

    public final int indexOf(Object obj) {
        return obj == null ? aa.d(this) : aa.c(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return e() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new a();
    }

    public final Object j(int i) {
        return b()[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        f(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        p31.f(collection, "elements");
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        p31.f(collection, "elements");
        boolean z = false;
        for (int iE = e() - 1; -1 < iE; iE--) {
            if (!j.D(collection, b()[iE])) {
                f(iE);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return d();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return d.l(this.b, 0, this.c);
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(e() * 14);
        sb.append('{');
        int iE = e();
        for (int i = 0; i < iE; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object objJ = j(i);
            if (objJ != this) {
                sb.append(objJ);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        p31.e(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public y9(int i) {
        this.a = r20.a;
        this.b = r20.c;
        if (i > 0) {
            aa.a(this, i);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        p31.f(objArr, "array");
        Object[] objArrA = z9.a(objArr, this.c);
        d.g(this.b, objArrA, 0, 0, this.c);
        p31.e(objArrA, "result");
        return objArrA;
    }

    public /* synthetic */ y9(int i, int i2, y70 y70Var) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
