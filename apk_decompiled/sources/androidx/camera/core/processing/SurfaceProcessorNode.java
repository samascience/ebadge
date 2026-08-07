package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.core.x;
import defpackage.b52;
import defpackage.bs0;
import defpackage.ix2;
import defpackage.kx2;
import defpackage.os0;
import defpackage.q20;
import defpackage.qx2;
import defpackage.s03;
import defpackage.t23;
import defpackage.y43;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public class SurfaceProcessorNode {
    final qx2 a;
    final CameraInternal b;
    private Out c;
    private b d;

    public static class Out extends HashMap<c, ix2> {
    }

    class a implements bs0 {
        final /* synthetic */ ix2 a;

        a(ix2 ix2Var) {
            this.a = ix2Var;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            if (this.a.s() == 2 && (th instanceof CancellationException)) {
                x.a("SurfaceProcessorNode", "Downstream VideoCapture failed to provide Surface.");
                return;
            }
            x.l("SurfaceProcessorNode", "Downstream node failed to provide Surface. Target: " + s03.a(this.a.s()), th);
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(kx2 kx2Var) {
            b52.g(kx2Var);
            try {
                SurfaceProcessorNode.this.a.b(kx2Var);
            } catch (ProcessingException e) {
                x.d("SurfaceProcessorNode", "Failed to send SurfaceOutput to SurfaceProcessor.", e);
            }
        }
    }

    public static abstract class b {
        public static b c(ix2 ix2Var, List list) {
            return new androidx.camera.core.processing.a(ix2Var, list);
        }

        public abstract List a();

        public abstract ix2 b();
    }

    public static abstract class c {
        public static c h(int i, int i2, Rect rect, Size size, int i3, boolean z) {
            return i(i, i2, rect, size, i3, z, false);
        }

        public static c i(int i, int i2, Rect rect, Size size, int i3, boolean z, boolean z2) {
            return new androidx.camera.core.processing.b(UUID.randomUUID(), i, i2, rect, size, i3, z, z2);
        }

        public static c j(ix2 ix2Var) {
            return h(ix2Var.s(), ix2Var.o(), ix2Var.m(), y43.f(ix2Var.m(), ix2Var.p()), ix2Var.p(), ix2Var.v());
        }

        public abstract Rect a();

        public abstract int b();

        public abstract int c();

        public abstract Size d();

        public abstract int e();

        abstract UUID f();

        public abstract boolean g();

        public abstract boolean k();
    }

    public SurfaceProcessorNode(CameraInternal cameraInternal, qx2 qx2Var) {
        this.b = cameraInternal;
        this.a = qx2Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void g(ix2 ix2Var, Map.Entry entry) {
        ix2 ix2Var2 = (ix2) entry.getValue();
        os0.j(ix2Var2.j(ix2Var.r().e(), ((c) entry.getKey()).b(), ((c) entry.getKey()).a(), ((c) entry.getKey()).c(), ((c) entry.getKey()).g(), ix2Var.t() ? this.b : null), new a(ix2Var2), androidx.camera.core.impl.utils.executor.c.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        Out out = this.c;
        if (out != null) {
            Iterator<ix2> it = out.values().iterator();
            while (it.hasNext()) {
                it.next().i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Map map, SurfaceRequest.g gVar) {
        for (Map.Entry entry : map.entrySet()) {
            int iB = gVar.b() - ((c) entry.getKey()).c();
            if (((c) entry.getKey()).g()) {
                iB = -iB;
            }
            ((ix2) entry.getValue()).C(y43.v(iB), -1);
        }
    }

    private void j(final ix2 ix2Var, Map map) {
        for (final Map.Entry entry : map.entrySet()) {
            g(ix2Var, entry);
            ((ix2) entry.getValue()).e(new Runnable() { // from class: rx2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.g(ix2Var, entry);
                }
            });
        }
    }

    private void k(ix2 ix2Var) {
        try {
            this.a.a(ix2Var.k(this.b));
        } catch (ProcessingException e) {
            x.d("SurfaceProcessorNode", "Failed to send SurfaceRequest to SurfaceProcessor.", e);
        }
    }

    private ix2 n(ix2 ix2Var, c cVar) {
        Rect rectQ;
        Rect rectA = cVar.a();
        int iC = cVar.c();
        boolean zG = cVar.g();
        Matrix matrix = new Matrix(ix2Var.q());
        Matrix matrixE = y43.e(new RectF(rectA), y43.s(cVar.d()), iC, zG);
        matrix.postConcat(matrixE);
        b52.a(y43.j(y43.f(rectA, iC), cVar.d()));
        if (cVar.k()) {
            b52.b(cVar.a().contains(ix2Var.m()), String.format("Output crop rect %s must contain input crop rect %s", cVar.a(), ix2Var.m()));
            rectQ = new Rect();
            RectF rectF = new RectF(ix2Var.m());
            matrixE.mapRect(rectF);
            rectF.round(rectQ);
        } else {
            rectQ = y43.q(cVar.d());
        }
        Rect rect = rectQ;
        return new ix2(cVar.e(), cVar.b(), ix2Var.r().f().e(cVar.d()).a(), matrix, false, rect, ix2Var.p() - iC, -1, ix2Var.v() != zG);
    }

    public qx2 e() {
        return this.a;
    }

    public void i() {
        this.a.release();
        t23.d(new Runnable() { // from class: tx2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f();
            }
        });
    }

    void l(ix2 ix2Var, final Map map) {
        ix2Var.f(new q20() { // from class: sx2
            @Override // defpackage.q20
            public final void accept(Object obj) {
                SurfaceProcessorNode.h(map, (SurfaceRequest.g) obj);
            }
        });
    }

    public Out m(b bVar) {
        t23.a();
        this.d = bVar;
        this.c = new Out();
        ix2 ix2VarB = bVar.b();
        for (c cVar : bVar.a()) {
            this.c.put(cVar, n(ix2VarB, cVar));
        }
        k(ix2VarB);
        j(ix2VarB, this.c);
        l(ix2VarB, this.c);
        return this.c;
    }
}
