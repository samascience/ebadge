package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import defpackage.be3;
import defpackage.d11;
import defpackage.v8;

/* JADX INFO: loaded from: classes.dex */
public class k {
    private final ImageView a;
    private c0 b;
    private c0 c;
    private c0 d;
    private int e = 0;

    public k(ImageView imageView) {
        this.a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new c0();
        }
        c0 c0Var = this.d;
        c0Var.a();
        ColorStateList colorStateListA = d11.a(this.a);
        if (colorStateListA != null) {
            c0Var.d = true;
            c0Var.a = colorStateListA;
        }
        PorterDuff.Mode modeB = d11.b(this.a);
        if (modeB != null) {
            c0Var.c = true;
            c0Var.b = modeB;
        }
        if (!c0Var.d && !c0Var.c) {
            return false;
        }
        g.i(drawable, c0Var, this.a.getDrawableState());
        return true;
    }

    private boolean l() {
        return this.b != null;
    }

    void b() {
        if (this.a.getDrawable() != null) {
            this.a.getDrawable().setLevel(this.e);
        }
    }

    void c() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            s.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            c0 c0Var = this.c;
            if (c0Var != null) {
                g.i(drawable, c0Var, this.a.getDrawableState());
                return;
            }
            c0 c0Var2 = this.b;
            if (c0Var2 != null) {
                g.i(drawable, c0Var2, this.a.getDrawableState());
            }
        }
    }

    ColorStateList d() {
        c0 c0Var = this.c;
        if (c0Var != null) {
            return c0Var.a;
        }
        return null;
    }

    PorterDuff.Mode e() {
        c0 c0Var = this.c;
        if (c0Var != null) {
            return c0Var.b;
        }
        return null;
    }

    boolean f() {
        return !(this.a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i) {
        int iN;
        Context context = this.a.getContext();
        int[] iArr = R$styleable.AppCompatImageView;
        e0 e0VarV = e0.v(context, attributeSet, iArr, i, 0);
        ImageView imageView = this.a;
        be3.n0(imageView, imageView.getContext(), iArr, attributeSet, e0VarV.r(), i, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null && (iN = e0VarV.n(R$styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = v8.b(this.a.getContext(), iN)) != null) {
                this.a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                s.b(drawable);
            }
            int i2 = R$styleable.AppCompatImageView_tint;
            if (e0VarV.s(i2)) {
                d11.c(this.a, e0VarV.c(i2));
            }
            int i3 = R$styleable.AppCompatImageView_tintMode;
            if (e0VarV.s(i3)) {
                d11.d(this.a, s.e(e0VarV.k(i3, -1), null));
            }
        } finally {
            e0VarV.x();
        }
    }

    void h(Drawable drawable) {
        this.e = drawable.getLevel();
    }

    public void i(int i) {
        if (i != 0) {
            Drawable drawableB = v8.b(this.a.getContext(), i);
            if (drawableB != null) {
                s.b(drawableB);
            }
            this.a.setImageDrawable(drawableB);
        } else {
            this.a.setImageDrawable(null);
        }
        c();
    }

    void j(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new c0();
        }
        c0 c0Var = this.c;
        c0Var.a = colorStateList;
        c0Var.d = true;
        c();
    }

    void k(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new c0();
        }
        c0 c0Var = this.c;
        c0Var.b = mode;
        c0Var.c = true;
        c();
    }
}
