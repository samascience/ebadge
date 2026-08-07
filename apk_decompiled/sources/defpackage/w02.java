package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class w02 implements xx0 {
    private static w02 b;
    private xx0 a;

    private w02() {
    }

    public static w02 b() {
        if (b == null) {
            synchronized (w02.class) {
                try {
                    if (b == null) {
                        b = new w02();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    @Override // defpackage.xx0
    public b32 a() {
        xx0 xx0Var = this.a;
        if (xx0Var == null) {
            return null;
        }
        return xx0Var.a();
    }
}
