package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class hb3 {
    float a;
    float b;
    float c;
    float d;
    float e;
    float f;

    public void a(float f, float f2, int i, int i2, float[] fArr) {
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = (f - 0.5f) * 2.0f;
        float f6 = (f2 - 0.5f) * 2.0f;
        float f7 = f3 + this.c;
        float f8 = f4 + this.d;
        float f9 = f7 + (this.a * f5);
        float f10 = f8 + (this.b * f6);
        float radians = (float) Math.toRadians(this.f);
        float radians2 = (float) Math.toRadians(this.e);
        double d = radians;
        double d2 = i2 * f6;
        float fSin = f9 + (((float) ((((double) ((-i) * f5)) * Math.sin(d)) - (Math.cos(d) * d2))) * radians2);
        float fCos = f10 + (radians2 * ((float) ((((double) (i * f5)) * Math.cos(d)) - (d2 * Math.sin(d)))));
        fArr[0] = fSin;
        fArr[1] = fCos;
    }

    public void b() {
        this.e = 0.0f;
        this.d = 0.0f;
        this.c = 0.0f;
        this.b = 0.0f;
        this.a = 0.0f;
    }

    public void c(z81 z81Var, float f) {
        if (z81Var != null) {
            this.e = z81Var.b(f);
        }
    }

    public void d(rs2 rs2Var, float f) {
        if (rs2Var != null) {
            this.e = rs2Var.b(f);
            this.f = rs2Var.a(f);
        }
    }

    public void e(z81 z81Var, z81 z81Var2, float f) {
        if (z81Var != null) {
            this.a = z81Var.b(f);
        }
        if (z81Var2 != null) {
            this.b = z81Var2.b(f);
        }
    }

    public void f(rs2 rs2Var, rs2 rs2Var2, float f) {
        if (rs2Var != null) {
            this.a = rs2Var.b(f);
        }
        if (rs2Var2 != null) {
            this.b = rs2Var2.b(f);
        }
    }

    public void g(z81 z81Var, z81 z81Var2, float f) {
        if (z81Var != null) {
            this.c = z81Var.b(f);
        }
        if (z81Var2 != null) {
            this.d = z81Var2.b(f);
        }
    }

    public void h(rs2 rs2Var, rs2 rs2Var2, float f) {
        if (rs2Var != null) {
            this.c = rs2Var.b(f);
        }
        if (rs2Var2 != null) {
            this.d = rs2Var2.b(f);
        }
    }
}
