package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class hd extends u11 {
    private final float a;
    private final float b;
    private final float c;
    private final float d;

    hd(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    @Override // defpackage.u11, defpackage.xl3
    public float a() {
        return this.b;
    }

    @Override // defpackage.u11, defpackage.xl3
    public float b() {
        return this.c;
    }

    @Override // defpackage.u11, defpackage.xl3
    public float c() {
        return this.a;
    }

    @Override // defpackage.u11, defpackage.xl3
    public float d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u11)) {
            return false;
        }
        u11 u11Var = (u11) obj;
        return Float.floatToIntBits(this.a) == Float.floatToIntBits(u11Var.c()) && Float.floatToIntBits(this.b) == Float.floatToIntBits(u11Var.a()) && Float.floatToIntBits(this.c) == Float.floatToIntBits(u11Var.b()) && Float.floatToIntBits(this.d) == Float.floatToIntBits(u11Var.d());
    }

    public int hashCode() {
        return ((((((Float.floatToIntBits(this.a) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.b)) * 1000003) ^ Float.floatToIntBits(this.c)) * 1000003) ^ Float.floatToIntBits(this.d);
    }

    public String toString() {
        return "ImmutableZoomState{zoomRatio=" + this.a + ", maxZoomRatio=" + this.b + ", minZoomRatio=" + this.c + ", linearZoom=" + this.d + "}";
    }
}
