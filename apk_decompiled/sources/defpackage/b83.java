package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b83 extends nw1 {
    static final int[] d = {1, 1, 1};
    static final int[] e = {1, 1, 1, 1, 1};
    static final int[] f = {1, 1, 1, 1, 1, 1};
    static final int[][] g;
    static final int[][] h;
    private final StringBuilder a = new StringBuilder(20);
    private final a83 b = new a83();
    private final we0 c = new we0();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        g = iArr;
        int[][] iArr2 = new int[20][];
        h = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = g[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            h[i] = iArr4;
        }
    }

    protected b83() {
    }

    static boolean i(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            int iCharAt = charSequence.charAt(i2) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i += iCharAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            int iCharAt2 = charSequence.charAt(i4) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i3 += iCharAt2;
        }
        return i3 % 10 == 0;
    }

    static int j(uh uhVar, int[] iArr, int i, int[][] iArr2) throws NotFoundException {
        nw1.f(uhVar, i, iArr);
        int length = iArr2.length;
        float f2 = 0.48f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fE = nw1.e(iArr, iArr2[i3], 0.7f);
            if (fE < f2) {
                i2 = i3;
                f2 = fE;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    static int[] n(uh uhVar, int i, boolean z, int[] iArr) {
        return o(uhVar, i, z, iArr, new int[iArr.length]);
    }

    private static int[] o(uh uhVar, int i, boolean z, int[] iArr, int[] iArr2) throws NotFoundException {
        int iG = uhVar.g();
        int iF = z ? uhVar.f(i) : uhVar.e(i);
        int length = iArr.length;
        boolean z2 = z;
        int i2 = 0;
        int i3 = iF;
        while (iF < iG) {
            if (uhVar.c(iF) ^ z2) {
                iArr2[i2] = iArr2[i2] + 1;
            } else {
                int i4 = length - 1;
                if (i2 != i4) {
                    i2++;
                } else {
                    if (nw1.e(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i3, iF};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i5 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i2--;
                }
                iArr2[i2] = 1;
                z2 = !z2;
            }
            iF++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    static int[] p(uh uhVar) throws NotFoundException {
        int[] iArr = new int[d.length];
        int[] iArrO = null;
        boolean zH = false;
        int i = 0;
        while (!zH) {
            int[] iArr2 = d;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrO = o(uhVar, i, false, iArr2, iArr);
            int i2 = iArrO[0];
            int i3 = iArrO[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                zH = uhVar.h(i4, i2, false);
            }
            i = i3;
        }
        return iArrO;
    }

    @Override // defpackage.nw1
    public kh2 c(int i, uh uhVar, Map map) {
        return m(i, uhVar, p(uhVar), map);
    }

    boolean h(String str) {
        return i(str);
    }

    int[] k(uh uhVar, int i) {
        return n(uhVar, i, false, d);
    }

    protected abstract int l(uh uhVar, int[] iArr, StringBuilder sb);

    public kh2 m(int i, uh uhVar, int[] iArr, Map map) throws NotFoundException, ChecksumException, FormatException {
        int length;
        String strC;
        if (map != null) {
            e43.a(map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK));
        }
        StringBuilder sb = this.a;
        int i2 = 0;
        sb.setLength(0);
        int[] iArrK = k(uhVar, l(uhVar, iArr, sb));
        int i3 = iArrK[1];
        int i4 = (i3 - iArrK[0]) + i3;
        if (i4 >= uhVar.g() || !uhVar.h(i3, i4, false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        String string = sb.toString();
        if (string.length() < 8) {
            throw FormatException.getFormatInstance();
        }
        if (!h(string)) {
            throw ChecksumException.getChecksumInstance();
        }
        float f2 = (iArr[1] + iArr[0]) / 2.0f;
        float f3 = (iArrK[1] + iArrK[0]) / 2.0f;
        BarcodeFormat barcodeFormatQ = q();
        float f4 = i;
        kh2 kh2Var = new kh2(string, null, new nh2[]{new nh2(f2, f4), new nh2(f3, f4)}, barcodeFormatQ);
        try {
            kh2 kh2VarA = this.b.a(i, uhVar, iArrK[1]);
            kh2Var.h(ResultMetadataType.UPC_EAN_EXTENSION, kh2VarA.f());
            kh2Var.g(kh2VarA.d());
            kh2Var.a(kh2VarA.e());
            length = kh2VarA.f().length();
        } catch (ReaderException unused) {
            length = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            int length2 = iArr2.length;
            while (true) {
                if (i2 >= length2) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (length == iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        if ((barcodeFormatQ == BarcodeFormat.EAN_13 || barcodeFormatQ == BarcodeFormat.UPC_A) && (strC = this.c.c(string)) != null) {
            kh2Var.h(ResultMetadataType.POSSIBLE_COUNTRY, strC);
        }
        return kh2Var;
    }

    abstract BarcodeFormat q();
}
