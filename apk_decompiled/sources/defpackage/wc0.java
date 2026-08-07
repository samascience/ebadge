package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class wc0 {
    private static long a;

    public static boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - a < 800) {
            return true;
        }
        a = jCurrentTimeMillis;
        return false;
    }
}
