package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class di1 implements v92 {
    public static boolean f() {
        return "itel".equalsIgnoreCase(Build.BRAND) && "itel w6004".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean g() {
        return "positivo".equalsIgnoreCase(Build.BRAND) && "twist 2 pro".equalsIgnoreCase(Build.MODEL);
    }

    static boolean h() {
        return g() || f();
    }
}
