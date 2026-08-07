package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import defpackage.be3;
import defpackage.dd0;
import defpackage.ho2;
import defpackage.nf3;
import defpackage.og1;
import defpackage.sg1;
import defpackage.sn2;
import defpackage.tg1;
import defpackage.yh2;
import defpackage.zh2;

/* JADX INFO: loaded from: classes3.dex */
class a {
    private static final boolean u = true;
    private static final boolean v = false;
    private final MaterialButton a;
    private sn2 b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private PorterDuff.Mode i;
    private ColorStateList j;
    private ColorStateList k;
    private ColorStateList l;
    private Drawable m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f251q;
    private LayerDrawable s;
    private int t;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean r = true;

    a(MaterialButton materialButton, sn2 sn2Var) {
        this.a = materialButton;
        this.b = sn2Var;
    }

    private void G(int i, int i2) {
        int iF = be3.F(this.a);
        int paddingTop = this.a.getPaddingTop();
        int iE = be3.E(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        int i3 = this.e;
        int i4 = this.f;
        this.f = i2;
        this.e = i;
        if (!this.o) {
            H();
        }
        be3.F0(this.a, iF, (paddingTop + i) - i3, iE, (paddingBottom + i2) - i4);
    }

    private void H() {
        this.a.setInternalBackground(a());
        tg1 tg1VarF = f();
        if (tg1VarF != null) {
            tg1VarF.a0(this.t);
            tg1VarF.setState(this.a.getDrawableState());
        }
    }

    private void I(sn2 sn2Var) {
        if (v && !this.o) {
            int iF = be3.F(this.a);
            int paddingTop = this.a.getPaddingTop();
            int iE = be3.E(this.a);
            int paddingBottom = this.a.getPaddingBottom();
            H();
            be3.F0(this.a, iF, paddingTop, iE, paddingBottom);
            return;
        }
        if (f() != null) {
            f().setShapeAppearanceModel(sn2Var);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(sn2Var);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(sn2Var);
        }
    }

    private void J() {
        tg1 tg1VarF = f();
        tg1 tg1VarN = n();
        if (tg1VarF != null) {
            tg1VarF.k0(this.h, this.k);
            if (tg1VarN != null) {
                tg1VarN.j0(this.h, this.n ? og1.d(this.a, R$attr.colorSurface) : 0);
            }
        }
    }

    private InsetDrawable K(Drawable drawable) {
        return new InsetDrawable(drawable, this.c, this.e, this.d, this.f);
    }

    private Drawable a() {
        tg1 tg1Var = new tg1(this.b);
        tg1Var.Q(this.a.getContext());
        dd0.o(tg1Var, this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            dd0.p(tg1Var, mode);
        }
        tg1Var.k0(this.h, this.k);
        tg1 tg1Var2 = new tg1(this.b);
        tg1Var2.setTint(0);
        tg1Var2.j0(this.h, this.n ? og1.d(this.a, R$attr.colorSurface) : 0);
        if (u) {
            tg1 tg1Var3 = new tg1(this.b);
            this.m = tg1Var3;
            dd0.n(tg1Var3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(zh2.d(this.l), K(new LayerDrawable(new Drawable[]{tg1Var2, tg1Var})), this.m);
            this.s = rippleDrawable;
            return rippleDrawable;
        }
        yh2 yh2Var = new yh2(this.b);
        this.m = yh2Var;
        dd0.o(yh2Var, zh2.d(this.l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{tg1Var2, tg1Var, this.m});
        this.s = layerDrawable;
        return K(layerDrawable);
    }

    private tg1 g(boolean z) {
        LayerDrawable layerDrawable = this.s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return u ? (tg1) ((LayerDrawable) ((InsetDrawable) this.s.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0) : (tg1) this.s.getDrawable(!z ? 1 : 0);
    }

    private tg1 n() {
        return g(true);
    }

    void A(boolean z) {
        this.n = z;
        J();
    }

    void B(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            J();
        }
    }

    void C(int i) {
        if (this.h != i) {
            this.h = i;
            J();
        }
    }

    void D(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            if (f() != null) {
                dd0.o(f(), this.j);
            }
        }
    }

    void E(PorterDuff.Mode mode) {
        if (this.i != mode) {
            this.i = mode;
            if (f() == null || this.i == null) {
                return;
            }
            dd0.p(f(), this.i);
        }
    }

    void F(boolean z) {
        this.r = z;
    }

    int b() {
        return this.g;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.e;
    }

    public ho2 e() {
        LayerDrawable layerDrawable = this.s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.s.getNumberOfLayers() > 2 ? (ho2) this.s.getDrawable(2) : (ho2) this.s.getDrawable(1);
    }

    tg1 f() {
        return g(false);
    }

    ColorStateList h() {
        return this.l;
    }

    sn2 i() {
        return this.b;
    }

    ColorStateList j() {
        return this.k;
    }

    int k() {
        return this.h;
    }

    ColorStateList l() {
        return this.j;
    }

    PorterDuff.Mode m() {
        return this.i;
    }

    boolean o() {
        return this.o;
    }

    boolean p() {
        return this.f251q;
    }

    boolean q() {
        return this.r;
    }

    void r(TypedArray typedArray) {
        this.c = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetLeft, 0);
        this.d = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetRight, 0);
        this.e = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetTop, 0);
        this.f = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetBottom, 0);
        int i = R$styleable.MaterialButton_cornerRadius;
        if (typedArray.hasValue(i)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i, -1);
            this.g = dimensionPixelSize;
            z(this.b.w(dimensionPixelSize));
            this.p = true;
        }
        this.h = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_strokeWidth, 0);
        this.i = nf3.q(typedArray.getInt(R$styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.j = sg1.a(this.a.getContext(), typedArray, R$styleable.MaterialButton_backgroundTint);
        this.k = sg1.a(this.a.getContext(), typedArray, R$styleable.MaterialButton_strokeColor);
        this.l = sg1.a(this.a.getContext(), typedArray, R$styleable.MaterialButton_rippleColor);
        this.f251q = typedArray.getBoolean(R$styleable.MaterialButton_android_checkable, false);
        this.t = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_elevation, 0);
        this.r = typedArray.getBoolean(R$styleable.MaterialButton_toggleCheckedStateOnClick, true);
        int iF = be3.F(this.a);
        int paddingTop = this.a.getPaddingTop();
        int iE = be3.E(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        if (typedArray.hasValue(R$styleable.MaterialButton_android_background)) {
            t();
        } else {
            H();
        }
        be3.F0(this.a, iF + this.c, paddingTop + this.e, iE + this.d, paddingBottom + this.f);
    }

    void s(int i) {
        if (f() != null) {
            f().setTint(i);
        }
    }

    void t() {
        this.o = true;
        this.a.setSupportBackgroundTintList(this.j);
        this.a.setSupportBackgroundTintMode(this.i);
    }

    void u(boolean z) {
        this.f251q = z;
    }

    void v(int i) {
        if (this.p && this.g == i) {
            return;
        }
        this.g = i;
        this.p = true;
        z(this.b.w(i));
    }

    public void w(int i) {
        G(this.e, i);
    }

    public void x(int i) {
        G(i, this.f);
    }

    void y(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            boolean z = u;
            if (z && (this.a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.a.getBackground()).setColor(zh2.d(colorStateList));
            } else {
                if (z || !(this.a.getBackground() instanceof yh2)) {
                    return;
                }
                ((yh2) this.a.getBackground()).setTintList(zh2.d(colorStateList));
            }
        }
    }

    void z(sn2 sn2Var) {
        this.b = sn2Var;
        I(sn2Var);
    }
}
