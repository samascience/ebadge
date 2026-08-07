package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class hf1 extends pt1.a {
    private static pt1 e;
    public double c;
    public double d;

    static {
        pt1 pt1VarA = pt1.a(64, new hf1(0.0d, 0.0d));
        e = pt1VarA;
        pt1VarA.g(0.5f);
    }

    private hf1(double d, double d2) {
        this.c = d;
        this.d = d2;
    }

    public static hf1 b(double d, double d2) {
        hf1 hf1Var = (hf1) e.b();
        hf1Var.c = d;
        hf1Var.d = d2;
        return hf1Var;
    }

    @Override // pt1.a
    protected pt1.a a() {
        return new hf1(0.0d, 0.0d);
    }

    public String toString() {
        return "MPPointD, x: " + this.c + ", y: " + this.d;
    }
}
