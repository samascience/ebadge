package defpackage;

import com.fasterxml.jackson.core.JsonFactory;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public final class fi1 {
    public static final a e = new a(null);
    private static final Pattern f = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern g = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private final String a;
    private final String b;
    private final String c;
    private final String[] d;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final fi1 a(String str) {
            p31.f(str, "<this>");
            Matcher matcher = fi1.f.matcher(str);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + str + JsonFactory.DEFAULT_QUOTE_CHAR).toString());
            }
            String strGroup = matcher.group(1);
            p31.e(strGroup, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            p31.e(locale, "US");
            String lowerCase = strGroup.toLowerCase(locale);
            p31.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            String strGroup2 = matcher.group(2);
            p31.e(strGroup2, "typeSubtype.group(2)");
            p31.e(locale, "US");
            String lowerCase2 = strGroup2.toLowerCase(locale);
            p31.e(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = fi1.g.matcher(str);
            int iEnd = matcher.end();
            while (iEnd < str.length()) {
                matcher2.region(iEnd, str.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Parameter is not formatted correctly: \"");
                    String strSubstring = str.substring(iEnd);
                    p31.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                    sb.append(strSubstring);
                    sb.append("\" for: \"");
                    sb.append(str);
                    sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                String strGroup3 = matcher2.group(1);
                if (strGroup3 == null) {
                    iEnd = matcher2.end();
                } else {
                    String strGroup4 = matcher2.group(2);
                    if (strGroup4 == null) {
                        strGroup4 = matcher2.group(3);
                    } else if (i.G(strGroup4, "'", false, 2, null) && i.u(strGroup4, "'", false, 2, null) && strGroup4.length() > 2) {
                        strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                        p31.e(strGroup4, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    arrayList.add(strGroup3);
                    arrayList.add(strGroup4);
                    iEnd = matcher2.end();
                }
            }
            return new fi1(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]), null);
        }

        public final fi1 b(String str) {
            p31.f(str, "<this>");
            try {
                return a(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private a() {
        }
    }

    public /* synthetic */ fi1(String str, String str2, String str3, String[] strArr, y70 y70Var) {
        this(str, str2, str3, strArr);
    }

    public static /* synthetic */ Charset d(fi1 fi1Var, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = null;
        }
        return fi1Var.c(charset);
    }

    public static final fi1 e(String str) {
        return e.a(str);
    }

    public static final fi1 g(String str) {
        return e.b(str);
    }

    public final Charset c(Charset charset) {
        String strF = f("charset");
        if (strF == null) {
            return charset;
        }
        try {
            return Charset.forName(strF);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof fi1) && p31.a(((fi1) obj).a, this.a);
    }

    public final String f(String str) {
        p31.f(str, "name");
        int i = 0;
        int iB = f82.b(0, this.d.length - 1, 2);
        if (iB < 0) {
            return null;
        }
        while (!i.v(this.d[i], str, true)) {
            if (i == iB) {
                return null;
            }
            i += 2;
        }
        return this.d[i + 1];
    }

    public final String h() {
        return this.c;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public final String i() {
        return this.b;
    }

    public String toString() {
        return this.a;
    }

    private fi1(String str, String str2, String str3, String[] strArr) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = strArr;
    }
}
