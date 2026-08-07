package defpackage;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public abstract class ea {
    public static Object[] a(Object[] objArr, Object[] objArr2) {
        return (Object[]) c(objArr, objArr2);
    }

    public static int b(Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    private static Object c(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return null;
        }
        if (obj == null) {
            return d(obj2);
        }
        if (obj2 == null) {
            return d(obj);
        }
        int iB = b(obj);
        int iB2 = b(obj2);
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), iB + iB2);
        System.arraycopy(obj, 0, objNewInstance, 0, iB);
        System.arraycopy(obj2, 0, objNewInstance, iB, iB2);
        return objNewInstance;
    }

    private static Object d(Object obj) {
        if (obj == null) {
            return null;
        }
        return e(obj, 0, b(obj));
    }

    private static Object e(Object obj, int i, int i2) {
        if (obj == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        int iB = b(obj);
        if (i2 > iB) {
            i2 = iB;
        }
        int i3 = i2 - i;
        Class<?> componentType = obj.getClass().getComponentType();
        if (i3 <= 0) {
            return Array.newInstance(componentType, 0);
        }
        Object objNewInstance = Array.newInstance(componentType, i3);
        System.arraycopy(obj, i, objNewInstance, 0, i3);
        return objNewInstance;
    }
}
