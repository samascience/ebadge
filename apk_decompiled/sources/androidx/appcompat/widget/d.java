package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import defpackage.be3;

/* JADX INFO: loaded from: classes.dex */
class d {
    private final View a;
    private c0 d;
    private c0 e;
    private c0 f;
    private int c = -1;
    private final g b = g.b();

    d(View view) {
        this.a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f == null) {
            this.f = new c0();
        }
        c0 c0Var = this.f;
        c0Var.a();
        ColorStateList colorStateListS = be3.s(this.a);
        if (colorStateListS != null) {
            c0Var.d = true;
            c0Var.a = colorStateListS;
        }
        PorterDuff.Mode modeT = be3.t(this.a);
        if (modeT != null) {
            c0Var.c = true;
            c0Var.b = modeT;
        }
        if (!c0Var.d && !c0Var.c) {
            return false;
        }
        g.i(drawable, c0Var, this.a.getDrawableState());
        return true;
    }

    private boolean k() {
        return this.d != null;
    }

    void b() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            c0 c0Var = this.e;
            if (c0Var != null) {
                g.i(background, c0Var, this.a.getDrawableState());
                return;
            }
            c0 c0Var2 = this.d;
            if (c0Var2 != null) {
                g.i(background, c0Var2, this.a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        c0 c0Var = this.e;
        if (c0Var != null) {
            return c0Var.a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        c0 c0Var = this.e;
        if (c0Var != null) {
            return c0Var.b;
        }
        return null;
    }

    void e(AttributeSet attributeSet, int i) {
        Context context = this.a.getContext();
        int[] iArr = R$styleable.ViewBackgroundHelper;
        e0 e0VarV = e0.v(context, attributeSet, iArr, i, 0);
        View view = this.a;
        be3.n0(view, view.getContext(), iArr, attributeSet, e0VarV.r(), i, 0);
        try {
            int i2 = R$styleable.ViewBackgroundHelper_android_background;
            if (e0VarV.s(i2)) {
                this.c = e0VarV.n(i2, -1);
                ColorStateList colorStateListF = this.b.f(this.a.getContext(), this.c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            int i3 = R$styleable.ViewBackgroundHelper_backgroundTint;
            if (e0VarV.s(i3)) {
                be3.u0(this.a, e0VarV.c(i3));
            }
            int i4 = R$styleable.ViewBackgroundHelper_backgroundTintMode;
            if (e0VarV.s(i4)) {
                be3.v0(this.a, s.e(e0VarV.k(i4, -1), null));
            }
        } finally {
            e0VarV.x();
        }
    }

    void f(Drawable drawable) {
        this.c = -1;
        h(null);
        b();
    }

    void g(int i) {
        this.c = i;
        g gVar = this.b;
        h(gVar != null ? gVar.f(this.a.getContext(), i) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new c0();
            }
            c0 c0Var = this.d;
            c0Var.a = colorStateList;
            c0Var.d = true;
        } else {
            this.d = null;
        }
        b();
    }

    void i(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new c0();
        }
        c0 c0Var = this.e;
        c0Var.a = colorStateList;
        c0Var.d = true;
        b();
    }

    void j(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new c0();
        }
        c0 c0Var = this.e;
        c0Var.b = mode;
        c0Var.c = true;
        b();
    }
}
