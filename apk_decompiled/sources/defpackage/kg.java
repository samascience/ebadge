package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public abstract class kg extends Dialog {
    public Context a;

    public kg(Context context, int i) {
        super(context, i);
        this.a = context;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            Context context = this.a;
            if (context instanceof Activity) {
                if (!((Activity) context).isFinishing()) {
                    super.dismiss();
                }
            } else if (isShowing()) {
                super.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            Activity ownerActivity = getOwnerActivity();
            Context context = this.a;
            if (context instanceof Activity) {
                ownerActivity = (Activity) context;
            }
            if (ownerActivity == null) {
                super.show();
            } else {
                if (ownerActivity.isFinishing() || ownerActivity.getWindow() == null) {
                    return;
                }
                super.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
