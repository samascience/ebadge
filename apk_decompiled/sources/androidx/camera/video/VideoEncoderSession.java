package androidx.camera.video;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.bs0;
import defpackage.ie0;
import defpackage.ig0;
import defpackage.os0;
import defpackage.q20;
import defpackage.ub1;
import defpackage.vd3;
import defpackage.yb3;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class VideoEncoderSession {
    private final Executor a;
    private final Executor b;
    private final ig0 c;
    private androidx.camera.video.internal.encoder.c d = null;
    private Surface e = null;
    private SurfaceRequest f = null;
    private Executor g = null;
    private androidx.camera.video.internal.encoder.c.InterfaceC0011c.a h = null;
    private VideoEncoderState i = VideoEncoderState.NOT_INITIALIZED;
    private ub1 j = os0.n(new IllegalStateException("Cannot close the encoder before configuring."));
    private CallbackToFutureAdapter.a k = null;
    private ub1 l = os0.n(new IllegalStateException("Cannot close the encoder before configuring."));
    private CallbackToFutureAdapter.a m = null;

    private enum VideoEncoderState {
        NOT_INITIALIZED,
        INITIALIZING,
        PENDING_RELEASE,
        READY,
        RELEASED
    }

    class a implements bs0 {
        a() {
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            androidx.camera.core.x.l("VideoEncoderSession", "VideoEncoder configuration failed.", th);
            VideoEncoderSession.this.x();
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(androidx.camera.video.internal.encoder.c cVar) {
        }
    }

    VideoEncoderSession(ig0 ig0Var, Executor executor, Executor executor2) {
        this.a = executor2;
        this.b = executor;
        this.c = ig0Var;
    }

    private void h() {
        int iOrdinal = this.i.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            x();
            return;
        }
        if (iOrdinal == 2 || iOrdinal == 3) {
            androidx.camera.core.x.a("VideoEncoderSession", "closeInternal in " + this.i + " state");
            this.i = VideoEncoderState.PENDING_RELEASE;
            return;
        }
        if (iOrdinal == 4) {
            androidx.camera.core.x.a("VideoEncoderSession", "closeInternal in RELEASED state, No-op");
            return;
        }
        throw new IllegalStateException("State " + this.i + " is not handled");
    }

    private void j(final SurfaceRequest surfaceRequest, Timebase timebase, vd3 vd3Var, p pVar, final CallbackToFutureAdapter.a aVar) {
        ie0 ie0VarM = surfaceRequest.m();
        try {
            androidx.camera.video.internal.encoder.c cVarA = this.c.a(this.a, yb3.c(yb3.d(pVar, ie0VarM, vd3Var), timebase, pVar.d(), surfaceRequest.o(), ie0VarM, surfaceRequest.n()));
            this.d = cVarA;
            androidx.camera.video.internal.encoder.c.b bVarB = cVarA.b();
            if (bVarB instanceof androidx.camera.video.internal.encoder.c.InterfaceC0011c) {
                ((androidx.camera.video.internal.encoder.c.InterfaceC0011c) bVarB).b(this.b, new androidx.camera.video.internal.encoder.c.InterfaceC0011c.a() { // from class: androidx.camera.video.t0
                    @Override // androidx.camera.video.internal.encoder.c.InterfaceC0011c.a
                    public final void a(Surface surface) {
                        this.a.s(aVar, surfaceRequest, surface);
                    }
                });
            } else {
                aVar.f(new AssertionError("The EncoderInput of video isn't a SurfaceInput."));
            }
        } catch (InvalidConfigException e) {
            androidx.camera.core.x.d("VideoEncoderSession", "Unable to initialize video encoder.", e);
            aVar.f(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o(CallbackToFutureAdapter.a aVar) {
        this.k = aVar;
        return "ReleasedFuture " + this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p(CallbackToFutureAdapter.a aVar) {
        this.m = aVar;
        return "ReadyToReleaseFuture " + this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q(SurfaceRequest surfaceRequest, Timebase timebase, vd3 vd3Var, p pVar, CallbackToFutureAdapter.a aVar) {
        j(surfaceRequest, timebase, vd3Var, pVar, aVar);
        return "ConfigureVideoEncoderFuture " + this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(Surface surface) {
        this.h.a(surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(CallbackToFutureAdapter.a aVar, SurfaceRequest surfaceRequest, final Surface surface) {
        Executor executor;
        int iOrdinal = this.i.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                if (surfaceRequest.r()) {
                    androidx.camera.core.x.a("VideoEncoderSession", "Not provide surface, " + Objects.toString(surfaceRequest, "EMPTY") + " is already serviced.");
                    aVar.c(null);
                    h();
                    return;
                }
                this.e = surface;
                androidx.camera.core.x.a("VideoEncoderSession", "provide surface: " + surface);
                surfaceRequest.B(surface, this.b, new q20() { // from class: androidx.camera.video.u0
                    @Override // defpackage.q20
                    public final void accept(Object obj) {
                        this.a.u((SurfaceRequest.f) obj);
                    }
                });
                this.i = VideoEncoderState.READY;
                aVar.c(this.d);
                return;
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    if (this.h != null && (executor = this.g) != null) {
                        executor.execute(new Runnable() { // from class: androidx.camera.video.v0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.r(surface);
                            }
                        });
                    }
                    androidx.camera.core.x.k("VideoEncoderSession", "Surface is updated in READY state: " + surface);
                    return;
                }
                if (iOrdinal != 4) {
                    throw new IllegalStateException("State " + this.i + " is not handled");
                }
            }
        }
        androidx.camera.core.x.a("VideoEncoderSession", "Not provide surface in " + this.i);
        aVar.c(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        this.k.c(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(SurfaceRequest.f fVar) {
        androidx.camera.core.x.a("VideoEncoderSession", "Surface can be closed: " + fVar.b().hashCode());
        Surface surfaceB = fVar.b();
        if (surfaceB != this.e) {
            surfaceB.release();
            return;
        }
        this.e = null;
        this.m.c(this.d);
        h();
    }

    ub1 i(final SurfaceRequest surfaceRequest, final Timebase timebase, final p pVar, final vd3 vd3Var) {
        if (this.i.ordinal() != 0) {
            return os0.n(new IllegalStateException("configure() shouldn't be called in " + this.i));
        }
        this.i = VideoEncoderState.INITIALIZING;
        this.f = surfaceRequest;
        androidx.camera.core.x.a("VideoEncoderSession", "Create VideoEncoderSession: " + this);
        this.j = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.video.q0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.o(aVar);
            }
        });
        this.l = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.video.r0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.p(aVar);
            }
        });
        ub1 ub1VarA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.video.s0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.q(surfaceRequest, timebase, vd3Var, pVar, aVar);
            }
        });
        os0.j(ub1VarA, new a(), this.b);
        return os0.B(ub1VarA);
    }

    Surface k() {
        if (this.i != VideoEncoderState.READY) {
            return null;
        }
        return this.e;
    }

    ub1 l() {
        return os0.B(this.l);
    }

    androidx.camera.video.internal.encoder.c m() {
        return this.d;
    }

    boolean n(SurfaceRequest surfaceRequest) {
        int iOrdinal = this.i.ordinal();
        if (iOrdinal == 0) {
            return false;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return false;
            }
            if (iOrdinal != 3) {
                if (iOrdinal == 4) {
                    return false;
                }
                throw new IllegalStateException("State " + this.i + " is not handled");
            }
        }
        return this.f == surfaceRequest;
    }

    public String toString() {
        return "VideoEncoderSession@" + hashCode() + " for " + Objects.toString(this.f, "SURFACE_REQUEST_NOT_CONFIGURED");
    }

    void v(Executor executor, androidx.camera.video.internal.encoder.c.InterfaceC0011c.a aVar) {
        this.g = executor;
        this.h = aVar;
    }

    ub1 w() {
        h();
        return os0.B(this.j);
    }

    void x() {
        int iOrdinal = this.i.ordinal();
        if (iOrdinal == 0) {
            this.i = VideoEncoderState.RELEASED;
            return;
        }
        if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new IllegalStateException("State " + this.i + " is not handled");
            }
            androidx.camera.core.x.a("VideoEncoderSession", "terminateNow in " + this.i + ", No-op");
            return;
        }
        this.i = VideoEncoderState.RELEASED;
        this.m.c(this.d);
        this.f = null;
        if (this.d == null) {
            androidx.camera.core.x.k("VideoEncoderSession", "There's no VideoEncoder to release! Finish release completer.");
            this.k.c(null);
            return;
        }
        androidx.camera.core.x.a("VideoEncoderSession", "VideoEncoder is releasing: " + this.d);
        this.d.release();
        this.d.d().a(new Runnable() { // from class: androidx.camera.video.p0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.t();
            }
        }, this.b);
        this.d = null;
    }
}
