package com.skydoves.colorpickerview;

import android.graphics.Point;

/* JADX INFO: loaded from: classes.dex */
abstract class a {
    private static Point a(ColorPickerView colorPickerView, Point point, Point point2) {
        if (d(point, point2) <= 3) {
            return point2;
        }
        Point pointB = b(point, point2);
        return colorPickerView.i((float) pointB.x, (float) pointB.y) == 0 ? a(colorPickerView, pointB, point2) : a(colorPickerView, point, pointB);
    }

    private static Point b(Point point, Point point2) {
        return new Point((point2.x + point.x) / 2, (point2.y + point.y) / 2);
    }

    protected static Point c(ColorPickerView colorPickerView, Point point) {
        return colorPickerView.j() ? e(colorPickerView, point) : a(colorPickerView, point, new Point(colorPickerView.getMeasuredWidth() / 2, colorPickerView.getMeasuredHeight() / 2));
    }

    private static int d(Point point, Point point2) {
        return (int) Math.sqrt((Math.abs(point2.x - point.x) * Math.abs(point2.x - point.x)) + (Math.abs(point2.y - point.y) * Math.abs(point2.y - point.y)));
    }

    private static Point e(ColorPickerView colorPickerView, Point point) {
        float width = colorPickerView.getWidth() * 0.5f;
        float height = colorPickerView.getHeight() * 0.5f;
        float f = point.x - width;
        float f2 = point.y - height;
        float fMin = Math.min(width, height);
        double dSqrt = Math.sqrt((f * f) + (f2 * f2));
        double d = fMin;
        if (dSqrt > d) {
            double d2 = d / dSqrt;
            f = (float) (((double) f) * d2);
            f2 = (float) (((double) f2) * d2);
        }
        return new Point((int) (f + width), (int) (f2 + height));
    }
}
