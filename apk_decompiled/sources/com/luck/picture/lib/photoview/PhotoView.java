package com.luck.picture.lib.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.fw1;
import defpackage.iw1;
import defpackage.l02;
import defpackage.lw1;
import defpackage.mw1;
import defpackage.nv1;
import defpackage.qv1;
import defpackage.tv1;

/* JADX INFO: loaded from: classes3.dex */
public class PhotoView extends AppCompatImageView {
    private l02 d;
    private ImageView.ScaleType e;

    public PhotoView(Context context) {
        this(context, null);
    }

    private void c() {
        this.d = new l02(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.e;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.e = null;
        }
    }

    public l02 getAttacher() {
        return this.d;
    }

    public RectF getDisplayRect() {
        return this.d.B();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.d.E();
    }

    public float getMaximumScale() {
        return this.d.H();
    }

    public float getMediumScale() {
        return this.d.I();
    }

    public float getMinimumScale() {
        return this.d.J();
    }

    public float getScale() {
        return this.d.K();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.d.L();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.d.O(z);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.d.l0();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        l02 l02Var = this.d;
        if (l02Var != null) {
            l02Var.l0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        l02 l02Var = this.d;
        if (l02Var != null) {
            l02Var.l0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        l02 l02Var = this.d;
        if (l02Var != null) {
            l02Var.l0();
        }
    }

    public void setMaximumScale(float f) {
        this.d.Q(f);
    }

    public void setMediumScale(float f) {
        this.d.R(f);
    }

    public void setMinimumScale(float f) {
        this.d.S(f);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.d.T(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.d.U(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.d.V(onLongClickListener);
    }

    public void setOnMatrixChangeListener(nv1 nv1Var) {
        this.d.W(nv1Var);
    }

    public void setOnOutsidePhotoTapListener(qv1 qv1Var) {
        this.d.X(qv1Var);
    }

    public void setOnPhotoTapListener(tv1 tv1Var) {
        this.d.Y(tv1Var);
    }

    public void setOnScaleChangeListener(fw1 fw1Var) {
        this.d.Z(fw1Var);
    }

    public void setOnSingleFlingListener(iw1 iw1Var) {
        this.d.a0(iw1Var);
    }

    public void setOnViewDragListener(lw1 lw1Var) {
        this.d.b0(lw1Var);
    }

    public void setOnViewTapListener(mw1 mw1Var) {
        this.d.c0(mw1Var);
    }

    public void setRotationBy(float f) {
        this.d.d0(f);
    }

    public void setRotationTo(float f) {
        this.d.e0(f);
    }

    public void setScale(float f) {
        this.d.f0(f);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        l02 l02Var = this.d;
        if (l02Var == null) {
            this.e = scaleType;
        } else {
            l02Var.i0(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i) {
        this.d.j0(i);
    }

    public void setZoomable(boolean z) {
        this.d.k0(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }
}
