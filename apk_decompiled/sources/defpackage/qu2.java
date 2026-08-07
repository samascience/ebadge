package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class qu2 implements ou2 {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private String k;
    private float m;
    private float n;
    private boolean l = false;
    private boolean o = false;

    private float c(float f) {
        this.o = false;
        float f2 = this.d;
        if (f <= f2) {
            float f3 = this.a;
            return (f3 * f) + ((((this.b - f3) * f) * f) / (f2 * 2.0f));
        }
        int i = this.j;
        if (i == 1) {
            return this.g;
        }
        float f4 = f - f2;
        float f5 = this.e;
        if (f4 < f5) {
            float f6 = this.g;
            float f7 = this.b;
            return f6 + (f7 * f4) + ((((this.c - f7) * f4) * f4) / (f5 * 2.0f));
        }
        if (i == 2) {
            return this.h;
        }
        float f8 = f4 - f5;
        float f9 = this.f;
        if (f8 > f9) {
            this.o = true;
            return this.i;
        }
        float f10 = this.h;
        float f11 = this.c;
        return (f10 + (f11 * f8)) - (((f11 * f8) * f8) / (f9 * 2.0f));
    }

    private void f(float f, float f2, float f3, float f4, float f5) {
        this.o = false;
        if (f == 0.0f) {
            f = 1.0E-4f;
        }
        this.a = f;
        float f6 = f / f3;
        float f7 = (f6 * f) / 2.0f;
        if (f < 0.0f) {
            float fSqrt = (float) Math.sqrt((f2 - ((((-f) / f3) * f) / 2.0f)) * f3);
            if (fSqrt < f4) {
                this.k = "backward accelerate, decelerate";
                this.j = 2;
                this.a = f;
                this.b = fSqrt;
                this.c = 0.0f;
                float f8 = (fSqrt - f) / f3;
                this.d = f8;
                this.e = fSqrt / f3;
                this.g = ((f + fSqrt) * f8) / 2.0f;
                this.h = f2;
                this.i = f2;
                return;
            }
            this.k = "backward accelerate cruse decelerate";
            this.j = 3;
            this.a = f;
            this.b = f4;
            this.c = f4;
            float f9 = (f4 - f) / f3;
            this.d = f9;
            float f10 = f4 / f3;
            this.f = f10;
            float f11 = ((f + f4) * f9) / 2.0f;
            float f12 = (f10 * f4) / 2.0f;
            this.e = ((f2 - f11) - f12) / f4;
            this.g = f11;
            this.h = f2 - f12;
            this.i = f2;
            return;
        }
        if (f7 >= f2) {
            this.k = "hard stop";
            this.j = 1;
            this.a = f;
            this.b = 0.0f;
            this.g = f2;
            this.d = (2.0f * f2) / f;
            return;
        }
        float f13 = f2 - f7;
        float f14 = f13 / f;
        if (f14 + f6 < f5) {
            this.k = "cruse decelerate";
            this.j = 2;
            this.a = f;
            this.b = f;
            this.c = 0.0f;
            this.g = f13;
            this.h = f2;
            this.d = f14;
            this.e = f6;
            return;
        }
        float fSqrt2 = (float) Math.sqrt((f3 * f2) + ((f * f) / 2.0f));
        float f15 = (fSqrt2 - f) / f3;
        this.d = f15;
        float f16 = fSqrt2 / f3;
        this.e = f16;
        if (fSqrt2 < f4) {
            this.k = "accelerate decelerate";
            this.j = 2;
            this.a = f;
            this.b = fSqrt2;
            this.c = 0.0f;
            this.d = f15;
            this.e = f16;
            this.g = ((f + fSqrt2) * f15) / 2.0f;
            this.h = f2;
            return;
        }
        this.k = "accelerate cruse decelerate";
        this.j = 3;
        this.a = f;
        this.b = f4;
        this.c = f4;
        float f17 = (f4 - f) / f3;
        this.d = f17;
        float f18 = f4 / f3;
        this.f = f18;
        float f19 = ((f + f4) * f17) / 2.0f;
        float f20 = (f18 * f4) / 2.0f;
        this.e = ((f2 - f19) - f20) / f4;
        this.g = f19;
        this.h = f2 - f20;
        this.i = f2;
    }

    @Override // defpackage.ou2
    public boolean a() {
        return b() < 1.0E-5f && Math.abs(this.i - this.n) < 1.0E-5f;
    }

    @Override // defpackage.ou2
    public float b() {
        return this.l ? -e(this.n) : e(this.n);
    }

    public void d(float f, float f2, float f3, float f4, float f5, float f6) {
        this.o = false;
        this.m = f;
        boolean z = f > f2;
        this.l = z;
        if (z) {
            f(-f3, f - f2, f5, f6, f4);
        } else {
            f(f3, f2 - f, f5, f6, f4);
        }
    }

    public float e(float f) {
        float f2 = this.d;
        if (f <= f2) {
            float f3 = this.a;
            return f3 + (((this.b - f3) * f) / f2);
        }
        int i = this.j;
        if (i == 1) {
            return 0.0f;
        }
        float f4 = f - f2;
        float f5 = this.e;
        if (f4 < f5) {
            float f6 = this.b;
            return f6 + (((this.c - f6) * f4) / f5);
        }
        if (i == 2) {
            return this.h;
        }
        float f7 = f4 - f5;
        float f8 = this.f;
        if (f7 >= f8) {
            return this.i;
        }
        float f9 = this.c;
        return f9 - ((f7 * f9) / f8);
    }

    @Override // defpackage.ou2
    public float getInterpolation(float f) {
        float fC = c(f);
        this.n = f;
        return this.l ? this.m - fC : this.m + fC;
    }
}
