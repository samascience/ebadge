package com.google.android.material.bottomsheet;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import defpackage.be3;
import defpackage.df0;
import defpackage.jg1;
import defpackage.li3;
import defpackage.m2;
import defpackage.mu1;
import defpackage.nf3;
import defpackage.og1;
import defpackage.t1;
import defpackage.tg1;
import defpackage.u8;
import defpackage.zi3;
import lombok.eclipse.Eclipse;

/* JADX INFO: loaded from: classes3.dex */
public class a extends u8 {
    private BottomSheetBehavior f;
    private FrameLayout g;
    private CoordinatorLayout h;
    private FrameLayout i;
    boolean j;
    boolean k;
    private boolean l;
    private boolean m;
    private f n;
    private boolean o;
    private jg1 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BottomSheetBehavior.g f249q;

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.a$a, reason: collision with other inner class name */
    class C0085a implements mu1 {
        C0085a() {
        }

        @Override // defpackage.mu1
        public zi3 a(View view, zi3 zi3Var) {
            if (a.this.n != null) {
                a.this.f.F0(a.this.n);
            }
            if (zi3Var != null) {
                a aVar = a.this;
                aVar.n = new f(aVar.i, zi3Var, null);
                a.this.n.e(a.this.getWindow());
                a.this.f.c0(a.this.n);
            }
            return zi3Var;
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.k && aVar.isShowing() && a.this.p()) {
                a.this.cancel();
            }
        }
    }

    class c extends t1 {
        c() {
        }

        @Override // defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            super.onInitializeAccessibilityNodeInfo(view, m2Var);
            if (!a.this.k) {
                m2Var.o0(false);
            } else {
                m2Var.a(Eclipse.HasTypeAnnotations);
                m2Var.o0(true);
            }
        }

        @Override // defpackage.t1
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (i == 1048576) {
                a aVar = a.this;
                if (aVar.k) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i, bundle);
        }
    }

    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    class e extends BottomSheetBehavior.g {
        e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(View view, float f) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void c(View view, int i) {
            if (i == 5) {
                a.this.cancel();
            }
        }
    }

    private static class f extends BottomSheetBehavior.g {
        private final Boolean a;
        private final zi3 b;
        private Window c;
        private boolean d;

        /* synthetic */ f(View view, zi3 zi3Var, C0085a c0085a) {
            this(view, zi3Var);
        }

        private void d(View view) {
            if (view.getTop() < this.b.l()) {
                Window window = this.c;
                if (window != null) {
                    Boolean bool = this.a;
                    df0.f(window, bool == null ? this.d : bool.booleanValue());
                }
                view.setPadding(view.getPaddingLeft(), this.b.l() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
                return;
            }
            if (view.getTop() != 0) {
                Window window2 = this.c;
                if (window2 != null) {
                    df0.f(window2, this.d);
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        void a(View view) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(View view, float f) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void c(View view, int i) {
            d(view);
        }

        void e(Window window) {
            if (this.c == window) {
                return;
            }
            this.c = window;
            if (window != null) {
                this.d = li3.a(window, window.getDecorView()).b();
            }
        }

        private f(View view, zi3 zi3Var) {
            this.b = zi3Var;
            tg1 tg1VarT0 = BottomSheetBehavior.q0(view).t0();
            ColorStateList colorStateListX = tg1VarT0 != null ? tg1VarT0.x() : be3.s(view);
            if (colorStateListX != null) {
                this.a = Boolean.valueOf(og1.h(colorStateListX.getDefaultColor()));
                return;
            }
            Integer numH = nf3.h(view);
            if (numH != null) {
                this.a = Boolean.valueOf(og1.h(numH.intValue()));
            } else {
                this.a = null;
            }
        }
    }

    public a(Context context, int i) {
        super(context, f(context, i));
        this.k = true;
        this.l = true;
        this.f249q = new e();
        i(1);
        this.o = getContext().getTheme().obtainStyledAttributes(new int[]{R$attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    private static int f(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R$attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R$style.Theme_Design_Light_BottomSheetDialog;
    }

    private FrameLayout n() {
        if (this.g == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R$layout.design_bottom_sheet_dialog, null);
            this.g = frameLayout;
            this.h = (CoordinatorLayout) frameLayout.findViewById(R$id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.g.findViewById(R$id.design_bottom_sheet);
            this.i = frameLayout2;
            BottomSheetBehavior bottomSheetBehaviorQ0 = BottomSheetBehavior.q0(frameLayout2);
            this.f = bottomSheetBehaviorQ0;
            bottomSheetBehaviorQ0.c0(this.f249q);
            this.f.Q0(this.k);
            this.p = new jg1(this.f, this.i);
        }
        return this.g;
    }

    private void q() {
        jg1 jg1Var = this.p;
        if (jg1Var == null) {
            return;
        }
        if (this.k) {
            jg1Var.c();
        } else {
            jg1Var.f();
        }
    }

    private View r(int i, View view, ViewGroup.LayoutParams layoutParams) {
        n();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.g.findViewById(R$id.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (ViewGroup) coordinatorLayout, false);
        }
        if (this.o) {
            be3.E0(this.i, new C0085a());
        }
        this.i.removeAllViews();
        if (layoutParams == null) {
            this.i.addView(view);
        } else {
            this.i.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R$id.touch_outside).setOnClickListener(new b());
        be3.p0(this.i, new c());
        this.i.setOnTouchListener(new d());
        return this.g;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior bottomSheetBehaviorO = o();
        if (!this.j || bottomSheetBehaviorO.u0() == 5) {
            super.cancel();
        } else {
            bottomSheetBehaviorO.Y0(5);
        }
    }

    public BottomSheetBehavior o() {
        if (this.f == null) {
            n();
        }
        return this.f;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z = this.o && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.g;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z);
            }
            CoordinatorLayout coordinatorLayout = this.h;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z);
            }
            li3.b(window, !z);
            f fVar = this.n;
            if (fVar != null) {
                fVar.e(window);
            }
        }
        q();
    }

    @Override // defpackage.u8, defpackage.e10, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        f fVar = this.n;
        if (fVar != null) {
            fVar.e(null);
        }
        jg1 jg1Var = this.p;
        if (jg1Var != null) {
            jg1Var.f();
        }
    }

    @Override // defpackage.e10, android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior bottomSheetBehavior = this.f;
        if (bottomSheetBehavior == null || bottomSheetBehavior.u0() != 5) {
            return;
        }
        this.f.Y0(4);
    }

    boolean p() {
        if (!this.m) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            this.l = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.m = true;
        }
        return this.l;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.k != z) {
            this.k = z;
            BottomSheetBehavior bottomSheetBehavior = this.f;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.Q0(z);
            }
            if (getWindow() != null) {
                q();
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.k) {
            this.k = true;
        }
        this.l = z;
        this.m = true;
    }

    @Override // defpackage.u8, defpackage.e10, android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(r(i, null, null));
    }

    @Override // defpackage.u8, defpackage.e10, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(r(0, view, null));
    }

    @Override // defpackage.u8, defpackage.e10, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(r(0, view, layoutParams));
    }
}
