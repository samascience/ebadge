package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class oa1 implements v92 {
    static boolean f(zs zsVar) {
        Integer num = (Integer) zsVar.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }

    static boolean g(zs zsVar) {
        return Build.VERSION.SDK_INT < 29 && f(zsVar);
    }
}
