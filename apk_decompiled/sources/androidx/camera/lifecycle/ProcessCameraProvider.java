package androidx.camera.lifecycle;

import android.content.Context;
import androidx.camera.core.CameraX;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.g;
import androidx.camera.core.impl.utils.executor.c;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.k;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import defpackage.ab;
import defpackage.ar0;
import defpackage.b52;
import defpackage.bs0;
import defpackage.cs0;
import defpackage.ct;
import defpackage.db1;
import defpackage.dt;
import defpackage.gt;
import defpackage.ih2;
import defpackage.k83;
import defpackage.lv2;
import defpackage.os0;
import defpackage.p31;
import defpackage.qj0;
import defpackage.st;
import defpackage.t23;
import defpackage.t30;
import defpackage.te3;
import defpackage.tu;
import defpackage.ub1;
import defpackage.wr0;
import defpackage.wt;
import defpackage.y70;
import defpackage.yt;
import defpackage.zr;
import defpackage.zt;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.d;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessCameraProvider {
    public static final Companion i = new Companion(null);
    private static final ProcessCameraProvider j = new ProcessCameraProvider();
    private final Object a = new Object();
    private k.b b;
    private ub1 c;
    private ub1 d;
    private final LifecycleCameraRepository e;
    private CameraX f;
    private Context g;
    private final Map h;

    public static final class Companion {
        public /* synthetic */ Companion(y70 y70Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ProcessCameraProvider c(ar0 ar0Var, Object obj) {
            p31.f(ar0Var, "$tmp0");
            return (ProcessCameraProvider) ar0Var.invoke(obj);
        }

        public final ub1 b(final Context context) {
            p31.f(context, "context");
            b52.g(context);
            ub1 ub1VarM = ProcessCameraProvider.j.m(context);
            final ar0 ar0Var = new ar0() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$Companion$getInstance$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // defpackage.ar0
                public final ProcessCameraProvider invoke(CameraX cameraX) {
                    ProcessCameraProvider processCameraProvider = ProcessCameraProvider.j;
                    p31.e(cameraX, "cameraX");
                    processCameraProvider.r(cameraX);
                    ProcessCameraProvider processCameraProvider2 = ProcessCameraProvider.j;
                    Context contextA = t30.a(context);
                    p31.e(contextA, "getApplicationContext(context)");
                    processCameraProvider2.s(contextA);
                    return ProcessCameraProvider.j;
                }
            };
            ub1 ub1VarG = os0.G(ub1VarM, new wr0() { // from class: u62
                @Override // defpackage.wr0
                public final Object apply(Object obj) {
                    return ProcessCameraProvider.Companion.c(ar0Var, obj);
                }
            }, c.b());
            p31.e(ub1VarG, "context: Context): Liste…tExecutor()\n            )");
            return ub1VarG;
        }

        private Companion() {
        }
    }

    public static final class a implements bs0 {
        final /* synthetic */ CallbackToFutureAdapter.a a;
        final /* synthetic */ CameraX b;

        a(CallbackToFutureAdapter.a aVar, CameraX cameraX) {
            this.a = aVar;
            this.b = cameraX;
        }

        @Override // defpackage.bs0
        public void a(Throwable th) {
            p31.f(th, "t");
            this.a.f(th);
        }

        @Override // defpackage.bs0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r2) {
            this.a.c(this.b);
        }
    }

    private ProcessCameraProvider() {
        ub1 ub1VarP = os0.p(null);
        p31.e(ub1VarP, "immediateFuture<Void>(null)");
        this.d = ub1VarP;
        this.e = new LifecycleCameraRepository();
        this.h = new HashMap();
    }

    private final g i(tu tuVar, yt ytVar) {
        g gVar = null;
        for (Object obj : tuVar.c()) {
            p31.e(obj, "cameraSelector.cameraFilterSet");
            wt wtVar = (wt) obj;
            if (!p31.a(wtVar.a(), wt.a)) {
                ct ctVarA = qj0.a(wtVar.a());
                Context context = this.g;
                p31.c(context);
                g gVarB = ctVarA.b(ytVar, context);
                if (gVarB == null) {
                    continue;
                } else {
                    if (gVar != null) {
                        throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
                    }
                    gVar = gVarB;
                }
            }
        }
        return gVar == null ? dt.a() : gVar;
    }

    private final int k() {
        CameraX cameraX = this.f;
        if (cameraX == null) {
            return 0;
        }
        p31.c(cameraX);
        return cameraX.e().d().a();
    }

    public static final ub1 l(Context context) {
        return i.b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ub1 m(Context context) {
        synchronized (this.a) {
            ub1 ub1Var = this.c;
            if (ub1Var != null) {
                p31.d(ub1Var, "null cannot be cast to non-null type com.google.common.util.concurrent.ListenableFuture<androidx.camera.core.CameraX>");
                return ub1Var;
            }
            final CameraX cameraX = new CameraX(context, this.b);
            ub1 ub1VarA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: s62
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return ProcessCameraProvider.n(this.a, cameraX, aVar);
                }
            });
            this.c = ub1VarA;
            p31.d(ub1VarA, "null cannot be cast to non-null type com.google.common.util.concurrent.ListenableFuture<androidx.camera.core.CameraX>");
            return ub1VarA;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object n(ProcessCameraProvider processCameraProvider, final CameraX cameraX, CallbackToFutureAdapter.a aVar) {
        p31.f(processCameraProvider, "this$0");
        p31.f(cameraX, "$cameraX");
        p31.f(aVar, "completer");
        synchronized (processCameraProvider.a) {
            cs0 cs0VarB = cs0.b(processCameraProvider.d);
            final ar0 ar0Var = new ar0() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$getOrCreateCameraXInstance$1$1$1$future$1
                {
                    super(1);
                }

                @Override // defpackage.ar0
                public final ub1 invoke(Void r1) {
                    return cameraX.i();
                }
            };
            cs0 cs0VarF = cs0VarB.f(new ab() { // from class: t62
                @Override // defpackage.ab
                public final ub1 apply(Object obj) {
                    return ProcessCameraProvider.o(ar0Var, obj);
                }
            }, c.b());
            p31.e(cs0VarF, "cameraX = CameraX(contex…                        )");
            os0.j(cs0VarF, new a(aVar, cameraX), c.b());
            k83 k83Var = k83.a;
        }
        return "ProcessCameraProvider-initializeCameraX";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ub1 o(ar0 ar0Var, Object obj) {
        p31.f(ar0Var, "$tmp0");
        return (ub1) ar0Var.invoke(obj);
    }

    private final void q(int i2) {
        CameraX cameraX = this.f;
        if (cameraX == null) {
            return;
        }
        p31.c(cameraX);
        cameraX.e().d().d(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(CameraX cameraX) {
        this.f = cameraX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(Context context) {
        this.g = context;
    }

    public final zr g(db1 db1Var, tu tuVar, UseCase... useCaseArr) {
        p31.f(db1Var, "lifecycleOwner");
        p31.f(tuVar, "cameraSelector");
        p31.f(useCaseArr, "useCases");
        if (k() == 2) {
            throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
        }
        q(1);
        return h(db1Var, tuVar, null, j.j(), (UseCase[]) Arrays.copyOf(useCaseArr, useCaseArr.length));
    }

    public final zr h(db1 db1Var, tu tuVar, te3 te3Var, List list, UseCase... useCaseArr) {
        p31.f(db1Var, "lifecycleOwner");
        p31.f(tuVar, "cameraSelector");
        p31.f(list, "effects");
        p31.f(useCaseArr, "useCases");
        t23.a();
        CameraX cameraX = this.f;
        p31.c(cameraX);
        CameraInternal cameraInternalE = tuVar.e(cameraX.f().a());
        p31.e(cameraInternalE, "cameraSelector.select(mC…cameraRepository.cameras)");
        yt ytVarJ = j(tuVar);
        p31.d(ytVarJ, "null cannot be cast to non-null type androidx.camera.core.impl.RestrictedCameraInfo");
        ih2 ih2Var = (ih2) ytVarJ;
        LifecycleCamera lifecycleCameraC = this.e.c(db1Var, CameraUseCaseAdapter.z(ih2Var));
        Collection collectionE = this.e.e();
        for (UseCase useCase : d.s(useCaseArr)) {
            for (Object obj : collectionE) {
                p31.e(obj, "lifecycleCameras");
                LifecycleCamera lifecycleCamera = (LifecycleCamera) obj;
                if (lifecycleCamera.r(useCase) && !p31.a(lifecycleCamera, lifecycleCameraC)) {
                    lv2 lv2Var = lv2.a;
                    String str = String.format("Use case %s already bound to a different lifecycle.", Arrays.copyOf(new Object[]{useCase}, 1));
                    p31.e(str, "format(format, *args)");
                    throw new IllegalStateException(str);
                }
            }
        }
        if (lifecycleCameraC == null) {
            LifecycleCameraRepository lifecycleCameraRepository = this.e;
            CameraX cameraX2 = this.f;
            p31.c(cameraX2);
            gt gtVarD = cameraX2.e().d();
            CameraX cameraX3 = this.f;
            p31.c(cameraX3);
            st stVarD = cameraX3.d();
            CameraX cameraX4 = this.f;
            p31.c(cameraX4);
            lifecycleCameraC = lifecycleCameraRepository.b(db1Var, new CameraUseCaseAdapter(cameraInternalE, ih2Var, gtVarD, stVarD, cameraX4.h()));
        }
        if (useCaseArr.length == 0) {
            p31.c(lifecycleCameraC);
            return lifecycleCameraC;
        }
        LifecycleCameraRepository lifecycleCameraRepository2 = this.e;
        p31.c(lifecycleCameraC);
        List listM = j.m(Arrays.copyOf(useCaseArr, useCaseArr.length));
        CameraX cameraX5 = this.f;
        p31.c(cameraX5);
        lifecycleCameraRepository2.a(lifecycleCameraC, te3Var, list, listM, cameraX5.e().d());
        return lifecycleCameraC;
    }

    public yt j(tu tuVar) {
        Object ih2Var;
        p31.f(tuVar, "cameraSelector");
        CameraX cameraX = this.f;
        p31.c(cameraX);
        zt ztVarN = tuVar.e(cameraX.f().a()).n();
        p31.e(ztVarN, "cameraSelector.select(mC…meras).cameraInfoInternal");
        g gVarI = i(tuVar, ztVarN);
        CameraUseCaseAdapter.a aVarA = CameraUseCaseAdapter.a.a(ztVarN.d(), gVarI.Q());
        p31.e(aVarA, "create(\n                …atibilityId\n            )");
        synchronized (this.a) {
            try {
                ih2Var = this.h.get(aVarA);
                if (ih2Var == null) {
                    ih2Var = new ih2(ztVarN, gVarI);
                    this.h.put(aVarA, ih2Var);
                }
                k83 k83Var = k83.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return (yt) ih2Var;
    }

    public boolean p(UseCase useCase) {
        p31.f(useCase, "useCase");
        for (Object obj : this.e.e()) {
            p31.e(obj, "mLifecycleCameraRepository.lifecycleCameras");
            if (((LifecycleCamera) obj).r(useCase)) {
                return true;
            }
        }
        return false;
    }

    public void t() {
        t23.a();
        q(0);
        this.e.k();
    }
}
