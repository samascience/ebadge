package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.TypedValue;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes4.dex */
public class ji2 extends ri {
    private final float b;
    private final Paint c;

    public static class a {
        private final float a;
        private final int b;

        public a(int i, float f, int i2) {
            this.a = TypedValue.applyDimension(i, f, Resources.getSystem().getDisplayMetrics());
            this.b = i2;
        }
    }

    public ji2(int i, float f, a aVar) {
        this.b = TypedValue.applyDimension(i, f, Resources.getSystem().getDisplayMetrics());
        if (aVar == null) {
            this.c = null;
            return;
        }
        Paint paint = new Paint();
        this.c = paint;
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setColor(aVar.b);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(aVar.a);
    }

    private Bitmap a(oi oiVar, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap bitmapD = oiVar.d(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapD);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        float f = this.b;
        canvas.drawRoundRect(rectF, f, f, paint);
        Paint paint2 = this.c;
        if (paint2 != null) {
            float f2 = this.b;
            canvas.drawRoundRect(rectF, f2, f2, paint2);
        }
        return bitmapD;
    }

    @Override // defpackage.ri
    protected Bitmap transform(oi oiVar, Bitmap bitmap, int i, int i2) {
        return a(oiVar, b53.b(oiVar, bitmap, i, i2));
    }

    @Override // defpackage.w81
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
