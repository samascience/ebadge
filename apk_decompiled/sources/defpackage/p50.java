package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class p50 extends m40 {
    float a = -1.0f;

    @Override // defpackage.m40
    public void a(co2 co2Var, float f, float f2, float f3) {
        co2Var.o(0.0f, f3 * f2, 180.0f, 180.0f - f);
        double d = f3;
        double d2 = f2;
        co2Var.m((float) (Math.sin(Math.toRadians(f)) * d * d2), (float) (Math.sin(Math.toRadians(90.0f - f)) * d * d2));
    }
}
