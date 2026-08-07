package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.SessionConfiguration;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;

/* JADX INFO: loaded from: classes.dex */
class pt extends ot {
    pt(CameraDevice cameraDevice) {
        super((CameraDevice) b52.g(cameraDevice), null);
    }

    @Override // defpackage.ot, ht.a
    public void a(jn2 jn2Var) throws CameraAccessExceptionCompat {
        SessionConfiguration sessionConfiguration = (SessionConfiguration) jn2Var.j();
        b52.g(sessionConfiguration);
        try {
            this.a.createCaptureSession(sessionConfiguration);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        }
    }
}
