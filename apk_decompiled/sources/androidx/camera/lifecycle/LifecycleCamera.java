package androidx.camera.lifecycle;

import androidx.camera.core.UseCase;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.j;
import defpackage.cb1;
import defpackage.db1;
import defpackage.yt;
import defpackage.zr;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class LifecycleCamera implements cb1, zr {
    private final db1 b;
    private final CameraUseCaseAdapter c;
    private final Object a = new Object();
    private volatile boolean d = false;
    private boolean e = false;
    private boolean f = false;

    LifecycleCamera(db1 db1Var, CameraUseCaseAdapter cameraUseCaseAdapter) {
        this.b = db1Var;
        this.c = cameraUseCaseAdapter;
        if (db1Var.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
            cameraUseCaseAdapter.o();
        } else {
            cameraUseCaseAdapter.y();
        }
        db1Var.getLifecycle().a(this);
    }

    @Override // defpackage.zr
    public yt a() {
        return this.c.a();
    }

    void f(Collection collection) {
        synchronized (this.a) {
            this.c.f(collection);
        }
    }

    public CameraUseCaseAdapter o() {
        return this.c;
    }

    @j(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(db1 db1Var) {
        synchronized (this.a) {
            CameraUseCaseAdapter cameraUseCaseAdapter = this.c;
            cameraUseCaseAdapter.W(cameraUseCaseAdapter.G());
        }
    }

    @j(Lifecycle.Event.ON_PAUSE)
    public void onPause(db1 db1Var) {
        this.c.j(false);
    }

    @j(Lifecycle.Event.ON_RESUME)
    public void onResume(db1 db1Var) {
        this.c.j(true);
    }

    @j(Lifecycle.Event.ON_START)
    public void onStart(db1 db1Var) {
        synchronized (this.a) {
            try {
                if (!this.e && !this.f) {
                    this.c.o();
                    this.d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @j(Lifecycle.Event.ON_STOP)
    public void onStop(db1 db1Var) {
        synchronized (this.a) {
            try {
                if (!this.e && !this.f) {
                    this.c.y();
                    this.d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public db1 p() {
        db1 db1Var;
        synchronized (this.a) {
            db1Var = this.b;
        }
        return db1Var;
    }

    public List q() {
        List listUnmodifiableList;
        synchronized (this.a) {
            listUnmodifiableList = Collections.unmodifiableList(this.c.G());
        }
        return listUnmodifiableList;
    }

    public boolean r(UseCase useCase) {
        boolean zContains;
        synchronized (this.a) {
            zContains = this.c.G().contains(useCase);
        }
        return zContains;
    }

    public void s() {
        synchronized (this.a) {
            try {
                if (this.e) {
                    return;
                }
                onStop(this.b);
                this.e = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void t() {
        synchronized (this.a) {
            CameraUseCaseAdapter cameraUseCaseAdapter = this.c;
            cameraUseCaseAdapter.W(cameraUseCaseAdapter.G());
        }
    }

    public void u() {
        synchronized (this.a) {
            try {
                if (this.e) {
                    this.e = false;
                    if (this.b.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
                        onStart(this.b);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
