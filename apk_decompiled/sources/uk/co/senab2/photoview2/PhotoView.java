package uk.co.senab2.photoview2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoView extends ImageView implements b {
    private c a;
    private ImageView.ScaleType b;

    public PhotoView(Context context) {
        this(context, null);
    }

    protected void a() {
        c cVar = this.a;
        if (cVar == null || cVar.u() == null) {
            this.a = new c(this);
        }
        ImageView.ScaleType scaleType = this.b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.b = null;
        }
    }

    public void b(float f, boolean z) {
        this.a.a0(f, z);
    }

    public RectF getDisplayRect() {
        return this.a.q();
    }

    public b getIPhotoViewImplementation() {
        return this.a;
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.a.t();
    }

    public float getMaximumScale() {
        return this.a.x();
    }

    public float getMediumScale() {
        return this.a.y();
    }

    public float getMinimumScale() {
        return this.a.z();
    }

    public float getScale() {
        return this.a.C();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.a.D();
    }

    public Bitmap getVisibleRectangleBitmap() {
        return this.a.F();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        a();
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.a.p();
        this.a.I();
        this.a = null;
        super.onDetachedFromWindow();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.a.J(z);
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        c cVar = this.a;
        if (cVar != null) {
            cVar.e0();
        }
        return frame;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        c cVar = this.a;
        if (cVar != null) {
            cVar.e0();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        c cVar = this.a;
        if (cVar != null) {
            cVar.e0();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        c cVar = this.a;
        if (cVar != null) {
            cVar.e0();
        }
    }

    public void setMaximumScale(float f) {
        this.a.M(f);
    }

    public void setMediumScale(float f) {
        this.a.N(f);
    }

    public void setMinimumScale(float f) {
        this.a.O(f);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.a.P(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.a.Q(onLongClickListener);
    }

    public void setOnMatrixChangeListener(c.e eVar) {
        this.a.R(eVar);
    }

    public void setOnPhotoTapListener(c.f fVar) {
        this.a.S(fVar);
    }

    public void setOnScaleChangeListener(c.g gVar) {
        this.a.T(gVar);
    }

    public void setOnSingleFlingListener(c.h hVar) {
        this.a.U(hVar);
    }

    public void setOnViewTapListener(c.i iVar) {
        this.a.V(iVar);
    }

    public void setRotationBy(float f) {
        this.a.W(f);
    }

    public void setRotationTo(float f) {
        this.a.X(f);
    }

    public void setScale(float f) {
        this.a.Y(f);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        c cVar = this.a;
        if (cVar != null) {
            cVar.b0(scaleType);
        } else {
            this.b = scaleType;
        }
    }

    public void setZoomTransitionDuration(int i) {
        this.a.c0(i);
    }

    public void setZoomable(boolean z) {
        this.a.d0(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        a();
    }
}
