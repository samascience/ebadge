package defpackage;

import android.hardware.camera2.CaptureRequest;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class mu2 {
    private final boolean a;

    public mu2() {
        this.a = ((lu2) xa0.a(lu2.class)) != null;
    }

    public boolean a(List list, boolean z) {
        if (this.a && z) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) ((CaptureRequest) it.next()).get(CaptureRequest.CONTROL_AE_MODE)).intValue();
                if (iIntValue == 2 || iIntValue == 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
