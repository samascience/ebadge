package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import defpackage.af3;
import defpackage.be3;
import defpackage.s70;
import defpackage.t2;
import defpackage.v8;
import defpackage.xe3;

/* JADX INFO: loaded from: classes.dex */
public class f0 implements s70 {
    Toolbar a;
    private int b;
    private View c;
    private View d;
    private Drawable e;
    private Drawable f;
    private Drawable g;
    private boolean h;
    CharSequence i;
    private CharSequence j;
    private CharSequence k;
    Window.Callback l;
    boolean m;
    private ActionMenuPresenter n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Drawable f144q;

    class a implements View.OnClickListener {
        final t2 a;

        a() {
            this.a = new t2(f0.this.a.getContext(), 0, R.id.home, 0, 0, f0.this.i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f0 f0Var = f0.this;
            Window.Callback callback = f0Var.l;
            if (callback == null || !f0Var.m) {
                return;
            }
            callback.onMenuItemSelected(0, this.a);
        }
    }

    class b extends af3 {
        private boolean a = false;
        final /* synthetic */ int b;

        b(int i) {
            this.b = i;
        }

        @Override // defpackage.af3, defpackage.ze3
        public void a(View view) {
            this.a = true;
        }

        @Override // defpackage.ze3
        public void b(View view) {
            if (this.a) {
                return;
            }
            f0.this.a.setVisibility(this.b);
        }

        @Override // defpackage.af3, defpackage.ze3
        public void c(View view) {
            f0.this.a.setVisibility(0);
        }
    }

    public f0(Toolbar toolbar, boolean z) {
        this(toolbar, z, R$string.abc_action_bar_up_description, R$drawable.abc_ic_ab_back_material);
    }

    private void G(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setTitle(charSequence);
            if (this.h) {
                be3.s0(this.a.getRootView(), charSequence);
            }
        }
    }

    private void H() {
        if ((this.b & 4) != 0) {
            if (TextUtils.isEmpty(this.k)) {
                this.a.setNavigationContentDescription(this.p);
            } else {
                this.a.setNavigationContentDescription(this.k);
            }
        }
    }

