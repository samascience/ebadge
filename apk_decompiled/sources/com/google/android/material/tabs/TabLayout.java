package com.google.android.material.tabs;

import android.R;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.seeker.luckychart.animation.ChartCoordinateportAnimator;
import defpackage.a42;
import defpackage.be3;
import defpackage.dd0;
import defpackage.el1;
import defpackage.g43;
import defpackage.h42;
import defpackage.i42;
import defpackage.j23;
import defpackage.j42;
import defpackage.m2;
import defpackage.nf3;
import defpackage.o23;
import defpackage.qd0;
import defpackage.sg1;
import defpackage.tg1;
import defpackage.uf1;
import defpackage.ug1;
import defpackage.v8;
import defpackage.y6;
import defpackage.yg1;
import defpackage.zh2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@ViewPager.e
public class TabLayout extends HorizontalScrollView {
    private static final int f0 = R$style.Widget_Design_TabLayout;
    private static final h42 g0 = new j42(16);
    int F;
    int G;
    int H;
    int I;
    boolean J;
    boolean K;
    int L;
    int M;
    boolean N;
    private com.google.android.material.tabs.c O;
    private final TimeInterpolator P;
    private c Q;
    private final ArrayList R;
    private c S;
    private ValueAnimator T;
    ViewPager U;
    private androidx.viewpager.widget.a V;
    private DataSetObserver W;
    int a;
    private h a0;
    private final ArrayList b;
    private b b0;
    private g c;
    private boolean c0;
    final f d;
    private int d0;
    int e;
    private final h42 e0;
    int f;
    int g;
    int h;
    private final int i;
    private final int j;
    private int k;
    ColorStateList l;
    ColorStateList m;
    ColorStateList n;
    Drawable o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    PorterDuff.Mode f270q;
    float r;
    float s;
    float t;
    final int u;
    int v;
    private final int w;
    private final int x;
    private final int y;
    private int z;

    public final class TabView extends LinearLayout {
        private g a;
        private TextView b;
        private ImageView c;
        private View d;
        private com.google.android.material.badge.a e;
        private View f;
        private TextView g;
        private ImageView h;
        private Drawable i;
        private int j;

        class a implements View.OnLayoutChangeListener {
            final /* synthetic */ View a;

            a(View view) {
                this.a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (this.a.getVisibility() == 0) {
                    TabView.this.s(this.a);
                }
            }
        }

        public TabView(Context context) {
            super(context);
            this.j = 2;
            u(context);
            be3.F0(this, TabLayout.this.e, TabLayout.this.f, TabLayout.this.g, TabLayout.this.h);
            setGravity(17);
            setOrientation(!TabLayout.this.J ? 1 : 0);
            setClickable(true);
            be3.G0(this, a42.b(getContext(), 1002));
        }

        private void f(View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        private float g(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }

        private com.google.android.material.badge.a getBadge() {
            return this.e;
        }

        private com.google.android.material.badge.a getOrCreateBadge() {
            if (this.e == null) {
                this.e = com.google.android.material.badge.a.d(getContext());
            }
            r();
            com.google.android.material.badge.a aVar = this.e;
            if (aVar != null) {
                return aVar;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private void h(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z);
                viewGroup.setClipToPadding(z);
            }
        }

        private FrameLayout i() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(Canvas canvas) {
            Drawable drawable = this.i;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.i.draw(canvas);
            }
        }

