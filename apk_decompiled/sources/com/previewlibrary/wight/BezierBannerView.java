package com.previewlibrary.wight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.viewpager.widget.ViewPager;
import com.previewlibrary.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class BezierBannerView extends View implements ViewPager.j {
    public static int Q = 1;
    public static int R = 2;
    private static final String S = "com.previewlibrary.wight.BezierBannerView";
    private int F;
    private int G;
    private int H;
    float I;
    float J;
    float K;
    float L;
    float M;
    float N;
    private int O;
    Interpolator P;
    private Paint a;
    private Paint b;
    private Path c;
    private Path d;
    private int e;
    private int f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    float n;
    float o;
    float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    float f307q;
    float r;
    float s;
    float t;
    float u;
    private boolean v;
    private float w;
    private float x;
    private float y;
    private int z;

    public BezierBannerView(Context context) {
        this(context, null);
    }

    private float b(int i) {
        if (i == 0) {
            return this.h;
        }
        float f = this.g;
        float f2 = this.j;
        return (i * (f + (2.0f * f2))) + f2 + (this.h - f2);
    }

    private void f() {
        Paint paint = new Paint(1);
        paint.setColor(this.e);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setAntiAlias(true);
        paint.setDither(true);
        this.a = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(this.f);
        paint2.setStyle(style);
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        this.b = paint2;
    }

    private void g(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BezierBannerView);
        this.e = typedArrayObtainStyledAttributes.getColor(R$styleable.BezierBannerView_selectedColor, -1);
        this.f = typedArrayObtainStyledAttributes.getColor(R$styleable.BezierBannerView_unSelectedColor, -5592406);
        this.h = typedArrayObtainStyledAttributes.getDimension(R$styleable.BezierBannerView_selectedRaduis, this.h);
        this.j = typedArrayObtainStyledAttributes.getDimension(R$styleable.BezierBannerView_unSelectedRaduis, this.j);
        this.g = typedArrayObtainStyledAttributes.getDimension(R$styleable.BezierBannerView_spacing, this.g);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void h() {
        this.c.reset();
        this.d.reset();
        float interpolation = this.P.getInterpolation(this.y);
        this.n = d(b(this.z), b(this.z + 1) - this.h, this.H);
        float f = this.h;
        this.o = f;
        this.i = c(f, 0.0f, interpolation);
        double radians = Math.toRadians(d(45.0f, 0.0f, this.G));
        float fSin = (float) (Math.sin(radians) * ((double) this.i));
        float fCos = (float) (Math.cos(radians) * ((double) this.i));
        this.p = d(b(this.z) + this.h, b(this.z + 1), this.G);
        float f2 = this.h;
        this.f307q = f2;
        this.l = c(0.0f, f2, interpolation);
        double radians2 = Math.toRadians(d(0.0f, 45.0f, this.H));
        float fSin2 = (float) (Math.sin(radians2) * ((double) this.l));
        float fCos2 = (float) (Math.cos(radians2) * ((double) this.l));
        this.K = this.n + fSin;
        this.L = this.o - fCos;
        this.M = this.p - fSin2;
        this.N = this.h - fCos2;
        this.I = e(b(this.z) + this.h, b(this.z + 1) - this.h);
        this.J = this.h;
        this.c.moveTo(this.K, this.L);
        this.c.quadTo(this.I, this.J, this.M, this.N);
        this.c.lineTo(this.M, this.h + fCos2);
        this.c.quadTo(this.I, this.h, this.K, this.L + (fCos * 2.0f));
        this.c.lineTo(this.K, this.L);
        this.t = d(b(this.z + 1), b(this.z) + this.j, this.H);
        this.u = this.h;
        this.k = c(this.j, 0.0f, interpolation);
        double radians3 = Math.toRadians(d(45.0f, 0.0f, this.G));
        float fSin3 = (float) (Math.sin(radians3) * ((double) this.k));
        float fCos3 = (float) (Math.cos(radians3) * ((double) this.k));
        this.r = d(b(this.z + 1) - this.j, b(this.z), this.G);
        this.s = this.h;
        this.m = c(0.0f, this.j, interpolation);
        double radians4 = Math.toRadians(d(0.0f, 45.0f, this.H));
        float fSin4 = (float) (Math.sin(radians4) * ((double) this.m));
        float fCos4 = (float) (Math.cos(radians4) * ((double) this.m));
        float f3 = this.t - fSin3;
        float f4 = this.u - fCos3;
        float f5 = this.r + fSin4;
        float f6 = this.s - fCos4;
        float fE = e(b(this.z + 1) - this.j, b(this.z) + this.j);
        float f7 = this.h;
        this.d.moveTo(f3, f4);
        this.d.quadTo(fE, f7, f5, f6);
        this.d.lineTo(f5, this.h + fCos4);
        this.d.quadTo(fE, f7, f3, (fCos3 * 2.0f) + f4);
        this.d.lineTo(f3, f4);
    }

    private void i() {
        this.c.reset();
        this.d.reset();
        float interpolation = this.P.getInterpolation(this.y);
        this.n = d(b(this.z), b(this.z - 1) + this.h, this.H);
        float f = this.h;
        this.o = f;
        this.i = c(f, 0.0f, interpolation);
        double radians = Math.toRadians(d(45.0f, 0.0f, this.G));
        float fSin = (float) (Math.sin(radians) * ((double) this.i));
        float fCos = (float) (Math.cos(radians) * ((double) this.i));
        this.p = d(b(this.z) - this.h, b(this.z - 1), this.G);
        float f2 = this.h;
        this.f307q = f2;
        this.l = c(0.0f, f2, interpolation);
        double radians2 = Math.toRadians(d(0.0f, 45.0f, this.H));
        float fSin2 = (float) (Math.sin(radians2) * ((double) this.l));
        float fCos2 = (float) (Math.cos(radians2) * ((double) this.l));
        this.K = this.n - fSin;
        this.L = this.o - fCos;
        this.M = this.p + fSin2;
        this.N = this.h - fCos2;
        this.I = e(b(this.z) - this.h, b(this.z - 1) + this.h);
        this.J = this.h;
        this.c.moveTo(this.K, this.L);
        this.c.quadTo(this.I, this.J, this.M, this.N);
        this.c.lineTo(this.M, this.h + fCos2);
        this.c.quadTo(this.I, this.h, this.K, this.L + (fCos * 2.0f));
        this.c.lineTo(this.K, this.L);
        this.t = d(b(this.z - 1), b(this.z) - this.j, this.H);
        this.u = this.h;
        this.k = c(this.j, 0.0f, interpolation);
        double radians3 = Math.toRadians(d(45.0f, 0.0f, this.G));
        float fSin3 = (float) (Math.sin(radians3) * ((double) this.k));
        float fCos3 = (float) (Math.cos(radians3) * ((double) this.k));
        this.r = d(b(this.z - 1) + this.j, b(this.z), this.G);
        this.s = this.h;
        this.m = c(0.0f, this.j, interpolation);
        double radians4 = Math.toRadians(d(0.0f, 45.0f, this.H));
        float fSin4 = (float) (Math.sin(radians4) * ((double) this.m));
        float fCos4 = (float) (Math.cos(radians4) * ((double) this.m));
        float f3 = this.t + fSin3;
        float f4 = this.u - fCos3;
        float f5 = this.r - fSin4;
        float f6 = this.s - fCos4;
        float fE = e(b(this.z - 1) + this.j, b(this.z) - this.j);
        float f7 = this.h;
        this.d.moveTo(f3, f4);
        this.d.quadTo(fE, f7, f5, f6);
        this.d.lineTo(f5, this.h + fCos4);
        this.d.quadTo(fE, f7, f3, (fCos3 * 2.0f) + f4);
        this.d.lineTo(f3, f4);
    }

    public void a(ViewPager viewPager) {
        viewPager.c(this);
        this.F = viewPager.getAdapter().d();
        this.z = viewPager.getCurrentItem();
        h();
        this.O = R;
        invalidate();
    }

    public float c(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    public float d(float f, float f2, int i) {
        float f3;
        float f4;
        if (i == this.G) {
            f3 = f2 - f;
            f4 = this.w;
        } else {
            f3 = f2 - f;
            f4 = this.x;
        }
        return f + (f3 * f4);
    }

    public float e(float f, float f2) {
        return f + ((f2 - f) * this.y);
    }

    public void j() {
        this.w = 0.0f;
        this.x = 0.0f;
        this.y = 0.0f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        for (int i2 = 0; i2 < this.F; i2++) {
            int i3 = this.O;
            if (i3 == R) {
                int i4 = this.z;
                if (i2 != i4 && i2 != i4 + 1) {
                    canvas.drawCircle(b(i2), this.h, this.j, this.b);
                }
            } else if (i3 == Q && i2 != (i = this.z) && i2 != i - 1) {
                canvas.drawCircle(b(i2), this.h, this.j, this.b);
            }
        }
        canvas.drawCircle(this.r, this.s, this.m, this.b);
        canvas.drawCircle(this.t, this.u, this.k, this.b);
        canvas.drawPath(this.d, this.b);
        canvas.drawCircle(this.p, this.f307q, this.l, this.a);
        canvas.drawCircle(this.n, this.o, this.i, this.a);
        canvas.drawPath(this.c, this.a);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        float f = this.j;
        int i3 = this.F;
        int paddingLeft = (int) ((f * 2.0f * i3) + ((this.h - f) * 2.0f) + ((i3 - 1) * this.g) + getPaddingLeft() + getPaddingRight());
        int paddingTop = (int) ((this.h * 2.0f) + getPaddingTop() + getPaddingBottom());
        if (mode != 1073741824 && mode == Integer.MIN_VALUE) {
            size = Math.min(size, paddingLeft);
        }
        if (mode2 != 1073741824 && mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size2, paddingTop);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrolled(int i, float f, int i2) {
        if (f == 0.0f) {
            this.z = i;
            Log.d(S, "到达");
            j();
        }
        float f2 = i + f;
        int i3 = this.z;
        if (f2 - i3 > 0.0f) {
            this.O = R;
            if (f2 <= i3 + 1) {
                setProgress(f);
                return;
            } else {
                this.z = i;
                Log.d(S, "向左快速滑动");
                return;
            }
        }
        if (f2 - i3 < 0.0f) {
            this.O = Q;
            if (f2 >= i3 - 1) {
                setProgress(1.0f - f);
            } else {
                this.z = i;
                Log.d(S, "向右快速滑动");
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageSelected(int i) {
    }

    public void setDirection(int i) {
        this.O = i;
    }

    public void setProgress(float f) {
        if (f == 0.0f) {
            return;
        }
        this.y = f;
        if (f <= 0.5d) {
            this.w = f / 0.5f;
            this.x = 0.0f;
        } else {
            this.x = (f - 0.5f) / 0.5f;
            this.w = 1.0f;
        }
        if (this.O == R) {
            h();
        } else {
            i();
        }
        invalidate();
    }

    public BezierBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezierBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new Path();
        this.d = new Path();
        this.g = 80.0f;
        this.h = 30.0f;
        this.j = 20.0f;
        this.v = false;
        this.w = 0.0f;
        this.x = 0.0f;
        this.z = 0;
        this.G = 1;
        this.H = 2;
        this.P = new AccelerateDecelerateInterpolator();
        g(attributeSet);
        f();
    }
}
