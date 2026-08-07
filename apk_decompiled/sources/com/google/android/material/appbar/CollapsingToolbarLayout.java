package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.tenmeter.smlibrary.banner.config.BannerConfig;
import defpackage.be3;
import defpackage.dd0;
import defpackage.eh1;
import defpackage.el1;
import defpackage.hf0;
import defpackage.m90;
import defpackage.mu1;
import defpackage.o23;
import defpackage.og1;
import defpackage.q30;
import defpackage.sg1;
import defpackage.tt1;
import defpackage.ut2;
import defpackage.y6;
import defpackage.yg1;
import defpackage.zi3;

/* JADX INFO: loaded from: classes3.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int K = R$style.Widget_Design_CollapsingToolbar;
    zi3 F;
    private int G;
    private boolean H;
    private int I;
    private boolean J;
    private boolean a;
    private int b;
    private ViewGroup c;
    private View d;
    private View e;
    private int f;
    private int g;
    private int h;
    private int i;
    private final Rect j;
    final com.google.android.material.internal.a k;
    final hf0 l;
    private boolean m;
    private boolean n;
    private Drawable o;
    Drawable p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f246q;
    private boolean r;
    private ValueAnimator s;
    private long t;
    private final TimeInterpolator u;
    private final TimeInterpolator v;
    private int w;
    private AppBarLayout.f x;
    int y;
    private int z;

    class a implements mu1 {
        a() {
        }

        @Override // defpackage.mu1
        public zi3 a(View view, zi3 zi3Var) {
            return CollapsingToolbarLayout.this.o(zi3Var);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    private class d implements AppBarLayout.f {
        d() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void a(AppBarLayout appBarLayout, int i) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.y = i;
            zi3 zi3Var = collapsingToolbarLayout.F;
            int iL = zi3Var != null ? zi3Var.l() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                c cVar = (c) childAt.getLayoutParams();
                com.google.android.material.appbar.d dVarK = CollapsingToolbarLayout.k(childAt);
                int i3 = cVar.a;
                if (i3 == 1) {
                    dVarK.f(eh1.b(-i, 0, CollapsingToolbarLayout.this.i(childAt)));
                } else if (i3 == 2) {
                    dVarK.f(Math.round((-i) * cVar.b));
                }
            }
            CollapsingToolbarLayout.this.v();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.p != null && iL > 0) {
                be3.g0(collapsingToolbarLayout2);
            }
            int height = CollapsingToolbarLayout.this.getHeight();
            int iB = (height - be3.B(CollapsingToolbarLayout.this)) - iL;
            float f = iB;
            CollapsingToolbarLayout.this.k.A0(Math.min(1.0f, (height - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger()) / f));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.k.n0(collapsingToolbarLayout3.y + iB);
            CollapsingToolbarLayout.this.k.y0(Math.abs(i) / f);
        }
    }

    public interface e extends ut2 {
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    private void a(int i) {
        d();
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.s = valueAnimator2;
            valueAnimator2.setInterpolator(i > this.f246q ? this.u : this.v);
            this.s.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.s.cancel();
        }
        this.s.setDuration(this.t);
        this.s.setIntValues(this.f246q, i);
        this.s.start();
    }

    private TextUtils.TruncateAt b(int i) {
        if (i == 0) {
            return TextUtils.TruncateAt.START;
        }
        if (i != 1) {
            return i != 3 ? TextUtils.TruncateAt.END : TextUtils.TruncateAt.MARQUEE;
        }
        return TextUtils.TruncateAt.MIDDLE;
    }

    private void c(AppBarLayout appBarLayout) {
        if (l()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    private void d() {
        if (this.a) {
            ViewGroup viewGroup = null;
            this.c = null;
            this.d = null;
            int i = this.b;
            if (i != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i);
                this.c = viewGroup2;
                if (viewGroup2 != null) {
                    this.d = e(viewGroup2);
                }
            }
            if (this.c == null) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    if (m(childAt)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                }
                this.c = viewGroup;
            }
            u();
            this.a = false;
        }
    }

    private View e(View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    private int getDefaultContentScrimColorForTitleCollapseFadeMode() {
        ColorStateList colorStateListG = og1.g(getContext(), R$attr.colorSurfaceContainer);
        if (colorStateListG != null) {
            return colorStateListG.getDefaultColor();
        }
        return this.l.d(getResources().getDimension(R$dimen.design_appbar_elevation));
    }

    private static int h(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private static CharSequence j(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    static com.google.android.material.appbar.d k(View view) {
        int i = R$id.view_offset_helper;
        com.google.android.material.appbar.d dVar = (com.google.android.material.appbar.d) view.getTag(i);
        if (dVar != null) {
            return dVar;
        }
        com.google.android.material.appbar.d dVar2 = new com.google.android.material.appbar.d(view);
        view.setTag(i, dVar2);
        return dVar2;
    }

    private boolean l() {
        return this.z == 1;
    }

    private static boolean m(View view) {
        return (view instanceof Toolbar) || (view instanceof android.widget.Toolbar);
    }

    private boolean n(View view) {
        View view2 = this.d;
        if (view2 == null || view2 == this) {
            if (view != this.c) {
                return false;
            }
        } else if (view != view2) {
            return false;
        }
        return true;
    }

    private void q(boolean z) {
        int titleMarginStart;
        int titleMarginBottom;
        int titleMarginEnd;
        int titleMarginTop;
        View view = this.d;
        if (view == null) {
            view = this.c;
        }
        int i = i(view);
        m90.a(this, this.e, this.j);
        ViewGroup viewGroup = this.c;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            titleMarginStart = toolbar.getTitleMarginStart();
            titleMarginEnd = toolbar.getTitleMarginEnd();
            titleMarginTop = toolbar.getTitleMarginTop();
            titleMarginBottom = toolbar.getTitleMarginBottom();
        } else if (viewGroup instanceof android.widget.Toolbar) {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            titleMarginStart = toolbar2.getTitleMarginStart();
            titleMarginEnd = toolbar2.getTitleMarginEnd();
            titleMarginTop = toolbar2.getTitleMarginTop();
            titleMarginBottom = toolbar2.getTitleMarginBottom();
        } else {
            titleMarginStart = 0;
            titleMarginBottom = 0;
            titleMarginEnd = 0;
            titleMarginTop = 0;
        }
        com.google.android.material.internal.a aVar = this.k;
        Rect rect = this.j;
        int i2 = rect.left + (z ? titleMarginEnd : titleMarginStart);
        int i3 = rect.top + i + titleMarginTop;
        int i4 = rect.right;
        if (!z) {
            titleMarginStart = titleMarginEnd;
        }
        aVar.e0(i2, i3, i4 - titleMarginStart, (rect.bottom + i) - titleMarginBottom);
    }

    private void r() {
        setContentDescription(getTitle());
    }

    private void s(Drawable drawable, int i, int i2) {
        t(drawable, this.c, i, i2);
    }

    private void t(Drawable drawable, View view, int i, int i2) {
        if (l() && view != null && this.m) {
            i2 = view.getBottom();
        }
        drawable.setBounds(0, 0, i, i2);
    }

    private void u() {
        View view;
        if (!this.m && (view = this.e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.e);
            }
        }
        if (!this.m || this.c == null) {
            return;
        }
        if (this.e == null) {
            this.e = new View(getContext());
        }
        if (this.e.getParent() == null) {
            this.c.addView(this.e, -1, -1);
        }
    }

    private void w(int i, int i2, int i3, int i4, boolean z) {
        View view;
        if (!this.m || (view = this.e) == null) {
            return;
        }
        boolean z2 = be3.S(view) && this.e.getVisibility() == 0;
        this.n = z2;
        if (z2 || z) {
            boolean z3 = be3.A(this) == 1;
            q(z3);
            this.k.o0(z3 ? this.h : this.f, this.j.top + this.g, (i3 - i) - (z3 ? this.f : this.h), (i4 - i2) - this.i);
            this.k.b0(z);
        }
    }

    private void x() {
        if (this.c != null && this.m && TextUtils.isEmpty(this.k.O())) {
            setTitle(j(this.c));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        d();
        if (this.c == null && (drawable = this.o) != null && this.f246q > 0) {
            drawable.mutate().setAlpha(this.f246q);
            this.o.draw(canvas);
        }
        if (this.m && this.n) {
            if (this.c == null || this.o == null || this.f246q <= 0 || !l() || this.k.F() >= this.k.G()) {
                this.k.l(canvas);
            } else {
                int iSave = canvas.save();
                canvas.clipRect(this.o.getBounds(), Region.Op.DIFFERENCE);
                this.k.l(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        if (this.p == null || this.f246q <= 0) {
            return;
        }
        zi3 zi3Var = this.F;
        int iL = zi3Var != null ? zi3Var.l() : 0;
        if (iL > 0) {
            this.p.setBounds(0, -this.y, getWidth(), iL - this.y);
            this.p.mutate().setAlpha(this.f246q);
            this.p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.o == null || this.f246q <= 0 || !n(view)) {
            z = false;
        } else {
            t(this.o, view, getWidth(), getHeight());
            this.o.mutate().setAlpha(this.f246q);
            this.o.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j) || z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.p;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.o;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.a aVar = this.k;
        if (aVar != null) {
            state |= aVar.I0(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public int getCollapsedTitleGravity() {
        return this.k.q();
    }

    public float getCollapsedTitleTextSize() {
        return this.k.u();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.k.v();
    }

    public Drawable getContentScrim() {
        return this.o;
    }

    public int getExpandedTitleGravity() {
        return this.k.B();
    }

    public int getExpandedTitleMarginBottom() {
        return this.i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f;
    }

    public int getExpandedTitleMarginTop() {
        return this.g;
    }

    public float getExpandedTitleTextSize() {
        return this.k.D();
    }

    public Typeface getExpandedTitleTypeface() {
        return this.k.E();
    }

    public int getHyphenationFrequency() {
        return this.k.H();
    }

    public int getLineCount() {
        return this.k.I();
    }

    public float getLineSpacingAdd() {
        return this.k.J();
    }

    public float getLineSpacingMultiplier() {
        return this.k.K();
    }

    public int getMaxLines() {
        return this.k.L();
    }

    int getScrimAlpha() {
        return this.f246q;
    }

    public long getScrimAnimationDuration() {
        return this.t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i = this.w;
        if (i >= 0) {
            return i + this.G + this.I;
        }
        zi3 zi3Var = this.F;
        int iL = zi3Var != null ? zi3Var.l() : 0;
        int iB = be3.B(this);
        return iB > 0 ? Math.min((iB * 2) + iL, getHeight()) : getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.p;
    }

    public CharSequence getTitle() {
        if (this.m) {
            return this.k.O();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.z;
    }

    public TimeInterpolator getTitlePositionInterpolator() {
        return this.k.N();
    }

    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.k.R();
    }

    final int i(View view) {
        return ((getHeight() - k(view).b()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((c) view.getLayoutParams())).bottomMargin;
    }

    zi3 o(zi3 zi3Var) {
        zi3 zi3Var2 = be3.x(this) ? zi3Var : null;
        if (!tt1.a(this.F, zi3Var2)) {
            this.F = zi3Var2;
            requestLayout();
        }
        return zi3Var.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            c(appBarLayout);
            be3.y0(this, be3.x(appBarLayout));
            if (this.x == null) {
                this.x = new d();
            }
            appBarLayout.d(this.x);
            be3.m0(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.k.Y(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.f fVar = this.x;
        if (fVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).x(fVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        zi3 zi3Var = this.F;
        if (zi3Var != null) {
            int iL = zi3Var.l();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!be3.x(childAt) && childAt.getTop() < iL) {
                    be3.a0(childAt, iL);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i6 = 0; i6 < childCount2; i6++) {
            k(getChildAt(i6)).d();
        }
        w(i, i2, i3, i4, false);
        x();
        v();
        int childCount3 = getChildCount();
        for (int i7 = 0; i7 < childCount3; i7++) {
            k(getChildAt(i7)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        d();
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        zi3 zi3Var = this.F;
        int iL = zi3Var != null ? zi3Var.l() : 0;
        if ((mode == 0 || this.H) && iL > 0) {
            this.G = iL;
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iL, 1073741824));
        }
        if (this.J && this.k.L() > 1) {
            x();
            w(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int iZ = this.k.z();
            if (iZ > 1) {
                this.I = Math.round(this.k.A()) * (iZ - 1);
                super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.I, 1073741824));
            }
        }
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            View view = this.d;
            if (view == null || view == this) {
                setMinimumHeight(h(viewGroup));
            } else {
                setMinimumHeight(h(view));
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable drawable = this.o;
        if (drawable != null) {
            s(drawable, i, i2);
        }
    }

    public void p(boolean z, boolean z2) {
        if (this.r != z) {
            if (z2) {
                a(z ? 255 : 0);
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.r = z;
        }
    }

    public void setCollapsedTitleGravity(int i) {
        this.k.j0(i);
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.k.g0(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextSize(float f) {
        this.k.k0(f);
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.k.l0(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.o = drawableMutate;
            if (drawableMutate != null) {
                s(drawableMutate, getWidth(), getHeight());
                this.o.setCallback(this);
                this.o.setAlpha(this.f246q);
            }
            be3.g0(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(q30.e(getContext(), i));
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleGravity(int i) {
        this.k.u0(i);
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.i = i;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.h = i;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i) {
        this.f = i;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i) {
        this.g = i;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.k.r0(i);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.k.t0(colorStateList);
    }

    public void setExpandedTitleTextSize(float f) {
        this.k.v0(f);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.k.w0(typeface);
    }

    public void setExtraMultilineHeightEnabled(boolean z) {
        this.J = z;
    }

    public void setForceApplySystemWindowInsetTop(boolean z) {
        this.H = z;
    }

    public void setHyphenationFrequency(int i) {
        this.k.B0(i);
    }

    public void setLineSpacingAdd(float f) {
        this.k.D0(f);
    }

    public void setLineSpacingMultiplier(float f) {
        this.k.E0(f);
    }

    public void setMaxLines(int i) {
        this.k.F0(i);
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z) {
        this.k.H0(z);
    }

    void setScrimAlpha(int i) {
        ViewGroup viewGroup;
        if (i != this.f246q) {
            if (this.o != null && (viewGroup = this.c) != null) {
                be3.g0(viewGroup);
            }
            this.f246q = i;
            be3.g0(this);
        }
    }

    public void setScrimAnimationDuration(long j) {
        this.t = j;
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.w != i) {
            this.w = i;
            v();
        }
    }

    public void setScrimsShown(boolean z) {
        p(z, be3.T(this) && !isInEditMode());
    }

    public void setStaticLayoutBuilderConfigurer(e eVar) {
        this.k.J0(eVar);
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.p = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.p.setState(getDrawableState());
                }
                dd0.m(this.p, be3.A(this));
                this.p.setVisible(getVisibility() == 0, false);
                this.p.setCallback(this);
                this.p.setAlpha(this.f246q);
            }
            be3.g0(this);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(q30.e(getContext(), i));
    }

    public void setTitle(CharSequence charSequence) {
        this.k.K0(charSequence);
        r();
    }

    public void setTitleCollapseMode(int i) {
        this.z = i;
        boolean zL = l();
        this.k.z0(zL);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            c((AppBarLayout) parent);
        }
        if (zL && this.o == null) {
            setContentScrimColor(getDefaultContentScrimColorForTitleCollapseFadeMode());
        }
    }

    public void setTitleEllipsize(TextUtils.TruncateAt truncateAt) {
        this.k.M0(truncateAt);
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.m) {
            this.m = z;
            r();
            u();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(TimeInterpolator timeInterpolator) {
        this.k.G0(timeInterpolator);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.p;
        if (drawable != null && drawable.isVisible() != z) {
            this.p.setVisible(z, false);
        }
        Drawable drawable2 = this.o;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.o.setVisible(z, false);
    }

    final void v() {
        if (this.o == null && this.p == null) {
            return;
        }
        setScrimsShown(getHeight() + this.y < getScrimVisibleHeightTrigger());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o || drawable == this.p;
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.collapsingToolbarLayoutStyle);
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.k.i0(colorStateList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = K;
        super(yg1.c(context, attributeSet, i, i2), attributeSet, i);
        this.a = true;
        this.j = new Rect();
        this.w = -1;
        this.G = 0;
        this.I = 0;
        Context context2 = getContext();
        com.google.android.material.internal.a aVar = new com.google.android.material.internal.a(this);
        this.k = aVar;
        aVar.L0(y6.e);
        aVar.H0(false);
        this.l = new hf0(context2);
        TypedArray typedArrayI = o23.i(context2, attributeSet, R$styleable.CollapsingToolbarLayout, i, i2, new int[0]);
        aVar.u0(typedArrayI.getInt(R$styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        aVar.j0(typedArrayI.getInt(R$styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayI.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.i = dimensionPixelSize;
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        this.f = dimensionPixelSize;
        int i3 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart;
        if (typedArrayI.hasValue(i3)) {
            this.f = typedArrayI.getDimensionPixelSize(i3, 0);
        }
        int i4 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd;
        if (typedArrayI.hasValue(i4)) {
            this.h = typedArrayI.getDimensionPixelSize(i4, 0);
        }
        int i5 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop;
        if (typedArrayI.hasValue(i5)) {
            this.g = typedArrayI.getDimensionPixelSize(i5, 0);
        }
        int i6 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom;
        if (typedArrayI.hasValue(i6)) {
            this.i = typedArrayI.getDimensionPixelSize(i6, 0);
        }
        this.m = typedArrayI.getBoolean(R$styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(typedArrayI.getText(R$styleable.CollapsingToolbarLayout_title));
        aVar.r0(R$style.TextAppearance_Design_CollapsingToolbar_Expanded);
        aVar.g0(androidx.appcompat.R$style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        int i7 = R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance;
        if (typedArrayI.hasValue(i7)) {
            aVar.r0(typedArrayI.getResourceId(i7, 0));
        }
        int i8 = R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance;
        if (typedArrayI.hasValue(i8)) {
            aVar.g0(typedArrayI.getResourceId(i8, 0));
        }
        int i9 = R$styleable.CollapsingToolbarLayout_titleTextEllipsize;
        if (typedArrayI.hasValue(i9)) {
            setTitleEllipsize(b(typedArrayI.getInt(i9, -1)));
        }
        int i10 = R$styleable.CollapsingToolbarLayout_expandedTitleTextColor;
        if (typedArrayI.hasValue(i10)) {
            aVar.t0(sg1.a(context2, typedArrayI, i10));
        }
        int i11 = R$styleable.CollapsingToolbarLayout_collapsedTitleTextColor;
        if (typedArrayI.hasValue(i11)) {
            aVar.i0(sg1.a(context2, typedArrayI, i11));
        }
        this.w = typedArrayI.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        int i12 = R$styleable.CollapsingToolbarLayout_maxLines;
        if (typedArrayI.hasValue(i12)) {
            aVar.F0(typedArrayI.getInt(i12, 1));
        }
        int i13 = R$styleable.CollapsingToolbarLayout_titlePositionInterpolator;
        if (typedArrayI.hasValue(i13)) {
            aVar.G0(AnimationUtils.loadInterpolator(context2, typedArrayI.getResourceId(i13, 0)));
        }
        this.t = typedArrayI.getInt(R$styleable.CollapsingToolbarLayout_scrimAnimationDuration, BannerConfig.SCROLL_TIME);
        int i14 = R$attr.motionEasingStandardInterpolator;
        this.u = el1.g(context2, i14, y6.c);
        this.v = el1.g(context2, i14, y6.d);
        setContentScrim(typedArrayI.getDrawable(R$styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(typedArrayI.getDrawable(R$styleable.CollapsingToolbarLayout_statusBarScrim));
        setTitleCollapseMode(typedArrayI.getInt(R$styleable.CollapsingToolbarLayout_titleCollapseMode, 0));
        this.b = typedArrayI.getResourceId(R$styleable.CollapsingToolbarLayout_toolbarId, -1);
        this.H = typedArrayI.getBoolean(R$styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.J = typedArrayI.getBoolean(R$styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        typedArrayI.recycle();
        setWillNotDraw(false);
        be3.E0(this, new a());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public static class c extends FrameLayout.LayoutParams {
        int a;
        float b;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            this.b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout_Layout);
            this.a = typedArrayObtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(typedArrayObtainStyledAttributes.getFloat(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            typedArrayObtainStyledAttributes.recycle();
        }

        public void a(float f) {
            this.b = f;
        }

        public c(int i, int i2) {
            super(i, i2);
            this.a = 0;
            this.b = 0.5f;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
            this.b = 0.5f;
        }
    }
}
