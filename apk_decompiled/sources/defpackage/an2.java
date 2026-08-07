package defpackage;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.databind.introspect.g;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public abstract class an2 extends t60 {
    protected static final boolean CACHE_UNKNOWN_MAPPINGS = false;
    public static final f71 DEFAULT_NULL_KEY_SERIALIZER = new FailingSerializer("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
    protected static final f71 DEFAULT_UNKNOWN_SERIALIZER = new UnknownSerializer();
    protected transient ContextAttributes _attributes;
    protected final SerializationConfig _config;
    protected DateFormat _dateFormat;
    protected f71 _keySerializer;
    protected final bd2 _knownSerializers;
    protected f71 _nullKeySerializer;
    protected f71 _nullValueSerializer;
    protected final Class<?> _serializationView;
    protected final ym2 _serializerCache;
    protected final zm2 _serializerFactory;
    protected final boolean _stdNullValueSerializer;
    protected f71 _unknownTypeSerializer;

    public an2() {
        this._unknownTypeSerializer = DEFAULT_UNKNOWN_SERIALIZER;
        this._nullValueSerializer = NullSerializer.instance;
        this._nullKeySerializer = DEFAULT_NULL_KEY_SERIALIZER;
        this._config = null;
        this._serializerFactory = null;
        this._serializerCache = new ym2();
        this._knownSerializers = null;
        this._serializationView = null;
        this._attributes = null;
        this._stdNullValueSerializer = true;
    }

    protected f71 _createAndCacheUntypedSerializer(Class<?> cls) throws JsonMappingException {
        f71 f71Var_createUntypedSerializer;
        JavaType javaTypeConstructType = this._config.constructType(cls);
        try {
            f71Var_createUntypedSerializer = _createUntypedSerializer(javaTypeConstructType);
        } catch (IllegalArgumentException e) {
            reportBadDefinition(javaTypeConstructType, ay.o(e));
            f71Var_createUntypedSerializer = null;
        }
        if (f71Var_createUntypedSerializer != null) {
            this._serializerCache.c(cls, javaTypeConstructType, f71Var_createUntypedSerializer, this);
        }
        return f71Var_createUntypedSerializer;
    }

    protected f71 _createUntypedSerializer(JavaType javaType) throws JsonMappingException {
        return this._serializerFactory.createSerializer(this, javaType);
    }

    protected final DateFormat _dateFormat() {
        DateFormat dateFormat = this._dateFormat;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this._config.getDateFormat().clone();
        this._dateFormat = dateFormat2;
        return dateFormat2;
    }

    protected f71 _findExplicitUntypedSerializer(Class<?> cls) throws JsonMappingException {
        f71 f71VarH = this._knownSerializers.h(cls);
        if (f71VarH == null && (f71VarH = this._serializerCache.l(cls)) == null) {
            f71VarH = _createAndCacheUntypedSerializer(cls);
        }
        if (isUnknownTypeSerializer(f71VarH)) {
            return null;
        }
        return f71VarH;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected f71 _handleContextualResolvable(f71 f71Var, BeanProperty beanProperty) throws JsonMappingException {
        if (f71Var instanceof cg2) {
            ((cg2) f71Var).resolve(this);
        }
        return handleSecondaryContextualization(f71Var, beanProperty);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected f71 _handleResolvable(f71 f71Var) throws JsonMappingException {
        if (f71Var instanceof cg2) {
            ((cg2) f71Var).resolve(this);
        }
        return f71Var;
    }

    protected void _reportIncompatibleRootType(Object obj, JavaType javaType) throws IOException {
        if (javaType.isPrimitive() && ay.o0(javaType.getRawClass()).isAssignableFrom(obj.getClass())) {
            return;
        }
        reportBadDefinition(javaType, String.format("Incompatible types: declared root type (%s) vs %s", javaType, ay.h(obj)));
    }

    public q33 bufferForValueConversion(jt1 jt1Var) {
        return new q33(jt1Var, false);
    }

    public final boolean canOverrideAccessModifiers() {
        return this._config.canOverrideAccessModifiers();
    }

    public JavaType constructSpecializedType(JavaType javaType, Class<?> cls) throws IllegalArgumentException {
        return javaType.hasRawClass(cls) ? javaType : getConfig().getTypeFactory().constructSpecializedType(javaType, cls, true);
    }

    public void defaultSerializeDateKey(long j, JsonGenerator jsonGenerator) throws IOException {
        if (isEnabled(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
            jsonGenerator.V0(String.valueOf(j));
        } else {
            jsonGenerator.V0(_dateFormat().format(new Date(j)));
        }
    }

    public final void defaultSerializeDateValue(long j, JsonGenerator jsonGenerator) throws IOException {
        if (isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)) {
            jsonGenerator.a1(j);
        } else {
            jsonGenerator.w1(_dateFormat().format(new Date(j)));
        }
    }

    public final void defaultSerializeField(String str, Object obj, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.V0(str);
        if (obj != null) {
            findTypedValueSerializer(obj.getClass(), true, (BeanProperty) null).serialize(obj, jsonGenerator, this);
        } else if (this._stdNullValueSerializer) {
            jsonGenerator.W0();
        } else {
            this._nullValueSerializer.serialize(null, jsonGenerator, this);
        }
    }

    public final void defaultSerializeNull(JsonGenerator jsonGenerator) throws IOException {
        if (this._stdNullValueSerializer) {
            jsonGenerator.W0();
        } else {
            this._nullValueSerializer.serialize(null, jsonGenerator, this);
        }
    }

    public final void defaultSerializeValue(Object obj, JsonGenerator jsonGenerator) throws IOException {
        if (obj != null) {
            findTypedValueSerializer(obj.getClass(), true, (BeanProperty) null).serialize(obj, jsonGenerator, this);
        } else if (this._stdNullValueSerializer) {
            jsonGenerator.W0();
        } else {
            this._nullValueSerializer.serialize(null, jsonGenerator, this);
        }
    }

    public f71 findContentValueSerializer(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarG = this._knownSerializers.g(javaType);
        return (f71VarG == null && (f71VarG = this._serializerCache.k(javaType)) == null && (f71VarG = _createAndCacheUntypedSerializer(javaType)) == null) ? getUnknownTypeSerializer(javaType.getRawClass()) : handleSecondaryContextualization(f71VarG, beanProperty);
    }

    public f71 findKeySerializer(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        return _handleContextualResolvable(this._serializerFactory.createKeySerializer(this, javaType, this._keySerializer), beanProperty);
    }

    public f71 findNullKeySerializer(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        return this._nullKeySerializer;
    }

    public f71 findNullValueSerializer(BeanProperty beanProperty) throws JsonMappingException {
        return this._nullValueSerializer;
    }

    public abstract jl3 findObjectId(Object obj, ObjectIdGenerator objectIdGenerator);

    public f71 findPrimaryPropertySerializer(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarG = this._knownSerializers.g(javaType);
        return (f71VarG == null && (f71VarG = this._serializerCache.k(javaType)) == null && (f71VarG = _createAndCacheUntypedSerializer(javaType)) == null) ? getUnknownTypeSerializer(javaType.getRawClass()) : handlePrimaryContextualization(f71VarG, beanProperty);
    }

    public z63 findTypeSerializer(JavaType javaType) throws JsonMappingException {
        return this._serializerFactory.createTypeSerializer(this._config, javaType);
    }

    public f71 findTypedValueSerializer(Class<?> cls, boolean z, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarF = this._knownSerializers.f(cls);
        if (f71VarF != null) {
            return f71VarF;
        }
        f71 f71VarJ = this._serializerCache.j(cls);
        if (f71VarJ != null) {
            return f71VarJ;
        }
        f71 f71VarFindValueSerializer = findValueSerializer(cls, beanProperty);
        zm2 zm2Var = this._serializerFactory;
        SerializationConfig serializationConfig = this._config;
        z63 z63VarCreateTypeSerializer = zm2Var.createTypeSerializer(serializationConfig, serializationConfig.constructType(cls));
        if (z63VarCreateTypeSerializer != null) {
            f71VarFindValueSerializer = new b73(z63VarCreateTypeSerializer.a(beanProperty), f71VarFindValueSerializer);
        }
        if (z) {
            this._serializerCache.e(cls, f71VarFindValueSerializer);
        }
        return f71VarFindValueSerializer;
    }

    public f71 findValueSerializer(Class<?> cls, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarH = this._knownSerializers.h(cls);
        return (f71VarH == null && (f71VarH = this._serializerCache.l(cls)) == null && (f71VarH = this._serializerCache.k(this._config.constructType(cls))) == null && (f71VarH = _createAndCacheUntypedSerializer(cls)) == null) ? getUnknownTypeSerializer(cls) : handleSecondaryContextualization(f71VarH, beanProperty);
    }

    public final Class<?> getActiveView() {
        return this._serializationView;
    }

    public final AnnotationIntrospector getAnnotationIntrospector() {
        return this._config.getAnnotationIntrospector();
    }

    public Object getAttribute(Object obj) {
        return this._attributes.getAttribute(obj);
    }

    public f71 getDefaultNullKeySerializer() {
        return this._nullKeySerializer;
    }

    public f71 getDefaultNullValueSerializer() {
        return this._nullValueSerializer;
    }

    public final JsonFormat.Value getDefaultPropertyFormat(Class<?> cls) {
        return this._config.getDefaultPropertyFormat(cls);
    }

    public final JsonInclude.Value getDefaultPropertyInclusion(Class<?> cls) {
        return this._config.getDefaultPropertyInclusion(cls);
    }

    public final kn0 getFilterProvider() {
        return this._config.getFilterProvider();
    }

    public abstract JsonGenerator getGenerator();

    public Locale getLocale() {
        return this._config.getLocale();
    }

    public TimeZone getTimeZone() {
        return this._config.getTimeZone();
    }

    @Override // defpackage.t60
    public final TypeFactory getTypeFactory() {
        return this._config.getTypeFactory();
    }

    public f71 getUnknownTypeSerializer(Class<?> cls) {
        return cls == Object.class ? this._unknownTypeSerializer : new UnknownSerializer(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f71 handlePrimaryContextualization(f71 f71Var, BeanProperty beanProperty) throws JsonMappingException {
        return (f71Var == 0 || !(f71Var instanceof w30)) ? f71Var : ((w30) f71Var).createContextual(this, beanProperty);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f71 handleSecondaryContextualization(f71 f71Var, BeanProperty beanProperty) throws JsonMappingException {
        return (f71Var == 0 || !(f71Var instanceof w30)) ? f71Var : ((w30) f71Var).createContextual(this, beanProperty);
    }

    public final boolean hasSerializationFeatures(int i) {
        return this._config.hasSerializationFeatures(i);
    }

    public abstract Object includeFilterInstance(g gVar, Class cls);

    public abstract boolean includeFilterSuppressNulls(Object obj);

    @Override // defpackage.t60
    public JsonMappingException invalidTypeIdException(JavaType javaType, String str, String str2) {
        return InvalidTypeIdException.from(null, _colonConcat(String.format("Could not resolve type id '%s' as a subtype of %s", str, ay.G(javaType)), str2), javaType, str);
    }

    public final boolean isEnabled(MapperFeature mapperFeature) {
        return this._config.isEnabled(mapperFeature);
    }

    public boolean isUnknownTypeSerializer(f71 f71Var) {
        if (f71Var == this._unknownTypeSerializer || f71Var == null) {
            return true;
        }
        return isEnabled(SerializationFeature.FAIL_ON_EMPTY_BEANS) && f71Var.getClass() == UnknownSerializer.class;
    }

    @Deprecated
    public JsonMappingException mappingException(String str, Object... objArr) {
        return JsonMappingException.from(getGenerator(), _format(str, objArr));
    }

    @Override // defpackage.t60
    public <T> T reportBadDefinition(JavaType javaType, String str) throws JsonMappingException {
        throw InvalidDefinitionException.from(getGenerator(), str, javaType);
    }

    public <T> T reportBadPropertyDefinition(kh khVar, g gVar, String str, Object... objArr) throws JsonMappingException {
        throw InvalidDefinitionException.from(getGenerator(), String.format("Invalid definition for property %s (of type %s): %s", gVar != null ? _quotedString(gVar.getName()) : "N/A", khVar != null ? ay.X(khVar.r()) : "N/A", _format(str, objArr)), khVar, gVar);
    }

    public <T> T reportBadTypeDefinition(kh khVar, String str, Object... objArr) throws JsonMappingException {
        throw InvalidDefinitionException.from(getGenerator(), String.format("Invalid type definition for type %s: %s", khVar != null ? ay.X(khVar.r()) : "N/A", _format(str, objArr)), khVar, (g) null);
    }

    public void reportMappingProblem(String str, Object... objArr) throws JsonMappingException {
        throw mappingException(str, objArr);
    }

    public abstract f71 serializerInstance(d7 d7Var, Object obj);

    public void setDefaultKeySerializer(f71 f71Var) {
        if (f71Var == null) {
            throw new IllegalArgumentException("Cannot pass null JsonSerializer");
        }
        this._keySerializer = f71Var;
    }

    public void setNullKeySerializer(f71 f71Var) {
        if (f71Var == null) {
            throw new IllegalArgumentException("Cannot pass null JsonSerializer");
        }
        this._nullKeySerializer = f71Var;
    }

    public void setNullValueSerializer(f71 f71Var) {
        if (f71Var == null) {
            throw new IllegalArgumentException("Cannot pass null JsonSerializer");
        }
        this._nullValueSerializer = f71Var;
    }

    public final q33 bufferForValueConversion() {
        return bufferForValueConversion(null);
    }

    @Override // defpackage.t60
    public final SerializationConfig getConfig() {
        return this._config;
    }

    public final boolean isEnabled(u60 u60Var) {
        return this._config.isEnabled(u60Var);
    }

    @Deprecated
    protected JsonMappingException mappingException(Throwable th, String str, Object... objArr) {
        return JsonMappingException.from(getGenerator(), _format(str, objArr), th);
    }

    public <T> T reportBadDefinition(JavaType javaType, String str, Throwable th) throws JsonMappingException {
        throw InvalidDefinitionException.from(getGenerator(), str, javaType).withCause(th);
    }

    public void reportMappingProblem(Throwable th, String str, Object... objArr) throws JsonMappingException {
        throw JsonMappingException.from(getGenerator(), _format(str, objArr), th);
    }

    /* JADX INFO: renamed from: setAttribute, reason: merged with bridge method [inline-methods] */
    public an2 m0setAttribute(Object obj, Object obj2) {
        this._attributes = this._attributes.withPerCallAttribute(obj, obj2);
        return this;
    }

    public f71 findKeySerializer(Class<?> cls, BeanProperty beanProperty) throws JsonMappingException {
        return findKeySerializer(this._config.constructType(cls), beanProperty);
    }

    public final boolean isEnabled(SerializationFeature serializationFeature) {
        return this._config.isEnabled(serializationFeature);
    }

    public void defaultSerializeDateKey(Date date, JsonGenerator jsonGenerator) throws IOException {
        if (isEnabled(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
            jsonGenerator.V0(String.valueOf(date.getTime()));
        } else {
            jsonGenerator.V0(_dateFormat().format(date));
        }
    }

    public final void defaultSerializeDateValue(Date date, JsonGenerator jsonGenerator) throws IOException {
        if (isEnabled(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)) {
            jsonGenerator.a1(date.getTime());
        } else {
            jsonGenerator.w1(_dateFormat().format(date));
        }
    }

    public <T> T reportBadDefinition(Class<?> cls, String str, Throwable th) throws JsonMappingException {
        throw InvalidDefinitionException.from(getGenerator(), str, constructType(cls)).withCause(th);
    }

    protected f71 _createAndCacheUntypedSerializer(JavaType javaType) throws JsonMappingException {
        f71 f71Var_createUntypedSerializer;
        try {
            f71Var_createUntypedSerializer = _createUntypedSerializer(javaType);
        } catch (IllegalArgumentException e) {
            reportMappingProblem(e, ay.o(e), new Object[0]);
            f71Var_createUntypedSerializer = null;
        }
        if (f71Var_createUntypedSerializer != null) {
            this._serializerCache.b(javaType, f71Var_createUntypedSerializer, this);
        }
        return f71Var_createUntypedSerializer;
    }

    public f71 findContentValueSerializer(Class<?> cls, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarH = this._knownSerializers.h(cls);
        if (f71VarH == null && (f71VarH = this._serializerCache.l(cls)) == null && (f71VarH = this._serializerCache.k(this._config.constructType(cls))) == null && (f71VarH = _createAndCacheUntypedSerializer(cls)) == null) {
            return getUnknownTypeSerializer(cls);
        }
        return handleSecondaryContextualization(f71VarH, beanProperty);
    }

    public f71 findPrimaryPropertySerializer(Class<?> cls, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarH = this._knownSerializers.h(cls);
        if (f71VarH == null && (f71VarH = this._serializerCache.l(cls)) == null && (f71VarH = this._serializerCache.k(this._config.constructType(cls))) == null && (f71VarH = _createAndCacheUntypedSerializer(cls)) == null) {
            return getUnknownTypeSerializer(cls);
        }
        return handlePrimaryContextualization(f71VarH, beanProperty);
    }

    public f71 findValueSerializer(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        if (javaType == null) {
            reportMappingProblem("Null passed for `valueType` of `findValueSerializer()`", new Object[0]);
        }
        f71 f71VarG = this._knownSerializers.g(javaType);
        if (f71VarG == null && (f71VarG = this._serializerCache.k(javaType)) == null && (f71VarG = _createAndCacheUntypedSerializer(javaType)) == null) {
            return getUnknownTypeSerializer(javaType.getRawClass());
        }
        return handleSecondaryContextualization(f71VarG, beanProperty);
    }

    public f71 findTypedValueSerializer(JavaType javaType, boolean z, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarE = this._knownSerializers.e(javaType);
        if (f71VarE != null) {
            return f71VarE;
        }
        f71 f71VarI = this._serializerCache.i(javaType);
        if (f71VarI != null) {
            return f71VarI;
        }
        f71 f71VarFindValueSerializer = findValueSerializer(javaType, beanProperty);
        z63 z63VarCreateTypeSerializer = this._serializerFactory.createTypeSerializer(this._config, javaType);
        if (z63VarCreateTypeSerializer != null) {
            f71VarFindValueSerializer = new b73(z63VarCreateTypeSerializer.a(beanProperty), f71VarFindValueSerializer);
        }
        if (z) {
            this._serializerCache.d(javaType, f71VarFindValueSerializer);
        }
        return f71VarFindValueSerializer;
    }

    protected an2(an2 an2Var, SerializationConfig serializationConfig, zm2 zm2Var) {
        this._unknownTypeSerializer = DEFAULT_UNKNOWN_SERIALIZER;
        this._nullValueSerializer = NullSerializer.instance;
        f71 f71Var = DEFAULT_NULL_KEY_SERIALIZER;
        this._nullKeySerializer = f71Var;
        this._serializerFactory = zm2Var;
        this._config = serializationConfig;
        ym2 ym2Var = an2Var._serializerCache;
        this._serializerCache = ym2Var;
        this._unknownTypeSerializer = an2Var._unknownTypeSerializer;
        this._keySerializer = an2Var._keySerializer;
        f71 f71Var2 = an2Var._nullValueSerializer;
        this._nullValueSerializer = f71Var2;
        this._nullKeySerializer = an2Var._nullKeySerializer;
        this._stdNullValueSerializer = f71Var2 == f71Var;
        this._serializationView = serializationConfig.getActiveView();
        this._attributes = serializationConfig.getAttributes();
        this._knownSerializers = ym2Var.g();
    }

    public f71 findValueSerializer(Class<?> cls) throws JsonMappingException {
        f71 f71VarH = this._knownSerializers.h(cls);
        if (f71VarH != null) {
            return f71VarH;
        }
        f71 f71VarL = this._serializerCache.l(cls);
        if (f71VarL != null) {
            return f71VarL;
        }
        f71 f71VarK = this._serializerCache.k(this._config.constructType(cls));
        if (f71VarK != null) {
            return f71VarK;
        }
        f71 f71Var_createAndCacheUntypedSerializer = _createAndCacheUntypedSerializer(cls);
        return f71Var_createAndCacheUntypedSerializer == null ? getUnknownTypeSerializer(cls) : f71Var_createAndCacheUntypedSerializer;
    }

    public f71 findValueSerializer(JavaType javaType) throws JsonMappingException {
        f71 f71VarG = this._knownSerializers.g(javaType);
        if (f71VarG != null) {
            return f71VarG;
        }
        f71 f71VarK = this._serializerCache.k(javaType);
        if (f71VarK != null) {
            return f71VarK;
        }
        f71 f71Var_createAndCacheUntypedSerializer = _createAndCacheUntypedSerializer(javaType);
        return f71Var_createAndCacheUntypedSerializer == null ? getUnknownTypeSerializer(javaType.getRawClass()) : f71Var_createAndCacheUntypedSerializer;
    }

    protected an2(an2 an2Var) {
        this._unknownTypeSerializer = DEFAULT_UNKNOWN_SERIALIZER;
        this._nullValueSerializer = NullSerializer.instance;
        this._nullKeySerializer = DEFAULT_NULL_KEY_SERIALIZER;
        this._config = null;
        this._serializationView = null;
        this._serializerFactory = null;
        this._knownSerializers = null;
        this._serializerCache = new ym2();
        this._unknownTypeSerializer = an2Var._unknownTypeSerializer;
        this._keySerializer = an2Var._keySerializer;
        this._nullValueSerializer = an2Var._nullValueSerializer;
        this._nullKeySerializer = an2Var._nullKeySerializer;
        this._stdNullValueSerializer = an2Var._stdNullValueSerializer;
    }
}
