package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;
import defpackage.be3;
import defpackage.dd0;

/* JADX INFO: loaded from: classes.dex */
class o extends m {
    private final SeekBar d;
    private Drawable e;
    private ColorStateList f;
    private PorterDuff.Mode g;
    private boolean h;
    private boolean i;

    o(SeekBar seekBar) {
        super(seekBar);
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = false;
        this.d = seekBar;
    }

    private void f() {
        Drawable drawable = this.e;
        if (drawable != null) {
            if (this.h || this.i) {
                Drawable drawableR = dd0.r(drawable.mutate());
                this.e = drawableR;
                if (this.h) {
                    dd0.o(drawableR, this.f);
                }
                if (this.i) {
                    dd0.p(this.e, this.g);
                }
                if (this.e.isStateful()) {
                    this.e.setState(this.d.getDrawableState());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.m
    void c(AttributeSet attributeSet, int i) {
        super.c(attributeSet, i);
        Context context = this.d.getContext();
        int[] iArr = R$styleable.AppCompatSeekBar;
        e0 e0VarV = e0.v(context, attributeSet, iArr, i, 0);
        SeekBar seekBar = this.d;
        be3.n0(seekBar, seekBar.getContext(), iArr, attributeSet, e0VarV.r(), i, 0);
        Drawable drawableH = e0VarV.h(R$styleable.AppCompatSeekBar_android_thumb);
        if (drawableH != null) {
            this.d.setThumb(drawableH);
        }
        j(e0VarV.g(R$styleable.AppCompatSeekBar_tickMark));
        int i2 = R$styleable.AppCompatSeekBar_tickMarkTintMode;
        if (e0VarV.s(i2)) {
            this.g = s.e(e0VarV.k(i2, -1), this.g);
            this.i = true;
        }
        int i3 = R$styleable.AppCompatSeekBar_tickMarkTint;
        if (e0VarV.s(i3)) {
            this.f = e0VarV.c(i3);
            this.h = true;
        }
        e0VarV.x();
        f();
    }

    void g(Canvas canvas) {
        if (this.e != null) {
            int max = this.d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.e.getIntrinsicWidth();
                int intrinsicHeight = this.e.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.e.setBounds(-i, -i2, i, i2);
                float width = ((this.d.getWidth() - this.d.getPaddingLeft()) - this.d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.d.getPaddingLeft(), this.d.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    void h() {
        Drawable drawable = this.e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.d.getDrawableState())) {
            this.d.invalidateDrawable(drawable);
        }
    }

    void i() {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.d);
            dd0.m(drawable, this.d.getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(this.d.getDrawableState());
            }
            f();
        }
        this.d.invalidate();
    }
}
