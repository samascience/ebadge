package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class i71 {
    private static final char[] a = ex.d(true);
    private static final byte[] b = ex.c(true);
    private static final i71 c = new i71();

    private int a(int i, int i2, zo zoVar, int i3) {
        zoVar.m0(i3);
        zoVar.u(92);
        if (i2 < 0) {
            zoVar.u(117);
            if (i > 255) {
                byte[] bArr = b;
                zoVar.u(bArr[i >> 12]);
                zoVar.u(bArr[(i >> 8) & 15]);
                i &= 255;
            } else {
                zoVar.u(48);
                zoVar.u(48);
            }
            byte[] bArr2 = b;
            zoVar.u(bArr2[i >> 4]);
            zoVar.u(bArr2[i & 15]);
        } else {
            zoVar.u((byte) i2);
        }
        return zoVar.e0();
    }

    private int b(int i, char[] cArr) {
        cArr[1] = (char) i;
        return 2;
    }

    private int c(int i, char[] cArr) {
        cArr[1] = 'u';
        char[] cArr2 = a;
        cArr[4] = cArr2[i >> 4];
        cArr[5] = cArr2[i & 15];
        return 6;
    }

    private static int d(int i, int i2) {
        if (i2 >= 56320 && i2 <= 57343) {
            return ((i - 55296) << 10) + 65536 + (i2 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
    }

    private static void e(int i) {
        throw new IllegalArgumentException(h83.w(i));
    }

    static int f(int i) {
        return Math.min(Math.max(24, i + 6 + (i >> 1)), 32000);
    }

    static int g(int i) {
        return Math.min(Math.max(16, i + Math.min((i >> 3) + 6, 1000)), 32000);
    }

    private char[] h() {
        return new char[]{'\\', 0, '0', '0', 0, 0};
    }

    public static i71 j() {
        return c;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00df  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e8 A[SYNTHETIC] */
    public byte[] i(String str) {
        int i;
        int i2;
        int length = str.length();
        int iF = f(length);
        byte[] bArrD = new byte[iF];
        zo zoVarV = null;
        int i3 = 0;
        int i4 = 0;
        loop0: while (i3 < length) {
            int i5 = i3 + 1;
            char cCharAt = str.charAt(i3);
            while (cCharAt <= 127) {
                if (i4 >= iF) {
                    if (zoVarV == null) {
                        zoVarV = zo.V(bArrD, i4);
                    }
                    byte[] bArrD2 = zoVarV.D();
                    i4 = 0;
                    bArrD = bArrD2;
                    iF = bArrD2.length;
                }
                int i6 = i4 + 1;
                bArrD[i4] = (byte) cCharAt;
                if (i5 >= length) {
                    i4 = i6;
                    break loop0;
                }
                char cCharAt2 = str.charAt(i5);
                i5++;
                cCharAt = cCharAt2;
                i4 = i6;
            }
            if (zoVarV == null) {
                zoVarV = zo.V(bArrD, i4);
            }
            if (i4 >= iF) {
                bArrD = zoVarV.D();
                iF = bArrD.length;
                i4 = 0;
            }
            if (cCharAt < 2048) {
                i = i4 + 1;
                bArrD[i4] = (byte) ((cCharAt >> 6) | 192);
            } else {
                if (cCharAt < 55296 || cCharAt > 57343) {
                    int i7 = i4 + 1;
                    bArrD[i4] = (byte) ((cCharAt >> '\f') | 224);
                    if (i7 >= iF) {
                        bArrD = zoVarV.D();
                        iF = bArrD.length;
                        i7 = 0;
                    }
                    bArrD[i7] = (byte) (((cCharAt >> 6) & 63) | 128);
                    i = i7 + 1;
                } else {
                    if (cCharAt > 56319) {
                        e(cCharAt);
                    }
                    if (i5 >= length) {
                        e(cCharAt);
                    }
                    int i8 = i5 + 1;
                    int iD = d(cCharAt, str.charAt(i5));
                    if (iD > 1114111) {
                        e(iD);
                    }
                    int i9 = i4 + 1;
                    bArrD[i4] = (byte) ((iD >> 18) | 240);
                    if (i9 >= iF) {
                        bArrD = zoVarV.D();
                        iF = bArrD.length;
                        i9 = 0;
                    }
                    int i10 = i9 + 1;
                    bArrD[i9] = (byte) (((iD >> 12) & 63) | 128);
                    if (i10 >= iF) {
                        byte[] bArrD3 = zoVarV.D();
                        i10 = 0;
                        bArrD = bArrD3;
                        iF = bArrD3.length;
                    }
                    int i11 = i10 + 1;
                    bArrD[i10] = (byte) (((iD >> 6) & 63) | 128);
                    i2 = iD;
                    i3 = i8;
                    i = i11;
                }
                if (i >= iF) {
                    byte[] bArrD4 = zoVarV.D();
                    i = 0;
                    bArrD = bArrD4;
                    iF = bArrD4.length;
                }
                bArrD[i] = (byte) ((i2 & 63) | 128);
                i4 = i + 1;
            }
            i2 = cCharAt;
            i3 = i5;
            if (i >= iF) {
                byte[] bArrD5 = zoVarV.D();
                i = 0;
                bArrD = bArrD5;
                iF = bArrD5.length;
            }
            bArrD[i] = (byte) ((i2 & 63) | 128);
            i4 = i + 1;
        }
        return zoVarV == null ? Arrays.copyOfRange(bArrD, 0, i4) : zoVarV.C(i4);
    }

    public char[] k(String str) {
        int length = str.length();
        char[] cArrP = new char[g(length)];
        int[] iArrE = ex.e();
        int length2 = iArrE.length;
        w13 w13VarQ = null;
        int i = 0;
        int i2 = 0;
        char[] cArrH = null;
        loop0: while (i < length) {
            while (true) {
                char cCharAt = str.charAt(i);
                if (cCharAt >= length2 || iArrE[cCharAt] == 0) {
                    if (i2 >= cArrP.length) {
                        if (w13VarQ == null) {
                            w13VarQ = w13.q(cArrP);
                        }
                        cArrP = w13VarQ.p();
                        i2 = 0;
                    }
                    int i3 = i2 + 1;
                    cArrP[i2] = cCharAt;
                    i++;
                    if (i >= length) {
                        i2 = i3;
                        break loop0;
                    }
                    i2 = i3;
                }
            }
            if (cArrH == null) {
                cArrH = h();
            }
            int i4 = i + 1;
            char cCharAt2 = str.charAt(i);
            int i5 = iArrE[cCharAt2];
            int iC = i5 < 0 ? c(cCharAt2, cArrH) : b(i5, cArrH);
            int i6 = i2 + iC;
            if (i6 > cArrP.length) {
                int length3 = cArrP.length - i2;
                if (length3 > 0) {
                    System.arraycopy(cArrH, 0, cArrP, i2, length3);
                }
                if (w13VarQ == null) {
                    w13VarQ = w13.q(cArrP);
                }
                cArrP = w13VarQ.p();
                int i7 = iC - length3;
                System.arraycopy(cArrH, length3, cArrP, 0, i7);
                i2 = i7;
            } else {
                System.arraycopy(cArrH, 0, cArrP, i2, iC);
                i2 = i6;
            }
            i = i4;
        }
        if (w13VarQ == null) {
            return Arrays.copyOfRange(cArrP, 0, i2);
        }
        w13VarQ.E(i2);
        return w13VarQ.g();
    }

    public byte[] l(String str) {
        int i;
        int i2;
        int i3;
        int length = str.length();
        byte[] bArrD = new byte[f(length)];
        zo zoVarV = null;
        int i4 = 0;
        int iA = 0;
        loop0: while (i4 < length) {
            int[] iArrE = ex.e();
            while (true) {
                char cCharAt = str.charAt(i4);
                if (cCharAt > 127 || iArrE[cCharAt] != 0) {
                    break;
                }
                if (iA >= bArrD.length) {
                    if (zoVarV == null) {
                        zoVarV = zo.V(bArrD, iA);
                    }
                    bArrD = zoVarV.D();
                    iA = 0;
                }
                int i5 = iA + 1;
                bArrD[iA] = (byte) cCharAt;
                i4++;
                if (i4 >= length) {
                    iA = i5;
                    break loop0;
                }
                iA = i5;
            }
            if (zoVarV == null) {
                zoVarV = zo.V(bArrD, iA);
            }
            if (iA >= bArrD.length) {
                bArrD = zoVarV.D();
                iA = 0;
            }
            int i6 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 <= 127) {
                iA = a(cCharAt2, iArrE[cCharAt2], zoVarV, iA);
                bArrD = zoVarV.a0();
            } else {
                if (cCharAt2 <= 2047) {
                    i3 = iA + 1;
                    bArrD[iA] = (byte) ((cCharAt2 >> 6) | 192);
                    i2 = (cCharAt2 & '?') | 128;
                } else {
                    if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                        int i7 = iA + 1;
                        bArrD[iA] = (byte) ((cCharAt2 >> '\f') | 224);
                        if (i7 >= bArrD.length) {
                            bArrD = zoVarV.D();
                            i7 = 0;
                        }
                        bArrD[i7] = (byte) (((cCharAt2 >> 6) & 63) | 128);
                        i = i7 + 1;
                        i2 = (cCharAt2 & '?') | 128;
                    } else {
                        if (cCharAt2 > 56319) {
                            e(cCharAt2);
                        }
                        if (i6 >= length) {
                            e(cCharAt2);
                        }
                        int i8 = i4 + 2;
                        int iD = d(cCharAt2, str.charAt(i6));
                        if (iD > 1114111) {
                            e(iD);
                        }
                        int i9 = iA + 1;
                        bArrD[iA] = (byte) ((iD >> 18) | 240);
                        if (i9 >= bArrD.length) {
                            bArrD = zoVarV.D();
                            i9 = 0;
                        }
                        int i10 = i9 + 1;
                        bArrD[i9] = (byte) (((iD >> 12) & 63) | 128);
                        if (i10 >= bArrD.length) {
                            bArrD = zoVarV.D();
                            i10 = 0;
                        }
                        int i11 = i10 + 1;
                        bArrD[i10] = (byte) (((iD >> 6) & 63) | 128);
                        i2 = (iD & 63) | 128;
                        i = i11;
                        i6 = i8;
                    }
                    i3 = i;
                }
                if (i3 >= bArrD.length) {
                    bArrD = zoVarV.D();
                    i3 = 0;
                }
                bArrD[i3] = (byte) i2;
                iA = i3 + 1;
            }
            i4 = i6;
        }
        return zoVarV == null ? Arrays.copyOfRange(bArrD, 0, iA) : zoVarV.C(iA);
    }
}
