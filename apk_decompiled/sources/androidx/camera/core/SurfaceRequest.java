package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.b52;
import defpackage.bs0;
import defpackage.ie0;
import defpackage.os0;
import defpackage.q20;
import defpackage.ub1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class SurfaceRequest {
    public static final Range o = androidx.camera.core.impl.x.a;
    private final Object a = new Object();
    private final Size b;
    private final ie0 c;
    private final Range d;
    private final CameraInternal e;
    final ub1 f;
    private final CallbackToFutureAdapter.a g;
    private final ub1 h;
    private final CallbackToFutureAdapter.a i;
    private final CallbackToFutureAdapter.a j;
    private final DeferrableSurface k;
    private g l;
    private h m;
    private Executor n;

    private static final class RequestCancelledException extends RuntimeException {
        RequestCancelledException(String str, Throwable th) {
            super(str, th);
        }
    }

    class a implements bs0 {
        final /* synthetic */ CallbackToFutureAdapter.a a;
        final /* synthetic */ ub1 b;

        a(CallbackToFutureAdapter.a aVar, ub1 ub1Var) {
            this.a = aVar;
            this.b = ub1Var;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            if (th instanceof RequestCancelledException) {
                b52.i(this.b.cancel(false));
            } else {
                b52.i(this.a.c(null));
            }
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r2) {
            b52.i(this.a.c(null));
        }
    }

    class b extends DeferrableSurface {
        b(Size size, int i) {
            super(size, i);
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        protected ub1 r() {
            return SurfaceRequest.this.f;
        }
    }

    class c implements bs0 {
        final /* synthetic */ ub1 a;
        final /* synthetic */ CallbackToFutureAdapter.a b;
        final /* synthetic */ String c;

        c(ub1 ub1Var, CallbackToFutureAdapter.a aVar, String str) {
            this.a = ub1Var;
            this.b = aVar;
            this.c = str;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            if (!(th instanceof CancellationException)) {
                this.b.c(null);
                return;
            }
            b52.i(this.b.f(new RequestCancelledException(this.c + " cancelled.", th)));
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Surface surface) {
            os0.C(this.a, this.b);
        }
    }

    class d implements bs0 {
        final /* synthetic */ q20 a;
        final /* synthetic */ Surface b;

        d(q20 q20Var, Surface surface) {
            this.a = q20Var;
            this.b = surface;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            b52.j(th instanceof RequestCancelledException, "Camera surface session should only fail with request cancellation. Instead failed due to:\n" + th);
            this.a.accept(f.c(1, this.b));
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r3) {
            this.a.accept(f.c(0, this.b));
        }
    }

    class e implements bs0 {
        final /* synthetic */ Runnable a;

        e(Runnable runnable) {
            this.a = runnable;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r1) {
            this.a.run();
        }
    }

    public static abstract class f {
        f() {
        }

        static f c(int i, Surface surface) {
            return new androidx.camera.core.g(i, surface);
        }

        public abstract int a();

        public abstract Surface b();
    }

    public static abstract class g {
        g() {
        }

        public static g g(Rect rect, int i, int i2, boolean z, Matrix matrix, boolean z2) {
            return new androidx.camera.core.h(rect, i, i2, z, matrix, z2);
        }

        public abstract Rect a();

        public abstract int b();

        public abstract Matrix c();

        public abstract int d();

        public abstract boolean e();

        public abstract boolean f();
    }

    public interface h {
        void a(g gVar);
    }

    public SurfaceRequest(Size size, CameraInternal cameraInternal, ie0 ie0Var, Range range, Runnable runnable) {
        this.b = size;
        this.e = cameraInternal;
        this.c = ie0Var;
        this.d = range;
        final String str = "SurfaceRequest[size: " + size + ", id: " + hashCode() + "]";
        final AtomicReference atomicReference = new AtomicReference(null);
        ub1 ub1VarA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: vx2
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return SurfaceRequest.t(atomicReference, str, aVar);
            }
        });
        CallbackToFutureAdapter.a aVar = (CallbackToFutureAdapter.a) b52.g((CallbackToFutureAdapter.a) atomicReference.get());
        this.j = aVar;
        final AtomicReference atomicReference2 = new AtomicReference(null);
        ub1 ub1VarA2 = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: wx2
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar2) {
                return SurfaceRequest.u(atomicReference2, str, aVar2);
            }
        });
        this.h = ub1VarA2;
        os0.j(ub1VarA2, new a(aVar, ub1VarA), androidx.camera.core.impl.utils.executor.c.b());
        CallbackToFutureAdapter.a aVar2 = (CallbackToFutureAdapter.a) b52.g((CallbackToFutureAdapter.a) atomicReference2.get());
        final AtomicReference atomicReference3 = new AtomicReference(null);
        ub1 ub1VarA3 = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: xx2
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar3) {
                return SurfaceRequest.v(atomicReference3, str, aVar3);
            }
        });
        this.f = ub1VarA3;
        this.g = (CallbackToFutureAdapter.a) b52.g((CallbackToFutureAdapter.a) atomicReference3.get());
        b bVar = new b(size, 34);
        this.k = bVar;
        ub1 ub1VarK = bVar.k();
        os0.j(ub1VarA3, new c(ub1VarK, aVar2, str), androidx.camera.core.impl.utils.executor.c.b());
        ub1VarK.a(new Runnable() { // from class: yx2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.w();
            }
        }, androidx.camera.core.impl.utils.executor.c.b());
        this.i = p(androidx.camera.core.impl.utils.executor.c.b(), runnable);
    }

    private CallbackToFutureAdapter.a p(Executor executor, Runnable runnable) {
        final AtomicReference atomicReference = new AtomicReference(null);
        os0.j(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: zx2
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.s(atomicReference, aVar);
            }
        }), new e(runnable), executor);
        return (CallbackToFutureAdapter.a) b52.g((CallbackToFutureAdapter.a) atomicReference.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object s(AtomicReference atomicReference, CallbackToFutureAdapter.a aVar) {
        atomicReference.set(aVar);
        return "SurfaceRequest-surface-recreation(" + hashCode() + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object t(AtomicReference atomicReference, String str, CallbackToFutureAdapter.a aVar) {
        atomicReference.set(aVar);
        return str + "-cancellation";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object u(AtomicReference atomicReference, String str, CallbackToFutureAdapter.a aVar) {
        atomicReference.set(aVar);
        return str + "-status";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object v(AtomicReference atomicReference, String str, CallbackToFutureAdapter.a aVar) {
        atomicReference.set(aVar);
        return str + "-Surface";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        this.f.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(q20 q20Var, Surface surface) {
        q20Var.accept(f.c(3, surface));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(q20 q20Var, Surface surface) {
        q20Var.accept(f.c(4, surface));
    }

    public void B(final Surface surface, Executor executor, final q20 q20Var) {
        if (this.g.c(surface) || this.f.isCancelled()) {
            os0.j(this.h, new d(q20Var, surface), executor);
            return;
        }
        b52.i(this.f.isDone());
        try {
            this.f.get();
            executor.execute(new Runnable() { // from class: by2
                @Override // java.lang.Runnable
                public final void run() {
                    SurfaceRequest.x(q20Var, surface);
                }
            });
        } catch (InterruptedException | ExecutionException unused) {
            executor.execute(new Runnable() { // from class: cy2
                @Override // java.lang.Runnable
                public final void run() {
                    SurfaceRequest.y(q20Var, surface);
                }
            });
        }
    }

    public void C(Executor executor, final h hVar) {
        final g gVar;
        synchronized (this.a) {
            this.m = hVar;
            this.n = executor;
            gVar = this.l;
        }
        if (gVar != null) {
            executor.execute(new Runnable() { // from class: ay2
                @Override // java.lang.Runnable
                public final void run() {
                    hVar.a(gVar);
                }
            });
        }
    }

    public void D(final g gVar) {
        final h hVar;
        Executor executor;
        synchronized (this.a) {
            this.l = gVar;
            hVar = this.m;
            executor = this.n;
        }
        if (hVar == null || executor == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: ux2
            @Override // java.lang.Runnable
            public final void run() {
                hVar.a(gVar);
            }
        });
    }

    public boolean E() {
        return this.g.f(new DeferrableSurface.SurfaceUnavailableException("Surface request will not complete."));
    }

    public void j(Executor executor, Runnable runnable) {
        this.j.a(runnable, executor);
    }

    public CameraInternal k() {
        return this.e;
    }

    public DeferrableSurface l() {
        return this.k;
    }

    public ie0 m() {
        return this.c;
    }

    public Range n() {
        return this.d;
    }

    public Size o() {
        return this.b;
    }

    public boolean q() {
        E();
        return this.i.c(null);
    }

    public boolean r() {
        return this.f.isDone();
    }
}
