package defpackage;

import com.fasterxml.jackson.core.JsonPointer;
import com.jieli.jl_rcsp.BuildConfig;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.j;
import kotlin.text.Regex;
import kotlin.text.i;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: loaded from: classes4.dex */
public final class h40 {
    public static final a j = new a(null);
    private static final Pattern k = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern l = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern m = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern n = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private final String a;
    private final String b;
    private final long c;
    private final String d;
    private final String e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private final int a(String str, int i, int i2, boolean z) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z)) {
                    return i;
                }
                i++;
            }
            return i2;
        }

        private final boolean b(String str, String str2) {
            if (p31.a(str, str2)) {
                return true;
            }
            return i.u(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !pa3.i(str);
        }

        private final String f(String str) {
            if (i.u(str, FileUtils.FILE_EXTENSION_SEPARATOR, false, 2, null)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String strE = fx0.e(i.p0(str, FileUtils.FILE_EXTENSION_SEPARATOR));
            if (strE != null) {
                return strE;
            }
            throw new IllegalArgumentException();
        }

        private final long g(String str, int i, int i2) {
            int iA = a(str, i, i2, false);
            Matcher matcher = h40.n.matcher(str);
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int iW = -1;
            int i6 = -1;
            int i7 = -1;
            while (iA < i2) {
                int iA2 = a(str, iA + 1, i2, true);
                matcher.region(iA, iA2);
                if (i4 == -1 && matcher.usePattern(h40.n).matches()) {
                    String strGroup = matcher.group(1);
                    p31.e(strGroup, "matcher.group(1)");
                    i4 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    p31.e(strGroup2, "matcher.group(2)");
                    i6 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    p31.e(strGroup3, "matcher.group(3)");
                    i7 = Integer.parseInt(strGroup3);
                } else if (i5 == -1 && matcher.usePattern(h40.m).matches()) {
                    String strGroup4 = matcher.group(1);
                    p31.e(strGroup4, "matcher.group(1)");
                    i5 = Integer.parseInt(strGroup4);
                } else if (iW == -1 && matcher.usePattern(h40.l).matches()) {
                    String strGroup5 = matcher.group(1);
                    p31.e(strGroup5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    p31.e(locale, "US");
                    String lowerCase = strGroup5.toLowerCase(locale);
                    p31.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String strPattern = h40.l.pattern();
                    p31.e(strPattern, "MONTH_PATTERN.pattern()");
                    iW = i.W(strPattern, lowerCase, 0, false, 6, null) / 4;
                } else if (i3 == -1 && matcher.usePattern(h40.k).matches()) {
                    String strGroup6 = matcher.group(1);
                    p31.e(strGroup6, "matcher.group(1)");
                    i3 = Integer.parseInt(strGroup6);
                }
                iA = a(str, iA2 + 1, i2, false);
            }
            if (70 <= i3 && i3 < 100) {
                i3 += 1900;
            }
            if (i3 >= 0 && i3 < 70) {
                i3 += 2000;
            }
            if (i3 < 1601) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (iW == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (1 > i5 || i5 >= 32) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i4 < 0 || i4 >= 24) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i6 < 0 || i6 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i7 < 0 || i7 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(pa3.f);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, iW - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i6);
            gregorianCalendar.set(13, i7);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long h(String str) {
            try {
                long j = Long.parseLong(str);
                if (j <= 0) {
                    return Long.MIN_VALUE;
                }
                return j;
            } catch (NumberFormatException e) {
                if (new Regex("-?\\d+").matches(str)) {
                    return i.G(str, "-", false, 2, null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e;
            }
        }

        public final h40 c(tx0 tx0Var, String str) {
            p31.f(tx0Var, SocialConstants.PARAM_URL);
            p31.f(str, "setCookie");
            return d(System.currentTimeMillis(), tx0Var, str);
        }

        /* JADX WARN: Code duplicated, block: B:43:0x00d7 A[PHI: r1
          0x00d7: PHI (r1v23 long) = (r1v7 long), (r1v11 long) binds: [B:42:0x00d5, B:53:0x00fd] A[DONT_GENERATE, DONT_INLINE]] */
        public final h40 d(long j, tx0 tx0Var, String str) {
            long j2;
            long j3;
            h40 h40Var;
            String str2;
            String str3;
            p31.f(tx0Var, SocialConstants.PARAM_URL);
            p31.f(str, "setCookie");
            int iR = pa3.r(str, ';', 0, 0, 6, null);
            int iR2 = pa3.r(str, '=', 0, iR, 2, null);
            if (iR2 == iR) {
                return null;
            }
            String strZ = pa3.Z(str, 0, iR2, 1, null);
            if (strZ.length() == 0 || pa3.y(strZ) != -1) {
                return null;
            }
            String strY = pa3.Y(str, iR2 + 1, iR);
            if (pa3.y(strY) != -1) {
                return null;
            }
            int i = iR + 1;
            int length = str.length();
            String strF = null;
            String str4 = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = true;
            long jH = -1;
            long jG = 253402300799999L;
            while (i < length) {
                int iP = pa3.p(str, ';', i, length);
                int iP2 = pa3.p(str, '=', i, iP);
                String strY2 = pa3.Y(str, i, iP2);
                String strY3 = iP2 < iP ? pa3.Y(str, iP2 + 1, iP) : Constants.STR_EMPTY;
                if (i.v(strY2, "expires", true)) {
                    try {
                        jG = g(strY3, 0, strY3.length());
                        z3 = true;
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else if (i.v(strY2, "max-age", true)) {
                    jH = h(strY3);
                    z3 = true;
                } else if (i.v(strY2, "domain", true)) {
                    strF = f(strY3);
                    z4 = false;
                } else if (i.v(strY2, "path", true)) {
                    str4 = strY3;
                } else if (i.v(strY2, "secure", true)) {
                    z = true;
                } else if (i.v(strY2, "httponly", true)) {
                    z2 = true;
                }
                i = iP + 1;
            }
            long j4 = Long.MIN_VALUE;
            if (jH == Long.MIN_VALUE) {
                j2 = j4;
            } else if (jH != -1) {
                j4 = j + (jH <= 9223372036854775L ? jH * ((long) 1000) : Long.MAX_VALUE);
                if (j4 >= j) {
                    j3 = 253402300799999L;
                    if (j4 <= 253402300799999L) {
                        j2 = j4;
                    }
                } else {
                    j3 = 253402300799999L;
                }
                j2 = j3;
            } else {
                j2 = jG;
            }
            String strH = tx0Var.h();
            if (strF == null) {
                str2 = strH;
                h40Var = null;
            } else {
                if (!b(strH, strF)) {
                    return null;
                }
                h40Var = null;
                str2 = strF;
            }
            if (strH.length() != str2.length() && PublicSuffixDatabase.e.c().c(str2) == null) {
                return h40Var;
            }
            String strSubstring = WatchConstant.FAT_FS_ROOT;
            String str5 = str4;
            if (str5 == null || !i.G(str5, WatchConstant.FAT_FS_ROOT, false, 2, h40Var)) {
                String strD = tx0Var.d();
                int iB0 = i.b0(strD, JsonPointer.SEPARATOR, 0, false, 6, null);
                if (iB0 != 0) {
                    strSubstring = strD.substring(0, iB0);
                    p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                str3 = strSubstring;
            } else {
                str3 = str5;
            }
            return new h40(strZ, strY, j2, str2, str3, z, z2, z3, z4, null);
        }

        public final List e(tx0 tx0Var, iw0 iw0Var) {
            p31.f(tx0Var, SocialConstants.PARAM_URL);
            p31.f(iw0Var, "headers");
            List listH = iw0Var.h("Set-Cookie");
            int size = listH.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                h40 h40VarC = c(tx0Var, (String) listH.get(i));
                if (h40VarC != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(h40VarC);
                }
            }
            if (arrayList == null) {
                return j.j();
            }
            List listUnmodifiableList = Collections.unmodifiableList(arrayList);
            p31.e(listUnmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return listUnmodifiableList;
        }

        private a() {
        }
    }

    public /* synthetic */ h40(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, y70 y70Var) {
        this(str, str2, j2, str3, str4, z, z2, z3, z4);
    }

    public final String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h40) {
            h40 h40Var = (h40) obj;
            if (p31.a(h40Var.a, this.a) && p31.a(h40Var.b, this.b) && h40Var.c == this.c && p31.a(h40Var.d, this.d) && p31.a(h40Var.e, this.e) && h40Var.f == this.f && h40Var.g == this.g && h40Var.h == this.h && h40Var.i == this.i) {
                return true;
            }
        }
        return false;
    }

    public final String f(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append('=');
        sb.append(this.b);
        if (this.h) {
            if (this.c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(b70.b(new Date(this.c)));
            }
        }
        if (!this.i) {
            sb.append("; domain=");
            if (z) {
                sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            }
            sb.append(this.d);
        }
        sb.append("; path=");
        sb.append(this.e);
        if (this.f) {
            sb.append("; secure");
        }
        if (this.g) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        p31.e(string, "toString()");
        return string;
    }

    public final String g() {
        return this.b;
    }

    public int hashCode() {
        return ((((((((((((((((BuildConfig.VERSION_CODE + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i);
    }

    public String toString() {
        return f(false);
    }

    private h40(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = str;
        this.b = str2;
        this.c = j2;
        this.d = str3;
        this.e = str4;
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = z4;
    }
}
