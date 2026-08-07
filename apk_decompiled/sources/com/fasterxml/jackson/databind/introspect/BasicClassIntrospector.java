package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.type.SimpleType;
import defpackage.ah;
import defpackage.ay;
import defpackage.kh;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BasicClassIntrospector extends h implements Serializable {
    protected static final ah BOOLEAN_DESC;
    protected static final ah INT_DESC;
    protected static final ah LONG_DESC;
    protected static final ah OBJECT_DESC;
    private static final long serialVersionUID = 2;
    private static final Class<?> CLS_OBJECT = Object.class;
    private static final Class<?> CLS_STRING = String.class;
    private static final Class<?> CLS_JSON_NODE = JsonNode.class;
    protected static final ah STRING_DESC = ah.K(null, SimpleType.constructUnsafe(String.class), b.h(String.class));

    static {
        Class cls = Boolean.TYPE;
        BOOLEAN_DESC = ah.K(null, SimpleType.constructUnsafe(cls), b.h(cls));
        Class cls2 = Integer.TYPE;
        INT_DESC = ah.K(null, SimpleType.constructUnsafe(cls2), b.h(cls2));
        Class cls3 = Long.TYPE;
        LONG_DESC = ah.K(null, SimpleType.constructUnsafe(cls3), b.h(cls3));
        OBJECT_DESC = ah.K(null, SimpleType.constructUnsafe(Object.class), b.h(Object.class));
    }

    protected ah _findStdJdkCollectionDesc(MapperConfig<?> mapperConfig, JavaType javaType) {
        if (_isStdJDKCollection(javaType)) {
            return ah.K(mapperConfig, javaType, _resolveAnnotatedClass(mapperConfig, javaType, mapperConfig));
        }
        return null;
    }

    protected ah _findStdTypeDesc(MapperConfig<?> mapperConfig, JavaType javaType) {
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass.isPrimitive()) {
            if (rawClass == Integer.TYPE) {
                return INT_DESC;
            }
            if (rawClass == Long.TYPE) {
                return LONG_DESC;
            }
            if (rawClass == Boolean.TYPE) {
                return BOOLEAN_DESC;
            }
            return null;
        }
        if (!ay.M(rawClass)) {
            if (CLS_JSON_NODE.isAssignableFrom(rawClass)) {
                return ah.K(mapperConfig, javaType, b.h(rawClass));
            }
            return null;
        }
        if (rawClass == CLS_OBJECT) {
            return OBJECT_DESC;
        }
        if (rawClass == CLS_STRING) {
            return STRING_DESC;
        }
        if (rawClass == Integer.class) {
            return INT_DESC;
        }
        if (rawClass == Long.class) {
            return LONG_DESC;
        }
        if (rawClass == Boolean.class) {
            return BOOLEAN_DESC;
        }
        return null;
    }

    protected boolean _isStdJDKCollection(JavaType javaType) {
        if (javaType.isContainerType() && !javaType.isArrayType()) {
            Class<?> rawClass = javaType.getRawClass();
            if (ay.M(rawClass) && (Collection.class.isAssignableFrom(rawClass) || Map.class.isAssignableFrom(rawClass))) {
                return true;
            }
        }
        return false;
    }

    protected a _resolveAnnotatedClass(MapperConfig<?> mapperConfig, JavaType javaType, h.a aVar) {
        return b.i(mapperConfig, javaType, aVar);
    }

    protected a _resolveAnnotatedWithoutSuperTypes(MapperConfig<?> mapperConfig, JavaType javaType, h.a aVar) {
        return b.m(mapperConfig, javaType, aVar);
    }

    protected k collectProperties(MapperConfig<?> mapperConfig, JavaType javaType, h.a aVar, boolean z) {
        a aVar_resolveAnnotatedClass = _resolveAnnotatedClass(mapperConfig, javaType, aVar);
        return constructPropertyCollector(mapperConfig, aVar_resolveAnnotatedClass, javaType, z, javaType.isRecordType() ? mapperConfig.getAccessorNaming().forRecord(mapperConfig, aVar_resolveAnnotatedClass) : mapperConfig.getAccessorNaming().forPOJO(mapperConfig, aVar_resolveAnnotatedClass));
    }

    protected k collectPropertiesWithBuilder(MapperConfig<?> mapperConfig, JavaType javaType, h.a aVar, kh khVar, boolean z) {
        a aVar_resolveAnnotatedClass = _resolveAnnotatedClass(mapperConfig, javaType, aVar);
        return constructPropertyCollector(mapperConfig, aVar_resolveAnnotatedClass, javaType, z, mapperConfig.getAccessorNaming().forBuilder(mapperConfig, aVar_resolveAnnotatedClass, khVar));
    }

    protected k constructPropertyCollector(MapperConfig<?> mapperConfig, a aVar, JavaType javaType, boolean z, AccessorNamingStrategy accessorNamingStrategy) {
        return new k(mapperConfig, z, javaType, aVar, accessorNamingStrategy);
    }

    @Override // com.fasterxml.jackson.databind.introspect.h
    public h copy() {
        return new BasicClassIntrospector();
    }

    @Override // com.fasterxml.jackson.databind.introspect.h
    public /* bridge */ /* synthetic */ kh forClassAnnotations(MapperConfig mapperConfig, JavaType javaType, h.a aVar) {
        return forClassAnnotations((MapperConfig<?>) mapperConfig, javaType, aVar);
    }

    @Override // com.fasterxml.jackson.databind.introspect.h
    public /* bridge */ /* synthetic */ kh forDirectClassAnnotations(MapperConfig mapperConfig, JavaType javaType, h.a aVar) {
        return forDirectClassAnnotations((MapperConfig<?>) mapperConfig, javaType, aVar);
    }

    @Deprecated
    protected k constructPropertyCollector(MapperConfig<?> mapperConfig, a aVar, JavaType javaType, boolean z, String str) {
        return new k(mapperConfig, z, javaType, aVar, str);
    }

    @Override // com.fasterxml.jackson.databind.introspect.h
    public ah forClassAnnotations(MapperConfig<?> mapperConfig, JavaType javaType, h.a aVar) {
        ah ahVar_findStdTypeDesc = _findStdTypeDesc(mapperConfig, javaType);
        return ahVar_findStdTypeDesc == null ? ah.K(mapperConfig, javaType, _resolveAnnotatedClass(mapperConfig, javaType, aVar)) : ahVar_findStdTypeDesc;
    }

    @Override // com.fasterxml.jackson.databind.introspect.h
    public ah forCreation(DeserializationConfig deserializationConfig, JavaType javaType, h.a aVar) {
        ah ahVar_findStdTypeDesc = _findStdTypeDesc(deserializationConfig, javaType);
        if (ahVar_findStdTypeDesc != null) {
            return ahVar_findStdTypeDesc;
        }
        ah ahVar_findStdJdkCollectionDesc = _findStdJdkCollectionDesc(deserializationConfig, javaType);
        return ahVar_findStdJdkCollectionDesc == null ? ah.J(collectProperties(deserializationConfig, javaType, aVar, false)) : ahVar_findStdJdkCollectionDesc;
    }

    @Override // com.fasterxml.jackson.databind.introspect.h
    public ah forDeserialization(DeserializationConfig deserializationConfig, JavaType javaType, h.a aVar) {
        ah ahVar_findStdTypeDesc = _findStdTypeDesc(deserializationConfig, javaType);
        if (ahVar_findStdTypeDesc != null) {
            return ahVar_findStdTypeDesc;
        }
        ah ahVar_findStdJdkCollectionDesc = _findStdJdkCollectionDesc(deserializationConfig, javaType);
        return ahVar_findStdJdkCollectionDesc == null ? ah.J(collectProperties(deserializationConfig, javaType, aVar, false)) : ahVar_findStdJdkCollectionDesc;
    }

    @Override // com.fasterxml.jackson.databind.introspect.h
    public ah forDirectClassAnnotations(MapperConfig<?> mapperConfig, JavaType javaType, h.a aVar) {
        ah ahVar_findStdTypeDesc = _findStdTypeDesc(mapperConfig, javaType);
        return ahVar_findStdTypeDesc == null ? ah.K(mapperConfig, javaType, _resolveAnnotatedWithoutSuperTypes(mapperConfig, javaType, aVar)) : ahVar_findStdTypeDesc;
    }

    @Override // com.fasterxml.jackson.databind.introspect.h
    public ah forSerialization(SerializationConfig serializationConfig, JavaType javaType, h.a aVar) {
        ah ahVar_findStdTypeDesc = _findStdTypeDesc(serializationConfig, javaType);
        if (ahVar_findStdTypeDesc != null) {
            return ahVar_findStdTypeDesc;
        }
        ah ahVar_findStdJdkCollectionDesc = _findStdJdkCollectionDesc(serializationConfig, javaType);
        return ahVar_findStdJdkCollectionDesc == null ? ah.L(collectProperties(serializationConfig, javaType, aVar, true)) : ahVar_findStdJdkCollectionDesc;
    }

    @Override // com.fasterxml.jackson.databind.introspect.h
    public ah forDeserializationWithBuilder(DeserializationConfig deserializationConfig, JavaType javaType, h.a aVar, kh khVar) {
        return ah.J(collectPropertiesWithBuilder(deserializationConfig, javaType, aVar, khVar, false));
    }

    @Override // com.fasterxml.jackson.databind.introspect.h
    @Deprecated
    public ah forDeserializationWithBuilder(DeserializationConfig deserializationConfig, JavaType javaType, h.a aVar) {
        return ah.J(collectPropertiesWithBuilder(deserializationConfig, javaType, aVar, null, false));
    }

    @Deprecated
    protected k collectPropertiesWithBuilder(MapperConfig<?> mapperConfig, JavaType javaType, h.a aVar, boolean z) {
        return collectPropertiesWithBuilder(mapperConfig, javaType, aVar, null, z);
    }

    @Deprecated
    protected k collectProperties(MapperConfig<?> mapperConfig, JavaType javaType, h.a aVar, boolean z, String str) {
        a aVar_resolveAnnotatedClass = _resolveAnnotatedClass(mapperConfig, javaType, aVar);
        return constructPropertyCollector(mapperConfig, aVar_resolveAnnotatedClass, javaType, z, new DefaultAccessorNamingStrategy.Provider().withSetterPrefix(str).forPOJO(mapperConfig, aVar_resolveAnnotatedClass));
    }
}
