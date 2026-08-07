package defpackage;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
abstract class ay1 extends ey1 {
    ay1(Object obj) {
        super(obj);
    }

    @Override // zx1.a
    public Surface a() {
        return ((OutputConfiguration) i()).getSurface();
    }

    @Override // zx1.a
    public abstract Object i();
}
