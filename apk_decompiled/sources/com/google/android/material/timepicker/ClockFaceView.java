package com.google.android.material.timepicker;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.tencent.connect.common.Constants;
import defpackage.be3;
import defpackage.m2;
import defpackage.sg1;
import defpackage.t1;
import defpackage.v8;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
class ClockFaceView extends e implements ClockHandView.c {
    private final ClockHandView G;
    private final Rect H;
    private final RectF I;
    private final Rect J;
    private final SparseArray K;
    private final t1 L;
    private final int[] M;
    private final float[] N;
    private final int O;
    private final int P;
    private final int Q;
    private final int R;
    private String[] S;
    private float T;
    private final ColorStateList U;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.F(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.G.j()) - ClockFaceView.this.O);
            return true;
        }
    }

    class b extends t1 {
        b() {
        }

        @Override // defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            super.onInitializeAccessibilityNodeInfo(view, m2Var);
            int iIntValue = ((Integer) view.getTag(R$id.material_value_index)).intValue();
            if (iIntValue > 0) {
                m2Var.N0((View) ClockFaceView.this.K.get(iIntValue - 1));
            }
            m2Var.m0(m2.f.f(0, 1, iIntValue, 1, false, view.isSelected()));
            m2Var.k0(true);
            m2Var.b(m2.a.i);
        }

        @Override // defpackage.t1
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (i != 16) {
                return super.performAccessibilityAction(view, i, bundle);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            view.getHitRect(ClockFaceView.this.H);
            float fCenterX = ClockFaceView.this.H.centerX();
            float fCenterY = ClockFaceView.this.H.centerY();
            ClockFaceView.this.G.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, fCenterX, fCenterY, 0));
            ClockFaceView.this.G.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, fCenterX, fCenterY, 0));
            return true;
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    private void N() {
        RectF rectFF = this.G.f();
        TextView textViewQ = Q(rectFF);
        for (int i = 0; i < this.K.size(); i++) {
            TextView textView = (TextView) this.K.get(i);
            if (textView != null) {
                textView.setSelected(textView == textViewQ);
                textView.getPaint().setShader(P(rectFF, textView));
                textView.invalidate();
            }
        }
    }

    private RadialGradient P(RectF rectF, TextView textView) {
        textView.getHitRect(this.H);
        this.I.set(this.H);
        textView.getLineBounds(0, this.J);
        RectF rectF2 = this.I;
        Rect rect = this.J;
        rectF2.inset(rect.left, rect.top);
        if (RectF.intersects(rectF, this.I)) {
            return new RadialGradient(rectF.centerX() - this.I.left, rectF.centerY() - this.I.top, rectF.width() * 0.5f, this.M, this.N, Shader.TileMode.CLAMP);
        }
        return null;
    }

    private TextView Q(RectF rectF) {
        float f = Float.MAX_VALUE;
        TextView textView = null;
        for (int i = 0; i < this.K.size(); i++) {
            TextView textView2 = (TextView) this.K.get(i);
            if (textView2 != null) {
                textView2.getHitRect(this.H);
                this.I.set(this.H);
                this.I.union(rectF);
                float fWidth = this.I.width() * this.I.height();
                if (fWidth < f) {
                    textView = textView2;
                    f = fWidth;
                }
            }
        }
        return textView;
    }

    private static float R(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    private void U(int i) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.K.size();
        boolean z = false;
        for (int i2 = 0; i2 < Math.max(this.S.length, size); i2++) {
            TextView textView = (TextView) this.K.get(i2);
            if (i2 >= this.S.length) {
                removeView(textView);
                this.K.remove(i2);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R$layout.material_clockface_textview, (ViewGroup) this, false);
                    this.K.put(i2, textView);
                    addView(textView);
                }
                textView.setText(this.S[i2]);
                textView.setTag(R$id.material_value_index, Integer.valueOf(i2));
                int i3 = (i2 / 12) + 1;
                textView.setTag(R$id.material_clock_level, Integer.valueOf(i3));
                if (i3 > 1) {
                    z = true;
                }
                be3.p0(textView, this.L);
                textView.setTextColor(this.U);
                if (i != 0) {
                    textView.setContentDescription(getResources().getString(i, this.S[i2]));
                }
            }
        }
        this.G.t(z);
    }

    @Override // com.google.android.material.timepicker.e
    public void F(int i) {
        if (i != E()) {
            super.F(i);
            this.G.o(E());
        }
    }

    @Override // com.google.android.material.timepicker.e
    protected void H() {
        super.H();
        for (int i = 0; i < this.K.size(); i++) {
            ((TextView) this.K.get(i)).setVisibility(0);
        }
    }

    int O() {
        return this.G.e();
    }

    void S(int i) {
        this.G.p(i);
    }

    public void T(String[] strArr, int i) {
        this.S = strArr;
        U(i);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void a(float f, boolean z) {
        if (Math.abs(this.T - f) > 0.001f) {
            this.T = f;
            N();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        m2.Q0(accessibilityNodeInfo).l0(m2.e.b(1, this.S.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        N();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iR = (int) (this.R / R(this.P / displayMetrics.heightPixels, this.Q / displayMetrics.widthPixels, 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iR, 1073741824);
        setMeasuredDimension(iR, iR);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    public ClockFaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.H = new Rect();
        this.I = new RectF();
        this.J = new Rect();
        this.K = new SparseArray();
        this.N = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockFaceView, i, R$style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListA = sg1.a(context, typedArrayObtainStyledAttributes, R$styleable.ClockFaceView_clockNumberTextColor);
        this.U = colorStateListA;
        LayoutInflater.from(context).inflate(R$layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R$id.material_clock_hand);
        this.G = clockHandView;
        this.O = resources.getDimensionPixelSize(R$dimen.material_clock_hand_padding);
        int colorForState = colorStateListA.getColorForState(new int[]{R.attr.state_selected}, colorStateListA.getDefaultColor());
        this.M = new int[]{colorForState, colorForState, colorStateListA.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = v8.a(context, R$color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListA2 = sg1.a(context, typedArrayObtainStyledAttributes, R$styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateListA2 != null ? colorStateListA2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.L = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, Constants.STR_EMPTY);
        T(strArr, 0);
        this.P = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_height);
        this.Q = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_width);
        this.R = resources.getDimensionPixelSize(R$dimen.material_clock_size);
    }
}
