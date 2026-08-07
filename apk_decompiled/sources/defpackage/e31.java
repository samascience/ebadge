package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public final class e31 extends c31 {
    public static final a e = new a(null);
    private static final e31 f = new e31(1, 0);

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final e31 a() {
            return e31.f;
        }

        private a() {
        }
    }

    public e31(int i, int i2) {
        super(i, i2, 1);
    }

    @Override // defpackage.c31
    public boolean equals(Object obj) {
        if (obj instanceof e31) {
            if (!isEmpty() || !((e31) obj).isEmpty()) {
                e31 e31Var = (e31) obj;
                if (a() != e31Var.a() || b() != e31Var.b()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean f(int i) {
        return a() <= i && i <= b();
    }

    public Integer g() {
        return Integer.valueOf(b());
    }

    public Integer h() {
        return Integer.valueOf(a());
    }

    @Override // defpackage.c31
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // defpackage.c31
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // defpackage.c31
    public String toString() {
        return a() + ".." + b();
    }
}
