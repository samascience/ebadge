package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes3.dex */
public final class c83 extends b83 {
    static final int[] j = {56, 52, 50, 49, 44, 38, 35, 42, 41, 37};
    private static final int[] k = {1, 1, 1, 1, 1, 1};
    private static final int[][] l = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    private final int[] i = new int[4];

    public static String r(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c);
                break;
        }
        sb.append(str.charAt(7));
        return sb.toString();
    }

    private static void s(StringBuilder sb, int i) throws NotFoundException {
        for (int i2 = 0; i2 <= 1; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (i == l[i2][i3]) {
                    sb.insert(0, (char) (i2 + 48));
                    sb.append((char) (i3 + 48));
                    return;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // defpackage.b83
    protected boolean h(String str) {
        return super.h(r(str));
    }

    @Override // defpackage.b83
    protected int[] k(uh uhVar, int i) {
        return b83.n(uhVar, i, true, k);
    }

    @Override // defpackage.b83
    protected int l(uh uhVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iG = uhVar.g();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 6 && i < iG; i3++) {
            int iJ = b83.j(uhVar, iArr2, i, b83.h);
            sb.append((char) ((iJ % 10) + 48));
            for (int i4 : iArr2) {
                i += i4;
            }
            if (iJ >= 10) {
                i2 |= 1 << (5 - i3);
            }
        }
        s(sb, i2);
        return i;
    }

    @Override // defpackage.b83
    BarcodeFormat q() {
        return BarcodeFormat.UPC_E;
    }
}
