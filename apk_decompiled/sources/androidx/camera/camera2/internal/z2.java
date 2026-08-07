package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.ab;
import defpackage.b52;
import defpackage.bs0;
import defpackage.cs0;
import defpackage.fs;
import defpackage.ht;
import defpackage.jn2;
import defpackage.os0;
import defpackage.ub1;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
abstract class z2 extends t2.c implements t2, t2.a {
    final a2 b;
    final Handler c;
    final Executor d;
    private final ScheduledExecutorService e;
    t2.c f;
    fs g;
    ub1 h;
    CallbackToFutureAdapter.a i;
    private ub1 j;
    final Object a = new Object();
    private List k = null;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;

    class a implements bs0 {
        a() {
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            z2.this.a();
            z2 z2Var = z2.this;
            z2Var.b.i(z2Var);
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r1) {
        }
    }

    class b extends CameraCaptureSession.StateCallback {
        b() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onActive(CameraCaptureSession cameraCaptureSession) {
            z2.this.B(cameraCaptureSession);
            z2 z2Var = z2.this;
            z2Var.o(z2Var);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onCaptureQueueEmpty(CameraCaptureSession cameraCaptureSession) {
            z2.this.B(cameraCaptureSession);
            z2 z2Var = z2.this;
            z2Var.p(z2Var);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(CameraCaptureSession cameraCaptureSession) {
            z2.this.B(cameraCaptureSession);
            z2 z2Var = z2.this;
            z2Var.q(z2Var);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            CallbackToFutureAdapter.a aVar;
            try {
                z2.this.B(cameraCaptureSession);
                z2 z2Var = z2.this;
                z2Var.r(z2Var);
                synchronized (z2.this.a) {
                    b52.h(z2.this.i, "OpenCaptureSession completer should not null");
                    z2 z2Var2 = z2.this;
                    aVar = z2Var2.i;
                    z2Var2.i = null;
                }
            } finally {
                synchronized (z2.this.a) {
                    b52.h(z2.this.i, "OpenCaptureSession completer should not null");
                    z2 z2Var3 = z2.this;
                    aVar = z2Var3.i;
                    z2Var3.i = null;
                    aVar.f(new IllegalStateException("onConfigureFailed"));
                }
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            CallbackToFutureAdapter.a aVar;
            try {
                z2.this.B(cameraCaptureSession);
                z2 z2Var = z2.this;
                z2Var.s(z2Var);
                synchronized (z2.this.a) {
                    b52.h(z2.this.i, "OpenCaptureSession completer should not null");
                    z2 z2Var2 = z2.this;
                    aVar = z2Var2.i;
                    z2Var2.i = null;
                }
            } finally {
                synchronized (z2.this.a) {
                    b52.h(z2.this.i, "OpenCaptureSession completer should not null");
                    z2 z2Var3 = z2.this;
                    aVar = z2Var3.i;
                    z2Var3.i = null;
                    aVar.c(null);
                }
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(CameraCaptureSession cameraCaptureSession) {
            z2.this.B(cameraCaptureSession);
            z2 z2Var = z2.this;
            z2Var.t(z2Var);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onSurfacePrepared(CameraCaptureSession cameraCaptureSession, Surface surface) {
            z2.this.B(cameraCaptureSession);
            z2 z2Var = z2.this;
            z2Var.v(z2Var, surface);
        }
    }

    z2(a2 a2Var, Executor executor, ScheduledExecutorService scheduledExecutorService, Handler handler) {
        this.b = a2Var;
        this.c = handler;
        this.d = executor;
        this.e = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        u(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(t2 t2Var) {
        this.b.g(this);
        u(t2Var);
        if (this.g != null) {
            Objects.requireNonNull(this.f);
            this.f.q(t2Var);
            return;
        }
        androidx.camera.core.x.k("SyncCaptureSessionBase", "[" + this + "] Cannot call onClosed() when the CameraCaptureSession is not correctly configured.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(t2 t2Var) {
        Objects.requireNonNull(this.f);
        this.f.u(t2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object H(List list, ht htVar, jn2 jn2Var, CallbackToFutureAdapter.a aVar) {
        String str;
        synchronized (this.a) {
            C(list);
            b52.j(this.i == null, "The openCaptureSessionCompleter can only set once!");
            this.i = aVar;
            htVar.a(jn2Var);
            str = "openCaptureSession[session=" + this + "]";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ub1 I(List list, List list2) {
        androidx.camera.core.x.a("SyncCaptureSessionBase", "[" + this + "] getSurface done with results: " + list2);
        if (list2.isEmpty()) {
            return os0.n(new IllegalArgumentException("Unable to open capture session without surfaces"));
        }
        return list2.contains(null) ? os0.n(new DeferrableSurface.SurfaceClosedException("Surface closed", (DeferrableSurface) list.get(list2.indexOf(null)))) : os0.p(list2);
    }

    void B(CameraCaptureSession cameraCaptureSession) {
        if (this.g == null) {
            this.g = fs.d(cameraCaptureSession, this.c);
        }
    }

    void C(List list) {
        synchronized (this.a) {
            J();
            androidx.camera.core.impl.m.d(list);
            this.k = list;
        }
    }

    boolean D() {
        boolean z;
        synchronized (this.a) {
            z = this.h != null;
        }
        return z;
    }

    void J() {
        synchronized (this.a) {
            try {
                List list = this.k;
                if (list != null) {
                    androidx.camera.core.impl.m.c(list);
                    this.k = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a() {
        J();
    }

    @Override // androidx.camera.camera2.internal.t2.a
    public Executor b() {
        return this.d;
    }

    @Override // androidx.camera.camera2.internal.t2
    public t2.c c() {
        return this;
    }

    public void close() {
        b52.h(this.g, "Need to call openCaptureSession before using this API.");
        this.b.h(this);
        this.g.c().close();
        b().execute(new Runnable() { // from class: androidx.camera.camera2.internal.x2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.E();
            }
        });
    }

    public int d(List list, CameraCaptureSession.CaptureCallback captureCallback) {
        b52.h(this.g, "Need to call openCaptureSession before using this API.");
        return this.g.a(list, b(), captureCallback);
    }

    @Override // androidx.camera.camera2.internal.t2
    public fs e() {
        b52.g(this.g);
        return this.g;
    }

    public void f(int i) {
    }

    @Override // androidx.camera.camera2.internal.t2
    public void g() {
        b52.h(this.g, "Need to call openCaptureSession before using this API.");
        this.g.c().abortCaptures();
    }

    @Override // androidx.camera.camera2.internal.t2
    public CameraDevice h() {
        b52.g(this.g);
        return this.g.c().getDevice();
    }

    public int i(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) {
        b52.h(this.g, "Need to call openCaptureSession before using this API.");
        return this.g.b(captureRequest, b(), captureCallback);
    }

    public ub1 j(CameraDevice cameraDevice, final jn2 jn2Var, final List list) {
        synchronized (this.a) {
            try {
                if (this.m) {
                    return os0.n(new CancellationException("Opener is disabled"));
                }
                this.b.k(this);
                final ht htVarB = ht.b(cameraDevice, this.c);
                ub1 ub1VarA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.camera2.internal.y2
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                    public final Object a(CallbackToFutureAdapter.a aVar) {
                        return this.a.H(list, htVarB, jn2Var, aVar);
                    }
                });
                this.h = ub1VarA;
                os0.j(ub1VarA, new a(), androidx.camera.core.impl.utils.executor.c.b());
                return os0.B(this.h);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.camera2.internal.t2.a
    public jn2 k(int i, List list, t2.c cVar) {
        this.f = cVar;
        return new jn2(i, list, b(), new b());
    }

    @Override // androidx.camera.camera2.internal.t2
    public void l() throws CameraAccessException {
        b52.h(this.g, "Need to call openCaptureSession before using this API.");
        this.g.c().stopRepeating();
    }

    public ub1 m(final List list, long j) {
        synchronized (this.a) {
            try {
                if (this.m) {
                    return os0.n(new CancellationException("Opener is disabled"));
                }
                cs0 cs0VarF = cs0.b(androidx.camera.core.impl.m.g(list, false, j, b(), this.e)).f(new ab() { // from class: androidx.camera.camera2.internal.v2
                    @Override // defpackage.ab
                    public final ub1 apply(Object obj) {
                        return this.a.I(list, (List) obj);
                    }
                }, b());
                this.j = cs0VarF;
                return os0.B(cs0VarF);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.camera2.internal.t2.c
    public void o(t2 t2Var) {
        Objects.requireNonNull(this.f);
        this.f.o(t2Var);
    }

    @Override // androidx.camera.camera2.internal.t2.c
    public void p(t2 t2Var) {
        Objects.requireNonNull(this.f);
        this.f.p(t2Var);
    }

    @Override // androidx.camera.camera2.internal.t2.c
    public void q(final t2 t2Var) {
        ub1 ub1Var;
        synchronized (this.a) {
            try {
                if (this.l) {
                    ub1Var = null;
                } else {
                    this.l = true;
                    b52.h(this.h, "Need to call openCaptureSession before using this API.");
                    ub1Var = this.h;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        a();
        if (ub1Var != null) {
            ub1Var.a(new Runnable() { // from class: androidx.camera.camera2.internal.u2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.F(t2Var);
                }
            }, androidx.camera.core.impl.utils.executor.c.b());
        }
    }

    @Override // androidx.camera.camera2.internal.t2.c
    public void r(t2 t2Var) {
        Objects.requireNonNull(this.f);
        a();
        this.b.i(this);
        this.f.r(t2Var);
    }

    @Override // androidx.camera.camera2.internal.t2.c
    public void s(t2 t2Var) {
        Objects.requireNonNull(this.f);
        this.b.j(this);
        this.f.s(t2Var);
    }

    public boolean stop() {
        boolean z;
        ub1 ub1Var = null;
        try {
            synchronized (this.a) {
                try {
                    if (!this.m) {
                        ub1 ub1Var2 = this.j;
                        ub1Var = ub1Var2 != null ? ub1Var2 : null;
                        this.m = true;
                    }
                    z = !D();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (ub1Var != null) {
                ub1Var.cancel(true);
            }
            return z;
        } catch (Throwable th2) {
            if (ub1Var != null) {
                ub1Var.cancel(true);
            }
            throw th2;
        }
    }

    @Override // androidx.camera.camera2.internal.t2.c
    public void t(t2 t2Var) {
        Objects.requireNonNull(this.f);
        this.f.t(t2Var);
    }

    @Override // androidx.camera.camera2.internal.t2.c
    void u(final t2 t2Var) {
        ub1 ub1Var;
        synchronized (this.a) {
            try {
                if (this.n) {
                    ub1Var = null;
                } else {
                    this.n = true;
                    b52.h(this.h, "Need to call openCaptureSession before using this API.");
                    ub1Var = this.h;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (ub1Var != null) {
            ub1Var.a(new Runnable() { // from class: androidx.camera.camera2.internal.w2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.G(t2Var);
                }
            }, androidx.camera.core.impl.utils.executor.c.b());
        }
    }

    @Override // androidx.camera.camera2.internal.t2.c
    public void v(t2 t2Var, Surface surface) {
        Objects.requireNonNull(this.f);
        this.f.v(t2Var, surface);
    }
}
