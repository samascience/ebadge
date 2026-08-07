package defpackage;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public abstract class da {
    public static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    private static Object b(Object obj, int i, int i2) {
        if (obj == null) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        int iA = a(obj);
        if (i2 > iA) {
            i2 = iA;
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

    public static byte[] c(byte[] bArr, int i, int i2) {
        return (byte[]) b(bArr, i, i2);
    }
}
