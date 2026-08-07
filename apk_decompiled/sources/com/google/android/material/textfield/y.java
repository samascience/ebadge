package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.e0;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import defpackage.be3;
import defpackage.j23;
import defpackage.m2;
import defpackage.nf3;
import defpackage.sg1;
import defpackage.uf1;

/* JADX INFO: loaded from: classes3.dex */
class y extends LinearLayout {
    private final TextInputLayout a;
    private final TextView b;
    private CharSequence c;
    private final CheckableImageButton d;
    private ColorStateList e;
    private PorterDuff.Mode f;
    private int g;
    private ImageView.ScaleType h;
    private View.OnLongClickListener i;
    private boolean j;

    y(TextInputLayout textInputLayout, e0 e0Var) {
        super(textInputLayout.getContext());
        this.a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.d = checkableImageButton;
        t.e(checkableImageButton);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.b = appCompatTextView;
        j(e0Var);
        i(e0Var);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    private void C() {
        int i = (this.c == null || this.j) ? 8 : 0;
        setVisibility((this.d.getVisibility() == 0 || i == 0) ? 0 : 8);
        this.b.setVisibility(i);
        this.a.o0();
    }

    private void i(e0 e0Var) {
        this.b.setVisibility(8);
        this.b.setId(R$id.textinput_prefix_text);
        this.b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        be3.r0(this.b, 1);
        o(e0Var.n(R$styleable.TextInputLayout_prefixTextAppearance, 0));
        int i = R$styleable.TextInputLayout_prefixTextColor;
        if (e0Var.s(i)) {
            p(e0Var.c(i));
        }
        n(e0Var.p(R$styleable.TextInputLayout_prefixText));
    }

    private void j(e0 e0Var) {
        if (sg1.j(getContext())) {
            uf1.c((ViewGroup.MarginLayoutParams) this.d.getLayoutParams(), 0);
        }
        u(null);
        v(null);
        int i = R$styleable.TextInputLayout_startIconTint;
        if (e0Var.s(i)) {
            this.e = sg1.b(getContext(), e0Var, i);
        }
        int i2 = R$styleable.TextInputLayout_startIconTintMode;
        if (e0Var.s(i2)) {
            this.f = nf3.q(e0Var.k(i2, -1), null);
        }
        int i3 = R$styleable.TextInputLayout_startIconDrawable;
        if (e0Var.s(i3)) {
            s(e0Var.g(i3));
            int i4 = R$styleable.TextInputLayout_startIconContentDescription;
            if (e0Var.s(i4)) {
                r(e0Var.p(i4));
            }
            q(e0Var.a(R$styleable.TextInputLayout_startIconCheckable, true));
        }
        t(e0Var.f(R$styleable.TextInputLayout_startIconMinSize, getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size)));
        int i5 = R$styleable.TextInputLayout_startIconScaleType;
        if (e0Var.s(i5)) {
            w(t.b(e0Var.k(i5, -1)));
        }
    }

    void A(m2 m2Var) {
        if (this.b.getVisibility() != 0) {
            m2Var.N0(this.d);
        } else {
            m2Var.v0(this.b);
            m2Var.N0(this.b);
        }
    }

    void B() {
        EditText editText = this.a.d;
        if (editText == null) {
            return;
        }
        be3.F0(this.b, k() ? 0 : be3.F(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    CharSequence a() {
        return this.c;
    }

    ColorStateList b() {
        return this.b.getTextColors();
    }

    int c() {
        return be3.F(this) + be3.F(this.b) + (k() ? this.d.getMeasuredWidth() + uf1.a((ViewGroup.MarginLayoutParams) this.d.getLayoutParams()) : 0);
    }

    TextView d() {
        return this.b;
    }

    CharSequence e() {
        return this.d.getContentDescription();
    }

    Drawable f() {
        return this.d.getDrawable();
    }

    int g() {
        return this.g;
    }

    ImageView.ScaleType h() {
        return this.h;
    }

    boolean k() {
        return this.d.getVisibility() == 0;
    }

    void l(boolean z) {
        this.j = z;
        C();
    }

    void m() {
        t.d(this.a, this.d, this.e);
    }

    void n(CharSequence charSequence) {
        this.c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.b.setText(charSequence);
        C();
    }

    void o(int i) {
        j23.p(this.b, i);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        B();
    }

    void p(ColorStateList colorStateList) {
        this.b.setTextColor(colorStateList);
    }

    void q(boolean z) {
        this.d.setCheckable(z);
    }

    void r(CharSequence charSequence) {
        if (e() != charSequence) {
            this.d.setContentDescription(charSequence);
        }
    }

    void s(Drawable drawable) {
        this.d.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.a, this.d, this.e, this.f);
            z(true);
            m();
        } else {
            z(false);
            u(null);
            v(null);
            r(null);
        }
    }

    void t(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i != this.g) {
            this.g = i;
            t.g(this.d, i);
        }
    }

    void u(View.OnClickListener onClickListener) {
        t.h(this.d, onClickListener, this.i);
    }

    void v(View.OnLongClickListener onLongClickListener) {
        this.i = onLongClickListener;
        t.i(this.d, onLongClickListener);
    }

    void w(ImageView.ScaleType scaleType) {
        this.h = scaleType;
        t.j(this.d, scaleType);
    }

    void x(ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            t.a(this.a, this.d, colorStateList, this.f);
        }
    }

    void y(PorterDuff.Mode mode) {
        if (this.f != mode) {
            this.f = mode;
            t.a(this.a, this.d, this.e, mode);
        }
    }

    void z(boolean z) {
        if (k() != z) {
            this.d.setVisibility(z ? 0 : 8);
            B();
            C();
        }
    }
}
