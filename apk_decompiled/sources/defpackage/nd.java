package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class nd extends j72.a {
    private final bf0 a;
    private final bf0 b;
    private final int c;
    private final int d;

    nd(bf0 bf0Var, bf0 bf0Var2, int i, int i2) {
        if (bf0Var == null) {
            throw new NullPointerException("Null edge");
        }
        this.a = bf0Var;
        if (bf0Var2 == null) {
            throw new NullPointerException("Null postviewEdge");
        }
        this.b = bf0Var2;
        this.c = i;
        this.d = i2;
    }

    @Override // j72.a
    bf0 a() {
        return this.a;
    }

    @Override // j72.a
    int b() {
        return this.c;
    }

    @Override // j72.a
    int c() {
        return this.d;
    }

    @Override // j72.a
    bf0 d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j72.a)) {
            return false;
        }
        j72.a aVar = (j72.a) obj;
        return this.a.equals(aVar.a()) && this.b.equals(aVar.d()) && this.c == aVar.b() && this.d == aVar.c();
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c) * 1000003) ^ this.d;
    }

    public String toString() {
        return "In{edge=" + this.a + ", postviewEdge=" + this.b + ", inputFormat=" + this.c + ", outputFormat=" + this.d + "}";
    }
}
