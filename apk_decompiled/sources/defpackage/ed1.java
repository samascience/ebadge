package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ed1 {
    public static boolean a = true;

    public static void a(String str, String str2) {
        if (a) {
            Log.e(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (a) {
            Log.i(str, str2);
        }
    }
}
