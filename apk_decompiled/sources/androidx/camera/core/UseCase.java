package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import defpackage.b52;
import defpackage.m03;
import defpackage.s03;
import defpackage.tt;
import defpackage.wf2;
import defpackage.y43;
import defpackage.zt;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class UseCase {
    private androidx.camera.core.impl.d0 d;
    private androidx.camera.core.impl.d0 e;
    private androidx.camera.core.impl.d0 f;
    private androidx.camera.core.impl.x g;
    private androidx.camera.core.impl.d0 h;
    private Rect i;
    private CameraInternal k;
    private String l;
    private final Set a = new HashSet();
    private final Object b = new Object();
    private State c = State.INACTIVE;
    private Matrix j = new Matrix();
    private SessionConfig m = SessionConfig.b();

    enum State {
        ACTIVE,
        INACTIVE
    }

    public interface a {
        void c(UseCase useCase);

        void d(UseCase useCase);

        void f(UseCase useCase);

        void o(UseCase useCase);
    }

    protected UseCase(androidx.camera.core.impl.d0 d0Var) {
        this.e = d0Var;
        this.f = d0Var;
    }

    private void P(a aVar) {
        this.a.remove(aVar);
    }

    private void a(a aVar) {
        this.a.add(aVar);
    }

    public boolean A(CameraInternal cameraInternal) {
        int iN = n();
        if (iN == -1 || iN == 0) {
            return false;
        }
        if (iN == 1) {
            return true;
        }
        if (iN == 2) {
            return cameraInternal.b();
        }
        throw new AssertionError("Unknown mirrorMode: " + iN);
    }

    public androidx.camera.core.impl.d0 B(zt ztVar, androidx.camera.core.impl.d0 d0Var, androidx.camera.core.impl.d0 d0Var2) {
        androidx.camera.core.impl.t tVarC0;
        if (d0Var2 != null) {
            tVarC0 = androidx.camera.core.impl.t.d0(d0Var2);
            tVarC0.e0(m03.b);
        } else {
            tVarC0 = androidx.camera.core.impl.t.c0();
        }
        if (this.e.b(androidx.camera.core.impl.r.n) || this.e.b(androidx.camera.core.impl.r.r)) {
            Config.a aVar = androidx.camera.core.impl.r.v;
            if (tVarC0.b(aVar)) {
                tVarC0.e0(aVar);
            }
        }
        androidx.camera.core.impl.d0 d0Var3 = this.e;
        Config.a aVar2 = androidx.camera.core.impl.r.v;
        if (d0Var3.b(aVar2)) {
            Config.a aVar3 = androidx.camera.core.impl.r.t;
            if (tVarC0.b(aVar3) && ((wf2) this.e.a(aVar2)).d() != null) {
                tVarC0.e0(aVar3);
            }
        }
        Iterator it = this.e.e().iterator();
        while (it.hasNext()) {
            Config.W(tVarC0, tVarC0, this.e, (Config.a) it.next());
        }
        if (d0Var != null) {
            for (Config.a aVar4 : d0Var.e()) {
                if (!aVar4.c().equals(m03.b.c())) {
                    Config.W(tVarC0, tVarC0, d0Var, aVar4);
                }
            }
        }
        if (tVarC0.b(androidx.camera.core.impl.r.r)) {
            Config.a aVar5 = androidx.camera.core.impl.r.n;
            if (tVarC0.b(aVar5)) {
                tVarC0.e0(aVar5);
            }
        }
        Config.a aVar6 = androidx.camera.core.impl.r.v;
        if (tVarC0.b(aVar6) && ((wf2) tVarC0.a(aVar6)).a() != 0) {
            tVarC0.x(androidx.camera.core.impl.d0.D, Boolean.TRUE);
        }
        return J(ztVar, w(tVarC0));
    }

    protected final void C() {
        this.c = State.ACTIVE;
        F();
    }

    protected final void D() {
        this.c = State.INACTIVE;
        F();
    }

    protected final void E() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).d(this);
        }
    }

    public final void F() {
        int iOrdinal = this.c.ordinal();
        if (iOrdinal == 0) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((a) it.next()).c(this);
            }
        } else {
            if (iOrdinal != 1) {
                return;
            }
            Iterator it2 = this.a.iterator();
            while (it2.hasNext()) {
                ((a) it2.next()).o(this);
            }
        }
    }

    protected final void G() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((a) it.next()).f(this);
        }
    }

    public void H() {
    }

    public void I() {
    }

    protected abstract androidx.camera.core.impl.d0 J(zt ztVar, androidx.camera.core.impl.d0.a aVar);

    public void K() {
    }

    public void L() {
    }

    protected abstract androidx.camera.core.impl.x M(Config config);

    protected abstract androidx.camera.core.impl.x N(androidx.camera.core.impl.x xVar);

    public void O() {
    }

    public void Q(tt ttVar) {
        b52.a(true);
    }

    public void R(Matrix matrix) {
        this.j = new Matrix(matrix);
    }

    public void S(Rect rect) {
        this.i = rect;
    }

    public final void T(CameraInternal cameraInternal) {
        O();
        synchronized (this.b) {
            b52.a(cameraInternal == this.k);
            P(this.k);
            this.k = null;
        }
        this.g = null;
        this.i = null;
        this.f = this.e;
        this.d = null;
        this.h = null;
    }

    protected void U(SessionConfig sessionConfig) {
        this.m = sessionConfig;
        for (DeferrableSurface deferrableSurface : sessionConfig.m()) {
            if (deferrableSurface.g() == null) {
                deferrableSurface.s(getClass());
            }
        }
    }

    public void V(androidx.camera.core.impl.x xVar) {
        this.g = N(xVar);
    }

    public void W(Config config) {
        this.g = M(config);
    }

    public final void b(CameraInternal cameraInternal, androidx.camera.core.impl.d0 d0Var, androidx.camera.core.impl.d0 d0Var2) {
        synchronized (this.b) {
            this.k = cameraInternal;
            a(cameraInternal);
        }
        this.d = d0Var;
        this.h = d0Var2;
        this.f = B(cameraInternal.n(), this.d, this.h);
        H();
    }

    protected androidx.camera.core.impl.d0 c() {
        return this.e;
    }

    protected int d() {
        return ((androidx.camera.core.impl.r) this.f).B(-1);
    }

    public androidx.camera.core.impl.x e() {
        return this.g;
    }

    public Size f() {
        androidx.camera.core.impl.x xVar = this.g;
        if (xVar != null) {
            return xVar.e();
        }
        return null;
    }

    public CameraInternal g() {
        CameraInternal cameraInternal;
        synchronized (this.b) {
            cameraInternal = this.k;
        }
        return cameraInternal;
    }

    protected CameraControlInternal h() {
        synchronized (this.b) {
            try {
                CameraInternal cameraInternal = this.k;
                if (cameraInternal == null) {
                    return CameraControlInternal.a;
                }
                return cameraInternal.h();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected String i() {
        return ((CameraInternal) b52.h(g(), "No camera attached to use case: " + this)).n().d();
    }

    public androidx.camera.core.impl.d0 j() {
        return this.f;
    }

    public abstract androidx.camera.core.impl.d0 k(boolean z, UseCaseConfigFactory useCaseConfigFactory);

    public tt l() {
        return null;
    }

    public int m() {
        return this.f.p();
    }

    protected int n() {
        return ((androidx.camera.core.impl.r) this.f).V(-1);
    }

    public String o() {
        String strC = this.f.C("<UnknownUseCase-" + hashCode() + ">");
        Objects.requireNonNull(strC);
        return strC;
    }

    public String p() {
        return this.l;
    }

    protected int q(CameraInternal cameraInternal) {
        return r(cameraInternal, false);
    }

    protected int r(CameraInternal cameraInternal, boolean z) {
        int iK = cameraInternal.n().k(v());
        return (cameraInternal.m() || !z) ? iK : y43.v(-iK);
    }

    public Matrix s() {
        return this.j;
    }

    public SessionConfig t() {
        return this.m;
    }

    protected Set u() {
        return Collections.emptySet();
    }

    protected int v() {
        return ((androidx.camera.core.impl.r) this.f).U(0);
    }

    public abstract androidx.camera.core.impl.d0.a w(Config config);

    public Rect x() {
        return this.i;
    }

    protected boolean y(String str) {
        if (g() == null) {
            return false;
        }
        return Objects.equals(str, i());
    }

    public boolean z(int i) {
        Iterator it = u().iterator();
        while (it.hasNext()) {
            if (s03.b(i, ((Integer) it.next()).intValue())) {
                return true;
            }
        }
        return false;
    }
}
