package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.u;

/* JADX INFO: loaded from: classes.dex */
public final class yr extends ow {
    public static final Config.a J = Config.a.a("camera2.captureRequest.templateType", Integer.TYPE);
    public static final Config.a K = Config.a.a("camera2.cameraCaptureSession.streamUseCase", Long.TYPE);
    public static final Config.a L = Config.a.a("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class);
    public static final Config.a M = Config.a.a("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class);
    public static final Config.a N = Config.a.a("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class);
    public static final Config.a O = Config.a.a("camera2.captureRequest.tag", Object.class);
    public static final Config.a P = Config.a.a("camera2.cameraCaptureSession.physicalCameraId", String.class);

    public static final class a implements oj0 {
        private final t a = t.c0();

        @Override // defpackage.oj0
        public s a() {
            return this.a;
        }

        public yr c() {
            return new yr(u.a0(this.a));
        }

        public a d(Config config) {
            e(config, Config.OptionPriority.OPTIONAL);
            return this;
        }

        public a e(Config config, Config.OptionPriority optionPriority) {
            for (Config.a aVar : config.e()) {
                this.a.s(aVar, optionPriority, config.a(aVar));
            }
            return this;
        }

        public a f(CaptureRequest.Key key, Object obj) {
            this.a.x(yr.Y(key), obj);
            return this;
        }

        public a g(CaptureRequest.Key key, Object obj, Config.OptionPriority optionPriority) {
            this.a.s(yr.Y(key), optionPriority, obj);
            return this;
        }
    }

    public yr(Config config) {
        super(config);
    }

    public static Config.a Y(CaptureRequest.Key key) {
        return Config.a.b("camera2.captureRequest.option." + key.getName(), Object.class, key);
    }

    public ow Z() {
        return ow.a.e(n()).d();
    }

    public int a0(int i) {
        return ((Integer) n().f(J, Integer.valueOf(i))).intValue();
    }

    public CameraDevice.StateCallback b0(CameraDevice.StateCallback stateCallback) {
        return (CameraDevice.StateCallback) n().f(L, stateCallback);
    }

    public String c0(String str) {
        return (String) n().f(P, str);
    }

    public CameraCaptureSession.CaptureCallback d0(CameraCaptureSession.CaptureCallback captureCallback) {
        return (CameraCaptureSession.CaptureCallback) n().f(N, captureCallback);
    }

    public CameraCaptureSession.StateCallback e0(CameraCaptureSession.StateCallback stateCallback) {
        return (CameraCaptureSession.StateCallback) n().f(M, stateCallback);
    }

    public long f0(long j) {
        return ((Long) n().f(K, Long.valueOf(j))).longValue();
    }
}
