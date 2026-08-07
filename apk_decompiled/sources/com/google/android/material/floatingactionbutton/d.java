package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import defpackage.b52;
import defpackage.be3;
import defpackage.c7;
import defpackage.cl1;
import defpackage.dd0;
import defpackage.el1;
import defpackage.fh1;
import defpackage.ho2;
import defpackage.p01;
import defpackage.qt2;
import defpackage.rn2;
import defpackage.sn2;
import defpackage.tg1;
import defpackage.ug1;
import defpackage.y6;
import defpackage.zh2;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
abstract class d {
    static final TimeInterpolator D = y6.c;
    private static final int E = R$attr.motionDurationLong2;
    private static final int F = R$attr.motionEasingEmphasizedInterpolator;
    private static final int G = R$attr.motionDurationMedium1;
    private static final int H = R$attr.motionEasingEmphasizedAccelerateInterpolator;
    static final int[] I = {R.attr.state_pressed, R.attr.state_enabled};
    static final int[] J = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    static final int[] K = {R.attr.state_focused, R.attr.state_enabled};
    static final int[] L = {R.attr.state_hovered, R.attr.state_enabled};
    static final int[] M = {R.attr.state_enabled};
    static final int[] N = new int[0];
    private ViewTreeObserver.OnPreDrawListener C;
    sn2 a;
    tg1 b;
    Drawable c;
    com.google.android.material.floatingactionbutton.c d;
    Drawable e;
    boolean f;
    float h;
    float i;
    float j;
    int k;
    private final qt2 l;
    private Animator m;
    private cl1 n;
    private cl1 o;
    private float p;
    private int r;
    private ArrayList t;
    private ArrayList u;
    private ArrayList v;
    final FloatingActionButton w;
    final rn2 x;
    boolean g = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f259q = 1.0f;
    private int s = 0;
    private final Rect y = new Rect();
    private final RectF z = new RectF();
    private final RectF A = new RectF();
    private final Matrix B = new Matrix();

    class a extends AnimatorListenerAdapter {
        private boolean a;
        final /* synthetic */ boolean b;
        final /* synthetic */ k c;

        a(boolean z, k kVar) {
            this.b = z;
            this.c = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.s = 0;
            d.this.m = null;
            if (this.a) {
                return;
            }
            FloatingActionButton floatingActionButton = d.this.w;
            boolean z = this.b;
            floatingActionButton.b(z ? 8 : 4, z);
            k kVar = this.c;
            if (kVar != null) {
                kVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.w.b(0, this.b);
            d.this.s = 1;
            d.this.m = animator;
            this.a = false;
        }
    }

    class b extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;
        final /* synthetic */ k b;

        b(boolean z, k kVar) {
            this.a = z;
            this.b = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.s = 0;
            d.this.m = null;
            k kVar = this.b;
            if (kVar != null) {
                kVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.w.b(0, this.a);
            d.this.s = 2;
            d.this.m = animator;
        }
    }

    class c extends fh1 {
        c() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            d.this.f259q = f;
            return super.evaluate(f, matrix, matrix2);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.d$d, reason: collision with other inner class name */
    class C0089d implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float a;
        final /* synthetic */ float b;
        final /* synthetic */ float c;
        final /* synthetic */ float d;
        final /* synthetic */ float e;
        final /* synthetic */ float f;
        final /* synthetic */ float g;
        final /* synthetic */ Matrix h;

        C0089d(float f, float f2, float f3, float f4, float f5, float f6, float f7, Matrix matrix) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            this.e = f5;
            this.f = f6;
            this.g = f7;
            this.h = matrix;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            d.this.w.setAlpha(y6.b(this.a, this.b, 0.0f, 0.2f, fFloatValue));
            d.this.w.setScaleX(y6.a(this.c, this.d, fFloatValue));
            d.this.w.setScaleY(y6.a(this.e, this.d, fFloatValue));
            d.this.f259q = y6.a(this.f, this.g, fFloatValue);
            d.this.h(y6.a(this.f, this.g, fFloatValue), this.h);
            d.this.w.setImageMatrix(this.h);
        }
    }

    class e implements TypeEvaluator {
        FloatEvaluator a = new FloatEvaluator();

