package androidx.camera.core;

import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
final class g extends SurfaceRequest.f {
    private final int a;
    private final Surface b;

    g(int i, Surface surface) {
        this.a = i;
        if (surface == null) {
            throw new NullPointerException("Null surface");
        }
        this.b = surface;
    }

    @Override // androidx.camera.core.SurfaceRequest.f
    public int a() {
        return this.a;
    }

    @Override // androidx.camera.core.SurfaceRequest.f
    public Surface b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceRequest.f)) {
            return false;
        }
        SurfaceRequest.f fVar = (SurfaceRequest.f) obj;
        return this.a == fVar.a() && this.b.equals(fVar.b());
    }

    public int hashCode() {
        return ((this.a ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "Result{resultCode=" + this.a + ", surface=" + this.b + "}";
    }
}
