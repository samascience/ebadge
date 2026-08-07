package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class zi3 {
    public static final zi3 b;
    private final k a;

    private static class d extends c {
        d() {
        }

        @Override // zi3.e
        void c(int i, z21 z21Var) {
            this.c.setInsets(m.a(i), z21Var.e());
        }

        d(zi3 zi3Var) {
            super(zi3Var);
        }
    }

    private static class e {
        private final zi3 a;
        z21[] b;

        e() {
            this(new zi3((zi3) null));
        }

        protected final void a() {
            z21[] z21VarArr = this.b;
            if (z21VarArr != null) {
                z21 z21VarF = z21VarArr[l.b(1)];
                z21 z21VarF2 = this.b[l.b(2)];
                if (z21VarF2 == null) {
                    z21VarF2 = this.a.f(2);
                }
                if (z21VarF == null) {
                    z21VarF = this.a.f(1);
                }
                g(z21.a(z21VarF, z21VarF2));
                z21 z21Var = this.b[l.b(16)];
                if (z21Var != null) {
                    f(z21Var);
                }
                z21 z21Var2 = this.b[l.b(32)];
                if (z21Var2 != null) {
                    d(z21Var2);
                }
                z21 z21Var3 = this.b[l.b(64)];
                if (z21Var3 != null) {
                    h(z21Var3);
                }
            }
        }

        abstract zi3 b();

        void c(int i, z21 z21Var) {
            if (this.b == null) {
                this.b = new z21[9];
            }
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    this.b[l.b(i2)] = z21Var;
                }
            }
        }

        void d(z21 z21Var) {
        }

        abstract void e(z21 z21Var);

        void f(z21 z21Var) {
        }

        abstract void g(z21 z21Var);

        void h(z21 z21Var) {
        }

        e(zi3 zi3Var) {
            this.a = zi3Var;
        }
    }

    private static class h extends g {
        h(zi3 zi3Var, WindowInsets windowInsets) {
            super(zi3Var, windowInsets);
        }

        @Override // zi3.k
        zi3 a() {
            return zi3.w(this.c.consumeDisplayCutout());
        }

        @Override // zi3.f, zi3.k
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Objects.equals(this.c, hVar.c) && Objects.equals(this.g, hVar.g);
        }

        @Override // zi3.k
        jc0 f() {
            return jc0.e(this.c.getDisplayCutout());
        }

        @Override // zi3.k
        public int hashCode() {
            return this.c.hashCode();
        }

        h(zi3 zi3Var, h hVar) {
            super(zi3Var, hVar);
        }
    }

    private static class j extends i {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        static final zi3 f459q = zi3.w(WindowInsets.CONSUMED);

        j(zi3 zi3Var, WindowInsets windowInsets) {
            super(zi3Var, windowInsets);
        }

        @Override // zi3.f, zi3.k
        final void d(View view) {
        }

        @Override // zi3.f, zi3.k
        public z21 g(int i) {
            return z21.d(this.c.getInsets(m.a(i)));
        }

        j(zi3 zi3Var, j jVar) {
            super(zi3Var, jVar);
        }
    }

    private static class k {
        static final zi3 b = new a().a().a().b().c();
        final zi3 a;

        k(zi3 zi3Var) {
            this.a = zi3Var;
        }

        zi3 a() {
            return this.a;
        }

        zi3 b() {
            return this.a;
        }

        zi3 c() {
            return this.a;
        }

        void d(View view) {
        }

        void e(zi3 zi3Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return o() == kVar.o() && n() == kVar.n() && tt1.a(k(), kVar.k()) && tt1.a(i(), kVar.i()) && tt1.a(f(), kVar.f());
        }

        jc0 f() {
            return null;
        }

        z21 g(int i) {
            return z21.e;
        }

        z21 h() {
            return k();
        }

        public int hashCode() {
            return tt1.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        z21 i() {
            return z21.e;
        }

        z21 j() {
            return k();
        }

        z21 k() {
            return z21.e;
        }

        z21 l() {
            return k();
        }

        zi3 m(int i, int i2, int i3, int i4) {
            return b;
        }

        boolean n() {
            return false;
        }

        boolean o() {
            return false;
        }

        public void p(z21[] z21VarArr) {
        }

        void q(z21 z21Var) {
        }

        void r(zi3 zi3Var) {
        }

        public void s(z21 z21Var) {
        }
    }

    public static final class l {
        public static int a() {
            return 8;
        }

        static int b(int i) {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 4) {
                return 2;
            }
            if (i == 8) {
                return 3;
            }
            if (i == 16) {
                return 4;
            }
            if (i == 32) {
                return 5;
            }
            if (i == 64) {
                return 6;
            }
            if (i == 128) {
                return 7;
            }
            if (i == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
        }

        public static int c() {
            return 32;
        }

        public static int d() {
            return 7;
        }
    }

    private static final class m {
        static int a(int i) {
            int iStatusBars;
            int i2 = 0;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i & i3) != 0) {
                    if (i3 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i3 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i3 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i3 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i3 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i3 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i3 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i3 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i2 |= iStatusBars;
                }
            }
            return i2;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            b = j.f459q;
        } else {
            b = k.b;
        }
    }

    private zi3(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.a = new j(this, windowInsets);
            return;
        }
        if (i2 >= 29) {
            this.a = new i(this, windowInsets);
        } else if (i2 >= 28) {
            this.a = new h(this, windowInsets);
        } else {
            this.a = new g(this, windowInsets);
        }
    }

    static z21 o(z21 z21Var, int i2, int i3, int i4, int i5) {
        int iMax = Math.max(0, z21Var.a - i2);
        int iMax2 = Math.max(0, z21Var.b - i3);
        int iMax3 = Math.max(0, z21Var.c - i4);
        int iMax4 = Math.max(0, z21Var.d - i5);
        return (iMax == i2 && iMax2 == i3 && iMax3 == i4 && iMax4 == i5) ? z21Var : z21.b(iMax, iMax2, iMax3, iMax4);
    }

    public static zi3 w(WindowInsets windowInsets) {
        return x(windowInsets, null);
    }

    public static zi3 x(WindowInsets windowInsets, View view) {
        zi3 zi3Var = new zi3((WindowInsets) b52.g(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            zi3Var.t(be3.H(view));
            zi3Var.d(view.getRootView());
        }
        return zi3Var;
    }

    public zi3 a() {
        return this.a.a();
    }

    public zi3 b() {
        return this.a.b();
    }

    public zi3 c() {
        return this.a.c();
    }

    void d(View view) {
        this.a.d(view);
    }

    public jc0 e() {
        return this.a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zi3) {
            return tt1.a(this.a, ((zi3) obj).a);
        }
        return false;
    }

    public z21 f(int i2) {
        return this.a.g(i2);
    }

    public z21 g() {
        return this.a.i();
    }

    public z21 h() {
        return this.a.j();
    }

    public int hashCode() {
        k kVar = this.a;
        if (kVar == null) {
            return 0;
        }
        return kVar.hashCode();
    }

    public int i() {
        return this.a.k().d;
    }

    public int j() {
        return this.a.k().a;
    }

    public int k() {
        return this.a.k().c;
    }

    public int l() {
        return this.a.k().b;
    }

    public boolean m() {
        return !this.a.k().equals(z21.e);
    }

    public zi3 n(int i2, int i3, int i4, int i5) {
        return this.a.m(i2, i3, i4, i5);
    }

    public boolean p() {
        return this.a.n();
    }

    public zi3 q(int i2, int i3, int i4, int i5) {
        return new a(this).d(z21.b(i2, i3, i4, i5)).a();
    }

    void r(z21[] z21VarArr) {
        this.a.p(z21VarArr);
    }

    void s(z21 z21Var) {
        this.a.q(z21Var);
    }

    void t(zi3 zi3Var) {
        this.a.r(zi3Var);
    }

    void u(z21 z21Var) {
        this.a.s(z21Var);
    }

    public WindowInsets v() {
        k kVar = this.a;
        if (kVar instanceof f) {
            return ((f) kVar).c;
        }
        return null;
    }

    private static class b extends e {
        private static Field e = null;
        private static boolean f = false;
        private static Constructor g = null;
        private static boolean h = false;
        private WindowInsets c;
        private z21 d;

        b() {
            this.c = i();
        }

        private static WindowInsets i() {
            if (!f) {
                try {
                    e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f = true;
            }
            Field field = e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!h) {
                try {
                    g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                h = true;
            }
            Constructor constructor = g;
            if (constructor != null) {
                try {
                    return (WindowInsets) constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        @Override // zi3.e
        zi3 b() {
            a();
            zi3 zi3VarW = zi3.w(this.c);
            zi3VarW.r(this.b);
            zi3VarW.u(this.d);
            return zi3VarW;
        }

        @Override // zi3.e
        void e(z21 z21Var) {
            this.d = z21Var;
        }

        @Override // zi3.e
        void g(z21 z21Var) {
            WindowInsets windowInsets = this.c;
            if (windowInsets != null) {
                this.c = windowInsets.replaceSystemWindowInsets(z21Var.a, z21Var.b, z21Var.c, z21Var.d);
            }
        }

        b(zi3 zi3Var) {
            super(zi3Var);
            this.c = zi3Var.v();
        }
    }

    private static class c extends e {
        final WindowInsets.Builder c;

        c() {
            this.c = hj3.a();
        }

        @Override // zi3.e
        zi3 b() {
            a();
            zi3 zi3VarW = zi3.w(this.c.build());
            zi3VarW.r(this.b);
            return zi3VarW;
        }

        @Override // zi3.e
        void d(z21 z21Var) {
            this.c.setMandatorySystemGestureInsets(z21Var.e());
        }

        @Override // zi3.e
        void e(z21 z21Var) {
            this.c.setStableInsets(z21Var.e());
        }

        @Override // zi3.e
        void f(z21 z21Var) {
            this.c.setSystemGestureInsets(z21Var.e());
        }

        @Override // zi3.e
        void g(z21 z21Var) {
            this.c.setSystemWindowInsets(z21Var.e());
        }

        @Override // zi3.e
        void h(z21 z21Var) {
            this.c.setTappableElementInsets(z21Var.e());
        }

        c(zi3 zi3Var) {
            WindowInsets.Builder builderA;
            super(zi3Var);
            WindowInsets windowInsetsV = zi3Var.v();
            if (windowInsetsV != null) {
                builderA = gj3.a(windowInsetsV);
            } else {
                builderA = hj3.a();
            }
            this.c = builderA;
        }
    }

    private static class g extends f {
        private z21 m;

        g(zi3 zi3Var, WindowInsets windowInsets) {
            super(zi3Var, windowInsets);
            this.m = null;
        }

        @Override // zi3.k
        zi3 b() {
            return zi3.w(this.c.consumeStableInsets());
        }

        @Override // zi3.k
        zi3 c() {
            return zi3.w(this.c.consumeSystemWindowInsets());
        }

        @Override // zi3.k
        final z21 i() {
            if (this.m == null) {
                this.m = z21.b(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
            }
            return this.m;
        }

        @Override // zi3.k
        boolean n() {
            return this.c.isConsumed();
        }

        @Override // zi3.k
        public void s(z21 z21Var) {
            this.m = z21Var;
        }

        g(zi3 zi3Var, g gVar) {
            super(zi3Var, gVar);
            this.m = null;
            this.m = gVar.m;
        }
    }

    private static class f extends k {
        private static boolean h = false;
        private static Method i;
        private static Class j;
        private static Field k;
        private static Field l;
        final WindowInsets c;
        private z21[] d;
        private z21 e;
        private zi3 f;
        z21 g;

        f(zi3 zi3Var, WindowInsets windowInsets) {
            super(zi3Var);
            this.e = null;
            this.c = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        private z21 t(int i2, boolean z) {
            z21 z21VarA = z21.e;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    z21VarA = z21.a(z21VarA, u(i3, z));
                }
            }
            return z21VarA;
        }

        private z21 v() {
            zi3 zi3Var = this.f;
            return zi3Var != null ? zi3Var.g() : z21.e;
        }

        private z21 w(View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!h) {
                x();
            }
            Method method = i;
            if (method != null && j != null && k != null) {
                try {
                    Object objInvoke = method.invoke(view, null);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) k.get(l.get(objInvoke));
                    if (rect != null) {
                        return z21.c(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
                }
            }
            return null;
        }

        @SuppressLint({"PrivateApi"})
        private static void x() {
            try {
                i = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                j = cls;
                k = cls.getDeclaredField("mVisibleInsets");
                l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                k.setAccessible(true);
                l.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
            h = true;
        }

        @Override // zi3.k
        void d(View view) {
            z21 z21VarW = w(view);
            if (z21VarW == null) {
                z21VarW = z21.e;
            }
            q(z21VarW);
        }

        @Override // zi3.k
        void e(zi3 zi3Var) {
            zi3Var.t(this.f);
            zi3Var.s(this.g);
        }

        @Override // zi3.k
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.g, ((f) obj).g);
            }
            return false;
        }

        @Override // zi3.k
        public z21 g(int i2) {
            return t(i2, false);
        }

        @Override // zi3.k
        final z21 k() {
            if (this.e == null) {
                this.e = z21.b(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
            }
            return this.e;
        }

        @Override // zi3.k
        zi3 m(int i2, int i3, int i4, int i5) {
            a aVar = new a(zi3.w(this.c));
            aVar.d(zi3.o(k(), i2, i3, i4, i5));
            aVar.c(zi3.o(i(), i2, i3, i4, i5));
            return aVar.a();
        }

        @Override // zi3.k
        boolean o() {
            return this.c.isRound();
        }

        @Override // zi3.k
        public void p(z21[] z21VarArr) {
            this.d = z21VarArr;
        }

        @Override // zi3.k
        void q(z21 z21Var) {
            this.g = z21Var;
        }

        @Override // zi3.k
        void r(zi3 zi3Var) {
            this.f = zi3Var;
        }

        protected z21 u(int i2, boolean z) {
            z21 z21VarG;
            int i3;
            if (i2 == 1) {
                return z ? z21.b(0, Math.max(v().b, k().b), 0, 0) : z21.b(0, k().b, 0, 0);
            }
            if (i2 == 2) {
                if (z) {
                    z21 z21VarV = v();
                    z21 z21VarI = i();
                    return z21.b(Math.max(z21VarV.a, z21VarI.a), 0, Math.max(z21VarV.c, z21VarI.c), Math.max(z21VarV.d, z21VarI.d));
                }
                z21 z21VarK = k();
                zi3 zi3Var = this.f;
                z21VarG = zi3Var != null ? zi3Var.g() : null;
                int iMin = z21VarK.d;
                if (z21VarG != null) {
                    iMin = Math.min(iMin, z21VarG.d);
                }
                return z21.b(z21VarK.a, 0, z21VarK.c, iMin);
            }
            if (i2 != 8) {
                if (i2 == 16) {
                    return j();
                }
                if (i2 == 32) {
                    return h();
                }
                if (i2 == 64) {
                    return l();
                }
                if (i2 != 128) {
                    return z21.e;
                }
                zi3 zi3Var2 = this.f;
                jc0 jc0VarE = zi3Var2 != null ? zi3Var2.e() : f();
                return jc0VarE != null ? z21.b(jc0VarE.b(), jc0VarE.d(), jc0VarE.c(), jc0VarE.a()) : z21.e;
            }
            z21[] z21VarArr = this.d;
            z21VarG = z21VarArr != null ? z21VarArr[l.b(8)] : null;
            if (z21VarG != null) {
                return z21VarG;
            }
            z21 z21VarK2 = k();
            z21 z21VarV2 = v();
            int i4 = z21VarK2.d;
            if (i4 > z21VarV2.d) {
                return z21.b(0, 0, 0, i4);
            }
            z21 z21Var = this.g;
            return (z21Var == null || z21Var.equals(z21.e) || (i3 = this.g.d) <= z21VarV2.d) ? z21.e : z21.b(0, 0, 0, i3);
        }

        f(zi3 zi3Var, f fVar) {
            this(zi3Var, new WindowInsets(fVar.c));
        }
    }

    private static class i extends h {
        private z21 n;
        private z21 o;
        private z21 p;

        i(zi3 zi3Var, WindowInsets windowInsets) {
            super(zi3Var, windowInsets);
            this.n = null;
            this.o = null;
            this.p = null;
        }

        @Override // zi3.k
        z21 h() {
            if (this.o == null) {
                this.o = z21.d(this.c.getMandatorySystemGestureInsets());
            }
            return this.o;
        }

        @Override // zi3.k
        z21 j() {
            if (this.n == null) {
                this.n = z21.d(this.c.getSystemGestureInsets());
            }
            return this.n;
        }

        @Override // zi3.k
        z21 l() {
            if (this.p == null) {
                this.p = z21.d(this.c.getTappableElementInsets());
            }
            return this.p;
        }

        @Override // zi3.f, zi3.k
        zi3 m(int i, int i2, int i3, int i4) {
            return zi3.w(this.c.inset(i, i2, i3, i4));
        }

        @Override // zi3.g, zi3.k
        public void s(z21 z21Var) {
        }

        i(zi3 zi3Var, i iVar) {
            super(zi3Var, iVar);
            this.n = null;
            this.o = null;
            this.p = null;
        }
    }

    public static final class a {
        private final e a;

        public a() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.a = new d();
            } else if (i >= 29) {
                this.a = new c();
            } else {
                this.a = new b();
            }
        }

        public zi3 a() {
            return this.a.b();
        }

        public a b(int i, z21 z21Var) {
            this.a.c(i, z21Var);
            return this;
        }

        public a c(z21 z21Var) {
            this.a.e(z21Var);
            return this;
        }

        public a d(z21 z21Var) {
            this.a.g(z21Var);
            return this;
        }

        public a(zi3 zi3Var) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.a = new d(zi3Var);
            } else if (i >= 29) {
                this.a = new c(zi3Var);
            } else {
                this.a = new b(zi3Var);
            }
        }
    }

    public zi3(zi3 zi3Var) {
        if (zi3Var != null) {
            k kVar = zi3Var.a;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && (kVar instanceof j)) {
                this.a = new j(this, (j) kVar);
            } else if (i2 >= 29 && (kVar instanceof i)) {
                this.a = new i(this, (i) kVar);
            } else if (i2 >= 28 && (kVar instanceof h)) {
                this.a = new h(this, (h) kVar);
            } else if (kVar instanceof g) {
                this.a = new g(this, (g) kVar);
            } else if (kVar instanceof f) {
                this.a = new f(this, (f) kVar);
            } else {
                this.a = new k(this);
            }
            kVar.e(this);
            return;
        }
        this.a = new k(this);
    }
}
