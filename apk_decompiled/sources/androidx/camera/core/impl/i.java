package androidx.camera.core.impl;

import defpackage.i33;
import defpackage.rh2;

/* JADX INFO: loaded from: classes.dex */
public final class i implements rh2 {
    private final androidx.camera.core.a0 d;

    class a implements androidx.camera.core.a0 {
        final /* synthetic */ long d;

        a(long j) {
            this.d = j;
        }

        @Override // androidx.camera.core.a0
        public long b() {
            return this.d;
        }

        @Override // androidx.camera.core.a0
        public androidx.camera.core.a0.c c(androidx.camera.core.a0.b bVar) {
            return bVar.n() == 1 ? androidx.camera.core.a0.c.d : androidx.camera.core.a0.c.e;
        }
    }

    public static final class b implements rh2 {
        private final androidx.camera.core.a0 d;

        public b(long j) {
            this.d = new i(j);
        }

        @Override // androidx.camera.core.a0
        public long b() {
            return this.d.b();
        }

        @Override // androidx.camera.core.a0
        public androidx.camera.core.a0.c c(androidx.camera.core.a0.b bVar) {
            if (this.d.c(bVar).d()) {
                return androidx.camera.core.a0.c.e;
            }
            Throwable thA = bVar.a();
            if (thA instanceof CameraValidator.CameraIdListIncorrectException) {
                androidx.camera.core.x.c("CameraX", "The device might underreport the amount of the cameras. Finish the initialize task since we are already reaching the maximum number of retries.");
                if (((CameraValidator.CameraIdListIncorrectException) thA).getAvailableCameraCount() > 0) {
                    return androidx.camera.core.a0.c.g;
                }
            }
            return androidx.camera.core.a0.c.d;
        }

        @Override // defpackage.rh2
        public androidx.camera.core.a0 d(long j) {
            return new b(j);
        }
    }

    public i(long j) {
        this.d = new i33(j, new a(j));
    }

    @Override // androidx.camera.core.a0
    public long b() {
        return this.d.b();
    }

    @Override // androidx.camera.core.a0
    public androidx.camera.core.a0.c c(androidx.camera.core.a0.b bVar) {
        return this.d.c(bVar);
    }

    @Override // defpackage.rh2
    public androidx.camera.core.a0 d(long j) {
        return new i(j);
    }
}
