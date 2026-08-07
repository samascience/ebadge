package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class wf1 extends ef0 {
    private final float a;

    public wf1(float f) {
        this.a = f - 0.001f;
    }

    @Override // defpackage.ef0
    boolean a() {
        return true;
    }

    @Override // defpackage.ef0
    public void b(float f, float f2, float f3, co2 co2Var) {
        float fSqrt = (float) ((((double) this.a) * Math.sqrt(2.0d)) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(this.a, 2.0d) - Math.pow(fSqrt, 2.0d));
        co2Var.n(f2 - fSqrt, ((float) (-((((double) this.a) * Math.sqrt(2.0d)) - ((double) this.a)))) + fSqrt2);
        co2Var.m(f2, (float) (-((((double) this.a) * Math.sqrt(2.0d)) - ((double) this.a))));
        co2Var.m(f2 + fSqrt, ((float) (-((((double) this.a) * Math.sqrt(2.0d)) - ((double) this.a)))) + fSqrt2);
    }
}
