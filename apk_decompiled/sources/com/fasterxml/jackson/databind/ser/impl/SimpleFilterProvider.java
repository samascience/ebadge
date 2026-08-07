package com.fasterxml.jackson.databind.ser.impl;

import defpackage.i82;
import defpackage.kn0;
import defpackage.nh;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SimpleFilterProvider extends kn0 implements Serializable {
    private static final long serialVersionUID = 1;
    protected boolean _cfgFailOnUnknownId;
    protected i82 _defaultFilter;
    protected final Map<String, i82> _filtersById;

    public SimpleFilterProvider() {
        this(new HashMap());
    }

    private static final Map<String, i82> _convert(Map<String, ?> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof i82) {
                map2.put(entry.getKey(), (i82) value);
            } else {
                if (!(value instanceof nh)) {
                    throw new IllegalArgumentException("Unrecognized filter type (" + value.getClass().getName() + ")");
                }
                map2.put(entry.getKey(), _convert((nh) value));
            }
        }
        return map2;
    }

    @Deprecated
    public SimpleFilterProvider addFilter(String str, nh nhVar) {
        this._filtersById.put(str, _convert(nhVar));
        return this;
    }

    @Deprecated
    public nh findFilter(Object obj) {
        throw new UnsupportedOperationException("Access to deprecated filters not supported");
    }

    @Override // defpackage.kn0
    public i82 findPropertyFilter(Object obj, Object obj2) {
        i82 i82Var = this._filtersById.get(obj);
        if (i82Var != null || (i82Var = this._defaultFilter) != null || !this._cfgFailOnUnknownId) {
            return i82Var;
        }
        throw new IllegalArgumentException("No filter configured with id '" + obj + "' (type " + obj.getClass().getName() + ")");
    }

    public i82 getDefaultFilter() {
        return this._defaultFilter;
    }

    public i82 removeFilter(String str) {
        return this._filtersById.remove(str);
    }

    @Deprecated
    public SimpleFilterProvider setDefaultFilter(nh nhVar) {
        this._defaultFilter = SimpleBeanPropertyFilter.from(nhVar);
        return this;
    }

    public SimpleFilterProvider setFailOnUnknownId(boolean z) {
        this._cfgFailOnUnknownId = z;
        return this;
    }

    public boolean willFailOnUnknownId() {
        return this._cfgFailOnUnknownId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleFilterProvider(Map<String, ?> map) {
        this._cfgFailOnUnknownId = true;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            if (!(it.next() instanceof i82)) {
                this._filtersById = _convert(map);
                return;
            }
        }
        this._filtersById = map;
    }

    public SimpleFilterProvider addFilter(String str, i82 i82Var) {
        this._filtersById.put(str, i82Var);
        return this;
    }

    public SimpleFilterProvider setDefaultFilter(i82 i82Var) {
        this._defaultFilter = i82Var;
        return this;
    }

    public SimpleFilterProvider addFilter(String str, SimpleBeanPropertyFilter simpleBeanPropertyFilter) {
        this._filtersById.put(str, simpleBeanPropertyFilter);
        return this;
    }

    public SimpleFilterProvider setDefaultFilter(SimpleBeanPropertyFilter simpleBeanPropertyFilter) {
        this._defaultFilter = simpleBeanPropertyFilter;
        return this;
    }

    private static final i82 _convert(nh nhVar) {
        return SimpleBeanPropertyFilter.from(nhVar);
    }
}
