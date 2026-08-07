package defpackage;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.b;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ob0 {
    public static void a(b bVar) {
        Window window = bVar.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = (int) (((double) ml2.c()) * 0.95d);
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public static void b() {
        if (c()) {
            d20.c.dismiss();
            d20.c = null;
        }
    }

    public static boolean c() {
        lc1 lc1Var = d20.c;
        return lc1Var != null && lc1Var.isShowing();
    }

    public static void d(Context context, int i) {
        if (context != null) {
            g(context, context.getString(i), 30000, false);
        }
    }

    public static void e(Context context, int i, int i2, boolean z) {
        if (context != null) {
            g(context, context.getString(i), i2, z);
        }
    }

    public static void f(Context context, String str) {
        if (context != null) {
            g(context, str, 30000, false);
        }
    }

    public static void g(Context context, String str, int i, boolean z) {
        if (!(context instanceof Activity) || ((Activity) context).isDestroyed()) {
            return;
        }
        b();
        lc1 lc1VarB = new lc1.a(context).e(str).d(z).b(true, i);
        d20.c = lc1VarB;
        lc1VarB.show();
    }
}
