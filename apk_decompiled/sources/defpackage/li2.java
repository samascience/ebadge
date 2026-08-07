package defpackage;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class li2 {
    private final Set a = new LinkedHashSet();

    public final synchronized void a(ki2 ki2Var) {
        p31.f(ki2Var, "route");
        this.a.remove(ki2Var);
    }

    public final synchronized void b(ki2 ki2Var) {
        p31.f(ki2Var, "failedRoute");
        this.a.add(ki2Var);
    }

    public final synchronized boolean c(ki2 ki2Var) {
        p31.f(ki2Var, "route");
        return this.a.contains(ki2Var);
    }
}
