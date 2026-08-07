package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ce0 {
    private static final boolean a = false;
    private static final ThreadLocal[] b;

    static {
        ThreadLocal[] threadLocalArr = new ThreadLocal[4];
        for (int i = 0; i < 4; i++) {
            threadLocalArr[i] = new ThreadLocal();
        }
        b = threadLocalArr;
    }

    public static final boolean a() {
        return a;
    }
}
