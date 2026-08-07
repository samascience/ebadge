package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.m;
import androidx.camera.core.v;
import defpackage.b52;
import defpackage.ie0;
import defpackage.ir2;
import defpackage.k11;
import defpackage.m03;
import defpackage.ow1;
import defpackage.qa;
import defpackage.t23;
import defpackage.vf2;
import defpackage.wf2;
import defpackage.yf2;
import defpackage.zt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public final class m extends UseCase {
    public static final d s = new d();
    private static final Boolean t = null;
    final p n;
    private final Object o;
    private a p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    SessionConfig.b f155q;
    private DeferrableSurface r;

    public interface a {
        default Size a() {
            return null;
        }

        void b(v vVar);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public static final class c implements androidx.camera.core.impl.d0.a {
        private final androidx.camera.core.impl.t a;

        public c() {
            this(androidx.camera.core.impl.t.c0());
        }

        static c d(Config config) {
            return new c(androidx.camera.core.impl.t.d0(config));
        }

        @Override // defpackage.oj0
        public androidx.camera.core.impl.s a() {
            return this.a;
        }

        public m c() {
            androidx.camera.core.impl.o oVarB = b();
            androidx.camera.core.impl.r.E(oVarB);
            return new m(oVarB);
        }

        @Override // androidx.camera.core.impl.d0.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public androidx.camera.core.impl.o b() {
            return new androidx.camera.core.impl.o(androidx.camera.core.impl.u.a0(this.a));
        }

        public c f(int i) {
            a().x(androidx.camera.core.impl.o.J, Integer.valueOf(i));
            return this;
        }

        public c g(UseCaseConfigFactory.CaptureType captureType) {
            a().x(androidx.camera.core.impl.d0.F, captureType);
            return this;
        }

        public c h(Size size) {
            a().x(androidx.camera.core.impl.r.s, size);
            return this;
        }

        public c i(ie0 ie0Var) {
            if (!Objects.equals(ie0.d, ie0Var)) {
                throw new UnsupportedOperationException("ImageAnalysis currently only supports SDR");
            }
            a().x(androidx.camera.core.impl.q.m, ie0Var);
            return this;
        }

        public c j(wf2 wf2Var) {
            a().x(androidx.camera.core.impl.r.v, wf2Var);
            return this;
        }

        public c k(int i) {
            a().x(androidx.camera.core.impl.d0.B, Integer.valueOf(i));
            return this;
        }

        public c l(int i) {
            if (i == -1) {
                i = 0;
            }
            a().x(androidx.camera.core.impl.r.n, Integer.valueOf(i));
            return this;
        }

        public c m(Class cls) {
            a().x(m03.c, cls);
            if (a().f(m03.b, null) == null) {
                n(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        public c n(String str) {
            a().x(m03.b, str);
            return this;
        }

        private c(androidx.camera.core.impl.t tVar) {
            this.a = tVar;
            Class cls = (Class) tVar.f(m03.c, null);
            if (cls == null || cls.equals(m.class)) {
                g(UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS);
                m(m.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }
    }

    public static final class d {
        private static final Size a;
        private static final ie0 b;
        private static final wf2 c;
        private static final androidx.camera.core.impl.o d;

        static {
            Size size = new Size(640, 480);
            a = size;
            ie0 ie0Var = ie0.d;
            b = ie0Var;
            wf2 wf2VarA = new wf2.a().d(qa.c).f(new yf2(ir2.c, 1)).a();
            c = wf2VarA;
            d = new c().h(size).k(1).l(0).j(wf2VarA).i(ie0Var).b();
        }

        public androidx.camera.core.impl.o a() {
            return d;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    m(androidx.camera.core.impl.o oVar) {
        super(oVar);
        this.o = new Object();
        if (((androidx.camera.core.impl.o) j()).Y(0) == 1) {
            this.n = new q();
        } else {
            this.n = new r(oVar.S(androidx.camera.core.impl.utils.executor.c.c()));
        }
        this.n.t(g0());
        this.n.u(i0());
    }

    private boolean h0(CameraInternal cameraInternal) {
        return i0() && q(cameraInternal) % Opcodes.GETFIELD != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j0(b0 b0Var, b0 b0Var2) {
        b0Var.m();
        if (b0Var2 != null) {
            b0Var2.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(String str, androidx.camera.core.impl.o oVar, androidx.camera.core.impl.x xVar, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        b0();
        this.n.g();
        if (y(str)) {
            U(c0(str, oVar, xVar).p());
            E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List l0(Size size, List list, int i) {
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.contains(size)) {
            arrayList.remove(size);
            arrayList.add(0, size);
        }
        return arrayList;
    }

    private void o0() {
        CameraInternal cameraInternalG = g();
        if (cameraInternalG != null) {
            this.n.w(q(cameraInternalG));
        }
    }

    @Override // androidx.camera.core.UseCase
    public void H() {
        this.n.f();
    }

    @Override // androidx.camera.core.UseCase
    protected androidx.camera.core.impl.d0 J(zt ztVar, androidx.camera.core.impl.d0.a aVar) {
        final Size sizeA;
        Boolean boolF0 = f0();
        boolean zA = ztVar.m().a(ow1.class);
        p pVar = this.n;
        if (boolF0 != null) {
            zA = boolF0.booleanValue();
        }
        pVar.s(zA);
        synchronized (this.o) {
            try {
                a aVar2 = this.p;
                sizeA = aVar2 != null ? aVar2.a() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (sizeA == null) {
            return aVar.b();
        }
        if (ztVar.k(((Integer) aVar.a().f(androidx.camera.core.impl.r.o, 0)).intValue()) % Opcodes.GETFIELD == 90) {
            sizeA = new Size(sizeA.getHeight(), sizeA.getWidth());
        }
        androidx.camera.core.impl.d0 d0VarB = aVar.b();
        Config.a aVar3 = androidx.camera.core.impl.r.r;
        if (!d0VarB.b(aVar3)) {
            aVar.a().x(aVar3, sizeA);
        }
        androidx.camera.core.impl.d0 d0VarB2 = aVar.b();
        Config.a aVar4 = androidx.camera.core.impl.r.v;
        if (d0VarB2.b(aVar4)) {
            wf2 wf2Var = (wf2) c().f(aVar4, null);
            wf2.a aVar5 = wf2Var == null ? new wf2.a() : wf2.a.b(wf2Var);
            if (wf2Var == null || wf2Var.d() == null) {
                aVar5.f(new yf2(sizeA, 1));
            }
            if (wf2Var == null) {
                aVar5.e(new vf2() { // from class: iz0
                    @Override // defpackage.vf2
                    public final List a(List list, int i) {
                        return m.l0(sizeA, list, i);
                    }
                });
            }
            aVar.a().x(aVar4, aVar5.a());
        }
        return aVar.b();
    }

    @Override // androidx.camera.core.UseCase
    protected androidx.camera.core.impl.x M(Config config) {
        this.f155q.h(config);
        U(this.f155q.p());
        return e().f().d(config).a();
    }

    @Override // androidx.camera.core.UseCase
    protected androidx.camera.core.impl.x N(androidx.camera.core.impl.x xVar) {
        SessionConfig.b bVarC0 = c0(i(), (androidx.camera.core.impl.o) j(), xVar);
        this.f155q = bVarC0;
        U(bVarC0.p());
        return xVar;
    }

    @Override // androidx.camera.core.UseCase
    public void O() {
        b0();
        this.n.j();
    }

    @Override // androidx.camera.core.UseCase
    public void R(Matrix matrix) {
        super.R(matrix);
        this.n.x(matrix);
    }

    @Override // androidx.camera.core.UseCase
    public void S(Rect rect) {
        super.S(rect);
        this.n.y(rect);
    }

    void b0() {
        t23.a();
        DeferrableSurface deferrableSurface = this.r;
        if (deferrableSurface != null) {
            deferrableSurface.d();
            this.r = null;
        }
    }

    SessionConfig.b c0(final String str, final androidx.camera.core.impl.o oVar, final androidx.camera.core.impl.x xVar) {
        t23.a();
        Size sizeE = xVar.e();
        Executor executor = (Executor) b52.g(oVar.S(androidx.camera.core.impl.utils.executor.c.c()));
        boolean z = true;
        int iE0 = d0() == 1 ? e0() : 4;
        oVar.a0();
        final b0 b0Var = new b0(w.a(sizeE.getWidth(), sizeE.getHeight(), m(), iE0));
        boolean zH0 = g() != null ? h0(g()) : false;
        int height = zH0 ? sizeE.getHeight() : sizeE.getWidth();
        int width = zH0 ? sizeE.getWidth() : sizeE.getHeight();
        int i = g0() == 2 ? 1 : 35;
        boolean z2 = m() == 35 && g0() == 2;
        if (m() != 35 || ((g() == null || q(g()) == 0) && !Boolean.TRUE.equals(f0()))) {
            z = false;
        }
        final b0 b0Var2 = (z2 || z) ? new b0(w.a(height, width, i, b0Var.g())) : null;
        if (b0Var2 != null) {
            this.n.v(b0Var2);
        }
        o0();
        b0Var.f(this.n, executor);
        SessionConfig.b bVarR = SessionConfig.b.r(oVar, xVar.e());
        if (xVar.d() != null) {
            bVarR.h(xVar.d());
        }
        DeferrableSurface deferrableSurface = this.r;
        if (deferrableSurface != null) {
            deferrableSurface.d();
        }
        k11 k11Var = new k11(b0Var.a(), sizeE, m());
        this.r = k11Var;
        k11Var.k().a(new Runnable() { // from class: gz0
            @Override // java.lang.Runnable
            public final void run() {
                m.j0(b0Var, b0Var2);
            }
        }, androidx.camera.core.impl.utils.executor.c.e());
        bVarR.u(xVar.c());
        bVarR.n(this.r, xVar.b(), null, -1);
        bVarR.g(new SessionConfig.c() { // from class: hz0
            @Override // androidx.camera.core.impl.SessionConfig.c
            public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                this.a.k0(str, oVar, xVar, sessionConfig, sessionError);
            }
        });
        return bVarR;
    }

    public int d0() {
        return ((androidx.camera.core.impl.o) j()).Y(0);
    }

    public int e0() {
        return ((androidx.camera.core.impl.o) j()).Z(6);
    }

    public Boolean f0() {
        return ((androidx.camera.core.impl.o) j()).b0(t);
    }

    public int g0() {
        return ((androidx.camera.core.impl.o) j()).c0(1);
    }

    public boolean i0() {
        return ((androidx.camera.core.impl.o) j()).d0(Boolean.FALSE).booleanValue();
    }

    @Override // androidx.camera.core.UseCase
    public androidx.camera.core.impl.d0 k(boolean z, UseCaseConfigFactory useCaseConfigFactory) {
        d dVar = s;
        Config configA = useCaseConfigFactory.a(dVar.a().F(), 1);
        if (z) {
            configA = Config.I(configA, dVar.a());
        }
        if (configA == null) {
            return null;
        }
        return w(configA).b();
    }

    public void n0(Executor executor, final a aVar) {
        synchronized (this.o) {
            try {
                this.n.r(executor, new a() { // from class: jz0
                    @Override // androidx.camera.core.m.a
                    public final void b(v vVar) {
                        aVar.b(vVar);
                    }
                });
                if (this.p == null) {
                    C();
                }
                this.p = aVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return "ImageAnalysis:" + o();
    }

    @Override // androidx.camera.core.UseCase
    public androidx.camera.core.impl.d0.a w(Config config) {
        return c.d(config);
    }
}
