package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class vd extends oc3 {
    private final int e;
    private final int f;
    private final int g;

    vd(int i, int i2, int i3) {
        this.e = i;
        this.f = i2;
        this.g = i3;
    }

    @Override // defpackage.oc3
    public int b() {
        return this.g;
    }

    @Override // defpackage.oc3
    public int c() {
        return this.e;
    }

    @Override // defpackage.oc3
    public int d() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oc3)) {
            return false;
        }
        oc3 oc3Var = (oc3) obj;
        return this.e == oc3Var.c() && this.f == oc3Var.d() && this.g == oc3Var.b();
    }

    public int hashCode() {
        return ((((this.e ^ 1000003) * 1000003) ^ this.f) * 1000003) ^ this.g;
    }

    public String toString() {
        return "VideoEncoderDataSpace{standard=" + this.e + ", transfer=" + this.f + ", range=" + this.g + "}";
    }
}
