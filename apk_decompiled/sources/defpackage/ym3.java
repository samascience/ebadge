package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
abstract class ym3 {
    public static boolean a = false;
    private static String b = "BaiduApiAuth";

    public static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return stackTraceElement.getFileName() + "[" + stackTraceElement.getLineNumber() + "]";
    }

    public static void b(String str) {
        if (!a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.d(b, a() + ";" + str);
    }

    public static void c(String str) {
        if (Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.i(b, str);
    }

    public static void d(String str) {
        if (!a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.e(b, a() + ";" + str);
    }
}
