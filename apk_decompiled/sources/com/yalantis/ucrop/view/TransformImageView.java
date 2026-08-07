package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.cj0;
import defpackage.fe2;
import defpackage.hk0;
import defpackage.li;
import defpackage.ni;

/* JADX INFO: loaded from: classes3.dex */
public class TransformImageView extends AppCompatImageView {
    protected final float[] d;
    protected final float[] e;
    private final float[] f;
    protected Matrix g;
    protected int h;
    protected int i;
    protected b j;
    private float[] k;
    private float[] l;
    protected boolean m;
    protected boolean n;
    private int o;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f318q;
    private cj0 r;

    class a implements li {
        a() {
        }

        @Override // defpackage.li
        public void a(Bitmap bitmap, cj0 cj0Var, String str, String str2) {
            TransformImageView.this.p = str;
            TransformImageView.this.f318q = str2;
            TransformImageView.this.r = cj0Var;
            TransformImageView transformImageView = TransformImageView.this;
            transformImageView.m = true;
            transformImageView.setImageBitmap(bitmap);
        }

        @Override // defpackage.li
        public void b(Exception exc) {
            Log.e("TransformImageView", "onFailure: setImageUri", exc);
            b bVar = TransformImageView.this.j;
            if (bVar != null) {
                bVar.c(exc);
            }
        }
    }

    public interface b {
        void a(float f);

        void b();

        void c(Exception exc);

        void d(float f);
    }

    public TransformImageView(Context context) {
        this(context, null);
    }

    private void o() {
        this.g.mapPoints(this.d, this.k);
        this.g.mapPoints(this.e, this.l);
    }

    public float f(Matrix matrix) {
        return (float) (-(Math.atan2(h(matrix, 1), h(matrix, 0)) * 57.29577951308232d));
    }

    public float g(Matrix matrix) {
        return (float) Math.sqrt(Math.pow(h(matrix, 0), 2.0d) + Math.pow(h(matrix, 3), 2.0d));
    }

    public float getCurrentAngle() {
        return f(this.g);
    }

    public float getCurrentScale() {
        return g(this.g);
    }

    public cj0 getExifInfo() {
        return this.r;
    }

    public String getImageInputPath() {
        return this.p;
    }

    public String getImageOutputPath() {
        return this.f318q;
    }

    public int getMaxBitmapSize() {
        if (this.o <= 0) {
            this.o = ni.b(getContext());
        }
        return this.o;
    }

    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof hk0)) {
            return null;
        }
        return ((hk0) getDrawable()).a();
    }

    protected float h(Matrix matrix, int i) {
        matrix.getValues(this.f);
        return this.f[i];
    }

    protected void i() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    protected void j() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        Log.d("TransformImageView", String.format("Image size: [%d:%d]", Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)));
        RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        this.k = fe2.b(rectF);
        this.l = fe2.a(rectF);
        this.n = true;
        b bVar = this.j;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void k(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.g.postRotate(f, f2, f3);
            setImageMatrix(this.g);
            b bVar = this.j;
            if (bVar != null) {
                bVar.a(f(this.g));
            }
        }
    }

    public void l(float f, float f2, float f3) {
        if (f != 0.0f) {
            this.g.postScale(f, f, f2, f3);
            setImageMatrix(this.g);
            b bVar = this.j;
            if (bVar != null) {
                bVar.d(g(this.g));
            }
        }
    }

    public void m(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        this.g.postTranslate(f, f2);
        setImageMatrix(this.g);
    }

    public void n(Uri uri, Uri uri2, int i, int i2) {
        int maxBitmapSize = getMaxBitmapSize();
        ni.d(getContext(), uri, uri2, maxBitmapSize, maxBitmapSize, i, i2, new a());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z || (this.m && !this.n)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.h = width - paddingLeft;
            this.i = height - paddingTop;
            j();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new hk0(bitmap));
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.g.set(matrix);
        o();
    }

    public void setMaxBitmapSize(int i) {
        this.o = i;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w("TransformImageView", "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setTransformImageListener(b bVar) {
        this.j = bVar;
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new float[8];
        this.e = new float[2];
        this.f = new float[9];
        this.g = new Matrix();
        this.m = false;
        this.n = false;
        this.o = 0;
        i();
    }
}
