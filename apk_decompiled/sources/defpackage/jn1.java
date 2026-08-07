package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public abstract class jn1 {
    private static final boolean a;

    static {
        a = System.getProperty("org.graalvm.nativeimage.imagecode") != null;
    }

    private static boolean a() {
        return a && "runtime".equals(System.getProperty("org.graalvm.nativeimage.imagecode"));
    }

    public static boolean b(Throwable th) {
        if (!a()) {
            return false;
        }
        if (th instanceof InvocationTargetException) {
            th = th.getCause();
        }
        return th.getClass().getName().equals("com.oracle.svm.core.jdk.UnsupportedFeatureError");
    }

    public static boolean c(Class cls) {
        if (a()) {
            return (cls.getDeclaredFields().length == 0 || ay.T(cls)) && cls.getDeclaredMethods().length == 0 && cls.getDeclaredConstructors().length == 0;
        }
        return false;
    }
}
