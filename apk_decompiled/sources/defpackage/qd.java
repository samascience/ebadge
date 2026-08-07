package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class qd extends kx2.a {
    private final int a;
    private final kx2 b;

    qd(int i, kx2 kx2Var) {
        this.a = i;
        if (kx2Var == null) {
            throw new NullPointerException("Null surfaceOutput");
        }
        this.b = kx2Var;
    }

    @Override // kx2.a
    public int a() {
        return this.a;
    }

    @Override // kx2.a
    public kx2 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof kx2.a)) {
            return false;
        }
        kx2.a aVar = (kx2.a) obj;
        return this.a == aVar.a() && this.b.equals(aVar.b());
    }

    public int hashCode() {
        return ((this.a ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "Event{eventCode=" + this.a + ", surfaceOutput=" + this.b + "}";
    }
}
