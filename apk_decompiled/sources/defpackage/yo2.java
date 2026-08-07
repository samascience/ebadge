package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class yo2 implements v92 {
    private static boolean f() {
        return "Nokia".equalsIgnoreCase(Build.BRAND) && "Nokia 1".equalsIgnoreCase(Build.MODEL);
    }

    static boolean g() {
        return f();
    }
}
