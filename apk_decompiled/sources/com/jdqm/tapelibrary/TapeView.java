package com.jdqm.tapelibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import defpackage.nc0;

/* JADX INFO: loaded from: classes3.dex */
public class TapeView extends View {
    private VelocityTracker F;
    private a G;
    private Context H;
    private int a;
    private int b;
    private int c;
    private int d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private int k;
    private int l;
    private float m;
    private float n;
    private float o;
    private float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f280q;
    private float r;
    private float s;
    private float t;
    private int u;
    private float v;
    private float w;
    private Scroller x;
    private float y;
    private Paint z;

    public interface a {
        void a(float f);
    }

    public TapeView(Context context) {
        super(context, null);
        this.a = Color.parseColor("#FBE40C");
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = 14.0f;
        this.g = 1.0f;
        this.h = 20.0f;
        this.i = 35.0f;
        this.j = 18.0f;
        this.m = 0.0f;
        this.n = 100.0f;
        this.o = 0.0f;
        this.p = 1.0f;
        this.f280q = 10;
        this.t = 10.0f;
    }

    private void a() {
        j(this.m, this.o, this.n);
        this.f = this.i + nc0.a(30.0f, this.H);
        float f = this.o;
        float f2 = this.m;
        float f3 = this.p;
        float f4 = this.t;
        this.r = (((f - f2) * 10.0f) / f3) * f4;
        float f5 = this.n;
        this.s = (((f5 - f2) * 10.0f) / f3) * f4;
        this.u = (int) ((((f5 - f2) * 10.0f) / f3) + 1.0f);
    }

