package defpackage;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.skydoves.colorpickerview.R$anim;

/* JADX INFO: loaded from: classes.dex */
public abstract class fk0 {
    public static void a(View view) {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(view.getContext(), R$anim.fade_in);
        animationLoadAnimation.setFillAfter(true);
        view.startAnimation(animationLoadAnimation);
    }

    public static void b(View view) {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(view.getContext(), R$anim.fade_out);
        animationLoadAnimation.setFillAfter(true);
        view.startAnimation(animationLoadAnimation);
    }
}
