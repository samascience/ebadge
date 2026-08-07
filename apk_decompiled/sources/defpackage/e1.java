package defpackage;

/* JADX INFO: loaded from: classes.dex */
abstract class e1 extends c1 {
    e1() {
    }

    private boolean a(char c) {
        return '0' <= c && c <= '9';
    }

    private long d(CharSequence charSequence, int i, int i2, int i3, boolean z, boolean z2) {
        char c;
        int i4;
        int i5;
        int i6;
        int i7;
        long j;
        boolean z3;
        int i8;
        int iK;
        int i9 = -1;
        int i10 = i;
        long j2 = 0;
        char cCharAt = 0;
        boolean z4 = false;
        while (true) {
            c = '.';
            if (i10 >= i3) {
                break;
            }
            cCharAt = charSequence.charAt(i10);
            if (!a(cCharAt)) {
                if (cCharAt != '.') {
                    break;
                }
                z4 |= i9 >= 0;
                int i11 = i10;
                while (i11 < i3 - 8 && (iK = k(charSequence, i11 + 1)) >= 0) {
                    j2 = (j2 * 100000000) + ((long) iK);
                    i11 += 8;
                }
                int i12 = i10;
                i10 = i11;
                i9 = i12;
            } else {
                j2 = ((j2 * 10) + ((long) cCharAt)) - 48;
            }
            i10++;
        }
        if (i9 < 0) {
            i4 = i10 - i;
            i9 = i10;
            i5 = 0;
        } else {
            i4 = (i10 - i) - 1;
            i5 = (i9 - i10) + 1;
        }
        if (cCharAt == 'e' || cCharAt == 'E') {
            i6 = i10 + 1;
            cCharAt = i6 < i3 ? charSequence.charAt(i6) : (char) 0;
            boolean z5 = cCharAt == '-';
            if (z5 || cCharAt == '+') {
                i6 = i10 + 2;
                cCharAt = i6 < i3 ? charSequence.charAt(i6) : (char) 0;
            }
            z4 |= !a(cCharAt);
            i7 = 0;
            do {
                if (i7 < 1024) {
                    i7 = ((i7 * 10) + cCharAt) - 48;
                }
                i6++;
                cCharAt = i6 < i3 ? charSequence.charAt(i6) : (char) 0;
            } while (a(cCharAt));
            if (z5) {
                i7 = -i7;
            }
            i5 += i7;
        } else {
            i6 = i10;
            i7 = 0;
        }
        char c2 = cCharAt;
        int i13 = i5;
        if (i6 < i3 && (c2 == 'd' || c2 == 'D' || c2 == 'f' || c2 == 'F')) {
            i6++;
        }
        int iJ = j(charSequence, i6, i3);
        if (z4 || iJ < i3) {
            return -1L;
        }
        if (!z2 && i4 == 0) {
            return -1L;
        }
        if (i4 > 19) {
            int i14 = i;
            long j3 = 0;
            int i15 = 0;
            while (i14 < i10) {
                char cCharAt2 = charSequence.charAt(i14);
                if (cCharAt2 != c) {
                    if (Long.compareUnsigned(j3, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j3 = ((j3 * 10) + ((long) cCharAt2)) - 48;
                } else {
                    i15++;
                }
                i14++;
                c = '.';
            }
            i8 = (i9 - i14) + i15 + i7;
            j = j3;
            z3 = i14 < i10;
        } else {
            j = j2;
            z3 = false;
            i8 = 0;
        }
        return l(charSequence, i2, i3, z, j, i13, z3, i8);
    }

    private long f(CharSequence charSequence, int i, int i2, int i3, boolean z) {
        int i4;
        int iMin;
        boolean z2;
        int i5;
        int i6;
        int i7;
        boolean z3;
        char cCharAt;
        long j;
        boolean z4;
        int i8;
        int i9 = i;
        long j2 = 0;
        int i10 = -1;
        char cCharAt2 = 0;
        boolean z5 = false;
        while (true) {
            if (i9 >= i3) {
                break;
            }
            cCharAt2 = charSequence.charAt(i9);
            byte b = cCharAt2 > 127 ? (byte) -1 : c1.a[cCharAt2];
            if (b < 0) {
                if (b != -4) {
                    break;
                }
                z5 |= i10 >= 0;
                i10 = i9;
            } else {
                j2 = (j2 << 4) | ((long) b);
            }
            i9++;
        }
        if (i10 < 0) {
            i4 = i9 - i;
            i10 = i9;
            iMin = 0;
        } else {
            i4 = (i9 - i) - 1;
            iMin = Math.min((i10 - i9) + 1, 1024) * 4;
        }
        boolean z6 = cCharAt2 == 'p' || cCharAt2 == 'P';
        if (z6) {
            int i11 = i9 + 1;
            char cCharAt3 = i11 < i3 ? charSequence.charAt(i11) : (char) 0;
            boolean z7 = cCharAt3 == '-';
            if (z7 || cCharAt3 == '+') {
                i11 = i9 + 2;
                cCharAt3 = i11 < i3 ? charSequence.charAt(i11) : (char) 0;
            }
            boolean z8 = (!a(cCharAt3)) | z5;
            int i12 = 1024;
            i6 = 0;
            while (true) {
                if (i6 < i12) {
                    i6 = ((i6 * 10) + cCharAt3) - 48;
                }
                z2 = true;
                i11++;
                cCharAt = i11 < i3 ? charSequence.charAt(i11) : (char) 0;
                if (!a(cCharAt)) {
                    break;
                }
                cCharAt3 = cCharAt;
                i12 = 1024;
            }
            if (z7) {
                i6 = -i6;
            }
            int i13 = iMin + i6;
            z3 = z8;
            i5 = i11;
            i7 = i13;
        } else {
            z2 = true;
            i5 = i9;
            i6 = 0;
            char c = cCharAt2;
            i7 = iMin;
            z3 = z5;
            cCharAt = c;
        }
        if (i5 < i3 && (cCharAt == 'd' || cCharAt == 'D' || cCharAt == 'f' || cCharAt == 'F')) {
            i5++;
        }
        int iJ = j(charSequence, i5, i3);
        if (z3 || iJ < i3 || i4 == 0 || !z6) {
            return -1L;
        }
        if (i4 > 16) {
            iJ = i;
            int i14 = 0;
            long j3 = 0;
            while (iJ < i9) {
                char cCharAt4 = charSequence.charAt(iJ);
                byte b2 = cCharAt4 > 127 ? (byte) -1 : c1.a[cCharAt4];
                if (b2 < 0) {
                    i14++;
                } else {
                    if (Long.compareUnsigned(j3, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j3 = (j3 << 4) | ((long) b2);
                }
                iJ++;
            }
            if (iJ >= i9) {
                z2 = false;
            }
            i8 = i14;
            j = j3;
            z4 = z2;
        } else {
            j = j2;
            z4 = false;
            i8 = 0;
        }
        return m(charSequence, i2, i3, z, j, i7, z4, (i10 - iJ) + i8 + i6);
    }

    private long g(CharSequence charSequence, int i, int i2, boolean z) {
        int i3 = i + 7;
        if (i3 < i2 && charSequence.charAt(i) == 'I' && charSequence.charAt(i + 1) == 'n' && charSequence.charAt(i + 2) == 'f' && charSequence.charAt(i + 3) == 'i' && charSequence.charAt(i + 4) == 'n' && charSequence.charAt(i + 5) == 'i' && charSequence.charAt(i + 6) == 't' && charSequence.charAt(i3) == 'y' && j(charSequence, i + 8, i2) == i2) {
            return z ? c() : i();
        }
        return -1L;
    }

    private long h(CharSequence charSequence, int i, int i2) {
        int i3 = i + 2;
        if (i3 < i2 && charSequence.charAt(i + 1) == 'a' && charSequence.charAt(i3) == 'N' && j(charSequence, i + 3, i2) == i2) {
            return b();
        }
        return -1L;
    }

    private int j(CharSequence charSequence, int i, int i2) {
        while (i < i2 && charSequence.charAt(i) <= ' ') {
            i++;
        }
        return i;
    }

    private int k(CharSequence charSequence, int i) {
        return lk0.a(((long) charSequence.charAt(i)) | (((long) charSequence.charAt(i + 1)) << 16) | (((long) charSequence.charAt(i + 2)) << 32) | (((long) charSequence.charAt(i + 3)) << 48), (((long) charSequence.charAt(i + 7)) << 48) | ((long) charSequence.charAt(i + 4)) | (((long) charSequence.charAt(i + 5)) << 16) | (((long) charSequence.charAt(i + 6)) << 32));
    }

    abstract long b();

    abstract long c();

    public long e(CharSequence charSequence, int i, int i2) {
        int iJ;
        int i3;
        int i4 = i + i2;
        if (i < 0 || i4 > charSequence.length() || (iJ = j(charSequence, i, i4)) == i4) {
            return -1L;
        }
        char cCharAt = charSequence.charAt(iJ);
        boolean z = cCharAt == '-';
        if (z || cCharAt == '+') {
            iJ++;
            cCharAt = iJ < i4 ? charSequence.charAt(iJ) : (char) 0;
            if (cCharAt == 0) {
                return -1L;
            }
        }
        if (cCharAt >= 'I') {
            return cCharAt == 'N' ? h(charSequence, iJ, i4) : g(charSequence, iJ, i4, z);
        }
        boolean z2 = cCharAt == '0';
        if (z2) {
            int i5 = iJ + 1;
            char cCharAt2 = i5 < i4 ? charSequence.charAt(i5) : (char) 0;
            if (cCharAt2 == 'x' || cCharAt2 == 'X') {
                return f(charSequence, iJ + 2, i, i4, z);
            }
            i3 = i5;
        } else {
            i3 = iJ;
        }
        return d(charSequence, i3, i, i4, z, z2);
    }

    abstract long i();

    abstract long l(CharSequence charSequence, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);

    abstract long m(CharSequence charSequence, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);
}
