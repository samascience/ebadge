package defpackage;

import java.util.Arrays;
import kotlin.collections.d;

/* JADX INFO: loaded from: classes.dex */
public class zd1 implements Cloneable {
    public /* synthetic */ boolean a;
    public /* synthetic */ long[] b;
    public /* synthetic */ Object[] c;
    public /* synthetic */ int d;

    public zd1() {
        this(0, 1, null);
    }

    public void a() {
        int i = this.d;
        Object[] objArr = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.d = 0;
        this.a = false;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public zd1 clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        p31.d(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        zd1 zd1Var = (zd1) objClone;
        zd1Var.b = (long[]) this.b.clone();
        zd1Var.c = (Object[]) this.c.clone();
        return zd1Var;
    }

    public Object c(long j) {
        int iB = r20.b(this.b, this.d, j);
        if (iB < 0 || this.c[iB] == ae1.a) {
            return null;
        }
        return this.c[iB];
    }

    public int d(long j) {
        if (this.a) {
            int i = this.d;
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != ae1.a) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.a = false;
            this.d = i2;
        }
        return r20.b(this.b, this.d, j);
    }

    public long e(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.d)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i).toString());
        }
        if (this.a) {
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != ae1.a) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.a = false;
            this.d = i3;
        }
        return this.b[i];
    }

    public void f(long j, Object obj) {
        int iB = r20.b(this.b, this.d, j);
        if (iB >= 0) {
            this.c[iB] = obj;
            return;
        }
        int i = ~iB;
        if (i < this.d && this.c[i] == ae1.a) {
            this.b[i] = j;
            this.c[i] = obj;
            return;
        }
        if (this.a) {
            int i2 = this.d;
            long[] jArr = this.b;
            if (i2 >= jArr.length) {
                Object[] objArr = this.c;
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    Object obj2 = objArr[i4];
                    if (obj2 != ae1.a) {
                        if (i4 != i3) {
                            jArr[i3] = jArr[i4];
                            objArr[i3] = obj2;
                            objArr[i4] = null;
                        }
                        i3++;
                    }
                }
                this.a = false;
                this.d = i3;
                i = ~r20.b(this.b, i3, j);
            }
        }
        int i5 = this.d;
        if (i5 >= this.b.length) {
            int iF = r20.f(i5 + 1);
            long[] jArrCopyOf = Arrays.copyOf(this.b, iF);
            p31.e(jArrCopyOf, "copyOf(this, newSize)");
            this.b = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.c, iF);
            p31.e(objArrCopyOf, "copyOf(this, newSize)");
            this.c = objArrCopyOf;
        }
        int i6 = this.d;
        if (i6 - i != 0) {
            long[] jArr2 = this.b;
            int i7 = i + 1;
            d.f(jArr2, jArr2, i7, i, i6);
            Object[] objArr2 = this.c;
            d.g(objArr2, objArr2, i7, i, this.d);
        }
        this.b[i] = j;
        this.c[i] = obj;
        this.d++;
    }

    public void g(long j) {
        int iB = r20.b(this.b, this.d, j);
        if (iB < 0 || this.c[iB] == ae1.a) {
            return;
        }
        this.c[iB] = ae1.a;
        this.a = true;
    }

    public void h(int i) {
        if (this.c[i] != ae1.a) {
            this.c[i] = ae1.a;
            this.a = true;
        }
    }

    public int i() {
        if (this.a) {
            int i = this.d;
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != ae1.a) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.a = false;
            this.d = i2;
        }
        return this.d;
    }

    public Object j(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.d)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i).toString());
        }
        if (this.a) {
            long[] jArr = this.b;
            Object[] objArr = this.c;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != ae1.a) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.a = false;
            this.d = i3;
        }
        return this.c[i];
    }

    public String toString() {
        if (i() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(e(i2));
            sb.append('=');
            Object objJ = j(i2);
            if (objJ != sb) {
                sb.append(objJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        p31.e(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public zd1(int i) {
        if (i == 0) {
            this.b = r20.b;
            this.c = r20.c;
        } else {
            int iF = r20.f(i);
            this.b = new long[iF];
            this.c = new Object[iF];
        }
    }

    public /* synthetic */ zd1(int i, int i2, y70 y70Var) {
        this((i2 & 1) != 0 ? 10 : i);
    }
}
