package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import defpackage.py1;
import defpackage.q70;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
abstract class DecodedBitStreamParser {
    private static final char[] a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final Charset c = Charset.forName("ISO-8859-1");
    private static final BigInteger[] d;

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Mode.values().length];
            a = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        d = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = d;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(bigIntegerValueOf);
            i++;
        }
    }

    private static int a(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int i3;
        int i4;
        int i5;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i6 = 922;
        int i7 = 923;
        int i8 = 928;
        long j = 900;
        if (i == 901) {
            int[] iArr2 = new int[6];
            i3 = i2 + 1;
            int i9 = iArr[i2];
            long j2 = 0;
            boolean z = false;
            int i10 = 0;
            while (true) {
                i4 = iArr[0];
                if (i3 >= i4 || z) {
                    break;
                }
                int i11 = i10 + 1;
                iArr2[i10] = i9;
                j2 = (j2 * j) + ((long) i9);
                int i12 = i3 + 1;
                i9 = iArr[i3];
                if (i9 == 900 || i9 == 901 || i9 == 902 || i9 == 924 || i9 == 928 || i9 == i7 || i9 == i6) {
                    i10 = i11;
                    i6 = 922;
                    i7 = 923;
                    j = 900;
                    z = true;
                } else if (i11 % 5 != 0 || i11 <= 0) {
                    i3 = i12;
                    i10 = i11;
                    i6 = 922;
                    i7 = 923;
                    j = 900;
                } else {
                    int i13 = 0;
                    while (i13 < 6) {
                        byteArrayOutputStream.write((byte) (j2 >> ((5 - i13) * 8)));
                        i13++;
                        i6 = 922;
                        i7 = 923;
                    }
                    i3 = i12;
                    i10 = 0;
                    j = 900;
                    j2 = 0;
                }
            }
            if (i3 != i4 || i9 >= 900) {
                i5 = i10;
            } else {
                i5 = i10 + 1;
                iArr2[i10] = i9;
            }
            for (int i14 = 0; i14 < i5; i14++) {
                byteArrayOutputStream.write((byte) iArr2[i14]);
            }
        } else if (i == 924) {
            int i15 = i2;
            boolean z2 = false;
            int i16 = 0;
            long j3 = 0;
            while (i15 < iArr[0] && !z2) {
                int i17 = i15 + 1;
                int i18 = iArr[i15];
                if (i18 < 900) {
                    i16++;
                    j3 = (j3 * 900) + ((long) i18);
                    i15 = i17;
                } else {
                    if (i18 != 900 && i18 != 901 && i18 != 902 && i18 != 924 && i18 != i8) {
                        if (i18 != 923 && i18 != 922) {
                            i15 = i17;
                        }
                    }
                    z2 = true;
                }
                if (i16 % 5 == 0 && i16 > 0) {
                    for (int i19 = 0; i19 < 6; i19++) {
                        byteArrayOutputStream.write((byte) (j3 >> ((5 - i19) * 8)));
                    }
                    i16 = 0;
                    j3 = 0;
                }
                i8 = 928;
            }
            i3 = i15;
        } else {
            i3 = i2;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x004e  */
    static q70 b(int[] iArr, String str) throws FormatException {
        int iG;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charsetForName = c;
        int i = iArr[1];
        py1 py1Var = new py1();
        int i2 = 2;
        while (i2 < iArr[0]) {
            if (i != 913) {
                switch (i) {
                    case 900:
                        iG = g(iArr, i2, sb);
                        break;
                    case 901:
                        iG = a(i, iArr, charsetForName, i2, sb);
                        break;
                    case 902:
                        iG = f(iArr, i2, sb);
                        break;
                    default:
                        switch (i) {
                            case 922:
                            case 923:
                                throw FormatException.getFormatInstance();
                            case 924:
                                iG = a(i, iArr, charsetForName, i2, sb);
                                break;
                            case 925:
                                iG = i2 + 1;
                                break;
                            case 926:
                                iG = i2 + 2;
                                break;
                            case 927:
                                iG = i2 + 1;
                                charsetForName = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i2]).name());
                                break;
                            case 928:
                                iG = d(iArr, i2, py1Var);
                                break;
                            default:
                                iG = g(iArr, i2 - 1, sb);
                                break;
                        }
                        break;
                }
            } else {
                iG = i2 + 1;
                sb.append((char) iArr[i2]);
            }
            if (iG >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            i2 = iG + 1;
            i = iArr[iG];
        }
        if (sb.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        q70 q70Var = new q70(null, sb.toString(), null, str);
        q70Var.m(py1Var);
        return q70Var;
    }

    private static String c(int[] iArr, int i) throws FormatException {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigIntegerAdd = bigIntegerAdd.add(d[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    private static int d(int[] iArr, int i, py1 py1Var) throws FormatException {
        if (i + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i2 = 0;
        while (i2 < 2) {
            iArr2[i2] = iArr[i];
            i2++;
            i++;
        }
        py1Var.d(Integer.parseInt(c(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int iG = g(iArr, i, sb);
        py1Var.a(sb.toString());
        int i3 = iArr[iG];
        if (i3 != 923) {
            if (i3 != 922) {
                return iG;
            }
            py1Var.b(true);
            return iG + 1;
        }
        int i4 = iG + 1;
        int[] iArr3 = new int[iArr[0] - i4];
        boolean z = false;
        int i5 = 0;
        while (i4 < iArr[0] && !z) {
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            if (i7 < 900) {
                iArr3[i5] = i7;
                i5++;
                i4 = i6;
            } else {
                if (i7 != 922) {
                    throw FormatException.getFormatInstance();
                }
                py1Var.b(true);
                i4 += 2;
                z = true;
            }
        }
        py1Var.c(Arrays.copyOf(iArr3, i5));
        return i4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void e(int[] iArr, int[] iArr2, int i, StringBuilder sb) {
        Mode mode;
        int i2;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = mode2;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            char c2 = ' ';
            switch (a.a[mode2.ordinal()]) {
                case 1:
                    if (i4 < 26) {
                        i2 = i4 + 65;
                        c2 = (char) i2;
                    } else if (i4 != 26) {
                        if (i4 == 27) {
                            mode2 = Mode.LOWER;
                        } else if (i4 == 28) {
                            mode2 = Mode.MIXED;
                        } else if (i4 == 29) {
                            mode = Mode.PUNCT_SHIFT;
                            c2 = 0;
                            Mode mode4 = mode;
                            mode3 = mode2;
                            mode2 = mode4;
                            break;
                        } else if (i4 == 913) {
                            sb.append((char) iArr2[i3]);
                        } else if (i4 == 900) {
                            mode2 = Mode.ALPHA;
                        }
                        c2 = 0;
                    }
                    break;
                case 2:
                    if (i4 < 26) {
                        i2 = i4 + 97;
                        c2 = (char) i2;
                    } else if (i4 != 26) {
                        if (i4 != 27) {
                            if (i4 == 28) {
                                mode2 = Mode.MIXED;
                            } else if (i4 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                            } else if (i4 == 913) {
                                sb.append((char) iArr2[i3]);
                            } else if (i4 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            c2 = 0;
                        } else {
                            mode = Mode.ALPHA_SHIFT;
                        }
                        c2 = 0;
                        Mode mode5 = mode;
                        mode3 = mode2;
                        mode2 = mode5;
                    }
                    break;
                case 3:
                    if (i4 < 25) {
                        c2 = b[i4];
                    } else {
                        if (i4 == 25) {
                            mode2 = Mode.PUNCT;
                        } else if (i4 != 26) {
                            if (i4 == 27) {
                                mode2 = Mode.LOWER;
                            } else if (i4 == 28) {
                                mode2 = Mode.ALPHA;
                            } else if (i4 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                                c2 = 0;
                                Mode mode6 = mode;
                                mode3 = mode2;
                                mode2 = mode6;
                                break;
                            } else if (i4 == 913) {
                                sb.append((char) iArr2[i3]);
                            } else if (i4 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                        }
                        c2 = 0;
                    }
                    break;
                case 4:
                    if (i4 < 29) {
                        c2 = a[i4];
                    } else {
                        if (i4 == 29) {
                            mode2 = Mode.ALPHA;
                        } else if (i4 == 913) {
                            sb.append((char) iArr2[i3]);
                        } else if (i4 == 900) {
                            mode2 = Mode.ALPHA;
                        }
                        c2 = 0;
                    }
                    break;
                case 5:
                    if (i4 < 26) {
                        c2 = (char) (i4 + 65);
                    } else if (i4 != 26) {
                        if (i4 == 900) {
                            mode2 = Mode.ALPHA;
                            c2 = 0;
                        }
                        c2 = 0;
                    }
                    mode2 = mode3;
                    break;
                case 6:
                    if (i4 >= 29) {
                        if (i4 == 29) {
                            mode2 = Mode.ALPHA;
                        } else {
                            if (i4 == 913) {
                                sb.append((char) iArr2[i3]);
                            } else if (i4 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            c2 = 0;
                        }
                        c2 = 0;
                    } else {
                        c2 = a[i4];
                    }
                    mode2 = mode3;
                    break;
                default:
                    c2 = 0;
                    break;
            }
            if (c2 != 0) {
                sb.append(c2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0007 A[SYNTHETIC] */
    private static int f(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (true) {
            int i3 = iArr[0];
            if (i >= i3 || z) {
                break;
            }
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i4 == i3) {
                z = true;
            }
            if (i5 < 900) {
                iArr2[i2] = i5;
                i2++;
            } else {
                if (i5 == 900 || i5 == 901 || i5 == 924 || i5 == 928 || i5 == 923 || i5 == 922) {
                    z = true;
                }
                if (i2 % 15 != 0 || i5 == 902 || z) {
                    if (i2 > 0) {
                        sb.append(c(iArr2, i2));
                        i2 = 0;
                    }
                }
            }
            i = i4;
            if (i2 % 15 != 0) {
            }
            if (i2 > 0) {
                sb.append(c(iArr2, i2));
                i2 = 0;
            }
        }
        return i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0033. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0036. Please report as an issue. */
    private static int g(int[] iArr, int i, StringBuilder sb) {
        int i2 = iArr[0];
        int[] iArr2 = new int[(i2 - i) << 1];
        int[] iArr3 = new int[(i2 - i) << 1];
        boolean z = false;
        int i3 = 0;
        while (i < iArr[0] && !z) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 != 913) {
                if (i5 != 928) {
                    switch (i5) {
                        case 900:
                            iArr2[i3] = 900;
                            i3++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i5) {
                                case 922:
                                case 923:
                                case 924:
                                    break;
                                default:
                                    break;
                            }
                            break;
                    }
                }
                z = true;
            } else {
                iArr2[i3] = 913;
                i += 2;
                iArr3[i3] = iArr[i4];
                i3++;
            }
            i = i4;
        }
        e(iArr2, iArr3, i3, sb);
        return i;
    }
}
