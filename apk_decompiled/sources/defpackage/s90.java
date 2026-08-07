package defpackage;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* JADX INFO: loaded from: classes3.dex */
public final class s90 {
    private static final int[] g = {3808, 476, 2107, 1799};
    private final wh a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;

    static final class a {
        private final int a;
        private final int b;

        a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        int a() {
            return this.a;
        }

        int b() {
            return this.b;
        }

        nh2 c() {
            return new nh2(a(), b());
        }

        public String toString() {
            return "<" + this.a + ' ' + this.b + '>';
        }
    }

    public s90(wh whVar) {
        this.a = whVar;
    }

    private static float b(a aVar, a aVar2) {
        return dh1.b(aVar.a(), aVar.b(), aVar2.a(), aVar2.b());
    }

    private static float c(nh2 nh2Var, nh2 nh2Var2) {
        return dh1.a(nh2Var.c(), nh2Var.d(), nh2Var2.c(), nh2Var2.d());
    }

    private static nh2[] d(nh2[] nh2VarArr, float f, float f2) {
        float f3 = f2 / (f * 2.0f);
        float fC = nh2VarArr[0].c() - nh2VarArr[2].c();
        float fD = nh2VarArr[0].d() - nh2VarArr[2].d();
        float fC2 = (nh2VarArr[0].c() + nh2VarArr[2].c()) / 2.0f;
        float fD2 = (nh2VarArr[0].d() + nh2VarArr[2].d()) / 2.0f;
        float f4 = fC * f3;
        float f5 = fD * f3;
        nh2 nh2Var = new nh2(fC2 + f4, fD2 + f5);
        nh2 nh2Var2 = new nh2(fC2 - f4, fD2 - f5);
        float fC3 = nh2VarArr[1].c() - nh2VarArr[3].c();
        float fD3 = nh2VarArr[1].d() - nh2VarArr[3].d();
        float fC4 = (nh2VarArr[1].c() + nh2VarArr[3].c()) / 2.0f;
        float fD4 = (nh2VarArr[1].d() + nh2VarArr[3].d()) / 2.0f;
        float f6 = fC3 * f3;
        float f7 = f3 * fD3;
        return new nh2[]{nh2Var, new nh2(fC4 + f6, fD4 + f7), nh2Var2, new nh2(fC4 - f6, fD4 - f7)};
    }

