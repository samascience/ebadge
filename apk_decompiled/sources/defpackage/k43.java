package defpackage;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.k;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k43 {
    private final boolean a;

    public k43() {
        this.a = xa0.a(j43.class) != null;
    }

    public k a(k kVar) {
        k.a aVar = new k.a();
        aVar.v(kVar.k());
        Iterator it = kVar.i().iterator();
        while (it.hasNext()) {
            aVar.f((DeferrableSurface) it.next());
        }
        aVar.e(kVar.g());
        yr.a aVar2 = new yr.a();
        aVar2.f(CaptureRequest.FLASH_MODE, 0);
        aVar.e(aVar2.c());
        return aVar.h();
    }

    public boolean b(List list, boolean z) {
        if (!this.a || !z) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) ((CaptureRequest) it.next()).get(CaptureRequest.FLASH_MODE);
            if (num != null && num.intValue() == 2) {
                return true;
            }
        }
        return false;
    }
}
