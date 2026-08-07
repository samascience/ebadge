package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import defpackage.wh;

/* JADX INFO: loaded from: classes3.dex */
final class a {
    private final wh a;
    private final wh b;
    private final d c;

    a(wh whVar) throws FormatException {
        int iG = whVar.g();
        if (iG < 8 || iG > 144 || (iG & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.c = j(whVar);
        wh whVarA = a(whVar);
        this.a = whVarA;
        this.b = new wh(whVarA.j(), whVarA.g());
    }

    private wh a(wh whVar) {
        int iF = this.c.f();
        int iE = this.c.e();
        if (whVar.g() != iF) {
            throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
        }
        int iC = this.c.c();
        int iB = this.c.b();
        int i = iF / iC;
        int i2 = iE / iB;
        wh whVar2 = new wh(i2 * iB, i * iC);
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * iC;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i5 * iB;
                for (int i7 = 0; i7 < iC; i7++) {
                    int i8 = ((iC + 2) * i3) + 1 + i7;
                    int i9 = i4 + i7;
                    for (int i10 = 0; i10 < iB; i10++) {
                        if (whVar.d(((iB + 2) * i5) + 1 + i10, i8)) {
                            whVar2.l(i6 + i10, i9);
                        }
                    }
                }
            }
        }
        return whVar2;
    }

    private int d(int i, int i2) {
        int i3 = i - 1;
        int i4 = (h(i3, 0, i, i2) ? 1 : 0) << 1;
        if (h(i3, 1, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(i3, 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(0, i2 - 2, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i2 - 1;
        if (h(0, i8, i, i2)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (h(1, i8, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (h(2, i8, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return h(3, i8, i, i2) ? i11 | 1 : i11;
    }

    private int e(int i, int i2) {
        int i3 = (h(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (h(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (h(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(0, i2 - 4, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(0, i2 - 3, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (h(0, i2 - 2, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i2 - 1;
        if (h(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        return h(1, i9, i, i2) ? i10 | 1 : i10;
    }

    private int f(int i, int i2) {
        int i3 = i - 1;
        int i4 = (h(i3, 0, i, i2) ? 1 : 0) << 1;
        int i5 = i2 - 1;
        if (h(i3, i5, i, i2)) {
            i4 |= 1;
        }
        int i6 = i4 << 1;
        int i7 = i2 - 3;
        if (h(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        int i9 = i2 - 2;
        if (h(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (h(0, i5, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (h(1, i7, i, i2)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(1, i9, i, i2)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        return h(1, i5, i, i2) ? i13 | 1 : i13;
    }

    private int g(int i, int i2) {
        int i3 = (h(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (h(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (h(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        int i7 = i2 - 1;
        if (h(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        if (h(1, i7, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (h(2, i7, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        return h(3, i7, i, i2) ? i10 | 1 : i10;
    }

    private boolean h(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.b.l(i2, i);
        return this.a.d(i2, i);
    }

    private int i(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (h(i5, i6, i3, i4) ? 1 : 0) << 1;
        int i8 = i2 - 1;
        if (h(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (h(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (h(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return h(i, i2, i3, i4) ? i15 | 1 : i15;
    }

    private static d j(wh whVar) {
        return d.h(whVar.g(), whVar.j());
    }

    d b() {
        return this.c;
    }

    byte[] c() throws FormatException {
        byte[] bArr = new byte[this.c.g()];
        int iG = this.a.g();
        int iJ = this.a.j();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i3 = 4;
        while (true) {
            if (i3 == iG && i == 0 && !z) {
                bArr[i2] = (byte) d(iG, iJ);
                i3 -= 2;
                i += 2;
                i2++;
                z = true;
            } else {
                int i4 = iG - 2;
                if (i3 == i4 && i == 0 && (iJ & 3) != 0 && !z2) {
                    bArr[i2] = (byte) e(iG, iJ);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z2 = true;
                } else if (i3 == iG + 4 && i == 2 && (iJ & 7) == 0 && !z3) {
                    bArr[i2] = (byte) f(iG, iJ);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z3 = true;
                } else if (i3 == i4 && i == 0 && (iJ & 7) == 4 && !z4) {
                    bArr[i2] = (byte) g(iG, iJ);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z4 = true;
                } else {
                    while (true) {
                        if (i3 < iG && i >= 0 && !this.b.d(i, i3)) {
                            bArr[i2] = (byte) i(i3, i, iG, iJ);
                            i2++;
                        }
                        int i5 = i3 - 2;
                        int i6 = i + 2;
                        if (i5 < 0 || i6 >= iJ) {
                            break;
                        }
                        i3 = i5;
                        i = i6;
                    }
                    int i7 = i3 - 1;
                    int i8 = i + 5;
                    while (true) {
                        if (i7 >= 0 && i8 < iJ && !this.b.d(i8, i7)) {
                            bArr[i2] = (byte) i(i7, i8, iG, iJ);
                            i2++;
                        }
                        int i9 = i7 + 2;
                        int i10 = i8 - 2;
                        if (i9 >= iG || i10 < 0) {
                            break;
                        }
                        i7 = i9;
                        i8 = i10;
                    }
                    i3 = i7 + 5;
                    i = i8 - 1;
                }
            }
            if (i3 >= iG && i >= iJ) {
                break;
            }
        }
        if (i2 == this.c.g()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }
}
