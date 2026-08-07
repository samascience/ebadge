package defpackage;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p33 {
    private static long a;

    public static boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - a < 1500) {
            return true;
        }
        a = jCurrentTimeMillis;
        return false;
    }

    public static void b(Context context, String str) {
        if (a()) {
            return;
        }
        Toast.makeText(context.getApplicationContext(), str, 0).show();
    }
}
