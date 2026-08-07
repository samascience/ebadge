package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class ib implements v92 {
    private static boolean f() {
        return "Sony".equalsIgnoreCase(Build.BRAND) && "G3125".equalsIgnoreCase(Build.MODEL);
    }

    static boolean g() {
        return f();
    }
}
