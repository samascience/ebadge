package com.skydoves.colorpickerview.sliders;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.R$styleable;
import defpackage.kz;
import defpackage.v8;

/* JADX INFO: loaded from: classes.dex */
public class BrightnessSlideBar extends a {
    public BrightnessSlideBar(Context context) {
        super(context);
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public int a() {
        float[] fArr = {0.0f, 0.0f, this.d};
        Color.colorToHSV(getColor(), fArr);
        ColorPickerView colorPickerView = this.a;
        return (colorPickerView == null || colorPickerView.getAlphaSlideBar() == null) ? Color.HSVToColor(fArr) : Color.HSVToColor((int) (this.a.getAlphaSlideBar().getSelectorPosition() * 255.0f), fArr);
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    protected void b(AttributeSet attributeSet) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BrightnessSlideBar);
        try {
            int i = R$styleable.BrightnessSlideBar_selector_BrightnessSlider;
            if (typedArrayObtainStyledAttributes.hasValue(i) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i, -1)) != -1) {
                this.f = v8.b(getContext(), resourceId);
            }
            int i2 = R$styleable.BrightnessSlideBar_borderColor_BrightnessSlider;
            if (typedArrayObtainStyledAttributes.hasValue(i2)) {
                this.h = typedArrayObtainStyledAttributes.getColor(i2, this.h);
            }
            int i3 = R$styleable.BrightnessSlideBar_borderSize_BrightnessSlider;
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
            j(kz.g(getContext()).d(getPreferenceName(), measuredWidth) + getSelectorHalfSize());
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
    protected void i(Paint paint) {
        float[] fArr = {0.0f, 0.0f, 0.0f};
        Color.colorToHSV(getColor(), fArr);
        int iHSVToColor = Color.HSVToColor(fArr);
        fArr[2] = 1.0f;
        paint.setShader(new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), iHSVToColor, Color.HSVToColor(fArr), Shader.TileMode.CLAMP));
    }

    @Override // com.skydoves.colorpickerview.sliders.a
    public /* bridge */ /* synthetic */ void j(int i) {
        super.j(i);
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

    public BrightnessSlideBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BrightnessSlideBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
