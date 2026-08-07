package defpackage;

import android.app.Activity;
import android.content.Context;
import com.legend.mywatch.commonlib.R$string;

/* JADX INFO: loaded from: classes3.dex */
public abstract class pb0 {
    private static kc1 a;

    public static void a() {
        if (b()) {
            a.dismiss();
            a = null;
        }
    }

    public static boolean b() {
        kc1 kc1Var = a;
        return kc1Var != null && kc1Var.isShowing();
    }

    public static void c(Context context, String str) {
        if (context != null) {
            d(context, str, 30000, false);
        }
    }

    public static void d(Context context, String str, int i, boolean z) {
        if (!(context instanceof Activity) || ((Activity) context).isDestroyed()) {
            return;
        }
        a();
        kc1 kc1VarB = new kc1.a(context).e(str).d(z).b(true, i);
        a = kc1VarB;
        kc1VarB.show();
    }

    public static void e(Context context, String str, boolean z) {
        if (context != null) {
            d(context, str, 8000, z);
        }
    }

    public static void f(Context context) {
        if (context != null) {
            d(context, context.getString(R$string.loadding_data), 30000, false);
        }
    }
}
