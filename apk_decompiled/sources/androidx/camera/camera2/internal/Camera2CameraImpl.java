package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.media.CamcorderProfile;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraState;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.ab;
import defpackage.b52;
import defpackage.bs0;
import defpackage.cc1;
import defpackage.cs0;
import defpackage.dt;
import defpackage.ev2;
import defpackage.gt;
import defpackage.iu;
import defpackage.k11;
import defpackage.n52;
import defpackage.na1;
import defpackage.oa1;
import defpackage.os0;
import defpackage.re0;
import defpackage.rt;
import defpackage.ub1;
import defpackage.ut1;
import defpackage.w7;
import defpackage.xa0;
import defpackage.xu;
import defpackage.zs;
import defpackage.zt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
final class Camera2CameraImpl implements CameraInternal {
    private final t2.b F;
    private final Set G;
    private androidx.camera.core.impl.g H;
    final Object I;
    boolean J;
    private final c2 K;
    private final zs L;
    private final re0 M;
    private final s2 N;
    private final h O;
    private final androidx.camera.core.impl.c0 a;
    private final iu b;
    private final Executor c;
    private final ScheduledExecutorService d;
    volatile InternalState e = InternalState.INITIALIZED;
    private final cc1 f;
    private final p1 g;
    private final androidx.camera.camera2.internal.h h;
    private final i i;
    final d0 j;
    CameraDevice k;
    int l;
    x1 m;
    final AtomicInteger n;
    CallbackToFutureAdapter.a o;
    final Map p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final e f147q;
    final f r;
    final gt s;
    final androidx.camera.core.impl.j t;
    private final boolean u;
    private final boolean v;
    private boolean w;
    private boolean x;
    private q2 y;
    private final a2 z;

    enum InternalState {
        INITIALIZED,
        PENDING_OPEN,
        OPENING,
        OPENED,
        CONFIGURED,
        CLOSING,
        REOPENING,
        REOPENING_QUIRK,
        RELEASING,
        RELEASED
    }

    class a implements androidx.camera.camera2.internal.d {
        a() {
        }

        @Override // androidx.camera.camera2.internal.d
        public CamcorderProfile a(int i, int i2) {
            return CamcorderProfile.get(i, i2);
        }

        @Override // androidx.camera.camera2.internal.d
        public boolean b(int i, int i2) {
            return CamcorderProfile.hasProfile(i, i2);
        }
    }

    class b extends CameraDevice.StateCallback {
        final /* synthetic */ CallbackToFutureAdapter.a a;

        b(CallbackToFutureAdapter.a aVar) {
            this.a = aVar;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            Camera2CameraImpl.this.S("openCameraConfigAndClose camera closed");
            this.a.c(null);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            Camera2CameraImpl.this.S("openCameraConfigAndClose camera disconnected");
            this.a.c(null);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            Camera2CameraImpl.this.S("openCameraConfigAndClose camera error " + i);
            this.a.c(null);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(final CameraDevice cameraDevice) {
            Camera2CameraImpl.this.S("openCameraConfigAndClose camera opened");
            ub1 ub1VarP = Camera2CameraImpl.this.P(cameraDevice);
            Objects.requireNonNull(cameraDevice);
            ub1VarP.a(new Runnable() { // from class: qr
                @Override // java.lang.Runnable
                public final void run() {
                    cameraDevice.close();
                }
            }, Camera2CameraImpl.this.c);
        }
    }

    class c implements bs0 {
        final /* synthetic */ x1 a;

        c(x1 x1Var) {
            this.a = x1Var;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r2) {
            Camera2CameraImpl.this.p.remove(this.a);
            int iOrdinal = Camera2CameraImpl.this.e.ordinal();
            if (iOrdinal != 5) {
                if (iOrdinal != 6) {
                    if (iOrdinal != 7) {
                        if (iOrdinal != 8) {
                            return;
                        }
                    }
                } else if (Camera2CameraImpl.this.l == 0) {
                    return;
                }
                Camera2CameraImpl.this.S("Camera reopen required. Checking if the current camera can be closed safely.");
            }
            if (Camera2CameraImpl.this.c0()) {
                Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                if (camera2CameraImpl.k != null) {
                    camera2CameraImpl.S("closing camera");
                    w7.a(Camera2CameraImpl.this.k);
                    Camera2CameraImpl.this.k = null;
                }
            }
        }
    }

    class d implements bs0 {
        final /* synthetic */ x1 a;

        d(x1 x1Var) {
            this.a = x1Var;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            if (th instanceof DeferrableSurface.SurfaceClosedException) {
                SessionConfig sessionConfigU = Camera2CameraImpl.this.U(((DeferrableSurface.SurfaceClosedException) th).getDeferrableSurface());
                if (sessionConfigU != null) {
                    Camera2CameraImpl.this.A0(sessionConfigU);
                    return;
                }
                return;
            }
            if (th instanceof CancellationException) {
                Camera2CameraImpl.this.S("Unable to configure camera cancelled");
                return;
            }
            InternalState internalState = Camera2CameraImpl.this.e;
            InternalState internalState2 = InternalState.OPENED;
            if (internalState == internalState2) {
                Camera2CameraImpl.this.G0(internalState2, CameraState.a.b(4, th));
            }
            androidx.camera.core.x.d("Camera2CameraImpl", "Unable to configure camera " + Camera2CameraImpl.this, th);
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            if (camera2CameraImpl.m == this.a) {
                camera2CameraImpl.D0(false);
            }
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r2) {
            if (Camera2CameraImpl.this.s.a() == 2 && Camera2CameraImpl.this.e == InternalState.OPENED) {
                Camera2CameraImpl.this.F0(InternalState.CONFIGURED);
            }
        }
    }

    final class e extends CameraManager.AvailabilityCallback implements androidx.camera.core.impl.j.c {
        private final String a;
        private boolean b = true;

