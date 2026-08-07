package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes3.dex */
public final class ue0 extends b83 {
    static final int[] j = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] i = new int[4];

    private static void r(StringBuilder sb, int i) throws NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == j[i2]) {
                sb.insert(0, (char) (i2 + 48));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
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
        r(sb, i2);
        int i5 = b83.n(uhVar, i, true, b83.e)[1];
        for (int i6 = 0; i6 < 6 && i5 < iG; i6++) {
            sb.append((char) (b83.j(uhVar, iArr2, i5, b83.g) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    @Override // defpackage.b83
    BarcodeFormat q() {
        return BarcodeFormat.EAN_13;
    }
}
