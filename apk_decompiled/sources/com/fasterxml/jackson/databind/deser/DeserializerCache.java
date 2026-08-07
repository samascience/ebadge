package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.util.LRUMap;
import defpackage.a91;
import defpackage.ag2;
import defpackage.ay;
import defpackage.d7;
import defpackage.f40;
import defpackage.kh;
import defpackage.s51;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class DeserializerCache implements Serializable {
    private static final long serialVersionUID = 1;
    protected final LRUMap<JavaType, s51> _cachedDeserializers;
    protected final HashMap<JavaType, s51> _incompleteDeserializers;

    public DeserializerCache() {
        this(2000);
    }

    private boolean _hasCustomHandlers(JavaType javaType) {
        if (!javaType.isContainerType()) {
            return false;
        }
        JavaType javaTypeMo15getContentType = javaType.mo15getContentType();
        if (javaTypeMo15getContentType == null || (javaTypeMo15getContentType.getValueHandler() == null && javaTypeMo15getContentType.getTypeHandler() == null)) {
            return javaType.isMapLikeType() && javaType.mo16getKeyType().getValueHandler() != null;
        }
        return true;
    }

    private Class<?> _verifyAsClass(Object obj, String str, Class<?> cls) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Class) {
            Class<?> cls2 = (Class) obj;
            if (cls2 == cls || ay.J(cls2)) {
                return null;
            }
            return cls2;
        }
        throw new IllegalStateException("AnnotationIntrospector." + str + "() returned value of type " + obj.getClass().getName() + ": expected type JsonSerializer or Class<JsonSerializer> instead");
    }

    private JavaType modifyTypeByAnnotation(DeserializationContext deserializationContext, d7 d7Var, JavaType javaType) throws JsonMappingException {
        Object objFindContentDeserializer;
        s51 s51VarDeserializerInstance;
        JavaType javaTypeMo16getKeyType;
        Object objFindKeyDeserializer;
        a91 a91VarKeyDeserializerInstance;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            return javaType;
        }
        if (javaType.isMapLikeType() && (javaTypeMo16getKeyType = javaType.mo16getKeyType()) != null && javaTypeMo16getKeyType.getValueHandler() == null && (objFindKeyDeserializer = annotationIntrospector.findKeyDeserializer(d7Var)) != null && (a91VarKeyDeserializerInstance = deserializationContext.keyDeserializerInstance(d7Var, objFindKeyDeserializer)) != null) {
            javaType = ((MapLikeType) javaType).withKeyValueHandler(a91VarKeyDeserializerInstance);
        }
        JavaType javaTypeMo15getContentType = javaType.mo15getContentType();
        if (javaTypeMo15getContentType != null && javaTypeMo15getContentType.getValueHandler() == null && (objFindContentDeserializer = annotationIntrospector.findContentDeserializer(d7Var)) != null) {
            if (objFindContentDeserializer instanceof s51) {
                s51VarDeserializerInstance = (s51) objFindContentDeserializer;
            } else {
                Class<?> cls_verifyAsClass = _verifyAsClass(objFindContentDeserializer, "findContentDeserializer", s51.a.class);
                s51VarDeserializerInstance = cls_verifyAsClass != null ? deserializationContext.deserializerInstance(d7Var, cls_verifyAsClass) : null;
            }
            if (s51VarDeserializerInstance != null) {
                javaType = javaType.withContentValueHandler(s51VarDeserializerInstance);
            }
        }
        return annotationIntrospector.refineDeserializationType(deserializationContext.getConfig(), d7Var, javaType);
    }

    protected s51 _createAndCache2(DeserializationContext deserializationContext, a aVar, JavaType javaType) throws JsonMappingException {
        s51 s51Var_createDeserializer;
        try {
            s51Var_createDeserializer = _createDeserializer(deserializationContext, aVar, javaType);
        } catch (IllegalArgumentException e) {
            deserializationContext.reportBadDefinition(javaType, ay.o(e));
            s51Var_createDeserializer = null;
        }
        if (s51Var_createDeserializer == null) {
            return null;
        }
        boolean z = !_hasCustomHandlers(javaType) && s51Var_createDeserializer.isCachable();
        if (s51Var_createDeserializer instanceof ag2) {
            this._incompleteDeserializers.put(javaType, s51Var_createDeserializer);
            ((ag2) s51Var_createDeserializer).resolve(deserializationContext);
            this._incompleteDeserializers.remove(javaType);
        }
        if (z) {
            this._cachedDeserializers.put(javaType, s51Var_createDeserializer);
        }
        return s51Var_createDeserializer;
    }

    protected s51 _createAndCacheValueDeserializer(DeserializationContext deserializationContext, a aVar, JavaType javaType) throws JsonMappingException {
        s51 s51Var;
        synchronized (this._incompleteDeserializers) {
            try {
                s51 s51Var_findCachedDeserializer = _findCachedDeserializer(javaType);
                if (s51Var_findCachedDeserializer != null) {
                    return s51Var_findCachedDeserializer;
                }
                int size = this._incompleteDeserializers.size();
                if (size > 0 && (s51Var = this._incompleteDeserializers.get(javaType)) != null) {
                    return s51Var;
                }
                try {
                    s51 s51Var_createAndCache2 = _createAndCache2(deserializationContext, aVar, javaType);
                    if (size == 0 && this._incompleteDeserializers.size() > 0) {
                        this._incompleteDeserializers.clear();
                    }
                    return s51Var_createAndCache2;
                } catch (Throwable th) {
                    if (size == 0 && this._incompleteDeserializers.size() > 0) {
                        this._incompleteDeserializers.clear();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    protected s51 _createDeserializer(DeserializationContext deserializationContext, a aVar, JavaType javaType) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        if (javaType.isAbstract() || javaType.isMapLikeType() || javaType.isCollectionLikeType()) {
            javaType = aVar.mapAbstractType(config, javaType);
        }
        kh khVarIntrospect = config.introspect(javaType);
        s51 s51VarFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, khVarIntrospect.t());
        if (s51VarFindDeserializerFromAnnotation != null) {
            return s51VarFindDeserializerFromAnnotation;
        }
        JavaType javaTypeModifyTypeByAnnotation = modifyTypeByAnnotation(deserializationContext, khVarIntrospect.t(), javaType);
        if (javaTypeModifyTypeByAnnotation != javaType) {
            khVarIntrospect = config.introspect(javaTypeModifyTypeByAnnotation);
            javaType = javaTypeModifyTypeByAnnotation;
        }
        Class clsM = khVarIntrospect.m();
        if (clsM != null) {
            return aVar.createBuilderBasedDeserializer(deserializationContext, javaType, khVarIntrospect, clsM);
        }
        f40 f40VarF = khVarIntrospect.f();
        if (f40VarF == null) {
            return _createDeserializer2(deserializationContext, aVar, javaType, khVarIntrospect);
        }
        JavaType javaTypeA = f40VarF.a(deserializationContext.getTypeFactory());
        if (!javaTypeA.hasRawClass(javaType.getRawClass())) {
            khVarIntrospect = config.introspect(javaTypeA);
        }
        return new StdDelegatingDeserializer(f40VarF, javaTypeA, _createDeserializer2(deserializationContext, aVar, javaTypeA, khVarIntrospect));
    }

    protected s51 _createDeserializer2(DeserializationContext deserializationContext, a aVar, JavaType javaType, kh khVar) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        if (javaType.isEnumType()) {
            return aVar.createEnumDeserializer(deserializationContext, javaType, khVar);
        }
        if (javaType.isContainerType()) {
            if (javaType.isArrayType()) {
                return aVar.createArrayDeserializer(deserializationContext, (ArrayType) javaType, khVar);
            }
            if (javaType.isMapLikeType() && khVar.g(null).getShape() != JsonFormat.Shape.OBJECT) {
                MapLikeType mapLikeType = (MapLikeType) javaType;
                return mapLikeType instanceof MapType ? aVar.createMapDeserializer(deserializationContext, (MapType) mapLikeType, khVar) : aVar.createMapLikeDeserializer(deserializationContext, mapLikeType, khVar);
            }
            if (javaType.isCollectionLikeType() && khVar.g(null).getShape() != JsonFormat.Shape.OBJECT) {
                CollectionLikeType collectionLikeType = (CollectionLikeType) javaType;
                return collectionLikeType instanceof CollectionType ? aVar.createCollectionDeserializer(deserializationContext, (CollectionType) collectionLikeType, khVar) : aVar.createCollectionLikeDeserializer(deserializationContext, collectionLikeType, khVar);
            }
        }
        if (javaType.isReferenceType()) {
            return aVar.createReferenceDeserializer(deserializationContext, (ReferenceType) javaType, khVar);
        }
        return JsonNode.class.isAssignableFrom(javaType.getRawClass()) ? aVar.createTreeDeserializer(config, javaType, khVar) : aVar.createBeanDeserializer(deserializationContext, javaType, khVar);
    }

    protected s51 _findCachedDeserializer(JavaType javaType) {
        if (javaType == null) {
            throw new IllegalArgumentException("Null JavaType passed");
        }
        if (_hasCustomHandlers(javaType)) {
            return null;
        }
        return this._cachedDeserializers.get(javaType);
    }

    protected a91 _handleUnknownKeyDeserializer(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        return (a91) deserializationContext.reportBadDefinition(javaType, "Cannot find a (Map) Key deserializer for type " + javaType);
    }

    protected s51 _handleUnknownValueDeserializer(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        if (ay.K(javaType.getRawClass())) {
            return (s51) deserializationContext.reportBadDefinition(javaType, "Cannot find a Value deserializer for type " + javaType);
        }
        return (s51) deserializationContext.reportBadDefinition(javaType, "Cannot find a Value deserializer for abstract type " + javaType);
    }

    public int cachedDeserializersCount() {
        return this._cachedDeserializers.size();
    }

    protected f40 findConverter(DeserializationContext deserializationContext, d7 d7Var) throws JsonMappingException {
        Object objFindDeserializationConverter = deserializationContext.getAnnotationIntrospector().findDeserializationConverter(d7Var);
        if (objFindDeserializationConverter == null) {
            return null;
        }
        return deserializationContext.converterInstance(d7Var, objFindDeserializationConverter);
    }

    protected s51 findConvertingDeserializer(DeserializationContext deserializationContext, d7 d7Var, s51 s51Var) throws JsonMappingException {
        f40 f40VarFindConverter = findConverter(deserializationContext, d7Var);
        return f40VarFindConverter == null ? s51Var : new StdDelegatingDeserializer(f40VarFindConverter, f40VarFindConverter.a(deserializationContext.getTypeFactory()), s51Var);
    }

    protected s51 findDeserializerFromAnnotation(DeserializationContext deserializationContext, d7 d7Var) throws JsonMappingException {
        Object objFindDeserializer = deserializationContext.getAnnotationIntrospector().findDeserializer(d7Var);
        if (objFindDeserializer == null) {
            return null;
        }
        return findConvertingDeserializer(deserializationContext, d7Var, deserializationContext.deserializerInstance(d7Var, objFindDeserializer));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a91 findKeyDeserializer(DeserializationContext deserializationContext, a aVar, JavaType javaType) throws JsonMappingException {
        a91 a91VarCreateKeyDeserializer = aVar.createKeyDeserializer(deserializationContext, javaType);
        if (a91VarCreateKeyDeserializer == 0) {
            return _handleUnknownKeyDeserializer(deserializationContext, javaType);
        }
        if (a91VarCreateKeyDeserializer instanceof ag2) {
            ((ag2) a91VarCreateKeyDeserializer).resolve(deserializationContext);
        }
        return a91VarCreateKeyDeserializer;
    }

    public s51 findValueDeserializer(DeserializationContext deserializationContext, a aVar, JavaType javaType) throws JsonMappingException {
        s51 s51Var_findCachedDeserializer = _findCachedDeserializer(javaType);
        if (s51Var_findCachedDeserializer != null) {
            return s51Var_findCachedDeserializer;
        }
        s51 s51Var_createAndCacheValueDeserializer = _createAndCacheValueDeserializer(deserializationContext, aVar, javaType);
        return s51Var_createAndCacheValueDeserializer == null ? _handleUnknownValueDeserializer(deserializationContext, javaType) : s51Var_createAndCacheValueDeserializer;
    }

    public void flushCachedDeserializers() {
        this._cachedDeserializers.clear();
    }

    public boolean hasValueDeserializerFor(DeserializationContext deserializationContext, a aVar, JavaType javaType) throws JsonMappingException {
        s51 s51Var_findCachedDeserializer = _findCachedDeserializer(javaType);
        if (s51Var_findCachedDeserializer == null) {
            s51Var_findCachedDeserializer = _createAndCacheValueDeserializer(deserializationContext, aVar, javaType);
        }
        return s51Var_findCachedDeserializer != null;
    }

    Object writeReplace() {
        this._incompleteDeserializers.clear();
        return this;
    }

    public DeserializerCache(int i) {
        this._incompleteDeserializers = new HashMap<>(8);
        this._cachedDeserializers = new LRUMap<>(Math.min(64, i >> 2), i);
    }
}
