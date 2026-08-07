package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class j50 {

    static class a extends j50 {
        double a;
        double[] b;

        a(double d, double[] dArr) {
            this.a = d;
            this.b = dArr;
        }

        @Override // defpackage.j50
        public double c(double d, int i) {
            return this.b[i];
        }

        @Override // defpackage.j50
        public void d(double d, double[] dArr) {
            double[] dArr2 = this.b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // defpackage.j50
        public void e(double d, float[] fArr) {
            int i = 0;
            while (true) {
                double[] dArr = this.b;
                if (i >= dArr.length) {
                    return;
                }
                fArr[i] = (float) dArr[i];
                i++;
            }
        }

        @Override // defpackage.j50
        public double f(double d, int i) {
            return 0.0d;
        }

        @Override // defpackage.j50
        public void g(double d, double[] dArr) {
            for (int i = 0; i < this.b.length; i++) {
                dArr[i] = 0.0d;
            }
        }

        @Override // defpackage.j50
        public double[] h() {
            return new double[]{this.a};
        }
    }

    public static j50 a(int i, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i = 2;
        }
        if (i != 0) {
            return i != 2 ? new mb1(dArr, dArr2) : new a(dArr[0], dArr2[0]);
        }
        return new zk1(dArr, dArr2);
    }

    public static j50 b(int[] iArr, double[] dArr, double[][] dArr2) {
        return new i9(iArr, dArr, dArr2);
    }

    public abstract double c(double d, int i);

    public abstract void d(double d, double[] dArr);

    public abstract void e(double d, float[] fArr);

    public abstract double f(double d, int i);

    public abstract void g(double d, double[] dArr);

    public abstract double[] h();
}
