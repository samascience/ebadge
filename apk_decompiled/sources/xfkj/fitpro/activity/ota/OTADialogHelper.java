package xfkj.fitpro.activity.ota;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class OTADialogHelper {
    private static LoadingDailog dialog;

    public static void hideDialog() {
        if (isShown()) {
            dialog.dismiss();
            dialog = null;
        }
    }

    public static boolean isShown() {
        LoadingDailog loadingDailog = dialog;
        return loadingDailog != null && loadingDailog.isShowing();
    }

    public static void showDialog(Context context, int i, int i2, boolean z) {
        if (context != null) {
            showDialog(context, context.getString(i), i2, z);
        }
    }

    public static void showLoadDialog(Context context) {
        if (context != null) {
            showDialog(context, context.getString(R.string.loadding_data), 30000, false);
        }
    }

    public static void showDialog(Context context, int i, boolean z) {
        if (context != null) {
            showDialog(context, context.getString(i), 8000, z);
        }
    }

    public static void showLoadDialog(Context context, int i) {
        if (context != null) {
            showDialog(context, context.getString(R.string.loadding_data), i, false);
        }
    }

    public static void showDialog(Context context, String str, boolean z) {
        if (context != null) {
            showDialog(context, str, 8000, z);
        }
    }

    public static void showDialog(Context context, int i) {
        if (context != null) {
            showDialog(context, context.getString(i), 30000, false);
        }
    }

    public static void showDialog(Context context, String str) {
        if (context != null) {
            showDialog(context, str, 30000, false);
        }
    }

    public static void showDialog(Context context, String str, int i, boolean z) {
        if (!(context instanceof Activity) || ((Activity) context).isDestroyed()) {
            return;
        }
        hideDialog();
        LoadingDailog loadingDailogCreate = new LoadingDailog.Builder(context).setMessage(str).setCancelable(z).create(true, i);
        dialog = loadingDailogCreate;
        loadingDailogCreate.show();
    }
}
