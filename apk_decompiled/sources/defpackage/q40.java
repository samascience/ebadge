package defpackage;

import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public abstract class q40 {
    public static Pair a(double d, double d2) {
        if (va0.a(rn1.class) != null) {
            d = b(d);
            d2 = b(d2);
        }
        return Pair.create(Double.valueOf(d), Double.valueOf(d2));
    }

    private static double b(double d) {
        return d >= 0.0d ? d : ((d * 10000.0d) - 1.0d) / 10000.0d;
    }
}
