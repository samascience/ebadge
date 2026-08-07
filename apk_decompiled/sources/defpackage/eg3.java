package defpackage;

import android.graphics.Rect;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.q;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.s;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.core.u;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class eg3 implements UseCase.a {
    final Set a;
    private final UseCaseConfigFactory e;
    private final CameraInternal f;
    private final Set h;
    private final Map i;
    private final zf2 j;
    final Map b = new HashMap();
    private final Map c = new HashMap();
    final Map d = new HashMap();
    private final as g = q();

    class a extends as {
        a() {
        }

        @Override // defpackage.as
        public void b(int i, cs csVar) {
            super.b(i, csVar);
            Iterator it = eg3.this.a.iterator();
            while (it.hasNext()) {
                eg3.G(csVar, ((UseCase) it.next()).t(), i);
            }
        }
    }

    eg3(CameraInternal cameraInternal, Set set, UseCaseConfigFactory useCaseConfigFactory, ev2.a aVar) {
        this.f = cameraInternal;
        this.e = useCaseConfigFactory;
        this.a = set;
        Map mapI = I(cameraInternal, set, useCaseConfigFactory);
        this.i = mapI;
        HashSet hashSet = new HashSet(mapI.values());
        this.h = hashSet;
        this.j = new zf2(cameraInternal, hashSet);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            UseCase useCase = (UseCase) it.next();
            this.d.put(useCase, Boolean.FALSE);
            this.c.put(useCase, new dg3(cameraInternal, this, aVar));
        }
    }

    private ix2 A(UseCase useCase) {
        ix2 ix2Var = (ix2) this.b.get(useCase);
        Objects.requireNonNull(ix2Var);
        return ix2Var;
    }

    private boolean B(UseCase useCase) {
        Boolean bool = (Boolean) this.d.get(useCase);
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    static void G(cs csVar, SessionConfig sessionConfig, int i) {
        Iterator it = sessionConfig.h().iterator();
        while (it.hasNext()) {
            ((as) it.next()).b(i, new fg3(sessionConfig.i().j(), csVar));
        }
    }

    private static Map I(CameraInternal cameraInternal, Set set, UseCaseConfigFactory useCaseConfigFactory) {
        HashMap map = new HashMap();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            UseCase useCase = (UseCase) it.next();
            map.put(useCase, useCase.B(cameraInternal.n(), null, useCase.k(true, useCaseConfigFactory)));
        }
        return map;
    }

    private static void r(ix2 ix2Var, DeferrableSurface deferrableSurface, SessionConfig sessionConfig) {
        ix2Var.u();
        try {
            ix2Var.B(deferrableSurface);
        } catch (DeferrableSurface.SurfaceClosedException unused) {
            Iterator it = sessionConfig.d().iterator();
            while (it.hasNext()) {
                ((SessionConfig.c) it.next()).a(sessionConfig, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
            }
        }
    }

    private static int s(UseCase useCase) {
        return useCase instanceof u ? 256 : 34;
    }

    private int t(UseCase useCase) {
        return this.f.a().k(((r) useCase.j()).U(0));
    }

    static DeferrableSurface u(UseCase useCase) {
        List listM = useCase instanceof u ? useCase.t().m() : useCase.t().i().i();
        b52.i(listM.size() <= 1);
        if (listM.size() == 1) {
            return (DeferrableSurface) listM.get(0);
        }
        return null;
    }

    private static int v(UseCase useCase) {
        if (useCase instanceof n52) {
            return 1;
        }
        return useCase instanceof u ? 4 : 2;
    }

    private static int y(Set set) {
        Iterator it = set.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, ((d0) it.next()).N(0));
        }
        return iMax;
    }

    void C(s sVar) {
        sVar.x(r.w, this.j.n(sVar));
        sVar.x(d0.B, Integer.valueOf(y(this.h)));
        ie0 ie0VarD = ne0.d(this.h);
        if (ie0VarD == null) {
            throw new IllegalArgumentException("Failed to merge child dynamic ranges, can not find a dynamic range that satisfies all children.");
        }
        sVar.x(q.m, ie0VarD);
        for (UseCase useCase : this.a) {
            if (useCase.j().G() != 0) {
                sVar.x(d0.H, Integer.valueOf(useCase.j().G()));
            }
            if (useCase.j().P() != 0) {
                sVar.x(d0.G, Integer.valueOf(useCase.j().P()));
            }
        }
    }

    void D() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((UseCase) it.next()).K();
        }
    }

    void E() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((UseCase) it.next()).L();
        }
    }

    void F() {
        t23.a();
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            d((UseCase) it.next());
        }
    }

    void H(Map map) {
        this.b.clear();
        this.b.putAll(map);
        for (Map.Entry entry : this.b.entrySet()) {
            UseCase useCase = (UseCase) entry.getKey();
            ix2 ix2Var = (ix2) entry.getValue();
            useCase.S(ix2Var.m());
            useCase.R(ix2Var.q());
            useCase.V(ix2Var.r());
            useCase.F();
        }
    }

    void J() {
        for (UseCase useCase : this.a) {
            dg3 dg3Var = (dg3) this.c.get(useCase);
            Objects.requireNonNull(dg3Var);
            useCase.T(dg3Var);
        }
    }

    @Override // androidx.camera.core.UseCase.a
    public void c(UseCase useCase) {
        t23.a();
        if (B(useCase)) {
            return;
        }
        this.d.put(useCase, Boolean.TRUE);
        DeferrableSurface deferrableSurfaceU = u(useCase);
        if (deferrableSurfaceU != null) {
            r(A(useCase), deferrableSurfaceU, useCase.t());
        }
    }

    @Override // androidx.camera.core.UseCase.a
    public void d(UseCase useCase) {
        DeferrableSurface deferrableSurfaceU;
        t23.a();
        ix2 ix2VarA = A(useCase);
        if (B(useCase) && (deferrableSurfaceU = u(useCase)) != null) {
            r(ix2VarA, deferrableSurfaceU, useCase.t());
        }
    }

    @Override // androidx.camera.core.UseCase.a
    public void f(UseCase useCase) {
        t23.a();
        if (B(useCase)) {
            ix2 ix2VarA = A(useCase);
            DeferrableSurface deferrableSurfaceU = u(useCase);
            if (deferrableSurfaceU != null) {
                r(ix2VarA, deferrableSurfaceU, useCase.t());
            } else {
                ix2VarA.l();
            }
        }
    }

    @Override // androidx.camera.core.UseCase.a
    public void o(UseCase useCase) {
        t23.a();
        if (B(useCase)) {
            this.d.put(useCase, Boolean.FALSE);
            A(useCase).l();
        }
    }

    void p() {
        for (UseCase useCase : this.a) {
            dg3 dg3Var = (dg3) this.c.get(useCase);
            Objects.requireNonNull(dg3Var);
            useCase.b(dg3Var, null, useCase.k(true, this.e));
        }
    }

    as q() {
        return new a();
    }

    Set w() {
        return this.a;
    }

    Map x(ix2 ix2Var, int i, boolean z) {
        HashMap map = new HashMap();
        int iK = this.f.a().k(i);
        boolean zL = y43.l(ix2Var.q());
        for (UseCase useCase : this.a) {
            zf2 zf2Var = this.j;
            d0 d0Var = (d0) this.i.get(useCase);
            Objects.requireNonNull(d0Var);
            Pair pairR = zf2Var.r(d0Var, ix2Var.m(), y43.g(ix2Var.q()), z);
            Rect rect = (Rect) pairR.first;
            Size size = (Size) pairR.second;
            int iT = t(useCase);
            dg3 dg3Var = (dg3) this.c.get(useCase);
            Objects.requireNonNull(dg3Var);
            dg3Var.p(iT);
            int iV = y43.v((ix2Var.p() + iT) - iK);
            map.put(useCase, SurfaceProcessorNode.c.h(v(useCase), s(useCase), rect, y43.p(size, iV), iV, useCase.A(this.f) ^ zL));
        }
        return map;
    }

    as z() {
        return this.g;
    }
}
