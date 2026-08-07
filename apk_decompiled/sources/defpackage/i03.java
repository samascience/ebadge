package defpackage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.u;
import androidx.camera.core.v;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class i03 {
    private int a = new uv().a();

    interface a {
        void a(i03 i03Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(ImageCaptureException imageCaptureException) {
        i();
        if (!(k() != null)) {
            throw new IllegalStateException("One and only one callback is allowed.");
        }
        u.f fVarK = k();
        Objects.requireNonNull(fVarK);
        fVarK.d(imageCaptureException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(Bitmap bitmap) {
        if (k() != null) {
            k().a(bitmap);
        } else {
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(u.h hVar) {
        u.f fVarK = k();
        Objects.requireNonNull(fVarK);
        Objects.requireNonNull(hVar);
        fVarK.c(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(v vVar) {
        i();
        throw null;
    }

    public static i03 t(Executor executor, u.e eVar, u.f fVar, u.g gVar, Rect rect, Matrix matrix, int i, int i2, int i3, List list) {
        b52.b((fVar == null) == (gVar == null), "onDiskCallback and outputFileOptions should be both null or both non-null.");
        b52.b(!(fVar == null), "One and only one on-disk or in-memory callback should be present.");
        return new td(executor, eVar, fVar, gVar, rect, matrix, i, i2, i3, list);
    }

    boolean e() {
        t23.a();
        int i = this.a;
        if (i <= 0) {
            return false;
        }
        this.a = i - 1;
        return true;
    }

    abstract Executor f();

    abstract int g();

    abstract Rect h();

    public abstract u.e i();

    abstract int j();

    public abstract u.f k();

    abstract u.g l();

    abstract int m();

    abstract Matrix n();

    abstract List o();

    void u(final ImageCaptureException imageCaptureException) {
        f().execute(new Runnable() { // from class: e03
            @Override // java.lang.Runnable
            public final void run() {
                this.a.p(imageCaptureException);
            }
        });
    }

    void v(final Bitmap bitmap) {
        f().execute(new Runnable() { // from class: g03
            @Override // java.lang.Runnable
            public final void run() {
                this.a.q(bitmap);
            }
        });
    }

    void w(final u.h hVar) {
        f().execute(new Runnable() { // from class: h03
            @Override // java.lang.Runnable
            public final void run() {
                this.a.r(hVar);
            }
        });
    }

    void x(final v vVar) {
        f().execute(new Runnable() { // from class: f03
            @Override // java.lang.Runnable
            public final void run() {
                this.a.s(vVar);
            }
        });
    }
}
