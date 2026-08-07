package androidx.camera.video;

/* JADX INFO: loaded from: classes.dex */
final class d extends b {
    private final int b;
    private final double c;
    private final Throwable d;

    d(int i, double d, Throwable th) {
        this.b = i;
        this.c = d;
        this.d = th;
    }

    @Override // androidx.camera.video.b
    double a() {
        return this.c;
    }

    @Override // androidx.camera.video.b
    public int b() {
        return this.b;
    }

    @Override // androidx.camera.video.b
    public Throwable c() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.b == bVar.b() && Double.doubleToLongBits(this.c) == Double.doubleToLongBits(bVar.a())) {
            Throwable th = this.d;
            if (th == null) {
                if (bVar.c() == null) {
                    return true;
                }
            } else if (th.equals(bVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iDoubleToLongBits = (((this.b ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.c) >>> 32) ^ Double.doubleToLongBits(this.c)))) * 1000003;
        Throwable th = this.d;
        return iDoubleToLongBits ^ (th == null ? 0 : th.hashCode());
    }

    public String toString() {
        return "AudioStats{audioState=" + this.b + ", audioAmplitudeInternal=" + this.c + ", errorCause=" + this.d + "}";
    }
}
