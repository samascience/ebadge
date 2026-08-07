package androidx.camera.lifecycle;

import androidx.camera.core.internal.CameraUseCaseAdapter;
import defpackage.db1;

/* JADX INFO: loaded from: classes.dex */
final class a extends LifecycleCameraRepository.a {
    private final db1 a;
    private final CameraUseCaseAdapter.a b;

    a(db1 db1Var, CameraUseCaseAdapter.a aVar) {
        if (db1Var == null) {
            throw new NullPointerException("Null lifecycleOwner");
        }
        this.a = db1Var;
        if (aVar == null) {
            throw new NullPointerException("Null cameraId");
        }
        this.b = aVar;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraRepository.a
    public CameraUseCaseAdapter.a b() {
        return this.b;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraRepository.a
    public db1 c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LifecycleCameraRepository.a)) {
            return false;
        }
        LifecycleCameraRepository.a aVar = (LifecycleCameraRepository.a) obj;
        return this.a.equals(aVar.c()) && this.b.equals(aVar.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "Key{lifecycleOwner=" + this.a + ", cameraId=" + this.b + "}";
    }
}
