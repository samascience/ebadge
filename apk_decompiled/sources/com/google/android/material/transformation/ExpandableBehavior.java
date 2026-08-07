package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.be3;
import defpackage.ij0;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.c {
    private int a;

    class a implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View a;
        final /* synthetic */ int b;
        final /* synthetic */ ij0 c;

        a(View view, int i, ij0 ij0Var) {
            this.a = view;
            this.b = i;
            this.c = ij0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.a == this.b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                ij0 ij0Var = this.c;
                expandableBehavior.L((View) ij0Var, this.a, ij0Var.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.a = 0;
    }

    private boolean J(boolean z) {
        if (!z) {
            return this.a == 1;
        }
        int i = this.a;
        return i == 0 || i == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected ij0 K(CoordinatorLayout coordinatorLayout, View view) {
        List listV = coordinatorLayout.v(view);
        int size = listV.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) listV.get(i);
            if (i(coordinatorLayout, view, view2)) {
                return (ij0) view2;
            }
        }
        return null;
    }

    protected abstract boolean L(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public abstract boolean i(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, View view2) {
        ij0 ij0Var = (ij0) view2;
        if (!J(ij0Var.a())) {
            return false;
        }
        this.a = ij0Var.a() ? 1 : 2;
        return L((View) ij0Var, view, ij0Var.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean p(CoordinatorLayout coordinatorLayout, View view, int i) {
        ij0 ij0VarK;
        if (be3.T(view) || (ij0VarK = K(coordinatorLayout, view)) == null || !J(ij0VarK.a())) {
            return false;
        }
        int i2 = ij0VarK.a() ? 1 : 2;
        this.a = i2;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i2, ij0VarK));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
    }
}
