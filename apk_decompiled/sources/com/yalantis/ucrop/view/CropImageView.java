package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.luck.picture.lib.R$styleable;
import defpackage.a11;
import defpackage.b50;
import defpackage.bi;
import defpackage.c50;
import defpackage.ci;
import defpackage.e50;
import defpackage.fe2;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class CropImageView extends TransformImageView {
    private float F;
    private int G;
    private int H;
    private long I;
    private final RectF s;
    private final Matrix t;
    private float u;
    private float v;
    private b50 w;
    private Runnable x;
    private Runnable y;
    private float z;

    private static class a implements Runnable {
        private final WeakReference a;
        private final long b;
        private final long c = System.currentTimeMillis();
        private final float d;
        private final float e;
        private final float f;
        private final float g;
        private final float h;
        private final float i;
        private final boolean j;

        public a(CropImageView cropImageView, long j, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
            this.a = new WeakReference(cropImageView);
            this.b = j;
            this.d = f;
            this.e = f2;
            this.f = f3;
            this.g = f4;
            this.h = f5;
            this.i = f6;
            this.j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = (CropImageView) this.a.get();
            if (cropImageView == null) {
                return;
            }
            float fMin = Math.min(this.b, System.currentTimeMillis() - this.c);
            float fB = e50.b(fMin, 0.0f, this.f, this.b);
            float fB2 = e50.b(fMin, 0.0f, this.g, this.b);
            float fA = e50.a(fMin, 0.0f, this.i, this.b);
            if (fMin < this.b) {
                float[] fArr = cropImageView.e;
                cropImageView.m(fB - (fArr[0] - this.d), fB2 - (fArr[1] - this.e));
                if (!this.j) {
                    cropImageView.D(this.h + fA, cropImageView.s.centerX(), cropImageView.s.centerY());
                }
                if (cropImageView.v()) {
                    return;
                }
                cropImageView.post(this);
            }
        }
    }

    private static class b implements Runnable {
        private final WeakReference a;
        private final long b;
        private final long c = System.currentTimeMillis();
        private final float d;
        private final float e;
        private final float f;
        private final float g;

        public b(CropImageView cropImageView, long j, float f, float f2, float f3, float f4) {
            this.a = new WeakReference(cropImageView);
            this.b = j;
            this.d = f;
            this.e = f2;
            this.f = f3;
            this.g = f4;
        }

        @Override // java.lang.Runnable
        public void run() {
            CropImageView cropImageView = (CropImageView) this.a.get();
            if (cropImageView == null) {
                return;
            }
            float fMin = Math.min(this.b, System.currentTimeMillis() - this.c);
            float fA = e50.a(fMin, 0.0f, this.e, this.b);
            if (fMin >= this.b) {
                cropImageView.z();
            } else {
                cropImageView.D(this.d + fA, this.f, this.g);
                cropImageView.post(this);
            }
        }
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    private void A(float f, float f2) {
        float fWidth = this.s.width();
        float fHeight = this.s.height();
        float fMax = Math.max(this.s.width() / f, this.s.height() / f2);
        RectF rectF = this.s;
        float f3 = ((fWidth - (f * fMax)) / 2.0f) + rectF.left;
        float f4 = ((fHeight - (f2 * fMax)) / 2.0f) + rectF.top;
        this.g.reset();
        this.g.postScale(fMax, fMax);
        this.g.postTranslate(f3, f4);
        setImageMatrix(this.g);
    }

    private float[] q() {
        this.t.reset();
        this.t.setRotate(-getCurrentAngle());
        float[] fArr = this.d;
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        float[] fArrB = fe2.b(this.s);
        this.t.mapPoints(fArrCopyOf);
        this.t.mapPoints(fArrB);
        RectF rectFD = fe2.d(fArrCopyOf);
        RectF rectFD2 = fe2.d(fArrB);
        float f = rectFD.left - rectFD2.left;
        float f2 = rectFD.top - rectFD2.top;
        float f3 = rectFD.right - rectFD2.right;
        float f4 = rectFD.bottom - rectFD2.bottom;
        if (f <= 0.0f) {
            f = 0.0f;
        }
        if (f2 <= 0.0f) {
            f2 = 0.0f;
        }
        if (f3 >= 0.0f) {
            f3 = 0.0f;
        }
        if (f4 >= 0.0f) {
            f4 = 0.0f;
        }
        float[] fArr2 = {f, f2, f3, f4};
        this.t.reset();
        this.t.setRotate(getCurrentAngle());
        this.t.mapPoints(fArr2);
        return fArr2;
    }

    private void r() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        s(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    private void s(float f, float f2) {
        float fMin = Math.min(Math.min(this.s.width() / f, this.s.width() / f2), Math.min(this.s.height() / f2, this.s.height() / f));
        this.F = fMin;
        this.z = fMin * this.v;
    }

    protected void B(float f, float f2, float f3, long j) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        float currentScale = getCurrentScale();
        b bVar = new b(this, j, currentScale, f - currentScale, f2, f3);
        this.y = bVar;
        post(bVar);
    }

    public void C(float f) {
        D(f, this.s.centerX(), this.s.centerY());
    }

    public void D(float f, float f2, float f3) {
        if (f <= getMaxScale()) {
            l(f / getCurrentScale(), f2, f3);
        }
    }

    public void E(float f) {
        F(f, this.s.centerX(), this.s.centerY());
    }

    public void F(float f, float f2, float f3) {
        if (f >= getMinScale()) {
            l(f / getCurrentScale(), f2, f3);
        }
    }

    public b50 getCropBoundsChangeListener() {
        return this.w;
    }

    public float getMaxScale() {
        return this.z;
    }

    public float getMinScale() {
        return this.F;
    }

    public float getTargetAspectRatio() {
        return this.u;
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    protected void j() {
        super.j();
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.u == 0.0f) {
            this.u = intrinsicWidth / intrinsicHeight;
        }
        int i = this.h;
        float f = this.u;
        int i2 = (int) (i / f);
        int i3 = this.i;
        if (i2 > i3) {
            int i4 = (int) (i3 * f);
            int i5 = (i - i4) / 2;
            this.s.set(i5, 0.0f, i4 + i5, i3);
        } else {
            int i6 = (i3 - i2) / 2;
            this.s.set(0.0f, i6, i, i2 + i6);
        }
        s(intrinsicWidth, intrinsicHeight);
        A(intrinsicWidth, intrinsicHeight);
        b50 b50Var = this.w;
        if (b50Var != null) {
            b50Var.a(this.u);
        }
        TransformImageView.b bVar = this.j;
        if (bVar != null) {
            bVar.d(getCurrentScale());
            this.j.a(getCurrentAngle());
        }
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    public void l(float f, float f2, float f3) {
        if (f > 1.0f && getCurrentScale() * f <= getMaxScale()) {
            super.l(f, f2, f3);
        } else {
            if (f >= 1.0f || getCurrentScale() * f < getMinScale()) {
                return;
            }
            super.l(f, f2, f3);
        }
    }

    public void setCropBoundsChangeListener(b50 b50Var) {
        this.w = b50Var;
    }

    public void setCropRect(RectF rectF) {
        this.u = rectF.width() / rectF.height();
        this.s.set(rectF.left - getPaddingLeft(), rectF.top - getPaddingTop(), rectF.right - getPaddingRight(), rectF.bottom - getPaddingBottom());
        r();
        z();
    }

    public void setImageToWrapCropBounds(boolean z) {
        float f;
        float fMax;
        float f2;
        if (!this.n || v()) {
            return;
        }
        float[] fArr = this.e;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float currentScale = getCurrentScale();
        float fCenterX = this.s.centerX() - f3;
        float fCenterY = this.s.centerY() - f4;
        this.t.reset();
        this.t.setTranslate(fCenterX, fCenterY);
        float[] fArr2 = this.d;
        float[] fArrCopyOf = Arrays.copyOf(fArr2, fArr2.length);
        this.t.mapPoints(fArrCopyOf);
        boolean zW = w(fArrCopyOf);
        if (zW) {
            float[] fArrQ = q();
            float f5 = -(fArrQ[0] + fArrQ[2]);
            f2 = -(fArrQ[1] + fArrQ[3]);
            f = f5;
            fMax = 0.0f;
        } else {
            RectF rectF = new RectF(this.s);
            this.t.reset();
            this.t.setRotate(getCurrentAngle());
            this.t.mapRect(rectF);
            float[] fArrC = fe2.c(this.d);
            f = fCenterX;
            fMax = (Math.max(rectF.width() / fArrC[0], rectF.height() / fArrC[1]) * currentScale) - currentScale;
            f2 = fCenterY;
        }
        if (z) {
            a aVar = new a(this, this.I, f3, f4, f, f2, currentScale, fMax, zW);
            this.x = aVar;
            post(aVar);
        } else {
            m(f, f2);
            if (zW) {
                return;
            }
            D(currentScale + fMax, this.s.centerX(), this.s.centerY());
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Animation duration cannot be negative value.");
        }
        this.I = j;
    }

    public void setMaxResultImageSizeX(int i) {
        this.G = i;
    }

    public void setMaxResultImageSizeY(int i) {
        this.H = i;
    }

    public void setMaxScaleMultiplier(float f) {
        this.v = f;
    }

    public void setTargetAspectRatio(float f) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            this.u = f;
            return;
        }
        if (f == 0.0f) {
            this.u = drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
        } else {
            this.u = f;
        }
        b50 b50Var = this.w;
        if (b50Var != null) {
            b50Var.a(this.u);
        }
    }

    public void t() {
        removeCallbacks(this.x);
        removeCallbacks(this.y);
    }

    public void u(Bitmap.CompressFormat compressFormat, int i, bi biVar) {
        t();
        setImageToWrapCropBounds(false);
        new ci(getContext(), getViewBitmap(), new a11(this.s, fe2.d(this.d), getCurrentScale(), getCurrentAngle()), new c50(this.G, this.H, compressFormat, i, getImageInputPath(), getImageOutputPath(), getExifInfo()), biVar).executeOnExecutor(Executors.newCachedThreadPool(), new Void[0]);
    }

    protected boolean v() {
        return w(this.d);
    }

    protected boolean w(float[] fArr) {
        this.t.reset();
        this.t.setRotate(-getCurrentAngle());
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        this.t.mapPoints(fArrCopyOf);
        float[] fArrB = fe2.b(this.s);
        this.t.mapPoints(fArrB);
        return fe2.d(fArrCopyOf).contains(fe2.d(fArrB));
    }

    public void x(float f) {
        k(f, this.s.centerX(), this.s.centerY());
    }

    protected void y(TypedArray typedArray) {
        float fAbs = Math.abs(typedArray.getFloat(R$styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float fAbs2 = Math.abs(typedArray.getFloat(R$styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        if (fAbs == 0.0f || fAbs2 == 0.0f) {
            this.u = 0.0f;
        } else {
            this.u = fAbs / fAbs2;
        }
    }

    public void z() {
        setImageToWrapCropBounds(true);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.s = new RectF();
        this.t = new Matrix();
        this.v = 10.0f;
        this.y = null;
        this.G = 0;
        this.H = 0;
        this.I = 500L;
    }
}
