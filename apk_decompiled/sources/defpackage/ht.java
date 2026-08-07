package defpackage;

import android.hardware.camera2.CameraDevice;
import android.os.Build;
import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class ht {
    private final a a;

    interface a {
        void a(jn2 jn2Var);
    }

    static final class b extends CameraDevice.StateCallback {
        final CameraDevice.StateCallback a;
        private final Executor b;

        b(Executor executor, CameraDevice.StateCallback stateCallback) {
            this.b = executor;
            this.a = stateCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(CameraDevice cameraDevice) {
            this.a.onClosed(cameraDevice);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(CameraDevice cameraDevice) {
            this.a.onDisconnected(cameraDevice);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(CameraDevice cameraDevice, int i) {
            this.a.onError(cameraDevice, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(CameraDevice cameraDevice) {
            this.a.onOpened(cameraDevice);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(final CameraDevice cameraDevice) {
            this.b.execute(new Runnable() { // from class: jt
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.e(cameraDevice);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(final CameraDevice cameraDevice) {
            this.b.execute(new Runnable() { // from class: lt
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f(cameraDevice);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(final CameraDevice cameraDevice, final int i) {
            this.b.execute(new Runnable() { // from class: kt
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.g(cameraDevice, i);
                }
            });
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(final CameraDevice cameraDevice) {
            this.b.execute(new Runnable() { // from class: mt
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.h(cameraDevice);
                }
            });
        }
    }

    private ht(CameraDevice cameraDevice, Handler handler) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.a = new pt(cameraDevice);
        } else {
            this.a = ot.e(cameraDevice, handler);
        }
    }

    public static ht b(CameraDevice cameraDevice, Handler handler) {
        return new ht(cameraDevice, handler);
    }

    public void a(jn2 jn2Var) {
        this.a.a(jn2Var);
    }
}
