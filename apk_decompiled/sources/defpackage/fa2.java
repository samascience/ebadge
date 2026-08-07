package defpackage;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes4.dex */
public abstract class fa2 {
    public static final String a(Object obj, Object obj2) {
        p31.f(obj, Constants.FROM);
        p31.f(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }

    public static final void b(double d, double d2) {
        if (d2 <= d) {
            throw new IllegalArgumentException(a(Double.valueOf(d), Double.valueOf(d2)).toString());
        }
    }

    public static final void c(int i, int i2) {
        if (i2 <= i) {
            throw new IllegalArgumentException(a(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public static final void d(long j, long j2) {
        if (j2 <= j) {
            throw new IllegalArgumentException(a(Long.valueOf(j), Long.valueOf(j2)).toString());
        }
    }

    public static final int e(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final int f(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }
}
