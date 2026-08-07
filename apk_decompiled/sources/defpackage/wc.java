package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class wc extends zh.b {
    private final xy1 a;
    private final int b;

    wc(xy1 xy1Var, int i) {
        if (xy1Var == null) {
            throw new NullPointerException("Null packet");
        }
        this.a = xy1Var;
        this.b = i;
    }

    @Override // zh.b
    int a() {
        return this.b;
    }

    @Override // zh.b
    xy1 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zh.b)) {
            return false;
        }
        zh.b bVar = (zh.b) obj;
        return this.a.equals(bVar.b()) && this.b == bVar.a();
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b;
    }

    public String toString() {
        return "In{packet=" + this.a + ", jpegQuality=" + this.b + "}";
    }
}
