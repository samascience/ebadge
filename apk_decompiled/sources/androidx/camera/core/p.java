package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ImageWriter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.OperationCanceledException;
import defpackage.g11;
import defpackage.os0;
import defpackage.t11;
import defpackage.ub1;
import defpackage.x01;
import defpackage.y43;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
abstract class p implements x01.a {
    private m.a a;
    private volatile int b;
    private volatile int c;
    private volatile boolean e;
    private volatile boolean f;
    private Executor g;
    private b0 h;
    private ImageWriter i;
    ByteBuffer n;
    ByteBuffer o;
    ByteBuffer p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ByteBuffer f156q;
    private volatile int d = 1;
    private Rect j = new Rect();
    private Rect k = new Rect();
    private Matrix l = new Matrix();
    private Matrix m = new Matrix();
    private final Object r = new Object();
    protected boolean s = true;

    p() {
    }

    private void h(v vVar) {
        if (this.d != 1) {
            if (this.d == 2 && this.n == null) {
                this.n = ByteBuffer.allocateDirect(vVar.getWidth() * vVar.getHeight() * 4);
                return;
            }
            return;
        }
        if (this.o == null) {
            this.o = ByteBuffer.allocateDirect(vVar.getWidth() * vVar.getHeight());
        }
        this.o.position(0);
        if (this.p == null) {
            this.p = ByteBuffer.allocateDirect((vVar.getWidth() * vVar.getHeight()) / 4);
        }
        this.p.position(0);
        if (this.f156q == null) {
            this.f156q = ByteBuffer.allocateDirect((vVar.getWidth() * vVar.getHeight()) / 4);
        }
        this.f156q.position(0);
    }

    private static b0 i(int i, int i2, int i3, int i4, int i5) {
        boolean z = i3 == 90 || i3 == 270;
        int i6 = z ? i2 : i;
        if (!z) {
            i = i2;
        }
        return new b0(w.a(i6, i, i4, i5));
    }

    static Matrix k(int i, int i2, int i3, int i4, int i5) {
        Matrix matrix = new Matrix();
        if (i5 > 0) {
            matrix.setRectToRect(new RectF(0.0f, 0.0f, i, i2), y43.a, Matrix.ScaleToFit.FILL);
            matrix.postRotate(i5);
            matrix.postConcat(y43.c(new RectF(0.0f, 0.0f, i3, i4)));
        }
        return matrix;
    }

    static Rect l(Rect rect, Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(v vVar, Matrix matrix, v vVar2, Rect rect, m.a aVar, CallbackToFutureAdapter.a aVar2) {
        if (!this.s) {
            aVar2.f(new OperationCanceledException("ImageAnalysis is detached"));
            return;
        }
        c0 c0Var = new c0(vVar2, t11.e(vVar.h0().a(), vVar.h0().c(), this.e ? 0 : this.b, matrix));
        if (!rect.isEmpty()) {
            c0Var.d0(rect);
        }
        aVar.b(c0Var);
        aVar2.c(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n(Executor executor, final v vVar, final Matrix matrix, final v vVar2, final Rect rect, final m.a aVar, final CallbackToFutureAdapter.a aVar2) {
        executor.execute(new Runnable() { // from class: androidx.camera.core.o
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m(vVar, matrix, vVar2, rect, aVar, aVar2);
            }
        });
        return "analyzeImage";
    }

    private void p(int i, int i2, int i3, int i4) {
        Matrix matrixK = k(i, i2, i3, i4, this.b);
        this.k = l(this.j, matrixK);
        this.m.setConcat(this.l, matrixK);
    }

    private void q(v vVar, int i) {
        b0 b0Var = this.h;
        if (b0Var == null) {
            return;
        }
        b0Var.m();
        this.h = i(vVar.getWidth(), vVar.getHeight(), i, this.h.d(), this.h.g());
        if (this.d == 1) {
            ImageWriter imageWriter = this.i;
            if (imageWriter != null) {
                g11.a(imageWriter);
            }
            this.i = g11.c(this.h.a(), this.h.g());
        }
    }

    @Override // x01.a
    public void a(x01 x01Var) {
        try {
            v vVarD = d(x01Var);
            if (vVarD != null) {
                o(vVarD);
            }
        } catch (IllegalStateException e) {
            x.d("ImageAnalysisAnalyzer", "Failed to acquire image.", e);
        }
    }

    abstract v d(x01 x01Var);

    /* JADX WARN: Code duplicated, block: B:41:0x006b  */
    ub1 e(final v vVar) {
        final Executor executor;
        final m.a aVar;
        boolean z;
        b0 b0Var;
        ImageWriter imageWriter;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        ByteBuffer byteBuffer3;
        ByteBuffer byteBuffer4;
        v vVarO;
        int i = this.e ? this.b : 0;
        synchronized (this.r) {
            try {
                executor = this.g;
                aVar = this.a;
                z = this.e && i != this.c;
                if (z) {
                    q(vVar, i);
                }
                if (this.e) {
                    h(vVar);
                }
                b0Var = this.h;
                imageWriter = this.i;
                byteBuffer = this.n;
                byteBuffer2 = this.o;
                byteBuffer3 = this.p;
                byteBuffer4 = this.f156q;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (aVar == null || executor == null || !this.s) {
            return os0.n(new OperationCanceledException("No analyzer or executor currently set."));
        }
        if (b0Var == null) {
            vVarO = null;
        } else if (this.d == 2) {
            vVarO = ImageProcessingUtil.g(vVar, b0Var, byteBuffer, i, this.f);
        } else if (this.d != 1) {
            vVarO = null;
        } else {
            if (this.f) {
                ImageProcessingUtil.c(vVar);
            }
            if (imageWriter == null || byteBuffer2 == null || byteBuffer3 == null || byteBuffer4 == null) {
                vVarO = null;
            } else {
                vVarO = ImageProcessingUtil.o(vVar, b0Var, imageWriter, byteBuffer2, byteBuffer3, byteBuffer4, i);
            }
        }
        boolean z2 = vVarO == null;
        final v vVar2 = z2 ? vVar : vVarO;
        final Rect rect = new Rect();
        final Matrix matrix = new Matrix();
        synchronized (this.r) {
            if (z && !z2) {
                try {
                    p(vVar.getWidth(), vVar.getHeight(), vVar2.getWidth(), vVar2.getHeight());
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            this.c = i;
            rect.set(this.k);
            matrix.set(this.m);
        }
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.core.n
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar2) {
                return this.a.n(executor, vVar, matrix, vVar2, rect, aVar, aVar2);
            }
        });
    }

    void f() {
        this.s = true;
    }

    abstract void g();

    void j() {
        this.s = false;
        g();
    }

    abstract void o(v vVar);

    void r(Executor executor, m.a aVar) {
        if (aVar == null) {
            g();
        }
        synchronized (this.r) {
            this.a = aVar;
            this.g = executor;
        }
    }

    void s(boolean z) {
        this.f = z;
    }

    void t(int i) {
        this.d = i;
    }

    void u(boolean z) {
        this.e = z;
    }

    void v(b0 b0Var) {
        synchronized (this.r) {
            this.h = b0Var;
        }
    }

    void w(int i) {
        this.b = i;
    }

    void x(Matrix matrix) {
        synchronized (this.r) {
            this.l = matrix;
            this.m = new Matrix(this.l);
        }
    }

    void y(Rect rect) {
        synchronized (this.r) {
            this.j = rect;
            this.k = new Rect(this.j);
        }
    }
}
