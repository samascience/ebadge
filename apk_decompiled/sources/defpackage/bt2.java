package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class bt2 {
    double a;
    double b;
    private boolean c;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    private double i;
    private final he0.o j;

    public bt2() {
        this.a = Math.sqrt(1500.0d);
        this.b = 0.5d;
        this.c = false;
        this.i = Double.MAX_VALUE;
        this.j = new he0.o();
    }

    private void b() {
        if (this.c) {
            return;
        }
        if (this.i == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d = this.b;
        if (d > 1.0d) {
            double d2 = this.a;
            this.f = ((-d) * d2) + (d2 * Math.sqrt((d * d) - 1.0d));
            double d3 = this.b;
            double d4 = this.a;
            this.g = ((-d3) * d4) - (d4 * Math.sqrt((d3 * d3) - 1.0d));
        } else if (d >= 0.0d && d < 1.0d) {
            this.h = this.a * Math.sqrt(1.0d - (d * d));
        }
        this.c = true;
    }

    public float a() {
        return (float) this.i;
    }

    public boolean c(float f, float f2) {
        return ((double) Math.abs(f2)) < this.e && ((double) Math.abs(f - a())) < this.d;
    }

    public bt2 d(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.b = f;
        this.c = false;
        return this;
    }

    public bt2 e(float f) {
        this.i = f;
        return this;
    }

    public bt2 f(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.a = Math.sqrt(f);
        this.c = false;
        return this;
    }

    void g(double d) {
        double dAbs = Math.abs(d);
        this.d = dAbs;
        this.e = dAbs * 62.5d;
    }

    he0.o h(double d, double d2, long j) {
        double dCos;
        double dPow;
        b();
        double d3 = j / 1000.0d;
        double d4 = d - this.i;
        double d5 = this.b;
        if (d5 > 1.0d) {
            double d6 = this.g;
            double d7 = this.f;
            double d8 = d4 - (((d6 * d4) - d2) / (d6 - d7));
            double d9 = ((d4 * d6) - d2) / (d6 - d7);
            dPow = (Math.pow(2.718281828459045d, d6 * d3) * d8) + (Math.pow(2.718281828459045d, this.f * d3) * d9);
            double d10 = this.g;
            double dPow2 = d8 * d10 * Math.pow(2.718281828459045d, d10 * d3);
            double d11 = this.f;
            dCos = dPow2 + (d9 * d11 * Math.pow(2.718281828459045d, d11 * d3));
        } else if (d5 == 1.0d) {
            double d12 = this.a;
            double d13 = d2 + (d12 * d4);
            double d14 = d4 + (d13 * d3);
            dPow = Math.pow(2.718281828459045d, (-d12) * d3) * d14;
            double dPow3 = d14 * Math.pow(2.718281828459045d, (-this.a) * d3);
            double d15 = this.a;
            dCos = (d13 * Math.pow(2.718281828459045d, (-d15) * d3)) + (dPow3 * (-d15));
        } else {
            double d16 = 1.0d / this.h;
            double d17 = this.a;
            double d18 = d16 * ((d5 * d17 * d4) + d2);
            double dPow4 = Math.pow(2.718281828459045d, (-d5) * d17 * d3) * ((Math.cos(this.h * d3) * d4) + (Math.sin(this.h * d3) * d18));
            double d19 = this.a;
            double d20 = this.b;
            double d21 = (-d19) * dPow4 * d20;
            double dPow5 = Math.pow(2.718281828459045d, (-d20) * d19 * d3);
            double d22 = this.h;
            double dSin = (-d22) * d4 * Math.sin(d22 * d3);
            double d23 = this.h;
            dCos = d21 + (dPow5 * (dSin + (d18 * d23 * Math.cos(d23 * d3))));
            dPow = dPow4;
        }
        he0.o oVar = this.j;
        oVar.a = (float) (dPow + this.i);
        oVar.b = (float) dCos;
        return oVar;
    }

    public bt2(float f) {
        this.a = Math.sqrt(1500.0d);
        this.b = 0.5d;
        this.c = false;
        this.i = Double.MAX_VALUE;
        this.j = new he0.o();
        this.i = f;
    }
}
