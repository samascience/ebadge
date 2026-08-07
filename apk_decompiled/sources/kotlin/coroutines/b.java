package kotlin.coroutines;

import defpackage.ar0;
import defpackage.p31;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b implements d.c {
    private final ar0 safeCast;
    private final d.c topmostKey;

    public b(d.c cVar, ar0 ar0Var) {
        p31.f(cVar, "baseKey");
        p31.f(ar0Var, "safeCast");
        this.safeCast = ar0Var;
        this.topmostKey = cVar instanceof b ? ((b) cVar).topmostKey : cVar;
    }

    public final boolean isSubKey$kotlin_stdlib(d.c cVar) {
        p31.f(cVar, "key");
        return cVar == this || this.topmostKey == cVar;
    }

    public final Object tryCast$kotlin_stdlib(d.b bVar) {
        p31.f(bVar, "element");
        return (d.b) this.safeCast.invoke(bVar);
    }
}
