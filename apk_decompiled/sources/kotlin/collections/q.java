package kotlin.collections;

import defpackage.ar0;
import defpackage.p31;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class q extends p {
    public static Object A(List list) {
        p31.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(j.l(list));
    }

    public static boolean B(Iterable iterable, ar0 ar0Var) {
        p31.f(iterable, "<this>");
        p31.f(ar0Var, "predicate");
        return y(iterable, ar0Var, false);
    }

    public static boolean w(Collection collection, Iterable iterable) {
        p31.f(collection, "<this>");
        p31.f(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static boolean x(Collection collection, Object[] objArr) {
        p31.f(collection, "<this>");
        p31.f(objArr, "elements");
        return collection.addAll(d.c(objArr));
    }

    private static final boolean y(Iterable iterable, ar0 ar0Var, boolean z) {
        Iterator it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (((Boolean) ar0Var.invoke(it.next())).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static Object z(List list) {
        p31.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(j.l(list));
    }
}
