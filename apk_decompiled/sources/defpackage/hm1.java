package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class hm1 extends v40 {
    /* JADX WARN: Multi-variable type inference failed */
    public hm1() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // defpackage.v40
    public Object a(v40.b bVar) {
        p31.f(bVar, "key");
        return b().get(bVar);
    }

    public final void c(v40.b bVar, Object obj) {
        p31.f(bVar, "key");
        b().put(bVar, obj);
    }

    public hm1(v40 v40Var) {
        p31.f(v40Var, "initialExtras");
        b().putAll(v40Var.b());
    }

    public /* synthetic */ hm1(v40 v40Var, int i, y70 y70Var) {
        this((i & 1) != 0 ? v40.a.b : v40Var);
    }
}
