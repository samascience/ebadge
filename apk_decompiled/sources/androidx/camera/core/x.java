package androidx.camera.core;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class x {
    private static int a = 3;

    public static void a(String str, String str2) {
        String strJ = j(str);
        if (g(strJ, 3)) {
            Log.d(strJ, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        String strJ = j(str);
        if (g(strJ, 3)) {
            Log.d(strJ, str2, th);
        }
    }

    public static void c(String str, String str2) {
        String strJ = j(str);
        if (g(strJ, 6)) {
            Log.e(strJ, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        String strJ = j(str);
        if (g(strJ, 6)) {
            Log.e(strJ, str2, th);
        }
    }

    public static void e(String str, String str2) {
        String strJ = j(str);
        if (g(strJ, 4)) {
            Log.i(strJ, str2);
        }
    }

    public static boolean f(String str) {
        return g(j(str), 3);
    }

    private static boolean g(String str, int i) {
        return a <= i || Log.isLoggable(str, i);
    }

    static void h() {
        a = 3;
    }

    static void i(int i) {
        a = i;
    }

    private static String j(String str) {
        return str;
    }

    public static void k(String str, String str2) {
        String strJ = j(str);
        if (g(strJ, 5)) {
            Log.w(strJ, str2);
        }
    }

    public static void l(String str, String str2, Throwable th) {
        String strJ = j(str);
        if (g(strJ, 5)) {
            Log.w(strJ, str2, th);
        }
    }
}
