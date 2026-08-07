package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import com.google.android.material.R$anim;
import defpackage.e6;
import defpackage.eh1;
import defpackage.z6;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class l extends h {
    private static final int[] k = {533, 567, 850, 750};
    private static final int[] l = {1267, 1000, 333, 0};
    private static final Property m = new c(Float.class, "animationFraction");
    private ObjectAnimator c;
    private ObjectAnimator d;
    private final Interpolator[] e;
    private final com.google.android.material.progressindicator.a f;
    private int g;
    private boolean h;
    private float i;
    e6 j;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            l lVar = l.this;
            lVar.g = (lVar.g + 1) % l.this.f.c.length;
            l.this.h = true;
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            l.this.a();
            l lVar = l.this;
            e6 e6Var = lVar.j;
            if (e6Var != null) {
                e6Var.b(lVar.a);
            }
        }
    }

    class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(l lVar) {
            return Float.valueOf(lVar.n());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(l lVar, Float f) {
            lVar.r(f.floatValue());
        }
    }

    public l(Context context, m mVar) {
        super(2);
        this.g = 0;
        this.j = null;
        this.f = mVar;
        this.e = new Interpolator[]{z6.a(context, R$anim.linear_indeterminate_line1_head_interpolator), z6.a(context, R$anim.linear_indeterminate_line1_tail_interpolator), z6.a(context, R$anim.linear_indeterminate_line2_head_interpolator), z6.a(context, R$anim.linear_indeterminate_line2_tail_interpolator)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.i;
    }

    private void o() {
        if (this.c == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<l, Float>) m, 0.0f, 1.0f);
            this.c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1800L);
            this.c.setInterpolator(null);
            this.c.setRepeatCount(-1);
            this.c.addListener(new a());
        }
        if (this.d == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<l, Float>) m, 1.0f);
            this.d = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(1800L);
            this.d.setInterpolator(null);
            this.d.addListener(new b());
        }
    }

    private void p() {
        if (this.h) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((g.a) it.next()).c = this.f.c[this.g];
            }
            this.h = false;
        }
    }

    private void s(int i) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            g.a aVar = (g.a) this.b.get(i2);
            int[] iArr = l;
            int i3 = i2 * 2;
            int i4 = iArr[i3];
            int[] iArr2 = k;
            aVar.a = eh1.a(this.e[i3].getInterpolation(b(i, i4, iArr2[i3])), 0.0f, 1.0f);
            int i5 = i3 + 1;
            aVar.b = eh1.a(this.e[i5].getInterpolation(b(i, iArr[i5], iArr2[i5])), 0.0f, 1.0f);
        }
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
        this.j = e6Var;
    }

    @Override // com.google.android.material.progressindicator.h
    public void f() {
        ObjectAnimator objectAnimator = this.d;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        a();
        if (this.a.isVisible()) {
            this.d.setFloatValues(this.i, 1.0f);
            this.d.setDuration((long) ((1.0f - this.i) * 1800.0f));
            this.d.start();
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public void g() {
        o();
        q();
        this.c.start();
    }

    @Override // com.google.android.material.progressindicator.h
    public void h() {
        this.j = null;
    }

    void q() {
        this.g = 0;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((g.a) it.next()).c = this.f.c[0];
        }
    }

    void r(float f) {
        this.i = f;
        s((int) (f * 1800.0f));
        p();
        this.a.invalidateSelf();
    }
}
