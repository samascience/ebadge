package defpackage;

import android.hardware.camera2.CaptureRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class m13 {
    private final w92 a;

    public m13(w92 w92Var) {
        this.a = w92Var;
    }

    public Map a(int i) {
        if (i != 3 || !wv.e(this.a)) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap();
        map.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 1);
        return Collections.unmodifiableMap(map);
    }
}
