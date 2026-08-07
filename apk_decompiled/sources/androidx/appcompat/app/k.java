package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import defpackage.af3;
import defpackage.be3;
import defpackage.bf3;
import defpackage.e43;
import defpackage.mw2;
import defpackage.s2;
import defpackage.s70;
import defpackage.u2;
import defpackage.xe3;
import defpackage.ye3;
import defpackage.ze3;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class k extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {
    private static final Interpolator E = new AccelerateInterpolator();
    private static final Interpolator F = new DecelerateInterpolator();
    boolean A;
    Context a;
    private Context b;
    private Activity c;
    ActionBarOverlayLayout d;
    ActionBarContainer e;
    s70 f;
    ActionBarContextView g;
    View h;
    ScrollingTabContainerView i;
    private boolean l;
    d m;
    u2 n;
    u2.a o;
    private boolean p;
    private boolean r;
    boolean u;
    boolean v;
    private boolean w;
    ye3 y;
    private boolean z;
    private ArrayList j = new ArrayList();
    private int k = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ArrayList f128q = new ArrayList();
    private int s = 0;
    boolean t = true;
    private boolean x = true;
    final ze3 B = new a();
    final ze3 C = new b();
    final bf3 D = new c();

    class a extends af3 {
        a() {
        }

        @Override // defpackage.ze3
        public void b(View view) {
            View view2;
            k kVar = k.this;
            if (kVar.t && (view2 = kVar.h) != null) {
                view2.setTranslationY(0.0f);
                k.this.e.setTranslationY(0.0f);
            }
            k.this.e.setVisibility(8);
            k.this.e.setTransitioning(false);
            k kVar2 = k.this;
            kVar2.y = null;
            kVar2.z();
            ActionBarOverlayLayout actionBarOverlayLayout = k.this.d;
            if (actionBarOverlayLayout != null) {
                be3.m0(actionBarOverlayLayout);
            }
        }
    }

    class b extends af3 {
        b() {
        }

        @Override // defpackage.ze3
        public void b(View view) {
            k kVar = k.this;
            kVar.y = null;
            kVar.e.requestLayout();
        }
    }

    class c implements bf3 {
        c() {
        }

        @Override // defpackage.bf3
        public void a(View view) {
            ((View) k.this.e.getParent()).invalidate();
        }
    }

    public class d extends u2 implements androidx.appcompat.view.menu.e.a {
        private final Context c;
        private final androidx.appcompat.view.menu.e d;
        private u2.a e;
        private WeakReference f;

        public d(Context context, u2.a aVar) {
            this.c = context;
            this.e = aVar;
            androidx.appcompat.view.menu.e eVarX = new androidx.appcompat.view.menu.e(context).X(1);
            this.d = eVarX;
            eVarX.W(this);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            u2.a aVar = this.e;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (this.e == null) {
                return;
            }
            k();
            k.this.g.l();
        }

        @Override // defpackage.u2
        public void c() {
            k kVar = k.this;
            if (kVar.m != this) {
                return;
            }
            if (k.y(kVar.u, kVar.v, false)) {
                this.e.b(this);
            } else {
                k kVar2 = k.this;
                kVar2.n = this;
                kVar2.o = this.e;
            }
            this.e = null;
            k.this.x(false);
            k.this.g.g();
            k kVar3 = k.this;
            kVar3.d.setHideOnContentScrollEnabled(kVar3.A);
            k.this.m = null;
        }

        @Override // defpackage.u2
        public View d() {
            WeakReference weakReference = this.f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        @Override // defpackage.u2
        public Menu e() {
            return this.d;
        }

        @Override // defpackage.u2
        public MenuInflater f() {
            return new mw2(this.c);
        }

        @Override // defpackage.u2
        public CharSequence g() {
            return k.this.g.getSubtitle();
        }

        @Override // defpackage.u2
        public CharSequence i() {
            return k.this.g.getTitle();
        }

        @Override // defpackage.u2
        public void k() {
            if (k.this.m != this) {
                return;
            }
            this.d.i0();
            try {
                this.e.d(this, this.d);
            } finally {
                this.d.h0();
            }
        }

        @Override // defpackage.u2
        public boolean l() {
            return k.this.g.j();
        }

        @Override // defpackage.u2
        public void m(View view) {
            k.this.g.setCustomView(view);
            this.f = new WeakReference(view);
        }

        @Override // defpackage.u2
        public void n(int i) {
            o(k.this.a.getResources().getString(i));
        }

        @Override // defpackage.u2
        public void o(CharSequence charSequence) {
            k.this.g.setSubtitle(charSequence);
        }

        @Override // defpackage.u2
        public void q(int i) {
            r(k.this.a.getResources().getString(i));
        }

        @Override // defpackage.u2
        public void r(CharSequence charSequence) {
            k.this.g.setTitle(charSequence);
        }

        @Override // defpackage.u2
        public void s(boolean z) {
            super.s(z);
            k.this.g.setTitleOptional(z);
        }

        public boolean t() {
            this.d.i0();
            try {
                return this.e.c(this, this.d);
            } finally {
                this.d.h0();
            }
        }
    }

    public k(Activity activity, boolean z) {
        this.c = activity;
        View decorView = activity.getWindow().getDecorView();
        F(decorView);
        if (z) {
            return;
        }
        this.h = decorView.findViewById(R.id.content);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private s70 C(View view) {
        if (view instanceof s70) {
            return (s70) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    private void E() {
        if (this.w) {
            this.w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.d;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            N(false);
        }
    }

    private void F(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.d = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f = C(view.findViewById(R$id.action_bar));
        this.g = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.e = actionBarContainer;
        s70 s70Var = this.f;
        if (s70Var == null || this.g == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.a = s70Var.getContext();
        boolean z = (this.f.t() & 4) != 0;
        if (z) {
            this.l = true;
        }
        s2 s2VarB = s2.b(this.a);
        K(s2VarB.a() || z);
        I(s2VarB.g());
        TypedArray typedArrayObtainStyledAttributes = this.a.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            J(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            H(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void I(boolean z) {
        this.r = z;
        if (z) {
            this.e.setTabContainer(null);
            this.f.i(this.i);
        } else {
            this.f.i(null);
            this.e.setTabContainer(this.i);
        }
        boolean z2 = D() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.i;
        if (scrollingTabContainerView != null) {
            if (z2) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.d;
                if (actionBarOverlayLayout != null) {
                    be3.m0(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.f.w(!this.r && z2);
        this.d.setHasNonEmbeddedTabs(!this.r && z2);
    }

    private boolean L() {
        return this.e.isLaidOut();
    }

    private void M() {
        if (this.w) {
            return;
        }
        this.w = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.d;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        N(false);
    }

    private void N(boolean z) {
        if (y(this.u, this.v, this.w)) {
            if (this.x) {
                return;
            }
            this.x = true;
            B(z);
            return;
        }
        if (this.x) {
            this.x = false;
            A(z);
        }
    }

    static boolean y(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    public void A(boolean z) {
        View view;
        ye3 ye3Var = this.y;
        if (ye3Var != null) {
            ye3Var.a();
        }
        if (this.s != 0 || (!this.z && !z)) {
            this.B.b(null);
            return;
        }
        this.e.setAlpha(1.0f);
        this.e.setTransitioning(true);
        ye3 ye3Var2 = new ye3();
        float f = -this.e.getHeight();
        if (z) {
            int[] iArr = {0, 0};
            this.e.getLocationInWindow(iArr);
            f -= iArr[1];
        }
        xe3 xe3VarM = be3.e(this.e).m(f);
        xe3VarM.k(this.D);
        ye3Var2.c(xe3VarM);
        if (this.t && (view = this.h) != null) {
            ye3Var2.c(be3.e(view).m(f));
        }
        ye3Var2.f(E);
        ye3Var2.e(250L);
        ye3Var2.g(this.B);
        this.y = ye3Var2;
        ye3Var2.h();
    }

    public void B(boolean z) {
        View view;
        View view2;
        ye3 ye3Var = this.y;
        if (ye3Var != null) {
            ye3Var.a();
        }
        this.e.setVisibility(0);
        if (this.s == 0 && (this.z || z)) {
            this.e.setTranslationY(0.0f);
            float f = -this.e.getHeight();
            if (z) {
                int[] iArr = {0, 0};
                this.e.getLocationInWindow(iArr);
                f -= iArr[1];
            }
            this.e.setTranslationY(f);
            ye3 ye3Var2 = new ye3();
            xe3 xe3VarM = be3.e(this.e).m(0.0f);
            xe3VarM.k(this.D);
            ye3Var2.c(xe3VarM);
            if (this.t && (view2 = this.h) != null) {
                view2.setTranslationY(f);
                ye3Var2.c(be3.e(this.h).m(0.0f));
            }
            ye3Var2.f(F);
            ye3Var2.e(250L);
            ye3Var2.g(this.C);
            this.y = ye3Var2;
            ye3Var2.h();
        } else {
            this.e.setAlpha(1.0f);
            this.e.setTranslationY(0.0f);
            if (this.t && (view = this.h) != null) {
                view.setTranslationY(0.0f);
            }
            this.C.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.d;
        if (actionBarOverlayLayout != null) {
            be3.m0(actionBarOverlayLayout);
        }
    }

    public int D() {
        return this.f.n();
    }

    public void G(int i, int i2) {
        int iT = this.f.t();
        if ((i2 & 4) != 0) {
            this.l = true;
        }
        this.f.k((i & i2) | ((~i2) & iT));
    }

    public void H(float f) {
        be3.x0(this.e, f);
    }

    public void J(boolean z) {
        if (z && !this.d.x()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.A = z;
        this.d.setHideOnContentScrollEnabled(z);
    }

    public void K(boolean z) {
        this.f.s(z);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.v) {
            this.v = false;
            N(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(boolean z) {
        this.t = z;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
        if (this.v) {
            return;
        }
        this.v = true;
        N(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        ye3 ye3Var = this.y;
        if (ye3Var != null) {
            ye3Var.a();
            this.y = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f(int i) {
        this.s = i;
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        s70 s70Var = this.f;
        if (s70Var == null || !s70Var.j()) {
            return false;
        }
        this.f.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z) {
        if (z == this.p) {
            return;
        }
        this.p = z;
        if (this.f128q.size() <= 0) {
            return;
        }
        e43.a(this.f128q.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f.t();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.b = new ContextThemeWrapper(this.a, i);
            } else {
                this.b = this.a;
            }
        }
        return this.b;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        I(s2.b(this.a).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i, KeyEvent keyEvent) {
        Menu menuE;
        d dVar = this.m;
        if (dVar == null || (menuE = dVar.e()) == null) {
            return false;
        }
        menuE.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuE.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z) {
        if (this.l) {
            return;
        }
        s(z);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z) {
        G(z ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z) {
        G(z ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z) {
        ye3 ye3Var;
        this.z = z;
        if (z || (ye3Var = this.y) == null) {
            return;
        }
        ye3Var.a();
    }

    @Override // androidx.appcompat.app.a
    public void v(CharSequence charSequence) {
        this.f.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public u2 w(u2.a aVar) {
        d dVar = this.m;
        if (dVar != null) {
            dVar.c();
        }
        this.d.setHideOnContentScrollEnabled(false);
        this.g.k();
        d dVar2 = new d(this.g.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.m = dVar2;
        dVar2.k();
        this.g.h(dVar2);
        x(true);
        return dVar2;
    }

    public void x(boolean z) {
        xe3 xe3VarO;
        xe3 xe3VarF;
        if (z) {
            M();
        } else {
            E();
        }
        if (!L()) {
            if (z) {
                this.f.q(4);
                this.g.setVisibility(0);
                return;
            } else {
                this.f.q(0);
                this.g.setVisibility(8);
                return;
            }
        }
        if (z) {
            xe3VarF = this.f.o(4, 100L);
            xe3VarO = this.g.f(0, 200L);
        } else {
            xe3VarO = this.f.o(0, 200L);
            xe3VarF = this.g.f(8, 100L);
        }
        ye3 ye3Var = new ye3();
        ye3Var.d(xe3VarF, xe3VarO);
        ye3Var.h();
    }

    void z() {
        u2.a aVar = this.o;
        if (aVar != null) {
            aVar.b(this.n);
            this.n = null;
            this.o = null;
        }
    }

    public k(Dialog dialog) {
        F(dialog.getWindow().getDecorView());
    }
}
