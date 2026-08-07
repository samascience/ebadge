package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class PropertyBasedCreator {
    protected final int a;
    protected final ValueInstantiator b;
    protected final HashMap c;
    protected final SettableBeanProperty[] d;

    static class CaseInsensitiveMap extends HashMap<String, SettableBeanProperty> {
        private static final long serialVersionUID = 1;
        protected final Locale _locale;

        @Deprecated
        public CaseInsensitiveMap() {
            this(Locale.getDefault());
        }

        public static CaseInsensitiveMap construct(Locale locale) {
            return new CaseInsensitiveMap(locale);
        }

        public CaseInsensitiveMap(Locale locale) {
            this._locale = locale;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public SettableBeanProperty get(Object obj) {
            return (SettableBeanProperty) super.get((Object) ((String) obj).toLowerCase(this._locale));
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public SettableBeanProperty put(String str, SettableBeanProperty settableBeanProperty) {
            return (SettableBeanProperty) super.put(str.toLowerCase(this._locale), settableBeanProperty);
        }
    }

    protected PropertyBasedCreator(DeserializationContext deserializationContext, ValueInstantiator valueInstantiator, SettableBeanProperty[] settableBeanPropertyArr, boolean z, boolean z2) {
        this.b = valueInstantiator;
        if (z) {
            this.c = CaseInsensitiveMap.construct(deserializationContext.getConfig().getLocale());
        } else {
            this.c = new HashMap();
        }
        int length = settableBeanPropertyArr.length;
        this.a = length;
        this.d = new SettableBeanProperty[length];
        if (z2) {
            DeserializationConfig config = deserializationContext.getConfig();
            for (SettableBeanProperty settableBeanProperty : settableBeanPropertyArr) {
                if (!settableBeanProperty.isIgnorable()) {
                    List<PropertyName> listFindAliases = settableBeanProperty.findAliases(config);
                    if (!listFindAliases.isEmpty()) {
                        Iterator<PropertyName> it = listFindAliases.iterator();
                        while (it.hasNext()) {
                            this.c.put(it.next().getSimpleName(), settableBeanProperty);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < length; i++) {
            SettableBeanProperty settableBeanProperty2 = settableBeanPropertyArr[i];
            this.d[i] = settableBeanProperty2;
            if (!settableBeanProperty2.isIgnorable()) {
                this.c.put(settableBeanProperty2.getName(), settableBeanProperty2);
            }
        }
    }

    public static PropertyBasedCreator b(DeserializationContext deserializationContext, ValueInstantiator valueInstantiator, SettableBeanProperty[] settableBeanPropertyArr, BeanPropertyMap beanPropertyMap) {
        int length = settableBeanPropertyArr.length;
        SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[length];
        for (int i = 0; i < length; i++) {
            SettableBeanProperty settableBeanPropertyWithValueDeserializer = settableBeanPropertyArr[i];
            if (!settableBeanPropertyWithValueDeserializer.hasValueDeserializer() && !settableBeanPropertyWithValueDeserializer.isInjectionOnly()) {
                settableBeanPropertyWithValueDeserializer = settableBeanPropertyWithValueDeserializer.withValueDeserializer(deserializationContext.findContextualValueDeserializer(settableBeanPropertyWithValueDeserializer.getType(), settableBeanPropertyWithValueDeserializer));
            }
            settableBeanPropertyArr2[i] = settableBeanPropertyWithValueDeserializer;
        }
        return new PropertyBasedCreator(deserializationContext, valueInstantiator, settableBeanPropertyArr2, beanPropertyMap.isCaseInsensitive(), true);
    }

    public static PropertyBasedCreator c(DeserializationContext deserializationContext, ValueInstantiator valueInstantiator, SettableBeanProperty[] settableBeanPropertyArr, boolean z) {
        int length = settableBeanPropertyArr.length;
        SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[length];
        for (int i = 0; i < length; i++) {
            SettableBeanProperty settableBeanPropertyWithValueDeserializer = settableBeanPropertyArr[i];
            if (!settableBeanPropertyWithValueDeserializer.hasValueDeserializer()) {
                settableBeanPropertyWithValueDeserializer = settableBeanPropertyWithValueDeserializer.withValueDeserializer(deserializationContext.findContextualValueDeserializer(settableBeanPropertyWithValueDeserializer.getType(), settableBeanPropertyWithValueDeserializer));
            }
            settableBeanPropertyArr2[i] = settableBeanPropertyWithValueDeserializer;
        }
        return new PropertyBasedCreator(deserializationContext, valueInstantiator, settableBeanPropertyArr2, z, false);
    }

    public Object a(DeserializationContext deserializationContext, b bVar) throws IOException {
        Object objCreateFromObjectWith = this.b.createFromObjectWith(deserializationContext, this.d, bVar);
        if (objCreateFromObjectWith != null) {
            objCreateFromObjectWith = bVar.h(deserializationContext, objCreateFromObjectWith);
            for (a aVarF = bVar.f(); aVarF != null; aVarF = aVarF.a) {
                aVarF.a(objCreateFromObjectWith);
            }
        }
        return objCreateFromObjectWith;
    }

    public SettableBeanProperty d(int i) {
        for (SettableBeanProperty settableBeanProperty : this.c.values()) {
            if (settableBeanProperty.getPropertyIndex() == i) {
                return settableBeanProperty;
            }
        }
        return null;
    }

    public SettableBeanProperty e(String str) {
        return (SettableBeanProperty) this.c.get(str);
    }

    public Collection f() {
        return this.c.values();
    }

    public b g(JsonParser jsonParser, DeserializationContext deserializationContext, ObjectIdReader objectIdReader) {
        return new b(jsonParser, deserializationContext, this.a, objectIdReader);
    }
}
