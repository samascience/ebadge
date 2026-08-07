package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class o13 implements wv {
    private static boolean f() {
        return "Pixel 8".equalsIgnoreCase(Build.MODEL);
    }

    static boolean g(zs zsVar) {
        return f() && ((Integer) zsVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }
}
