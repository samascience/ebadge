package androidx.camera.camera2.internal;

import android.content.Context;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import defpackage.n13;

/* JADX INFO: loaded from: classes.dex */
public final class m1 implements UseCaseConfigFactory {
    final c2 b;

    public m1(Context context) {
        this.b = c2.c(context);
    }

    @Override // androidx.camera.core.impl.UseCaseConfigFactory
    public Config a(UseCaseConfigFactory.CaptureType captureType, int i) {
        androidx.camera.core.impl.t tVarC0 = androidx.camera.core.impl.t.c0();
        SessionConfig.b bVar = new SessionConfig.b();
        bVar.z(n13.b(captureType, i));
        tVarC0.x(androidx.camera.core.impl.d0.x, bVar.p());
        tVarC0.x(androidx.camera.core.impl.d0.z, l1.a);
        androidx.camera.core.impl.k.a aVar = new androidx.camera.core.impl.k.a();
        aVar.v(n13.a(captureType, i));
        tVarC0.x(androidx.camera.core.impl.d0.y, aVar.h());
        tVarC0.x(androidx.camera.core.impl.d0.A, captureType == UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE ? n2.c : f0.a);
        if (captureType == UseCaseConfigFactory.CaptureType.PREVIEW) {
            tVarC0.x(androidx.camera.core.impl.r.t, this.b.f());
        }
        tVarC0.x(androidx.camera.core.impl.r.o, Integer.valueOf(this.b.d(true).getRotation()));
        if (captureType == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE || captureType == UseCaseConfigFactory.CaptureType.STREAM_SHARING) {
            tVarC0.x(androidx.camera.core.impl.d0.D, Boolean.TRUE);
        }
        return androidx.camera.core.impl.u.a0(tVarC0);
    }
}
