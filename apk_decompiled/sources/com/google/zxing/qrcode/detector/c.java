package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.qrcode.decoder.g;
import defpackage.dh1;
import defpackage.e43;
import defpackage.k02;
import defpackage.lv0;
import defpackage.nh2;
import defpackage.nn0;
import defpackage.u90;
import defpackage.wh;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private final wh a;

    public c(wh whVar) {
        this.a = whVar;
    }

    private float b(nh2 nh2Var, nh2 nh2Var2) {
        float fJ = j((int) nh2Var.c(), (int) nh2Var.d(), (int) nh2Var2.c(), (int) nh2Var2.d());
        float fJ2 = j((int) nh2Var2.c(), (int) nh2Var2.d(), (int) nh2Var.c(), (int) nh2Var.d());
        if (Float.isNaN(fJ)) {
            return fJ2 / 7.0f;
        }
        return Float.isNaN(fJ2) ? fJ / 7.0f : (fJ + fJ2) / 14.0f;
    }

    private static int c(nh2 nh2Var, nh2 nh2Var2, nh2 nh2Var3, float f) throws NotFoundException {
        int iC = (dh1.c(nh2.b(nh2Var, nh2Var2) / f) + dh1.c(nh2.b(nh2Var, nh2Var3) / f)) / 2;
        int i = iC + 7;
        int i2 = i & 3;
        if (i2 == 0) {
            return iC + 8;
        }
        if (i2 == 2) {
            return iC + 6;
        }
        if (i2 != 3) {
            return i;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static k02 d(nh2 nh2Var, nh2 nh2Var2, nh2 nh2Var3, nh2 nh2Var4, int i) {
        float fC;
        float fD;
        float f;
        float f2 = i - 3.5f;
        if (nh2Var4 != null) {
            fC = nh2Var4.c();
            fD = nh2Var4.d();
            f = f2 - 3.0f;
        } else {
            fC = (nh2Var2.c() - nh2Var.c()) + nh2Var3.c();
            fD = (nh2Var2.d() - nh2Var.d()) + nh2Var3.d();
            f = f2;
        }
        return k02.b(3.5f, 3.5f, f2, 3.5f, f, f, 3.5f, f2, nh2Var.c(), nh2Var.d(), nh2Var2.c(), nh2Var2.d(), fC, fD, nh2Var3.c(), nh2Var3.d());
    }

    private static wh h(wh whVar, k02 k02Var, int i) {
        return lv0.b().d(whVar, i, i, k02Var);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0089  */
    /* JADX WARN: Code duplicated, block: B:43:0x0090 A[RETURN] */
    private float i(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = 1;
        boolean z = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z) {
            i6 = i;
            i5 = i2;
            i8 = i3;
            i7 = i4;
        } else {
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
        }
        int iAbs = Math.abs(i7 - i5);
        int iAbs2 = Math.abs(i8 - i6);
        int i11 = 2;
        int i12 = (-iAbs) / 2;
        int i13 = i5 < i7 ? 1 : -1;
        int i14 = i6 < i8 ? 1 : -1;
        int i15 = i7 + i13;
        int i16 = i5;
        int i17 = i6;
        int i18 = 0;
        while (i16 != i15) {
            if ((i18 == i10 ? i10 : 0) == this.a.d(z ? i17 : i16, z ? i16 : i17)) {
                if (i18 == 2) {
                    return dh1.b(i16, i17, i5, i6);
                }
                i18++;
            }
            i12 += iAbs2;
            if (i12 > 0) {
                if (i17 == i8) {
                    i9 = 2;
                    if (i18 == i9) {
                        return dh1.b(i15, i8, i5, i6);
                    }
                    return Float.NaN;
                }
                i17 += i14;
                i12 -= iAbs;
            }
            i16 += i13;
            i15 = i15;
            z = z;
            i10 = 1;
            i11 = 2;
        }
        i15 = i15;
        i9 = i11;
        if (i18 == i9) {
            return dh1.b(i15, i8, i5, i6);
        }
        return Float.NaN;
    }

    private float j(int i, int i2, int i3, int i4) {
        float fJ;
        float fG;
        float fI = i(i, i2, i3, i4);
        int iJ = i - (i3 - i);
        int iG = 0;
        if (iJ < 0) {
            fJ = i / (i - iJ);
            iJ = 0;
        } else if (iJ >= this.a.j()) {
            fJ = ((this.a.j() - 1) - i) / (iJ - i);
            iJ = this.a.j() - 1;
        } else {
            fJ = 1.0f;
        }
        float f = i2;
        int i5 = (int) (f - ((i4 - i2) * fJ));
        if (i5 < 0) {
            fG = f / (i2 - i5);
        } else if (i5 >= this.a.g()) {
            fG = ((this.a.g() - 1) - i2) / (i5 - i2);
            iG = this.a.g() - 1;
        } else {
            iG = i5;
            fG = 1.0f;
        }
        return (fI + i(i, i2, (int) (i + ((iJ - i) * fG)), iG)) - 1.0f;
    }

    protected final float a(nh2 nh2Var, nh2 nh2Var2, nh2 nh2Var3) {
        return (b(nh2Var, nh2Var2) + b(nh2Var, nh2Var3)) / 2.0f;
    }

    public final u90 e(Map map) {
        if (map != null) {
            e43.a(map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK));
        }
        return g(new FinderPatternFinder(this.a, null).e(map));
    }

    protected final a f(float f, int i, int i2, float f2) throws NotFoundException {
        int i3 = (int) (f2 * f);
        int iMax = Math.max(0, i - i3);
        int iMin = Math.min(this.a.j() - 1, i + i3) - iMax;
        float f3 = 3.0f * f;
        if (iMin < f3) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iMax2 = Math.max(0, i2 - i3);
        int iMin2 = Math.min(this.a.g() - 1, i2 + i3) - iMax2;
        if (iMin2 >= f3) {
            return new b(this.a, iMax, iMax2, iMin, iMin2, f, null).c();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected final u90 g(nn0 nn0Var) throws NotFoundException, FormatException {
        a aVarF;
        d dVarB = nn0Var.b();
        d dVarC = nn0Var.c();
        d dVarA = nn0Var.a();
        float fA = a(dVarB, dVarC, dVarA);
        if (fA < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iC = c(dVarB, dVarC, dVarA, fA);
        g gVarG = g.g(iC);
        int iE = gVarG.e() - 7;
        if (gVarG.d().length <= 0) {
            aVarF = null;
            break;
        }
        float fC = (dVarC.c() - dVarB.c()) + dVarA.c();
        float fD = (dVarC.d() - dVarB.d()) + dVarA.d();
        float f = 1.0f - (3.0f / iE);
        int iC2 = (int) (dVarB.c() + ((fC - dVarB.c()) * f));
        int iD = (int) (dVarB.d() + (f * (fD - dVarB.d())));
        int i = 4;
        while (true) {
            if (i > 16) {
                aVarF = null;
                break;
            }
            try {
                aVarF = f(fA, iC2, iD, i);
                break;
            } catch (NotFoundException unused) {
                i <<= 1;
            }
        }
        return new u90(h(this.a, d(dVarB, dVarC, dVarA, aVarF, iC), iC), aVarF == null ? new nh2[]{dVarA, dVarB, dVarC} : new nh2[]{dVarA, dVarB, dVarC, aVarF});
    }
}
