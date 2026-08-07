package defpackage;

import android.graphics.Matrix;

/* JADX INFO: loaded from: classes.dex */
public class c53 {
    protected ue3 c;
    protected Matrix a = new Matrix();
    protected Matrix b = new Matrix();
    protected float[] d = new float[1];
    protected float[] e = new float[1];
    protected float[] f = new float[1];
    protected float[] g = new float[1];
    protected Matrix h = new Matrix();
    float[] i = new float[2];
    private Matrix j = new Matrix();
    private Matrix k = new Matrix();

    public c53(ue3 ue3Var) {
        this.c = ue3Var;
    }

    public void a(float f, float f2, hf1 hf1Var) {
        float[] fArr = this.i;
        fArr[0] = f;
        fArr[1] = f2;
        b(fArr);
        float[] fArr2 = this.i;
        hf1Var.c = fArr2[0];
        hf1Var.d = fArr2[1];
    }

    public void b(float[] fArr) {
        Matrix matrix = this.h;
        matrix.reset();
        this.b.invert(matrix);
        matrix.mapPoints(fArr);
        this.c.p().invert(matrix);
        matrix.mapPoints(fArr);
        this.a.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public void c(float[] fArr) {
        this.a.mapPoints(fArr);
        this.c.p().mapPoints(fArr);
        this.b.mapPoints(fArr);
    }

    public void d(boolean z) {
        this.b.reset();
        if (!z) {
            this.b.postTranslate(this.c.y(), this.c.l() - this.c.x());
        } else {
            this.b.setTranslate(this.c.y(), -this.c.A());
            this.b.postScale(1.0f, -1.0f);
        }
    }

    public void e(float f, float f2, float f3, float f4) {
        float fK = this.c.k() / f2;
        float fG = this.c.g() / f3;
        if (Float.isInfinite(fK)) {
            fK = 0.0f;
        }
        if (Float.isInfinite(fG)) {
            fG = 0.0f;
        }
        this.a.reset();
        this.a.postTranslate(-f, -f4);
        this.a.postScale(fK, -fG);
    }
}
