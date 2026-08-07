package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class g7 {
    private static final w63 a = new w63();

    static {
        b("file_citation", cm0.class);
        b("file_path", tm0.class);
    }

    public static synchronized Class a(String str) {
        return a.a(str);
    }

    protected static synchronized void b(String str, Class cls) {
        a.b(str, cls);
    }
}
