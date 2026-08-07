package defpackage;

import com.google.zxing.BarcodeFormat;

/* JADX INFO: loaded from: classes3.dex */
public final class ve0 extends b83 {
    private final int[] i = new int[4];

    @Override // defpackage.b83
    protected int l(uh uhVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iG = uhVar.g();
        int i = iArr[1];
        for (int i2 = 0; i2 < 4 && i < iG; i2++) {
            sb.append((char) (b83.j(uhVar, iArr2, i, b83.g) + 48));
            for (int i3 : iArr2) {
                i += i3;
            }
        }
        int i4 = b83.n(uhVar, i, true, b83.e)[1];
        for (int i5 = 0; i5 < 4 && i4 < iG; i5++) {
            sb.append((char) (b83.j(uhVar, iArr2, i4, b83.g) + 48));
            for (int i6 : iArr2) {
                i4 += i6;
            }
        }
        return i4;
    }

    @Override // defpackage.b83
    BarcodeFormat q() {
        return BarcodeFormat.EAN_8;
    }
}
