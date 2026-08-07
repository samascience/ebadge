package defpackage;

import androidx.camera.core.u;

/* JADX INFO: loaded from: classes.dex */
final class id extends y41.a {
    private final xy1 a;
    private final u.g b;

    id(xy1 xy1Var, u.g gVar) {
        if (xy1Var == null) {
            throw new NullPointerException("Null packet");
        }
        this.a = xy1Var;
        if (gVar == null) {
            throw new NullPointerException("Null outputFileOptions");
        }
        this.b = gVar;
    }

    @Override // y41.a
    u.g a() {
        return this.b;
    }

    @Override // y41.a
    xy1 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y41.a)) {
            return false;
        }
        y41.a aVar = (y41.a) obj;
        return this.a.equals(aVar.b()) && this.b.equals(aVar.a());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "In{packet=" + this.a + ", outputFileOptions=" + this.b + "}";
    }
}
