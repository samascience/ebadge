package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Log;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.ab;
import defpackage.as;
import defpackage.cs;
import defpackage.cs0;
import defpackage.d40;
import defpackage.ea3;
import defpackage.es;
import defpackage.fa3;
import defpackage.ly1;
import defpackage.os0;
import defpackage.sn0;
import defpackage.sr;
import defpackage.ub1;
import defpackage.w92;
import defpackage.wr0;
import defpackage.yq;
import defpackage.yr;
import defpackage.zs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
class j0 {
    private final h a;
    private final fa3 b;
    private final boolean c;
    private final w92 d;
    private final Executor e;
    private final ScheduledExecutorService f;
    private final boolean g;
    private int h = 1;

    static class a implements d {
        private final h a;
        private final ly1 b;
        private final int c;
        private boolean d = false;

        a(h hVar, int i, ly1 ly1Var) {
            this.a = hVar;
            this.c = i;
            this.b = ly1Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object f(CallbackToFutureAdapter.a aVar) {
            this.a.w().x(aVar);
            this.b.b();
            return "AePreCapture";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean g(Void r0) {
            return Boolean.TRUE;
        }

        @Override // androidx.camera.camera2.internal.j0.d
        public ub1 a(TotalCaptureResult totalCaptureResult) {
            if (!j0.d(this.c, totalCaptureResult)) {
                return os0.p(Boolean.FALSE);
            }
            androidx.camera.core.x.a("Camera2CapturePipeline", "Trigger AE");
            this.d = true;
            return cs0.b(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.camera2.internal.h0
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return this.a.f(aVar);
                }
            })).e(new wr0() { // from class: androidx.camera.camera2.internal.i0
                @Override // defpackage.wr0
                public final Object apply(Object obj) {
                    return j0.a.g((Void) obj);
                }
            }, androidx.camera.core.impl.utils.executor.c.b());
        }

        @Override // androidx.camera.camera2.internal.j0.d
        public boolean b() {
            return this.c == 0;
        }

