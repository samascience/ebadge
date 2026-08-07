package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.h;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class i43 implements v92 {
    private static final List b = Arrays.asList("PIXEL 6A", "PIXEL 6 PRO", "PIXEL 7", "PIXEL 7A", "PIXEL 7 PRO", "PIXEL 8", "PIXEL 8 PRO");
    private final zs a;

    public i43(zs zsVar) {
        this.a = zsVar;
    }

    private static boolean f(zs zsVar) {
        return g() && j(zsVar);
    }

    private static boolean g() {
        Iterator it = b.iterator();
        while (it.hasNext()) {
            if (Build.MODEL.toUpperCase(Locale.US).equals((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean h(zs zsVar) {
        return Build.VERSION.SDK_INT >= 28 && h.B(zsVar, 5) == 5;
    }

    private static boolean j(zs zsVar) {
        return ((Integer) zsVar.a(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }

    static boolean k(zs zsVar) {
        return f(zsVar);
    }

    public boolean i() {
        return !h(this.a);
    }
}
