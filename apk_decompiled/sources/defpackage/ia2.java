package defpackage;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ia2 extends ha2 {
    public static int b(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static long c(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static int d(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static long e(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static float f(float f, float f2, float f3) {
        if (f2 <= f3) {
            if (f < f2) {
                return f2;
            }
            return f > f3 ? f3 : f;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
    }

    public static int g(int i, int i2, int i3) {
        if (i2 <= i3) {
            if (i < i2) {
                return i2;
            }
            return i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static long h(long j, long j2, long j3) {
        if (j2 <= j3) {
            if (j < j2) {
                return j2;
            }
            return j > j3 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + '.');
    }

    public static c31 i(int i, int i2) {
        return c31.d.a(i, i2, -1);
    }

    public static c31 j(c31 c31Var, int i) {
        p31.f(c31Var, "<this>");
        ha2.a(i > 0, Integer.valueOf(i));
        c31.a aVar = c31.d;
        int iA = c31Var.a();
        int iB = c31Var.b();
        if (c31Var.c() <= 0) {
            i = -i;
        }
        return aVar.a(iA, iB, i);
    }

    public static e31 k(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? e31.e.a() : new e31(i, i2 - 1);
    }
}
