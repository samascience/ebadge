package androidx.camera.camera2.internal;

import defpackage.vz0;
import defpackage.yr;

/* JADX INFO: loaded from: classes.dex */
final class n2 extends f0 {
    static final n2 c = new n2(new vz0());
    private final vz0 b;

    private n2(vz0 vz0Var) {
        this.b = vz0Var;
    }

    @Override // androidx.camera.camera2.internal.f0, androidx.camera.core.impl.k.b
    public void a(androidx.camera.core.impl.d0 d0Var, androidx.camera.core.impl.k.a aVar) {
        super.a(d0Var, aVar);
        if (!(d0Var instanceof androidx.camera.core.impl.p)) {
            throw new IllegalArgumentException("config is not ImageCaptureConfig");
        }
        androidx.camera.core.impl.p pVar = (androidx.camera.core.impl.p) d0Var;
        yr.a aVar2 = new yr.a();
        if (pVar.g0()) {
            this.b.a(pVar.Z(), aVar2);
        }
        aVar.e(aVar2.c());
    }
}
