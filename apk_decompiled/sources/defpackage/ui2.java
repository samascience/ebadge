package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ui2 extends Dialog {
    protected Context a;
    protected WindowManager.LayoutParams b;

    public ui2(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        requestWindowFeature(1);
        getWindow().setBackgroundDrawableResource(R.drawable.transparent_bg);
        this.a = context;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        this.b = attributes;
        attributes.alpha = 1.0f;
        window.setAttributes(attributes);
        WindowManager.LayoutParams layoutParams = this.b;
        if (layoutParams != null) {
            layoutParams.height = -1;
            layoutParams.gravity = 17;
        }
    }
}
