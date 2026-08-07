package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class t33 {
    private static final Map a = new HashMap();

    static {
        e("function", u33.class);
    }

    public static synchronized Class c(String str) {
        return (Class) a.get(str);
    }

    protected static synchronized void e(String str, Class cls) {
        a.put(str, cls);
    }

    public abstract String a();

    public abstract Integer b();

    public abstract String d();
}
