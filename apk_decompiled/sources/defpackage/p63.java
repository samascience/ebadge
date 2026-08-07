package defpackage;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class p63 {
    public static Object a(Object obj, int i) {
        if (obj != null && !c(obj, i)) {
            g(obj, "kotlin.jvm.functions.Function" + i);
        }
        return obj;
    }

    public static int b(Object obj) {
        if (obj instanceof yr0) {
            return ((yr0) obj).getArity();
        }
        if (obj instanceof yq0) {
            return 0;
        }
        if (obj instanceof ar0) {
            return 1;
        }
        if (obj instanceof or0) {
            return 2;
        }
        if (obj instanceof pr0) {
            return 3;
        }
        if (obj instanceof qr0) {
            return 4;
        }
        if (obj instanceof rr0) {
            return 5;
        }
        if (obj instanceof sr0) {
            return 6;
        }
        if (obj instanceof tr0) {
            return 7;
        }
        if (obj instanceof ur0) {
            return 8;
        }
        if (obj instanceof vr0) {
            return 9;
        }
        if (obj instanceof zq0) {
            return 10;
        }
        if (obj instanceof br0) {
            return 11;
        }
        if (obj instanceof cr0) {
            return 12;
        }
        if (obj instanceof dr0) {
            return 13;
        }
        if (obj instanceof er0) {
            return 14;
        }
        if (obj instanceof fr0) {
            return 15;
        }
        if (obj instanceof gr0) {
            return 16;
        }
        if (obj instanceof hr0) {
            return 17;
        }
        if (obj instanceof ir0) {
            return 18;
        }
        if (obj instanceof jr0) {
            return 19;
        }
        if (obj instanceof lr0) {
            return 20;
        }
        if (obj instanceof mr0) {
            return 21;
        }
        return obj instanceof nr0 ? 22 : -1;
    }

    public static boolean c(Object obj, int i) {
        return (obj instanceof kr0) && b(obj) == i;
    }

    public static boolean d(Object obj) {
        return (obj instanceof Map) && (!(obj instanceof k81) || (obj instanceof l81));
    }

    private static Throwable e(Throwable th) {
        return p31.m(th, p63.class.getName());
    }

    public static ClassCastException f(ClassCastException classCastException) {
        throw ((ClassCastException) e(classCastException));
    }

    public static void g(Object obj, String str) {
        h((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void h(String str) {
        throw f(new ClassCastException(str));
    }
}
