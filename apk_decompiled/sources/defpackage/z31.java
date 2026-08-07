package defpackage;

import kotlin.random.Random;

/* JADX INFO: loaded from: classes4.dex */
public class z31 extends y31 {

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
    public Random b() {
        return c(34) ? new v32() : super.b();
    }
}
