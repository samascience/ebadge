package defpackage;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public abstract class is1 {
    private static int a = 1000000;
    private static int b = 1000000000;
    private static long c = 1000000000;
    private static long d = -2147483648L;
    private static long e = 2147483647L;
    static final String f = String.valueOf(Integer.MIN_VALUE);
    static final String g = String.valueOf(Long.MIN_VALUE);
    private static final int[] h = new int[1000];
    private static final String[] i;
    private static final String[] j;

    static {
        int i2 = 0;
        for (int i3 = 0; i3 < 10; i3++) {
            for (int i4 = 0; i4 < 10; i4++) {
                int i5 = 0;
                while (i5 < 10) {
                    h[i2] = ((i3 + 48) << 16) | ((i4 + 48) << 8) | (i5 + 48);
                    i5++;
                    i2++;
                }
            }
        }
        i = new String[]{"0", "1", "2", "3", Constants.VIA_TO_TYPE_QZONE, "5", Constants.VIA_SHARE_TYPE_INFO, "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_SHARE_TYPE_MINI_PROGRAM, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ};
        j = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    private static int a(int i2, byte[] bArr, int i3) {
        int i4 = h[i2];
        bArr[i3] = (byte) (i4 >> 16);
        int i5 = i3 + 2;
        bArr[i3 + 1] = (byte) (i4 >> 8);
        int i6 = i3 + 3;
        bArr[i5] = (byte) i4;
        return i6;
    }

    private static int b(int i2, char[] cArr, int i3) {
        int i4 = h[i2];
        cArr[i3] = (char) (i4 >> 16);
        int i5 = i3 + 2;
        cArr[i3 + 1] = (char) ((i4 >> 8) & 127);
        int i6 = i3 + 3;
        cArr[i5] = (char) (i4 & 127);
        return i6;
    }

    private static int c(int i2, byte[] bArr, int i3) {
        int i4 = h[i2];
        if (i2 > 9) {
            if (i2 > 99) {
                bArr[i3] = (byte) (i4 >> 16);
                i3++;
            }
            bArr[i3] = (byte) (i4 >> 8);
            i3++;
        }
        int i5 = i3 + 1;
        bArr[i3] = (byte) i4;
        return i5;
    }

    private static int d(int i2, char[] cArr, int i3) {
        int i4 = h[i2];
        if (i2 > 9) {
            if (i2 > 99) {
                cArr[i3] = (char) (i4 >> 16);
                i3++;
            }
            cArr[i3] = (char) ((i4 >> 8) & 127);
            i3++;
        }
        int i5 = i3 + 1;
        cArr[i3] = (char) (i4 & 127);
        return i5;
    }

    private static int e(int i2, byte[] bArr, int i3) {
        int i4 = i2 / 1000;
        int i5 = i2 - (i4 * 1000);
        int i6 = i4 / 1000;
        int i7 = i4 - (i6 * 1000);
        int[] iArr = h;
        int i8 = iArr[i6];
        bArr[i3] = (byte) (i8 >> 16);
        bArr[i3 + 1] = (byte) (i8 >> 8);
        bArr[i3 + 2] = (byte) i8;
        int i9 = iArr[i7];
        bArr[i3 + 3] = (byte) (i9 >> 16);
        bArr[i3 + 4] = (byte) (i9 >> 8);
        bArr[i3 + 5] = (byte) i9;
        int i10 = iArr[i5];
        bArr[i3 + 6] = (byte) (i10 >> 16);
        int i11 = i3 + 8;
        bArr[i3 + 7] = (byte) (i10 >> 8);
        int i12 = i3 + 9;
        bArr[i11] = (byte) i10;
        return i12;
    }

    private static int f(int i2, char[] cArr, int i3) {
        int i4 = i2 / 1000;
        int i5 = i2 - (i4 * 1000);
        int i6 = i4 / 1000;
        int[] iArr = h;
        int i7 = iArr[i6];
        cArr[i3] = (char) (i7 >> 16);
        cArr[i3 + 1] = (char) ((i7 >> 8) & 127);
        cArr[i3 + 2] = (char) (i7 & 127);
        int i8 = iArr[i4 - (i6 * 1000)];
        cArr[i3 + 3] = (char) (i8 >> 16);
        cArr[i3 + 4] = (char) ((i8 >> 8) & 127);
        cArr[i3 + 5] = (char) (i8 & 127);
        int i9 = iArr[i5];
        cArr[i3 + 6] = (char) (i9 >> 16);
        int i10 = i3 + 8;
        cArr[i3 + 7] = (char) ((i9 >> 8) & 127);
        int i11 = i3 + 9;
        cArr[i10] = (char) (i9 & 127);
        return i11;
    }

    private static int g(byte[] bArr, int i2) {
        int length = f.length();
        int i3 = 0;
        while (i3 < length) {
            bArr[i2] = (byte) f.charAt(i3);
            i3++;
            i2++;
        }
        return i2;
    }

    private static int h(char[] cArr, int i2) {
        String str = f;
        int length = str.length();
        str.getChars(0, length, cArr, i2);
        return i2 + length;
    }

    private static int i(byte[] bArr, int i2) {
        int length = g.length();
        int i3 = 0;
        while (i3 < length) {
            bArr[i2] = (byte) g.charAt(i3);
            i3++;
            i2++;
        }
        return i2;
    }

    private static int j(char[] cArr, int i2) {
        String str = g;
        int length = str.length();
        str.getChars(0, length, cArr, i2);
        return i2 + length;
    }

    private static int k(int i2, byte[] bArr, int i3) {
        if (i2 < a) {
            if (i2 < 1000) {
                return c(i2, bArr, i3);
            }
            int i4 = i2 / 1000;
            return m(bArr, i3, i4, i2 - (i4 * 1000));
        }
        int i5 = i2 / 1000;
        int i6 = i2 - (i5 * 1000);
        int i7 = i5 / 1000;
        int i8 = i5 - (i7 * 1000);
        int iC = c(i7, bArr, i3);
        int[] iArr = h;
        int i9 = iArr[i8];
        bArr[iC] = (byte) (i9 >> 16);
        bArr[iC + 1] = (byte) (i9 >> 8);
        bArr[iC + 2] = (byte) i9;
        int i10 = iArr[i6];
        bArr[iC + 3] = (byte) (i10 >> 16);
        int i11 = iC + 5;
        bArr[iC + 4] = (byte) (i10 >> 8);
        int i12 = iC + 6;
        bArr[i11] = (byte) i10;
        return i12;
    }

    private static int l(int i2, char[] cArr, int i3) {
        if (i2 < a) {
            if (i2 < 1000) {
                return d(i2, cArr, i3);
            }
            int i4 = i2 / 1000;
            return n(cArr, i3, i4, i2 - (i4 * 1000));
        }
        int i5 = i2 / 1000;
        int i6 = i2 - (i5 * 1000);
        int i7 = i5 / 1000;
        int i8 = i5 - (i7 * 1000);
        int iD = d(i7, cArr, i3);
        int[] iArr = h;
        int i9 = iArr[i8];
        cArr[iD] = (char) (i9 >> 16);
        cArr[iD + 1] = (char) ((i9 >> 8) & 127);
        cArr[iD + 2] = (char) (i9 & 127);
        int i10 = iArr[i6];
        cArr[iD + 3] = (char) (i10 >> 16);
        int i11 = iD + 5;
        cArr[iD + 4] = (char) ((i10 >> 8) & 127);
        int i12 = iD + 6;
        cArr[i11] = (char) (i10 & 127);
        return i12;
    }

    private static int m(byte[] bArr, int i2, int i3, int i4) {
        int[] iArr = h;
        int i5 = iArr[i3];
        if (i3 > 9) {
            if (i3 > 99) {
                bArr[i2] = (byte) (i5 >> 16);
                i2++;
            }
            bArr[i2] = (byte) (i5 >> 8);
            i2++;
        }
        bArr[i2] = (byte) i5;
        int i6 = iArr[i4];
        bArr[i2 + 1] = (byte) (i6 >> 16);
        int i7 = i2 + 3;
        bArr[i2 + 2] = (byte) (i6 >> 8);
        int i8 = i2 + 4;
        bArr[i7] = (byte) i6;
        return i8;
    }

    private static int n(char[] cArr, int i2, int i3, int i4) {
        int[] iArr = h;
        int i5 = iArr[i3];
        if (i3 > 9) {
            if (i3 > 99) {
                cArr[i2] = (char) (i5 >> 16);
                i2++;
            }
            cArr[i2] = (char) ((i5 >> 8) & 127);
            i2++;
        }
        cArr[i2] = (char) (i5 & 127);
        int i6 = iArr[i4];
        cArr[i2 + 1] = (char) (i6 >> 16);
        int i7 = i2 + 3;
        cArr[i2 + 2] = (char) ((i6 >> 8) & 127);
        int i8 = i2 + 4;
        cArr[i7] = (char) (i6 & 127);
        return i8;
    }

    public static boolean o(double d2) {
        return Double.isNaN(d2) || Double.isInfinite(d2);
    }

    public static boolean p(float f2) {
        return Float.isNaN(f2) || Float.isInfinite(f2);
    }

    public static int q(int i2, byte[] bArr, int i3) {
        int i4;
        if (i2 < 0) {
            if (i2 == Integer.MIN_VALUE) {
                return g(bArr, i3);
            }
            bArr[i3] = 45;
            i2 = -i2;
            i3++;
        }
        if (i2 < a) {
            if (i2 >= 1000) {
                int i5 = i2 / 1000;
                return a(i2 - (i5 * 1000), bArr, c(i5, bArr, i3));
            }
            if (i2 >= 10) {
                return c(i2, bArr, i3);
            }
            int i6 = i3 + 1;
            bArr[i3] = (byte) (i2 + 48);
            return i6;
        }
        int i7 = b;
        if (i2 < i7) {
            int i8 = i2 / 1000;
            int i9 = i8 / 1000;
            return a(i2 - (i8 * 1000), bArr, a(i8 - (i9 * 1000), bArr, c(i9, bArr, i3)));
        }
        int i10 = i2 - i7;
        if (i10 >= i7) {
            i10 -= i7;
            i4 = i3 + 1;
            bArr[i3] = 50;
        } else {
            i4 = i3 + 1;
            bArr[i3] = 49;
        }
        return e(i10, bArr, i4);
    }

    public static int r(int i2, char[] cArr, int i3) {
        int i4;
        if (i2 < 0) {
            if (i2 == Integer.MIN_VALUE) {
                return h(cArr, i3);
            }
            cArr[i3] = '-';
            i2 = -i2;
            i3++;
        }
        if (i2 < a) {
            if (i2 >= 1000) {
                int i5 = i2 / 1000;
                return b(i2 - (i5 * 1000), cArr, d(i5, cArr, i3));
            }
            if (i2 >= 10) {
                return d(i2, cArr, i3);
            }
            cArr[i3] = (char) (i2 + 48);
            return i3 + 1;
        }
        int i6 = b;
        if (i2 < i6) {
            int i7 = i2 / 1000;
            int i8 = i7 / 1000;
            return b(i2 - (i7 * 1000), cArr, b(i7 - (i8 * 1000), cArr, d(i8, cArr, i3)));
        }
        int i9 = i2 - i6;
        if (i9 >= i6) {
            i9 -= i6;
            i4 = i3 + 1;
            cArr[i3] = '2';
        } else {
            i4 = i3 + 1;
            cArr[i3] = '1';
        }
        return f(i9, cArr, i4);
    }

    public static int s(long j2, byte[] bArr, int i2) {
        int iE;
        if (j2 < 0) {
            if (j2 > d) {
                return q((int) j2, bArr, i2);
            }
            if (j2 == Long.MIN_VALUE) {
                return i(bArr, i2);
            }
            bArr[i2] = 45;
            j2 = -j2;
            i2++;
        } else if (j2 <= e) {
            return q((int) j2, bArr, i2);
        }
        long j3 = c;
        long j4 = j2 / j3;
        long j5 = j2 - (j4 * j3);
        if (j4 < j3) {
            iE = k((int) j4, bArr, i2);
        } else {
            long j6 = j4 / j3;
            int iC = c((int) j6, bArr, i2);
            iE = e((int) (j4 - (j3 * j6)), bArr, iC);
        }
        return e((int) j5, bArr, iE);
    }

    public static int t(long j2, char[] cArr, int i2) {
        int iF;
        if (j2 < 0) {
            if (j2 > d) {
                return r((int) j2, cArr, i2);
            }
            if (j2 == Long.MIN_VALUE) {
                return j(cArr, i2);
            }
            cArr[i2] = '-';
            j2 = -j2;
            i2++;
        } else if (j2 <= e) {
            return r((int) j2, cArr, i2);
        }
        long j3 = c;
        long j4 = j2 / j3;
        long j5 = j2 - (j4 * j3);
        if (j4 < j3) {
            iF = l((int) j4, cArr, i2);
        } else {
            long j6 = j4 / j3;
            int iD = d((int) j6, cArr, i2);
            iF = f((int) (j4 - (j3 * j6)), cArr, iD);
        }
        return f((int) j5, cArr, iF);
    }

    public static String u(double d2) {
        return v(d2, false);
    }

    public static String v(double d2, boolean z) {
        return z ? vc0.p(d2) : Double.toString(d2);
    }

    public static String w(float f2) {
        return x(f2, false);
    }

    public static String x(float f2, boolean z) {
        return z ? co0.o(f2) : Float.toString(f2);
    }

    public static String y(int i2) {
        String[] strArr = i;
        if (i2 < strArr.length) {
            if (i2 >= 0) {
                return strArr[i2];
            }
            int i3 = (-i2) - 1;
            String[] strArr2 = j;
            if (i3 < strArr2.length) {
                return strArr2[i3];
            }
        }
        return Integer.toString(i2);
    }

    public static String z(long j2) {
        return (j2 > 2147483647L || j2 < -2147483648L) ? Long.toString(j2) : y((int) j2);
    }
}
