package defpackage;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public abstract class xf {
    private static View a(Activity activity, int i, boolean z) {
        return b(activity.getWindow(), i, z);
    }

    private static View b(Window window, int i, boolean z) {
        ViewGroup viewGroup = z ? (ViewGroup) window.getDecorView() : (ViewGroup) window.findViewById(R.id.content);
        View viewFindViewWithTag = viewGroup.findViewWithTag("TAG_STATUS_BAR");
        if (viewFindViewWithTag == null) {
            View viewC = c(window.getContext(), i);
            viewGroup.addView(viewC);
            return viewC;
        }
        if (viewFindViewWithTag.getVisibility() == 8) {
            viewFindViewWithTag.setVisibility(0);
        }
        viewFindViewWithTag.setBackgroundColor(i);
        return viewFindViewWithTag;
    }

    private static View c(Context context, int i) {
        View view = new View(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, e()));
        view.setBackgroundColor(i);
        view.setTag("TAG_STATUS_BAR");
        return view;
    }

    public static int d() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int e() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static View f(Activity activity, int i) {
        return g(activity, i, false);
    }

    public static View g(Activity activity, int i, boolean z) {
        h(activity);
        return a(activity, i, z);
    }

    public static void h(Activity activity) {
        i(activity.getWindow());
    }

    public static void i(Window window) {
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
        window.setStatusBarColor(0);
    }
}
