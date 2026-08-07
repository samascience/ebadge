package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import defpackage.fs;
import defpackage.jn2;
import defpackage.ub1;
import defpackage.w92;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public interface t2 {

    public interface a {
        Executor b();

        ub1 j(CameraDevice cameraDevice, jn2 jn2Var, List list);

        jn2 k(int i, List list, c cVar);

        ub1 m(List list, long j);

        boolean stop();
    }

    public static class b {
        private final Executor a;
        private final ScheduledExecutorService b;
        private final Handler c;
        private final a2 d;
        private final w92 e;
        private final w92 f;

        b(Executor executor, ScheduledExecutorService scheduledExecutorService, Handler handler, a2 a2Var, w92 w92Var, w92 w92Var2) {
            this.a = executor;
            this.b = scheduledExecutorService;
            this.c = handler;
            this.d = a2Var;
            this.e = w92Var;
            this.f = w92Var2;
        }

        a a() {
            return new d3(this.e, this.f, this.d, this.a, this.b, this.c);
        }
    }

    public static abstract class c {
        void o(t2 t2Var) {
        }

        void p(t2 t2Var) {
        }

        public void q(t2 t2Var) {
        }

        public abstract void r(t2 t2Var);

        abstract void s(t2 t2Var);

        abstract void t(t2 t2Var);

        abstract void u(t2 t2Var);

        void v(t2 t2Var, Surface surface) {
        }
    }

    void a();

    c c();

    void close();

    int d(List list, CameraCaptureSession.CaptureCallback captureCallback);

    fs e();

    void f(int i);

    void g();

    CameraDevice h();

    int i(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback);

    void l();

    ub1 n();
}
