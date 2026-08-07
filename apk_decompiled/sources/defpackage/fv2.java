package defpackage;

import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.u;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
class fv2 implements d0.a {
    private final t a;

    fv2() {
        this(t.c0());
    }

    @Override // defpackage.oj0
    public s a() {
        return this.a;
    }

    @Override // androidx.camera.core.impl.d0.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public gv2 b() {
        return new gv2(u.a0(this.a));
    }

    public fv2 d(UseCaseConfigFactory.CaptureType captureType) {
        a().x(d0.F, captureType);
        return this;
    }

    public fv2 e(Class cls) {
        a().x(m03.c, cls);
        if (a().f(m03.b, null) == null) {
            f(cls.getCanonicalName() + "-" + UUID.randomUUID());
        }
        return this;
    }

    public fv2 f(String str) {
        a().x(m03.b, str);
        return this;
    }

    fv2(t tVar) {
        this.a = tVar;
        Class cls = (Class) tVar.f(m03.c, null);
        if (cls == null || cls.equals(ev2.class)) {
            d(UseCaseConfigFactory.CaptureType.STREAM_SHARING);
            e(ev2.class);
            return;
        }
        throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
    }
}
