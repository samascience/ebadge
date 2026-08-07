package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.core.impl.CameraCaptureFailure;
import defpackage.as;
import defpackage.b52;
import defpackage.vz2;
import defpackage.yq;

/* JADX INFO: loaded from: classes.dex */
final class q1 extends CameraCaptureSession.CaptureCallback {
    private final as a;

    q1(as asVar) {
        if (asVar == null) {
            throw new NullPointerException("cameraCaptureCallback is null");
        }
        this.a = asVar;
    }

    private int a(CaptureRequest captureRequest) {
        Integer num;
        if ((captureRequest.getTag() instanceof vz2) && (num = (Integer) ((vz2) captureRequest.getTag()).d("CAPTURE_CONFIG_ID_KEY")) != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        vz2 vz2VarB;
        super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        Object tag = captureRequest.getTag();
        if (tag != null) {
            b52.b(tag instanceof vz2, "The tagBundle object from the CaptureResult is not a TagBundle object.");
            vz2VarB = (vz2) tag;
        } else {
            vz2VarB = vz2.b();
        }
        this.a.b(a(captureRequest), new yq(vz2VarB, totalCaptureResult));
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
        this.a.c(a(captureRequest), new CameraCaptureFailure(CameraCaptureFailure.Reason.ERROR));
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
        super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
        this.a.d(a(captureRequest));
    }
}
