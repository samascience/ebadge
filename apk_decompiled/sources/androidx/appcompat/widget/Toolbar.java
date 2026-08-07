package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.customview.view.AbsSavedState;
import defpackage.be3;
import defpackage.bz;
import defpackage.g43;
import defpackage.iv0;
import defpackage.li1;
import defpackage.mw2;
import defpackage.oi1;
import defpackage.s70;
import defpackage.si1;
import defpackage.v8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup implements li1 {
    private ColorStateList F;
    private boolean G;
    private boolean H;
    private final ArrayList I;
    private final ArrayList J;
    private final int[] K;
    final oi1 L;
    private ArrayList M;
    h N;
    private final ActionMenuView.e O;
    private f0 P;
    private ActionMenuPresenter Q;
    private f R;
    private androidx.appcompat.view.menu.j.a S;
    androidx.appcompat.view.menu.e.a T;
    private boolean U;
    private OnBackInvokedCallback V;
    private OnBackInvokedDispatcher W;
    ActionMenuView a;
    private boolean a0;
    private TextView b;
    private final Runnable b0;
    private TextView c;
    private ImageButton d;
    private ImageView e;
    private Drawable f;
    private CharSequence g;
    ImageButton h;
    View i;
    private Context j;
    private int k;
    private int l;
    private int m;
    int n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f143q;
    private int r;
    private int s;
    private y t;
    private int u;
    private int v;
    private int w;
    private CharSequence x;
    private CharSequence y;
    private ColorStateList z;

    class a implements ActionMenuView.e {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.L.j(menuItem)) {
                return true;
            }
            h hVar = Toolbar.this.N;
            if (hVar != null) {
                return hVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.Q();
        }
    }

    class c implements androidx.appcompat.view.menu.e.a {
        c() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            androidx.appcompat.view.menu.e.a aVar = Toolbar.this.T;
            return aVar != null && aVar.a(eVar, menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (!Toolbar.this.a.G()) {
                Toolbar.this.L.k(eVar);
            }
            androidx.appcompat.view.menu.e.a aVar = Toolbar.this.T;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    static class e {
        static OnBackInvokedDispatcher a(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback b(final Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new OnBackInvokedCallback() { // from class: d43
                public final void onBackInvoked() {
                    runnable.run();
                }
            };
        }

        static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        static void d(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    private class f implements androidx.appcompat.view.menu.j {
        androidx.appcompat.view.menu.e a;
        androidx.appcompat.view.menu.g b;

        f() {
        }

        @Override // androidx.appcompat.view.menu.j
        public void c(androidx.appcompat.view.menu.e eVar, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.j
        public void d(boolean z) {
            if (this.b != null) {
                androidx.appcompat.view.menu.e eVar = this.a;
                if (eVar != null) {
                    int size = eVar.size();
                    for (int i = 0; i < size; i++) {
                        if (this.a.getItem(i) == this.b) {
                            return;
                        }
                    }
                }
                f(this.a, this.b);
            }
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean e() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean f(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            KeyEvent.Callback callback = Toolbar.this.i;
            if (callback instanceof bz) {
                ((bz) callback).c();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.i = null;
            toolbar3.a();
            this.b = null;
            Toolbar.this.requestLayout();
            gVar.r(false);
            Toolbar.this.R();
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean g(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.h);
            }
            Toolbar.this.i = gVar.getActionView();
            this.b = gVar;
            ViewParent parent2 = Toolbar.this.i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.i);
                }
                g gVarGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                gVarGenerateDefaultLayoutParams.a = (toolbar4.n & 112) | 8388611;
                gVarGenerateDefaultLayoutParams.b = 2;
                toolbar4.i.setLayoutParams(gVarGenerateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.i);
            }
            Toolbar.this.I();
            Toolbar.this.requestLayout();
            gVar.r(true);
            KeyEvent.Callback callback = Toolbar.this.i;
            if (callback instanceof bz) {
                ((bz) callback).b();
            }
            Toolbar.this.R();
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.j
        public void i(Context context, androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.a;
            if (eVar2 != null && (gVar = this.b) != null) {
                eVar2.f(gVar);
            }
            this.a = eVar;
        }

        @Override // androidx.appcompat.view.menu.j
        public void j(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean l(androidx.appcompat.view.menu.m mVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public Parcelable m() {
            return null;
        }
    }

    public interface h {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    private int C(View view, int i, int[] iArr, int i2) {
        g gVar = (g) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - iArr[0];
        int iMax = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int iQ = q(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iQ, iMax + measuredWidth, view.getMeasuredHeight() + iQ);
        return iMax + measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).rightMargin;
    }

    private int D(View view, int i, int[] iArr, int i2) {
        g gVar = (g) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - iArr[1];
        int iMax = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int iQ = q(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iQ, iMax, view.getMeasuredHeight() + iQ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) gVar).leftMargin);
    }

    private int E(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + iMax + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private void F(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void G() {
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.L.h(menu, getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.M = currentMenuItems2;
    }

    private void H() {
        removeCallbacks(this.b0);
        post(this.b0);
    }

    private boolean O() {
        if (!this.U) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (P(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean P(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List list, int i) {
        boolean z = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int iB = iv0.b(i, getLayoutDirection());
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.b == 0 && P(childAt) && p(gVar.a) == iB) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            g gVar2 = (g) childAt2.getLayoutParams();
            if (gVar2.b == 0 && P(childAt2) && p(gVar2.a) == iB) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z) {
        g gVarGenerateLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            gVarGenerateLayoutParams = generateDefaultLayoutParams();
        } else {
            gVarGenerateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (g) layoutParams;
        }
        gVarGenerateLayoutParams.b = 1;
        if (!z || this.i == null) {
            addView(view, gVarGenerateLayoutParams);
        } else {
            view.setLayoutParams(gVarGenerateLayoutParams);
            this.J.add(view);
        }
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new mw2(getContext());
    }

    private void h() {
        if (this.t == null) {
            this.t = new y();
        }
    }

    private void i() {
        if (this.e == null) {
            this.e = new AppCompatImageView(getContext());
        }
    }

    private void j() {
        k();
        if (this.a.K() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.a.getMenu();
            if (this.R == null) {
                this.R = new f();
            }
            this.a.setExpandedActionViewsExclusive(true);
            eVar.c(this.R, this.j);
            R();
        }
    }

    private void k() {
        if (this.a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.a = actionMenuView;
            actionMenuView.setPopupTheme(this.k);
            this.a.setOnMenuItemClickListener(this.O);
            this.a.L(this.S, new c());
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.a = (this.n & 112) | 8388613;
            this.a.setLayoutParams(gVarGenerateDefaultLayoutParams);
            c(this.a, false);
        }
    }

    private void l() {
        if (this.d == null) {
            this.d = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.a = (this.n & 112) | 8388611;
            this.d.setLayoutParams(gVarGenerateDefaultLayoutParams);
        }
    }

    private int p(int i) {
        int layoutDirection = getLayoutDirection();
        int iB = iv0.b(i, layoutDirection) & 7;
        if (iB == 1 || iB == 3 || iB == 5) {
            return iB;
        }
        return layoutDirection == 1 ? 5 : 3;
    }

    private int q(View view, int i) {
        g gVar = (g) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int iR = r(gVar.a);
        if (iR == 48) {
            return getPaddingTop() - i2;
        }
        if (iR == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i3 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
        if (iMax < i3) {
            iMax = i3;
        } else {
            int i4 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i5 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
            if (i4 < i5) {
                iMax = Math.max(0, iMax - (i5 - i4));
            }
        }
        return paddingTop + iMax;
    }

    private int r(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.w & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int measuredWidth = 0;
        while (i3 < size) {
            View view = (View) list.get(i3);
            g gVar = (g) view.getLayoutParams();
            int i4 = ((ViewGroup.MarginLayoutParams) gVar).leftMargin - i;
            int i5 = ((ViewGroup.MarginLayoutParams) gVar).rightMargin - i2;
            int iMax = Math.max(0, i4);
            int iMax2 = Math.max(0, i5);
            int iMax3 = Math.max(0, -i4);
            int iMax4 = Math.max(0, -i5);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i3++;
            i2 = iMax4;
            i = iMax3;
        }
        return measuredWidth;
    }

    private boolean z(View view) {
        return view.getParent() == this || this.J.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.F();
    }

    public boolean B() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.G();
    }

    void I() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((g) childAt.getLayoutParams()).b != 2 && childAt != this.a) {
                removeViewAt(childCount);
                this.J.add(childAt);
            }
        }
    }

    public void J(int i, int i2) {
        h();
        this.t.g(i, i2);
    }

    public void K(androidx.appcompat.view.menu.e eVar, ActionMenuPresenter actionMenuPresenter) {
        if (eVar == null && this.a == null) {
            return;
        }
        k();
        androidx.appcompat.view.menu.e eVarK = this.a.K();
        if (eVarK == eVar) {
            return;
        }
        if (eVarK != null) {
            eVarK.R(this.Q);
            eVarK.R(this.R);
        }
        if (this.R == null) {
            this.R = new f();
        }
        actionMenuPresenter.J(true);
        if (eVar != null) {
            eVar.c(actionMenuPresenter, this.j);
            eVar.c(this.R, this.j);
        } else {
            actionMenuPresenter.i(this.j, null);
            this.R.i(this.j, null);
            actionMenuPresenter.d(true);
            this.R.d(true);
        }
        this.a.setPopupTheme(this.k);
        this.a.setPresenter(actionMenuPresenter);
        this.Q = actionMenuPresenter;
        R();
    }

    public void L(androidx.appcompat.view.menu.j.a aVar, androidx.appcompat.view.menu.e.a aVar2) {
        this.S = aVar;
        this.T = aVar2;
        ActionMenuView actionMenuView = this.a;
        if (actionMenuView != null) {
            actionMenuView.L(aVar, aVar2);
        }
    }

    public void M(Context context, int i) {
        this.m = i;
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void N(Context context, int i) {
        this.l = i;
        TextView textView = this.b;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public boolean Q() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.M();
    }

    void R() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = e.a(this);
            boolean z = v() && onBackInvokedDispatcherA != null && isAttachedToWindow() && this.a0;
            if (z && this.W == null) {
                if (this.V == null) {
                    this.V = e.b(new Runnable() { // from class: b43
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.e();
                        }
                    });
                }
                e.c(onBackInvokedDispatcherA, this.V);
                this.W = onBackInvokedDispatcherA;
                return;
            }
            if (z || (onBackInvokedDispatcher = this.W) == null) {
                return;
            }
            e.d(onBackInvokedDispatcher, this.V);
            this.W = null;
        }
    }

    void a() {
        for (int size = this.J.size() - 1; size >= 0; size--) {
            addView((View) this.J.get(size));
        }
        this.J.clear();
    }

    @Override // defpackage.li1
    public void addMenuProvider(si1 si1Var) {
        this.L.c(si1Var);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof g);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.a) != null && actionMenuView.H();
    }

    public void e() {
        f fVar = this.R;
        androidx.appcompat.view.menu.g gVar = fVar == null ? null : fVar.b;
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.a;
        if (actionMenuView != null) {
            actionMenuView.y();
        }
    }

    void g() {
        if (this.h == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            this.h = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f);
            this.h.setContentDescription(this.g);
            g gVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            gVarGenerateDefaultLayoutParams.a = (this.n & 112) | 8388611;
            gVarGenerateDefaultLayoutParams.b = 2;
            this.h.setLayoutParams(gVarGenerateDefaultLayoutParams);
            this.h.setOnClickListener(new d());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        y yVar = this.t;
        if (yVar != null) {
            return yVar.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.v;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        y yVar = this.t;
        if (yVar != null) {
            return yVar.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        y yVar = this.t;
        if (yVar != null) {
            return yVar.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        y yVar = this.t;
        if (yVar != null) {
            return yVar.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.u;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.e eVarK;
        ActionMenuView actionMenuView = this.a;
        return (actionMenuView == null || (eVarK = actionMenuView.K()) == null || !eVarK.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.a.getMenu();
    }

    View getNavButtonView() {
        return this.d;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.Q;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.a.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.j;
    }

    public int getPopupTheme() {
        return this.k;
    }

    public CharSequence getSubtitle() {
        return this.y;
    }

    final TextView getSubtitleTextView() {
        return this.c;
    }

    public CharSequence getTitle() {
        return this.x;
    }

    public int getTitleMarginBottom() {
        return this.s;
    }

    public int getTitleMarginEnd() {
        return this.f143q;
    }

    public int getTitleMarginStart() {
        return this.p;
    }

    public int getTitleMarginTop() {
        return this.r;
    }

    final TextView getTitleTextView() {
        return this.b;
    }

    public s70 getWrapper() {
        if (this.P == null) {
            this.P = new f0(this, true);
        }
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public g generateDefaultLayoutParams() {
        return new g(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public g generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof g) {
            return new g((g) layoutParams);
        }
        if (layoutParams instanceof androidx.appcompat.app.a.C0002a) {
            return new g((androidx.appcompat.app.a.C0002a) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        R();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.b0);
        R();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.H = false;
        }
        if (!this.H) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.H = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.H = false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0268  */
    /* JADX WARN: Code duplicated, block: B:102:0x028a  */
    /* JADX WARN: Code duplicated, block: B:104:0x028d  */
    /* JADX WARN: Code duplicated, block: B:107:0x02a1 A[LOOP:0: B:106:0x029f->B:107:0x02a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:110:0x02c3 A[LOOP:1: B:109:0x02c1->B:110:0x02c3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:114:0x02ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:116:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:119:0x02fc A[LOOP:2: B:118:0x02fa->B:119:0x02fc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:19:0x0060 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0062  */
    /* JADX WARN: Code duplicated, block: B:21:0x0069  */
    /* JADX WARN: Code duplicated, block: B:24:0x0077 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0079  */
    /* JADX WARN: Code duplicated, block: B:26:0x0080  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:42:0x0104  */
    /* JADX WARN: Code duplicated, block: B:43:0x011c  */
    /* JADX WARN: Code duplicated, block: B:49:0x012a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x012c  */
    /* JADX WARN: Code duplicated, block: B:51:0x012f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0133  */
    /* JADX WARN: Code duplicated, block: B:54:0x0136  */
    /* JADX WARN: Code duplicated, block: B:57:0x0146  */
    /* JADX WARN: Code duplicated, block: B:59:0x014e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x0167  */
    /* JADX WARN: Code duplicated, block: B:68:0x016b  */
    /* JADX WARN: Code duplicated, block: B:70:0x017d  */
    /* JADX WARN: Code duplicated, block: B:71:0x0180  */
    /* JADX WARN: Code duplicated, block: B:73:0x018b  */
    /* JADX WARN: Code duplicated, block: B:75:0x0197  */
    /* JADX WARN: Code duplicated, block: B:76:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:81:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:84:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:85:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:87:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:88:0x021b  */
    /* JADX WARN: Code duplicated, block: B:90:0x021e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0227 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x0229  */
    /* JADX WARN: Code duplicated, block: B:95:0x022e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0242  */
    /* JADX WARN: Code duplicated, block: B:99:0x0265  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iC;
        int iD;
        int iMax;
        int iMin;
        boolean zP;
        boolean zP2;
        int measuredHeight;
        TextView textView;
        TextView textView2;
        g gVar;
        g gVar2;
        boolean z2;
        int i5;
        int i6;
        int paddingTop;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int iMax2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int size;
        int iC2;
        int i19;
        int i20;
        int size2;
        int i21;
        int i22;
        int i23;
        int size3;
        boolean z3 = getLayoutDirection() == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i24 = width - paddingRight;
        int[] iArr = this.K;
        iArr[1] = 0;
        iArr[0] = 0;
        int iB = be3.B(this);
        int iMin2 = iB >= 0 ? Math.min(iB, i4 - i2) : 0;
        if (P(this.d)) {
            if (z3) {
                iD = D(this.d, i24, iArr, iMin2);
                iC = paddingLeft;
            } else {
                iC = C(this.d, paddingLeft, iArr, iMin2);
            }
            if (P(this.h)) {
                if (z3) {
                    iD = D(this.h, iD, iArr, iMin2);
                } else {
                    iC = C(this.h, iC, iArr, iMin2);
                }
            }
            if (P(this.a)) {
                if (z3) {
                    iC = C(this.a, iC, iArr, iMin2);
                } else {
                    iD = D(this.a, iD, iArr, iMin2);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - iC);
            iArr[1] = Math.max(0, currentContentInsetRight - (i24 - iD));
            iMax = Math.max(iC, currentContentInsetLeft);
            iMin = Math.min(iD, i24 - currentContentInsetRight);
            if (P(this.i)) {
                if (z3) {
                    iMin = D(this.i, iMin, iArr, iMin2);
                } else {
                    iMax = C(this.i, iMax, iArr, iMin2);
                }
            }
            if (P(this.e)) {
                if (z3) {
                    iMin = D(this.e, iMin, iArr, iMin2);
                } else {
                    iMax = C(this.e, iMax, iArr, iMin2);
                }
            }
            zP = P(this.b);
            zP2 = P(this.c);
            if (zP) {
                g gVar3 = (g) this.b.getLayoutParams();
                measuredHeight = ((ViewGroup.MarginLayoutParams) gVar3).topMargin + this.b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gVar3).bottomMargin;
            } else {
                measuredHeight = 0;
            }
            if (zP2) {
                g gVar4 = (g) this.c.getLayoutParams();
                measuredHeight += ((ViewGroup.MarginLayoutParams) gVar4).topMargin + this.c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gVar4).bottomMargin;
            }
            if (!zP || zP2) {
                if (zP) {
                    textView = this.b;
                } else {
                    textView = this.c;
                }
                if (zP2) {
                    textView2 = this.c;
                } else {
                    textView2 = this.b;
                }
                gVar = (g) textView.getLayoutParams();
                gVar2 = (g) textView2.getLayoutParams();
                z2 = (!zP && this.b.getMeasuredWidth() > 0) || (zP2 && this.c.getMeasuredWidth() > 0);
                i5 = this.w & 112;
                i6 = paddingLeft;
                if (i5 == 48) {
                    paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) gVar).topMargin + this.r;
                } else if (i5 != 80) {
                    iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    i14 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
                    i15 = this.r;
                    if (iMax2 < i14 + i15) {
                        iMax2 = i14 + i15;
                    } else {
                        i16 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                        i17 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
                        i18 = this.s;
                        if (i16 < i17 + i18) {
                            iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) gVar2).bottomMargin + i18) - i16));
                        }
                    }
                    paddingTop = paddingTop2 + iMax2;
                } else {
                    paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) gVar2).bottomMargin) - this.s) - measuredHeight;
                }
                if (z3) {
                    if (z2) {
                        i11 = this.p;
                    } else {
                        i11 = 0;
                    }
                    int i25 = i11 - iArr[1];
                    iMin -= Math.max(0, i25);
                    iArr[1] = Math.max(0, -i25);
                    if (zP) {
                        g gVar5 = (g) this.b.getLayoutParams();
                        int measuredWidth = iMin - this.b.getMeasuredWidth();
                        int measuredHeight2 = this.b.getMeasuredHeight() + paddingTop;
                        this.b.layout(measuredWidth, paddingTop, iMin, measuredHeight2);
                        i12 = measuredWidth - this.f143q;
                        paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) gVar5).bottomMargin;
                    } else {
                        i12 = iMin;
                    }
                    if (zP2) {
                        int i26 = paddingTop + ((ViewGroup.MarginLayoutParams) ((g) this.c.getLayoutParams())).topMargin;
                        this.c.layout(iMin - this.c.getMeasuredWidth(), i26, iMin, this.c.getMeasuredHeight() + i26);
                        i13 = iMin - this.f143q;
                    } else {
                        i13 = iMin;
                    }
                    if (z2) {
                        iMin = Math.min(i12, i13);
                    }
                    iMax = iMax;
                } else {
                    if (z2) {
                        i7 = this.p;
                    } else {
                        i7 = 0;
                    }
                    i8 = 0;
                    int i27 = i7 - iArr[0];
                    iMax += Math.max(0, i27);
                    iArr[0] = Math.max(0, -i27);
                    if (zP) {
                        g gVar6 = (g) this.b.getLayoutParams();
                        int measuredWidth2 = this.b.getMeasuredWidth() + iMax;
                        int measuredHeight3 = this.b.getMeasuredHeight() + paddingTop;
                        this.b.layout(iMax, paddingTop, measuredWidth2, measuredHeight3);
                        i9 = measuredWidth2 + this.f143q;
                        paddingTop = measuredHeight3 + ((ViewGroup.MarginLayoutParams) gVar6).bottomMargin;
                    } else {
                        i9 = iMax;
                    }
                    if (zP2) {
                        int i28 = paddingTop + ((ViewGroup.MarginLayoutParams) ((g) this.c.getLayoutParams())).topMargin;
                        int measuredWidth3 = this.c.getMeasuredWidth() + iMax;
                        this.c.layout(iMax, i28, measuredWidth3, this.c.getMeasuredHeight() + i28);
                        i10 = measuredWidth3 + this.f143q;
                    } else {
                        i10 = iMax;
                    }
                    if (z2) {
                        iMax = Math.max(i9, i10);
                    }
                }
                b(this.I, 3);
                size = this.I.size();
                iC2 = iMax;
                for (i19 = i8; i19 < size; i19++) {
                    iC2 = C((View) this.I.get(i19), iC2, iArr, iMin2);
                }
                i20 = iMin2;
                b(this.I, 5);
                size2 = this.I.size();
                for (i21 = i8; i21 < size2; i21++) {
                    iMin = D((View) this.I.get(i21), iMin, iArr, i20);
                }
                b(this.I, 1);
                int iU = u(this.I, iArr);
                i22 = (i6 + (((width - i6) - paddingRight) / 2)) - (iU / 2);
                i23 = iU + i22;
                if (i22 >= iC2) {
                    if (i23 > iMin) {
                        iC2 = i22 - (i23 - iMin);
                    } else {
                        iC2 = i22;
                    }
                }
                size3 = this.I.size();
                while (i8 < size3) {
                    iC2 = C((View) this.I.get(i8), iC2, iArr, i20);
                    i8++;
                }
                this.I.clear();
            }
            i6 = paddingLeft;
            iMin2 = iMin2;
            i8 = 0;
            b(this.I, 3);
            size = this.I.size();
            iC2 = iMax;
            while (i19 < size) {
                iC2 = C((View) this.I.get(i19), iC2, iArr, iMin2);
            }
            i20 = iMin2;
            b(this.I, 5);
            size2 = this.I.size();
            while (i21 < size2) {
                iMin = D((View) this.I.get(i21), iMin, iArr, i20);
            }
            b(this.I, 1);
            int iU2 = u(this.I, iArr);
            i22 = (i6 + (((width - i6) - paddingRight) / 2)) - (iU2 / 2);
            i23 = iU2 + i22;
            if (i22 >= iC2) {
                if (i23 > iMin) {
                    iC2 = i22 - (i23 - iMin);
                } else {
                    iC2 = i22;
                }
            }
            size3 = this.I.size();
            while (i8 < size3) {
                iC2 = C((View) this.I.get(i8), iC2, iArr, i20);
                i8++;
            }
            this.I.clear();
        }
        iC = paddingLeft;
        iD = i24;
        if (P(this.h)) {
            if (z3) {
                iD = D(this.h, iD, iArr, iMin2);
            } else {
                iC = C(this.h, iC, iArr, iMin2);
            }
        }
        if (P(this.a)) {
            if (z3) {
                iC = C(this.a, iC, iArr, iMin2);
            } else {
                iD = D(this.a, iD, iArr, iMin2);
            }
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - iC);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i24 - iD));
        iMax = Math.max(iC, currentContentInsetLeft2);
        iMin = Math.min(iD, i24 - currentContentInsetRight2);
        if (P(this.i)) {
            if (z3) {
                iMin = D(this.i, iMin, iArr, iMin2);
            } else {
                iMax = C(this.i, iMax, iArr, iMin2);
            }
        }
        if (P(this.e)) {
            if (z3) {
                iMin = D(this.e, iMin, iArr, iMin2);
            } else {
                iMax = C(this.e, iMax, iArr, iMin2);
            }
        }
        zP = P(this.b);
        zP2 = P(this.c);
        if (zP) {
            g gVar7 = (g) this.b.getLayoutParams();
            measuredHeight = ((ViewGroup.MarginLayoutParams) gVar7).topMargin + this.b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gVar7).bottomMargin;
        } else {
            measuredHeight = 0;
        }
        if (zP2) {
            g gVar8 = (g) this.c.getLayoutParams();
            measuredHeight += ((ViewGroup.MarginLayoutParams) gVar8).topMargin + this.c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gVar8).bottomMargin;
        }
        if (zP) {
            if (zP) {
                textView = this.b;
            } else {
                textView = this.c;
            }
            if (zP2) {
                textView2 = this.c;
            } else {
                textView2 = this.b;
            }
            gVar = (g) textView.getLayoutParams();
            gVar2 = (g) textView2.getLayoutParams();
            if (zP) {
            }
            i5 = this.w & 112;
            i6 = paddingLeft;
            if (i5 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) gVar).topMargin + this.r;
            } else if (i5 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                i14 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
                i15 = this.r;
                if (iMax2 < i14 + i15) {
                    iMax2 = i14 + i15;
                } else {
                    i16 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                    i17 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
                    i18 = this.s;
                    if (i16 < i17 + i18) {
                        iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) gVar2).bottomMargin + i18) - i16));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) gVar2).bottomMargin) - this.s) - measuredHeight;
            }
            if (z3) {
                if (z2) {
                    i11 = this.p;
                } else {
                    i11 = 0;
                }
                int i29 = i11 - iArr[1];
                iMin -= Math.max(0, i29);
                iArr[1] = Math.max(0, -i29);
                if (zP) {
                    g gVar9 = (g) this.b.getLayoutParams();
                    int measuredWidth4 = iMin - this.b.getMeasuredWidth();
                    int measuredHeight4 = this.b.getMeasuredHeight() + paddingTop;
                    this.b.layout(measuredWidth4, paddingTop, iMin, measuredHeight4);
                    i12 = measuredWidth4 - this.f143q;
                    paddingTop = measuredHeight4 + ((ViewGroup.MarginLayoutParams) gVar9).bottomMargin;
                } else {
                    i12 = iMin;
                }
                if (zP2) {
                    int i210 = paddingTop + ((ViewGroup.MarginLayoutParams) ((g) this.c.getLayoutParams())).topMargin;
                    this.c.layout(iMin - this.c.getMeasuredWidth(), i210, iMin, this.c.getMeasuredHeight() + i210);
                    i13 = iMin - this.f143q;
                } else {
                    i13 = iMin;
                }
                if (z2) {
                    iMin = Math.min(i12, i13);
                }
                iMax = iMax;
                i8 = 0;
            } else {
                if (z2) {
                    i7 = this.p;
                } else {
                    i7 = 0;
                }
                i8 = 0;
                int i211 = i7 - iArr[0];
                iMax += Math.max(0, i211);
                iArr[0] = Math.max(0, -i211);
                if (zP) {
                    g gVar10 = (g) this.b.getLayoutParams();
                    int measuredWidth5 = this.b.getMeasuredWidth() + iMax;
                    int measuredHeight5 = this.b.getMeasuredHeight() + paddingTop;
                    this.b.layout(iMax, paddingTop, measuredWidth5, measuredHeight5);
                    i9 = measuredWidth5 + this.f143q;
                    paddingTop = measuredHeight5 + ((ViewGroup.MarginLayoutParams) gVar10).bottomMargin;
                } else {
                    i9 = iMax;
                }
                if (zP2) {
                    int i212 = paddingTop + ((ViewGroup.MarginLayoutParams) ((g) this.c.getLayoutParams())).topMargin;
                    int measuredWidth6 = this.c.getMeasuredWidth() + iMax;
                    this.c.layout(iMax, i212, measuredWidth6, this.c.getMeasuredHeight() + i212);
                    i10 = measuredWidth6 + this.f143q;
                } else {
                    i10 = iMax;
                }
                if (z2) {
                    iMax = Math.max(i9, i10);
                }
            }
        } else {
            if (zP) {
                textView = this.b;
            } else {
                textView = this.c;
            }
            if (zP2) {
                textView2 = this.c;
            } else {
                textView2 = this.b;
            }
            gVar = (g) textView.getLayoutParams();
            gVar2 = (g) textView2.getLayoutParams();
            if (zP) {
            }
            i5 = this.w & 112;
            i6 = paddingLeft;
            if (i5 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) gVar).topMargin + this.r;
            } else if (i5 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                i14 = ((ViewGroup.MarginLayoutParams) gVar).topMargin;
                i15 = this.r;
                if (iMax2 < i14 + i15) {
                    iMax2 = i14 + i15;
                } else {
                    i16 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                    i17 = ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
                    i18 = this.s;
                    if (i16 < i17 + i18) {
                        iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) gVar2).bottomMargin + i18) - i16));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) gVar2).bottomMargin) - this.s) - measuredHeight;
            }
            if (z3) {
                if (z2) {
                    i11 = this.p;
                } else {
                    i11 = 0;
                }
                int i213 = i11 - iArr[1];
                iMin -= Math.max(0, i213);
                iArr[1] = Math.max(0, -i213);
                if (zP) {
                    g gVar11 = (g) this.b.getLayoutParams();
                    int measuredWidth7 = iMin - this.b.getMeasuredWidth();
                    int measuredHeight6 = this.b.getMeasuredHeight() + paddingTop;
                    this.b.layout(measuredWidth7, paddingTop, iMin, measuredHeight6);
                    i12 = measuredWidth7 - this.f143q;
                    paddingTop = measuredHeight6 + ((ViewGroup.MarginLayoutParams) gVar11).bottomMargin;
                } else {
                    i12 = iMin;
                }
                if (zP2) {
                    int i214 = paddingTop + ((ViewGroup.MarginLayoutParams) ((g) this.c.getLayoutParams())).topMargin;
                    this.c.layout(iMin - this.c.getMeasuredWidth(), i214, iMin, this.c.getMeasuredHeight() + i214);
                    i13 = iMin - this.f143q;
                } else {
                    i13 = iMin;
                }
                if (z2) {
                    iMin = Math.min(i12, i13);
                }
                iMax = iMax;
                i8 = 0;
            } else {
                if (z2) {
                    i7 = this.p;
                } else {
                    i7 = 0;
                }
                i8 = 0;
                int i215 = i7 - iArr[0];
                iMax += Math.max(0, i215);
                iArr[0] = Math.max(0, -i215);
                if (zP) {
                    g gVar12 = (g) this.b.getLayoutParams();
                    int measuredWidth8 = this.b.getMeasuredWidth() + iMax;
                    int measuredHeight7 = this.b.getMeasuredHeight() + paddingTop;
                    this.b.layout(iMax, paddingTop, measuredWidth8, measuredHeight7);
                    i9 = measuredWidth8 + this.f143q;
                    paddingTop = measuredHeight7 + ((ViewGroup.MarginLayoutParams) gVar12).bottomMargin;
                } else {
                    i9 = iMax;
                }
                if (zP2) {
                    int i216 = paddingTop + ((ViewGroup.MarginLayoutParams) ((g) this.c.getLayoutParams())).topMargin;
                    int measuredWidth9 = this.c.getMeasuredWidth() + iMax;
                    this.c.layout(iMax, i216, measuredWidth9, this.c.getMeasuredHeight() + i216);
                    i10 = measuredWidth9 + this.f143q;
                } else {
                    i10 = iMax;
                }
                if (z2) {
                    iMax = Math.max(i9, i10);
                }
            }
        }
        b(this.I, 3);
        size = this.I.size();
        iC2 = iMax;
        while (i19 < size) {
            iC2 = C((View) this.I.get(i19), iC2, iArr, iMin2);
        }
        i20 = iMin2;
        b(this.I, 5);
        size2 = this.I.size();
        while (i21 < size2) {
            iMin = D((View) this.I.get(i21), iMin, iArr, i20);
        }
        b(this.I, 1);
        int iU3 = u(this.I, iArr);
        i22 = (i6 + (((width - i6) - paddingRight) / 2)) - (iU3 / 2);
        i23 = iU3 + i22;
        if (i22 >= iC2) {
            if (i23 > iMin) {
                iC2 = i22 - (i23 - iMin);
            } else {
                iC2 = i22;
            }
        }
        size3 = this.I.size();
        while (i8 < size3) {
            iC2 = C((View) this.I.get(i8), iC2, iArr, i20);
            i8++;
        }
        this.I.clear();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int measuredHeight;
        int iCombineMeasuredStates2;
        int iMax2;
        int[] iArr = this.K;
        boolean zB = h0.b(this);
        int i3 = !zB ? 1 : 0;
        if (P(this.d)) {
            F(this.d, i, 0, i2, 0, this.o);
            measuredWidth = this.d.getMeasuredWidth() + s(this.d);
            iMax = Math.max(0, this.d.getMeasuredHeight() + t(this.d));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.d.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (P(this.h)) {
            F(this.h, i, 0, i2, 0, this.o);
            measuredWidth = this.h.getMeasuredWidth() + s(this.h);
            iMax = Math.max(iMax, this.h.getMeasuredHeight() + t(this.h));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth);
        iArr[zB ? 1 : 0] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (P(this.a)) {
            F(this.a, i, iMax3, i2, 0, this.o);
            measuredWidth2 = this.a.getMeasuredWidth() + s(this.a);
            iMax = Math.max(iMax, this.a.getMeasuredHeight() + t(this.a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.a.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[i3] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (P(this.i)) {
            iMax4 += E(this.i, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.i.getMeasuredHeight() + t(this.i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.i.getMeasuredState());
        }
        if (P(this.e)) {
            iMax4 += E(this.e, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.e.getMeasuredHeight() + t(this.e));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (((g) childAt.getLayoutParams()).b == 0 && P(childAt)) {
                iMax4 += E(childAt, i, iMax4, i2, 0, iArr);
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + t(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i5 = this.r + this.s;
        int i6 = this.p + this.f143q;
        if (P(this.b)) {
            E(this.b, i, iMax4 + i6, i2, i5, iArr);
            int measuredWidth3 = this.b.getMeasuredWidth() + s(this.b);
            measuredHeight = this.b.getMeasuredHeight() + t(this.b);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.b.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            measuredHeight = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (P(this.c)) {
            iMax2 = Math.max(iMax2, E(this.c, i, iMax4 + i6, i2, measuredHeight + i5, iArr));
            measuredHeight += this.c.getMeasuredHeight() + t(this.c);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.c.getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax4 + iMax2 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2), O() ? 0 : View.resolveSizeAndState(Math.max(Math.max(iMax, measuredHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.a;
        androidx.appcompat.view.menu.e eVarK = actionMenuView != null ? actionMenuView.K() : null;
        int i = savedState.a;
        if (i != 0 && this.R != null && eVarK != null && (menuItemFindItem = eVarK.findItem(i)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.b) {
            H();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        h();
        this.t.f(i == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        androidx.appcompat.view.menu.g gVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        f fVar = this.R;
        if (fVar != null && (gVar = fVar.b) != null) {
            savedState.a = gVar.getItemId();
        }
        savedState.b = B();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.G = false;
        }
        if (!this.G) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.G = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.G = false;
        }
        return true;
    }

    @Override // defpackage.li1
    public void removeMenuProvider(si1 si1Var) {
        this.L.l(si1Var);
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.a0 != z) {
            this.a0 = z;
            R();
        }
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(v8.b(getContext(), i));
    }

    public void setCollapsible(boolean z) {
        this.U = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.v) {
            this.v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.u) {
            this.u = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(v8.b(getContext(), i));
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(v8.b(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(h hVar) {
        this.N = hVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.k != i) {
            this.k = i;
            if (i == 0) {
                this.j = getContext();
            } else {
                this.j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleMarginBottom(int i) {
        this.s = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.f143q = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.p = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.r = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public boolean v() {
        f fVar = this.R;
        return (fVar == null || fVar.b == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.a;
        return actionMenuView != null && actionMenuView.E();
    }

    public void x(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public void y() {
        Iterator it = this.M.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        G();
    }

    public static class g extends androidx.appcompat.app.a.C0002a {
        int b;

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public g(int i, int i2) {
            super(i, i2);
            this.b = 0;
            this.a = 8388627;
        }

        public g(g gVar) {
            super((androidx.appcompat.app.a.C0002a) gVar);
            this.b = 0;
            this.b = gVar.b;
        }

        public g(androidx.appcompat.app.a.C0002a c0002a) {
            super(c0002a);
            this.b = 0;
        }

        public g(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = 0;
            a(marginLayoutParams);
        }

        public g(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.h.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.h;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!z(this.e)) {
                c(this.e, true);
            }
        } else {
            ImageView imageView = this.e;
            if (imageView != null && z(imageView)) {
                removeView(this.e);
                this.J.remove(this.e);
            }
        }
        ImageView imageView2 = this.e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            g43.a(this.d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!z(this.d)) {
                c(this.d, true);
            }
        } else {
            ImageButton imageButton = this.d;
            if (imageButton != null && z(imageButton)) {
                removeView(this.d);
                this.J.remove(this.d);
            }
        }
        ImageButton imageButton2 = this.d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.c;
            if (textView != null && z(textView)) {
                removeView(this.c);
                this.J.remove(this.c);
            }
        } else {
            if (this.c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.c.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.m;
                if (i != 0) {
                    this.c.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.F;
                if (colorStateList != null) {
                    this.c.setTextColor(colorStateList);
                }
            }
            if (!z(this.c)) {
                c(this.c, true);
            }
        }
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.F = colorStateList;
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.b;
            if (textView != null && z(textView)) {
                removeView(this.b);
                this.J.remove(this.b);
            }
        } else {
            if (this.b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                this.b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.b.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.l;
                if (i != 0) {
                    this.b.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.z;
                if (colorStateList != null) {
                    this.b.setTextColor(colorStateList);
                }
            }
            if (!z(this.b)) {
                c(this.b, true);
            }
        }
        TextView textView2 = this.b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.z = colorStateList;
        TextView textView = this.b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int a;
        boolean b;

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
            this.a = parcel.readInt();
            this.b = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.w = 8388627;
        this.I = new ArrayList();
        this.J = new ArrayList();
        this.K = new int[2];
        this.L = new oi1(new Runnable() { // from class: c43
            @Override // java.lang.Runnable
            public final void run() {
                this.a.y();
            }
        });
        this.M = new ArrayList();
        this.O = new a();
        this.b0 = new b();
        Context context2 = getContext();
        int[] iArr = R$styleable.Toolbar;
        e0 e0VarV = e0.v(context2, attributeSet, iArr, i, 0);
        be3.n0(this, context, iArr, attributeSet, e0VarV.r(), i, 0);
        this.l = e0VarV.n(R$styleable.Toolbar_titleTextAppearance, 0);
        this.m = e0VarV.n(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.w = e0VarV.l(R$styleable.Toolbar_android_gravity, this.w);
        this.n = e0VarV.l(R$styleable.Toolbar_buttonGravity, 48);
        int iE = e0VarV.e(R$styleable.Toolbar_titleMargin, 0);
        int i2 = R$styleable.Toolbar_titleMargins;
        iE = e0VarV.s(i2) ? e0VarV.e(i2, iE) : iE;
        this.s = iE;
        this.r = iE;
        this.f143q = iE;
        this.p = iE;
        int iE2 = e0VarV.e(R$styleable.Toolbar_titleMarginStart, -1);
        if (iE2 >= 0) {
            this.p = iE2;
        }
        int iE3 = e0VarV.e(R$styleable.Toolbar_titleMarginEnd, -1);
        if (iE3 >= 0) {
            this.f143q = iE3;
        }
        int iE4 = e0VarV.e(R$styleable.Toolbar_titleMarginTop, -1);
        if (iE4 >= 0) {
            this.r = iE4;
        }
        int iE5 = e0VarV.e(R$styleable.Toolbar_titleMarginBottom, -1);
        if (iE5 >= 0) {
            this.s = iE5;
        }
        this.o = e0VarV.f(R$styleable.Toolbar_maxButtonHeight, -1);
        int iE6 = e0VarV.e(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int iE7 = e0VarV.e(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int iF = e0VarV.f(R$styleable.Toolbar_contentInsetLeft, 0);
        int iF2 = e0VarV.f(R$styleable.Toolbar_contentInsetRight, 0);
        h();
        this.t.e(iF, iF2);
        if (iE6 != Integer.MIN_VALUE || iE7 != Integer.MIN_VALUE) {
            this.t.g(iE6, iE7);
        }
        this.u = e0VarV.e(R$styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.v = e0VarV.e(R$styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f = e0VarV.g(R$styleable.Toolbar_collapseIcon);
        this.g = e0VarV.p(R$styleable.Toolbar_collapseContentDescription);
        CharSequence charSequenceP = e0VarV.p(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceP)) {
            setTitle(charSequenceP);
        }
        CharSequence charSequenceP2 = e0VarV.p(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceP2)) {
            setSubtitle(charSequenceP2);
        }
        this.j = getContext();
        setPopupTheme(e0VarV.n(R$styleable.Toolbar_popupTheme, 0));
        Drawable drawableG = e0VarV.g(R$styleable.Toolbar_navigationIcon);
        if (drawableG != null) {
            setNavigationIcon(drawableG);
        }
        CharSequence charSequenceP3 = e0VarV.p(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceP3)) {
            setNavigationContentDescription(charSequenceP3);
        }
        Drawable drawableG2 = e0VarV.g(R$styleable.Toolbar_logo);
        if (drawableG2 != null) {
            setLogo(drawableG2);
        }
        CharSequence charSequenceP4 = e0VarV.p(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceP4)) {
            setLogoDescription(charSequenceP4);
        }
        int i3 = R$styleable.Toolbar_titleTextColor;
        if (e0VarV.s(i3)) {
            setTitleTextColor(e0VarV.c(i3));
        }
        int i4 = R$styleable.Toolbar_subtitleTextColor;
        if (e0VarV.s(i4)) {
            setSubtitleTextColor(e0VarV.c(i4));
        }
        int i5 = R$styleable.Toolbar_menu;
        if (e0VarV.s(i5)) {
            x(e0VarV.n(i5, 0));
        }
        e0VarV.x();
    }
}
