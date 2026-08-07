package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class xe3 {
    private final WeakReference a;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ ze3 a;
        final /* synthetic */ View b;

        a(ze3 ze3Var, View view) {
            this.a = ze3Var;
            this.b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a.a(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.b(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.c(this.b);
        }
    }

    xe3(View view) {
        this.a = new WeakReference(view);
    }

    private void i(View view, ze3 ze3Var) {
        if (ze3Var != null) {
            view.animate().setListener(new a(ze3Var, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public xe3 b(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public void c() {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = (View) this.a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public xe3 f(long j) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public xe3 g(Interpolator interpolator) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public xe3 h(ze3 ze3Var) {
        View view = (View) this.a.get();
        if (view != null) {
            i(view, ze3Var);
        }
        return this;
    }

    public xe3 j(long j) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public xe3 k(final bf3 bf3Var) {
        final View view = (View) this.a.get();
        if (view != null) {
            view.animate().setUpdateListener(bf3Var != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: we3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    bf3Var.a(view);
                }
            } : null);
        }
        return this;
    }

    public void l() {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public xe3 m(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }
}
