package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Log;
import android.util.Size;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.q;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.x;
import androidx.camera.core.processing.SurfaceProcessorNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ev2 extends UseCase {
    private final gv2 n;
    private final eg3 o;
    private SurfaceProcessorNode p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private SurfaceProcessorNode f330q;
    private ix2 r;
    private ix2 s;
    SessionConfig.b t;

    interface a {
        ub1 a(int i, int i2);
    }

    public ev2(CameraInternal cameraInternal, Set set, UseCaseConfigFactory useCaseConfigFactory) {
        super(f0(set));
        this.n = f0(set);
        this.o = new eg3(cameraInternal, set, useCaseConfigFactory, new a() { // from class: dv2
            @Override // ev2.a
            public final ub1 a(int i, int i2) {
                return this.a.k0(i, i2);
            }
        });
    }

    private void Z(SessionConfig.b bVar, final String str, final d0 d0Var, final x xVar) {
        bVar.g(new SessionConfig.c() { // from class: cv2
            @Override // androidx.camera.core.impl.SessionConfig.c
            public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                this.a.j0(str, d0Var, xVar, sessionConfig, sessionError);
            }
        });
    }

    private void a0() {
        ix2 ix2Var = this.r;
        if (ix2Var != null) {
            ix2Var.i();
            this.r = null;
        }
        ix2 ix2Var2 = this.s;
        if (ix2Var2 != null) {
            ix2Var2.i();
            this.s = null;
        }
        SurfaceProcessorNode surfaceProcessorNode = this.f330q;
        if (surfaceProcessorNode != null) {
            surfaceProcessorNode.i();
            this.f330q = null;
        }
        SurfaceProcessorNode surfaceProcessorNode2 = this.p;
        if (surfaceProcessorNode2 != null) {
            surfaceProcessorNode2.i();
            this.p = null;
        }
    }

    private SessionConfig b0(String str, d0 d0Var, x xVar) {
        t23.a();
        CameraInternal cameraInternal = (CameraInternal) b52.g(g());
        Matrix matrixS = s();
        boolean zM = cameraInternal.m();
        Rect rectE0 = e0(xVar.e());
        Objects.requireNonNull(rectE0);
        ix2 ix2Var = new ix2(3, 34, xVar, matrixS, zM, rectE0, q(cameraInternal), -1, A(cameraInternal));
        this.r = ix2Var;
        this.s = g0(ix2Var, cameraInternal);
        this.f330q = h0(cameraInternal, xVar);
        Map mapX = this.o.x(this.s, v(), x() != null);
        SurfaceProcessorNode.Out outM = this.f330q.m(SurfaceProcessorNode.b.c(this.s, new ArrayList(mapX.values())));
        HashMap map = new HashMap();
        for (Map.Entry entry : mapX.entrySet()) {
            map.put((UseCase) entry.getKey(), outM.get(entry.getValue()));
        }
        this.o.H(map);
        SessionConfig.b bVarR = SessionConfig.b.r(d0Var, xVar.e());
        l0(xVar.e(), bVarR);
        bVarR.n(this.r.n(), xVar.b(), null, -1);
        bVarR.k(this.o.z());
        if (xVar.d() != null) {
            bVarR.h(xVar.d());
        }
        Z(bVarR, str, d0Var, xVar);
        this.t = bVarR;
        return bVarR.p();
    }

    public static List c0(UseCase useCase) {
        ArrayList arrayList = new ArrayList();
        if (i0(useCase)) {
            Iterator it = ((ev2) useCase).d0().iterator();
            while (it.hasNext()) {
                arrayList.add(((UseCase) it.next()).j().F());
            }
        } else {
            arrayList.add(useCase.j().F());
        }
        return arrayList;
    }

    private Rect e0(Size size) {
        return x() != null ? x() : new Rect(0, 0, size.getWidth(), size.getHeight());
    }

    private static gv2 f0(Set set) {
        s sVarA = new fv2().a();
        sVarA.x(q.l, 34);
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            UseCase useCase = (UseCase) it.next();
            if (useCase.j().b(d0.F)) {
                arrayList.add(useCase.j().F());
            } else {
                Log.e("StreamSharing", "A child does not have capture type.");
            }
        }
        sVarA.x(gv2.J, arrayList);
        sVarA.x(r.f153q, 2);
        return new gv2(u.a0(sVarA));
    }

    private ix2 g0(ix2 ix2Var, CameraInternal cameraInternal) {
        l();
        return ix2Var;
    }

    private SurfaceProcessorNode h0(CameraInternal cameraInternal, x xVar) {
        l();
        return new SurfaceProcessorNode(cameraInternal, w80.a.a(xVar.b()));
    }

    public static boolean i0(UseCase useCase) {
        return useCase instanceof ev2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(String str, d0 d0Var, x xVar, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        a0();
        if (y(str)) {
            U(b0(str, d0Var, xVar));
            E();
            this.o.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ub1 k0(int i, int i2) {
        SurfaceProcessorNode surfaceProcessorNode = this.f330q;
        return surfaceProcessorNode != null ? surfaceProcessorNode.e().c(i, i2) : os0.n(new Exception("Failed to take picture: pipeline is not ready."));
    }

    private void l0(Size size, SessionConfig.b bVar) {
        Iterator it = d0().iterator();
        while (it.hasNext()) {
            SessionConfig sessionConfigP = SessionConfig.b.r(((UseCase) it.next()).j(), size).p();
            bVar.c(sessionConfigP.h());
            bVar.a(sessionConfigP.l());
            bVar.d(sessionConfigP.j());
            bVar.b(sessionConfigP.c());
            bVar.h(sessionConfigP.e());
        }
    }

    @Override // androidx.camera.core.UseCase
    public void H() {
        super.H();
        this.o.p();
    }

    @Override // androidx.camera.core.UseCase
    protected d0 J(zt ztVar, d0.a aVar) {
        this.o.C(aVar.a());
        return aVar.b();
    }

    @Override // androidx.camera.core.UseCase
    public void K() {
        super.K();
        this.o.D();
    }

    @Override // androidx.camera.core.UseCase
    public void L() {
        super.L();
        this.o.E();
    }

    @Override // androidx.camera.core.UseCase
    protected x M(Config config) {
        this.t.h(config);
        U(this.t.p());
        return e().f().d(config).a();
    }

    @Override // androidx.camera.core.UseCase
    protected x N(x xVar) {
        U(b0(i(), j(), xVar));
        C();
        return xVar;
    }

    @Override // androidx.camera.core.UseCase
    public void O() {
        super.O();
        a0();
        this.o.J();
    }

    public Set d0() {
        return this.o.w();
    }

    @Override // androidx.camera.core.UseCase
    public d0 k(boolean z, UseCaseConfigFactory useCaseConfigFactory) {
        Config configA = useCaseConfigFactory.a(this.n.F(), 1);
        if (z) {
            configA = Config.I(configA, this.n.n());
        }
        if (configA == null) {
            return null;
        }
        return w(configA).b();
    }

    @Override // androidx.camera.core.UseCase
    public Set u() {
        HashSet hashSet = new HashSet();
        hashSet.add(3);
        return hashSet;
    }

    @Override // androidx.camera.core.UseCase
    public d0.a w(Config config) {
        return new fv2(t.d0(config));
    }
}
