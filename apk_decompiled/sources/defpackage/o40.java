package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class o40 {
    private static final String a = "_COROUTINE";

    /* JADX INFO: Access modifiers changed from: private */
    public static final StackTraceElement b(Throwable th, String str) {
        StackTraceElement stackTraceElement = th.getStackTrace()[0];
        return new StackTraceElement(a + '.' + str, "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }

    public static final String c() {
        return a;
    }
}
