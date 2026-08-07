package defpackage;

import android.hardware.camera2.params.DynamicRangeProfiles;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class se0 implements re0.a {
    private final DynamicRangeProfiles a;

    se0(Object obj) {
        this.a = (DynamicRangeProfiles) obj;
    }

    private Long d(ie0 ie0Var) {
        return ke0.a(ie0Var, this.a);
    }

    private static Set e(Set set) {
        if (set.isEmpty()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(set.size());
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(f(((Long) it.next()).longValue()));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static ie0 f(long j) {
        return (ie0) b52.h(ke0.b(j), "Dynamic range profile cannot be converted to a DynamicRange object: " + j);
    }

    @Override // re0.a
    public DynamicRangeProfiles a() {
        return this.a;
    }

    @Override // re0.a
    public Set b() {
        return e(this.a.getSupportedProfiles());
    }

    @Override // re0.a
    public Set c(ie0 ie0Var) {
        Long lD = d(ie0Var);
        b52.b(lD != null, "DynamicRange is not supported: " + ie0Var);
        return e(this.a.getProfileCaptureRequestConstraints(lD.longValue()));
    }
}
