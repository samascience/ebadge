package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.u;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class u implements Config {
    protected static final Comparator J;
    private static final u K;
    protected final TreeMap I;

    static {
        Comparator comparator = new Comparator() { // from class: sx1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return u.b0((Config.a) obj, (Config.a) obj2);
            }
        };
        J = comparator;
        K = new u(new TreeMap(comparator));
    }

    u(TreeMap treeMap) {
        this.I = treeMap;
    }

    public static u Z() {
        return K;
    }

    public static u a0(Config config) {
        if (u.class.equals(config.getClass())) {
            return (u) config;
        }
        TreeMap treeMap = new TreeMap(J);
        for (Config.a aVar : config.e()) {
            Set<Config.OptionPriority> setH = config.h(aVar);
            ArrayMap arrayMap = new ArrayMap();
            for (Config.OptionPriority optionPriority : setH) {
                arrayMap.put(optionPriority, config.d(aVar, optionPriority));
            }
            treeMap.put(aVar, arrayMap);
        }
        return new u(treeMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b0(Config.a aVar, Config.a aVar2) {
        return aVar.c().compareTo(aVar2.c());
    }

    @Override // androidx.camera.core.impl.Config
    public Object a(Config.a aVar) {
        Map map = (Map) this.I.get(aVar);
        if (map != null) {
            return map.get((Config.OptionPriority) Collections.min(map.keySet()));
        }
        throw new IllegalArgumentException("Option does not exist: " + aVar);
    }

    @Override // androidx.camera.core.impl.Config
    public boolean b(Config.a aVar) {
        return this.I.containsKey(aVar);
    }

    @Override // androidx.camera.core.impl.Config
    public void c(String str, Config.b bVar) {
        for (Map.Entry entry : this.I.tailMap(Config.a.a(str, Void.class)).entrySet()) {
            if (!((Config.a) entry.getKey()).c().startsWith(str) || !bVar.a((Config.a) entry.getKey())) {
                return;
            }
        }
    }

    @Override // androidx.camera.core.impl.Config
    public Object d(Config.a aVar, Config.OptionPriority optionPriority) {
        Map map = (Map) this.I.get(aVar);
        if (map == null) {
            throw new IllegalArgumentException("Option does not exist: " + aVar);
        }
        if (map.containsKey(optionPriority)) {
            return map.get(optionPriority);
        }
        throw new IllegalArgumentException("Option does not exist: " + aVar + " with priority=" + optionPriority);
    }

    @Override // androidx.camera.core.impl.Config
    public Set e() {
        return Collections.unmodifiableSet(this.I.keySet());
    }

    @Override // androidx.camera.core.impl.Config
    public Object f(Config.a aVar, Object obj) {
        try {
            return a(aVar);
        } catch (IllegalArgumentException unused) {
            return obj;
        }
    }

    @Override // androidx.camera.core.impl.Config
    public Config.OptionPriority g(Config.a aVar) {
        Map map = (Map) this.I.get(aVar);
        if (map != null) {
            return (Config.OptionPriority) Collections.min(map.keySet());
        }
        throw new IllegalArgumentException("Option does not exist: " + aVar);
    }

    @Override // androidx.camera.core.impl.Config
    public Set h(Config.a aVar) {
        Map map = (Map) this.I.get(aVar);
        return map == null ? Collections.emptySet() : Collections.unmodifiableSet(map.keySet());
    }
}
