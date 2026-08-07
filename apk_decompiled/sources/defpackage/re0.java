package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class re0 {
    private final a a;

    interface a {
        DynamicRangeProfiles a();

        Set b();

        Set c(ie0 ie0Var);
    }

    re0(a aVar) {
        this.a = aVar;
    }

    public static re0 a(zs zsVar) {
        re0 re0VarE = Build.VERSION.SDK_INT >= 33 ? e(qe0.a(zsVar.a(CameraCharacteristics.REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES))) : null;
        return re0VarE == null ? te0.a : re0VarE;
    }

    public static re0 e(DynamicRangeProfiles dynamicRangeProfiles) {
        if (dynamicRangeProfiles == null) {
            return null;
        }
        b52.j(Build.VERSION.SDK_INT >= 33, "DynamicRangeProfiles can only be converted to DynamicRangesCompat on API 33 or higher.");
        return new re0(new se0(dynamicRangeProfiles));
    }

    public Set b(ie0 ie0Var) {
        return this.a.c(ie0Var);
    }

    public Set c() {
        return this.a.b();
    }

    public DynamicRangeProfiles d() {
        b52.j(Build.VERSION.SDK_INT >= 33, "DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.");
        return this.a.a();
    }
}
