package androidx.camera.core;

/* JADX INFO: loaded from: classes.dex */
final class e extends CameraState {
    private final CameraState.Type a;
    private final CameraState.a b;

    e(CameraState.Type type, CameraState.a aVar) {
        if (type == null) {
            throw new NullPointerException("Null type");
        }
        this.a = type;
        this.b = aVar;
    }

    @Override // androidx.camera.core.CameraState
    public CameraState.a c() {
        return this.b;
    }

    @Override // androidx.camera.core.CameraState
    public CameraState.Type d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraState)) {
            return false;
        }
        CameraState cameraState = (CameraState) obj;
        if (this.a.equals(cameraState.d())) {
            CameraState.a aVar = this.b;
            if (aVar == null) {
                if (cameraState.c() == null) {
                    return true;
                }
            } else if (aVar.equals(cameraState.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        CameraState.a aVar = this.b;
        return iHashCode ^ (aVar == null ? 0 : aVar.hashCode());
    }

    public String toString() {
        return "CameraState{type=" + this.a + ", error=" + this.b + "}";
    }
}
