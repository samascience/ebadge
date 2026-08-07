package defpackage;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class ax {
    private final String a;
    private final Map b;

    public ax(String str, Map map) {
        String lowerCase;
        p31.f(str, "scheme");
        p31.f(map, "authParams");
        this.a = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if (str2 != null) {
                Locale locale = Locale.US;
                p31.e(locale, "US");
                lowerCase = str2.toLowerCase(locale);
                p31.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            linkedHashMap.put(lowerCase, str3);
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        p31.e(mapUnmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.b = mapUnmodifiableMap;
    }

    public final Charset a() {
        String str = (String) this.b.get("charset");
        if (str != null) {
            try {
                Charset charsetForName = Charset.forName(str);
                p31.e(charsetForName, "forName(charset)");
                return charsetForName;
            } catch (Exception unused) {
            }
        }
        Charset charset = StandardCharsets.ISO_8859_1;
        p31.e(charset, "ISO_8859_1");
        return charset;
    }

    public final String b() {
        return (String) this.b.get("realm");
    }

    public final String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ax) {
            ax axVar = (ax) obj;
            if (p31.a(axVar.a, this.a) && p31.a(axVar.b, this.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.a.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return this.a + " authParams=" + this.b;
    }
}
