package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import androidx.camera.core.impl.DeferrableSurface;
import defpackage.ab;
import defpackage.cs0;
import defpackage.jn2;
import defpackage.ln2;
import defpackage.nf2;
import defpackage.os0;
import defpackage.qw;
import defpackage.ub1;
import defpackage.w92;
import defpackage.xo0;
import defpackage.y11;
import defpackage.yo0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class d3 extends z2 {
    private final ScheduledExecutorService o;
    private final Object p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private List f149q;
    ub1 r;
    private final yo0 s;
    private final xo0 t;
    private final nf2 u;
    private final ln2 v;
    private final AtomicBoolean w;

    d3(w92 w92Var, w92 w92Var2, a2 a2Var, Executor executor, ScheduledExecutorService scheduledExecutorService, Handler handler) {
        super(a2Var, executor, scheduledExecutorService, handler);
        this.p = new Object();
        this.w = new AtomicBoolean(false);
        this.s = new yo0(w92Var, w92Var2);
        this.u = new nf2(w92Var.a(qw.class) || w92Var.a(y11.class));
        this.t = new xo0(w92Var2);
        this.v = new ln2(w92Var2);
        this.o = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        O("Session call super.close()");
        super.close();
    }

    private void N() {
        Iterator it = this.b.d().iterator();
        while (it.hasNext()) {
            ((t2) it.next()).close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(t2 t2Var) {
        super.s(t2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ub1 Q(CameraDevice cameraDevice, jn2 jn2Var, List list, List list2) {
        if (this.v.a()) {
            N();
        }
        O("start openCaptureSession");
        return super.j(cameraDevice, jn2Var, list);
    }

    void O(String str) {
        androidx.camera.core.x.a("SyncCaptureSessionImpl", "[" + this + "] " + str);
    }

    @Override // androidx.camera.camera2.internal.z2, androidx.camera.camera2.internal.t2
    public void a() {
        super.a();
        this.u.i();
    }

    @Override // androidx.camera.camera2.internal.z2, androidx.camera.camera2.internal.t2
    public void close() {
        if (!this.w.compareAndSet(false, true)) {
            O("close() has been called. Skip this invocation.");
            return;
        }
        if (this.v.a()) {
            try {
                O("Call abortCaptures() before closing session.");
                g();
            } catch (Exception e) {
                O("Exception when calling abortCaptures()" + e);
            }
        }
        O("Session call close()");
        this.u.e().a(new Runnable() { // from class: androidx.camera.camera2.internal.b3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.E();
            }
        }, b());
    }

    @Override // androidx.camera.camera2.internal.z2, androidx.camera.camera2.internal.t2
    public int d(List list, CameraCaptureSession.CaptureCallback captureCallback) {
        return super.d(list, this.u.d(captureCallback));
    }

    @Override // androidx.camera.camera2.internal.z2, androidx.camera.camera2.internal.t2
    public void f(int i) {
        super.f(i);
        if (i == 5) {
            synchronized (this.p) {
                try {
                    if (D() && this.f149q != null) {
                        O("Close DeferrableSurfaces for CameraDevice error.");
                        Iterator it = this.f149q.iterator();
                        while (it.hasNext()) {
                            ((DeferrableSurface) it.next()).d();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // androidx.camera.camera2.internal.z2, androidx.camera.camera2.internal.t2
    public int i(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) {
        return super.i(captureRequest, this.u.d(captureCallback));
    }

    @Override // androidx.camera.camera2.internal.z2, androidx.camera.camera2.internal.t2.a
    public ub1 j(final CameraDevice cameraDevice, final jn2 jn2Var, final List list) {
        ub1 ub1VarB;
        synchronized (this.p) {
            try {
                List listD = this.b.d();
                ArrayList arrayList = new ArrayList();
                Iterator it = listD.iterator();
                while (it.hasNext()) {
                    arrayList.add(((t2) it.next()).n());
                }
                ub1 ub1VarF = os0.F(arrayList);
                this.r = ub1VarF;
                ub1VarB = os0.B(cs0.b(ub1VarF).f(new ab() { // from class: androidx.camera.camera2.internal.c3
                    @Override // defpackage.ab
                    public final ub1 apply(Object obj) {
                        return this.a.Q(cameraDevice, jn2Var, list, (List) obj);
                    }
                }, b()));
            } catch (Throwable th) {
                throw th;
            }
        }
        return ub1VarB;
    }

    @Override // androidx.camera.camera2.internal.z2, androidx.camera.camera2.internal.t2.a
    public ub1 m(List list, long j) {
        ub1 ub1VarM;
        synchronized (this.p) {
            this.f149q = list;
            ub1VarM = super.m(list, j);
        }
        return ub1VarM;
    }

    @Override // androidx.camera.camera2.internal.t2
    public ub1 n() {
        return os0.z(1500L, this.o, this.u.e());
    }

    @Override // androidx.camera.camera2.internal.z2, androidx.camera.camera2.internal.t2.c
    public void q(t2 t2Var) {
        synchronized (this.p) {
            this.s.a(this.f149q);
        }
        O("onClosed()");
        super.q(t2Var);
    }

    @Override // androidx.camera.camera2.internal.z2, androidx.camera.camera2.internal.t2.c
    public void s(t2 t2Var) {
        O("Session onConfigured()");
        this.t.c(t2Var, this.b.e(), this.b.d(), new xo0.a() { // from class: androidx.camera.camera2.internal.a3
            @Override // xo0.a
            public final void a(t2 t2Var2) {
                this.a.P(t2Var2);
            }
        });
    }

    @Override // androidx.camera.camera2.internal.z2, androidx.camera.camera2.internal.t2.a
    public boolean stop() {
        boolean zStop;
        synchronized (this.p) {
            try {
                if (D()) {
                    this.s.a(this.f149q);
                } else {
                    ub1 ub1Var = this.r;
                    if (ub1Var != null) {
                        ub1Var.cancel(true);
                    }
                }
                zStop = super.stop();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zStop;
    }
}
