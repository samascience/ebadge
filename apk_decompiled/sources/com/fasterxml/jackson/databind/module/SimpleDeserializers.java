package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import defpackage.a91;
import defpackage.kh;
import defpackage.m63;
import defpackage.q90;
import defpackage.s51;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SimpleDeserializers extends q90.a implements Serializable {
    private static final long serialVersionUID = 1;
    protected HashMap<ClassKey, s51> _classMappings = null;
    protected boolean _hasEnumDeserializer = false;

    public SimpleDeserializers() {
    }

    private final s51 _find(JavaType javaType) {
        HashMap<ClassKey, s51> map = this._classMappings;
        if (map == null) {
            return null;
        }
        return map.get(new ClassKey(javaType.getRawClass()));
    }

    public <T> void addDeserializer(Class<T> cls, s51 s51Var) {
        ClassKey classKey = new ClassKey(cls);
        if (this._classMappings == null) {
            this._classMappings = new HashMap<>();
        }
        this._classMappings.put(classKey, s51Var);
        if (cls == Enum.class) {
            this._hasEnumDeserializer = true;
        }
    }

    public void addDeserializers(Map<Class<?>, s51> map) {
        for (Map.Entry<Class<?>, s51> entry : map.entrySet()) {
            addDeserializer(entry.getKey(), entry.getValue());
        }
    }

    @Override // defpackage.q90
    public s51 findArrayDeserializer(ArrayType arrayType, DeserializationConfig deserializationConfig, kh khVar, m63 m63Var, s51 s51Var) throws JsonMappingException {
        return _find(arrayType);
    }

    @Override // defpackage.q90
    public s51 findBeanDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, kh khVar) throws JsonMappingException {
        return _find(javaType);
    }

    @Override // defpackage.q90
    public s51 findCollectionDeserializer(CollectionType collectionType, DeserializationConfig deserializationConfig, kh khVar, m63 m63Var, s51 s51Var) throws JsonMappingException {
        return _find(collectionType);
    }

    @Override // defpackage.q90
    public s51 findCollectionLikeDeserializer(CollectionLikeType collectionLikeType, DeserializationConfig deserializationConfig, kh khVar, m63 m63Var, s51 s51Var) throws JsonMappingException {
        return _find(collectionLikeType);
    }

    @Override // defpackage.q90
    public s51 findEnumDeserializer(Class<?> cls, DeserializationConfig deserializationConfig, kh khVar) throws JsonMappingException {
        HashMap<ClassKey, s51> map = this._classMappings;
        if (map == null) {
            return null;
        }
        s51 s51Var = map.get(new ClassKey(cls));
        return (s51Var == null && this._hasEnumDeserializer && cls.isEnum()) ? this._classMappings.get(new ClassKey(Enum.class)) : s51Var;
    }

    @Override // defpackage.q90
    public s51 findMapDeserializer(MapType mapType, DeserializationConfig deserializationConfig, kh khVar, a91 a91Var, m63 m63Var, s51 s51Var) throws JsonMappingException {
        return _find(mapType);
    }

    @Override // defpackage.q90
    public s51 findMapLikeDeserializer(MapLikeType mapLikeType, DeserializationConfig deserializationConfig, kh khVar, a91 a91Var, m63 m63Var, s51 s51Var) throws JsonMappingException {
        return _find(mapLikeType);
    }

    @Override // defpackage.q90
    public s51 findReferenceDeserializer(ReferenceType referenceType, DeserializationConfig deserializationConfig, kh khVar, m63 m63Var, s51 s51Var) throws JsonMappingException {
        return _find(referenceType);
    }

    @Override // defpackage.q90
    public s51 findTreeNodeDeserializer(Class<? extends JsonNode> cls, DeserializationConfig deserializationConfig, kh khVar) throws JsonMappingException {
        HashMap<ClassKey, s51> map = this._classMappings;
        if (map == null) {
            return null;
        }
        return map.get(new ClassKey(cls));
    }

    public boolean hasDeserializerFor(DeserializationConfig deserializationConfig, Class<?> cls) {
        HashMap<ClassKey, s51> map = this._classMappings;
        return map != null && map.containsKey(new ClassKey(cls));
    }

    public SimpleDeserializers(Map<Class<?>, s51> map) {
        addDeserializers(map);
    }
}
