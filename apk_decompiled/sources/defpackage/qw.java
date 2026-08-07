package defpackage;

import android.hardware.camera2.CameraCharacteristics;

/* JADX INFO: loaded from: classes.dex */
public class qw implements v92 {
    static boolean f(zs zsVar) {
        Integer num = (Integer) zsVar.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }
}
