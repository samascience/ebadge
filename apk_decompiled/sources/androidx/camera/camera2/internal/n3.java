package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import defpackage.zs;

/* JADX INFO: loaded from: classes.dex */
abstract class n3 {
    public static boolean a(zs zsVar, int i) {
        int[] iArr = (int[]) zsVar.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }
}
