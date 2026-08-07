package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import defpackage.e6;
import defpackage.m9;
import defpackage.qk0;

/* JADX INFO: loaded from: classes3.dex */
final class c extends h {
    private static final int[] k = {0, 1350, 2700, 4050};
    private static final int[] l = {667, 2017, 3367, 4717};
    private static final int[] m = {1000, 2350, 3700, 5050};
    private static final Property n = new C0092c(Float.class, "animationFraction");
    private static final Property o = new d(Float.class, "completeEndFraction");
    private ObjectAnimator c;
    private ObjectAnimator d;
    private final qk0 e;
    private final com.google.android.material.progressindicator.a f;
    private int g;
    private float h;
    private float i;
    e6 j;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            c cVar = c.this;
            cVar.g = (cVar.g + 4) % c.this.f.c.length;
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c.this.a();
            c cVar = c.this;
            e6 e6Var = cVar.j;
            if (e6Var != null) {
                e6Var.b(cVar.a);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.progressindicator.c$c, reason: collision with other inner class name */
    class C0092c extends Property {
        C0092c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(c cVar) {
            return Float.valueOf(cVar.o());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, Float f) {
            cVar.t(f.floatValue());
        }
    }

    class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(c cVar) {
            return Float.valueOf(cVar.p());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, Float f) {
            cVar.u(f.floatValue());
        }
    }

    public c(com.google.android.material.progressindicator.d dVar) {
        super(1);
        this.g = 0;
        this.j = null;
        this.f = dVar;
        this.e = new qk0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float o() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p() {
        return this.i;
    }

    private void q() {
        if (this.c == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<c, Float>) n, 0.0f, 1.0f);
            this.c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(5400L);
            this.c.setInterpolator(null);
            this.c.setRepeatCount(-1);
            this.c.addListener(new a());
        }
        if (this.d == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<c, Float>) o, 0.0f, 1.0f);
            this.d = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(333L);
            this.d.setInterpolator(this.e);
            this.d.addListener(new b());
        }
    }

    private void r(int i) {
        for (int i2 = 0; i2 < 4; i2++) {
            float fB = b(i, m[i2], 333);
            if (fB >= 0.0f && fB <= 1.0f) {
                int i3 = i2 + this.g;
                int[] iArr = this.f.c;
                int length = i3 % iArr.length;
                int length2 = (length + 1) % iArr.length;
                int i4 = iArr[length];
                int i5 = iArr[length2];
                ((g.a) this.b.get(0)).c = m9.b().evaluate(this.e.getInterpolation(fB), Integer.valueOf(i4), Integer.valueOf(i5)).intValue();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(float f) {
        this.i = f;
    }

    private void v(int i) {
        g.a aVar = (g.a) this.b.get(0);
        float f = this.h;
        aVar.a = (f * 1520.0f) - 20.0f;
        aVar.b = f * 1520.0f;
        for (int i2 = 0; i2 < 4; i2++) {
            aVar.b += this.e.getInterpolation(b(i, k[i2], 667)) * 250.0f;
            aVar.a += this.e.getInterpolation(b(i, l[i2], 667)) * 250.0f;
        }
        float f2 = aVar.a;
        float f3 = aVar.b;
        aVar.a = (f2 + ((f3 - f2) * this.i)) / 360.0f;
        aVar.b = f3 / 360.0f;
    }

    @Override // com.google.android.material.progressindicator.h
    void a() {
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void c() {
        s();
    }

    @Override // com.google.android.material.progressindicator.h
    public void d(e6 e6Var) {
        this.j = e6Var;
    }

    @Override // com.google.android.material.progressindicator.h
    void f() {
        ObjectAnimator objectAnimator = this.d;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        if (this.a.isVisible()) {
            this.d.start();
        } else {
            a();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    void g() {
        q();
        s();
        this.c.start();
    }

    @Override // com.google.android.material.progressindicator.h
    public void h() {
        this.j = null;
    }

    void s() {
        this.g = 0;
        ((g.a) this.b.get(0)).c = this.f.c[0];
        this.i = 0.0f;
    }

    void t(float f) {
        this.h = f;
        int i = (int) (f * 5400.0f);
        v(i);
        r(i);
        this.a.invalidateSelf();
    }
}
