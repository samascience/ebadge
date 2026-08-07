package com.google.zxing.qrcode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import defpackage.je2;
import defpackage.jt0;
import defpackage.q70;
import defpackage.wh;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private final je2 a = new je2(jt0.l);

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

    private q70 c(a aVar, Map map) throws ChecksumException, FormatException {
        g gVarE = aVar.e();
        ErrorCorrectionLevel errorCorrectionLevelD = aVar.d().d();
        b[] bVarArrB = b.b(aVar.c(), gVarE, errorCorrectionLevelD);
        int iC = 0;
        for (b bVar : bVarArrB) {
            iC += bVar.c();
        }
        byte[] bArr = new byte[iC];
        int i = 0;
        for (b bVar2 : bVarArrB) {
            byte[] bArrA = bVar2.a();
            int iC2 = bVar2.c();
            a(bArrA, iC2);
            int i2 = 0;
            while (i2 < iC2) {
                bArr[i] = bArrA[i2];
                i2++;
                i++;
            }
        }
        return c.a(bArr, gVarE, errorCorrectionLevelD, map);
    }

    public q70 b(wh whVar, Map map) {
        ChecksumException e;
        a aVar = new a(whVar);
        FormatException formatException = null;
        try {
            return c(aVar, map);
        } catch (ChecksumException e2) {
            e = e2;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                q70 q70VarC = c(aVar, map);
                q70VarC.m(new f(true));
                return q70VarC;
            } catch (ChecksumException | FormatException e3) {
                if (formatException != null) {
                    throw formatException;
                }
                if (e != null) {
                    throw e;
                }
                throw e3;
            }
        } catch (FormatException e4) {
            e = null;
            formatException = e4;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            q70 q70VarC2 = c(aVar, map);
            q70VarC2.m(new f(true));
            return q70VarC2;
        }
    }
}
