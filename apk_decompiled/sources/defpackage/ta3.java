package defpackage;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public abstract class ta3 {
    private static DisplayMetrics a = null;
    private static int b = 50;
    private static int c = 8000;
    public static final double d = Double.longBitsToDouble(1);
    public static final float e = Float.intBitsToFloat(1);
    private static Rect f = new Rect();
    private static Paint.FontMetrics g = new Paint.FontMetrics();
    private static Rect h = new Rect();
    private static final int[] i = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    private static wy0 j = d();
    private static Rect k = new Rect();
    private static Rect l = new Rect();
    private static Paint.FontMetrics m = new Paint.FontMetrics();

    public static int a(Paint paint, String str) {
        Rect rect = f;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static int b(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static float c(float f2) {
        DisplayMetrics displayMetrics = a;
        if (displayMetrics != null) {
            return f2 * displayMetrics.density;
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
        return f2;
    }

    private static wy0 d() {
        return new y80(1);
    }

    public static int e() {
        return c;
    }

    public static int f() {
        return b;
    }

    public static float g(float f2) {
        while (f2 < 0.0f) {
            f2 += 360.0f;
        }
        return f2 % 360.0f;
    }

    public static void h(Context context) {
        if (context == null) {
            b = ViewConfiguration.getMinimumFlingVelocity();
            c = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            b = viewConfiguration.getScaledMinimumFlingVelocity();
            c = viewConfiguration.getScaledMaximumFlingVelocity();
            a = context.getResources().getDisplayMetrics();
        }
    }

    public static void i(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void j(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, c);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (i2 != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }
}
