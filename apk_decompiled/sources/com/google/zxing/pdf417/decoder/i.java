package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import defpackage.dh1;
import defpackage.my1;
import defpackage.nh2;
import defpackage.q70;
import defpackage.wh;
import defpackage.zh0;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {
    private static final zh0 a = new zh0();

    private static c a(g gVar) {
        int[] iArrJ;
        if (gVar == null || (iArrJ = gVar.j()) == null) {
            return null;
        }
        int iP = p(iArrJ);
        int i = 0;
        int i2 = 0;
        for (int i3 : iArrJ) {
            i2 += iP - i3;
            if (i3 > 0) {
                break;
            }
        }
        d[] dVarArrD = gVar.d();
        for (int i4 = 0; i2 > 0 && dVarArrD[i4] == null; i4++) {
            i2--;
        }
        for (int length = iArrJ.length - 1; length >= 0; length--) {
            int i5 = iArrJ[length];
            i += iP - i5;
            if (i5 > 0) {
                break;
            }
        }
        for (int length2 = dVarArrD.length - 1; i > 0 && dVarArrD[length2] == null; length2--) {
            i--;
        }
        return gVar.a().a(i2, i, gVar.k());
    }

    private static void b(e eVar, b[][] bVarArr) throws NotFoundException {
        int[] iArrA = bVarArr[0][1].a();
        int iJ = (eVar.j() * eVar.l()) - r(eVar.k());
        if (iArrA.length != 0) {
            if (iArrA[0] != iJ) {
                bVarArr[0][1].b(iJ);
            }
        } else {
            if (iJ <= 0 || iJ > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            bVarArr[0][1].b(iJ);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0011  */
    /* JADX WARN: Code duplicated, block: B:14:0x0017  */
    /* JADX WARN: Code duplicated, block: B:17:0x0020 A[LOOP:1: B:8:0x000a->B:17:0x0020, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x001f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0022 A[EDGE_INSN: B:24:0x0022->B:18:0x0022 BREAK  A[LOOP:1: B:8:0x000a->B:17:0x0020], SYNTHETIC] */
    private static int c(wh whVar, int i, int i2, boolean z, int i3, int i4) {
        int i5 = z ? -1 : 1;
        int i6 = i3;
        for (int i7 = 0; i7 < 2; i7++) {
            while (true) {
                if (!z) {
                    if (i6 >= i2) {
                        break;
                    }
                    if (z == whVar.d(i6, i4)) {
                        break;
                        break;
                    }
                    if (Math.abs(i3 - i6) > 2) {
                        return i3;
                    }
                    i6 += i5;
                } else {
                    if (i6 < i) {
                        break;
                    }
                    if (z == whVar.d(i6, i4)) {
                        break;
                    }
                    if (Math.abs(i3 - i6) > 2) {
                        return i3;
                    }
                    i6 += i5;
                }
            }
            i5 = -i5;
            z = !z;
        }
        return i6;
    }

    private static boolean d(int i, int i2, int i3) {
        return i2 + (-2) <= i && i <= i3 + 2;
    }

    private static int e(int[] iArr, int[] iArr2, int i) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return a.a(iArr, i, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    private static b[][] f(e eVar) {
        int iC;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, eVar.l(), eVar.j() + 2);
        for (b[] bVarArr2 : bVarArr) {
            int i = 0;
            while (true) {
                if (i < bVarArr2.length) {
                    bVarArr2[i] = new b();
                    i++;
                }
            }
        }
        int i2 = 0;
        for (f fVar : eVar.o()) {
            if (fVar != null) {
                for (d dVar : fVar.d()) {
                    if (dVar != null && (iC = dVar.c()) >= 0 && iC < bVarArr.length) {
                        bVarArr[iC][i2].b(dVar.e());
                    }
                }
            }
            i2++;
        }
        return bVarArr;
    }

    private static q70 g(e eVar) throws NotFoundException {
        b[][] bVarArrF = f(eVar);
        b(eVar, bVarArrF);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[eVar.l() * eVar.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < eVar.l(); i++) {
            int i2 = 0;
            while (i2 < eVar.j()) {
                int i3 = i2 + 1;
                int[] iArrA = bVarArrF[i][i3].a();
                int iJ = (eVar.j() * i) + i2;
                if (iArrA.length == 0) {
                    arrayList.add(Integer.valueOf(iJ));
                } else if (iArrA.length == 1) {
                    iArr[iJ] = iArrA[0];
                } else {
                    arrayList3.add(Integer.valueOf(iJ));
                    arrayList2.add(iArrA);
                }
                i2 = i3;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return h(eVar.k(), iArr, my1.b(arrayList), my1.b(arrayList3), iArr2);
    }

    private static q70 h(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws ChecksumException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                throw ChecksumException.getChecksumInstance();
            }
            for (int i4 = 0; i4 < length; i4++) {
                iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
            }
            try {
                return j(iArr, i, iArr2);
            } catch (ChecksumException unused) {
                if (length == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                for (int i5 = 0; i5 < length; i5++) {
                    int i6 = iArr5[i5];
                    if (i6 < iArr4[i5].length - 1) {
                        iArr5[i5] = i6 + 1;
                        break;
                    }
                    iArr5[i5] = 0;
                    if (i5 == length - 1) {
                        throw ChecksumException.getChecksumInstance();
                    }
                }
                i2 = i3;
            }
        }
    }

    public static q70 i(wh whVar, nh2 nh2Var, nh2 nh2Var2, nh2 nh2Var3, nh2 nh2Var4, int i, int i2) throws NotFoundException {
        int i3;
        int i4;
        int i5;
        g gVarS = null;
        g gVarS2 = null;
        e eVarV = null;
        c cVar = new c(whVar, nh2Var, nh2Var2, nh2Var3, nh2Var4);
        for (int i6 = 0; i6 < 2; i6++) {
            if (nh2Var != null) {
                gVarS = s(whVar, cVar, nh2Var, true, i, i2);
            }
            if (nh2Var3 != null) {
                gVarS2 = s(whVar, cVar, nh2Var3, false, i, i2);
            }
            eVarV = v(gVarS, gVarS2);
            if (eVarV == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i6 != 0 || eVarV.m() == null || (eVarV.m().h() >= cVar.h() && eVarV.m().f() <= cVar.f())) {
                eVarV.p(cVar);
                break;
            }
            cVar = eVarV.m();
        }
        int iJ = eVarV.j() + 1;
        eVarV.q(0, gVarS);
        eVarV.q(iJ, gVarS2);
        boolean z = gVarS != null;
        int iMin = i;
        int iMax = i2;
        for (int i7 = 1; i7 <= iJ; i7++) {
            int i8 = z ? i7 : iJ - i7;
            if (eVarV.n(i8) == null) {
                f gVar = (i8 == 0 || i8 == iJ) ? new g(cVar, i8 == 0) : new f(cVar);
                eVarV.q(i8, gVar);
                int i9 = -1;
                int iH = cVar.h();
                int i10 = -1;
                while (iH <= cVar.f()) {
                    int iT = t(eVarV, i8, iH, z);
                    if (iT < 0 || iT > cVar.e()) {
                        if (i10 != i9) {
                            i5 = i10;
                        } else {
                            i3 = iH;
                            i4 = i9;
                        }
                        i10 = i10;
                        iH = i3 + 1;
                        i9 = i4;
                    } else {
                        i5 = iT;
                    }
                    int i11 = iH;
                    i4 = i9;
                    d dVarK = k(whVar, cVar.g(), cVar.e(), z, i5, i11, iMin, iMax);
                    i3 = i11;
                    if (dVarK != null) {
                        gVar.f(i3, dVarK);
                        iMin = Math.min(iMin, dVarK.f());
                        iMax = Math.max(iMax, dVarK.f());
                        i10 = i5;
                    } else {
                        i10 = i10;
                    }
                    iH = i3 + 1;
                    i9 = i4;
                }
            }
        }
        return g(eVarV);
    }

    private static q70 j(int[] iArr, int i, int[] iArr2) throws ChecksumException, FormatException {
        if (iArr.length == 0) {
            throw FormatException.getFormatInstance();
        }
        int i2 = 1 << (i + 1);
        int iE = e(iArr, iArr2, i2);
        w(iArr, i2);
        q70 q70VarB = DecodedBitStreamParser.b(iArr, String.valueOf(i));
        q70VarB.k(Integer.valueOf(iE));
        q70VarB.j(Integer.valueOf(iArr2.length));
        return q70VarB;
    }

    private static d k(wh whVar, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int iD;
        int iA;
        int iC = c(whVar, i, i2, z, i3, i4);
        int[] iArrQ = q(whVar, i, i2, z, iC, i4);
        if (iArrQ == null) {
            return null;
        }
        int iD2 = dh1.d(iArrQ);
        if (z) {
            i7 = iC + iD2;
        } else {
            for (int i8 = 0; i8 < iArrQ.length / 2; i8++) {
                int i9 = iArrQ[i8];
                iArrQ[i8] = iArrQ[(iArrQ.length - 1) - i8];
                iArrQ[(iArrQ.length - 1) - i8] = i9;
            }
            iC -= iD2;
            i7 = iC;
        }
        if (d(iD2, i5, i6) && (iA = my1.a((iD = h.d(iArrQ)))) != -1) {
            return new d(iC, i7, n(iD), iA);
        }
        return null;
    }

    private static a l(g gVar, g gVar2) {
        a aVarI;
        a aVarI2;
        if (gVar == null || (aVarI = gVar.i()) == null) {
            if (gVar2 == null) {
                return null;
            }
            return gVar2.i();
        }
        if (gVar2 == null || (aVarI2 = gVar2.i()) == null || aVarI.a() == aVarI2.a() || aVarI.b() == aVarI2.b() || aVarI.c() == aVarI2.c()) {
            return aVarI;
        }
        return null;
    }

    private static int[] m(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    private static int n(int i) {
        return o(m(i));
    }

    private static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static int p(int[] iArr) {
        int iMax = -1;
        for (int i : iArr) {
            iMax = Math.max(iMax, i);
        }
        return iMax;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0013 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
    /* JADX WARN: Code duplicated, block: B:28:0x0027 A[EDGE_INSN: B:28:0x0027->B:16:0x0027 BREAK  A[LOOP:0: B:7:0x000c->B:31:0x000c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0022 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x001b A[SYNTHETIC] */
    private static int[] q(wh whVar, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        int i6 = 0;
        boolean z2 = z;
        while (true) {
            if (!z) {
                if (i3 < i) {
                    break;
                }
                if (i6 < 8) {
                    break;
                    break;
                }
                if (whVar.d(i3, i4) == z2) {
                    iArr[i6] = iArr[i6] + 1;
                    i3 += i5;
                } else {
                    i6++;
                    z2 = !z2;
                }
            } else {
                if (i3 >= i2) {
                    break;
                }
                if (i6 < 8) {
                    break;
                }
                if (whVar.d(i3, i4) == z2) {
                    iArr[i6] = iArr[i6] + 1;
                    i3 += i5;
                } else {
                    i6++;
                    z2 = !z2;
                }
            }
        }
        if (i6 != 8) {
            if (z) {
                i = i2;
            }
            if (i3 != i || i6 != 7) {
                return null;
            }
        }
        return iArr;
    }

    private static int r(int i) {
        return 2 << i;
    }

    private static g s(wh whVar, c cVar, nh2 nh2Var, boolean z, int i, int i2) {
        g gVar = new g(cVar, z);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int iC = (int) nh2Var.c();
            for (int iD = (int) nh2Var.d(); iD <= cVar.f() && iD >= cVar.h(); iD += i4) {
                d dVarK = k(whVar, 0, whVar.j(), z, iC, iD, i, i2);
                if (dVarK != null) {
                    gVar.f(iD, dVarK);
                    iC = z ? dVarK.d() : dVarK.b();
                }
            }
            i3++;
        }
        return gVar;
    }

    private static int t(e eVar, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        int i4 = i - i3;
        d dVarB = u(eVar, i4) ? eVar.n(i4).b(i2) : null;
        if (dVarB != null) {
            return z ? dVarB.b() : dVarB.d();
        }
        d dVarC = eVar.n(i).c(i2);
        if (dVarC != null) {
            return z ? dVarC.d() : dVarC.b();
        }
        if (u(eVar, i4)) {
            dVarC = eVar.n(i4).c(i2);
        }
        if (dVarC != null) {
            return z ? dVarC.b() : dVarC.d();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (!u(eVar, i)) {
                c cVarM = eVar.m();
                return z ? cVarM.g() : cVarM.e();
            }
            for (d dVar : eVar.n(i).d()) {
                if (dVar != null) {
                    return (z ? dVar.b() : dVar.d()) + (i3 * i5 * (dVar.b() - dVar.d()));
                }
            }
            i5++;
        }
    }

    private static boolean u(e eVar, int i) {
        return i >= 0 && i <= eVar.j() + 1;
    }

    private static e v(g gVar, g gVar2) {
        a aVarL;
        if ((gVar == null && gVar2 == null) || (aVarL = l(gVar, gVar2)) == null) {
            return null;
        }
        return new e(aVarL, c.l(a(gVar), a(gVar2)));
    }

    private static void w(int[] iArr, int i) throws FormatException {
        if (iArr.length < 4) {
            throw FormatException.getFormatInstance();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw FormatException.getFormatInstance();
        }
        if (i2 == 0) {
            if (i >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            iArr[0] = iArr.length - i;
        }
    }
}
