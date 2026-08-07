package defpackage;

import android.os.Build;
import android.util.Pair;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class rn0 implements v92 {
    private static final Set a = new HashSet();

    static {
        f("sprd", "lemp");
        f("sprd", "DM20C");
    }

    private static void f(String str, String str2) {
        Set set = a;
        Locale locale = Locale.US;
        set.add(new Pair(str.toLowerCase(locale), str2.toLowerCase(locale)));
    }

    static boolean g() {
        Set set = a;
        String str = Build.MANUFACTURER;
        Locale locale = Locale.US;
        return set.contains(new Pair(str.toLowerCase(locale), Build.MODEL.toLowerCase(locale)));
    }
}
