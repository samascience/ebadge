package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public abstract class og1 {
    public static int a(int i, int i2) {
        return pz.k(i, (Color.alpha(i) * i2) / 255);
    }

    public static int b(Context context, int i, int i2) {
        Integer numF = f(context, i);
        return numF != null ? numF.intValue() : i2;
    }

    public static int c(Context context, int i, String str) {
        return l(context, gg1.e(context, i, str));
    }

    public static int d(View view, int i) {
        return l(view.getContext(), gg1.f(view, i));
    }

    public static int e(View view, int i, int i2) {
        return b(view.getContext(), i, i2);
    }

    public static Integer f(Context context, int i) {
        TypedValue typedValueA = gg1.a(context, i);
        if (typedValueA != null) {
            return Integer.valueOf(l(context, typedValueA));
        }
        return null;
    }

    public static ColorStateList g(Context context, int i) {
        TypedValue typedValueA = gg1.a(context, i);
        if (typedValueA == null) {
            return null;
        }
        int i2 = typedValueA.resourceId;
        if (i2 != 0) {
            return q30.d(context, i2);
        }
        int i3 = typedValueA.data;
        if (i3 != 0) {
            return ColorStateList.valueOf(i3);
        }
        return null;
    }

    public static boolean h(int i) {
        return i != 0 && pz.d(i) > 0.5d;
    }

    public static int i(int i, int i2) {
        return pz.g(i2, i);
    }

    public static int j(int i, int i2, float f) {
        return i(i, pz.k(i2, Math.round(Color.alpha(i2) * f)));
    }

    public static int k(View view, int i, int i2, float f) {
        return j(d(view, i), d(view, i2), f);
    }

    private static int l(Context context, TypedValue typedValue) {
        int i = typedValue.resourceId;
        return i != 0 ? q30.c(context, i) : typedValue.data;
    }
}
