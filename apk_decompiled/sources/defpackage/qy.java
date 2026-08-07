package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public final class qy {
    public static final a d = new a(null);
    private final Method a;
    private final Method b;
    private final Method c;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final qy a() throws NoSuchMethodException {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", null);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", null);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new qy(method3, method2, method);
        }

        private a() {
        }
    }

    public qy(Method method, Method method2, Method method3) {
        this.a = method;
        this.b = method2;
        this.c = method3;
    }

    public final Object a(String str) {
        p31.f(str, "closer");
        Method method = this.a;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, null);
                Method method2 = this.b;
                p31.c(method2);
                method2.invoke(objInvoke, str);
                return objInvoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean b(Object obj) {
        if (obj != null) {
            try {
                Method method = this.c;
                p31.c(method);
                method.invoke(obj, null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
