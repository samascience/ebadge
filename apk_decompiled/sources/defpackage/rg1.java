package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import com.google.android.material.R$dimen;
import com.google.android.material.internal.ClippableRoundedCornerLayout;

/* JADX INFO: loaded from: classes3.dex */
public class rg1 extends hg1 {
    private final float g;
    private final float h;
    private float i;
    private Rect j;
    private Rect k;
    private Integer l;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.a;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public rg1(View view) {
        super(view);
        Resources resources = view.getResources();
        this.g = resources.getDimension(R$dimen.m3_back_progress_main_container_min_edge_gap);
        this.h = resources.getDimension(R$dimen.m3_back_progress_main_container_max_translation_y);
    }

    private ValueAnimator h(final ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(clippableRoundedCornerLayout.getCornerRadius(), k());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: qg1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                rg1.q(clippableRoundedCornerLayout, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private AnimatorSet i(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.TRANSLATION_Y, 0.0f));
        animatorSet.addListener(new a(view));
        return animatorSet;
    }

    private int n() {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 31 || (rootWindowInsets = this.b.getRootWindowInsets()) == null) {
            return 0;
        }
        return Math.max(Math.max(o(rootWindowInsets, 0), o(rootWindowInsets, 1)), Math.max(o(rootWindowInsets, 3), o(rootWindowInsets, 2)));
    }

    private int o(WindowInsets windowInsets, int i) {
        RoundedCorner roundedCorner = windowInsets.getRoundedCorner(i);
        if (roundedCorner != null) {
            return roundedCorner.getRadius();
        }
        return 0;
    }

    private boolean p() {
        int[] iArr = new int[2];
        this.b.getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(ClippableRoundedCornerLayout clippableRoundedCornerLayout, ValueAnimator valueAnimator) {
        clippableRoundedCornerLayout.e(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private void r() {
        this.i = 0.0f;
        this.j = null;
        this.k = null;
    }

    public void g(View view) {
        if (super.b() == null) {
            return;
        }
        AnimatorSet animatorSetI = i(view);
        View view2 = this.b;
        if (view2 instanceof ClippableRoundedCornerLayout) {
            animatorSetI.playTogether(h((ClippableRoundedCornerLayout) view2));
        }
        animatorSetI.setDuration(this.e);
        animatorSetI.start();
        r();
    }

    public void j(long j, View view) {
        AnimatorSet animatorSetI = i(view);
        animatorSetI.setDuration(j);
        animatorSetI.start();
        r();
    }

    public int k() {
        if (this.l == null) {
            this.l = Integer.valueOf(p() ? n() : 0);
        }
        return this.l.intValue();
    }

    public Rect l() {
        return this.k;
    }

    public Rect m() {
        return this.j;
    }

    public void s(float f, View view) {
        this.j = nf3.c(this.b);
        if (view != null) {
            this.k = nf3.b(this.b, view);
        }
        this.i = f;
    }

    public void t(he heVar, View view) {
        super.d(heVar);
        s(heVar.c(), view);
    }

    public void u(float f, boolean z, float f2, float f3) {
        float fA = a(f);
        float width = this.b.getWidth();
        float height = this.b.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float fA2 = y6.a(1.0f, 0.9f, fA);
        float fA3 = y6.a(0.0f, Math.max(0.0f, ((width - (0.9f * width)) / 2.0f) - this.g), fA) * (z ? 1 : -1);
        float fMin = Math.min(Math.max(0.0f, ((height - (fA2 * height)) / 2.0f) - this.g), this.h);
        float f4 = f2 - this.i;
        float fA4 = y6.a(0.0f, fMin, Math.abs(f4) / height) * Math.signum(f4);
        this.b.setScaleX(fA2);
        this.b.setScaleY(fA2);
        this.b.setTranslationX(fA3);
        this.b.setTranslationY(fA4);
        View view = this.b;
        if (view instanceof ClippableRoundedCornerLayout) {
            ((ClippableRoundedCornerLayout) view).e(y6.a(k(), f3, fA));
        }
    }

    public void v(he heVar, View view, float f) {
        if (super.e(heVar) == null) {
            return;
        }
        if (view != null && view.getVisibility() != 4) {
            view.setVisibility(4);
        }
        u(heVar.a(), heVar.b() == 0, heVar.c(), f);
    }
}
