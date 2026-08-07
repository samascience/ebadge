package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ts2 {
    private static final String a = "ts2";
    private static float b;
    private static float c;
    private static int d;
    private static int e;

    static {
        f();
    }

    public static float a() {
        return b(c);
    }

    public static float b(float f) {
        f();
        return ls1.b((float) (((double) f) / Math.pow(b / 100.0f, 2.0d)), 1);
    }

    public static float c(float f) {
        f();
        float f2 = d == 0 ? ((1.2f * f) + (e * 0.23f)) - 5.4f : (((1.2f * f) + (e * 0.23f)) - 5.4f) - 10.8f;
        Log.i(a, "calculateFatRate:" + f + ";bodyFatRate:" + f2);
        return ls1.b(f2, 1);
    }

    public static int d(float f, float f2) {
        f();
        int iAbs = ((int) (((1.0f - Math.abs((f - 24.0f) / 24.0f)) * 35.0f) + ((1.0f - (d == 0 ? Math.abs((f2 - 29.0f) / 29.0f) : Math.abs((f2 - 19.0f) / 19.0f))) * 65.0f))) % 100;
        Log.i(a, "健康指数:" + iAbs);
        if (iAbs < 0) {
            return 0;
        }
        return iAbs;
    }

    public static int e() {
        float fA = a();
        int iD = d(fA, c(fA));
        Log.i(a, "健康得分:" + iD);
        return iD;
    }

    private static void f() {
        b = zm1.k();
        c = zm1.C();
        d = zm1.j();
        e = zm1.c();
    }
}
