package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import defpackage.a7;
import defpackage.e6;
import defpackage.y6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class f extends Drawable implements Animatable {
    private static final Property o = new c(Float.class, "growFraction");
    final Context a;
    final com.google.android.material.progressindicator.a b;
    private ValueAnimator d;
    private ValueAnimator e;
    private boolean f;
    private boolean g;
    private float h;
    private List i;
    private e6 j;
    private boolean k;
    private float l;
    private int n;
    final Paint m = new Paint();
    a7 c = new a7();

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            f.this.f();
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            f.super.setVisible(false, false);
            f.this.e();
        }
    }

    class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(f fVar) {
            return Float.valueOf(fVar.h());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(f fVar, Float f) {
            fVar.n(f.floatValue());
        }
    }

    f(Context context, com.google.android.material.progressindicator.a aVar) {
        this.a = context;
        this.b = aVar;
        setAlpha(255);
    }

    private void d(ValueAnimator... valueAnimatorArr) {
        boolean z = this.k;
        this.k = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.cancel();
        }
        this.k = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        e6 e6Var = this.j;
        if (e6Var != null) {
            e6Var.b(this);
        }
        List list = this.i;
        if (list == null || this.k) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((e6) it.next()).b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        e6 e6Var = this.j;
        if (e6Var != null) {
            e6Var.c(this);
        }
        List list = this.i;
        if (list == null || this.k) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((e6) it.next()).c(this);
        }
    }

    private void g(ValueAnimator... valueAnimatorArr) {
        boolean z = this.k;
        this.k = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.k = z;
    }

    private void l() {
        if (this.d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<f, Float>) o, 0.0f, 1.0f);
            this.d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.d.setInterpolator(y6.b);
            p(this.d);
        }
        if (this.e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<f, Float>) o, 1.0f, 0.0f);
            this.e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(500L);
            this.e.setInterpolator(y6.b);
            o(this.e);
        }
    }

    private void o(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.e;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.e = valueAnimator;
        valueAnimator.addListener(new b());
    }

    private void p(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.d = valueAnimator;
        valueAnimator.addListener(new a());
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    float h() {
        if (this.b.b() || this.b.a()) {
            return (this.g || this.f) ? this.h : this.l;
        }
        return 1.0f;
    }

    public boolean i() {
        return q(false, false, false);
    }

    public boolean isRunning() {
        return k() || j();
    }

    public boolean j() {
        ValueAnimator valueAnimator = this.e;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.g;
    }

    public boolean k() {
        ValueAnimator valueAnimator = this.d;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f;
    }

    public void m(e6 e6Var) {
        if (this.i == null) {
            this.i = new ArrayList();
        }
        if (this.i.contains(e6Var)) {
            return;
        }
        this.i.add(e6Var);
    }

    void n(float f) {
        if (this.l != f) {
            this.l = f;
            invalidateSelf();
        }
    }

    public boolean q(boolean z, boolean z2, boolean z3) {
        return r(z, z2, z3 && this.c.a(this.a.getContentResolver()) > 0.0f);
    }

    boolean r(boolean z, boolean z2, boolean z3) {
        l();
        if (!isVisible() && !z) {
            return false;
        }
        ValueAnimator valueAnimator = z ? this.d : this.e;
        ValueAnimator valueAnimator2 = z ? this.e : this.d;
        if (!z3) {
            if (valueAnimator2.isRunning()) {
                d(valueAnimator2);
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                g(valueAnimator);
            }
            return super.setVisible(z, false);
        }
        if (valueAnimator.isRunning()) {
            return false;
        }
        boolean z4 = !z || super.setVisible(z, false);
        if (!(z ? this.b.b() : this.b.a())) {
            g(valueAnimator);
            return z4;
        }
        if (z2 || !valueAnimator.isPaused()) {
            valueAnimator.start();
        } else {
            valueAnimator.resume();
        }
        return z4;
    }

    public boolean s(e6 e6Var) {
        List list = this.i;
        if (list == null || !list.contains(e6Var)) {
            return false;
        }
        this.i.remove(e6Var);
        if (!this.i.isEmpty()) {
            return true;
        }
        this.i = null;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.n = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.m.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return q(z, z2, true);
    }

    public void start() {
        r(true, true, false);
    }

    public void stop() {
        r(false, true, false);
    }
}
