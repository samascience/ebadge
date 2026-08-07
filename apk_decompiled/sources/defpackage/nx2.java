package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.x;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class nx2 implements kx2 {
    private final Surface b;
    private final int c;
    private final int d;
    private final Size e;
    private final Size f;
    private final Rect g;
    private final int h;
    private final boolean i;
    private q20 l;
    private Executor m;
    private final ub1 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CallbackToFutureAdapter.a f364q;
    private CameraInternal r;
    private Matrix s;
    private final Object a = new Object();
    private final float[] j = new float[16];
    private final float[] k = new float[16];
    private boolean n = false;
    private boolean o = false;

    nx2(Surface surface, int i, int i2, Size size, Size size2, Rect rect, int i3, boolean z, CameraInternal cameraInternal, Matrix matrix) {
        this.b = surface;
        this.c = i;
        this.d = i2;
        this.e = size;
        this.f = size2;
        this.g = new Rect(rect);
        this.i = z;
        this.h = i3;
        this.r = cameraInternal;
        this.s = matrix;
        w();
        this.p = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: lx2
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.D(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object D(CallbackToFutureAdapter.a aVar) {
        this.f364q = aVar;
        return "SurfaceOutputImpl close future complete";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(AtomicReference atomicReference) {
        ((q20) atomicReference.get()).accept(kx2.a.c(0, this));
    }

    private void w() {
        android.opengl.Matrix.setIdentityM(this.j, 0);
        gh1.d(this.j, 0.5f);
        gh1.c(this.j, this.h, 0.5f, 0.5f);
        if (this.i) {
            android.opengl.Matrix.translateM(this.j, 0, 1.0f, 0.0f, 0.0f);
            android.opengl.Matrix.scaleM(this.j, 0, -1.0f, 1.0f, 1.0f);
        }
        Size sizeP = y43.p(this.f, this.h);
        Matrix matrixE = y43.e(y43.s(this.f), y43.s(sizeP), this.h, this.i);
        RectF rectF = new RectF(this.g);
        matrixE.mapRect(rectF);
        float width = rectF.left / sizeP.getWidth();
        float height = ((sizeP.getHeight() - rectF.height()) - rectF.top) / sizeP.getHeight();
        float fWidth = rectF.width() / sizeP.getWidth();
        float fHeight = rectF.height() / sizeP.getHeight();
        android.opengl.Matrix.translateM(this.j, 0, width, height, 0.0f);
        android.opengl.Matrix.scaleM(this.j, 0, fWidth, fHeight, 1.0f);
        y();
        float[] fArr = this.j;
        android.opengl.Matrix.multiplyMM(fArr, 0, this.k, 0, fArr, 0);
    }

    private void y() {
        android.opengl.Matrix.setIdentityM(this.k, 0);
        gh1.d(this.k, 0.5f);
        CameraInternal cameraInternal = this.r;
        if (cameraInternal != null) {
            b52.j(cameraInternal.m(), "Camera has no transform.");
            gh1.c(this.k, this.r.a().a(), 0.5f, 0.5f);
            if (this.r.b()) {
                android.opengl.Matrix.translateM(this.k, 0, 1.0f, 0.0f, 0.0f);
                android.opengl.Matrix.scaleM(this.k, 0, -1.0f, 1.0f, 1.0f);
            }
        }
        float[] fArr = this.k;
        android.opengl.Matrix.invertM(fArr, 0, fArr, 0);
    }

    public ub1 C() {
        return this.p;
    }

    public void a0() {
        Executor executor;
        q20 q20Var;
        final AtomicReference atomicReference = new AtomicReference();
        synchronized (this.a) {
            try {
                if (this.m == null || (q20Var = this.l) == null) {
                    this.n = true;
                } else if (!this.o) {
                    atomicReference.set(q20Var);
                    executor = this.m;
                    this.n = false;
                }
                executor = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (executor != null) {
            try {
                executor.execute(new Runnable() { // from class: mx2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.V(atomicReference);
                    }
                });
            } catch (RejectedExecutionException e) {
                x.b("SurfaceOutputImpl", "Processor executor closed. Close request not posted.", e);
            }
        }
    }

    @Override // defpackage.kx2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.a) {
            try {
                if (!this.o) {
                    this.o = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f364q.c(null);
    }

    @Override // defpackage.kx2
    public Surface i0(Executor executor, q20 q20Var) {
        boolean z;
        synchronized (this.a) {
            this.m = executor;
            this.l = q20Var;
            z = this.n;
        }
        if (z) {
            a0();
        }
        return this.b;
    }

    @Override // defpackage.kx2
    public Size o() {
        return this.e;
    }

    @Override // defpackage.kx2
    public int q() {
        return this.d;
    }

    @Override // defpackage.kx2
    public void z(float[] fArr, float[] fArr2) {
        android.opengl.Matrix.multiplyMM(fArr, 0, fArr2, 0, this.j, 0);
    }
}
