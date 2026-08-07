package defpackage;

import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
public final class aw2 {
    private final String a;
    private final String b;
    private final String c;
    private final boolean d;
    private final int e;

    public aw2(String str, String str2, String str3, boolean z, int i) {
        p31.f(str, "id");
        p31.f(str2, "imageUrl");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
        this.e = i;
    }

    public static /* synthetic */ aw2 b(aw2 aw2Var, String str, String str2, String str3, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = aw2Var.a;
        }
        if ((i2 & 2) != 0) {
            str2 = aw2Var.b;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = aw2Var.c;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            z = aw2Var.d;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            i = aw2Var.e;
        }
        return aw2Var.a(str, str4, str5, z2, i);
    }

    public final aw2 a(String str, String str2, String str3, boolean z, int i) {
        p31.f(str, "id");
        p31.f(str2, "imageUrl");
        return new aw2(str, str2, str3, z, i);
    }

    public final String c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aw2)) {
            return false;
        }
        aw2 aw2Var = (aw2) obj;
        return p31.a(this.a, aw2Var.a) && p31.a(this.b, aw2Var.b) && p31.a(this.c, aw2Var.c) && this.d == aw2Var.d && this.e == aw2Var.e;
    }

    public final Integer f() {
        if (j()) {
            return Integer.valueOf(Integer.parseInt(this.b));
        }
        return null;
    }

    public final int g() {
        return this.e;
    }

    public final String h() {
        int i = this.e;
        if (i == 1) {
            return "边框";
        }
        if (i != 2) {
            return i != 3 ? "未知" : "时间样式";
        }
        return "贴纸";
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
    }

    public final boolean i() {
        return this.e == 1;
    }

    public final boolean j() {
        return new Regex("^\\d+$").matches(this.b);
    }

    public final boolean k() {
        return this.d;
    }

    public final boolean l() {
        return this.e == 2;
    }

    public String toString() {
        return "StyleItem(id=" + this.a + ", imageUrl=" + this.b + ", name=" + this.c + ", isSelected=" + this.d + ", type=" + this.e + ")";
    }

    public /* synthetic */ aw2(String str, String str2, String str3, boolean z, int i, int i2, y70 y70Var) {
        this(str, str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? 0 : i);
    }
}
