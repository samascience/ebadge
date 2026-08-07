package defpackage;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes.dex */
public class qe1 extends ug implements Choreographer.FrameCallback {
    private fe1 j;
    private float c = 1.0f;
    private boolean d = false;
    private long e = 0;
    private float f = 0.0f;
    private int g = 0;
    private float h = -2.1474836E9f;
    private float i = 2.1474836E9f;
    protected boolean k = false;

    private void A() {
        if (this.j == null) {
            return;
        }
        float f = this.f;
        if (f < this.h || f > this.i) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.h), Float.valueOf(this.i), Float.valueOf(this.f)));
        }
    }

    private float j() {
        fe1 fe1Var = this.j;
        if (fe1Var == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / fe1Var.h()) / Math.abs(this.c);
    }

    private boolean o() {
        return m() < 0.0f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        a();
        r();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        q();
        if (this.j == null || !isRunning()) {
            return;
        }
        long jNanoTime = System.nanoTime();
        float fJ = (jNanoTime - this.e) / j();
        float f = this.f;
        if (o()) {
            fJ = -fJ;
        }
        float f2 = f + fJ;
        this.f = f2;
        boolean zD = ok1.d(f2, l(), k());
        this.f = ok1.b(this.f, l(), k());
        this.e = jNanoTime;
        e();
        if (!zD) {
            if (getRepeatCount() == -1 || this.g < getRepeatCount()) {
                c();
                this.g++;
                if (getRepeatMode() == 2) {
                    this.d = !this.d;
                    t();
                } else {
                    this.f = o() ? k() : l();
                }
                this.e = jNanoTime;
            } else {
                this.f = k();
                r();
                b(o());
            }
        }
        A();
    }

    public void f() {
        this.j = null;
        this.h = -2.1474836E9f;
        this.i = 2.1474836E9f;
    }

    public void g() {
        r();
        b(o());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fL;
        float fK;
        float fL2;
        if (this.j == null) {
            return 0.0f;
        }
        if (o()) {
            fL = k() - this.f;
            fK = k();
            fL2 = l();
        } else {
            fL = this.f - l();
            fK = k();
            fL2 = l();
        }
        return fL / (fK - fL2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(h());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        fe1 fe1Var = this.j;
        if (fe1Var == null) {
            return 0L;
        }
        return (long) fe1Var.d();
    }

    public float h() {
        fe1 fe1Var = this.j;
        if (fe1Var == null) {
            return 0.0f;
        }
        return (this.f - fe1Var.m()) / (this.j.f() - this.j.m());
    }

    public float i() {
        return this.f;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.k;
    }

    public float k() {
        fe1 fe1Var = this.j;
        if (fe1Var == null) {
            return 0.0f;
        }
        float f = this.i;
        return f == 2.1474836E9f ? fe1Var.f() : f;
    }

    public float l() {
        fe1 fe1Var = this.j;
        if (fe1Var == null) {
            return 0.0f;
        }
        float f = this.h;
        return f == -2.1474836E9f ? fe1Var.m() : f;
    }

    public float m() {
        return this.c;
    }

    public void p() {
        this.k = true;
        d(o());
        v((int) (o() ? k() : l()));
        this.e = System.nanoTime();
        this.g = 0;
        q();
    }

    protected void q() {
        if (isRunning()) {
            s(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void r() {
        s(true);
    }

    protected void s(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.k = false;
        }
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.d) {
            return;
        }
        this.d = false;
        t();
    }

    public void t() {
        z(-m());
    }

    public void u(fe1 fe1Var) {
        boolean z = this.j == null;
        this.j = fe1Var;
        if (z) {
            x((int) Math.max(this.h, fe1Var.m()), (int) Math.min(this.i, fe1Var.f()));
        } else {
            x((int) fe1Var.m(), (int) fe1Var.f());
        }
        v((int) this.f);
        this.e = System.nanoTime();
    }

    public void v(int i) {
        float f = i;
        if (this.f == f) {
            return;
        }
        this.f = ok1.b(f, l(), k());
        this.e = System.nanoTime();
        e();
    }

    public void w(int i) {
        x((int) this.h, i);
    }

    public void x(int i, int i2) {
        fe1 fe1Var = this.j;
        float fM = fe1Var == null ? -3.4028235E38f : fe1Var.m();
        fe1 fe1Var2 = this.j;
        float f = fe1Var2 == null ? Float.MAX_VALUE : fe1Var2.f();
        float f2 = i;
        this.h = ok1.b(f2, fM, f);
        float f3 = i2;
        this.i = ok1.b(f3, fM, f);
        v((int) ok1.b(this.f, f2, f3));
    }

    public void y(int i) {
        x(i, (int) this.i);
    }

    public void z(float f) {
        this.c = f;
    }
}
