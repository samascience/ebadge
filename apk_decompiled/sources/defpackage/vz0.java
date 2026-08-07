package defpackage;

import android.hardware.camera2.CaptureRequest;

/* JADX INFO: loaded from: classes.dex */
public class vz0 {
    public void a(int i, yr.a aVar) {
        if (((wz0) xa0.a(wz0.class)) == null) {
            return;
        }
        if (i == 0) {
            aVar.f(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.TRUE);
        } else {
            if (i != 1) {
                return;
            }
            aVar.f(CaptureRequest.CONTROL_ENABLE_ZSL, Boolean.FALSE);
        }
    }
}
