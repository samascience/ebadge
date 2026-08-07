package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class wi {
    private static wi a;

    private wi() {
    }

    public static synchronized wi a() {
        try {
            if (a == null) {
                a = new wi();
            }
        } catch (Throwable th) {
            throw th;
        }
        return a;
    }

    public boolean b() {
        return gh3.o().B() || b62.t().y();
    }
}
