package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.g;
import com.fasterxml.jackson.databind.node.ObjectNode;
import defpackage.an2;
import defpackage.ay;
import defpackage.d7;
import defpackage.d71;
import defpackage.f71;
import defpackage.jl3;
import defpackage.tk2;
import defpackage.y51;
import defpackage.z63;
import defpackage.zm2;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class DefaultSerializerProvider extends an2 implements Serializable {
    private static final long serialVersionUID = 1;
    protected transient JsonGenerator _generator;
    protected transient ArrayList<ObjectIdGenerator<?>> _objectIdGenerators;
    protected transient Map<Object, jl3> _seenObjectIds;

    public static final class Impl extends DefaultSerializerProvider {
        private static final long serialVersionUID = 1;

        public Impl() {
        }

        @Override // com.fasterxml.jackson.databind.ser.DefaultSerializerProvider
        public DefaultSerializerProvider copy() {
            return new Impl(this);
        }

        public Impl(Impl impl) {
            super(impl);
        }

        @Override // com.fasterxml.jackson.databind.ser.DefaultSerializerProvider
        public Impl createInstance(SerializationConfig serializationConfig, zm2 zm2Var) {
            return new Impl(this, serializationConfig, zm2Var);
        }

        protected Impl(an2 an2Var, SerializationConfig serializationConfig, zm2 zm2Var) {
            super(an2Var, serializationConfig, zm2Var);
        }
    }

    protected DefaultSerializerProvider() {
    }

    private final void _serialize(JsonGenerator jsonGenerator, Object obj, f71 f71Var, PropertyName propertyName) throws IOException {
        try {
            jsonGenerator.s1();
            jsonGenerator.U0(propertyName.simpleAsEncoded(this._config));
            f71Var.serialize(obj, jsonGenerator, this);
            jsonGenerator.S0();
        } catch (Exception e) {
            throw _wrapAsIOE(jsonGenerator, e);
        }
    }

    private IOException _wrapAsIOE(JsonGenerator jsonGenerator, Exception exc) {
        if (exc instanceof IOException) {
            return (IOException) exc;
        }
        String strO = ay.o(exc);
        if (strO == null) {
            strO = "[no message for " + exc.getClass().getName() + "]";
        }
        return new JsonMappingException(jsonGenerator, strO, exc);
    }

    protected Map<Object, jl3> _createObjectIdMap() {
        return isEnabled(SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID) ? new HashMap() : new IdentityHashMap();
    }

    protected void _serializeNull(JsonGenerator jsonGenerator) throws IOException {
        try {
            getDefaultNullValueSerializer().serialize(null, jsonGenerator, this);
        } catch (Exception e) {
            throw _wrapAsIOE(jsonGenerator, e);
        }
    }

    public void acceptJsonFormatVisitor(JavaType javaType, y51 y51Var) throws JsonMappingException {
        if (javaType == null) {
            throw new IllegalArgumentException("A class must be provided");
        }
        y51Var.a(this);
        findValueSerializer(javaType, (BeanProperty) null).acceptJsonFormatVisitor(y51Var, javaType);
    }

    public int cachedSerializersCount() {
        return this._serializerCache.h();
    }

    public DefaultSerializerProvider copy() {
        throw new IllegalStateException("DefaultSerializerProvider sub-class not overriding copy()");
    }

    public abstract DefaultSerializerProvider createInstance(SerializationConfig serializationConfig, zm2 zm2Var);

    /* JADX WARN: Code duplicated, block: B:19:0x003e  */
    @Override // defpackage.an2
    public jl3 findObjectId(Object obj, ObjectIdGenerator<?> objectIdGenerator) {
        ObjectIdGenerator<?> objectIdGeneratorNewForSerialization;
        Map<Object, jl3> map = this._seenObjectIds;
        if (map == null) {
            this._seenObjectIds = _createObjectIdMap();
        } else {
            jl3 jl3Var = map.get(obj);
            if (jl3Var != null) {
                return jl3Var;
            }
        }
        ArrayList<ObjectIdGenerator<?>> arrayList = this._objectIdGenerators;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    objectIdGeneratorNewForSerialization = this._objectIdGenerators.get(i);
                    if (objectIdGeneratorNewForSerialization.canUseFor(objectIdGenerator)) {
                        break;
                    }
                    i++;
                }
            }
            if (objectIdGeneratorNewForSerialization == null) {
                objectIdGeneratorNewForSerialization = objectIdGenerator.newForSerialization(this);
                this._objectIdGenerators.add(objectIdGeneratorNewForSerialization);
            }
            jl3 jl3Var2 = new jl3(objectIdGeneratorNewForSerialization);
            this._seenObjectIds.put(obj, jl3Var2);
            return jl3Var2;
        }
        this._objectIdGenerators = new ArrayList<>(8);
        objectIdGeneratorNewForSerialization = null;
        if (objectIdGeneratorNewForSerialization == null) {
            objectIdGeneratorNewForSerialization = objectIdGenerator.newForSerialization(this);
            this._objectIdGenerators.add(objectIdGeneratorNewForSerialization);
        }
        jl3 jl3Var3 = new jl3(objectIdGeneratorNewForSerialization);
        this._seenObjectIds.put(obj, jl3Var3);
        return jl3Var3;
    }

    public void flushCachedSerializers() {
        this._serializerCache.f();
    }

    @Deprecated
    public d71 generateJsonSchema(Class<?> cls) throws JsonMappingException {
        Object objFindValueSerializer = findValueSerializer(cls, (BeanProperty) null);
        JsonNode schema = objFindValueSerializer instanceof tk2 ? ((tk2) objFindValueSerializer).getSchema(this, null) : d71.a();
        if (schema instanceof ObjectNode) {
            return new d71((ObjectNode) schema);
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " would not be serialized as a JSON object and therefore has no schema");
    }

    @Override // defpackage.an2
    public JsonGenerator getGenerator() {
        return this._generator;
    }

    public boolean hasSerializerFor(Class<?> cls, AtomicReference<Throwable> atomicReference) {
        if (cls == Object.class && !this._config.isEnabled(SerializationFeature.FAIL_ON_EMPTY_BEANS)) {
            return true;
        }
        try {
            return _findExplicitUntypedSerializer(cls) != null;
        } catch (JsonMappingException e) {
            if (atomicReference != null) {
                atomicReference.set(e);
            }
            return false;
        } catch (RuntimeException e2) {
            if (atomicReference == null) {
                throw e2;
            }
            atomicReference.set(e2);
            return false;
        }
    }

    @Override // defpackage.an2
    public Object includeFilterInstance(g gVar, Class<?> cls) {
        if (cls == null) {
            return null;
        }
        this._config.getHandlerInstantiator();
        return ay.l(cls, this._config.canOverrideAccessModifiers());
    }

    @Override // defpackage.an2
    public boolean includeFilterSuppressNulls(Object obj) throws JsonMappingException {
        if (obj == null) {
            return true;
        }
        try {
            return obj.equals(null);
        } catch (Exception e) {
            reportBadDefinition(obj.getClass(), String.format("Problem determining whether filter of type '%s' should filter out `null` values: (%s) %s", obj.getClass().getName(), e.getClass().getName(), ay.o(e)), e);
            return false;
        }
    }

    public void serializePolymorphic(JsonGenerator jsonGenerator, Object obj, JavaType javaType, f71 f71Var, z63 z63Var) throws IOException {
        boolean zIsEnabled;
        this._generator = jsonGenerator;
        if (obj == null) {
            _serializeNull(jsonGenerator);
            return;
        }
        if (javaType != null && !javaType.getRawClass().isAssignableFrom(obj.getClass())) {
            _reportIncompatibleRootType(obj, javaType);
        }
        if (f71Var == null) {
            f71Var = (javaType == null || !javaType.isContainerType()) ? findValueSerializer(obj.getClass(), (BeanProperty) null) : findValueSerializer(javaType, (BeanProperty) null);
        }
        PropertyName fullRootName = this._config.getFullRootName();
        if (fullRootName == null) {
            zIsEnabled = this._config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE);
            if (zIsEnabled) {
                jsonGenerator.s1();
                jsonGenerator.U0(this._config.findRootName(obj.getClass()).simpleAsEncoded(this._config));
            }
        } else if (fullRootName.isEmpty()) {
            zIsEnabled = false;
        } else {
            jsonGenerator.s1();
            jsonGenerator.V0(fullRootName.getSimpleName());
            zIsEnabled = true;
        }
        try {
            f71Var.serializeWithType(obj, jsonGenerator, this, z63Var);
            if (zIsEnabled) {
                jsonGenerator.S0();
            }
        } catch (Exception e) {
            throw _wrapAsIOE(jsonGenerator, e);
        }
    }

    public void serializeValue(JsonGenerator jsonGenerator, Object obj) throws IOException {
        this._generator = jsonGenerator;
        if (obj == null) {
            _serializeNull(jsonGenerator);
            return;
        }
        Class<?> cls = obj.getClass();
        f71 f71VarFindTypedValueSerializer = findTypedValueSerializer(cls, true, (BeanProperty) null);
        PropertyName fullRootName = this._config.getFullRootName();
        if (fullRootName == null) {
            if (this._config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE)) {
                _serialize(jsonGenerator, obj, f71VarFindTypedValueSerializer, this._config.findRootName(cls));
                return;
            }
        } else if (!fullRootName.isEmpty()) {
            _serialize(jsonGenerator, obj, f71VarFindTypedValueSerializer, fullRootName);
            return;
        }
        _serialize(jsonGenerator, obj, f71VarFindTypedValueSerializer);
    }

    @Override // defpackage.an2
    public f71 serializerInstance(d7 d7Var, Object obj) throws JsonMappingException {
        f71 f71Var;
        if (obj == null) {
            return null;
        }
        if (obj instanceof f71) {
            f71Var = (f71) obj;
        } else {
            if (!(obj instanceof Class)) {
                reportBadDefinition(d7Var.getType(), "AnnotationIntrospector returned serializer definition of type " + obj.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
            }
            Class cls = (Class) obj;
            if (cls == f71.a.class || ay.J(cls)) {
                return null;
            }
            if (!f71.class.isAssignableFrom(cls)) {
                reportBadDefinition(d7Var.getType(), "AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonSerializer>");
            }
            this._config.getHandlerInstantiator();
            f71Var = (f71) ay.l(cls, this._config.canOverrideAccessModifiers());
        }
        return _handleResolvable(f71Var);
    }

    protected DefaultSerializerProvider(an2 an2Var, SerializationConfig serializationConfig, zm2 zm2Var) {
        super(an2Var, serializationConfig, zm2Var);
    }

    protected DefaultSerializerProvider(DefaultSerializerProvider defaultSerializerProvider) {
        super(defaultSerializerProvider);
    }

    private final void _serialize(JsonGenerator jsonGenerator, Object obj, f71 f71Var) throws IOException {
        try {
            f71Var.serialize(obj, jsonGenerator, this);
        } catch (Exception e) {
            throw _wrapAsIOE(jsonGenerator, e);
        }
    }

    public void serializeValue(JsonGenerator jsonGenerator, Object obj, JavaType javaType) throws IOException {
        this._generator = jsonGenerator;
        if (obj == null) {
            _serializeNull(jsonGenerator);
            return;
        }
        if (!javaType.getRawClass().isAssignableFrom(obj.getClass())) {
            _reportIncompatibleRootType(obj, javaType);
        }
        f71 f71VarFindTypedValueSerializer = findTypedValueSerializer(javaType, true, (BeanProperty) null);
        PropertyName fullRootName = this._config.getFullRootName();
        if (fullRootName == null) {
            if (this._config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE)) {
                _serialize(jsonGenerator, obj, f71VarFindTypedValueSerializer, this._config.findRootName(javaType));
                return;
            }
        } else if (!fullRootName.isEmpty()) {
            _serialize(jsonGenerator, obj, f71VarFindTypedValueSerializer, fullRootName);
            return;
        }
        _serialize(jsonGenerator, obj, f71VarFindTypedValueSerializer);
    }

    public void serializeValue(JsonGenerator jsonGenerator, Object obj, JavaType javaType, f71 f71Var) throws IOException {
        PropertyName propertyNameFindRootName;
        this._generator = jsonGenerator;
        if (obj == null) {
            _serializeNull(jsonGenerator);
            return;
        }
        if (javaType != null && !javaType.getRawClass().isAssignableFrom(obj.getClass())) {
            _reportIncompatibleRootType(obj, javaType);
        }
        if (f71Var == null) {
            f71Var = findTypedValueSerializer(javaType, true, (BeanProperty) null);
        }
        PropertyName fullRootName = this._config.getFullRootName();
        if (fullRootName == null) {
            if (this._config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE)) {
                if (javaType == null) {
                    propertyNameFindRootName = this._config.findRootName(obj.getClass());
                } else {
                    propertyNameFindRootName = this._config.findRootName(javaType);
                }
                _serialize(jsonGenerator, obj, f71Var, propertyNameFindRootName);
                return;
            }
        } else if (!fullRootName.isEmpty()) {
            _serialize(jsonGenerator, obj, f71Var, fullRootName);
            return;
        }
        _serialize(jsonGenerator, obj, f71Var);
    }
}
