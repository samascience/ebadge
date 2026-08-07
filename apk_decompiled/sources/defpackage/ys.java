package defpackage;

import android.hardware.camera2.CameraCharacteristics;

/* JADX INFO: loaded from: classes.dex */
class ys implements zs.a {
    protected final CameraCharacteristics a;

    ys(CameraCharacteristics cameraCharacteristics) {
        this.a = cameraCharacteristics;
    }

    @Override // zs.a
    public Object a(CameraCharacteristics.Key key) {
        return this.a.get(key);
    }
}
