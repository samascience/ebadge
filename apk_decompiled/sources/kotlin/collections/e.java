package kotlin.collections;

import defpackage.p31;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes4.dex */
abstract class e {
    public static final Object[] a(Object[] objArr, int i) {
        p31.f(objArr, "reference");
        Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
        p31.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) objNewInstance;
    }

    public static final void b(int i, int i2) {
        if (i <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i2 + ").");
    }
}
