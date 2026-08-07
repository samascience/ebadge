package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class nh2 {
    private final float a;
    private final float b;

    public nh2(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    private static float a(nh2 nh2Var, nh2 nh2Var2, nh2 nh2Var3) {
        float f = nh2Var2.a;
        float f2 = nh2Var2.b;
        return ((nh2Var3.a - f) * (nh2Var.b - f2)) - ((nh2Var3.b - f2) * (nh2Var.a - f));
    }

    public static float b(nh2 nh2Var, nh2 nh2Var2) {
        return dh1.a(nh2Var.a, nh2Var.b, nh2Var2.a, nh2Var2.b);
    }

    public static void e(nh2[] nh2VarArr) {
        nh2 nh2Var;
        nh2 nh2Var2;
        nh2 nh2Var3;
        float fB = b(nh2VarArr[0], nh2VarArr[1]);
        float fB2 = b(nh2VarArr[1], nh2VarArr[2]);
        float fB3 = b(nh2VarArr[0], nh2VarArr[2]);
        if (fB2 >= fB && fB2 >= fB3) {
            nh2Var = nh2VarArr[0];
            nh2Var2 = nh2VarArr[1];
            nh2Var3 = nh2VarArr[2];
        } else if (fB3 < fB2 || fB3 < fB) {
            nh2Var = nh2VarArr[2];
            nh2Var2 = nh2VarArr[0];
            nh2Var3 = nh2VarArr[1];
        } else {
            nh2Var = nh2VarArr[1];
            nh2Var2 = nh2VarArr[0];
            nh2Var3 = nh2VarArr[2];
        }
        if (a(nh2Var2, nh2Var, nh2Var3) < 0.0f) {
            nh2 nh2Var4 = nh2Var3;
            nh2Var3 = nh2Var2;
            nh2Var2 = nh2Var4;
        }
        nh2VarArr[0] = nh2Var2;
        nh2VarArr[1] = nh2Var;
        nh2VarArr[2] = nh2Var3;
    }

    public final float c() {
        return this.a;
    }

    public final float d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof nh2) {
            nh2 nh2Var = (nh2) obj;
            if (this.a == nh2Var.a && this.b == nh2Var.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "(" + this.a + ',' + this.b + ')';
    }
}
