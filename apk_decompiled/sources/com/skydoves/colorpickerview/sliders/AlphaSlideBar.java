package com.skydoves.colorpickerview.sliders;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.skydoves.colorpickerview.R$styleable;
import defpackage.kz;
import defpackage.n5;
import defpackage.v8;

/* JADX INFO: loaded from: classes.dex */
public class AlphaSlideBar extends a {
    private Bitmap l;
    private n5 m;

    public AlphaSlideBar(Context context) {
        super(context);
        this.m = new n5();
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public int a() {
        float[] fArr = new float[3];
        Color.colorToHSV(getColor(), fArr);
        return Color.HSVToColor((int) (this.d * 255.0f), fArr);
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    protected void b(AttributeSet attributeSet) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.AlphaSlideBar);
        try {
            int i = R$styleable.AlphaSlideBar_selector_AlphaSlideBar;
            if (typedArrayObtainStyledAttributes.hasValue(i) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i, -1)) != -1) {
                this.f = v8.b(getContext(), resourceId);
            }
            int i2 = R$styleable.AlphaSlideBar_borderColor_AlphaSlideBar;
            if (typedArrayObtainStyledAttributes.hasValue(i2)) {
                this.h = typedArrayObtainStyledAttributes.getColor(i2, this.h);
            }
            int i3 = R$styleable.AlphaSlideBar_borderSize_AlphaSlideBar;
            if (typedArrayObtainStyledAttributes.hasValue(i3)) {
                this.g = typedArrayObtainStyledAttributes.getInt(i3, this.g);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public void g() {
        int measuredWidth = getMeasuredWidth();
        if (getPreferenceName() != null) {
            j(kz.g(getContext()).b(getPreferenceName(), measuredWidth) + getSelectorHalfSize());
        } else {
            this.j.setX(measuredWidth);
        }
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public /* bridge */ /* synthetic */ int getColor() {
        return super.getColor();
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public /* bridge */ /* synthetic */ String getPreferenceName() {
        return super.getPreferenceName();
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public /* bridge */ /* synthetic */ int getSelectedX() {
        return super.getSelectedX();
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public void i(Paint paint) {
        float[] fArr = new float[3];
        Color.colorToHSV(getColor(), fArr);
        paint.setShader(new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), Color.HSVToColor(0, fArr), Color.HSVToColor(255, fArr), Shader.TileMode.CLAMP));
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public /* bridge */ /* synthetic */ void j(int i) {
        super.j(i);
    }

    @Override // com.skydoves.colorpickerview.sliders.a, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.l, 0.0f, 0.0f, (Paint) null);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.l = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.l);
        this.m.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        this.m.draw(canvas);
    }

    @Override // com.skydoves.colorpickerview.sliders.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public /* bridge */ /* synthetic */ void setBorderColor(int i) {
        super.setBorderColor(i);
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public /* bridge */ /* synthetic */ void setBorderColorRes(int i) {
        super.setBorderColorRes(i);
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public /* bridge */ /* synthetic */ void setBorderSize(int i) {
        super.setBorderSize(i);
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public /* bridge */ /* synthetic */ void setBorderSizeRes(int i) {
        super.setBorderSizeRes(i);
    }

    @Override // com.skydoves.colorpickerview.sliders.a, android.view.View
    public /* bridge */ /* synthetic */ void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public /* bridge */ /* synthetic */ void setPreferenceName(String str) {
        super.setPreferenceName(str);
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public /* bridge */ /* synthetic */ void setSelectorDrawable(Drawable drawable) {
        super.setSelectorDrawable(drawable);
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public /* bridge */ /* synthetic */ void setSelectorDrawableRes(int i) {
        super.setSelectorDrawableRes(i);
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public /* bridge */ /* synthetic */ void setSelectorPosition(float f) {
        super.setSelectorPosition(f);
    }

    public AlphaSlideBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = new n5();
    }

    public AlphaSlideBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new n5();
    }
}
