package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class o01 {
    public static boolean a(Context context) {
        if (context instanceof Activity) {
            return !b((Activity) context);
        }
        if (context instanceof ContextWrapper) {
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (contextWrapper.getBaseContext() instanceof Activity) {
                return !b((Activity) contextWrapper.getBaseContext());
            }
        }
        return true;
    }

    private static boolean b(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }
}
