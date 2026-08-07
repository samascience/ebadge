package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class y73 {
    private final int[] a = new int[4];
    private final StringBuilder b = new StringBuilder();

    y73() {
    }

    private int a(uh uhVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iG = uhVar.g();
        int iF = iArr[1];
        int i = 0;
        for (int i2 = 0; i2 < 2 && iF < iG; i2++) {
            int iJ = b83.j(uhVar, iArr2, iF, b83.h);
            sb.append((char) ((iJ % 10) + 48));
            for (int i3 : iArr2) {
                iF += i3;
            }
            if (iJ >= 10) {
                i |= 1 << (1 - i2);
            }
            if (i2 != 1) {
                iF = uhVar.f(uhVar.e(iF));
            }
        }
        if (sb.length() != 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (Integer.parseInt(sb.toString()) % 4 == i) {
            return iF;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static Map c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put(ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }

    kh2 b(int i, uh uhVar, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.b;
        sb.setLength(0);
        int iA = a(uhVar, iArr, sb);
        String string = sb.toString();
        Map mapC = c(string);
        float f = i;
        kh2 kh2Var = new kh2(string, null, new nh2[]{new nh2((iArr[0] + iArr[1]) / 2.0f, f), new nh2(iA, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (mapC != null) {
            kh2Var.g(mapC);
        }
        return kh2Var;
    }
}
