package androidx.camera.core;

import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.camera.core.impl.CameraValidator;
import androidx.camera.core.impl.MetadataHolderService;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.b52;
import defpackage.os0;
import defpackage.ru;
import defpackage.st;
import defpackage.t30;
import defpackage.tu;
import defpackage.ub1;
import defpackage.ut;
import defpackage.wu;
import defpackage.zv0;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class CameraX {
    private static final Object o = new Object();
    private static final SparseArray p = new SparseArray();
    private final k c;
    private final Executor d;
    private final Handler e;
    private final HandlerThread f;
    private ut g;
    private st h;
    private UseCaseConfigFactory i;
    private a0 j;
    private final ub1 k;
    private final Integer n;
    final ru a = new ru();
    private final Object b = new Object();
    private InternalInitState l = InternalInitState.UNINITIALIZED;
    private ub1 m = os0.p(null);

    private enum InternalInitState {
        UNINITIALIZED,
        INITIALIZING,
        INITIALIZING_ERROR,
        INITIALIZED,
        SHUTDOWN
    }

    public CameraX(Context context, k.b bVar) {
        if (bVar != null) {
            this.c = bVar.getCameraXConfig();
        } else {
            k.b bVarG = g(context);
            if (bVarG == null) {
                throw new IllegalStateException("CameraX is not configured properly. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            }
            this.c = bVarG.getCameraXConfig();
        }
        Executor executorZ = this.c.Z(null);
        Handler handlerE0 = this.c.e0(null);
        this.d = executorZ == null ? new j() : executorZ;
        if (handlerE0 == null) {
            HandlerThread handlerThread = new HandlerThread("CameraX-scheduler", 10);
            this.f = handlerThread;
            handlerThread.start();
            this.e = zv0.a(handlerThread.getLooper());
        } else {
            this.f = null;
            this.e = handlerE0;
        }
        Integer num = (Integer) this.c.f(k.O, null);
        this.n = num;
        j(num);
        this.j = new a0.a(this.c.c0()).a();
        this.k = l(context);
    }

    private static k.b g(Context context) {
        ComponentCallbacks2 componentCallbacks2B = t30.b(context);
        if (componentCallbacks2B instanceof k.b) {
            return (k.b) componentCallbacks2B;
        }
        try {
            Context contextA = t30.a(context);
            Bundle bundle = contextA.getPackageManager().getServiceInfo(new ComponentName(contextA, (Class<?>) MetadataHolderService.class), 640).metaData;
            String string = bundle != null ? bundle.getString("androidx.camera.core.impl.MetadataHolderService.DEFAULT_CONFIG_PROVIDER") : null;
            if (string != null) {
                return (k.b) Class.forName(string).getDeclaredConstructor(null).newInstance(null);
            }
            x.c("CameraX", "No default CameraXConfig.Provider specified in meta-data. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            x.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (ClassNotFoundException e2) {
            e = e2;
            x.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (IllegalAccessException e3) {
            e = e3;
            x.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (InstantiationException e4) {
            e = e4;
            x.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (NoSuchMethodException e5) {
            e = e5;
            x.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (NullPointerException e6) {
            e = e6;
            x.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (InvocationTargetException e7) {
            e = e7;
            x.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        }
    }

    private static void j(Integer num) {
        synchronized (o) {
            try {
                if (num == null) {
                    return;
                }
                b52.c(num.intValue(), 3, 6, "minLogLevel");
                SparseArray sparseArray = p;
                sparseArray.put(num.intValue(), Integer.valueOf(sparseArray.get(num.intValue()) != null ? 1 + ((Integer) sparseArray.get(num.intValue())).intValue() : 1));
                q();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void k(final Executor executor, final long j, final int i, final Context context, final CallbackToFutureAdapter.a aVar) {
        executor.execute(new Runnable() { // from class: ev
            @Override // java.lang.Runnable
            public final void run() {
                this.a.n(context, executor, aVar, j, i);
            }
        });
    }

    private ub1 l(final Context context) {
        ub1 ub1VarA;
        synchronized (this.b) {
            b52.j(this.l == InternalInitState.UNINITIALIZED, "CameraX.initInternal() should only be called once per instance");
            this.l = InternalInitState.INITIALIZING;
            ub1VarA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: dv
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return this.a.o(context, aVar);
                }
            });
        }
        return ub1VarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(Executor executor, long j, int i, Context context, CallbackToFutureAdapter.a aVar) {
        k(executor, j, i + 1, context, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:36:0x010b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0112  */
    /* JADX WARN: Code duplicated, block: B:39:0x0116  */
    /* JADX WARN: Code duplicated, block: B:40:0x0142  */
    /* JADX WARN: Code duplicated, block: B:42:0x0146  */
    /* JADX WARN: Code duplicated, block: B:43:0x014a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:39:0x0116, please report this as an issue */
    public /* synthetic */ void n(Context context, final Executor executor, final CallbackToFutureAdapter.a aVar, final long j, final int i) {
        a0.c cVarC;
        final Context contextA = t30.a(context);
        try {
            ut.a aVarA0 = this.c.a0(null);
            if (aVarA0 == null) {
                throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing CameraFactory."));
            }
            wu wuVarA = wu.a(this.d, this.e);
            tu tuVarY = this.c.Y(null);
            this.g = aVarA0.a(contextA, wuVarA, tuVarY, this.c.b0());
            st.a aVarD0 = this.c.d0(null);
            if (aVarD0 == null) {
                throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing CameraDeviceSurfaceManager."));
            }
            this.h = aVarD0.a(contextA, this.g.c(), this.g.a());
            UseCaseConfigFactory.b bVarF0 = this.c.f0(null);
            if (bVarF0 == null) {
                throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing UseCaseConfigFactory."));
            }
            this.i = bVarF0.a(contextA);
            if (executor instanceof j) {
                ((j) executor).c(this.g);
            }
            this.a.b(this.g);
            CameraValidator.a(contextA, this.a, tuVarY);
            p();
            aVar.c(null);
        } catch (InitializationException e) {
            e = e;
            cVarC = this.j.c(new androidx.camera.core.impl.h(j, i, e));
            if (!cVarC.d() && i < Integer.MAX_VALUE) {
                x.l("CameraX", "Retry init. Start time " + j + " current time " + SystemClock.elapsedRealtime(), e);
                zv0.b(this.e, new Runnable() { // from class: fv
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.m(executor, j, i, contextA, aVar);
                    }
                }, "retry_token", cVarC.b());
                return;
            }
            synchronized (this.b) {
                this.l = InternalInitState.INITIALIZING_ERROR;
            }
            if (cVarC.c()) {
                p();
                aVar.c(null);
                return;
            }
            if (!(e instanceof CameraValidator.CameraIdListIncorrectException)) {
                if (e instanceof InitializationException) {
                    aVar.f(e);
                    return;
                } else {
                    aVar.f(new InitializationException(e));
                    return;
                }
            }
            String str = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((CameraValidator.CameraIdListIncorrectException) e).getAvailableCameraCount();
            x.d("CameraX", str, e);
            aVar.f(new InitializationException(new CameraUnavailableException(3, str)));
        } catch (CameraValidator.CameraIdListIncorrectException e2) {
            e = e2;
            cVarC = this.j.c(new androidx.camera.core.impl.h(j, i, e));
            if (!cVarC.d()) {
            }
            synchronized (this.b) {
                this.l = InternalInitState.INITIALIZING_ERROR;
                if (cVarC.c()) {
                    p();
                    aVar.c(null);
                    return;
                }
                if (!(e instanceof CameraValidator.CameraIdListIncorrectException)) {
                    if (e instanceof InitializationException) {
                        aVar.f(e);
                        return;
                    } else {
                        aVar.f(new InitializationException(e));
                        return;
                    }
                }
                String str2 = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((CameraValidator.CameraIdListIncorrectException) e).getAvailableCameraCount();
                x.d("CameraX", str2, e);
                aVar.f(new InitializationException(new CameraUnavailableException(3, str2)));
            }
        } catch (RuntimeException e3) {
            e = e3;
            cVarC = this.j.c(new androidx.camera.core.impl.h(j, i, e));
            if (!cVarC.d()) {
            }
            synchronized (this.b) {
                this.l = InternalInitState.INITIALIZING_ERROR;
                if (cVarC.c()) {
                    p();
                    aVar.c(null);
                    return;
                }
                if (!(e instanceof CameraValidator.CameraIdListIncorrectException)) {
                    if (e instanceof InitializationException) {
                        aVar.f(e);
                        return;
                    } else {
                        aVar.f(new InitializationException(e));
                        return;
                    }
                }
                String str3 = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((CameraValidator.CameraIdListIncorrectException) e).getAvailableCameraCount();
                x.d("CameraX", str3, e);
                aVar.f(new InitializationException(new CameraUnavailableException(3, str3)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o(Context context, CallbackToFutureAdapter.a aVar) {
        k(this.d, SystemClock.elapsedRealtime(), 1, context, aVar);
        return "CameraX initInternal";
    }

    private void p() {
        synchronized (this.b) {
            this.l = InternalInitState.INITIALIZED;
        }
    }

    private static void q() {
        SparseArray sparseArray = p;
        if (sparseArray.size() == 0) {
            x.h();
            return;
        }
        if (sparseArray.get(3) != null) {
            x.i(3);
            return;
        }
        if (sparseArray.get(4) != null) {
            x.i(4);
        } else if (sparseArray.get(5) != null) {
            x.i(5);
        } else if (sparseArray.get(6) != null) {
            x.i(6);
        }
    }

    public st d() {
        st stVar = this.h;
        if (stVar != null) {
            return stVar;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    public ut e() {
        ut utVar = this.g;
        if (utVar != null) {
            return utVar;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    public ru f() {
        return this.a;
    }

    public UseCaseConfigFactory h() {
        UseCaseConfigFactory useCaseConfigFactory = this.i;
        if (useCaseConfigFactory != null) {
            return useCaseConfigFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    public ub1 i() {
        return this.k;
    }
}
