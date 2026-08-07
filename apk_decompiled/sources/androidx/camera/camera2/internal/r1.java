package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import defpackage.as;

/* JADX INFO: loaded from: classes.dex */
final class r1 extends as {
    private final CameraCaptureSession.CaptureCallback a;

    private r1(CameraCaptureSession.CaptureCallback captureCallback) {
        if (captureCallback == null) {
            throw new NullPointerException("captureCallback is null");
        }
        this.a = captureCallback;
    }

    static r1 e(CameraCaptureSession.CaptureCallback captureCallback) {
        return new r1(captureCallback);
    }

    CameraCaptureSession.CaptureCallback f() {
        return this.a;
    }
}
