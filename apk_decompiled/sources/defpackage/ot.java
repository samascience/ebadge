package defpackage;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ot extends nt {
    ot(CameraDevice cameraDevice, Object obj) {
        super(cameraDevice, obj);
    }

    static ot e(CameraDevice cameraDevice, Handler handler) {
        return new ot(cameraDevice, new qt.a(handler));
    }

    @Override // ht.a
    public void a(jn2 jn2Var) throws CameraAccessExceptionCompat {
        qt.c(this.a, jn2Var);
        fs.c cVar = new fs.c(jn2Var.a(), jn2Var.e());
        List listC = jn2Var.c();
        Handler handler = ((qt.a) b52.g((qt.a) this.b)).a;
        o21 o21VarB = jn2Var.b();
        try {
            if (o21VarB != null) {
                InputConfiguration inputConfiguration = (InputConfiguration) o21VarB.a();
                b52.g(inputConfiguration);
                this.a.createReprocessableCaptureSessionByConfigurations(inputConfiguration, jn2.h(listC), cVar, handler);
            } else if (jn2Var.d() == 1) {
                this.a.createConstrainedHighSpeedCaptureSession(qt.d(listC), cVar, handler);
            } else {
                this.a.createCaptureSessionByOutputConfigurations(jn2.h(listC), cVar, handler);
            }
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        }
    }
}
