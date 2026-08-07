package defpackage;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.b0;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.l;
import androidx.camera.core.v;
import androidx.camera.core.w;
import androidx.camera.core.x;
import androidx.camera.core.y;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
class mw {
    b0 b;
    b0 c;
    private j72.a d;
    private c e;
    k72 a = null;
    private fr1 f = null;

    class a extends as {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            k72 k72Var = mw.this.a;
            if (k72Var != null) {
                k72Var.m();
            }
        }

        @Override // defpackage.as
        public void d(int i) {
            androidx.camera.core.impl.utils.executor.c.e().execute(new Runnable() { // from class: lw
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f();
                }
            });
        }
    }

    class b implements bs0 {
        final /* synthetic */ k72 a;

        b(k72 k72Var) {
            this.a = k72Var;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            t23.a();
            if (this.a == mw.this.a) {
                x.k("CaptureNode", "request aborted, id=" + mw.this.a.e());
                if (mw.this.f != null) {
                    mw.this.f.j();
                }
                mw.this.a = null;
            }
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r1) {
        }
    }

    static abstract class c {
        private DeferrableSurface b;
        private as a = new a();
        private DeferrableSurface c = null;

        class a extends as {
            a() {
            }
        }

        c() {
        }

        static c m(Size size, int i, int i2, boolean z, y01 y01Var, Size size2, int i3) {
            return new yc(size, i, i2, z, y01Var, size2, i3, new bf0(), new bf0());
        }

        as a() {
            return this.a;
        }

        abstract bf0 b();

        abstract y01 c();

        abstract int d();

        abstract int e();

        abstract int f();

        abstract Size g();

        DeferrableSurface h() {
            return this.c;
        }

        abstract bf0 i();

        abstract Size j();

        DeferrableSurface k() {
            DeferrableSurface deferrableSurface = this.b;
            Objects.requireNonNull(deferrableSurface);
            return deferrableSurface;
        }

        abstract boolean l();

        void n(as asVar) {
            this.a = asVar;
        }

        void o(Surface surface, Size size, int i) {
            this.c = new k11(surface, size, i);
        }

        void p(Surface surface) {
            b52.j(this.b == null, "The surface is already set.");
            this.b = new k11(surface, j(), d());
        }
    }

    mw() {
    }

    private static x01 g(y01 y01Var, int i, int i2, int i3) {
        return y01Var != null ? y01Var.a(i, i2, i3, 4, 0L) : w.a(i, i2, i3, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(b0 b0Var) {
        if (b0Var != null) {
            b0Var.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(k72 k72Var) {
        p(k72Var);
        this.f.i(k72Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(x01 x01Var) {
        try {
            v vVarC = x01Var.c();
            if (vVarC != null) {
                o(vVarC);
            } else {
                k72 k72Var = this.a;
                if (k72Var != null) {
                    t(d03.b.c(k72Var.e(), new ImageCaptureException(2, "Failed to acquire latest image", null)));
                }
            }
        } catch (IllegalStateException e) {
            k72 k72Var2 = this.a;
            if (k72Var2 != null) {
                t(d03.b.c(k72Var2.e(), new ImageCaptureException(2, "Failed to acquire latest image", e)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(x01 x01Var) {
        try {
            v vVarC = x01Var.c();
            if (vVarC != null) {
                q(vVarC);
            }
        } catch (IllegalStateException e) {
            x.d("CaptureNode", "Failed to acquire latest image of postview", e);
        }
    }

    private void n(v vVar) {
        t23.a();
        j72.a aVar = this.d;
        Objects.requireNonNull(aVar);
        aVar.a().accept(j72.b.c(this.a, vVar));
        k72 k72Var = this.a;
        this.a = null;
        k72Var.p();
    }

    private void q(v vVar) {
        if (this.a == null) {
            vVar.close();
            return;
        }
        j72.a aVar = this.d;
        Objects.requireNonNull(aVar);
        aVar.d().accept(j72.b.c(this.a, vVar));
    }

    private void s(c cVar, final b0 b0Var, final b0 b0Var2) {
        cVar.k().d();
        cVar.k().k().a(new Runnable() { // from class: jw
            @Override // java.lang.Runnable
            public final void run() {
                b0Var.m();
            }
        }, androidx.camera.core.impl.utils.executor.c.e());
        if (cVar.h() != null) {
            cVar.h().d();
            cVar.h().k().a(new Runnable() { // from class: kw
                @Override // java.lang.Runnable
                public final void run() {
                    mw.j(b0Var2);
                }
            }, androidx.camera.core.impl.utils.executor.c.e());
        }
    }

    public int h() {
        t23.a();
        b52.j(this.b != null, "The ImageReader is not initialized.");
        return this.b.j();
    }

    void o(v vVar) {
        t23.a();
        if (this.a == null) {
            x.k("CaptureNode", "Discarding ImageProxy which was inadvertently acquired: " + vVar);
            vVar.close();
            return;
        }
        if (((Integer) vVar.h0().a().d(this.a.i())) != null) {
            n(vVar);
        } else {
            x.k("CaptureNode", "Discarding ImageProxy which was acquired for aborted request");
            vVar.close();
        }
    }

    void p(k72 k72Var) {
        t23.a();
        b52.j(k72Var.h().size() == 1, "only one capture stage is supported.");
        b52.j(h() > 0, "Too many acquire images. Close image to be able to process next.");
        this.a = k72Var;
        os0.j(k72Var.a(), new b(k72Var), androidx.camera.core.impl.utils.executor.c.b());
    }

    public void r() {
        t23.a();
        c cVar = this.e;
        Objects.requireNonNull(cVar);
        b0 b0Var = this.b;
        Objects.requireNonNull(b0Var);
        s(cVar, b0Var, this.c);
    }

    void t(d03.b bVar) {
        t23.a();
        k72 k72Var = this.a;
        if (k72Var == null || k72Var.e() != bVar.b()) {
            return;
        }
        this.a.l(bVar.a());
    }

    public void u(l.a aVar) {
        t23.a();
        b52.j(this.b != null, "The ImageReader is not initialized.");
        this.b.n(aVar);
    }

    public j72.a v(c cVar) {
        q20 q20Var;
        x01 x01Var;
        b52.j(this.e == null && this.b == null, "CaptureNode does not support recreation yet.");
        this.e = cVar;
        Size sizeJ = cVar.j();
        int iD = cVar.d();
        boolean zL = cVar.l();
        as aVar = new a();
        if (zL) {
            cVar.c();
            fr1 fr1Var = new fr1(g(null, sizeJ.getWidth(), sizeJ.getHeight(), iD));
            this.f = fr1Var;
            q20Var = new q20() { // from class: fw
                @Override // defpackage.q20
                public final void accept(Object obj) {
                    this.a.k((k72) obj);
                }
            };
            x01Var = fr1Var;
        } else {
            cVar.c();
            y yVar = new y(sizeJ.getWidth(), sizeJ.getHeight(), iD, 4);
            aVar = bs.b(aVar, yVar.n());
            q20Var = new q20() { // from class: ew
                @Override // defpackage.q20
                public final void accept(Object obj) {
                    this.a.p((k72) obj);
                }
            };
            x01Var = yVar;
        }
        cVar.n(aVar);
        Surface surfaceA = x01Var.a();
        Objects.requireNonNull(surfaceA);
        cVar.p(surfaceA);
        this.b = new b0(x01Var);
        x01Var.f(new x01.a() { // from class: gw
            @Override // x01.a
            public final void a(x01 x01Var2) {
                this.a.l(x01Var2);
            }
        }, androidx.camera.core.impl.utils.executor.c.e());
        if (cVar.g() != null) {
            cVar.c();
            x01 x01VarG = g(null, cVar.g().getWidth(), cVar.g().getHeight(), cVar.f());
            x01VarG.f(new x01.a() { // from class: hw
                @Override // x01.a
                public final void a(x01 x01Var2) {
                    this.a.m(x01Var2);
                }
            }, androidx.camera.core.impl.utils.executor.c.e());
            this.c = new b0(x01VarG);
            cVar.o(x01VarG.a(), cVar.g(), cVar.f());
        }
        cVar.i().a(q20Var);
        cVar.b().a(new q20() { // from class: iw
            @Override // defpackage.q20
            public final void accept(Object obj) {
                this.a.t((d03.b) obj);
            }
        });
        j72.a aVarE = j72.a.e(cVar.d(), cVar.e());
        this.d = aVarE;
        return aVarE;
    }
}
