package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class nc1 {
    private final ValueAnimator.AnimatorUpdateListener a = new a();
    protected final Rect b = new Rect();
    private Drawable.Callback c;
    private ValueAnimator d;
    protected long e;
    protected float f;
    protected float g;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            nc1.this.c(((Float) valueAnimator.getAnimatedValue()).floatValue());
            nc1.this.e();
        }
    }

    public nc1(Context context) {
        float fA = va3.a(context, 56.0f);
        this.g = fA;
        this.f = fA;
        this.e = 1333L;
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.c.invalidateDrawable(null);
    }

    private void l() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.d = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setRepeatCount(-1);
        this.d.setRepeatMode(1);
        this.d.setDuration(this.e);
        this.d.setInterpolator(new LinearInterpolator());
        this.d.addUpdateListener(this.a);
    }

    protected void b(Animator.AnimatorListener animatorListener) {
        this.d.addListener(animatorListener);
    }

    protected abstract void c(float f);

    protected abstract void d(Canvas canvas);

    boolean f() {
        return this.d.isRunning();
    }

    protected abstract void g();

    protected abstract void h(int i);

    void i(Rect rect) {
        this.b.set(rect);
    }

    void j(Drawable.Callback callback) {
        this.c = callback;
    }

    protected abstract void k(ColorFilter colorFilter);

    void m() {
        g();
        this.d.addUpdateListener(this.a);
        this.d.setRepeatCount(-1);
        this.d.setDuration(this.e);
        this.d.start();
    }

    void n() {
        this.d.removeUpdateListener(this.a);
        this.d.setRepeatCount(0);
        this.d.setDuration(0L);
        this.d.end();
    }
}
