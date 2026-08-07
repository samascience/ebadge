package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.util.internal.PrivateMaxEntriesMap;
import defpackage.be1;
import java.io.Serializable;
import java.util.Map;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes.dex */
public class LRUMap<K, V> implements be1, Serializable {
    private static final long serialVersionUID = 2;
    protected final int _initialEntries;
    protected final transient PrivateMaxEntriesMap<K, V> _map;
    protected final int _maxEntries;

    public LRUMap(int i, int i2) {
        this._initialEntries = i;
        this._maxEntries = i2;
        this._map = new PrivateMaxEntriesMap.c().c(i).d(i2).b(4).a();
    }

    @Override // defpackage.be1
    public void clear() {
        this._map.clear();
    }

    public void contents(BiConsumer<K, V> biConsumer) {
        for (Map.Entry<K, V> entry : this._map.entrySet()) {
            biConsumer.accept(entry.getKey(), entry.getValue());
        }
    }

    @Override // defpackage.be1
    public V get(Object obj) {
        return this._map.get(obj);
    }

    public V put(K k, V v) {
        return this._map.put(k, v);
    }

    @Override // defpackage.be1
    public V putIfAbsent(K k, V v) {
        return this._map.putIfAbsent(k, v);
    }

    protected Object readResolve() {
        return new LRUMap(this._initialEntries, this._maxEntries);
    }

    public int size() {
        return this._map.size();
    }
}
