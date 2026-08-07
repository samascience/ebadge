package defpackage;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zh2 {
    public static final boolean a = true;
    private static final int[] b = {R.attr.state_pressed};
    private static final int[] c = {R.attr.state_hovered, R.attr.state_focused};
    private static final int[] d = {R.attr.state_focused};
    private static final int[] e = {R.attr.state_hovered};
    private static final int[] f = {R.attr.state_selected, R.attr.state_pressed};
    private static final int[] g = {R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
    private static final int[] h = {R.attr.state_selected, R.attr.state_focused};
    private static final int[] i = {R.attr.state_selected, R.attr.state_hovered};
    private static final int[] j = {R.attr.state_selected};
    private static final int[] k = {R.attr.state_enabled, R.attr.state_pressed};
    static final String l = zh2.class.getSimpleName();

    public static ColorStateList a(ColorStateList colorStateList) {
        if (a) {
            int[] iArr = d;
            return new ColorStateList(new int[][]{j, iArr, StateSet.NOTHING}, new int[]{c(colorStateList, f), c(colorStateList, iArr), c(colorStateList, b)});
        }
        int[] iArr2 = f;
        int[] iArr3 = g;
        int[] iArr4 = h;
        int[] iArr5 = i;
        int[] iArr6 = b;
        int[] iArr7 = c;
        int[] iArr8 = d;
        int[] iArr9 = e;
        return new ColorStateList(new int[][]{iArr2, iArr3, iArr4, iArr5, j, iArr6, iArr7, iArr8, iArr9, StateSet.NOTHING}, new int[]{c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), c(colorStateList, iArr5), 0, c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), c(colorStateList, iArr9), 0});
    }

    private static int b(int i2) {
        return pz.k(i2, Math.min(Color.alpha(i2) * 2, 255));
    }

    private static int c(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return a ? b(colorForState) : colorForState;
    }

    public static ColorStateList d(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(k, 0)) != 0) {
            Log.w(l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean e(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
