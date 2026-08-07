package defpackage;

import android.hardware.camera2.CameraManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class b8 {
    public static void a(CameraManager.AvailabilityCallback availabilityCallback) {
        availabilityCallback.onCameraAccessPrioritiesChanged();
    }
}
