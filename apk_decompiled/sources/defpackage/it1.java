package defpackage;

import java.lang.reflect.Array;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class it1 {
    private pb1 a;
    private pb1 b;
    private int c;
    private Object[] d;

    protected final void a(Object obj, int i, Object[] objArr, int i2) {
        int i3 = 0;
        for (pb1 pb1VarC = this.a; pb1VarC != null; pb1VarC = pb1VarC.c()) {
            Object[] objArr2 = (Object[]) pb1VarC.d();
            int length = objArr2.length;
            System.arraycopy(objArr2, 0, obj, i3, length);
            i3 += length;
        }
        System.arraycopy(objArr, 0, obj, i3, i2);
        int i4 = i3 + i2;
        if (i4 == i) {
            return;
        }
        throw new IllegalStateException("Should have gotten " + i + " entries, got " + i4);
    }

    protected void b() {
        pb1 pb1Var = this.b;
        if (pb1Var != null) {
            this.d = (Object[]) pb1Var.d();
        }
        this.b = null;
        this.a = null;
        this.c = 0;
    }

    public Object[] c(Object[] objArr) {
        pb1 pb1Var = new pb1(objArr, null);
        if (this.a == null) {
            this.b = pb1Var;
            this.a = pb1Var;
        } else {
            this.b.b(pb1Var);
            this.b = pb1Var;
        }
        int length = objArr.length;
        this.c += length;
        if (length < 16384) {
            length += length;
        } else if (length < 262144) {
            length += length >> 2;
        }
        return new Object[length];
    }

    public int d() {
        return this.c;
    }

    public void e(Object[] objArr, int i, List list) {
        int i2;
        pb1 pb1VarC = this.a;
        while (true) {
            i2 = 0;
            if (pb1VarC == null) {
                break;
            }
            Object[] objArr2 = (Object[]) pb1VarC.d();
            int length = objArr2.length;
            while (i2 < length) {
                list.add(objArr2[i2]);
                i2++;
            }
            pb1VarC = pb1VarC.c();
        }
        while (i2 < i) {
            list.add(objArr[i2]);
            i2++;
        }
        b();
    }

    public Object[] f(Object[] objArr, int i) {
        int i2 = this.c + i;
        Object[] objArr2 = new Object[i2];
        a(objArr2, i2, objArr, i);
        b();
        return objArr2;
    }

    public Object[] g(Object[] objArr, int i, Class cls) {
        int i2 = this.c + i;
        Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) cls, i2);
        a(objArr2, i2, objArr, i);
        b();
        return objArr2;
    }

    public int h() {
        Object[] objArr = this.d;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    public Object[] i() {
        b();
        Object[] objArr = this.d;
        if (objArr != null) {
            return objArr;
        }
        Object[] objArr2 = new Object[12];
        this.d = objArr2;
        return objArr2;
    }

    public Object[] j(Object[] objArr, int i) {
        b();
        Object[] objArr2 = this.d;
        if (objArr2 == null || objArr2.length < i) {
            this.d = new Object[Math.max(12, i)];
        }
        System.arraycopy(objArr, 0, this.d, 0, i);
        return this.d;
    }
}
