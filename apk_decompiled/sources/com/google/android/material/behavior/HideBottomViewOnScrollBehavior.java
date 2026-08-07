package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import defpackage.e43;
import defpackage.el1;
import defpackage.y6;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c {
    private static final int j = R$attr.motionDurationLong2;
    private static final int k = R$attr.motionDurationMedium4;
    private static final int l = R$attr.motionEasingEmphasizedInterpolator;
    private final LinkedHashSet a;
    private int b;
    private int c;
    private TimeInterpolator d;
    private TimeInterpolator e;
    private int f;
    private int g;
    private int h;
    private ViewPropertyAnimator i;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.i = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.a = new LinkedHashSet();
        this.f = 0;
        this.g = 2;
        this.h = 0;
    }

    private void J(View view, int i, long j2, TimeInterpolator timeInterpolator) {
        this.i = view.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j2).setListener(new a());
    }

    private void R(View view, int i) {
        this.g = i;
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean E(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        return i == 2;
    }

    public boolean K() {
        return this.g == 1;
    }

    public boolean L() {
        return this.g == 2;
    }

    public void M(View view, int i) {
        this.h = i;
        if (this.g == 1) {
            view.setTranslationY(this.f + i);
        }
    }

    public void N(View view) {
        O(view, true);
    }

    public void O(View view, boolean z) {
        if (K()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.i;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        R(view, 1);
        int i = this.f + this.h;
        if (z) {
            J(view, i, this.c, this.e);
        } else {
            view.setTranslationY(i);
        }
    }

    public void P(View view) {
        Q(view, true);
    }

    public void Q(View view, boolean z) {
        if (L()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.i;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        R(view, 2);
        if (z) {
            J(view, 0, this.b, this.d);
        } else {
            view.setTranslationY(0);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean p(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.b = el1.f(view.getContext(), j, 225);
        this.c = el1.f(view.getContext(), k, Opcodes.DRETURN);
        Context context = view.getContext();
        int i2 = l;
        this.d = el1.g(context, i2, y6.d);
        this.e = el1.g(view.getContext(), i2, y6.c);
        return super.p(coordinatorLayout, view, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i2 > 0) {
            N(view);
        } else if (i2 < 0) {
            P(view);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new LinkedHashSet();
        this.f = 0;
        this.g = 2;
        this.h = 0;
    }
}
