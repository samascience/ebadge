package defpackage;

import android.graphics.Path;

/* JADX INFO: loaded from: classes4.dex */
public abstract class wg implements b42 {
    private Path a = new Path();
    private c42 b;

    @Override // defpackage.b42
    public Path a(c42 c42Var) {
        double radians = Math.toRadians(c42Var.i());
        this.b = c42Var;
        this.a.reset();
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        while (true) {
            double d = ((double) i) * 6.283185307179586d;
            float fD = c42Var.d() + ((c42Var.g() / 2.0f) * ((float) Math.cos(d / ((double) c42Var.h()))));
            float fE = c42Var.e() + ((c42Var.g() / 2.0f) * ((float) Math.sin(d / ((double) c42Var.h()))));
            float fCos = (float) (((Math.cos(radians) * ((double) (fD - c42Var.d()))) - (Math.sin(radians) * ((double) (fE - c42Var.e())))) + ((double) c42Var.d()));
            float fSin = (float) ((Math.sin(radians) * ((double) (fD - c42Var.d()))) + (Math.cos(radians) * ((double) (fE - c42Var.e()))) + ((double) c42Var.e()));
            if (i == 0) {
                this.a.moveTo(fCos, fSin);
            } else {
                b(f, f2, fCos, fSin);
            }
            i++;
            if (i > c42Var.h()) {
                this.a.close();
                return this.a;
            }
            f2 = fSin;
            f = fCos;
        }
    }

    protected abstract void b(float f, float f2, float f3, float f4);

    public Path c() {
        return this.a;
    }
}
