package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class dw implements v92 {
    static boolean f(zs zsVar) {
        String str = Build.HARDWARE;
        return ("samsungexynos7420".equalsIgnoreCase(str) || "universal7420".equalsIgnoreCase(str)) && ((Integer) zsVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 1;
    }
}
