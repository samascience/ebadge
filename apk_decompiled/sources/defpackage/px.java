package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.TypedValue;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes4.dex */
public class px extends ri {
    private final Paint b;
    private final float c;

    public px(int i, float f, int i2) {
        float fApplyDimension = TypedValue.applyDimension(i, f, Resources.getSystem().getDisplayMetrics());
        this.c = fApplyDimension;
        Paint paint = new Paint();
        this.b = paint;
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setColor(i2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(fApplyDimension);
    }

    private Bitmap a(oi oiVar, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) - (this.c / 2.0f));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - iMin) / 2, (bitmap.getHeight() - iMin) / 2, iMin, iMin);
        Bitmap bitmapD = oiVar.d(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapD);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        float f = iMin / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        Paint paint2 = this.b;
        if (paint2 != null) {
            canvas.drawCircle(f, f, f - (this.c / 2.0f), paint2);
        }
        return bitmapD;
    }

    @Override // defpackage.ri
    protected Bitmap transform(oi oiVar, Bitmap bitmap, int i, int i2) {
        return a(oiVar, bitmap);
    }

    @Override // defpackage.w81
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
