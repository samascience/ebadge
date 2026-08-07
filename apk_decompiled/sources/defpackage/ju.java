package defpackage;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class ju extends mu {
    ju(Context context) {
        super(context, null);
    }

    static ju i(Context context) {
        return new ju(context);
    }

    private boolean j(Throwable th) {
        return Build.VERSION.SDK_INT == 28 && k(th);
    }

    private static boolean k(Throwable th) {
        StackTraceElement[] stackTrace;
        if (!th.getClass().equals(RuntimeException.class) || (stackTrace = th.getStackTrace()) == null || stackTrace.length < 0) {
            return false;
        }
        return "_enableShutterSound".equals(stackTrace[0].getMethodName());
    }

    private void l(Throwable th) throws CameraAccessExceptionCompat {
        throw new CameraAccessExceptionCompat(10001, th);
    }

    @Override // defpackage.mu, iu.b
    public void a(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        this.a.registerAvailabilityCallback(executor, availabilityCallback);
    }

    @Override // defpackage.mu, iu.b
    public void b(CameraManager.AvailabilityCallback availabilityCallback) {
        this.a.unregisterAvailabilityCallback(availabilityCallback);
    }

    @Override // defpackage.mu, iu.b
    public CameraCharacteristics c(String str) throws CameraAccessExceptionCompat {
        try {
            return super.c(str);
        } catch (RuntimeException e) {
            if (j(e)) {
                l(e);
            }
            throw e;
        }
    }

    @Override // defpackage.mu, iu.b
    public void f(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        try {
            this.a.openCamera(str, executor, stateCallback);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        } catch (IllegalArgumentException e2) {
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            if (j(e4)) {
                l(e4);
            }
            throw e4;
        }
    }
}
