package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.appcompat.R$styleable;
import defpackage.be3;
import defpackage.dd0;
import defpackage.mx;
import defpackage.v8;

/* JADX INFO: loaded from: classes.dex */
class e {
    private final CheckedTextView a;
    private ColorStateList b = null;
    private PorterDuff.Mode c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f;

    e(CheckedTextView checkedTextView) {
        this.a = checkedTextView;
    }

    void a() {
        Drawable drawableA = mx.a(this.a);
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
                this.a.setCheckMarkDrawable(drawableMutate);
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
        int[] iArr = R$styleable.CheckedTextView;
        e0 e0VarV = e0.v(context, attributeSet, iArr, i, 0);
        CheckedTextView checkedTextView = this.a;
        be3.n0(checkedTextView, checkedTextView.getContext(), iArr, attributeSet, e0VarV.r(), i, 0);
        try {
            int i3 = R$styleable.CheckedTextView_checkMarkCompat;
            if (!e0VarV.s(i3) || (iN2 = e0VarV.n(i3, 0)) == 0) {
                i2 = R$styleable.CheckedTextView_android_checkMark;
                if (e0VarV.s(i2) && (iN = e0VarV.n(i2, 0)) != 0) {
                    CheckedTextView checkedTextView2 = this.a;
                    checkedTextView2.setCheckMarkDrawable(v8.b(checkedTextView2.getContext(), iN));
                }
            } else {
                try {
                    CheckedTextView checkedTextView3 = this.a;
                    checkedTextView3.setCheckMarkDrawable(v8.b(checkedTextView3.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                    i2 = R$styleable.CheckedTextView_android_checkMark;
                    if (e0VarV.s(i2)) {
                        CheckedTextView checkedTextView4 = this.a;
                        checkedTextView4.setCheckMarkDrawable(v8.b(checkedTextView4.getContext(), iN));
                    }
                }
            }
            int i4 = R$styleable.CheckedTextView_checkMarkTint;
            if (e0VarV.s(i4)) {
                mx.b(this.a, e0VarV.c(i4));
            }
            int i5 = R$styleable.CheckedTextView_checkMarkTintMode;
            if (e0VarV.s(i5)) {
                mx.c(this.a, s.e(e0VarV.k(i5, -1), null));
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
