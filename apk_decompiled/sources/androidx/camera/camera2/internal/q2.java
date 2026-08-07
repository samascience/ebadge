package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import defpackage.bs0;
import defpackage.k11;
import defpackage.m03;
import defpackage.os0;
import defpackage.vw2;
import defpackage.zs;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
class q2 {
    private DeferrableSurface a;
    private SessionConfig b;
    private final Size d;
    private final c f;
    private final vw2 e = new vw2();
    private final b c = new b();

    class a implements bs0 {
        final /* synthetic */ Surface a;
        final /* synthetic */ SurfaceTexture b;

        a(Surface surface, SurfaceTexture surfaceTexture) {
            this.a = surface;
            this.b = surfaceTexture;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            throw new IllegalStateException("Future should never fail. Did it get completed by GC?", th);
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r1) {
            this.a.release();
            this.b.release();
        }
    }

    private static class b implements androidx.camera.core.impl.d0 {
        private final Config I;

        b() {
            androidx.camera.core.impl.t tVarC0 = androidx.camera.core.impl.t.c0();
            tVarC0.x(androidx.camera.core.impl.d0.z, new l1());
            tVarC0.x(androidx.camera.core.impl.q.l, 34);
            Y(tVarC0);
            this.I = tVarC0;
        }

        private void Y(androidx.camera.core.impl.t tVar) {
            tVar.x(m03.c, q2.class);
            tVar.x(m03.b, q2.class.getCanonicalName() + "-" + UUID.randomUUID());
        }

        @Override // androidx.camera.core.impl.d0
        public UseCaseConfigFactory.CaptureType F() {
            return UseCaseConfigFactory.CaptureType.METERING_REPEATING;
        }

        @Override // androidx.camera.core.impl.w
        public Config n() {
            return this.I;
        }
    }

    interface c {
        void a();
    }

    q2(zs zsVar, c2 c2Var, c cVar) {
        this.f = cVar;
        Size sizeG = g(zsVar, c2Var);
        this.d = sizeG;
        androidx.camera.core.x.a("MeteringRepeating", "MeteringSession SurfaceTexture size: " + sizeG);
        this.b = d();
    }

    private Size g(zs zsVar, c2 c2Var) {
        Size[] sizeArrC = zsVar.b().c(34);
        if (sizeArrC == null) {
            androidx.camera.core.x.c("MeteringRepeating", "Can not get output size list.");
            return new Size(0, 0);
        }
        Size[] sizeArrA = this.e.a(sizeArrC);
        List listAsList = Arrays.asList(sizeArrA);
        Collections.sort(listAsList, new Comparator() { // from class: androidx.camera.camera2.internal.p2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return q2.k((Size) obj, (Size) obj2);
            }
        });
        Size sizeF = c2Var.f();
        long jMin = Math.min(((long) sizeF.getWidth()) * ((long) sizeF.getHeight()), 307200L);
        int length = sizeArrA.length;
        Size size = null;
        int i = 0;
        while (i < length) {
            Size size2 = sizeArrA[i];
            long width = ((long) size2.getWidth()) * ((long) size2.getHeight());
            if (width == jMin) {
                return size2;
            }
            if (width > jMin) {
                if (size == null) {
                    break;
                }
                return size;
            }
            i++;
            size = size2;
        }
        return (Size) listAsList.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.b = d();
        c cVar = this.f;
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int k(Size size, Size size2) {
        return Long.signum((((long) size.getWidth()) * ((long) size.getHeight())) - (((long) size2.getWidth()) * ((long) size2.getHeight())));
    }

    void c() {
        androidx.camera.core.x.a("MeteringRepeating", "MeteringRepeating clear!");
        DeferrableSurface deferrableSurface = this.a;
        if (deferrableSurface != null) {
            deferrableSurface.d();
        }
        this.a = null;
    }

    SessionConfig d() {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(this.d.getWidth(), this.d.getHeight());
        Surface surface = new Surface(surfaceTexture);
        SessionConfig.b bVarR = SessionConfig.b.r(this.c, this.d);
        bVarR.z(1);
        k11 k11Var = new k11(surface);
        this.a = k11Var;
        os0.j(k11Var.k(), new a(surface, surfaceTexture), androidx.camera.core.impl.utils.executor.c.b());
        bVarR.m(this.a);
        bVarR.g(new SessionConfig.c() { // from class: androidx.camera.camera2.internal.o2
            @Override // androidx.camera.core.impl.SessionConfig.c
            public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                this.a.j(sessionConfig, sessionError);
            }
        });
        return bVarR.p();
    }

    Size e() {
        return this.d;
    }

    String f() {
        return "MeteringRepeating";
    }

    SessionConfig h() {
        return this.b;
    }

    androidx.camera.core.impl.d0 i() {
        return this.c;
    }
}
