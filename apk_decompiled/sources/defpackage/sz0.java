package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class sz0 implements v92 {
    private static final List a = Arrays.asList("sm-j700f", "sm-j710f");

    static boolean f(zs zsVar) {
        return a.contains(Build.MODEL.toLowerCase(Locale.US)) && ((Integer) zsVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }
}
