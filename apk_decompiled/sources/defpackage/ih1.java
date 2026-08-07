package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ih1 implements cd2 {
    private static final nh2[] b = new nh2[0];
    private final o70 a = new o70();

    private static wh c(wh whVar) throws NotFoundException {
        int[] iArrF = whVar.f();
        if (iArrF == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i = iArrF[0];
        int i2 = iArrF[1];
        int i3 = iArrF[2];
        int i4 = iArrF[3];
        wh whVar2 = new wh(30, 33);
        for (int i5 = 0; i5 < 33; i5++) {
            int i6 = (((i5 * i4) + (i4 / 2)) / 33) + i2;
            for (int i7 = 0; i7 < 30; i7++) {
                if (whVar.d(((((i7 * i3) + (i3 / 2)) + (((i5 & 1) * i3) / 2)) / 30) + i, i6)) {
                    whVar2.l(i7, i5);
                }
            }
        }
        return whVar2;
    }

    @Override // defpackage.cd2
    public kh2 a(th thVar, Map map) throws NotFoundException, ChecksumException, FormatException {
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            throw NotFoundException.getNotFoundInstance();
        }
        q70 q70VarB = this.a.b(c(thVar.a()), map);
        kh2 kh2Var = new kh2(q70VarB.h(), q70VarB.e(), b, BarcodeFormat.MAXICODE);
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
