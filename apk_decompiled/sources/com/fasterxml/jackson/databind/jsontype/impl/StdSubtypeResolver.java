package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.a;
import com.fasterxml.jackson.databind.introspect.b;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import defpackage.iw2;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class StdSubtypeResolver extends iw2 implements Serializable {
    private static final long serialVersionUID = 1;
    protected LinkedHashSet<NamedType> _registeredSubtypes;

    public StdSubtypeResolver() {
    }

    protected void _collectAndResolve(a aVar, NamedType namedType, MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector, HashMap<NamedType, NamedType> map) {
        String strFindTypeName;
        if (!namedType.hasName() && (strFindTypeName = annotationIntrospector.findTypeName(aVar)) != null) {
            namedType = new NamedType(namedType.getType(), strFindTypeName);
        }
        NamedType namedType2 = new NamedType(namedType.getType());
        if (map.containsKey(namedType2)) {
            if (!namedType.hasName() || map.get(namedType2).hasName()) {
                return;
            }
            map.put(namedType2, namedType);
            return;
        }
        map.put(namedType2, namedType);
        List<NamedType> listFindSubtypes = annotationIntrospector.findSubtypes(aVar);
        if (listFindSubtypes == null || listFindSubtypes.isEmpty()) {
            return;
        }
        for (NamedType namedType3 : listFindSubtypes) {
            _collectAndResolve(b.n(mapperConfig, namedType3.getType()), namedType3, mapperConfig, annotationIntrospector, map);
        }
    }

    protected void _collectAndResolveByTypeId(a aVar, NamedType namedType, MapperConfig<?> mapperConfig, Set<Class<?>> set, Map<String, NamedType> map) {
        List<NamedType> listFindSubtypes;
        String strFindTypeName;
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        if (!namedType.hasName() && (strFindTypeName = annotationIntrospector.findTypeName(aVar)) != null) {
            namedType = new NamedType(namedType.getType(), strFindTypeName);
        }
        if (namedType.hasName()) {
            map.put(namedType.getName(), namedType);
        }
        if (!set.add(namedType.getType()) || (listFindSubtypes = annotationIntrospector.findSubtypes(aVar)) == null || listFindSubtypes.isEmpty()) {
            return;
        }
        for (NamedType namedType2 : listFindSubtypes) {
            _collectAndResolveByTypeId(b.n(mapperConfig, namedType2.getType()), namedType2, mapperConfig, set, map);
        }
    }

    protected Collection<NamedType> _combineNamedAndUnnamed(Class<?> cls, Set<Class<?>> set, Map<String, NamedType> map) {
        ArrayList arrayList = new ArrayList(map.values());
        Iterator<NamedType> it = map.values().iterator();
        while (it.hasNext()) {
            set.remove(it.next().getType());
        }
        for (Class<?> cls2 : set) {
            if (cls2 != cls || !Modifier.isAbstract(cls2.getModifiers())) {
                arrayList.add(new NamedType(cls2));
            }
        }
        return arrayList;
    }

    @Override // defpackage.iw2
    public Collection<NamedType> collectAndResolveSubtypesByClass(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        Class<?> rawType;
        List<NamedType> listFindSubtypes;
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        if (javaType != null) {
            rawType = javaType.getRawClass();
        } else {
            if (annotatedMember == null) {
                throw new IllegalArgumentException("Both property and base type are nulls");
            }
            rawType = annotatedMember.getRawType();
        }
        HashMap<NamedType, NamedType> map = new HashMap<>();
        LinkedHashSet<NamedType> linkedHashSet = this._registeredSubtypes;
        if (linkedHashSet != null) {
            for (NamedType namedType : linkedHashSet) {
                if (rawType.isAssignableFrom(namedType.getType())) {
                    _collectAndResolve(b.n(mapperConfig, namedType.getType()), namedType, mapperConfig, annotationIntrospector, map);
                }
            }
        }
        if (annotatedMember != null && (listFindSubtypes = annotationIntrospector.findSubtypes(annotatedMember)) != null) {
            for (NamedType namedType2 : listFindSubtypes) {
                _collectAndResolve(b.n(mapperConfig, namedType2.getType()), namedType2, mapperConfig, annotationIntrospector, map);
            }
        }
        _collectAndResolve(b.n(mapperConfig, rawType), new NamedType(rawType, null), mapperConfig, annotationIntrospector, map);
        return new ArrayList(map.values());
    }

    @Override // defpackage.iw2
    public Collection<NamedType> collectAndResolveSubtypesByTypeId(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        List<NamedType> listFindSubtypes;
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        Class<?> rawClass = javaType.getRawClass();
        HashSet hashSet = new HashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        _collectAndResolveByTypeId(b.n(mapperConfig, rawClass), new NamedType(rawClass, null), mapperConfig, hashSet, linkedHashMap);
        if (annotatedMember != null && (listFindSubtypes = annotationIntrospector.findSubtypes(annotatedMember)) != null) {
            for (NamedType namedType : listFindSubtypes) {
                _collectAndResolveByTypeId(b.n(mapperConfig, namedType.getType()), namedType, mapperConfig, hashSet, linkedHashMap);
            }
        }
        LinkedHashSet<NamedType> linkedHashSet = this._registeredSubtypes;
        if (linkedHashSet != null) {
            for (NamedType namedType2 : linkedHashSet) {
                if (rawClass.isAssignableFrom(namedType2.getType())) {
                    _collectAndResolveByTypeId(b.n(mapperConfig, namedType2.getType()), namedType2, mapperConfig, hashSet, linkedHashMap);
                }
            }
        }
        return _combineNamedAndUnnamed(rawClass, hashSet, linkedHashMap);
    }

    @Override // defpackage.iw2
    public iw2 copy() {
        return new StdSubtypeResolver(this);
    }

    @Override // defpackage.iw2
    public void registerSubtypes(NamedType... namedTypeArr) {
        if (this._registeredSubtypes == null) {
            this._registeredSubtypes = new LinkedHashSet<>();
        }
        for (NamedType namedType : namedTypeArr) {
            this._registeredSubtypes.add(namedType);
        }
    }

    protected StdSubtypeResolver(StdSubtypeResolver stdSubtypeResolver) {
        LinkedHashSet<NamedType> linkedHashSet = stdSubtypeResolver._registeredSubtypes;
        this._registeredSubtypes = linkedHashSet == null ? null : new LinkedHashSet<>(linkedHashSet);
    }

    @Override // defpackage.iw2
    public void registerSubtypes(Class<?>... clsArr) {
        NamedType[] namedTypeArr = new NamedType[clsArr.length];
        int length = clsArr.length;
        for (int i = 0; i < length; i++) {
            namedTypeArr[i] = new NamedType(clsArr[i]);
        }
        registerSubtypes(namedTypeArr);
    }

    @Override // defpackage.iw2
    public void registerSubtypes(Collection<Class<?>> collection) {
        NamedType[] namedTypeArr = new NamedType[collection.size()];
        Iterator<Class<?>> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            namedTypeArr[i] = new NamedType(it.next());
            i++;
        }
        registerSubtypes(namedTypeArr);
    }

    @Override // defpackage.iw2
    public Collection<NamedType> collectAndResolveSubtypesByTypeId(MapperConfig<?> mapperConfig, a aVar) {
        Class rawType = aVar.getRawType();
        HashSet hashSet = new HashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        _collectAndResolveByTypeId(aVar, new NamedType(rawType, null), mapperConfig, hashSet, linkedHashMap);
        LinkedHashSet<NamedType> linkedHashSet = this._registeredSubtypes;
        if (linkedHashSet != null) {
            for (NamedType namedType : linkedHashSet) {
                if (rawType.isAssignableFrom(namedType.getType())) {
                    _collectAndResolveByTypeId(b.n(mapperConfig, namedType.getType()), namedType, mapperConfig, hashSet, linkedHashMap);
                }
            }
        }
        return _combineNamedAndUnnamed(rawType, hashSet, linkedHashMap);
    }

    @Override // defpackage.iw2
    public Collection<NamedType> collectAndResolveSubtypesByClass(MapperConfig<?> mapperConfig, a aVar) {
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        HashMap<NamedType, NamedType> map = new HashMap<>();
        if (this._registeredSubtypes != null) {
            Class rawType = aVar.getRawType();
            for (NamedType namedType : this._registeredSubtypes) {
                if (rawType.isAssignableFrom(namedType.getType())) {
                    _collectAndResolve(b.n(mapperConfig, namedType.getType()), namedType, mapperConfig, annotationIntrospector, map);
                }
            }
        }
        _collectAndResolve(aVar, new NamedType(aVar.getRawType(), null), mapperConfig, annotationIntrospector, map);
        return new ArrayList(map.values());
    }
}
