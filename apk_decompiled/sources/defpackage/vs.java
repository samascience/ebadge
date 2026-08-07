package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class vs implements fs.a {
    final CameraCaptureSession a;
    final Object b;

    private static class a {
        final Handler a;

        a(Handler handler) {
            this.a = handler;
        }
    }

    vs(CameraCaptureSession cameraCaptureSession, Object obj) {
        this.a = (CameraCaptureSession) b52.g(cameraCaptureSession);
        this.b = obj;
    }

    static fs.a d(CameraCaptureSession cameraCaptureSession, Handler handler) {
        return new vs(cameraCaptureSession, new a(handler));
    }

    @Override // fs.a
    public CameraCaptureSession a() {
        return this.a;
    }

    @Override // fs.a
    public int b(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.a.setRepeatingRequest(captureRequest, new fs.b(executor, captureCallback), ((a) this.b).a);
    }

    @Override // fs.a
    public int c(List list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.a.captureBurst(list, new fs.b(executor, captureCallback), ((a) this.b).a);
    }
}
