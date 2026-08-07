package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class s33 {
    private static final w63 a = new w63();

    static {
        b("function", x33.class);
        b("quark_search", z33.class);
        b("code_interpreter", w33.class);
        b("wanx", a43.class);
        b("text_to_image", s13.class);
    }

    public static synchronized Class a(String str) {
        return a.a(str);
    }

    protected static synchronized void b(String str, Class cls) {
        a.b(str, cls);
    }
}
