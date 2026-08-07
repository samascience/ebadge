package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SimpleMixInResolver implements h.a, Serializable {
    private static final long serialVersionUID = 1;
    protected Map<ClassKey, Class<?>> _localMixIns;
    protected final h.a _overrides;

    public SimpleMixInResolver(h.a aVar) {
        this._overrides = aVar;
    }

    public void addLocalDefinition(Class<?> cls, Class<?> cls2) {
        if (this._localMixIns == null) {
            this._localMixIns = new HashMap();
        }
        this._localMixIns.put(new ClassKey(cls), cls2);
    }

    @Override // com.fasterxml.jackson.databind.introspect.h.a
    public Class<?> findMixInClassFor(Class<?> cls) {
        Map<ClassKey, Class<?>> map;
        h.a aVar = this._overrides;
        Class<?> clsFindMixInClassFor = aVar == null ? null : aVar.findMixInClassFor(cls);
        return (clsFindMixInClassFor != null || (map = this._localMixIns) == null) ? clsFindMixInClassFor : map.get(new ClassKey(cls));
    }

    public boolean hasMixIns() {
        if (this._localMixIns != null) {
            return true;
        }
        h.a aVar = this._overrides;
        if (aVar == null) {
            return false;
        }
        if (aVar instanceof SimpleMixInResolver) {
            return ((SimpleMixInResolver) aVar).hasMixIns();
        }
        return true;
    }

    public int localSize() {
        Map<ClassKey, Class<?>> map = this._localMixIns;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public void setLocalDefinitions(Map<Class<?>, Class<?>> map) {
        if (map == null || map.isEmpty()) {
            this._localMixIns = null;
            return;
        }
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<Class<?>, Class<?>> entry : map.entrySet()) {
            map2.put(new ClassKey(entry.getKey()), entry.getValue());
        }
        this._localMixIns = map2;
    }

    public SimpleMixInResolver withOverrides(h.a aVar) {
        return new SimpleMixInResolver(aVar, this._localMixIns);
    }

    public SimpleMixInResolver withoutLocalDefinitions() {
        return new SimpleMixInResolver(this._overrides, null);
    }

    @Override // com.fasterxml.jackson.databind.introspect.h.a
    public SimpleMixInResolver copy() {
        h.a aVar = this._overrides;
        return new SimpleMixInResolver(aVar == null ? null : aVar.copy(), this._localMixIns != null ? new HashMap(this._localMixIns) : null);
    }

    protected SimpleMixInResolver(h.a aVar, Map<ClassKey, Class<?>> map) {
        this._overrides = aVar;
        this._localMixIns = map;
    }
}
