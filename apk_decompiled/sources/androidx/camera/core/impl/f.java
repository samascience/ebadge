package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes.dex */
final class f extends SurfaceConfig {
    private final SurfaceConfig.ConfigType a;
    private final SurfaceConfig.ConfigSize b;
    private final long c;

    f(SurfaceConfig.ConfigType configType, SurfaceConfig.ConfigSize configSize, long j) {
        if (configType == null) {
            throw new NullPointerException("Null configType");
        }
        this.a = configType;
        if (configSize == null) {
            throw new NullPointerException("Null configSize");
        }
        this.b = configSize;
        this.c = j;
    }

    @Override // androidx.camera.core.impl.SurfaceConfig
    public SurfaceConfig.ConfigSize c() {
        return this.b;
    }

    @Override // androidx.camera.core.impl.SurfaceConfig
    public SurfaceConfig.ConfigType d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceConfig)) {
            return false;
        }
        SurfaceConfig surfaceConfig = (SurfaceConfig) obj;
        return this.a.equals(surfaceConfig.d()) && this.b.equals(surfaceConfig.c()) && this.c == surfaceConfig.f();
    }

    @Override // androidx.camera.core.impl.SurfaceConfig
    public long f() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        long j = this.c;
        return iHashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "SurfaceConfig{configType=" + this.a + ", configSize=" + this.b + ", streamUseCase=" + this.c + "}";
    }
}
