package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.executor.c;
import androidx.camera.core.impl.x;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ix2 {
    private final int a;
    private final Matrix b;
    private final boolean c;
    private final Rect d;
    private final boolean e;
    private final int f;
    private final x g;
    private int h;
    private int i;
    private SurfaceRequest k;
    private a l;
    private boolean j = false;
    private final Set m = new HashSet();
    private boolean n = false;
    private final List o = new ArrayList();

    static class a extends DeferrableSurface {
        final ub1 o;
        CallbackToFutureAdapter.a p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private DeferrableSurface f348q;
        private nx2 r;

        a(Size size, int i) {
            super(size, i);
            this.o = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: gx2
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return this.a.n(aVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object n(CallbackToFutureAdapter.a aVar) {
            this.p = aVar;
            return "SettableFuture hashCode: " + hashCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w() {
            nx2 nx2Var = this.r;
            if (nx2Var != null) {
                nx2Var.a0();
            }
            if (this.f348q == null) {
                this.p.d();
            }
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        public void d() {
            super.d();
            t23.d(new Runnable() { // from class: fx2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.w();
                }
            });
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        protected ub1 r() {
            return this.o;
        }

        boolean v() {
            t23.a();
            return this.f348q == null && !m();
        }

        public void x(nx2 nx2Var) {
            b52.j(this.r == null, "Consumer can only be linked once.");
            this.r = nx2Var;
        }

        public boolean y(final DeferrableSurface deferrableSurface, Runnable runnable) {
            t23.a();
            b52.g(deferrableSurface);
            DeferrableSurface deferrableSurface2 = this.f348q;
            if (deferrableSurface2 == deferrableSurface) {
                return false;
            }
            b52.j(deferrableSurface2 == null, "A different provider has been set. To change the provider, call SurfaceEdge#invalidate before calling SurfaceEdge#setProvider");
            b52.b(h().equals(deferrableSurface.h()), String.format("The provider's size(%s) must match the parent(%s)", h(), deferrableSurface.h()));
            b52.b(i() == deferrableSurface.i(), String.format("The provider's format(%s) must match the parent(%s)", Integer.valueOf(i()), Integer.valueOf(deferrableSurface.i())));
            b52.j(!m(), "The parent is closed. Call SurfaceEdge#invalidate() before setting a new provider.");
            this.f348q = deferrableSurface;
            os0.C(deferrableSurface.j(), this.p);
            deferrableSurface.l();
            k().a(new Runnable() { // from class: hx2
                @Override // java.lang.Runnable
                public final void run() {
                    deferrableSurface.e();
                }
            }, c.b());
            deferrableSurface.f().a(runnable, c.e());
            return true;
        }
    }

    public ix2(int i, int i2, x xVar, Matrix matrix, boolean z, Rect rect, int i3, int i4, boolean z2) {
        this.f = i;
        this.a = i2;
        this.g = xVar;
        this.b = matrix;
        this.c = z;
        this.d = rect;
        this.i = i3;
        this.h = i4;
        this.e = z2;
        this.l = new a(xVar.e(), i2);
    }

    private void A() {
        t23.a();
        SurfaceRequest.g gVarG = SurfaceRequest.g.g(this.d, this.i, this.h, t(), this.b, this.e);
        SurfaceRequest surfaceRequest = this.k;
        if (surfaceRequest != null) {
            surfaceRequest.D(gVarG);
        }
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            ((q20) it.next()).accept(gVarG);
        }
    }

    private void g() {
        b52.j(!this.j, "Consumer can only be linked once.");
        this.j = true;
    }

    private void h() {
        b52.j(!this.n, "Edge is already closed.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ub1 w(final a aVar, int i, Size size, Rect rect, int i2, boolean z, CameraInternal cameraInternal, Surface surface) {
        b52.g(surface);
        try {
            aVar.l();
            nx2 nx2Var = new nx2(surface, s(), i, this.g.e(), size, rect, i2, z, cameraInternal, this.b);
            nx2Var.C().a(new Runnable() { // from class: ex2
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.e();
                }
            }, c.b());
            aVar.x(nx2Var);
            return os0.p(nx2Var);
        } catch (DeferrableSurface.SurfaceClosedException e) {
            return os0.n(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x() {
        if (this.n) {
            return;
        }
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y() {
        c.e().execute(new Runnable() { // from class: cx2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(int i, int i2) {
        boolean z;
        boolean z2 = true;
        if (this.i != i) {
            this.i = i;
            z = true;
        } else {
            z = false;
        }
        if (this.h != i2) {
            this.h = i2;
        } else {
            z2 = z;
        }
        if (z2) {
            A();
        }
    }

    public void B(DeferrableSurface deferrableSurface) {
        t23.a();
        h();
        a aVar = this.l;
        Objects.requireNonNull(aVar);
        aVar.y(deferrableSurface, new zw2(aVar));
    }

    public void C(final int i, final int i2) {
        t23.d(new Runnable() { // from class: bx2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z(i, i2);
            }
        });
    }

    public void e(Runnable runnable) {
        t23.a();
        h();
        this.m.add(runnable);
    }

    public void f(q20 q20Var) {
        b52.g(q20Var);
        this.o.add(q20Var);
    }

    public final void i() {
        t23.a();
        this.l.d();
        this.n = true;
    }

    public ub1 j(final Size size, final int i, final Rect rect, final int i2, final boolean z, final CameraInternal cameraInternal) {
        t23.a();
        h();
        g();
        final a aVar = this.l;
        return os0.H(aVar.j(), new ab() { // from class: dx2
            @Override // defpackage.ab
            public final ub1 apply(Object obj) {
                return this.a.w(aVar, i, size, rect, i2, z, cameraInternal, (Surface) obj);
            }
        }, c.e());
    }

    public SurfaceRequest k(CameraInternal cameraInternal) {
        t23.a();
        h();
        SurfaceRequest surfaceRequest = new SurfaceRequest(this.g.e(), cameraInternal, this.g.b(), this.g.c(), new Runnable() { // from class: yw2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.y();
            }
        });
        try {
            final DeferrableSurface deferrableSurfaceL = surfaceRequest.l();
            a aVar = this.l;
            Objects.requireNonNull(aVar);
            if (aVar.y(deferrableSurfaceL, new zw2(aVar))) {
                ub1 ub1VarK = aVar.k();
                Objects.requireNonNull(deferrableSurfaceL);
                ub1VarK.a(new Runnable() { // from class: ax2
                    @Override // java.lang.Runnable
                    public final void run() {
                        deferrableSurfaceL.d();
                    }
                }, c.b());
            }
            this.k = surfaceRequest;
            A();
            return surfaceRequest;
        } catch (DeferrableSurface.SurfaceClosedException e) {
            throw new AssertionError("Surface is somehow already closed", e);
        } catch (RuntimeException e2) {
            surfaceRequest.E();
            throw e2;
        }
    }

    public final void l() {
        t23.a();
        h();
        this.l.d();
    }

    public Rect m() {
        return this.d;
    }

    public DeferrableSurface n() {
        t23.a();
        h();
        g();
        return this.l;
    }

    public int o() {
        return this.a;
    }

    public int p() {
        return this.i;
    }

    public Matrix q() {
        return this.b;
    }

    public x r() {
        return this.g;
    }

    public int s() {
        return this.f;
    }

    public boolean t() {
        return this.c;
    }

    public void u() {
        t23.a();
        h();
        if (this.l.v()) {
            return;
        }
        this.j = false;
        this.l.d();
        this.l = new a(this.g.e(), this.a);
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public boolean v() {
        return this.e;
    }
}
