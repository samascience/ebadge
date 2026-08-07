package androidx.camera.core.impl;

import android.util.ArrayMap;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class t extends u implements s {
    private static final Config.OptionPriority L = Config.OptionPriority.OPTIONAL;

    private t(TreeMap treeMap) {
        super(treeMap);
    }

    public static t c0() {
        return new t(new TreeMap(u.J));
    }

    public static t d0(Config config) {
        TreeMap treeMap = new TreeMap(u.J);
        for (Config.a aVar : config.e()) {
            Set<Config.OptionPriority> setH = config.h(aVar);
            ArrayMap arrayMap = new ArrayMap();
            for (Config.OptionPriority optionPriority : setH) {
                arrayMap.put(optionPriority, config.d(aVar, optionPriority));
            }
            treeMap.put(aVar, arrayMap);
        }
        return new t(treeMap);
    }

    public Object e0(Config.a aVar) {
        return this.I.remove(aVar);
    }

    @Override // androidx.camera.core.impl.s
    public void s(Config.a aVar, Config.OptionPriority optionPriority, Object obj) {
        Map map = (Map) this.I.get(aVar);
        if (map == null) {
            ArrayMap arrayMap = new ArrayMap();
            this.I.put(aVar, arrayMap);
            arrayMap.put(optionPriority, obj);
            return;
        }
        Config.OptionPriority optionPriority2 = (Config.OptionPriority) Collections.min(map.keySet());
        if (Objects.equals(map.get(optionPriority2), obj) || !Config.M(optionPriority2, optionPriority)) {
            map.put(optionPriority, obj);
            return;
        }
        throw new IllegalArgumentException("Option values conflicts: " + aVar.c() + ", existing value (" + optionPriority2 + ")=" + map.get(optionPriority2) + ", conflicting (" + optionPriority + ")=" + obj);
    }

    @Override // androidx.camera.core.impl.s
    public void x(Config.a aVar, Object obj) {
        s(aVar, L, obj);
    }
}
