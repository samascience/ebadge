package kotlin.text;

import com.tencent.connect.common.Constants;
import defpackage.ga2;
import defpackage.gx;
import defpackage.lv2;
import defpackage.p31;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class t extends s {
    public static String A(String str, String str2, String str3, boolean z) {
        p31.f(str, "<this>");
        p31.f(str2, "oldValue");
        p31.f(str3, "newValue");
        int i = 0;
        int iS = w.S(str, str2, 0, z);
        if (iS < 0) {
            return str;
        }
        int length = str2.length();
        int iB = ga2.b(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i, iS);
            sb.append(str3);
            i = iS + length;
            if (iS >= str.length()) {
                break;
            }
            iS = w.S(str, str2, iS + iB, z);
        } while (iS > 0);
        sb.append((CharSequence) str, i, str.length());
        String string = sb.toString();
        p31.e(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String B(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return z(str, c, c2, z);
    }

    public static /* synthetic */ String C(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return i.A(str, str2, str3, z);
    }

    public static boolean D(String str, String str2, int i, boolean z) {
        p31.f(str, "<this>");
        p31.f(str2, "prefix");
        return !z ? str.startsWith(str2, i) : x(str, i, str2, 0, str2.length(), z);
    }

    public static boolean E(String str, String str2, boolean z) {
        p31.f(str, "<this>");
        p31.f(str2, "prefix");
        return !z ? str.startsWith(str2) : x(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean F(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return i.D(str, str2, i, z);
    }

    public static /* synthetic */ boolean G(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return i.E(str, str2, z);
    }

    public static String q(char[] cArr) {
        p31.f(cArr, "<this>");
        return new String(cArr);
    }

    public static String r(char[] cArr, int i, int i2) {
        p31.f(cArr, "<this>");
        kotlin.collections.a.Companion.a(i, i2, cArr.length);
        return new String(cArr, i, i2 - i);
    }

    public static String s(byte[] bArr) {
        p31.f(bArr, "<this>");
        return new String(bArr, gx.b);
    }

    public static boolean t(String str, String str2, boolean z) {
        p31.f(str, "<this>");
        p31.f(str2, "suffix");
        return !z ? str.endsWith(str2) : x(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean u(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return i.t(str, str2, z);
    }

    public static boolean v(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        }
        return !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static Comparator w(lv2 lv2Var) {
        p31.f(lv2Var, "<this>");
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        p31.e(comparator, "CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    public static final boolean x(String str, int i, String str2, int i2, int i3, boolean z) {
        p31.f(str, "<this>");
        p31.f(str2, "other");
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }

    public static String y(CharSequence charSequence, int i) {
        p31.f(charSequence, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
        }
        if (i == 0) {
            return Constants.STR_EMPTY;
        }
        int i2 = 1;
        if (i == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return Constants.STR_EMPTY;
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i];
            for (int i3 = 0; i3 < i; i3++) {
                cArr[i3] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i);
        if (1 <= i) {
            while (true) {
                sb.append(charSequence);
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        String string = sb.toString();
        p31.c(string);
        return string;
    }

    public static final String z(String str, char c, char c2, boolean z) {
        p31.f(str, "<this>");
        if (!z) {
            String strReplace = str.replace(c, c2);
            p31.e(strReplace, "replace(...)");
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (c.d(cCharAt, c, z)) {
                cCharAt = c2;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }
}
