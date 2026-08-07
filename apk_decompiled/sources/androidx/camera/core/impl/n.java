package androidx.camera.core.impl;

import android.graphics.Rect;
import defpackage.ub1;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class n implements CameraControlInternal {
    private final CameraControlInternal b;

    public n(CameraControlInternal cameraControlInternal) {
        this.b = cameraControlInternal;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void a(SessionConfig.b bVar) {
        this.b.a(bVar);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public ub1 b(List list, int i, int i2) {
        return this.b.b(list, i, i2);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void c(Config config) {
        this.b.c(config);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public Rect d() {
        return this.b.d();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void e(int i) {
        this.b.e(i);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public Config f() {
        return this.b.f();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void g(androidx.camera.core.u.i iVar) {
        this.b.g(iVar);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void h() {
        this.b.h();
    }
}
