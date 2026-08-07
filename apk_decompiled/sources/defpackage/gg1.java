package defpackage;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public abstract class gg1 {
    public static TypedValue a(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(Context context, int i, boolean z) {
        TypedValue typedValueA = a(context, i);
        if (typedValueA == null || typedValueA.type != 18) {
            return z;
        }
        return typedValueA.data != 0;
    }

    public static int c(Context context, int i, int i2) {
        TypedValue typedValueA = a(context, i);
        return (typedValueA == null || typedValueA.type != 16) ? i2 : typedValueA.data;
    }

    public static int d(Context context, int i, String str) {
        return e(context, i, str).data;
    }

    public static TypedValue e(Context context, int i, String str) {
        TypedValue typedValueA = a(context, i);
        if (typedValueA != null) {
            return typedValueA;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static TypedValue f(View view, int i) {
        return e(view.getContext(), i, view.getClass().getCanonicalName());
    }
}
