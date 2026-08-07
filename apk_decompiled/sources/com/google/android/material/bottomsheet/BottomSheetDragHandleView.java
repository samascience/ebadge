package com.google.android.material.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import defpackage.be3;
import defpackage.m2;
import defpackage.p2;
import defpackage.t1;
import defpackage.yg1;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {
    private static final int m = R$style.Widget_Material3_BottomSheet_DragHandle;
    private final AccessibilityManager d;
    private BottomSheetBehavior e;
    private boolean f;
    private boolean g;
    private boolean h;
    private final String i;
    private final String j;
    private final String k;
    private final BottomSheetBehavior.g l;

    class a extends BottomSheetBehavior.g {
        a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(View view, float f) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void c(View view, int i) {
            BottomSheetDragHandleView.this.k(i);
        }
    }

    class b extends t1 {
        b() {
        }

        @Override // defpackage.t1
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            if (accessibilityEvent.getEventType() == 1) {
                BottomSheetDragHandleView.this.g();
            }
        }
    }

    public BottomSheetDragHandleView(Context context) {
        this(context, null);
    }

    private void f(String str) {
        if (this.d == null) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(16384);
        accessibilityEventObtain.getText().add(str);
        this.d.sendAccessibilityEvent(accessibilityEventObtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        boolean z = false;
        if (!this.g) {
            return false;
        }
        f(this.k);
        if (!this.e.z0() && !this.e.e1()) {
            z = true;
        }
        int iU0 = this.e.u0();
        int i = 6;
        int i2 = 3;
        if (iU0 == 4) {
            if (!z) {
                i = i2;
            }
        } else if (iU0 != 3) {
            if (!this.h) {
                i2 = 4;
            }
            i = i2;
        } else if (!z) {
            i = 4;
        }
        this.e.Y0(i);
        return true;
    }

    private BottomSheetBehavior h() {
        View viewI = this;
        while (true) {
            viewI = i(viewI);
            if (viewI == null) {
                return null;
            }
            ViewGroup.LayoutParams layoutParams = viewI.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) layoutParams).f();
                if (cVarF instanceof BottomSheetBehavior) {
                    return (BottomSheetBehavior) cVarF;
                }
            }
        }
    }

    private static View i(View view) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean j(View view, p2.a aVar) {
        return g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i) {
        if (i == 4) {
            this.h = true;
        } else if (i == 3) {
            this.h = false;
        }
        be3.l0(this, m2.a.i, this.h ? this.i : this.j, new p2() { // from class: gn
            @Override // defpackage.p2
            public final boolean a(View view, p2.a aVar) {
                return this.a.j(view, aVar);
            }
        });
    }

    private void l() {
        this.g = this.f && this.e != null;
        be3.z0(this, this.e == null ? 2 : 1);
        setClickable(this.g);
    }

    private void setBottomSheetBehavior(BottomSheetBehavior<?> bottomSheetBehavior) {
        BottomSheetBehavior bottomSheetBehavior2 = this.e;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.F0(this.l);
            this.e.K0(null);
        }
        this.e = bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.K0(this);
            k(this.e.u0());
            this.e.c0(this.l);
        }
        l();
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean z) {
        this.f = z;
        l();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBottomSheetBehavior(h());
        AccessibilityManager accessibilityManager = this.d;
        if (accessibilityManager != null) {
            accessibilityManager.addAccessibilityStateChangeListener(this);
            onAccessibilityStateChanged(this.d.isEnabled());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        AccessibilityManager accessibilityManager = this.d;
        if (accessibilityManager != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(this);
        }
        setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }

    public BottomSheetDragHandleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomSheetDragHandleStyle);
    }

    public BottomSheetDragHandleView(Context context, AttributeSet attributeSet, int i) {
        super(yg1.c(context, attributeSet, i, m), attributeSet, i);
        this.i = getResources().getString(R$string.bottomsheet_action_expand);
        this.j = getResources().getString(R$string.bottomsheet_action_collapse);
        this.k = getResources().getString(R$string.bottomsheet_drag_handle_clicked);
        this.l = new a();
        this.d = (AccessibilityManager) getContext().getSystemService("accessibility");
        l();
        be3.p0(this, new b());
    }
}
