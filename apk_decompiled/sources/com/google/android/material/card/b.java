package com.google.android.material.card;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.seeker.luckychart.animation.ChartCoordinateportAnimator;
import defpackage.be3;
import defpackage.dd0;
import defpackage.el1;
import defpackage.ii2;
import defpackage.m40;
import defpackage.og1;
import defpackage.p50;
import defpackage.sg1;
import defpackage.sn2;
import defpackage.tg1;
import defpackage.y6;
import defpackage.zh2;

/* JADX INFO: loaded from: classes3.dex */
class b {
    private static final Drawable A;
    private static final double z = Math.cos(Math.toRadians(45.0d));
    private final MaterialCardView a;
    private final tg1 c;
    private final tg1 d;
    private int e;
    private int f;
    private int g;
    private int h;
    private Drawable i;
    private Drawable j;
    private ColorStateList k;
    private ColorStateList l;
    private sn2 m;
    private ColorStateList n;
    private Drawable o;
    private LayerDrawable p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private tg1 f253q;
    private tg1 r;
    private boolean t;
    private ValueAnimator u;
    private final TimeInterpolator v;
    private final int w;
    private final int x;
    private final Rect b = new Rect();
    private boolean s = false;
    private float y = 0.0f;

    class a extends InsetDrawable {
        a(Drawable drawable, int i, int i2, int i3, int i4) {
            super(drawable, i, i2, i3, i4);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    static {
        A = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
    }

    public b(MaterialCardView materialCardView, AttributeSet attributeSet, int i, int i2) {
        this.a = materialCardView;
        tg1 tg1Var = new tg1(materialCardView.getContext(), attributeSet, i, i2);
        this.c = tg1Var;
        tg1Var.Q(materialCardView.getContext());
        tg1Var.h0(-12303292);
        sn2.b bVarV = tg1Var.E().v();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R$styleable.CardView, i, R$style.CardView);
        int i3 = R$styleable.CardView_cardCornerRadius;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            bVarV.o(typedArrayObtainStyledAttributes.getDimension(i3, 0.0f));
        }
        this.d = new tg1();
        Z(bVarV.m());
        this.v = el1.g(materialCardView.getContext(), R$attr.motionEasingLinearInterpolator, y6.a);
        this.w = el1.f(materialCardView.getContext(), R$attr.motionDurationShort2, ChartCoordinateportAnimator.FAST_ANIMATION_DURATION);
        this.x = el1.f(materialCardView.getContext(), R$attr.motionDurationShort1, ChartCoordinateportAnimator.FAST_ANIMATION_DURATION);
        typedArrayObtainStyledAttributes.recycle();
    }

    private Drawable D(Drawable drawable) {
        int iCeil;
        int iCeil2;
        if (this.a.getUseCompatPadding()) {
            iCeil2 = (int) Math.ceil(f());
            iCeil = (int) Math.ceil(e());
        } else {
            iCeil = 0;
            iCeil2 = 0;
        }
        return new a(drawable, iCeil, iCeil2, iCeil, iCeil2);
    }

    private boolean G() {
        return (this.g & 80) == 80;
    }

    private boolean H() {
        return (this.g & 8388613) == 8388613;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.j.setAlpha((int) (255.0f * fFloatValue));
        this.y = fFloatValue;
    }

    private float c() {
        return Math.max(Math.max(d(this.m.q(), this.c.J()), d(this.m.s(), this.c.K())), Math.max(d(this.m.k(), this.c.t()), d(this.m.i(), this.c.s())));
    }

    private float d(m40 m40Var, float f) {
        if (m40Var instanceof ii2) {
            return (float) ((1.0d - z) * ((double) f));
        }
        if (m40Var instanceof p50) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    private boolean d0() {
        return this.a.getPreventCornerOverlap() && !g();
    }

    private float e() {
        return this.a.getMaxCardElevation() + (e0() ? c() : 0.0f);
    }

    private boolean e0() {
        return this.a.getPreventCornerOverlap() && g() && this.a.getUseCompatPadding();
    }

    private float f() {
        return (this.a.getMaxCardElevation() * 1.5f) + (e0() ? c() : 0.0f);
    }

    private boolean f0() {
        if (this.a.isClickable()) {
            return true;
        }
        View view = this.a;
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    private boolean g() {
        return this.c.T();
    }

    private Drawable h() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        tg1 tg1VarJ = j();
        this.f253q = tg1VarJ;
        tg1VarJ.b0(this.k);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.f253q);
        return stateListDrawable;
    }

    private Drawable i() {
        if (!zh2.a) {
            return h();
        }
        this.r = j();
        return new RippleDrawable(this.k, null, this.r);
    }

