package com.yalantis.ucrop.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import com.luck.picture.lib.R$color;
import com.luck.picture.lib.R$dimen;
import com.luck.picture.lib.R$styleable;
import defpackage.fe2;
import defpackage.ky1;

/* JADX INFO: loaded from: classes3.dex */
public class OverlayView extends View {
    private final int F;
    private int G;
    private boolean H;
    private boolean I;
    private ValueAnimator J;
    private ky1 K;
    private boolean L;
    private final RectF a;
    private final RectF b;
    protected int c;
    protected int d;
    protected float[] e;
    protected float[] f;
    private int g;
    private int h;
    private float i;
    private float[] j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private final Path p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Paint f317q;
    private final Paint r;
    private final Paint s;
    private final Paint t;
    private int u;
    private float v;
    private float w;
    private int x;
    private final int y;
    private final int z;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (OverlayView.this.K != null) {
                OverlayView.this.K.b(OverlayView.this.a);
            }
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        float a = 0.0f;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ RectF d;

        b(int i, int i2, RectF rectF) {
            this.b = i;
            this.c = i2;
            this.d = rectF;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = this.b * ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float fFloatValue2 = this.c * ((Float) valueAnimator.getAnimatedValue()).floatValue();
            RectF rectF = OverlayView.this.a;
            RectF rectF2 = this.d;
            rectF.set(new RectF(rectF2.left + fFloatValue, rectF2.top + fFloatValue2, rectF2.right + fFloatValue, rectF2.bottom + fFloatValue2));
            OverlayView.this.n();
            OverlayView.this.postInvalidate();
            if (OverlayView.this.K != null) {
                OverlayView.this.K.a(this.b * (((Float) valueAnimator.getAnimatedValue()).floatValue() - this.a), this.c * (((Float) valueAnimator.getAnimatedValue()).floatValue() - this.a));
            }
            this.a = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        }
    }

    public OverlayView(Context context) {
        this(context, null);
    }

    private int f(float f, float f2) {
        double d = this.y;
        int i = -1;
        for (int i2 = 0; i2 < 8; i2 += 2) {
            double dSqrt = Math.sqrt(Math.pow(f - this.e[i2], 2.0d) + Math.pow(f2 - this.e[i2 + 1], 2.0d));
            if (dSqrt < d) {
                i = i2 / 2;
                d = dSqrt;
            }
        }
        if (this.u == 1 && i < 0 && this.a.contains(f, f2)) {
            return 4;
        }
        return i;
    }

    private void h(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R$styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(R$dimen.ucrop_default_crop_frame_stoke_width));
        int color = typedArray.getColor(R$styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(R$color.ucrop_color_default_crop_frame));
        this.s.setStrokeWidth(dimensionPixelSize);
        this.s.setColor(color);
        Paint paint = this.s;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.t.setStrokeWidth(dimensionPixelSize * 3);
        this.t.setColor(color);
        this.t.setStyle(style);
    }

    private void i(TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R$styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(R$dimen.ucrop_default_crop_grid_stoke_width));
        int color = typedArray.getColor(R$styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(R$color.ucrop_color_default_crop_grid));
        this.r.setStrokeWidth(dimensionPixelSize);
        this.r.setColor(color);
        this.g = typedArray.getInt(R$styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.h = typedArray.getInt(R$styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    private void l() {
        Point point = new Point((getRight() + getLeft()) / 2, (getTop() + getBottom()) / 2);
        int iCenterY = (int) (point.y - this.a.centerY());
        int iCenterX = (int) (point.x - this.a.centerX());
        RectF rectF = new RectF(this.a);
        new RectF(this.a).offset(iCenterX, iCenterY);
        ValueAnimator valueAnimator = this.J;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.J = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1000L);
        this.J.setInterpolator(new OvershootInterpolator(1.0f));
        this.J.addListener(new a());
        this.J.addUpdateListener(new b(iCenterX, iCenterY, rectF));
        this.J.start();
    }

    private void m(float f, float f2) {
        this.b.set(this.a);
        int i = this.x;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            this.b.offset(f - this.v, f2 - this.w);
                            if (this.b.left <= getLeft() || this.b.top <= getTop() || this.b.right >= getRight() || this.b.bottom >= getBottom()) {
                                return;
                            }
                            this.a.set(this.b);
                            n();
                            postInvalidate();
                            return;
                        }
                    } else if (this.H) {
                        RectF rectF = this.b;
                        RectF rectF2 = this.a;
                        rectF.set(f, rectF2.top, rectF2.right, f2);
                    }
                } else if (this.H) {
                    RectF rectF3 = this.b;
                    RectF rectF4 = this.a;
                    rectF3.set(rectF4.left, rectF4.top, f, f2);
                }
            } else if (this.H) {
                RectF rectF5 = this.b;
                RectF rectF6 = this.a;
                rectF5.set(rectF6.left, f2, f, rectF6.bottom);
            }
        } else if (this.H) {
            RectF rectF7 = this.b;
            RectF rectF8 = this.a;
            rectF7.set(f, f2, rectF8.right, rectF8.bottom);
        }
        boolean z = this.b.height() >= ((float) this.z);
        boolean z2 = this.b.width() >= ((float) this.z);
        RectF rectF9 = this.a;
        rectF9.set(z2 ? this.b.left : rectF9.left, z ? this.b.top : rectF9.top, z2 ? this.b.right : rectF9.right, z ? this.b.bottom : rectF9.bottom);
        if (z || z2) {
            n();
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.e = fe2.b(this.a);
        this.f = fe2.a(this.a);
        this.j = null;
        this.p.reset();
        this.p.addCircle(this.a.centerX(), this.a.centerY(), Math.min(this.a.width(), this.a.height()) / 2.0f, Path.Direction.CW);
    }

    protected void d(Canvas canvas) {
        if (this.l) {
            if (this.j == null && !this.a.isEmpty()) {
                this.j = new float[(this.g * 4) + (this.h * 4)];
                int i = 0;
                for (int i2 = 0; i2 < this.g; i2++) {
                    float[] fArr = this.j;
                    RectF rectF = this.a;
                    fArr[i] = rectF.left;
                    float f = i2 + 1.0f;
                    float fHeight = rectF.height() * (f / (this.g + 1));
                    RectF rectF2 = this.a;
                    fArr[i + 1] = fHeight + rectF2.top;
                    float[] fArr2 = this.j;
                    int i3 = i + 3;
                    fArr2[i + 2] = rectF2.right;
                    i += 4;
                    fArr2[i3] = (rectF2.height() * (f / (this.g + 1))) + this.a.top;
                }
                for (int i4 = 0; i4 < this.h; i4++) {
                    float[] fArr3 = this.j;
                    float f2 = i4 + 1.0f;
                    float fWidth = this.a.width() * (f2 / (this.h + 1));
                    RectF rectF3 = this.a;
                    fArr3[i] = fWidth + rectF3.left;
                    float[] fArr4 = this.j;
                    fArr4[i + 1] = rectF3.top;
                    int i5 = i + 3;
                    float fWidth2 = rectF3.width() * (f2 / (this.h + 1));
                    RectF rectF4 = this.a;
                    fArr4[i + 2] = fWidth2 + rectF4.left;
                    i += 4;
                    this.j[i5] = rectF4.bottom;
                }
            }
            float[] fArr5 = this.j;
            if (fArr5 != null) {
                canvas.drawLines(fArr5, this.r);
            }
        }
        if (this.k) {
            canvas.drawRect(this.a, this.s);
        }
        if (this.u != 0) {
            canvas.save();
            this.b.set(this.a);
            RectF rectF5 = this.b;
            int i6 = this.F;
            rectF5.inset(i6, -i6);
            RectF rectF6 = this.b;
            Region.Op op = Region.Op.DIFFERENCE;
            canvas.clipRect(rectF6, op);
            this.b.set(this.a);
            RectF rectF7 = this.b;
            int i7 = this.F;
            rectF7.inset(-i7, i7);
            canvas.clipRect(this.b, op);
            canvas.drawRect(this.a, this.t);
            canvas.restore();
        }
    }

    protected void e(Canvas canvas) {
        canvas.save();
        if (this.m) {
            canvas.clipPath(this.p, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.a, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.n);
        canvas.restore();
        if (this.m) {
            canvas.drawCircle(this.a.centerX(), this.a.centerY(), Math.min(this.a.width(), this.a.height()) / 2.0f, this.f317q);
        }
    }

    protected void g() {
    }

    public RectF getCropViewRect() {
        return this.a;
    }

    public int getFreestyleCropMode() {
        return this.u;
    }

    public ky1 getOverlayViewChangeListener() {
        return this.K;
    }

    protected void j(TypedArray typedArray) {
        this.m = typedArray.getBoolean(R$styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        this.n = typedArray.getColor(R$styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(R$color.ucrop_color_default_dimmed));
        this.f317q.setColor(this.o);
        this.f317q.setStyle(Paint.Style.STROKE);
        this.f317q.setStrokeWidth(this.G);
        h(typedArray);
        this.k = typedArray.getBoolean(R$styleable.ucrop_UCropView_ucrop_show_frame, true);
        i(typedArray);
        this.l = typedArray.getBoolean(R$styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    public void k() {
        int i = this.c;
        float f = this.i;
        int i2 = (int) (i / f);
        int i3 = this.d;
        if (i2 > i3) {
            int i4 = (int) (i3 * f);
            int i5 = (i - i4) / 2;
            this.a.set(getPaddingLeft() + i5, getPaddingTop(), getPaddingLeft() + i4 + i5, getPaddingTop() + this.d);
        } else {
            int i6 = (i3 - i2) / 2;
            this.a.set(getPaddingLeft(), getPaddingTop() + i6, getPaddingLeft() + this.c, getPaddingTop() + i2 + i6);
        }
        ky1 ky1Var = this.K;
        if (ky1Var != null) {
            ky1Var.b(this.a);
        }
        n();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        e(canvas);
        d(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.c = width - paddingLeft;
            this.d = height - paddingTop;
            if (this.L) {
                this.L = false;
                setTargetAspectRatio(this.i);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.a.isEmpty() && this.u != 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if ((motionEvent.getAction() & 255) == 0) {
                ValueAnimator valueAnimator = this.J;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                int iF = f(x, y);
                this.x = iF;
                if (iF != -1 && iF != 4) {
                    z = true;
                }
                if (!z) {
                    this.v = -1.0f;
                    this.w = -1.0f;
                } else if (this.v < 0.0f) {
                    this.v = x;
                    this.w = y;
                }
                return z;
            }
            if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.x != -1) {
                float fMin = Math.min(Math.max(x, getPaddingLeft()), getWidth() - getPaddingRight());
                float fMin2 = Math.min(Math.max(y, getPaddingTop()), getHeight() - getPaddingBottom());
                m(fMin, fMin2);
                this.v = fMin;
                this.w = fMin2;
                return true;
            }
            if ((motionEvent.getAction() & 255) == 1) {
                this.v = -1.0f;
                this.w = -1.0f;
                this.x = -1;
                ky1 ky1Var = this.K;
                if (ky1Var != null) {
                    ky1Var.b(this.a);
                }
                if (this.I) {
                    l();
                }
            }
        }
        return false;
    }

    public void setCircleDimmedLayer(boolean z) {
        this.m = z;
    }

    public void setCropFrameColor(int i) {
        this.s.setColor(i);
    }

    public void setCropFrameStrokeWidth(int i) {
        this.s.setStrokeWidth(i);
    }

    public void setCropGridColor(int i) {
        this.r.setColor(i);
    }

    public void setCropGridColumnCount(int i) {
        this.h = i;
        this.j = null;
    }

    public void setCropGridRowCount(int i) {
        this.g = i;
        this.j = null;
    }

    public void setCropGridStrokeWidth(int i) {
        this.r.setStrokeWidth(i);
    }

    public void setDimmedBorderColor(int i) {
        this.o = i;
        Paint paint = this.f317q;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public void setDimmedColor(int i) {
        this.n = i;
    }

    public void setDimmedStrokeWidth(int i) {
        this.G = i;
        Paint paint = this.f317q;
        if (paint != null) {
            paint.setStrokeWidth(i);
        }
    }

    public void setDragFrame(boolean z) {
        this.H = z;
    }

    public void setDragSmoothToCenter(boolean z) {
        this.I = z;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean z) {
        this.u = z ? 1 : 0;
    }

    public void setFreestyleCropMode(int i) {
        this.u = i;
        postInvalidate();
    }

    public void setOverlayViewChangeListener(ky1 ky1Var) {
        this.K = ky1Var;
    }

    public void setShowCropFrame(boolean z) {
        this.k = z;
    }

    public void setShowCropGrid(boolean z) {
        this.l = z;
    }

    public void setTargetAspectRatio(float f) {
        this.i = f;
        if (this.c <= 0) {
            this.L = true;
        } else {
            k();
            postInvalidate();
        }
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new RectF();
        this.b = new RectF();
        this.j = null;
        this.p = new Path();
        this.f317q = new Paint(1);
        this.r = new Paint(1);
        this.s = new Paint(1);
        this.t = new Paint(1);
        this.u = 0;
        this.v = -1.0f;
        this.w = -1.0f;
        this.x = -1;
        this.G = 1;
        this.H = true;
        this.y = getResources().getDimensionPixelSize(R$dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.z = getResources().getDimensionPixelSize(R$dimen.ucrop_default_crop_rect_min_size);
        this.F = getResources().getDimensionPixelSize(R$dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        g();
    }
}
