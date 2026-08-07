package defpackage;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class em1 implements ValueAnimator.AnimatorUpdateListener {
    private final a a;
    private final View[] b;

    interface a {
        void a(ValueAnimator valueAnimator, View view);
    }

    public em1(a aVar, View... viewArr) {
        this.a = aVar;
        this.b = viewArr;
    }

    public static em1 e(View... viewArr) {
        return new em1(new a() { // from class: dm1
            @Override // em1.a
            public final void a(ValueAnimator valueAnimator, View view) {
                em1.g(valueAnimator, view);
            }
        }, viewArr);
    }

    public static em1 f(View... viewArr) {
        return new em1(new a() { // from class: cm1
            @Override // em1.a
            public final void a(ValueAnimator valueAnimator, View view) {
                em1.h(valueAnimator, view);
            }
        }, viewArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(ValueAnimator valueAnimator, View view) {
        view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(ValueAnimator valueAnimator, View view) {
        Float f = (Float) valueAnimator.getAnimatedValue();
        view.setScaleX(f.floatValue());
        view.setScaleY(f.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(ValueAnimator valueAnimator, View view) {
        view.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(ValueAnimator valueAnimator, View view) {
        view.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static em1 k(View... viewArr) {
        return new em1(new a() { // from class: am1
            @Override // em1.a
            public final void a(ValueAnimator valueAnimator, View view) {
                em1.i(valueAnimator, view);
            }
        }, viewArr);
    }

    public static em1 l(View... viewArr) {
        return new em1(new a() { // from class: bm1
            @Override // em1.a
            public final void a(ValueAnimator valueAnimator, View view) {
                em1.j(valueAnimator, view);
            }
        }, viewArr);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        for (View view : this.b) {
            this.a.a(valueAnimator, view);
        }
    }
}
