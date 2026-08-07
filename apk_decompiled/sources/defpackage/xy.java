package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.jieli.jl_rcsp.constant.Command;
import java.util.Arrays;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public final class xy extends nw1 {
    static final int[] e;
    static final int f;
    private final boolean a;
    private final boolean b;
    private final StringBuilder c;
    private final int[] d;

    static {
        int[] iArr = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, Opcodes.I2B, 400, Command.CMD_NOTIFY_DEVICE_APP_INFO, 133, 388, 196, Opcodes.LCMP, Opcodes.JSR, 162, Opcodes.L2D, 42};
        e = iArr;
        f = iArr[39];
    }

    public xy() {
        this(false);
    }

    private static String h(CharSequence charSequence) throws FormatException {
        int i;
        char c;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt == '+' || cCharAt == '$' || cCharAt == '%' || cCharAt == '/') {
                i2++;
                char cCharAt2 = charSequence.charAt(i2);
                if (cCharAt != '$') {
                    if (cCharAt != '%') {
                        if (cCharAt != '+') {
                            if (cCharAt != '/') {
                                c = 0;
                            } else if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                                i = cCharAt2 - ' ';
                            } else {
                                if (cCharAt2 != 'Z') {
                                    throw FormatException.getFormatInstance();
                                }
                                c = ':';
                            }
                            sb.append(c);
                        } else {
                            if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            i = cCharAt2 + ' ';
                        }
                    } else if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                        i = cCharAt2 - '&';
                    } else {
                        if (cCharAt2 < 'F' || cCharAt2 > 'W') {
                            throw FormatException.getFormatInstance();
                        }
                        i = cCharAt2 - 11;
                    }
                } else {
                    if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                        throw FormatException.getFormatInstance();
                    }
                    i = cCharAt2 - '@';
                }
                c = (char) i;
                sb.append(c);
            } else {
                sb.append(cCharAt);
            }
            i2++;
        }
        return sb.toString();
    }

    private static int[] i(uh uhVar, int[] iArr) throws NotFoundException {
        int iG = uhVar.g();
        int iE = uhVar.e(0);
        int length = iArr.length;
        boolean z = false;
        int i = 0;
        int i2 = iE;
        while (iE < iG) {
            if (uhVar.c(iE) ^ z) {
                iArr[i] = iArr[i] + 1;
            } else {
                int i3 = length - 1;
                if (i != i3) {
                    i++;
                } else {
                    if (k(iArr) == f && uhVar.h(Math.max(0, i2 - ((iE - i2) / 2)), i2, false)) {
                        return new int[]{i2, iE};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i4 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i4);
                    iArr[i4] = 0;
                    iArr[i3] = 0;
                    i--;
                }
                iArr[i] = 1;
                z = !z;
            }
            iE++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static char j(int i) throws NotFoundException {
        int i2 = 0;
        while (true) {
            int[] iArr = e;
            if (i2 >= iArr.length) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (iArr[i2] == i) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".charAt(i2);
            }
            i2++;
        }
    }

    private static int k(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i5 |= 1 << ((length - 1) - i7);
                    i4++;
                    i6 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if ((i10 << 1) >= i6) {
                            return -1;
                        }
                    }
                }
                return i5;
            }
            if (i4 <= 3) {
                return -1;
            }
            i = i2;
        }
    }

    @Override // defpackage.nw1
    public kh2 c(int i, uh uhVar, Map map) throws NotFoundException, ChecksumException {
        int[] iArr = this.d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.c;
        sb.setLength(0);
        int[] iArrI = i(uhVar, iArr);
        int iE = uhVar.e(iArrI[1]);
        int iG = uhVar.g();
        while (true) {
            nw1.f(uhVar, iE, iArr);
            int iK = k(iArr);
            if (iK < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char cJ = j(iK);
            sb.append(cJ);
            int i2 = iE;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int iE2 = uhVar.e(i2);
            if (cJ == '*') {
                sb.setLength(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                int i6 = (iE2 - iE) - i4;
                if (iE2 != iG && (i6 << 1) < i4) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (this.a) {
                    int length = sb.length() - 1;
                    int iIndexOf = 0;
                    for (int i7 = 0; i7 < length; i7++) {
                        iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.c.charAt(i7));
                    }
                    if (sb.charAt(length) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(iIndexOf % 43)) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                float f2 = i;
                return new kh2(this.b ? h(sb) : sb.toString(), null, new nh2[]{new nh2((iArrI[1] + iArrI[0]) / 2.0f, f2), new nh2(iE + (i4 / 2.0f), f2)}, BarcodeFormat.CODE_39);
            }
            iE = iE2;
        }
    }

    public xy(boolean z) {
        this(z, false);
    }

    public xy(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
        this.c = new StringBuilder(20);
        this.d = new int[9];
    }
}
