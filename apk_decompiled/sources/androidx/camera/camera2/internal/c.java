package androidx.camera.camera2.internal;

/* JADX INFO: loaded from: classes.dex */
final class c extends s2.b {
    private final int a;
    private final int b;
    private final boolean c;
    private final boolean d;

    c(int i, int i2, boolean z, boolean z2) {
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = z2;
    }

    @Override // androidx.camera.camera2.internal.s2.b
    int a() {
        return this.a;
    }

    @Override // androidx.camera.camera2.internal.s2.b
    int b() {
        return this.b;
    }

    @Override // androidx.camera.camera2.internal.s2.b
    boolean c() {
        return this.c;
    }

    @Override // androidx.camera.camera2.internal.s2.b
    boolean d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s2.b)) {
            return false;
        }
        s2.b bVar = (s2.b) obj;
        return this.a == bVar.a() && this.b == bVar.b() && this.c == bVar.c() && this.d == bVar.d();
    }

    public int hashCode() {
        return ((((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ (this.c ? 1231 : 1237)) * 1000003) ^ (this.d ? 1231 : 1237);
    }

    public String toString() {
        return "FeatureSettings{cameraMode=" + this.a + ", requiredMaxBitDepth=" + this.b + ", previewStabilizationOn=" + this.c + ", ultraHdrOn=" + this.d + "}";
    }
}
