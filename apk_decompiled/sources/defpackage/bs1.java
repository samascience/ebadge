package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public abstract class bs1 {
    public static boolean a(Context context) {
        return as1.d(context.getApplicationContext()).a();
    }

    public static void b(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
        intent.putExtra("android.provider.extra.CHANNEL_ID", activity.getApplicationInfo().uid);
        activity.startActivity(intent);
    }
}