        private FrameLayout k(View view) {
            if ((view == this.c || view == this.b) && com.google.android.material.badge.b.a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean l() {
            return this.e != null;
        }

        private void m() {
            ViewGroup viewGroup;
            if (com.google.android.material.badge.b.a) {
                FrameLayout frameLayoutI = i();
                addView(frameLayoutI, 0);
                viewGroup = frameLayoutI;
            } else {
                viewGroup = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, viewGroup, false);
            this.c = imageView;
            viewGroup.addView(imageView, 0);
        }

        private void n() {
            ViewGroup viewGroup;
            if (com.google.android.material.badge.b.a) {
                FrameLayout frameLayoutI = i();
                addView(frameLayoutI);
                viewGroup = frameLayoutI;
            } else {
                viewGroup = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, viewGroup, false);
            this.b = textView;
            viewGroup.addView(textView);
        }

        private void p(View view) {
            if (l() && view != null) {
                h(false);
                com.google.android.material.badge.b.a(this.e, view, k(view));
                this.d = view;
            }
        }

        private void q() {
            if (l()) {
                h(true);
                View view = this.d;
                if (view != null) {
                    com.google.android.material.badge.b.d(this.e, view);
                    this.d = null;
                }
            }
        }

        private void r() {
            g gVar;
            g gVar2;
            if (l()) {
                if (this.f != null) {
                    q();
                    return;
                }
                if (this.c != null && (gVar2 = this.a) != null && gVar2.f() != null) {
                    View view = this.d;
                    ImageView imageView = this.c;
                    if (view == imageView) {
                        s(imageView);
                        return;
                    } else {
                        q();
                        p(this.c);
                        return;
                    }
                }
                if (this.b == null || (gVar = this.a) == null || gVar.h() != 1) {
                    q();
                    return;
                }
                View view2 = this.d;
                TextView textView = this.b;
                if (view2 == textView) {
                    s(textView);
                } else {
                    q();
                    p(this.b);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(View view) {
            if (l() && view == this.d) {
                com.google.android.material.badge.b.e(this.e, view, k(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(Context context) {
            GradientDrawable gradientDrawable;
            int i = TabLayout.this.u;
            if (i != 0) {
                Drawable drawableB = v8.b(context, i);
                this.i = drawableB;
                if (drawableB != null && drawableB.isStateful()) {
                    this.i.setState(getDrawableState());
                }
            } else {
                this.i = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            Drawable rippleDrawable = gradientDrawable2;
            if (TabLayout.this.n != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList colorStateListA = zh2.a(TabLayout.this.n);
                boolean z = TabLayout.this.N;
                if (z) {
                    gradientDrawable = gradientDrawable2;
                    gradientDrawable = null;
                }
                rippleDrawable = new RippleDrawable(colorStateListA, gradientDrawable, z ? null : gradientDrawable3);
            }
            be3.t0(this, rippleDrawable);
            TabLayout.this.invalidate();
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0060  */
        private void x(TextView textView, ImageView imageView, boolean z) {
            boolean z2;
            g gVar = this.a;
            Drawable drawableMutate = (gVar == null || gVar.f() == null) ? null : dd0.r(this.a.f()).mutate();
            if (drawableMutate != null) {
                dd0.o(drawableMutate, TabLayout.this.m);
                PorterDuff.Mode mode = TabLayout.this.f270q;
                if (mode != null) {
                    dd0.p(drawableMutate, mode);
                }
            }
            g gVar2 = this.a;
            CharSequence charSequenceI = gVar2 != null ? gVar2.i() : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean zIsEmpty = TextUtils.isEmpty(charSequenceI);
            if (textView != null) {
                if (!zIsEmpty) {
                    z2 = this.a.g == 1;
                }
                textView.setText(!zIsEmpty ? charSequenceI : null);
                textView.setVisibility(z2 ? 0 : 8);
                if (!zIsEmpty) {
                    setVisibility(0);
                }
            } else {
                z2 = false;
            }
            if (z && imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iG = (z2 && imageView.getVisibility() == 0) ? (int) nf3.g(getContext(), 8) : 0;
                if (TabLayout.this.J) {
                    if (iG != uf1.a(marginLayoutParams)) {
                        uf1.c(marginLayoutParams, iG);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iG != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iG;
                    uf1.c(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            g gVar3 = this.a;
            CharSequence charSequence = gVar3 != null ? gVar3.d : null;
            if (zIsEmpty) {
                charSequenceI = charSequence;
            }
            g43.a(this, charSequenceI);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.i;
            if ((drawable == null || !drawable.isStateful()) ? false : this.i.setState(drawableState)) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        int getContentHeight() {
            View[] viewArr = {this.b, this.c, this.f};
            int iMax = 0;
            int iMin = 0;
            boolean z = false;
            for (int i = 0; i < 3; i++) {
                View view = viewArr[i];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z ? Math.min(iMin, view.getTop()) : view.getTop();
                    iMax = z ? Math.max(iMax, view.getBottom()) : view.getBottom();
                    z = true;
                }
            }
            return iMax - iMin;
        }

        int getContentWidth() {
            View[] viewArr = {this.b, this.c, this.f};
            int iMax = 0;
            int iMin = 0;
            boolean z = false;
            for (int i = 0; i < 3; i++) {
                View view = viewArr[i];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z ? Math.max(iMax, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return iMax - iMin;
        }

        public g getTab() {
            return this.a;
        }

        void o() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            m2 m2VarQ0 = m2.Q0(accessibilityNodeInfo);
            com.google.android.material.badge.a aVar = this.e;
            if (aVar != null && aVar.isVisible()) {
                m2VarQ0.n0(this.e.i());
            }
            m2VarQ0.m0(m2.f.f(0, 1, this.a.g(), 1, false, isSelected()));
            if (isSelected()) {
                m2VarQ0.k0(false);
                m2VarQ0.b0(m2.a.i);
            }
            m2VarQ0.E0(getResources().getString(R$string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.v, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.b != null) {
                float f = TabLayout.this.r;
                int i3 = this.j;
                ImageView imageView = this.c;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = TabLayout.this.t;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.b.getTextSize();
                int lineCount = this.b.getLineCount();
                int iD = j23.d(this.b);
                if (f != textSize || (iD >= 0 && i3 != iD)) {
                    if (TabLayout.this.I != 1 || f <= textSize || lineCount != 1 || ((layout = this.b.getLayout()) != null && g(layout, 0, f) <= (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        this.b.setTextSize(0, f);
                        this.b.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.a == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.a.l();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            isSelected();
            super.setSelected(z);
            TextView textView = this.b;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.c;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f;
            if (view != null) {
                view.setSelected(z);
            }
        }

        void setTab(g gVar) {
            if (gVar != this.a) {
                this.a = gVar;
                t();
            }
        }

        final void t() {
            w();
            g gVar = this.a;
            setSelected(gVar != null && gVar.j());
        }

        final void v() {
            setOrientation(!TabLayout.this.J ? 1 : 0);
            TextView textView = this.g;
            if (textView == null && this.h == null) {
                x(this.b, this.c, true);
            } else {
                x(textView, this.h, false);
            }
        }

        final void w() {
            ViewParent parent;
            g gVar = this.a;
            View viewE = gVar != null ? gVar.e() : null;
            if (viewE != null) {
                ViewParent parent2 = viewE.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(viewE);
                    }
                    View view = this.f;
                    if (view != null && (parent = view.getParent()) != null) {
                        ((ViewGroup) parent).removeView(this.f);
                    }
                    addView(viewE);
                }
                this.f = viewE;
                TextView textView = this.b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) viewE.findViewById(R.id.text1);
                this.g = textView2;
                if (textView2 != null) {
                    this.j = j23.d(textView2);
                }
                this.h = (ImageView) viewE.findViewById(R.id.icon);
            } else {
                View view2 = this.f;
                if (view2 != null) {
                    removeView(view2);
                    this.f = null;
                }
                this.g = null;
                this.h = null;
            }
            if (this.f == null) {
                if (this.c == null) {
                    m();
                }
                if (this.b == null) {
                    n();
                    this.j = j23.d(this.b);
                }
                j23.p(this.b, TabLayout.this.i);
                if (!isSelected() || TabLayout.this.k == -1) {
                    j23.p(this.b, TabLayout.this.j);
                } else {
                    j23.p(this.b, TabLayout.this.k);
                }
                ColorStateList colorStateList = TabLayout.this.l;
                if (colorStateList != null) {
                    this.b.setTextColor(colorStateList);
                }
                x(this.b, this.c, true);
                r();
                f(this.c);
                f(this.b);
            } else {
                TextView textView3 = this.g;
                if (textView3 != null || this.h != null) {
                    x(textView3, this.h, false);
                }
            }
            if (gVar == null || TextUtils.isEmpty(gVar.d)) {
                return;
            }
            setContentDescription(gVar.d);
        }
    }

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    private class b implements ViewPager.i {
        private boolean a;

        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.U == viewPager) {
                tabLayout.L(aVar2, this.a);
            }
        }

        void b(boolean z) {
            this.a = z;
        }
    }

    public interface c {
        void a(g gVar);

        void b(g gVar);

        void c(g gVar);
    }

    public interface d extends c {
    }

    private class e extends DataSetObserver {
        e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.E();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.E();
        }
    }

    class f extends LinearLayout {
        ValueAnimator a;
        private int b;

        class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ View a;
            final /* synthetic */ View b;

            a(View view, View view2) {
                this.a = view;
                this.b = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.j(this.a, this.b, valueAnimator.getAnimatedFraction());
            }
        }

        f(Context context) {
            super(context);
            this.b = -1;
            setWillNotDraw(false);
        }

        private void e() {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.a == -1) {
                tabLayout.a = tabLayout.getSelectedTabPosition();
            }
            f(TabLayout.this.a);
        }

        private void f(int i) {
            if (TabLayout.this.d0 == 0 || (TabLayout.this.getTabSelectedIndicator().getBounds().left == -1 && TabLayout.this.getTabSelectedIndicator().getBounds().right == -1)) {
                View childAt = getChildAt(i);
                com.google.android.material.tabs.c cVar = TabLayout.this.O;
                TabLayout tabLayout = TabLayout.this;
                cVar.c(tabLayout, childAt, tabLayout.o);
                TabLayout.this.a = i;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            f(TabLayout.this.getSelectedTabPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(View view, View view2, float f) {
            if (view == null || view.getWidth() <= 0) {
                Drawable drawable = TabLayout.this.o;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.o.getBounds().bottom);
            } else {
                com.google.android.material.tabs.c cVar = TabLayout.this.O;
                TabLayout tabLayout = TabLayout.this;
                cVar.d(tabLayout, view, view2, f, tabLayout.o);
            }
            be3.g0(this);
        }

        private void k(boolean z, int i, int i2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.a == i) {
                return;
            }
            View childAt = getChildAt(tabLayout.getSelectedTabPosition());
            View childAt2 = getChildAt(i);
            if (childAt2 == null) {
                g();
                return;
            }
            TabLayout.this.a = i;
            a aVar = new a(childAt, childAt2);
            if (!z) {
                this.a.removeAllUpdateListeners();
                this.a.addUpdateListener(aVar);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.a = valueAnimator;
            valueAnimator.setInterpolator(TabLayout.this.P);
            valueAnimator.setDuration(i2);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(aVar);
            valueAnimator.start();
        }

        void c(int i, int i2) {
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null && valueAnimator.isRunning() && TabLayout.this.a != i) {
                this.a.cancel();
            }
            k(true, i, i2);
        }

        boolean d() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int height;
            int iHeight = TabLayout.this.o.getBounds().height();
            if (iHeight < 0) {
                iHeight = TabLayout.this.o.getIntrinsicHeight();
            }
            int i = TabLayout.this.H;
            if (i == 0) {
                height = getHeight() - iHeight;
                iHeight = getHeight();
            } else if (i != 1) {
                height = 0;
                if (i != 2) {
                    iHeight = i != 3 ? 0 : getHeight();
                }
            } else {
                height = (getHeight() - iHeight) / 2;
                iHeight = (getHeight() + iHeight) / 2;
            }
            if (TabLayout.this.o.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.o.getBounds();
                TabLayout.this.o.setBounds(bounds.left, height, bounds.right, iHeight);
                TabLayout.this.o.draw(canvas);
            }
            super.draw(canvas);
        }

        void h(int i, float f) {
            TabLayout.this.a = Math.round(i + f);
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.a.cancel();
            }
            j(getChildAt(i), getChildAt(i + 1), f);
        }

        void i(int i) {
            Rect bounds = TabLayout.this.o.getBounds();
            TabLayout.this.o.setBounds(bounds.left, 0, bounds.right, i);
            requestLayout();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                e();
            } else {
                k(false, TabLayout.this.getSelectedTabPosition(), -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z = true;
            if (tabLayout.F == 1 || tabLayout.I == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) nf3.g(getContext(), 16)) * 2)) {
                    boolean z2 = false;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.F = 0;
                    tabLayout2.T(false);
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
        }
    }

    public static class g {
        private Object a;
        private Drawable b;
        private CharSequence c;
        private CharSequence d;
        private View f;
        public TabLayout h;
        public TabView i;
        private int e = -1;
        private int g = 1;
        private int j = -1;

        public View e() {
            return this.f;
        }

        public Drawable f() {
            return this.b;
        }

        public int g() {
            return this.e;
        }

        public int h() {
            return this.g;
        }

        public CharSequence i() {
            return this.c;
        }

        public boolean j() {
            TabLayout tabLayout = this.h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            int selectedTabPosition = tabLayout.getSelectedTabPosition();
            return selectedTabPosition != -1 && selectedTabPosition == this.e;
        }

        void k() {
            this.h = null;
            this.i = null;
            this.a = null;
            this.b = null;
            this.j = -1;
            this.c = null;
            this.d = null;
            this.e = -1;
            this.f = null;
        }

        public void l() {
            TabLayout tabLayout = this.h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.J(this);
        }

        public g m(CharSequence charSequence) {
            this.d = charSequence;
            s();
            return this;
        }

        public g n(int i) {
            return o(LayoutInflater.from(this.i.getContext()).inflate(i, (ViewGroup) this.i, false));
        }

        public g o(View view) {
            this.f = view;
            s();
            return this;
        }

        public g p(Drawable drawable) {
            this.b = drawable;
            TabLayout tabLayout = this.h;
            if (tabLayout.F == 1 || tabLayout.I == 2) {
                tabLayout.T(true);
            }
            s();
            if (com.google.android.material.badge.b.a && this.i.l() && this.i.e.isVisible()) {
                this.i.invalidate();
            }
            return this;
        }

        void q(int i) {
            this.e = i;
        }

        public g r(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(charSequence)) {
                this.i.setContentDescription(charSequence);
            }
            this.c = charSequence;
            s();
            return this;
        }

        void s() {
            TabView tabView = this.i;
            if (tabView != null) {
                tabView.t();
            }
        }
    }

    public static class h implements ViewPager.j {
        private final WeakReference a;
        private int b;
        private int c;

        public h(TabLayout tabLayout) {
            this.a = new WeakReference(tabLayout);
        }

        void a() {
            this.c = 0;
            this.b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i) {
            this.b = this.c;
            this.c = i;
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout != null) {
                tabLayout.U(this.c);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i, float f, int i2) {
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout != null) {
                int i3 = this.c;
                tabLayout.O(i, f, i3 != 2 || this.b == 1, (i3 == 2 && this.b == 0) ? false : true, false);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i) {
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.c;
            tabLayout.K(tabLayout.A(i), i2 == 0 || (i2 == 2 && this.b == 0));
        }
    }

    public static class i implements d {
        private final ViewPager a;

        public i(ViewPager viewPager) {
            this.a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(g gVar) {
            this.a.setCurrentItem(gVar.g());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(g gVar) {
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    private boolean B() {
        return getTabMode() == 0 || getTabMode() == 2;
    }

    private void I(int i2) {
        TabView tabView = (TabView) this.d.getChildAt(i2);
        this.d.removeViewAt(i2);
        if (tabView != null) {
            tabView.o();
            this.e0.a(tabView);
        }
        requestLayout();
    }

    private void Q(ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.U;
        if (viewPager2 != null) {
            h hVar = this.a0;
            if (hVar != null) {
                viewPager2.J(hVar);
            }
            b bVar = this.b0;
            if (bVar != null) {
                this.U.I(bVar);
            }
        }
        c cVar = this.S;
        if (cVar != null) {
            H(cVar);
            this.S = null;
        }
        if (viewPager != null) {
            this.U = viewPager;
            if (this.a0 == null) {
                this.a0 = new h(this);
            }
            this.a0.a();
            viewPager.c(this.a0);
            i iVar = new i(viewPager);
            this.S = iVar;
            g(iVar);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                L(adapter, z);
            }
            if (this.b0 == null) {
                this.b0 = new b();
            }
            this.b0.b(z);
            viewPager.b(this.b0);
            M(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.U = null;
            L(null, false);
        }
        this.c0 = z2;
    }

    private void R() {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((g) this.b.get(i2)).s();
        }
    }

    private void S(LinearLayout.LayoutParams layoutParams) {
        if (this.I == 1 && this.F == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    private int getDefaultHeight() {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.b.get(i2);
            if (gVar != null && gVar.f() != null && !TextUtils.isEmpty(gVar.i())) {
                if (!this.J) {
                    return 72;
                }
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i2 = this.w;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.I;
        if (i3 == 0 || i3 == 2) {
            return this.y;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void k(TabItem tabItem) {
        g gVarD = D();
        CharSequence charSequence = tabItem.a;
        if (charSequence != null) {
            gVarD.r(charSequence);
        }
        Drawable drawable = tabItem.b;
        if (drawable != null) {
            gVarD.p(drawable);
        }
        int i2 = tabItem.c;
        if (i2 != 0) {
            gVarD.n(i2);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            gVarD.m(tabItem.getContentDescription());
        }
        h(gVarD);
    }

    private void l(g gVar) {
        TabView tabView = gVar.i;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.d.addView(tabView, gVar.g(), t());
    }

    private void m(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        k((TabItem) view);
    }

    private void n(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() == null || !be3.T(this) || this.d.d()) {
            M(i2, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int iQ = q(i2, 0.0f);
        if (scrollX != iQ) {
            z();
            this.T.setIntValues(scrollX, iQ);
            this.T.start();
        }
        this.d.c(i2, this.G);
    }

    private void o(int i2) {
        if (i2 == 0) {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i2 == 1) {
            this.d.setGravity(1);
            return;
        } else if (i2 != 2) {
            return;
        }
        this.d.setGravity(8388611);
    }

    private void p() {
        int i2 = this.I;
        be3.F0(this.d, (i2 == 0 || i2 == 2) ? Math.max(0, this.z - this.e) : 0, 0, 0, 0);
        int i3 = this.I;
        if (i3 == 0) {
            o(this.F);
        } else if (i3 == 1 || i3 == 2) {
            if (this.F == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.d.setGravity(1);
        }
        T(true);
    }

    private int q(int i2, float f2) {
        View childAt;
        int i3 = this.I;
        if ((i3 != 0 && i3 != 2) || (childAt = this.d.getChildAt(i2)) == null) {
            return 0;
        }
        int i4 = i2 + 1;
        View childAt2 = i4 < this.d.getChildCount() ? this.d.getChildAt(i4) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i5 = (int) ((width + width2) * 0.5f * f2);
        return be3.A(this) == 0 ? left + i5 : left - i5;
    }

    private void r(g gVar, int i2) {
        gVar.q(i2);
        this.b.add(i2, gVar);
        int size = this.b.size();
        int i3 = -1;
        for (int i4 = i2 + 1; i4 < size; i4++) {
            if (((g) this.b.get(i4)).g() == this.a) {
                i3 = i4;
            }
            ((g) this.b.get(i4)).q(i4);
        }
        this.a = i3;
    }

    private static ColorStateList s(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.d.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.d.getChildAt(i3);
                if ((i3 != i2 || childAt.isSelected()) && (i3 == i2 || !childAt.isSelected())) {
                    childAt.setSelected(i3 == i2);
                    childAt.setActivated(i3 == i2);
                } else {
                    childAt.setSelected(i3 == i2);
                    childAt.setActivated(i3 == i2);
                    if (childAt instanceof TabView) {
                        ((TabView) childAt).w();
                    }
                }
                i3++;
            }
        }
    }

    private LinearLayout.LayoutParams t() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        S(layoutParams);
        return layoutParams;
    }

    private TabView v(g gVar) {
        h42 h42Var = this.e0;
        TabView tabView = h42Var != null ? (TabView) h42Var.b() : null;
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.setTab(gVar);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(gVar.d)) {
            tabView.setContentDescription(gVar.c);
        } else {
            tabView.setContentDescription(gVar.d);
        }
        return tabView;
    }

    private void w(g gVar) {
        for (int size = this.R.size() - 1; size >= 0; size--) {
            ((c) this.R.get(size)).a(gVar);
        }
    }

    private void x(g gVar) {
        for (int size = this.R.size() - 1; size >= 0; size--) {
            ((c) this.R.get(size)).b(gVar);
        }
    }

    private void y(g gVar) {
        for (int size = this.R.size() - 1; size >= 0; size--) {
            ((c) this.R.get(size)).c(gVar);
        }
    }

    private void z() {
        if (this.T == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.T = valueAnimator;
            valueAnimator.setInterpolator(this.P);
            this.T.setDuration(this.G);
            this.T.addUpdateListener(new a());
        }
    }

    public g A(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return (g) this.b.get(i2);
    }

    public boolean C() {
        return this.K;
    }

    public g D() {
        g gVarU = u();
        gVarU.h = this;
        gVarU.i = v(gVarU);
        if (gVarU.j != -1) {
            gVarU.i.setId(gVarU.j);
        }
        return gVarU;
    }

    void E() {
        int currentItem;
        G();
        androidx.viewpager.widget.a aVar = this.V;
        if (aVar != null) {
            int iD = aVar.d();
            for (int i2 = 0; i2 < iD; i2++) {
                j(D().r(this.V.f(i2)), false);
            }
            ViewPager viewPager = this.U;
            if (viewPager == null || iD <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            J(A(currentItem));
        }
    }

    protected boolean F(g gVar) {
        return g0.a(gVar);
    }

    public void G() {
        for (int childCount = this.d.getChildCount() - 1; childCount >= 0; childCount--) {
            I(childCount);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            it.remove();
            gVar.k();
            F(gVar);
        }
        this.c = null;
    }

    public void H(c cVar) {
        this.R.remove(cVar);
    }

    public void J(g gVar) {
        K(gVar, true);
    }

    public void K(g gVar, boolean z) {
        g gVar2 = this.c;
        if (gVar2 == gVar) {
            if (gVar2 != null) {
                w(gVar);
                n(gVar.g());
                return;
            }
            return;
        }
        int iG = gVar != null ? gVar.g() : -1;
        if (z) {
            if ((gVar2 == null || gVar2.g() == -1) && iG != -1) {
                M(iG, 0.0f, true);
            } else {
                n(iG);
            }
            if (iG != -1) {
                setSelectedTabView(iG);
            }
        }
        this.c = gVar;
        if (gVar2 != null && gVar2.h != null) {
            y(gVar2);
        }
        if (gVar != null) {
            x(gVar);
        }
    }

    void L(androidx.viewpager.widget.a aVar, boolean z) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.V;
        if (aVar2 != null && (dataSetObserver = this.W) != null) {
            aVar2.s(dataSetObserver);
        }
        this.V = aVar;
        if (z && aVar != null) {
            if (this.W == null) {
                this.W = new e();
            }
            aVar.k(this.W);
        }
        E();
    }

    public void M(int i2, float f2, boolean z) {
        N(i2, f2, z, true);
    }

    public void N(int i2, float f2, boolean z, boolean z2) {
        O(i2, f2, z, z2, true);
    }

    void O(int i2, float f2, boolean z, boolean z2, boolean z3) {
        int iRound = Math.round(i2 + f2);
        if (iRound < 0 || iRound >= this.d.getChildCount()) {
            return;
        }
        if (z2) {
            this.d.h(i2, f2);
        }
        ValueAnimator valueAnimator = this.T;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.T.cancel();
        }
        int iQ = q(i2, f2);
        int scrollX = getScrollX();
        boolean z4 = (i2 < getSelectedTabPosition() && iQ >= scrollX) || (i2 > getSelectedTabPosition() && iQ <= scrollX) || i2 == getSelectedTabPosition();
        if (be3.A(this) == 1) {
            z4 = (i2 < getSelectedTabPosition() && iQ <= scrollX) || (i2 > getSelectedTabPosition() && iQ >= scrollX) || i2 == getSelectedTabPosition();
        }
        if (z4 || this.d0 == 1 || z3) {
            if (i2 < 0) {
                iQ = 0;
            }
            scrollTo(iQ, 0);
        }
        if (z) {
            setSelectedTabView(iRound);
        }
    }

    public void P(ViewPager viewPager, boolean z) {
        Q(viewPager, z, false);
    }

    void T(boolean z) {
        for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
            View childAt = this.d.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            S((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    void U(int i2) {
        this.d0 = i2;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        m(view);
    }

    public void g(c cVar) {
        if (this.R.contains(cVar)) {
            return;
        }
        this.R.add(cVar);
    }

    public int getSelectedTabPosition() {
        g gVar = this.c;
        if (gVar != null) {
            return gVar.g();
        }
        return -1;
    }

    public int getTabCount() {
        return this.b.size();
    }

    public int getTabGravity() {
        return this.F;
    }

    public ColorStateList getTabIconTint() {
        return this.m;
    }

    public int getTabIndicatorAnimationMode() {
        return this.M;
    }

    public int getTabIndicatorGravity() {
        return this.H;
    }

    int getTabMaxWidth() {
        return this.v;
    }

    public int getTabMode() {
        return this.I;
    }

    public ColorStateList getTabRippleColor() {
        return this.n;
    }

    public Drawable getTabSelectedIndicator() {
        return this.o;
    }

    public ColorStateList getTabTextColors() {
        return this.l;
    }

    public void h(g gVar) {
        j(gVar, this.b.isEmpty());
    }

    public void i(g gVar, int i2, boolean z) {
        if (gVar.h != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        r(gVar, i2);
        l(gVar);
        if (z) {
            gVar.l();
        }
    }

    public void j(g gVar, boolean z) {
        i(gVar, this.b.size(), z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ug1.e(this);
        if (this.U == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                Q((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.c0) {
            setupWithViewPager(null);
            this.c0 = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
            View childAt = this.d.getChildAt(i2);
            if (childAt instanceof TabView) {
                ((TabView) childAt).j(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        m2.Q0(accessibilityNodeInfo).l0(m2.e.b(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return B() && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int iRound = Math.round(nf3.g(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(iRound + getPaddingTop() + getPaddingBottom(), 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i3) >= iRound) {
            getChildAt(0).setMinimumHeight(iRound);
        }
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0) {
            int iG = this.x;
            if (iG <= 0) {
                iG = (int) (size - nf3.g(getContext(), 56));
            }
            this.v = iG;
        }
        super.onMeasure(i2, i3);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i4 = this.I;
            if (i4 == 0) {
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                    return;
                }
            } else if (i4 != 1) {
                if (i4 != 2) {
                    return;
                }
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                    return;
                }
            } else if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || B()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        ug1.d(this, f2);
    }

    public void setInlineLabel(boolean z) {
        if (this.J != z) {
            this.J = z;
            for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
                View childAt = this.d.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).v();
                }
            }
            p();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        z();
        this.T.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable drawableMutate = dd0.r(drawable).mutate();
        this.o = drawableMutate;
        qd0.n(drawableMutate, this.p);
        int intrinsicHeight = this.L;
        if (intrinsicHeight == -1) {
            intrinsicHeight = this.o.getIntrinsicHeight();
        }
        this.d.i(intrinsicHeight);
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.p = i2;
        qd0.n(this.o, i2);
        T(false);
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.H != i2) {
            this.H = i2;
            be3.g0(this.d);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.L = i2;
        this.d.i(i2);
    }

    public void setTabGravity(int i2) {
        if (this.F != i2) {
            this.F = i2;
            p();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            R();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(v8.a(getContext(), i2));
    }

    public void setTabIndicatorAnimationMode(int i2) {
        this.M = i2;
        if (i2 == 0) {
            this.O = new com.google.android.material.tabs.c();
            return;
        }
        if (i2 == 1) {
            this.O = new com.google.android.material.tabs.a();
        } else {
            if (i2 == 2) {
                this.O = new com.google.android.material.tabs.b();
                return;
            }
            throw new IllegalArgumentException(i2 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.K = z;
        this.d.g();
        be3.g0(this.d);
    }

    public void setTabMode(int i2) {
        if (i2 != this.I) {
            this.I = i2;
            p();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
                View childAt = this.d.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).u(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(v8.a(getContext(), i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            R();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        L(aVar, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.N != z) {
            this.N = z;
            for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
                View childAt = this.d.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).u(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        P(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    protected g u() {
        g gVar = (g) g0.b();
        return gVar == null ? new g() : gVar;
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.tabStyle);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        m(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.Q;
        if (cVar2 != null) {
            H(cVar2);
        }
        this.Q = cVar;
        if (cVar != null) {
            g(cVar);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(Context context, AttributeSet attributeSet, int i2) {
        int i3 = f0;
        super(yg1.c(context, attributeSet, i2, i3), attributeSet, i2);
        this.a = -1;
        this.b = new ArrayList();
        this.k = -1;
        this.p = 0;
        this.v = Integer.MAX_VALUE;
        this.L = -1;
        this.R = new ArrayList();
        this.e0 = new i42(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        f fVar = new f(context2);
        this.d = fVar;
        super.addView(fVar, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] iArr = R$styleable.TabLayout;
        int i4 = R$styleable.TabLayout_tabTextAppearance;
        TypedArray typedArrayI = o23.i(context2, attributeSet, iArr, i2, i3, i4);
        ColorStateList colorStateListG = qd0.g(getBackground());
        if (colorStateListG != null) {
            tg1 tg1Var = new tg1();
            tg1Var.b0(colorStateListG);
            tg1Var.Q(context2);
            tg1Var.a0(be3.v(this));
            be3.t0(this, tg1Var);
        }
        setSelectedTabIndicator(sg1.e(context2, typedArrayI, R$styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(typedArrayI.getColor(R$styleable.TabLayout_tabIndicatorColor, 0));
        fVar.i(typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(typedArrayI.getInt(R$styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorAnimationMode(typedArrayI.getInt(R$styleable.TabLayout_tabIndicatorAnimationMode, 0));
        setTabIndicatorFullWidth(typedArrayI.getBoolean(R$styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabPadding, 0);
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        this.f = dimensionPixelSize;
        this.e = dimensionPixelSize;
        this.e = typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f = typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingTop, this.f);
        this.g = typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingEnd, this.g);
        this.h = typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingBottom, this.h);
        if (o23.g(context2)) {
            this.i = R$attr.textAppearanceTitleSmall;
        } else {
            this.i = R$attr.textAppearanceButton;
        }
        int resourceId = typedArrayI.getResourceId(i4, R$style.TextAppearance_Design_Tab);
        this.j = resourceId;
        int[] iArr2 = androidx.appcompat.R$styleable.TextAppearance;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, iArr2);
        try {
            int i5 = androidx.appcompat.R$styleable.TextAppearance_android_textSize;
            this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(i5, 0);
            int i6 = androidx.appcompat.R$styleable.TextAppearance_android_textColor;
            this.l = sg1.a(context2, typedArrayObtainStyledAttributes, i6);
            typedArrayObtainStyledAttributes.recycle();
            int i7 = R$styleable.TabLayout_tabSelectedTextAppearance;
            if (typedArrayI.hasValue(i7)) {
                this.k = typedArrayI.getResourceId(i7, resourceId);
            }
            int i8 = this.k;
            if (i8 != -1) {
                TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(i8, iArr2);
                try {
                    this.s = typedArrayObtainStyledAttributes2.getDimensionPixelSize(i5, (int) this.r);
                    ColorStateList colorStateListA = sg1.a(context2, typedArrayObtainStyledAttributes2, i6);
                    if (colorStateListA != null) {
                        this.l = s(this.l.getDefaultColor(), colorStateListA.getColorForState(new int[]{R.attr.state_selected}, colorStateListA.getDefaultColor()));
                    }
                    typedArrayObtainStyledAttributes2.recycle();
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes2.recycle();
                    throw th;
                }
            }
            int i9 = R$styleable.TabLayout_tabTextColor;
            if (typedArrayI.hasValue(i9)) {
                this.l = sg1.a(context2, typedArrayI, i9);
            }
            int i10 = R$styleable.TabLayout_tabSelectedTextColor;
            if (typedArrayI.hasValue(i10)) {
                this.l = s(this.l.getDefaultColor(), typedArrayI.getColor(i10, 0));
            }
            this.m = sg1.a(context2, typedArrayI, R$styleable.TabLayout_tabIconTint);
            this.f270q = nf3.q(typedArrayI.getInt(R$styleable.TabLayout_tabIconTintMode, -1), null);
            this.n = sg1.a(context2, typedArrayI, R$styleable.TabLayout_tabRippleColor);
            this.G = typedArrayI.getInt(R$styleable.TabLayout_tabIndicatorAnimationDuration, ChartCoordinateportAnimator.FAST_ANIMATION_DURATION);
            this.P = el1.g(context2, R$attr.motionEasingEmphasizedInterpolator, y6.b);
            this.w = typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabMinWidth, -1);
            this.x = typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabMaxWidth, -1);
            this.u = typedArrayI.getResourceId(R$styleable.TabLayout_tabBackground, 0);
            this.z = typedArrayI.getDimensionPixelSize(R$styleable.TabLayout_tabContentStart, 0);
            this.I = typedArrayI.getInt(R$styleable.TabLayout_tabMode, 1);
            this.F = typedArrayI.getInt(R$styleable.TabLayout_tabGravity, 0);
            this.J = typedArrayI.getBoolean(R$styleable.TabLayout_tabInlineLabel, false);
            this.N = typedArrayI.getBoolean(R$styleable.TabLayout_tabUnboundedRipple, false);
            typedArrayI.recycle();
            Resources resources = getResources();
            this.t = resources.getDimensionPixelSize(R$dimen.design_tab_text_size_2line);
            this.y = resources.getDimensionPixelSize(R$dimen.design_tab_scrollable_min_width);
            p();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        m(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        m(view);
    }

    public void setSelectedTabIndicator(int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(v8.b(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
