package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class zu0 {
    private final float[] a;
    private final int[] b;

    public zu0(float[] fArr, int[] iArr) {
        this.a = fArr;
        this.b = iArr;
    }

    public int[] a() {
        return this.b;
    }

    public float[] b() {
        return this.a;
    }

    public int c() {
        return this.b.length;
    }

    public void d(zu0 zu0Var, zu0 zu0Var2, float f) {
        if (zu0Var.b.length == zu0Var2.b.length) {
            for (int i = 0; i < zu0Var.b.length; i++) {
                this.a[i] = ok1.j(zu0Var.a[i], zu0Var2.a[i], f);
                this.b[i] = us0.c(f, zu0Var.b[i], zu0Var2.b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + zu0Var.b.length + " vs " + zu0Var2.b.length + ")");
    }
}
