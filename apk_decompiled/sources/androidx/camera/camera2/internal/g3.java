package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import defpackage.im1;
import defpackage.sn0;
import defpackage.sr;
import defpackage.t23;
import defpackage.zs;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class g3 {
    private final h a;
    private final im1 b;
    private final boolean c;
    private final Executor d;
    private boolean e;
    CallbackToFutureAdapter.a f;
    boolean g;

    g3(h hVar, zs zsVar, Executor executor) {
        this.a = hVar;
        this.d = executor;
        Objects.requireNonNull(zsVar);
        this.c = sn0.a(new sr(zsVar));
        this.b = new im1(0);
        hVar.r(new h.c() { // from class: androidx.camera.camera2.internal.f3
            @Override // androidx.camera.camera2.internal.h.c
            public final boolean a(TotalCaptureResult totalCaptureResult) {
                return this.a.d(totalCaptureResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean d(TotalCaptureResult totalCaptureResult) {
        if (this.f != null) {
            Integer num = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.FLASH_MODE);
            if ((num != null && num.intValue() == 2) == this.g) {
                this.f.c(null);
                this.f = null;
            }
        }
        return false;
    }

    private void f(im1 im1Var, Object obj) {
        if (t23.c()) {
            im1Var.o(obj);
        } else {
            im1Var.m(obj);
        }
    }

    void b(CallbackToFutureAdapter.a aVar, boolean z) {
        if (!this.c) {
            if (aVar != null) {
                aVar.f(new IllegalStateException("No flash unit"));
            }
        } else {
            if (!this.e) {
                f(this.b, 0);
                if (aVar != null) {
                    aVar.f(new CameraControl$OperationCanceledException("Camera is not active."));
                    return;
                }
                return;
            }
            this.g = z;
            this.a.u(z);
            f(this.b, Integer.valueOf(z ? 1 : 0));
            CallbackToFutureAdapter.a aVar2 = this.f;
            if (aVar2 != null) {
                aVar2.f(new CameraControl$OperationCanceledException("There is a new enableTorch being set"));
            }
            this.f = aVar;
        }
    }

    LiveData c() {
        return this.b;
    }

    void e(boolean z) {
        if (this.e == z) {
            return;
        }
        this.e = z;
        if (z) {
            return;
        }
        if (this.g) {
            this.g = false;
            this.a.u(false);
            f(this.b, 0);
        }
        CallbackToFutureAdapter.a aVar = this.f;
        if (aVar != null) {
            aVar.f(new CameraControl$OperationCanceledException("Camera is not active."));
            this.f = null;
        }
    }
}
