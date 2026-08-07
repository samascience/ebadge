package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public final class nn2 {
    public static final a c = new a(null);
    private int a;
    private final int[] b = new int[10];

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public final int a(int i) {
        return this.b[i];
    }

    public final int b() {
        if ((this.a & 2) != 0) {
            return this.b[1];
        }
        return -1;
    }

    public final int c() {
        if ((this.a & 128) != 0) {
            return this.b[7];
        }
        return 65535;
    }

    public final int d() {
        if ((this.a & 16) != 0) {
            return this.b[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int e(int i) {
        return (this.a & 32) != 0 ? this.b[5] : i;
    }

    public final boolean f(int i) {
        return ((1 << i) & this.a) != 0;
    }

    public final void g(nn2 nn2Var) {
        p31.f(nn2Var, "other");
        for (int i = 0; i < 10; i++) {
            if (nn2Var.f(i)) {
                h(i, nn2Var.a(i));
            }
        }
    }

    public final nn2 h(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.b;
            if (i < iArr.length) {
                this.a = (1 << i) | this.a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    public final int i() {
        return Integer.bitCount(this.a);
    }
}
