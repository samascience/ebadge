package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import defpackage.wh;

/* JADX INFO: loaded from: classes3.dex */
final class a {
    private final wh a;
    private g b;
    private e c;
    private boolean d;

    a(wh whVar) throws FormatException {
        int iG = whVar.g();
        if (iG < 21 || (iG & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.a = whVar;
    }

    private int a(int i, int i2, int i3) {
        return this.d ? this.a.d(i2, i) : this.a.d(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    void b() {
        int i = 0;
        while (i < this.a.j()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.a.g(); i3++) {
                if (this.a.d(i, i3) != this.a.d(i3, i)) {
                    this.a.c(i3, i);
                    this.a.c(i, i3);
                }
            }
            i = i2;
        }
    }

    byte[] c() throws FormatException {
        e eVarD = d();
        g gVarE = e();
        DataMask dataMask = DataMask.values()[eVarD.c()];
        int iG = this.a.g();
        dataMask.unmaskBitMatrix(this.a, iG);
        wh whVarA = gVarE.a();
        byte[] bArr = new byte[gVarE.h()];
        int i = iG - 1;
        boolean z = true;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            for (int i6 = 0; i6 < iG; i6++) {
                int i7 = z ? i - i6 : i6;
                for (int i8 = 0; i8 < 2; i8++) {
                    int i9 = i2 - i8;
                    if (!whVarA.d(i9, i7)) {
                        i4++;
                        i5 <<= 1;
                        if (this.a.d(i9, i7)) {
                            i5 |= 1;
                        }
                        if (i4 == 8) {
                            bArr[i3] = (byte) i5;
                            i3++;
                            i4 = 0;
                            i5 = 0;
                        }
                    }
                }
            }
            z = !z;
            i2 -= 2;
        }
        if (i3 == gVarE.h()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    e d() throws FormatException {
        e eVar = this.c;
        if (eVar != null) {
            return eVar;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i = 0; i < 6; i++) {
            iA2 = a(i, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iA3 = a(8, i2, iA3);
        }
        int iG = this.a.g();
        int i3 = iG - 7;
        for (int i4 = iG - 1; i4 >= i3; i4--) {
            iA = a(8, i4, iA);
        }
        for (int i5 = iG - 8; i5 < iG; i5++) {
            iA = a(i5, 8, iA);
        }
        e eVarA = e.a(iA3, iA);
        this.c = eVarA;
        if (eVarA != null) {
            return eVarA;
        }
        throw FormatException.getFormatInstance();
    }

    g e() throws FormatException {
        g gVar = this.b;
        if (gVar != null) {
            return gVar;
        }
        int iG = this.a.g();
        int i = (iG - 17) / 4;
        if (i <= 6) {
            return g.i(i);
        }
        int i2 = iG - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i3 = 5; i3 >= 0; i3--) {
            for (int i4 = iG - 9; i4 >= i2; i4--) {
                iA2 = a(i4, i3, iA2);
            }
        }
        g gVarC = g.c(iA2);
        if (gVarC != null && gVarC.e() == iG) {
            this.b = gVarC;
            return gVarC;
        }
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = iG - 9; i6 >= i2; i6--) {
                iA = a(i5, i6, iA);
            }
        }
        g gVarC2 = g.c(iA);
        if (gVarC2 == null || gVarC2.e() != iG) {
            throw FormatException.getFormatInstance();
        }
        this.b = gVarC2;
        return gVarC2;
    }

    void f() {
        if (this.c == null) {
            return;
        }
        DataMask.values()[this.c.c()].unmaskBitMatrix(this.a, this.a.g());
    }

    void g(boolean z) {
        this.b = null;
        this.c = null;
        this.d = z;
    }
}
