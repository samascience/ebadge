package defpackage;

import android.util.Size;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class uf2 {
    private final sj0 a;

    public uf2() {
        this((sj0) xa0.a(sj0.class));
    }

    public List a(SurfaceConfig.ConfigType configType, List list) {
        Size sizeF;
        sj0 sj0Var = this.a;
        if (sj0Var == null || (sizeF = sj0Var.f(configType)) == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(sizeF);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            if (!size.equals(sizeF)) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    uf2(sj0 sj0Var) {
        this.a = sj0Var;
    }
}
