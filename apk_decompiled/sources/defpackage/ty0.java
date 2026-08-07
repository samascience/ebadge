package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ty0 extends nw1 {
    private static final int[] b = {6, 8, 10, 12, 14};
    private static final int[] c = {1, 1, 1, 1};
    private static final int[] d = {1, 1, 3};
    static final int[][] e = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    private int a = -1;

    private static int h(int[] iArr) throws NotFoundException {
        int length = e.length;
        float f = 0.38f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float fE = nw1.e(iArr, e[i2], 0.78f);
            if (fE < f) {
                i = i2;
                f = fE;
            }
        }
        if (i >= 0) {
            return i;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int[] i(uh uhVar) {
        uhVar.j();
        try {
            int[] iArrL = l(uhVar, m(uhVar), d);
            n(uhVar, iArrL[0]);
            int i = iArrL[0];
            iArrL[0] = uhVar.g() - iArrL[1];
            iArrL[1] = uhVar.g() - i;
            return iArrL;
        } finally {
            uhVar.j();
        }
    }

    private static void j(uh uhVar, int i, int i2, StringBuilder sb) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i < i2) {
            nw1.f(uhVar, i, iArr);
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = i3 * 2;
                iArr2[i3] = iArr[i4];
                iArr3[i3] = iArr[i4 + 1];
            }
            sb.append((char) (h(iArr2) + 48));
            sb.append((char) (h(iArr3) + 48));
            for (int i5 = 0; i5 < 10; i5++) {
                i += iArr[i5];
            }
        }
    }

    private int[] k(uh uhVar) throws NotFoundException {
        int[] iArrL = l(uhVar, m(uhVar), c);
        int i = iArrL[1];
        int i2 = iArrL[0];
        this.a = (i - i2) / 4;
        n(uhVar, i2);
        return iArrL;
    }

    private static int[] l(uh uhVar, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iG = uhVar.g();
        int i2 = i;
        boolean z = false;
        int i3 = 0;
        while (i < iG) {
            if (uhVar.c(i) ^ z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                int i4 = length - 1;
                if (i3 != i4) {
                    i3++;
                } else {
                    if (nw1.e(iArr2, iArr, 0.78f) < 0.38f) {
                        return new int[]{i2, i};
                    }
                    i2 += iArr2[0] + iArr2[1];
                    int i5 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z = !z;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int m(uh uhVar) throws NotFoundException {
        int iG = uhVar.g();
        int iE = uhVar.e(0);
        if (iE != iG) {
            return iE;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void n(uh uhVar, int i) throws NotFoundException {
        int i2 = this.a * 10;
        if (i2 >= i) {
            i2 = i;
        }
        for (int i3 = i - 1; i2 > 0 && i3 >= 0 && !uhVar.c(i3); i3--) {
            i2--;
        }
        if (i2 != 0) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    @Override // defpackage.nw1
    public kh2 c(int i, uh uhVar, Map map) throws NotFoundException, FormatException {
        boolean z;
        int[] iArrK = k(uhVar);
        int[] iArrI = i(uhVar);
        StringBuilder sb = new StringBuilder(20);
        j(uhVar, iArrK[1], iArrI[0], sb);
        String string = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = b;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length2) {
                z = false;
                break;
            }
            int i4 = iArr[i2];
            if (length == i4) {
                z = true;
                break;
            }
            if (i4 > i3) {
                i3 = i4;
            }
            i2++;
        }
        if (!z && length > i3) {
            z = true;
        }
        if (!z) {
            throw FormatException.getFormatInstance();
        }
        float f = i;
        return new kh2(string, null, new nh2[]{new nh2(iArrK[1], f), new nh2(iArrI[0], f)}, BarcodeFormat.ITF);
    }
}
