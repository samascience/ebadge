package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes4.dex */
public abstract class xa3 {
    public static int a(float f, float f2) {
        int iRound = Math.round(f * 100000.0f);
        int iRound2 = Math.round(f2 * 100000.0f);
        if (iRound > iRound2) {
            return 1;
        }
        return iRound < iRound2 ? -1 : 0;
    }

    public static int b(Context context, float f) {
        if (context == null || a(0.0f, f) == 0) {
            return 0;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void c(Canvas canvas, Bitmap bitmap, Rect rect) {
        new NinePatch(bitmap, bitmap.getNinePatchChunk(), null).draw(canvas, rect);
    }
}
