package defpackage;

import java.lang.reflect.Method;
import kotlin.collections.d;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes4.dex */
public abstract class s32 {

    private static final class a {
        public static final a a = new a();
        public static final Method b;
        public static final Method c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            p31.c(methods);
            int length = methods.length;
            int i = 0;
            while (true) {
                method = null;
                if (i >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i];
                if (p31.a(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    p31.e(parameterTypes, "getParameterTypes(...)");
                    if (p31.a(d.B(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i++;
            }
            b = method2;
            for (Method method3 : methods) {
                if (p31.a(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
            }
            c = method;
        }

        private a() {
        }
    }

    public void a(Throwable th, Throwable th2) {
        p31.f(th, "cause");
        p31.f(th2, "exception");
        Method method = a.b;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public Random b() {
        return new gk0();
    }
}
