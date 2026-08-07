package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class o6 implements u6 {
    private final g6 a;
    private final g6 b;

    public o6(g6 g6Var, g6 g6Var2) {
        this.a = g6Var;
        this.b = g6Var2;
    }

    @Override // defpackage.u6
    public tg a() {
        return new ss2(this.a.a(), this.b.a());
    }
}
