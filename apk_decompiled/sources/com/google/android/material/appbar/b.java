package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.be3;
import defpackage.eh1;
import defpackage.iv0;
import defpackage.zi3;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class b extends c {
    final Rect d;
    final Rect e;
    private int f;
    private int g;

    public b() {
        this.d = new Rect();
        this.e = new Rect();
        this.f = 0;
    }

    private static int R(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    @Override // com.google.android.material.appbar.c
    protected void J(CoordinatorLayout coordinatorLayout, View view, int i) {
        View viewL = L(coordinatorLayout.v(view));
        if (viewL == null) {
            super.J(coordinatorLayout, view, i);
            this.f = 0;
            return;
        }
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
        Rect rect = this.d;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, viewL.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + viewL.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        zi3 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && be3.x(coordinatorLayout) && !be3.x(view)) {
            rect.left += lastWindowInsets.j();
            rect.right -= lastWindowInsets.k();
        }
        Rect rect2 = this.e;
        iv0.a(R(fVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        int iM = M(viewL);
        view.layout(rect2.left, rect2.top - iM, rect2.right, rect2.bottom - iM);
        this.f = rect2.top - viewL.getBottom();
    }

    abstract View L(List list);

    final int M(View view) {
        if (this.g == 0) {
            return 0;
        }
        float fN = N(view);
        int i = this.g;
        return eh1.b((int) (fN * i), 0, i);
    }

    abstract float N(View view);

    public final int O() {
        return this.g;
    }

    int P(View view) {
        return view.getMeasuredHeight();
    }

    final int Q() {
        return this.f;
    }

    public final void S(int i) {
        this.g = i;
    }

    protected boolean T() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean q(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View viewL;
        zi3 lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (viewL = L(coordinatorLayout.v(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (be3.x(viewL) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.l() + lastWindowInsets.i();
        }
        int iP = size + P(viewL);
        int measuredHeight = viewL.getMeasuredHeight();
        if (T()) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(0.0f);
            iP -= measuredHeight;
        }
        coordinatorLayout.N(view, i, i2, View.MeasureSpec.makeMeasureSpec(iP, i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new Rect();
        this.e = new Rect();
        this.f = 0;
    }
}
