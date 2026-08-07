package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R$styleable;
import defpackage.be3;
import defpackage.dd0;
import defpackage.f10;
import defpackage.v8;

/* JADX INFO: loaded from: classes.dex */
class f {
    private final CompoundButton a;
    private ColorStateList b = null;
    private PorterDuff.Mode c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f;

    f(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    void a() {
        Drawable drawableA = f10.a(this.a);
        if (drawableA != null) {
            if (this.d || this.e) {
                Drawable drawableMutate = dd0.r(drawableA).mutate();
                if (this.d) {
                    dd0.o(drawableMutate, this.b);
                }
                if (this.e) {
                    dd0.p(drawableMutate, this.c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.a.getDrawableState());
                }
                this.a.setButtonDrawable(drawableMutate);
            }
        }
    }

    ColorStateList b() {
        return this.b;
    }

    PorterDuff.Mode c() {
        return this.c;
    }

    void d(AttributeSet attributeSet, int i) {
        int i2;
        int iN;
        int iN2;
        Context context = this.a.getContext();
        int[] iArr = R$styleable.CompoundButton;
        e0 e0VarV = e0.v(context, attributeSet, iArr, i, 0);
        CompoundButton compoundButton = this.a;
        be3.n0(compoundButton, compoundButton.getContext(), iArr, attributeSet, e0VarV.r(), i, 0);
        try {
            int i3 = R$styleable.CompoundButton_buttonCompat;
            if (!e0VarV.s(i3) || (iN2 = e0VarV.n(i3, 0)) == 0) {
                i2 = R$styleable.CompoundButton_android_button;
                if (e0VarV.s(i2) && (iN = e0VarV.n(i2, 0)) != 0) {
                    CompoundButton compoundButton2 = this.a;
                    compoundButton2.setButtonDrawable(v8.b(compoundButton2.getContext(), iN));
                }
            } else {
                try {
                    CompoundButton compoundButton3 = this.a;
                    compoundButton3.setButtonDrawable(v8.b(compoundButton3.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                    i2 = R$styleable.CompoundButton_android_button;
                    if (e0VarV.s(i2)) {
                        CompoundButton compoundButton4 = this.a;
                        compoundButton4.setButtonDrawable(v8.b(compoundButton4.getContext(), iN));
                    }
                }
            }
            int i4 = R$styleable.CompoundButton_buttonTint;
            if (e0VarV.s(i4)) {
                f10.d(this.a, e0VarV.c(i4));
            }
            int i5 = R$styleable.CompoundButton_buttonTintMode;
            if (e0VarV.s(i5)) {
                f10.e(this.a, s.e(e0VarV.k(i5, -1), null));
            }
        } finally {
            e0VarV.x();
        }
    }

    void e() {
        if (this.f) {
            this.f = false;
        } else {
            this.f = true;
            a();
        }
    }

    void f(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.d = true;
        a();
    }

    void g(PorterDuff.Mode mode) {
        this.c = mode;
        this.e = true;
        a();
    }
}
