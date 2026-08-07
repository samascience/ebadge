package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
public abstract class x7 {
    public static void a(CameraCaptureSession.StateCallback stateCallback, CameraCaptureSession cameraCaptureSession, Surface surface) {
        stateCallback.onSurfacePrepared(cameraCaptureSession, surface);
    }
}
