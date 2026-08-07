package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class jq {
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;

    jq(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f = f6;
        this.g = f7;
        this.h = f8;
        this.i = f9;
    }

    private static jq b(float f, float f2, float f3) {
        float f4 = 100.0f;
        float f5 = 1000.0f;
        float f6 = 0.0f;
        jq jqVar = null;
        float f7 = 1000.0f;
        while (Math.abs(f6 - f4) > 0.01f) {
            float f8 = ((f4 - f6) / 2.0f) + f6;
            int iP = e(f8, f2, f).p();
            float fB = kq.b(iP);
            float fAbs = Math.abs(f3 - fB);
            if (fAbs < 0.2f) {
                jq jqVarC = c(iP);
                float fA = jqVarC.a(e(jqVarC.k(), jqVarC.i(), f));
                if (fA <= 1.0f) {
                    jqVar = jqVarC;
                    f5 = fAbs;
                    f7 = fA;
                }
            }
            if (f5 == 0.0f && f7 == 0.0f) {
                break;
            }
            if (fB < f3) {
                f6 = f8;
            } else {
                f4 = f8;
            }
        }
        return jqVar;
    }

    static jq c(int i) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        d(i, cg3.k, fArr, fArr2);
        return new jq(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    static void d(int i, cg3 cg3Var, float[] fArr, float[] fArr2) {
        kq.f(i, fArr2);
        float[][] fArr3 = kq.a;
        float f = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f2 = fArr4[0] * f;
        float f3 = fArr2[1];
        float f4 = f2 + (fArr4[1] * f3);
        float f5 = fArr2[2];
        float f6 = f4 + (fArr4[2] * f5);
        float[] fArr5 = fArr3[1];
        float f7 = (fArr5[0] * f) + (fArr5[1] * f3) + (fArr5[2] * f5);
        float[] fArr6 = fArr3[2];
        float f8 = (f * fArr6[0]) + (f3 * fArr6[1]) + (f5 * fArr6[2]);
        float f9 = cg3Var.i()[0] * f6;
        float f10 = cg3Var.i()[1] * f7;
        float f11 = cg3Var.i()[2] * f8;
        float fPow = (float) Math.pow(((double) (cg3Var.c() * Math.abs(f9))) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (cg3Var.c() * Math.abs(f10))) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (cg3Var.c() * Math.abs(f11))) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f9) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f10) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f11) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d = fSignum3;
        float f12 = ((float) (((((double) fSignum) * 11.0d) + (((double) fSignum2) * (-12.0d))) + d)) / 11.0f;
        float f13 = ((float) (((double) (fSignum + fSignum2)) - (d * 2.0d))) / 9.0f;
        float f14 = fSignum2 * 20.0f;
        float f15 = (((fSignum * 20.0f) + f14) + (21.0f * fSignum3)) / 20.0f;
        float f16 = (((fSignum * 40.0f) + f14) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f13, f12)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f17 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f16 * cg3Var.f()) / cg3Var.a(), cg3Var.b() * cg3Var.j())) * 100.0f;
        float fB = (4.0f / cg3Var.b()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (cg3Var.a() + 4.0f) * cg3Var.d();
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, cg3Var.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) fAtan2) < 20.14d ? 360.0f + fAtan2 : fAtan2)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * cg3Var.g()) * cg3Var.h()) * ((float) Math.sqrt((f12 * f12) + (f13 * f13)))) / (f15 + 0.305f), 0.9d));
        float fSqrt = ((float) Math.sqrt(((double) fPow4) / 100.0d)) * fPow5;
        float fD = cg3Var.d() * fSqrt;
        float fSqrt2 = ((float) Math.sqrt((fPow5 * cg3Var.b()) / (cg3Var.a() + 4.0f))) * 50.0f;
        float f18 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * fD) + 1.0f)) * 43.85965f;
        double d2 = f17;
        float fCos = ((float) Math.cos(d2)) * fLog;
        float fSin = fLog * ((float) Math.sin(d2));
        fArr2[0] = fAtan2;
        fArr2[1] = fSqrt;
        if (fArr != null) {
            fArr[0] = fPow4;
            fArr[1] = fB;
            fArr[2] = fD;
            fArr[3] = fSqrt2;
            fArr[4] = f18;
            fArr[5] = fCos;
            fArr[6] = fSin;
        }
    }

    private static jq e(float f, float f2, float f3) {
        return f(f, f2, f3, cg3.k);
    }

    private static jq f(float f, float f2, float f3, cg3 cg3Var) {
        double d = ((double) f) / 100.0d;
        float fB = (4.0f / cg3Var.b()) * ((float) Math.sqrt(d)) * (cg3Var.a() + 4.0f) * cg3Var.d();
        float fD = f2 * cg3Var.d();
        float fSqrt = ((float) Math.sqrt(((f2 / ((float) Math.sqrt(d))) * cg3Var.b()) / (cg3Var.a() + 4.0f))) * 50.0f;
        float f4 = (1.7f * f) / ((0.007f * f) + 1.0f);
        float fLog = ((float) Math.log((((double) fD) * 0.0228d) + 1.0d)) * 43.85965f;
        double d2 = (3.1415927f * f3) / 180.0f;
        return new jq(f3, f2, f, fB, fD, fSqrt, f4, fLog * ((float) Math.cos(d2)), fLog * ((float) Math.sin(d2)));
    }

    public static int m(float f, float f2, float f3) {
        return n(f, f2, f3, cg3.k);
    }

    static int n(float f, float f2, float f3, cg3 cg3Var) {
        if (f2 < 1.0d || Math.round(f3) <= 0.0d || Math.round(f3) >= 100.0d) {
            return kq.a(f3);
        }
        float fMin = f < 0.0f ? 0.0f : Math.min(360.0f, f);
        jq jqVar = null;
        boolean z = true;
        float f4 = 0.0f;
        float f5 = f2;
        while (Math.abs(f4 - f2) >= 0.4f) {
            jq jqVarB = b(fMin, f5, f3);
            if (!z) {
                if (jqVarB == null) {
                    f2 = f5;
                } else {
                    f4 = f5;
                    jqVar = jqVarB;
                }
                f5 = ((f2 - f4) / 2.0f) + f4;
            } else {
                if (jqVarB != null) {
                    return jqVarB.o(cg3Var);
                }
                f5 = ((f2 - f4) / 2.0f) + f4;
                z = false;
            }
        }
        return jqVar == null ? kq.a(f3) : jqVar.o(cg3Var);
    }

    float a(jq jqVar) {
        float fL = l() - jqVar.l();
        float fG = g() - jqVar.g();
        float fH = h() - jqVar.h();
        return (float) (Math.pow(Math.sqrt((fL * fL) + (fG * fG) + (fH * fH)), 0.63d) * 1.41d);
    }

    float g() {
        return this.h;
    }

    float h() {
        return this.i;
    }

    float i() {
        return this.b;
    }

    float j() {
        return this.a;
    }

    float k() {
        return this.c;
    }

    float l() {
        return this.g;
    }

    int o(cg3 cg3Var) {
        float fPow = (float) Math.pow(((double) ((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? 0.0f : i() / ((float) Math.sqrt(((double) k()) / 100.0d)))) / Math.pow(1.64d - Math.pow(0.29d, cg3Var.e()), 0.73d), 1.1111111111111112d);
        double dJ = (j() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + dJ) + 3.8d)) * 0.25f;
        float fA = cg3Var.a() * ((float) Math.pow(((double) k()) / 100.0d, (1.0d / ((double) cg3Var.b())) / ((double) cg3Var.j())));
        float fG = fCos * 3846.1538f * cg3Var.g() * cg3Var.h();
        float f = fA / cg3Var.f();
        float fSin = (float) Math.sin(dJ);
        float fCos2 = (float) Math.cos(dJ);
        float f2 = (((0.305f + f) * 23.0f) * fPow) / (((fG * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f3 = fCos2 * f2;
        float f4 = f2 * fSin;
        float f5 = f * 460.0f;
        float f6 = (((451.0f * f3) + f5) + (288.0f * f4)) / 1403.0f;
        float f7 = ((f5 - (891.0f * f3)) - (261.0f * f4)) / 1403.0f;
        float f8 = ((f5 - (f3 * 220.0f)) - (f4 * 6300.0f)) / 1403.0f;
        float fSignum = Math.signum(f6) * (100.0f / cg3Var.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f6)) * 27.13d) / (400.0d - ((double) Math.abs(f6)))), 2.380952380952381d));
        float fSignum2 = Math.signum(f7) * (100.0f / cg3Var.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f7)) * 27.13d) / (400.0d - ((double) Math.abs(f7)))), 2.380952380952381d));
        float fSignum3 = Math.signum(f8) * (100.0f / cg3Var.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f8)) * 27.13d) / (400.0d - ((double) Math.abs(f8)))), 2.380952380952381d));
        float f9 = fSignum / cg3Var.i()[0];
        float f10 = fSignum2 / cg3Var.i()[1];
        float f11 = fSignum3 / cg3Var.i()[2];
        float[][] fArr = kq.b;
        float[] fArr2 = fArr[0];
        float f12 = (fArr2[0] * f9) + (fArr2[1] * f10) + (fArr2[2] * f11);
        float[] fArr3 = fArr[1];
        float f13 = (fArr3[0] * f9) + (fArr3[1] * f10) + (fArr3[2] * f11);
        float[] fArr4 = fArr[2];
        return pz.b(f12, f13, (f9 * fArr4[0]) + (f10 * fArr4[1]) + (f11 * fArr4[2]));
    }

    int p() {
        return o(cg3.k);
    }
}
