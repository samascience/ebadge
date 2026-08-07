package defpackage;

import android.hardware.camera2.params.DynamicRangeProfiles;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class te0 implements re0.a {
    static final re0 a = new re0(new te0());
    private static final Set b = Collections.singleton(ie0.d);

    te0() {
    }

    @Override // re0.a
    public DynamicRangeProfiles a() {
        return null;
    }

    @Override // re0.a
    public Set b() {
        return b;
    }

    @Override // re0.a
    public Set c(ie0 ie0Var) {
        b52.b(ie0.d.equals(ie0Var), "DynamicRange is not supported: " + ie0Var);
        return b;
    }
}
