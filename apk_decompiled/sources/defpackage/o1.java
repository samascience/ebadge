package defpackage;

/* JADX INFO: loaded from: classes4.dex */
abstract class o1 extends m1 {
    protected final int f;
    protected final int g;

    protected o1(y0 y0Var, String str, String[] strArr, int i, int i2) {
        super(y0Var, str, strArr);
        this.f = i;
        this.g = i2;
    }

    public o1 d(int i, Object obj) {
        if (i < 0 || !(i == this.f || i == this.g)) {
            return (o1) super.b(i, obj);
        }
        throw new IllegalArgumentException("Illegal parameter index: " + i);
    }
}
