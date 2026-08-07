package com.google.android.material.bottomsheet;

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
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import defpackage.be3;
import defpackage.eh1;
import defpackage.fe3;
import defpackage.he;
import defpackage.ig1;
import defpackage.m2;
import defpackage.mg1;
import defpackage.nf3;
import defpackage.p2;
import defpackage.sg1;
import defpackage.sn2;
import defpackage.tg1;
import defpackage.z21;
import defpackage.zi3;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lombok.eclipse.Eclipse;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c implements ig1 {
    private static final int n0 = R$style.Widget_Design_BottomSheet_Modal;
    private boolean F;
    private final h G;
    private ValueAnimator H;
    int I;
    int J;
    int K;
    float L;
    int M;
    float N;
    boolean O;
    private boolean P;
    private boolean Q;
    int R;
    int S;
    fe3 T;
    private boolean U;
    private int V;
    private boolean W;
    private float X;
    private int Y;
    int Z;
    private int a;
    int a0;
    private boolean b;
    WeakReference b0;
    private boolean c;
    WeakReference c0;
    private float d;
    WeakReference d0;
    private int e;
    private final ArrayList e0;
    private int f;
    private VelocityTracker f0;
    private boolean g;
    mg1 g0;
    private int h;
    int h0;
    private int i;
    private int i0;
    private tg1 j;
    boolean j0;
    private ColorStateList k;
    private Map k0;
    private int l;
    final SparseIntArray l0;
    private int m;
    private final fe3.c m0;
    private int n;
    private boolean o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f248q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private boolean y;
    private sn2 z;

    class a implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ int b;

        a(View view, int i) {
            this.a = view;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.g1(this.a, this.b, false);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomSheetBehavior.this.Z0(5);
            WeakReference weakReference = BottomSheetBehavior.this.b0;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            ((View) BottomSheetBehavior.this.b0.get()).requestLayout();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.j != null) {
                BottomSheetBehavior.this.j.c0(fFloatValue);
            }
        }
    }

    class d implements nf3.d {
        final /* synthetic */ boolean a;

        d(boolean z) {
            this.a = z;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0080  */
        /* JADX WARN: Code duplicated, block: B:33:0x00a3  */
        @Override // nf3.d
        public zi3 a(View view, zi3 zi3Var, nf3.e eVar) {
            boolean z;
            z21 z21VarF = zi3Var.f(zi3.l.d());
            z21 z21VarF2 = zi3Var.f(zi3.l.c());
            BottomSheetBehavior.this.x = z21VarF.b;
            boolean zO = nf3.o(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.this.p) {
                BottomSheetBehavior.this.w = zi3Var.i();
                paddingBottom = eVar.d + BottomSheetBehavior.this.w;
            }
            if (BottomSheetBehavior.this.f248q) {
                paddingLeft = (zO ? eVar.c : eVar.a) + z21VarF.a;
            }
            if (BottomSheetBehavior.this.r) {
                paddingRight = (zO ? eVar.a : eVar.c) + z21VarF.c;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            boolean z2 = true;
            if (BottomSheetBehavior.this.t) {
                int i = marginLayoutParams.leftMargin;
                int i2 = z21VarF.a;
                if (i != i2) {
                    marginLayoutParams.leftMargin = i2;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (BottomSheetBehavior.this.u) {
                int i3 = marginLayoutParams.rightMargin;
                int i4 = z21VarF.c;
                if (i3 != i4) {
                    marginLayoutParams.rightMargin = i4;
                    z = true;
                }
            }
            if (BottomSheetBehavior.this.v) {
                int i5 = marginLayoutParams.topMargin;
                int i6 = z21VarF.b;
                if (i5 != i6) {
                    marginLayoutParams.topMargin = i6;
                } else {
                    z2 = z;
                }
            } else {
                z2 = z;
            }
            if (z2) {
                view.setLayoutParams(marginLayoutParams);
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.a) {
                BottomSheetBehavior.this.n = z21VarF2.d;
            }
            if (BottomSheetBehavior.this.p || this.a) {
                BottomSheetBehavior.this.l1(false);
            }
            return zi3Var;
        }
    }

    class e extends fe3.c {
        private long a;

        e() {
        }

        private boolean n(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.a0 + bottomSheetBehavior.s0()) / 2;
        }

        @Override // fe3.c
        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // fe3.c
        public int b(View view, int i, int i2) {
            return eh1.b(i, BottomSheetBehavior.this.s0(), e(view));
        }

        @Override // fe3.c
        public int e(View view) {
            return BottomSheetBehavior.this.j0() ? BottomSheetBehavior.this.a0 : BottomSheetBehavior.this.M;
        }

        @Override // fe3.c
        public void j(int i) {
            if (i == 1 && BottomSheetBehavior.this.Q) {
                BottomSheetBehavior.this.Z0(1);
            }
        }

        @Override // fe3.c
        public void k(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.o0(i2);
        }

        /* JADX WARN: Code duplicated, block: B:39:0x00ad  */
        /* JADX WARN: Code duplicated, block: B:6:0x0010  */
        @Override // fe3.c
        public void l(View view, float f, float f2) {
            int i = 6;
            if (f2 >= 0.0f) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.O && bottomSheetBehavior.d1(view, f2)) {
                    if ((Math.abs(f) < Math.abs(f2) && f2 > BottomSheetBehavior.this.e) || n(view)) {
                        i = 5;
                    } else if (BottomSheetBehavior.this.b || Math.abs(view.getTop() - BottomSheetBehavior.this.s0()) < Math.abs(view.getTop() - BottomSheetBehavior.this.K)) {
                        i = 3;
                    }
                } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                    int top = view.getTop();
                    if (!BottomSheetBehavior.this.b) {
                        BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                        int i2 = bottomSheetBehavior2.K;
                        if (top < i2) {
                            if (top < Math.abs(top - bottomSheetBehavior2.M)) {
                                i = 3;
                            } else if (BottomSheetBehavior.this.e1()) {
                                i = 4;
                            }
                        } else if (Math.abs(top - i2) >= Math.abs(top - BottomSheetBehavior.this.M) || BottomSheetBehavior.this.e1()) {
                            i = 4;
                        }
                    } else if (Math.abs(top - BottomSheetBehavior.this.J) < Math.abs(top - BottomSheetBehavior.this.M)) {
                        i = 3;
                    } else {
                        i = 4;
                    }
                } else if (BottomSheetBehavior.this.b) {
                    i = 4;
                } else {
                    int top2 = view.getTop();
                    if (Math.abs(top2 - BottomSheetBehavior.this.K) >= Math.abs(top2 - BottomSheetBehavior.this.M) || BottomSheetBehavior.this.e1()) {
                        i = 4;
                    }
                }
            } else if (BottomSheetBehavior.this.b) {
                i = 3;
            } else {
                int top3 = view.getTop();
                long jCurrentTimeMillis = System.currentTimeMillis() - this.a;
                if (BottomSheetBehavior.this.e1()) {
                    BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                    if (!bottomSheetBehavior3.b1(jCurrentTimeMillis, (top3 * 100.0f) / bottomSheetBehavior3.a0)) {
                        i = 4;
                    }
                } else if (top3 <= BottomSheetBehavior.this.K) {
                }
                i = 3;
            }
            BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
            bottomSheetBehavior4.g1(view, i, bottomSheetBehavior4.f1());
        }

        @Override // fe3.c
        public boolean m(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.R;
            if (i2 == 1 || bottomSheetBehavior.j0) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.h0 == i) {
                WeakReference weakReference = bottomSheetBehavior.d0;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.a = System.currentTimeMillis();
            WeakReference weakReference2 = BottomSheetBehavior.this.b0;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    class f implements p2 {
        final /* synthetic */ int a;

        f(int i) {
            this.a = i;
        }

        @Override // defpackage.p2
        public boolean a(View view, p2.a aVar) {
            BottomSheetBehavior.this.Y0(this.a);
            return true;
        }
    }

    public static abstract class g {
        void a(View view) {
        }

        public abstract void b(View view, float f);

        public abstract void c(View view, int i);
    }

    public BottomSheetBehavior() {
        this.a = 0;
        this.b = true;
        this.c = false;
        this.l = -1;
        this.m = -1;
        this.G = new h(this, null);
        this.L = 0.5f;
        this.N = -1.0f;
        this.Q = true;
        this.R = 4;
        this.S = 4;
        this.X = 0.1f;
        this.e0 = new ArrayList();
        this.i0 = -1;
        this.l0 = new SparseIntArray();
        this.m0 = new e();
    }

    private boolean D0(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && be3.S(view);
    }

    private void G0(View view, m2.a aVar, int i) {
        be3.l0(view, aVar, null, l0(i));
    }

    private void H0() {
        this.h0 = -1;
        this.i0 = -1;
        VelocityTracker velocityTracker = this.f0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f0 = null;
        }
    }

    private void I0(SavedState savedState) {
        int i = this.a;
        if (i == 0) {
            return;
        }
        if (i == -1 || (i & 1) == 1) {
            this.f = savedState.b;
        }
        if (i == -1 || (i & 2) == 2) {
            this.b = savedState.c;
        }
        if (i == -1 || (i & 4) == 4) {
            this.O = savedState.d;
        }
        if (i == -1 || (i & 8) == 8) {
            this.P = savedState.e;
        }
    }

    private void J0(View view, Runnable runnable) {
        if (D0(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void a1(View view) {
        boolean z = (Build.VERSION.SDK_INT < 29 || A0() || this.g) ? false : true;
        if (this.p || this.f248q || this.r || this.t || this.u || this.v || z) {
            nf3.e(view, new d(z));
        }
    }

    private int b0(View view, int i, int i2) {
        return be3.c(view, view.getResources().getString(i), l0(i2));
    }

    private boolean c1() {
        return this.T != null && (this.Q || this.R == 1);
    }

    private void d0() {
        int iH0 = h0();
        if (this.b) {
            this.M = Math.max(this.a0 - iH0, this.J);
        } else {
            this.M = this.a0 - iH0;
        }
    }

    private float e0(float f2, RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            float radius = roundedCorner.getRadius();
            if (radius > 0.0f && f2 > 0.0f) {
                return radius / f2;
            }
        }
        return 0.0f;
    }

    private void f0() {
        this.K = (int) (this.a0 * (1.0f - this.L));
    }

    private float g0() {
        WeakReference weakReference;
        WindowInsets rootWindowInsets;
        if (this.j == null || (weakReference = this.b0) == null || weakReference.get() == null || Build.VERSION.SDK_INT < 31) {
            return 0.0f;
        }
        View view = (View) this.b0.get();
        if (!x0() || (rootWindowInsets = view.getRootWindowInsets()) == null) {
            return 0.0f;
        }
        return Math.max(e0(this.j.J(), rootWindowInsets.getRoundedCorner(0)), e0(this.j.K(), rootWindowInsets.getRoundedCorner(1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1(View view, int i, boolean z) {
        int iV0 = v0(i);
        fe3 fe3Var = this.T;
        if (fe3Var == null || (!z ? fe3Var.R(view, view.getLeft(), iV0) : fe3Var.P(view.getLeft(), iV0))) {
            Z0(i);
            return;
        }
        Z0(2);
        j1(i, true);
        this.G.c(i);
    }

    private int h0() {
        int i;
        if (this.g) {
            return Math.min(Math.max(this.h, this.a0 - ((this.Z * 9) / 16)), this.Y) + this.w;
        }
        return (this.o || this.p || (i = this.n) <= 0) ? this.f + this.w : Math.max(this.f, i + this.i);
    }

    private void h1() {
        WeakReference weakReference = this.b0;
        if (weakReference != null) {
            i1((View) weakReference.get(), 0);
        }
        WeakReference weakReference2 = this.c0;
        if (weakReference2 != null) {
            i1((View) weakReference2.get(), 1);
        }
    }

    private float i0(int i) {
        float f2;
        float fS0;
        int i2 = this.M;
        if (i > i2 || i2 == s0()) {
            int i3 = this.M;
            f2 = i3 - i;
            fS0 = this.a0 - i3;
        } else {
            int i4 = this.M;
            f2 = i4 - i;
            fS0 = i4 - s0();
        }
        return f2 / fS0;
    }

    private void i1(View view, int i) {
        if (view == null) {
            return;
        }
        k0(view, i);
        if (!this.b && this.R != 6) {
            this.l0.put(i, b0(view, R$string.bottomsheet_action_expand_halfway, 6));
        }
        if (this.O && C0() && this.R != 5) {
            G0(view, m2.a.y, 5);
        }
        int i2 = this.R;
        if (i2 == 3) {
            G0(view, m2.a.x, this.b ? 4 : 6);
            return;
        }
        if (i2 == 4) {
            G0(view, m2.a.w, this.b ? 3 : 6);
        } else {
            if (i2 != 6) {
                return;
            }
            G0(view, m2.a.x, 4);
            G0(view, m2.a.w, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j0() {
        return B0() && C0();
    }

    private void j1(int i, boolean z) {
        boolean zY0;
        ValueAnimator valueAnimator;
        if (i == 2 || this.F == (zY0 = y0()) || this.j == null) {
            return;
        }
        this.F = zY0;
        if (!z || (valueAnimator = this.H) == null) {
            ValueAnimator valueAnimator2 = this.H;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.H.cancel();
            }
            this.j.c0(this.F ? g0() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            this.H.reverse();
        } else {
            this.H.setFloatValues(this.j.y(), zY0 ? g0() : 1.0f);
            this.H.start();
        }
    }

    private void k0(View view, int i) {
        if (view == null) {
            return;
        }
        be3.j0(view, Opcodes.ASM8);
        be3.j0(view, Opcodes.ASM4);
        be3.j0(view, Eclipse.HasTypeAnnotations);
        int i2 = this.l0.get(i, -1);
        if (i2 != -1) {
            be3.j0(view, i2);
            this.l0.delete(i);
        }
    }

    private void k1(boolean z) {
        Map map;
        WeakReference weakReference = this.b0;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.k0 != null) {
                    return;
                } else {
                    this.k0 = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.b0.get()) {
                    if (z) {
                        this.k0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.c) {
                            be3.z0(childAt, 4);
                        }
                    } else if (this.c && (map = this.k0) != null && map.containsKey(childAt)) {
                        be3.z0(childAt, ((Integer) this.k0.get(childAt)).intValue());
                    }
                }
            }
            if (!z) {
                this.k0 = null;
            } else if (this.c) {
                ((View) this.b0.get()).sendAccessibilityEvent(8);
            }
        }
    }

    private p2 l0(int i) {
        return new f(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(boolean z) {
        View view;
        if (this.b0 != null) {
            d0();
            if (this.R != 4 || (view = (View) this.b0.get()) == null) {
                return;
            }
            if (z) {
                Y0(4);
            } else {
                view.requestLayout();
            }
        }
    }

    private void m0(Context context) {
        if (this.z == null) {
            return;
        }
        tg1 tg1Var = new tg1(this.z);
        this.j = tg1Var;
        tg1Var.Q(context);
        ColorStateList colorStateList = this.k;
        if (colorStateList != null) {
            this.j.b0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.j.setTint(typedValue.data);
    }

    private void n0() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(g0(), 1.0f);
        this.H = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.H.addUpdateListener(new c());
    }

    public static BottomSheetBehavior q0(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.f)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) layoutParams).f();
        if (cVarF instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) cVarF;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    private int r0(int i, int i2, int i3, int i4) {
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

    private int v0(int i) {
        if (i == 3) {
            return s0();
        }
        if (i == 4) {
            return this.M;
        }
        if (i == 5) {
            return this.a0;
        }
        if (i == 6) {
            return this.K;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i);
    }

    private float w0() {
        VelocityTracker velocityTracker = this.f0;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.d);
        return this.f0.getYVelocity(this.h0);
    }

    private boolean x0() {
        WeakReference weakReference = this.b0;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        int[] iArr = new int[2];
        ((View) this.b0.get()).getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    private boolean y0() {
        return this.R == 3 && (this.y || x0());
    }

    public boolean A0() {
        return this.o;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void B(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.B(coordinatorLayout, view, savedState.getSuperState());
        I0(savedState);
        int i = savedState.a;
        if (i == 1 || i == 2) {
            this.R = 4;
            this.S = 4;
        } else {
            this.R = i;
            this.S = i;
        }
    }

    public boolean B0() {
        return this.O;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable C(CoordinatorLayout coordinatorLayout, View view) {
        return new SavedState(super.C(coordinatorLayout, view), this);
    }

    public boolean C0() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean E(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        this.V = 0;
        this.W = false;
        return (i & 2) != 0;
    }

    public boolean E0() {
        return true;
    }

    public void F0(g gVar) {
        this.e0.remove(gVar);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a9  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void G(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
        WeakReference weakReference;
        int i2 = 3;
        if (view.getTop() == s0()) {
            Z0(3);
            return;
        }
        if (!E0() || ((weakReference = this.d0) != null && view2 == weakReference.get() && this.W)) {
            if (this.V > 0) {
                if (!this.b && view.getTop() > this.K) {
                    i2 = 6;
                }
            } else if (this.O && d1(view, w0())) {
                i2 = 5;
            } else if (this.V == 0) {
                int top = view.getTop();
                if (!this.b) {
                    int i3 = this.K;
                    if (top < i3) {
                        if (top >= Math.abs(top - this.M)) {
                            if (e1()) {
                                i2 = 4;
                            } else {
                                i2 = 6;
                            }
                        }
                    } else if (Math.abs(top - i3) < Math.abs(top - this.M)) {
                        i2 = 6;
                    } else {
                        i2 = 4;
                    }
                } else if (Math.abs(top - this.J) >= Math.abs(top - this.M)) {
                    i2 = 4;
                }
            } else {
                if (!this.b) {
                    int top2 = view.getTop();
                    if (Math.abs(top2 - this.K) < Math.abs(top2 - this.M)) {
                        i2 = 6;
                    }
                }
                i2 = 4;
            }
            g1(view, i2, false);
            this.W = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean H(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.R == 1 && actionMasked == 0) {
            return true;
        }
        if (c1()) {
            this.T.G(motionEvent);
        }
        if (actionMasked == 0) {
            H0();
        }
        if (this.f0 == null) {
            this.f0 = VelocityTracker.obtain();
        }
        this.f0.addMovement(motionEvent);
        if (c1() && actionMasked == 2 && !this.U && Math.abs(this.i0 - motionEvent.getY()) > this.T.A()) {
            this.T.c(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.U;
    }

    void K0(View view) {
        WeakReference weakReference;
        if (view != null || (weakReference = this.c0) == null) {
            this.c0 = new WeakReference(view);
            i1(view, 1);
        } else {
            k0((View) weakReference.get(), 1);
            this.c0 = null;
        }
    }

    public void L0(boolean z) {
        this.Q = z;
    }

    public void M0(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.I = i;
        j1(this.R, true);
    }

    public void N0(boolean z) {
        if (this.b == z) {
            return;
        }
        this.b = z;
        if (this.b0 != null) {
            d0();
        }
        Z0((this.b && this.R == 6) ? 3 : this.R);
        j1(this.R, true);
        h1();
    }

    public void O0(boolean z) {
        this.o = z;
    }

    public void P0(float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.L = f2;
        if (this.b0 != null) {
            f0();
        }
    }

    public void Q0(boolean z) {
        if (this.O != z) {
            this.O = z;
            if (!z && this.R == 5) {
                Y0(4);
            }
            h1();
        }
    }

    public void R0(int i) {
        this.m = i;
    }

    public void S0(int i) {
        this.l = i;
    }

    public void T0(int i) {
        U0(i, false);
    }

    public final void U0(int i, boolean z) {
        if (i == -1) {
            if (this.g) {
                return;
            } else {
                this.g = true;
            }
        } else {
            if (!this.g && this.f == i) {
                return;
            }
            this.g = false;
            this.f = Math.max(0, i);
        }
        l1(z);
    }

    public void V0(int i) {
        this.a = i;
    }

    public void W0(int i) {
        this.e = i;
    }

    public void X0(boolean z) {
        this.P = z;
    }

    public void Y0(int i) {
        if (i == 1 || i == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (!this.O && i == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i);
            return;
        }
        int i2 = (i == 6 && this.b && v0(i) <= this.J) ? 3 : i;
        WeakReference weakReference = this.b0;
        if (weakReference == null || weakReference.get() == null) {
            Z0(i);
        } else {
            View view = (View) this.b0.get();
            J0(view, new a(view, i2));
        }
    }

    void Z0(int i) {
        View view;
        if (this.R == i) {
            return;
        }
        this.R = i;
        if (i == 4 || i == 3 || i == 6 || (this.O && i == 5)) {
            this.S = i;
        }
        WeakReference weakReference = this.b0;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            k1(true);
        } else if (i == 6 || i == 5 || i == 4) {
            k1(false);
        }
        j1(i, true);
        for (int i2 = 0; i2 < this.e0.size(); i2++) {
            ((g) this.e0.get(i2)).c(view, i);
        }
        h1();
    }

    @Override // defpackage.ig1
    public void a() {
        mg1 mg1Var = this.g0;
        if (mg1Var == null) {
            return;
        }
        he heVarC = mg1Var.c();
        if (heVarC == null || Build.VERSION.SDK_INT < 34) {
            Y0(this.O ? 5 : 4);
        } else if (this.O) {
            this.g0.h(heVarC, new b());
        } else {
            this.g0.i(heVarC, null);
            Y0(4);
        }
    }

    @Override // defpackage.ig1
    public void b(he heVar) {
        mg1 mg1Var = this.g0;
        if (mg1Var == null) {
            return;
        }
        mg1Var.l(heVar);
    }

    public boolean b1(long j, float f2) {
        return false;
    }

    @Override // defpackage.ig1
    public void c(he heVar) {
        mg1 mg1Var = this.g0;
        if (mg1Var == null) {
            return;
        }
        mg1Var.j(heVar);
    }

    public void c0(g gVar) {
        if (this.e0.contains(gVar)) {
            return;
        }
        this.e0.add(gVar);
    }

    @Override // defpackage.ig1
    public void d() {
        mg1 mg1Var = this.g0;
        if (mg1Var == null) {
            return;
        }
        mg1Var.f();
    }

    boolean d1(View view, float f2) {
        if (this.P) {
            return true;
        }
        if (C0() && view.getTop() >= this.M) {
            return Math.abs((((float) view.getTop()) + (f2 * this.X)) - ((float) this.M)) / ((float) h0()) > 0.5f;
        }
        return false;
    }

    public boolean e1() {
        return false;
    }

    public boolean f1() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void k(CoordinatorLayout.f fVar) {
        super.k(fVar);
        this.b0 = null;
        this.T = null;
        this.g0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void n() {
        super.n();
        this.b0 = null;
        this.T = null;
        this.g0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i;
        fe3 fe3Var;
        if (!view.isShown() || !this.Q) {
            this.U = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            H0();
        }
        if (this.f0 == null) {
            this.f0 = VelocityTracker.obtain();
        }
        this.f0.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.i0 = (int) motionEvent.getY();
            if (this.R != 2) {
                WeakReference weakReference = this.d0;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.F(view2, x, this.i0)) {
                    this.h0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.j0 = true;
                }
            }
            this.U = this.h0 == -1 && !coordinatorLayout.F(view, x, this.i0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.j0 = false;
            this.h0 = -1;
            if (this.U) {
                this.U = false;
                return false;
            }
        }
        if (!this.U && (fe3Var = this.T) != null && fe3Var.Q(motionEvent)) {
            return true;
        }
        WeakReference weakReference2 = this.d0;
        View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
        return (actionMasked != 2 || view3 == null || this.U || this.R == 1 || coordinatorLayout.F(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.T == null || (i = this.i0) == -1 || Math.abs(((float) i) - motionEvent.getY()) <= ((float) this.T.A())) ? false : true;
    }

    void o0(int i) {
        View view = (View) this.b0.get();
        if (view == null || this.e0.isEmpty()) {
            return;
        }
        float fI0 = i0(i);
        for (int i2 = 0; i2 < this.e0.size(); i2++) {
            ((g) this.e0.get(i2)).b(view, fI0);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean p(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (be3.x(coordinatorLayout) && !be3.x(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.b0 == null) {
            this.h = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            a1(view);
            be3.M0(view, new com.google.android.material.bottomsheet.b(view));
            this.b0 = new WeakReference(view);
            this.g0 = new mg1(view);
            tg1 tg1Var = this.j;
            if (tg1Var != null) {
                be3.t0(view, tg1Var);
                tg1 tg1Var2 = this.j;
                float fV = this.N;
                if (fV == -1.0f) {
                    fV = be3.v(view);
                }
                tg1Var2.a0(fV);
            } else {
                ColorStateList colorStateList = this.k;
                if (colorStateList != null) {
                    be3.u0(view, colorStateList);
                }
            }
            h1();
            if (be3.y(view) == 0) {
                be3.z0(view, 1);
            }
        }
        if (this.T == null) {
            this.T = fe3.p(coordinatorLayout, this.m0);
        }
        int top = view.getTop();
        coordinatorLayout.M(view, i);
        this.Z = coordinatorLayout.getWidth();
        this.a0 = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.Y = height;
        int iMin = this.a0;
        int i2 = iMin - height;
        int i3 = this.x;
        if (i2 < i3) {
            if (this.s) {
                int i4 = this.m;
                if (i4 != -1) {
                    iMin = Math.min(iMin, i4);
                }
                this.Y = iMin;
            } else {
                int iMin2 = iMin - i3;
                int i5 = this.m;
                if (i5 != -1) {
                    iMin2 = Math.min(iMin2, i5);
                }
                this.Y = iMin2;
            }
        }
        this.J = Math.max(0, this.a0 - this.Y);
        f0();
        d0();
        int i6 = this.R;
        if (i6 == 3) {
            be3.a0(view, s0());
        } else if (i6 == 6) {
            be3.a0(view, this.K);
        } else if (this.O && i6 == 5) {
            be3.a0(view, this.a0);
        } else if (i6 == 4) {
            be3.a0(view, this.M);
        } else if (i6 == 1 || i6 == 2) {
            be3.a0(view, top - view.getTop());
        }
        j1(this.R, false);
        this.d0 = new WeakReference(p0(view));
        for (int i7 = 0; i7 < this.e0.size(); i7++) {
            ((g) this.e0.get(i7)).a(view);
        }
        return true;
    }

    View p0(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (be3.U(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View viewP0 = p0(viewGroup.getChildAt(i));
                if (viewP0 != null) {
                    return viewP0;
                }
            }
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean q(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(r0(i, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, this.l, marginLayoutParams.width), r0(i3, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, this.m, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean s(CoordinatorLayout coordinatorLayout, View view, View view2, float f2, float f3) {
        WeakReference weakReference;
        if (E0() && (weakReference = this.d0) != null && view2 == weakReference.get()) {
            return this.R != 3 || super.s(coordinatorLayout, view, view2, f2, f3);
        }
        return false;
    }

    public int s0() {
        if (this.b) {
            return this.J;
        }
        return Math.max(this.I, this.s ? 0 : this.x);
    }

    tg1 t0() {
        return this.j;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void u(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        WeakReference weakReference = this.d0;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if (!E0() || view2 == view3) {
            int top = view.getTop();
            int i4 = top - i2;
            if (i2 > 0) {
                if (i4 < s0()) {
                    int iS0 = top - s0();
                    iArr[1] = iS0;
                    be3.a0(view, -iS0);
                    Z0(3);
                } else {
                    if (!this.Q) {
                        return;
                    }
                    iArr[1] = i2;
                    be3.a0(view, -i2);
                    Z0(1);
                }
            } else if (i2 < 0 && !view2.canScrollVertically(-1)) {
                if (i4 > this.M && !j0()) {
                    int i5 = top - this.M;
                    iArr[1] = i5;
                    be3.a0(view, -i5);
                    Z0(4);
                } else {
                    if (!this.Q) {
                        return;
                    }
                    iArr[1] = i2;
                    be3.a0(view, -i2);
                    Z0(1);
                }
            }
            o0(view.getTop());
            this.V = i2;
            this.W = true;
        }
    }

    public int u0() {
        return this.R;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    public boolean z0() {
        return this.b;
    }

    private class h {
        private int a;
        private boolean b;
        private final Runnable c;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.b = false;
                fe3 fe3Var = BottomSheetBehavior.this.T;
                if (fe3Var != null && fe3Var.n(true)) {
                    h hVar = h.this;
                    hVar.c(hVar.a);
                    return;
                }
                h hVar2 = h.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.R == 2) {
                    bottomSheetBehavior.Z0(hVar2.a);
                }
            }
        }

        private h() {
            this.c = new a();
        }

        void c(int i) {
            WeakReference weakReference = BottomSheetBehavior.this.b0;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.a = i;
            if (this.b) {
                return;
            }
            be3.h0((View) BottomSheetBehavior.this.b0.get(), this.c);
            this.b = true;
        }

        /* synthetic */ h(BottomSheetBehavior bottomSheetBehavior, a aVar) {
            this();
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        final int a;
        int b;
        boolean c;
        boolean d;
        boolean e;

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
            this.b = parcel.readInt();
            this.c = parcel.readInt() == 1;
            this.d = parcel.readInt() == 1;
            this.e = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
            parcel.writeInt(this.d ? 1 : 0);
            parcel.writeInt(this.e ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior bottomSheetBehavior) {
            super(parcelable);
            this.a = bottomSheetBehavior.R;
            this.b = bottomSheetBehavior.f;
            this.c = bottomSheetBehavior.b;
            this.d = bottomSheetBehavior.O;
            this.e = bottomSheetBehavior.P;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        this.a = 0;
        this.b = true;
        this.c = false;
        this.l = -1;
        this.m = -1;
        this.G = new h(this, null);
        this.L = 0.5f;
        this.N = -1.0f;
        this.Q = true;
        this.R = 4;
        this.S = 4;
        this.X = 0.1f;
        this.e0 = new ArrayList();
        this.i0 = -1;
        this.l0 = new SparseIntArray();
        this.m0 = new e();
        this.i = context.getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        int i2 = R$styleable.BottomSheetBehavior_Layout_backgroundTint;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            this.k = sg1.a(context, typedArrayObtainStyledAttributes, i2);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.z = sn2.e(context, attributeSet, R$attr.bottomSheetStyle, n0).m();
        }
        m0(context);
        n0();
        this.N = typedArrayObtainStyledAttributes.getDimension(R$styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i3 = R$styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            S0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i3, -1));
        }
        int i4 = R$styleable.BottomSheetBehavior_Layout_android_maxHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            R0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i4, -1));
        }
        int i5 = R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(i5);
        if (typedValuePeekValue != null && (i = typedValuePeekValue.data) == -1) {
            T0(i);
        } else {
            T0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i5, -1));
        }
        Q0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        O0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        N0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        X0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        L0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        V0(typedArrayObtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        P0(typedArrayObtainStyledAttributes.getFloat(R$styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i6 = R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(i6);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            M0(typedValuePeekValue2.data);
        } else {
            M0(typedArrayObtainStyledAttributes.getDimensionPixelOffset(i6, 0));
        }
        W0(typedArrayObtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500));
        this.p = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.f248q = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.r = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.s = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.t = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.u = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.v = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        this.y = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
        typedArrayObtainStyledAttributes.recycle();
        this.d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
