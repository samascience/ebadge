package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.Config;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.yr;
import defpackage.zs;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class e2 {
    private final h a;
    private final f2 b;
    private final Executor c;
    private boolean d = false;
    private CallbackToFutureAdapter.a e;
    private h.c f;

    e2(h hVar, zs zsVar, Executor executor) {
        this.a = hVar;
        this.b = new f2(zsVar, 0);
        this.c = executor;
    }

    private void a() {
        CallbackToFutureAdapter.a aVar = this.e;
        if (aVar != null) {
            aVar.f(new CameraControl$OperationCanceledException("Cancelled by another setExposureCompensationIndex()"));
            this.e = null;
        }
        h.c cVar = this.f;
        if (cVar != null) {
            this.a.W(cVar);
            this.f = null;
        }
    }

    void b(boolean z) {
        if (z == this.d) {
            return;
        }
        this.d = z;
        if (z) {
            return;
        }
        this.b.b(0);
        a();
    }

    void c(yr.a aVar) {
        aVar.g(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(this.b.a()), Config.OptionPriority.REQUIRED);
    }
}
