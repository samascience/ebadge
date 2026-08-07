package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public abstract class ze0 {
    private static ContextWrapper a;
    private static SharedPreferences b;

    public static void a(Context context, String str) {
        if (a == null) {
            a = new ContextWrapper(context);
        }
        if (b == null) {
            b = a.getSharedPreferences(str, 0);
        }
    }
}
