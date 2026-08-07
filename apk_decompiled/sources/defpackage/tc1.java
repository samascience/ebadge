package defpackage;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class tc1 {
    private static final tc1 b = a(new Locale[0]);
    private final uc1 a;

    static class a {
        private static final Locale[] a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    static class b {
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }
    }

    private tc1(uc1 uc1Var) {
        this.a = uc1Var;
    }

    public static tc1 a(Locale... localeArr) {
        return h(b.a(localeArr));
    }

    public static tc1 b(String str) {
        if (str == null || str.isEmpty()) {
            return d();
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            localeArr[i] = a.a(strArrSplit[i]);
        }
        return a(localeArr);
    }

    public static tc1 d() {
        return b;
    }

    public static tc1 h(LocaleList localeList) {
        return new tc1(new vc1(localeList));
    }

    public Locale c(int i) {
        return this.a.get(i);
    }

    public boolean e() {
        return this.a.isEmpty();
    }

    public boolean equals(Object obj) {
        return (obj instanceof tc1) && this.a.equals(((tc1) obj).a);
    }

    public int f() {
        return this.a.size();
    }

    public String g() {
        return this.a.a();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
