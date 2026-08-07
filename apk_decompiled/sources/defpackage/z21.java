package defpackage;

import android.graphics.Insets;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public final class z21 {
    public static final z21 e = new z21(0, 0, 0, 0);
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    static class a {
        static Insets a(int i, int i2, int i3, int i4) {
            return Insets.of(i, i2, i3, i4);
        }
    }

    private z21(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static z21 a(z21 z21Var, z21 z21Var2) {
        return b(Math.max(z21Var.a, z21Var2.a), Math.max(z21Var.b, z21Var2.b), Math.max(z21Var.c, z21Var2.c), Math.max(z21Var.d, z21Var2.d));
    }

    public static z21 b(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? e : new z21(i, i2, i3, i4);
    }

    public static z21 c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static z21 d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.a, this.b, this.c, this.d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z21.class != obj.getClass()) {
            return false;
        }
        z21 z21Var = (z21) obj;
        return this.d == z21Var.d && this.a == z21Var.a && this.c == z21Var.c && this.b == z21Var.b;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        return "Insets{left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + '}';
    }
}
