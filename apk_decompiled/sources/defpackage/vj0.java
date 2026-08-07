package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class vj0 implements v92 {
    private static boolean f() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL);
    }

    static boolean g() {
        return f();
    }
}
