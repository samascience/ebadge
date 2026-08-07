package androidx.camera.camera2.internal;

import androidx.camera.core.impl.Config;
import defpackage.yr;

/* JADX INFO: loaded from: classes.dex */
class f0 implements androidx.camera.core.impl.k.b {
    static final f0 a = new f0();

    f0() {
    }

    @Override // androidx.camera.core.impl.k.b
    public void a(androidx.camera.core.impl.d0 d0Var, androidx.camera.core.impl.k.a aVar) {
        androidx.camera.core.impl.k kVarZ = d0Var.z(null);
        Config configZ = androidx.camera.core.impl.u.Z();
        int iK = androidx.camera.core.impl.k.b().k();
        if (kVarZ != null) {
            iK = kVarZ.k();
            aVar.a(kVarZ.c());
            configZ = kVarZ.g();
        }
        aVar.s(configZ);
        yr yrVar = new yr(d0Var);
        aVar.v(yrVar.a0(iK));
        aVar.c(r1.e(yrVar.d0(e0.c())));
        aVar.e(yrVar.Z());
    }
}
