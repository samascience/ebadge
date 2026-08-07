package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public abstract class y31 extends s32 {

    private static final class a {
        public static final a a = new a();
        public static final Integer b;

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
                num = obj instanceof Integer ? (Integer) obj : null;
            } catch (Throwable unused) {
            }
            if (num != null && num.intValue() > 0) {
                num2 = num;
            }
            b = num2;
        }

        private a() {
        }
    }

    private final boolean c(int i) {
        Integer num = a.b;
        return num == null || num.intValue() >= i;
    }

    @Override // defpackage.s32
    public void a(Throwable th, Throwable th2) {
        p31.f(th, "cause");
        p31.f(th2, "exception");
        if (c(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
