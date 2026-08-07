package defpackage;

import android.os.Build;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class zl3 implements v92 {
    private static final List a = Arrays.asList("SM-F936", "SM-S901U", "SM-S908U", "SM-S908U1");
    private static final List b = Arrays.asList("MI 8");

    private static boolean f(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (Build.MODEL.toUpperCase(Locale.US).startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean g() {
        return "samsung".equalsIgnoreCase(Build.BRAND) && f(a);
    }

    private static boolean h() {
        return "xiaomi".equalsIgnoreCase(Build.BRAND) && f(b);
    }

    static boolean i() {
        return g() || h();
    }
}
