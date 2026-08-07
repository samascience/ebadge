package androidx.camera.core;

/* JADX INFO: loaded from: classes.dex */
final class f extends CameraState.a {
    private final int a;
    private final Throwable b;

    f(int i, Throwable th) {
        this.a = i;
        this.b = th;
    }

    @Override // androidx.camera.core.CameraState.a
    public Throwable c() {
        return this.b;
    }

    @Override // androidx.camera.core.CameraState.a
    public int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraState.a)) {
            return false;
        }
        CameraState.a aVar = (CameraState.a) obj;
        if (this.a == aVar.d()) {
            Throwable th = this.b;
            if (th == null) {
                if (aVar.c() == null) {
                    return true;
                }
            } else if (th.equals(aVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (this.a ^ 1000003) * 1000003;
        Throwable th = this.b;
        return i ^ (th == null ? 0 : th.hashCode());
    }

    public String toString() {
        return "StateError{code=" + this.a + ", cause=" + this.b + "}";
    }
}
