package defpackage;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
abstract class z9 {
    static Object[] a(Object[] objArr, int i) {
        if (objArr.length < i) {
            return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }
}
