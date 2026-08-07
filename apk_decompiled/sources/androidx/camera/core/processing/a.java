package androidx.camera.core.processing;

import defpackage.ix2;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class a extends SurfaceProcessorNode.b {
    private final ix2 a;
    private final List b;

    a(ix2 ix2Var, List list) {
        if (ix2Var == null) {
            throw new NullPointerException("Null surfaceEdge");
        }
        this.a = ix2Var;
        if (list == null) {
            throw new NullPointerException("Null outConfigs");
        }
        this.b = list;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.b
    public List a() {
        return this.b;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.b
    public ix2 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceProcessorNode.b)) {
            return false;
        }
        SurfaceProcessorNode.b bVar = (SurfaceProcessorNode.b) obj;
        return this.a.equals(bVar.b()) && this.b.equals(bVar.a());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "In{surfaceEdge=" + this.a + ", outConfigs=" + this.b + "}";
    }
}
