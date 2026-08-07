package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.c;
import defpackage.a91;
import defpackage.ag2;
import defpackage.ay;
import defpackage.d7;
import defpackage.e43;
import defpackage.s51;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class DefaultDeserializationContext extends DeserializationContext implements Serializable {
    private static final long serialVersionUID = 1;
    private List<com.fasterxml.jackson.annotation.a> _objectIdResolvers;
    protected transient LinkedHashMap<ObjectIdGenerator.IdKey, c> _objectIds;

    public static final class Impl extends DefaultDeserializationContext {
        private static final long serialVersionUID = 1;

        public Impl(a aVar) {
            super(aVar, (DeserializerCache) null);
        }

        @Override // com.fasterxml.jackson.databind.deser.DefaultDeserializationContext
        public DefaultDeserializationContext copy() {
            ay.n0(Impl.class, this, "copy");
            return new Impl(this);
        }

        @Override // com.fasterxml.jackson.databind.deser.DefaultDeserializationContext
        public DefaultDeserializationContext createDummyInstance(DeserializationConfig deserializationConfig) {
            return new Impl(this, deserializationConfig);
        }

        @Override // com.fasterxml.jackson.databind.deser.DefaultDeserializationContext
        public DefaultDeserializationContext createInstance(DeserializationConfig deserializationConfig, JsonParser jsonParser, InjectableValues injectableValues) {
            return new Impl(this, deserializationConfig, jsonParser, injectableValues);
        }

        @Override // com.fasterxml.jackson.databind.deser.DefaultDeserializationContext
        public DefaultDeserializationContext with(a aVar) {
            return new Impl(this, aVar);
        }

        private Impl(Impl impl, DeserializationConfig deserializationConfig, JsonParser jsonParser, InjectableValues injectableValues) {
            super(impl, deserializationConfig, jsonParser, injectableValues);
        }

        private Impl(Impl impl) {
            super(impl);
        }

        private Impl(Impl impl, a aVar) {
            super(impl, aVar);
        }

        private Impl(Impl impl, DeserializationConfig deserializationConfig) {
            super(impl, deserializationConfig);
        }
    }

    protected DefaultDeserializationContext(a aVar, DeserializerCache deserializerCache) {
        super(aVar, deserializerCache);
    }

    protected Object _unwrapAndDeserialize(JsonParser jsonParser, JavaType javaType, s51 s51Var, Object obj) throws IOException {
        String simpleName = this._config.findRootName(javaType).getSimpleName();
        JsonToken jsonTokenD = jsonParser.D();
        JsonToken jsonToken = JsonToken.START_OBJECT;
        if (jsonTokenD != jsonToken) {
            reportWrongTokenException(javaType, jsonToken, "Current token not START_OBJECT (needed to unwrap root name %s), but %s", ay.V(simpleName), jsonParser.D());
        }
        JsonToken jsonTokenN1 = jsonParser.n1();
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonTokenN1 != jsonToken2) {
            reportWrongTokenException(javaType, jsonToken2, "Current token not FIELD_NAME (to contain expected root name %s), but %s", ay.V(simpleName), jsonParser.D());
        }
        String strC = jsonParser.C();
        if (!simpleName.equals(strC)) {
            reportPropertyInputMismatch(javaType, strC, "Root name (%s) does not match expected (%s) for type %s", ay.V(strC), ay.V(simpleName), ay.G(javaType));
        }
        jsonParser.n1();
        Object objDeserialize = obj == null ? s51Var.deserialize(jsonParser, this) : s51Var.deserialize(jsonParser, this, obj);
        JsonToken jsonTokenN2 = jsonParser.n1();
        JsonToken jsonToken3 = JsonToken.END_OBJECT;
        if (jsonTokenN2 != jsonToken3) {
            reportWrongTokenException(javaType, jsonToken3, "Current token not END_OBJECT (to match wrapper object with root name %s), but %s", ay.V(simpleName), jsonParser.D());
        }
        return objDeserialize;
    }

    @Override // com.fasterxml.jackson.databind.DeserializationContext
    public void checkUnresolvedObjectId() throws UnresolvedForwardReference {
        if (this._objectIds != null && isEnabled(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS)) {
            Iterator<Map.Entry<ObjectIdGenerator.IdKey, c>> it = this._objectIds.entrySet().iterator();
            UnresolvedForwardReference unresolvedForwardReferenceWithStackTrace = null;
            while (it.hasNext()) {
                c value = it.next().getValue();
                if (value.d() && !tryToResolveUnresolvedObjectId(value)) {
                    if (unresolvedForwardReferenceWithStackTrace == null) {
                        unresolvedForwardReferenceWithStackTrace = new UnresolvedForwardReference(getParser(), "Unresolved forward references for: ").withStackTrace();
                    }
                    Object obj = value.c().key;
                    Iterator itE = value.e();
                    while (itE.hasNext()) {
                        c.a aVar = (c.a) itE.next();
                        unresolvedForwardReferenceWithStackTrace.addUnresolvedId(obj, aVar.a(), aVar.b());
                    }
                }
            }
            if (unresolvedForwardReferenceWithStackTrace != null) {
                throw unresolvedForwardReferenceWithStackTrace;
            }
        }
    }

    public DefaultDeserializationContext copy() {
        throw new IllegalStateException("DefaultDeserializationContext sub-class not overriding copy()");
    }

    public abstract DefaultDeserializationContext createDummyInstance(DeserializationConfig deserializationConfig);

    public abstract DefaultDeserializationContext createInstance(DeserializationConfig deserializationConfig, JsonParser jsonParser, InjectableValues injectableValues);

    protected c createReadableObjectId(ObjectIdGenerator.IdKey idKey) {
        return new c(idKey);
    }

    @Override // com.fasterxml.jackson.databind.DeserializationContext
    public s51 deserializerInstance(d7 d7Var, Object obj) throws JsonMappingException {
        s51 s51Var;
        if (obj == null) {
            return null;
        }
        if (obj instanceof s51) {
            s51Var = (s51) obj;
        } else {
            if (!(obj instanceof Class)) {
                throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + obj.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
            }
            Class cls = (Class) obj;
            if (cls == s51.a.class || ay.J(cls)) {
                return null;
            }
            if (!s51.class.isAssignableFrom(cls)) {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonDeserializer>");
            }
            this._config.getHandlerInstantiator();
            s51Var = (s51) ay.l(cls, this._config.canOverrideAccessModifiers());
        }
        if (s51Var instanceof ag2) {
            ((ag2) s51Var).resolve(this);
        }
        return s51Var;
    }

    @Override // com.fasterxml.jackson.databind.DeserializationContext
    public c findObjectId(Object obj, ObjectIdGenerator<?> objectIdGenerator, com.fasterxml.jackson.annotation.a aVar) {
        if (obj == null) {
            return null;
        }
        ObjectIdGenerator.IdKey idKeyKey = objectIdGenerator.key(obj);
        LinkedHashMap<ObjectIdGenerator.IdKey, c> linkedHashMap = this._objectIds;
        if (linkedHashMap == null) {
            this._objectIds = new LinkedHashMap<>();
        } else {
            c cVar = linkedHashMap.get(idKeyKey);
            if (cVar != null) {
                return cVar;
            }
        }
        List<com.fasterxml.jackson.annotation.a> list = this._objectIdResolvers;
        if (list == null) {
            this._objectIdResolvers = new ArrayList(8);
        } else {
            Iterator<com.fasterxml.jackson.annotation.a> it = list.iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                throw null;
            }
        }
        aVar.a(this);
        this._objectIdResolvers.add(null);
        c cVarCreateReadableObjectId = createReadableObjectId(idKeyKey);
        cVarCreateReadableObjectId.g(null);
        this._objectIds.put(idKeyKey, cVarCreateReadableObjectId);
        return cVarCreateReadableObjectId;
    }

    @Override // com.fasterxml.jackson.databind.DeserializationContext
    public final a91 keyDeserializerInstance(d7 d7Var, Object obj) throws JsonMappingException {
        a91 a91Var;
        if (obj == null) {
            return null;
        }
        if (obj instanceof a91) {
            a91Var = (a91) obj;
        } else {
            if (!(obj instanceof Class)) {
                throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + obj.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
            }
            Class cls = (Class) obj;
            if (cls == a91.a.class || ay.J(cls)) {
                return null;
            }
            if (!a91.class.isAssignableFrom(cls)) {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<KeyDeserializer>");
            }
            this._config.getHandlerInstantiator();
            a91Var = (a91) ay.l(cls, this._config.canOverrideAccessModifiers());
        }
        if (a91Var instanceof ag2) {
            ((ag2) a91Var).resolve(this);
        }
        return a91Var;
    }

    public Object readRootValue(JsonParser jsonParser, JavaType javaType, s51 s51Var, Object obj) throws IOException {
        if (this._config.useRootWrapping()) {
            return _unwrapAndDeserialize(jsonParser, javaType, s51Var, obj);
        }
        return obj == null ? s51Var.deserialize(jsonParser, this) : s51Var.deserialize(jsonParser, this, obj);
    }

    protected boolean tryToResolveUnresolvedObjectId(c cVar) {
        return cVar.h(this);
    }

    public abstract DefaultDeserializationContext with(a aVar);

    protected DefaultDeserializationContext(DefaultDeserializationContext defaultDeserializationContext, DeserializationConfig deserializationConfig, JsonParser jsonParser, InjectableValues injectableValues) {
        super(defaultDeserializationContext, deserializationConfig, jsonParser, injectableValues);
    }

    protected DefaultDeserializationContext(DefaultDeserializationContext defaultDeserializationContext, DeserializationConfig deserializationConfig) {
        super(defaultDeserializationContext, deserializationConfig);
    }

    protected DefaultDeserializationContext(DefaultDeserializationContext defaultDeserializationContext, a aVar) {
        super(defaultDeserializationContext, aVar);
    }

    protected DefaultDeserializationContext(DefaultDeserializationContext defaultDeserializationContext) {
        super(defaultDeserializationContext);
    }
}
