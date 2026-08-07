package defpackage;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.Arrays;
import kotlin.UninitializedPropertyAccessException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class p31 {

    public static class a {
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) l(new IllegalStateException(str + " must not be null")));
    }

    public static void c(Object obj) {
        if (obj == null) {
            n();
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            o(str);
        }
    }

    public static void e(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) l(new NullPointerException(str + " must not be null")));
    }

    public static void f(Object obj, String str) {
        if (obj == null) {
            p(str);
        }
    }

    public static int g(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int h(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    private static String i(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = p31.class.getName();
        int i = 0;
        while (!stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        while (stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        StackTraceElement stackTraceElement = stackTrace[i];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + FileUtils.FILE_EXTENSION_SEPARATOR + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void j() {
        q();
    }

    public static void k(int i, String str) {
        q();
    }

    private static Throwable l(Throwable th) {
        return m(th, p31.class.getName());
    }

    static Throwable m(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return th;
    }

    public static void n() {
        throw ((NullPointerException) l(new NullPointerException()));
    }

    public static void o(String str) {
        throw ((NullPointerException) l(new NullPointerException(str)));
    }

    private static void p(String str) {
        throw ((NullPointerException) l(new NullPointerException(i(str))));
    }

    public static void q() {
        r("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void r(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void s(String str) {
        throw ((UninitializedPropertyAccessException) l(new UninitializedPropertyAccessException(str)));
    }

    public static void t(String str) {
        s("lateinit property " + str + " has not been initialized");
    }
}
