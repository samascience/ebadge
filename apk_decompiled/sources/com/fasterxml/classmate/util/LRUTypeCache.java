package com.fasterxml.classmate.util;

import defpackage.og2;
import defpackage.pg2;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LRUTypeCache extends ResolvedTypeCache {
    private static final long serialVersionUID = 1;
    protected final transient CacheMap _map;
    protected final int _maxEntries;

    private static final class CacheMap extends LinkedHashMap<pg2, og2> {
        protected final int _maxEntries;

        public CacheMap(int i) {
            this._maxEntries = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<pg2, og2> entry) {
            return size() > this._maxEntries;
        }
    }

    public LRUTypeCache(int i) {
        this._map = new CacheMap(i);
        this._maxEntries = i;
    }

    @Override // com.fasterxml.classmate.util.ResolvedTypeCache
    public synchronized og2 find(pg2 pg2Var) {
        try {
            if (pg2Var == null) {
                throw new IllegalArgumentException("Null key not allowed");
            }
        } catch (Throwable th) {
            throw th;
        }
        return this._map.get(pg2Var);
    }

    @Override // com.fasterxml.classmate.util.ResolvedTypeCache
    public synchronized void put(pg2 pg2Var, og2 og2Var) {
        try {
            if (pg2Var == null) {
                throw new IllegalArgumentException("Null key not allowed");
            }
            this._map.put(pg2Var, og2Var);
        } catch (Throwable th) {
            throw th;
        }
    }

    Object readResolve() {
        return new LRUTypeCache(this._maxEntries);
    }

    @Override // com.fasterxml.classmate.util.ResolvedTypeCache
    public synchronized int size() {
        return this._map.size();
    }
}
