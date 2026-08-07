package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class sc3 implements v92 {
    static boolean f() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && Build.VERSION.SDK_INT < 29;
    }
}
