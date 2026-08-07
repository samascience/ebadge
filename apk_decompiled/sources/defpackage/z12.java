package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import com.luck.picture.lib.R$layout;
import com.luck.picture.lib.R$style;

/* JADX INFO: loaded from: classes3.dex */
public class z12 extends Dialog {
    public z12(Context context) {
        super(context, R$style.Picture_Theme_AlertDialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.PictureThemeDialogWindowStyle);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.picture_alert_dialog);
    }
}
