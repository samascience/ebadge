package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a51 implements xr2 {
    private static final Set a = new HashSet(Arrays.asList("redmi note 8 pro"));

    static boolean f(zs zsVar) {
        return a.contains(Build.MODEL.toLowerCase(Locale.US)) && ((Integer) zsVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }
}