        e(String str) {
            this.a = str;
        }

        @Override // androidx.camera.core.impl.j.c
        public void a() {
            if (Camera2CameraImpl.this.e == InternalState.PENDING_OPEN) {
                Camera2CameraImpl.this.N0(false);
            }
        }

        boolean b() {
            return this.b;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(String str) {
            if (this.a.equals(str)) {
                this.b = true;
                if (Camera2CameraImpl.this.e == InternalState.PENDING_OPEN) {
                    Camera2CameraImpl.this.N0(false);
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(String str) {
            if (this.a.equals(str)) {
                this.b = false;
            }
        }
    }

    final class f implements androidx.camera.core.impl.j.b {
        f() {
        }

        @Override // androidx.camera.core.impl.j.b
        public void a() {
            if (Camera2CameraImpl.this.e == InternalState.OPENED) {
                Camera2CameraImpl.this.y0();
            }
        }
    }

    final class g implements CameraControlInternal.b {
        g() {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.b
        public void a() {
            Camera2CameraImpl.this.O0();
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.b
        public void b(List list) {
            Camera2CameraImpl.this.I0((List) b52.g(list));
        }
    }

    final class i extends CameraDevice.StateCallback {
        private final Executor a;
        private final ScheduledExecutorService b;
        private b c;
        ScheduledFuture d;
        private final a e;

        class a {
            private final long a;
            private long b = -1;

            a(long j) {
                this.a = j;
            }

            boolean a() {
                if (b() < d()) {
                    return true;
                }
                e();
                return false;
            }

            long b() {
                long jUptimeMillis = SystemClock.uptimeMillis();
                if (this.b == -1) {
                    this.b = jUptimeMillis;
                }
                return jUptimeMillis - this.b;
            }

            int c() {
                if (!i.this.f()) {
                    return 700;
                }
                long jB = b();
                if (jB <= 120000) {
                    return 1000;
                }
                return jB <= 300000 ? 2000 : 4000;
            }

            int d() {
                if (i.this.f()) {
                    long j = this.a;
                    if (j > 0) {
                        return Math.min((int) j, 1800000);
                    }
                    return 1800000;
                }
                long j2 = this.a;
                if (j2 > 0) {
                    return Math.min((int) j2, 10000);
                }
                return 10000;
            }

            void e() {
                this.b = -1L;
            }
        }

        class b implements Runnable {
            private Executor a;
            private boolean b = false;

            b(Executor executor) {
                this.a = executor;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void c() {
                if (this.b) {
                    return;
                }
                b52.i(Camera2CameraImpl.this.e == InternalState.REOPENING || Camera2CameraImpl.this.e == InternalState.REOPENING_QUIRK);
                if (i.this.f()) {
                    Camera2CameraImpl.this.M0(true);
                } else {
                    Camera2CameraImpl.this.N0(true);
                }
            }

            void b() {
                this.b = true;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.execute(new Runnable() { // from class: androidx.camera.camera2.internal.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.c();
                    }
                });
            }
        }

        i(Executor executor, ScheduledExecutorService scheduledExecutorService, long j) {
            this.a = executor;
            this.b = scheduledExecutorService;
            this.e = new a(j);
        }

        private void b(CameraDevice cameraDevice, int i) {
            b52.j(Camera2CameraImpl.this.e == InternalState.OPENING || Camera2CameraImpl.this.e == InternalState.OPENED || Camera2CameraImpl.this.e == InternalState.CONFIGURED || Camera2CameraImpl.this.e == InternalState.REOPENING || Camera2CameraImpl.this.e == InternalState.REOPENING_QUIRK, "Attempt to handle open error from non open state: " + Camera2CameraImpl.this.e);
            if (i == 1 || i == 2 || i == 4) {
                androidx.camera.core.x.a("Camera2CameraImpl", String.format("Attempt to reopen camera[%s] after error[%s]", cameraDevice.getId(), Camera2CameraImpl.Y(i)));
                c(i);
                return;
            }
            androidx.camera.core.x.c("Camera2CameraImpl", "Error observed on open (or opening) camera device " + cameraDevice.getId() + ": " + Camera2CameraImpl.Y(i) + " closing camera.");
            Camera2CameraImpl.this.G0(InternalState.CLOSING, CameraState.a.a(i == 3 ? 5 : 6));
            Camera2CameraImpl.this.N(false);
        }

        private void c(int i) {
            int i2 = 1;
            b52.j(Camera2CameraImpl.this.l != 0, "Can only reopen camera device after error if the camera device is actually in an error state.");
            if (i == 1) {
                i2 = 2;
            } else if (i != 2) {
                i2 = 3;
            }
            Camera2CameraImpl.this.G0(InternalState.REOPENING, CameraState.a.a(i2));
            Camera2CameraImpl.this.N(false);
        }

        boolean a() {
            if (this.d == null) {
                return false;
            }
            Camera2CameraImpl.this.S("Cancelling scheduled re-open: " + this.c);
            this.c.b();
            this.c = null;
            this.d.cancel(false);
            this.d = null;
            return true;
        }

        void d() {
            this.e.e();
        }

        void e() {
            b52.i(this.c == null);
            b52.i(this.d == null);
            if (!this.e.a()) {
                androidx.camera.core.x.c("Camera2CameraImpl", "Camera reopening attempted for " + this.e.d() + "ms without success.");
                Camera2CameraImpl.this.H0(InternalState.PENDING_OPEN, null, false);
                return;
            }
            this.c = new b(this.a);
            Camera2CameraImpl.this.S("Attempting camera re-open in " + this.e.c() + "ms: " + this.c + " activeResuming = " + Camera2CameraImpl.this.J);
            this.d = this.b.schedule(this.c, (long) this.e.c(), TimeUnit.MILLISECONDS);
        }

        boolean f() {
            int i;
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            return camera2CameraImpl.J && ((i = camera2CameraImpl.l) == 1 || i == 2);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            Camera2CameraImpl.this.S("CameraDevice.onClosed()");
            b52.j(Camera2CameraImpl.this.k == null, "Unexpected onClose callback on camera device: " + cameraDevice);
            int iOrdinal = Camera2CameraImpl.this.e.ordinal();
            if (iOrdinal != 5) {
                if (iOrdinal == 6 || iOrdinal == 7) {
                    Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                    if (camera2CameraImpl.l == 0) {
                        camera2CameraImpl.N0(false);
                        return;
                    }
                    camera2CameraImpl.S("Camera closed due to error: " + Camera2CameraImpl.Y(Camera2CameraImpl.this.l));
                    e();
                    return;
                }
                if (iOrdinal != 8) {
                    throw new IllegalStateException("Camera closed while in state: " + Camera2CameraImpl.this.e);
                }
            }
            b52.i(Camera2CameraImpl.this.c0());
            Camera2CameraImpl.this.Q();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            Camera2CameraImpl.this.S("CameraDevice.onDisconnected()");
            onError(cameraDevice, 1);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.k = cameraDevice;
            camera2CameraImpl.l = i;
            camera2CameraImpl.O.b();
            switch (Camera2CameraImpl.this.e.ordinal()) {
                case 2:
                case 3:
                case 4:
                case 6:
                case 7:
                    androidx.camera.core.x.a("Camera2CameraImpl", String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will attempt recovering from error.", cameraDevice.getId(), Camera2CameraImpl.Y(i), Camera2CameraImpl.this.e.name()));
                    b(cameraDevice, i);
                    return;
                case 5:
                case 8:
                    androidx.camera.core.x.c("Camera2CameraImpl", String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will finish closing camera.", cameraDevice.getId(), Camera2CameraImpl.Y(i), Camera2CameraImpl.this.e.name()));
                    Camera2CameraImpl.this.N(false);
                    return;
                default:
                    throw new IllegalStateException("onError() should not be possible from state: " + Camera2CameraImpl.this.e);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            Camera2CameraImpl.this.S("CameraDevice.onOpened()");
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.k = cameraDevice;
            camera2CameraImpl.l = 0;
            d();
            int iOrdinal = Camera2CameraImpl.this.e.ordinal();
            if (iOrdinal != 2) {
                if (iOrdinal != 5) {
                    if (iOrdinal != 6 && iOrdinal != 7) {
                        if (iOrdinal != 8) {
                            throw new IllegalStateException("onOpened() should not be possible from state: " + Camera2CameraImpl.this.e);
                        }
                    }
                }
                b52.i(Camera2CameraImpl.this.c0());
                Camera2CameraImpl.this.k.close();
                Camera2CameraImpl.this.k = null;
                return;
            }
            Camera2CameraImpl.this.F0(InternalState.OPENED);
            androidx.camera.core.impl.j jVar = Camera2CameraImpl.this.t;
            String id = cameraDevice.getId();
            Camera2CameraImpl camera2CameraImpl2 = Camera2CameraImpl.this;
            if (jVar.i(id, camera2CameraImpl2.s.c(camera2CameraImpl2.k.getId()))) {
                Camera2CameraImpl.this.y0();
            }
        }
    }

    static abstract class j {
        j() {
        }

        static j a(String str, Class cls, SessionConfig sessionConfig, androidx.camera.core.impl.d0 d0Var, Size size, androidx.camera.core.impl.x xVar, List list) {
            return new androidx.camera.camera2.internal.b(str, cls, sessionConfig, d0Var, size, xVar, list);
        }

        static j b(UseCase useCase) {
            return a(Camera2CameraImpl.a0(useCase), useCase.getClass(), useCase.t(), useCase.j(), useCase.f(), useCase.e(), Camera2CameraImpl.X(useCase));
        }

        abstract List c();

        abstract SessionConfig d();

        abstract androidx.camera.core.impl.x e();

        abstract Size f();

        abstract androidx.camera.core.impl.d0 g();

        abstract String h();

        abstract Class i();
    }

    Camera2CameraImpl(Context context, iu iuVar, String str, d0 d0Var, gt gtVar, androidx.camera.core.impl.j jVar, Executor executor, Handler handler, c2 c2Var, long j2) throws CameraUnavailableException {
        cc1 cc1Var = new cc1();
        this.f = cc1Var;
        this.l = 0;
        this.n = new AtomicInteger(0);
        this.p = new LinkedHashMap();
        this.w = false;
        this.x = false;
        this.G = new HashSet();
        this.H = dt.a();
        this.I = new Object();
        this.J = false;
        this.O = new h(this, null);
        this.b = iuVar;
        this.s = gtVar;
        this.t = jVar;
        ScheduledExecutorService scheduledExecutorServiceF = androidx.camera.core.impl.utils.executor.c.f(handler);
        this.d = scheduledExecutorServiceF;
        Executor executorG = androidx.camera.core.impl.utils.executor.c.g(executor);
        this.c = executorG;
        this.i = new i(executorG, scheduledExecutorServiceF, j2);
        this.a = new androidx.camera.core.impl.c0(str);
        cc1Var.m(CameraInternal.State.CLOSED);
        p1 p1Var = new p1(jVar);
        this.g = p1Var;
        a2 a2Var = new a2(executorG);
        this.z = a2Var;
        this.K = c2Var;
        try {
            zs zsVarC = iuVar.c(str);
            this.L = zsVarC;
            androidx.camera.camera2.internal.h hVar = new androidx.camera.camera2.internal.h(zsVarC, scheduledExecutorServiceF, executorG, new g(), d0Var.m());
            this.h = hVar;
            this.j = d0Var;
            d0Var.t(hVar);
            d0Var.w(p1Var.a());
            this.M = re0.a(zsVarC);
            this.m = t0();
            this.F = new t2.b(executorG, scheduledExecutorServiceF, handler, a2Var, d0Var.m(), xa0.b());
            this.u = d0Var.m().a(na1.class);
            this.v = d0Var.m().a(oa1.class);
            e eVar = new e(str);
            this.f147q = eVar;
            f fVar = new f();
            this.r = fVar;
            jVar.g(this, executorG, fVar, eVar);
            iuVar.g(executorG, eVar);
            this.N = new s2(context, str, iuVar, new a());
        } catch (CameraAccessExceptionCompat e2) {
            throw xu.a(e2);
        }
    }

    private void C0() {
        if (this.y != null) {
            this.a.w(this.y.f() + this.y.hashCode());
            this.a.x(this.y.f() + this.y.hashCode());
            this.y.c();
            this.y = null;
        }
    }

    private void E0(final String str, final SessionConfig sessionConfig, final androidx.camera.core.impl.d0 d0Var, final androidx.camera.core.impl.x xVar, final List list) {
        this.c.execute(new Runnable() { // from class: androidx.camera.camera2.internal.x
            @Override // java.lang.Runnable
            public final void run() {
                this.a.r0(str, sessionConfig, d0Var, xVar, list);
            }
        });
    }

    private Collection J0(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(j.b((UseCase) it.next()));
        }
        return arrayList;
    }

    private void K() {
        q2 q2Var = this.y;
        if (q2Var != null) {
            String strZ = Z(q2Var);
            androidx.camera.core.impl.c0 c0Var = this.a;
            SessionConfig sessionConfigH = this.y.h();
            androidx.camera.core.impl.d0 d0VarI = this.y.i();
            UseCaseConfigFactory.CaptureType captureType = UseCaseConfigFactory.CaptureType.METERING_REPEATING;
            c0Var.v(strZ, sessionConfigH, d0VarI, null, Collections.singletonList(captureType));
            this.a.u(strZ, this.y.h(), this.y.i(), null, Collections.singletonList(captureType));
        }
    }

    private void K0(Collection collection) {
        Size sizeF;
        boolean zIsEmpty = this.a.h().isEmpty();
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        Rational rational = null;
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (!this.a.o(jVar.h())) {
                this.a.v(jVar.h(), jVar.d(), jVar.g(), jVar.e(), jVar.c());
                arrayList.add(jVar.h());
                if (jVar.i() == n52.class && (sizeF = jVar.f()) != null) {
                    rational = new Rational(sizeF.getWidth(), sizeF.getHeight());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        S("Use cases [" + TextUtils.join(", ", arrayList) + "] now ATTACHED");
        if (zIsEmpty) {
            this.h.Z(true);
            this.h.I();
        }
        L();
        P0();
        O0();
        D0(false);
        if (this.e == InternalState.OPENED) {
            y0();
        } else {
            z0();
        }
        if (rational != null) {
            this.h.a0(rational);
        }
    }

    private void L() {
        SessionConfig sessionConfigB = this.a.g().b();
        androidx.camera.core.impl.k kVarI = sessionConfigB.i();
        int size = kVarI.i().size();
        int size2 = sessionConfigB.m().size();
        if (sessionConfigB.m().isEmpty()) {
            return;
        }
        if (kVarI.i().isEmpty()) {
            if (this.y == null) {
                this.y = new q2(this.j.q(), this.K, new q2.c() { // from class: androidx.camera.camera2.internal.m
                    @Override // androidx.camera.camera2.internal.q2.c
                    public final void a() {
                        this.a.e0();
                    }
                });
            }
            if (d0()) {
                K();
                return;
            } else {
                androidx.camera.core.x.c("Camera2CameraImpl", "Failed to add a repeating surface, CameraControl and ImageCapture may encounter issues due to the absence of repeating surface. Please add a UseCase (Preview or ImageAnalysis) that can provide a repeating surface for CameraControl and ImageCapture to function properly.");
                return;
            }
        }
        if (size2 == 1 && size == 1) {
            C0();
            return;
        }
        if (size >= 2) {
            C0();
            return;
        }
        if (this.y != null && !d0()) {
            C0();
            return;
        }
        androidx.camera.core.x.a("Camera2CameraImpl", "No need to remove a previous mMeteringRepeating, SessionConfig Surfaces: " + size2 + ", CaptureConfig Surfaces: " + size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public void j0(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (this.a.o(jVar.h())) {
                this.a.t(jVar.h());
                arrayList.add(jVar.h());
                if (jVar.i() == n52.class) {
                    z = true;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        S("Use cases [" + TextUtils.join(", ", arrayList) + "] now DETACHED for camera");
        if (z) {
            this.h.a0(null);
        }
        L();
        if (this.a.i().isEmpty()) {
            this.h.c0(false);
        } else {
            P0();
        }
        if (this.a.h().isEmpty()) {
            this.h.t();
            D0(false);
            this.h.Z(false);
            this.m = t0();
            O();
            return;
        }
        O0();
        D0(false);
        if (this.e == InternalState.OPENED) {
            y0();
        }
    }

    private boolean M(androidx.camera.core.impl.k.a aVar) {
        if (!aVar.m().isEmpty()) {
            androidx.camera.core.x.k("Camera2CameraImpl", "The capture config builder already has surface inside.");
            return false;
        }
        Iterator it = this.a.f().iterator();
        while (it.hasNext()) {
            androidx.camera.core.impl.k kVarI = ((SessionConfig) it.next()).i();
            List listI = kVarI.i();
            if (!listI.isEmpty()) {
                if (kVarI.h() != 0) {
                    aVar.u(kVarI.h());
                }
                if (kVarI.l() != 0) {
                    aVar.x(kVarI.l());
                }
                Iterator it2 = listI.iterator();
                while (it2.hasNext()) {
                    aVar.f((DeferrableSurface) it2.next());
                }
            }
        }
        if (!aVar.m().isEmpty()) {
            return true;
        }
        androidx.camera.core.x.k("Camera2CameraImpl", "Unable to find a repeating surface to attach to CaptureConfig");
        return false;
    }

    private void O() {
        S("Closing camera.");
        int iOrdinal = this.e.ordinal();
        if (iOrdinal == 1) {
            b52.i(this.k == null);
            F0(InternalState.INITIALIZED);
            return;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3 || iOrdinal == 4) {
                F0(InternalState.CLOSING);
                N(false);
                return;
            } else if (iOrdinal != 6 && iOrdinal != 7) {
                S("close() ignored due to being in state: " + this.e);
                return;
            }
        }
        boolean z = this.i.a() || this.O.c();
        this.O.a();
        F0(InternalState.CLOSING);
        if (z) {
            b52.i(c0());
            Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ub1 P(CameraDevice cameraDevice) {
        final CaptureSession captureSession = new CaptureSession(this.M);
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(640, 480);
        final Surface surface = new Surface(surfaceTexture);
        final k11 k11Var = new k11(surface);
        k11Var.k().a(new Runnable() { // from class: androidx.camera.camera2.internal.o
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.g0(surface, surfaceTexture);
            }
        }, androidx.camera.core.impl.utils.executor.c.b());
        SessionConfig.b bVar = new SessionConfig.b();
        bVar.i(k11Var);
        bVar.z(1);
        S("Start configAndClose.");
        return cs0.b(os0.I(captureSession.b(bVar.p(), cameraDevice, this.F.a()))).f(new ab() { // from class: androidx.camera.camera2.internal.p
            @Override // defpackage.ab
            public final ub1 apply(Object obj) {
                return Camera2CameraImpl.h0(captureSession, k11Var, (Void) obj);
            }
        }, this.c);
    }

    private void P0() {
        Iterator it = this.a.i().iterator();
        boolean zW = false;
        while (it.hasNext()) {
            zW |= ((androidx.camera.core.impl.d0) it.next()).w(false);
        }
        this.h.c0(zW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        b52.i(this.e == InternalState.RELEASING || this.e == InternalState.CLOSING);
        b52.i(this.p.isEmpty());
        if (!this.w) {
            V();
            return;
        }
        if (this.x) {
            S("Ignored since configAndClose is processing");
            return;
        }
        if (!this.f147q.b()) {
            S("Ignore configAndClose since camera is unavailable.");
            return;
        }
        S("Open camera to configAndClose");
        ub1 ub1VarW0 = w0();
        this.x = true;
        ub1VarW0.a(new Runnable() { // from class: androidx.camera.camera2.internal.q
            @Override // java.lang.Runnable
            public final void run() {
                this.a.i0();
            }
        }, this.c);
    }

    private CameraDevice.StateCallback R() {
        ArrayList arrayList = new ArrayList(this.a.g().b().c());
        arrayList.add(this.z.c());
        arrayList.add(this.i);
        return rt.a(arrayList);
    }

    private void T(String str, Throwable th) {
        androidx.camera.core.x.b("Camera2CameraImpl", String.format("{%s} %s", toString(), str), th);
    }

    private int W() {
        synchronized (this.I) {
            try {
                return this.s.a() == 2 ? 1 : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static List X(UseCase useCase) {
        if (useCase.g() == null) {
            return null;
        }
        return ev2.c0(useCase);
    }

    static String Y(int i2) {
        if (i2 == 0) {
            return "ERROR_NONE";
        }
        if (i2 == 1) {
            return "ERROR_CAMERA_IN_USE";
        }
        if (i2 == 2) {
            return "ERROR_MAX_CAMERAS_IN_USE";
        }
        if (i2 == 3) {
            return "ERROR_CAMERA_DISABLED";
        }
        if (i2 != 4) {
            return i2 != 5 ? "UNKNOWN ERROR" : "ERROR_CAMERA_SERVICE";
        }
        return "ERROR_CAMERA_DEVICE";
    }

    static String Z(q2 q2Var) {
        return q2Var.f() + q2Var.hashCode();
    }

    static String a0(UseCase useCase) {
        return useCase.o() + useCase.hashCode();
    }

    private boolean d0() {
        ArrayList arrayList = new ArrayList();
        int iW = W();
        for (androidx.camera.core.impl.c0.b bVar : this.a.j()) {
            if (bVar.c() == null || bVar.c().get(0) != UseCaseConfigFactory.CaptureType.METERING_REPEATING) {
                if (bVar.e() == null || bVar.c() == null) {
                    androidx.camera.core.x.k("Camera2CameraImpl", "Invalid stream spec or capture types in " + bVar);
                    return false;
                }
                SessionConfig sessionConfigD = bVar.d();
                androidx.camera.core.impl.d0 d0VarF = bVar.f();
                for (DeferrableSurface deferrableSurface : sessionConfigD.m()) {
                    arrayList.add(androidx.camera.core.impl.a.a(this.N.M(iW, d0VarF.p(), deferrableSurface.h()), d0VarF.p(), deferrableSurface.h(), bVar.e().b(), bVar.c(), bVar.e().d(), d0VarF.J(null)));
                }
            }
        }
        b52.g(this.y);
        HashMap map = new HashMap();
        map.put(this.y.i(), Collections.singletonList(this.y.e()));
        try {
            this.N.A(iW, arrayList, map, false);
            S("Surface combination with metering repeating supported!");
            return true;
        } catch (IllegalArgumentException e2) {
            T("Surface combination with metering repeating  not supported!", e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0() {
        if (b0()) {
            E0(Z(this.y), this.y.h(), this.y.i(), null, Collections.singletonList(UseCaseConfigFactory.CaptureType.METERING_REPEATING));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(List list) {
        try {
            K0(list);
        } finally {
            this.h.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(Surface surface, SurfaceTexture surfaceTexture) {
        surface.release();
        surfaceTexture.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ub1 h0(CaptureSession captureSession, DeferrableSurface deferrableSurface, Void r2) {
        captureSession.close();
        deferrableSurface.d();
        return captureSession.c(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0() {
        this.x = false;
        this.w = false;
        S("OpenCameraConfigAndClose is done, state: " + this.e);
        int iOrdinal = this.e.ordinal();
        if (iOrdinal != 5) {
            if (iOrdinal == 6) {
                if (this.l == 0) {
                    N0(false);
                    return;
                }
                S("OpenCameraConfigAndClose in error: " + Y(this.l));
                this.i.e();
                return;
            }
            if (iOrdinal != 8) {
                S("OpenCameraConfigAndClose finished while in state: " + this.e);
                return;
            }
        }
        b52.i(c0());
        V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(CallbackToFutureAdapter.a aVar) {
        q2 q2Var = this.y;
        if (q2Var == null) {
            aVar.c(Boolean.FALSE);
        } else {
            aVar.c(Boolean.valueOf(this.a.o(Z(q2Var))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object l0(final CallbackToFutureAdapter.a aVar) {
        try {
            this.c.execute(new Runnable() { // from class: androidx.camera.camera2.internal.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.k0(aVar);
                }
            });
            return "isMeteringRepeatingAttached";
        } catch (RejectedExecutionException unused) {
            aVar.f(new RuntimeException("Unable to check if MeteringRepeating is attached. Camera executor shut down."));
            return "isMeteringRepeatingAttached";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(String str, SessionConfig sessionConfig, androidx.camera.core.impl.d0 d0Var, androidx.camera.core.impl.x xVar, List list) {
        S("Use case " + str + " ACTIVE");
        this.a.u(str, sessionConfig, d0Var, xVar, list);
        this.a.y(str, sessionConfig, d0Var, xVar, list);
        O0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(String str) {
        S("Use case " + str + " INACTIVE");
        this.a.x(str);
        O0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(String str, SessionConfig sessionConfig, androidx.camera.core.impl.d0 d0Var, androidx.camera.core.impl.x xVar, List list) {
        S("Use case " + str + " UPDATED");
        this.a.y(str, sessionConfig, d0Var, xVar, list);
        O0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p0(CallbackToFutureAdapter.a aVar) {
        try {
            ArrayList arrayList = new ArrayList(this.a.g().b().c());
            arrayList.add(this.z.c());
            arrayList.add(new b(aVar));
            this.b.f(this.j.d(), this.c, rt.a(arrayList));
            return "configAndCloseTask";
        } catch (CameraAccessExceptionCompat | SecurityException e2) {
            T("Unable to open camera for configAndClose: " + e2.getMessage(), e2);
            aVar.f(e2);
            return "configAndCloseTask";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q0(SessionConfig.c cVar, SessionConfig sessionConfig) {
        cVar.a(sessionConfig, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(String str, SessionConfig sessionConfig, androidx.camera.core.impl.d0 d0Var, androidx.camera.core.impl.x xVar, List list) {
        S("Use case " + str + " RESET");
        this.a.y(str, sessionConfig, d0Var, xVar, list);
        L();
        D0(false);
        O0();
        if (this.e == InternalState.OPENED) {
            y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(boolean z) {
        this.J = z;
        if (z && this.e == InternalState.PENDING_OPEN) {
            M0(false);
        }
    }

    private x1 t0() {
        CaptureSession captureSession;
        synchronized (this.I) {
            captureSession = new CaptureSession(this.M, this.j.m());
        }
        return captureSession;
    }

    private void u0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            UseCase useCase = (UseCase) it.next();
            String strA0 = a0(useCase);
            if (!this.G.contains(strA0)) {
                this.G.add(strA0);
                useCase.K();
                useCase.I();
            }
        }
    }

    private void v0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            UseCase useCase = (UseCase) it.next();
            String strA0 = a0(useCase);
            if (this.G.contains(strA0)) {
                useCase.L();
                this.G.remove(strA0);
            }
        }
    }

    private ub1 w0() {
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.camera2.internal.l
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.p0(aVar);
            }
        });
    }

    private void x0(boolean z) {
        if (!z) {
            this.i.d();
        }
        this.i.a();
        this.O.a();
        S("Opening camera.");
        F0(InternalState.OPENING);
        try {
            this.b.f(this.j.d(), this.c, R());
        } catch (CameraAccessExceptionCompat e2) {
            S("Unable to open camera due to " + e2.getMessage());
            if (e2.getReason() != 10001) {
                this.O.d();
            } else {
                G0(InternalState.INITIALIZED, CameraState.a.b(7, e2));
            }
        } catch (SecurityException e3) {
            S("Unable to open camera due to " + e3.getMessage());
            F0(InternalState.REOPENING);
            this.i.e();
        }
    }

    private void z0() {
        int iOrdinal = this.e.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            M0(false);
            return;
        }
        if (iOrdinal != 5) {
            S("open() ignored due to being in state: " + this.e);
            return;
        }
        F0(InternalState.REOPENING);
        if (c0() || this.x || this.l != 0) {
            return;
        }
        b52.j(this.k != null, "Camera Device should be open if session close is not complete");
        F0(InternalState.OPENED);
        y0();
    }

    void A0(final SessionConfig sessionConfig) {
        ScheduledExecutorService scheduledExecutorServiceE = androidx.camera.core.impl.utils.executor.c.e();
        List listD = sessionConfig.d();
        if (listD.isEmpty()) {
            return;
        }
        final SessionConfig.c cVar = (SessionConfig.c) listD.get(0);
        T("Posting surface closed", new Throwable());
        scheduledExecutorServiceE.execute(new Runnable() { // from class: androidx.camera.camera2.internal.v
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraImpl.q0(cVar, sessionConfig);
            }
        });
    }

    ub1 B0(x1 x1Var, boolean z) {
        x1Var.close();
        ub1 ub1VarC = x1Var.c(z);
        S("Releasing session in state " + this.e.name());
        this.p.put(x1Var, ub1VarC);
        os0.j(ub1VarC, new c(x1Var), androidx.camera.core.impl.utils.executor.c.b());
        return ub1VarC;
    }

    void D0(boolean z) {
        b52.i(this.m != null);
        S("Resetting Capture Session");
        x1 x1Var = this.m;
        SessionConfig sessionConfigF = x1Var.f();
        List listD = x1Var.d();
        x1 x1VarT0 = t0();
        this.m = x1VarT0;
        x1VarT0.g(sessionConfigF);
        this.m.e(listD);
        if (this.e.ordinal() != 3) {
            S("Skipping Capture Session state check due to current camera state: " + this.e + " and previous session status: " + x1Var.h());
        } else if (this.u && x1Var.h()) {
            S("Close camera before creating new session");
            F0(InternalState.REOPENING_QUIRK);
        }
        if (this.v && x1Var.h()) {
            S("ConfigAndClose is required when close the camera.");
            this.w = true;
        }
        B0(x1Var, z);
    }

    void F0(InternalState internalState) {
        G0(internalState, null);
    }

    void G0(InternalState internalState, CameraState.a aVar) {
        H0(internalState, aVar, true);
    }

    void H0(InternalState internalState, CameraState.a aVar, boolean z) {
        CameraInternal.State state;
        S("Transitioning camera internal state: " + this.e + " --> " + internalState);
        this.e = internalState;
        switch (internalState) {
            case INITIALIZED:
                state = CameraInternal.State.CLOSED;
                break;
            case PENDING_OPEN:
                state = CameraInternal.State.PENDING_OPEN;
                break;
            case OPENING:
            case REOPENING:
                state = CameraInternal.State.OPENING;
                break;
            case OPENED:
                state = CameraInternal.State.OPEN;
                break;
            case CONFIGURED:
                state = CameraInternal.State.CONFIGURED;
                break;
            case CLOSING:
            case REOPENING_QUIRK:
                state = CameraInternal.State.CLOSING;
                break;
            case RELEASING:
                state = CameraInternal.State.RELEASING;
                break;
            case RELEASED:
                state = CameraInternal.State.RELEASED;
                break;
            default:
                throw new IllegalStateException("Unknown state: " + internalState);
        }
        this.t.e(this, state, z);
        this.f.m(state);
        this.g.c(state, aVar);
    }

    void I0(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            androidx.camera.core.impl.k kVar = (androidx.camera.core.impl.k) it.next();
            androidx.camera.core.impl.k.a aVarK = androidx.camera.core.impl.k.a.k(kVar);
            if (kVar.k() == 5 && kVar.d() != null) {
                aVarK.p(kVar.d());
            }
            if (!kVar.i().isEmpty() || !kVar.m() || M(aVarK)) {
                arrayList.add(aVarK.h());
            }
        }
        S("Issue capture request");
        this.m.e(arrayList);
    }

    void M0(boolean z) {
        S("Attempting to force open the camera.");
        if (this.t.h(this)) {
            x0(z);
        } else {
            S("No cameras available. Waiting for available camera before opening camera.");
            F0(InternalState.PENDING_OPEN);
        }
    }

    void N(boolean z) {
        b52.j(this.e == InternalState.CLOSING || this.e == InternalState.RELEASING || (this.e == InternalState.REOPENING && this.l != 0), "closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + this.e + " (error: " + Y(this.l) + ")");
        D0(z);
        this.m.a();
    }

    void N0(boolean z) {
        S("Attempting to open the camera.");
        if (this.f147q.b() && this.t.h(this)) {
            x0(z);
        } else {
            S("No cameras available. Waiting for available camera before opening camera.");
            F0(InternalState.PENDING_OPEN);
        }
    }

    void O0() {
        SessionConfig.f fVarE = this.a.e();
        if (!fVarE.d()) {
            this.h.Y();
            this.m.g(this.h.y());
            return;
        }
        this.h.b0(fVarE.b().n());
        fVarE.a(this.h.y());
        this.m.g(fVarE.b());
    }

    void S(String str) {
        T(str, null);
    }

    SessionConfig U(DeferrableSurface deferrableSurface) {
        for (SessionConfig sessionConfig : this.a.h()) {
            if (sessionConfig.m().contains(deferrableSurface)) {
                return sessionConfig;
            }
        }
        return null;
    }

    void V() {
        b52.i(this.e == InternalState.RELEASING || this.e == InternalState.CLOSING);
        b52.i(this.p.isEmpty());
        this.k = null;
        if (this.e == InternalState.CLOSING) {
            F0(InternalState.INITIALIZED);
            return;
        }
        this.b.h(this.f147q);
        F0(InternalState.RELEASED);
        CallbackToFutureAdapter.a aVar = this.o;
        if (aVar != null) {
            aVar.c(null);
            this.o = null;
        }
    }

    boolean b0() {
        try {
            return ((Boolean) CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.camera2.internal.n
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return this.a.l0(aVar);
                }
            }).get()).booleanValue();
        } catch (InterruptedException | ExecutionException e2) {
            throw new RuntimeException("Unable to check if MeteringRepeating is attached.", e2);
        }
    }

    @Override // androidx.camera.core.UseCase.a
    public void c(UseCase useCase) {
        b52.g(useCase);
        final String strA0 = a0(useCase);
        final SessionConfig sessionConfigT = useCase.t();
        final androidx.camera.core.impl.d0 d0VarJ = useCase.j();
        final androidx.camera.core.impl.x xVarE = useCase.e();
        final List listX = X(useCase);
        this.c.execute(new Runnable() { // from class: androidx.camera.camera2.internal.u
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m0(strA0, sessionConfigT, d0VarJ, xVarE, listX);
            }
        });
    }

    boolean c0() {
        return this.p.isEmpty();
    }

    @Override // androidx.camera.core.UseCase.a
    public void d(UseCase useCase) {
        b52.g(useCase);
        E0(a0(useCase), useCase.t(), useCase.j(), useCase.e(), X(useCase));
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void e(androidx.camera.core.impl.g gVar) {
        if (gVar == null) {
            gVar = dt.a();
        }
        gVar.X(null);
        this.H = gVar;
        synchronized (this.I) {
        }
    }

    @Override // androidx.camera.core.UseCase.a
    public void f(UseCase useCase) {
        b52.g(useCase);
        final String strA0 = a0(useCase);
        final SessionConfig sessionConfigT = useCase.t();
        final androidx.camera.core.impl.d0 d0VarJ = useCase.j();
        final androidx.camera.core.impl.x xVarE = useCase.e();
        final List listX = X(useCase);
        this.c.execute(new Runnable() { // from class: androidx.camera.camera2.internal.s
            @Override // java.lang.Runnable
            public final void run() {
                this.a.o0(strA0, sessionConfigT, d0VarJ, xVarE, listX);
            }
        });
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public ut1 g() {
        return this.f;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public CameraControlInternal h() {
        return this.h;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public androidx.camera.core.impl.g i() {
        return this.H;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void j(final boolean z) {
        this.c.execute(new Runnable() { // from class: androidx.camera.camera2.internal.y
            @Override // java.lang.Runnable
            public final void run() {
                this.a.s0(z);
            }
        });
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void k(Collection collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (arrayList.isEmpty()) {
            return;
        }
        this.h.I();
        u0(new ArrayList(arrayList));
        final ArrayList arrayList2 = new ArrayList(J0(arrayList));
        try {
            this.c.execute(new Runnable() { // from class: androidx.camera.camera2.internal.r
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f0(arrayList2);
                }
            });
        } catch (RejectedExecutionException e2) {
            T("Unable to attach use cases.", e2);
            this.h.t();
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void l(Collection collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (arrayList.isEmpty()) {
            return;
        }
        final ArrayList arrayList2 = new ArrayList(J0(arrayList));
        v0(new ArrayList(arrayList));
        this.c.execute(new Runnable() { // from class: androidx.camera.camera2.internal.w
            @Override // java.lang.Runnable
            public final void run() {
                this.a.j0(arrayList2);
            }
        });
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public zt n() {
        return this.j;
    }

    @Override // androidx.camera.core.UseCase.a
    public void o(UseCase useCase) {
        b52.g(useCase);
        final String strA0 = a0(useCase);
        this.c.execute(new Runnable() { // from class: androidx.camera.camera2.internal.t
            @Override // java.lang.Runnable
            public final void run() {
                this.a.n0(strA0);
            }
        });
    }

    public String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", Integer.valueOf(hashCode()), this.j.d());
    }

    void y0() {
        b52.i(this.e == InternalState.OPENED);
        SessionConfig.f fVarG = this.a.g();
        if (!fVarG.d()) {
            S("Unable to create capture session due to conflicting configurations");
            return;
        }
        if (!this.t.i(this.k.getId(), this.s.c(this.k.getId()))) {
            S("Unable to create capture session in camera operating mode = " + this.s.a());
            return;
        }
        HashMap map = new HashMap();
        r2.m(this.a.h(), this.a.i(), map);
        this.m.i(map);
        x1 x1Var = this.m;
        os0.j(x1Var.b(fVarG.b(), (CameraDevice) b52.g(this.k), this.F.a()), new d(x1Var), this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class h {
        private a a;

        /* JADX INFO: Access modifiers changed from: private */
        class a {
            private final ScheduledFuture a;
            private final AtomicBoolean b = new AtomicBoolean(false);

            a() {
                this.a = Camera2CameraImpl.this.d.schedule(new Runnable() { // from class: androidx.camera.camera2.internal.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.d();
                    }
                }, 2000L, TimeUnit.MILLISECONDS);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void d() {
                if (this.b.getAndSet(true)) {
                    return;
                }
                Camera2CameraImpl.this.c.execute(new Runnable() { // from class: androidx.camera.camera2.internal.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.e();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void e() {
                if (Camera2CameraImpl.this.e == InternalState.OPENING) {
                    Camera2CameraImpl.this.S("Camera onError timeout, reopen it.");
                    Camera2CameraImpl.this.F0(InternalState.REOPENING);
                    Camera2CameraImpl.this.i.e();
                } else {
                    Camera2CameraImpl.this.S("Camera skip reopen at state: " + Camera2CameraImpl.this.e);
                }
            }

            public void c() {
                this.b.set(true);
                this.a.cancel(true);
            }

            public boolean f() {
                return this.b.get();
            }
        }

        private h() {
            this.a = null;
        }

        public void a() {
            a aVar = this.a;
            if (aVar != null) {
                aVar.c();
            }
            this.a = null;
        }

        public void b() {
            Camera2CameraImpl.this.S("Camera receive onErrorCallback");
            a();
        }

        public boolean c() {
            a aVar = this.a;
            return (aVar == null || aVar.f()) ? false : true;
        }

        public void d() {
            if (Camera2CameraImpl.this.e != InternalState.OPENING) {
                Camera2CameraImpl.this.S("Don't need the onError timeout handler.");
                return;
            }
            Camera2CameraImpl.this.S("Camera waiting for onError.");
            a();
            this.a = new a();
        }

        /* synthetic */ h(Camera2CameraImpl camera2CameraImpl, a aVar) {
            this();
        }
    }
}
