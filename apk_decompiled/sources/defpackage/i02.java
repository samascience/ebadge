package defpackage;

import android.os.Build;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class i02 {
    private static Map a;
    private static i02 b;
    static final String[] c = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};

    public static i02 a() {
        if (b == null) {
            b = new i02();
        }
        a = new HashMap();
        return b;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public String b() {
        return Build.VERSION.SDK_INT >= 33 ? "android.permission.READ_MEDIA_IMAGES" : "android.permission.READ_EXTERNAL_STORAGE";
    }
}
