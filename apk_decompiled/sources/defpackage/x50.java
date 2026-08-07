package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class x50 {
    private final int a;
    private final int b;

    public x50(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof x50)) {
            return false;
        }
        x50 x50Var = (x50) obj;
        return this.a == x50Var.a && this.b == x50Var.b;
    }

    public final int hashCode() {
        return this.a ^ this.b;
    }

    public final String toString() {
        return this.a + "(" + this.b + ')';
    }
}
