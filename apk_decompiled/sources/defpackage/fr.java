package defpackage;

import androidx.camera.camera2.internal.h;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.Config;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class fr {
    private final h c;
    final Executor d;
    CallbackToFutureAdapter.a g;
    private boolean a = false;
    private boolean b = false;
    final Object e = new Object();
    private yr.a f = new yr.a();

    public fr(h hVar, Executor executor) {
        this.c = hVar;
        this.d = executor;
    }

    private void h(ow owVar) {
        synchronized (this.e) {
            this.f.d(owVar);
        }
    }

    private void k() {
        synchronized (this.e) {
            this.f = new yr.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        CallbackToFutureAdapter.a aVar = this.g;
        if (aVar != null) {
            aVar.c(null);
            this.g = null;
        }
    }

    private void m(Exception exc) {
        CallbackToFutureAdapter.a aVar = this.g;
        if (aVar != null) {
            if (exc == null) {
                exc = new Exception("Camera2CameraControl failed with unknown error.");
            }
            aVar.f(exc);
            this.g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p(final CallbackToFutureAdapter.a aVar) {
        this.d.execute(new Runnable() { // from class: er
            @Override // java.lang.Runnable
            public final void run() {
                this.a.o(aVar);
            }
        });
        return "addCaptureRequestOptions";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(final CallbackToFutureAdapter.a aVar) {
        this.d.execute(new Runnable() { // from class: cr
            @Override // java.lang.Runnable
            public final void run() {
                this.a.q(aVar);
            }
        });
        return "clearCaptureRequestOptions";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void s(boolean z) {
        if (this.a == z) {
            return;
        }
        this.a = z;
        if (!z) {
            m(new CameraControl$OperationCanceledException("The camera control has became inactive."));
        } else if (this.b) {
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void q(CallbackToFutureAdapter.a aVar) {
        this.b = true;
        m(new CameraControl$OperationCanceledException("Camera2CameraControl was updated with new options."));
        this.g = aVar;
        if (this.a) {
            w();
        }
    }

    private void w() {
        this.c.e0().a(new Runnable() { // from class: dr
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l();
            }
        }, this.d);
        this.b = false;
    }

    public ub1 g(ow owVar) {
        h(owVar);
        return os0.B(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: zq
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.p(aVar);
            }
        }));
    }

    public void i(yr.a aVar) {
        synchronized (this.e) {
            aVar.e(this.f.a(), Config.OptionPriority.ALWAYS_OVERRIDE);
        }
    }

    public ub1 j() {
        k();
        return os0.B(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: br
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return this.a.r(aVar);
            }
        }));
    }

    public yr n() {
        yr yrVarC;
        synchronized (this.e) {
            yrVarC = this.f.c();
        }
        return yrVarC;
    }

    public void t(final boolean z) {
        this.d.execute(new Runnable() { // from class: ar
            @Override // java.lang.Runnable
            public final void run() {
                this.a.s(z);
            }
        });
    }
}
