package com.google.zxing.aztec.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import defpackage.ae;
import defpackage.je2;
import defpackage.jt0;
import defpackage.q70;
import defpackage.wh;
import java.util.Arrays;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
public final class Decoder {
    private static final String[] b = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] c = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] e = {Constants.STR_EMPTY, "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", Marker.ANY_MARKER, Marker.ANY_NON_NULL_MARKER, ",", "-", FileUtils.FILE_EXTENSION_SEPARATOR, WatchConstant.FAT_FS_ROOT, ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] f = {"CTRL_PS", " ", "0", "1", "2", "3", Constants.VIA_TO_TYPE_QZONE, "5", Constants.VIA_SHARE_TYPE_INFO, "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_SHARE_TYPE_MINI_PROGRAM, ",", FileUtils.FILE_EXTENSION_SEPARATOR, "CTRL_UL", "CTRL_US"};
    private ae a;

    private enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Table.values().length];
            a = iArr;
            try {
                iArr[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = h(zArr, i << 3);
        }
        return bArr;
    }

    private boolean[] b(boolean[] zArr) throws FormatException {
        int i;
        jt0 jt0Var;
        if (this.a.d() <= 2) {
            jt0Var = jt0.j;
            i = 6;
        } else {
            i = 8;
            if (this.a.d() <= 8) {
                jt0Var = jt0.n;
            } else if (this.a.d() <= 22) {
                jt0Var = jt0.i;
                i = 10;
            } else {
                jt0Var = jt0.h;
                i = 12;
            }
        }
        int iC = this.a.c();
        int length = zArr.length / i;
        if (length < iC) {
            throw FormatException.getFormatInstance();
        }
        int length2 = zArr.length % i;
        int[] iArr = new int[length];
        int i2 = 0;
        while (i2 < length) {
            iArr[i2] = i(zArr, length2, i);
            i2++;
            length2 += i;
        }
        try {
            new je2(jt0Var).a(iArr, length - iC);
            int i3 = 1 << i;
            int i4 = i3 - 1;
            int i5 = 0;
            for (int i6 = 0; i6 < iC; i6++) {
                int i7 = iArr[i6];
                if (i7 == 0 || i7 == i4) {
                    throw FormatException.getFormatInstance();
                }
                if (i7 == 1 || i7 == i3 - 2) {
                    i5++;
                }
            }
            boolean[] zArr2 = new boolean[(iC * i) - i5];
            int i8 = 0;
            for (int i9 = 0; i9 < iC; i9++) {
                int i10 = iArr[i9];
                if (i10 == 1 || i10 == i3 - 2) {
                    Arrays.fill(zArr2, i8, (i8 + i) - 1, i10 > 1);
                    i8 += i - 1;
                } else {
                    int i11 = i - 1;
                    while (i11 >= 0) {
                        int i12 = i8 + 1;
                        zArr2[i8] = ((1 << i11) & i10) != 0;
                        i11--;
                        i8 = i12;
                    }
                }
            }
            return zArr2;
        } catch (ReedSolomonException e2) {
            throw FormatException.getFormatInstance(e2);
        }
    }

    private boolean[] d(wh whVar) {
        boolean zE = this.a.e();
        int iD = this.a.d();
        int i = (zE ? 11 : 14) + (iD << 2);
        int[] iArr = new int[i];
        boolean[] zArr = new boolean[j(iD, zE)];
        int i2 = 2;
        if (zE) {
            for (int i3 = 0; i3 < i; i3++) {
                iArr[i3] = i3;
            }
        } else {
            int i4 = i / 2;
            int i5 = ((i + 1) + (((i4 - 1) / 15) * 2)) / 2;
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = (i6 / 15) + i6;
                iArr[(i4 - i6) - 1] = (i5 - i7) - 1;
                iArr[i4 + i6] = i7 + i5 + 1;
            }
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < iD) {
            int i10 = ((iD - i8) << i2) + (zE ? 9 : 12);
            int i11 = i8 << 1;
            int i12 = (i - 1) - i11;
            int i13 = 0;
            while (i13 < i10) {
                int i14 = i13 << 1;
                int i15 = 0;
                while (i15 < i2) {
                    int i16 = i11 + i15;
                    int i17 = i11 + i13;
                    zArr[i9 + i14 + i15] = whVar.d(iArr[i16], iArr[i17]);
                    int i18 = iArr[i17];
                    int i19 = i12 - i15;
                    zArr[(i10 * 2) + i9 + i14 + i15] = whVar.d(i18, iArr[i19]);
                    int i20 = i12 - i13;
                    zArr[(i10 * 4) + i9 + i14 + i15] = whVar.d(iArr[i19], iArr[i20]);
                    zArr[(i10 * 6) + i9 + i14 + i15] = whVar.d(iArr[i20], iArr[i16]);
                    i15++;
                    iD = iD;
                    zE = zE;
                    i2 = 2;
                }
                i13++;
                i2 = 2;
            }
            i9 += i10 << 3;
            i8++;
            i2 = 2;
        }
        return zArr;
    }

    private static String e(Table table, int i) {
        int i2 = a.a[table.ordinal()];
        if (i2 == 1) {
            return b[i];
        }
        if (i2 == 2) {
            return c[i];
        }
        if (i2 == 3) {
            return d[i];
        }
        if (i2 == 4) {
            return e[i];
        }
        if (i2 == 5) {
            return f[i];
        }
        throw new IllegalStateException("Bad table");
    }

    private static String f(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        StringBuilder sb = new StringBuilder(20);
        Table tableG = table;
        int i = 0;
        while (i < length) {
            if (table != Table.BINARY) {
                int i2 = table == Table.DIGIT ? 4 : 5;
                if (length - i < i2) {
                    break;
                }
                int i3 = i(zArr, i, i2);
                i += i2;
                String strE = e(table, i3);
                if (strE.startsWith("CTRL_")) {
                    tableG = g(strE.charAt(5));
                    if (strE.charAt(6) != 'L') {
                        tableG = table;
                        table = tableG;
                    }
                } else {
                    sb.append(strE);
                }
                table = tableG;
            } else {
                if (length - i < 5) {
                    break;
                }
                int i4 = i(zArr, i, 5);
                int i5 = i + 5;
                if (i4 == 0) {
                    if (length - i5 < 11) {
                        break;
                    }
                    i4 = i(zArr, i5, 11) + 31;
                    i5 = i + 16;
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= i4) {
                        i = i5;
                        break;
                    }
                    if (length - i5 < 8) {
                        i = length;
                        break;
                    }
                    sb.append((char) i(zArr, i5, 8));
                    i5 += 8;
                    i6++;
                }
                table = tableG;
            }
        }
        return sb.toString();
    }

    private static Table g(char c2) {
        if (c2 == 'B') {
            return Table.BINARY;
        }
        if (c2 == 'D') {
            return Table.DIGIT;
        }
        if (c2 == 'P') {
            return Table.PUNCT;
        }
        if (c2 != 'L') {
            return c2 != 'M' ? Table.UPPER : Table.MIXED;
        }
        return Table.LOWER;
    }

    private static byte h(boolean[] zArr, int i) {
        int length = zArr.length - i;
        return (byte) (length >= 8 ? i(zArr, i, 8) : i(zArr, i, length) << (8 - length));
    }

    private static int i(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static int j(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    public q70 c(ae aeVar) throws FormatException {
        this.a = aeVar;
        boolean[] zArrB = b(d(aeVar.a()));
        q70 q70Var = new q70(a(zArrB), f(zArrB), null, null);
        q70Var.l(zArrB.length);
        return q70Var;
    }
}
