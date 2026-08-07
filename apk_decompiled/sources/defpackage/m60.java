package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.datamatrix.decoder.c;
import com.google.zxing.datamatrix.detector.Detector;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class m60 implements cd2 {
    private static final nh2[] b = new nh2[0];
    private final c a = new c();

    private static wh c(wh whVar) throws NotFoundException {
        int[] iArrI = whVar.i();
        int[] iArrE = whVar.e();
        if (iArrI == null || iArrE == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iD = d(iArrI, whVar);
        int i = iArrI[1];
        int i2 = iArrE[1];
        int i3 = iArrI[0];
        int i4 = ((iArrE[0] - i3) + 1) / iD;
        int i5 = ((i2 - i) + 1) / iD;
        if (i4 <= 0 || i5 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = iD / 2;
        int i7 = i + i6;
        int i8 = i3 + i6;
        wh whVar2 = new wh(i4, i5);
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = (i9 * iD) + i7;
            for (int i11 = 0; i11 < i4; i11++) {
                if (whVar.d((i11 * iD) + i8, i10)) {
                    whVar2.l(i11, i9);
                }
            }
        }
        return whVar2;
    }

    private static int d(int[] iArr, wh whVar) throws NotFoundException {
        int iJ = whVar.j();
        int i = iArr[0];
        int i2 = iArr[1];
        while (i < iJ && whVar.d(i, i2)) {
            i++;
        }
        if (i == iJ) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i3 = i - iArr[0];
        if (i3 != 0) {
            return i3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // defpackage.cd2
    public kh2 a(th thVar, Map map) throws NotFoundException, ChecksumException {
        nh2[] nh2VarArrB;
        q70 q70VarB;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            u90 u90VarC = new Detector(thVar.a()).c();
            q70 q70VarB2 = this.a.b(u90VarC.a());
            nh2VarArrB = u90VarC.b();
            q70VarB = q70VarB2;
        } else {
            q70VarB = this.a.b(c(thVar.a()));
            nh2VarArrB = b;
        }
        kh2 kh2Var = new kh2(q70VarB.h(), q70VarB.e(), nh2VarArrB, BarcodeFormat.DATA_MATRIX);
        List listA = q70VarB.a();
        if (listA != null) {
            kh2Var.h(ResultMetadataType.BYTE_SEGMENTS, listA);
        }
        String strB = q70VarB.b();
        if (strB != null) {
            kh2Var.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
        }
        return kh2Var;
    }

    @Override // defpackage.cd2
    public void b() {
    }
}
