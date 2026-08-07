package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R$dimen;

/* JADX INFO: loaded from: classes3.dex */
public class vg1 extends hg1 {
    private final float g;
    private final float h;
    private final float i;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ int b;

        a(boolean z, int i) {
            this.a = z;
            this.b = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            vg1.this.b.setTranslationX(0.0f);
            vg1.this.k(0.0f, this.a, this.b);
        }
    }

    public vg1(View view) {
        super(view);
        Resources resources = view.getResources();
        this.g = resources.getDimension(R$dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.h = resources.getDimension(R$dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.i = resources.getDimension(R$dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    private boolean g(int i, int i2) {
        return (iv0.b(i, be3.A(this.b)) & i2) == i2;
    }

    private int i(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return z ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.SCALE_Y, 1.0f));
        View view = this.b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.e);
        animatorSet.start();
    }

    public void h(he heVar, int i, Animator.AnimatorListener animatorListener, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        boolean z = heVar.b() == 0;
        boolean zG = g(i, 3);
        float width = (this.b.getWidth() * this.b.getScaleX()) + i(zG);
        View view = this.b;
        Property property = View.TRANSLATION_X;
        if (zG) {
            width = -width;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, width);
        if (animatorUpdateListener != null) {
            objectAnimatorOfFloat.addUpdateListener(animatorUpdateListener);
        }
        objectAnimatorOfFloat.setInterpolator(new qk0());
        objectAnimatorOfFloat.setDuration(y6.c(this.c, this.d, heVar.a()));
        objectAnimatorOfFloat.addListener(new a(z, i));
        if (animatorListener != null) {
            objectAnimatorOfFloat.addListener(animatorListener);
        }
        objectAnimatorOfFloat.start();
    }

    public void j(he heVar) {
        super.d(heVar);
    }

    public void k(float f, boolean z, int i) {
        float fA = a(f);
        boolean zG = g(i, 3);
        boolean z2 = z == zG;
        int width = this.b.getWidth();
        int height = this.b.getHeight();
        float f2 = width;
        if (f2 > 0.0f) {
            float f3 = height;
            if (f3 <= 0.0f) {
                return;
            }
            float f4 = this.g / f2;
            float f5 = this.h / f2;
            float f6 = this.i / f3;
            View view = this.b;
            if (zG) {
                f2 = 0.0f;
            }
            view.setPivotX(f2);
            if (!z2) {
                f5 = -f4;
            }
            float fA2 = y6.a(0.0f, f5, fA);
            float f7 = fA2 + 1.0f;
            this.b.setScaleX(f7);
            float fA3 = 1.0f - y6.a(0.0f, f6, fA);
            this.b.setScaleY(fA3);
            View view2 = this.b;
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    childAt.setPivotX(zG ? (width - childAt.getRight()) + childAt.getWidth() : -childAt.getLeft());
                    childAt.setPivotY(-childAt.getTop());
                    float f8 = z2 ? 1.0f - fA2 : 1.0f;
                    float f9 = fA3 != 0.0f ? (f7 / fA3) * f8 : 1.0f;
                    childAt.setScaleX(f8);
                    childAt.setScaleY(f9);
                }
            }
        }
    }

    public void l(he heVar, int i) {
        if (super.e(heVar) == null) {
            return;
        }
        k(heVar.a(), heVar.b() == 0, i);
    }
}
