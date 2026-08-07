package defpackage;

import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInternal;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
class dg3 implements CameraInternal {
    private final CameraInternal a;
    private final gg3 b;
    private final hg3 c;
    private final UseCase.a d;

    dg3(CameraInternal cameraInternal, UseCase.a aVar, ev2.a aVar2) {
        this.a = cameraInternal;
        this.d = aVar;
        this.b = new gg3(cameraInternal.h(), aVar2);
        this.c = new hg3(cameraInternal.n());
    }

    @Override // androidx.camera.core.UseCase.a
    public void c(UseCase useCase) {
        t23.a();
        this.d.c(useCase);
    }

    @Override // androidx.camera.core.UseCase.a
    public void d(UseCase useCase) {
        t23.a();
        this.d.d(useCase);
    }

    @Override // androidx.camera.core.UseCase.a
    public void f(UseCase useCase) {
        t23.a();
        this.d.f(useCase);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public ut1 g() {
        return this.a.g();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public CameraControlInternal h() {
        return this.b;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void k(Collection collection) {
        throw new UnsupportedOperationException("Operation not supported by VirtualCamera.");
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void l(Collection collection) {
        throw new UnsupportedOperationException("Operation not supported by VirtualCamera.");
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public boolean m() {
        return false;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public zt n() {
        return this.c;
    }

    @Override // androidx.camera.core.UseCase.a
    public void o(UseCase useCase) {
        t23.a();
        this.d.o(useCase);
    }

    void p(int i) {
        this.c.p(i);
    }
}
