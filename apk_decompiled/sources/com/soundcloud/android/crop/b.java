package com.soundcloud.android.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
abstract class b extends ImageView {
    protected Matrix a;
    protected Matrix b;
    private final Matrix c;
    private final float[] d;
    protected final e e;
    int f;
    int g;
    float h;
    private Runnable i;
    protected Handler j;
    private c k;

    class a implements Runnable {
        final /* synthetic */ e a;
        final /* synthetic */ boolean b;

        a(e eVar, boolean z) {
            this.a = eVar;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.n(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: com.soundcloud.android.crop.b$b, reason: collision with other inner class name */
    class RunnableC0105b implements Runnable {
        final /* synthetic */ float a;
        final /* synthetic */ long b;
        final /* synthetic */ float c;
        final /* synthetic */ float d;
        final /* synthetic */ float e;
        final /* synthetic */ float f;

        RunnableC0105b(float f, long j, float f2, float f3, float f4, float f5) {
            this.a = f;
            this.b = j;
            this.c = f2;
            this.d = f3;
            this.e = f4;
            this.f = f5;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMin = Math.min(this.a, System.currentTimeMillis() - this.b);
            b.this.p(this.c + (this.d * fMin), this.e, this.f);
            if (fMin < this.a) {
                b.this.j.post(this);
            }
        }
    }

    public interface c {
        void a(Bitmap bitmap);
    }

    public b(Context context) {
        super(context);
        this.a = new Matrix();
        this.b = new Matrix();
        this.c = new Matrix();
        this.d = new float[9];
        this.e = new e(null, 0);
        this.f = -1;
        this.g = -1;
        this.j = new Handler();
        i();
    }

    private float c(RectF rectF, float f, float f2) {
        float f3;
        float width = getWidth();
        if (f < width) {
            width = (width - f) / 2.0f;
            f3 = rectF.left;
        } else {
            float f4 = rectF.left;
            if (f4 > 0.0f) {
                return -f4;
            }
            f3 = rectF.right;
            if (f3 >= width) {
                return f2;
            }
        }
        return width - f3;
    }

    private float d(RectF rectF, float f, float f2) {
        float height = getHeight();
        if (f < height) {
            return ((height - f) / 2.0f) - rectF.top;
        }
        float f3 = rectF.top;
        if (f3 > 0.0f) {
            return -f3;
        }
        return rectF.bottom < height ? getHeight() - rectF.bottom : f2;
    }

    private void f(e eVar, Matrix matrix, boolean z) {
        float width = getWidth();
        float height = getHeight();
        float fE = eVar.e();
        float fB = eVar.b();
        matrix.reset();
        float fMin = Math.min(Math.min(width / fE, 3.0f), Math.min(height / fB, 3.0f));
        if (z) {
            matrix.postConcat(eVar.c());
        }
        matrix.postScale(fMin, fMin);
        matrix.postTranslate((width - (fE * fMin)) / 2.0f, (height - (fB * fMin)) / 2.0f);
    }

    private void i() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void l(Bitmap bitmap, int i) {
        c cVar;
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap bitmapA = this.e.a();
        this.e.h(bitmap);
        this.e.i(i);
        if (bitmapA == null || bitmapA == bitmap || (cVar = this.k) == null) {
            return;
        }
        cVar.a(bitmapA);
    }

    protected float a() {
        if (this.e.a() == null) {
            return 1.0f;
        }
        return Math.max(this.e.e() / this.f, this.e.b() / this.g) * 4.0f;
    }

    protected void b() {
        Bitmap bitmapA = this.e.a();
        if (bitmapA == null) {
            return;
        }
        Matrix imageViewMatrix = getImageViewMatrix();
        RectF rectF = new RectF(0.0f, 0.0f, bitmapA.getWidth(), bitmapA.getHeight());
        imageViewMatrix.mapRect(rectF);
        float fHeight = rectF.height();
        k(c(rectF, rectF.width(), 0.0f), d(rectF, fHeight, 0.0f));
        setImageMatrix(getImageViewMatrix());
    }

    public void e() {
        m(null, true);
    }

    protected float g(Matrix matrix) {
        return h(matrix, 0);
    }

    protected Matrix getImageViewMatrix() {
        this.c.set(this.a);
        this.c.postConcat(this.b);
        return this.c;
    }

    protected float getScale() {
        return g(this.b);
    }

    public Matrix getUnrotatedMatrix() {
        Matrix matrix = new Matrix();
        f(this.e, matrix, false);
        matrix.postConcat(this.b);
        return matrix;
    }

    protected float h(Matrix matrix, int i) {
        matrix.getValues(this.d);
        return this.d[i];
    }

    protected void j(float f, float f2) {
        k(f, f2);
        setImageMatrix(getImageViewMatrix());
    }

    protected void k(float f, float f2) {
        this.b.postTranslate(f, f2);
    }

    public void m(Bitmap bitmap, boolean z) {
        n(new e(bitmap, 0), z);
    }

    public void n(e eVar, boolean z) {
        if (getWidth() <= 0) {
            this.i = new a(eVar, z);
            return;
        }
        if (eVar.a() != null) {
            f(eVar, this.a, true);
            l(eVar.a(), eVar.d());
        } else {
            this.a.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.b.reset();
        }
        setImageMatrix(getImageViewMatrix());
        this.h = a();
    }

    protected void o(float f) {
        p(f, getWidth() / 2.0f, getHeight() / 2.0f);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || !keyEvent.isTracking() || keyEvent.isCanceled() || getScale() <= 1.0f) {
            return super.onKeyUp(i, keyEvent);
        }
        o(1.0f);
        return true;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f = i3 - i;
        this.g = i4 - i2;
        Runnable runnable = this.i;
        if (runnable != null) {
            this.i = null;
            runnable.run();
        }
        if (this.e.a() != null) {
            f(this.e, this.a, true);
            setImageMatrix(getImageViewMatrix());
        }
    }

    protected void p(float f, float f2, float f3) {
        float f4 = this.h;
        if (f > f4) {
            f = f4;
        }
        float scale = f / getScale();
        this.b.postScale(scale, scale, f2, f3);
        setImageMatrix(getImageViewMatrix());
        b();
    }

    protected void q(float f, float f2, float f3, float f4) {
        float scale = (f - getScale()) / f4;
        float scale2 = getScale();
        this.j.post(new RunnableC0105b(f4, System.currentTimeMillis(), scale2, scale, f2, f3));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        l(bitmap, 0);
    }

    public void setRecycler(c cVar) {
        this.k = cVar;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Matrix();
        this.b = new Matrix();
        this.c = new Matrix();
        this.d = new float[9];
        this.e = new e(null, 0);
        this.f = -1;
        this.g = -1;
        this.j = new Handler();
        i();
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Matrix();
        this.b = new Matrix();
        this.c = new Matrix();
        this.d = new float[9];
        this.e = new e(null, 0);
        this.f = -1;
        this.g = -1;
        this.j = new Handler();
        i();
    }
}
