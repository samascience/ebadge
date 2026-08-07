package kotlin.text;

import defpackage.c31;
import defpackage.d63;
import defpackage.e31;
import defpackage.ga2;
import defpackage.or0;
import defpackage.p31;
import defpackage.rm2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class w extends t {

    public static final class a implements rm2 {
        final /* synthetic */ CharSequence a;

        public a(CharSequence charSequence) {
            this.a = charSequence;
        }

        @Override // defpackage.rm2
        public Iterator iterator() {
            return new f(this.a);
        }
    }

    public static /* synthetic */ boolean A0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return z0(charSequence, charSequence2, z);
    }

    public static final String B0(CharSequence charSequence, e31 e31Var) {
        p31.f(charSequence, "<this>");
        p31.f(e31Var, "range");
        return charSequence.subSequence(e31Var.h().intValue(), e31Var.g().intValue() + 1).toString();
    }

    public static final String C0(String str, char c, String str2) {
        p31.f(str, "<this>");
        p31.f(str2, "missingDelimiterValue");
        int iV = i.V(str, c, 0, false, 6, null);
        if (iV == -1) {
            return str2;
        }
        String strSubstring = str.substring(iV + 1, str.length());
        p31.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String D0(String str, String str2, String str3) {
        p31.f(str, "<this>");
        p31.f(str2, "delimiter");
        p31.f(str3, "missingDelimiterValue");
        int iW = i.W(str, str2, 0, false, 6, null);
        if (iW == -1) {
            return str3;
        }
        String strSubstring = str.substring(iW + str2.length(), str.length());
        p31.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String E0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return C0(str, c, str2);
    }

    public static /* synthetic */ String F0(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return D0(str, str2, str3);
    }

    public static String G0(String str, char c, String str2) {
        p31.f(str, "<this>");
        p31.f(str2, "missingDelimiterValue");
        int iB0 = i.b0(str, c, 0, false, 6, null);
        if (iB0 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iB0 + 1, str.length());
        p31.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String H0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return i.G0(str, c, str2);
    }

    public static final String I0(String str, char c, String str2) {
        p31.f(str, "<this>");
        p31.f(str2, "missingDelimiterValue");
        int iV = i.V(str, c, 0, false, 6, null);
        if (iV == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iV);
        p31.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean J(CharSequence charSequence, char c, boolean z) {
        p31.f(charSequence, "<this>");
        return i.V(charSequence, c, 0, z, 2, null) >= 0;
    }

    public static final String J0(String str, String str2, String str3) {
        p31.f(str, "<this>");
        p31.f(str2, "delimiter");
        p31.f(str3, "missingDelimiterValue");
        int iW = i.W(str, str2, 0, false, 6, null);
        if (iW == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iW);
        p31.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static boolean K(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        p31.f(charSequence, "<this>");
        p31.f(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (i.W(charSequence, (String) charSequence2, 0, z, 2, null) < 0) {
                return false;
            }
        } else if (U(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ String K0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return I0(str, c, str2);
    }

    public static /* synthetic */ boolean L(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return J(charSequence, c, z);
    }

    public static /* synthetic */ String L0(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return J0(str, str2, str3);
    }

    public static /* synthetic */ boolean M(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return i.K(charSequence, charSequence2, z);
    }

    public static final String M0(String str, String str2, String str3) {
        p31.f(str, "<this>");
        p31.f(str2, "delimiter");
        p31.f(str3, "missingDelimiterValue");
        int iC0 = i.c0(str, str2, 0, false, 6, null);
        if (iC0 == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iC0);
        p31.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean N(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        p31.f(charSequence, "<this>");
        p31.f(charSequence2, "suffix");
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? i.u((String) charSequence, (String) charSequence2, false, 2, null) : o0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ String N0(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return M0(str, str2, str3);
    }

    public static /* synthetic */ boolean O(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return N(charSequence, charSequence2, z);
    }

    public static CharSequence O0(CharSequence charSequence) {
        p31.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zC = b.c(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    private static final Pair P(CharSequence charSequence, Collection collection, int i, boolean z, boolean z2) {
        Object next;
        String str;
        Object next2;
        String str2;
        if (!z && collection.size() == 1) {
            String str3 = (String) kotlin.collections.j.S(collection);
            int iW = !z2 ? i.W(charSequence, str3, i, false, 4, null) : i.c0(charSequence, str3, i, false, 4, null);
            if (iW < 0) {
                return null;
            }
            return d63.a(Integer.valueOf(iW), str3);
        }
        c31 e31Var = !z2 ? new e31(ga2.b(i, 0), charSequence.length()) : ga2.i(ga2.d(i, Q(charSequence)), 0);
        if (charSequence instanceof String) {
            int iA = e31Var.a();
            int iB = e31Var.b();
            int iC = e31Var.c();
            if ((iC > 0 && iA <= iB) || (iC < 0 && iB <= iA)) {
                while (true) {
                    Iterator it = collection.iterator();
                    do {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        str2 = (String) next2;
                    } while (!t.x(str2, 0, (String) charSequence, iA, str2.length(), z));
                    String str4 = (String) next2;
                    if (str4 != null) {
                        return d63.a(Integer.valueOf(iA), str4);
                    }
                    if (iA != iB) {
                        iA += iC;
                    }
                }
            }
        } else {
            int iA2 = e31Var.a();
            int iB2 = e31Var.b();
            int iC2 = e31Var.c();
            if ((iC2 > 0 && iA2 <= iB2) || (iC2 < 0 && iB2 <= iA2)) {
                while (true) {
                    Iterator it2 = collection.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        str = (String) next;
                    } while (!o0(str, 0, charSequence, iA2, str.length(), z));
                    String str5 = (String) next;
                    if (str5 != null) {
                        return d63.a(Integer.valueOf(iA2), str5);
                    }
                    if (iA2 != iB2) {
                        iA2 += iC2;
                    }
                }
            }
        }
        return null;
    }

    public static final int Q(CharSequence charSequence) {
        p31.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int R(CharSequence charSequence, char c, int i, boolean z) {
        p31.f(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? X(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    public static final int S(CharSequence charSequence, String str, int i, boolean z) {
        p31.f(charSequence, "<this>");
        p31.f(str, "string");
        return (z || !(charSequence instanceof String)) ? U(charSequence, str, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(str, i);
    }

    private static final int T(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        c31 e31Var = !z2 ? new e31(ga2.b(i, 0), ga2.d(i2, charSequence.length())) : ga2.i(ga2.d(i, Q(charSequence)), ga2.b(i2, 0));
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int iA = e31Var.a();
            int iB = e31Var.b();
            int iC = e31Var.c();
            if ((iC <= 0 || iA > iB) && (iC >= 0 || iB > iA)) {
                return -1;
            }
            while (!o0(charSequence2, 0, charSequence, iA, charSequence2.length(), z)) {
                if (iA == iB) {
                    return -1;
                }
                iA += iC;
            }
            return iA;
        }
        int iA2 = e31Var.a();
        int iB2 = e31Var.b();
        int iC2 = e31Var.c();
        if ((iC2 <= 0 || iA2 > iB2) && (iC2 >= 0 || iB2 > iA2)) {
            return -1;
        }
        while (true) {
            String str = (String) charSequence2;
            if (t.x(str, 0, (String) charSequence, iA2, str.length(), z)) {
                return iA2;
            }
            if (iA2 == iB2) {
                return -1;
            }
            iA2 += iC2;
        }
    }

    static /* synthetic */ int U(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return T(charSequence, charSequence2, i, i2, z, z2);
    }

    public static /* synthetic */ int V(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return R(charSequence, c, i, z);
    }

    public static /* synthetic */ int W(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return S(charSequence, str, i, z);
    }

    public static final int X(CharSequence charSequence, char[] cArr, int i, boolean z) {
        p31.f(charSequence, "<this>");
        p31.f(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(kotlin.collections.d.A(cArr), i);
        }
        int iB = ga2.b(i, 0);
        int iQ = Q(charSequence);
        if (iB > iQ) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iB);
            for (char c : cArr) {
                if (c.d(c, cCharAt, z)) {
                    return iB;
                }
            }
            if (iB == iQ) {
                return -1;
            }
            iB++;
        }
    }

    public static boolean Y(CharSequence charSequence) {
        p31.f(charSequence, "<this>");
        for (int i = 0; i < charSequence.length(); i++) {
            if (!b.c(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static final int Z(CharSequence charSequence, char c, int i, boolean z) {
        p31.f(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? d0(charSequence, new char[]{c}, i, z) : ((String) charSequence).lastIndexOf(c, i);
    }

    public static final int a0(CharSequence charSequence, String str, int i, boolean z) {
        p31.f(charSequence, "<this>");
        p31.f(str, "string");
        return (z || !(charSequence instanceof String)) ? T(charSequence, str, i, 0, z, true) : ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* synthetic */ int b0(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Q(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return Z(charSequence, c, i, z);
    }

    public static /* synthetic */ int c0(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Q(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a0(charSequence, str, i, z);
    }

    public static final int d0(CharSequence charSequence, char[] cArr, int i, boolean z) {
        p31.f(charSequence, "<this>");
        p31.f(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(kotlin.collections.d.A(cArr), i);
        }
        for (int iD = ga2.d(i, Q(charSequence)); -1 < iD; iD--) {
            char cCharAt = charSequence.charAt(iD);
            for (char c : cArr) {
                if (c.d(c, cCharAt, z)) {
                    return iD;
                }
            }
        }
        return -1;
    }

    public static final rm2 e0(CharSequence charSequence) {
        p31.f(charSequence, "<this>");
        return new a(charSequence);
    }

    public static final List f0(CharSequence charSequence) {
        p31.f(charSequence, "<this>");
        return kotlin.sequences.d.z(e0(charSequence));
    }

    public static final CharSequence g0(CharSequence charSequence, int i, char c) {
        p31.f(charSequence, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        }
        if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i);
        int length = i - charSequence.length();
        int i2 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c);
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        sb.append(charSequence);
        return sb;
    }

    public static String h0(String str, int i, char c) {
        p31.f(str, "<this>");
        return g0(str, i, c).toString();
    }

    private static final rm2 i0(CharSequence charSequence, final char[] cArr, int i, final boolean z, int i2) {
        t0(i2);
        return new d(charSequence, i, i2, new or0() { // from class: kotlin.text.u
            @Override // defpackage.or0
            public final Object invoke(Object obj, Object obj2) {
                return w.m0(cArr, z, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    private static final rm2 j0(CharSequence charSequence, String[] strArr, int i, final boolean z, int i2) {
        t0(i2);
        final List listC = kotlin.collections.d.c(strArr);
        return new d(charSequence, i, i2, new or0() { // from class: kotlin.text.v
            @Override // defpackage.or0
            public final Object invoke(Object obj, Object obj2) {
                return w.n0(listC, z, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    static /* synthetic */ rm2 k0(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return i0(charSequence, cArr, i, z, i2);
    }

    static /* synthetic */ rm2 l0(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return j0(charSequence, strArr, i, z, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair m0(char[] cArr, boolean z, CharSequence charSequence, int i) {
        p31.f(charSequence, "$this$DelimitedRangesSequence");
        int iX = X(charSequence, cArr, i, z);
        if (iX < 0) {
            return null;
        }
        return d63.a(Integer.valueOf(iX), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair n0(List list, boolean z, CharSequence charSequence, int i) {
        p31.f(charSequence, "$this$DelimitedRangesSequence");
        Pair pairP = P(charSequence, list, i, z, false);
        if (pairP != null) {
            return d63.a(pairP.getFirst(), Integer.valueOf(((String) pairP.getSecond()).length()));
        }
        return null;
    }

    public static final boolean o0(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        p31.f(charSequence, "<this>");
        p31.f(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!c.d(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String p0(String str, CharSequence charSequence) {
        p31.f(str, "<this>");
        p31.f(charSequence, "prefix");
        if (!A0(str, charSequence, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length());
        p31.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String q0(String str, CharSequence charSequence) {
        p31.f(str, "<this>");
        p31.f(charSequence, "suffix");
        if (!O(str, charSequence, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - charSequence.length());
        p31.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String r0(String str, CharSequence charSequence) {
        p31.f(str, "<this>");
        p31.f(charSequence, "delimiter");
        return s0(str, charSequence, charSequence);
    }

    public static final String s0(String str, CharSequence charSequence, CharSequence charSequence2) {
        p31.f(str, "<this>");
        p31.f(charSequence, "prefix");
        p31.f(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length() || !A0(str, charSequence, false, 2, null) || !O(str, charSequence2, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        p31.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final void t0(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    public static final List u0(CharSequence charSequence, char[] cArr, boolean z, int i) {
        p31.f(charSequence, "<this>");
        p31.f(cArr, "delimiters");
        if (cArr.length == 1) {
            return w0(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable iterableK = kotlin.sequences.d.k(k0(charSequence, cArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.j.t(iterableK, 10));
        Iterator it = iterableK.iterator();
        while (it.hasNext()) {
            arrayList.add(B0(charSequence, (e31) it.next()));
        }
        return arrayList;
    }

    public static final List v0(CharSequence charSequence, String[] strArr, boolean z, int i) {
        p31.f(charSequence, "<this>");
        p31.f(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return w0(charSequence, str, z, i);
            }
        }
        Iterable iterableK = kotlin.sequences.d.k(l0(charSequence, strArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.j.t(iterableK, 10));
        Iterator it = iterableK.iterator();
        while (it.hasNext()) {
            arrayList.add(B0(charSequence, (e31) it.next()));
        }
        return arrayList;
    }

    private static final List w0(CharSequence charSequence, String str, boolean z, int i) {
        t0(i);
        int length = 0;
        int iS = S(charSequence, str, 0, z);
        if (iS == -1 || i == 1) {
            return kotlin.collections.j.e(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? ga2.d(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iS).toString());
            length = str.length() + iS;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            iS = S(charSequence, str, length, z);
        } while (iS != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List x0(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return u0(charSequence, cArr, z, i);
    }

    public static /* synthetic */ List y0(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return v0(charSequence, strArr, z, i);
    }

    public static final boolean z0(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        p31.f(charSequence, "<this>");
        p31.f(charSequence2, "prefix");
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? i.G((String) charSequence, (String) charSequence2, false, 2, null) : o0(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }
}