    private void b() {
        this.F.computeCurrentVelocity(1000);
        float xVelocity = this.F.getXVelocity();
        Log.d("TapeView", "xVelocity: " + xVelocity);
        if (Math.abs(xVelocity) > this.w) {
            this.x.fling(0, 0, (int) xVelocity, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            invalidate();
        }
    }

    private void c(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        int i = this.l;
        float f5 = this.r;
        int i2 = (int) (i - f5);
        int i3 = i2 < 0 ? (int) ((-i2) / this.t) : 0;
        float f6 = (i - f5) + (i3 * this.t);
        while (f6 < this.k * 10 && i3 < this.u) {
            if (f6 == 0.0f) {
                i3++;
                f2 = this.l - this.r;
                f3 = i3;
                f4 = this.t;
            } else {
                if (i3 % this.f280q == 0) {
                    this.z.setStrokeWidth(this.g * 2.0f);
                    f = this.i;
                    String strValueOf = String.valueOf(this.m + ((i3 * this.p) / 10.0f));
                    if (strValueOf.endsWith(".0")) {
                        strValueOf = strValueOf.substring(0, strValueOf.length() - 2);
                    }
                    this.z.setColor(this.c);
                    canvas.drawText(strValueOf, f6 - (this.z.measureText(strValueOf) / 2.0f), this.f, this.z);
                } else {
                    this.z.setStrokeWidth(this.g);
                    f = this.h;
                }
                float f7 = f;
                this.z.setColor(this.b);
                canvas.drawLine(f6, 0.0f, f6, f7, this.z);
                i3++;
                f2 = this.l - this.r;
                f3 = i3;
                f4 = this.t;
            }
            f6 = f2 + (f3 * f4);
        }
    }

    private void d(Canvas canvas) {
        this.z.setColor(this.d);
        Path path = new Path();
        path.moveTo((getWidth() / 2) - (this.j / 2.0f), 0.0f);
        path.lineTo(getWidth() / 2, this.j / 2.0f);
        path.lineTo((getWidth() / 2) + (this.j / 2.0f), 0.0f);
        path.close();
        canvas.drawPath(path, this.z);
    }

    private void e(Context context) {
        this.w = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.x = new Scroller(context);
        Paint paint = new Paint(1);
        this.z = paint;
        paint.setTextSize(this.e);
    }

    private void f(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TapeView);
        this.a = typedArrayObtainStyledAttributes.getColor(R$styleable.TapeView_bgColor, this.a);
        this.b = typedArrayObtainStyledAttributes.getColor(R$styleable.TapeView_calibrationColor, this.b);
        this.g = typedArrayObtainStyledAttributes.getDimension(R$styleable.TapeView_calibrationWidth, nc0.a(this.g, context));
        this.i = typedArrayObtainStyledAttributes.getDimension(R$styleable.TapeView_calibrationLong, nc0.a(this.i, context));
        this.h = typedArrayObtainStyledAttributes.getDimension(R$styleable.TapeView_calibrationShort, nc0.a(this.h, context));
        this.d = typedArrayObtainStyledAttributes.getColor(R$styleable.TapeView_triangleColor, this.d);
        this.j = typedArrayObtainStyledAttributes.getDimension(R$styleable.TapeView_triangleHeight, nc0.a(this.j, context));
        this.c = typedArrayObtainStyledAttributes.getColor(R$styleable.TapeView_textColor, this.c);
        this.e = typedArrayObtainStyledAttributes.getDimension(R$styleable.TapeView_textSize, nc0.b(this.e, context));
        this.p = typedArrayObtainStyledAttributes.getFloat(R$styleable.TapeView_per, this.p) * 10.0f;
        this.f280q = typedArrayObtainStyledAttributes.getInt(R$styleable.TapeView_perCount, this.f280q);
        this.t = typedArrayObtainStyledAttributes.getDimension(R$styleable.TapeView_gapWidth, nc0.a(this.t, context));
        this.m = typedArrayObtainStyledAttributes.getFloat(R$styleable.TapeView_tpminValue, this.m);
        this.n = typedArrayObtainStyledAttributes.getFloat(R$styleable.TapeView_tpmaxValue, this.n);
        this.o = typedArrayObtainStyledAttributes.getFloat(R$styleable.TapeView_value, this.o);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void h() {
        float f = this.r + this.y;
        this.r = f;
        if (f < 0.0f) {
            this.r = 0.0f;
        } else {
            float f2 = this.s;
            if (f > f2) {
                this.r = f2;
            }
        }
        this.v = 0.0f;
        this.y = 0.0f;
        float f3 = this.m;
        float fRound = Math.round(Math.abs(this.r) / this.t);
        float f4 = this.p;
        float f5 = f3 + ((fRound * f4) / 10.0f);
        this.o = f5;
        this.r = (((f5 - this.m) * 10.0f) / f4) * this.t;
        a aVar = this.G;
        if (aVar != null) {
            aVar.a(f5);
        }
        postInvalidate();
    }

    private void i() {
        float f = this.r + this.y;
        this.r = f;
        if (f < 0.0f) {
            this.r = 0.0f;
            this.y = 0.0f;
            this.x.forceFinished(true);
        } else {
            float f2 = this.s;
            if (f > f2) {
                this.r = f2;
                this.y = 0.0f;
                this.x.forceFinished(true);
            }
        }
        float fRound = this.m + ((Math.round(Math.abs(this.r) / this.t) * this.p) / 10.0f);
        this.o = fRound;
        a aVar = this.G;
        if (aVar != null) {
            aVar.a(fRound);
        }
        postInvalidate();
    }

    private void j(float f, float f2, float f3) {
        if (f > f3) {
            this.m = f3;
        }
        if (f2 < f) {
            this.o = f;
        }
        if (f2 > f3) {
            this.o = f3;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.x.computeScrollOffset()) {
            if (this.x.getCurrX() == this.x.getFinalX()) {
                h();
                return;
            }
            float currX = this.x.getCurrX();
            this.y = this.v - currX;
            i();
            this.v = currX;
        }
    }

    public void g(float f, float f2, float f3, float f4, int i) {
        this.o = f;
        this.m = f2;
        this.n = f3;
        this.p = f4 * 10.0f;
        this.f280q = i;
        a();
        invalidate();
    }

    public float getValue() {
        return this.o;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.a);
        c(canvas);
        d(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        this.k = size;
        this.l = size / 2;
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) nc0.a(80.0f, this.H), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.F == null) {
            this.F = VelocityTracker.obtain();
        }
        this.F.addMovement(motionEvent);
        float x = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.x.forceFinished(true);
            this.v = x;
            this.y = 0.0f;
        } else {
            if (action == 1) {
                h();
                b();
                return false;
            }
            if (action != 2) {
                return false;
            }
            Log.d("TapeView", "onTouchEvent: " + x);
            this.y = this.v - x;
            i();
        }
        this.v = x;
        return true;
    }

    public void setOnValueChangeListener(a aVar) {
        this.G = aVar;
    }

    public TapeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TapeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = Color.parseColor("#FBE40C");
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = 14.0f;
        this.g = 1.0f;
        this.h = 20.0f;
        this.i = 35.0f;
        this.j = 18.0f;
        this.m = 0.0f;
        this.n = 100.0f;
        this.o = 0.0f;
        this.p = 1.0f;
        this.f280q = 10;
        this.t = 10.0f;
        this.H = context;
        f(context, attributeSet);
        e(context);
        a();
    }
}
