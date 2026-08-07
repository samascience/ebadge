package androidx.camera.core.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import defpackage.ru;
import defpackage.tu;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class CameraValidator {
    private static final tu a = new tu.a().b(2).a();

    public static class CameraIdListIncorrectException extends Exception {
        private int mAvailableCameraCount;

        public CameraIdListIncorrectException(String str, int i, Throwable th) {
            super(str, th);
            this.mAvailableCameraCount = i;
        }

        public int getAvailableCameraCount() {
            return this.mAvailableCameraCount;
        }
    }

    private static class a {
        static int a(Context context) {
            return context.getDeviceId();
        }
    }

    public static void a(Context context, ru ruVar, tu tuVar) throws CameraIdListIncorrectException {
        Integer numD;
        int i = 0;
        IllegalArgumentException illegalArgumentException = null;
        if (Build.VERSION.SDK_INT >= 34 && a.a(context) != 0) {
            LinkedHashSet linkedHashSetA = ruVar.a();
            if (linkedHashSetA.isEmpty()) {
                throw new CameraIdListIncorrectException("No cameras available", 0, null);
            }
            androidx.camera.core.x.a("CameraValidator", "Virtual device with ID: " + a.a(context) + " has " + linkedHashSetA.size() + " cameras. Skipping validation.");
            return;
        }
        if (tuVar != null) {
            try {
                numD = tuVar.d();
                if (numD == null) {
                    androidx.camera.core.x.k("CameraValidator", "No lens facing info in the availableCamerasSelector, don't verify the camera lens facing.");
                    return;
                }
            } catch (IllegalStateException e) {
                androidx.camera.core.x.d("CameraValidator", "Cannot get lens facing from the availableCamerasSelector don't verify the camera lens facing.", e);
                return;
            }
        } else {
            numD = null;
        }
        androidx.camera.core.x.a("CameraValidator", "Verifying camera lens facing on " + Build.DEVICE + ", lensFacingInteger: " + numD);
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera") && (tuVar == null || numD.intValue() == 1)) {
                tu.d.e(ruVar.a());
                i = 1;
            }
        } catch (IllegalArgumentException e2) {
            illegalArgumentException = e2;
            androidx.camera.core.x.l("CameraValidator", "Camera LENS_FACING_BACK verification failed", illegalArgumentException);
        }
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera.front") && (tuVar == null || numD.intValue() == 0)) {
                tu.c.e(ruVar.a());
                i++;
            }
        } catch (IllegalArgumentException e3) {
            illegalArgumentException = e3;
            androidx.camera.core.x.l("CameraValidator", "Camera LENS_FACING_FRONT verification failed", illegalArgumentException);
        }
        try {
            a.e(ruVar.a());
            androidx.camera.core.x.a("CameraValidator", "Found a LENS_FACING_EXTERNAL camera");
            i++;
        } catch (IllegalArgumentException unused) {
        }
        if (illegalArgumentException == null) {
            return;
        }
        androidx.camera.core.x.c("CameraValidator", "Camera LensFacing verification failed, existing cameras: " + ruVar.a());
        throw new CameraIdListIncorrectException("Expected camera missing from device.", i, illegalArgumentException);
    }
}
