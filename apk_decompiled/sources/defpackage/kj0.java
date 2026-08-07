package defpackage;

/* JADX INFO: loaded from: classes3.dex */
final class kj0 {
    private final boolean a;
    private final x50 b;
    private final x50 c;
    private final mn0 d;

    kj0(x50 x50Var, x50 x50Var2, mn0 mn0Var, boolean z) {
        this.b = x50Var;
        this.c = x50Var2;
        this.d = mn0Var;
        this.a = z;
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    mn0 b() {
        return this.d;
    }

    x50 c() {
        return this.b;
    }

    x50 d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof kj0)) {
            return false;
        }
        kj0 kj0Var = (kj0) obj;
        return a(this.b, kj0Var.b) && a(this.c, kj0Var.c) && a(this.d, kj0Var.d);
    }

    public boolean f() {
        return this.c == null;
    }

    public int hashCode() {
        return (e(this.b) ^ e(this.c)) ^ e(this.d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.b);
        sb.append(" , ");
        sb.append(this.c);
        sb.append(" : ");
        mn0 mn0Var = this.d;
        sb.append(mn0Var == null ? "null" : Integer.valueOf(mn0Var.c()));
        sb.append(" ]");
        return sb.toString();
    }
}
