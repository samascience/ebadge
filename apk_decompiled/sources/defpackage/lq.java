package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Size;
import androidx.camera.core.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class lq implements v92 {
    private final wu2 a;
    private List b = null;

    public lq(zs zsVar) {
        this.a = zsVar.b();
    }

    static boolean g(zs zsVar) {
        Integer num = (Integer) zsVar.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }

    public List f() {
        if (this.b == null) {
            Size[] sizeArrC = this.a.c(34);
            this.b = sizeArrC != null ? Arrays.asList((Size[]) sizeArrC.clone()) : Collections.emptyList();
            x.a("CamcorderProfileResolutionQuirk", "mSupportedResolutions = " + this.b);
        }
        return new ArrayList(this.b);
    }
}