    private void e(nh2[] nh2VarArr) throws NotFoundException {
        long j;
        long j2;
        if (!o(nh2VarArr[0]) || !o(nh2VarArr[1]) || !o(nh2VarArr[2]) || !o(nh2VarArr[3])) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i = this.e * 2;
        int[] iArr = {r(nh2VarArr[0], nh2VarArr[1], i), r(nh2VarArr[1], nh2VarArr[2], i), r(nh2VarArr[2], nh2VarArr[3], i), r(nh2VarArr[3], nh2VarArr[0], i)};
        this.f = m(iArr, i);
        long j3 = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = iArr[(this.f + i2) % 4];
            if (this.b) {
                j = j3 << 7;
                j2 = (i3 >> 1) & 127;
            } else {
                j = j3 << 10;
                j2 = ((i3 >> 2) & 992) + ((i3 >> 1) & 31);
            }
            j3 = j + j2;
        }
        int iH = h(j3, this.b);
        if (this.b) {
            this.c = (iH >> 6) + 1;
            this.d = (iH & 63) + 1;
        } else {
            this.c = (iH >> 11) + 1;
            this.d = (iH & 2047) + 1;
        }
    }

    private nh2[] f(a aVar) throws NotFoundException {
        this.e = 1;
        a aVar2 = aVar;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        boolean z = true;
        while (this.e < 9) {
            a aVarJ = j(aVar, z, 1, -1);
            a aVarJ2 = j(aVar2, z, 1, 1);
            a aVarJ3 = j(aVar3, z, -1, 1);
            a aVarJ4 = j(aVar4, z, -1, -1);
            if (this.e > 2) {
                double dB = (b(aVarJ4, aVarJ) * this.e) / (b(aVar4, aVar) * (this.e + 2));
                if (dB < 0.75d || dB > 1.25d || !p(aVarJ, aVarJ2, aVarJ3, aVarJ4)) {
                    break;
                }
            }
            z = !z;
            this.e++;
            aVar4 = aVarJ4;
            aVar = aVarJ;
            aVar2 = aVarJ2;
            aVar3 = aVarJ3;
        }
        int i = this.e;
        if (i != 5 && i != 7) {
            throw NotFoundException.getNotFoundInstance();
        }
        this.b = i == 5;
        nh2[] nh2VarArr = {new nh2(aVar.a() + 0.5f, aVar.b() - 0.5f), new nh2(aVar2.a() + 0.5f, aVar2.b() + 0.5f), new nh2(aVar3.a() - 0.5f, aVar3.b() + 0.5f), new nh2(aVar4.a() - 0.5f, aVar4.b() - 0.5f)};
        int i2 = this.e;
        return d(nh2VarArr, (i2 * 2) - 3, i2 * 2);
    }

    private int g(a aVar, a aVar2) {
        float fB = b(aVar, aVar2);
        float fA = (aVar2.a() - aVar.a()) / fB;
        float fB2 = (aVar2.b() - aVar.b()) / fB;
        float fA2 = aVar.a();
        float fB3 = aVar.b();
        boolean zD = this.a.d(aVar.a(), aVar.b());
        int iCeil = (int) Math.ceil(fB);
        int i = 0;
        for (int i2 = 0; i2 < iCeil; i2++) {
            fA2 += fA;
            fB3 += fB2;
            if (this.a.d(dh1.c(fA2), dh1.c(fB3)) != zD) {
                i++;
            }
        }
        float f = i / fB;
        if (f <= 0.1f || f >= 0.9f) {
            return (f <= 0.1f) == zD ? 1 : -1;
        }
        return 0;
    }

    private static int h(long j, boolean z) throws NotFoundException {
        int i;
        int i2;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i3 = i - i2;
        int[] iArr = new int[i];
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iArr[i4] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new je2(jt0.k).a(iArr, i3);
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 = (i5 << 4) + iArr[i6];
            }
            return i5;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private int i() {
        if (this.b) {
            return (this.c * 4) + 11;
        }
        int i = this.c;
        return i <= 4 ? (i * 4) + 15 : (i * 4) + ((((i - 4) / 8) + 1) * 2) + 15;
    }

    private a j(a aVar, boolean z, int i, int i2) {
        int iA = aVar.a() + i;
        int iB = aVar.b();
        while (true) {
            iB += i2;
            if (!n(iA, iB) || this.a.d(iA, iB) != z) {
                break;
            }
            iA += i;
        }
        int i3 = iA - i;
        int i4 = iB - i2;
        while (n(i3, i4) && this.a.d(i3, i4) == z) {
            i3 += i;
        }
        int i5 = i3 - i;
        while (n(i5, i4) && this.a.d(i5, i4) == z) {
            i4 += i2;
        }
        return new a(i5, i4 - i2);
    }

    private a k() {
        nh2 nh2VarC;
        nh2 nh2Var;
        nh2 nh2Var2;
        nh2 nh2Var3;
        nh2 nh2VarC2;
        nh2 nh2VarC3;
        nh2 nh2VarC4;
        nh2 nh2VarC5;
        try {
            nh2[] nh2VarArrC = new hi3(this.a).c();
            nh2Var2 = nh2VarArrC[0];
            nh2Var3 = nh2VarArrC[1];
            nh2Var = nh2VarArrC[2];
            nh2VarC = nh2VarArrC[3];
        } catch (NotFoundException unused) {
            int iJ = this.a.j() / 2;
            int iG = this.a.g() / 2;
            int i = iJ + 7;
            int i2 = iG - 7;
            nh2 nh2VarC6 = j(new a(i, i2), false, 1, -1).c();
            int i3 = iG + 7;
            nh2 nh2VarC7 = j(new a(i, i3), false, 1, 1).c();
            int i4 = iJ - 7;
            nh2 nh2VarC8 = j(new a(i4, i3), false, -1, 1).c();
            nh2VarC = j(new a(i4, i2), false, -1, -1).c();
            nh2Var = nh2VarC8;
            nh2Var2 = nh2VarC6;
            nh2Var3 = nh2VarC7;
        }
        int iC = dh1.c((((nh2Var2.c() + nh2VarC.c()) + nh2Var3.c()) + nh2Var.c()) / 4.0f);
        int iC2 = dh1.c((((nh2Var2.d() + nh2VarC.d()) + nh2Var3.d()) + nh2Var.d()) / 4.0f);
        try {
            nh2[] nh2VarArrC2 = new hi3(this.a, 15, iC, iC2).c();
            nh2VarC2 = nh2VarArrC2[0];
            nh2VarC3 = nh2VarArrC2[1];
            nh2VarC4 = nh2VarArrC2[2];
            nh2VarC5 = nh2VarArrC2[3];
        } catch (NotFoundException unused2) {
            int i5 = iC + 7;
            int i6 = iC2 - 7;
            nh2VarC2 = j(new a(i5, i6), false, 1, -1).c();
            int i7 = iC2 + 7;
            nh2VarC3 = j(new a(i5, i7), false, 1, 1).c();
            int i8 = iC - 7;
            nh2VarC4 = j(new a(i8, i7), false, -1, 1).c();
            nh2VarC5 = j(new a(i8, i6), false, -1, -1).c();
        }
        return new a(dh1.c((((nh2VarC2.c() + nh2VarC5.c()) + nh2VarC3.c()) + nh2VarC4.c()) / 4.0f), dh1.c((((nh2VarC2.d() + nh2VarC5.d()) + nh2VarC3.d()) + nh2VarC4.d()) / 4.0f));
    }

    private nh2[] l(nh2[] nh2VarArr) {
        return d(nh2VarArr, this.e * 2, i());
    }

    private static int m(int[] iArr, int i) throws NotFoundException {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 = (i2 << 3) + ((i3 >> (i - 2)) << 1) + (i3 & 1);
        }
        int i4 = ((i2 & 1) << 11) + (i2 >> 1);
        for (int i5 = 0; i5 < 4; i5++) {
            if (Integer.bitCount(g[i5] ^ i4) <= 2) {
                return i5;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private boolean n(int i, int i2) {
        return i >= 0 && i < this.a.j() && i2 > 0 && i2 < this.a.g();
    }

    private boolean o(nh2 nh2Var) {
        return n(dh1.c(nh2Var.c()), dh1.c(nh2Var.d()));
    }

    private boolean p(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a(aVar.a() - 3, aVar.b() + 3);
        a aVar6 = new a(aVar2.a() - 3, aVar2.b() - 3);
        a aVar7 = new a(aVar3.a() + 3, aVar3.b() - 3);
        a aVar8 = new a(aVar4.a() + 3, aVar4.b() + 3);
        int iG = g(aVar8, aVar5);
        return iG != 0 && g(aVar5, aVar6) == iG && g(aVar6, aVar7) == iG && g(aVar7, aVar8) == iG;
    }

    private wh q(wh whVar, nh2 nh2Var, nh2 nh2Var2, nh2 nh2Var3, nh2 nh2Var4) {
        lv0 lv0VarB = lv0.b();
        int i = i();
        float f = i / 2.0f;
        int i2 = this.e;
        float f2 = f - i2;
        float f3 = f + i2;
        return lv0VarB.c(whVar, i, i, f2, f2, f3, f2, f3, f3, f2, f3, nh2Var.c(), nh2Var.d(), nh2Var2.c(), nh2Var2.d(), nh2Var3.c(), nh2Var3.d(), nh2Var4.c(), nh2Var4.d());
    }

    private int r(nh2 nh2Var, nh2 nh2Var2, int i) {
        float fC = c(nh2Var, nh2Var2);
        float f = fC / i;
        float fC2 = nh2Var.c();
        float fD = nh2Var.d();
        float fC3 = ((nh2Var2.c() - nh2Var.c()) * f) / fC;
        float fD2 = (f * (nh2Var2.d() - nh2Var.d())) / fC;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f2 = i3;
            if (this.a.d(dh1.c((f2 * fC3) + fC2), dh1.c((f2 * fD2) + fD))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }

    public ae a(boolean z) throws NotFoundException {
        nh2[] nh2VarArrF = f(k());
        if (z) {
            nh2 nh2Var = nh2VarArrF[0];
            nh2VarArrF[0] = nh2VarArrF[2];
            nh2VarArrF[2] = nh2Var;
        }
        e(nh2VarArrF);
        wh whVar = this.a;
        int i = this.f;
        return new ae(q(whVar, nh2VarArrF[i % 4], nh2VarArrF[(i + 1) % 4], nh2VarArrF[(i + 2) % 4], nh2VarArrF[(i + 3) % 4]), l(nh2VarArrF), this.b, this.d, this.c);
    }
}
