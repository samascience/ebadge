package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class t20 {
    private static final w63 a = new w63();

    static {
        b("image_file", v20.class);
        b("text", l30.class);
    }

    public static synchronized Class a(String str) {
        return a.a(str);
    }

    protected static synchronized void b(String str, Class cls) {
        a.b(str, cls);
    }
}
