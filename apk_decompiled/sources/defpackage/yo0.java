package defpackage;

import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.x;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class yo0 {
    private final boolean a;
    private final boolean b;
    private final boolean c;

    public yo0(w92 w92Var, w92 w92Var2) {
        this.a = w92Var2.a(n23.class);
        this.b = w92Var.a(e62.class);
        this.c = w92Var.a(m10.class);
    }

    public void a(List list) {
        if (!b() || list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((DeferrableSurface) it.next()).d();
        }
        x.a("ForceCloseDeferrableSurface", "deferrableSurface closed");
    }

    public boolean b() {
        return this.a || this.b || this.c;
    }
}
