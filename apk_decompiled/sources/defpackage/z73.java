package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.tencent.connect.common.Constants;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class z73 {
    private static final int[] c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    private final int[] a = new int[4];
    private final StringBuilder b = new StringBuilder();

    z73() {
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
        for (int i2 = 0; i2 < 5 && iF < iG; i2++) {
            int iJ = b83.j(uhVar, iArr2, iF, b83.h);
            sb.append((char) ((iJ % 10) + 48));
            for (int i3 : iArr2) {
                iF += i3;
            }
            if (iJ >= 10) {
                i |= 1 << (4 - i2);
            }
            if (i2 != 4) {
                iF = uhVar.f(uhVar.e(iF));
            }
        }
        if (sb.length() != 5) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (d(sb.toString()) == c(i)) {
            return iF;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int c(int i) throws NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == c[i2]) {
                return i2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i = length - 2; i >= 0; i -= 2) {
            iCharAt += charSequence.charAt(i) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            iCharAt2 += charSequence.charAt(i2) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    private static String e(String str) {
        String str2;
        String strValueOf;
        char cCharAt = str.charAt(0);
        if (cCharAt == '0') {
            str2 = "£";
        } else if (cCharAt != '5') {
            str2 = Constants.STR_EMPTY;
            if (cCharAt == '9') {
                if ("90000".equals(str)) {
                    return null;
                }
                if ("99991".equals(str)) {
                    return "0.00";
                }
                if ("99990".equals(str)) {
                    return "Used";
                }
            }
        } else {
            str2 = "$";
        }
        int i = Integer.parseInt(str.substring(1));
        String strValueOf2 = String.valueOf(i / 100);
        int i2 = i % 100;
        if (i2 < 10) {
            strValueOf = "0" + i2;
        } else {
            strValueOf = String.valueOf(i2);
        }
        return str2 + strValueOf2 + '.' + strValueOf;
    }

    private static Map f(String str) {
        String strE;
        if (str.length() != 5 || (strE = e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put(ResultMetadataType.SUGGESTED_PRICE, strE);
        return enumMap;
    }

    kh2 b(int i, uh uhVar, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.b;
        sb.setLength(0);
        int iA = a(uhVar, iArr, sb);
        String string = sb.toString();
        Map mapF = f(string);
        float f = i;
        kh2 kh2Var = new kh2(string, null, new nh2[]{new nh2((iArr[0] + iArr[1]) / 2.0f, f), new nh2(iA, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (mapF != null) {
            kh2Var.g(mapF);
        }
        return kh2Var;
    }
}
