package androidx.fragment.app;

import defpackage.ap2;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    private static final ap2 a = new ap2();

    static boolean b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Class c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        ap2 ap2Var = a;
        ap2 ap2Var2 = (ap2) ap2Var.get(classLoader);
        if (ap2Var2 == null) {
            ap2Var2 = new ap2();
            ap2Var.put(classLoader, ap2Var2);
        }
        Class cls = (Class) ap2Var2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        ap2Var2.put(str, cls2);
        return cls2;
    }

    public static Class d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists", e2);
        }
    }

    public abstract Fragment a(ClassLoader classLoader, String str);
}
