package defpackage;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d6 {
    public static void a(View view, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.12f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.12f, 1.0f));
            animatorSet.setDuration(450L);
            animatorSet.start();
        }
    }

    public static void b(ImageView imageView, boolean z) {
        RotateAnimation rotateAnimation = new RotateAnimation(180.0f, 360.0f, imageView.getWidth() / 2.0f, imageView.getHeight() / 2.0f);
        rotateAnimation.setDuration(350L);
        imageView.startAnimation(rotateAnimation);
    }

    public static void c(View view, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.12f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.12f));
            animatorSet.setDuration(450L);
            animatorSet.start();
        }
    }
}
