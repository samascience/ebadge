package androidx.camera.core.impl;

import android.graphics.Rect;
import defpackage.os0;
import defpackage.ub1;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface CameraControlInternal {
    public static final CameraControlInternal a = new a();

    class a implements CameraControlInternal {
        a() {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void a(SessionConfig.b bVar) {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public ub1 b(List list, int i, int i2) {
            return os0.p(Collections.emptyList());
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void c(Config config) {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public Rect d() {
            return new Rect();
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void e(int i) {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public Config f() {
            return null;
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void h() {
        }
    }

    public interface b {
        void a();

        void b(List list);
    }

    void a(SessionConfig.b bVar);

    ub1 b(List list, int i, int i2);

    void c(Config config);

    Rect d();

    void e(int i);

    Config f();

    default void g(androidx.camera.core.u.i iVar) {
    }

    void h();

    public static final class CameraControlException extends Exception {
        private CameraCaptureFailure mCameraCaptureFailure;

        public CameraControlException(CameraCaptureFailure cameraCaptureFailure) {
            this.mCameraCaptureFailure = cameraCaptureFailure;
        }

        public CameraCaptureFailure getCameraCaptureFailure() {
            return this.mCameraCaptureFailure;
        }

        public CameraControlException(CameraCaptureFailure cameraCaptureFailure, Throwable th) {
            super(th);
            this.mCameraCaptureFailure = cameraCaptureFailure;
        }
    }
}
