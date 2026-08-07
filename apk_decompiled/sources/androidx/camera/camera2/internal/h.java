package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.ArrayMap;
import android.util.Rational;
import androidx.camera.camera2.internal.h;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.ab;
import defpackage.as;
import defpackage.b52;
import defpackage.cs;
import defpackage.cs0;
import defpackage.fr;
import defpackage.nc;
import defpackage.os0;
import defpackage.ow;
import defpackage.ub1;
import defpackage.vz2;
import defpackage.w92;
import defpackage.y4;
import defpackage.yr;
import defpackage.zs;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class h implements CameraControlInternal {
    final b b;
    final Executor c;
    private final Object d = new Object();
    private final zs e;
    private final CameraControlInternal.b f;
    private final SessionConfig.b g;
    private final m2 h;
    private final h3 i;
    private final g3 j;
    private final e2 k;
    j3 l;
    private final fr m;
    private final j0 n;
    private int o;
    private androidx.camera.core.u.i p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile boolean f150q;
    private volatile int r;
    private final y4 s;
    private final nc t;
    private final AtomicLong u;
    private volatile ub1 v;
    private int w;
    private long x;
    private final a y;

    static final class a extends as {
        Set a = new HashSet();
        Map b = new ArrayMap();

        a() {
        }

        @Override // defpackage.as
        public void a(final int i) {
            for (final as asVar : this.a) {
                try {
                    ((Executor) this.b.get(asVar)).execute(new Runnable() { // from class: androidx.camera.camera2.internal.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            asVar.a(i);
                        }
                    });
                } catch (RejectedExecutionException e) {
                    androidx.camera.core.x.d("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCancelled.", e);
                }
            }
        }

        @Override // defpackage.as
        public void b(final int i, final cs csVar) {
            for (final as asVar : this.a) {
                try {
                    ((Executor) this.b.get(asVar)).execute(new Runnable() { // from class: androidx.camera.camera2.internal.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            asVar.b(i, csVar);
                        }
                    });
                } catch (RejectedExecutionException e) {
                    androidx.camera.core.x.d("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCompleted.", e);
                }
            }
        }

        @Override // defpackage.as
        public void c(final int i, final CameraCaptureFailure cameraCaptureFailure) {
            for (final as asVar : this.a) {
                try {
                    ((Executor) this.b.get(asVar)).execute(new Runnable() { // from class: androidx.camera.camera2.internal.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            asVar.c(i, cameraCaptureFailure);
                        }
                    });
                } catch (RejectedExecutionException e) {
                    androidx.camera.core.x.d("Camera2CameraControlImp", "Executor rejected to invoke onCaptureFailed.", e);
                }
            }
        }

        void h(Executor executor, as asVar) {
            this.a.add(asVar);
            this.b.put(asVar, executor);
        }

        void l(as asVar) {
            this.a.remove(asVar);
            this.b.remove(asVar);
        }
    }

    static final class b extends CameraCaptureSession.CaptureCallback {
        final Set a = new HashSet();
        private final Executor b;

        b(Executor executor) {
            this.b = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(TotalCaptureResult totalCaptureResult) {
            HashSet hashSet = new HashSet();
            for (c cVar : this.a) {
                if (cVar.a(totalCaptureResult)) {
                    hashSet.add(cVar);
                }
            }
            if (hashSet.isEmpty()) {
                return;
            }
            this.a.removeAll(hashSet);
        }

        void b(c cVar) {
            this.a.add(cVar);
        }

        void d(c cVar) {
            this.a.remove(cVar);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, final TotalCaptureResult totalCaptureResult) {
            this.b.execute(new Runnable() { // from class: androidx.camera.camera2.internal.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c(totalCaptureResult);
                }
            });
        }
    }

    public interface c {
        boolean a(TotalCaptureResult totalCaptureResult);
    }

    h(zs zsVar, ScheduledExecutorService scheduledExecutorService, Executor executor, CameraControlInternal.b bVar, w92 w92Var) {
        SessionConfig.b bVar2 = new SessionConfig.b();
        this.g = bVar2;
        this.o = 0;
        this.f150q = false;
        this.r = 2;
        this.u = new AtomicLong(0L);
        this.v = os0.p(null);
        this.w = 1;
        this.x = 0L;
        a aVar = new a();
        this.y = aVar;
        this.e = zsVar;
        this.f = bVar;
        this.c = executor;
        b bVar3 = new b(executor);
        this.b = bVar3;
        bVar2.z(this.w);
        bVar2.k(r1.e(bVar3));
        bVar2.k(aVar);
        this.k = new e2(this, zsVar, executor);
        this.h = new m2(this, scheduledExecutorService, executor, w92Var);
        this.i = new h3(this, zsVar, executor);
        this.j = new g3(this, zsVar, executor);
        this.l = new m3(zsVar);
        this.s = new y4(w92Var);
        this.t = new nc(w92Var);
        this.m = new fr(this, executor);
        this.n = new j0(this, zsVar, w92Var, executor, scheduledExecutorService);
    }

    public static int B(zs zsVar, int i) {
        int[] iArr = (int[]) zsVar.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (K(i, iArr)) {
            return i;
        }
        return K(1, iArr) ? 1 : 0;
    }

    private int D(int i) {
        int[] iArr = (int[]) this.e.a(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (K(i, iArr)) {
            return i;
        }
        return K(1, iArr) ? 1 : 0;
    }

    private boolean J() {
        return F() > 0;
    }

    private static boolean K(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    static boolean L(TotalCaptureResult totalCaptureResult, long j) {
        Long l;
        if (totalCaptureResult.getRequest() == null) {
            return false;
        }
        Object tag = totalCaptureResult.getRequest().getTag();
        return (tag instanceof vz2) && (l = (Long) ((vz2) tag).d("CameraControlSessionUpdateId")) != null && l.longValue() >= j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(Executor executor, as asVar) {
        this.y.h(executor, asVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(as asVar) {
        this.y.l(asVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ub1 R(List list, int i, int i2, int i3, Void r5) {
        return this.n.h(list, i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(CallbackToFutureAdapter.a aVar) {
        os0.C(g0(f0()), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object T(final CallbackToFutureAdapter.a aVar) {
        this.c.execute(new Runnable() { // from class: mr
            @Override // java.lang.Runnable
            public final void run() {
                this.a.S(aVar);
            }
        });
        return "updateSessionConfigAsync";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean U(long j, CallbackToFutureAdapter.a aVar, TotalCaptureResult totalCaptureResult) {
        if (!L(totalCaptureResult, j)) {
            return false;
        }
        aVar.c(null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object V(final long j, final CallbackToFutureAdapter.a aVar) {
        r(new c() { // from class: or
            @Override // androidx.camera.camera2.internal.h.c
            public final boolean a(TotalCaptureResult totalCaptureResult) {
                return h.U(j, aVar, totalCaptureResult);
            }
        });
        return "waitForSessionUpdateId:" + j;
    }

    private ub1 g0(final long j) {
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: nr
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.V(j, aVar);
            }
        });
    }

    int A(int i) {
        return B(this.e, i);
    }

    int C(int i) {
        int[] iArr = (int[]) this.e.a(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (K(i, iArr)) {
            return i;
        }
        if (K(4, iArr)) {
            return 4;
        }
        return K(1, iArr) ? 1 : 0;
    }

    public g3 E() {
        return this.j;
    }

    int F() {
        int i;
        synchronized (this.d) {
            i = this.o;
        }
        return i;
    }

    public h3 G() {
        return this.i;
    }

    public j3 H() {
        return this.l;
    }

    void I() {
        synchronized (this.d) {
            this.o++;
        }
    }

    boolean M() {
        return this.f150q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(c cVar) {
        this.b.d(cVar);
    }

    void X(final as asVar) {
        this.c.execute(new Runnable() { // from class: jr
            @Override // java.lang.Runnable
            public final void run() {
                this.a.Q(asVar);
            }
        });
    }

    void Y() {
        b0(1);
    }

    void Z(boolean z) {
        this.h.z(z);
        this.i.f(z);
        this.j.e(z);
        this.k.b(z);
        this.m.t(z);
        if (z) {
            return;
        }
        this.p = null;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void a(SessionConfig.b bVar) {
        this.l.a(bVar);
    }

    public void a0(Rational rational) {
        this.h.A(rational);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public ub1 b(final List list, final int i, final int i2) {
        if (J()) {
            final int iV = v();
            return cs0.b(os0.B(this.v)).f(new ab() { // from class: gr
                @Override // defpackage.ab
                public final ub1 apply(Object obj) {
                    return this.a.R(list, i, iV, i2, (Void) obj);
                }
            }, this.c);
        }
        androidx.camera.core.x.k("Camera2CameraControlImp", "Camera is not active.");
        return os0.n(new CameraControl$OperationCanceledException("Camera is not active."));
    }

    void b0(int i) {
        this.w = i;
        this.h.B(i);
        this.n.g(this.w);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void c(Config config) {
        this.m.g(ow.a.e(config).d()).a(new Runnable() { // from class: ir
            @Override // java.lang.Runnable
            public final void run() {
                h.N();
            }
        }, androidx.camera.core.impl.utils.executor.c.b());
    }

    public void c0(boolean z) {
        this.l.e(z);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public Rect d() {
        return (Rect) b52.g((Rect) this.e.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }

    void d0(List list) {
        this.f.b(list);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void e(int i) {
        if (!J()) {
            androidx.camera.core.x.k("Camera2CameraControlImp", "Camera is not active.");
            return;
        }
        this.r = i;
        j3 j3Var = this.l;
        boolean z = true;
        if (this.r != 1 && this.r != 0) {
            z = false;
        }
        j3Var.d(z);
        this.v = e0();
    }

    public ub1 e0() {
        return os0.B(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: kr
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.T(aVar);
            }
        }));
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public Config f() {
        return this.m.n();
    }

    long f0() {
        this.x = this.u.getAndIncrement();
        this.f.a();
        return this.x;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void g(androidx.camera.core.u.i iVar) {
        this.p = iVar;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void h() {
        this.m.j().a(new Runnable() { // from class: lr
            @Override // java.lang.Runnable
            public final void run() {
                h.P();
            }
        }, androidx.camera.core.impl.utils.executor.c.b());
    }

    void r(c cVar) {
        this.b.b(cVar);
    }

    void s(final Executor executor, final as asVar) {
        this.c.execute(new Runnable() { // from class: hr
            @Override // java.lang.Runnable
            public final void run() {
                this.a.O(executor, asVar);
            }
        });
    }

    void t() {
        synchronized (this.d) {
            try {
                int i = this.o;
                if (i == 0) {
                    throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
                }
                this.o = i - 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void u(boolean z) {
        this.f150q = z;
        if (!z) {
            androidx.camera.core.impl.k.a aVar = new androidx.camera.core.impl.k.a();
            aVar.v(this.w);
            aVar.w(true);
            yr.a aVar2 = new yr.a();
            aVar2.f(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(A(1)));
            aVar2.f(CaptureRequest.FLASH_MODE, 0);
            aVar.e(aVar2.c());
            d0(Collections.singletonList(aVar.h()));
        }
        f0();
    }

    public int v() {
        return this.r;
    }

    public m2 w() {
        return this.h;
    }

    public androidx.camera.core.u.i x() {
        return this.p;
    }

    public SessionConfig y() {
        this.g.z(this.w);
        this.g.v(z());
        this.g.o("CameraControlSessionUpdateId", Long.valueOf(this.x));
        return this.g.p();
    }

    Config z() {
        yr.a aVar = new yr.a();
        CaptureRequest.Key key = CaptureRequest.CONTROL_MODE;
        Config.OptionPriority optionPriority = Config.OptionPriority.REQUIRED;
        aVar.g(key, 1, optionPriority);
        this.h.g(aVar);
        this.s.a(aVar);
        this.i.a(aVar);
        int iA = this.h.s() ? 5 : 1;
        if (this.f150q) {
            aVar.g(CaptureRequest.FLASH_MODE, 2, optionPriority);
        } else {
            int i = this.r;
            if (i == 0) {
                iA = this.t.a(2);
            } else if (i == 1) {
                iA = 3;
            } else if (i == 2) {
                iA = 1;
            }
        }
        aVar.g(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(A(iA)), optionPriority);
        aVar.g(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(D(1)), optionPriority);
        this.k.c(aVar);
        this.m.i(aVar);
        return aVar.c();
    }
}
