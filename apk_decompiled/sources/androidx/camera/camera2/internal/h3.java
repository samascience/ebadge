package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Looper;
import android.util.Range;
import androidx.lifecycle.LiveData;
import defpackage.im1;
import defpackage.u11;
import defpackage.xl3;
import defpackage.yr;
import defpackage.zs;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class h3 {
    private final h a;
    private final Executor b;
    private final i3 c;
    private final im1 d;
    final b e;
    private boolean f = false;
    private h.c g = new a();

    class a implements h.c {
        a() {
        }

        @Override // androidx.camera.camera2.internal.h.c
        public boolean a(TotalCaptureResult totalCaptureResult) {
            h3.this.e.a(totalCaptureResult);
            return false;
        }
    }

    interface b {
        void a(TotalCaptureResult totalCaptureResult);

        float b();

        float c();

        void d(yr.a aVar);

        void e();
    }

    h3(h hVar, zs zsVar, Executor executor) {
        this.a = hVar;
        this.b = executor;
        b bVarB = b(zsVar);
        this.e = bVarB;
        i3 i3Var = new i3(bVarB.b(), bVarB.c());
        this.c = i3Var;
        i3Var.f(1.0f);
        this.d = new im1(u11.e(i3Var));
        hVar.r(this.g);
    }

    private static b b(zs zsVar) {
        return e(zsVar) ? new androidx.camera.camera2.internal.a(zsVar) : new b2(zsVar);
    }

    private static Range c(zs zsVar) {
        try {
            return (Range) zsVar.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
        } catch (AssertionError e) {
            androidx.camera.core.x.l("ZoomControl", "AssertionError, fail to get camera characteristic.", e);
            return null;
        }
    }

    static boolean e(zs zsVar) {
        return Build.VERSION.SDK_INT >= 30 && c(zsVar) != null;
    }

    private void g(xl3 xl3Var) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.d.o(xl3Var);
        } else {
            this.d.m(xl3Var);
        }
    }

    void a(yr.a aVar) {
        this.e.d(aVar);
    }

    LiveData d() {
        return this.d;
    }

    void f(boolean z) {
        xl3 xl3VarE;
        if (this.f == z) {
            return;
        }
        this.f = z;
        if (z) {
            return;
        }
        synchronized (this.c) {
            this.c.f(1.0f);
            xl3VarE = u11.e(this.c);
        }
        g(xl3VarE);
        this.e.e();
        this.a.f0();
    }
}
