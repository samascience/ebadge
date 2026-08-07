package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ye0 {
    static ye0 b = new ye0();
    public static String[] c = {"standard", "accelerate", "decelerate", "linear"};
    String a = "identity";

    static class a extends ye0 {
        private static double h = 0.01d;
        private static double i = 1.0E-4d;
        double d;
        double e;
        double f;
        double g;

        a(String str) {
            this.a = str;
            int iIndexOf = str.indexOf(40);
            int iIndexOf2 = str.indexOf(44, iIndexOf);
            this.d = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
            int i2 = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(44, i2);
            this.e = Double.parseDouble(str.substring(i2, iIndexOf3).trim());
            int i3 = iIndexOf3 + 1;
            int iIndexOf4 = str.indexOf(44, i3);
            this.f = Double.parseDouble(str.substring(i3, iIndexOf4).trim());
            int i4 = iIndexOf4 + 1;
            this.g = Double.parseDouble(str.substring(i4, str.indexOf(41, i4)).trim());
        }

        private double d(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            return (this.d * d2 * d3 * d) + (this.f * d3 * d * d) + (d * d * d);
        }

        private double e(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            return (this.e * d2 * d3 * d) + (this.g * d3 * d * d) + (d * d * d);
        }

        @Override // defpackage.ye0
        public double a(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d2 > h) {
                d2 *= 0.5d;
                d3 = d(d3) < d ? d3 + d2 : d3 - d2;
            }
            double d4 = d3 - d2;
            double d5 = d(d4);
            double d6 = d3 + d2;
            double d7 = d(d6);
            double dE = e(d4);
            return (((e(d6) - dE) * (d - d5)) / (d7 - d5)) + dE;
        }

        @Override // defpackage.ye0
        public double b(double d) {
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d2 > i) {
                d2 *= 0.5d;
                d3 = d(d3) < d ? d3 + d2 : d3 - d2;
            }
            double d4 = d3 - d2;
            double d5 = d3 + d2;
            return (e(d5) - e(d4)) / (d(d5) - d(d4));
        }
    }

    public static ye0 c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new a(str);
        }
        if (str.startsWith("spline")) {
            return new du2(str);
        }
        if (str.startsWith("Schlick")) {
            return new il2(str);
        }
        switch (str) {
            case "accelerate":
                return new a("cubic(0.4, 0.05, 0.8, 0.7)");
            case "decelerate":
                return new a("cubic(0.0, 0.0, 0.2, 0.95)");
            case "anticipate":
                return new a("cubic(0.36, 0, 0.66, -0.56)");
            case "linear":
                return new a("cubic(1, 1, 0, 0)");
            case "overshoot":
                return new a("cubic(0.34, 1.56, 0.64, 1)");
            case "standard":
                return new a("cubic(0.4, 0.0, 0.2, 1)");
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(c));
                return b;
        }
    }

    public double a(double d) {
        return d;
    }

    public double b(double d) {
        return 1.0d;
    }

    public String toString() {
        return this.a;
    }
}
