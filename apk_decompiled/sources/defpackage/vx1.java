package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class vx1 {
    public static String a = "Telink-OTA";
    public static boolean b = true;

    public static int a(String str) {
        if (b) {
            return Log.d(a, str);
        }
        return 0;
    }

    public static int b(String str) {
        if (b) {
            return Log.i(a, str);
        }
        return 0;
    }

    public static int c(String str) {
        if (b) {
            return Log.w(a, str);
        }
        return 0;
    }
}
