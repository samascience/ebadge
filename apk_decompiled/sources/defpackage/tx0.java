package defpackage;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonPointer;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.jieli.jl_rcsp.constant.Command;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.EOFException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.j;
import kotlin.text.Regex;
import kotlin.text.i;
import org.objectweb.asm.Opcodes;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes4.dex */
public final class tx0 {
    public static final b k = new b(null);
    private static final char[] l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final int e;
    private final List f;
    private final List g;
    private final String h;
    private final String i;
    private final boolean j;

    public static final class a {
        public static final C0173a i = new C0173a(null);
        private String a;
        private String d;
        private final List f;
        private List g;
        private String h;
        private String b = Constants.STR_EMPTY;
        private String c = Constants.STR_EMPTY;
        private int e = -1;

        /* JADX INFO: renamed from: tx0$a$a, reason: collision with other inner class name */
        public static final class C0173a {
            public /* synthetic */ C0173a(y70 y70Var) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int e(String str, int i, int i2) {
                try {
                    int i3 = Integer.parseInt(b.b(tx0.k, str, i, i2, Constants.STR_EMPTY, false, false, false, false, null, 248, null));
                    if (1 > i3 || i3 >= 65536) {
                        return -1;
                    }
                    return i3;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int f(String str, int i, int i2) {
                while (i < i2) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt == '[') {
                        do {
                            i++;
                            if (i >= i2) {
                                break;
                            }
                        } while (str.charAt(i) != ']');
                    } else if (cCharAt == ':') {
                        return i;
                    }
                    i++;
                }
                return i2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int g(String str, int i, int i2) {
                if (i2 - i < 2) {
                    return -1;
                }
                char cCharAt = str.charAt(i);
                if ((p31.g(cCharAt, 97) < 0 || p31.g(cCharAt, 122) > 0) && (p31.g(cCharAt, 65) < 0 || p31.g(cCharAt, 90) > 0)) {
                    return -1;
                }
                while (true) {
                    i++;
                    if (i >= i2) {
                        return -1;
                    }
                    char cCharAt2 = str.charAt(i);
                    if ('a' > cCharAt2 || cCharAt2 >= '{') {
                        if ('A' > cCharAt2 || cCharAt2 >= '[') {
                            if ('0' > cCharAt2 || cCharAt2 >= ':') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                    return -1;
                                }
                            }
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int h(String str, int i, int i2) {
                int i3 = 0;
                while (i < i2) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt != '\\' && cCharAt != '/') {
                        break;
                    }
                    i3++;
                    i++;
                }
                return i3;
            }

            private C0173a() {
            }
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add(Constants.STR_EMPTY);
        }

        private final int d() {
            int i2 = this.e;
            if (i2 != -1) {
                return i2;
            }
            b bVar = tx0.k;
            String str = this.a;
            p31.c(str);
            return bVar.c(str);
        }

        private final boolean h(String str) {
            return p31.a(str, FileUtils.FILE_EXTENSION_SEPARATOR) || i.v(str, "%2e", true);
        }

        private final boolean i(String str) {
            return p31.a(str, "..") || i.v(str, "%2e.", true) || i.v(str, ".%2e", true) || i.v(str, "%2e%2e", true);
        }

        private final void l() {
            List list = this.f;
            if (((String) list.remove(list.size() - 1)).length() != 0 || this.f.isEmpty()) {
                this.f.add(Constants.STR_EMPTY);
            } else {
                List list2 = this.f;
                list2.set(list2.size() - 1, Constants.STR_EMPTY);
            }
        }

        private final void n(String str, int i2, int i3, boolean z, boolean z2) {
            String strB = b.b(tx0.k, str, i2, i3, " \"<>^`{}|/\\?#", z2, false, false, false, null, 240, null);
            if (h(strB)) {
                return;
            }
            if (i(strB)) {
                l();
                return;
            }
            List list = this.f;
            if (((CharSequence) list.get(list.size() - 1)).length() == 0) {
                List list2 = this.f;
                list2.set(list2.size() - 1, strB);
            } else {
                this.f.add(strB);
            }
            if (z) {
                this.f.add(Constants.STR_EMPTY);
            }
        }

