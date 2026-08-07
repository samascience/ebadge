package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class qd3 {
    public static boolean a(zs zsVar) {
        int[] iArr;
        if (Build.VERSION.SDK_INT >= 33 && (iArr = (int[]) zsVar.a(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES)) != null && iArr.length != 0) {
            for (int i : iArr) {
                if (i == 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
