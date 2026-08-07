package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class ct2 implements ou2 {
    private double c;
    private double d;
    private double e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    double a = 0.5d;
    private boolean b = false;
    private int k = 0;

    private void c(double d) {
        double d2 = this.c;
        double d3 = this.a;
        int iSqrt = (int) ((9.0d / ((Math.sqrt(d2 / ((double) this.i)) * d) * 4.0d)) + 1.0d);
        double d4 = d / ((double) iSqrt);
        int i = 0;
        while (i < iSqrt) {
            float f = this.g;
            double d5 = this.d;
            float f2 = this.h;
            double d6 = d2;
            double d7 = ((-d2) * (((double) f) - d5)) - (((double) f2) * d3);
            float f3 = this.i;
            double d8 = d3;
            double d9 = ((double) f2) + (((d7 / ((double) f3)) * d4) / 2.0d);
            double d10 = ((((-((((double) f) + ((d4 * d9) / 2.0d)) - d5)) * d6) - (d9 * d8)) / ((double) f3)) * d4;
            float f4 = (float) (((double) f2) + d10);
            this.h = f4;
            float f5 = (float) (((double) f) + ((((double) f2) + (d10 / 2.0d)) * d4));
            this.g = f5;
            int i2 = this.k;
            if (i2 > 0) {
                if (f5 < 0.0f && (i2 & 1) == 1) {
                    this.g = -f5;
                    this.h = -f4;
                }
                float f6 = this.g;
                if (f6 > 1.0f && (i2 & 2) == 2) {
                    this.g = 2.0f - f6;
                    this.h = -this.h;
                }
            }
            i++;
            d2 = d6;
            d3 = d8;
        }
    }

    @Override // defpackage.ou2
    public boolean a() {
        double d = ((double) this.g) - this.d;
        double d2 = this.c;
        double d3 = this.h;
        return Math.sqrt((((d3 * d3) * ((double) this.i)) + ((d2 * d) * d)) / d2) <= ((double) this.j);
    }

    @Override // defpackage.ou2
    public float b() {
        return 0.0f;
    }

    public void d(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        this.d = f2;
        this.a = f6;
        this.b = false;
        this.g = f;
        this.e = f3;
        this.c = f5;
        this.i = f4;
        this.j = f7;
        this.k = i;
        this.f = 0.0f;
    }

    @Override // defpackage.ou2
    public float getInterpolation(float f) {
        c(f - this.f);
        this.f = f;
        return this.g;
    }
}
