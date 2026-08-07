package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import android.util.Log;
import android.util.Rational;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.Config;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.as;
import defpackage.cs;
import defpackage.os0;
import defpackage.ub1;
import defpackage.vj1;
import defpackage.w92;
import defpackage.yr;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes.dex */
class m2 {
    private static final MeteringRectangle[] x = new MeteringRectangle[0];
    private final h a;
    final Executor b;
    private final ScheduledExecutorService c;
    private final vj1 f;
    private ScheduledFuture i;
    private ScheduledFuture j;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MeteringRectangle[] f151q;
    private MeteringRectangle[] r;
    private MeteringRectangle[] s;
    CallbackToFutureAdapter.a t;
    CallbackToFutureAdapter.a u;
    private boolean v;
    private h.c w;
    private volatile boolean d = false;
    private volatile Rational e = null;
    private boolean g = false;
    Integer h = 0;
    long k = 0;
    boolean l = false;
    boolean m = false;
    private int n = 1;
    private h.c o = null;
    private h.c p = null;

    class a extends as {
        final /* synthetic */ CallbackToFutureAdapter.a a;

        a(CallbackToFutureAdapter.a aVar) {
            this.a = aVar;
        }

        @Override // defpackage.as
        public void a(int i) {
            CallbackToFutureAdapter.a aVar = this.a;
            if (aVar != null) {
                aVar.f(new CameraControl$OperationCanceledException("Camera is closed"));
            }
        }

        @Override // defpackage.as
        public void b(int i, cs csVar) {
            CallbackToFutureAdapter.a aVar = this.a;
            if (aVar != null) {
                aVar.c(csVar);
            }
        }

        @Override // defpackage.as
        public void c(int i, CameraCaptureFailure cameraCaptureFailure) {
            CallbackToFutureAdapter.a aVar = this.a;
            if (aVar != null) {
                aVar.f(new CameraControlInternal.CameraControlException(cameraCaptureFailure));
            }
        }
    }

    class b extends as {
        final /* synthetic */ CallbackToFutureAdapter.a a;

        b(CallbackToFutureAdapter.a aVar) {
            this.a = aVar;
        }

        @Override // defpackage.as
        public void a(int i) {
            CallbackToFutureAdapter.a aVar = this.a;
            if (aVar != null) {
                aVar.f(new CameraControl$OperationCanceledException("Camera is closed"));
            }
        }

        @Override // defpackage.as
        public void b(int i, cs csVar) {
            if (this.a != null) {
                androidx.camera.core.x.a("FocusMeteringControl", "triggerAePrecapture: triggering capture request completed");
                this.a.c(null);
            }
        }

        @Override // defpackage.as
        public void c(int i, CameraCaptureFailure cameraCaptureFailure) {
            CallbackToFutureAdapter.a aVar = this.a;
            if (aVar != null) {
                aVar.f(new CameraControlInternal.CameraControlException(cameraCaptureFailure));
            }
        }
    }

    m2(h hVar, ScheduledExecutorService scheduledExecutorService, Executor executor, w92 w92Var) {
        MeteringRectangle[] meteringRectangleArr = x;
        this.f151q = meteringRectangleArr;
        this.r = meteringRectangleArr;
        this.s = meteringRectangleArr;
        this.t = null;
        this.u = null;
        this.v = false;
        this.w = null;
        this.a = hVar;
        this.b = executor;
        this.c = scheduledExecutorService;
        this.f = new vj1(w92Var);
    }

    private boolean C() {
        return this.f151q.length > 0;
    }

