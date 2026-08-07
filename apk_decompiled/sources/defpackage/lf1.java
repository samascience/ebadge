package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
abstract class lf1 {
    private static pn2 a;

    static synchronized ClassLoader a() {
        try {
            if (a == null) {
                a = new pn2(lf1.class.getClassLoader(), "lombok", null, Arrays.asList(new String[0]), Arrays.asList("lombok.patcher.Symbols"));
            }
        } catch (Throwable th) {
            throw th;
        }
        return a;
    }
}
