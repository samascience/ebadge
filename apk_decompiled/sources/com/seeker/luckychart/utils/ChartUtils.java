package com.seeker.luckychart.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public final class ChartUtils {
    public static final float CONTAIN_OFFSET = 5.0f;
    public static final char[] VALUEWIDTHCHARS = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};

    public static float applyDimension(int i, float f) {
        return TypedValue.applyDimension(i, f, Resources.getSystem().getDisplayMetrics());
    }

    public static boolean copyof(char[] cArr, char[] cArr2) {
        System.arraycopy(cArr, 0, cArr2, 0, Math.min(cArr.length, cArr2.length));
        return true;
    }

    public static int dp2px(float f, float f2) {
        if (f2 == 0.0f) {
            return 0;
        }
        return (int) ((f2 * f) + 0.5f);
    }

    public static Bitmap drawBitmapText(char[] cArr, int i, int i2, float f, float f2, float f3, Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        RectF rectF = new RectF(0.0f, 0.0f, paint.measureText(cArr, i, i2), (float) Math.floor(fontMetrics.descent - fontMetrics.ascent));
        int i3 = (int) ((((rectF.bottom + rectF.top) - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) rectF.width(), (int) rectF.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.save();
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 7));
        canvas.rotate(f, f2, f3);
        canvas.drawColor(0);
        canvas.drawText(cArr, i, i2, 0.0f, i3, paint);
        canvas.restore();
        return bitmapCreateBitmap;
    }

    public static int getTextHeight(Paint paint, String str) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length() - 1, rect);
        return rect.height();
    }

    public static float measureText(char[] cArr, Paint paint) {
        return paint.measureText(cArr, 0, cArr.length);
    }

    public static int sp2px(float f, float f2) {
        if (f2 == 0.0f) {
            return 0;
        }
        return (int) ((f2 * f) + 0.5f);
    }

    public static Bitmap drawBitmapText(char[] cArr, int i, int i2, Paint paint) {
        return drawBitmapText(cArr, i, i2, 0.0f, 0.0f, 0.0f, paint);
    }
}
