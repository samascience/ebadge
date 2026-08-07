package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class af2 implements v92 {
    public static boolean f() {
        return "Huawei".equalsIgnoreCase(Build.BRAND) && "mha-l29".equalsIgnoreCase(Build.MODEL);
    }

    static boolean g() {
        return f();
    }
}
