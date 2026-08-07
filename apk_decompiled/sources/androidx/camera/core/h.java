package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
final class h extends SurfaceRequest.g {
    private final Rect a;
    private final int b;
    private final int c;
    private final boolean d;
    private final Matrix e;
    private final boolean f;

    h(Rect rect, int i, int i2, boolean z, Matrix matrix, boolean z2) {
        if (rect == null) {
            throw new NullPointerException("Null getCropRect");
        }
        this.a = rect;
        this.b = i;
        this.c = i2;
        this.d = z;
        if (matrix == null) {
            throw new NullPointerException("Null getSensorToBufferTransform");
        }
        this.e = matrix;
        this.f = z2;
    }

    @Override // androidx.camera.core.SurfaceRequest.g
    public Rect a() {
        return this.a;
    }

    @Override // androidx.camera.core.SurfaceRequest.g
    public int b() {
        return this.b;
    }

    @Override // androidx.camera.core.SurfaceRequest.g
    public Matrix c() {
        return this.e;
    }

    @Override // androidx.camera.core.SurfaceRequest.g
    public int d() {
        return this.c;
    }

    @Override // androidx.camera.core.SurfaceRequest.g
    public boolean e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceRequest.g)) {
            return false;
        }
        SurfaceRequest.g gVar = (SurfaceRequest.g) obj;
        return this.a.equals(gVar.a()) && this.b == gVar.b() && this.c == gVar.d() && this.d == gVar.e() && this.e.equals(gVar.c()) && this.f == gVar.f();
    }

    @Override // androidx.camera.core.SurfaceRequest.g
    public boolean f() {
        return this.f;
    }

    public int hashCode() {
        return ((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ (this.d ? 1231 : 1237)) * 1000003) ^ this.e.hashCode()) * 1000003) ^ (this.f ? 1231 : 1237);
    }

    public String toString() {
        return "TransformationInfo{getCropRect=" + this.a + ", getRotationDegrees=" + this.b + ", getTargetRotation=" + this.c + ", hasCameraTransform=" + this.d + ", getSensorToBufferTransform=" + this.e + ", isMirroring=" + this.f + "}";
    }
}
