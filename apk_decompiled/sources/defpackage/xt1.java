package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class xt1 extends ef0 {
    private final ef0 a;
    private final float b;

    public xt1(ef0 ef0Var, float f) {
        this.a = ef0Var;
        this.b = f;
    }

    @Override // defpackage.ef0
    boolean a() {
        return this.a.a();
    }

    @Override // defpackage.ef0
    public void b(float f, float f2, float f3, co2 co2Var) {
        this.a.b(f, f2 - this.b, f3, co2Var);
    }
}
