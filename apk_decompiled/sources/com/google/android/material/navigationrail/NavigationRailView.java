package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.e0;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.navigation.NavigationBarView;
import defpackage.be3;
import defpackage.nf3;
import defpackage.o23;
import defpackage.sg1;
import defpackage.y6;
import defpackage.z21;
import defpackage.zi3;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationRailView extends NavigationBarView {
    private final int a;
    private View b;
    private Boolean c;
    private Boolean d;
    private Boolean e;

    class a implements nf3.d {
        a() {
        }

        @Override // nf3.d
        public zi3 a(View view, zi3 zi3Var, nf3.e eVar) {
            z21 z21VarF = zi3Var.f(zi3.l.d());
            NavigationRailView navigationRailView = NavigationRailView.this;
            if (navigationRailView.k(navigationRailView.c)) {
                eVar.b += z21VarF.b;
            }
            NavigationRailView navigationRailView2 = NavigationRailView.this;
            if (navigationRailView2.k(navigationRailView2.d)) {
                eVar.d += z21VarF.d;
            }
            NavigationRailView navigationRailView3 = NavigationRailView.this;
            if (navigationRailView3.k(navigationRailView3.e)) {
                eVar.a += nf3.o(view) ? z21VarF.c : z21VarF.a;
            }
            eVar.a(view);
            return zi3Var;
        }
    }

    public NavigationRailView(Context context) {
        this(context, null);
    }

    private void applyWindowInsets() {
        nf3.e(this, new a());
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private boolean h() {
        View view = this.b;
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    private int i(int i) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(Boolean bool) {
        return bool != null ? bool.booleanValue() : be3.x(this);
    }

    public void e(int i) {
        f(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this, false));
    }

    public void f(View view) {
        j();
        this.b = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.a;
        addView(view, 0, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.navigation.NavigationBarView
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public NavigationRailMenuView createNavigationBarMenuView(Context context) {
        return new NavigationRailMenuView(context);
    }

    public View getHeaderView() {
        return this.b;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) getMenuView()).getItemMinimumHeight();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public void j() {
        View view = this.b;
        if (view != null) {
            removeView(view);
            this.b = null;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        int i5 = 0;
        if (h()) {
            int bottom = this.b.getBottom() + this.a;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i5 = bottom - top;
            }
        } else if (navigationRailMenuView.e()) {
            i5 = this.a;
        }
        if (i5 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i5, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i5);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i(i);
        super.onMeasure(i3, i2);
        if (h()) {
            measureChild(getNavigationRailMenuView(), i3, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.b.getMeasuredHeight()) - this.a, Integer.MIN_VALUE));
        }
    }

    public void setItemMinimumHeight(int i) {
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i);
    }

    public void setMenuGravity(int i) {
        getNavigationRailMenuView().setMenuGravity(i);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.navigationRailStyle);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, R$style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = getResources().getDimensionPixelSize(R$dimen.mtrl_navigation_rail_margin);
        Context context2 = getContext();
        e0 e0VarJ = o23.j(context2, attributeSet, R$styleable.NavigationRailView, i, i2, new int[0]);
        int iN = e0VarJ.n(R$styleable.NavigationRailView_headerLayout, 0);
        if (iN != 0) {
            e(iN);
        }
        setMenuGravity(e0VarJ.k(R$styleable.NavigationRailView_menuGravity, 49));
        int i3 = R$styleable.NavigationRailView_itemMinHeight;
        if (e0VarJ.s(i3)) {
            setItemMinimumHeight(e0VarJ.f(i3, -1));
        }
        int i4 = R$styleable.NavigationRailView_paddingTopSystemWindowInsets;
        if (e0VarJ.s(i4)) {
            this.c = Boolean.valueOf(e0VarJ.a(i4, false));
        }
        int i5 = R$styleable.NavigationRailView_paddingBottomSystemWindowInsets;
        if (e0VarJ.s(i5)) {
            this.d = Boolean.valueOf(e0VarJ.a(i5, false));
        }
        int i6 = R$styleable.NavigationRailView_paddingStartSystemWindowInsets;
        if (e0VarJ.s(i6)) {
            this.e = Boolean.valueOf(e0VarJ.a(i6, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.m3_navigation_rail_item_padding_top_with_large_font);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R$dimen.m3_navigation_rail_item_padding_bottom_with_large_font);
        float fB = y6.b(0.0f, 1.0f, 0.3f, 1.0f, sg1.f(context2) - 1.0f);
        float fC = y6.c(getItemPaddingTop(), dimensionPixelOffset, fB);
        float fC2 = y6.c(getItemPaddingBottom(), dimensionPixelOffset2, fB);
        setItemPaddingTop(Math.round(fC));
        setItemPaddingBottom(Math.round(fC2));
        e0VarJ.x();
        applyWindowInsets();
    }
}
