package defpackage;

import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.collections.j;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public final class iw0 implements Iterable, k81 {
    public static final b b = new b(null);
    private final String[] a;

    public static final class a {
        private final List a = new ArrayList(20);

        public final a a(String str, String str2) {
            p31.f(str, "name");
            p31.f(str2, "value");
            b bVar = iw0.b;
            bVar.d(str);
            bVar.e(str2, str);
            c(str, str2);
            return this;
        }

        public final a b(String str) {
            p31.f(str, "line");
            int iV = i.V(str, ':', 1, false, 4, null);
            if (iV != -1) {
                String strSubstring = str.substring(0, iV);
                p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = str.substring(iV + 1);
                p31.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
                c(strSubstring, strSubstring2);
            } else if (str.charAt(0) == ':') {
                String strSubstring3 = str.substring(1);
                p31.e(strSubstring3, "this as java.lang.String).substring(startIndex)");
                c(Constants.STR_EMPTY, strSubstring3);
            } else {
                c(Constants.STR_EMPTY, str);
            }
            return this;
        }

        public final a c(String str, String str2) {
            p31.f(str, "name");
            p31.f(str2, "value");
            this.a.add(str);
            this.a.add(i.O0(str2).toString());
            return this;
        }

        public final a d(String str, String str2) {
            p31.f(str, "name");
            p31.f(str2, "value");
            iw0.b.d(str);
            c(str, str2);
            return this;
        }

        public final iw0 e() {
            return new iw0((String[]) this.a.toArray(new String[0]), null);
        }

        public final List f() {
            return this.a;
        }

        public final a g(String str) {
            p31.f(str, "name");
            int i = 0;
            while (i < this.a.size()) {
                if (i.v(str, (String) this.a.get(i), true)) {
                    this.a.remove(i);
                    this.a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public final a h(String str, String str2) {
            p31.f(str, "name");
            p31.f(str2, "value");
            b bVar = iw0.b;
            bVar.d(str);
            bVar.e(str2, str);
            g(str);
            c(str, str2);
            return this;
        }
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(String str) {
            if (str.length() <= 0) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if ('!' > cCharAt || cCharAt >= 127) {
                    throw new IllegalArgumentException(pa3.t("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(String str, String str2) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(pa3.t("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i), str2));
                    sb.append(pa3.G(str2) ? Constants.STR_EMPTY : ": " + str);
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String f(String[] strArr, String str) {
            int length = strArr.length - 2;
            int iB = f82.b(length, 0, -2);
            if (iB > length) {
                return null;
            }
            while (!i.v(str, strArr[length], true)) {
                if (length == iB) {
                    return null;
                }
                length -= 2;
            }
            return strArr[length + 1];
        }

        public final iw0 g(Map map) {
            p31.f(map, "<this>");
            String[] strArr = new String[map.size() * 2];
            int i = 0;
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                String string = i.O0(str).toString();
                String string2 = i.O0(str2).toString();
                d(string);
                e(string2, string);
                strArr[i] = string;
                strArr[i + 1] = string2;
                i += 2;
            }
            return new iw0(strArr, null);
        }

        public final iw0 h(String... strArr) {
            p31.f(strArr, "namesAndValues");
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            String[] strArr2 = (String[]) strArr.clone();
            int length = strArr2.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                String str = strArr2[i2];
                if (str == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                strArr2[i2] = i.O0(str).toString();
            }
            int iB = f82.b(0, strArr2.length - 1, 2);
            if (iB >= 0) {
                while (true) {
                    String str2 = strArr2[i];
                    String str3 = strArr2[i + 1];
                    d(str2);
                    e(str3, str2);
                    if (i == iB) {
                        break;
                    }
                    i += 2;
                }
            }
            return new iw0(strArr2, null);
        }

        private b() {
        }
    }

    public /* synthetic */ iw0(String[] strArr, y70 y70Var) {
        this(strArr);
    }

    public static final iw0 d(Map map) {
        return b.g(map);
    }

    public static final iw0 e(String... strArr) {
        return b.h(strArr);
    }

    public final String a(String str) {
        p31.f(str, "name");
        return b.f(this.a, str);
    }

    public final String b(int i) {
        return this.a[i * 2];
    }

    public final a c() {
        a aVar = new a();
        j.x(aVar.f(), this.a);
        return aVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof iw0) && Arrays.equals(this.a, ((iw0) obj).a);
    }

    public final Map f() {
        TreeMap treeMap = new TreeMap(i.w(lv2.a));
        int size = size();
        for (int i = 0; i < size; i++) {
            String strB = b(i);
            Locale locale = Locale.US;
            p31.e(locale, "US");
            String lowerCase = strB.toLowerCase(locale);
            p31.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(g(i));
        }
        return treeMap;
    }

    public final String g(int i) {
        return this.a[(i * 2) + 1];
    }

    public final List h(String str) {
        p31.f(str, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (i.v(str, b(i), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(g(i));
            }
        }
        if (arrayList == null) {
            return j.j();
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        p31.e(listUnmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return listUnmodifiableList;
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = d63.a(b(i), g(i));
        }
        return t9.a(pairArr);
    }

    public final int size() {
        return this.a.length / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String strB = b(i);
            String strG = g(i);
            sb.append(strB);
            sb.append(": ");
            if (pa3.G(strB)) {
                strG = "██";
            }
            sb.append(strG);
            sb.append("\n");
        }
        String string = sb.toString();
        p31.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private iw0(String[] strArr) {
        this.a = strArr;
    }
}
