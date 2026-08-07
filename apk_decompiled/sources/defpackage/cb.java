package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes3.dex */
public abstract class cb {
    public static boolean a(Context context, int i) {
        boolean z = false;
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i});
            z = typedArrayObtainStyledAttributes.getBoolean(0, false);
            typedArrayObtainStyledAttributes.recycle();
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    public static int b(Context context, int i) {
        int color = 0;
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i});
            color = typedArrayObtainStyledAttributes.getColor(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            return color;
        } catch (Exception e) {
            e.printStackTrace();
            return color;
        }
    }

    public static ColorStateList c(Context context, int i) {
        ColorStateList colorStateList = null;
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i});
            colorStateList = typedArrayObtainStyledAttributes.getColorStateList(0);
            typedArrayObtainStyledAttributes.recycle();
            return colorStateList;
        } catch (Exception e) {
            e.printStackTrace();
            return colorStateList;
        }
    }

    public static Drawable d(Context context, int i, int i2) {
        Drawable drawable = null;
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i});
            drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return drawable == null ? q30.e(context, i2) : drawable;
    }

    public static float e(Context context, int i) {
        float dimensionPixelSize = 0.0f;
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i});
            dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            return dimensionPixelSize;
        } catch (Exception e) {
            e.printStackTrace();
            return dimensionPixelSize;
        }
    }

    public static int f(Context context, int i) {
        int dimensionPixelSize = 0;
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().resourceId, new int[]{i});
            dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            return dimensionPixelSize;
        } catch (Exception e) {
            e.printStackTrace();
            return dimensionPixelSize;
        }
    }
}
