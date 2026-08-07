package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;

/* JADX INFO: loaded from: classes.dex */
final class md extends xy1 {
    private final Object a;
    private final bj0 b;
    private final int c;
    private final Size d;
    private final Rect e;
    private final int f;
    private final Matrix g;
    private final cs h;

    md(Object obj, bj0 bj0Var, int i, Size size, Rect rect, int i2, Matrix matrix, cs csVar) {
        if (obj == null) {
            throw new NullPointerException("Null data");
        }
        this.a = obj;
        this.b = bj0Var;
        this.c = i;
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.d = size;
        if (rect == null) {
            throw new NullPointerException("Null cropRect");
        }
        this.e = rect;
        this.f = i2;
        if (matrix == null) {
            throw new NullPointerException("Null sensorToBufferTransform");
        }
        this.g = matrix;
        if (csVar == null) {
            throw new NullPointerException("Null cameraCaptureResult");
        }
        this.h = csVar;
    }

    @Override // defpackage.xy1
    public cs a() {
        return this.h;
    }

    @Override // defpackage.xy1
    public Rect b() {
        return this.e;
    }

    @Override // defpackage.xy1
    public Object c() {
        return this.a;
    }

    @Override // defpackage.xy1
    public bj0 d() {
        return this.b;
    }

    @Override // defpackage.xy1
    public int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        bj0 bj0Var;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof xy1)) {
            return false;
        }
        xy1 xy1Var = (xy1) obj;
        return this.a.equals(xy1Var.c()) && ((bj0Var = this.b) != null ? bj0Var.equals(xy1Var.d()) : xy1Var.d() == null) && this.c == xy1Var.e() && this.d.equals(xy1Var.h()) && this.e.equals(xy1Var.b()) && this.f == xy1Var.f() && this.g.equals(xy1Var.g()) && this.h.equals(xy1Var.a());
    }

    @Override // defpackage.xy1
    public int f() {
        return this.f;
    }

    @Override // defpackage.xy1
    public Matrix g() {
        return this.g;
    }

    @Override // defpackage.xy1
    public Size h() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        bj0 bj0Var = this.b;
        return ((((((((((((iHashCode ^ (bj0Var == null ? 0 : bj0Var.hashCode())) * 1000003) ^ this.c) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode();
    }

    public String toString() {
        return "Packet{data=" + this.a + ", exif=" + this.b + ", format=" + this.c + ", size=" + this.d + ", cropRect=" + this.e + ", rotationDegrees=" + this.f + ", sensorToBufferTransform=" + this.g + ", cameraCaptureResult=" + this.h + "}";
    }
}
