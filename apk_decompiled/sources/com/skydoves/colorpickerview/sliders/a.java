package com.skydoves.colorpickerview.sliders;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.skydoves.colorpickerview.ActionMode;
import com.skydoves.colorpickerview.ColorPickerView;
import defpackage.bh2;
import defpackage.q30;

/* JADX INFO: loaded from: classes.dex */
abstract class a extends FrameLayout {
    public ColorPickerView a;
    protected Paint b;
    protected Paint c;
    protected float d;
    protected int e;
    protected Drawable f;
    protected int g;
    protected int h;
    protected int i;
    protected ImageView j;
    protected String k;

    /* JADX INFO: renamed from: com.skydoves.colorpickerview.sliders.a$a, reason: collision with other inner class name */
    class ViewTreeObserverOnGlobalLayoutListenerC0102a implements ViewTreeObserver.OnGlobalLayoutListener {
        ViewTreeObserverOnGlobalLayoutListenerC0102a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            a.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            a.this.g();
        }
    }

    public a(Context context) {
        super(context);
        this.d = 1.0f;
        this.e = 0;
        this.g = 2;
        this.h = -16777216;
        this.i = -1;
        f();
    }

    private float c(float f) {
        float measuredWidth = getMeasuredWidth() - this.j.getMeasuredWidth();
        if (f >= measuredWidth) {
            return measuredWidth;
        }
        if (f <= getSelectorHalfSize()) {
            return 0.0f;
        }
        return f - getSelectorHalfSize();
    }

    private void d() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0102a());
    }

    private void f() {
        this.b = new Paint(1);
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.g);
        this.c.setColor(this.h);
        setBackgroundColor(-1);
        this.j = new ImageView(getContext());
        Drawable drawable = this.f;
        if (drawable != null) {
            setSelectorDrawable(drawable);
        }
        d();
    }

    private void h(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float measuredWidth = this.j.getMeasuredWidth();
        float measuredWidth2 = getMeasuredWidth() - this.j.getMeasuredWidth();
        if (x < measuredWidth) {
            x = measuredWidth;
        }
        if (x > measuredWidth2) {
            x = measuredWidth2;
        }
        float f = (x - measuredWidth) / (measuredWidth2 - measuredWidth);
        this.d = f;
        if (f > 1.0f) {
            this.d = 1.0f;
        }
        int iC = (int) c(new Point((int) motionEvent.getX(), (int) motionEvent.getY()).x);
        this.e = iC;
        this.j.setX(iC);
        if (this.a.getActionMode() != ActionMode.LAST || motionEvent.getAction() == 1) {
            this.a.f(a(), true);
        }
        if (this.a.getFlagView() != null) {
            this.a.getFlagView().e(motionEvent);
        }
        float measuredWidth3 = getMeasuredWidth() - this.j.getMeasuredWidth();
        if (this.j.getX() >= measuredWidth3) {
            this.j.setX(measuredWidth3);
        }
        if (this.j.getX() <= 0.0f) {
            this.j.setX(0.0f);
        }
    }

    public abstract int a();

    protected abstract void b(AttributeSet attributeSet);

    public void e() {
        this.i = this.a.getPureColor();
        i(this.b);
        invalidate();
    }

    public abstract void g();

    protected int getBorderHalfSize() {
        return (int) (this.g * 0.5f);
    }

    public int getColor() {
        return this.i;
    }

    public String getPreferenceName() {
        return this.k;
    }

    public int getSelectedX() {
        return this.e;
    }

    protected int getSelectorHalfSize() {
        return this.j.getMeasuredWidth();
    }

    protected float getSelectorPosition() {
        return this.d;
    }

    protected abstract void i(Paint paint);

    public void j(int i) {
        float measuredWidth = this.j.getMeasuredWidth();
        float f = i;
        float measuredWidth2 = (f - measuredWidth) / ((getMeasuredWidth() - this.j.getMeasuredWidth()) - measuredWidth);
        this.d = measuredWidth2;
        if (measuredWidth2 > 1.0f) {
            this.d = 1.0f;
        }
        int iC = (int) c(f);
        this.e = iC;
        this.j.setX(iC);
        this.a.f(a(), false);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        canvas.drawRect(0.0f, 0.0f, measuredWidth, measuredHeight, this.b);
        canvas.drawRect(0.0f, 0.0f, measuredWidth, measuredHeight, this.c);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || this.a == null) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 1 && actionMasked != 2) {
            this.j.setPressed(false);
            return false;
        }
        this.j.setPressed(true);
        h(motionEvent);
        return true;
    }

    public void setBorderColor(int i) {
        this.h = i;
        this.c.setColor(i);
        invalidate();
    }

    public void setBorderColorRes(int i) {
        setBorderColor(q30.c(getContext(), i));
    }

    public void setBorderSize(int i) {
        this.g = i;
        this.c.setStrokeWidth(i);
        invalidate();
    }

    public void setBorderSizeRes(int i) {
        setBorderSize((int) getContext().getResources().getDimension(i));
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.j.setVisibility(z ? 0 : 4);
        setClickable(z);
    }

    public void setPreferenceName(String str) {
        this.k = str;
    }

    public void setSelectorDrawable(Drawable drawable) {
        removeView(this.j);
        this.f = drawable;
        this.j.setImageDrawable(drawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(this.j, layoutParams);
    }

    public void setSelectorDrawableRes(int i) {
        setSelectorDrawable(bh2.e(getContext().getResources(), i, null));
    }

    public void setSelectorPosition(float f) {
        this.d = Math.min(f, 1.0f);
        int iC = (int) c(((getMeasuredWidth() * f) - getSelectorHalfSize()) - getBorderHalfSize());
        this.e = iC;
        this.j.setX(iC);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 1.0f;
        this.e = 0;
        this.g = 2;
        this.h = -16777216;
        this.i = -1;
        b(attributeSet);
        f();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 1.0f;
        this.e = 0;
        this.g = 2;
        this.h = -16777216;
        this.i = -1;
        b(attributeSet);
        f();
    }
}
