package defpackage;

import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import androidx.camera.core.impl.Config;

/* JADX INFO: loaded from: classes.dex */
public class y4 {
    private final Range a;

    public y4(w92 w92Var) {
        z4 z4Var = (z4) w92Var.b(z4.class);
        if (z4Var == null) {
            this.a = null;
        } else {
            this.a = z4Var.g();
        }
    }

    public void a(yr.a aVar) {
        Range range = this.a;
        if (range != null) {
            aVar.g(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range, Config.OptionPriority.REQUIRED);
        }
    }
}
