package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import defpackage.ie0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class b extends a {
    private final SurfaceConfig a;
    private final int b;
    private final Size c;
    private final ie0 d;
    private final List e;
    private final Config f;
    private final Range g;

    b(SurfaceConfig surfaceConfig, int i, Size size, ie0 ie0Var, List list, Config config, Range range) {
        if (surfaceConfig == null) {
            throw new NullPointerException("Null surfaceConfig");
        }
        this.a = surfaceConfig;
        this.b = i;
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.c = size;
        if (ie0Var == null) {
            throw new NullPointerException("Null dynamicRange");
        }
        this.d = ie0Var;
        if (list == null) {
            throw new NullPointerException("Null captureTypes");
        }
        this.e = list;
        this.f = config;
        this.g = range;
    }

    @Override // androidx.camera.core.impl.a
    public List b() {
        return this.e;
    }

    @Override // androidx.camera.core.impl.a
    public ie0 c() {
        return this.d;
    }

    @Override // androidx.camera.core.impl.a
    public int d() {
        return this.b;
    }

    @Override // androidx.camera.core.impl.a
    public Config e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        Config config;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.a.equals(aVar.g()) && this.b == aVar.d() && this.c.equals(aVar.f()) && this.d.equals(aVar.c()) && this.e.equals(aVar.b()) && ((config = this.f) != null ? config.equals(aVar.e()) : aVar.e() == null)) {
            Range range = this.g;
            if (range == null) {
                if (aVar.h() == null) {
                    return true;
                }
            } else if (range.equals(aVar.h())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.impl.a
    public Size f() {
        return this.c;
    }

    @Override // androidx.camera.core.impl.a
    public SurfaceConfig g() {
        return this.a;
    }

    @Override // androidx.camera.core.impl.a
    public Range h() {
        return this.g;
    }

    public int hashCode() {
        int iHashCode = (((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003;
        Config config = this.f;
        int iHashCode2 = (iHashCode ^ (config == null ? 0 : config.hashCode())) * 1000003;
        Range range = this.g;
        return iHashCode2 ^ (range != null ? range.hashCode() : 0);
    }

    public String toString() {
        return "AttachedSurfaceInfo{surfaceConfig=" + this.a + ", imageFormat=" + this.b + ", size=" + this.c + ", dynamicRange=" + this.d + ", captureTypes=" + this.e + ", implementationOptions=" + this.f + ", targetFrameRate=" + this.g + "}";
    }
}
