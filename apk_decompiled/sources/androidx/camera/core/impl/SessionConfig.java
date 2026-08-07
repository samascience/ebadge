package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.util.Range;
import android.util.Size;
import defpackage.as;
import defpackage.fy2;
import defpackage.ie0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class SessionConfig {
    private final List a;
    private final e b;
    private final List c;
    private final List d;
    private final List e;
    private final List f;
    private final k g;
    private final int h;
    private InputConfiguration i;

    public enum SessionError {
        SESSION_ERROR_SURFACE_NEEDS_RESET,
        SESSION_ERROR_UNKNOWN
    }

    static class a {
        InputConfiguration g;
        e i;
        final Set a = new LinkedHashSet();
        final k.a b = new k.a();
        final List c = new ArrayList();
        final List d = new ArrayList();
        final List e = new ArrayList();
        final List f = new ArrayList();
        int h = 0;

        a() {
        }
    }

    public static class b extends a {
        public static b r(d0 d0Var, Size size) {
            d dVarT = d0Var.T(null);
            if (dVarT != null) {
                b bVar = new b();
                dVarT.a(size, d0Var, bVar);
                return bVar;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + d0Var.C(d0Var.toString()));
        }

        public b A(int i) {
            if (i != 0) {
                this.b.x(i);
            }
            return this;
        }

        public b a(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                as asVar = (as) it.next();
                this.b.c(asVar);
                if (!this.f.contains(asVar)) {
                    this.f.add(asVar);
                }
            }
            return this;
        }

        public b b(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                f((CameraDevice.StateCallback) it.next());
            }
            return this;
        }

        public b c(Collection collection) {
            this.b.a(collection);
            return this;
        }

        public b d(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                l((CameraCaptureSession.StateCallback) it.next());
            }
            return this;
        }

        public b e(as asVar) {
            this.b.c(asVar);
            if (!this.f.contains(asVar)) {
                this.f.add(asVar);
            }
            return this;
        }

        public b f(CameraDevice.StateCallback stateCallback) {
            if (this.c.contains(stateCallback)) {
                return this;
            }
            this.c.add(stateCallback);
            return this;
        }

        public b g(c cVar) {
            this.e.add(cVar);
            return this;
        }

        public b h(Config config) {
            this.b.e(config);
            return this;
        }

        public b i(DeferrableSurface deferrableSurface) {
            return j(deferrableSurface, ie0.d);
        }

        public b j(DeferrableSurface deferrableSurface, ie0 ie0Var) {
            this.a.add(e.a(deferrableSurface).b(ie0Var).a());
            return this;
        }

        public b k(as asVar) {
            this.b.c(asVar);
            return this;
        }

        public b l(CameraCaptureSession.StateCallback stateCallback) {
            if (this.d.contains(stateCallback)) {
                return this;
            }
            this.d.add(stateCallback);
            return this;
        }

        public b m(DeferrableSurface deferrableSurface) {
            return n(deferrableSurface, ie0.d, null, -1);
        }

        public b n(DeferrableSurface deferrableSurface, ie0 ie0Var, String str, int i) {
            this.a.add(e.a(deferrableSurface).d(str).b(ie0Var).c(i).a());
            this.b.f(deferrableSurface);
            return this;
        }

        public b o(String str, Object obj) {
            this.b.g(str, obj);
            return this;
        }

        public SessionConfig p() {
            return new SessionConfig(new ArrayList(this.a), new ArrayList(this.c), new ArrayList(this.d), new ArrayList(this.f), new ArrayList(this.e), this.b.h(), this.g, this.h, this.i);
        }

        public b q() {
            this.a.clear();
            this.b.i();
            return this;
        }

        public List s() {
            return Collections.unmodifiableList(this.f);
        }

        public boolean t(as asVar) {
            return this.b.o(asVar) || this.f.remove(asVar);
        }

        public b u(Range range) {
            this.b.q(range);
            return this;
        }

        public b v(Config config) {
            this.b.s(config);
            return this;
        }

        public b w(InputConfiguration inputConfiguration) {
            this.g = inputConfiguration;
            return this;
        }

        public b x(DeferrableSurface deferrableSurface) {
            this.i = e.a(deferrableSurface).a();
            return this;
        }

        public b y(int i) {
            if (i != 0) {
                this.b.u(i);
            }
            return this;
        }

        public b z(int i) {
            this.b.v(i);
            return this;
        }
    }

    public interface c {
        void a(SessionConfig sessionConfig, SessionError sessionError);
    }

    public interface d {
        void a(Size size, d0 d0Var, b bVar);
    }

    public static abstract class e {

        public static abstract class a {
            public abstract e a();

            public abstract a b(ie0 ie0Var);

            public abstract a c(int i);

            public abstract a d(String str);

            public abstract a e(List list);

            public abstract a f(int i);
        }

        public static a a(DeferrableSurface deferrableSurface) {
            return new androidx.camera.core.impl.d.b().g(deferrableSurface).e(Collections.emptyList()).d(null).c(-1).f(-1).b(ie0.d);
        }

        public abstract ie0 b();

        public abstract int c();

        public abstract String d();

        public abstract List e();

        public abstract DeferrableSurface f();

        public abstract int g();
    }

    public static final class f extends a {
        private static final List m = Arrays.asList(1, 5, 3);
        private final fy2 j = new fy2();
        private boolean k = true;
        private boolean l = false;

        private List c() {
            ArrayList arrayList = new ArrayList();
            for (e eVar : this.a) {
                arrayList.add(eVar.f());
                Iterator it = eVar.e().iterator();
                while (it.hasNext()) {
                    arrayList.add((DeferrableSurface) it.next());
                }
            }
            return arrayList;
        }

        private int e(int i, int i2) {
            List list = m;
            return list.indexOf(Integer.valueOf(i)) >= list.indexOf(Integer.valueOf(i2)) ? i : i2;
        }

        private void f(Range range) {
            Range range2 = x.a;
            if (range.equals(range2)) {
                return;
            }
            if (this.b.l().equals(range2)) {
                this.b.q(range);
            } else {
                if (this.b.l().equals(range)) {
                    return;
                }
                this.k = false;
                androidx.camera.core.x.a("ValidatingBuilder", "Different ExpectedFrameRateRange values");
            }
        }

        private void g(int i) {
            if (i != 0) {
                this.b.u(i);
            }
        }

        private void h(int i) {
            if (i != 0) {
                this.b.x(i);
            }
        }

        public void a(SessionConfig sessionConfig) {
            k kVarI = sessionConfig.i();
            if (kVarI.k() != -1) {
                this.l = true;
                this.b.v(e(kVarI.k(), this.b.n()));
            }
            f(kVarI.e());
            g(kVarI.h());
            h(kVarI.l());
            this.b.b(sessionConfig.i().j());
            this.c.addAll(sessionConfig.c());
            this.d.addAll(sessionConfig.j());
            this.b.a(sessionConfig.h());
            this.f.addAll(sessionConfig.l());
            this.e.addAll(sessionConfig.d());
            if (sessionConfig.f() != null) {
                this.g = sessionConfig.f();
            }
            this.a.addAll(sessionConfig.g());
            this.b.m().addAll(kVarI.i());
            if (!c().containsAll(this.b.m())) {
                androidx.camera.core.x.a("ValidatingBuilder", "Invalid configuration due to capture request surfaces are not a subset of surfaces");
                this.k = false;
            }
            if (sessionConfig.k() != this.h && sessionConfig.k() != 0 && this.h != 0) {
                androidx.camera.core.x.a("ValidatingBuilder", "Invalid configuration due to that two non-default session types are set");
                this.k = false;
            } else if (sessionConfig.k() != 0) {
                this.h = sessionConfig.k();
            }
            if (sessionConfig.b != null) {
                if (this.i == sessionConfig.b || this.i == null) {
                    this.i = sessionConfig.b;
                } else {
                    androidx.camera.core.x.a("ValidatingBuilder", "Invalid configuration due to that two different postview output configs are set");
                    this.k = false;
                }
            }
            this.b.e(kVarI.g());
        }

        public SessionConfig b() {
            if (!this.k) {
                throw new IllegalArgumentException("Unsupported session configuration combination");
            }
            ArrayList arrayList = new ArrayList(this.a);
            this.j.d(arrayList);
            return new SessionConfig(arrayList, new ArrayList(this.c), new ArrayList(this.d), new ArrayList(this.f), new ArrayList(this.e), this.b.h(), this.g, this.h, this.i);
        }

        public boolean d() {
            return this.l && this.k;
        }
    }

    SessionConfig(List list, List list2, List list3, List list4, List list5, k kVar, InputConfiguration inputConfiguration, int i, e eVar) {
        this.a = list;
        this.c = Collections.unmodifiableList(list2);
        this.d = Collections.unmodifiableList(list3);
        this.e = Collections.unmodifiableList(list4);
        this.f = Collections.unmodifiableList(list5);
        this.g = kVar;
        this.i = inputConfiguration;
        this.h = i;
        this.b = eVar;
    }

    public static SessionConfig b() {
        return new SessionConfig(new ArrayList(), new ArrayList(0), new ArrayList(0), new ArrayList(0), new ArrayList(0), new k.a().h(), null, 0, null);
    }

    public List c() {
        return this.c;
    }

    public List d() {
        return this.f;
    }

    public Config e() {
        return this.g.g();
    }

    public InputConfiguration f() {
        return this.i;
    }

    public List g() {
        return this.a;
    }

    public List h() {
        return this.g.c();
    }

    public k i() {
        return this.g;
    }

    public List j() {
        return this.d;
    }

    public int k() {
        return this.h;
    }

    public List l() {
        return this.e;
    }

    public List m() {
        ArrayList arrayList = new ArrayList();
        for (e eVar : this.a) {
            arrayList.add(eVar.f());
            Iterator it = eVar.e().iterator();
            while (it.hasNext()) {
                arrayList.add((DeferrableSurface) it.next());
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int n() {
        return this.g.k();
    }
}
