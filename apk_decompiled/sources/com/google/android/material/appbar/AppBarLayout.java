package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$integer;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.tenmeter.smlibrary.banner.config.BannerConfig;
import defpackage.be3;
import defpackage.dd0;
import defpackage.e43;
import defpackage.eh1;
import defpackage.el1;
import defpackage.m2;
import defpackage.mu1;
import defpackage.o23;
import defpackage.og1;
import defpackage.qd0;
import defpackage.sg1;
import defpackage.sn1;
import defpackage.t1;
import defpackage.tg1;
import defpackage.tt1;
import defpackage.ug1;
import defpackage.v8;
import defpackage.y6;
import defpackage.yg1;
import defpackage.zi3;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {
    private static final int z = R$style.Widget_Design_AppBarLayout;
    private int a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private int f;
    private zi3 g;
    private List h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private WeakReference n;
    private final boolean o;
    private ValueAnimator p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f245q;
    private final List r;
    private final long s;
    private final TimeInterpolator t;
    private int[] u;
    private Drawable v;
    private Integer w;
    private final float x;
    private Behavior y;

    protected static class BaseBehavior<T extends AppBarLayout> extends com.google.android.material.appbar.a {
        private int k;
        private int l;
        private ValueAnimator m;
        private SavedState n;
        private WeakReference o;

        class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ CoordinatorLayout a;
            final /* synthetic */ AppBarLayout b;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.a = coordinatorLayout;
                this.b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.T(this.a, this.b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        class b extends t1 {
            final /* synthetic */ AppBarLayout a;
            final /* synthetic */ CoordinatorLayout b;

            b(AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout) {
                this.a = appBarLayout;
                this.b = coordinatorLayout;
            }

            @Override // defpackage.t1
            public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
                View viewJ0;
                super.onInitializeAccessibilityNodeInfo(view, m2Var);
                m2Var.j0(ScrollView.class.getName());
                if (this.a.getTotalScrollRange() == 0 || (viewJ0 = BaseBehavior.this.j0(this.b)) == null || !BaseBehavior.this.f0(this.a)) {
                    return;
                }
                if (BaseBehavior.this.Q() != (-this.a.getTotalScrollRange())) {
                    m2Var.b(m2.a.f352q);
                    m2Var.G0(true);
                }
                if (BaseBehavior.this.Q() != 0) {
                    if (!viewJ0.canScrollVertically(-1)) {
                        m2Var.b(m2.a.r);
                        m2Var.G0(true);
                    } else if ((-this.a.getDownNestedPreScrollRange()) != 0) {
                        m2Var.b(m2.a.r);
                        m2Var.G0(true);
                    }
                }
            }

            @Override // defpackage.t1
            public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                if (i == 4096) {
                    this.a.setExpanded(false);
                    return true;
                }
                if (i != 8192) {
                    return super.performAccessibilityAction(view, i, bundle);
                }
                if (BaseBehavior.this.Q() != 0) {
                    View viewJ0 = BaseBehavior.this.j0(this.b);
                    if (!viewJ0.canScrollVertically(-1)) {
                        this.a.setExpanded(true);
                        return true;
                    }
                    int i2 = -this.a.getDownNestedPreScrollRange();
                    if (i2 != 0) {
                        BaseBehavior.this.u(this.b, this.a, viewJ0, 0, i2, new int[]{0, 0}, 1);
                        return true;
                    }
                }
                return false;
            }
        }

        public BaseBehavior() {
        }

        private void A0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int topInset = appBarLayout.getTopInset() + appBarLayout.getPaddingTop();
            int iQ = Q() - topInset;
            int iI0 = i0(appBarLayout, iQ);
            if (iI0 >= 0) {
                View childAt = appBarLayout.getChildAt(iI0);
                e eVar = (e) childAt.getLayoutParams();
                int iC = eVar.c();
                if ((iC & 17) == 17) {
                    int topInset2 = -childAt.getTop();
                    int iB = -childAt.getBottom();
                    if (iI0 == 0 && be3.x(appBarLayout) && be3.x(childAt)) {
                        topInset2 -= appBarLayout.getTopInset();
                    }
                    if (e0(iC, 2)) {
                        iB += be3.B(childAt);
                    } else if (e0(iC, 5)) {
                        int iB2 = be3.B(childAt) + iB;
                        if (iQ < iB2) {
                            topInset2 = iB2;
                        } else {
                            iB = iB2;
                        }
                    }
                    if (e0(iC, 32)) {
                        topInset2 += ((LinearLayout.LayoutParams) eVar).topMargin;
                        iB -= ((LinearLayout.LayoutParams) eVar).bottomMargin;
                    }
                    Z(coordinatorLayout, appBarLayout, eh1.b(b0(iQ, iB, topInset2) + topInset, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void B0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, boolean z) {
            View viewH0 = h0(appBarLayout, i);
            boolean zF = false;
            if (viewH0 != null) {
                int iC = ((e) viewH0.getLayoutParams()).c();
                if ((iC & 1) != 0) {
                    int iB = be3.B(viewH0);
                    if (i2 <= 0 || (iC & 12) == 0 ? !((iC & 2) == 0 || (-i) < (viewH0.getBottom() - iB) - appBarLayout.getTopInset()) : (-i) >= (viewH0.getBottom() - iB) - appBarLayout.getTopInset()) {
                        zF = true;
                    }
                }
            }
            if (appBarLayout.q()) {
                zF = appBarLayout.F(g0(coordinatorLayout));
            }
            boolean zC = appBarLayout.C(zF);
            if (z || (zC && z0(coordinatorLayout, appBarLayout))) {
                if (appBarLayout.getBackground() != null) {
                    appBarLayout.getBackground().jumpToCurrentState();
                }
                if (appBarLayout.getForeground() != null) {
                    appBarLayout.getForeground().jumpToCurrentState();
                }
                if (appBarLayout.getStateListAnimator() != null) {
                    appBarLayout.getStateListAnimator().jumpToCurrentState();
                }
            }
        }

        private void Y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            if (be3.O(coordinatorLayout)) {
                return;
            }
            be3.p0(coordinatorLayout, new b(appBarLayout, coordinatorLayout));
        }

        private void Z(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f) {
            int iAbs = Math.abs(Q() - i);
            float fAbs = Math.abs(f);
            a0(coordinatorLayout, appBarLayout, i, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / appBarLayout.getHeight()) + 1.0f) * 150.0f));
        }

        private void a0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2) {
            int iQ = Q();
            if (iQ == i) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.m = valueAnimator3;
                valueAnimator3.setInterpolator(y6.e);
                this.m.addUpdateListener(new a(coordinatorLayout, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration(Math.min(i2, BannerConfig.SCROLL_TIME));
            this.m.setIntValues(iQ, i);
            this.m.start();
        }

        private int b0(int i, int i2, int i3) {
            return i < (i2 + i3) / 2 ? i2 : i3;
        }

        private boolean d0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            return appBarLayout.m() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
        }

        private static boolean e0(int i, int i2) {
            return (i & i2) == i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean f0(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (((e) appBarLayout.getChildAt(i).getLayoutParams()).a != 0) {
                    return true;
                }
            }
            return false;
        }

        private View g0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof sn1) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private static View h0(AppBarLayout appBarLayout, int i) {
            int iAbs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int i0(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                e eVar = (e) childAt.getLayoutParams();
                if (e0(eVar.c(), 32)) {
                    top -= ((LinearLayout.LayoutParams) eVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) eVar).bottomMargin;
                }
                int i3 = -i;
                if (top <= i3 && bottom >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public View j0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (((CoordinatorLayout.f) childAt.getLayoutParams()).f() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        private int m0(AppBarLayout appBarLayout, int i) {
            int iAbs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int topInset = 0;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                e eVar = (e) childAt.getLayoutParams();
                Interpolator interpolatorD = eVar.d();
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    if (interpolatorD == null) {
                        break;
                    }
                    int iC = eVar.c();
                    if ((iC & 1) != 0) {
                        topInset = childAt.getHeight() + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                        if ((iC & 2) != 0) {
                            topInset -= be3.B(childAt);
                        }
                    }
                    if (be3.x(childAt)) {
                        topInset -= appBarLayout.getTopInset();
                    }
                    if (topInset <= 0) {
                        break;
                    }
                    float f = topInset;
                    return Integer.signum(i) * (childAt.getTop() + Math.round(f * interpolatorD.getInterpolation((iAbs - childAt.getTop()) / f)));
                }
            }
            return i;
        }

        private boolean z0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            List listW = coordinatorLayout.w(appBarLayout);
            int size = listW.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) ((View) listW.get(i)).getLayoutParams()).f();
                if (cVarF instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) cVarF).O() != 0;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.a
        int Q() {
            return I() + this.k;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
        public boolean L(AppBarLayout appBarLayout) {
            WeakReference weakReference = this.o;
            if (weakReference == null) {
                return true;
            }
            View view = (View) weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
        public int O(AppBarLayout appBarLayout) {
            return (-appBarLayout.getDownNestedScrollRange()) + appBarLayout.getTopInset();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
        public int P(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
        public void R(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            A0(coordinatorLayout, appBarLayout);
            if (appBarLayout.q()) {
                appBarLayout.C(appBarLayout.F(g0(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
        public boolean p(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            boolean zP = super.p(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            SavedState savedState = this.n;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i2 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z) {
                            Z(coordinatorLayout, appBarLayout, i2, 0.0f);
                        } else {
                            T(coordinatorLayout, appBarLayout, i2);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z) {
                            Z(coordinatorLayout, appBarLayout, 0, 0.0f);
                        } else {
                            T(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (savedState.a) {
                T(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (savedState.b) {
                T(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(savedState.c);
                T(coordinatorLayout, appBarLayout, (-childAt.getBottom()) + (this.n.e ? be3.B(childAt) + appBarLayout.getTopInset() : Math.round(childAt.getHeight() * this.n.d)));
            }
            appBarLayout.y();
            this.n = null;
            K(eh1.b(I(), -appBarLayout.getTotalScrollRange(), 0));
            B0(coordinatorLayout, appBarLayout, I(), 0, true);
            appBarLayout.u(I());
            Y(coordinatorLayout, appBarLayout);
            return zP;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
        public boolean q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) appBarLayout.getLayoutParams())).height != -2) {
                return super.q(coordinatorLayout, appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.N(appBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
        public void u(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int downNestedPreScrollRange;
            if (i2 != 0) {
                if (i2 < 0) {
                    i4 = -appBarLayout.getTotalScrollRange();
                    downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange() + i4;
                } else {
                    i4 = -appBarLayout.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                int i5 = i4;
                int i6 = downNestedPreScrollRange;
                if (i5 != i6) {
                    iArr[1] = S(coordinatorLayout, appBarLayout, i2, i5, i6);
                }
            }
            if (appBarLayout.q()) {
                appBarLayout.C(appBarLayout.F(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
        public void x(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            if (i4 < 0) {
                iArr[1] = S(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i4 == 0) {
                Y(coordinatorLayout, appBarLayout);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
        public void B(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                w0((SavedState) parcelable, true);
                super.B(coordinatorLayout, appBarLayout, this.n.getSuperState());
            } else {
                super.B(coordinatorLayout, appBarLayout, parcelable);
                this.n = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
        public Parcelable C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            Parcelable parcelableC = super.C(coordinatorLayout, appBarLayout);
            SavedState savedStateX0 = x0(parcelableC, appBarLayout);
            return savedStateX0 == null ? parcelableC : savedStateX0;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
        public boolean E(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            ValueAnimator valueAnimator;
            boolean z = (i & 2) != 0 && (appBarLayout.q() || d0(coordinatorLayout, appBarLayout, view));
            if (z && (valueAnimator = this.m) != null) {
                valueAnimator.cancel();
            }
            this.o = null;
            this.l = i2;
            return z;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
        public void G(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            if (this.l == 0 || i == 1) {
                A0(coordinatorLayout, appBarLayout);
                if (appBarLayout.q()) {
                    appBarLayout.C(appBarLayout.F(view));
                }
            }
            this.o = new WeakReference(view);
        }

        void w0(SavedState savedState, boolean z) {
            if (this.n == null || z) {
                this.n = savedState;
            }
        }

        SavedState x0(Parcelable parcelable, AppBarLayout appBarLayout) {
            int I = I();
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + I;
                if (childAt.getTop() + I <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.EMPTY_STATE;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    boolean z = I == 0;
                    savedState.b = z;
                    savedState.a = !z && (-I) >= appBarLayout.getTotalScrollRange();
                    savedState.c = i;
                    savedState.e = bottom == be3.B(childAt) + appBarLayout.getTopInset();
                    savedState.d = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
        public int U(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int iQ = Q();
            int i4 = 0;
            if (i2 == 0 || iQ < i2 || iQ > i3) {
                this.k = 0;
            } else {
                int iB = eh1.b(i, i2, i3);
                if (iQ != iB) {
                    int iM0 = appBarLayout.k() ? m0(appBarLayout, iB) : iB;
                    boolean zK = K(iM0);
                    int i5 = iQ - iB;
                    this.k = iB - iM0;
                    if (zK) {
                        while (i4 < appBarLayout.getChildCount()) {
                            e eVar = (e) appBarLayout.getChildAt(i4).getLayoutParams();
                            c cVarB = eVar.b();
                            if (cVarB != null && (eVar.c() & 1) != 0) {
                                cVarB.a(appBarLayout, appBarLayout.getChildAt(i4), I());
                            }
                            i4++;
                        }
                    }
                    if (!zK && appBarLayout.k()) {
                        coordinatorLayout.p(appBarLayout);
                    }
                    appBarLayout.u(I());
                    B0(coordinatorLayout, appBarLayout, iB, iB < iQ ? -1 : 1, false);
                    i4 = i5;
                }
            }
            Y(coordinatorLayout, appBarLayout);
            return i4;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();
            boolean a;
            boolean b;
            int c;
            float d;
            boolean e;

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

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.a = parcel.readByte() != 0;
                this.b = parcel.readByte() != 0;
                this.c = parcel.readInt();
                this.d = parcel.readFloat();
                this.e = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeByte(this.a ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.c);
                parcel.writeFloat(this.d);
                parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.a, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean H(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.H(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ int I() {
            return super.I();
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ boolean K(int i) {
            return super.K(i);
        }

        @Override // com.google.android.material.appbar.a, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean o(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.o(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: o0 */
        public /* bridge */ /* synthetic */ boolean p(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            return super.p(coordinatorLayout, appBarLayout, i);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: p0 */
        public /* bridge */ /* synthetic */ boolean q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            return super.q(coordinatorLayout, appBarLayout, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: q0 */
        public /* bridge */ /* synthetic */ void u(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            super.u(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: r0 */
        public /* bridge */ /* synthetic */ void x(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            super.x(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: s0 */
        public /* bridge */ /* synthetic */ void B(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.B(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: t0 */
        public /* bridge */ /* synthetic */ Parcelable C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.C(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: u0 */
        public /* bridge */ /* synthetic */ boolean E(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            return super.E(coordinatorLayout, appBarLayout, view, view2, i, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: v0 */
        public /* bridge */ /* synthetic */ void G(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            super.G(coordinatorLayout, appBarLayout, view, i);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends com.google.android.material.appbar.b {
        public ScrollingViewBehavior() {
        }

        private static int V(AppBarLayout appBarLayout) {
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f();
            if (cVarF instanceof BaseBehavior) {
                return ((BaseBehavior) cVarF).Q();
            }
            return 0;
        }

        private void W(View view, View view2) {
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) view2.getLayoutParams()).f();
            if (cVarF instanceof BaseBehavior) {
                be3.a0(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) cVarF).k) + Q()) - M(view2));
            }
        }

        private void X(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.q()) {
                    appBarLayout.C(appBarLayout.F(view));
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean A(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout appBarLayoutL = L(coordinatorLayout.v(view));
            if (appBarLayoutL != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                Rect rect3 = this.d;
                rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect3.contains(rect2)) {
                    appBarLayoutL.z(false, !z);
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.b
        float N(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iV = V(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iV > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iV / i) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.b
        int P(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.P(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
        public AppBarLayout L(List list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean i(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean l(CoordinatorLayout coordinatorLayout, View view, View view2) {
            W(view, view2);
            X(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void m(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                be3.p0(coordinatorLayout, null);
            }
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean p(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.p(coordinatorLayout, view, i);
        }

        @Override // com.google.android.material.appbar.b, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean q(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.q(coordinatorLayout, view, i, i2, i3, i4);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingViewBehavior_Layout);
            S(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    class a implements mu1 {
        a() {
        }

        @Override // defpackage.mu1
        public zi3 a(View view, zi3 zi3Var) {
            return AppBarLayout.this.v(zi3Var);
        }
    }

    public interface b {
        void a(AppBarLayout appBarLayout, int i);
    }

    public static abstract class c {
        public abstract void a(AppBarLayout appBarLayout, View view, float f);
    }

    public static class d extends c {
        private final Rect a = new Rect();
        private final Rect b = new Rect();

        private static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, View view, float f) {
            b(this.a, appBarLayout, view);
            float fAbs = this.a.top - Math.abs(f);
            if (fAbs > 0.0f) {
                be3.w0(view, null);
                view.setTranslationY(0.0f);
                view.setVisibility(0);
                return;
            }
            float fA = 1.0f - eh1.a(Math.abs(fAbs / this.a.height()), 0.0f, 1.0f);
            float fHeight = (-fAbs) - ((this.a.height() * 0.3f) * (1.0f - (fA * fA)));
            view.setTranslationY(fHeight);
            view.getDrawingRect(this.b);
            this.b.offset(0, (int) (-fHeight));
            if (fHeight >= this.b.height()) {
                view.setVisibility(4);
            } else {
                view.setVisibility(0);
            }
            be3.w0(view, this.b);
        }
    }

    public interface f extends b {
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    private void A(boolean z2, boolean z3, boolean z4) {
        this.f = (z2 ? 1 : 2) | (z3 ? 4 : 0) | (z4 ? 8 : 0);
        requestLayout();
    }

    private boolean B(boolean z2) {
        if (this.j == z2) {
            return false;
        }
        this.j = z2;
        refreshDrawableState();
        return true;
    }

    private boolean E() {
        return this.v != null && getTopInset() > 0;
    }

    private boolean G() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || be3.x(childAt)) ? false : true;
    }

    private void H(float f2, float f3) {
        ValueAnimator valueAnimator = this.p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f2, f3);
        this.p = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.s);
        this.p.setInterpolator(this.t);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f245q;
        if (animatorUpdateListener != null) {
            this.p.addUpdateListener(animatorUpdateListener);
        }
        this.p.start();
    }

    private void I() {
        setWillNotDraw(!E());
    }

    private void e() {
        WeakReference weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.n = null;
    }

    private Integer f() {
        Drawable drawable = this.v;
        if (drawable instanceof tg1) {
            return Integer.valueOf(((tg1) drawable).A());
        }
        ColorStateList colorStateListG = qd0.g(drawable);
        if (colorStateListG != null) {
            return Integer.valueOf(colorStateListG.getDefaultColor());
        }
        return null;
    }

    private View g(View view) {
        int i;
        if (this.n == null && (i = this.m) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.m);
            }
            if (viewFindViewById != null) {
                this.n = new WeakReference(viewFindViewById);
            }
        }
        WeakReference weakReference = this.n;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    private boolean l() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((e) getChildAt(i).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    private void n(final tg1 tg1Var, final ColorStateList colorStateList, final ColorStateList colorStateList2) {
        final Integer numF = og1.f(getContext(), R$attr.colorSurface);
        this.f245q = new ValueAnimator.AnimatorUpdateListener() { // from class: k8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.s(colorStateList, colorStateList2, tg1Var, numF, valueAnimator);
            }
        };
        be3.t0(this, tg1Var);
    }

    private void o(Context context, final tg1 tg1Var) {
        tg1Var.Q(context);
        this.f245q = new ValueAnimator.AnimatorUpdateListener() { // from class: l8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.t(tg1Var, valueAnimator);
            }
        };
        be3.t0(this, tg1Var);
    }

    private void p() {
        Behavior behavior = this.y;
        BaseBehavior.SavedState savedStateX0 = (behavior == null || this.b == -1 || this.f != 0) ? null : behavior.x0(AbsSavedState.EMPTY_STATE, this);
        this.b = -1;
        this.c = -1;
        this.d = -1;
        if (savedStateX0 != null) {
            this.y.w0(savedStateX0, false);
        }
    }

    private boolean r() {
        return getBackground() instanceof tg1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(ColorStateList colorStateList, ColorStateList colorStateList2, tg1 tg1Var, Integer num, ValueAnimator valueAnimator) {
        Integer num2;
        int iJ = og1.j(colorStateList.getDefaultColor(), colorStateList2.getDefaultColor(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
        tg1Var.b0(ColorStateList.valueOf(iJ));
        if (this.v != null && (num2 = this.w) != null && num2.equals(num)) {
            dd0.n(this.v, iJ);
        }
        if (this.r.isEmpty()) {
            return;
        }
        Iterator it = this.r.iterator();
        while (it.hasNext()) {
            e43.a(it.next());
            if (tg1Var.x() != null) {
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(tg1 tg1Var, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        tg1Var.a0(fFloatValue);
        Drawable drawable = this.v;
        if (drawable instanceof tg1) {
            ((tg1) drawable).a0(fFloatValue);
        }
        Iterator it = this.r.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            tg1Var.A();
            throw null;
        }
    }

    boolean C(boolean z2) {
        return D(z2, !this.i);
    }

    boolean D(boolean z2, boolean z3) {
        if (!z3 || this.k == z2) {
            return false;
        }
        this.k = z2;
        refreshDrawableState();
        if (!r()) {
            return true;
        }
        if (this.o) {
            H(z2 ? 0.0f : 1.0f, z2 ? 1.0f : 0.0f);
            return true;
        }
        if (!this.l) {
            return true;
        }
        H(z2 ? 0.0f : this.x, z2 ? this.x : 0.0f);
        return true;
    }

    boolean F(View view) {
        View viewG = g(view);
        if (viewG != null) {
            view = viewG;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public void c(b bVar) {
        if (this.h == null) {
            this.h = new ArrayList();
        }
        if (bVar == null || this.h.contains(bVar)) {
            return;
        }
        this.h.add(bVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    public void d(f fVar) {
        c(fVar);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (E()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.a);
            this.v.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.v;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c getBehavior() {
        Behavior behavior = new Behavior();
        this.y = behavior;
        return behavior;
    }

    int getDownNestedPreScrollRange() {
        int iMin;
        int iB;
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i3 = eVar.a;
                if ((i3 & 5) != 5) {
                    if (i2 > 0) {
                        break;
                    }
                } else {
                    int i4 = ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                    if ((i3 & 8) != 0) {
                        iB = be3.B(childAt);
                    } else {
                        if ((i3 & 2) != 0) {
                            iB = measuredHeight - be3.B(childAt);
                        } else {
                            iMin = i4 + measuredHeight;
                        }
                        if (childCount == 0 && be3.x(childAt)) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                        i2 += iMin;
                    }
                    iMin = i4 + iB;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i2 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i2);
        this.c = iMax;
        return iMax;
    }

    int getDownNestedScrollRange() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int iB = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                int i3 = eVar.a;
                if ((i3 & 1) == 0) {
                    break;
                }
                iB += measuredHeight;
                if ((i3 & 2) != 0) {
                    iB -= be3.B(childAt);
                    break;
                }
            }
        }
        int iMax = Math.max(0, iB);
        this.d = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.m;
    }

    public tg1 getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof tg1) {
            return (tg1) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int iB = be3.B(this);
        if (iB == 0) {
            int childCount = getChildCount();
            iB = childCount >= 1 ? be3.B(getChildAt(childCount - 1)) : 0;
            if (iB == 0) {
                return getHeight() / 3;
            }
        }
        return (iB * 2) + topInset;
    }

    int getPendingAction() {
        return this.f;
    }

    public Drawable getStatusBarForeground() {
        return this.v;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        zi3 zi3Var = this.g;
        if (zi3Var != null) {
            return zi3Var.l();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.b;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int iB = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i3 = eVar.a;
                if ((i3 & 1) == 0) {
                    break;
                }
                iB += measuredHeight + ((LinearLayout.LayoutParams) eVar).topMargin + ((LinearLayout.LayoutParams) eVar).bottomMargin;
                if (i2 == 0 && be3.x(childAt)) {
                    iB -= getTopInset();
                }
                if ((i3 & 2) != 0) {
                    iB -= be3.B(childAt);
                    break;
                }
            }
        }
        int iMax = Math.max(0, iB);
        this.b = iMax;
        return iMax;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new e((LinearLayout.LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    boolean k() {
        return this.e;
    }

    boolean m() {
        return getTotalScrollRange() != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ug1.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        if (this.u == null) {
            this.u = new int[4];
        }
        int[] iArr = this.u;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        boolean z2 = this.j;
        int i2 = R$attr.state_liftable;
        if (!z2) {
            i2 = -i2;
        }
        iArr[0] = i2;
        iArr[1] = (z2 && this.k) ? R$attr.state_lifted : -R$attr.state_lifted;
        int i3 = R$attr.state_collapsible;
        if (!z2) {
            i3 = -i3;
        }
        iArr[2] = i3;
        iArr[3] = (z2 && this.k) ? R$attr.state_collapsed : -R$attr.state_collapsed;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        boolean z3 = true;
        if (be3.x(this) && G()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                be3.a0(getChildAt(childCount), topInset);
            }
        }
        p();
        this.e = false;
        int childCount2 = getChildCount();
        for (int i5 = 0; i5 < childCount2; i5++) {
            if (((e) getChildAt(i5).getLayoutParams()).d() != null) {
                this.e = true;
                break;
            }
        }
        Drawable drawable = this.v;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.i) {
            return;
        }
        if (!this.l && !l()) {
            z3 = false;
        }
        B(z3);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824 && be3.x(this) && G()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = eh1.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i2));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        p();
    }

    public boolean q() {
        return this.l;
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        ug1.d(this, f2);
    }

    public void setExpanded(boolean z2) {
        z(z2, be3.T(this));
    }

    public void setLiftOnScroll(boolean z2) {
        this.l = z2;
    }

    public void setLiftOnScrollTargetView(View view) {
        this.m = -1;
        if (view == null) {
            e();
        } else {
            this.n = new WeakReference(view);
        }
    }

    public void setLiftOnScrollTargetViewId(int i) {
        this.m = i;
        e();
    }

    public void setLiftableOverrideEnabled(boolean z2) {
        this.i = z2;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.v;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.v = drawable != null ? drawable.mutate() : null;
            this.w = f();
            Drawable drawable3 = this.v;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.v.setState(getDrawableState());
                }
                dd0.m(this.v, be3.A(this));
                this.v.setVisible(getVisibility() == 0, false);
                this.v.setCallback(this);
            }
            I();
            be3.g0(this);
        }
    }

    public void setStatusBarForegroundColor(int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(int i) {
        setStatusBarForeground(v8.b(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        com.google.android.material.appbar.e.b(this, f2);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z2 = i == 0;
        Drawable drawable = this.v;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
    }

    void u(int i) {
        this.a = i;
        if (!willNotDraw()) {
            be3.g0(this);
        }
        List list = this.h;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = (b) this.h.get(i2);
                if (bVar != null) {
                    bVar.a(this, i);
                }
            }
        }
    }

    zi3 v(zi3 zi3Var) {
        zi3 zi3Var2 = be3.x(this) ? zi3Var : null;
        if (!tt1.a(this.g, zi3Var2)) {
            this.g = zi3Var2;
            I();
            requestLayout();
        }
        return zi3Var;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.v;
    }

    public void w(b bVar) {
        List list = this.h;
        if (list == null || bVar == null) {
            return;
        }
        list.remove(bVar);
    }

    public void x(f fVar) {
        w(fVar);
    }

    void y() {
        this.f = 0;
    }

    public void z(boolean z2, boolean z3) {
        A(z2, z3, true);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.appBarLayoutStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = z;
        super(yg1.c(context, attributeSet, i, i2), attributeSet, i);
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.f = 0;
        this.r = new ArrayList();
        Context context2 = getContext();
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            com.google.android.material.appbar.e.a(this);
        }
        com.google.android.material.appbar.e.c(this, attributeSet, i, i2);
        TypedArray typedArrayI = o23.i(context2, attributeSet, R$styleable.AppBarLayout, i, i2, new int[0]);
        be3.t0(this, typedArrayI.getDrawable(R$styleable.AppBarLayout_android_background));
        ColorStateList colorStateListA = sg1.a(context2, typedArrayI, R$styleable.AppBarLayout_liftOnScrollColor);
        this.o = colorStateListA != null;
        ColorStateList colorStateListG = qd0.g(getBackground());
        if (colorStateListG != null) {
            tg1 tg1Var = new tg1();
            tg1Var.b0(colorStateListG);
            if (colorStateListA != null) {
                n(tg1Var, colorStateListG, colorStateListA);
            } else {
                o(context2, tg1Var);
            }
        }
        this.s = el1.f(context2, R$attr.motionDurationMedium2, getResources().getInteger(R$integer.app_bar_elevation_anim_duration));
        this.t = el1.g(context2, R$attr.motionEasingStandardInterpolator, y6.a);
        int i3 = R$styleable.AppBarLayout_expanded;
        if (typedArrayI.hasValue(i3)) {
            A(typedArrayI.getBoolean(i3, false), false, false);
        }
        int i4 = R$styleable.AppBarLayout_elevation;
        if (typedArrayI.hasValue(i4)) {
            com.google.android.material.appbar.e.b(this, typedArrayI.getDimensionPixelSize(i4, 0));
        }
        int i5 = R$styleable.AppBarLayout_android_keyboardNavigationCluster;
        if (typedArrayI.hasValue(i5)) {
            setKeyboardNavigationCluster(typedArrayI.getBoolean(i5, false));
        }
        int i6 = R$styleable.AppBarLayout_android_touchscreenBlocksFocus;
        if (typedArrayI.hasValue(i6)) {
            setTouchscreenBlocksFocus(typedArrayI.getBoolean(i6, false));
        }
        this.x = getResources().getDimension(R$dimen.design_appbar_elevation);
        this.l = typedArrayI.getBoolean(R$styleable.AppBarLayout_liftOnScroll, false);
        this.m = typedArrayI.getResourceId(R$styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(typedArrayI.getDrawable(R$styleable.AppBarLayout_statusBarForeground));
        typedArrayI.recycle();
        be3.E0(this, new a());
    }

    public static class e extends LinearLayout.LayoutParams {
        int a;
        private c b;
        Interpolator c;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AppBarLayout_Layout);
            this.a = typedArrayObtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            f(typedArrayObtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollEffect, 0));
            int i = R$styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (typedArrayObtainStyledAttributes.hasValue(i)) {
                this.c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(i, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        private c a(int i) {
            if (i != 1) {
                return null;
            }
            return new d();
        }

        public c b() {
            return this.b;
        }

        public int c() {
            return this.a;
        }

        public Interpolator d() {
            return this.c;
        }

        boolean e() {
            int i = this.a;
            return (i & 1) == 1 && (i & 10) != 0;
        }

        public void f(int i) {
            this.b = a(i);
        }

        public void g(int i) {
            this.a = i;
        }

        public e(int i, int i2) {
            super(i, i2);
            this.a = 1;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 1;
        }

        public e(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }
    }
}
