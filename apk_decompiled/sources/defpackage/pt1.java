package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class pt1 {
    private static int g;
    private int a;
    private int b;
    private Object[] c;
    private int d;
    private a e;
    private float f;

    public static abstract class a {
        public static int b = -1;
        int a = b;

        protected abstract a a();
    }

    private pt1(int i, a aVar) {
        if (i <= 0) {
            throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
        }
        this.b = i;
        this.c = new Object[i];
        this.d = 0;
        this.e = aVar;
        this.f = 1.0f;
        d();
    }

    public static synchronized pt1 a(int i, a aVar) {
        pt1 pt1Var;
        pt1Var = new pt1(i, aVar);
        int i2 = g;
        pt1Var.a = i2;
        g = i2 + 1;
        return pt1Var;
    }

    private void d() {
        e(this.f);
    }

    private void e(float f) {
        int i = this.b;
        int i2 = (int) (i * f);
        if (i2 < 1) {
            i = 1;
        } else if (i2 <= i) {
            i = i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.c[i3] = this.e.a();
        }
        this.d = i - 1;
    }

    private void f() {
        int i = this.b;
        int i2 = i * 2;
        this.b = i2;
        Object[] objArr = new Object[i2];
        for (int i3 = 0; i3 < i; i3++) {
            objArr[i3] = this.c[i3];
        }
        this.c = objArr;
    }

    public synchronized a b() {
        a aVar;
        try {
            if (this.d == -1 && this.f > 0.0f) {
                d();
            }
            Object[] objArr = this.c;
            int i = this.d;
            aVar = (a) objArr[i];
            aVar.a = a.b;
            this.d = i - 1;
        } catch (Throwable th) {
            throw th;
        }
        return aVar;
    }

    public synchronized void c(a aVar) {
        try {
            int i = aVar.a;
            if (i != a.b) {
                if (i == this.a) {
                    throw new IllegalArgumentException("The object passed is already stored in this pool!");
                }
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + aVar.a + ".  Object cannot belong to two different pool instances simultaneously!");
            }
            int i2 = this.d + 1;
            this.d = i2;
            if (i2 >= this.c.length) {
                f();
            }
            aVar.a = this.a;
            this.c[this.d] = aVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0006 A[PHI: r0
      0x0006: PHI (r0v2 float) = (r0v0 float), (r0v1 float) binds: [B:3:0x0004, B:6:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    public void g(float f) {
        float f2 = 1.0f;
        if (f > 1.0f) {
            f = f2;
        } else {
            f2 = 0.0f;
            if (f < 0.0f) {
                f = f2;
            }
        }
        this.f = f;
    }
}
