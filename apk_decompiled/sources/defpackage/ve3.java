package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.x;
import androidx.camera.core.internal.utils.ImageUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ve3 {
    public static Map a(Rect rect, boolean z, Rational rational, int i, int i2, int i3, Map map) {
        b52.b(rect.width() > 0 && rect.height() > 0, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        HashMap map2 = new HashMap();
        RectF rectF2 = new RectF(rect);
        for (Map.Entry entry : map.entrySet()) {
            Matrix matrix = new Matrix();
            RectF rectF3 = new RectF(0.0f, 0.0f, ((x) entry.getValue()).e().getWidth(), ((x) entry.getValue()).e().getHeight());
            matrix.setRectToRect(rectF3, rectF, Matrix.ScaleToFit.CENTER);
            map2.put((UseCase) entry.getKey(), matrix);
            RectF rectF4 = new RectF();
            matrix.mapRect(rectF4, rectF3);
            rectF2.intersect(rectF4);
        }
        RectF rectFG = g(rectF2, ImageUtil.f(i, rational), i2, z, i3, i);
        HashMap map3 = new HashMap();
        RectF rectF5 = new RectF();
        Matrix matrix2 = new Matrix();
        for (Map.Entry entry2 : map2.entrySet()) {
            ((Matrix) entry2.getValue()).invert(matrix2);
            matrix2.mapRect(rectF5, rectFG);
            Rect rect2 = new Rect();
            rectF5.round(rect2);
            map3.put((UseCase) entry2.getKey(), rect2);
        }
        return map3;
    }

    private static RectF b(boolean z, int i, RectF rectF, RectF rectF2) {
        boolean z2 = false;
        boolean z3 = i == 0 && !z;
        boolean z4 = i == 90 && z;
        if (z3 || z4) {
            return rectF2;
        }
        boolean z5 = i == 0 && z;
        boolean z6 = i == 270 && !z;
        if (z5 || z6) {
            return c(rectF2, rectF.centerX());
        }
        boolean z7 = i == 90 && !z;
        boolean z8 = i == 180 && z;
        if (z7 || z8) {
            return d(rectF2, rectF.centerY());
        }
        boolean z9 = i == 180 && !z;
        if (i == 270 && z) {
            z2 = true;
        }
        if (z9 || z2) {
            return c(d(rectF2, rectF.centerY()), rectF.centerX());
        }
        throw new IllegalArgumentException("Invalid argument: mirrored " + z + " rotation " + i);
    }

    private static RectF c(RectF rectF, float f) {
        return new RectF(e(rectF.right, f), rectF.top, e(rectF.left, f), rectF.bottom);
    }

    private static RectF d(RectF rectF, float f) {
        return new RectF(rectF.left, f(rectF.bottom, f), rectF.right, f(rectF.top, f));
    }

    private static float e(float f, float f2) {
        return (f2 + f2) - f;
    }

    private static float f(float f, float f2) {
        return (f2 + f2) - f;
    }

    public static RectF g(RectF rectF, Rational rational, int i, boolean z, int i2, int i3) {
        if (i == 3) {
            return rectF;
        }
        Matrix matrix = new Matrix();
        RectF rectF2 = new RectF(0.0f, 0.0f, rational.getNumerator(), rational.getDenominator());
        if (i == 0) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.START);
        } else if (i == 1) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.CENTER);
        } else {
            if (i != 2) {
                throw new IllegalStateException("Unexpected scale type: " + i);
            }
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.END);
        }
        RectF rectF3 = new RectF();
        matrix.mapRect(rectF3, rectF2);
        return b(h(z, i2), i3, rectF, rectF3);
    }

    private static boolean h(boolean z, int i) {
        return z ^ (i == 1);
    }
}
