package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.Property;
import android.view.View;
import com.google.android.material.R$color;
import defpackage.b52;
import defpackage.q30;
import defpackage.rn2;
import defpackage.sn2;
import defpackage.tg1;
import defpackage.zh2;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class e extends d {
    private StateListAnimator O;

    static class a extends tg1 {
        a(sn2 sn2Var) {
            super(sn2Var);
        }

        @Override // defpackage.tg1, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    e(FloatingActionButton floatingActionButton, rn2 rn2Var) {
        super(floatingActionButton, rn2Var);
    }

    private StateListAnimator j0(float f, float f2, float f3) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(d.I, k0(f, f3));
        stateListAnimator.addState(d.J, k0(f, f2));
        stateListAnimator.addState(d.K, k0(f, f2));
        stateListAnimator.addState(d.L, k0(f, f2));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.w, "elevation", f).setDuration(0L));
        arrayList.add(ObjectAnimator.ofFloat(this.w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(d.D);
        stateListAnimator.addState(d.M, animatorSet);
        stateListAnimator.addState(d.N, k0(0.0f, 0.0f));
        return stateListAnimator;
    }

    private Animator k0(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.w, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(d.D);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void A() {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void C() {
        f0();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void E(int[] iArr) {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void F(float f, float f2, float f3) {
        if (this.w.getStateListAnimator() == this.O) {
            StateListAnimator stateListAnimatorJ0 = j0(f, f2, f3);
            this.O = stateListAnimatorJ0;
            this.w.setStateListAnimator(stateListAnimatorJ0);
        }
        if (Z()) {
            f0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean K() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void V(ColorStateList colorStateList) {
        Drawable drawable = this.c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(zh2.d(colorStateList));
        } else {
            super.V(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean Z() {
        return this.x.d() || !b0();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void d0() {
    }

    c i0(int i, ColorStateList colorStateList) {
        Context context = this.w.getContext();
        c cVar = new c((sn2) b52.g(this.a));
        cVar.e(q30.c(context, R$color.design_fab_stroke_top_outer_color), q30.c(context, R$color.design_fab_stroke_top_inner_color), q30.c(context, R$color.design_fab_stroke_end_inner_color), q30.c(context, R$color.design_fab_stroke_end_outer_color));
        cVar.d(i);
        cVar.c(colorStateList);
        return cVar;
    }

    tg1 l0() {
        return new a((sn2) b52.g(this.a));
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public float m() {
        return this.w.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void r(Rect rect) {
        if (this.x.d()) {
            super.r(rect);
        } else if (b0()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.k - this.w.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void x(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable layerDrawable;
        tg1 tg1VarL0 = l0();
        this.b = tg1VarL0;
        tg1VarL0.setTintList(colorStateList);
        if (mode != null) {
            this.b.setTintMode(mode);
        }
        this.b.Q(this.w.getContext());
        if (i > 0) {
            this.d = i0(i, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{(Drawable) b52.g(this.d), (Drawable) b52.g(this.b)});
        } else {
            this.d = null;
            layerDrawable = this.b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(zh2.d(colorStateList2), layerDrawable, null);
        this.c = rippleDrawable;
        this.e = rippleDrawable;
    }
}
