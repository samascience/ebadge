package defpackage;

import android.os.Build;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class bv implements v92 {
    private static final Set a = new HashSet(Arrays.asList("samsungexynos7570", "samsungexynos7870", "qcom"));
    private static final Set b = new HashSet(Arrays.asList("sm4350", "sm6375", "sm7325"));
    private static final Set c = new HashSet(Arrays.asList("m2007j20cg", "m2007j20ct"));

    private static boolean f() {
        return c.contains(Build.MODEL.toLowerCase());
    }

    private static boolean g() {
        return "SAMSUNG".equalsIgnoreCase(Build.BRAND) && a.contains(Build.HARDWARE.toLowerCase());
    }

    static boolean h() {
        return i() || g() || f();
    }

    private static boolean i() {
        return Build.VERSION.SDK_INT >= 31 && b.contains(Build.SOC_MODEL.toLowerCase());
    }
}
