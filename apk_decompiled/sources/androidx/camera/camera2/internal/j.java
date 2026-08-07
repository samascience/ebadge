package androidx.camera.camera2.internal;

import android.content.Context;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.impl.CameraInternal;
import defpackage.gt;
import defpackage.iu;
import defpackage.pr;
import defpackage.tu;
import defpackage.ut;
import defpackage.wu;
import defpackage.xt;
import defpackage.xu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class j implements ut {
    private final Context a;
    private final gt b;
    private final wu c;
    private final androidx.camera.core.impl.j d;
    private final iu e;
    private final List f;
    private final c2 g;
    private final long h;
    private final Map i = new HashMap();

    public j(Context context, wu wuVar, tu tuVar, long j) {
        this.a = context;
        this.c = wuVar;
        iu iuVarB = iu.b(context, wuVar.c());
        this.e = iuVarB;
        this.g = c2.c(context);
        this.f = e(o1.b(this, tuVar));
        pr prVar = new pr(iuVarB);
        this.b = prVar;
        androidx.camera.core.impl.j jVar = new androidx.camera.core.impl.j(prVar, 1);
        this.d = jVar;
        prVar.b(jVar);
        this.h = j;
    }

    private List e(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.equals("0") || str.equals("1")) {
                arrayList.add(str);
            } else if (xt.a(this.e, str)) {
                arrayList.add(str);
            } else {
                androidx.camera.core.x.a("Camera2CameraFactory", "Camera " + str + " is filtered out because its capabilities do not contain REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE.");
            }
        }
        return arrayList;
    }

    @Override // defpackage.ut
    public Set a() {
        return new LinkedHashSet(this.f);
    }

    @Override // defpackage.ut
    public CameraInternal b(String str) {
        if (this.f.contains(str)) {
            return new Camera2CameraImpl(this.a, this.e, str, f(str), this.b, this.d, this.c.b(), this.c.c(), this.g, this.h);
        }
        throw new IllegalArgumentException("The given camera id is not on the available camera id list.");
    }

    @Override // defpackage.ut
    public gt d() {
        return this.b;
    }

    d0 f(String str) throws CameraUnavailableException {
        try {
            d0 d0Var = (d0) this.i.get(str);
            if (d0Var != null) {
                return d0Var;
            }
            d0 d0Var2 = new d0(str, this.e);
            this.i.put(str, d0Var2);
            return d0Var2;
        } catch (CameraAccessExceptionCompat e) {
            throw xu.a(e);
        }
    }

    @Override // defpackage.ut
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public iu c() {
        return this.e;
    }
}
