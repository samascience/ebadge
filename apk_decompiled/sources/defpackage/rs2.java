package defpackage;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class rs2 {
    protected j50 a;
    protected int[] b = new int[10];
    protected float[] c = new float[10];
    private int d;
    private String e;

    private static class a {
        static void a(int[] iArr, float[] fArr, int i, int i2) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i2;
            iArr2[1] = i;
            int i3 = 2;
            while (i3 > 0) {
                int i4 = iArr2[i3 - 1];
                int i5 = i3 - 2;
                int i6 = iArr2[i5];
                if (i4 < i6) {
                    int iB = b(iArr, fArr, i4, i6);
                    iArr2[i5] = iB - 1;
                    iArr2[i3 - 1] = i4;
                    int i7 = i3 + 1;
                    iArr2[i3] = i6;
                    i3 += 2;
                    iArr2[i7] = iB + 1;
                } else {
                    i3 = i5;
                }
            }
        }

        private static int b(int[] iArr, float[] fArr, int i, int i2) {
            int i3 = iArr[i2];
            int i4 = i;
            while (i < i2) {
                if (iArr[i] <= i3) {
                    c(iArr, fArr, i4, i);
                    i4++;
                }
                i++;
            }
            c(iArr, fArr, i4, i2);
            return i4;
        }

        private static void c(int[] iArr, float[] fArr, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float f = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = f;
        }
    }

    public float a(float f) {
        return (float) this.a.c(f, 0);
    }

    public float b(float f) {
        return (float) this.a.f(f, 0);
    }

    public void c(int i, float f) {
        int[] iArr = this.b;
        if (iArr.length < this.d + 1) {
            this.b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.c;
            this.c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.b;
        int i2 = this.d;
        iArr2[i2] = i;
        this.c[i2] = f;
        this.d = i2 + 1;
    }

    public void d(String str) {
        this.e = str;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0048  */
    public void e(int i) {
        int i2 = this.d;
        if (i2 == 0) {
            return;
        }
        a.a(this.b, this.c, 0, i2 - 1);
        int i3 = 1;
        for (int i4 = 1; i4 < this.d; i4++) {
            int[] iArr = this.b;
            if (iArr[i4 - 1] != iArr[i4]) {
                i3++;
            }
        }
        double[] dArr = new double[i3];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i3, 1);
        int i5 = 0;
        for (int i6 = 0; i6 < this.d; i6++) {
            if (i6 > 0) {
                int[] iArr2 = this.b;
                if (iArr2[i6] != iArr2[i6 - 1]) {
                    dArr[i5] = ((double) this.b[i6]) * 0.01d;
                    dArr2[i5][0] = this.c[i6];
                    i5++;
                }
            } else {
                dArr[i5] = ((double) this.b[i6]) * 0.01d;
                dArr2[i5][0] = this.c[i6];
                i5++;
            }
        }
        this.a = j50.a(i, dArr, dArr2);
    }

    public String toString() {
        String str = this.e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.d; i++) {
            str = str + "[" + this.b[i] + " , " + decimalFormat.format(this.c[i]) + "] ";
        }
        return str;
    }
}
