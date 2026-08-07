package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class zy implements v92 {
    private static boolean f() {
        return "Nokia".equalsIgnoreCase(Build.BRAND) && "Nokia 1".equalsIgnoreCase(Build.MODEL);
    }

    static boolean h() {
        return f();
    }

    public boolean g(String str) {
        return "video/mp4v-es".equals(str);
    }
}
