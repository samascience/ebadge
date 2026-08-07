package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class yz0 implements ga3 {
    public static final List a = Arrays.asList("SM-G9300", "SM-G930R", "SM-G930A", "SM-G930V", "SM-G930T", "SM-G930U", "SM-G930P", "SM-SC02H", "SM-SCV33", "SM-G9350", "SM-G935R", "SM-G935A", "SM-G935V", "SM-G935T", "SM-G935U", "SM-G935P");

    static boolean f(zs zsVar) {
        return a.contains(Build.MODEL.toUpperCase(Locale.US)) && ((Integer) zsVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 1;
    }
}
