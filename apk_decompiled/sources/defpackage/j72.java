package defpackage;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.executor.c;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.u;
import androidx.camera.core.v;
import androidx.camera.core.x;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class j72 {
    final Executor a;
    final n31 b;
    private a c;
    private uw1 d;
    private uw1 e;
    private uw1 f;
    private uw1 g;
    private uw1 h;
    private uw1 i;
    private uw1 j;
    private uw1 k;
    private uw1 l;
    private final w92 m;
    private final boolean n;

    static abstract class a {
        a() {
        }

        static a e(int i, int i2) {
            return new nd(new bf0(), new bf0(), i, i2);
        }

        abstract bf0 a();

        abstract int b();

        abstract int c();

        abstract bf0 d();
    }

    static abstract class b {
        b() {
        }

        static b c(k72 k72Var, v vVar) {
            return new od(k72Var, vVar);
        }

        abstract v a();

        abstract k72 b();
    }

    j72(Executor executor, n31 n31Var) {
        this(executor, n31Var, ua0.b());
    }

    private xy1 i(xy1 xy1Var, int i) {
        b52.i(ImageUtil.i(xy1Var.e()));
        xy1 xy1Var2 = (xy1) this.h.apply(xy1Var);
        uw1 uw1Var = this.l;
        if (uw1Var != null) {
            xy1Var2 = (xy1) uw1Var.apply(xy1Var2);
        }
        return (xy1) this.f.apply(zh.b.c(xy1Var2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(final b bVar) {
        if (bVar.b().j()) {
            bVar.a().close();
        } else {
            this.a.execute(new Runnable() { // from class: e72
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.n(bVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(final b bVar) {
        if (bVar.b().j()) {
            bVar.a().close();
        } else {
            this.a.execute(new Runnable() { // from class: d72
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.p(bVar);
                }
            });
        }
    }

    private static void w(final k72 k72Var, final ImageCaptureException imageCaptureException) {
        c.e().execute(new Runnable() { // from class: i72
            @Override // java.lang.Runnable
            public final void run() {
                k72Var.r(imageCaptureException);
            }
        });
    }

    v r(b bVar) {
        k72 k72VarB = bVar.b();
        xy1 xy1Var = (xy1) this.d.apply(bVar);
        if ((xy1Var.e() == 35 || this.l != null || this.n) && this.c.c() == 256) {
            xy1 xy1VarI = (xy1) this.e.apply(fz0.a.c(xy1Var, k72VarB.c()));
            if (this.l != null) {
                xy1VarI = i(xy1VarI, k72VarB.c());
            }
            xy1Var = (xy1) this.j.apply(xy1VarI);
        }
        return (v) this.i.apply(xy1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void n(b bVar) {
        final k72 k72VarB = bVar.b();
        try {
            if (bVar.b().k()) {
                final v vVarR = r(bVar);
                c.e().execute(new Runnable() { // from class: f72
                    @Override // java.lang.Runnable
                    public final void run() {
                        k72VarB.o(vVarR);
                    }
                });
            } else {
                final u.h hVarT = t(bVar);
                c.e().execute(new Runnable() { // from class: g72
                    @Override // java.lang.Runnable
                    public final void run() {
                        k72VarB.n(hVarT);
                    }
                });
            }
        } catch (ImageCaptureException e) {
            w(k72VarB, e);
        } catch (OutOfMemoryError e2) {
            w(k72VarB, new ImageCaptureException(0, "Processing failed due to low memory.", e2));
        } catch (RuntimeException e3) {
            w(k72VarB, new ImageCaptureException(0, "Processing failed.", e3));
        }
    }

    u.h t(b bVar) {
        int iC = this.c.c();
        b52.b(ImageUtil.i(iC), String.format("On-disk capture only support JPEG and JPEG/R output formats. Output format: %s", Integer.valueOf(iC)));
        k72 k72VarB = bVar.b();
        xy1 xy1VarI = (xy1) this.e.apply(fz0.a.c((xy1) this.d.apply(bVar), k72VarB.c()));
        if (xy1VarI.i() || this.l != null) {
            xy1VarI = i(xy1VarI, k72VarB.c());
        }
        uw1 uw1Var = this.g;
        u.g gVarD = k72VarB.d();
        Objects.requireNonNull(gVarD);
        return (u.h) uw1Var.apply(y41.a.c(xy1VarI, gVarD));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void p(b bVar) {
        int iC = this.c.c();
        b52.b(iC == 35 || iC == 256, String.format("Postview only support YUV and JPEG output formats. Output format: %s", Integer.valueOf(iC)));
        final k72 k72VarB = bVar.b();
        try {
            final Bitmap bitmap = (Bitmap) this.k.apply((xy1) this.d.apply(bVar));
            c.e().execute(new Runnable() { // from class: h72
                @Override // java.lang.Runnable
                public final void run() {
                    k72VarB.q(bitmap);
                }
            });
        } catch (Exception e) {
            bVar.a().close();
            x.d("ProcessingNode", "process postview input packet failed.", e);
        }
    }

    public void v() {
    }

    public Void x(a aVar) {
        this.c = aVar;
        aVar.a().a(new q20() { // from class: b72
            @Override // defpackage.q20
            public final void accept(Object obj) {
                this.a.o((j72.b) obj);
            }
        });
        aVar.d().a(new q20() { // from class: c72
            @Override // defpackage.q20
            public final void accept(Object obj) {
                this.a.q((j72.b) obj);
            }
        });
        this.d = new a72();
        this.e = new fz0(this.m);
        this.h = new x41();
        this.f = new zh();
        this.g = new y41();
        this.i = new c51();
        this.k = new ez0();
        if (aVar.b() != 35 && !this.n) {
            return null;
        }
        this.j = new z41();
        return null;
    }

    j72(Executor executor, n31 n31Var, w92 w92Var) {
        if (ua0.a(se1.class) != null) {
            this.a = c.g(executor);
        } else {
            this.a = executor;
        }
        this.m = w92Var;
        this.n = w92Var.a(z11.class);
    }
}
