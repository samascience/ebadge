package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageWriter;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import defpackage.am3;
import defpackage.as;
import defpackage.g11;
import defpackage.k11;
import defpackage.m00;
import defpackage.ub1;
import defpackage.x01;
import defpackage.xa0;
import defpackage.xh2;
import defpackage.yl3;
import defpackage.zl3;
import defpackage.zs;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class m3 implements j3 {
    private final zs a;
    final am3 b;
    private boolean c = false;
    private boolean d = false;
    private boolean e;
    private boolean f;
    androidx.camera.core.b0 g;
    private as h;
    private DeferrableSurface i;
    ImageWriter j;

    class a extends CameraCaptureSession.StateCallback {
        a() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            Surface inputSurface = cameraCaptureSession.getInputSurface();
            if (inputSurface != null) {
                m3.this.j = g11.c(inputSurface, 1);
            }
        }
    }

    m3(zs zsVar) {
        this.e = false;
        this.f = false;
        this.a = zsVar;
        this.e = n3.a(zsVar, 4);
        this.f = xa0.a(zl3.class) != null;
        this.b = new am3(3, new xh2.a() { // from class: androidx.camera.camera2.internal.k3
            @Override // xh2.a
            public final void a(Object obj) {
                ((androidx.camera.core.v) obj).close();
            }
        });
    }

    private void j() {
        am3 am3Var = this.b;
        while (!am3Var.isEmpty()) {
            ((androidx.camera.core.v) am3Var.a()).close();
        }
        DeferrableSurface deferrableSurface = this.i;
        if (deferrableSurface != null) {
            androidx.camera.core.b0 b0Var = this.g;
            if (b0Var != null) {
                deferrableSurface.k().a(new yl3(b0Var), androidx.camera.core.impl.utils.executor.c.e());
                this.g = null;
            }
            deferrableSurface.d();
            this.i = null;
        }
        ImageWriter imageWriter = this.j;
        if (imageWriter != null) {
            imageWriter.close();
            this.j = null;
        }
    }

    private Map k(zs zsVar) {
        StreamConfigurationMap streamConfigurationMap;
        try {
            streamConfigurationMap = (StreamConfigurationMap) zsVar.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        } catch (AssertionError e) {
            androidx.camera.core.x.c("ZslControlImpl", "Failed to retrieve StreamConfigurationMap, error = " + e.getMessage());
            streamConfigurationMap = null;
        }
        if (streamConfigurationMap == null || streamConfigurationMap.getInputFormats() == null) {
            return new HashMap();
        }
        HashMap map = new HashMap();
        for (int i : streamConfigurationMap.getInputFormats()) {
            Size[] inputSizes = streamConfigurationMap.getInputSizes(i);
            if (inputSizes != null) {
                Arrays.sort(inputSizes, new m00(true));
                map.put(Integer.valueOf(i), inputSizes[0]);
            }
        }
        return map;
    }

    private boolean l(zs zsVar, int i) {
        int[] validOutputFormatsForInput;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) zsVar.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null || (validOutputFormatsForInput = streamConfigurationMap.getValidOutputFormatsForInput(i)) == null) {
            return false;
        }
        for (int i2 : validOutputFormatsForInput) {
            if (i2 == 256) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(x01 x01Var) {
        try {
            androidx.camera.core.v vVarC = x01Var.c();
            if (vVarC != null) {
                this.b.b(vVarC);
            }
        } catch (IllegalStateException e) {
            androidx.camera.core.x.c("ZslControlImpl", "Failed to acquire latest image IllegalStateException = " + e.getMessage());
        }
    }

    @Override // androidx.camera.camera2.internal.j3
    public void a(SessionConfig.b bVar) {
        j();
        if (this.c || this.f) {
            return;
        }
        Map mapK = k(this.a);
        if (this.e && !mapK.isEmpty() && mapK.containsKey(34) && l(this.a, 34)) {
            Size size = (Size) mapK.get(34);
            androidx.camera.core.y yVar = new androidx.camera.core.y(size.getWidth(), size.getHeight(), 34, 9);
            this.h = yVar.n();
            this.g = new androidx.camera.core.b0(yVar);
            yVar.f(new x01.a() { // from class: androidx.camera.camera2.internal.l3
                @Override // x01.a
                public final void a(x01 x01Var) {
                    this.a.m(x01Var);
                }
            }, androidx.camera.core.impl.utils.executor.c.d());
            k11 k11Var = new k11(this.g.a(), new Size(this.g.getWidth(), this.g.getHeight()), 34);
            this.i = k11Var;
            androidx.camera.core.b0 b0Var = this.g;
            ub1 ub1VarK = k11Var.k();
            Objects.requireNonNull(b0Var);
            ub1VarK.a(new yl3(b0Var), androidx.camera.core.impl.utils.executor.c.e());
            bVar.m(this.i);
            bVar.e(this.h);
            bVar.l(new a());
            bVar.w(new InputConfiguration(this.g.getWidth(), this.g.getHeight(), this.g.d()));
        }
    }

    @Override // androidx.camera.camera2.internal.j3
    public boolean b() {
        return this.c;
    }

    @Override // androidx.camera.camera2.internal.j3
    public boolean c() {
        return this.d;
    }

    @Override // androidx.camera.camera2.internal.j3
    public void d(boolean z) {
        this.d = z;
    }

    @Override // androidx.camera.camera2.internal.j3
    public void e(boolean z) {
        this.c = z;
    }

    @Override // androidx.camera.camera2.internal.j3
    public androidx.camera.core.v f() {
        try {
            return (androidx.camera.core.v) this.b.a();
        } catch (NoSuchElementException unused) {
            androidx.camera.core.x.c("ZslControlImpl", "dequeueImageFromBuffer no such element");
            return null;
        }
    }

    @Override // androidx.camera.camera2.internal.j3
    public boolean g(androidx.camera.core.v vVar) {
        Image imageS0 = vVar.s0();
        ImageWriter imageWriter = this.j;
        if (imageWriter != null && imageS0 != null) {
            try {
                g11.d(imageWriter, imageS0);
                return true;
            } catch (IllegalStateException e) {
                androidx.camera.core.x.c("ZslControlImpl", "enqueueImageToImageWriter throws IllegalStateException = " + e.getMessage());
            }
        }
        return false;
    }
}
