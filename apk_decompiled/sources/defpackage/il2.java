package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class il2 extends ye0 {
    double d;
    double e;

    il2(String str) {
        this.a = str;
        int iIndexOf = str.indexOf(40);
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        this.d = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
        int i = iIndexOf2 + 1;
        this.e = Double.parseDouble(str.substring(i, str.indexOf(44, i)).trim());
    }

    private double d(double d) {
        double d2 = this.e;
        if (d < d2) {
            double d3 = this.d;
            return ((d3 * d2) * d2) / ((((d2 - d) * d3) + d) * ((d3 * (d2 - d)) + d));
        }
        double d4 = this.d;
        return (((d2 - 1.0d) * d4) * (d2 - 1.0d)) / (((((-d4) * (d2 - d)) - d) + 1.0d) * ((((-d4) * (d2 - d)) - d) + 1.0d));
    }

    private double e(double d) {
        double d2 = this.e;
        return d < d2 ? (d2 * d) / (d + (this.d * (d2 - d))) : ((1.0d - d2) * (d - 1.0d)) / ((1.0d - d) - (this.d * (d2 - d)));
    }

    @Override // defpackage.ye0
    public double a(double d) {
        return e(d);
    }

    @Override // defpackage.ye0
    public double b(double d) {
        return d(d);
    }
}
