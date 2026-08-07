package defpackage;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class hs1 {
    static final String a = String.valueOf(Long.MIN_VALUE).substring(1);
    static final String b = String.valueOf(Long.MAX_VALUE);

    public static boolean a(String str, boolean z) {
        String str2 = z ? a : b;
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int iCharAt = str.charAt(i) - str2.charAt(i);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    public static boolean b(char[] cArr, int i, int i2, boolean z) {
        String str = z ? a : b;
        int length = str.length();
        if (i2 < length) {
            return true;
        }
        if (i2 > length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            int iCharAt = cArr[i + i3] - str.charAt(i3);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    public static double c(String str, double d) {
        return d(str, d, false);
    }

    public static double d(String str, double d, boolean z) {
        if (str == null) {
            return d;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            return d;
        }
        try {
            return j(strTrim, z);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public static int e(String str, int i) {
        String strTrim;
        int length;
        if (str == null || (length = (strTrim = str.trim()).length()) == 0) {
            return i;
        }
        int i2 = 0;
        char cCharAt = strTrim.charAt(0);
        if (cCharAt == '+') {
            strTrim = strTrim.substring(1);
            length = strTrim.length();
        } else if (cCharAt == '-') {
            i2 = 1;
        }
        while (i2 < length) {
            char cCharAt2 = strTrim.charAt(i2);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                try {
                    return (int) j(strTrim, true);
                } catch (NumberFormatException unused) {
                    return i;
                }
            }
            i2++;
        }
        try {
            return Integer.parseInt(strTrim);
        } catch (NumberFormatException unused2) {
            return i;
        }
    }

    public static long f(String str, long j) {
        String strTrim;
        int length;
        if (str == null || (length = (strTrim = str.trim()).length()) == 0) {
            return j;
        }
        int i = 0;
        char cCharAt = strTrim.charAt(0);
        if (cCharAt == '+') {
            strTrim = strTrim.substring(1);
            length = strTrim.length();
        } else if (cCharAt == '-') {
            i = 1;
        }
        while (i < length) {
            char cCharAt2 = strTrim.charAt(i);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                try {
                    return (long) j(strTrim, true);
                } catch (NumberFormatException unused) {
                    return j;
                }
            }
            i++;
        }
        try {
            return Long.parseLong(strTrim);
        } catch (NumberFormatException unused2) {
            return j;
        }
    }

    public static BigDecimal g(String str) {
        return rh.b(str);
    }

    public static BigInteger h(String str) {
        return str.length() > 1250 ? rh.b(str).toBigInteger() : new BigInteger(str);
    }

    public static double i(String str) {
        return j(str, false);
    }

    public static double j(String str, boolean z) {
        return z ? kk0.a(str) : Double.parseDouble(str);
    }

    public static float k(String str) {
        return l(str, false);
    }

    public static float l(String str, boolean z) {
        return z ? nk0.a(str) : Float.parseFloat(str);
    }

    public static int m(String str) {
        char cCharAt = str.charAt(0);
        int length = str.length();
        int i = 1;
        boolean z = cCharAt == '-';
        if (z) {
            if (length == 1 || length > 10) {
                return Integer.parseInt(str);
            }
            cCharAt = str.charAt(1);
            i = 2;
        } else if (length > 9) {
            return Integer.parseInt(str);
        }
        if (cCharAt > '9' || cCharAt < '0') {
            return Integer.parseInt(str);
        }
        int i2 = cCharAt - '0';
        if (i < length) {
            int i3 = i + 1;
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                return Integer.parseInt(str);
            }
            i2 = (i2 * 10) + (cCharAt2 - '0');
            if (i3 < length) {
                int i4 = i + 2;
                char cCharAt3 = str.charAt(i3);
                if (cCharAt3 > '9' || cCharAt3 < '0') {
                    return Integer.parseInt(str);
                }
                i2 = (i2 * 10) + (cCharAt3 - '0');
                if (i4 < length) {
                    while (true) {
                        int i5 = i4 + 1;
                        char cCharAt4 = str.charAt(i4);
                        if (cCharAt4 > '9' || cCharAt4 < '0') {
                            break;
                        }
                        i2 = (i2 * 10) + (cCharAt4 - '0');
                        if (i5 < length) {
                            i4 = i5;
                        }
                    }
                    return Integer.parseInt(str);
                }
            }
        }
        return z ? -i2 : i2;
    }

    public static int n(char[] cArr, int i, int i2) {
        if (i2 > 0 && cArr[i] == '+') {
            i++;
            i2--;
        }
        int i3 = cArr[(i + i2) - 1] - '0';
        switch (i2) {
            case 9:
                i3 += (cArr[i] - '0') * 100000000;
                i++;
            case 8:
                i3 += (cArr[i] - '0') * 10000000;
                i++;
            case 7:
                i3 += (cArr[i] - '0') * 1000000;
                i++;
            case 6:
                i3 += (cArr[i] - '0') * 100000;
                i++;
            case 5:
                i3 += (cArr[i] - '0') * 10000;
                i++;
            case 4:
                i3 += (cArr[i] - '0') * 1000;
                i++;
            case 3:
                i3 += (cArr[i] - '0') * 100;
                i++;
            case 2:
                return i3 + ((cArr[i] - '0') * 10);
            default:
                return i3;
        }
    }

    public static long o(String str) {
        return str.length() <= 9 ? m(str) : Long.parseLong(str);
    }

    public static long p(char[] cArr, int i, int i2) {
        int i3 = i2 - 9;
        return (((long) n(cArr, i, i3)) * 1000000000) + ((long) n(cArr, i + i3, 9));
    }
}
