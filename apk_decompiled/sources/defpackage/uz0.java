package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class uz0 implements ga3 {
    private static final List a = Arrays.asList("itel w6004");
    private static final List b = Arrays.asList("sm-j700f", "sm-j710f");

    static boolean f(zs zsVar) {
        List list = b;
        String str = Build.MODEL;
        Locale locale = Locale.US;
        return (list.contains(str.toLowerCase(locale)) && ((Integer) zsVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 0) || a.contains(str.toLowerCase(locale));
    }
}
