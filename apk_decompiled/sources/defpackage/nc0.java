package defpackage;

import android.content.Context;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes3.dex */
public abstract class nc0 {
    public static float a(float f, Context context) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static float b(float f, Context context) {
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }
}
