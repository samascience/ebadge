package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.Config;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.yr;
import defpackage.zs;

/* JADX INFO: loaded from: classes.dex */
final class a implements h3.b {
    private final zs a;
    private final Range b;
    private CallbackToFutureAdapter.a d;
    private float c = 1.0f;
    private float e = 1.0f;

    a(zs zsVar) {
        this.a = zsVar;
        this.b = (Range) zsVar.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
    }

    @Override // androidx.camera.camera2.internal.h3.b
    public void a(TotalCaptureResult totalCaptureResult) {
        if (this.d != null) {
            CaptureRequest request = totalCaptureResult.getRequest();
            Float f = request == null ? null : (Float) request.get(CaptureRequest.CONTROL_ZOOM_RATIO);
            if (f == null) {
                return;
            }
            if (this.e == f.floatValue()) {
                this.d.c(null);
                this.d = null;
            }
        }
    }

    @Override // androidx.camera.camera2.internal.h3.b
    public float b() {
        return ((Float) this.b.getUpper()).floatValue();
    }

    @Override // androidx.camera.camera2.internal.h3.b
    public float c() {
        return ((Float) this.b.getLower()).floatValue();
    }

    @Override // androidx.camera.camera2.internal.h3.b
    public void d(yr.a aVar) {
        aVar.g(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(this.c), Config.OptionPriority.REQUIRED);
    }

    @Override // androidx.camera.camera2.internal.h3.b
    public void e() {
        this.c = 1.0f;
        CallbackToFutureAdapter.a aVar = this.d;
        if (aVar != null) {
            aVar.f(new CameraControl$OperationCanceledException("Camera is not active."));
            this.d = null;
        }
    }
}
