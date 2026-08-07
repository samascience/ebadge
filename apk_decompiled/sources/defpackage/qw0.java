package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.DisplayMetrics;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes4.dex */
public abstract class qw0 {
    public static ViewGroup a(Activity activity) {
        if (activity == null) {
            return null;
        }
        return (ViewGroup) activity.getWindow().getDecorView();
    }

    public static int b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        f(context).getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int c(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int d(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static void e(Activity activity, ViewGroup viewGroup) {
        viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() | 4098);
        activity.getWindow().setFlags(1024, 1024);
    }

    public static Activity f(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return f(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static ViewGroup g(Context context, boolean z) {
        Activity activityF = f(context);
        ViewGroup viewGroupA = a(activityF);
        if (viewGroupA == null) {
            return null;
        }
        if (z) {
            e(activityF, viewGroupA);
            activityF.setRequestedOrientation(0);
        } else {
            h(activityF, viewGroupA);
            activityF.setRequestedOrientation(1);
        }
        return viewGroupA;
    }

    public static void h(Activity activity, ViewGroup viewGroup) {
        viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() & (-4099));
        activity.getWindow().clearFlags(1024);
    }
}
