package com.zcw.togglebutton;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;

/* JADX INFO: loaded from: classes.dex */
public class ToggleButton extends View {
    private SpringSystem a;
    private Spring b;
    private float c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private Paint i;
    private boolean j;
    private int k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f321q;
    private float r;
    private float s;
    private RectF t;
    private boolean u;
    private boolean v;
    SimpleSpringListener w;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToggleButton toggleButton = ToggleButton.this;
            toggleButton.f(toggleButton.u);
        }
    }

    class b extends SimpleSpringListener {
        b() {
        }
    }

    public interface c {
    }

    public ToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = Color.parseColor("#4ebb7f");
        this.e = Color.parseColor("#dadbda");
        this.f = Color.parseColor("#ffffff");
        this.g = Color.parseColor("#ffffff");
        this.h = this.e;
        this.j = false;
        this.k = 2;
        this.t = new RectF();
        this.u = true;
        this.v = false;
        this.w = new b();
        setup(attributeSet);
    }

    private void b(double d) {
        this.r = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.o, this.p);
        double d2 = 1.0d - d;
        this.s = (float) SpringUtil.mapValueFromRangeToRange(d2, 0.0d, 1.0d, 10.0d, this.f321q);
        int iBlue = Color.blue(this.d);
        int iRed = Color.red(this.d);
        int iGreen = Color.green(this.d);
        int iBlue2 = Color.blue(this.e);
        int iRed2 = Color.red(this.e);
        int iGreen2 = Color.green(this.e);
        int iMapValueFromRangeToRange = (int) SpringUtil.mapValueFromRangeToRange(d2, 0.0d, 1.0d, iBlue, iBlue2);
        this.h = Color.rgb(c((int) SpringUtil.mapValueFromRangeToRange(d2, 0.0d, 1.0d, iRed, iRed2), 0, 255), c((int) SpringUtil.mapValueFromRangeToRange(d2, 0.0d, 1.0d, iGreen, iGreen2), 0, 255), c(iMapValueFromRangeToRange, 0, 255));
        postInvalidate();
    }

    private int c(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private void e(boolean z) {
        if (z) {
            this.b.setEndValue(this.j ? 1.0d : 0.0d);
        } else {
            this.b.setCurrentValue(this.j ? 1.0d : 0.0d);
            b(this.j ? 1.0d : 0.0d);
        }
    }

    public void d() {
        setToggleOn(true);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.t.set(0.0f, 0.0f, getWidth(), getHeight());
        this.i.setColor(this.h);
        RectF rectF = this.t;
        float f = this.c;
        canvas.drawRoundRect(rectF, f, f, this.i);
        float f2 = this.s;
        if (f2 > 0.0f) {
            float f3 = f2 * 0.5f;
            RectF rectF2 = this.t;
            float f4 = this.r - f3;
            float f5 = this.l;
            rectF2.set(f4, f5 - f3, this.n + f3, f5 + f3);
            this.i.setColor(this.f);
            canvas.drawRoundRect(this.t, f3, f3, this.i);
        }
        RectF rectF3 = this.t;
        float f6 = this.r;
        float f7 = this.c;
        float f8 = this.l;
        rectF3.set((f6 - 1.0f) - f7, f8 - f7, f6 + 1.1f + f7, f8 + f7);
        this.i.setColor(this.h);
        RectF rectF4 = this.t;
        float f9 = this.c;
        canvas.drawRoundRect(rectF4, f9, f9, this.i);
        float f10 = this.f321q * 0.5f;
        RectF rectF5 = this.t;
        float f11 = this.r;
        float f12 = this.l;
        rectF5.set(f11 - f10, f12 - f10, f11 + f10, f12 + f10);
        this.i.setColor(this.g);
        canvas.drawRoundRect(this.t, f10, f10, this.i);
    }

    public void f(boolean z) {
        this.j = !this.j;
        e(z);
    }

    public void g() {
        d();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.addListener(this.w);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.removeListener(this.w);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int width = getWidth();
        int height = getHeight();
        float fMin = Math.min(width, height) * 0.5f;
        this.c = fMin;
        this.l = fMin;
        this.m = fMin;
        float f = width - fMin;
        this.n = f;
        int i5 = this.k;
        float f2 = fMin + i5;
        this.o = f2;
        float f3 = f - i5;
        this.p = f3;
        this.f321q = height - (i5 * 4);
        if (this.j) {
            f2 = f3;
        }
        this.r = f2;
        this.s = 0.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        Resources system = Resources.getSystem();
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, 50.0f, system.getDisplayMetrics()), 1073741824);
        }
        if (mode2 == 0 || size == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, 30.0f, system.getDisplayMetrics()), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setAnimate(boolean z) {
        this.u = z;
    }

    public void setOnToggleChanged(c cVar) {
    }

    public void setToggleOff(boolean z) {
        this.j = false;
        e(z);
    }

    public void setToggleOn(boolean z) {
        this.j = true;
        e(z);
    }

    public void setup(AttributeSet attributeSet) {
        Paint paint = new Paint(1);
        this.i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.i.setStrokeCap(Paint.Cap.ROUND);
        SpringSystem springSystemCreate = SpringSystem.create();
        this.a = springSystemCreate;
        Spring springCreateSpring = springSystemCreate.createSpring();
        this.b = springCreateSpring;
        springCreateSpring.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new a());
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ToggleButton);
        this.e = typedArrayObtainStyledAttributes.getColor(R$styleable.ToggleButton_tbOffBorderColor, this.e);
        this.d = typedArrayObtainStyledAttributes.getColor(R$styleable.ToggleButton_tbOnColor, this.d);
        this.g = typedArrayObtainStyledAttributes.getColor(R$styleable.ToggleButton_tbSpotColor, this.g);
        this.f = typedArrayObtainStyledAttributes.getColor(R$styleable.ToggleButton_tbOffColor, this.f);
        this.k = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ToggleButton_tbBorderWidth, this.k);
        this.u = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ToggleButton_tbAnimate, this.u);
        this.v = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ToggleButton_tbAsDefaultOn, this.v);
        typedArrayObtainStyledAttributes.recycle();
        this.h = this.e;
        if (this.v) {
            g();
        }
    }

    public ToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = Color.parseColor("#4ebb7f");
        this.e = Color.parseColor("#dadbda");
        this.f = Color.parseColor("#ffffff");
        this.g = Color.parseColor("#ffffff");
        this.h = this.e;
        this.j = false;
        this.k = 2;
        this.t = new RectF();
        this.u = true;
        this.v = false;
        this.w = new b();
        setup(attributeSet);
    }
}
