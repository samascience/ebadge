package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.qrcode.decoder.d;
import com.google.zxing.qrcode.decoder.f;
import com.google.zxing.qrcode.detector.c;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class n92 implements cd2 {
    private static final nh2[] b = new nh2[0];
    private final d a = new d();

    private static wh c(wh whVar) throws NotFoundException {
        int[] iArrI = whVar.i();
        int[] iArrE = whVar.e();
        if (iArrI == null || iArrE == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float fD = d(iArrI, whVar);
        int i = iArrI[1];
        int i2 = iArrE[1];
        int i3 = iArrI[0];
        int i4 = iArrE[0];
        if (i3 >= i4 || i >= i2) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i5 = i2 - i;
        if (i5 != i4 - i3 && (i4 = i3 + i5) >= whVar.j()) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iRound = Math.round(((i4 - i3) + 1) / fD);
        int iRound2 = Math.round((i5 + 1) / fD);
        if (iRound <= 0 || iRound2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (iRound2 != iRound) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = (int) (fD / 2.0f);
        int i7 = i + i6;
        int i8 = i3 + i6;
        int i9 = (((int) ((iRound - 1) * fD)) + i8) - i4;
        if (i9 > 0) {
            if (i9 > i6) {
                throw NotFoundException.getNotFoundInstance();
            }
            i8 -= i9;
        }
        int i10 = (((int) ((iRound2 - 1) * fD)) + i7) - i2;
        if (i10 > 0) {
            if (i10 > i6) {
                throw NotFoundException.getNotFoundInstance();
            }
            i7 -= i10;
        }
        wh whVar2 = new wh(iRound, iRound2);
        for (int i11 = 0; i11 < iRound2; i11++) {
            int i12 = ((int) (i11 * fD)) + i7;
            for (int i13 = 0; i13 < iRound; i13++) {
                if (whVar.d(((int) (i13 * fD)) + i8, i12)) {
                    whVar2.l(i13, i11);
                }
            }
        }
        return whVar2;
    }

    private static float d(int[] iArr, wh whVar) throws NotFoundException {
        int iG = whVar.g();
        int iJ = whVar.j();
        int i = iArr[0];
        boolean z = true;
        int i2 = iArr[1];
        int i3 = 0;
        while (i < iJ && i2 < iG) {
            if (z != whVar.d(i, i2)) {
                i3++;
                if (i3 == 5) {
                    break;
                }
                z = !z;
            }
            i++;
            i2++;
        }
        if (i == iJ || i2 == iG) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (i - iArr[0]) / 7.0f;
    }

    @Override // defpackage.cd2
    public final kh2 a(th thVar, Map map) throws NotFoundException {
        nh2[] nh2VarArrB;
        q70 q70VarB;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            u90 u90VarE = new c(thVar.a()).e(map);
            q70 q70VarB2 = this.a.b(u90VarE.a(), map);
            nh2VarArrB = u90VarE.b();
            q70VarB = q70VarB2;
        } else {
            q70VarB = this.a.b(c(thVar.a()), map);
            nh2VarArrB = b;
        }
        if (q70VarB.d() instanceof f) {
            ((f) q70VarB.d()).a(nh2VarArrB);
        }
        kh2 kh2Var = new kh2(q70VarB.h(), q70VarB.e(), nh2VarArrB, BarcodeFormat.QR_CODE);
        List listA = q70VarB.a();
        if (listA != null) {
            kh2Var.h(ResultMetadataType.BYTE_SEGMENTS, listA);
        }
        String strB = q70VarB.b();
        if (strB != null) {
            kh2Var.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
        }
        if (q70VarB.i()) {
            kh2Var.h(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(q70VarB.g()));
            kh2Var.h(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(q70VarB.f()));
        }
        return kh2Var;
    }

    @Override // defpackage.cd2
    public void b() {
    }
}
