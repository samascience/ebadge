package androidx.camera.camera2.internal;

import android.util.Size;
import androidx.camera.core.impl.SessionConfig;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class b extends Camera2CameraImpl.j {
    private final String a;
    private final Class b;
    private final SessionConfig c;
    private final androidx.camera.core.impl.d0 d;
    private final Size e;
    private final androidx.camera.core.impl.x f;
    private final List g;

    b(String str, Class cls, SessionConfig sessionConfig, androidx.camera.core.impl.d0 d0Var, Size size, androidx.camera.core.impl.x xVar, List list) {
        if (str == null) {
            throw new NullPointerException("Null useCaseId");
        }
        this.a = str;
        if (cls == null) {
            throw new NullPointerException("Null useCaseType");
        }
        this.b = cls;
        if (sessionConfig == null) {
            throw new NullPointerException("Null sessionConfig");
        }
        this.c = sessionConfig;
        if (d0Var == null) {
            throw new NullPointerException("Null useCaseConfig");
        }
        this.d = d0Var;
        this.e = size;
        this.f = xVar;
        this.g = list;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.j
    List c() {
        return this.g;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.j
    SessionConfig d() {
        return this.c;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.j
    androidx.camera.core.impl.x e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        Size size;
        androidx.camera.core.impl.x xVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Camera2CameraImpl.j)) {
            return false;
        }
        Camera2CameraImpl.j jVar = (Camera2CameraImpl.j) obj;
        if (this.a.equals(jVar.h()) && this.b.equals(jVar.i()) && this.c.equals(jVar.d()) && this.d.equals(jVar.g()) && ((size = this.e) != null ? size.equals(jVar.f()) : jVar.f() == null) && ((xVar = this.f) != null ? xVar.equals(jVar.e()) : jVar.e() == null)) {
            List list = this.g;
            if (list == null) {
                if (jVar.c() == null) {
                    return true;
                }
            } else if (list.equals(jVar.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.j
    Size f() {
        return this.e;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.j
    androidx.camera.core.impl.d0 g() {
        return this.d;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.j
    String h() {
        return this.a;
    }

    public int hashCode() {
        int iHashCode = (((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003;
        Size size = this.e;
        int iHashCode2 = (iHashCode ^ (size == null ? 0 : size.hashCode())) * 1000003;
        androidx.camera.core.impl.x xVar = this.f;
        int iHashCode3 = (iHashCode2 ^ (xVar == null ? 0 : xVar.hashCode())) * 1000003;
        List list = this.g;
        return iHashCode3 ^ (list != null ? list.hashCode() : 0);
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.j
    Class i() {
        return this.b;
    }

    public String toString() {
        return "UseCaseInfo{useCaseId=" + this.a + ", useCaseType=" + this.b + ", sessionConfig=" + this.c + ", useCaseConfig=" + this.d + ", surfaceResolution=" + this.e + ", streamSpec=" + this.f + ", captureTypes=" + this.g + "}";
    }
}
