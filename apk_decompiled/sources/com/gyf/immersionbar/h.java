package com.gyf.immersionbar;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import defpackage.pz;
import defpackage.q30;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements i {
    private final Activity a;
    private Fragment b;
    private android.app.Fragment c;
    private Dialog d;
    private Window e;
    private ViewGroup f;
    private ViewGroup g;
    private h h;
    private boolean i;
    private boolean j;
    private boolean k;
    private com.gyf.immersionbar.b l;
    private com.gyf.immersionbar.a m;
    private int n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private f f278q;
    private final Map r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private int z;

    class a implements Runnable {
        final /* synthetic */ ViewGroup.LayoutParams a;
        final /* synthetic */ View b;
        final /* synthetic */ int c;
        final /* synthetic */ Integer d;

        a(ViewGroup.LayoutParams layoutParams, View view, int i, Integer num) {
            this.a = layoutParams;
            this.b = view;
            this.c = i;
            this.d = num;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.height = (this.b.getHeight() + this.c) - this.d.intValue();
            View view = this.b;
            view.setPadding(view.getPaddingLeft(), (this.b.getPaddingTop() + this.c) - this.d.intValue(), this.b.getPaddingRight(), this.b.getPaddingBottom());
            this.b.setLayoutParams(this.a);
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BarHide.values().length];
            a = iArr;
            try {
                iArr[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    h(Activity activity) {
        this.i = false;
        this.j = false;
        this.k = false;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.f278q = null;
        this.r = new HashMap();
        this.s = 0;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.a = activity;
        J(activity.getWindow());
    }

    private static l A() {
        return l.f();
    }

    public static int B(Activity activity) {
        return new com.gyf.immersionbar.a(activity).j();
    }

    private void E() {
        WindowInsetsController windowInsetsController;
        if (Build.VERSION.SDK_INT < 30 || (windowInsetsController = this.g.getWindowInsetsController()) == null) {
            return;
        }
        int i = b.a[this.l.j.ordinal()];
        if (i == 1) {
            windowInsetsController.hide(WindowInsets.Type.statusBars());
            windowInsetsController.hide(WindowInsets.Type.navigationBars());
        } else if (i == 2) {
            windowInsetsController.hide(WindowInsets.Type.statusBars());
        } else if (i == 3) {
            windowInsetsController.hide(WindowInsets.Type.navigationBars());
        } else if (i == 4) {
            windowInsetsController.show(WindowInsets.Type.statusBars());
            windowInsetsController.show(WindowInsets.Type.navigationBars());
        }
        windowInsetsController.setSystemBarsBehavior(2);
    }

    private int F(int i) {
        if (Build.VERSION.SDK_INT >= 30) {
            return i;
        }
        int i2 = b.a[this.l.j.ordinal()];
        if (i2 == 1) {
            i |= 518;
        } else if (i2 == 2) {
            i |= 1028;
        } else if (i2 == 3) {
            i |= 514;
        }
        return i | 4096;
    }

    private int H(int i) {
        if (!this.t) {
            this.l.c = this.e.getNavigationBarColor();
        }
        int i2 = i | 1024;
        com.gyf.immersionbar.b bVar = this.l;
        if (bVar.h && bVar.M) {
            i2 = i | 1536;
        }
        this.e.clearFlags(67108864);
        if (this.m.l()) {
            this.e.clearFlags(134217728);
        }
        this.e.addFlags(Integer.MIN_VALUE);
        com.gyf.immersionbar.b bVar2 = this.l;
        if (bVar2.f277q) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.e.setStatusBarContrastEnforced(false);
            }
            Window window = this.e;
            com.gyf.immersionbar.b bVar3 = this.l;
            window.setStatusBarColor(pz.c(bVar3.a, bVar3.r, bVar3.d));
        } else {
            this.e.setStatusBarColor(pz.c(bVar2.a, 0, bVar2.d));
        }
        com.gyf.immersionbar.b bVar4 = this.l;
        if (bVar4.M) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.e.setNavigationBarContrastEnforced(false);
            }
            Window window2 = this.e;
            com.gyf.immersionbar.b bVar5 = this.l;
            window2.setNavigationBarColor(pz.c(bVar5.b, bVar5.s, bVar5.f));
        } else {
            this.e.setNavigationBarColor(bVar4.c);
        }
        return i2;
    }

    private void I() {
        this.e.addFlags(67108864);
        i0();
        if (this.m.l() || OSUtils.isEMUI3_x()) {
            com.gyf.immersionbar.b bVar = this.l;
            if (bVar.M && bVar.N) {
                this.e.addFlags(134217728);
            } else {
                this.e.clearFlags(134217728);
            }
            if (this.n == 0) {
                this.n = this.m.d();
            }
            if (this.o == 0) {
                this.o = this.m.g();
            }
            h0();
        }
    }

    private void J(Window window) {
        this.e = window;
        this.l = new com.gyf.immersionbar.b();
        ViewGroup viewGroup = (ViewGroup) this.e.getDecorView();
        this.f = viewGroup;
        this.g = (ViewGroup) viewGroup.findViewById(R.id.content);
    }

    public static boolean M() {
        OSUtils.isMIUI6Later();
        return true;
    }

    public static boolean N() {
        if (OSUtils.isMIUI6Later()) {
            return true;
        }
        OSUtils.isFlymeOS4Later();
        return true;
    }

    private void V() {
        q();
        if (this.i || !OSUtils.isEMUI3_x()) {
            return;
        }
        p();
    }

    private void X() {
        if (Build.VERSION.SDK_INT >= 30) {
            d0();
            Z();
        }
    }

    private int Y(int i) {
        return this.l.l ? i | 16 : i;
    }

    private void Z() {
        WindowInsetsController windowInsetsController = this.g.getWindowInsetsController();
        if (this.l.l) {
            windowInsetsController.setSystemBarsAppearance(16, 16);
        } else {
            windowInsetsController.setSystemBarsAppearance(0, 16);
        }
    }

    private void a0(int i, int i2, int i3, int i4) {
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            viewGroup.setPadding(i, i2, i3, i4);
        }
        this.w = i;
        this.x = i2;
        this.y = i3;
        this.z = i4;
    }

    private void b() {
        com.gyf.immersionbar.b bVar = this.l;
        int iC = pz.c(bVar.a, bVar.r, bVar.d);
        com.gyf.immersionbar.b bVar2 = this.l;
        if (bVar2.m && iC != 0) {
            k0(iC > -4539718, bVar2.o);
        }
        com.gyf.immersionbar.b bVar3 = this.l;
        int iC2 = pz.c(bVar3.b, bVar3.s, bVar3.f);
        com.gyf.immersionbar.b bVar4 = this.l;
        if (!bVar4.n || iC2 == 0) {
            return;
        }
        R(iC2 > -4539718, bVar4.p);
    }

    private void b0() {
        if (OSUtils.isMIUI6Later()) {
            SpecialBarFontUtils.setMIUIBarDark(this.e, "EXTRA_FLAG_STATUS_BAR_DARK_MODE", this.l.k);
            com.gyf.immersionbar.b bVar = this.l;
            if (bVar.M) {
                SpecialBarFontUtils.setMIUIBarDark(this.e, "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE", bVar.l);
            }
        }
        if (OSUtils.isFlymeOS4Later()) {
            com.gyf.immersionbar.b bVar2 = this.l;
            int i = bVar2.H;
            if (i != 0) {
                SpecialBarFontUtils.setStatusBarDarkIcon(this.a, i);
            } else {
                SpecialBarFontUtils.setStatusBarDarkIcon(this.a, bVar2.k);
            }
        }
    }

    private int c0(int i) {
        return this.l.k ? i | 8192 : i;
    }

    private void d0() {
        WindowInsetsController windowInsetsController = this.g.getWindowInsetsController();
        if (!this.l.k) {
            windowInsetsController.setSystemBarsAppearance(0, 8);
            return;
        }
        if (this.e != null) {
            m0(8192);
        }
        windowInsetsController.setSystemBarsAppearance(8, 8);
    }

    private void e() {
        if (this.a != null) {
            f fVar = this.f278q;
            if (fVar != null) {
                fVar.a();
                this.f278q = null;
            }
            e.b().d(this);
            k.a().c(this.l.Q);
        }
    }

    public static void e0(Activity activity, int i, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i < 0) {
            i = 0;
        }
        for (View view : viewArr) {
            if (view != null) {
                int i2 = R$id.immersion_fits_layout_overlap;
                Integer num = (Integer) view.getTag(i2);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i) {
                    view.setTag(i2, Integer.valueOf(i));
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, 0);
                    }
                    layoutParams.height = i;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public static boolean f(View view) {
        if (view == null) {
            return false;
        }
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (((childAt instanceof DrawerLayout) && f(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void f0(Activity activity, int i, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i < 0) {
            i = 0;
        }
        for (View view : viewArr) {
            if (view != null) {
                int i2 = R$id.immersion_fits_layout_overlap;
                Integer num = (Integer) view.getTag(i2);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i) {
                    view.setTag(i2, Integer.valueOf(i));
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, -2);
                    }
                    int i3 = layoutParams.height;
                    if (i3 == -2 || i3 == -1) {
                        view.post(new a(layoutParams, view, i, num));
                    } else {
                        layoutParams.height = i3 + (i - num.intValue());
                        view.setPadding(view.getPaddingLeft(), (view.getPaddingTop() + i) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                        view.setLayoutParams(layoutParams);
                    }
                }
            }
        }
    }

    private void g() {
        if (this.h == null) {
            this.h = p0(this.a);
        }
        h hVar = this.h;
        if (hVar == null || hVar.t) {
            return;
        }
        hVar.G();
    }

    public static void g0(Activity activity, int i, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i < 0) {
            i = 0;
        }
        for (View view : viewArr) {
            if (view != null) {
                int i2 = R$id.immersion_fits_layout_overlap;
                Integer num = (Integer) view.getTag(i2);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i) {
                    view.setTag(i2, Integer.valueOf(i));
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (marginLayoutParams.topMargin + i) - num.intValue(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    private void h() {
        if (!this.i) {
            if (this.l.K) {
                if (this.f278q == null) {
                    this.f278q = new f(this);
                }
                this.f278q.c(this.l.L);
                return;
            } else {
                f fVar = this.f278q;
                if (fVar != null) {
                    fVar.b();
                    return;
                }
                return;
            }
        }
        h hVar = this.h;
        if (hVar != null) {
            if (hVar.l.K) {
                if (hVar.f278q == null) {
                    hVar.f278q = new f(hVar);
                }
                h hVar2 = this.h;
                hVar2.f278q.c(hVar2.l.L);
                return;
            }
            f fVar2 = hVar.f278q;
            if (fVar2 != null) {
                fVar2.b();
            }
        }
    }

    private void h0() {
        FrameLayout.LayoutParams layoutParams;
        ViewGroup viewGroup = this.f;
        int i = d.b;
        View viewFindViewById = viewGroup.findViewById(i);
        if (viewFindViewById == null) {
            viewFindViewById = new View(this.a);
            viewFindViewById.setId(i);
            this.f.addView(viewFindViewById);
        }
        if (this.m.m()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.m.d());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.m.g(), -1);
            layoutParams.gravity = 8388613;
        }
        viewFindViewById.setLayoutParams(layoutParams);
        com.gyf.immersionbar.b bVar = this.l;
        viewFindViewById.setBackgroundColor(pz.c(bVar.b, bVar.s, bVar.f));
        com.gyf.immersionbar.b bVar2 = this.l;
        if (bVar2.M && bVar2.N && !bVar2.i) {
            viewFindViewById.setVisibility(0);
        } else {
            viewFindViewById.setVisibility(8);
        }
    }

    private void i() {
        int iJ = this.l.G ? this.m.j() : 0;
        int i = this.s;
        if (i == 1) {
            f0(this.a, iJ, this.l.z);
        } else if (i == 2) {
            g0(this.a, iJ, this.l.z);
        } else {
            if (i != 3) {
                return;
            }
            e0(this.a, iJ, this.l.F);
        }
    }

    private void i0() {
        ViewGroup viewGroup = this.f;
        int i = d.a;
        View viewFindViewById = viewGroup.findViewById(i);
        if (viewFindViewById == null) {
            viewFindViewById = new View(this.a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.m.j());
            layoutParams.gravity = 48;
            viewFindViewById.setLayoutParams(layoutParams);
            viewFindViewById.setVisibility(0);
            viewFindViewById.setId(i);
            this.f.addView(viewFindViewById);
        }
        com.gyf.immersionbar.b bVar = this.l;
        if (bVar.f277q) {
            viewFindViewById.setBackgroundColor(pz.c(bVar.a, bVar.r, bVar.d));
        } else {
            viewFindViewById.setBackgroundColor(pz.c(bVar.a, 0, bVar.d));
        }
    }

    private void j() {
        if (Build.VERSION.SDK_INT < 28 || this.t) {
            return;
        }
        try {
            WindowManager.LayoutParams attributes = this.e.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            this.e.setAttributes(attributes);
        } catch (Exception unused) {
        }
    }

    private void l0() {
        if (this.l.t.size() != 0) {
            for (Map.Entry entry : this.l.t.entrySet()) {
                View view = (View) entry.getKey();
                Map map = (Map) entry.getValue();
                Integer numValueOf = Integer.valueOf(this.l.a);
                Integer numValueOf2 = Integer.valueOf(this.l.r);
                for (Map.Entry entry2 : map.entrySet()) {
                    Integer num = (Integer) entry2.getKey();
                    numValueOf2 = (Integer) entry2.getValue();
                    numValueOf = num;
                }
                if (view != null) {
                    if (Math.abs(this.l.u - 0.0f) == 0.0f) {
                        view.setBackgroundColor(pz.c(numValueOf.intValue(), numValueOf2.intValue(), this.l.d));
                    } else {
                        view.setBackgroundColor(pz.c(numValueOf.intValue(), numValueOf2.intValue(), this.l.u));
                    }
                }
            }
        }
    }

    private void m() {
        if (OSUtils.isEMUI3_x()) {
            o();
        } else {
            n();
        }
        i();
    }

    private void n() {
        if (f(this.f.findViewById(R.id.content))) {
            a0(0, 0, 0, 0);
            return;
        }
        int iJ = (this.l.y && this.s == 4) ? this.m.j() : 0;
        if (this.l.J) {
            iJ = this.m.j() + this.p;
        }
        a0(0, iJ, 0, 0);
    }

    private void n0() {
        com.gyf.immersionbar.a aVar = new com.gyf.immersionbar.a(this.a);
        this.m = aVar;
        if (!this.t || this.u) {
            this.p = aVar.a();
        }
    }

    private void o() {
        if (this.l.J) {
            this.u = true;
            this.g.post(this);
        } else {
            this.u = false;
            V();
        }
    }

    private void o0() {
        b();
        if (!this.t || this.i) {
            n0();
        }
        h hVar = this.h;
        if (hVar != null) {
            if (this.i) {
                hVar.l = this.l;
            }
            if (this.k && hVar.v) {
                hVar.l.K = false;
            }
        }
    }

    private void p() {
        View viewFindViewById = this.f.findViewById(d.b);
        com.gyf.immersionbar.b bVar = this.l;
        if (!bVar.M || !bVar.N) {
            e.b().d(this);
            viewFindViewById.setVisibility(8);
        } else if (viewFindViewById != null) {
            e.b().a(this);
            e.b().c(this.a.getApplication());
        }
    }

    public static h p0(Activity activity) {
        return A().b(activity, false);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0088  */
    private void q() {
        int iG;
        int iD;
        if (f(this.f.findViewById(R.id.content))) {
            a0(0, 0, 0, 0);
            return;
        }
        int iJ = (this.l.y && this.s == 4) ? this.m.j() : 0;
        if (this.l.J) {
            iJ = this.m.j() + this.p;
        }
        if (this.m.l()) {
            com.gyf.immersionbar.b bVar = this.l;
            if (bVar.M && bVar.N) {
                if (bVar.h) {
                    iG = 0;
                    iD = 0;
                } else if (this.m.m()) {
                    iD = this.m.d();
                    iG = 0;
                } else {
                    iG = this.m.g();
                    iD = 0;
                }
                if (this.l.i) {
                    if (this.m.m()) {
                        iD = 0;
                    } else {
                        iG = 0;
                    }
                } else if (!this.m.m()) {
                    iG = this.m.g();
                }
            } else {
                iG = 0;
                iD = 0;
            }
        } else {
            iG = 0;
            iD = 0;
        }
        a0(0, iJ, iG, iD);
    }

    public static h q0(Fragment fragment) {
        return A().c(fragment, false);
    }

    Fragment C() {
        return this.b;
    }

    Window D() {
        return this.e;
    }

    public void G() {
        if (this.l.P) {
            o0();
            W();
            m();
            h();
            l0();
            this.t = true;
        }
    }

    boolean K() {
        return this.t;
    }

    boolean L() {
        return this.j;
    }

    public h O(boolean z) {
        return P(z, this.l.L);
    }

    public h P(boolean z, int i) {
        com.gyf.immersionbar.b bVar = this.l;
        bVar.K = z;
        bVar.L = i;
        this.v = z;
        return this;
    }

    public h Q(boolean z) {
        return R(z, 0.2f);
    }

    public h R(boolean z, float f) {
        this.l.l = z;
        if (!z || M()) {
            com.gyf.immersionbar.b bVar = this.l;
            bVar.f = bVar.g;
        } else {
            this.l.f = f;
        }
        return this;
    }

    void S(Configuration configuration) {
        n0();
        if (!OSUtils.isEMUI3_x()) {
            m();
        } else if (this.t && !this.i && this.l.N) {
            G();
        } else {
            m();
        }
    }

    void T() {
        h hVar;
        e();
        if (this.k && (hVar = this.h) != null) {
            com.gyf.immersionbar.b bVar = hVar.l;
            bVar.K = hVar.v;
            if (bVar.j != BarHide.FLAG_SHOW_BAR) {
                hVar.W();
            }
        }
        this.t = false;
    }

    void U() {
        n0();
        if (this.i || !this.t || this.l == null) {
            return;
        }
        if (OSUtils.isEMUI3_x() && this.l.O) {
            G();
        } else if (this.l.j != BarHide.FLAG_SHOW_BAR) {
            W();
        }
    }

    void W() {
        int iY = 256;
        if (OSUtils.isEMUI3_x()) {
            I();
        } else {
            j();
            iY = Y(c0(H(256)));
            X();
        }
        this.f.setSystemUiVisibility(F(iY));
        b0();
        E();
        if (this.l.Q != null) {
            k.a().b(this.a.getApplication());
        }
    }

    @Override // defpackage.pv1
    public void a(boolean z, NavigationBarType navigationBarType) {
        View viewFindViewById = this.f.findViewById(d.b);
        if (viewFindViewById != null) {
            this.m = new com.gyf.immersionbar.a(this.a);
            int paddingBottom = this.g.getPaddingBottom();
            int paddingRight = this.g.getPaddingRight();
            if (z) {
                viewFindViewById.setVisibility(0);
                if (!f(this.f.findViewById(R.id.content))) {
                    if (this.n == 0) {
                        this.n = this.m.d();
                    }
                    if (this.o == 0) {
                        this.o = this.m.g();
                    }
                    if (!this.l.i) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewFindViewById.getLayoutParams();
                        if (this.m.m()) {
                            layoutParams.gravity = 80;
                            paddingBottom = this.n;
                            layoutParams.height = paddingBottom;
                            if (this.l.h) {
                                paddingBottom = 0;
                            }
                            paddingRight = 0;
                        } else {
                            layoutParams.gravity = 8388613;
                            int i = this.o;
                            layoutParams.width = i;
                            if (this.l.h) {
                                i = 0;
                            }
                            paddingRight = i;
                            paddingBottom = 0;
                        }
                        viewFindViewById.setLayoutParams(layoutParams);
                    }
                }
                a0(0, this.g.getPaddingTop(), paddingRight, paddingBottom);
            }
            viewFindViewById.setVisibility(8);
            paddingBottom = 0;
            paddingRight = 0;
            a0(0, this.g.getPaddingTop(), paddingRight, paddingBottom);
        }
    }

    public h c(int i) {
        return d(q30.c(this.a, i));
    }

    public h d(int i) {
        com.gyf.immersionbar.b bVar = this.l;
        bVar.a = i;
        bVar.b = i;
        return this;
    }

    public h j0(boolean z) {
        return k0(z, 0.2f);
    }

    void k() {
        f fVar;
        h hVar = this.h;
        if (hVar == null || (fVar = hVar.f278q) == null) {
            return;
        }
        fVar.b();
        this.h.f278q.d();
    }

    public h k0(boolean z, float f) {
        this.l.k = z;
        if (!z || N()) {
            com.gyf.immersionbar.b bVar = this.l;
            bVar.H = bVar.I;
            bVar.d = bVar.e;
        } else {
            this.l.d = f;
        }
        return this;
    }

    public h l(boolean z) {
        this.l.y = z;
        if (!z) {
            this.s = 0;
        } else if (this.s == 0) {
            this.s = 4;
        }
        return this;
    }

    protected void m0(int i) {
        View decorView = this.e.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }

    int r() {
        return this.p;
    }

    @Override // java.lang.Runnable
    public void run() {
        V();
    }

    Activity s() {
        return this.a;
    }

    com.gyf.immersionbar.a t() {
        if (this.m == null) {
            this.m = new com.gyf.immersionbar.a(this.a);
        }
        return this.m;
    }

    public com.gyf.immersionbar.b u() {
        return this.l;
    }

    android.app.Fragment v() {
        return this.c;
    }

    int w() {
        return this.z;
    }

    int x() {
        return this.w;
    }

    int y() {
        return this.y;
    }

    int z() {
        return this.x;
    }

    h(Fragment fragment) {
        this.i = false;
        this.j = false;
        this.k = false;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.f278q = null;
        this.r = new HashMap();
        this.s = 0;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.i = true;
        FragmentActivity activity = fragment.getActivity();
        this.a = activity;
        this.b = fragment;
        g();
        J(activity.getWindow());
    }

    h(android.app.Fragment fragment) {
        this.i = false;
        this.j = false;
        this.k = false;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.f278q = null;
        this.r = new HashMap();
        this.s = 0;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.i = true;
        Activity activity = fragment.getActivity();
        this.a = activity;
        this.c = fragment;
        g();
        J(activity.getWindow());
    }

    h(DialogFragment dialogFragment) {
        this.i = false;
        this.j = false;
        this.k = false;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.f278q = null;
        this.r = new HashMap();
        this.s = 0;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.k = true;
        this.j = true;
        this.a = dialogFragment.getActivity();
        this.b = dialogFragment;
        this.d = dialogFragment.B();
        g();
        J(this.d.getWindow());
    }

    h(android.app.DialogFragment dialogFragment) {
        this.i = false;
        this.j = false;
        this.k = false;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.f278q = null;
        this.r = new HashMap();
        this.s = 0;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.k = true;
        this.j = true;
        this.a = dialogFragment.getActivity();
        this.c = dialogFragment;
        this.d = dialogFragment.getDialog();
        g();
        J(this.d.getWindow());
    }
}
