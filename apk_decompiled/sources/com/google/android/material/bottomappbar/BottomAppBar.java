package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.seeker.luckychart.animation.ChartCoordinateportAnimator;
import defpackage.a53;
import defpackage.be3;
import defpackage.dd0;
import defpackage.e43;
import defpackage.el1;
import defpackage.nf3;
import defpackage.o23;
import defpackage.sg1;
import defpackage.sn2;
import defpackage.tg1;
import defpackage.ug1;
import defpackage.y6;
import defpackage.yg1;
import defpackage.zi3;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    private static final int C0 = R$style.Widget_MaterialComponents_BottomAppBar;
    private static final int D0 = R$attr.motionDurationLong2;
    private static final int E0 = R$attr.motionEasingEmphasizedInterpolator;
    AnimatorListenerAdapter A0;
    a53 B0;
    private Integer c0;
    private final tg1 d0;
    private Animator e0;
    private Animator f0;
    private int g0;
    private int h0;
    private int i0;
    private final int j0;
    private int k0;
    private int l0;
    private final boolean m0;
    private boolean n0;
    private final boolean o0;
    private final boolean p0;
    private final boolean q0;
    private int r0;
    private ArrayList s0;
    private int t0;
    private boolean u0;
    private boolean v0;
    private Behavior w0;
    private int x0;
    private int y0;
    private int z0;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int a;
        boolean b;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
            this.b = parcel.readInt() != 0;
        }
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (BottomAppBar.this.u0) {
                return;
            }
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.Q0(bottomAppBar.g0, BottomAppBar.this.v0);
        }
    }

    class b implements a53 {
        b() {
        }

        @Override // defpackage.a53
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(FloatingActionButton floatingActionButton) {
            BottomAppBar.this.d0.c0((floatingActionButton.getVisibility() == 0 && BottomAppBar.this.i0 == 1) ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // defpackage.a53
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(FloatingActionButton floatingActionButton) {
            if (BottomAppBar.this.i0 != 1) {
                return;
            }
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.getTopEdgeTreatment().h() != translationX) {
                BottomAppBar.this.getTopEdgeTreatment().o(translationX);
                BottomAppBar.this.d0.invalidateSelf();
            }
            float fMax = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.this.getTopEdgeTreatment().c() != fMax) {
                BottomAppBar.this.getTopEdgeTreatment().i(fMax);
                BottomAppBar.this.d0.invalidateSelf();
            }
            BottomAppBar.this.d0.c0(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    class c implements nf3.d {
        c() {
        }

        @Override // nf3.d
        public zi3 a(View view, zi3 zi3Var, nf3.e eVar) {
            boolean z;
            if (BottomAppBar.this.o0) {
                BottomAppBar.this.x0 = zi3Var.i();
            }
            boolean z2 = false;
            if (BottomAppBar.this.p0) {
                z = BottomAppBar.this.z0 != zi3Var.j();
                BottomAppBar.this.z0 = zi3Var.j();
            } else {
                z = false;
            }
            if (BottomAppBar.this.q0) {
                boolean z3 = BottomAppBar.this.y0 != zi3Var.k();
                BottomAppBar.this.y0 = zi3Var.k();
                z2 = z3;
            }
            if (z || z2) {
                BottomAppBar.this.E0();
                BottomAppBar.this.V0();
                BottomAppBar.this.U0();
            }
            return zi3Var;
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.I0();
            BottomAppBar.this.e0 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.J0();
        }
    }

    class e extends FloatingActionButton.b {
        final /* synthetic */ int a;

        class a extends FloatingActionButton.b {
            a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.I0();
            }
        }

        e(int i) {
            this.a = i;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.N0(this.a));
            floatingActionButton.s(new a());
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.I0();
            BottomAppBar.this.u0 = false;
            BottomAppBar.this.f0 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.J0();
        }
    }

    class g extends AnimatorListenerAdapter {
        public boolean a;
        final /* synthetic */ ActionMenuView b;
        final /* synthetic */ int c;
        final /* synthetic */ boolean d;

        g(ActionMenuView actionMenuView, int i, boolean z) {
            this.b = actionMenuView;
            this.c = i;
            this.d = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            boolean z = BottomAppBar.this.t0 != 0;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.T0(bottomAppBar.t0);
            BottomAppBar.this.Z0(this.b, this.c, this.d, z);
        }
    }

    class h implements Runnable {
        final /* synthetic */ ActionMenuView a;
        final /* synthetic */ int b;
        final /* synthetic */ boolean c;

        h(ActionMenuView actionMenuView, int i, boolean z) {
            this.a = actionMenuView;
            this.b = i;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuView actionMenuView = this.a;
            actionMenuView.setTranslationX(BottomAppBar.this.M0(actionMenuView, this.b, this.c));
        }
    }

    class i extends AnimatorListenerAdapter {
        i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.A0.onAnimationStart(animator);
            FloatingActionButton floatingActionButtonK0 = BottomAppBar.this.K0();
            if (floatingActionButtonK0 != null) {
                floatingActionButtonK0.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    public BottomAppBar(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(FloatingActionButton floatingActionButton) {
        floatingActionButton.e(this.A0);
        floatingActionButton.f(new i());
        floatingActionButton.g(this.B0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        Animator animator = this.f0;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.e0;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void G0(int i2, List list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(K0(), "translationX", N0(i2));
        objectAnimatorOfFloat.setDuration(getFabAlignmentAnimationDuration());
        list.add(objectAnimatorOfFloat);
    }

    private void H0(int i2, boolean z, List list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        objectAnimatorOfFloat.setDuration((long) (0.8f * fabAlignmentAnimationDuration));
        if (Math.abs(actionMenuView.getTranslationX() - M0(actionMenuView, i2, z)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(objectAnimatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            objectAnimatorOfFloat2.setDuration((long) (fabAlignmentAnimationDuration * 0.2f));
            objectAnimatorOfFloat2.addListener(new g(actionMenuView, i2, z));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(objectAnimatorOfFloat2, objectAnimatorOfFloat);
            list.add(animatorSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        ArrayList arrayList;
        int i2 = this.r0 - 1;
        this.r0 = i2;
        if (i2 != 0 || (arrayList = this.s0) == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        ArrayList arrayList;
        int i2 = this.r0;
        this.r0 = i2 + 1;
        if (i2 != 0 || (arrayList = this.s0) == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton K0() {
        View viewL0 = L0();
        if (viewL0 instanceof FloatingActionButton) {
            return (FloatingActionButton) viewL0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View L0() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).w(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float N0(int i2) {
        boolean zO = nf3.o(this);
        if (i2 != 1) {
            return 0.0f;
        }
        View viewL0 = L0();
        return ((getMeasuredWidth() / 2) - ((zO ? this.z0 : this.y0) + ((this.k0 == -1 || viewL0 == null) ? this.j0 : (viewL0.getMeasuredWidth() / 2) + this.k0))) * (zO ? -1 : 1);
    }

    private boolean O0() {
        FloatingActionButton floatingActionButtonK0 = K0();
        return floatingActionButtonK0 != null && floatingActionButtonK0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(int i2, boolean z) {
        if (!be3.T(this)) {
            this.u0 = false;
            T0(this.t0);
            return;
        }
        Animator animator = this.f0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!O0()) {
            i2 = 0;
            z = false;
        }
        H0(i2, z, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f0 = animatorSet;
        animatorSet.addListener(new f());
        this.f0.start();
    }

    private void R0(int i2) {
        if (this.g0 == i2 || !be3.T(this)) {
            return;
        }
        Animator animator = this.e0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.h0 == 1) {
            G0(i2, arrayList);
        } else {
            F0(i2, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.setInterpolator(el1.g(getContext(), E0, y6.a));
        this.e0 = animatorSet;
        animatorSet.addListener(new d());
        this.e0.start();
    }

    private Drawable S0(Drawable drawable) {
        if (drawable == null || this.c0 == null) {
            return drawable;
        }
        Drawable drawableR = dd0.r(drawable.mutate());
        dd0.n(drawableR, this.c0.intValue());
        return drawableR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.f0 != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (O0()) {
            Y0(actionMenuView, this.g0, this.v0);
        } else {
            Y0(actionMenuView, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        getTopEdgeTreatment().o(getFabTranslationX());
        this.d0.c0((this.v0 && O0() && this.i0 == 1) ? 1.0f : 0.0f);
        View viewL0 = L0();
        if (viewL0 != null) {
            viewL0.setTranslationY(getFabTranslationY());
            viewL0.setTranslationX(getFabTranslationX());
        }
    }

    private void Y0(ActionMenuView actionMenuView, int i2, boolean z) {
        Z0(actionMenuView, i2, z, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0(ActionMenuView actionMenuView, int i2, boolean z, boolean z2) {
        h hVar = new h(actionMenuView, i2, z);
        if (z2) {
            actionMenuView.post(hVar);
        } else {
            hVar.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a1(BottomAppBar bottomAppBar, View view) {
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        fVar.d = 17;
        int i2 = bottomAppBar.i0;
        if (i2 == 1) {
            fVar.d = 17 | 48;
        }
        if (i2 == 0) {
            fVar.d |= 80;
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.x0;
    }

    private int getFabAlignmentAnimationDuration() {
        return el1.f(getContext(), D0, ChartCoordinateportAnimator.FAST_ANIMATION_DURATION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return N0(this.g0);
    }

    private float getFabTranslationY() {
        if (this.i0 == 1) {
            return -getTopEdgeTreatment().c();
        }
        View viewL0 = L0();
        return viewL0 != null ? (-((getMeasuredHeight() + getBottomInset()) - viewL0.getMeasuredHeight())) / 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.z0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.y0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.material.bottomappbar.a getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.a) this.d0.E().p();
    }

    protected void F0(int i2, List list) {
        FloatingActionButton floatingActionButtonK0 = K0();
        if (floatingActionButtonK0 == null || floatingActionButtonK0.o()) {
            return;
        }
        J0();
        floatingActionButtonK0.m(new e(i2));
    }

    protected int M0(ActionMenuView actionMenuView, int i2, boolean z) {
        int dimensionPixelOffset = 0;
        if (this.l0 != 1 && (i2 != 1 || !z)) {
            return 0;
        }
        boolean zO = nf3.o(this);
        int measuredWidth = zO ? getMeasuredWidth() : 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.g) && (((Toolbar.g) childAt.getLayoutParams()).a & 8388615) == 8388611) {
                measuredWidth = zO ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = zO ? actionMenuView.getRight() : actionMenuView.getLeft();
        int i4 = zO ? this.y0 : -this.z0;
        if (getNavigationIcon() == null) {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.m3_bottomappbar_horizontal_padding);
            if (!zO) {
                dimensionPixelOffset = -dimensionPixelOffset;
            }
        }
        return measuredWidth - ((right + i4) + dimensionPixelOffset);
    }

    public void T0(int i2) {
        if (i2 != 0) {
            this.t0 = 0;
            getMenu().clear();
            x(i2);
        }
    }

    public void W0(int i2, int i3) {
        this.t0 = i3;
        this.u0 = true;
        Q0(i2, this.v0);
        R0(i2);
        this.g0 = i2;
    }

    boolean X0(int i2) {
        float f2 = i2;
        if (f2 == getTopEdgeTreatment().g()) {
            return false;
        }
        getTopEdgeTreatment().m(f2);
        this.d0.invalidateSelf();
        return true;
    }

    public ColorStateList getBackgroundTint() {
        return this.d0.I();
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().c();
    }

    public int getFabAlignmentMode() {
        return this.g0;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.k0;
    }

    public int getFabAnchorMode() {
        return this.i0;
    }

    public int getFabAnimationMode() {
        return this.h0;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().e();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f();
    }

    public boolean getHideOnScroll() {
        return this.n0;
    }

    public int getMenuAlignmentMode() {
        return this.l0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ug1.f(this, this.d0);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            E0();
            V0();
            final View viewL0 = L0();
            if (viewL0 != null && be3.T(viewL0)) {
                viewL0.post(new Runnable() { // from class: dn
                    @Override // java.lang.Runnable
                    public final void run() {
                        viewL0.requestLayout();
                    }
                });
            }
        }
        U0();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.g0 = savedState.a;
        this.v0 = savedState.b;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.g0;
        savedState.b = this.v0;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        dd0.o(this.d0, colorStateList);
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().i(f2);
            this.d0.invalidateSelf();
            V0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        this.d0.a0(f2);
        getBehavior().M(this, this.d0.D() - this.d0.C());
    }

    public void setFabAlignmentMode(int i2) {
        W0(i2, 0);
    }

    public void setFabAlignmentModeEndMargin(int i2) {
        if (this.k0 != i2) {
            this.k0 = i2;
            V0();
        }
    }

    public void setFabAnchorMode(int i2) {
        this.i0 = i2;
        V0();
        View viewL0 = L0();
        if (viewL0 != null) {
            a1(this, viewL0);
            viewL0.requestLayout();
            this.d0.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i2) {
        this.h0 = i2;
    }

    void setFabCornerSize(float f2) {
        if (f2 != getTopEdgeTreatment().d()) {
            getTopEdgeTreatment().j(f2);
            this.d0.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().k(f2);
            this.d0.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().l(f2);
            this.d0.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z) {
        this.n0 = z;
    }

    public void setMenuAlignmentMode(int i2) {
        if (this.l0 != i2) {
            this.l0 = i2;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                Y0(actionMenuView, this.g0, O0());
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(S0(drawable));
    }

    public void setNavigationIconTint(int i2) {
        this.c0 = Integer.valueOf(i2);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomAppBarStyle);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.w0 == null) {
            this.w0 = new Behavior();
        }
        return this.w0;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        private final Rect m;
        private WeakReference n;
        private int o;
        private final View.OnLayoutChangeListener p;

        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.n.get();
                if (bottomAppBar == null || !((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                int height = view.getHeight();
                if (view instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    floatingActionButton.j(Behavior.this.m);
                    int iHeight = Behavior.this.m.height();
                    bottomAppBar.X0(iHeight);
                    bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.m)));
                    height = iHeight;
                }
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (Behavior.this.o == 0) {
                    if (bottomAppBar.i0 == 1) {
                        ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fab_bottom_margin) - ((view.getMeasuredHeight() - height) / 2));
                    }
                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                    if (nf3.o(view)) {
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin += bottomAppBar.j0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin += bottomAppBar.j0;
                    }
                }
                bottomAppBar.V0();
            }
        }

        public Behavior() {
            this.p = new a();
            this.m = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
        public boolean p(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            this.n = new WeakReference(bottomAppBar);
            View viewL0 = bottomAppBar.L0();
            if (viewL0 != null && !be3.T(viewL0)) {
                BottomAppBar.a1(bottomAppBar, viewL0);
                this.o = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) viewL0.getLayoutParams())).bottomMargin;
                if (viewL0 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewL0;
                    if (bottomAppBar.i0 == 0 && bottomAppBar.m0) {
                        be3.x0(floatingActionButton, 0.0f);
                        floatingActionButton.setCompatElevation(0.0f);
                    }
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(R$animator.mtrl_fab_show_motion_spec);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(R$animator.mtrl_fab_hide_motion_spec);
                    }
                    bottomAppBar.D0(floatingActionButton);
                }
                viewL0.addOnLayoutChangeListener(this.p);
                bottomAppBar.V0();
            }
            coordinatorLayout.M(bottomAppBar, i);
            return super.p(coordinatorLayout, bottomAppBar, i);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
        public boolean E(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.E(coordinatorLayout, bottomAppBar, view, view2, i, i2);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.p = new a();
            this.m = new Rect();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BottomAppBar(Context context, AttributeSet attributeSet, int i2) {
        int i3 = C0;
        super(yg1.c(context, attributeSet, i2, i3), attributeSet, i2);
        tg1 tg1Var = new tg1();
        this.d0 = tg1Var;
        this.r0 = 0;
        this.t0 = 0;
        this.u0 = false;
        this.v0 = true;
        this.A0 = new a();
        this.B0 = new b();
        Context context2 = getContext();
        TypedArray typedArrayI = o23.i(context2, attributeSet, R$styleable.BottomAppBar, i2, i3, new int[0]);
        ColorStateList colorStateListA = sg1.a(context2, typedArrayI, R$styleable.BottomAppBar_backgroundTint);
        int i4 = R$styleable.BottomAppBar_navigationIconTint;
        if (typedArrayI.hasValue(i4)) {
            setNavigationIconTint(typedArrayI.getColor(i4, -1));
        }
        int dimensionPixelSize = typedArrayI.getDimensionPixelSize(R$styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = typedArrayI.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = typedArrayI.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = typedArrayI.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.g0 = typedArrayI.getInt(R$styleable.BottomAppBar_fabAlignmentMode, 0);
        this.h0 = typedArrayI.getInt(R$styleable.BottomAppBar_fabAnimationMode, 0);
        this.i0 = typedArrayI.getInt(R$styleable.BottomAppBar_fabAnchorMode, 1);
        this.m0 = typedArrayI.getBoolean(R$styleable.BottomAppBar_removeEmbeddedFabElevation, true);
        this.l0 = typedArrayI.getInt(R$styleable.BottomAppBar_menuAlignmentMode, 0);
        this.n0 = typedArrayI.getBoolean(R$styleable.BottomAppBar_hideOnScroll, false);
        this.o0 = typedArrayI.getBoolean(R$styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.p0 = typedArrayI.getBoolean(R$styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.q0 = typedArrayI.getBoolean(R$styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        this.k0 = typedArrayI.getDimensionPixelOffset(R$styleable.BottomAppBar_fabAlignmentModeEndMargin, -1);
        boolean z = typedArrayI.getBoolean(R$styleable.BottomAppBar_addElevationShadow, true);
        typedArrayI.recycle();
        this.j0 = getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fabOffsetEndMode);
        tg1Var.setShapeAppearanceModel(sn2.a().B(new com.google.android.material.bottomappbar.a(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3)).m());
        if (z) {
            tg1Var.i0(2);
        } else {
            tg1Var.i0(1);
            if (Build.VERSION.SDK_INT >= 28) {
                setOutlineAmbientShadowColor(0);
                setOutlineSpotShadowColor(0);
            }
        }
        tg1Var.e0(Paint.Style.FILL);
        tg1Var.Q(context2);
        setElevation(dimensionPixelSize);
        dd0.o(tg1Var, colorStateListA);
        be3.t0(this, tg1Var);
        nf3.f(this, attributeSet, i2, i3, new c());
    }
}
