package defpackage;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.executor.c;
import androidx.camera.core.x;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;

/* JADX INFO: loaded from: classes.dex */
public class w80 implements qx2, SurfaceTexture.OnFrameAvailableListener {
    private final rw1 a;
    final HandlerThread b;
    private final Executor c;
    final Handler d;
    private final AtomicBoolean e;
    private final float[] f;
    private final float[] g;
    final Map h;
    private int i;
    private boolean j;
    private final List k;

    public static class a {
        private static wr0 a = new wr0() { // from class: v80
            @Override // defpackage.wr0
            public final Object apply(Object obj) {
                return new w80((ie0) obj);
            }
        };

        public static qx2 a(ie0 ie0Var) {
            return (qx2) a.apply(ie0Var);
        }
    }

    static abstract class b {
        b() {
        }

        static zc d(int i, int i2, CallbackToFutureAdapter.a aVar) {
            return new zc(i, i2, aVar);
        }

        abstract CallbackToFutureAdapter.a a();

        abstract int b();

        abstract int c();
    }

    w80(ie0 ie0Var) {
        this(ie0Var, on2.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(SurfaceRequest surfaceRequest) {
        this.i++;
        final SurfaceTexture surfaceTexture = new SurfaceTexture(this.a.x());
        surfaceTexture.setDefaultBufferSize(surfaceRequest.o().getWidth(), surfaceRequest.o().getHeight());
        final Surface surface = new Surface(surfaceTexture);
        surfaceRequest.B(surface, this.c, new q20() { // from class: i80
            @Override // defpackage.q20
            public final void accept(Object obj) {
                this.a.z(surfaceTexture, surface, (SurfaceRequest.f) obj);
            }
        });
        surfaceTexture.setOnFrameAvailableListener(this, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(kx2 kx2Var, kx2.a aVar) {
        kx2Var.close();
        Surface surface = (Surface) this.h.remove(kx2Var);
        if (surface != null) {
            this.a.L(surface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(final kx2 kx2Var) {
        Surface surfaceI0 = kx2Var.i0(this.c, new q20() { // from class: r80
            @Override // defpackage.q20
            public final void accept(Object obj) {
                this.a.B(kx2Var, (kx2.a) obj);
            }
        });
        this.a.E(surfaceI0);
        this.h.put(kx2Var, surfaceI0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        this.j = true;
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(b bVar) {
        this.k.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F(CallbackToFutureAdapter.a aVar) {
        aVar.f(new Exception("Failed to snapshot: OpenGLRenderer not ready."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object G(int i, int i2, final CallbackToFutureAdapter.a aVar) {
        final zc zcVarD = b.d(i, i2, aVar);
        r(new Runnable() { // from class: k80
            @Override // java.lang.Runnable
            public final void run() {
                this.a.E(zcVarD);
            }
        }, new Runnable() { // from class: l80
            @Override // java.lang.Runnable
            public final void run() {
                w80.F(aVar);
            }
        });
        return "DefaultSurfaceProcessor#snapshot";
    }

    private void H(Triple triple) {
        if (this.k.isEmpty()) {
            return;
        }
        if (triple == null) {
            s(new Exception("Failed to snapshot: no JPEG Surface."));
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                Iterator it = this.k.iterator();
                int iC = -1;
                int iB = -1;
                Bitmap bitmapT = null;
                byte[] byteArray = null;
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (iC != bVar.c() || bitmapT == null) {
                        iC = bVar.c();
                        if (bitmapT != null) {
                            bitmapT.recycle();
                        }
                        bitmapT = t((Size) triple.getSecond(), (float[]) triple.getThird(), iC);
                        iB = -1;
                    }
                    if (iB != bVar.b()) {
                        byteArrayOutputStream.reset();
                        iB = bVar.b();
                        bitmapT.compress(Bitmap.CompressFormat.JPEG, iB, byteArrayOutputStream);
                        byteArray = byteArrayOutputStream.toByteArray();
                    }
                    Surface surface = (Surface) triple.getFirst();
                    Objects.requireNonNull(byteArray);
                    ImageProcessingUtil.q(surface, byteArray);
                    bVar.a().c(null);
                    it.remove();
                }
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            s(e);
        }
    }

    private void p() {
        if (this.j && this.i == 0) {
            Iterator it = this.h.keySet().iterator();
            while (it.hasNext()) {
                ((kx2) it.next()).close();
            }
            Iterator it2 = this.k.iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).a().f(new Exception("Failed to snapshot: DefaultSurfaceProcessor is released."));
            }
            this.h.clear();
            this.a.F();
            this.b.quit();
        }
    }

    private void q(Runnable runnable) {
        r(runnable, new Runnable() { // from class: s80
            @Override // java.lang.Runnable
            public final void run() {
                w80.v();
            }
        });
    }

    private void r(final Runnable runnable, final Runnable runnable2) {
        try {
            this.c.execute(new Runnable() { // from class: t80
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.w(runnable2, runnable);
                }
            });
        } catch (RejectedExecutionException e) {
            x.l("DefaultSurfaceProcessor", "Unable to executor runnable", e);
            runnable2.run();
        }
    }

    private void s(Throwable th) {
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a().f(th);
        }
        this.k.clear();
    }

    private Bitmap t(Size size, float[] fArr, int i) {
        float[] fArr2 = (float[]) fArr.clone();
        gh1.c(fArr2, i, 0.5f, 0.5f);
        gh1.d(fArr2, 0.5f);
        return this.a.J(y43.p(size, i), fArr2);
    }

    private void u(final ie0 ie0Var, final on2 on2Var) {
        try {
            CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: q80
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return this.a.y(ie0Var, on2Var, aVar);
                }
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            e = e;
            if (e instanceof ExecutionException) {
                e = e.getCause();
            }
            if (!(e instanceof RuntimeException)) {
                throw new IllegalStateException("Failed to create DefaultSurfaceProcessor", e);
            }
            throw ((RuntimeException) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(Runnable runnable, Runnable runnable2) {
        if (this.j) {
            runnable.run();
        } else {
            runnable2.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(ie0 ie0Var, on2 on2Var, CallbackToFutureAdapter.a aVar) throws Throwable {
        try {
            this.a.y(ie0Var, on2Var);
            aVar.c(null);
        } catch (RuntimeException e) {
            aVar.f(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object y(final ie0 ie0Var, final on2 on2Var, final CallbackToFutureAdapter.a aVar) {
        q(new Runnable() { // from class: u80
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.a.x(ie0Var, on2Var, aVar);
            }
        });
        return "Init GlRenderer";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(SurfaceTexture surfaceTexture, Surface surface, SurfaceRequest.f fVar) {
        surfaceTexture.setOnFrameAvailableListener(null);
        surfaceTexture.release();
        surface.release();
        this.i--;
        p();
    }

    @Override // defpackage.px2
    public void a(final SurfaceRequest surfaceRequest) {
        if (this.e.get()) {
            surfaceRequest.E();
            return;
        }
        Runnable runnable = new Runnable() { // from class: n80
            @Override // java.lang.Runnable
            public final void run() {
                this.a.A(surfaceRequest);
            }
        };
        Objects.requireNonNull(surfaceRequest);
        r(runnable, new Runnable() { // from class: o80
            @Override // java.lang.Runnable
            public final void run() {
                surfaceRequest.E();
            }
        });
    }

    @Override // defpackage.px2
    public void b(final kx2 kx2Var) {
        if (this.e.get()) {
            kx2Var.close();
            return;
        }
        Runnable runnable = new Runnable() { // from class: h80
            @Override // java.lang.Runnable
            public final void run() {
                this.a.C(kx2Var);
            }
        };
        Objects.requireNonNull(kx2Var);
        r(runnable, new Runnable() { // from class: m80
            @Override // java.lang.Runnable
            public final void run() {
                kx2Var.close();
            }
        });
    }

    @Override // defpackage.qx2
    public ub1 c(final int i, final int i2) {
        return os0.B(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: j80
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.G(i, i2, aVar);
            }
        }));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.e.get()) {
            return;
        }
        surfaceTexture.updateTexImage();
        surfaceTexture.getTransformMatrix(this.f);
        Triple triple = null;
        for (Map.Entry entry : this.h.entrySet()) {
            Surface surface = (Surface) entry.getValue();
            kx2 kx2Var = (kx2) entry.getKey();
            kx2Var.z(this.g, this.f);
            if (kx2Var.q() == 34) {
                try {
                    this.a.I(surfaceTexture.getTimestamp(), this.g, surface);
                } catch (RuntimeException e) {
                    x.d("DefaultSurfaceProcessor", "Failed to render with OpenGL.", e);
                }
            } else {
                b52.j(kx2Var.q() == 256, "Unsupported format: " + kx2Var.q());
                b52.j(triple == null, "Only one JPEG output is supported.");
                triple = new Triple(surface, kx2Var.o(), (float[]) this.g.clone());
            }
        }
        try {
            H(triple);
        } catch (RuntimeException e2) {
            s(e2);
        }
    }

    @Override // defpackage.qx2
    public void release() {
        if (this.e.getAndSet(true)) {
            return;
        }
        q(new Runnable() { // from class: p80
            @Override // java.lang.Runnable
            public final void run() {
                this.a.D();
            }
        });
    }

    w80(ie0 ie0Var, on2 on2Var) {
        this.e = new AtomicBoolean(false);
        this.f = new float[16];
        this.g = new float[16];
        this.h = new LinkedHashMap();
        this.i = 0;
        this.j = false;
        this.k = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("GL Thread");
        this.b = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.d = handler;
        this.c = c.f(handler);
        this.a = new rw1();
        try {
            u(ie0Var, on2Var);
        } catch (RuntimeException e) {
            release();
            throw e;
        }
    }
}
