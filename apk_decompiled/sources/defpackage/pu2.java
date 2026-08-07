package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class pu2 extends bl1 {
    private qu2 a;
    private ct2 b;
    private ou2 c;

    public pu2() {
        qu2 qu2Var = new qu2();
        this.a = qu2Var;
        this.c = qu2Var;
    }

    @Override // defpackage.bl1
    public float a() {
        return this.c.b();
    }

    public void b(float f, float f2, float f3, float f4, float f5, float f6) {
        qu2 qu2Var = this.a;
        this.c = qu2Var;
        qu2Var.d(f, f2, f3, f4, f5, f6);
    }

    public boolean c() {
        return this.c.a();
    }

    public void d(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        if (this.b == null) {
            this.b = new ct2();
        }
        ct2 ct2Var = this.b;
        this.c = ct2Var;
        ct2Var.d(f, f2, f3, f4, f5, f6, f7, i);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return this.c.getInterpolation(f);
    }
}