    private void I() {
        if ((this.b & 4) == 0) {
            this.a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.a;
        Drawable drawable = this.g;
        if (drawable == null) {
            drawable = this.f144q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    private void J() {
        Drawable drawable;
        int i = this.b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f) == null) {
            drawable = this.e;
        }
        this.a.setLogo(drawable);
    }

    private int x() {
        if (this.a.getNavigationIcon() == null) {
            return 11;
        }
        this.f144q = this.a.getNavigationIcon();
        return 15;
    }

    public void A(Drawable drawable) {
        this.f = drawable;
        J();
    }

    public void B(int i) {
        C(i == 0 ? null : getContext().getString(i));
    }

    public void C(CharSequence charSequence) {
        this.k = charSequence;
        H();
    }

    public void D(Drawable drawable) {
        this.g = drawable;
        I();
    }

    public void E(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    public void F(CharSequence charSequence) {
        this.h = true;
        G(charSequence);
    }

    @Override // defpackage.s70
    public void a(Menu menu, androidx.appcompat.view.menu.j.a aVar) {
        if (this.n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.a.getContext());
            this.n = actionMenuPresenter;
            actionMenuPresenter.s(R$id.action_menu_presenter);
        }
        this.n.h(aVar);
        this.a.K((androidx.appcompat.view.menu.e) menu, this.n);
    }

    @Override // defpackage.s70
    public boolean b() {
        return this.a.B();
    }

    @Override // defpackage.s70
    public void c() {
        this.m = true;
    }

    @Override // defpackage.s70
    public void collapseActionView() {
        this.a.e();
    }

    @Override // defpackage.s70
    public boolean d() {
        return this.a.d();
    }

    @Override // defpackage.s70
    public boolean e() {
        return this.a.A();
    }

    @Override // defpackage.s70
    public boolean f() {
        return this.a.w();
    }

    @Override // defpackage.s70
    public boolean g() {
        return this.a.Q();
    }

    @Override // defpackage.s70
    public Context getContext() {
        return this.a.getContext();
    }

    @Override // defpackage.s70
    public CharSequence getTitle() {
        return this.a.getTitle();
    }

    @Override // defpackage.s70
    public void h() {
        this.a.f();
    }

    @Override // defpackage.s70
    public void i(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.a;
            if (parent == toolbar) {
                toolbar.removeView(this.c);
            }
        }
        this.c = scrollingTabContainerView;
        if (scrollingTabContainerView == null || this.o != 2) {
            return;
        }
        this.a.addView(scrollingTabContainerView, 0);
        Toolbar.g gVar = (Toolbar.g) this.c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) gVar).width = -2;
        ((ViewGroup.MarginLayoutParams) gVar).height = -2;
        gVar.a = 8388691;
        scrollingTabContainerView.setAllowCollapse(true);
    }

    @Override // defpackage.s70
    public boolean j() {
        return this.a.v();
    }

    @Override // defpackage.s70
    public void k(int i) {
        View view;
        int i2 = this.b ^ i;
        this.b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    H();
                }
                I();
            }
            if ((i2 & 3) != 0) {
                J();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.i);
                    this.a.setSubtitle(this.j);
                } else {
                    this.a.setTitle((CharSequence) null);
                    this.a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.d) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.a.addView(view);
            } else {
                this.a.removeView(view);
            }
        }
    }

    @Override // defpackage.s70
    public Menu l() {
        return this.a.getMenu();
    }

    @Override // defpackage.s70
    public void m(int i) {
        A(i != 0 ? v8.b(getContext(), i) : null);
    }

    @Override // defpackage.s70
    public int n() {
        return this.o;
    }

    @Override // defpackage.s70
    public xe3 o(int i, long j) {
        return be3.e(this.a).b(i == 0 ? 1.0f : 0.0f).f(j).h(new b(i));
    }

    @Override // defpackage.s70
    public void p(androidx.appcompat.view.menu.j.a aVar, androidx.appcompat.view.menu.e.a aVar2) {
        this.a.L(aVar, aVar2);
    }

    @Override // defpackage.s70
    public void q(int i) {
        this.a.setVisibility(i);
    }

    @Override // defpackage.s70
    public ViewGroup r() {
        return this.a;
    }

    @Override // defpackage.s70
    public void s(boolean z) {
    }

    @Override // defpackage.s70
    public void setIcon(int i) {
        setIcon(i != 0 ? v8.b(getContext(), i) : null);
    }

    @Override // defpackage.s70
    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    @Override // defpackage.s70
    public void setWindowTitle(CharSequence charSequence) {
        if (this.h) {
            return;
        }
        G(charSequence);
    }

    @Override // defpackage.s70
    public int t() {
        return this.b;
    }

    @Override // defpackage.s70
    public void u() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // defpackage.s70
    public void v() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // defpackage.s70
    public void w(boolean z) {
        this.a.setCollapsible(z);
    }

    public void y(View view) {
        View view2 = this.d;
        if (view2 != null && (this.b & 16) != 0) {
            this.a.removeView(view2);
        }
        this.d = view;
        if (view == null || (this.b & 16) == 0) {
            return;
        }
        this.a.addView(view);
    }

    public void z(int i) {
        if (i == this.p) {
            return;
        }
        this.p = i;
        if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
            B(this.p);
        }
    }

    public f0(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        e0 e0VarV = e0.v(toolbar.getContext(), null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.f144q = e0VarV.g(R$styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence charSequenceP = e0VarV.p(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceP)) {
                F(charSequenceP);
            }
            CharSequence charSequenceP2 = e0VarV.p(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceP2)) {
                E(charSequenceP2);
            }
            Drawable drawableG = e0VarV.g(R$styleable.ActionBar_logo);
            if (drawableG != null) {
                A(drawableG);
            }
            Drawable drawableG2 = e0VarV.g(R$styleable.ActionBar_icon);
            if (drawableG2 != null) {
                setIcon(drawableG2);
            }
            if (this.g == null && (drawable = this.f144q) != null) {
                D(drawable);
            }
            k(e0VarV.k(R$styleable.ActionBar_displayOptions, 0));
            int iN = e0VarV.n(R$styleable.ActionBar_customNavigationLayout, 0);
            if (iN != 0) {
                y(LayoutInflater.from(this.a.getContext()).inflate(iN, (ViewGroup) this.a, false));
                k(this.b | 16);
            }
            int iM = e0VarV.m(R$styleable.ActionBar_height, 0);
            if (iM > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = iM;
                this.a.setLayoutParams(layoutParams);
            }
            int iE = e0VarV.e(R$styleable.ActionBar_contentInsetStart, -1);
            int iE2 = e0VarV.e(R$styleable.ActionBar_contentInsetEnd, -1);
            if (iE >= 0 || iE2 >= 0) {
                this.a.J(Math.max(iE, 0), Math.max(iE2, 0));
            }
            int iN2 = e0VarV.n(R$styleable.ActionBar_titleTextStyle, 0);
            if (iN2 != 0) {
                Toolbar toolbar2 = this.a;
                toolbar2.N(toolbar2.getContext(), iN2);
            }
            int iN3 = e0VarV.n(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (iN3 != 0) {
                Toolbar toolbar3 = this.a;
                toolbar3.M(toolbar3.getContext(), iN3);
            }
            int iN4 = e0VarV.n(R$styleable.ActionBar_popupTheme, 0);
            if (iN4 != 0) {
                this.a.setPopupTheme(iN4);
            }
        } else {
            this.b = x();
        }
        e0VarV.x();
        z(i);
        this.k = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new a());
    }

    @Override // defpackage.s70
    public void setIcon(Drawable drawable) {
        this.e = drawable;
        J();
    }
}
