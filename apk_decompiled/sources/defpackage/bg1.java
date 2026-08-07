package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public final class bg1 {
    private final String a;
    private final e31 b;

    public bg1(String str, e31 e31Var) {
        p31.f(str, "value");
        p31.f(e31Var, "range");
        this.a = str;
        this.b = e31Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bg1)) {
            return false;
        }
        bg1 bg1Var = (bg1) obj;
        return p31.a(this.a, bg1Var.a) && p31.a(this.b, bg1Var.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.a + ", range=" + this.b + ')';
    }
}
