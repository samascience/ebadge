package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.Config;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.yr;
import defpackage.zs;

/* JADX INFO: loaded from: classes.dex */
final class b2 implements h3.b {
    private final zs a;
    private CallbackToFutureAdapter.a c;
    private Rect b = null;
    private Rect d = null;

    b2(zs zsVar) {
        this.a = zsVar;
    }

    @Override // androidx.camera.camera2.internal.h3.b
    public void a(TotalCaptureResult totalCaptureResult) {
        if (this.c != null) {
            CaptureRequest request = totalCaptureResult.getRequest();
            Rect rect = request == null ? null : (Rect) request.get(CaptureRequest.SCALER_CROP_REGION);
            Rect rect2 = this.d;
            if (rect2 == null || !rect2.equals(rect)) {
                return;
            }
            this.c.c(null);
            this.c = null;
            this.d = null;
        }
    }

    @Override // androidx.camera.camera2.internal.h3.b
    public float b() {
        Float f = (Float) this.a.a(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f == null) {
            return 1.0f;
        }
        return f.floatValue() < c() ? c() : f.floatValue();
    }

    @Override // androidx.camera.camera2.internal.h3.b
    public float c() {
        return 1.0f;
    }

    @Override // androidx.camera.camera2.internal.h3.b
    public void d(yr.a aVar) {
        Rect rect = this.b;
        if (rect != null) {
            aVar.g(CaptureRequest.SCALER_CROP_REGION, rect, Config.OptionPriority.REQUIRED);
        }
    }

    @Override // androidx.camera.camera2.internal.h3.b
    public void e() {
        this.d = null;
        this.b = null;
        CallbackToFutureAdapter.a aVar = this.c;
        if (aVar != null) {
            aVar.f(new CameraControl$OperationCanceledException("Camera is not active."));
            this.c = null;
        }
    }
}
