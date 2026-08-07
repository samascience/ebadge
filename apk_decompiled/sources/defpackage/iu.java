package defpackage;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.util.ArrayMap;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class iu {
    private final b a;
    private final Map b = new ArrayMap(4);

    static final class a extends CameraManager.AvailabilityCallback {
        private final Executor a;
        final CameraManager.AvailabilityCallback b;
        private final Object c = new Object();
        private boolean d = false;

        a(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
            this.a = executor;
            this.b = availabilityCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            b8.a(this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(String str) {
            this.b.onCameraAvailable(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(String str) {
            this.b.onCameraUnavailable(str);
        }

        void g() {
            synchronized (this.c) {
                this.d = true;
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAccessPrioritiesChanged() {
            synchronized (this.c) {
                try {
                    if (!this.d) {
                        this.a.execute(new Runnable() { // from class: gu
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.d();
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(final String str) {
            synchronized (this.c) {
                try {
                    if (!this.d) {
                        this.a.execute(new Runnable() { // from class: fu
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.e(str);
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(final String str) {
            synchronized (this.c) {
                try {
                    if (!this.d) {
                        this.a.execute(new Runnable() { // from class: hu
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.f(str);
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public interface b {
        static b d(Context context, Handler handler) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                return new lu(context);
            }
            if (i >= 29) {
                return new ku(context);
            }
            return i >= 28 ? ju.i(context) : mu.h(context, handler);
        }

        void a(Executor executor, CameraManager.AvailabilityCallback availabilityCallback);

        void b(CameraManager.AvailabilityCallback availabilityCallback);

        CameraCharacteristics c(String str);

        Set e();

        void f(String str, Executor executor, CameraDevice.StateCallback stateCallback);

        String[] g();
    }

    private iu(b bVar) {
        this.a = bVar;
    }

    public static iu a(Context context) {
        return b(context, of1.a());
    }

    public static iu b(Context context, Handler handler) {
        return new iu(b.d(context, handler));
    }

    public zs c(String str) {
        zs zsVarD;
        synchronized (this.b) {
            zsVarD = (zs) this.b.get(str);
            if (zsVarD == null) {
                try {
                    zsVarD = zs.d(this.a.c(str), str);
                    this.b.put(str, zsVarD);
                } catch (AssertionError e) {
                    throw new CameraAccessExceptionCompat(CameraAccessExceptionCompat.CAMERA_CHARACTERISTICS_CREATION_ERROR, e.getMessage(), e);
                }
            }
        }
        return zsVarD;
    }

    public String[] d() {
        return this.a.g();
    }

    public Set e() {
        return this.a.e();
    }

    public void f(String str, Executor executor, CameraDevice.StateCallback stateCallback) {
        this.a.f(str, executor, stateCallback);
    }

    public void g(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        this.a.a(executor, availabilityCallback);
    }

    public void h(CameraManager.AvailabilityCallback availabilityCallback) {
        this.a.b(availabilityCallback);
    }
}
