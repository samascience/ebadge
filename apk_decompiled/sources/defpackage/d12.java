package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.luck.picture.lib.R$style;

/* JADX INFO: loaded from: classes3.dex */
public class d12 extends Dialog {
    public d12(Context context, int i) {
        super(context, R$style.Picture_Theme_Dialog);
        setContentView(i);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -2;
            attributes.height = -2;
            attributes.gravity = 17;
            window.setAttributes(attributes);
        }
    }
}
