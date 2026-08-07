package defpackage;

import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class r31 implements v92 {
    private static final List a = Arrays.asList("pixel 4", "pixel 4a", "pixel 4a (5g)", "pixel 4 xl", "pixel 5", "pixel 5a", "pixel 6", "pixel 6a", "pixel 6 pro", "pixel 7", "pixel 7 pro");
    private static final List b = Arrays.asList("cph2417", "cph2451");
    private static final List c = Arrays.asList("cph2437", "cph2525", "pht110");

    private static boolean f() {
        return Build.VERSION.SDK_INT == 33;
    }

    private static boolean g() {
        return h() && f();
    }

    private static boolean h() {
        return b.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean i() {
        return j() && f();
    }

    private static boolean j() {
        return c.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean k() {
        return r() || p();
    }

    private static boolean l() {
        return m() && k();
    }

    private static boolean m() {
        return a.contains(Build.MODEL.toLowerCase(Locale.ROOT));
    }

    private static boolean n() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && r();
    }

    private static boolean o() {
        String str = Build.BRAND;
        return ("redmi".equalsIgnoreCase(str) || "xiaomi".equalsIgnoreCase(str)) && (q() || r());
    }

    private static boolean p() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("td1a");
    }

    private static boolean q() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("tkq1");
    }

    private static boolean r() {
        return Build.ID.toLowerCase(Locale.ROOT).startsWith("tp1a");
    }

    static boolean s() {
        return n() || l() || o() || g() || i();
    }
}
