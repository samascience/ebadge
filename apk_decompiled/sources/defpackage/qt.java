package defpackage;

import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import androidx.camera.core.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class qt implements ht.a {
    final CameraDevice a;
    final Object b;

    static class a {
        final Handler a;

        a(Handler handler) {
            this.a = handler;
        }
    }

    qt(CameraDevice cameraDevice, Object obj) {
        this.a = (CameraDevice) b52.g(cameraDevice);
        this.b = obj;
    }

    private static void b(CameraDevice cameraDevice, List list) {
        String id = cameraDevice.getId();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String strC = ((zx1) it.next()).c();
            if (strC != null && !strC.isEmpty()) {
                x.k("CameraDeviceCompat", "Camera " + id + ": Camera doesn't support physicalCameraId " + strC + ". Ignoring.");
            }
        }
    }

    static void c(CameraDevice cameraDevice, jn2 jn2Var) {
        b52.g(cameraDevice);
        b52.g(jn2Var);
        b52.g(jn2Var.e());
        List listC = jn2Var.c();
        if (listC == null) {
            throw new IllegalArgumentException("Invalid output configurations");
        }
        if (jn2Var.a() == null) {
            throw new IllegalArgumentException("Invalid executor");
        }
        b(cameraDevice, listC);
    }

    static List d(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((zx1) it.next()).d());
        }
        return arrayList;
    }
}
