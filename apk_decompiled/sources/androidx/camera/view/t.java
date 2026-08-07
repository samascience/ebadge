package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.x;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.b52;
import defpackage.bs0;
import defpackage.os0;
import defpackage.q20;
import defpackage.q30;
import defpackage.ub1;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class t extends i {
    TextureView e;
    SurfaceTexture f;
    ub1 g;
    SurfaceRequest h;
    boolean i;
    SurfaceTexture j;
    AtomicReference k;
    i.a l;
    Executor m;

    class a implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: androidx.camera.view.t$a$a, reason: collision with other inner class name */
        class C0012a implements bs0 {
            final /* synthetic */ SurfaceTexture a;

            C0012a(SurfaceTexture surfaceTexture) {
                this.a = surfaceTexture;
            }

            @Override // defpackage.bs0
            public void a(Throwable th) {
                throw new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", th);
            }

            @Override // defpackage.bs0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(SurfaceRequest.f fVar) {
                b52.j(fVar.a() != 3, "Unexpected result from SurfaceRequest. Surface was provided twice.");
                x.a("TextureViewImpl", "SurfaceTexture about to manually be destroyed");
                this.a.release();
                t tVar = t.this;
                if (tVar.j != null) {
                    tVar.j = null;
                }
            }
        }

        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            x.a("TextureViewImpl", "SurfaceTexture available. Size: " + i + "x" + i2);
            t tVar = t.this;
            tVar.f = surfaceTexture;
            if (tVar.g == null) {
                tVar.u();
                return;
            }
            b52.g(tVar.h);
            x.a("TextureViewImpl", "Surface invalidated " + t.this.h);
            t.this.h.l().d();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            t tVar = t.this;
            tVar.f = null;
            ub1 ub1Var = tVar.g;
            if (ub1Var == null) {
                x.a("TextureViewImpl", "SurfaceTexture about to be destroyed");
                return true;
            }
            os0.j(ub1Var, new C0012a(surfaceTexture), q30.h(t.this.e.getContext()));
            t.this.j = surfaceTexture;
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            x.a("TextureViewImpl", "SurfaceTexture size changed: " + i + "x" + i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            CallbackToFutureAdapter.a aVar = (CallbackToFutureAdapter.a) t.this.k.getAndSet(null);
            if (aVar != null) {
                aVar.c(null);
            }
            t.this.getClass();
            Executor executor = t.this.m;
        }
    }

    t(FrameLayout frameLayout, e eVar) {
        super(frameLayout, eVar);
        this.i = false;
        this.k = new AtomicReference();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(SurfaceRequest surfaceRequest) {
        SurfaceRequest surfaceRequest2 = this.h;
        if (surfaceRequest2 != null && surfaceRequest2 == surfaceRequest) {
            this.h = null;
            this.g = null;
        }
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p(Surface surface, final CallbackToFutureAdapter.a aVar) {
        x.a("TextureViewImpl", "Surface set on Preview.");
        SurfaceRequest surfaceRequest = this.h;
        Executor executorB = androidx.camera.core.impl.utils.executor.c.b();
        Objects.requireNonNull(aVar);
        surfaceRequest.B(surface, executorB, new q20() { // from class: m23
            @Override // defpackage.q20
            public final void accept(Object obj) {
                aVar.c((SurfaceRequest.f) obj);
            }
        });
        return "provideSurface[request=" + this.h + " surface=" + surface + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(Surface surface, ub1 ub1Var, SurfaceRequest surfaceRequest) {
        x.a("TextureViewImpl", "Safe to release surface.");
        s();
        surface.release();
        if (this.g == ub1Var) {
            this.g = null;
        }
        if (this.h == surfaceRequest) {
            this.h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(CallbackToFutureAdapter.a aVar) {
        this.k.set(aVar);
        return "textureViewImpl_waitForNextFrame";
    }

    private void s() {
        i.a aVar = this.l;
        if (aVar != null) {
            aVar.a();
            this.l = null;
        }
    }

    private void t() {
        if (!this.i || this.j == null) {
            return;
        }
        SurfaceTexture surfaceTexture = this.e.getSurfaceTexture();
        SurfaceTexture surfaceTexture2 = this.j;
        if (surfaceTexture != surfaceTexture2) {
            this.e.setSurfaceTexture(surfaceTexture2);
            this.j = null;
            this.i = false;
        }
    }

    @Override // androidx.camera.view.i
    View b() {
        return this.e;
    }

    @Override // androidx.camera.view.i
    Bitmap c() {
        TextureView textureView = this.e;
        if (textureView == null || !textureView.isAvailable()) {
            return null;
        }
        return this.e.getBitmap();
    }

    @Override // androidx.camera.view.i
    void d() {
        t();
    }

    @Override // androidx.camera.view.i
    void e() {
        this.i = true;
    }

    @Override // androidx.camera.view.i
    void g(final SurfaceRequest surfaceRequest, i.a aVar) {
        this.a = surfaceRequest.o();
        this.l = aVar;
        n();
        SurfaceRequest surfaceRequest2 = this.h;
        if (surfaceRequest2 != null) {
            surfaceRequest2.E();
        }
        this.h = surfaceRequest;
        surfaceRequest.j(q30.h(this.e.getContext()), new Runnable() { // from class: androidx.camera.view.p
            @Override // java.lang.Runnable
            public final void run() {
                this.a.o(surfaceRequest);
            }
        });
        u();
    }

    @Override // androidx.camera.view.i
    ub1 i() {
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.view.q
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.r(aVar);
            }
        });
    }

    public void n() {
        b52.g(this.b);
        b52.g(this.a);
        TextureView textureView = new TextureView(this.b.getContext());
        this.e = textureView;
        textureView.setLayoutParams(new FrameLayout.LayoutParams(this.a.getWidth(), this.a.getHeight()));
        this.e.setSurfaceTextureListener(new a());
        this.b.removeAllViews();
        this.b.addView(this.e);
    }

    void u() {
        SurfaceTexture surfaceTexture;
        Size size = this.a;
        if (size == null || (surfaceTexture = this.f) == null || this.h == null) {
            return;
        }
        surfaceTexture.setDefaultBufferSize(size.getWidth(), this.a.getHeight());
        final Surface surface = new Surface(this.f);
        final SurfaceRequest surfaceRequest = this.h;
        final ub1 ub1VarA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.view.r
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.p(surface, aVar);
            }
        });
        this.g = ub1VarA;
        ub1VarA.a(new Runnable() { // from class: androidx.camera.view.s
            @Override // java.lang.Runnable
            public final void run() {
                this.a.q(surface, ub1VarA, surfaceRequest);
            }
        }, q30.h(this.e.getContext()));
        f();
    }
}
