package defpackage;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class mu implements iu.b {
    final CameraManager a;
    final Object b;

    static final class a {
        final Map a = new HashMap();
        final Handler b;

        a(Handler handler) {
            this.b = handler;
        }
    }

    mu(Context context, Object obj) {
        this.a = (CameraManager) context.getSystemService("camera");
        this.b = obj;
    }

    static mu h(Context context, Handler handler) {
        return new mu(context, new a(handler));
    }

    @Override // iu.b
    public void a(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        iu.a aVar;
        if (executor == null) {
            throw new IllegalArgumentException("executor was null");
        }
        a aVar2 = (a) this.b;
        if (availabilityCallback != null) {
            synchronized (aVar2.a) {
                try {
                    aVar = (iu.a) aVar2.a.get(availabilityCallback);
                    if (aVar == null) {
                        aVar = new iu.a(executor, availabilityCallback);
                        aVar2.a.put(availabilityCallback, aVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            aVar = null;
        }
        this.a.registerAvailabilityCallback(aVar, aVar2.b);
    }

    @Override // iu.b
    public void b(CameraManager.AvailabilityCallback availabilityCallback) {
        iu.a aVar;
        if (availabilityCallback != null) {
            a aVar2 = (a) this.b;
            synchronized (aVar2.a) {
                aVar = (iu.a) aVar2.a.remove(availabilityCallback);
            }
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.g();
        }
        this.a.unregisterAvailabilityCallback(aVar);
    }

    @Override // iu.b
    public CameraCharacteristics c(String str) throws CameraAccessExceptionCompat {
        try {
            return this.a.getCameraCharacteristics(str);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        }
    }

    @Override // iu.b
    public Set e() {
        return Collections.emptySet();
    }

    @Override // iu.b
    public void f(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        b52.g(executor);
        b52.g(stateCallback);
        try {
            this.a.openCamera(str, new ht.b(executor, stateCallback), ((a) this.b).b);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        }
    }

    @Override // iu.b
    public String[] g() throws CameraAccessExceptionCompat {
        try {
            return this.a.getCameraIdList();
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        }
    }
}
