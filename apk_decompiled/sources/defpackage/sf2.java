package defpackage;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.u;
import androidx.camera.core.v;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class sf2 implements wz2 {
    private final i03 a;
    private final i03.a b;
    private CallbackToFutureAdapter.a e;
    private CallbackToFutureAdapter.a f;
    private ub1 i;
    private boolean g = false;
    private boolean h = false;
    private final ub1 c = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: qf2
        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
        public final Object a(CallbackToFutureAdapter.a aVar) {
            return this.a.q(aVar);
        }
    });
    private final ub1 d = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: rf2
        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
        public final Object a(CallbackToFutureAdapter.a aVar) {
            return this.a.r(aVar);
        }
    });

    sf2(i03 i03Var, i03.a aVar) {
        this.a = i03Var;
        this.b = aVar;
    }

    private void k(ImageCaptureException imageCaptureException) {
        t23.a();
        this.g = true;
        ub1 ub1Var = this.i;
        Objects.requireNonNull(ub1Var);
        ub1Var.cancel(true);
        this.e.f(imageCaptureException);
        this.f.c(null);
    }

    private void n() {
        b52.j(this.c.isDone(), "onImageCaptured() must be called before onFinalResult()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q(CallbackToFutureAdapter.a aVar) {
        this.e = aVar;
        return "CaptureCompleteFuture";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(CallbackToFutureAdapter.a aVar) {
        this.f = aVar;
        return "RequestCompleteFuture";
    }

    private void s() {
        b52.j(!this.d.isDone(), "The callback can only complete once.");
        this.f.c(null);
    }

    private void t(ImageCaptureException imageCaptureException) {
        t23.a();
        this.a.u(imageCaptureException);
    }

    @Override // defpackage.wz2
    public void a(Bitmap bitmap) {
        t23.a();
        if (this.g) {
            return;
        }
        this.a.v(bitmap);
    }

    @Override // defpackage.wz2
    public void b() {
        t23.a();
        if (this.g || this.h) {
            return;
        }
        this.h = true;
        this.a.i();
        u.f fVarK = this.a.k();
        if (fVarK != null) {
            fVarK.b();
        }
    }

    @Override // defpackage.wz2
    public boolean c() {
        return this.g;
    }

    @Override // defpackage.wz2
    public void d(ImageCaptureException imageCaptureException) {
        t23.a();
        if (this.g) {
            return;
        }
        boolean zE = this.a.e();
        if (!zE) {
            t(imageCaptureException);
        }
        s();
        this.e.f(imageCaptureException);
        if (zE) {
            this.b.a(this.a);
        }
    }

    @Override // defpackage.wz2
    public void e() {
        t23.a();
        if (this.g) {
            return;
        }
        if (!this.h) {
            b();
        }
        this.e.c(null);
    }

    @Override // defpackage.wz2
    public void f(u.h hVar) {
        t23.a();
        if (this.g) {
            return;
        }
        n();
        s();
        this.a.w(hVar);
    }

    @Override // defpackage.wz2
    public void g(ImageCaptureException imageCaptureException) {
        t23.a();
        if (this.g) {
            return;
        }
        n();
        s();
        t(imageCaptureException);
    }

    @Override // defpackage.wz2
    public void h(v vVar) {
        t23.a();
        if (this.g) {
            vVar.close();
            return;
        }
        n();
        s();
        this.a.x(vVar);
    }

    void l(ImageCaptureException imageCaptureException) {
        t23.a();
        if (this.d.isDone()) {
            return;
        }
        k(imageCaptureException);
        t(imageCaptureException);
    }

    void m() {
        t23.a();
        if (this.d.isDone()) {
            return;
        }
        k(new ImageCaptureException(3, "The request is aborted silently and retried.", null));
        this.b.a(this.a);
    }

    ub1 o() {
        t23.a();
        return this.c;
    }

    ub1 p() {
        t23.a();
        return this.d;
    }

    public void u(ub1 ub1Var) {
        t23.a();
        b52.j(this.i == null, "CaptureRequestFuture can only be set once.");
        this.i = ub1Var;
    }
}
