package androidx.camera.core.processing;

import android.graphics.Rect;
import android.util.Size;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
final class b extends SurfaceProcessorNode.c {
    private final UUID a;
    private final int b;
    private final int c;
    private final Rect d;
    private final Size e;
    private final int f;
    private final boolean g;
    private final boolean h;

    b(UUID uuid, int i, int i2, Rect rect, Size size, int i3, boolean z, boolean z2) {
        if (uuid == null) {
            throw new NullPointerException("Null getUuid");
        }
        this.a = uuid;
        this.b = i;
        this.c = i2;
        if (rect == null) {
            throw new NullPointerException("Null getCropRect");
        }
        this.d = rect;
        if (size == null) {
            throw new NullPointerException("Null getSize");
        }
        this.e = size;
        this.f = i3;
        this.g = z;
        this.h = z2;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.c
    public Rect a() {
        return this.d;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.c
    public int b() {
        return this.c;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.c
    public int c() {
        return this.f;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.c
    public Size d() {
        return this.e;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.c
    public int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceProcessorNode.c)) {
            return false;
        }
        SurfaceProcessorNode.c cVar = (SurfaceProcessorNode.c) obj;
        return this.a.equals(cVar.f()) && this.b == cVar.e() && this.c == cVar.b() && this.d.equals(cVar.a()) && this.e.equals(cVar.d()) && this.f == cVar.c() && this.g == cVar.g() && this.h == cVar.k();
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.c
    UUID f() {
        return this.a;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.c
    public boolean g() {
        return this.g;
    }

    public int hashCode() {
        return ((((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f) * 1000003) ^ (this.g ? 1231 : 1237)) * 1000003) ^ (this.h ? 1231 : 1237);
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.c
    public boolean k() {
        return this.h;
    }

    public String toString() {
        return "OutConfig{getUuid=" + this.a + ", getTargets=" + this.b + ", getFormat=" + this.c + ", getCropRect=" + this.d + ", getSize=" + this.e + ", getRotationDegrees=" + this.f + ", isMirroring=" + this.g + ", shouldRespectInputCropRect=" + this.h + "}";
    }
}
