package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.deser.DeserializerCache;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.g;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import defpackage.a91;
import defpackage.ay;
import defpackage.d41;
import defpackage.d7;
import defpackage.e43;
import defpackage.it1;
import defpackage.kh;
import defpackage.m63;
import defpackage.n63;
import defpackage.p9;
import defpackage.pb1;
import defpackage.q33;
import defpackage.s51;
import defpackage.t60;
import defpackage.u60;
import defpackage.v30;
import defpackage.z53;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class DeserializationContext extends t60 implements Serializable {
    private static final long serialVersionUID = 1;
    protected transient p9 _arrayBuilders;
    protected transient ContextAttributes _attributes;
    protected final DeserializerCache _cache;
    protected final DeserializationConfig _config;
    protected pb1 _currentType;
    protected transient DateFormat _dateFormat;
    protected final com.fasterxml.jackson.databind.deser.a _factory;
    protected final int _featureFlags;
    protected final InjectableValues _injectableValues;
    protected transient it1 _objectBuffer;
    protected transient JsonParser _parser;
    protected final d41 _readCapabilities;
    protected final Class<?> _view;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            a = iArr;
            try {
                iArr[JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonToken.END_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonToken.FIELD_NAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonToken.START_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[JsonToken.END_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[JsonToken.VALUE_FALSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[JsonToken.VALUE_TRUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[JsonToken.VALUE_STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[JsonToken.VALUE_NULL.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[JsonToken.NOT_AVAILABLE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    protected DeserializationContext(com.fasterxml.jackson.databind.deser.a aVar) {
        this(aVar, (DeserializerCache) null);
    }

    private z53 _treeAsTokens(JsonNode jsonNode) throws IOException {
        JsonParser jsonParser = this._parser;
        z53 z53Var = new z53(jsonNode, jsonParser == null ? null : jsonParser.t0());
        z53Var.n1();
        return z53Var;
    }

    protected DateFormat _getDateFormat() {
        DateFormat dateFormat = this._dateFormat;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this._config.getDateFormat().clone();
        this._dateFormat = dateFormat2;
        return dateFormat2;
    }

    protected boolean _isCompatible(Class<?> cls, Object obj) {
        if (obj == null || cls.isInstance(obj)) {
            return true;
        }
        return cls.isPrimitive() && ay.o0(cls).isInstance(obj);
    }

    protected String _shapeForToken(JsonToken jsonToken) {
        if (jsonToken == null) {
            return "<end of input>";
        }
        switch (a.a[jsonToken.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return "Object value";
            case 4:
            case 5:
                return "Array value";
            case 6:
            case 7:
                return "Boolean value";
            case 8:
                return "Embedded Object";
            case 9:
                return "Floating-point value";
            case 10:
                return "Integer value";
            case 11:
                return "String value";
            case 12:
                return "Null value";
            default:
                return "[Unavailable value]";
        }
    }

    public q33 bufferAsCopyOfValue(JsonParser jsonParser) throws IOException {
        q33 q33VarBufferForInputBuffering = bufferForInputBuffering(jsonParser);
        q33VarBufferForInputBuffering.R1(jsonParser);
        return q33VarBufferForInputBuffering;
    }

    public q33 bufferForInputBuffering(JsonParser jsonParser) {
        return new q33(jsonParser, this);
    }

    public final boolean canOverrideAccessModifiers() {
        return this._config.canOverrideAccessModifiers();
    }

    public abstract void checkUnresolvedObjectId() throws UnresolvedForwardReference;

    public Calendar constructCalendar(Date date) {
        Calendar calendar = Calendar.getInstance(getTimeZone());
        calendar.setTime(date);
        return calendar;
    }

    public JavaType constructSpecializedType(JavaType javaType, Class<?> cls) throws IllegalArgumentException {
        return javaType.hasRawClass(cls) ? javaType : getConfig().getTypeFactory().constructSpecializedType(javaType, cls, false);
    }

    public final JavaType constructType(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return this._config.constructType(cls);
    }

    public abstract s51 deserializerInstance(d7 d7Var, Object obj) throws JsonMappingException;

    @Deprecated
    public JsonMappingException endOfInputException(Class<?> cls) {
        return MismatchedInputException.from(this._parser, cls, "Unexpected end-of-input when trying to deserialize a " + cls.getName());
    }

    public String extractScalarFromObject(JsonParser jsonParser, s51 s51Var, Class<?> cls) throws IOException {
        return (String) handleUnexpectedToken(cls, jsonParser);
    }

    public Class<?> findClass(String str) throws ClassNotFoundException {
        return getTypeFactory().findClass(str);
    }

    public CoercionAction findCoercionAction(LogicalType logicalType, Class<?> cls, CoercionInputShape coercionInputShape) {
        return this._config.findCoercionAction(logicalType, cls, coercionInputShape);
    }

    public CoercionAction findCoercionFromBlankString(LogicalType logicalType, Class<?> cls, CoercionAction coercionAction) {
        return this._config.findCoercionFromBlankString(logicalType, cls, coercionAction);
    }

    public final s51 findContextualValueDeserializer(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        s51 s51VarFindValueDeserializer = this._cache.findValueDeserializer(this, this._factory, javaType);
        return s51VarFindValueDeserializer != null ? handleSecondaryContextualization(s51VarFindValueDeserializer, beanProperty, javaType) : s51VarFindValueDeserializer;
    }

    public final Object findInjectableValue(Object obj, BeanProperty beanProperty, Object obj2) throws JsonMappingException {
        InjectableValues injectableValues = this._injectableValues;
        return injectableValues == null ? reportBadDefinition(ay.i(obj), String.format("No 'injectableValues' configured, cannot inject value with id [%s]", obj)) : injectableValues.findInjectableValue(obj, this, beanProperty, obj2);
    }

    public final a91 findKeyDeserializer(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        try {
            return this._cache.findKeyDeserializer(this, this._factory, javaType);
        } catch (IllegalArgumentException e) {
            reportBadDefinition(javaType, ay.o(e));
            return null;
        }
    }

    public final s51 findNonContextualValueDeserializer(JavaType javaType) throws JsonMappingException {
        return this._cache.findValueDeserializer(this, this._factory, javaType);
    }

    public abstract com.fasterxml.jackson.databind.deser.impl.c findObjectId(Object obj, ObjectIdGenerator<?> objectIdGenerator, com.fasterxml.jackson.annotation.a aVar);

    public final s51 findRootValueDeserializer(JavaType javaType) throws JsonMappingException {
        s51 s51VarFindValueDeserializer = this._cache.findValueDeserializer(this, this._factory, javaType);
        if (s51VarFindValueDeserializer == null) {
            return null;
        }
        s51 s51VarHandleSecondaryContextualization = handleSecondaryContextualization(s51VarFindValueDeserializer, null, javaType);
        m63 m63VarFindTypeDeserializer = this._factory.findTypeDeserializer(this._config, javaType);
        return m63VarFindTypeDeserializer != null ? new TypeWrappedDeserializer(m63VarFindTypeDeserializer.forProperty(null), s51VarHandleSecondaryContextualization) : s51VarHandleSecondaryContextualization;
    }

    public final Class<?> getActiveView() {
        return this._view;
    }

    public final AnnotationIntrospector getAnnotationIntrospector() {
        return this._config.getAnnotationIntrospector();
    }

    public final p9 getArrayBuilders() {
        if (this._arrayBuilders == null) {
            this._arrayBuilders = new p9();
        }
        return this._arrayBuilders;
    }

    public Object getAttribute(Object obj) {
        return this._attributes.getAttribute(obj);
    }

    public final Base64Variant getBase64Variant() {
        return this._config.getBase64Variant();
    }

    public JavaType getContextualType() {
        pb1 pb1Var = this._currentType;
        if (pb1Var == null) {
            return null;
        }
        return (JavaType) pb1Var.d();
    }

    @Deprecated
    protected DateFormat getDateFormat() {
        return _getDateFormat();
    }

    public final JsonFormat.Value getDefaultPropertyFormat(Class<?> cls) {
        return this._config.getDefaultPropertyFormat(cls);
    }

    public final int getDeserializationFeatures() {
        return this._featureFlags;
    }

    public com.fasterxml.jackson.databind.deser.a getFactory() {
        return this._factory;
    }

    public Locale getLocale() {
        return this._config.getLocale();
    }

    public final JsonNodeFactory getNodeFactory() {
        return this._config.getNodeFactory();
    }

    public final JsonParser getParser() {
        return this._parser;
    }

    public TimeZone getTimeZone() {
        return this._config.getTimeZone();
    }

    @Override // defpackage.t60
    public final TypeFactory getTypeFactory() {
        return this._config.getTypeFactory();
    }

    public void handleBadMerge(s51 s51Var) throws JsonMappingException {
        if (isEnabled(MapperFeature.IGNORE_MERGE_FOR_UNMERGEABLE)) {
            return;
        }
        JavaType javaTypeConstructType = constructType((Class<?>) s51Var.handledType());
        throw InvalidDefinitionException.from(getParser(), String.format("Invalid configuration: values of type %s cannot be merged", ay.G(javaTypeConstructType)), javaTypeConstructType);
    }

    public Object handleInstantiationProblem(Class<?> cls, Object obj, Throwable th) throws IOException {
        pb1 problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers != null) {
            e43.a(problemHandlers.d());
            throw null;
        }
        ay.i0(th);
        if (!isEnabled(DeserializationFeature.WRAP_EXCEPTIONS)) {
            ay.j0(th);
        }
        throw instantiationException(cls, th);
    }

    public Object handleMissingInstantiator(Class<?> cls, ValueInstantiator valueInstantiator, JsonParser jsonParser, String str, Object... objArr) throws IOException {
        if (jsonParser == null) {
            getParser();
        }
        String str_format = _format(str, objArr);
        pb1 problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers != null) {
            e43.a(problemHandlers.d());
            throw null;
        }
        if (valueInstantiator == null) {
            return reportBadDefinition(cls, String.format("Cannot construct instance of %s: %s", ay.X(cls), str_format));
        }
        return !valueInstantiator.canInstantiate() ? reportBadDefinition(cls, String.format("Cannot construct instance of %s (no Creators, like default constructor, exist): %s", ay.X(cls), str_format)) : reportInputMismatch(cls, String.format("Cannot construct instance of %s (although at least one Creator exists): %s", ay.X(cls), str_format), new Object[0]);
    }

    public JavaType handleMissingTypeId(JavaType javaType, n63 n63Var, String str) throws IOException {
        pb1 problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers == null) {
            throw missingTypeIdException(javaType, str);
        }
        e43.a(problemHandlers.d());
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s51 handlePrimaryContextualization(s51 s51Var, BeanProperty beanProperty, JavaType javaType) throws JsonMappingException {
        boolean z = s51Var instanceof v30;
        s51 s51Var2 = s51Var;
        if (z) {
            this._currentType = new pb1(javaType, this._currentType);
            try {
                s51 s51VarCreateContextual = ((v30) s51Var).createContextual(this, beanProperty);
            } finally {
                this._currentType = this._currentType.c();
            }
        }
        return s51Var2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s51 handleSecondaryContextualization(s51 s51Var, BeanProperty beanProperty, JavaType javaType) throws JsonMappingException {
        boolean z = s51Var instanceof v30;
        s51 s51Var2 = s51Var;
        if (z) {
            this._currentType = new pb1(javaType, this._currentType);
            try {
                s51 s51VarCreateContextual = ((v30) s51Var).createContextual(this, beanProperty);
            } finally {
                this._currentType = this._currentType.c();
            }
        }
        return s51Var2;
    }

    public Object handleUnexpectedToken(Class<?> cls, JsonParser jsonParser) throws IOException {
        return handleUnexpectedToken(constructType(cls), jsonParser.D(), jsonParser, (String) null, new Object[0]);
    }

    public boolean handleUnknownProperty(JsonParser jsonParser, s51 s51Var, Object obj, String str) throws IOException {
        pb1 problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers != null) {
            e43.a(problemHandlers.d());
            throw null;
        }
        if (isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)) {
            throw UnrecognizedPropertyException.from(this._parser, obj, str, s51Var != null ? s51Var.getKnownPropertyNames() : null);
        }
        jsonParser.v1();
        return true;
    }

    public JavaType handleUnknownTypeId(JavaType javaType, String str, n63 n63Var, String str2) throws IOException {
        pb1 problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers != null) {
            e43.a(problemHandlers.d());
            throw null;
        }
        if (isEnabled(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE)) {
            throw invalidTypeIdException(javaType, str, str2);
        }
        return null;
    }

    public Object handleWeirdKey(Class<?> cls, String str, String str2, Object... objArr) throws IOException {
        String str_format = _format(str2, objArr);
        pb1 problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers == null) {
            throw weirdKeyException(cls, str, str_format);
        }
        e43.a(problemHandlers.d());
        throw null;
    }

    public Object handleWeirdNativeValue(JavaType javaType, Object obj, JsonParser jsonParser) throws IOException {
        pb1 problemHandlers = this._config.getProblemHandlers();
        Class<?> rawClass = javaType.getRawClass();
        if (problemHandlers == null) {
            throw weirdNativeValueException(obj, rawClass);
        }
        e43.a(problemHandlers.d());
        throw null;
    }

    public Object handleWeirdNumberValue(Class<?> cls, Number number, String str, Object... objArr) throws IOException {
        String str_format = _format(str, objArr);
        pb1 problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers == null) {
            throw weirdNumberException(number, cls, str_format);
        }
        e43.a(problemHandlers.d());
        throw null;
    }

    public Object handleWeirdStringValue(Class<?> cls, String str, String str2, Object... objArr) throws IOException {
        String str_format = _format(str2, objArr);
        pb1 problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers == null) {
            throw weirdStringException(str, cls, str_format);
        }
        e43.a(problemHandlers.d());
        throw null;
    }

    public final boolean hasDeserializationFeatures(int i) {
        return (this._featureFlags & i) == i;
    }

    public final boolean hasSomeOfFeatures(int i) {
        return (i & this._featureFlags) != 0;
    }

    public boolean hasValueDeserializerFor(JavaType javaType, AtomicReference<Throwable> atomicReference) {
        try {
            return this._cache.hasValueDeserializerFor(this, this._factory, javaType);
        } catch (DatabindException e) {
            if (atomicReference == null) {
                return false;
            }
            atomicReference.set(e);
            return false;
        } catch (RuntimeException e2) {
            if (atomicReference == null) {
                throw e2;
            }
            atomicReference.set(e2);
            return false;
        }
    }

    public JsonMappingException instantiationException(Class<?> cls, Throwable th) {
        String strO;
        if (th == null) {
            strO = "N/A";
        } else {
            strO = ay.o(th);
            if (strO == null) {
                strO = ay.X(th.getClass());
            }
        }
        return ValueInstantiationException.from(this._parser, String.format("Cannot construct instance of %s, problem: %s", ay.X(cls), strO), constructType(cls), th);
    }

    @Override // defpackage.t60
    public JsonMappingException invalidTypeIdException(JavaType javaType, String str, String str2) {
        return InvalidTypeIdException.from(this._parser, _colonConcat(String.format("Could not resolve type id '%s' as a subtype of %s", str, ay.G(javaType)), str2), javaType, str);
    }

    public final boolean isEnabled(MapperFeature mapperFeature) {
        return this._config.isEnabled(mapperFeature);
    }

    public abstract a91 keyDeserializerInstance(d7 d7Var, Object obj) throws JsonMappingException;

    public final it1 leaseObjectBuffer() {
        it1 it1Var = this._objectBuffer;
        if (it1Var == null) {
            return new it1();
        }
        this._objectBuffer = null;
        return it1Var;
    }

    @Deprecated
    public JsonMappingException mappingException(String str) {
        return JsonMappingException.from(getParser(), str);
    }

    public JsonMappingException missingTypeIdException(JavaType javaType, String str) {
        return InvalidTypeIdException.from(this._parser, _colonConcat(String.format("Could not resolve subtype of %s", javaType), str), javaType, null);
    }

    public Date parseDate(String str) throws IllegalArgumentException {
        try {
            return _getDateFormat().parse(str);
        } catch (ParseException e) {
            throw new IllegalArgumentException(String.format("Failed to parse Date value '%s': %s", str, ay.o(e)));
        }
    }

    public <T> T readPropertyValue(JsonParser jsonParser, BeanProperty beanProperty, Class<T> cls) throws IOException {
        return (T) readPropertyValue(jsonParser, beanProperty, getTypeFactory().constructType(cls));
    }

    public JsonNode readTree(JsonParser jsonParser) throws IOException {
        JsonToken jsonTokenD = jsonParser.D();
        if (jsonTokenD == null && (jsonTokenD = jsonParser.n1()) == null) {
            return getNodeFactory().missingNode();
        }
        return jsonTokenD == JsonToken.VALUE_NULL ? getNodeFactory().m49nullNode() : (JsonNode) findRootValueDeserializer(this._config.constructType(JsonNode.class)).deserialize(jsonParser, this);
    }

    public <T> T readTreeAsValue(JsonNode jsonNode, Class<T> cls) throws IOException {
        if (jsonNode == null) {
            return null;
        }
        z53 z53Var_treeAsTokens = _treeAsTokens(jsonNode);
        try {
            T t = (T) readValue(z53Var_treeAsTokens, cls);
            if (z53Var_treeAsTokens != null) {
                z53Var_treeAsTokens.close();
            }
            return t;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (z53Var_treeAsTokens != null) {
                    try {
                        z53Var_treeAsTokens.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public <T> T readValue(JsonParser jsonParser, Class<T> cls) throws IOException {
        return (T) readValue(jsonParser, getTypeFactory().constructType(cls));
    }

    public <T> T reportBadCoercion(s51 s51Var, Class<?> cls, Object obj, String str, Object... objArr) throws JsonMappingException {
        throw InvalidFormatException.from(getParser(), _format(str, objArr), obj, cls);
    }

    @Override // defpackage.t60
    public <T> T reportBadDefinition(JavaType javaType, String str) throws JsonMappingException {
        throw InvalidDefinitionException.from(this._parser, str, javaType);
    }

    @Deprecated
    public <T> T reportBadMerge(s51 s51Var) throws JsonMappingException {
        handleBadMerge(s51Var);
        return null;
    }

    public <T> T reportBadPropertyDefinition(kh khVar, g gVar, String str, Object... objArr) throws JsonMappingException {
        throw InvalidDefinitionException.from(this._parser, String.format("Invalid definition for property %s (of type %s): %s", ay.W(gVar), ay.X(khVar.r()), _format(str, objArr)), khVar, gVar);
    }

    public <T> T reportBadTypeDefinition(kh khVar, String str, Object... objArr) throws JsonMappingException {
        throw InvalidDefinitionException.from(this._parser, String.format("Invalid type definition for type %s: %s", ay.X(khVar.r()), _format(str, objArr)), khVar, (g) null);
    }

    public <T> T reportInputMismatch(s51 s51Var, String str, Object... objArr) throws JsonMappingException {
        throw MismatchedInputException.from(getParser(), (Class<?>) s51Var.handledType(), _format(str, objArr));
    }

    @Deprecated
    public void reportMappingException(String str, Object... objArr) throws JsonMappingException {
        throw JsonMappingException.from(getParser(), _format(str, objArr));
    }

    @Deprecated
    public void reportMissingContent(String str, Object... objArr) throws JsonMappingException {
        throw MismatchedInputException.from(getParser(), (JavaType) null, "No content to map due to end-of-input");
    }

    public <T> T reportPropertyInputMismatch(Class<?> cls, String str, String str2, Object... objArr) throws JsonMappingException {
        MismatchedInputException mismatchedInputExceptionFrom = MismatchedInputException.from(getParser(), cls, _format(str2, objArr));
        if (str == null) {
            throw mismatchedInputExceptionFrom;
        }
        mismatchedInputExceptionFrom.prependPath(cls, str);
        throw mismatchedInputExceptionFrom;
    }

    public <T> T reportTrailingTokens(Class<?> cls, JsonParser jsonParser, JsonToken jsonToken) throws JsonMappingException {
        throw MismatchedInputException.from(jsonParser, cls, String.format("Trailing token (of type %s) found after value (bound as %s): not allowed as per `DeserializationFeature.FAIL_ON_TRAILING_TOKENS`", jsonToken, ay.X(cls)));
    }

    @Deprecated
    public void reportUnknownProperty(Object obj, String str, s51 s51Var) throws JsonMappingException {
        if (isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)) {
            throw UnrecognizedPropertyException.from(this._parser, obj, str, s51Var == null ? null : s51Var.getKnownPropertyNames());
        }
    }

    public <T> T reportUnresolvedObjectId(ObjectIdReader objectIdReader, Object obj) throws JsonMappingException {
        return (T) reportInputMismatch(objectIdReader.idProperty, String.format("No Object Id found for an instance of %s, to assign to property '%s'", ay.h(obj), objectIdReader.propertyName), new Object[0]);
    }

    public void reportWrongTokenException(s51 s51Var, JsonToken jsonToken, String str, Object... objArr) throws JsonMappingException {
        throw wrongTokenException(getParser(), (Class<?>) s51Var.handledType(), jsonToken, _format(str, objArr));
    }

    public final void returnObjectBuffer(it1 it1Var) {
        if (this._objectBuffer == null || it1Var.h() >= this._objectBuffer.h()) {
            this._objectBuffer = it1Var;
        }
    }

    @Deprecated
    public JsonMappingException unknownTypeException(JavaType javaType, String str, String str2) {
        return MismatchedInputException.from(this._parser, javaType, _colonConcat(String.format("Could not resolve type id '%s' into a subtype of %s", str, ay.G(javaType)), str2));
    }

    public JsonMappingException weirdKeyException(Class<?> cls, String str, String str2) {
        return InvalidFormatException.from(this._parser, String.format("Cannot deserialize Map key of type %s from String %s: %s", ay.X(cls), _quotedString(str), str2), str, cls);
    }

    public JsonMappingException weirdNativeValueException(Object obj, Class<?> cls) {
        return InvalidFormatException.from(this._parser, String.format("Cannot deserialize value of type %s from native value (`JsonToken.VALUE_EMBEDDED_OBJECT`) of type %s: incompatible types", ay.X(cls), ay.h(obj)), obj, cls);
    }

    public JsonMappingException weirdNumberException(Number number, Class<?> cls, String str) {
        return InvalidFormatException.from(this._parser, String.format("Cannot deserialize value of type %s from number %s: %s", ay.X(cls), String.valueOf(number), str), number, cls);
    }

    public JsonMappingException weirdStringException(String str, Class<?> cls, String str2) {
        return InvalidFormatException.from(this._parser, String.format("Cannot deserialize value of type %s from String %s: %s", ay.X(cls), _quotedString(str), str2), str, cls);
    }

    public JsonMappingException wrongTokenException(JsonParser jsonParser, JavaType javaType, JsonToken jsonToken, String str) {
        return MismatchedInputException.from(jsonParser, javaType, _colonConcat(String.format("Unexpected token (%s), expected %s", jsonParser.D(), jsonToken), str));
    }

    protected DeserializationContext(com.fasterxml.jackson.databind.deser.a aVar, DeserializerCache deserializerCache) {
        if (aVar == null) {
            throw new NullPointerException("Cannot pass null DeserializerFactory");
        }
        this._factory = aVar;
        this._cache = deserializerCache == null ? new DeserializerCache() : deserializerCache;
        this._featureFlags = 0;
        this._readCapabilities = null;
        this._config = null;
        this._injectableValues = null;
        this._view = null;
        this._attributes = null;
    }

    public final q33 bufferForInputBuffering() {
        return bufferForInputBuffering(getParser());
    }

    @Override // defpackage.t60
    public DeserializationConfig getConfig() {
        return this._config;
    }

    public Object handleUnexpectedToken(Class<?> cls, JsonToken jsonToken, JsonParser jsonParser, String str, Object... objArr) throws IOException {
        return handleUnexpectedToken(constructType(cls), jsonToken, jsonParser, str, objArr);
    }

    public final boolean isEnabled(u60 u60Var) {
        return this._config.isEnabled(u60Var);
    }

    @Deprecated
    public JsonMappingException mappingException(String str, Object... objArr) {
        return JsonMappingException.from(getParser(), _format(str, objArr));
    }

    public <T> T readPropertyValue(JsonParser jsonParser, BeanProperty beanProperty, JavaType javaType) throws IOException {
        s51 s51VarFindContextualValueDeserializer = findContextualValueDeserializer(javaType, beanProperty);
        return s51VarFindContextualValueDeserializer == null ? (T) reportBadDefinition(javaType, String.format("Could not find JsonDeserializer for type %s (via property %s)", ay.G(javaType), ay.W(beanProperty))) : (T) s51VarFindContextualValueDeserializer.deserialize(jsonParser, this);
    }

    public <T> T readValue(JsonParser jsonParser, JavaType javaType) throws IOException {
        s51 s51VarFindRootValueDeserializer = findRootValueDeserializer(javaType);
        if (s51VarFindRootValueDeserializer != null) {
            return (T) s51VarFindRootValueDeserializer.deserialize(jsonParser, this);
        }
        return (T) reportBadDefinition(javaType, "Could not find JsonDeserializer for type " + ay.G(javaType));
    }

    /* JADX INFO: renamed from: setAttribute, reason: merged with bridge method [inline-methods] */
    public DeserializationContext m13setAttribute(Object obj, Object obj2) {
        this._attributes = this._attributes.withPerCallAttribute(obj, obj2);
        return this;
    }

    public Object handleUnexpectedToken(JavaType javaType, JsonParser jsonParser) throws IOException {
        return handleUnexpectedToken(javaType, jsonParser.D(), jsonParser, (String) null, new Object[0]);
    }

    public final boolean isEnabled(DeserializationFeature deserializationFeature) {
        return (deserializationFeature.getMask() & this._featureFlags) != 0;
    }

    @Deprecated
    public JsonMappingException mappingException(Class<?> cls) {
        return mappingException(cls, this._parser.D());
    }

    public <T> T reportInputMismatch(Class<?> cls, String str, Object... objArr) throws JsonMappingException {
        throw MismatchedInputException.from(getParser(), cls, _format(str, objArr));
    }

    public void reportWrongTokenException(JavaType javaType, JsonToken jsonToken, String str, Object... objArr) throws JsonMappingException {
        throw wrongTokenException(getParser(), javaType, jsonToken, _format(str, objArr));
    }

    public Object handleUnexpectedToken(JavaType javaType, JsonToken jsonToken, JsonParser jsonParser, String str, Object... objArr) throws IOException {
        String str_format = _format(str, objArr);
        pb1 problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers == null) {
            if (str_format == null) {
                String strG = ay.G(javaType);
                if (jsonToken == null) {
                    str_format = String.format("Unexpected end-of-input when trying read value of type %s", strG);
                } else {
                    str_format = String.format("Cannot deserialize value of type %s from %s (token `JsonToken.%s`)", strG, _shapeForToken(jsonToken), jsonToken);
                }
            }
            if (jsonToken != null && jsonToken.isScalarValue()) {
                jsonParser.S0();
            }
            reportInputMismatch(javaType, str_format, new Object[0]);
            return null;
        }
        e43.a(problemHandlers.d());
        throw null;
    }

    public final boolean isEnabled(StreamReadCapability streamReadCapability) {
        return this._readCapabilities.b(streamReadCapability);
    }

    @Deprecated
    public JsonMappingException mappingException(Class<?> cls, JsonToken jsonToken) {
        return JsonMappingException.from(this._parser, String.format("Cannot deserialize instance of %s out of %s token", ay.X(cls), jsonToken));
    }

    public <T> T reportInputMismatch(JavaType javaType, String str, Object... objArr) throws JsonMappingException {
        throw MismatchedInputException.from(getParser(), javaType, _format(str, objArr));
    }

    public <T> T reportPropertyInputMismatch(JavaType javaType, String str, String str2, Object... objArr) throws JsonMappingException {
        return (T) reportPropertyInputMismatch(javaType.getRawClass(), str, str2, objArr);
    }

    public void reportWrongTokenException(Class<?> cls, JsonToken jsonToken, String str, Object... objArr) throws JsonMappingException {
        throw wrongTokenException(getParser(), cls, jsonToken, _format(str, objArr));
    }

    public JsonMappingException wrongTokenException(JsonParser jsonParser, Class<?> cls, JsonToken jsonToken, String str) {
        return MismatchedInputException.from(jsonParser, cls, _colonConcat(String.format("Unexpected token (%s), expected %s", jsonParser.D(), jsonToken), str));
    }

    public <T> T readTreeAsValue(JsonNode jsonNode, JavaType javaType) throws IOException {
        if (jsonNode == null) {
            return null;
        }
        z53 z53Var_treeAsTokens = _treeAsTokens(jsonNode);
        try {
            T t = (T) readValue(z53Var_treeAsTokens, javaType);
            if (z53Var_treeAsTokens != null) {
                z53Var_treeAsTokens.close();
            }
            return t;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (z53Var_treeAsTokens != null) {
                    try {
                        z53Var_treeAsTokens.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public JsonMappingException instantiationException(Class<?> cls, String str) {
        return ValueInstantiationException.from(this._parser, String.format("Cannot construct instance of %s: %s", ay.X(cls), str), constructType(cls));
    }

    public <T> T reportInputMismatch(BeanProperty beanProperty, String str, Object... objArr) throws JsonMappingException {
        AnnotatedMember member;
        MismatchedInputException mismatchedInputExceptionFrom = MismatchedInputException.from(getParser(), beanProperty == null ? null : beanProperty.getType(), _format(str, objArr));
        if (beanProperty != null && (member = beanProperty.getMember()) != null) {
            mismatchedInputExceptionFrom.prependPath(member.getDeclaringClass(), beanProperty.getName());
            throw mismatchedInputExceptionFrom;
        }
        throw mismatchedInputExceptionFrom;
    }

    @Deprecated
    public void reportWrongTokenException(JsonParser jsonParser, JsonToken jsonToken, String str, Object... objArr) throws JsonMappingException {
        throw wrongTokenException(jsonParser, jsonToken, _format(str, objArr));
    }

    @Deprecated
    public JsonMappingException wrongTokenException(JsonParser jsonParser, JsonToken jsonToken, String str) {
        return wrongTokenException(jsonParser, (JavaType) null, jsonToken, str);
    }

    protected DeserializationContext(DeserializationContext deserializationContext, com.fasterxml.jackson.databind.deser.a aVar) {
        this._cache = deserializationContext._cache;
        this._factory = aVar;
        this._config = deserializationContext._config;
        this._featureFlags = deserializationContext._featureFlags;
        this._readCapabilities = deserializationContext._readCapabilities;
        this._view = deserializationContext._view;
        this._parser = deserializationContext._parser;
        this._injectableValues = deserializationContext._injectableValues;
        this._attributes = deserializationContext._attributes;
    }

    protected DeserializationContext(DeserializationContext deserializationContext, DeserializationConfig deserializationConfig, JsonParser jsonParser, InjectableValues injectableValues) {
        this._cache = deserializationContext._cache;
        this._factory = deserializationContext._factory;
        this._readCapabilities = jsonParser == null ? null : jsonParser.Q0();
        this._config = deserializationConfig;
        this._featureFlags = deserializationConfig.getDeserializationFeatures();
        this._view = deserializationConfig.getActiveView();
        this._parser = jsonParser;
        this._injectableValues = injectableValues;
        this._attributes = deserializationConfig.getAttributes();
    }

    protected DeserializationContext(DeserializationContext deserializationContext, DeserializationConfig deserializationConfig) {
        this._cache = deserializationContext._cache;
        this._factory = deserializationContext._factory;
        this._readCapabilities = null;
        this._config = deserializationConfig;
        this._featureFlags = deserializationConfig.getDeserializationFeatures();
        this._view = null;
        this._parser = null;
        this._injectableValues = null;
        this._attributes = null;
    }

    protected DeserializationContext(DeserializationContext deserializationContext) {
        this._cache = new DeserializerCache();
        this._factory = deserializationContext._factory;
        this._config = deserializationContext._config;
        this._featureFlags = deserializationContext._featureFlags;
        this._readCapabilities = deserializationContext._readCapabilities;
        this._view = deserializationContext._view;
        this._injectableValues = null;
    }
}
