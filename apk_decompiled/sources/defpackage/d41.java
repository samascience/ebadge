package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class d41 {
    protected int a;

    protected d41(int i) {
        this.a = i;
    }

    public static d41 a(c41[] c41VarArr) {
        if (c41VarArr.length > 31) {
            throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", c41VarArr[0].getClass().getName(), Integer.valueOf(c41VarArr.length)));
        }
        int mask = 0;
        for (c41 c41Var : c41VarArr) {
            if (c41Var.enabledByDefault()) {
                mask |= c41Var.getMask();
            }
        }
        return new d41(mask);
    }

    public boolean b(c41 c41Var) {
        return (c41Var.getMask() & this.a) != 0;
    }

    public d41 c(c41 c41Var) {
        int mask = c41Var.getMask() | this.a;
        return mask == this.a ? this : new d41(mask);
    }
}
