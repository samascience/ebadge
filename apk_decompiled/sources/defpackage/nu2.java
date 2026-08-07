package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class nu2 implements v92 {
    private static boolean f() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto c".equalsIgnoreCase(Build.MODEL);
    }

    static boolean g() {
        return f();
    }
}
