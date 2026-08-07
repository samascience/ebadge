package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public abstract class gi2 extends Drawable {
    final Bitmap a;
    private int b;
    private final BitmapShader e;
    private float g;
    private boolean k;
    private int l;
    private int m;
    private int c = 119;
    private final Paint d = new Paint(3);
    private final Matrix f = new Matrix();
    final Rect h = new Rect();
    private final RectF i = new RectF();
    private boolean j = true;

    gi2(Resources resources, Bitmap bitmap) {
        this.b = 160;
        if (resources != null) {
            this.b = resources.getDisplayMetrics().densityDpi;
        }
        this.a = bitmap;
        if (bitmap != null) {
            a();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.e = new BitmapShader(bitmap, tileMode, tileMode);
        } else {
            this.m = -1;
            this.l = -1;
            this.e = null;
        }
    }

    private void a() {
        this.l = this.a.getScaledWidth(this.b);
        this.m = this.a.getScaledHeight(this.b);
    }

    private static boolean d(float f) {
        return f > 0.05f;
    }

    private void f() {
        this.g = Math.min(this.m, this.l) / 2;
    }

    public float b() {
        return this.g;
    }

    abstract void c(int i, int i2, int i3, Rect rect, Rect rect2);

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.a;
        if (bitmap == null) {
            return;
        }
        g();
        if (this.d.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.h, this.d);
            return;
        }
        RectF rectF = this.i;
        float f = this.g;
        canvas.drawRoundRect(rectF, f, f, this.d);
    }

    public void e(float f) {
        if (this.g == f) {
            return;
        }
        this.k = false;
        if (d(f)) {
            this.d.setShader(this.e);
        } else {
            this.d.setShader(null);
        }
        this.g = f;
        invalidateSelf();
    }

    void g() {
        if (this.j) {
            if (this.k) {
                int iMin = Math.min(this.l, this.m);
                c(this.c, iMin, iMin, getBounds(), this.h);
                int iMin2 = Math.min(this.h.width(), this.h.height());
                this.h.inset(Math.max(0, (this.h.width() - iMin2) / 2), Math.max(0, (this.h.height() - iMin2) / 2));
                this.g = iMin2 * 0.5f;
            } else {
                c(this.c, this.l, this.m, getBounds(), this.h);
            }
            this.i.set(this.h);
            if (this.e != null) {
                Matrix matrix = this.f;
                RectF rectF = this.i;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f.preScale(this.i.width() / this.a.getWidth(), this.i.height() / this.a.getHeight());
                this.e.setLocalMatrix(this.f);
                this.d.setShader(this.e);
            }
            this.j = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.d.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.c != 119 || this.k || (bitmap = this.a) == null || bitmap.hasAlpha() || this.d.getAlpha() < 255 || d(this.g)) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.k) {
            f();
        }
        this.j = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.d.getAlpha()) {
            this.d.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.d.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.d.setFilterBitmap(z);
        invalidateSelf();
    }
}
