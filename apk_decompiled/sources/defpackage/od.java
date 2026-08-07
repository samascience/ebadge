package defpackage;

import androidx.camera.core.v;

/* JADX INFO: loaded from: classes.dex */
final class od extends j72.b {
    private final k72 a;
    private final v b;

    od(k72 k72Var, v vVar) {
        if (k72Var == null) {
            throw new NullPointerException("Null processingRequest");
        }
        this.a = k72Var;
        if (vVar == null) {
            throw new NullPointerException("Null imageProxy");
        }
        this.b = vVar;
    }

    @Override // j72.b
    v a() {
        return this.b;
    }

    @Override // j72.b
    k72 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j72.b)) {
            return false;
        }
        j72.b bVar = (j72.b) obj;
        return this.a.equals(bVar.b()) && this.b.equals(bVar.a());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "InputPacket{processingRequest=" + this.a + ", imageProxy=" + this.b + "}";
    }
}
