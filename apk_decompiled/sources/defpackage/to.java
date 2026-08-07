package defpackage;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class to {
    public static final to a = new to();
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;

    private static final class a {
        public static final a a = new a();

        private a() {
        }

        public final int a(int i) {
            return SdkExtensions.getExtensionVersion(i);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        b = i >= 30 ? a.a.a(30) : 0;
        c = i >= 30 ? a.a.a(31) : 0;
        d = i >= 30 ? a.a.a(33) : 0;
        e = i >= 30 ? a.a.a(1000000) : 0;
    }

    private to() {
    }

    public static final boolean a(String str, String str2) {
        p31.f(str, "codename");
        p31.f(str2, "buildCodename");
        if (p31.a("REL", str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = str2.toUpperCase(locale);
        p31.e(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = str.toUpperCase(locale);
        p31.e(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase.compareTo(upperCase2) >= 0;
    }

    public static final boolean b() {
        int i = Build.VERSION.SDK_INT;
        if (i < 31) {
            if (i >= 30) {
                String str = Build.VERSION.CODENAME;
                p31.e(str, "CODENAME");
                if (a("S", str)) {
                }
            }
            return false;
        }
        return true;
    }

    public static final boolean c() {
        int i = Build.VERSION.SDK_INT;
        if (i < 35) {
            if (i >= 34) {
                String str = Build.VERSION.CODENAME;
                p31.e(str, "CODENAME");
                if (a("VanillaIceCream", str)) {
                }
            }
            return false;
        }
        return true;
    }
}
