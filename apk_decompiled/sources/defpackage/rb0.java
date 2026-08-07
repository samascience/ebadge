package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.Window;
import android.view.WindowManager;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class rb0 {
    public static AlertDialog a(Activity activity) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    AlertDialog alertDialogShow = new AlertDialog.Builder(activity, R.style.dialog_no_fullscreen_no_title).show();
                    alertDialogShow.setCanceledOnTouchOutside(false);
                    Window window = alertDialogShow.getWindow();
                    window.clearFlags(131080);
                    window.setSoftInputMode(4);
                    window.setContentView(R.layout.loading_dialog);
                    WindowManager.LayoutParams attributes = alertDialogShow.getWindow().getAttributes();
                    attributes.gravity = 17;
                    window.setAttributes(attributes);
                    return alertDialogShow;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
