package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.TouchObserverFrameLayout;
import defpackage.be3;
import defpackage.ck0;
import defpackage.dd0;
import defpackage.de2;
import defpackage.dk0;
import defpackage.em1;
import defpackage.f43;
import defpackage.he;
import defpackage.nf3;
import defpackage.rg1;
import defpackage.td0;
import defpackage.th2;
import defpackage.uf1;
import defpackage.y6;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class h {
    private final SearchView a;
    private final View b;
    private final ClippableRoundedCornerLayout c;
    private final FrameLayout d;
    private final FrameLayout e;
    private final Toolbar f;
    private final Toolbar g;
    private final TextView h;
    private final EditText i;
    private final ImageButton j;
    private final View k;
    private final TouchObserverFrameLayout l;
    private final rg1 m;
    private AnimatorSet n;
    private SearchBar o;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!h.this.a.s()) {
                h.this.a.J();
            }
            h.this.a.setTransitionState(SearchView.TransitionState.SHOWN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.c.setVisibility(0);
            h.this.o.i0();
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h.this.c.setVisibility(8);
            if (!h.this.a.s()) {
                h.this.a.p();
            }
            h.this.a.setTransitionState(SearchView.TransitionState.HIDDEN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.a.setTransitionState(SearchView.TransitionState.HIDING);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!h.this.a.s()) {
                h.this.a.J();
            }
            h.this.a.setTransitionState(SearchView.TransitionState.SHOWN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.c.setVisibility(0);
            h.this.a.setTransitionState(SearchView.TransitionState.SHOWING);
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h.this.c.setVisibility(8);
            if (!h.this.a.s()) {
                h.this.a.p();
            }
            h.this.a.setTransitionState(SearchView.TransitionState.HIDDEN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.a.setTransitionState(SearchView.TransitionState.HIDING);
        }
    }

    class e extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        e(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h.this.U(this.a ? 1.0f : 0.0f);
            h.this.c.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.U(this.a ? 0.0f : 1.0f);
        }
    }

    h(SearchView searchView) {
        this.a = searchView;
        this.b = searchView.a;
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = searchView.b;
        this.c = clippableRoundedCornerLayout;
        this.d = searchView.e;
        this.e = searchView.f;
        this.f = searchView.g;
        this.g = searchView.h;
        this.h = searchView.i;
        this.i = searchView.j;
        this.j = searchView.k;
        this.k = searchView.l;
        this.l = searchView.m;
        this.m = new rg1(clippableRoundedCornerLayout);
    }

    private Animator A(boolean z) {
        return K(z, true, this.i);
    }

    private AnimatorSet B(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (this.n == null) {
            animatorSet.playTogether(s(z), t(z));
        }
        animatorSet.playTogether(H(z), G(z), u(z), w(z), F(z), z(z), q(z), A(z), I(z));
        animatorSet.addListener(new e(z));
        return animatorSet;
    }

    private int C(View view) {
        int iA = uf1.a((ViewGroup.MarginLayoutParams) view.getLayoutParams());
        return nf3.o(this.o) ? this.o.getLeft() - iA : (this.o.getRight() - this.a.getWidth()) + iA;
    }

    private int D(View view) {
        int iB = uf1.b((ViewGroup.MarginLayoutParams) view.getLayoutParams());
        int iF = be3.F(this.o);
        return nf3.o(this.o) ? ((this.o.getWidth() - this.o.getRight()) + iB) - iF : (this.o.getLeft() - iB) + iF;
    }

    private int E() {
        return ((this.o.getTop() + this.o.getBottom()) / 2) - ((this.e.getTop() + this.e.getBottom()) / 2);
    }

    private Animator F(boolean z) {
        return K(z, false, this.d);
    }

    private Animator G(boolean z) {
        Rect rectM = this.m.m();
        Rect rectL = this.m.l();
        if (rectM == null) {
            rectM = nf3.c(this.a);
        }
        if (rectL == null) {
            rectL = nf3.b(this.c, this.o);
        }
        final Rect rect = new Rect(rectL);
        final float cornerSize = this.o.getCornerSize();
        final float fMax = Math.max(this.c.getCornerRadius(), this.m.k());
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new de2(rect), rectL, rectM);
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.P(cornerSize, fMax, rect, valueAnimator);
            }
        });
        valueAnimatorOfObject.setDuration(z ? 300L : 250L);
        valueAnimatorOfObject.setInterpolator(th2.a(z, y6.b));
        return valueAnimatorOfObject;
    }

    private Animator H(boolean z) {
        TimeInterpolator timeInterpolator = z ? y6.a : y6.b;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(z ? 300L : 250L);
        valueAnimatorOfFloat.setInterpolator(th2.a(z, timeInterpolator));
        valueAnimatorOfFloat.addUpdateListener(em1.e(this.b));
        return valueAnimatorOfFloat;
    }

    private Animator I(boolean z) {
        return K(z, true, this.h);
    }

    private AnimatorSet J(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(L());
        k(animatorSet);
        animatorSet.setInterpolator(th2.a(z, y6.b));
        animatorSet.setDuration(z ? 350L : 300L);
        return animatorSet;
    }

    private Animator K(boolean z, boolean z2, View view) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(z2 ? D(view) : C(view), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(em1.k(view));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(E(), 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(em1.l(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        animatorSet.setDuration(z ? 300L : 250L);
        animatorSet.setInterpolator(th2.a(z, y6.b));
        return animatorSet;
    }

    private Animator L() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.c.getHeight(), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(em1.l(this.c));
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N(td0 td0Var, ValueAnimator valueAnimator) {
        td0Var.e(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(ck0 ck0Var, ValueAnimator valueAnimator) {
        ck0Var.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(float f, float f2, Rect rect, ValueAnimator valueAnimator) {
        this.c.c(rect, y6.a(f, f2, valueAnimator.getAnimatedFraction()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        AnimatorSet animatorSetB = B(true);
        animatorSetB.addListener(new a());
        animatorSetB.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R() {
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.c;
        clippableRoundedCornerLayout.setTranslationY(clippableRoundedCornerLayout.getHeight());
        AnimatorSet animatorSetJ = J(true);
        animatorSetJ.addListener(new c());
        animatorSetJ.start();
    }

    private void T(float f) {
        ActionMenuView actionMenuViewA;
        if (!this.a.v() || (actionMenuViewA = f43.a(this.f)) == null) {
            return;
        }
        actionMenuViewA.setAlpha(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(float f) {
        this.j.setAlpha(f);
        this.k.setAlpha(f);
        this.l.setAlpha(f);
        T(f);
    }

    private void V(Drawable drawable) {
        if (drawable instanceof td0) {
            ((td0) drawable).e(1.0f);
        }
        if (drawable instanceof ck0) {
            ((ck0) drawable).a(1.0f);
        }
    }

    private void W(Toolbar toolbar) {
        ActionMenuView actionMenuViewA = f43.a(toolbar);
        if (actionMenuViewA != null) {
            for (int i = 0; i < actionMenuViewA.getChildCount(); i++) {
                View childAt = actionMenuViewA.getChildAt(i);
                childAt.setClickable(false);
                childAt.setFocusable(false);
                childAt.setFocusableInTouchMode(false);
            }
        }
    }

    private void Y() {
        Menu menu = this.g.getMenu();
        if (menu != null) {
            menu.clear();
        }
        if (this.o.getMenuResId() == -1 || !this.a.v()) {
            this.g.setVisibility(8);
            return;
        }
        this.g.x(this.o.getMenuResId());
        W(this.g);
        this.g.setVisibility(0);
    }

    private AnimatorSet b0() {
        if (this.a.s()) {
            this.a.p();
        }
        AnimatorSet animatorSetB = B(false);
        animatorSetB.addListener(new b());
        animatorSetB.start();
        return animatorSetB;
    }

    private AnimatorSet c0() {
        if (this.a.s()) {
            this.a.p();
        }
        AnimatorSet animatorSetJ = J(false);
        animatorSetJ.addListener(new d());
        animatorSetJ.start();
        return animatorSetJ;
    }

    private void d0() {
        if (this.a.s()) {
            this.a.J();
        }
        this.a.setTransitionState(SearchView.TransitionState.SHOWING);
        Y();
        this.i.setText(this.o.getText());
        EditText editText = this.i;
        editText.setSelection(editText.getText().length());
        this.c.setVisibility(4);
        this.c.post(new Runnable() { // from class: com.google.android.material.search.d
            @Override // java.lang.Runnable
            public final void run() {
                this.a.Q();
            }
        });
    }

    private void e0() {
        if (this.a.s()) {
            final SearchView searchView = this.a;
            Objects.requireNonNull(searchView);
            searchView.postDelayed(new Runnable() { // from class: com.google.android.material.search.f
                @Override // java.lang.Runnable
                public final void run() {
                    searchView.J();
                }
            }, 150L);
        }
        this.c.setVisibility(4);
        this.c.post(new Runnable() { // from class: com.google.android.material.search.g
            @Override // java.lang.Runnable
            public final void run() {
                this.a.R();
            }
        });
    }

    private void j(AnimatorSet animatorSet) {
        ActionMenuView actionMenuViewA = f43.a(this.f);
        if (actionMenuViewA == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(C(actionMenuViewA), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(em1.k(actionMenuViewA));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(E(), 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(em1.l(actionMenuViewA));
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
    }

    private void k(AnimatorSet animatorSet) {
        ImageButton imageButtonD = f43.d(this.f);
        if (imageButtonD == null) {
            return;
        }
        Drawable drawableQ = dd0.q(imageButtonD.getDrawable());
        if (!this.a.t()) {
            V(drawableQ);
        } else {
            m(animatorSet, drawableQ);
            n(animatorSet, drawableQ);
        }
    }

    private void l(AnimatorSet animatorSet) {
        ImageButton imageButtonD = f43.d(this.f);
        if (imageButtonD == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(D(imageButtonD), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(em1.k(imageButtonD));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(E(), 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(em1.l(imageButtonD));
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
    }

    private void m(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof td0) {
            final td0 td0Var = (td0) drawable;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    h.N(td0Var, valueAnimator);
                }
            });
            animatorSet.playTogether(valueAnimatorOfFloat);
        }
    }

    private void n(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof ck0) {
            final ck0 ck0Var = (ck0) drawable;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    h.O(ck0Var, valueAnimator);
                }
            });
            animatorSet.playTogether(valueAnimatorOfFloat);
        }
    }

    private Animator q(boolean z) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(z ? 300L : 250L);
        valueAnimatorOfFloat.setInterpolator(th2.a(z, y6.b));
        if (this.a.v()) {
            valueAnimatorOfFloat.addUpdateListener(new dk0(f43.a(this.g), f43.a(this.f)));
        }
        return valueAnimatorOfFloat;
    }

    private AnimatorSet s(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        k(animatorSet);
        animatorSet.setDuration(z ? 300L : 250L);
        animatorSet.setInterpolator(th2.a(z, y6.b));
        return animatorSet;
    }

    private AnimatorSet t(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        l(animatorSet);
        j(animatorSet);
        animatorSet.setDuration(z ? 300L : 250L);
        animatorSet.setInterpolator(th2.a(z, y6.b));
        return animatorSet;
    }

    private Animator u(boolean z) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(z ? 50L : 42L);
        valueAnimatorOfFloat.setStartDelay(z ? 250L : 0L);
        valueAnimatorOfFloat.setInterpolator(th2.a(z, y6.a));
        valueAnimatorOfFloat.addUpdateListener(em1.e(this.j));
        return valueAnimatorOfFloat;
    }

    private Animator v(boolean z) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(z ? 150L : 83L);
        valueAnimatorOfFloat.setStartDelay(z ? 75L : 0L);
        valueAnimatorOfFloat.setInterpolator(th2.a(z, y6.a));
        valueAnimatorOfFloat.addUpdateListener(em1.e(this.k, this.l));
        return valueAnimatorOfFloat;
    }

    private Animator w(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(v(z), y(z), x(z));
        return animatorSet;
    }

    private Animator x(boolean z) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.95f, 1.0f);
        valueAnimatorOfFloat.setDuration(z ? 300L : 250L);
        valueAnimatorOfFloat.setInterpolator(th2.a(z, y6.b));
        valueAnimatorOfFloat.addUpdateListener(em1.f(this.l));
        return valueAnimatorOfFloat;
    }

    private Animator y(boolean z) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat((this.l.getHeight() * 0.050000012f) / 2.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(z ? 300L : 250L);
        valueAnimatorOfFloat.setInterpolator(th2.a(z, y6.b));
        valueAnimatorOfFloat.addUpdateListener(em1.l(this.k));
        return valueAnimatorOfFloat;
    }

    private Animator z(boolean z) {
        return K(z, false, this.g);
    }

    AnimatorSet M() {
        return this.o != null ? b0() : c0();
    }

    public he S() {
        return this.m.c();
    }

    void X(SearchBar searchBar) {
        this.o = searchBar;
    }

    void Z() {
        if (this.o != null) {
            d0();
        } else {
            e0();
        }
    }

    void a0(he heVar) {
        this.m.t(heVar, this.o);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void f0(he heVar) {
        if (heVar.a() <= 0.0f) {
            return;
        }
        rg1 rg1Var = this.m;
        SearchBar searchBar = this.o;
        rg1Var.v(heVar, searchBar, searchBar.getCornerSize());
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            animatorSet.setCurrentPlayTime((long) (heVar.a() * this.n.getDuration()));
            return;
        }
        if (this.a.s()) {
            this.a.p();
        }
        if (this.a.t()) {
            AnimatorSet animatorSetS = s(false);
            this.n = animatorSetS;
            animatorSetS.start();
            this.n.pause();
        }
    }

    public void o() {
        this.m.g(this.o);
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            animatorSet.reverse();
        }
        this.n = null;
    }

    public void p() {
        this.m.j(M().getTotalDuration(), this.o);
        if (this.n != null) {
            t(false).start();
            this.n.resume();
        }
        this.n = null;
    }

    rg1 r() {
        return this.m;
    }
}