        private final void p(String str, int i2, int i3) {
            if (i2 == i3) {
                return;
            }
            char cCharAt = str.charAt(i2);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.f.clear();
                this.f.add(Constants.STR_EMPTY);
                i2++;
            } else {
                List list = this.f;
                list.set(list.size() - 1, Constants.STR_EMPTY);
            }
            while (true) {
                int i4 = i2;
                while (i4 < i3) {
                    i2 = pa3.q(str, "/\\", i4, i3);
                    boolean z = i2 < i3;
                    n(str, i4, i2, z, true);
                    if (z) {
                        i4 = i2 + 1;
                    }
                }
                return;
            }
        }

        public final a a(String str, String str2) {
            p31.f(str, "encodedName");
            if (this.g == null) {
                this.g = new ArrayList();
            }
            List list = this.g;
            p31.c(list);
            b bVar = tx0.k;
            list.add(b.b(bVar, str, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null));
            List list2 = this.g;
            p31.c(list2);
            list2.add(str2 != null ? b.b(bVar, str2, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null) : null);
            return this;
        }

        public final a b(String str, String str2) {
            p31.f(str, "name");
            if (this.g == null) {
                this.g = new ArrayList();
            }
            List list = this.g;
            p31.c(list);
            b bVar = tx0.k;
            list.add(b.b(bVar, str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
            List list2 = this.g;
            p31.c(list2);
            list2.add(str2 != null ? b.b(bVar, str2, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null) : null);
            return this;
        }

        public final tx0 c() {
            ArrayList arrayList;
            String str = this.a;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            b bVar = tx0.k;
            String strH = b.h(bVar, this.b, 0, 0, false, 7, null);
            String strH2 = b.h(bVar, this.c, 0, 0, false, 7, null);
            String str2 = this.d;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iD = d();
            List list = this.f;
            ArrayList arrayList2 = new ArrayList(j.t(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(b.h(tx0.k, (String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.g;
            if (list2 != null) {
                arrayList = new ArrayList(j.t(list2, 10));
                for (String str3 : list2) {
                    arrayList.add(str3 != null ? b.h(tx0.k, str3, 0, 0, true, 3, null) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.h;
            return new tx0(str, strH, strH2, str2, iD, arrayList2, arrayList, str4 != null ? b.h(tx0.k, str4, 0, 0, false, 7, null) : null, toString());
        }

        /* JADX WARN: Code duplicated, block: B:6:0x001d  */
        public final a e(String str) {
            List listJ;
            if (str != null) {
                b bVar = tx0.k;
                String strB = b.b(bVar, str, 0, 0, " \"'<>#", true, false, true, false, null, 211, null);
                if (strB != null) {
                    listJ = bVar.j(strB);
                } else {
                    listJ = null;
                }
            } else {
                listJ = null;
            }
            this.g = listJ;
            return this;
        }

        public final List f() {
            return this.f;
        }

        public final a g(String str) {
            p31.f(str, "host");
            String strE = fx0.e(b.h(tx0.k, str, 0, 0, false, 7, null));
            if (strE != null) {
                this.d = strE;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public final a j(tx0 tx0Var, String str) {
            int iQ;
            int i2;
            int i3;
            boolean z;
            boolean z2;
            String str2 = str;
            p31.f(str2, "input");
            int iA = pa3.A(str2, 0, 0, 3, null);
            int iC = pa3.C(str2, iA, 0, 2, null);
            C0173a c0173a = i;
            int iG = c0173a.g(str2, iA, iC);
            boolean z3 = true;
            byte b = -1;
            if (iG != -1) {
                if (i.D(str2, "https:", iA, true)) {
                    this.a = "https";
                    iA += 6;
                } else {
                    if (!i.D(str2, "http:", iA, true)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = str2.substring(0, iG);
                        p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb.append(strSubstring);
                        sb.append('\'');
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.a = "http";
                    iA += 5;
                }
            } else {
                if (tx0Var == null) {
                    if (str.length() > 6) {
                        str2 = i.S0(str2, 6) + "...";
                    }
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + str2);
                }
                this.a = tx0Var.r();
            }
            int iH = c0173a.h(str2, iA, iC);
            byte b2 = 63;
            byte b3 = 35;
            if (iH >= 2 || tx0Var == null || !p31.a(tx0Var.r(), this.a)) {
                boolean z4 = false;
                boolean z5 = false;
                int i4 = iA + iH;
                while (true) {
                    iQ = pa3.q(str2, "@/\\?#", i4, iC);
                    byte bCharAt = iQ != iC ? str2.charAt(iQ) : b;
                    if (bCharAt == b || bCharAt == b3 || bCharAt == 47 || bCharAt == 92 || bCharAt == b2) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z4) {
                            i3 = iQ;
                            z = z3;
                            this.c += "%40" + b.b(tx0.k, str, i4, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                        } else {
                            int iP = pa3.p(str2, ':', i4, iQ);
                            b bVar = tx0.k;
                            z = z3;
                            String strB = b.b(bVar, str, i4, iP, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z5) {
                                strB = this.b + "%40" + strB;
                            }
                            this.b = strB;
                            i3 = iQ;
                            if (iP != i3) {
                                this.c = b.b(bVar, str, iP + 1, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z2 = z;
                            } else {
                                z2 = z4;
                            }
                            z4 = z2;
                            z5 = z;
                        }
                        i4 = i3 + 1;
                        z3 = z;
                        iC = iC;
                        b3 = 35;
                        b2 = 63;
                        b = -1;
                    }
                }
                i2 = iC;
                C0173a c0173a2 = i;
                int iF = c0173a2.f(str2, i4, iQ);
                int i5 = iF + 1;
                if (i5 < iQ) {
                    this.d = fx0.e(b.h(tx0.k, str, i4, iF, false, 4, null));
                    int iE = c0173a2.e(str2, i5, iQ);
                    this.e = iE;
                    if (iE == -1) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Invalid URL port: \"");
                        String strSubstring2 = str2.substring(i5, iQ);
                        p31.e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb2.append(strSubstring2);
                        sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                        throw new IllegalArgumentException(sb2.toString().toString());
                    }
                } else {
                    b bVar2 = tx0.k;
                    this.d = fx0.e(b.h(bVar2, str, i4, iF, false, 4, null));
                    String str3 = this.a;
                    p31.c(str3);
                    this.e = bVar2.c(str3);
                }
                if (this.d == null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Invalid URL host: \"");
                    String strSubstring3 = str2.substring(i4, iF);
                    p31.e(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb3.append(strSubstring3);
                    sb3.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                    throw new IllegalArgumentException(sb3.toString().toString());
                }
                iA = iQ;
            } else {
                this.b = tx0Var.g();
                this.c = tx0Var.c();
                this.d = tx0Var.h();
                this.e = tx0Var.n();
                this.f.clear();
                this.f.addAll(tx0Var.e());
                if (iA == iC || str2.charAt(iA) == '#') {
                    e(tx0Var.f());
                }
                i2 = iC;
            }
            int i6 = i2;
            int iQ2 = pa3.q(str2, "?#", iA, i6);
            p(str2, iA, iQ2);
            if (iQ2 < i6 && str2.charAt(iQ2) == '?') {
                int iP2 = pa3.p(str2, '#', iQ2, i6);
                b bVar3 = tx0.k;
                this.g = bVar3.j(b.b(bVar3, str, iQ2 + 1, iP2, " \"'<>#", true, false, true, false, null, Command.CMD_NOTIFY_DEVICE_APP_INFO, null));
                iQ2 = iP2;
            }
            if (iQ2 < i6 && str2.charAt(iQ2) == '#') {
                this.h = b.b(tx0.k, str, iQ2 + 1, i6, Constants.STR_EMPTY, true, false, false, true, null, Opcodes.ARETURN, null);
            }
            return this;
        }

        public final a k(String str) {
            p31.f(str, "password");
            this.c = b.b(tx0.k, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final a m(int i2) {
            if (1 <= i2 && i2 < 65536) {
                this.e = i2;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i2).toString());
        }

        public final a o() {
            String str = this.d;
            this.d = str != null ? new Regex("[\"<>^`{|}]").replace(str, Constants.STR_EMPTY) : null;
            int size = this.f.size();
            for (int i2 = 0; i2 < size; i2++) {
                List list = this.f;
                list.set(i2, b.b(tx0.k, (String) list.get(i2), 0, 0, "[]", true, true, false, false, null, 227, null));
            }
            List list2 = this.g;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str2 = (String) list2.get(i3);
                    list2.set(i3, str2 != null ? b.b(tx0.k, str2, 0, 0, "\\^`{|}", true, true, true, false, null, 195, null) : null);
                }
            }
            String str3 = this.h;
            this.h = str3 != null ? b.b(tx0.k, str3, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163, null) : null;
            return this;
        }

        public final a q(String str) {
            p31.f(str, "scheme");
            if (i.v(str, "http", true)) {
                this.a = "http";
            } else {
                if (!i.v(str, "https", true)) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.a = "https";
            }
            return this;
        }

        public final void r(String str) {
            this.h = str;
        }

        public final void s(String str) {
            p31.f(str, "<set-?>");
            this.c = str;
        }

        public final void t(String str) {
            p31.f(str, "<set-?>");
            this.b = str;
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0085  */
        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (this.b.length() > 0 || this.c.length() > 0) {
                sb.append(this.b);
                if (this.c.length() > 0) {
                    sb.append(':');
                    sb.append(this.c);
                }
                sb.append('@');
            }
            String str2 = this.d;
            if (str2 != null) {
                p31.c(str2);
                if (i.L(str2, ':', false, 2, null)) {
                    sb.append('[');
                    sb.append(this.d);
                    sb.append(']');
                } else {
                    sb.append(this.d);
                }
            }
            if (this.e != -1 || this.a != null) {
                int iD = d();
                String str3 = this.a;
                if (str3 != null) {
                    b bVar = tx0.k;
                    p31.c(str3);
                    if (iD != bVar.c(str3)) {
                        sb.append(':');
                        sb.append(iD);
                    }
                } else {
                    sb.append(':');
                    sb.append(iD);
                }
            }
            b bVar2 = tx0.k;
            bVar2.i(this.f, sb);
            if (this.g != null) {
                sb.append('?');
                List list = this.g;
                p31.c(list);
                bVar2.k(list, sb);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            String string = sb.toString();
            p31.e(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        public final void u(String str) {
            this.d = str;
        }

        public final void v(int i2) {
            this.e = i2;
        }

        public final void w(String str) {
            this.a = str;
        }

        public final a x(String str) {
            p31.f(str, "username");
            this.b = b.b(tx0.k, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        public static /* synthetic */ String b(b bVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset, int i3, Object obj) {
            return bVar.a(str, (i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? str.length() : i2, str2, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? false : z3, (i3 & 64) != 0 ? false : z4, (i3 & 128) != 0 ? null : charset);
        }

        private final boolean e(String str, int i, int i2) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && pa3.H(str.charAt(i + 1)) != -1 && pa3.H(str.charAt(i3)) != -1;
        }

        public static /* synthetic */ String h(b bVar, String str, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            return bVar.g(str, i, i2, z);
        }

        /* JADX WARN: Code duplicated, block: B:39:0x0067  */
        /* JADX WARN: Code duplicated, block: B:40:0x0069  */
        /* JADX WARN: Code duplicated, block: B:43:0x0071  */
        /* JADX WARN: Code duplicated, block: B:49:0x008a  */
        /* JADX WARN: Code duplicated, block: B:52:0x0093 A[LOOP:1: B:50:0x008d->B:52:0x0093, LOOP_END] */
        private final void l(fo foVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) throws EOFException {
            int iCharCount = i;
            fo foVar2 = null;
            while (iCharCount < i2) {
                int iCodePointAt = str.codePointAt(iCharCount);
                if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                    if (iCodePointAt == 43 && z3) {
                        foVar.S(z ? Marker.ANY_NON_NULL_MARKER : "%2B");
                    } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z4) || i.L(str2, (char) iCodePointAt, false, 2, null))) {
                        if (foVar2 == null) {
                            foVar2 = new fo();
                        }
                        if (charset != null || p31.a(charset, StandardCharsets.UTF_8)) {
                            foVar2.Z0(iCodePointAt);
                        } else {
                            foVar2.V0(str, iCharCount, Character.charCount(iCodePointAt) + iCharCount, charset);
                        }
                        while (!foVar2.H()) {
                            byte b = foVar2.readByte();
                            foVar.I(37);
                            foVar.I(tx0.l[((b & 255) >> 4) & 15]);
                            foVar.I(tx0.l[b & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS]);
                        }
                    } else {
                        if (iCodePointAt == 37) {
                            if (z) {
                                if (z2) {
                                    if (!e(str, iCharCount, i2)) {
                                    }
                                }
                            }
                            if (foVar2 == null) {
                                foVar2 = new fo();
                            }
                            if (charset != null) {
                                foVar2.Z0(iCodePointAt);
                            } else {
                                foVar2.Z0(iCodePointAt);
                            }
                            while (!foVar2.H()) {
                                byte b2 = foVar2.readByte();
                                foVar.I(37);
                                foVar.I(tx0.l[((b2 & 255) >> 4) & 15]);
                                foVar.I(tx0.l[b2 & AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS]);
                            }
                        }
                        foVar.Z0(iCodePointAt);
                    }
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
        }

        private final void m(fo foVar, String str, int i, int i2, boolean z) {
            int i3;
            while (i < i2) {
                int iCodePointAt = str.codePointAt(i);
                if (iCodePointAt == 37 && (i3 = i + 2) < i2) {
                    int iH = pa3.H(str.charAt(i + 1));
                    int iH2 = pa3.H(str.charAt(i3));
                    if (iH == -1 || iH2 == -1) {
                        foVar.Z0(iCodePointAt);
                        i += Character.charCount(iCodePointAt);
                    } else {
                        foVar.I((iH << 4) + iH2);
                        i = Character.charCount(iCodePointAt) + i3;
                    }
                } else if (iCodePointAt == 43 && z) {
                    foVar.I(32);
                    i++;
                } else {
                    foVar.Z0(iCodePointAt);
                    i += Character.charCount(iCodePointAt);
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0041  */
        public final String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) throws EOFException {
            p31.f(str, "<this>");
            p31.f(str2, "encodeSet");
            int iCharCount = i;
            while (true) {
                if (iCharCount >= i2) {
                    String strSubstring = str.substring(i, i2);
                    p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    return strSubstring;
                }
                int iCodePointAt = str.codePointAt(iCharCount);
                if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z4) || i.L(str2, (char) iCodePointAt, false, 2, null))) {
                    break;
                }
                if (iCodePointAt == 37) {
                    if (!z) {
                        break;
                    }
                    if (z2) {
                        if (e(str, iCharCount, i2)) {
                        }
                    }
                    if (iCodePointAt == 43) {
                    }
                    iCharCount += Character.charCount(iCodePointAt);
                } else if (iCodePointAt == 43 || !z3) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
                fo foVar = new fo();
                foVar.Y0(str, i, iCharCount);
                l(foVar, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                return foVar.G0();
            }
            fo foVar2 = new fo();
            foVar2.Y0(str, i, iCharCount);
            l(foVar2, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
            return foVar2.G0();
        }

        public final int c(String str) {
            p31.f(str, "scheme");
            if (p31.a(str, "http")) {
                return 80;
            }
            return p31.a(str, "https") ? 443 : -1;
        }

        public final tx0 d(String str) {
            p31.f(str, "<this>");
            return new a().j(null, str).c();
        }

        public final tx0 f(String str) {
            p31.f(str, "<this>");
            try {
                return d(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String g(String str, int i, int i2, boolean z) {
            p31.f(str, "<this>");
            for (int i3 = i; i3 < i2; i3++) {
                char cCharAt = str.charAt(i3);
                if (cCharAt == '%' || (cCharAt == '+' && z)) {
                    fo foVar = new fo();
                    foVar.Y0(str, i, i3);
                    m(foVar, str, i3, i2, z);
                    return foVar.G0();
                }
            }
            String strSubstring = str.substring(i, i2);
            p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final void i(List list, StringBuilder sb) {
            p31.f(list, "<this>");
            p31.f(sb, "out");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(JsonPointer.SEPARATOR);
                sb.append((String) list.get(i));
            }
        }

        public final List j(String str) {
            p31.f(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int iV = i.V(str, '&', i, false, 4, null);
                if (iV == -1) {
                    iV = str.length();
                }
                int i2 = iV;
                int iV2 = i.V(str, '=', i, false, 4, null);
                if (iV2 == -1 || iV2 > i2) {
                    String strSubstring = str.substring(i, i2);
                    p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i, iV2);
                    p31.e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iV2 + 1, i2);
                    p31.e(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i = i2 + 1;
            }
            return arrayList;
        }

        public final void k(List list, StringBuilder sb) {
            p31.f(list, "<this>");
            p31.f(sb, "out");
            c31 c31VarJ = ga2.j(ga2.k(0, list.size()), 2);
            int iA = c31VarJ.a();
            int iB = c31VarJ.b();
            int iC = c31VarJ.c();
            if ((iC <= 0 || iA > iB) && (iC >= 0 || iB > iA)) {
                return;
            }
            while (true) {
                String str = (String) list.get(iA);
                String str2 = (String) list.get(iA + 1);
                if (iA > 0) {
                    sb.append('&');
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append('=');
                    sb.append(str2);
                }
                if (iA == iB) {
                    return;
                } else {
                    iA += iC;
                }
            }
        }

        private b() {
        }
    }

    public tx0(String str, String str2, String str3, String str4, int i, List list, List list2, String str5, String str6) {
        p31.f(str, "scheme");
        p31.f(str2, "username");
        p31.f(str3, "password");
        p31.f(str4, "host");
        p31.f(list, "pathSegments");
        p31.f(str6, SocialConstants.PARAM_URL);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = i;
        this.f = list;
        this.g = list2;
        this.h = str5;
        this.i = str6;
        this.j = p31.a(str, "https");
    }

    public static final tx0 l(String str) {
        return k.f(str);
    }

    public final String b() {
        if (this.h == null) {
            return null;
        }
        String strSubstring = this.i.substring(i.V(this.i, '#', 0, false, 6, null) + 1);
        p31.e(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public final String c() {
        if (this.c.length() == 0) {
            return Constants.STR_EMPTY;
        }
        String strSubstring = this.i.substring(i.V(this.i, ':', this.a.length() + 3, false, 4, null) + 1, i.V(this.i, '@', 0, false, 6, null));
        p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String d() {
        int iV = i.V(this.i, JsonPointer.SEPARATOR, this.a.length() + 3, false, 4, null);
        String str = this.i;
        String strSubstring = this.i.substring(iV, pa3.q(str, "?#", iV, str.length()));
        p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final List e() {
        int iV = i.V(this.i, JsonPointer.SEPARATOR, this.a.length() + 3, false, 4, null);
        String str = this.i;
        int iQ = pa3.q(str, "?#", iV, str.length());
        ArrayList arrayList = new ArrayList();
        while (iV < iQ) {
            int i = iV + 1;
            int iP = pa3.p(this.i, JsonPointer.SEPARATOR, i, iQ);
            String strSubstring = this.i.substring(i, iP);
            p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iV = iP;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof tx0) && p31.a(((tx0) obj).i, this.i);
    }

    public final String f() {
        if (this.g == null) {
            return null;
        }
        int iV = i.V(this.i, '?', 0, false, 6, null) + 1;
        String str = this.i;
        String strSubstring = this.i.substring(iV, pa3.p(str, '#', iV, str.length()));
        p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String g() {
        if (this.b.length() == 0) {
            return Constants.STR_EMPTY;
        }
        int length = this.a.length() + 3;
        String str = this.i;
        String strSubstring = this.i.substring(length, pa3.q(str, ":@", length, str.length()));
        p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String h() {
        return this.d;
    }

    public int hashCode() {
        return this.i.hashCode();
    }

    public final boolean i() {
        return this.j;
    }

    public final a j() {
        a aVar = new a();
        aVar.w(this.a);
        aVar.t(g());
        aVar.s(c());
        aVar.u(this.d);
        aVar.v(this.e != k.c(this.a) ? this.e : -1);
        aVar.f().clear();
        aVar.f().addAll(e());
        aVar.e(f());
        aVar.r(b());
        return aVar;
    }

    public final a k(String str) {
        p31.f(str, "link");
        try {
            return new a().j(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final List m() {
        return this.f;
    }

    public final int n() {
        return this.e;
    }

    public final String o() {
        if (this.g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        k.k(this.g, sb);
        return sb.toString();
    }

    public final String p() {
        a aVarK = k("/...");
        p31.c(aVarK);
        return aVarK.x(Constants.STR_EMPTY).k(Constants.STR_EMPTY).c().toString();
    }

    public final tx0 q(String str) {
        p31.f(str, "link");
        a aVarK = k(str);
        if (aVarK != null) {
            return aVarK.c();
        }
        return null;
    }

    public final String r() {
        return this.a;
    }

    public final URI s() {
        String string = j().o().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(string, Constants.STR_EMPTY));
                p31.e(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final URL t() {
        try {
            return new URL(this.i);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return this.i;
    }
}
