package com.fasterxml.classmate.util;

import defpackage.og2;
import defpackage.pg2;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ConcurrentTypeCache extends ResolvedTypeCache {
    private static final long serialVersionUID = 1;
    protected final transient ConcurrentHashMap<pg2, og2> _map;
    protected final int _maxEntries;

    public ConcurrentTypeCache(int i) {
        this._map = new ConcurrentHashMap<>(i, 0.8f, 4);
        this._maxEntries = i;
    }

    @Override // com.fasterxml.classmate.util.ResolvedTypeCache
    public og2 find(pg2 pg2Var) {
        if (pg2Var != null) {
            return this._map.get(pg2Var);
        }
        throw new IllegalArgumentException("Null key not allowed");
    }

    @Override // com.fasterxml.classmate.util.ResolvedTypeCache
    public void put(pg2 pg2Var, og2 og2Var) {
        if (pg2Var == null) {
            throw new IllegalArgumentException("Null key not allowed");
        }
        if (this._map.size() >= this._maxEntries) {
            synchronized (this) {
                try {
                    if (this._map.size() >= this._maxEntries) {
                        this._map.clear();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this._map.put(pg2Var, og2Var);
    }

    Object readResolve() {
        return new ConcurrentTypeCache(this._maxEntries);
    }

    @Override // com.fasterxml.classmate.util.ResolvedTypeCache
    public int size() {
        return this._map.size();
    }
}
