package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.q;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.x;
import androidx.camera.core.processing.SurfaceProcessorNode;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class n52 extends UseCase {
    public static final b u = new b();
    private static final Executor v = androidx.camera.core.impl.utils.executor.c.e();
    private c n;
    private Executor o;
    SessionConfig.b p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private DeferrableSurface f361q;
    private ix2 r;
    SurfaceRequest s;
    private SurfaceProcessorNode t;

    public static final class a implements d0.a {
        private final t a;

        public a() {
            this(t.c0());
        }

        static a d(Config config) {
            return new a(t.d0(config));
        }

        @Override // defpackage.oj0
        public s a() {
            return this.a;
        }

        public n52 c() {
            v vVarB = b();
            r.E(vVarB);
            return new n52(vVarB);
        }

        @Override // androidx.camera.core.impl.d0.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public v b() {
            return new v(u.a0(this.a));
        }

        public a f(UseCaseConfigFactory.CaptureType captureType) {
            a().x(d0.F, captureType);
            return this;
        }

        public a g(ie0 ie0Var) {
            a().x(q.m, ie0Var);
            return this;
        }

        public a h(wf2 wf2Var) {
            a().x(r.v, wf2Var);
            return this;
        }

        public a i(int i) {
            a().x(d0.B, Integer.valueOf(i));
            return this;
        }

        public a j(int i) {
            if (i == -1) {
                i = 0;
            }
            a().x(r.n, Integer.valueOf(i));
            return this;
        }

        public a k(Class cls) {
            a().x(m03.c, cls);
            if (a().f(m03.b, null) == null) {
                l(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        public a l(String str) {
            a().x(m03.b, str);
            return this;
        }

        private a(t tVar) {
            this.a = tVar;
            Class cls = (Class) tVar.f(m03.c, null);
            if (cls != null && !cls.equals(n52.class)) {
                throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
            }
            f(UseCaseConfigFactory.CaptureType.PREVIEW);
            k(n52.class);
            Config.a aVar = r.f153q;
            if (((Integer) tVar.f(aVar, -1)).intValue() == -1) {
                tVar.x(aVar, 2);
            }
        }
    }

    public static final class b {
        private static final wf2 a;
        private static final v b;
        private static final ie0 c;

        static {
            wf2 wf2VarA = new wf2.a().d(qa.c).f(yf2.c).a();
            a = wf2VarA;
            ie0 ie0Var = ie0.c;
            c = ie0Var;
            b = new a().i(2).j(0).h(wf2VarA).g(ie0Var).b();
        }

        public v a() {
            return b;
        }
    }

    public interface c {
        void a(SurfaceRequest surfaceRequest);
    }

    n52(v vVar) {
        super(vVar);
        this.o = v;
    }

    private void Z(SessionConfig.b bVar, final String str, final v vVar, final x xVar) {
        if (this.n != null) {
            bVar.n(this.f361q, xVar.b(), p(), n());
        }
        bVar.g(new SessionConfig.c() { // from class: m52
            @Override // androidx.camera.core.impl.SessionConfig.c
            public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                this.a.d0(str, vVar, xVar, sessionConfig, sessionError);
            }
        });
    }

    private void a0() {
        DeferrableSurface deferrableSurface = this.f361q;
        if (deferrableSurface != null) {
            deferrableSurface.d();
            this.f361q = null;
        }
        SurfaceProcessorNode surfaceProcessorNode = this.t;
        if (surfaceProcessorNode != null) {
            surfaceProcessorNode.i();
            this.t = null;
        }
        ix2 ix2Var = this.r;
        if (ix2Var != null) {
            ix2Var.i();
            this.r = null;
        }
        this.s = null;
    }

    private SessionConfig.b b0(String str, v vVar, x xVar) {
        t23.a();
        CameraInternal cameraInternalG = g();
        Objects.requireNonNull(cameraInternalG);
        CameraInternal cameraInternal = cameraInternalG;
        a0();
        b52.i(this.r == null);
        Matrix matrixS = s();
        boolean zM = cameraInternal.m();
        Rect rectC0 = c0(xVar.e());
        Objects.requireNonNull(rectC0);
        this.r = new ix2(1, 34, xVar, matrixS, zM, rectC0, r(cameraInternal, A(cameraInternal)), d(), j0(cameraInternal));
        l();
        this.r.e(new Runnable() { // from class: androidx.camera.core.z
            @Override // java.lang.Runnable
            public final void run() {
                this.a.E();
            }
        });
        SurfaceRequest surfaceRequestK = this.r.k(cameraInternal);
        this.s = surfaceRequestK;
        this.f361q = surfaceRequestK.l();
        if (this.n != null) {
            f0();
        }
        SessionConfig.b bVarR = SessionConfig.b.r(vVar, xVar.e());
        bVarR.u(xVar.c());
        bVarR.y(vVar.P());
        if (xVar.d() != null) {
            bVarR.h(xVar.d());
        }
        Z(bVarR, str, vVar, xVar);
        return bVarR;
    }

    private Rect c0(Size size) {
        if (x() != null) {
            return x();
        }
        if (size != null) {
            return new Rect(0, 0, size.getWidth(), size.getHeight());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(String str, v vVar, x xVar, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        if (y(str)) {
            U(b0(str, vVar, xVar).p());
            E();
        }
    }

    private void f0() {
        g0();
        final c cVar = (c) b52.g(this.n);
        final SurfaceRequest surfaceRequest = (SurfaceRequest) b52.g(this.s);
        this.o.execute(new Runnable() { // from class: l52
            @Override // java.lang.Runnable
            public final void run() {
                cVar.a(surfaceRequest);
            }
        });
    }

    private void g0() {
        CameraInternal cameraInternalG = g();
        ix2 ix2Var = this.r;
        if (cameraInternalG == null || ix2Var == null) {
            return;
        }
        ix2Var.C(r(cameraInternalG, A(cameraInternalG)), d());
    }

    private boolean j0(CameraInternal cameraInternal) {
        return cameraInternal.m() && A(cameraInternal);
    }

    private void k0(String str, v vVar, x xVar) {
        SessionConfig.b bVarB0 = b0(str, vVar, xVar);
        this.p = bVarB0;
        U(bVarB0.p());
    }

    @Override // androidx.camera.core.UseCase
    protected d0 J(zt ztVar, d0.a aVar) {
        aVar.a().x(q.l, 34);
        return aVar.b();
    }

    @Override // androidx.camera.core.UseCase
    protected x M(Config config) {
        this.p.h(config);
        U(this.p.p());
        return e().f().d(config).a();
    }

    @Override // androidx.camera.core.UseCase
    protected x N(x xVar) {
        k0(i(), (v) j(), xVar);
        return xVar;
    }

    @Override // androidx.camera.core.UseCase
    public void O() {
        a0();
    }

    @Override // androidx.camera.core.UseCase
    public void S(Rect rect) {
        super.S(rect);
        g0();
    }

    public void h0(c cVar) {
        i0(v, cVar);
    }

    public void i0(Executor executor, c cVar) {
        t23.a();
        if (cVar == null) {
            this.n = null;
            D();
            return;
        }
        this.n = cVar;
        this.o = executor;
        if (f() != null) {
            k0(i(), (v) j(), e());
            E();
        }
        C();
    }

    @Override // androidx.camera.core.UseCase
    public d0 k(boolean z, UseCaseConfigFactory useCaseConfigFactory) {
        b bVar = u;
        Config configA = useCaseConfigFactory.a(bVar.a().F(), 1);
        if (z) {
            configA = Config.I(configA, bVar.a());
        }
        if (configA == null) {
            return null;
        }
        return w(configA).b();
    }

    public String toString() {
        return "Preview:" + o();
    }

    @Override // androidx.camera.core.UseCase
    public Set u() {
        HashSet hashSet = new HashSet();
        hashSet.add(1);
        return hashSet;
    }

    @Override // androidx.camera.core.UseCase
    public d0.a w(Config config) {
        return a.d(config);
    }
}
