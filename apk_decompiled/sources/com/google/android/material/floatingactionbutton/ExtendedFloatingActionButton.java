package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import defpackage.be3;
import defpackage.cl1;
import defpackage.m90;
import defpackage.o23;
import defpackage.sn2;
import defpackage.yg1;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    private static final int Q = R$style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    static final Property R = new f(Float.class, "width");
    static final Property S = new g(Float.class, "height");
    static final Property T = new h(Float.class, "paddingStart");
    static final Property U = new i(Float.class, "paddingEnd");
    private final int F;
    private int G;
    private int H;
    private final CoordinatorLayout.c I;
    private boolean J;
    private boolean K;
    private boolean L;
    protected ColorStateList M;
    private int N;
    private int O;
    private final int P;
    private int u;
    private final com.google.android.material.floatingactionbutton.a v;
    private final com.google.android.material.floatingactionbutton.f w;
    private final com.google.android.material.floatingactionbutton.f x;
    private final com.google.android.material.floatingactionbutton.f y;
    private final com.google.android.material.floatingactionbutton.f z;

    class a implements n {
        a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int a() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams b() {
            return new ViewGroup.LayoutParams(getWidth(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int c() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getWidth() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }
    }

    class b implements n {
        b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int a() {
            return ExtendedFloatingActionButton.this.H;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams b() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int c() {
            return ExtendedFloatingActionButton.this.G;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getWidth() {
            return (ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2)) + ExtendedFloatingActionButton.this.G + ExtendedFloatingActionButton.this.H;
        }
    }

    class c implements n {
        final /* synthetic */ n a;

        c(n nVar) {
            this.a = nVar;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int a() {
            return ExtendedFloatingActionButton.this.H;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams b() {
            return new ViewGroup.LayoutParams(-1, ExtendedFloatingActionButton.this.O == 0 ? -2 : ExtendedFloatingActionButton.this.O);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int c() {
            return ExtendedFloatingActionButton.this.G;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            if (ExtendedFloatingActionButton.this.O != -1) {
                return (ExtendedFloatingActionButton.this.O == 0 || ExtendedFloatingActionButton.this.O == -2) ? this.a.getHeight() : ExtendedFloatingActionButton.this.O;
            }
            if (!(ExtendedFloatingActionButton.this.getParent() instanceof View)) {
                return this.a.getHeight();
            }
            View view = (View) ExtendedFloatingActionButton.this.getParent();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height != -2) {
                return (view.getHeight() - ((!(ExtendedFloatingActionButton.this.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) ExtendedFloatingActionButton.this.getLayoutParams()) == null) ? 0 : marginLayoutParams.topMargin + marginLayoutParams.bottomMargin)) - (view.getPaddingTop() + view.getPaddingBottom());
            }
            return this.a.getHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getWidth() {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            if (!(ExtendedFloatingActionButton.this.getParent() instanceof View)) {
                return this.a.getWidth();
            }
            View view = (View) ExtendedFloatingActionButton.this.getParent();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.width != -2) {
                return (view.getWidth() - ((!(ExtendedFloatingActionButton.this.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || (marginLayoutParams = (ViewGroup.MarginLayoutParams) ExtendedFloatingActionButton.this.getLayoutParams()) == null) ? 0 : marginLayoutParams.leftMargin + marginLayoutParams.rightMargin)) - (view.getPaddingLeft() + view.getPaddingRight());
            }
            return this.a.getWidth();
        }
    }

    class d implements n {
        final /* synthetic */ n a;
        final /* synthetic */ n b;

        d(n nVar, n nVar2) {
            this.a = nVar;
            this.b = nVar2;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int a() {
            return ExtendedFloatingActionButton.this.H;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams b() {
            return new ViewGroup.LayoutParams(ExtendedFloatingActionButton.this.N == 0 ? -2 : ExtendedFloatingActionButton.this.N, ExtendedFloatingActionButton.this.O != 0 ? ExtendedFloatingActionButton.this.O : -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int c() {
            return ExtendedFloatingActionButton.this.G;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            if (ExtendedFloatingActionButton.this.O == -1) {
                return this.a.getHeight();
            }
            return (ExtendedFloatingActionButton.this.O == 0 || ExtendedFloatingActionButton.this.O == -2) ? this.b.getHeight() : ExtendedFloatingActionButton.this.O;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getWidth() {
            if (ExtendedFloatingActionButton.this.N == -1) {
                return this.a.getWidth();
            }
            return (ExtendedFloatingActionButton.this.N == 0 || ExtendedFloatingActionButton.this.N == -2) ? this.b.getWidth() : ExtendedFloatingActionButton.this.N;
        }
    }

    class e extends AnimatorListenerAdapter {
        private boolean a;
        final /* synthetic */ com.google.android.material.floatingactionbutton.f b;

        e(com.google.android.material.floatingactionbutton.f fVar, l lVar) {
            this.b = fVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
            this.b.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.b.f();
            if (this.a) {
                return;
            }
            this.b.i(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.b.onAnimationStart(animator);
            this.a = false;
        }
    }

    class f extends Property {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f) {
            view.getLayoutParams().width = f.intValue();
            view.requestLayout();
        }
    }

    class g extends Property {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f) {
            view.getLayoutParams().height = f.intValue();
            view.requestLayout();
        }
    }

    class h extends Property {
        h(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(be3.F(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f) {
            be3.F0(view, f.intValue(), view.getPaddingTop(), be3.E(view), view.getPaddingBottom());
        }
    }

    class i extends Property {
        i(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(be3.E(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f) {
            be3.F0(view, be3.F(view), view.getPaddingTop(), f.intValue(), view.getPaddingBottom());
        }
    }

    class j extends com.google.android.material.floatingactionbutton.b {
        private final n g;
        private final boolean h;

        j(com.google.android.material.floatingactionbutton.a aVar, n nVar, boolean z) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.g = nVar;
            this.h = z;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int b() {
            return this.h ? R$animator.mtrl_extended_fab_change_size_expand_motion_spec : R$animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void c() {
            ExtendedFloatingActionButton.this.J = this.h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            if (!this.h) {
                ExtendedFloatingActionButton.this.N = layoutParams.width;
                ExtendedFloatingActionButton.this.O = layoutParams.height;
            }
            layoutParams.width = this.g.b().width;
            layoutParams.height = this.g.b().height;
            be3.F0(ExtendedFloatingActionButton.this, this.g.c(), ExtendedFloatingActionButton.this.getPaddingTop(), this.g.a(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean e() {
            return this.h == ExtendedFloatingActionButton.this.J || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void f() {
            super.f();
            ExtendedFloatingActionButton.this.K = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.g.b().width;
            layoutParams.height = this.g.b().height;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public AnimatorSet g() {
            cl1 cl1VarM = m();
            if (cl1VarM.j("width")) {
                PropertyValuesHolder[] propertyValuesHolderArrG = cl1VarM.g("width");
                propertyValuesHolderArrG[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.g.getWidth());
                cl1VarM.l("width", propertyValuesHolderArrG);
            }
            if (cl1VarM.j("height")) {
                PropertyValuesHolder[] propertyValuesHolderArrG2 = cl1VarM.g("height");
                propertyValuesHolderArrG2[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.g.getHeight());
                cl1VarM.l("height", propertyValuesHolderArrG2);
            }
            if (cl1VarM.j("paddingStart")) {
                PropertyValuesHolder[] propertyValuesHolderArrG3 = cl1VarM.g("paddingStart");
                propertyValuesHolderArrG3[0].setFloatValues(be3.F(ExtendedFloatingActionButton.this), this.g.c());
                cl1VarM.l("paddingStart", propertyValuesHolderArrG3);
            }
            if (cl1VarM.j("paddingEnd")) {
                PropertyValuesHolder[] propertyValuesHolderArrG4 = cl1VarM.g("paddingEnd");
                propertyValuesHolderArrG4[0].setFloatValues(be3.E(ExtendedFloatingActionButton.this), this.g.a());
                cl1VarM.l("paddingEnd", propertyValuesHolderArrG4);
            }
            if (cl1VarM.j("labelOpacity")) {
                PropertyValuesHolder[] propertyValuesHolderArrG5 = cl1VarM.g("labelOpacity");
                boolean z = this.h;
                propertyValuesHolderArrG5[0].setFloatValues(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
                cl1VarM.l("labelOpacity", propertyValuesHolderArrG5);
            }
            return super.l(cl1VarM);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void i(l lVar) {
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.J = this.h;
            ExtendedFloatingActionButton.this.K = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }
    }

    class k extends com.google.android.material.floatingactionbutton.b {
        private boolean g;

        public k(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void a() {
            super.a();
            this.g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int b() {
            return R$animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void c() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean e() {
            return ExtendedFloatingActionButton.this.x();
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void f() {
            super.f();
            ExtendedFloatingActionButton.this.u = 0;
            if (this.g) {
                return;
            }
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void i(l lVar) {
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.u = 1;
        }
    }

    public static abstract class l {
    }

    class m extends com.google.android.material.floatingactionbutton.b {
        public m(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int b() {
            return R$animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void c() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean e() {
            return ExtendedFloatingActionButton.this.y();
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void f() {
            super.f();
            ExtendedFloatingActionButton.this.u = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void i(l lVar) {
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.u = 2;
        }
    }

    interface n {
        int a();

        ViewGroup.LayoutParams b();

        int c();

        int getHeight();

        int getWidth();
    }

    public ExtendedFloatingActionButton(Context context) {
        this(context, null);
    }

    private void A() {
        this.M = getTextColors();
    }

    private boolean B() {
        return (be3.T(this) || (!y() && this.L)) && !isInEditMode();
    }

    private n w(int i2) {
        b bVar = new b();
        c cVar = new c(bVar);
        d dVar = new d(cVar, bVar);
        if (i2 != 1) {
            return i2 != 2 ? dVar : cVar;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        if (getVisibility() == 0) {
            return this.u == 1;
        }
        return this.u != 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        if (getVisibility() != 0) {
            return this.u == 2;
        }
        return this.u != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i2, l lVar) {
        com.google.android.material.floatingactionbutton.f fVar;
        if (i2 == 0) {
            fVar = this.y;
        } else if (i2 == 1) {
            fVar = this.z;
        } else if (i2 == 2) {
            fVar = this.w;
        } else {
            if (i2 != 3) {
                throw new IllegalStateException("Unknown strategy type: " + i2);
            }
            fVar = this.x;
        }
        if (fVar.e()) {
            return;
        }
        if (!B()) {
            fVar.c();
            fVar.i(lVar);
            return;
        }
        if (i2 == 2) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                this.N = layoutParams.width;
                this.O = layoutParams.height;
            } else {
                this.N = getWidth();
                this.O = getHeight();
            }
        }
        measure(0, 0);
        AnimatorSet animatorSetG = fVar.g();
        animatorSetG.addListener(new e(fVar, lVar));
        Iterator it = fVar.h().iterator();
        while (it.hasNext()) {
            animatorSetG.addListener((Animator.AnimatorListener) it.next());
        }
        animatorSetG.start();
    }

    protected void C(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c getBehavior() {
        return this.I;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    int getCollapsedSize() {
        int i2 = this.F;
        return i2 < 0 ? (Math.min(be3.F(this), be3.E(this)) * 2) + getIconSize() : i2;
    }

    public cl1 getExtendMotionSpec() {
        return this.x.d();
    }

    public cl1 getHideMotionSpec() {
        return this.z.d();
    }

    public cl1 getShowMotionSpec() {
        return this.y.d();
    }

    public cl1 getShrinkMotionSpec() {
        return this.w.d();
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.J && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.J = false;
            this.w.c();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z) {
        this.L = z;
    }

    public void setExtendMotionSpec(cl1 cl1Var) {
        this.x.j(cl1Var);
    }

    public void setExtendMotionSpecResource(int i2) {
        setExtendMotionSpec(cl1.d(getContext(), i2));
    }

    public void setExtended(boolean z) {
        if (this.J == z) {
            return;
        }
        com.google.android.material.floatingactionbutton.f fVar = z ? this.x : this.w;
        if (fVar.e()) {
            return;
        }
        fVar.c();
    }

    public void setHideMotionSpec(cl1 cl1Var) {
        this.z.j(cl1Var);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(cl1.d(getContext(), i2));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        if (!this.J || this.K) {
            return;
        }
        this.G = be3.F(this);
        this.H = be3.E(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        if (!this.J || this.K) {
            return;
        }
        this.G = i2;
        this.H = i4;
    }

    public void setShowMotionSpec(cl1 cl1Var) {
        this.y.j(cl1Var);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(cl1.d(getContext(), i2));
    }

    public void setShrinkMotionSpec(cl1 cl1Var) {
        this.w.j(cl1Var);
    }

    public void setShrinkMotionSpecResource(int i2) {
        setShrinkMotionSpec(cl1.d(getContext(), i2));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        super.setTextColor(i2);
        A();
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.extendedFloatingActionButtonStyle);
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c {
        private Rect a;
        private boolean b;
        private boolean c;

        public ExtendedFloatingActionButtonBehavior() {
            this.b = false;
            this.c = true;
        }

        private static boolean K(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean N(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.b || this.c) && ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams()).e() == view.getId();
        }

        private boolean P(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!N(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            m90.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                O(extendedFloatingActionButton);
                return true;
            }
            I(extendedFloatingActionButton);
            return true;
        }

        private boolean Q(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!N(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                O(extendedFloatingActionButton);
                return true;
            }
            I(extendedFloatingActionButton);
            return true;
        }

        protected void I(ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.z(this.c ? 3 : 0, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
        public boolean f(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.f(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                P(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!K(view)) {
                return false;
            }
            Q(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        public boolean p(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
            List listV = coordinatorLayout.v(extendedFloatingActionButton);
            int size = listV.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) listV.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (K(view) && Q(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (P(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.M(extendedFloatingActionButton, i);
            return true;
        }

        protected void O(ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.z(this.c ? 2 : 1, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void k(CoordinatorLayout.f fVar) {
            if (fVar.h == 0) {
                fVar.h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.b = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.c = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet, int i2) {
        int i3 = Q;
        super(yg1.c(context, attributeSet, i2, i3), attributeSet, i2);
        this.u = 0;
        com.google.android.material.floatingactionbutton.a aVar = new com.google.android.material.floatingactionbutton.a();
        this.v = aVar;
        m mVar = new m(aVar);
        this.y = mVar;
        k kVar = new k(aVar);
        this.z = kVar;
        this.J = true;
        this.K = false;
        this.L = false;
        Context context2 = getContext();
        this.I = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray typedArrayI = o23.i(context2, attributeSet, R$styleable.ExtendedFloatingActionButton, i2, i3, new int[0]);
        cl1 cl1VarC = cl1.c(context2, typedArrayI, R$styleable.ExtendedFloatingActionButton_showMotionSpec);
        cl1 cl1VarC2 = cl1.c(context2, typedArrayI, R$styleable.ExtendedFloatingActionButton_hideMotionSpec);
        cl1 cl1VarC3 = cl1.c(context2, typedArrayI, R$styleable.ExtendedFloatingActionButton_extendMotionSpec);
        cl1 cl1VarC4 = cl1.c(context2, typedArrayI, R$styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.F = typedArrayI.getDimensionPixelSize(R$styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        int i4 = typedArrayI.getInt(R$styleable.ExtendedFloatingActionButton_extendStrategy, 1);
        this.P = i4;
        this.G = be3.F(this);
        this.H = be3.E(this);
        com.google.android.material.floatingactionbutton.a aVar2 = new com.google.android.material.floatingactionbutton.a();
        j jVar = new j(aVar2, w(i4), true);
        this.x = jVar;
        j jVar2 = new j(aVar2, new a(), false);
        this.w = jVar2;
        mVar.j(cl1VarC);
        kVar.j(cl1VarC2);
        jVar.j(cl1VarC3);
        jVar2.j(cl1VarC4);
        typedArrayI.recycle();
        setShapeAppearanceModel(sn2.g(context2, attributeSet, i2, i3, sn2.m).m());
        A();
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        A();
    }
}
