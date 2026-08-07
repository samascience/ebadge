package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class vc0 {
    private final byte[] a = new byte[24];
    private int b;

    private vc0() {
    }

    private void a(int i) {
        byte[] bArr = this.a;
        int i2 = this.b + 1;
        this.b = i2;
        bArr[i2] = (byte) i;
    }

    private void b(int i) {
        int iQ = q(i);
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = iQ * 10;
            c(i3 >>> 28);
            iQ = i3 & 268435455;
        }
    }

    private void c(int i) {
        byte[] bArr = this.a;
        int i2 = this.b + 1;
        this.b = i2;
        bArr[i2] = (byte) (i + 48);
    }

    private String d() {
        return new String(this.a, 0, 0, this.b + 1);
    }

    private void e(int i) {
        a(69);
        if (i < 0) {
            a(45);
            i = -i;
        }
        if (i < 10) {
            c(i);
            return;
        }
        if (i >= 100) {
            int i2 = (i * 1311) >>> 17;
            c(i2);
            i -= i2 * 100;
        }
        int i3 = (i * 103) >>> 10;
        c(i3);
        c(i - (i3 * 10));
    }

    private void f(int i) {
        if (i != 0) {
            b(i);
        }
        g();
    }

    private void g() {
        int i;
        byte b;
        while (true) {
            byte[] bArr = this.a;
            i = this.b;
            b = bArr[i];
            if (b != 48) {
                break;
            } else {
                this.b = i - 1;
            }
        }
        if (b == 46) {
            this.b = i + 1;
        }
    }

    private static long h(long j, long j2, long j3) {
        long jF = bh1.f(j2, j3);
        long j4 = j * j3;
        long jF2 = bh1.f(j, j3);
        long j5 = (j4 >>> 1) + jF;
        return (jF2 + (j5 >>> 63)) | (((j5 & Long.MAX_VALUE) + Long.MAX_VALUE) >>> 63);
    }

    private int i(long j, int i) {
        int iA = bh1.a(64 - Long.numberOfLeadingZeros(j));
        if (j >= bh1.g(iA)) {
            iA++;
        }
        long jG = j * bh1.g(17 - iA);
        int i2 = i + iA;
        long jF = bh1.f(jG, 193428131138340668L) >>> 20;
        int i3 = (int) (jG - (100000000 * jF));
        int i4 = (int) ((1441151881 * jF) >>> 57);
        int i5 = (int) (jF - ((long) (100000000 * i4)));
        if (i2 <= 0 || i2 > 7) {
            return (-3 >= i2 || i2 > 0) ? l(i4, i5, i3, i2) : k(i4, i5, i3, i2);
        }
        return j(i4, i5, i3, i2);
    }

    private int j(int i, int i2, int i3, int i4) {
        c(i);
        int iQ = q(i2);
        int i5 = 1;
        while (i5 < i4) {
            int i6 = iQ * 10;
            c(i6 >>> 28);
            iQ = i6 & 268435455;
            i5++;
        }
        a(46);
        while (i5 <= 8) {
            int i7 = iQ * 10;
            c(i7 >>> 28);
            iQ = i7 & 268435455;
            i5++;
        }
        f(i3);
        return 0;
    }

    private int k(int i, int i2, int i3, int i4) {
        c(0);
        a(46);
        while (i4 < 0) {
            c(0);
            i4++;
        }
        c(i);
        b(i2);
        f(i3);
        return 0;
    }

    private int l(int i, int i2, int i3, int i4) {
        c(i);
        a(46);
        b(i2);
        f(i3);
        e(i4 - 1);
        return 0;
    }

    private int m(double d) {
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        long j = 4503599627370495L & jDoubleToRawLongBits;
        int i = ((int) (jDoubleToRawLongBits >>> 52)) & 2047;
        if (i >= 2047) {
            if (j != 0) {
                return 5;
            }
            return jDoubleToRawLongBits > 0 ? 3 : 4;
        }
        this.b = -1;
        if (jDoubleToRawLongBits < 0) {
            a(45);
        }
        if (i == 0) {
            if (j != 0) {
                return j < 3 ? n(-1074, j * 10, -1) : n(-1074, j, 0);
            }
            return jDoubleToRawLongBits == 0 ? 1 : 2;
        }
        int i2 = 1075 - i;
        long j2 = j | 4503599627370496L;
        if ((i2 < 53) & (i2 > 0)) {
            long j3 = j2 >> i2;
            if ((j3 << i2) == j2) {
                return i(j3, 0);
            }
        }
        return n(-i2, j2, 0);
    }

    private int n(int i, long j, int i2) {
        long j2;
        int iB;
        int i3 = ((int) j) & 1;
        long j3 = j << 2;
        long j4 = j3 + 2;
        if ((j != 4503599627370496L) || (i == -1074)) {
            j2 = j3 - 2;
            iB = bh1.a(i);
        } else {
            j2 = j3 - 1;
            iB = bh1.b(i);
        }
        int iC = i + bh1.c(-iB) + 2;
        long jE = bh1.e(iB);
        long jD = bh1.d(iB);
        long jH = h(jE, jD, j3 << iC);
        long jH2 = h(jE, jD, j2 << iC);
        long jH3 = h(jE, jD, j4 << iC);
        long j5 = jH >> 2;
        if (j5 >= 100) {
            long jF = bh1.f(j5, 1844674407370955168L) * 10;
            long j6 = jF + 10;
            int i4 = iB;
            long j7 = i3;
            boolean z = jH2 + j7 <= (jF << 2);
            if (z != ((j6 << 2) + j7 <= jH3)) {
                if (!z) {
                    jF = j6;
                }
                return i(jF, i4);
            }
            iB = i4;
        }
        long j8 = j5 + 1;
        long j9 = i3;
        boolean z2 = jH2 + j9 <= (j5 << 2);
        if (z2 != ((j8 << 2) + j9 <= jH3)) {
            if (!z2) {
                j5 = j8;
            }
            return i(j5, iB + i2);
        }
        long j10 = jH - ((j5 + j8) << 1);
        if (j10 >= 0 && (j10 != 0 || (1 & j5) != 0)) {
            j5 = j8;
        }
        return i(j5, iB + i2);
    }

    private String o(double d) {
        int iM = m(d);
        if (iM == 0) {
            return d();
        }
        if (iM == 1) {
            return "0.0";
        }
        if (iM == 2) {
            return "-0.0";
        }
        if (iM != 3) {
            return iM != 4 ? "NaN" : "-Infinity";
        }
        return "Infinity";
    }

    public static String p(double d) {
        return new vc0().o(d);
    }

    private int q(int i) {
        return ((int) (bh1.f(((long) (i + 1)) << 28, 193428131138340668L) >>> 20)) - 1;
    }
}
