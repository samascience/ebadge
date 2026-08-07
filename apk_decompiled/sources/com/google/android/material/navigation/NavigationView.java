package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.e0;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import defpackage.be3;
import defpackage.ck3;
import defpackage.he;
import defpackage.ig1;
import defpackage.io2;
import defpackage.iv0;
import defpackage.jg1;
import defpackage.mw2;
import defpackage.nn1;
import defpackage.nv;
import defpackage.o23;
import defpackage.q30;
import defpackage.qd0;
import defpackage.sg1;
import defpackage.sn2;
import defpackage.tg1;
import defpackage.u30;
import defpackage.ug1;
import defpackage.v8;
import defpackage.vd0;
import defpackage.vg1;
import defpackage.y6;
import defpackage.yg1;
import defpackage.zh2;
import defpackage.zi3;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationView extends ScrimInsetsFrameLayout implements ig1 {
    private static final int[] w = {R.attr.state_checked};
    private static final int[] x = {-16842910};
    private static final int y = R$style.Widget_Design_NavigationView;
    private final nn1 h;
    private final com.google.android.material.internal.b i;
    private final int j;
    private final int[] k;
    private MenuInflater l;
    private ViewTreeObserver.OnGlobalLayoutListener m;
    private boolean n;
    private boolean o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f264q;
    private final int r;
    private final io2 s;
    private final vg1 t;
    private final jg1 u;
    private final DrawerLayout.e v;

    class a extends DrawerLayout.g {
        a() {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void a(View view) {
            NavigationView navigationView = NavigationView.this;
            if (view == navigationView) {
                final jg1 jg1Var = navigationView.u;
                Objects.requireNonNull(jg1Var);
                view.post(new Runnable() { // from class: qn1
                    @Override // java.lang.Runnable
                    public final void run() {
                        jg1Var.e();
                    }
                });
            }
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void b(View view) {
            NavigationView navigationView = NavigationView.this;
            if (view == navigationView) {
                navigationView.u.f();
                NavigationView.this.t();
            }
        }
    }

    class b implements e.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(e eVar, MenuItem menuItem) {
            NavigationView.this.getClass();
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(e eVar) {
        }
    }

    class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.k);
            boolean z = true;
            boolean z2 = NavigationView.this.k[1] == 0;
            NavigationView.this.i.D(z2);
            NavigationView navigationView2 = NavigationView.this;
            navigationView2.setDrawTopInsetForeground(z2 && navigationView2.r());
            NavigationView.this.setDrawLeftInsetForeground(NavigationView.this.k[0] == 0 || NavigationView.this.k[0] + NavigationView.this.getWidth() == 0);
            Activity activityA = u30.a(NavigationView.this.getContext());
            if (activityA != null) {
                Rect rectA = ck3.a(activityA);
                boolean z3 = rectA.height() - NavigationView.this.getHeight() == NavigationView.this.k[1];
                boolean z4 = Color.alpha(activityA.getWindow().getNavigationBarColor()) != 0;
                NavigationView navigationView3 = NavigationView.this;
                navigationView3.setDrawBottomInsetForeground(z3 && z4 && navigationView3.q());
                if (rectA.width() != NavigationView.this.k[0] && rectA.width() - NavigationView.this.getWidth() != NavigationView.this.k[0]) {
                    z = false;
                }
                NavigationView.this.setDrawRightInsetForeground(z);
            }
        }
    }

    public interface d {
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        if (this.l == null) {
            this.l = new mw2(getContext());
        }
        return this.l;
    }

    private ColorStateList k(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListA = v8.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateListA.getDefaultColor();
        int[] iArr = x;
        return new ColorStateList(new int[][]{iArr, w, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListA.getColorForState(iArr, defaultColor), i2, defaultColor});
    }

    private Drawable l(e0 e0Var) {
        return m(e0Var, sg1.b(getContext(), e0Var, R$styleable.NavigationView_itemShapeFillColor));
    }

    private Drawable m(e0 e0Var, ColorStateList colorStateList) {
        tg1 tg1Var = new tg1(sn2.b(getContext(), e0Var.n(R$styleable.NavigationView_itemShapeAppearance, 0), e0Var.n(R$styleable.NavigationView_itemShapeAppearanceOverlay, 0)).m());
        tg1Var.b0(colorStateList);
        return new InsetDrawable((Drawable) tg1Var, e0Var.f(R$styleable.NavigationView_itemShapeInsetStart, 0), e0Var.f(R$styleable.NavigationView_itemShapeInsetTop, 0), e0Var.f(R$styleable.NavigationView_itemShapeInsetEnd, 0), e0Var.f(R$styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private boolean n(e0 e0Var) {
        return e0Var.s(R$styleable.NavigationView_itemShapeAppearance) || e0Var.s(R$styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (!this.f264q || this.p == 0) {
            return;
        }
        this.p = 0;
        u(getWidth(), getHeight());
    }

    private void u(int i, int i2) {
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof DrawerLayout.f)) {
            if ((this.p > 0 || this.f264q) && (getBackground() instanceof tg1)) {
                boolean z = iv0.b(((DrawerLayout.f) getLayoutParams()).a, be3.A(this)) == 3;
                tg1 tg1Var = (tg1) getBackground();
                sn2.b bVarO = tg1Var.E().v().o(this.p);
                if (z) {
                    bVarO.E(0.0f);
                    bVarO.v(0.0f);
                } else {
                    bVarO.I(0.0f);
                    bVarO.z(0.0f);
                }
                sn2 sn2VarM = bVarO.m();
                tg1Var.setShapeAppearanceModel(sn2VarM);
                this.s.g(this, sn2VarM);
                this.s.f(this, new RectF(0.0f, 0.0f, i, i2));
                this.s.i(this, true);
            }
        }
    }

    private Pair v() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof DrawerLayout.f)) {
            return new Pair((DrawerLayout) parent, (DrawerLayout.f) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    private void w() {
        this.m = new c();
        getViewTreeObserver().addOnGlobalLayoutListener(this.m);
    }

    @Override // defpackage.ig1
    public void a() {
        Pair pairV = v();
        DrawerLayout drawerLayout = (DrawerLayout) pairV.first;
        he heVarC = this.t.c();
        if (heVarC == null || Build.VERSION.SDK_INT < 34) {
            drawerLayout.f(this);
            return;
        }
        this.t.h(heVarC, ((DrawerLayout.f) pairV.second).a, vd0.b(drawerLayout, this), vd0.c(drawerLayout));
    }

    @Override // defpackage.ig1
    public void b(he heVar) {
        this.t.l(heVar, ((DrawerLayout.f) v().second).a);
        if (this.f264q) {
            this.p = y6.c(0, this.r, this.t.a(heVar.a()));
            u(getWidth(), getHeight());
        }
    }

    @Override // defpackage.ig1
    public void c(he heVar) {
        v();
        this.t.j(heVar);
    }

    @Override // defpackage.ig1
    public void d() {
        v();
        this.t.f();
        t();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.s.e(canvas, new nv.a() { // from class: pn1
            @Override // nv.a
            public final void a(Canvas canvas2) {
                this.a.s(canvas2);
            }
        });
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    protected void e(zi3 zi3Var) {
        this.i.k(zi3Var);
    }

    vg1 getBackHelper() {
        return this.t;
    }

    public MenuItem getCheckedItem() {
        return this.i.n();
    }

    public int getDividerInsetEnd() {
        return this.i.o();
    }

    public int getDividerInsetStart() {
        return this.i.p();
    }

    public int getHeaderCount() {
        return this.i.q();
    }

    public Drawable getItemBackground() {
        return this.i.r();
    }

    public int getItemHorizontalPadding() {
        return this.i.s();
    }

    public int getItemIconPadding() {
        return this.i.t();
    }

    public ColorStateList getItemIconTintList() {
        return this.i.w();
    }

    public int getItemMaxLines() {
        return this.i.u();
    }

    public ColorStateList getItemTextColor() {
        return this.i.v();
    }

    public int getItemVerticalPadding() {
        return this.i.x();
    }

    public Menu getMenu() {
        return this.h;
    }

    public int getSubheaderInsetEnd() {
        return this.i.z();
    }

    public int getSubheaderInsetStart() {
        return this.i.A();
    }

    public View o(int i) {
        return this.i.C(i);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ug1.e(this);
        ViewParent parent = getParent();
        if ((parent instanceof DrawerLayout) && this.u.b()) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            drawerLayout.N(this.v);
            drawerLayout.a(this.v);
            if (drawerLayout.D(this)) {
                this.u.e();
            }
        }
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.m);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            ((DrawerLayout) parent).N(this.v);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.j), 1073741824);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(this.j, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.h.T(savedState.a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.a = bundle;
        this.h.V(bundle);
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        u(i, i2);
    }

    public void p(int i) {
        this.i.Y(true);
        getMenuInflater().inflate(i, this.h);
        this.i.Y(false);
        this.i.d(false);
    }

    public boolean q() {
        return this.o;
    }

    public boolean r() {
        return this.n;
    }

    public void setBottomInsetScrimEnabled(boolean z) {
        this.o = z;
    }

    public void setCheckedItem(int i) {
        MenuItem menuItemFindItem = this.h.findItem(i);
        if (menuItemFindItem != null) {
            this.i.E((g) menuItemFindItem);
        }
    }

    public void setDividerInsetEnd(int i) {
        this.i.F(i);
    }

    public void setDividerInsetStart(int i) {
        this.i.G(i);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        ug1.d(this, f);
    }

    public void setForceCompatClippingEnabled(boolean z) {
        this.s.h(this, z);
    }

    public void setItemBackground(Drawable drawable) {
        this.i.I(drawable);
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(q30.e(getContext(), i));
    }

    public void setItemHorizontalPadding(int i) {
        this.i.K(i);
    }

    public void setItemHorizontalPaddingResource(int i) {
        this.i.K(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconPadding(int i) {
        this.i.L(i);
    }

    public void setItemIconPaddingResource(int i) {
        this.i.L(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconSize(int i) {
        this.i.M(i);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.i.N(colorStateList);
    }

    public void setItemMaxLines(int i) {
        this.i.O(i);
    }

    public void setItemTextAppearance(int i) {
        this.i.P(i);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.i.Q(z);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.i.R(colorStateList);
    }

    public void setItemVerticalPadding(int i) {
        this.i.S(i);
    }

    public void setItemVerticalPaddingResource(int i) {
        this.i.S(getResources().getDimensionPixelSize(i));
    }

    public void setNavigationItemSelectedListener(d dVar) {
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        com.google.android.material.internal.b bVar = this.i;
        if (bVar != null) {
            bVar.T(i);
        }
    }

    public void setSubheaderInsetEnd(int i) {
        this.i.V(i);
    }

    public void setSubheaderInsetStart(int i) {
        this.i.W(i);
    }

    public void setTopInsetScrimEnabled(boolean z) {
        this.n = z;
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public Bundle a;

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
            this.a = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.a);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R$attr.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateListK;
        int i2;
        int i3;
        int i4 = y;
        super(yg1.c(context, attributeSet, i, i4), attributeSet, i);
        com.google.android.material.internal.b bVar = new com.google.android.material.internal.b();
        this.i = bVar;
        this.k = new int[2];
        this.n = true;
        this.o = true;
        this.p = 0;
        this.s = io2.a(this);
        this.t = new vg1(this);
        this.u = new jg1(this);
        this.v = new a();
        Context context2 = getContext();
        nn1 nn1Var = new nn1(context2);
        this.h = nn1Var;
        e0 e0VarJ = o23.j(context2, attributeSet, R$styleable.NavigationView, i, i4, new int[0]);
        int i5 = R$styleable.NavigationView_android_background;
        if (e0VarJ.s(i5)) {
            be3.t0(this, e0VarJ.g(i5));
        }
        int iF = e0VarJ.f(R$styleable.NavigationView_drawerLayoutCornerSize, 0);
        this.p = iF;
        this.f264q = iF == 0;
        this.r = getResources().getDimensionPixelSize(R$dimen.m3_navigation_drawer_layout_corner_size);
        Drawable background = getBackground();
        ColorStateList colorStateListG = qd0.g(background);
        if (background == null || colorStateListG != null) {
            tg1 tg1Var = new tg1(sn2.e(context2, attributeSet, i, i4).m());
            if (colorStateListG != null) {
                tg1Var.b0(colorStateListG);
            }
            tg1Var.Q(context2);
            be3.t0(this, tg1Var);
        }
        int i6 = R$styleable.NavigationView_elevation;
        if (e0VarJ.s(i6)) {
            setElevation(e0VarJ.f(i6, 0));
        }
        setFitsSystemWindows(e0VarJ.a(R$styleable.NavigationView_android_fitsSystemWindows, false));
        this.j = e0VarJ.f(R$styleable.NavigationView_android_maxWidth, 0);
        int i7 = R$styleable.NavigationView_subheaderColor;
        ColorStateList colorStateListC = e0VarJ.s(i7) ? e0VarJ.c(i7) : null;
        int i8 = R$styleable.NavigationView_subheaderTextAppearance;
        int iN = e0VarJ.s(i8) ? e0VarJ.n(i8, 0) : 0;
        if (iN == 0 && colorStateListC == null) {
            colorStateListC = k(R.attr.textColorSecondary);
        }
        int i9 = R$styleable.NavigationView_itemIconTint;
        if (e0VarJ.s(i9)) {
            colorStateListK = e0VarJ.c(i9);
        } else {
            colorStateListK = k(R.attr.textColorSecondary);
        }
        int i10 = R$styleable.NavigationView_itemTextAppearance;
        int iN2 = e0VarJ.s(i10) ? e0VarJ.n(i10, 0) : 0;
        boolean zA = e0VarJ.a(R$styleable.NavigationView_itemTextAppearanceActiveBoldEnabled, true);
        int i11 = R$styleable.NavigationView_itemIconSize;
        if (e0VarJ.s(i11)) {
            setItemIconSize(e0VarJ.f(i11, 0));
        }
        int i12 = R$styleable.NavigationView_itemTextColor;
        ColorStateList colorStateListC2 = e0VarJ.s(i12) ? e0VarJ.c(i12) : null;
        if (iN2 == 0 && colorStateListC2 == null) {
            colorStateListC2 = k(R.attr.textColorPrimary);
        }
        Drawable drawableG = e0VarJ.g(R$styleable.NavigationView_itemBackground);
        if (drawableG == null && n(e0VarJ)) {
            drawableG = l(e0VarJ);
            ColorStateList colorStateListB = sg1.b(context2, e0VarJ, R$styleable.NavigationView_itemRippleColor);
            if (colorStateListB != null) {
                bVar.J(new RippleDrawable(zh2.d(colorStateListB), null, m(e0VarJ, null)));
            }
        }
        int i13 = R$styleable.NavigationView_itemHorizontalPadding;
        if (e0VarJ.s(i13)) {
            i2 = 0;
            setItemHorizontalPadding(e0VarJ.f(i13, 0));
        } else {
            i2 = 0;
        }
        int i14 = R$styleable.NavigationView_itemVerticalPadding;
        if (e0VarJ.s(i14)) {
            setItemVerticalPadding(e0VarJ.f(i14, i2));
        }
        setDividerInsetStart(e0VarJ.f(R$styleable.NavigationView_dividerInsetStart, i2));
        setDividerInsetEnd(e0VarJ.f(R$styleable.NavigationView_dividerInsetEnd, i2));
        setSubheaderInsetStart(e0VarJ.f(R$styleable.NavigationView_subheaderInsetStart, i2));
        setSubheaderInsetEnd(e0VarJ.f(R$styleable.NavigationView_subheaderInsetEnd, i2));
        setTopInsetScrimEnabled(e0VarJ.a(R$styleable.NavigationView_topInsetScrimEnabled, this.n));
        setBottomInsetScrimEnabled(e0VarJ.a(R$styleable.NavigationView_bottomInsetScrimEnabled, this.o));
        int iF2 = e0VarJ.f(R$styleable.NavigationView_itemIconPadding, i2);
        setItemMaxLines(e0VarJ.k(R$styleable.NavigationView_itemMaxLines, 1));
        nn1Var.W(new b());
        bVar.H(1);
        bVar.i(context2, nn1Var);
        if (iN != 0) {
            bVar.X(iN);
        }
        bVar.U(colorStateListC);
        bVar.N(colorStateListK);
        bVar.T(getOverScrollMode());
        if (iN2 != 0) {
            bVar.P(iN2);
        }
        bVar.Q(zA);
        bVar.R(colorStateListC2);
        bVar.I(drawableG);
        bVar.L(iF2);
        nn1Var.b(bVar);
        addView((View) bVar.y(this));
        int i15 = R$styleable.NavigationView_menu;
        if (e0VarJ.s(i15)) {
            i3 = 0;
            p(e0VarJ.n(i15, 0));
        } else {
            i3 = 0;
        }
        int i16 = R$styleable.NavigationView_headerLayout;
        if (e0VarJ.s(i16)) {
            o(e0VarJ.n(i16, i3));
        }
        e0VarJ.x();
        w();
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem menuItemFindItem = this.h.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.i.E((g) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
