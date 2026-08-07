package androidx.camera.core.impl;

import android.util.Range;
import defpackage.as;
import defpackage.cs;
import defpackage.pm1;
import defpackage.vz2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static final Config.a i = Config.a.a("camerax.core.captureConfig.rotation", Integer.TYPE);
    public static final Config.a j = Config.a.a("camerax.core.captureConfig.jpegQuality", Integer.class);
    private static final Config.a k = Config.a.a("camerax.core.captureConfig.resolvedFrameRate", Range.class);
    final List a;
    final Config b;
    final int c;
    final boolean d;
    final List e;
    private final boolean f;
    private final vz2 g;
    private final cs h;

    public interface b {
        void a(d0 d0Var, a aVar);
    }

    k(List list, Config config, int i2, boolean z, List list2, boolean z2, vz2 vz2Var, cs csVar) {
        this.a = list;
        this.b = config;
        this.c = i2;
        this.e = Collections.unmodifiableList(list2);
        this.f = z2;
        this.g = vz2Var;
        this.h = csVar;
        this.d = z;
    }

    public static k b() {
        return new a().h();
    }

    public List c() {
        return this.e;
    }

    public cs d() {
        return this.h;
    }

    public Range e() {
        Range range = (Range) this.b.f(k, x.a);
        Objects.requireNonNull(range);
        return range;
    }

    public int f() {
        Object objD = this.g.d("CAPTURE_CONFIG_ID_KEY");
        if (objD == null) {
            return -1;
        }
        return ((Integer) objD).intValue();
    }

    public Config g() {
        return this.b;
    }

    public int h() {
        Integer num = (Integer) this.b.f(d0.G, 0);
        Objects.requireNonNull(num);
        return num.intValue();
    }

    public List i() {
        return Collections.unmodifiableList(this.a);
    }

    public vz2 j() {
        return this.g;
    }

    public int k() {
        return this.c;
    }

    public int l() {
        Integer num = (Integer) this.b.f(d0.H, 0);
        Objects.requireNonNull(num);
        return num.intValue();
    }

    public boolean m() {
        return this.f;
    }

    public static final class a {
        private final Set a;
        private s b;
        private int c;
        private boolean d;
        private List e;
        private boolean f;
        private pm1 g;
        private cs h;

        public a() {
            this.a = new HashSet();
            this.b = t.c0();
            this.c = -1;
            this.d = false;
            this.e = new ArrayList();
            this.f = false;
            this.g = pm1.g();
        }

        public static a j(d0 d0Var) {
            b bVarT = d0Var.t(null);
            if (bVarT != null) {
                a aVar = new a();
                bVarT.a(d0Var, aVar);
                return aVar;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + d0Var.C(d0Var.toString()));
        }

        public static a k(k kVar) {
            return new a(kVar);
        }

        public void a(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                c((as) it.next());
            }
        }

        public void b(vz2 vz2Var) {
            this.g.f(vz2Var);
        }

        public void c(as asVar) {
            if (this.e.contains(asVar)) {
                return;
            }
            this.e.add(asVar);
        }

        public void d(Config.a aVar, Object obj) {
            this.b.x(aVar, obj);
        }

        public void e(Config config) {
            for (Config.a aVar : config.e()) {
                this.b.f(aVar, null);
                this.b.s(aVar, config.g(aVar), config.a(aVar));
            }
        }

        public void f(DeferrableSurface deferrableSurface) {
            this.a.add(deferrableSurface);
        }

        public void g(String str, Object obj) {
            this.g.i(str, obj);
        }

        public k h() {
            return new k(new ArrayList(this.a), u.a0(this.b), this.c, this.d, new ArrayList(this.e), this.f, vz2.c(this.g), this.h);
        }

        public void i() {
            this.a.clear();
        }

        public Range l() {
            return (Range) this.b.f(k.k, x.a);
        }

        public Set m() {
            return this.a;
        }

        public int n() {
            return this.c;
        }

        public boolean o(as asVar) {
            return this.e.remove(asVar);
        }

        public void p(cs csVar) {
            this.h = csVar;
        }

        public void q(Range range) {
            d(k.k, range);
        }

        public void r(int i) {
            this.g.i("CAPTURE_CONFIG_ID_KEY", Integer.valueOf(i));
        }

        public void s(Config config) {
            this.b = t.d0(config);
        }

        public void t(boolean z) {
            this.d = z;
        }

        public void u(int i) {
            if (i != 0) {
                d(d0.G, Integer.valueOf(i));
            }
        }

        public void v(int i) {
            this.c = i;
        }

        public void w(boolean z) {
            this.f = z;
        }

        public void x(int i) {
            if (i != 0) {
                d(d0.H, Integer.valueOf(i));
            }
        }

        private a(k kVar) {
            HashSet hashSet = new HashSet();
            this.a = hashSet;
            this.b = t.c0();
            this.c = -1;
            this.d = false;
            this.e = new ArrayList();
            this.f = false;
            this.g = pm1.g();
            hashSet.addAll(kVar.a);
            this.b = t.d0(kVar.b);
            this.c = kVar.c;
            this.e.addAll(kVar.c());
            this.f = kVar.m();
            this.g = pm1.h(kVar.j());
            this.d = kVar.d;
        }
    }
}
