package defpackage;

import android.location.Location;

/* JADX INFO: loaded from: classes.dex */
public abstract class uq3 {
    private static long a;
    private static bn3 b;
    private static Location c;
    private static String d;

    public static String a() {
        return d;
    }

    public static void b(long j) {
        a = j;
    }

    public static void c(bn3 bn3Var) {
        b = bn3Var;
    }

    public static void d(Location location) {
        c = location;
    }

    public static void e(String str) {
        d = str;
    }

    public static long f() {
        return a;
    }

    public static bn3 g() {
        return b;
    }

    public static Location h() {
        return c;
    }
}
