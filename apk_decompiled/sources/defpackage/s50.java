package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public abstract class s50 {
    public static int a(String str) {
        return Log.d("greenDAO", str);
    }

    public static int b(String str, Throwable th) {
        return Log.e("greenDAO", str, th);
    }

    public static int c(String str) {
        return Log.w("greenDAO", str);
    }

    public static int d(String str, Throwable th) {
        return Log.w("greenDAO", str, th);
    }
}
