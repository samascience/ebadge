package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class lx0 implements rk1 {
    public static final px1 b = px1.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    private final qk1 a;

    public static class a implements sk1 {
        private final qk1 a = new qk1(500);

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new lx0(this.a);
        }
    }

    public lx0(qk1 qk1Var) {
        this.a = qk1Var;
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public rk1.a b(su0 su0Var, int i, int i2, rx1 rx1Var) {
        qk1 qk1Var = this.a;
        if (qk1Var != null) {
            su0 su0Var2 = (su0) qk1Var.a(su0Var, 0, 0);
            if (su0Var2 == null) {
                this.a.b(su0Var, 0, 0, su0Var);
            } else {
                su0Var = su0Var2;
            }
        }
        return new rk1.a(su0Var, new ux0(su0Var, ((Integer) rx1Var.a(b)).intValue()));
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(su0 su0Var) {
        return true;
    }
}
