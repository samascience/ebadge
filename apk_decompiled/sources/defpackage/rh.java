package defpackage;

import java.math.BigDecimal;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class rh {
    private static int a(int i, long j) {
        long j2 = ((long) i) - j;
        if (j2 <= 2147483647L && j2 >= -2147483648L) {
            return (int) j2;
        }
        throw new NumberFormatException("Scale out of range: " + j2 + " while adjusting scale " + i + " to exponent " + j);
    }

    public static BigDecimal b(String str) {
        return c(str.toCharArray());
    }

    public static BigDecimal c(char[] cArr) {
        return d(cArr, 0, cArr.length);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001b  */
    /* JADX WARN: Code duplicated, block: B:17:0x0021  */
    /* JADX WARN: Code duplicated, block: B:18:0x0027  */
    /* JADX WARN: Instruction removed from duplicated block: B:18:0x0027, please report this as an issue */
    public static BigDecimal d(char[] cArr, int i, int i2) {
        String message;
        String str;
        try {
            return i2 < 500 ? new BigDecimal(cArr, i, i2) : e(cArr, i, i2, i2 / 10);
        } catch (ArithmeticException e) {
            e = e;
            message = e.getMessage();
            if (message == null) {
                message = "Not a valid number representation";
            }
            if (i2 <= 1000) {
                str = new String(cArr, i, i2);
            } else {
                str = new String(Arrays.copyOfRange(cArr, i, 1000)) + "(truncated, full length is " + cArr.length + " chars)";
            }
            throw new NumberFormatException("Value \"" + str + "\" can not be represented as `java.math.BigDecimal`, reason: " + message);
        } catch (NumberFormatException e2) {
            e = e2;
            message = e.getMessage();
            if (message == null) {
                message = "Not a valid number representation";
            }
            if (i2 <= 1000) {
                str = new String(cArr, i, i2);
            } else {
                str = new String(Arrays.copyOfRange(cArr, i, 1000)) + "(truncated, full length is " + cArr.length + " chars)";
            }
            throw new NumberFormatException("Value \"" + str + "\" can not be represented as `java.math.BigDecimal`, reason: " + message);
        }
    }

    private static BigDecimal e(char[] cArr, int i, int i2, int i3) {
        int i4;
        int i5;
        BigDecimal bigDecimalF;
        int i6 = i + i2;
        int i7 = i;
        int i8 = i7;
        int i9 = -1;
        int i10 = -1;
        int iA = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (i7 < i6) {
            char c = cArr[i7];
            if (c != '+') {
                if (c == 'E' || c == 'e') {
                    if (i9 >= 0) {
                        throw new NumberFormatException("Multiple exponent markers");
                    }
                    i9 = i7;
                } else if (c != '-') {
                    if (c != '.') {
                        if (i10 >= 0 && i9 == -1) {
                            iA++;
                        }
                    } else {
                        if (i10 >= 0) {
                            throw new NumberFormatException("Multiple decimal points");
                        }
                        i10 = i7;
                    }
                } else if (i9 >= 0) {
                    if (z2) {
                        throw new NumberFormatException("Multiple signs in exponent");
                    }
                    z2 = true;
                } else {
                    if (z) {
                        throw new NumberFormatException("Multiple signs in number");
                    }
                    i8 = i7 + 1;
                    z = true;
                    z3 = true;
                }
            } else if (i9 >= 0) {
                if (z2) {
                    throw new NumberFormatException("Multiple signs in exponent");
                }
                z2 = true;
            } else {
                if (z) {
                    throw new NumberFormatException("Multiple signs in number");
                }
                i8 = i7 + 1;
                z = true;
            }
            i7++;
        }
        if (i9 >= 0) {
            i4 = 1;
            i5 = Integer.parseInt(new String(cArr, i9 + 1, (i6 - i9) - 1));
            iA = a(iA, i5);
            i6 = i9;
        } else {
            i4 = 1;
            i5 = 0;
        }
        if (i10 >= 0) {
            int i11 = (i6 - i10) - i4;
            bigDecimalF = f(cArr, i8, i10 - i8, i5, i3).add(f(cArr, i10 + i4, i11, i5 - i11, i3));
        } else {
            bigDecimalF = f(cArr, i8, i6 - i8, i5, i3);
        }
        if (iA != 0) {
            bigDecimalF = bigDecimalF.setScale(iA);
        }
        return z3 ? bigDecimalF.negate() : bigDecimalF;
    }

    private static BigDecimal f(char[] cArr, int i, int i2, int i3, int i4) {
        if (i2 <= i4) {
            return i2 == 0 ? BigDecimal.ZERO : new BigDecimal(cArr, i, i2).movePointRight(i3);
        }
        int i5 = i2 / 2;
        return f(cArr, i, i5, (i3 + i2) - i5, i4).add(f(cArr, i + i5, i2 - i5, i3, i4));
    }
}
