package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 {
    private final int a;
    private final String b;
    private final String c;

    public j0(int i, String str, String str2) {
        p31.f(str, "name");
        p31.f(str2, "password");
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return this.a == j0Var.a && p31.a(this.b, j0Var.b) && p31.a(this.c, j0Var.c);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "AIGlassesWanWifiInfo(id=" + this.a + ", name=" + this.b + ", password=" + this.c + ")";
    }
}
