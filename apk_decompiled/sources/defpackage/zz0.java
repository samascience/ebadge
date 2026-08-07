package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class zz0 implements ga3 {
    public static final List a = Arrays.asList("sm-a260f", "sm-j530f", "sm-j600g", "sm-j701f", "sm-g610f", "sm-j710mn");

    static boolean f(zs zsVar) {
        return a.contains(Build.MODEL.toLowerCase(Locale.US)) && ((Integer) zsVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 1;
    }
}
