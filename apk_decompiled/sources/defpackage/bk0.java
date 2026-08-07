package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R$id;

/* JADX INFO: loaded from: classes.dex */
public class bk0 extends ig3 {

    private static class a extends AnimatorListenerAdapter implements f53.f {
        private final View a;
        private boolean b = false;

        a(View view) {
            this.a = view;
        }

        @Override // f53.f
        public void a(f53 f53Var) {
        }

        @Override // f53.f
        public void b(f53 f53Var) {
            this.a.setTag(R$id.transition_pause_alpha, null);
        }

        @Override // f53.f
        public void c(f53 f53Var) {
        }

        @Override // f53.f
        public void e(f53 f53Var) {
            this.a.setTag(R$id.transition_pause_alpha, Float.valueOf(this.a.getVisibility() == 0 ? of3.b(this.a) : 0.0f));
        }

        @Override // f53.f
        public void f(f53 f53Var, boolean z) {
        }

        @Override // f53.f
        public void g(f53 f53Var) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            of3.e(this.a, 1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.a.hasOverlappingRendering() && this.a.getLayerType() == 0) {
                this.b = true;
                this.a.setLayerType(2, null);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            if (this.b) {
                this.a.setLayerType(0, null);
            }
            if (z) {
                return;
            }
            of3.e(this.a, 1.0f);
            of3.a(this.a);
        }
    }

    public bk0(int i) {
        l0(i);
    }

    private Animator m0(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        of3.e(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) of3.b, f2);
        a aVar = new a(view);
        objectAnimatorOfFloat.addListener(aVar);
        x().a(aVar);
        return objectAnimatorOfFloat;
    }

    private static float n0(s53 s53Var, float f) {
        Float f2;
        return (s53Var == null || (f2 = (Float) s53Var.a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    @Override // defpackage.ig3, defpackage.f53
    public void i(s53 s53Var) {
        super.i(s53Var);
        Float fValueOf = (Float) s53Var.b.getTag(R$id.transition_pause_alpha);
        if (fValueOf == null) {
            fValueOf = s53Var.b.getVisibility() == 0 ? Float.valueOf(of3.b(s53Var.b)) : Float.valueOf(0.0f);
        }
        s53Var.a.put("android:fade:transitionAlpha", fValueOf);
    }

    @Override // defpackage.ig3
    public Animator i0(ViewGroup viewGroup, View view, s53 s53Var, s53 s53Var2) {
        of3.c(view);
        return m0(view, n0(s53Var, 0.0f), 1.0f);
    }

    @Override // defpackage.ig3
    public Animator k0(ViewGroup viewGroup, View view, s53 s53Var, s53 s53Var2) {
        of3.c(view);
        Animator animatorM0 = m0(view, n0(s53Var, 1.0f), 0.0f);
        if (animatorM0 == null) {
            of3.e(view, n0(s53Var2, 1.0f));
        }
        return animatorM0;
    }

    public bk0() {
    }
}
