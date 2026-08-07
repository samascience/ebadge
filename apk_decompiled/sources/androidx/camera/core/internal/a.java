package androidx.camera.core.internal;

import defpackage.az0;

/* JADX INFO: loaded from: classes.dex */
final class a extends CameraUseCaseAdapter.a {
    private final String a;
    private final az0 b;

    a(String str, az0 az0Var) {
        if (str == null) {
            throw new NullPointerException("Null cameraIdString");
        }
        this.a = str;
        if (az0Var == null) {
            throw new NullPointerException("Null cameraConfigId");
        }
        this.b = az0Var;
    }

    @Override // androidx.camera.core.internal.CameraUseCaseAdapter.a
    public az0 b() {
        return this.b;
    }

    @Override // androidx.camera.core.internal.CameraUseCaseAdapter.a
    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraUseCaseAdapter.a)) {
            return false;
        }
        CameraUseCaseAdapter.a aVar = (CameraUseCaseAdapter.a) obj;
        return this.a.equals(aVar.c()) && this.b.equals(aVar.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "CameraId{cameraIdString=" + this.a + ", cameraConfigId=" + this.b + "}";
    }
}
