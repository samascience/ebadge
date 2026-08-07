package defpackage;

import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class bf1 {
    private final LinkedHashMap a;

    public bf1(int i, float f) {
        this.a = new LinkedHashMap(i, f, true);
    }

    public final Object a(Object obj) {
        p31.f(obj, "key");
        return this.a.get(obj);
    }

    public final Set b() {
        Set setEntrySet = this.a.entrySet();
        p31.e(setEntrySet, "map.entries");
        return setEntrySet;
    }

    public final boolean c() {
        return this.a.isEmpty();
    }

    public final Object d(Object obj, Object obj2) {
        p31.f(obj, "key");
        p31.f(obj2, "value");
        return this.a.put(obj, obj2);
    }

    public final Object e(Object obj) {
        p31.f(obj, "key");
        return this.a.remove(obj);
    }
}