    private void k() {
        ScheduledFuture scheduledFuture = this.j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.j = null;
        }
    }

    private void l() {
        CallbackToFutureAdapter.a aVar = this.u;
        if (aVar != null) {
            aVar.c(null);
            this.u = null;
        }
    }

    private void m() {
        ScheduledFuture scheduledFuture = this.i;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.i = null;
        }
    }

    private void o(final CallbackToFutureAdapter.a aVar) {
        if (!this.d) {
            if (aVar != null) {
                aVar.f(new CameraControl$OperationCanceledException("Camera is not active."));
            }
        } else {
            final long jF0 = this.a.f0();
            h.c cVar = new h.c() { // from class: androidx.camera.camera2.internal.i2
                @Override // androidx.camera.camera2.internal.h.c
                public final boolean a(TotalCaptureResult totalCaptureResult) {
                    return this.a.w(jF0, aVar, totalCaptureResult);
                }
            };
            this.w = cVar;
            this.a.r(cVar);
        }
    }

    private void p(String str) {
        this.a.W(this.o);
        CallbackToFutureAdapter.a aVar = this.t;
        if (aVar != null) {
            aVar.f(new CameraControl$OperationCanceledException(str));
            this.t = null;
        }
    }

    private void q(String str) {
        this.a.W(this.p);
        CallbackToFutureAdapter.a aVar = this.u;
        if (aVar != null) {
            aVar.f(new CameraControl$OperationCanceledException(str));
            this.u = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean t(int i, long j, TotalCaptureResult totalCaptureResult) {
        if (((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE)).intValue() != i || !h.L(totalCaptureResult, j)) {
            return false;
        }
        l();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(boolean z, CallbackToFutureAdapter.a aVar) {
        this.a.W(this.w);
        this.v = z;
        o(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object v(final boolean z, final CallbackToFutureAdapter.a aVar) {
        this.b.execute(new Runnable() { // from class: androidx.camera.camera2.internal.h2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.u(z, aVar);
            }
        });
        return "enableExternalFlashAeMode";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean w(long j, CallbackToFutureAdapter.a aVar, TotalCaptureResult totalCaptureResult) {
        boolean z = ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_MODE)).intValue() == 5;
        androidx.camera.core.x.a("FocusMeteringControl", "enableExternalFlashAeMode: isAeModeExternalFlash = " + z);
        if (z != this.v || !h.L(totalCaptureResult, j)) {
            return false;
        }
        androidx.camera.core.x.a("FocusMeteringControl", "enableExternalFlashAeMode: session updated with isAeModeExternalFlash = " + z);
        if (aVar != null) {
            aVar.c(null);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object y(final CallbackToFutureAdapter.a aVar) {
        this.b.execute(new Runnable() { // from class: androidx.camera.camera2.internal.g2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x(aVar);
            }
        });
        return "triggerAePrecapture";
    }

    public void A(Rational rational) {
        this.e = rational;
    }

    void B(int i) {
        this.n = i;
    }

    ub1 D() {
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.camera2.internal.k2
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.y(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public void x(CallbackToFutureAdapter.a aVar) {
        if (!this.d) {
            if (aVar != null) {
                aVar.f(new CameraControl$OperationCanceledException("Camera is not active."));
                return;
            }
            return;
        }
        androidx.camera.core.impl.k.a aVar2 = new androidx.camera.core.impl.k.a();
        aVar2.v(this.n);
        aVar2.w(true);
        yr.a aVar3 = new yr.a();
        aVar3.f(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        aVar2.e(aVar3.c());
        aVar2.c(new b(aVar));
        this.a.d0(Collections.singletonList(aVar2.h()));
    }

    void F(CallbackToFutureAdapter.a aVar, boolean z) {
        if (!this.d) {
            if (aVar != null) {
                aVar.f(new CameraControl$OperationCanceledException("Camera is not active."));
                return;
            }
            return;
        }
        androidx.camera.core.impl.k.a aVar2 = new androidx.camera.core.impl.k.a();
        aVar2.v(this.n);
        aVar2.w(true);
        yr.a aVar3 = new yr.a();
        aVar3.f(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        if (z) {
            aVar3.g(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(this.a.A(1)), Config.OptionPriority.HIGH_PRIORITY_REQUIRED);
        }
        aVar2.e(aVar3.c());
        aVar2.c(new a(aVar));
        this.a.d0(Collections.singletonList(aVar2.h()));
    }

    void g(yr.a aVar) {
        int iR = this.g ? 1 : r();
        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_MODE;
        Object objValueOf = Integer.valueOf(this.a.C(iR));
        Config.OptionPriority optionPriority = Config.OptionPriority.REQUIRED;
        aVar.g(key, objValueOf, optionPriority);
        MeteringRectangle[] meteringRectangleArr = this.f151q;
        if (meteringRectangleArr.length != 0) {
            aVar.g(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr, optionPriority);
        }
        MeteringRectangle[] meteringRectangleArr2 = this.r;
        if (meteringRectangleArr2.length != 0) {
            aVar.g(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr2, optionPriority);
        }
        MeteringRectangle[] meteringRectangleArr3 = this.s;
        if (meteringRectangleArr3.length != 0) {
            aVar.g(CaptureRequest.CONTROL_AWB_REGIONS, meteringRectangleArr3, optionPriority);
        }
    }

    void h(boolean z, boolean z2) {
        if (this.d) {
            androidx.camera.core.impl.k.a aVar = new androidx.camera.core.impl.k.a();
            aVar.w(true);
            aVar.v(this.n);
            yr.a aVar2 = new yr.a();
            if (z) {
                aVar2.f(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            }
            if (z2) {
                aVar2.f(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
            }
            aVar.e(aVar2.c());
            this.a.d0(Collections.singletonList(aVar.h()));
        }
    }

    void i(CallbackToFutureAdapter.a aVar) {
        q("Cancelled by another cancelFocusAndMetering()");
        p("Cancelled by cancelFocusAndMetering()");
        this.u = aVar;
        m();
        k();
        if (C()) {
            h(true, false);
        }
        MeteringRectangle[] meteringRectangleArr = x;
        this.f151q = meteringRectangleArr;
        this.r = meteringRectangleArr;
        this.s = meteringRectangleArr;
        this.g = false;
        final long jF0 = this.a.f0();
        if (this.u != null) {
            final int iC = this.a.C(r());
            h.c cVar = new h.c() { // from class: androidx.camera.camera2.internal.j2
                @Override // androidx.camera.camera2.internal.h.c
                public final boolean a(TotalCaptureResult totalCaptureResult) {
                    return this.a.t(iC, jF0, totalCaptureResult);
                }
            };
            this.p = cVar;
            this.a.r(cVar);
        }
    }

    void j() {
        i(null);
    }

    ub1 n(final boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            Log.d("FocusMeteringControl", "CONTROL_AE_MODE_ON_EXTERNAL_FLASH is not supported in API " + i);
            return os0.p(null);
        }
        if (this.a.A(5) != 5) {
            Log.d("FocusMeteringControl", "CONTROL_AE_MODE_ON_EXTERNAL_FLASH is not supported in this device");
            return os0.p(null);
        }
        Log.d("FocusMeteringControl", "enableExternalFlashAeMode: CONTROL_AE_MODE_ON_EXTERNAL_FLASH supported");
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.camera2.internal.l2
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.v(z, aVar);
            }
        });
    }

    int r() {
        return this.n != 3 ? 4 : 3;
    }

    boolean s() {
        return this.v;
    }

    void z(boolean z) {
        if (z == this.d) {
            return;
        }
        this.d = z;
        if (this.d) {
            return;
        }
        j();
    }
}
