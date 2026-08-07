package defpackage;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class dk0 implements ValueAnimator.AnimatorUpdateListener {
    private final View a;
    private final View b;
    private final float[] c = new float[2];

    public dk0(View view, View view2) {
        this.a = view;
        this.b = view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        ek0.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.c);
        View view = this.a;
        if (view != null) {
            view.setAlpha(this.c[0]);
        }
        View view2 = this.b;
        if (view2 != null) {
            view2.setAlpha(this.c[1]);
        }
    }
}
