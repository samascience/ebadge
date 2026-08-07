package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class q62 {
    protected Object a;
    protected a b;
    protected a c;
    protected int d;

    static final class a {
        final Object a;
        final int b;
        a c;

        public a(Object obj, int i) {
            this.a = obj;
            this.b = i;
        }

        public int a(Object obj, int i) {
            System.arraycopy(this.a, 0, obj, i, this.b);
            return i + this.b;
        }

        public Object b() {
            return this.a;
        }

        public void c(a aVar) {
            if (this.c != null) {
                throw new IllegalStateException();
            }
            this.c = aVar;
        }

        public a d() {
            return this.c;
        }
    }

    protected q62() {
    }

    protected abstract Object a(int i);

    protected void b() {
        a aVar = this.c;
        if (aVar != null) {
            this.a = aVar.b();
        }
        this.c = null;
        this.b = null;
        this.d = 0;
    }

    public final Object c(Object obj, int i) {
        a aVar = new a(obj, i);
        if (this.b == null) {
            this.c = aVar;
            this.b = aVar;
        } else {
            this.c.c(aVar);
            this.c = aVar;
        }
        this.d += i;
        return a(i < 16384 ? i + i : i + (i >> 2));
    }

    public int d() {
        return this.d;
    }

    public Object e(Object obj, int i) {
        int i2 = this.d + i;
        Object objA = a(i2);
        int iA = 0;
        for (a aVarD = this.b; aVarD != null; aVarD = aVarD.d()) {
            iA = aVarD.a(objA, iA);
        }
        System.arraycopy(obj, 0, objA, iA, i);
        int i3 = iA + i;
        if (i3 == i2) {
            return objA;
        }
        throw new IllegalStateException("Should have gotten " + i2 + " entries, got " + i3);
    }

    public Object f() {
        b();
        Object obj = this.a;
        return obj == null ? a(12) : obj;
    }
}
