package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class co0 {
    private final byte[] a = new byte[15];
    private int b;

    private co0() {
    }

    private void a(int i) {
        byte[] bArr = this.a;
        int i2 = this.b + 1;
        this.b = i2;
        bArr[i2] = (byte) i;
    }

    private void b(int i) {
        int iP = p(i);
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = iP * 10;
            c(i3 >>> 28);
            iP = i3 & 268435455;
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
        int i2 = (i * 103) >>> 10;
        c(i2);
        c(i - (i2 * 10));
    }

    private void f() {
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

    private static int g(long j, long j2) {
        long jF = bh1.f(j, j2);
        return (int) ((((jF & 4294967295L) + 4294967295L) >>> 32) | (jF >>> 31));
    }

    private int h(int i, int i2) {
        int iA = bh1.a(32 - Integer.numberOfLeadingZeros(i));
        if (i >= bh1.g(iA)) {
            iA++;
        }
        int iG = i * ((int) bh1.g(9 - iA));
        int i3 = i2 + iA;
        int i4 = (int) ((((long) iG) * 1441151881) >>> 57);
        int i5 = iG - (100000000 * i4);
        if (i3 <= 0 || i3 > 7) {
            return (-3 >= i3 || i3 > 0) ? k(i4, i5, i3) : j(i4, i5, i3);
        }
        return i(i4, i5, i3);
    }

    private int i(int i, int i2, int i3) {
        c(i);
        int iP = p(i2);
        int i4 = 1;
        while (i4 < i3) {
            int i5 = iP * 10;
            c(i5 >>> 28);
            iP = i5 & 268435455;
            i4++;
        }
        a(46);
        while (i4 <= 8) {
            int i6 = iP * 10;
            c(i6 >>> 28);
            iP = i6 & 268435455;
            i4++;
        }
        f();
        return 0;
    }

    private int j(int i, int i2, int i3) {
        c(0);
        a(46);
        while (i3 < 0) {
            c(0);
            i3++;
        }
        c(i);
        b(i2);
        f();
        return 0;
    }

    private int k(int i, int i2, int i3) {
        c(i);
        a(46);
        b(i2);
        f();
        e(i3 - 1);
        return 0;
    }

    private int l(float f) {
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        int i = 8388607 & iFloatToRawIntBits;
        int i2 = (iFloatToRawIntBits >>> 23) & 255;
        if (i2 >= 255) {
            if (i != 0) {
                return 5;
            }
            return iFloatToRawIntBits > 0 ? 3 : 4;
        }
        this.b = -1;
        if (iFloatToRawIntBits < 0) {
            a(45);
        }
        if (i2 == 0) {
            if (i != 0) {
                return i < 8 ? m(-149, i * 10, -1) : m(-149, i, 0);
            }
            return iFloatToRawIntBits == 0 ? 1 : 2;
        }
        int i3 = 150 - i2;
        int i4 = i | 8388608;
        if ((i3 > 0) & (i3 < 24)) {
            int i5 = i4 >> i3;
            if ((i5 << i3) == i4) {
                return h(i5, 0);
            }
        }
        return m(-i3, i4, 0);
    }

    private int m(int i, int i2, int i3) {
        long j;
        int iB;
        int i4 = i2 & 1;
        long j2 = i2 << 2;
        long j3 = j2 + 2;
        if ((i2 != 8388608) || (i == -149)) {
            j = j2 - 2;
            iB = bh1.a(i);
        } else {
            j = j2 - 1;
            iB = bh1.b(i);
        }
        int iC = i + bh1.c(-iB) + 33;
        long jE = 1 + bh1.e(iB);
        int iG = g(jE, j2 << iC);
        int iG2 = g(jE, j << iC);
        int iG3 = g(jE, j3 << iC);
        int i5 = iG >> 2;
        if (i5 >= 100) {
            int i6 = ((int) ((((long) i5) * 1717986919) >>> 34)) * 10;
            int i7 = i6 + 10;
            boolean z = iG2 + i4 <= (i6 << 2);
            if (z != ((i7 << 2) + i4 <= iG3)) {
                if (!z) {
                    i6 = i7;
                }
                return h(i6, iB);
            }
        }
        int i8 = i5 + 1;
        boolean z2 = iG2 + i4 <= (i5 << 2);
        if (z2 != ((i8 << 2) + i4 <= iG3)) {
            if (!z2) {
                i5 = i8;
            }
            return h(i5, iB + i3);
        }
        int i9 = iG - ((i5 + i8) << 1);
        if (i9 >= 0 && (i9 != 0 || (i5 & 1) != 0)) {
            i5 = i8;
        }
        return h(i5, iB + i3);
    }

    private String n(float f) {
        int iL = l(f);
        if (iL == 0) {
            return d();
        }
        if (iL == 1) {
            return "0.0";
        }
        if (iL == 2) {
            return "-0.0";
        }
        if (iL != 3) {
            return iL != 4 ? "NaN" : "-Infinity";
        }
        return "Infinity";
    }

    public static String o(float f) {
        return new co0().n(f);
    }

    private int p(int i) {
        return ((int) (bh1.f(((long) (i + 1)) << 28, 193428131138340668L) >>> 20)) - 1;
    }
}
