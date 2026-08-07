package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R$dimen;

/* JADX INFO: loaded from: classes3.dex */
public class mg1 extends hg1 {
    private final float g;
    private final float h;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            mg1.this.b.setTranslationY(0.0f);
            mg1.this.k(0.0f);
        }
    }

    public mg1(View view) {
        super(view);
        Resources resources = view.getResources();
        this.g = resources.getDimension(R$dimen.m3_back_progress_bottom_container_max_scale_x_distance);
        this.h = resources.getDimension(R$dimen.m3_back_progress_bottom_container_max_scale_y_distance);
    }

    private Animator g() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.SCALE_Y, 1.0f));
        View view = this.b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new qk0());
        return animatorSet;
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        Animator animatorG = g();
        animatorG.setDuration(this.e);
        animatorG.start();
    }

    public void h(he heVar, Animator.AnimatorListener animatorListener) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.TRANSLATION_Y, this.b.getHeight() * this.b.getScaleY());
        objectAnimatorOfFloat.setInterpolator(new qk0());
        objectAnimatorOfFloat.setDuration(y6.c(this.c, this.d, heVar.a()));
        objectAnimatorOfFloat.addListener(new a());
        if (animatorListener != null) {
            objectAnimatorOfFloat.addListener(animatorListener);
        }
        objectAnimatorOfFloat.start();
    }

    public void i(he heVar, Animator.AnimatorListener animatorListener) {
        Animator animatorG = g();
        animatorG.setDuration(y6.c(this.c, this.d, heVar.a()));
        if (animatorListener != null) {
            animatorG.addListener(animatorListener);
        }
        animatorG.start();
    }

    public void j(he heVar) {
        super.d(heVar);
    }

    public void k(float f) {
        float fA = a(f);
        float width = this.b.getWidth();
        float height = this.b.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f2 = this.g / width;
        float f3 = this.h / height;
        float fA2 = 1.0f - y6.a(0.0f, f2, fA);
        float fA3 = 1.0f - y6.a(0.0f, f3, fA);
        this.b.setScaleX(fA2);
        this.b.setPivotY(height);
        this.b.setScaleY(fA3);
        View view = this.b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                childAt.setPivotY(-childAt.getTop());
                childAt.setScaleY(fA3 != 0.0f ? fA2 / fA3 : 1.0f);
            }
        }
    }

    public void l(he heVar) {
        if (super.e(heVar) == null) {
            return;
        }
        k(heVar.a());
    }
}
