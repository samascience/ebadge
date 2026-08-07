package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.R$attr;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import defpackage.be3;
import defpackage.el1;
import defpackage.m2;
import defpackage.v1;
import defpackage.y6;

/* JADX INFO: loaded from: classes3.dex */
class p extends s {
    private static final boolean s = true;
    private final int e;
    private final int f;
    private final TimeInterpolator g;
    private AutoCompleteTextView h;
    private final View.OnClickListener i;
    private final View.OnFocusChangeListener j;
    private final v1.a k;
    private boolean l;
    private boolean m;
    private boolean n;
    private long o;
    private AccessibilityManager p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ValueAnimator f272q;
    private ValueAnimator r;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            p.this.r();
            p.this.r.start();
        }
    }

    p(r rVar) {
        super(rVar);
        this.i = new View.OnClickListener() { // from class: com.google.android.material.textfield.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.J(view);
            }
        };
        this.j = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.m
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.a.K(view, z);
            }
        };
        this.k = new v1.a() { // from class: com.google.android.material.textfield.n
            @Override // v1.a
            public final void onTouchExplorationStateChanged(boolean z) {
                this.a.L(z);
            }
        };
        this.o = Long.MAX_VALUE;
        Context context = rVar.getContext();
        int i = R$attr.motionDurationShort3;
        this.f = el1.f(context, i, 67);
        this.e = el1.f(rVar.getContext(), i, 50);
        this.g = el1.g(rVar.getContext(), R$attr.motionEasingLinearInterpolator, y6.a);
    }

    private static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator E(int i, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.g);
        valueAnimatorOfFloat.setDuration(i);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.I(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private void F() {
        this.r = E(this.f, 0.0f, 1.0f);
        ValueAnimator valueAnimatorE = E(this.e, 1.0f, 0.0f);
        this.f272q = valueAnimatorE;
        valueAnimatorE.addListener(new a());
    }

    private boolean G() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.o;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        boolean zIsPopupShowing = this.h.isPopupShowing();
        O(zIsPopupShowing);
        this.m = zIsPopupShowing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(ValueAnimator valueAnimator) {
        this.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view, boolean z) {
        this.l = z;
        r();
        if (z) {
            return;
        }
        O(false);
        this.m = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(boolean z) {
        AutoCompleteTextView autoCompleteTextView = this.h;
        if (autoCompleteTextView == null || q.a(autoCompleteTextView)) {
            return;
        }
        be3.z0(this.d, z ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean M(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (G()) {
                this.m = false;
            }
            Q();
            R();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        R();
        O(false);
    }

    private void O(boolean z) {
        if (this.n != z) {
            this.n = z;
            this.r.cancel();
            this.f272q.start();
        }
    }

    private void P() {
        this.h.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.j
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.a.M(view, motionEvent);
            }
        });
        if (s) {
            this.h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.k
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public final void onDismiss() {
                    this.a.N();
                }
            });
        }
        this.h.setThreshold(0);
    }

    private void Q() {
        if (this.h == null) {
            return;
        }
        if (G()) {
            this.m = false;
        }
        if (this.m) {
            this.m = false;
            return;
        }
        if (s) {
            O(!this.n);
        } else {
            this.n = !this.n;
            r();
        }
        if (!this.n) {
            this.h.dismissDropDown();
        } else {
            this.h.requestFocus();
            this.h.showDropDown();
        }
    }

    private void R() {
        this.m = true;
        this.o = System.currentTimeMillis();
    }

    @Override // com.google.android.material.textfield.s
    public void a(Editable editable) {
        if (this.p.isTouchExplorationEnabled() && q.a(this.h) && !this.d.hasFocus()) {
            this.h.dismissDropDown();
        }
        this.h.post(new Runnable() { // from class: com.google.android.material.textfield.o
            @Override // java.lang.Runnable
            public final void run() {
                this.a.H();
            }
        });
    }

    @Override // com.google.android.material.textfield.s
    int c() {
        return R$string.exposed_dropdown_menu_content_description;
    }

    @Override // com.google.android.material.textfield.s
    int d() {
        return s ? R$drawable.mtrl_dropdown_arrow : R$drawable.mtrl_ic_arrow_drop_down;
    }

    @Override // com.google.android.material.textfield.s
    View.OnFocusChangeListener e() {
        return this.j;
    }

    @Override // com.google.android.material.textfield.s
    View.OnClickListener f() {
        return this.i;
    }

    @Override // com.google.android.material.textfield.s
    public v1.a h() {
        return this.k;
    }

    @Override // com.google.android.material.textfield.s
    boolean i(int i) {
        return i != 0;
    }

    @Override // com.google.android.material.textfield.s
    boolean j() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    boolean k() {
        return this.l;
    }

    @Override // com.google.android.material.textfield.s
    boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    boolean m() {
        return this.n;
    }

    @Override // com.google.android.material.textfield.s
    public void n(EditText editText) {
        this.h = D(editText);
        P();
        this.a.setErrorIconDrawable((Drawable) null);
        if (!q.a(editText) && this.p.isTouchExplorationEnabled()) {
            be3.z0(this.d, 2);
        }
        this.a.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.s
    public void o(View view, m2 m2Var) {
        if (!q.a(this.h)) {
            m2Var.j0(Spinner.class.getName());
        }
        if (m2Var.T()) {
            m2Var.u0(null);
        }
    }

    @Override // com.google.android.material.textfield.s
    public void p(View view, AccessibilityEvent accessibilityEvent) {
        if (!this.p.isEnabled() || q.a(this.h)) {
            return;
        }
        boolean z = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.n && !this.h.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z) {
            Q();
            R();
        }
    }

    @Override // com.google.android.material.textfield.s
    void s() {
        F();
        this.p = (AccessibilityManager) this.c.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.s
    boolean t() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    void u() {
        AutoCompleteTextView autoCompleteTextView = this.h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            if (s) {
                this.h.setOnDismissListener(null);
            }
        }
    }
}
