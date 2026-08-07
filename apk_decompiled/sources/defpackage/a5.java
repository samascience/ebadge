package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class a5 implements v92 {
    static boolean f(zs zsVar) {
        return Build.BRAND.equalsIgnoreCase("SAMSUNG") && Build.VERSION.SDK_INT < 33 && ((Integer) zsVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }
}
