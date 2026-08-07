package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class c31 implements Iterable, k81 {
    public static final a d = new a(null);
    private final int a;
    private final int b;
    private final int c;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final c31 a(int i, int i2, int i3) {
            return new c31(i, i2, i3);
        }

        private a() {
        }
    }

    public c31(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.a = i;
        this.b = f82.b(i, i2, i3);
        this.c = i3;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public b31 iterator() {
        return new d31(this.a, this.b, this.c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c31) {
            if (!isEmpty() || !((c31) obj).isEmpty()) {
                c31 c31Var = (c31) obj;
                if (this.a != c31Var.a || this.b != c31Var.b || this.c != c31Var.c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public boolean isEmpty() {
        if (this.c > 0) {
            if (this.a <= this.b) {
                return false;
            }
        } else if (this.a >= this.b) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.c > 0) {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append("..");
            sb.append(this.b);
            sb.append(" step ");
            i = this.c;
        } else {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" downTo ");
            sb.append(this.b);
            sb.append(" step ");
            i = -this.c;
        }
        sb.append(i);
        return sb.toString();
    }
}
