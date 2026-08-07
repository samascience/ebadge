package defpackage;

import android.graphics.Matrix;

/* JADX INFO: loaded from: classes.dex */
final class gd extends t11 {
    private final vz2 a;
    private final long b;
    private final int c;
    private final Matrix d;

    gd(vz2 vz2Var, long j, int i, Matrix matrix) {
        if (vz2Var == null) {
            throw new NullPointerException("Null tagBundle");
        }
        this.a = vz2Var;
        this.b = j;
        this.c = i;
        if (matrix == null) {
            throw new NullPointerException("Null sensorToBufferTransformMatrix");
        }
        this.d = matrix;
    }

    @Override // defpackage.t11, defpackage.n01
    public vz2 a() {
        return this.a;
    }

    @Override // defpackage.t11, defpackage.n01
    public long c() {
        return this.b;
    }

    @Override // defpackage.t11, defpackage.n01
    public int d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t11)) {
            return false;
        }
        t11 t11Var = (t11) obj;
        return this.a.equals(t11Var.a()) && this.b == t11Var.c() && this.c == t11Var.d() && this.d.equals(t11Var.f());
    }

    @Override // defpackage.t11
    public Matrix f() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        long j = this.b;
        return ((((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.c) * 1000003) ^ this.d.hashCode();
    }

    public String toString() {
        return "ImmutableImageInfo{tagBundle=" + this.a + ", timestamp=" + this.b + ", rotationDegrees=" + this.c + ", sensorToBufferTransformMatrix=" + this.d + "}";
    }
}
