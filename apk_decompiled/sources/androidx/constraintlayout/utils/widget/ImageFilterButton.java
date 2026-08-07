package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.R$styleable;
import defpackage.v8;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterButton extends AppCompatImageButton {
    private ImageFilterView.c d;
    private float e;
    private float f;
    private float g;
    private Path h;
    ViewOutlineProvider i;
    RectF j;
    Drawable[] k;
    LayerDrawable l;
    private boolean m;
    private Drawable n;
    private Drawable o;
    private float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f181q;
    private float r;
    private float s;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = ImageFilterButton.this.getWidth();
            int height = ImageFilterButton.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * ImageFilterButton.this.f) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.g);
        }
    }

    public ImageFilterButton(Context context) {
        super(context);
        this.d = new ImageFilterView.c();
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = Float.NaN;
        this.k = new Drawable[2];
        this.m = true;
        this.n = null;
        this.o = null;
        this.p = Float.NaN;
        this.f181q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        c(context, null);
    }

    private void c(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            this.n = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ImageFilterView_altSrc);
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R$styleable.ImageFilterView_crossfade) {
                    this.e = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R$styleable.ImageFilterView_warmth) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_saturation) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_contrast) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_overlay) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.m));
                } else if (index == R$styleable.ImageFilterView_imagePanX) {
                    setImagePanX(typedArrayObtainStyledAttributes.getFloat(index, this.p));
                } else if (index == R$styleable.ImageFilterView_imagePanY) {
                    setImagePanY(typedArrayObtainStyledAttributes.getFloat(index, this.f181q));
                } else if (index == R$styleable.ImageFilterView_imageRotate) {
                    setImageRotate(typedArrayObtainStyledAttributes.getFloat(index, this.s));
                } else if (index == R$styleable.ImageFilterView_imageZoom) {
                    setImageZoom(typedArrayObtainStyledAttributes.getFloat(index, this.r));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.o = drawable;
            if (this.n == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.o = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.k;
                    Drawable drawableMutate = drawable2.mutate();
                    this.o = drawableMutate;
                    drawableArr[0] = drawableMutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.k;
            Drawable drawableMutate2 = getDrawable().mutate();
            this.o = drawableMutate2;
            drawableArr2[0] = drawableMutate2;
            this.k[1] = this.n.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.k);
            this.l = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.e * 255.0f));
            if (!this.m) {
                this.l.getDrawable(0).setAlpha((int) ((1.0f - this.e) * 255.0f));
            }
            super.setImageDrawable(this.l);
        }
    }

    private void d() {
        if (Float.isNaN(this.p) && Float.isNaN(this.f181q) && Float.isNaN(this.r) && Float.isNaN(this.s)) {
            return;
        }
        float f = Float.isNaN(this.p) ? 0.0f : this.p;
        float f2 = Float.isNaN(this.f181q) ? 0.0f : this.f181q;
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

    private void e() {
        if (Float.isNaN(this.p) && Float.isNaN(this.f181q) && Float.isNaN(this.r) && Float.isNaN(this.s)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            d();
        }
    }

    private void setOverlay(boolean z) {
        this.m = z;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getContrast() {
        return this.d.f;
    }

    public float getCrossfade() {
        return this.e;
    }

    public float getImagePanX() {
        return this.p;
    }

    public float getImagePanY() {
        return this.f181q;
    }

    public float getImageRotate() {
        return this.s;
    }

    public float getImageZoom() {
        return this.r;
    }

    public float getRound() {
        return this.g;
    }

    public float getRoundPercent() {
        return this.f;
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
        d();
    }

    public void setAltImageResource(int i) {
        Drawable drawableMutate = v8.b(getContext(), i).mutate();
        this.n = drawableMutate;
        Drawable[] drawableArr = this.k;
        drawableArr[0] = this.o;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.k);
        this.l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.e);
    }

    public void setBrightness(float f) {
        ImageFilterView.c cVar = this.d;
        cVar.d = f;
        cVar.c(this);
    }

    public void setContrast(float f) {
        ImageFilterView.c cVar = this.d;
        cVar.f = f;
        cVar.c(this);
    }

    public void setCrossfade(float f) {
        this.e = f;
        if (this.k != null) {
            if (!this.m) {
                this.l.getDrawable(0).setAlpha((int) ((1.0f - this.e) * 255.0f));
            }
            this.l.getDrawable(1).setAlpha((int) (this.e * 255.0f));
            super.setImageDrawable(this.l);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.n == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.o = drawableMutate;
        Drawable[] drawableArr = this.k;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.n;
        LayerDrawable layerDrawable = new LayerDrawable(this.k);
        this.l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.e);
    }

    public void setImagePanX(float f) {
        this.p = f;
        e();
    }

    public void setImagePanY(float f) {
        this.f181q = f;
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int i) {
        if (this.n == null) {
            super.setImageResource(i);
            return;
        }
        Drawable drawableMutate = v8.b(getContext(), i).mutate();
        this.o = drawableMutate;
        Drawable[] drawableArr = this.k;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.n;
        LayerDrawable layerDrawable = new LayerDrawable(this.k);
        this.l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.e);
    }

    public void setImageRotate(float f) {
        this.s = f;
        e();
    }

    public void setImageZoom(float f) {
        this.r = f;
        e();
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.g = f;
            float f2 = this.f;
            this.f = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.g != f;
        this.g = f;
        if (f != 0.0f) {
            if (this.h == null) {
                this.h = new Path();
            }
            if (this.j == null) {
                this.j = new RectF();
            }
            if (this.i == null) {
                b bVar = new b();
                this.i = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.j.set(0.0f, 0.0f, getWidth(), getHeight());
            this.h.reset();
            Path path = this.h;
            RectF rectF = this.j;
            float f3 = this.g;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f) {
        boolean z = this.f != f;
        this.f = f;
        if (f != 0.0f) {
            if (this.h == null) {
                this.h = new Path();
            }
            if (this.j == null) {
                this.j = new RectF();
            }
            if (this.i == null) {
                a aVar = new a();
                this.i = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f) / 2.0f;
            this.j.set(0.0f, 0.0f, width, height);
            this.h.reset();
            this.h.addRoundRect(this.j, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f) {
        ImageFilterView.c cVar = this.d;
        cVar.e = f;
        cVar.c(this);
    }

    public void setWarmth(float f) {
        ImageFilterView.c cVar = this.d;
        cVar.g = f;
        cVar.c(this);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new ImageFilterView.c();
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = Float.NaN;
        this.k = new Drawable[2];
        this.m = true;
        this.n = null;
        this.o = null;
        this.p = Float.NaN;
        this.f181q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        c(context, attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new ImageFilterView.c();
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = Float.NaN;
        this.k = new Drawable[2];
        this.m = true;
        this.n = null;
        this.o = null;
        this.p = Float.NaN;
        this.f181q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        c(context, attributeSet);
    }
}
