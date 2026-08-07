package com.google.zxing.datamatrix.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import defpackage.je2;
import defpackage.jt0;
import defpackage.q70;
import defpackage.wh;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private final je2 a = new je2(jt0.m);

    private void a(byte[] bArr, int i) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public q70 b(wh whVar) throws ChecksumException {
        a aVar = new a(whVar);
        b[] bVarArrB = b.b(aVar.c(), aVar.b());
        int iC = 0;
        for (b bVar : bVarArrB) {
            iC += bVar.c();
        }
        byte[] bArr = new byte[iC];
        int length = bVarArrB.length;
        for (int i = 0; i < length; i++) {
            b bVar2 = bVarArrB[i];
            byte[] bArrA = bVar2.a();
            int iC2 = bVar2.c();
            a(bArrA, iC2);
            for (int i2 = 0; i2 < iC2; i2++) {
                bArr[(i2 * length) + i] = bArrA[i2];
            }
        }
        return DecodedBitStreamParser.a(bArr);
    }
}
