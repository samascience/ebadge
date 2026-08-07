package com.google.zxing.qrcode.decoder;

/* JADX INFO: loaded from: classes3.dex */
final class b {
    private final int a;
    private final byte[] b;

    private b(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    static b[] b(byte[] bArr, g gVar, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != gVar.h()) {
            throw new IllegalArgumentException();
        }
        g.b bVarF = gVar.f(errorCorrectionLevel);
        g.a[] aVarArrA = bVarF.a();
        int iA = 0;
        for (g.a aVar : aVarArrA) {
            iA += aVar.a();
        }
        b[] bVarArr = new b[iA];
        int i = 0;
        for (g.a aVar2 : aVarArrA) {
            int i2 = 0;
            while (i2 < aVar2.a()) {
                int iB = aVar2.b();
                bVarArr[i] = new b(iB, new byte[bVarF.b() + iB]);
                i2++;
                i++;
            }
        }
        int length = bVarArr[0].b.length;
        int i3 = iA - 1;
        while (i3 >= 0 && bVarArr[i3].b.length != length) {
            i3--;
        }
        int i4 = i3 + 1;
        int iB2 = length - bVarF.b();
        int i5 = 0;
        for (int i6 = 0; i6 < iB2; i6++) {
            int i7 = 0;
            while (i7 < i) {
                bVarArr[i7].b[i6] = bArr[i5];
                i7++;
                i5++;
            }
        }
        int i8 = i4;
        while (i8 < i) {
            bVarArr[i8].b[iB2] = bArr[i5];
            i8++;
            i5++;
        }
        int length2 = bVarArr[0].b.length;
        while (iB2 < length2) {
            int i9 = 0;
            while (i9 < i) {
                bVarArr[i9].b[i9 < i4 ? iB2 : iB2 + 1] = bArr[i5];
                i9++;
                i5++;
            }
            iB2++;
        }
        return bVarArr;
    }

    byte[] a() {
        return this.b;
    }

    int c() {
        return this.a;
    }
}
