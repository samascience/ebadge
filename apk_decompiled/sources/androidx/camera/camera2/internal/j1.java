package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import defpackage.cs;
import defpackage.m13;
import defpackage.ow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class j1 {

    static class a {
        static CaptureRequest.Builder a(CameraDevice cameraDevice, TotalCaptureResult totalCaptureResult) throws CameraAccessException {
            return cameraDevice.createReprocessCaptureRequest(totalCaptureResult);
        }
    }

    private static void a(androidx.camera.core.impl.k kVar, CaptureRequest.Builder builder) {
        if (kVar.e().equals(androidx.camera.core.impl.x.a)) {
            return;
        }
        builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, kVar.e());
    }

    private static void b(CaptureRequest.Builder builder, Config config) {
        ow owVarD = ow.a.e(config).d();
        for (Config.a aVar : owVarD.e()) {
            CaptureRequest.Key key = (CaptureRequest.Key) aVar.d();
            try {
                builder.set(key, owVarD.a(aVar));
            } catch (IllegalArgumentException unused) {
                androidx.camera.core.x.c("Camera2CaptureRequestBuilder", "CaptureRequest.Key is not supported: " + key);
            }
        }
    }

    private static void c(CaptureRequest.Builder builder, int i, m13 m13Var) {
        for (Map.Entry entry : m13Var.a(i).entrySet()) {
            builder.set((CaptureRequest.Key) entry.getKey(), entry.getValue());
        }
    }

    static void d(androidx.camera.core.impl.k kVar, CaptureRequest.Builder builder) {
        if (kVar.h() == 1 || kVar.l() == 1) {
            builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
        } else if (kVar.h() == 2) {
            builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 2);
        } else if (kVar.l() == 2) {
            builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 1);
        }
    }

    public static CaptureRequest e(androidx.camera.core.impl.k kVar, CameraDevice cameraDevice, Map map, boolean z, m13 m13Var) throws CameraAccessException {
        CaptureRequest.Builder builderCreateCaptureRequest;
        if (cameraDevice == null) {
            return null;
        }
        List listG = g(kVar.i(), map);
        if (listG.isEmpty()) {
            return null;
        }
        cs csVarD = kVar.d();
        if (kVar.k() == 5 && csVarD != null && (csVarD.i() instanceof TotalCaptureResult)) {
            androidx.camera.core.x.a("Camera2CaptureRequestBuilder", "createReprocessCaptureRequest");
            builderCreateCaptureRequest = a.a(cameraDevice, (TotalCaptureResult) csVarD.i());
        } else {
            androidx.camera.core.x.a("Camera2CaptureRequestBuilder", "createCaptureRequest");
            if (kVar.k() == 5) {
                builderCreateCaptureRequest = cameraDevice.createCaptureRequest(z ? 1 : 2);
            } else {
                builderCreateCaptureRequest = cameraDevice.createCaptureRequest(kVar.k());
            }
        }
        if (z) {
            c(builderCreateCaptureRequest, kVar.k(), m13Var);
        }
        a(kVar, builderCreateCaptureRequest);
        d(kVar, builderCreateCaptureRequest);
        Config configG = kVar.g();
        Config.a aVar = androidx.camera.core.impl.k.i;
        if (configG.b(aVar)) {
            builderCreateCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, (Integer) kVar.g().a(aVar));
        }
        Config configG2 = kVar.g();
        Config.a aVar2 = androidx.camera.core.impl.k.j;
        if (configG2.b(aVar2)) {
            builderCreateCaptureRequest.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) kVar.g().a(aVar2)).byteValue()));
        }
        b(builderCreateCaptureRequest, kVar.g());
        Iterator it = listG.iterator();
        while (it.hasNext()) {
            builderCreateCaptureRequest.addTarget((Surface) it.next());
        }
        builderCreateCaptureRequest.setTag(kVar.j());
        return builderCreateCaptureRequest.build();
    }

    public static CaptureRequest f(androidx.camera.core.impl.k kVar, CameraDevice cameraDevice, m13 m13Var) throws CameraAccessException {
        if (cameraDevice == null) {
            return null;
        }
        CaptureRequest.Builder builderCreateCaptureRequest = cameraDevice.createCaptureRequest(kVar.k());
        c(builderCreateCaptureRequest, kVar.k(), m13Var);
        b(builderCreateCaptureRequest, kVar.g());
        return builderCreateCaptureRequest.build();
    }

    private static List g(List list, Map map) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Surface surface = (Surface) map.get((DeferrableSurface) it.next());
            if (surface == null) {
                throw new IllegalArgumentException("DeferrableSurface not in configuredSurfaceMap");
            }
            arrayList.add(surface);
        }
        return arrayList;
    }
}
