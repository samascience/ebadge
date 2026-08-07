package androidx.lifecycle;

import defpackage.p31;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class r {
    private final Map a = new LinkedHashMap();

    public final void a() {
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((o) it.next()).a();
        }
        this.a.clear();
    }

    public final o b(String str) {
        p31.f(str, "key");
        return (o) this.a.get(str);
    }

    public final Set c() {
        return new HashSet(this.a.keySet());
    }

    public final void d(String str, o oVar) {
        p31.f(str, "key");
        p31.f(oVar, "viewModel");
        o oVar2 = (o) this.a.put(str, oVar);
        if (oVar2 != null) {
            oVar2.d();
        }
    }
}
