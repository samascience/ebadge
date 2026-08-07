package xfkj.fitpro.activity.ota.utils;

import android.app.Activity;
import defpackage.pb0;

/* JADX INFO: loaded from: classes4.dex */
public class OTADialogHelper {
    public static void hideDialog() {
        pb0.a();
    }

    public static void showDialog(Activity activity, String str) {
        showDialog(activity, str, true);
    }

    public static void showLoadDialog(Activity activity) {
        pb0.f(activity);
    }

    public static void showDialog(Activity activity, String str, boolean z) {
        pb0.e(activity, str, z);
    }
}
