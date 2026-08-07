package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class vd1 {
    private a[] a;
    private int b;
    private int c;
    private int d;

    static final class a {
        final long a;
        Object b;
        a c;

        a(long j, Object obj, a aVar) {
            this.a = j;
            this.b = obj;
            this.c = aVar;
        }
    }

    public vd1() {
        this(16);
    }

    public void a() {
        this.d = 0;
        Arrays.fill(this.a, (Object) null);
    }

    public Object b(long j) {
        for (a aVar = this.a[((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % this.b]; aVar != null; aVar = aVar.c) {
            if (aVar.a == j) {
                return aVar.b;
            }
        }
        return null;
    }

    public Object c(long j, Object obj) {
        int i = ((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % this.b;
        a aVar = this.a[i];
        for (a aVar2 = aVar; aVar2 != null; aVar2 = aVar2.c) {
            if (aVar2.a == j) {
                Object obj2 = aVar2.b;
                aVar2.b = obj;
                return obj2;
            }
        }
        this.a[i] = new a(j, obj, aVar);
        int i2 = this.d + 1;
        this.d = i2;
        if (i2 <= this.c) {
            return null;
        }
        f(this.b * 2);
        return null;
    }

    public Object d(long j) {
        int i = ((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % this.b;
        a aVar = this.a[i];
        a aVar2 = null;
        while (aVar != null) {
            a aVar3 = aVar.c;
            if (aVar.a == j) {
                if (aVar2 == null) {
                    this.a[i] = aVar3;
                } else {
                    aVar2.c = aVar3;
                }
                this.d--;
                return aVar.b;
            }
            aVar2 = aVar;
            aVar = aVar3;
        }
        return null;
    }

    public void e(int i) {
        f((i * 5) / 3);
    }

    public void f(int i) {
        a[] aVarArr = new a[i];
        int length = this.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            a aVar = this.a[i2];
            while (aVar != null) {
                long j = aVar.a;
                int i3 = ((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % i;
                a aVar2 = aVar.c;
                aVar.c = aVarArr[i3];
                aVarArr[i3] = aVar;
                aVar = aVar2;
            }
        }
        this.a = aVarArr;
        this.b = i;
        this.c = (i * 4) / 3;
    }

    public vd1(int i) {
        this.b = i;
        this.c = (i * 4) / 3;
        this.a = new a[i];
    }
}
