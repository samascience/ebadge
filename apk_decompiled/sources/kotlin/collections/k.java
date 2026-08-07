package kotlin.collections;

import defpackage.p31;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.collections.builders.ListBuilder;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class k {
    public static List a(List list) {
        p31.f(list, "builder");
        return ((ListBuilder) list).build();
    }

    public static final Object[] b(Object[] objArr, boolean z) {
        p31.f(objArr, "<this>");
        if (z && p31.a(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        p31.e(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    public static List c() {
        return new ListBuilder(0, 1, null);
    }

    public static List d(int i) {
        return new ListBuilder(i);
    }

    public static List e(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        p31.e(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static Object[] f(int i, Object[] objArr) {
        p31.f(objArr, "array");
        if (i < objArr.length) {
            objArr[i] = null;
        }
        return objArr;
    }
}
