package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
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
import com.google.android.material.R$string;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import defpackage.be3;
import defpackage.dd0;
import defpackage.e43;
import defpackage.j23;
import defpackage.l23;
import defpackage.nf3;
import defpackage.sg1;
import defpackage.uf1;
import defpackage.v1;
import defpackage.v8;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
class r extends LinearLayout {
    final TextInputLayout a;
    private final FrameLayout b;
    private final CheckableImageButton c;
    private ColorStateList d;
    private PorterDuff.Mode e;
    private View.OnLongClickListener f;
    private final CheckableImageButton g;
    private final d h;
    private int i;
    private final LinkedHashSet j;
    private ColorStateList k;
    private PorterDuff.Mode l;
    private int m;
    private ImageView.ScaleType n;
    private View.OnLongClickListener o;
    private CharSequence p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final TextView f273q;
    private boolean r;
    private EditText s;
    private final AccessibilityManager t;
    private v1.a u;
    private final TextWatcher v;
    private final TextInputLayout.f w;

    class a extends l23 {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            r.this.m().a(editable);
        }

        @Override // defpackage.l23, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            r.this.m().b(charSequence, i, i2, i3);
        }
    }

    class b implements TextInputLayout.f {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            if (r.this.s == textInputLayout.getEditText()) {
                return;
            }
            if (r.this.s != null) {
                r.this.s.removeTextChangedListener(r.this.v);
                if (r.this.s.getOnFocusChangeListener() == r.this.m().e()) {
                    r.this.s.setOnFocusChangeListener(null);
                }
            }
            r.this.s = textInputLayout.getEditText();
            if (r.this.s != null) {
                r.this.s.addTextChangedListener(r.this.v);
            }
            r.this.m().n(r.this.s);
            r rVar = r.this;
            rVar.h0(rVar.m());
        }
    }

    class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            r.this.g();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            r.this.M();
        }
    }

    private static class d {
        private final SparseArray a = new SparseArray();
        private final r b;
        private final int c;
        private final int d;

        d(r rVar, e0 e0Var) {
            this.b = rVar;
            this.c = e0Var.n(R$styleable.TextInputLayout_endIconDrawable, 0);
            this.d = e0Var.n(R$styleable.TextInputLayout_passwordToggleDrawable, 0);
        }

        private s b(int i) {
            if (i == -1) {
                return new g(this.b);
            }
            if (i == 0) {
                return new v(this.b);
            }
            if (i == 1) {
                return new x(this.b, this.d);
            }
            if (i == 2) {
                return new f(this.b);
            }
            if (i == 3) {
                return new p(this.b);
            }
            throw new IllegalArgumentException("Invalid end icon mode: " + i);
        }

        s c(int i) {
            s sVar = (s) this.a.get(i);
            if (sVar != null) {
                return sVar;
            }
            s sVarB = b(i);
            this.a.append(i, sVarB);
            return sVarB;
        }
    }

    r(TextInputLayout textInputLayout, e0 e0Var) {
        super(textInputLayout.getContext());
        this.i = 0;
        this.j = new LinkedHashSet();
        this.v = new a();
        b bVar = new b();
        this.w = bVar;
        this.t = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonI = i(this, layoutInflaterFrom, R$id.text_input_error_icon);
        this.c = checkableImageButtonI;
        CheckableImageButton checkableImageButtonI2 = i(frameLayout, layoutInflaterFrom, R$id.text_input_end_icon);
        this.g = checkableImageButtonI2;
        this.h = new d(this, e0Var);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f273q = appCompatTextView;
        C(e0Var);
        B(e0Var);
        D(e0Var);
        frameLayout.addView(checkableImageButtonI2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(checkableImageButtonI);
        textInputLayout.i(bVar);
        addOnAttachStateChangeListener(new c());
    }

    private void B(e0 e0Var) {
        int i = R$styleable.TextInputLayout_passwordToggleEnabled;
        if (!e0Var.s(i)) {
            int i2 = R$styleable.TextInputLayout_endIconTint;
            if (e0Var.s(i2)) {
                this.k = sg1.b(getContext(), e0Var, i2);
            }
            int i3 = R$styleable.TextInputLayout_endIconTintMode;
            if (e0Var.s(i3)) {
                this.l = nf3.q(e0Var.k(i3, -1), null);
            }
        }
        int i4 = R$styleable.TextInputLayout_endIconMode;
        if (e0Var.s(i4)) {
            U(e0Var.k(i4, 0));
            int i5 = R$styleable.TextInputLayout_endIconContentDescription;
            if (e0Var.s(i5)) {
                Q(e0Var.p(i5));
            }
            O(e0Var.a(R$styleable.TextInputLayout_endIconCheckable, true));
        } else if (e0Var.s(i)) {
            int i6 = R$styleable.TextInputLayout_passwordToggleTint;
            if (e0Var.s(i6)) {
                this.k = sg1.b(getContext(), e0Var, i6);
            }
            int i7 = R$styleable.TextInputLayout_passwordToggleTintMode;
            if (e0Var.s(i7)) {
                this.l = nf3.q(e0Var.k(i7, -1), null);
            }
            U(e0Var.a(i, false) ? 1 : 0);
            Q(e0Var.p(R$styleable.TextInputLayout_passwordToggleContentDescription));
        }
        T(e0Var.f(R$styleable.TextInputLayout_endIconMinSize, getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size)));
        int i8 = R$styleable.TextInputLayout_endIconScaleType;
        if (e0Var.s(i8)) {
            X(t.b(e0Var.k(i8, -1)));
        }
    }

    private void C(e0 e0Var) {
        int i = R$styleable.TextInputLayout_errorIconTint;
        if (e0Var.s(i)) {
            this.d = sg1.b(getContext(), e0Var, i);
        }
        int i2 = R$styleable.TextInputLayout_errorIconTintMode;
        if (e0Var.s(i2)) {
            this.e = nf3.q(e0Var.k(i2, -1), null);
        }
        int i3 = R$styleable.TextInputLayout_errorIconDrawable;
        if (e0Var.s(i3)) {
            c0(e0Var.g(i3));
        }
        this.c.setContentDescription(getResources().getText(R$string.error_icon_content_description));
        be3.z0(this.c, 2);
        this.c.setClickable(false);
        this.c.setPressable(false);
        this.c.setFocusable(false);
    }

    private void D(e0 e0Var) {
        this.f273q.setVisibility(8);
        this.f273q.setId(R$id.textinput_suffix_text);
        this.f273q.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        be3.r0(this.f273q, 1);
        q0(e0Var.n(R$styleable.TextInputLayout_suffixTextAppearance, 0));
        int i = R$styleable.TextInputLayout_suffixTextColor;
        if (e0Var.s(i)) {
            r0(e0Var.c(i));
        }
        p0(e0Var.p(R$styleable.TextInputLayout_suffixText));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        AccessibilityManager accessibilityManager;
        v1.a aVar = this.u;
        if (aVar == null || (accessibilityManager = this.t) == null) {
            return;
        }
        v1.b(accessibilityManager, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.u == null || this.t == null || !be3.S(this)) {
            return;
        }
        v1.a(this.t, this.u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(s sVar) {
        if (this.s == null) {
            return;
        }
        if (sVar.e() != null) {
            this.s.setOnFocusChangeListener(sVar.e());
        }
        if (sVar.g() != null) {
            this.g.setOnFocusChangeListener(sVar.g());
        }
    }

    private CheckableImageButton i(ViewGroup viewGroup, LayoutInflater layoutInflater, int i) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R$layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i);
        t.e(checkableImageButton);
        if (sg1.j(getContext())) {
            uf1.d((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    private void j(int i) {
        Iterator it = this.j.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
    }

    private void s0(s sVar) {
        sVar.s();
        this.u = sVar.h();
        g();
    }

    private int t(s sVar) {
        int i = this.h.c;
        return i == 0 ? sVar.d() : i;
    }

    private void t0(s sVar) {
        M();
        this.u = null;
        sVar.u();
    }

    private void u0(boolean z) {
        if (!z || n() == null) {
            t.a(this.a, this.g, this.k, this.l);
            return;
        }
        Drawable drawableMutate = dd0.r(n()).mutate();
        dd0.n(drawableMutate, this.a.getErrorCurrentTextColors());
        this.g.setImageDrawable(drawableMutate);
    }

    private void v0() {
        this.b.setVisibility((this.g.getVisibility() != 0 || G()) ? 8 : 0);
        setVisibility((F() || G() || ((this.p == null || this.r) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    private void w0() {
        this.c.setVisibility(s() != null && this.a.N() && this.a.d0() ? 0 : 8);
        v0();
        x0();
        if (A()) {
            return;
        }
        this.a.o0();
    }

    private void y0() {
        int visibility = this.f273q.getVisibility();
        int i = (this.p == null || this.r) ? 8 : 0;
        if (visibility != i) {
            m().q(i == 0);
        }
        v0();
        this.f273q.setVisibility(i);
        this.a.o0();
    }

    boolean A() {
        return this.i != 0;
    }

    boolean E() {
        return A() && this.g.isChecked();
    }

    boolean F() {
        return this.b.getVisibility() == 0 && this.g.getVisibility() == 0;
    }

    boolean G() {
        return this.c.getVisibility() == 0;
    }

    void H(boolean z) {
        this.r = z;
        y0();
    }

    void I() {
        w0();
        K();
        J();
        if (m().t()) {
            u0(this.a.d0());
        }
    }

    void J() {
        t.d(this.a, this.g, this.k);
    }

    void K() {
        t.d(this.a, this.c, this.d);
    }

    void L(boolean z) {
        boolean z2;
        boolean zIsActivated;
        boolean zIsChecked;
        s sVarM = m();
        boolean z3 = true;
        if (!sVarM.l() || (zIsChecked = this.g.isChecked()) == sVarM.m()) {
            z2 = false;
        } else {
            this.g.setChecked(!zIsChecked);
            z2 = true;
        }
        if (!sVarM.j() || (zIsActivated = this.g.isActivated()) == sVarM.k()) {
            z3 = z2;
        } else {
            N(!zIsActivated);
        }
        if (z || z3) {
            J();
        }
    }

    void N(boolean z) {
        this.g.setActivated(z);
    }

    void O(boolean z) {
        this.g.setCheckable(z);
    }

    void P(int i) {
        Q(i != 0 ? getResources().getText(i) : null);
    }

    void Q(CharSequence charSequence) {
        if (l() != charSequence) {
            this.g.setContentDescription(charSequence);
        }
    }

    void R(int i) {
        S(i != 0 ? v8.b(getContext(), i) : null);
    }

    void S(Drawable drawable) {
        this.g.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.a, this.g, this.k, this.l);
            J();
        }
    }

    void T(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i != this.m) {
            this.m = i;
            t.g(this.g, i);
            t.g(this.c, i);
        }
    }

    void U(int i) {
        if (this.i == i) {
            return;
        }
        t0(m());
        int i2 = this.i;
        this.i = i;
        j(i2);
        a0(i != 0);
        s sVarM = m();
        R(t(sVarM));
        P(sVarM.c());
        O(sVarM.l());
        if (!sVarM.i(this.a.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + this.a.getBoxBackgroundMode() + " is not supported by the end icon mode " + i);
        }
        s0(sVarM);
        V(sVarM.f());
        EditText editText = this.s;
        if (editText != null) {
            sVarM.n(editText);
            h0(sVarM);
        }
        t.a(this.a, this.g, this.k, this.l);
        L(true);
    }

    void V(View.OnClickListener onClickListener) {
        t.h(this.g, onClickListener, this.o);
    }

    void W(View.OnLongClickListener onLongClickListener) {
        this.o = onLongClickListener;
        t.i(this.g, onLongClickListener);
    }

    void X(ImageView.ScaleType scaleType) {
        this.n = scaleType;
        t.j(this.g, scaleType);
        t.j(this.c, scaleType);
    }

    void Y(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            t.a(this.a, this.g, colorStateList, this.l);
        }
    }

    void Z(PorterDuff.Mode mode) {
        if (this.l != mode) {
            this.l = mode;
            t.a(this.a, this.g, this.k, mode);
        }
    }

    void a0(boolean z) {
        if (F() != z) {
            this.g.setVisibility(z ? 0 : 8);
            v0();
            x0();
            this.a.o0();
        }
    }

    void b0(int i) {
        c0(i != 0 ? v8.b(getContext(), i) : null);
        K();
    }

    void c0(Drawable drawable) {
        this.c.setImageDrawable(drawable);
        w0();
        t.a(this.a, this.c, this.d, this.e);
    }

    void d0(View.OnClickListener onClickListener) {
        t.h(this.c, onClickListener, this.f);
    }

    void e0(View.OnLongClickListener onLongClickListener) {
        this.f = onLongClickListener;
        t.i(this.c, onLongClickListener);
    }

    void f0(ColorStateList colorStateList) {
        if (this.d != colorStateList) {
            this.d = colorStateList;
            t.a(this.a, this.c, colorStateList, this.e);
        }
    }

    void g0(PorterDuff.Mode mode) {
        if (this.e != mode) {
            this.e = mode;
            t.a(this.a, this.c, this.d, mode);
        }
    }

    void h() {
        this.g.performClick();
        this.g.jumpDrawablesToCurrentState();
    }

    void i0(int i) {
        j0(i != 0 ? getResources().getText(i) : null);
    }

    void j0(CharSequence charSequence) {
        this.g.setContentDescription(charSequence);
    }

    CheckableImageButton k() {
        if (G()) {
            return this.c;
        }
        if (A() && F()) {
            return this.g;
        }
        return null;
    }

    void k0(int i) {
        l0(i != 0 ? v8.b(getContext(), i) : null);
    }

    CharSequence l() {
        return this.g.getContentDescription();
    }

    void l0(Drawable drawable) {
        this.g.setImageDrawable(drawable);
    }

    s m() {
        return this.h.c(this.i);
    }

    void m0(boolean z) {
        if (z && this.i != 1) {
            U(1);
        } else {
            if (z) {
                return;
            }
            U(0);
        }
    }

    Drawable n() {
        return this.g.getDrawable();
    }

    void n0(ColorStateList colorStateList) {
        this.k = colorStateList;
        t.a(this.a, this.g, colorStateList, this.l);
    }

    int o() {
        return this.m;
    }

    void o0(PorterDuff.Mode mode) {
        this.l = mode;
        t.a(this.a, this.g, this.k, mode);
    }

    int p() {
        return this.i;
    }

    void p0(CharSequence charSequence) {
        this.p = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f273q.setText(charSequence);
        y0();
    }

    ImageView.ScaleType q() {
        return this.n;
    }

    void q0(int i) {
        j23.p(this.f273q, i);
    }

    CheckableImageButton r() {
        return this.g;
    }

    void r0(ColorStateList colorStateList) {
        this.f273q.setTextColor(colorStateList);
    }

    Drawable s() {
        return this.c.getDrawable();
    }

    CharSequence u() {
        return this.g.getContentDescription();
    }

    Drawable v() {
        return this.g.getDrawable();
    }

    CharSequence w() {
        return this.p;
    }

    ColorStateList x() {
        return this.f273q.getTextColors();
    }

    void x0() {
        if (this.a.d == null) {
            return;
        }
        be3.F0(this.f273q, getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), this.a.d.getPaddingTop(), (F() || G()) ? 0 : be3.E(this.a.d), this.a.d.getPaddingBottom());
    }

    int y() {
        return be3.E(this) + be3.E(this.f273q) + ((F() || G()) ? this.g.getMeasuredWidth() + uf1.b((ViewGroup.MarginLayoutParams) this.g.getLayoutParams()) : 0);
    }

    TextView z() {
        return this.f273q;
    }
}
