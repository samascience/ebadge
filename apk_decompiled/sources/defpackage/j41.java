package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class j41 implements vx {
    @Override // defpackage.vx
    public Class a(String str) {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                return contextClassLoader.loadClass(str);
            }
        } catch (ClassNotFoundException | SecurityException unused) {
        }
        try {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            if (systemClassLoader != null) {
                return systemClassLoader.loadClass(str);
            }
        } catch (ClassNotFoundException | Error | IllegalStateException | SecurityException unused2) {
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException | LinkageError unused3) {
            return null;
        }
    }
}
