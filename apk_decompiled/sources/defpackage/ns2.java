package defpackage;

import java.util.Arrays;
import kotlin.collections.d;

/* JADX INFO: loaded from: classes.dex */
public class ns2 implements Cloneable {
    public /* synthetic */ boolean a;
    public /* synthetic */ int[] b;
    public /* synthetic */ Object[] c;
    public /* synthetic */ int d;

    public ns2() {
        this(0, 1, null);
    }

    public void a(int i, Object obj) {
        int i2 = this.d;
        if (i2 != 0 && i <= this.b[i2 - 1]) {
            g(i, obj);
            return;
        }
        if (this.a && i2 >= this.b.length) {
            os2.d(this);
        }
        int i3 = this.d;
        if (i3 >= this.b.length) {
            int iE = r20.e(i3 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.b, iE);
            p31.e(iArrCopyOf, "copyOf(this, newSize)");
            this.b = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.c, iE);
            p31.e(objArrCopyOf, "copyOf(this, newSize)");
            this.c = objArrCopyOf;
        }
        this.b[i3] = i;
        this.c[i3] = obj;
        this.d = i3 + 1;
    }

    public void b() {
        int i = this.d;
        Object[] objArr = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.d = 0;
        this.a = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ns2 clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        p31.d(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        ns2 ns2Var = (ns2) objClone;
        ns2Var.b = (int[]) this.b.clone();
        ns2Var.c = (Object[]) this.c.clone();
        return ns2Var;
    }

    public Object d(int i) {
        return os2.c(this, i);
    }

    public int e(Object obj) {
        if (this.a) {
            os2.d(this);
        }
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.c[i2] == obj) {
                return i2;
            }
        }
        return -1;
    }

    public int f(int i) {
        if (this.a) {
            os2.d(this);
        }
        return this.b[i];
    }

    public void g(int i, Object obj) {
        int iA = r20.a(this.b, this.d, i);
        if (iA >= 0) {
            this.c[iA] = obj;
            return;
        }
        int i2 = ~iA;
        if (i2 < this.d && this.c[i2] == os2.a) {
            this.b[i2] = i;
            this.c[i2] = obj;
            return;
        }
        if (this.a && this.d >= this.b.length) {
            os2.d(this);
            i2 = ~r20.a(this.b, this.d, i);
        }
        int i3 = this.d;
        if (i3 >= this.b.length) {
            int iE = r20.e(i3 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.b, iE);
            p31.e(iArrCopyOf, "copyOf(this, newSize)");
            this.b = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.c, iE);
            p31.e(objArrCopyOf, "copyOf(this, newSize)");
            this.c = objArrCopyOf;
        }
        int i4 = this.d;
        if (i4 - i2 != 0) {
            int[] iArr = this.b;
            int i5 = i2 + 1;
            d.e(iArr, iArr, i5, i2, i4);
            Object[] objArr = this.c;
            d.g(objArr, objArr, i5, i2, this.d);
        }
        this.b[i2] = i;
        this.c[i2] = obj;
        this.d++;
    }

    public int h() {
        if (this.a) {
            os2.d(this);
        }
        return this.d;
    }

    public Object i(int i) {
        if (this.a) {
            os2.d(this);
        }
        return this.c[i];
    }

    public String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(f(i2));
            sb.append('=');
            Object objI = i(i2);
            if (objI != this) {
                sb.append(objI);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        p31.e(string, "buffer.toString()");
        return string;
    }

    public ns2(int i) {
        if (i == 0) {
            this.b = r20.a;
            this.c = r20.c;
        } else {
            int iE = r20.e(i);
            this.b = new int[iE];
            this.c = new Object[iE];
        }
    }

    public /* synthetic */ ns2(int i, int i2, y70 y70Var) {
        this((i2 & 1) != 0 ? 10 : i);
    }
}
