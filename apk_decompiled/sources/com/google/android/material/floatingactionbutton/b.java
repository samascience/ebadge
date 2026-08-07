package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import defpackage.b52;
import defpackage.c7;
import defpackage.cl1;
import defpackage.y6;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class b implements f {
    private final Context a;
    private final ExtendedFloatingActionButton b;
    private final ArrayList c = new ArrayList();
    private final com.google.android.material.floatingactionbutton.a d;
    private cl1 e;
    private cl1 f;

    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            return Float.valueOf(y6.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.M.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.b.M.getDefaultColor()))));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f) {
            int colorForState = extendedFloatingActionButton.M.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.b.M.getDefaultColor());
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.argb((int) (y6.a(0.0f, Color.alpha(colorForState) / 255.0f, f.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f.floatValue() == 1.0f) {
                extendedFloatingActionButton.C(extendedFloatingActionButton.M);
            } else {
                extendedFloatingActionButton.C(colorStateListValueOf);
            }
        }
    }

    b(ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.a aVar) {
        this.b = extendedFloatingActionButton;
        this.a = extendedFloatingActionButton.getContext();
        this.d = aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public void a() {
        this.d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public cl1 d() {
        return this.f;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public void f() {
        this.d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public AnimatorSet g() {
        return l(m());
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final List h() {
        return this.c;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final void j(cl1 cl1Var) {
        this.f = cl1Var;
    }

    AnimatorSet l(cl1 cl1Var) {
        ArrayList arrayList = new ArrayList();
        if (cl1Var.j("opacity")) {
            arrayList.add(cl1Var.f("opacity", this.b, View.ALPHA));
        }
        if (cl1Var.j("scale")) {
            arrayList.add(cl1Var.f("scale", this.b, View.SCALE_Y));
            arrayList.add(cl1Var.f("scale", this.b, View.SCALE_X));
        }
        if (cl1Var.j("width")) {
            arrayList.add(cl1Var.f("width", this.b, ExtendedFloatingActionButton.R));
        }
        if (cl1Var.j("height")) {
            arrayList.add(cl1Var.f("height", this.b, ExtendedFloatingActionButton.S));
        }
        if (cl1Var.j("paddingStart")) {
            arrayList.add(cl1Var.f("paddingStart", this.b, ExtendedFloatingActionButton.T));
        }
        if (cl1Var.j("paddingEnd")) {
            arrayList.add(cl1Var.f("paddingEnd", this.b, ExtendedFloatingActionButton.U));
        }
        if (cl1Var.j("labelOpacity")) {
            arrayList.add(cl1Var.f("labelOpacity", this.b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        c7.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final cl1 m() {
        cl1 cl1Var = this.f;
        if (cl1Var != null) {
            return cl1Var;
        }
        if (this.e == null) {
            this.e = cl1.d(this.a, b());
        }
        return (cl1) b52.g(this.e);
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public void onAnimationStart(Animator animator) {
        this.d.c(animator);
    }
}
