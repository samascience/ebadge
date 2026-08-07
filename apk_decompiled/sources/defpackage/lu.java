package defpackage;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class lu extends ku {
    lu(Context context) {
        super(context);
    }

    @Override // defpackage.mu, iu.b
    public Set e() throws CameraAccessExceptionCompat {
        try {
            return this.a.getConcurrentCameraIds();
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
        }
    }
}
