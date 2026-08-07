package defpackage;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.collections.d;

/* JADX INFO: loaded from: classes.dex */
public class ap2 {
    private int[] a;
    private Object[] b;
    private int c;

    public ap2() {
        this(0, 1, null);
    }

    private final int e(Object obj, int i) {
        int i2 = this.c;
        if (i2 == 0) {
            return -1;
        }
        int iA = r20.a(this.a, i2, i);
        if (iA < 0 || p31.a(obj, this.b[iA << 1])) {
            return iA;
        }
        int i3 = iA + 1;
        while (i3 < i2 && this.a[i3] == i) {
            if (p31.a(obj, this.b[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iA - 1; i4 >= 0 && this.a[i4] == i; i4--) {
            if (p31.a(obj, this.b[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    private final int g() {
        int i = this.c;
        if (i == 0) {
            return -1;
        }
        int iA = r20.a(this.a, i, 0);
        if (iA < 0 || this.b[iA << 1] == null) {
            return iA;
        }
        int i2 = iA + 1;
        while (i2 < i && this.a[i2] == 0) {
            if (this.b[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iA - 1; i3 >= 0 && this.a[i3] == 0; i3--) {
            if (this.b[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public final int c(Object obj) {
        int i = this.c * 2;
        Object[] objArr = this.b;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (p31.a(obj, objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public void clear() {
        if (this.c > 0) {
            this.a = r20.a;
            this.b = r20.c;
            this.c = 0;
        }
        if (this.c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return c(obj) >= 0;
    }

    public void d(int i) {
        int i2 = this.c;
        int[] iArr = this.a;
        if (iArr.length < i) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i);
            p31.e(iArrCopyOf, "copyOf(this, newSize)");
            this.a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.b, i * 2);
            p31.e(objArrCopyOf, "copyOf(this, newSize)");
            this.b = objArrCopyOf;
        }
        if (this.c != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof ap2) {
                if (size() != ((ap2) obj).size()) {
                    return false;
                }
                ap2 ap2Var = (ap2) obj;
                int i = this.c;
                for (int i2 = 0; i2 < i; i2++) {
                    Object objH = h(i2);
                    Object objL = l(i2);
                    Object obj2 = ap2Var.get(objH);
                    if (objL == null) {
                        if (obj2 != null || !ap2Var.containsKey(objH)) {
                            return false;
                        }
                    } else if (!p31.a(objL, obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || size() != ((Map) obj).size()) {
                return false;
            }
            int i3 = this.c;
            for (int i4 = 0; i4 < i3; i4++) {
                Object objH2 = h(i4);
                Object objL2 = l(i4);
                Object obj3 = ((Map) obj).get(objH2);
                if (objL2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objH2)) {
                        return false;
                    }
                } else if (!p31.a(objL2, obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    public Object get(Object obj) {
        int iF = f(obj);
        if (iF >= 0) {
            return this.b[(iF << 1) + 1];
        }
        return null;
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int iF = f(obj);
        return iF >= 0 ? this.b[(iF << 1) + 1] : obj2;
    }

    public Object h(int i) {
        if (i >= 0 && i < this.c) {
            return this.b[i << 1];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i).toString());
    }

    public int hashCode() {
        int[] iArr = this.a;
        Object[] objArr = this.b;
        int i = this.c;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public void i(ap2 ap2Var) {
        p31.f(ap2Var, "map");
        int i = ap2Var.c;
        d(this.c + i);
        if (this.c != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(ap2Var.h(i2), ap2Var.l(i2));
            }
        } else if (i > 0) {
            d.e(ap2Var.a, this.a, 0, 0, i);
            d.g(ap2Var.b, this.b, 0, 0, i << 1);
            this.c = i;
        }
    }

    public boolean isEmpty() {
        return this.c <= 0;
    }

    public Object j(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.c)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i).toString());
        }
        Object[] objArr = this.b;
        int i3 = i << 1;
        Object obj = objArr[i3 + 1];
        if (i2 <= 1) {
            clear();
        } else {
            int i4 = i2 - 1;
            int[] iArr = this.a;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                if (i < i4) {
                    int i5 = i + 1;
                    d.e(iArr, iArr, i, i5, i2);
                    Object[] objArr2 = this.b;
                    d.g(objArr2, objArr2, i3, i5 << 1, i2 << 1);
                }
                Object[] objArr3 = this.b;
                int i6 = i4 << 1;
                objArr3[i6] = null;
                objArr3[i6 + 1] = null;
            } else {
                int i7 = i2 > 8 ? i2 + (i2 >> 1) : 8;
                int[] iArrCopyOf = Arrays.copyOf(iArr, i7);
                p31.e(iArrCopyOf, "copyOf(this, newSize)");
                this.a = iArrCopyOf;
                Object[] objArrCopyOf = Arrays.copyOf(this.b, i7 << 1);
                p31.e(objArrCopyOf, "copyOf(this, newSize)");
                this.b = objArrCopyOf;
                if (i2 != this.c) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    d.e(iArr, this.a, 0, 0, i);
                    d.g(objArr, this.b, 0, 0, i3);
                }
                if (i < i4) {
                    int i8 = i + 1;
                    d.e(iArr, this.a, i, i8, i2);
                    d.g(objArr, this.b, i3, i8 << 1, i2 << 1);
                }
            }
            if (i2 != this.c) {
                throw new ConcurrentModificationException();
            }
            this.c = i4;
        }
        return obj;
    }

    public Object k(int i, Object obj) {
        if (i < 0 || i >= this.c) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i).toString());
        }
        int i2 = (i << 1) + 1;
        Object[] objArr = this.b;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public Object l(int i) {
        if (i >= 0 && i < this.c) {
            return this.b[(i << 1) + 1];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i).toString());
    }

    public Object put(Object obj, Object obj2) {
        int i = this.c;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iE = obj != null ? e(obj, iHashCode) : g();
        if (iE >= 0) {
            int i2 = (iE << 1) + 1;
            Object[] objArr = this.b;
            Object obj3 = objArr[i2];
            objArr[i2] = obj2;
            return obj3;
        }
        int i3 = ~iE;
        int[] iArr = this.a;
        if (i >= iArr.length) {
            int i4 = 8;
            if (i >= 8) {
                i4 = (i >> 1) + i;
            } else if (i < 4) {
                i4 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i4);
            p31.e(iArrCopyOf, "copyOf(this, newSize)");
            this.a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.b, i4 << 1);
            p31.e(objArrCopyOf, "copyOf(this, newSize)");
            this.b = objArrCopyOf;
            if (i != this.c) {
                throw new ConcurrentModificationException();
            }
        }
        if (i3 < i) {
            int[] iArr2 = this.a;
            int i5 = i3 + 1;
            d.e(iArr2, iArr2, i5, i3, i);
            Object[] objArr2 = this.b;
            d.g(objArr2, objArr2, i5 << 1, i3 << 1, this.c << 1);
        }
        int i6 = this.c;
        if (i == i6) {
            int[] iArr3 = this.a;
            if (i3 < iArr3.length) {
                iArr3[i3] = iHashCode;
                Object[] objArr3 = this.b;
                int i7 = i3 << 1;
                objArr3[i7] = obj;
                objArr3[i7 + 1] = obj2;
                this.c = i6 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int iF = f(obj);
        if (iF >= 0) {
            return j(iF);
        }
        return null;
    }

    public Object replace(Object obj, Object obj2) {
        int iF = f(obj);
        if (iF >= 0) {
            return k(iF, obj2);
        }
        return null;
    }

    public int size() {
        return this.c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.c * 28);
        sb.append('{');
        int i = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object objH = h(i2);
            if (objH != sb) {
                sb.append(objH);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objL = l(i2);
            if (objL != sb) {
                sb.append(objL);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        p31.e(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public ap2(int i) {
        this.a = i == 0 ? r20.a : new int[i];
        this.b = i == 0 ? r20.c : new Object[i << 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int iF = f(obj);
        if (iF < 0 || !p31.a(obj2, l(iF))) {
            return false;
        }
        j(iF);
        return true;
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        int iF = f(obj);
        if (iF < 0 || !p31.a(obj2, l(iF))) {
            return false;
        }
        k(iF, obj3);
        return true;
    }

    public /* synthetic */ ap2(int i, int i2, y70 y70Var) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public ap2(ap2 ap2Var) {
        this(0, 1, null);
        if (ap2Var != null) {
            i(ap2Var);
        }
    }
}
