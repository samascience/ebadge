package androidx.camera.camera2.internal;

import android.util.Size;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import defpackage.f62;
import defpackage.rt;
import defpackage.ws;
import defpackage.yr;

/* JADX INFO: loaded from: classes.dex */
final class l1 implements SessionConfig.d {
    static final l1 a = new l1();

    l1() {
    }

    @Override // androidx.camera.core.impl.SessionConfig.d
    public void a(Size size, androidx.camera.core.impl.d0 d0Var, SessionConfig.b bVar) {
        SessionConfig sessionConfigR = d0Var.r(null);
        Config configZ = androidx.camera.core.impl.u.Z();
        int iN = SessionConfig.b().n();
        if (sessionConfigR != null) {
            iN = sessionConfigR.n();
            bVar.b(sessionConfigR.c());
            bVar.d(sessionConfigR.j());
            bVar.c(sessionConfigR.h());
            configZ = sessionConfigR.e();
        }
        bVar.v(configZ);
        if (d0Var instanceof androidx.camera.core.impl.v) {
            f62.b(size, bVar);
        }
        yr yrVar = new yr(d0Var);
        bVar.z(yrVar.a0(iN));
        bVar.f(yrVar.b0(rt.b()));
        bVar.l(yrVar.e0(ws.b()));
        bVar.e(r1.e(yrVar.d0(e0.c())));
        bVar.A(d0Var.G());
        bVar.y(d0Var.P());
        androidx.camera.core.impl.t tVarC0 = androidx.camera.core.impl.t.c0();
        tVarC0.x(yr.P, yrVar.c0(null));
        tVarC0.x(yr.K, Long.valueOf(yrVar.f0(-1L)));
        bVar.h(tVarC0);
        bVar.h(yrVar.Z());
    }
}
