package defpackage;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class jo {
    private static final q23 a;
    protected static final ThreadLocal b;

    static {
        boolean zEquals;
        try {
            zEquals = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));
        } catch (SecurityException unused) {
            zEquals = false;
        }
        a = zEquals ? q23.a() : null;
        b = new ThreadLocal();
    }

    public static io a() {
        ThreadLocal threadLocal = b;
        SoftReference softReference = (SoftReference) threadLocal.get();
        io ioVar = softReference == null ? null : (io) softReference.get();
        if (ioVar == null) {
            ioVar = new io();
            q23 q23Var = a;
            threadLocal.set(q23Var != null ? q23Var.c(ioVar) : new SoftReference(ioVar));
        }
        return ioVar;
    }
}