        @Override // androidx.camera.camera2.internal.j0.d
        public void c() {
            if (this.d) {
                androidx.camera.core.x.a("Camera2CapturePipeline", "cancel TriggerAePreCapture");
                this.a.w().h(false, true);
                this.b.a();
            }
        }
    }

    static class b implements d {
        private final h a;
        private boolean b = false;

        b(h hVar) {
            this.a = hVar;
        }

        @Override // androidx.camera.camera2.internal.j0.d
        public ub1 a(TotalCaptureResult totalCaptureResult) {
            Integer num;
            ub1 ub1VarP = os0.p(Boolean.TRUE);
            if (totalCaptureResult == null || (num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE)) == null) {
                return ub1VarP;
            }
            int iIntValue = num.intValue();
            if (iIntValue == 1 || iIntValue == 2) {
                androidx.camera.core.x.a("Camera2CapturePipeline", "TriggerAf? AF mode auto");
                Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num2 != null && num2.intValue() == 0) {
                    androidx.camera.core.x.a("Camera2CapturePipeline", "Trigger AF");
                    this.b = true;
                    this.a.w().F(null, false);
                }
            }
            return ub1VarP;
        }

        @Override // androidx.camera.camera2.internal.j0.d
        public boolean b() {
            return true;
        }

        @Override // androidx.camera.camera2.internal.j0.d
        public void c() {
            if (this.b) {
                androidx.camera.core.x.a("Camera2CapturePipeline", "cancel TriggerAF");
                this.a.w().h(true, false);
            }
        }
    }

    static class c {
        private static final long j;
        private static final long k;
        private final int a;
        private final Executor b;
        private final ScheduledExecutorService c;
        private final h d;
        private final ly1 e;
        private final boolean f;
        private long g = j;
        final List h = new ArrayList();
        private final d i = new a();

        class a implements d {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ Boolean e(List list) {
                return Boolean.valueOf(list.contains(Boolean.TRUE));
            }

            @Override // androidx.camera.camera2.internal.j0.d
            public ub1 a(TotalCaptureResult totalCaptureResult) {
                ArrayList arrayList = new ArrayList();
                Iterator it = c.this.h.iterator();
                while (it.hasNext()) {
                    arrayList.add(((d) it.next()).a(totalCaptureResult));
                }
                return os0.G(os0.k(arrayList), new wr0() { // from class: androidx.camera.camera2.internal.q0
                    @Override // defpackage.wr0
                    public final Object apply(Object obj) {
                        return j0.c.a.e((List) obj);
                    }
                }, androidx.camera.core.impl.utils.executor.c.b());
            }

            @Override // androidx.camera.camera2.internal.j0.d
            public boolean b() {
                Iterator it = c.this.h.iterator();
                while (it.hasNext()) {
                    if (((d) it.next()).b()) {
                        return true;
                    }
                }
                return false;
            }

            @Override // androidx.camera.camera2.internal.j0.d
            public void c() {
                Iterator it = c.this.h.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).c();
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
                this.a.f(new ImageCaptureException(3, "Capture request is cancelled because camera is closed", null));
            }

            @Override // defpackage.as
            public void b(int i, cs csVar) {
                this.a.c(null);
            }

            @Override // defpackage.as
            public void c(int i, CameraCaptureFailure cameraCaptureFailure) {
                this.a.f(new ImageCaptureException(2, "Capture request failed with reason " + cameraCaptureFailure.a(), null));
            }
        }

        static {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            j = timeUnit.toNanos(1L);
            k = timeUnit.toNanos(5L);
        }

        c(int i, Executor executor, ScheduledExecutorService scheduledExecutorService, h hVar, boolean z, ly1 ly1Var) {
            this.a = i;
            this.b = executor;
            this.c = scheduledExecutorService;
            this.d = hVar;
            this.f = z;
            this.e = ly1Var;
        }

        private void g(androidx.camera.core.impl.k.a aVar) {
            yr.a aVar2 = new yr.a();
            aVar2.f(CaptureRequest.CONTROL_AE_MODE, 3);
            aVar.e(aVar2.c());
        }

        private void h(androidx.camera.core.impl.k.a aVar, androidx.camera.core.impl.k kVar) {
            int i;
            if (this.a != 3 || this.f) {
                i = (kVar.k() == -1 || kVar.k() == 5) ? 2 : -1;
            } else {
                i = 4;
            }
            if (i != -1) {
                aVar.v(i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ub1 j(int i, TotalCaptureResult totalCaptureResult) {
            if (j0.d(i, totalCaptureResult)) {
                o(k);
            }
            return this.i.a(totalCaptureResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean k(TotalCaptureResult totalCaptureResult) {
            return j0.c(totalCaptureResult, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ub1 l(Boolean bool) {
            return Boolean.TRUE.equals(bool) ? j0.i(this.g, this.c, this.d, new e.a() { // from class: androidx.camera.camera2.internal.o0
                @Override // androidx.camera.camera2.internal.j0.e.a
                public final boolean a(TotalCaptureResult totalCaptureResult) {
                    return j0.c.k(totalCaptureResult);
                }
            }) : os0.p(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ub1 m(List list, int i, TotalCaptureResult totalCaptureResult) {
            return p(list, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object n(androidx.camera.core.impl.k.a aVar, CallbackToFutureAdapter.a aVar2) {
            aVar.c(new b(aVar2));
            return "submitStillCapture";
        }

        private void o(long j2) {
            this.g = j2;
        }

        void f(d dVar) {
            this.h.add(dVar);
        }

        ub1 i(final List list, final int i) {
            ub1 ub1VarP = os0.p(null);
            if (!this.h.isEmpty()) {
                ub1VarP = cs0.b(this.i.b() ? j0.j(this.d, null) : os0.p(null)).f(new ab() { // from class: androidx.camera.camera2.internal.k0
                    @Override // defpackage.ab
                    public final ub1 apply(Object obj) {
                        return this.a.j(i, (TotalCaptureResult) obj);
                    }
                }, this.b).f(new ab() { // from class: androidx.camera.camera2.internal.l0
                    @Override // defpackage.ab
                    public final ub1 apply(Object obj) {
                        return this.a.l((Boolean) obj);
                    }
                }, this.b);
            }
            cs0 cs0VarF = cs0.b(ub1VarP).f(new ab() { // from class: androidx.camera.camera2.internal.m0
                @Override // defpackage.ab
                public final ub1 apply(Object obj) {
                    return this.a.m(list, i, (TotalCaptureResult) obj);
                }
            }, this.b);
            final d dVar = this.i;
            Objects.requireNonNull(dVar);
            cs0VarF.a(new Runnable() { // from class: androidx.camera.camera2.internal.n0
                @Override // java.lang.Runnable
                public final void run() {
                    dVar.c();
                }
            }, this.b);
            return cs0VarF;
        }

        ub1 p(List list, int i) {
            androidx.camera.core.v vVarF;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                androidx.camera.core.impl.k kVar = (androidx.camera.core.impl.k) it.next();
                final androidx.camera.core.impl.k.a aVarK = androidx.camera.core.impl.k.a.k(kVar);
                cs csVarA = (kVar.k() != 5 || this.d.H().c() || this.d.H().b() || (vVarF = this.d.H().f()) == null || !this.d.H().g(vVarF)) ? null : es.a(vVarF.h0());
                if (csVarA != null) {
                    aVarK.p(csVarA);
                } else {
                    h(aVarK, kVar);
                }
                if (this.e.c(i)) {
                    g(aVarK);
                }
                arrayList.add(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.camera2.internal.p0
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                    public final Object a(CallbackToFutureAdapter.a aVar) {
                        return this.a.n(aVarK, aVar);
                    }
                }));
                arrayList2.add(aVarK.h());
            }
            this.d.d0(arrayList2);
            return os0.k(arrayList);
        }
    }

    interface d {
        ub1 a(TotalCaptureResult totalCaptureResult);

        boolean b();

        void c();
    }

    static class e implements h.c {
        private CallbackToFutureAdapter.a a;
        private final ub1 b = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.camera2.internal.r0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.d(aVar);
            }
        });
        private final a c;

        interface a {
            boolean a(TotalCaptureResult totalCaptureResult);
        }

        e(a aVar) {
            this.c = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object d(CallbackToFutureAdapter.a aVar) {
            this.a = aVar;
            return "waitFor3AResult";
        }

        @Override // androidx.camera.camera2.internal.h.c
        public boolean a(TotalCaptureResult totalCaptureResult) {
            a aVar = this.c;
            if (aVar != null && !aVar.a(totalCaptureResult)) {
                return false;
            }
            this.a.c(totalCaptureResult);
            return true;
        }

        public ub1 c() {
            return this.b;
        }
    }

    static class f implements d {
        private static final long f = TimeUnit.SECONDS.toNanos(2);
        private final h a;
        private final Executor b;
        private final ScheduledExecutorService c;
        private final androidx.camera.core.u.i d;
        private final ea3 e;

        f(h hVar, Executor executor, ScheduledExecutorService scheduledExecutorService, ea3 ea3Var) {
            this.a = hVar;
            this.b = executor;
            this.c = scheduledExecutorService;
            this.e = ea3Var;
            androidx.camera.core.u.i iVarX = hVar.x();
            Objects.requireNonNull(iVarX);
            this.d = iVarX;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ub1 A(ub1 ub1Var, Object obj) {
            return os0.A(TimeUnit.SECONDS.toMillis(3L), this.c, null, true, ub1Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ub1 B(Void r1) {
            return this.a.w().D();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean C(TotalCaptureResult totalCaptureResult) {
            return j0.c(totalCaptureResult, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void r(CallbackToFutureAdapter.a aVar) {
            androidx.camera.core.x.a("Camera2CapturePipeline", "ScreenFlashTask#preCapture: UI change applied");
            aVar.c(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object s(AtomicReference atomicReference, final CallbackToFutureAdapter.a aVar) {
            atomicReference.set(new androidx.camera.core.u.j() { // from class: androidx.camera.camera2.internal.w0
                @Override // androidx.camera.core.u.j
                public final void a() {
                    j0.f.r(aVar);
                }
            });
            return "OnScreenFlashUiApplied";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ub1 t(Void r5) {
            return j0.i(f, this.c, this.a, new e.a() { // from class: androidx.camera.camera2.internal.v0
                @Override // androidx.camera.camera2.internal.j0.e.a
                public final boolean a(TotalCaptureResult totalCaptureResult) {
                    return j0.f.C(totalCaptureResult);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean u(TotalCaptureResult totalCaptureResult) {
            return Boolean.FALSE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(AtomicReference atomicReference, CallbackToFutureAdapter.a aVar) {
            androidx.camera.core.x.a("Camera2CapturePipeline", "ScreenFlashTask#preCapture: invoking applyScreenFlashUi");
            this.d.a(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(3L), (androidx.camera.core.u.j) atomicReference.get());
            aVar.c(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object w(final AtomicReference atomicReference, final CallbackToFutureAdapter.a aVar) {
            androidx.camera.core.impl.utils.executor.c.e().execute(new Runnable() { // from class: androidx.camera.camera2.internal.u0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.v(atomicReference, aVar);
                }
            });
            return "OnScreenFlashStart";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ub1 x(Void r2) {
            return this.a.w().n(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object y(CallbackToFutureAdapter.a aVar) {
            if (!this.e.a()) {
                aVar.c(null);
                return "EnableTorchInternal";
            }
            androidx.camera.core.x.a("Camera2CapturePipeline", "ScreenFlashTask#preCapture: enable torch");
            this.a.u(true);
            aVar.c(null);
            return "EnableTorchInternal";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ub1 z(Void r1) {
            return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.camera2.internal.t0
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return this.a.y(aVar);
                }
            });
        }

        @Override // androidx.camera.camera2.internal.j0.d
        public ub1 a(TotalCaptureResult totalCaptureResult) {
            androidx.camera.core.x.a("Camera2CapturePipeline", "ScreenFlashTask#preCapture");
            final AtomicReference atomicReference = new AtomicReference();
            final ub1 ub1VarA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.camera2.internal.s0
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return j0.f.s(atomicReference, aVar);
                }
            });
            return cs0.b(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.camera2.internal.x0
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return this.a.w(atomicReference, aVar);
                }
            })).f(new ab() { // from class: androidx.camera.camera2.internal.y0
                @Override // defpackage.ab
                public final ub1 apply(Object obj) {
                    return this.a.x((Void) obj);
                }
            }, this.b).f(new ab() { // from class: androidx.camera.camera2.internal.z0
                @Override // defpackage.ab
                public final ub1 apply(Object obj) {
                    return this.a.z((Void) obj);
                }
            }, this.b).f(new ab() { // from class: androidx.camera.camera2.internal.a1
                @Override // defpackage.ab
                public final ub1 apply(Object obj) {
                    return this.a.A(ub1VarA, obj);
                }
            }, this.b).f(new ab() { // from class: androidx.camera.camera2.internal.b1
                @Override // defpackage.ab
                public final ub1 apply(Object obj) {
                    return this.a.B((Void) obj);
                }
            }, this.b).f(new ab() { // from class: androidx.camera.camera2.internal.c1
                @Override // defpackage.ab
                public final ub1 apply(Object obj) {
                    return this.a.t((Void) obj);
                }
            }, this.b).e(new wr0() { // from class: androidx.camera.camera2.internal.d1
                @Override // defpackage.wr0
                public final Object apply(Object obj) {
                    return j0.f.u((TotalCaptureResult) obj);
                }
            }, androidx.camera.core.impl.utils.executor.c.b());
        }

        @Override // androidx.camera.camera2.internal.j0.d
        public boolean b() {
            return false;
        }

        @Override // androidx.camera.camera2.internal.j0.d
        public void c() {
            androidx.camera.core.x.a("Camera2CapturePipeline", "ScreenFlashTask#postCapture");
            if (this.e.a()) {
                this.a.u(false);
            }
            this.a.w().n(false).a(new Runnable() { // from class: androidx.camera.camera2.internal.e1
                @Override // java.lang.Runnable
                public final void run() {
                    Log.d("Camera2CapturePipeline", "enableExternalFlashAeMode disabled");
                }
            }, this.b);
            this.a.w().h(false, true);
            ScheduledExecutorService scheduledExecutorServiceE = androidx.camera.core.impl.utils.executor.c.e();
            final androidx.camera.core.u.i iVar = this.d;
            Objects.requireNonNull(iVar);
            scheduledExecutorServiceE.execute(new Runnable() { // from class: tr
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.clear();
                }
            });
        }
    }

    static class g implements d {
        private static final long f = TimeUnit.SECONDS.toNanos(2);
        private final h a;
        private final int b;
        private boolean c = false;
        private final Executor d;
        private final ScheduledExecutorService e;

        g(h hVar, int i, Executor executor, ScheduledExecutorService scheduledExecutorService) {
            this.a = hVar;
            this.b = i;
            this.d = executor;
            this.e = scheduledExecutorService;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object h(CallbackToFutureAdapter.a aVar) {
            this.a.E().b(aVar, true);
            return "TorchOn";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean i(TotalCaptureResult totalCaptureResult) {
            return j0.c(totalCaptureResult, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ub1 j(Void r5) {
            return j0.i(f, this.e, this.a, new e.a() { // from class: androidx.camera.camera2.internal.i1
                @Override // androidx.camera.camera2.internal.j0.e.a
                public final boolean a(TotalCaptureResult totalCaptureResult) {
                    return j0.g.i(totalCaptureResult);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean k(TotalCaptureResult totalCaptureResult) {
            return Boolean.FALSE;
        }

        @Override // androidx.camera.camera2.internal.j0.d
        public ub1 a(TotalCaptureResult totalCaptureResult) {
            if (j0.d(this.b, totalCaptureResult)) {
                if (!this.a.M()) {
                    androidx.camera.core.x.a("Camera2CapturePipeline", "Turn on torch");
                    this.c = true;
                    return cs0.b(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.camera2.internal.f1
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                        public final Object a(CallbackToFutureAdapter.a aVar) {
                            return this.a.h(aVar);
                        }
                    })).f(new ab() { // from class: androidx.camera.camera2.internal.g1
                        @Override // defpackage.ab
                        public final ub1 apply(Object obj) {
                            return this.a.j((Void) obj);
                        }
                    }, this.d).e(new wr0() { // from class: androidx.camera.camera2.internal.h1
                        @Override // defpackage.wr0
                        public final Object apply(Object obj) {
                            return j0.g.k((TotalCaptureResult) obj);
                        }
                    }, androidx.camera.core.impl.utils.executor.c.b());
                }
                androidx.camera.core.x.a("Camera2CapturePipeline", "Torch already on, not turn on");
            }
            return os0.p(Boolean.FALSE);
        }

        @Override // androidx.camera.camera2.internal.j0.d
        public boolean b() {
            return this.b == 0;
        }

        @Override // androidx.camera.camera2.internal.j0.d
        public void c() {
            if (this.c) {
                this.a.E().b(null, false);
                androidx.camera.core.x.a("Camera2CapturePipeline", "Turn off torch");
            }
        }
    }

    j0(h hVar, zs zsVar, w92 w92Var, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.a = hVar;
        Integer num = (Integer) zsVar.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        this.g = num != null && num.intValue() == 2;
        this.e = executor;
        this.f = scheduledExecutorService;
        this.d = w92Var;
        this.b = new fa3(w92Var);
        this.c = sn0.a(new sr(zsVar));
    }

    static boolean c(TotalCaptureResult totalCaptureResult, boolean z) {
        if (totalCaptureResult == null) {
            return false;
        }
        return d40.a(new yq(totalCaptureResult), z);
    }

    static boolean d(int i, TotalCaptureResult totalCaptureResult) {
        if (i == 0) {
            Integer num = totalCaptureResult != null ? (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE) : null;
            return num != null && num.intValue() == 4;
        }
        if (i != 1) {
            if (i == 2) {
                return false;
            }
            if (i != 3) {
                throw new AssertionError(i);
            }
        }
        return true;
    }

    private boolean e(int i) {
        return this.b.a() || this.h == 3 || i == 1;
    }

    static ub1 i(long j, ScheduledExecutorService scheduledExecutorService, h hVar, e.a aVar) {
        return os0.A(TimeUnit.NANOSECONDS.toMillis(j), scheduledExecutorService, null, true, j(hVar, aVar));
    }

    static ub1 j(final h hVar, e.a aVar) {
        final e eVar = new e(aVar);
        hVar.r(eVar);
        ub1 ub1VarC = eVar.c();
        ub1VarC.a(new Runnable() { // from class: androidx.camera.camera2.internal.g0
            @Override // java.lang.Runnable
            public final void run() {
                hVar.W(eVar);
            }
        }, hVar.c);
        return ub1VarC;
    }

    c b(int i, int i2, int i3) {
        ly1 ly1Var = new ly1(this.d);
        c cVar = new c(this.h, this.e, this.f, this.a, this.g, ly1Var);
        if (i == 0) {
            cVar.f(new b(this.a));
        }
        if (i2 == 3) {
            cVar.f(new f(this.a, this.e, this.f, new ea3(this.d)));
        } else if (this.c) {
            if (e(i3)) {
                cVar.f(new g(this.a, i2, this.e, this.f));
            } else {
                cVar.f(new a(this.a, i2, ly1Var));
            }
        }
        return cVar;
    }

    public void g(int i) {
        this.h = i;
    }

    public ub1 h(List list, int i, int i2, int i3) {
        return os0.B(b(i, i2, i3).i(list, i2));
    }
}
