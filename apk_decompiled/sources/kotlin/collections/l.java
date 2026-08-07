package kotlin.collections;

import defpackage.e31;
import defpackage.o00;
import defpackage.p31;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class l extends k {
    public static final Collection g(Object[] objArr) {
        p31.f(objArr, "<this>");
        return new b(objArr, false);
    }

    public static final int h(List list, Comparable comparable, int i, int i2) {
        p31.f(list, "<this>");
        q(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int iA = o00.a((Comparable) list.get(i4), comparable);
            if (iA < 0) {
                i = i4 + 1;
            } else {
                if (iA <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static /* synthetic */ int i(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return h(list, comparable, i, i2);
    }

    public static List j() {
        return EmptyList.INSTANCE;
    }

    public static e31 k(Collection collection) {
        p31.f(collection, "<this>");
        return new e31(0, collection.size() - 1);
    }

    public static int l(List list) {
        p31.f(list, "<this>");
        return list.size() - 1;
    }

    public static List m(Object... objArr) {
        p31.f(objArr, "elements");
        return objArr.length > 0 ? d.c(objArr) : j.j();
    }

    public static List n(Object... objArr) {
        p31.f(objArr, "elements");
        return d.s(objArr);
    }

    public static List o(Object... objArr) {
        p31.f(objArr, "elements");
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new b(objArr, true));
    }

    public static final List p(List list) {
        p31.f(list, "<this>");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : j.e(list.get(0));
        }
        return j.j();
    }

    private static final void q(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("fromIndex (" + i2 + ") is greater than toIndex (" + i3 + ").");
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is less than zero.");
        }
        if (i3 <= i) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i + ").");
    }

    public static void r() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void s() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
