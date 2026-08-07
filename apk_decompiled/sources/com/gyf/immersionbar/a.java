package com.gyf.immersionbar;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
class a {
    private final int a;
    private final int b;
    private final boolean c;
    private final int d;
    private final int e;
    private final boolean f;
    private final float g;

    a(Activity activity) {
        this.f = activity.getResources().getConfiguration().orientation == 1;
        this.g = i(activity);
        this.a = c(activity, "status_bar_height");
        this.b = b(activity);
        int iE = e(activity);
        this.d = iE;
        this.e = h(activity);
        this.c = iE > 0;
    }

    private int b(Activity activity) {
        View viewFindViewById = activity.getWindow().findViewById(R$id.action_bar_container);
        int measuredHeight = viewFindViewById != null ? viewFindViewById.getMeasuredHeight() : 0;
        if (measuredHeight != 0) {
            return measuredHeight;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
        return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
    }

    static int c(Context context, String str) {
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize && (Build.VERSION.SDK_INT < 29 || str.equals("status_bar_height"))) {
                    return dimensionPixelSize2;
                }
                float f = (dimensionPixelSize * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                return (int) (f >= 0.0f ? f + 0.5f : f - 0.5f);
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    private int e(Context context) {
        if (k((Activity) context)) {
            return f(context);
        }
        return 0;
    }

    static int f(Context context) {
        return c(context, context.getResources().getConfiguration().orientation == 1 ? "navigation_bar_height" : "navigation_bar_height_landscape");
    }

    private int h(Context context) {
        if (k((Activity) context)) {
            return c(context, "navigation_bar_width");
        }
        return 0;
    }

    private float i(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        float f = displayMetrics.widthPixels;
        float f2 = displayMetrics.density;
        return Math.min(f / f2, displayMetrics.heightPixels / f2);
    }

    private boolean k(Activity activity) {
        g.a aVarA = g.a(activity);
        if (!aVarA.b && aVarA.a) {
            return false;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i2 - displayMetrics2.widthPixels > 0 || i - displayMetrics2.heightPixels > 0;
    }

    int a() {
        return this.b;
    }

    int d() {
        return this.d;
    }

    int g() {
        return this.e;
    }

    int j() {
        return this.a;
    }

    boolean l() {
        return this.c;
    }

    boolean m() {
        return this.g >= 600.0f || this.f;
    }
}
