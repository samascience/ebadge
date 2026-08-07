package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import defpackage.e6;
import defpackage.qk0;

/* JADX INFO: loaded from: classes3.dex */
final class k extends h {
    private static final Property i = new b(Float.class, "animationFraction");
    private ObjectAnimator c;
    private qk0 d;
    private final com.google.android.material.progressindicator.a e;
    private int f;
    private boolean g;
    private float h;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            k kVar = k.this;
            kVar.f = (kVar.f + 1) % k.this.e.c.length;
            k.this.g = true;
        }
    }

    class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(k kVar) {
            return Float.valueOf(kVar.n());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, Float f) {
            kVar.r(f.floatValue());
        }
    }

    public k(m mVar) {
        super(3);
        this.f = 1;
        this.e = mVar;
        this.d = new qk0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.h;
    }

    private void o() {
        if (this.c == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<k, Float>) i, 0.0f, 1.0f);
            this.c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(333L);
            this.c.setInterpolator(null);
            this.c.setRepeatCount(-1);
            this.c.addListener(new a());
        }
    }

    private void p() {
        if (!this.g || ((g.a) this.b.get(1)).b >= 1.0f) {
            return;
        }
        ((g.a) this.b.get(2)).c = ((g.a) this.b.get(1)).c;
        ((g.a) this.b.get(1)).c = ((g.a) this.b.get(0)).c;
        ((g.a) this.b.get(0)).c = this.e.c[this.f];
        this.g = false;
    }

    private void s(int i2) {
        ((g.a) this.b.get(0)).a = 0.0f;
        float fB = b(i2, 0, 667);
        g.a aVar = (g.a) this.b.get(0);
        g.a aVar2 = (g.a) this.b.get(1);
        float interpolation = this.d.getInterpolation(fB);
        aVar2.a = interpolation;
        aVar.b = interpolation;
        g.a aVar3 = (g.a) this.b.get(1);
        g.a aVar4 = (g.a) this.b.get(2);
        float interpolation2 = this.d.getInterpolation(fB + 0.49925038f);
        aVar4.a = interpolation2;
        aVar3.b = interpolation2;
        ((g.a) this.b.get(2)).b = 1.0f;
    }

    @Override // com.google.android.material.progressindicator.h
    public void a() {
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.h
    public void d(e6 e6Var) {
    }

    @Override // com.google.android.material.progressindicator.h
    public void f() {
    }

    @Override // com.google.android.material.progressindicator.h
    public void g() {
        o();
        q();
        this.c.start();
    }

    @Override // com.google.android.material.progressindicator.h
    public void h() {
    }

    void q() {
        this.g = true;
        this.f = 1;
        for (g.a aVar : this.b) {
            com.google.android.material.progressindicator.a aVar2 = this.e;
            aVar.c = aVar2.c[0];
            aVar.d = aVar2.g / 2;
        }
    }

    void r(float f) {
        this.h = f;
        s((int) (f * 333.0f));
        p();
        this.a.invalidateSelf();
    }
}
