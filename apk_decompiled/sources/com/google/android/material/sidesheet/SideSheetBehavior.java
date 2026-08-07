package com.google.android.material.sidesheet;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.tenmeter.smlibrary.utils.FileUtils;
import defpackage.be3;
import defpackage.e43;
import defpackage.eh1;
import defpackage.fe3;
import defpackage.he;
import defpackage.ig1;
import defpackage.iv0;
import defpackage.m2;
import defpackage.p2;
import defpackage.sg1;
import defpackage.sn2;
import defpackage.tg1;
import defpackage.vg1;
import defpackage.y6;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.eclipse.Eclipse;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.c implements ig1 {
    private com.google.android.material.sidesheet.c a;
    private float b;
    private tg1 c;
    private ColorStateList d;
    private sn2 e;
    private final c f;
    private float g;
    private boolean h;
    private int i;
    private int j;
    private fe3 k;
    private boolean l;
    private float m;
    private int n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f268q;
    private WeakReference r;
    private WeakReference s;
    private int t;
    private VelocityTracker u;
    private vg1 v;
    private int w;
    private final Set x;
    private final fe3.c y;
    private static final int z = R$string.side_sheet_accessibility_pane_title;
    private static final int F = R$style.Widget_Material3_SideSheet;

    class a extends fe3.c {
        a() {
        }

        @Override // fe3.c
        public int a(View view, int i, int i2) {
            return eh1.b(i, SideSheetBehavior.this.a.g(), SideSheetBehavior.this.a.f());
        }

        @Override // fe3.c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // fe3.c
        public int d(View view) {
            return SideSheetBehavior.this.n + SideSheetBehavior.this.k0();
        }

        @Override // fe3.c
        public void j(int i) {
            if (i == 1 && SideSheetBehavior.this.h) {
                SideSheetBehavior.this.J0(1);
            }
        }

        @Override // fe3.c
        public void k(View view, int i, int i2, int i3, int i4) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            View viewF0 = SideSheetBehavior.this.f0();
            if (viewF0 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewF0.getLayoutParams()) != null) {
                SideSheetBehavior.this.a.p(marginLayoutParams, view.getLeft(), view.getRight());
                viewF0.setLayoutParams(marginLayoutParams);
            }
            SideSheetBehavior.this.a0(view, i);
        }

        @Override // fe3.c
        public void l(View view, float f, float f2) {
            int iW = SideSheetBehavior.this.W(view, f, f2);
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.O0(view, iW, sideSheetBehavior.N0());
        }

        @Override // fe3.c
        public boolean m(View view, int i) {
            return (SideSheetBehavior.this.i == 1 || SideSheetBehavior.this.r == null || SideSheetBehavior.this.r.get() != view) ? false : true;
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SideSheetBehavior.this.J0(5);
            if (SideSheetBehavior.this.r == null || SideSheetBehavior.this.r.get() == null) {
                return;
            }
            ((View) SideSheetBehavior.this.r.get()).requestLayout();
        }
    }

    class c {
        private int a;
        private boolean b;
        private final Runnable c = new Runnable() { // from class: com.google.android.material.sidesheet.e
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c();
            }
        };

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            this.b = false;
            if (SideSheetBehavior.this.k != null && SideSheetBehavior.this.k.n(true)) {
                b(this.a);
            } else if (SideSheetBehavior.this.i == 2) {
                SideSheetBehavior.this.J0(this.a);
            }
        }

        void b(int i) {
            if (SideSheetBehavior.this.r == null || SideSheetBehavior.this.r.get() == null) {
                return;
            }
            this.a = i;
            if (this.b) {
                return;
            }
            be3.h0((View) SideSheetBehavior.this.r.get(), this.c);
            this.b = true;
        }
    }

    public SideSheetBehavior() {
        this.f = new c();
        this.h = true;
        this.i = 5;
        this.j = 5;
        this.m = 0.1f;
        this.t = -1;
        this.x = new LinkedHashSet();
        this.y = new a();
    }

    private void A0(CoordinatorLayout coordinatorLayout) {
        int i;
        View viewFindViewById;
        if (this.s != null || (i = this.t) == -1 || (viewFindViewById = coordinatorLayout.findViewById(i)) == null) {
            return;
        }
        this.s = new WeakReference(viewFindViewById);
    }

    private void B0(View view, m2.a aVar, int i) {
        be3.l0(view, aVar, null, Y(i));
    }

    private void C0() {
        VelocityTracker velocityTracker = this.u;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.u = null;
        }
    }

    private void D0(View view, Runnable runnable) {
        if (v0(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void G0(int i) {
        com.google.android.material.sidesheet.c cVar = this.a;
        if (cVar == null || cVar.j() != i) {
            if (i == 0) {
                this.a = new com.google.android.material.sidesheet.b(this);
                if (this.e == null || s0()) {
                    return;
                }
                sn2.b bVarV = this.e.v();
                bVarV.I(0.0f).z(0.0f);
                R0(bVarV.m());
                return;
            }
            if (i == 1) {
                this.a = new com.google.android.material.sidesheet.a(this);
                if (this.e == null || r0()) {
                    return;
                }
                sn2.b bVarV2 = this.e.v();
                bVarV2.E(0.0f).v(0.0f);
                R0(bVarV2.m());
                return;
            }
            throw new IllegalArgumentException("Invalid sheet edge position value: " + i + ". Must be 0 or 1" + FileUtils.FILE_EXTENSION_SEPARATOR);
        }
    }

    private void H0(View view, int i) {
        G0(iv0.b(((CoordinatorLayout.f) view.getLayoutParams()).c, i) == 3 ? 1 : 0);
    }

    private boolean K0() {
        return this.k != null && (this.h || this.i == 1);
    }

    private boolean M0(View view) {
        return (view.isShown() || be3.p(view) != null) && this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(View view, int i, boolean z2) {
        if (!w0(view, i, z2)) {
            J0(i);
        } else {
            J0(2);
            this.f.b(i);
        }
    }

    private void P0() {
        View view;
        WeakReference weakReference = this.r;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        be3.j0(view, Opcodes.ASM4);
        be3.j0(view, Eclipse.HasTypeAnnotations);
        if (this.i != 5) {
            B0(view, m2.a.y, 5);
        }
        if (this.i != 3) {
            B0(view, m2.a.w, 3);
        }
    }

    private void Q0() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        WeakReference weakReference = this.r;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.r.get();
        View viewF0 = f0();
        if (viewF0 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewF0.getLayoutParams()) == null) {
            return;
        }
        this.a.o(marginLayoutParams, (int) ((this.n * view.getScaleX()) + this.f268q));
        viewF0.requestLayout();
    }

    private void R0(sn2 sn2Var) {
        tg1 tg1Var = this.c;
        if (tg1Var != null) {
            tg1Var.setShapeAppearanceModel(sn2Var);
        }
    }

    private void S0(View view) {
        int i = this.i == 5 ? 4 : 0;
        if (view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    private int U(int i, View view) {
        int i2 = this.i;
        if (i2 == 1 || i2 == 2) {
            return i - this.a.h(view);
        }
        if (i2 == 3) {
            return 0;
        }
        if (i2 == 5) {
            return this.a.e();
        }
        throw new IllegalStateException("Unexpected value: " + this.i);
    }

    private float V(float f, float f2) {
        return Math.abs(f - f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int W(View view, float f, float f2) {
        if (u0(f)) {
            return 3;
        }
        if (L0(view, f)) {
            if (!this.a.m(f, f2) && !this.a.l(view)) {
                return 3;
            }
        } else if (f == 0.0f || !d.a(f, f2)) {
            int left = view.getLeft();
            if (Math.abs(left - g0()) < Math.abs(left - this.a.e())) {
                return 3;
            }
        }
        return 5;
    }

    private void X() {
        WeakReference weakReference = this.s;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.s = null;
    }

    private p2 Y(final int i) {
        return new p2() { // from class: ro2
            @Override // defpackage.p2
            public final boolean a(View view, p2.a aVar) {
                return this.a.x0(i, view, aVar);
            }
        };
    }

    private void Z(Context context) {
        if (this.e == null) {
            return;
        }
        tg1 tg1Var = new tg1(this.e);
        this.c = tg1Var;
        tg1Var.Q(context);
        ColorStateList colorStateList = this.d;
        if (colorStateList != null) {
            this.c.b0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.c.setTint(typedValue.data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(View view, int i) {
        if (this.x.isEmpty()) {
            return;
        }
        this.a.b(i);
        Iterator it = this.x.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
    }

    private void b0(View view) {
        if (be3.p(view) == null) {
            be3.s0(view, view.getResources().getString(z));
        }
    }

    private int c0(int i, int i2, int i3, int i4) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i2, i4);
        if (i3 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), 1073741824);
        }
        if (size != 0) {
            i3 = Math.min(size, i3);
        }
        return View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
    }

    private ValueAnimator.AnimatorUpdateListener e0() {
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        final View viewF0 = f0();
        if (viewF0 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) viewF0.getLayoutParams()) == null) {
            return null;
        }
        final int iC = this.a.c(marginLayoutParams);
        return new ValueAnimator.AnimatorUpdateListener() { // from class: to2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.y0(marginLayoutParams, iC, viewF0, valueAnimator);
            }
        };
    }

    private int h0() {
        com.google.android.material.sidesheet.c cVar = this.a;
        return (cVar == null || cVar.j() == 0) ? 5 : 3;
    }

    private CoordinatorLayout.f q0() {
        View view;
        WeakReference weakReference = this.r;
        if (weakReference == null || (view = (View) weakReference.get()) == null || !(view.getLayoutParams() instanceof CoordinatorLayout.f)) {
            return null;
        }
        return (CoordinatorLayout.f) view.getLayoutParams();
    }

    private boolean r0() {
        CoordinatorLayout.f fVarQ0 = q0();
        return fVarQ0 != null && ((ViewGroup.MarginLayoutParams) fVarQ0).leftMargin > 0;
    }

    private boolean s0() {
        CoordinatorLayout.f fVarQ0 = q0();
        return fVarQ0 != null && ((ViewGroup.MarginLayoutParams) fVarQ0).rightMargin > 0;
    }

    private boolean t0(MotionEvent motionEvent) {
        return K0() && V((float) this.w, motionEvent.getX()) > ((float) this.k.A());
    }

    private boolean u0(float f) {
        return this.a.k(f);
    }

    private boolean v0(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && be3.S(view);
    }

    private boolean w0(View view, int i, boolean z2) {
        int iL0 = l0(i);
        fe3 fe3VarP0 = p0();
        return fe3VarP0 != null && (!z2 ? !fe3VarP0.R(view, iL0, view.getTop()) : !fe3VarP0.P(iL0, view.getTop()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean x0(int i, View view, p2.a aVar) {
        I0(i);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(ViewGroup.MarginLayoutParams marginLayoutParams, int i, View view, ValueAnimator valueAnimator) {
        this.a.o(marginLayoutParams, y6.c(i, 0, valueAnimator.getAnimatedFraction()));
        view.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(int i) {
        View view = (View) this.r.get();
        if (view != null) {
            O0(view, i, false);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void B(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.getSuperState() != null) {
            super.B(coordinatorLayout, view, savedState.getSuperState());
        }
        int i = savedState.a;
        if (i == 1 || i == 2) {
            i = 5;
        }
        this.i = i;
        this.j = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable C(CoordinatorLayout coordinatorLayout, View view) {
        return new SavedState(super.C(coordinatorLayout, view), this);
    }

    public void E0(int i) {
        this.t = i;
        X();
        WeakReference weakReference = this.r;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (i == -1 || !be3.T(view)) {
                return;
            }
            view.requestLayout();
        }
    }

    public void F0(boolean z2) {
        this.h = z2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean H(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.i == 1 && actionMasked == 0) {
            return true;
        }
        if (K0()) {
            this.k.G(motionEvent);
        }
        if (actionMasked == 0) {
            C0();
        }
        if (this.u == null) {
            this.u = VelocityTracker.obtain();
        }
        this.u.addMovement(motionEvent);
        if (K0() && actionMasked == 2 && !this.l && t0(motionEvent)) {
            this.k.c(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.l;
    }

    public void I0(final int i) {
        if (i == 1 || i == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        WeakReference weakReference = this.r;
        if (weakReference == null || weakReference.get() == null) {
            J0(i);
        } else {
            D0((View) this.r.get(), new Runnable() { // from class: so2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.z0(i);
                }
            });
        }
    }

    void J0(int i) {
        View view;
        if (this.i == i) {
            return;
        }
        this.i = i;
        if (i == 3 || i == 5) {
            this.j = i;
        }
        WeakReference weakReference = this.r;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        S0(view);
        Iterator it = this.x.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
        P0();
    }

    boolean L0(View view, float f) {
        return this.a.n(view, f);
    }

    public boolean N0() {
        return true;
    }

    @Override // defpackage.ig1
    public void a() {
        vg1 vg1Var = this.v;
        if (vg1Var == null) {
            return;
        }
        he heVarC = vg1Var.c();
        if (heVarC == null || Build.VERSION.SDK_INT < 34) {
            I0(5);
        } else {
            this.v.h(heVarC, h0(), new b(), e0());
        }
    }

    @Override // defpackage.ig1
    public void b(he heVar) {
        vg1 vg1Var = this.v;
        if (vg1Var == null) {
            return;
        }
        vg1Var.l(heVar, h0());
        Q0();
    }

    @Override // defpackage.ig1
    public void c(he heVar) {
        vg1 vg1Var = this.v;
        if (vg1Var == null) {
            return;
        }
        vg1Var.j(heVar);
    }

    @Override // defpackage.ig1
    public void d() {
        vg1 vg1Var = this.v;
        if (vg1Var == null) {
            return;
        }
        vg1Var.f();
    }

    int d0() {
        return this.n;
    }

    public View f0() {
        WeakReference weakReference = this.s;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public int g0() {
        return this.a.d();
    }

    public float i0() {
        return this.m;
    }

    float j0() {
        return 0.5f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void k(CoordinatorLayout.f fVar) {
        super.k(fVar);
        this.r = null;
        this.k = null;
        this.v = null;
    }

    int k0() {
        return this.f268q;
    }

    int l0(int i) {
        if (i == 3) {
            return g0();
        }
        if (i == 5) {
            return this.a.e();
        }
        throw new IllegalArgumentException("Invalid state to get outer edge offset: " + i);
    }

    int m0() {
        return this.p;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void n() {
        super.n();
        this.r = null;
        this.k = null;
        this.v = null;
    }

    int n0() {
        return this.o;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        fe3 fe3Var;
        if (!M0(view)) {
            this.l = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            C0();
        }
        if (this.u == null) {
            this.u = VelocityTracker.obtain();
        }
        this.u.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.w = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.l) {
            this.l = false;
            return false;
        }
        return (this.l || (fe3Var = this.k) == null || !fe3Var.Q(motionEvent)) ? false : true;
    }

    int o0() {
        return 500;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean p(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (be3.x(coordinatorLayout) && !be3.x(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.r == null) {
            this.r = new WeakReference(view);
            this.v = new vg1(view);
            tg1 tg1Var = this.c;
            if (tg1Var != null) {
                be3.t0(view, tg1Var);
                tg1 tg1Var2 = this.c;
                float fV = this.g;
                if (fV == -1.0f) {
                    fV = be3.v(view);
                }
                tg1Var2.a0(fV);
            } else {
                ColorStateList colorStateList = this.d;
                if (colorStateList != null) {
                    be3.u0(view, colorStateList);
                }
            }
            S0(view);
            P0();
            if (be3.y(view) == 0) {
                be3.z0(view, 1);
            }
            b0(view);
        }
        H0(view, i);
        if (this.k == null) {
            this.k = fe3.p(coordinatorLayout, this.y);
        }
        int iH = this.a.h(view);
        coordinatorLayout.M(view, i);
        this.o = coordinatorLayout.getWidth();
        this.p = this.a.i(coordinatorLayout);
        this.n = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.f268q = marginLayoutParams != null ? this.a.a(marginLayoutParams) : 0;
        be3.Z(view, U(iH, view));
        A0(coordinatorLayout);
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            e43.a(it.next());
        }
        return true;
    }

    fe3 p0() {
        return this.k;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean q(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(c0(i, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, -1, marginLayoutParams.width), c0(i3, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, -1, marginLayoutParams.height));
        return true;
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        final int a;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
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
            this.a = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }

        public SavedState(Parcelable parcelable, SideSheetBehavior sideSheetBehavior) {
            super(parcelable);
            this.a = sideSheetBehavior.i;
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new c();
        this.h = true;
        this.i = 5;
        this.j = 5;
        this.m = 0.1f;
        this.t = -1;
        this.x = new LinkedHashSet();
        this.y = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SideSheetBehavior_Layout);
        int i = R$styleable.SideSheetBehavior_Layout_backgroundTint;
        if (typedArrayObtainStyledAttributes.hasValue(i)) {
            this.d = sg1.a(context, typedArrayObtainStyledAttributes, i);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.SideSheetBehavior_Layout_shapeAppearance)) {
            this.e = sn2.e(context, attributeSet, 0, F).m();
        }
        int i2 = R$styleable.SideSheetBehavior_Layout_coplanarSiblingViewId;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            E0(typedArrayObtainStyledAttributes.getResourceId(i2, -1));
        }
        Z(context);
        this.g = typedArrayObtainStyledAttributes.getDimension(R$styleable.SideSheetBehavior_Layout_android_elevation, -1.0f);
        F0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.SideSheetBehavior_Layout_behavior_draggable, true));
        typedArrayObtainStyledAttributes.recycle();
        this.b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
