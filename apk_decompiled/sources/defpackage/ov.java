package defpackage;

import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ov {
    public static int[] a(Paint paint, String str) {
        int[] iArr = {0, 0};
        if (pv2.f(str)) {
            return iArr;
        }
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        iArr[0] = rect.right - rect.left;
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        iArr[1] = fontMetricsInt.bottom - fontMetricsInt.top;
        return iArr;
    }
}
