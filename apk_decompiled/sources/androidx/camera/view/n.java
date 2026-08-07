package androidx.camera.view;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.x;
import defpackage.b52;
import defpackage.os0;
import defpackage.q20;
import defpackage.q30;
import defpackage.ub1;
import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class n extends i {
    SurfaceView e;
    final b f;

    private static class a {
        static void a(SurfaceView surfaceView, Bitmap bitmap, PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener, Handler handler) {
            PixelCopy.request(surfaceView, bitmap, onPixelCopyFinishedListener, handler);
        }
    }

    class b implements SurfaceHolder.Callback {
        private Size a;
        private SurfaceRequest b;
        private SurfaceRequest c;
        private i.a d;
        private Size e;
        private boolean f = false;
        private boolean g = false;

        b() {
        }

        private boolean b() {
            return (this.f || this.b == null || !Objects.equals(this.a, this.e)) ? false : true;
        }

        private void c() {
            if (this.b != null) {
                x.a("SurfaceViewImpl", "Request canceled: " + this.b);
                this.b.E();
            }
        }

        private void d() {
            if (this.b != null) {
                x.a("SurfaceViewImpl", "Surface closed " + this.b);
                this.b.l().d();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(i.a aVar, SurfaceRequest.f fVar) {
            x.a("SurfaceViewImpl", "Safe to release surface.");
            if (aVar != null) {
                aVar.a();
            }
        }

        private boolean g() {
            Surface surface = n.this.e.getHolder().getSurface();
            if (!b()) {
                return false;
            }
            x.a("SurfaceViewImpl", "Surface set on Preview.");
            final i.a aVar = this.d;
            SurfaceRequest surfaceRequest = this.b;
            Objects.requireNonNull(surfaceRequest);
            surfaceRequest.B(surface, q30.h(n.this.e.getContext()), new q20() { // from class: androidx.camera.view.o
                @Override // defpackage.q20
                public final void accept(Object obj) {
                    n.b.e(aVar, (SurfaceRequest.f) obj);
                }
            });
            this.f = true;
            n.this.f();
            return true;
        }

        void f(SurfaceRequest surfaceRequest, i.a aVar) {
            c();
            if (this.g) {
                this.g = false;
                surfaceRequest.q();
                return;
            }
            this.b = surfaceRequest;
            this.d = aVar;
            Size sizeO = surfaceRequest.o();
            this.a = sizeO;
            this.f = false;
            if (g()) {
                return;
            }
            x.a("SurfaceViewImpl", "Wait for new Surface creation.");
            n.this.e.getHolder().setFixedSize(sizeO.getWidth(), sizeO.getHeight());
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            x.a("SurfaceViewImpl", "Surface changed. Size: " + i2 + "x" + i3);
            this.e = new Size(i2, i3);
            g();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            SurfaceRequest surfaceRequest;
            x.a("SurfaceViewImpl", "Surface created.");
            if (!this.g || (surfaceRequest = this.c) == null) {
                return;
            }
            surfaceRequest.q();
            this.c = null;
            this.g = false;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            x.a("SurfaceViewImpl", "Surface destroyed.");
            if (this.f) {
                d();
            } else {
                c();
            }
            this.g = true;
            SurfaceRequest surfaceRequest = this.b;
            if (surfaceRequest != null) {
                this.c = surfaceRequest;
            }
            this.f = false;
            this.b = null;
            this.d = null;
            this.e = null;
            this.a = null;
        }
    }

    n(FrameLayout frameLayout, e eVar) {
        super(frameLayout, eVar);
        this.f = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(Semaphore semaphore, int i) {
        if (i == 0) {
            x.a("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() succeeded");
        } else {
            x.c("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() failed with error " + i);
        }
        semaphore.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(SurfaceRequest surfaceRequest, i.a aVar) {
        this.f.f(surfaceRequest, aVar);
    }

    private static boolean o(SurfaceView surfaceView, Size size, SurfaceRequest surfaceRequest) {
        return surfaceView != null && Objects.equals(size, surfaceRequest.o());
    }

    @Override // androidx.camera.view.i
    View b() {
        return this.e;
    }

    @Override // androidx.camera.view.i
    Bitmap c() {
        SurfaceView surfaceView = this.e;
        if (surfaceView == null || surfaceView.getHolder().getSurface() == null || !this.e.getHolder().getSurface().isValid()) {
            return null;
        }
        final Semaphore semaphore = new Semaphore(0);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.e.getWidth(), this.e.getHeight(), Bitmap.Config.ARGB_8888);
        HandlerThread handlerThread = new HandlerThread("pixelCopyRequest Thread");
        handlerThread.start();
        a.a(this.e, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: androidx.camera.view.m
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i) {
                n.m(semaphore, i);
            }
        }, new Handler(handlerThread.getLooper()));
        try {
            try {
                if (!semaphore.tryAcquire(1, 100L, TimeUnit.MILLISECONDS)) {
                    x.c("SurfaceViewImpl", "Timed out while trying to acquire screenshot.");
                }
            } catch (InterruptedException e) {
                x.d("SurfaceViewImpl", "Interrupted while trying to acquire screenshot.", e);
            }
            return bitmapCreateBitmap;
        } finally {
            handlerThread.quitSafely();
        }
    }

    @Override // androidx.camera.view.i
    void d() {
    }

    @Override // androidx.camera.view.i
    void e() {
    }

    @Override // androidx.camera.view.i
    void g(final SurfaceRequest surfaceRequest, final i.a aVar) {
        if (!o(this.e, this.a, surfaceRequest)) {
            this.a = surfaceRequest.o();
            l();
        }
        if (aVar != null) {
            surfaceRequest.j(q30.h(this.e.getContext()), new Runnable() { // from class: androidx.camera.view.k
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.a();
                }
            });
        }
        this.e.post(new Runnable() { // from class: androidx.camera.view.l
            @Override // java.lang.Runnable
            public final void run() {
                this.a.n(surfaceRequest, aVar);
            }
        });
    }

    @Override // androidx.camera.view.i
    ub1 i() {
        return os0.p(null);
    }

    void l() {
        b52.g(this.b);
        b52.g(this.a);
        SurfaceView surfaceView = new SurfaceView(this.b.getContext());
        this.e = surfaceView;
        surfaceView.setLayoutParams(new FrameLayout.LayoutParams(this.a.getWidth(), this.a.getHeight()));
        this.b.removeAllViews();
        this.b.addView(this.e);
        this.e.getHolder().addCallback(this.f);
    }
}
