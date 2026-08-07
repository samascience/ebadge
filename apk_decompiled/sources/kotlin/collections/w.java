package kotlin.collections;

import defpackage.p31;
import java.util.Collections;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class w extends v {
    public static Map a(Map map) {
        p31.f(map, "builder");
        return ((MapBuilder) map).build();
    }

    public static Map b(int i) {
        return new MapBuilder(i);
    }

    public static int c(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final Map d(Pair pair) {
        p31.f(pair, "pair");
        Map mapSingletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        p31.e(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static final Map e(Map map) {
        p31.f(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        p31.e(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }
}
