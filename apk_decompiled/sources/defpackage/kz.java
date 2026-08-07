package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import com.skydoves.colorpickerview.ColorPickerView;

/* JADX INFO: loaded from: classes.dex */
public class kz {
    private static kz b;
    private SharedPreferences a;

    private kz(Context context) {
        this.a = context.getSharedPreferences(context.getPackageName(), 0);
    }

    public static kz g(Context context) {
        if (b == null) {
            b = new kz(context);
        }
        return b;
    }

    protected String a(String str) {
        return str + "_SLIDER_ALPHA";
    }

    public int b(String str, int i) {
        return this.a.getInt(a(str), i);
    }

    protected String c(String str) {
        return str + "_SLIDER_BRIGHTNESS";
    }

    public int d(String str, int i) {
        return this.a.getInt(c(str), i);
    }

    public int e(String str, int i) {
        return this.a.getInt(f(str), i);
    }

    protected String f(String str) {
        return str + "_COLOR";
    }

    public Point h(String str, Point point) {
        return new Point(this.a.getInt(i(str), point.x), this.a.getInt(j(str), point.y));
    }

    protected String i(String str) {
        return str + "_SELECTOR_X";
    }

    protected String j(String str) {
        return str + "_SELECTOR_Y";
    }

    public void k(ColorPickerView colorPickerView) {
        if (colorPickerView == null || colorPickerView.getPreferenceName() == null) {
            return;
        }
        String preferenceName = colorPickerView.getPreferenceName();
        colorPickerView.setPureColor(e(preferenceName, -1));
        Point point = new Point(colorPickerView.getMeasuredWidth() / 2, colorPickerView.getMeasuredHeight() / 2);
        colorPickerView.k(h(preferenceName, point).x, h(preferenceName, point).y, e(preferenceName, -1));
    }

    public void l(ColorPickerView colorPickerView) {
        if (colorPickerView == null || colorPickerView.getPreferenceName() == null) {
            return;
        }
        String preferenceName = colorPickerView.getPreferenceName();
        o(preferenceName, colorPickerView.getColor());
        p(preferenceName, colorPickerView.getSelectedPoint());
        if (colorPickerView.getAlphaSlideBar() != null) {
            m(preferenceName, colorPickerView.getAlphaSlideBar().getSelectedX());
        }
        if (colorPickerView.getBrightnessSlider() != null) {
            n(preferenceName, colorPickerView.getBrightnessSlider().getSelectedX());
        }
    }

    public kz m(String str, int i) {
        this.a.edit().putInt(a(str), i).apply();
        return b;
    }

    public kz n(String str, int i) {
        this.a.edit().putInt(c(str), i).apply();
        return b;
    }

    public kz o(String str, int i) {
        this.a.edit().putInt(f(str), i).apply();
        return b;
    }

    public kz p(String str, Point point) {
        this.a.edit().putInt(i(str), point.x).apply();
        this.a.edit().putInt(j(str), point.y).apply();
        return b;
    }
}
