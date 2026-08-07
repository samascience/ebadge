package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R$styleable;
import defpackage.v8;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {
    private c d;
    private boolean e;
    private Drawable f;
    private Drawable g;
    private float h;
    private float i;
    private float j;
    private Path k;
    ViewOutlineProvider l;
    RectF m;
    Drawable[] n;
    LayerDrawable o;
    float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    float f182q;
    float r;
    float s;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = ImageFilterView.this.getWidth();
            int height = ImageFilterView.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * ImageFilterView.this.i) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.j);
        }
    }

    static class c {
        float[] a = new float[20];
        ColorMatrix b = new ColorMatrix();
        ColorMatrix c = new ColorMatrix();
        float d = 1.0f;
        float e = 1.0f;
        float f = 1.0f;
        float g = 1.0f;

        c() {
        }

        private void a(float f) {
            float[] fArr = this.a;
            fArr[0] = f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void b(float f) {
            float f2 = 1.0f - f;
            float f3 = 0.2999f * f2;
            float f4 = 0.587f * f2;
            float f5 = f2 * 0.114f;
            float[] fArr = this.a;
            fArr[0] = f3 + f;
            fArr[1] = f4;
            fArr[2] = f5;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f3;
            fArr[6] = f4 + f;
            fArr[7] = f5;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f3;
            fArr[11] = f4;
            fArr[12] = f5 + f;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void d(float f) {
            float fLog;
            float fPow;
            float fLog2;
            if (f <= 0.0f) {
                f = 0.01f;
            }
            float f2 = (5000.0f / f) / 100.0f;
            if (f2 > 66.0f) {
                double d = f2 - 60.0f;
                fPow = ((float) Math.pow(d, -0.13320475816726685d)) * 329.69873f;
                fLog = ((float) Math.pow(d, 0.07551484555006027d)) * 288.12216f;
            } else {
                fLog = (((float) Math.log(f2)) * 99.4708f) - 161.11957f;
                fPow = 255.0f;
            }
            if (f2 < 66.0f) {
                fLog2 = f2 > 19.0f ? (((float) Math.log(f2 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f;
            } else {
                fLog2 = 255.0f;
            }
            float fMin = Math.min(255.0f, Math.max(fPow, 0.0f));
            float fMin2 = Math.min(255.0f, Math.max(fLog, 0.0f));
            float fMin3 = Math.min(255.0f, Math.max(fLog2, 0.0f));
            float fLog3 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float fLog4 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float fMin4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float fMin5 = Math.min(255.0f, Math.max(fLog3, 0.0f));
            float fMin6 = fMin3 / Math.min(255.0f, Math.max(fLog4, 0.0f));
            float[] fArr = this.a;
            fArr[0] = fMin / fMin4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = fMin2 / fMin5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = fMin6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        void c(ImageView imageView) {
            boolean z;
            this.b.reset();
            float f = this.e;
            boolean z2 = true;
            if (f != 1.0f) {
                b(f);
                this.b.set(this.a);
                z = true;
            } else {
                z = false;
            }
            float f2 = this.f;
            if (f2 != 1.0f) {
                this.c.setScale(f2, f2, f2, 1.0f);
                this.b.postConcat(this.c);
                z = true;
            }
            float f3 = this.g;
            if (f3 != 1.0f) {
                d(f3);
                this.c.set(this.a);
                this.b.postConcat(this.c);
                z = true;
            }
            float f4 = this.d;
            if (f4 != 1.0f) {
                a(f4);
                this.c.set(this.a);
                this.b.postConcat(this.c);
            } else {
                z2 = z;
            }
            if (z2) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.b));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        this.d = new c();
        this.e = true;
        this.f = null;
        this.g = null;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = Float.NaN;
        this.n = new Drawable[2];
        this.p = Float.NaN;
        this.f182q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        e(context, null);
    }

    private void e(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            this.f = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ImageFilterView_altSrc);
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R$styleable.ImageFilterView_crossfade) {
                    this.h = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R$styleable.ImageFilterView_warmth) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_saturation) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_contrast) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_brightness) {
                    setBrightness(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_overlay) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.e));
                } else if (index == R$styleable.ImageFilterView_imagePanX) {
                    setImagePanX(typedArrayObtainStyledAttributes.getFloat(index, this.p));
                } else if (index == R$styleable.ImageFilterView_imagePanY) {
                    setImagePanY(typedArrayObtainStyledAttributes.getFloat(index, this.f182q));
                } else if (index == R$styleable.ImageFilterView_imageRotate) {
                    setImageRotate(typedArrayObtainStyledAttributes.getFloat(index, this.s));
                } else if (index == R$styleable.ImageFilterView_imageZoom) {
                    setImageZoom(typedArrayObtainStyledAttributes.getFloat(index, this.r));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.g = drawable;
            if (this.f == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.g = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.n;
                    Drawable drawableMutate = drawable2.mutate();
                    this.g = drawableMutate;
                    drawableArr[0] = drawableMutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.n;
            Drawable drawableMutate2 = getDrawable().mutate();
            this.g = drawableMutate2;
            drawableArr2[0] = drawableMutate2;
            this.n[1] = this.f.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.n);
            this.o = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.h * 255.0f));
            if (!this.e) {
                this.o.getDrawable(0).setAlpha((int) ((1.0f - this.h) * 255.0f));
            }
            super.setImageDrawable(this.o);
        }
    }

    private void f() {
        if (Float.isNaN(this.p) && Float.isNaN(this.f182q) && Float.isNaN(this.r) && Float.isNaN(this.s)) {
            return;
        }
        float f = Float.isNaN(this.p) ? 0.0f : this.p;
        float f2 = Float.isNaN(this.f182q) ? 0.0f : this.f182q;
        float f3 = Float.isNaN(this.r) ? 1.0f : this.r;
        float f4 = Float.isNaN(this.s) ? 0.0f : this.s;
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        float f5 = f3 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
        matrix.postScale(f5, f5);
        float f6 = intrinsicWidth * f5;
        float f7 = f5 * intrinsicHeight;
        matrix.postTranslate((((f * (width - f6)) + width) - f6) * 0.5f, (((f2 * (height - f7)) + height) - f7) * 0.5f);
        matrix.postRotate(f4, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void g() {
        if (Float.isNaN(this.p) && Float.isNaN(this.f182q) && Float.isNaN(this.r) && Float.isNaN(this.s)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            f();
        }
    }

    private void setOverlay(boolean z) {
        this.e = z;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.d.d;
    }

    public float getContrast() {
        return this.d.f;
    }

    public float getCrossfade() {
        return this.h;
    }

    public float getImagePanX() {
        return this.p;
    }

    public float getImagePanY() {
        return this.f182q;
    }

    public float getImageRotate() {
        return this.s;
    }

    public float getImageZoom() {
        return this.r;
    }

    public float getRound() {
        return this.j;
    }

    public float getRoundPercent() {
        return this.i;
    }

    public float getSaturation() {
        return this.d.e;
    }

    public float getWarmth() {
        return this.d.g;
    }

    @Override // android.view.View
    public void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        f();
    }

    public void setAltImageResource(int i) {
        Drawable drawableMutate = v8.b(getContext(), i).mutate();
        this.f = drawableMutate;
        Drawable[] drawableArr = this.n;
        drawableArr[0] = this.g;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.n);
        this.o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.h);
    }

    public void setBrightness(float f) {
        c cVar = this.d;
        cVar.d = f;
        cVar.c(this);
    }

    public void setContrast(float f) {
        c cVar = this.d;
        cVar.f = f;
        cVar.c(this);
    }

    public void setCrossfade(float f) {
        this.h = f;
        if (this.n != null) {
            if (!this.e) {
                this.o.getDrawable(0).setAlpha((int) ((1.0f - this.h) * 255.0f));
            }
            this.o.getDrawable(1).setAlpha((int) (this.h * 255.0f));
            super.setImageDrawable(this.o);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.g = drawableMutate;
        Drawable[] drawableArr = this.n;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f;
        LayerDrawable layerDrawable = new LayerDrawable(this.n);
        this.o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.h);
    }

    public void setImagePanX(float f) {
        this.p = f;
        g();
    }

    public void setImagePanY(float f) {
        this.f182q = f;
        g();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        if (this.f == null) {
            super.setImageResource(i);
            return;
        }
        Drawable drawableMutate = v8.b(getContext(), i).mutate();
        this.g = drawableMutate;
        Drawable[] drawableArr = this.n;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f;
        LayerDrawable layerDrawable = new LayerDrawable(this.n);
        this.o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.h);
    }

    public void setImageRotate(float f) {
        this.s = f;
        g();
    }

    public void setImageZoom(float f) {
        this.r = f;
        g();
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.j = f;
            float f2 = this.i;
            this.i = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.j != f;
        this.j = f;
        if (f != 0.0f) {
            if (this.k == null) {
                this.k = new Path();
            }
            if (this.m == null) {
                this.m = new RectF();
            }
            if (this.l == null) {
                b bVar = new b();
                this.l = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.m.set(0.0f, 0.0f, getWidth(), getHeight());
            this.k.reset();
            Path path = this.k;
            RectF rectF = this.m;
            float f3 = this.j;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f) {
        boolean z = this.i != f;
        this.i = f;
        if (f != 0.0f) {
            if (this.k == null) {
                this.k = new Path();
            }
            if (this.m == null) {
                this.m = new RectF();
            }
            if (this.l == null) {
                a aVar = new a();
                this.l = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.i) / 2.0f;
            this.m.set(0.0f, 0.0f, width, height);
            this.k.reset();
            this.k.addRoundRect(this.m, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f) {
        c cVar = this.d;
        cVar.e = f;
        cVar.c(this);
    }

    public void setWarmth(float f) {
        c cVar = this.d;
        cVar.g = f;
        cVar.c(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new c();
        this.e = true;
        this.f = null;
        this.g = null;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = Float.NaN;
        this.n = new Drawable[2];
        this.p = Float.NaN;
        this.f182q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        e(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new c();
        this.e = true;
        this.f = null;
        this.g = null;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = Float.NaN;
        this.n = new Drawable[2];
        this.p = Float.NaN;
        this.f182q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        e(context, attributeSet);
    }
}
