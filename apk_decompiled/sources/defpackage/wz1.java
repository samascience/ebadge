package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes3.dex */
public abstract class wz1 {
    public static boolean a(Context context, String str) {
        return q30.a(context.getApplicationContext(), str) == 0;
    }

    private static boolean b(Context context, Intent intent) {
        return context.getApplicationContext().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static void c(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + applicationContext.getPackageName()));
        if (b(context, intent)) {
            applicationContext.startActivity(intent.addFlags(268435456));
        }
    }

    public static void d(Activity activity, String[] strArr, int i) {
        g3.s(activity, strArr, i);
    }
}
