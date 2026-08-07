package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class fd extends fz0.a {
    private final xy1 a;
    private final int b;

    fd(xy1 xy1Var, int i) {
        if (xy1Var == null) {
            throw new NullPointerException("Null packet");
        }
        this.a = xy1Var;
        this.b = i;
    }

    @Override // fz0.a
    int a() {
        return this.b;
    }

    @Override // fz0.a
    xy1 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fz0.a)) {
            return false;
        }
        fz0.a aVar = (fz0.a) obj;
        return this.a.equals(aVar.b()) && this.b == aVar.a();
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b;
    }

    public String toString() {
        return "In{packet=" + this.a + ", jpegQuality=" + this.b + "}";
    }
}
