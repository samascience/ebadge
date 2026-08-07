package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class xv2 {
    private final int a;
    private final String b;
    private final List c;

    public xv2(int i, String str, List list) {
        p31.f(str, "title");
        p31.f(list, "styles");
        this.a = i;
        this.b = str;
        this.c = list;
    }

    public static /* synthetic */ xv2 b(xv2 xv2Var, int i, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = xv2Var.a;
        }
        if ((i2 & 2) != 0) {
            str = xv2Var.b;
        }
        if ((i2 & 4) != 0) {
            list = xv2Var.c;
        }
        return xv2Var.a(i, str, list);
    }

    public final xv2 a(int i, String str, List list) {
        p31.f(str, "title");
        p31.f(list, "styles");
        return new xv2(i, str, list);
    }

    public final List c() {
        return this.c;
    }

    public final String d() {
        return this.b;
    }

    public final int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xv2)) {
            return false;
        }
        xv2 xv2Var = (xv2) obj;
        return this.a == xv2Var.a && p31.a(this.b, xv2Var.b) && p31.a(this.c, xv2Var.c);
    }

    public final boolean f() {
        return !this.c.isEmpty();
    }

    public int hashCode() {
        return (((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "StyleGroup(type=" + this.a + ", title=" + this.b + ", styles=" + this.c + ")";
    }
}
