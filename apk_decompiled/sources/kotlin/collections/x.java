package kotlin.collections;

import defpackage.p31;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class x extends w {
    public static Map f() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        p31.d(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    public static Map g(Pair... pairArr) {
        p31.f(pairArr, "pairs");
        return pairArr.length > 0 ? o(pairArr, new LinkedHashMap(u.c(pairArr.length))) : u.f();
    }

    public static Map h(Pair... pairArr) {
        p31.f(pairArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(u.c(pairArr.length));
        k(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static final Map i(Map map) {
        p31.f(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : w.e(map);
        }
        return u.f();
    }

    public static final void j(Map map, Iterable iterable) {
        p31.f(map, "<this>");
        p31.f(iterable, "pairs");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            map.put(pair.component1(), pair.component2());
        }
    }

    public static final void k(Map map, Pair[] pairArr) {
        p31.f(map, "<this>");
        p31.f(pairArr, "pairs");
        for (Pair pair : pairArr) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static Map l(Iterable iterable) {
        p31.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return i(m(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return u.f();
        }
        if (size != 1) {
            return m(iterable, new LinkedHashMap(u.c(collection.size())));
        }
        return w.d((Pair) (iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next()));
    }

    public static final Map m(Iterable iterable, Map map) {
        p31.f(iterable, "<this>");
        p31.f(map, "destination");
        j(map, iterable);
        return map;
    }

    public static Map n(Map map) {
        p31.f(map, "<this>");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? u.p(map) : w.e(map);
        }
        return u.f();
    }

    public static final Map o(Pair[] pairArr, Map map) {
        p31.f(pairArr, "<this>");
        p31.f(map, "destination");
        k(map, pairArr);
        return map;
    }

    public static Map p(Map map) {
        p31.f(map, "<this>");
        return new LinkedHashMap(map);
    }
}