        e() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f, Float f2, Float f3) {
            float fFloatValue = this.a.evaluate(f, (Number) f2, (Number) f3).floatValue();
            if (fFloatValue < 0.1f) {
                fFloatValue = 0.0f;
            }
            return Float.valueOf(fFloatValue);
        }
    }

    class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            d.this.H();
            return true;
        }
    }

    private class g extends m {
        g() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            return 0.0f;
        }
    }

    private class h extends m {
        h() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            d dVar = d.this;
            return dVar.h + dVar.i;
        }
    }

    private class i extends m {
        i() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            d dVar = d.this;
            return dVar.h + dVar.j;
        }
    }

    interface j {
        void a();

        void b();
    }

    interface k {
        void a();

        void b();
    }

    private class l extends m {
        l() {
            super(d.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.d.m
        protected float a() {
            return d.this.h;
        }
    }

    private abstract class m extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private boolean a;
        private float b;
        private float c;

        private m() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.g0((int) this.c);
            this.a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.a) {
                tg1 tg1Var = d.this.b;
                this.b = tg1Var == null ? 0.0f : tg1Var.w();
                this.c = a();
                this.a = true;
            }
            d dVar = d.this;
            float f = this.b;
            dVar.g0((int) (f + ((this.c - f) * valueAnimator.getAnimatedFraction())));
        }

        /* synthetic */ m(d dVar, a aVar) {
            this();
        }
    }

    d(FloatingActionButton floatingActionButton, rn2 rn2Var) {
        this.w = floatingActionButton;
        this.x = rn2Var;
        qt2 qt2Var = new qt2();
        this.l = qt2Var;
        qt2Var.a(I, k(new i()));
        qt2Var.a(J, k(new h()));
        qt2Var.a(K, k(new h()));
        qt2Var.a(L, k(new h()));
        qt2Var.a(M, k(new l()));
        qt2Var.a(N, k(new g()));
        this.p = floatingActionButton.getRotation();
    }

    private boolean a0() {
        return be3.T(this.w) && !this.w.isInEditMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.w.getDrawable();
        if (drawable == null || this.r == 0) {
            return;
        }
        RectF rectF = this.z;
        RectF rectF2 = this.A;
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int i2 = this.r;
        rectF2.set(0.0f, 0.0f, i2, i2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i3 = this.r;
        matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
    }

    private void h0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new e());
    }

    private AnimatorSet i(cl1 cl1Var, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.w, (Property<FloatingActionButton, Float>) View.ALPHA, f2);
        cl1Var.h("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.w, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        cl1Var.h("scale").a(objectAnimatorOfFloat2);
        h0(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.w, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        cl1Var.h("scale").a(objectAnimatorOfFloat3);
        h0(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        h(f4, this.B);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.w, new p01(), new c(), new Matrix(this.B));
        cl1Var.h("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        c7.a(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet j(float f2, float f3, float f4, int i2, int i3) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new C0089d(this.w.getAlpha(), f2, this.w.getScaleX(), f3, this.w.getScaleY(), this.f259q, f4, new Matrix(this.B)));
        arrayList.add(valueAnimatorOfFloat);
        c7.a(animatorSet, arrayList);
        animatorSet.setDuration(el1.f(this.w.getContext(), i2, this.w.getContext().getResources().getInteger(R$integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(el1.g(this.w.getContext(), i3, y6.b));
        return animatorSet;
    }

    private ValueAnimator k(m mVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(D);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(mVar);
        valueAnimator.addUpdateListener(mVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private ViewTreeObserver.OnPreDrawListener q() {
        if (this.C == null) {
            this.C = new f();
        }
        return this.C;
    }

    abstract void A();

    void B() {
        tg1 tg1Var = this.b;
        if (tg1Var != null) {
            ug1.f(this.w, tg1Var);
        }
        if (K()) {
            this.w.getViewTreeObserver().addOnPreDrawListener(q());
        }
    }

    abstract void C();

    void D() {
        ViewTreeObserver viewTreeObserver = this.w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.C;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.C = null;
        }
    }

    abstract void E(int[] iArr);

    abstract void F(float f2, float f3, float f4);

    void G(Rect rect) {
        b52.h(this.e, "Didn't initialize content background");
        if (!Z()) {
            this.x.c(this.e);
        } else {
            this.x.c(new InsetDrawable(this.e, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    void H() {
        float rotation = this.w.getRotation();
        if (this.p != rotation) {
            this.p = rotation;
            d0();
        }
    }

    void I() {
        ArrayList arrayList = this.v;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((j) it.next()).b();
            }
        }
    }

    void J() {
        ArrayList arrayList = this.v;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a();
            }
        }
    }

    abstract boolean K();

    void L(ColorStateList colorStateList) {
        tg1 tg1Var = this.b;
        if (tg1Var != null) {
            tg1Var.setTintList(colorStateList);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.d;
        if (cVar != null) {
            cVar.c(colorStateList);
        }
    }

    void M(PorterDuff.Mode mode) {
        tg1 tg1Var = this.b;
        if (tg1Var != null) {
            tg1Var.setTintMode(mode);
        }
    }

    final void N(float f2) {
        if (this.h != f2) {
            this.h = f2;
            F(f2, this.i, this.j);
        }
    }

    void O(boolean z) {
        this.f = z;
    }

    final void P(cl1 cl1Var) {
        this.o = cl1Var;
    }

    final void Q(float f2) {
        if (this.i != f2) {
            this.i = f2;
            F(this.h, f2, this.j);
        }
    }

    final void R(float f2) {
        this.f259q = f2;
        Matrix matrix = this.B;
        h(f2, matrix);
        this.w.setImageMatrix(matrix);
    }

    final void S(int i2) {
        if (this.r != i2) {
            this.r = i2;
            e0();
        }
    }

    void T(int i2) {
        this.k = i2;
    }

    final void U(float f2) {
        if (this.j != f2) {
            this.j = f2;
            F(this.h, this.i, f2);
        }
    }

    void V(ColorStateList colorStateList) {
        Drawable drawable = this.c;
        if (drawable != null) {
            dd0.o(drawable, zh2.d(colorStateList));
        }
    }

    void W(boolean z) {
        this.g = z;
        f0();
    }

    final void X(sn2 sn2Var) {
        this.a = sn2Var;
        tg1 tg1Var = this.b;
        if (tg1Var != null) {
            tg1Var.setShapeAppearanceModel(sn2Var);
        }
        Object obj = this.c;
        if (obj instanceof ho2) {
            ((ho2) obj).setShapeAppearanceModel(sn2Var);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.d;
        if (cVar != null) {
            cVar.f(sn2Var);
        }
    }

    final void Y(cl1 cl1Var) {
        this.n = cl1Var;
    }

    abstract boolean Z();

    final boolean b0() {
        return !this.f || this.w.getSizeDimension() >= this.k;
    }

    void c0(k kVar, boolean z) {
        if (z()) {
            return;
        }
        Animator animator = this.m;
        if (animator != null) {
            animator.cancel();
        }
        boolean z2 = this.n == null;
        if (!a0()) {
            this.w.b(0, z);
            this.w.setAlpha(1.0f);
            this.w.setScaleY(1.0f);
            this.w.setScaleX(1.0f);
            R(1.0f);
            if (kVar != null) {
                kVar.a();
                return;
            }
            return;
        }
        if (this.w.getVisibility() != 0) {
            this.w.setAlpha(0.0f);
            this.w.setScaleY(z2 ? 0.4f : 0.0f);
            this.w.setScaleX(z2 ? 0.4f : 0.0f);
            R(z2 ? 0.4f : 0.0f);
        }
        cl1 cl1Var = this.n;
        AnimatorSet animatorSetI = cl1Var != null ? i(cl1Var, 1.0f, 1.0f, 1.0f) : j(1.0f, 1.0f, 1.0f, E, F);
        animatorSetI.addListener(new b(z, kVar));
        ArrayList arrayList = this.t;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetI.addListener((Animator.AnimatorListener) it.next());
            }
        }
        animatorSetI.start();
    }

    abstract void d0();

    public void e(Animator.AnimatorListener animatorListener) {
        if (this.u == null) {
            this.u = new ArrayList();
        }
        this.u.add(animatorListener);
    }

    final void e0() {
        R(this.f259q);
    }

    void f(Animator.AnimatorListener animatorListener) {
        if (this.t == null) {
            this.t = new ArrayList();
        }
        this.t.add(animatorListener);
    }

    final void f0() {
        Rect rect = this.y;
        r(rect);
        G(rect);
        this.x.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void g(j jVar) {
        if (this.v == null) {
            this.v = new ArrayList();
        }
        this.v.add(jVar);
    }

    void g0(float f2) {
        tg1 tg1Var = this.b;
        if (tg1Var != null) {
            tg1Var.a0(f2);
        }
    }

    final Drawable l() {
        return this.e;
    }

    abstract float m();

    boolean n() {
        return this.f;
    }

    final cl1 o() {
        return this.o;
    }

    float p() {
        return this.i;
    }

    void r(Rect rect) {
        int iV = v();
        float fM = this.g ? m() + this.j : 0.0f;
        int iMax = Math.max(iV, (int) Math.ceil(fM));
        int iMax2 = Math.max(iV, (int) Math.ceil(fM * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    float s() {
        return this.j;
    }

    final sn2 t() {
        return this.a;
    }

    final cl1 u() {
        return this.n;
    }

    int v() {
        if (this.f) {
            return Math.max((this.k - this.w.getSizeDimension()) / 2, 0);
        }
        return 0;
    }

    void w(k kVar, boolean z) {
        if (y()) {
            return;
        }
        Animator animator = this.m;
        if (animator != null) {
            animator.cancel();
        }
        if (!a0()) {
            this.w.b(z ? 8 : 4, z);
            if (kVar != null) {
                kVar.b();
                return;
            }
            return;
        }
        cl1 cl1Var = this.o;
        AnimatorSet animatorSetI = cl1Var != null ? i(cl1Var, 0.0f, 0.0f, 0.0f) : j(0.0f, 0.4f, 0.4f, G, H);
        animatorSetI.addListener(new a(z, kVar));
        ArrayList arrayList = this.u;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetI.addListener((Animator.AnimatorListener) it.next());
            }
        }
        animatorSetI.start();
    }

    abstract void x(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2);

    boolean y() {
        if (this.w.getVisibility() == 0) {
            return this.s == 1;
        }
        return this.s != 2;
    }

    boolean z() {
        if (this.w.getVisibility() != 0) {
            return this.s == 2;
        }
        return this.s != 1;
    }
}
