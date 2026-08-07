package defpackage;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ue3 {
    protected final Matrix a = new Matrix();
    protected RectF b = new RectF();
    protected float c = 0.0f;
    protected float d = 0.0f;
    private float e = 1.0f;
    private float f = Float.MAX_VALUE;
    private float g = 1.0f;
    private float h = Float.MAX_VALUE;
    private float i = 1.0f;
    private float j = 1.0f;
    private float k = 0.0f;
    private float l = 0.0f;
    private float m = 0.0f;
    private float n = 0.0f;
    protected float[] o = new float[9];
    protected Matrix p = new Matrix();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected final float[] f391q = new float[9];

    public float A() {
        return this.b.top;
    }

    public Matrix B(Matrix matrix, View view, boolean z) {
        this.a.set(matrix);
        w(this.a, this.b);
        if (z) {
            view.invalidate();
        }
        matrix.set(this.a);
        return matrix;
    }

    public void C(float f, float f2, float f3, float f4) {
        this.b.set(f, f2, this.c - f3, this.d - f4);
    }

    public void D(float f, float f2) {
        float fY = y();
        float fA = A();
        float fZ = z();
        float fX = x();
        this.d = f2;
        this.c = f;
        C(fY, fA, fZ, fX);
    }

    public void E(float f) {
        this.m = ta3.c(f);
    }

    public void F(float f) {
        this.n = ta3.c(f);
    }

    public void G(float f) {
        if (f == 0.0f) {
            f = Float.MAX_VALUE;
        }
        this.h = f;
        w(this.a, this.b);
    }

    public void H(float f) {
        if (f == 0.0f) {
            f = Float.MAX_VALUE;
        }
        this.f = f;
        w(this.a, this.b);
    }

    public void I(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        this.g = f;
        w(this.a, this.b);
    }

    public void J(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        this.e = f;
        w(this.a, this.b);
    }

    public boolean a() {
        return this.i < this.h;
    }

    public boolean b() {
        return this.j < this.f;
    }

    public boolean c() {
        return this.i > this.g;
    }

    public boolean d() {
        return this.j > this.e;
    }

    public void e(float[] fArr, View view) {
        Matrix matrix = this.p;
        matrix.reset();
        matrix.set(this.a);
        matrix.postTranslate(-(fArr[0] - y()), -(fArr[1] - A()));
        B(matrix, view, true);
    }

    public float f() {
        return this.b.bottom;
    }

    public float g() {
        return this.b.height();
    }

    public float h() {
        return this.b.left;
    }

    public float i() {
        return this.b.right;
    }

    public float j() {
        return this.b.top;
    }

    public float k() {
        return this.b.width();
    }

    public float l() {
        return this.d;
    }

    public float m() {
        return this.c;
    }

    public if1 n() {
        return if1.b(this.b.centerX(), this.b.centerY());
    }

    public RectF o() {
        return this.b;
    }

    public Matrix p() {
        return this.a;
    }

    public float q() {
        return this.i;
    }

    public float r() {
        return this.j;
    }

    public boolean s() {
        return this.m <= 0.0f && this.n <= 0.0f;
    }

    public boolean t() {
        return u() && v();
    }

    public boolean u() {
        float f = this.i;
        float f2 = this.g;
        return f <= f2 && f2 <= 1.0f;
    }

    public boolean v() {
        float f = this.j;
        float f2 = this.e;
        return f <= f2 && f2 <= 1.0f;
    }

    public void w(Matrix matrix, RectF rectF) {
        float fWidth;
        float fHeight;
        matrix.getValues(this.f391q);
        float[] fArr = this.f391q;
        float f = fArr[2];
        float f2 = fArr[0];
        float f3 = fArr[5];
        float f4 = fArr[4];
        this.i = Math.min(Math.max(this.g, f2), this.h);
        this.j = Math.min(Math.max(this.e, f4), this.f);
        if (rectF != null) {
            fWidth = rectF.width();
            fHeight = rectF.height();
        } else {
            fWidth = 0.0f;
            fHeight = 0.0f;
        }
        this.k = Math.min(Math.max(f, ((-fWidth) * (this.i - 1.0f)) - this.m), this.m);
        float fMax = Math.max(Math.min(f3, (fHeight * (this.j - 1.0f)) + this.n), -this.n);
        this.l = fMax;
        float[] fArr2 = this.f391q;
        fArr2[2] = this.k;
        fArr2[0] = this.i;
        fArr2[5] = fMax;
        fArr2[4] = this.j;
        matrix.setValues(fArr2);
    }

    public float x() {
        return this.d - this.b.bottom;
    }

    public float y() {
        return this.b.left;
    }

    public float z() {
        return this.c - this.b.right;
    }
}
