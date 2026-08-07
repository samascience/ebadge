package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class eu2 {
    private static final w63 a = new w63();

    static {
        b("message_creation", gu2.class);
        b("tool_calls", hu2.class);
    }

    public static synchronized Class a(String str) {
        return a.a(str);
    }

    protected static synchronized void b(String str, Class cls) {
        a.b(str, cls);
    }
}