    private tg1 j() {
        return new tg1(this.m);
    }

    private void j0(Drawable drawable) {
        if (this.a.getForeground() instanceof InsetDrawable) {
            ((InsetDrawable) this.a.getForeground()).setDrawable(drawable);
        } else {
            this.a.setForeground(D(drawable));
        }
    }

    private void l0() {
        Drawable drawable;
        if (zh2.a && (drawable = this.o) != null) {
            ((RippleDrawable) drawable).setColor(this.k);
            return;
        }
        tg1 tg1Var = this.f253q;
        if (tg1Var != null) {
            tg1Var.b0(this.k);
        }
    }

    private Drawable t() {
        if (this.o == null) {
            this.o = i();
        }
        if (this.p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.o, this.d, this.j});
            this.p = layerDrawable;
            layerDrawable.setId(2, R$id.mtrl_card_checked_layer_id);
        }
        return this.p;
    }

    private float v() {
        if (this.a.getPreventCornerOverlap() && this.a.getUseCompatPadding()) {
            return (float) ((1.0d - z) * ((double) this.a.getCardViewRadius()));
        }
        return 0.0f;
    }

    ColorStateList A() {
        return this.n;
    }

    int B() {
        return this.h;
    }

    Rect C() {
        return this.b;
    }

    boolean E() {
        return this.s;
    }

    boolean F() {
        return this.t;
    }

    void J(TypedArray typedArray) {
        ColorStateList colorStateListA = sg1.a(this.a.getContext(), typedArray, R$styleable.MaterialCardView_strokeColor);
        this.n = colorStateListA;
        if (colorStateListA == null) {
            this.n = ColorStateList.valueOf(-1);
        }
        this.h = typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_strokeWidth, 0);
        boolean z2 = typedArray.getBoolean(R$styleable.MaterialCardView_android_checkable, false);
        this.t = z2;
        this.a.setLongClickable(z2);
        this.l = sg1.a(this.a.getContext(), typedArray, R$styleable.MaterialCardView_checkedIconTint);
        R(sg1.e(this.a.getContext(), typedArray, R$styleable.MaterialCardView_checkedIcon));
        U(typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconSize, 0));
        T(typedArray.getDimensionPixelSize(R$styleable.MaterialCardView_checkedIconMargin, 0));
        this.g = typedArray.getInteger(R$styleable.MaterialCardView_checkedIconGravity, 8388661);
        ColorStateList colorStateListA2 = sg1.a(this.a.getContext(), typedArray, R$styleable.MaterialCardView_rippleColor);
        this.k = colorStateListA2;
        if (colorStateListA2 == null) {
            this.k = ColorStateList.valueOf(og1.d(this.a, R$attr.colorControlHighlight));
        }
        N(sg1.a(this.a.getContext(), typedArray, R$styleable.MaterialCardView_cardForegroundColor));
        l0();
        i0();
        m0();
        this.a.setBackgroundInternal(D(this.c));
        Drawable drawableT = f0() ? t() : this.d;
        this.i = drawableT;
        this.a.setForeground(D(drawableT));
    }

    void K(int i, int i2) {
        int iCeil;
        int iCeil2;
        int i3;
        int i4;
        if (this.p != null) {
            if (this.a.getUseCompatPadding()) {
                iCeil = (int) Math.ceil(f() * 2.0f);
                iCeil2 = (int) Math.ceil(e() * 2.0f);
            } else {
                iCeil = 0;
                iCeil2 = 0;
            }
            int i5 = H() ? ((i - this.e) - this.f) - iCeil2 : this.e;
            int i6 = G() ? this.e : ((i2 - this.e) - this.f) - iCeil;
            int i7 = H() ? this.e : ((i - this.e) - this.f) - iCeil2;
            int i8 = G() ? ((i2 - this.e) - this.f) - iCeil : this.e;
            if (be3.A(this.a) == 1) {
                i4 = i7;
                i3 = i5;
            } else {
                i3 = i7;
                i4 = i5;
            }
            this.p.setLayerInset(2, i4, i8, i3, i6);
        }
    }

    void L(boolean z2) {
        this.s = z2;
    }

    void M(ColorStateList colorStateList) {
        this.c.b0(colorStateList);
    }

    void N(ColorStateList colorStateList) {
        tg1 tg1Var = this.d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        tg1Var.b0(colorStateList);
    }

    void O(boolean z2) {
        this.t = z2;
    }

    public void P(boolean z2) {
        Q(z2, false);
    }

    public void Q(boolean z2, boolean z3) {
        Drawable drawable = this.j;
        if (drawable != null) {
            if (z3) {
                b(z2);
            } else {
                drawable.setAlpha(z2 ? 255 : 0);
                this.y = z2 ? 1.0f : 0.0f;
            }
        }
    }

    void R(Drawable drawable) {
        if (drawable != null) {
            Drawable drawableMutate = dd0.r(drawable).mutate();
            this.j = drawableMutate;
            dd0.o(drawableMutate, this.l);
            P(this.a.isChecked());
        } else {
            this.j = A;
        }
        LayerDrawable layerDrawable = this.p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R$id.mtrl_card_checked_layer_id, this.j);
        }
    }

    void S(int i) {
        this.g = i;
        K(this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
    }

    void T(int i) {
        this.e = i;
    }

    void U(int i) {
        this.f = i;
    }

    void V(ColorStateList colorStateList) {
        this.l = colorStateList;
        Drawable drawable = this.j;
        if (drawable != null) {
            dd0.o(drawable, colorStateList);
        }
    }

    void W(float f) {
        Z(this.m.w(f));
        this.i.invalidateSelf();
        if (e0() || d0()) {
            h0();
        }
        if (e0()) {
            k0();
        }
    }

    void X(float f) {
        this.c.c0(f);
        tg1 tg1Var = this.d;
        if (tg1Var != null) {
            tg1Var.c0(f);
        }
        tg1 tg1Var2 = this.r;
        if (tg1Var2 != null) {
            tg1Var2.c0(f);
        }
    }

    void Y(ColorStateList colorStateList) {
        this.k = colorStateList;
        l0();
    }

    void Z(sn2 sn2Var) {
        this.m = sn2Var;
        this.c.setShapeAppearanceModel(sn2Var);
        tg1 tg1Var = this.c;
        tg1Var.g0(!tg1Var.T());
        tg1 tg1Var2 = this.d;
        if (tg1Var2 != null) {
            tg1Var2.setShapeAppearanceModel(sn2Var);
        }
        tg1 tg1Var3 = this.r;
        if (tg1Var3 != null) {
            tg1Var3.setShapeAppearanceModel(sn2Var);
        }
        tg1 tg1Var4 = this.f253q;
        if (tg1Var4 != null) {
            tg1Var4.setShapeAppearanceModel(sn2Var);
        }
    }

    void a0(ColorStateList colorStateList) {
        if (this.n == colorStateList) {
            return;
        }
        this.n = colorStateList;
        m0();
    }

    public void b(boolean z2) {
        float f = z2 ? 1.0f : 0.0f;
        float f2 = z2 ? 1.0f - this.y : this.y;
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.u = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.y, f);
        this.u = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.card.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.I(valueAnimator2);
            }
        });
        this.u.setInterpolator(this.v);
        this.u.setDuration((long) ((z2 ? this.w : this.x) * f2));
        this.u.start();
    }

    void b0(int i) {
        if (i == this.h) {
            return;
        }
        this.h = i;
        m0();
    }

    void c0(int i, int i2, int i3, int i4) {
        this.b.set(i, i2, i3, i4);
        h0();
    }

    void g0() {
        Drawable drawable = this.i;
        Drawable drawableT = f0() ? t() : this.d;
        this.i = drawableT;
        if (drawable != drawableT) {
            j0(drawableT);
        }
    }

    void h0() {
        int iC = (int) (((d0() || e0()) ? c() : 0.0f) - v());
        MaterialCardView materialCardView = this.a;
        Rect rect = this.b;
        materialCardView.k(rect.left + iC, rect.top + iC, rect.right + iC, rect.bottom + iC);
    }

    void i0() {
        this.c.a0(this.a.getCardElevation());
    }

    void k() {
        Drawable drawable = this.o;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i = bounds.bottom;
            this.o.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
            this.o.setBounds(bounds.left, bounds.top, bounds.right, i);
        }
    }

    void k0() {
        if (!E()) {
            this.a.setBackgroundInternal(D(this.c));
        }
        this.a.setForeground(D(this.i));
    }

    tg1 l() {
        return this.c;
    }

    ColorStateList m() {
        return this.c.x();
    }

    void m0() {
        this.d.k0(this.h, this.n);
    }

    ColorStateList n() {
        return this.d.x();
    }

    Drawable o() {
        return this.j;
    }

    int p() {
        return this.g;
    }

    int q() {
        return this.e;
    }

    int r() {
        return this.f;
    }

    ColorStateList s() {
        return this.l;
    }

    float u() {
        return this.c.J();
    }

    float w() {
        return this.c.y();
    }

    ColorStateList x() {
        return this.k;
    }

    sn2 y() {
        return this.m;
    }

    int z() {
        ColorStateList colorStateList = this.n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }
}
