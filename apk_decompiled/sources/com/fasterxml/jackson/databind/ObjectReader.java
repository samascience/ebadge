package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.TypeFactory;
import defpackage.ay;
import defpackage.hp0;
import defpackage.ip0;
import defpackage.jt1;
import defpackage.ng2;
import defpackage.p90;
import defpackage.s51;
import defpackage.u60;
import defpackage.u61;
import defpackage.v63;
import defpackage.vy1;
import defpackage.z50;
import defpackage.z53;
import java.io.DataInput;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ObjectReader extends jt1 implements Serializable {
    private static final long serialVersionUID = 2;
    protected final DeserializationConfig _config;
    protected final DefaultDeserializationContext _context;
    protected final z50 _dataFormatReaders;
    private final TokenFilter _filter;
    protected final InjectableValues _injectableValues;
    protected transient JavaType _jsonNodeType;
    protected final JsonFactory _parserFactory;
    protected final s51 _rootDeserializer;
    protected final ConcurrentHashMap<JavaType, s51> _rootDeserializers;
    protected final ip0 _schema;
    protected final boolean _unwrapRoot;
    protected final Object _valueToUpdate;
    protected final JavaType _valueType;

    protected ObjectReader(ObjectMapper objectMapper, DeserializationConfig deserializationConfig) {
        this(objectMapper, deserializationConfig, null, null, null, null);
    }

    protected final void _assertNotNull(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", str));
        }
    }

    protected Object _bind(JsonParser jsonParser, Object obj) throws IOException {
        DefaultDeserializationContext defaultDeserializationContextCreateDeserializationContext = createDeserializationContext(jsonParser);
        JsonToken jsonToken_initForReading = _initForReading(defaultDeserializationContextCreateDeserializationContext, jsonParser);
        if (jsonToken_initForReading == JsonToken.VALUE_NULL) {
            if (obj == null) {
                obj = _findRootDeserializer(defaultDeserializationContextCreateDeserializationContext).getNullValue(defaultDeserializationContextCreateDeserializationContext);
            }
        } else if (jsonToken_initForReading != JsonToken.END_ARRAY && jsonToken_initForReading != JsonToken.END_OBJECT) {
            obj = defaultDeserializationContextCreateDeserializationContext.readRootValue(jsonParser, this._valueType, _findRootDeserializer(defaultDeserializationContextCreateDeserializationContext), this._valueToUpdate);
        }
        jsonParser.y();
        if (this._config.isEnabled(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)) {
            _verifyNoTrailingTokens(jsonParser, defaultDeserializationContextCreateDeserializationContext, this._valueType);
        }
        return obj;
    }

    protected Object _bindAndClose(JsonParser jsonParser) throws IOException {
        Object rootValue;
        try {
            DefaultDeserializationContext defaultDeserializationContextCreateDeserializationContext = createDeserializationContext(jsonParser);
            JsonToken jsonToken_initForReading = _initForReading(defaultDeserializationContextCreateDeserializationContext, jsonParser);
            if (jsonToken_initForReading == JsonToken.VALUE_NULL) {
                rootValue = this._valueToUpdate;
                if (rootValue == null) {
                    rootValue = _findRootDeserializer(defaultDeserializationContextCreateDeserializationContext).getNullValue(defaultDeserializationContextCreateDeserializationContext);
                }
            } else {
                rootValue = (jsonToken_initForReading == JsonToken.END_ARRAY || jsonToken_initForReading == JsonToken.END_OBJECT) ? this._valueToUpdate : defaultDeserializationContextCreateDeserializationContext.readRootValue(jsonParser, this._valueType, _findRootDeserializer(defaultDeserializationContextCreateDeserializationContext), this._valueToUpdate);
            }
            if (this._config.isEnabled(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)) {
                _verifyNoTrailingTokens(jsonParser, defaultDeserializationContextCreateDeserializationContext, this._valueType);
            }
            if (jsonParser != null) {
                jsonParser.close();
            }
            return rootValue;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (jsonParser != null) {
                    try {
                        jsonParser.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    protected final JsonNode _bindAndCloseAsTree(JsonParser jsonParser) throws IOException {
        try {
            JsonNode jsonNode_bindAsTree = _bindAsTree(jsonParser);
            if (jsonParser != null) {
                jsonParser.close();
            }
            return jsonNode_bindAsTree;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (jsonParser != null) {
                    try {
                        jsonParser.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    protected <T> b _bindAndReadValues(JsonParser jsonParser) throws IOException {
        DefaultDeserializationContext defaultDeserializationContextCreateDeserializationContext = createDeserializationContext(jsonParser);
        _initForMultiRead(defaultDeserializationContextCreateDeserializationContext, jsonParser);
        jsonParser.n1();
        return _newIterator(jsonParser, defaultDeserializationContextCreateDeserializationContext, _findRootDeserializer(defaultDeserializationContextCreateDeserializationContext), true);
    }

    protected final JsonNode _bindAsTree(JsonParser jsonParser) throws IOException {
        Object obj = this._valueToUpdate;
        if (obj != null) {
            return (JsonNode) _bind(jsonParser, obj);
        }
        this._config.initialize(jsonParser);
        JsonToken jsonTokenD = jsonParser.D();
        if (jsonTokenD == null && (jsonTokenD = jsonParser.n1()) == null) {
            return this._config.getNodeFactory().missingNode();
        }
        DefaultDeserializationContext defaultDeserializationContextCreateDeserializationContext = createDeserializationContext(jsonParser);
        JsonNode jsonNodeNullNode = jsonTokenD == JsonToken.VALUE_NULL ? this._config.getNodeFactory().m49nullNode() : (JsonNode) defaultDeserializationContextCreateDeserializationContext.readRootValue(jsonParser, _jsonNodeType(), _findTreeDeserializer(defaultDeserializationContextCreateDeserializationContext), null);
        jsonParser.y();
        if (this._config.isEnabled(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)) {
            _verifyNoTrailingTokens(jsonParser, defaultDeserializationContextCreateDeserializationContext, _jsonNodeType());
        }
        return jsonNodeNullNode;
    }

    protected final JsonNode _bindAsTreeOrNull(JsonParser jsonParser) throws IOException {
        Object obj = this._valueToUpdate;
        if (obj != null) {
            return (JsonNode) _bind(jsonParser, obj);
        }
        this._config.initialize(jsonParser);
        JsonToken jsonTokenD = jsonParser.D();
        if (jsonTokenD == null && (jsonTokenD = jsonParser.n1()) == null) {
            return null;
        }
        DefaultDeserializationContext defaultDeserializationContextCreateDeserializationContext = createDeserializationContext(jsonParser);
        JsonNode jsonNodeNullNode = jsonTokenD == JsonToken.VALUE_NULL ? this._config.getNodeFactory().m49nullNode() : (JsonNode) defaultDeserializationContextCreateDeserializationContext.readRootValue(jsonParser, _jsonNodeType(), _findTreeDeserializer(defaultDeserializationContextCreateDeserializationContext), null);
        jsonParser.y();
        if (this._config.isEnabled(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)) {
            _verifyNoTrailingTokens(jsonParser, defaultDeserializationContextCreateDeserializationContext, _jsonNodeType());
        }
        return jsonNodeNullNode;
    }

    protected JsonParser _considerFilter(JsonParser jsonParser, boolean z) {
        return (this._filter == null || com.fasterxml.jackson.core.filter.a.class.isInstance(jsonParser)) ? jsonParser : new com.fasterxml.jackson.core.filter.a(jsonParser, this._filter, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, z);
    }

    protected Object _detectBindAndClose(byte[] bArr, int i, int i2) throws IOException {
        z50.b bVarC = this._dataFormatReaders.c(bArr, i, i2);
        if (!bVarC.d()) {
            _reportUnkownFormat(this._dataFormatReaders, bVarC);
        }
        return bVarC.c()._bindAndClose(bVarC.a());
    }

    protected JsonNode _detectBindAndCloseAsTree(InputStream inputStream) throws IOException {
        z50.b bVarB = this._dataFormatReaders.b(inputStream);
        if (!bVarB.d()) {
            _reportUnkownFormat(this._dataFormatReaders, bVarB);
        }
        JsonParser jsonParserA = bVarB.a();
        jsonParserA.a0(JsonParser.Feature.AUTO_CLOSE_SOURCE);
        return bVarB.c()._bindAndCloseAsTree(jsonParserA);
    }

    protected <T> b _detectBindAndReadValues(z50.b bVar, boolean z) throws IOException {
        if (!bVar.d()) {
            _reportUnkownFormat(this._dataFormatReaders, bVar);
        }
        JsonParser jsonParserA = bVar.a();
        if (z) {
            jsonParserA.a0(JsonParser.Feature.AUTO_CLOSE_SOURCE);
        }
        return bVar.c()._bindAndReadValues(jsonParserA);
    }

    protected s51 _findRootDeserializer(DeserializationContext deserializationContext) throws DatabindException {
        s51 s51Var = this._rootDeserializer;
        if (s51Var != null) {
            return s51Var;
        }
        JavaType javaType = this._valueType;
        if (javaType == null) {
            deserializationContext.reportBadDefinition((JavaType) null, "No value type configured for ObjectReader");
        }
        s51 s51Var2 = this._rootDeserializers.get(javaType);
        if (s51Var2 != null) {
            return s51Var2;
        }
        s51 s51VarFindRootValueDeserializer = deserializationContext.findRootValueDeserializer(javaType);
        if (s51VarFindRootValueDeserializer == null) {
            deserializationContext.reportBadDefinition(javaType, "Cannot find a deserializer for type " + javaType);
        }
        this._rootDeserializers.put(javaType, s51VarFindRootValueDeserializer);
        return s51VarFindRootValueDeserializer;
    }

    protected s51 _findTreeDeserializer(DeserializationContext deserializationContext) throws DatabindException {
        JavaType javaType_jsonNodeType = _jsonNodeType();
        s51 s51VarFindRootValueDeserializer = this._rootDeserializers.get(javaType_jsonNodeType);
        if (s51VarFindRootValueDeserializer == null) {
            s51VarFindRootValueDeserializer = deserializationContext.findRootValueDeserializer(javaType_jsonNodeType);
            if (s51VarFindRootValueDeserializer == null) {
                deserializationContext.reportBadDefinition(javaType_jsonNodeType, "Cannot find a deserializer for type " + javaType_jsonNodeType);
            }
            this._rootDeserializers.put(javaType_jsonNodeType, s51VarFindRootValueDeserializer);
        }
        return s51VarFindRootValueDeserializer;
    }

    protected void _initForMultiRead(DeserializationContext deserializationContext, JsonParser jsonParser) throws IOException {
        this._config.initialize(jsonParser, null);
    }

    protected JsonToken _initForReading(DeserializationContext deserializationContext, JsonParser jsonParser) throws IOException {
        this._config.initialize(jsonParser, null);
        JsonToken jsonTokenD = jsonParser.D();
        if (jsonTokenD == null && (jsonTokenD = jsonParser.n1()) == null) {
            deserializationContext.reportInputMismatch(this._valueType, "No content to map due to end-of-input", new Object[0]);
        }
        return jsonTokenD;
    }

    protected InputStream _inputStream(URL url) throws IOException {
        return url.openStream();
    }

    protected final JavaType _jsonNodeType() {
        JavaType javaType = this._jsonNodeType;
        if (javaType != null) {
            return javaType;
        }
        JavaType javaTypeConstructType = getTypeFactory().constructType(JsonNode.class);
        this._jsonNodeType = javaTypeConstructType;
        return javaTypeConstructType;
    }

    protected ObjectReader _new(ObjectReader objectReader, JsonFactory jsonFactory) {
        return new ObjectReader(objectReader, jsonFactory);
    }

    protected <T> b _newIterator(JsonParser jsonParser, DeserializationContext deserializationContext, s51 s51Var, boolean z) {
        return new b(this._valueType, jsonParser, deserializationContext, s51Var, z, this._valueToUpdate);
    }

    protected s51 _prefetchRootDeserializer(JavaType javaType) {
        if (javaType == null || !this._config.isEnabled(DeserializationFeature.EAGER_DESERIALIZER_FETCH)) {
            return null;
        }
        s51 s51VarFindRootValueDeserializer = this._rootDeserializers.get(javaType);
        if (s51VarFindRootValueDeserializer == null) {
            try {
                s51VarFindRootValueDeserializer = createDummyDeserializationContext().findRootValueDeserializer(javaType);
                if (s51VarFindRootValueDeserializer != null) {
                    this._rootDeserializers.put(javaType, s51VarFindRootValueDeserializer);
                }
            } catch (JacksonException unused) {
            }
        }
        return s51VarFindRootValueDeserializer;
    }

    protected void _reportUndetectableSource(Object obj) throws StreamReadException {
        throw new JsonParseException((JsonParser) null, "Cannot use source of type " + obj.getClass().getName() + " with format auto-detection: must be byte- not char-based");
    }

    protected void _reportUnkownFormat(z50 z50Var, z50.b bVar) throws IOException {
        throw new JsonParseException((JsonParser) null, "Cannot detect format from input, does not look like any of detectable formats " + z50Var.toString());
    }

    protected final void _verifyNoTrailingTokens(JsonParser jsonParser, DeserializationContext deserializationContext, JavaType javaType) throws IOException {
        Object obj;
        JsonToken jsonTokenN1 = jsonParser.n1();
        if (jsonTokenN1 != null) {
            Class<?> clsD0 = ay.d0(javaType);
            if (clsD0 == null && (obj = this._valueToUpdate) != null) {
                clsD0 = obj.getClass();
            }
            deserializationContext.reportTrailingTokens(clsD0, jsonParser, jsonTokenN1);
        }
    }

    protected void _verifySchemaType(ip0 ip0Var) {
        if (ip0Var == null || this._parserFactory.canUseSchema(ip0Var)) {
            return;
        }
        throw new IllegalArgumentException("Cannot use FormatSchema of type " + ip0Var.getClass().getName() + " for format " + this._parserFactory.getFormatName());
    }

    protected ObjectReader _with(DeserializationConfig deserializationConfig) {
        if (deserializationConfig == this._config) {
            return this;
        }
        ObjectReader objectReader_new = _new(this, deserializationConfig);
        z50 z50Var = this._dataFormatReaders;
        return z50Var != null ? objectReader_new.withFormatDetection(z50Var.d(deserializationConfig)) : objectReader_new;
    }

    public ObjectReader at(String str) {
        _assertNotNull("pointerExpr", str);
        return new ObjectReader(this, new u61(str));
    }

    protected DefaultDeserializationContext createDeserializationContext(JsonParser jsonParser) {
        return this._context.createInstance(this._config, jsonParser, this._injectableValues);
    }

    protected DefaultDeserializationContext createDummyDeserializationContext() {
        return this._context.createDummyInstance(this._config);
    }

    public JsonParser createNonBlockingByteArrayParser() throws IOException {
        return this._config.initialize(this._parserFactory.createNonBlockingByteArrayParser(), null);
    }

    public JsonParser createParser(File file) throws IOException {
        _assertNotNull("src", file);
        return this._config.initialize(this._parserFactory.createParser(file), null);
    }

    public ObjectReader forType(JavaType javaType) {
        if (javaType != null && javaType.equals(this._valueType)) {
            return this;
        }
        s51 s51Var_prefetchRootDeserializer = _prefetchRootDeserializer(javaType);
        z50 z50VarE = this._dataFormatReaders;
        if (z50VarE != null) {
            z50VarE = z50VarE.e(javaType);
        }
        return _new(this, this._config, javaType, s51Var_prefetchRootDeserializer, this._valueToUpdate, null, this._injectableValues, z50VarE);
    }

    public ContextAttributes getAttributes() {
        return this._config.getAttributes();
    }

    public DeserializationConfig getConfig() {
        return this._config;
    }

    @Override // defpackage.jt1
    public JsonFactory getFactory() {
        return this._parserFactory;
    }

    public InjectableValues getInjectableValues() {
        return this._injectableValues;
    }

    public TypeFactory getTypeFactory() {
        return this._config.getTypeFactory();
    }

    public JavaType getValueType() {
        return this._valueType;
    }

    public boolean isEnabled(DeserializationFeature deserializationFeature) {
        return this._config.isEnabled(deserializationFeature);
    }

    public <T extends com.fasterxml.jackson.core.d> T readTree(JsonParser jsonParser) throws IOException {
        _assertNotNull("p", jsonParser);
        return _bindAsTreeOrNull(jsonParser);
    }

    public <T> T readValue(JsonParser jsonParser) throws IOException {
        _assertNotNull("p", jsonParser);
        return (T) _bind(jsonParser, this._valueToUpdate);
    }

    public <T> Iterator<T> readValues(JsonParser jsonParser, Class<T> cls) throws IOException {
        _assertNotNull("p", jsonParser);
        return forType((Class<?>) cls).readValues(jsonParser);
    }

    public JsonParser treeAsTokens(com.fasterxml.jackson.core.d dVar) {
        _assertNotNull("n", dVar);
        return new z53((JsonNode) dVar, withValueToUpdate(null));
    }

    public <T> T treeToValue(com.fasterxml.jackson.core.d dVar, Class<T> cls) throws JsonProcessingException {
        _assertNotNull("n", dVar);
        try {
            return (T) readValue(treeAsTokens(dVar), cls);
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }

    public Version version() {
        return vy1.a;
    }

    public ObjectReader with(DeserializationFeature deserializationFeature) {
        return _with(this._config.with(deserializationFeature));
    }

    public ObjectReader withAttribute(Object obj, Object obj2) {
        return _with(this._config.withAttribute(obj, obj2));
    }

    public ObjectReader withAttributes(Map<?, ?> map) {
        return _with(this._config.withAttributes(map));
    }

    public ObjectReader withFeatures(DeserializationFeature... deserializationFeatureArr) {
        return _with(this._config.withFeatures(deserializationFeatureArr));
    }

    public ObjectReader withFormatDetection(ObjectReader... objectReaderArr) {
        return withFormatDetection(new z50(objectReaderArr));
    }

    public ObjectReader withHandler(p90 p90Var) {
        return _with(this._config.withHandler(p90Var));
    }

    public ObjectReader withRootName(String str) {
        return _with(this._config.withRootName(str));
    }

    @Deprecated
    public ObjectReader withType(JavaType javaType) {
        return forType(javaType);
    }

    public ObjectReader withValueToUpdate(Object obj) {
        if (obj == this._valueToUpdate) {
            return this;
        }
        if (obj == null) {
            return _new(this, this._config, this._valueType, this._rootDeserializer, null, null, this._injectableValues, this._dataFormatReaders);
        }
        JavaType javaTypeConstructType = this._valueType;
        if (javaTypeConstructType == null) {
            javaTypeConstructType = this._config.constructType(obj.getClass());
        }
        return _new(this, this._config, javaTypeConstructType, this._rootDeserializer, obj, null, this._injectableValues, this._dataFormatReaders);
    }

    public ObjectReader withView(Class<?> cls) {
        return _with(this._config.withView(cls));
    }

    public ObjectReader without(DeserializationFeature deserializationFeature) {
        return _with(this._config.without(deserializationFeature));
    }

    public ObjectReader withoutAttribute(Object obj) {
        return _with(this._config.withoutAttribute(obj));
    }

    public ObjectReader withoutFeatures(DeserializationFeature... deserializationFeatureArr) {
        return _with(this._config.withoutFeatures(deserializationFeatureArr));
    }

    public ObjectReader withoutRootName() {
        return _with(this._config.withRootName(PropertyName.NO_NAME));
    }

    public void writeTree(JsonGenerator jsonGenerator, com.fasterxml.jackson.core.d dVar) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.jt1
    public void writeValue(JsonGenerator jsonGenerator, Object obj) throws IOException {
        throw new UnsupportedOperationException("Not implemented for ObjectReader");
    }

    protected ObjectReader(ObjectMapper objectMapper, DeserializationConfig deserializationConfig, JavaType javaType, Object obj, ip0 ip0Var, InjectableValues injectableValues) {
        this._config = deserializationConfig;
        this._context = objectMapper._deserializationContext;
        this._rootDeserializers = objectMapper._rootDeserializers;
        this._parserFactory = objectMapper._jsonFactory;
        this._valueType = javaType;
        this._valueToUpdate = obj;
        this._injectableValues = injectableValues;
        this._unwrapRoot = deserializationConfig.useRootWrapping();
        this._rootDeserializer = _prefetchRootDeserializer(javaType);
        this._dataFormatReaders = null;
        this._filter = null;
    }

    protected InputStream _inputStream(File file) throws IOException {
        return new FileInputStream(file);
    }

    protected ObjectReader _new(ObjectReader objectReader, DeserializationConfig deserializationConfig) {
        return new ObjectReader(objectReader, deserializationConfig);
    }

    public JsonNode createArrayNode() {
        return this._config.getNodeFactory().arrayNode();
    }

    public JsonNode createObjectNode() {
        return this._config.getNodeFactory().objectNode();
    }

    public boolean isEnabled(MapperFeature mapperFeature) {
        return this._config.isEnabled(mapperFeature);
    }

    public JsonNode missingNode() {
        return this._config.getNodeFactory().missingNode();
    }

    public JsonNode nullNode() {
        return this._config.getNodeFactory().m49nullNode();
    }

    public ObjectReader with(DeserializationFeature deserializationFeature, DeserializationFeature... deserializationFeatureArr) {
        return _with(this._config.with(deserializationFeature, deserializationFeatureArr));
    }

    public ObjectReader withFeatures(u60... u60VarArr) {
        return _with(this._config.withFeatures(u60VarArr));
    }

    public ObjectReader withFormatDetection(z50 z50Var) {
        return _new(this, this._config, this._valueType, this._rootDeserializer, this._valueToUpdate, null, this._injectableValues, z50Var);
    }

    public ObjectReader withRootName(PropertyName propertyName) {
        return _with(this._config.withRootName(propertyName));
    }

    @Deprecated
    public ObjectReader withType(Class<?> cls) {
        return forType(this._config.constructType(cls));
    }

    public ObjectReader without(DeserializationFeature deserializationFeature, DeserializationFeature... deserializationFeatureArr) {
        return _with(this._config.without(deserializationFeature, deserializationFeatureArr));
    }

    public ObjectReader withoutFeatures(u60... u60VarArr) {
        return _with(this._config.withoutFeatures(u60VarArr));
    }

    protected ObjectReader _new(ObjectReader objectReader, DeserializationConfig deserializationConfig, JavaType javaType, s51 s51Var, Object obj, ip0 ip0Var, InjectableValues injectableValues, z50 z50Var) {
        return new ObjectReader(objectReader, deserializationConfig, javaType, s51Var, obj, ip0Var, injectableValues, z50Var);
    }

    public ObjectReader at(JsonPointer jsonPointer) {
        _assertNotNull("pointer", jsonPointer);
        return new ObjectReader(this, new u61(jsonPointer));
    }

    public JsonParser createParser(URL url) throws IOException {
        _assertNotNull("src", url);
        return this._config.initialize(this._parserFactory.createParser(url), null);
    }

    public boolean isEnabled(u60 u60Var) {
        return this._config.isEnabled(u60Var);
    }

    public JsonNode readTree(InputStream inputStream) throws IOException {
        if (this._dataFormatReaders != null) {
            return _detectBindAndCloseAsTree(inputStream);
        }
        return _bindAndCloseAsTree(_considerFilter(createParser(inputStream), false));
    }

    public <T> T readValue(JsonParser jsonParser, Class<T> cls) throws IOException {
        _assertNotNull("p", jsonParser);
        return (T) forType((Class<?>) cls).readValue(jsonParser);
    }

    public <T> Iterator<T> readValues(JsonParser jsonParser, v63 v63Var) throws IOException {
        _assertNotNull("p", jsonParser);
        return forType(v63Var).readValues(jsonParser);
    }

    public ObjectReader with(u60 u60Var) {
        return _with(this._config.with(u60Var));
    }

    public ObjectReader withFeatures(JsonParser.Feature... featureArr) {
        return _with(this._config.withFeatures(featureArr));
    }

    @Deprecated
    public ObjectReader withType(Type type) {
        return forType(this._config.getTypeFactory().constructType(type));
    }

    public ObjectReader without(u60 u60Var) {
        return _with(this._config.without(u60Var));
    }

    public ObjectReader withoutFeatures(JsonParser.Feature... featureArr) {
        return _with(this._config.withoutFeatures(featureArr));
    }

    public boolean isEnabled(JsonParser.Feature feature) {
        return this._config.isEnabled(feature, this._parserFactory);
    }

    public ObjectReader with(JsonParser.Feature feature) {
        return _with(this._config.with(feature));
    }

    public ObjectReader withFeatures(hp0... hp0VarArr) {
        return _with(this._config.withFeatures(hp0VarArr));
    }

    @Deprecated
    public ObjectReader withType(v63 v63Var) {
        this._config.getTypeFactory();
        throw null;
    }

    public ObjectReader without(JsonParser.Feature feature) {
        return _with(this._config.without(feature));
    }

    public ObjectReader withoutFeatures(hp0... hp0VarArr) {
        return _with(this._config.withoutFeatures(hp0VarArr));
    }

    public JsonParser createParser(InputStream inputStream) throws IOException {
        _assertNotNull("in", inputStream);
        return this._config.initialize(this._parserFactory.createParser(inputStream), null);
    }

    public boolean isEnabled(StreamReadFeature streamReadFeature) {
        return this._config.isEnabled(streamReadFeature.mappedFeature(), this._parserFactory);
    }

    public <T> T readValue(JsonParser jsonParser, v63 v63Var) throws IOException {
        _assertNotNull("p", jsonParser);
        return (T) forType(v63Var).readValue(jsonParser);
    }

    public <T> Iterator<T> readValues(JsonParser jsonParser, ng2 ng2Var) throws IOException {
        _assertNotNull("p", jsonParser);
        return readValues(jsonParser, (JavaType) ng2Var);
    }

    public <T> T treeToValue(com.fasterxml.jackson.core.d dVar, JavaType javaType) throws JsonProcessingException {
        _assertNotNull("n", dVar);
        try {
            return (T) readValue(treeAsTokens(dVar), javaType);
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }

    public ObjectReader with(StreamReadFeature streamReadFeature) {
        return _with(this._config.with(streamReadFeature.mappedFeature()));
    }

    public ObjectReader without(StreamReadFeature streamReadFeature) {
        return _with(this._config.without(streamReadFeature.mappedFeature()));
    }

    protected Object _detectBindAndClose(z50.b bVar, boolean z) throws IOException {
        if (!bVar.d()) {
            _reportUnkownFormat(this._dataFormatReaders, bVar);
        }
        JsonParser jsonParserA = bVar.a();
        if (z) {
            jsonParserA.a0(JsonParser.Feature.AUTO_CLOSE_SOURCE);
        }
        return bVar.c()._bindAndClose(jsonParserA);
    }

    public ObjectReader forType(Class<?> cls) {
        return forType(this._config.constructType(cls));
    }

    public JsonNode readTree(Reader reader) throws IOException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(reader);
        }
        return _bindAndCloseAsTree(_considerFilter(createParser(reader), false));
    }

    public ObjectReader with(hp0 hp0Var) {
        return _with(this._config.with(hp0Var));
    }

    public ObjectReader without(hp0 hp0Var) {
        return _with(this._config.without(hp0Var));
    }

    public JsonParser createParser(Reader reader) throws IOException {
        _assertNotNull("r", reader);
        return this._config.initialize(this._parserFactory.createParser(reader), null);
    }

    public ObjectReader forType(v63 v63Var) {
        this._config.getTypeFactory();
        throw null;
    }

    public <T> T readValue(JsonParser jsonParser, ng2 ng2Var) throws IOException {
        _assertNotNull("p", jsonParser);
        return (T) forType((JavaType) ng2Var).readValue(jsonParser);
    }

    public <T> Iterator<T> readValues(JsonParser jsonParser, JavaType javaType) throws IOException {
        _assertNotNull("p", jsonParser);
        return forType(javaType).readValues(jsonParser);
    }

    public ObjectReader with(DeserializationConfig deserializationConfig) {
        return _with(deserializationConfig);
    }

    public ObjectReader with(InjectableValues injectableValues) {
        return this._injectableValues == injectableValues ? this : _new(this, this._config, this._valueType, this._rootDeserializer, this._valueToUpdate, null, injectableValues, this._dataFormatReaders);
    }

    public JsonParser createParser(byte[] bArr) throws IOException {
        _assertNotNull("content", bArr);
        return this._config.initialize(this._parserFactory.createParser(bArr), null);
    }

    public JsonNode readTree(String str) throws JsonProcessingException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(str);
        }
        try {
            return _bindAndCloseAsTree(_considerFilter(createParser(str), false));
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }

    public <T> T readValue(JsonParser jsonParser, JavaType javaType) throws IOException {
        _assertNotNull("p", jsonParser);
        return (T) forType(javaType).readValue(jsonParser);
    }

    public <T> b readValues(JsonParser jsonParser) throws IOException {
        _assertNotNull("p", jsonParser);
        DefaultDeserializationContext defaultDeserializationContextCreateDeserializationContext = createDeserializationContext(jsonParser);
        return _newIterator(jsonParser, defaultDeserializationContextCreateDeserializationContext, _findRootDeserializer(defaultDeserializationContextCreateDeserializationContext), false);
    }

    public ObjectReader with(JsonNodeFactory jsonNodeFactory) {
        return _with(this._config.with(jsonNodeFactory));
    }

    public JsonParser createParser(byte[] bArr, int i, int i2) throws IOException {
        _assertNotNull("content", bArr);
        return this._config.initialize(this._parserFactory.createParser(bArr, i, i2), null);
    }

    public <T> T readValue(InputStream inputStream) throws IOException {
        z50 z50Var = this._dataFormatReaders;
        if (z50Var != null) {
            return (T) _detectBindAndClose(z50Var.b(inputStream), false);
        }
        return (T) _bindAndClose(_considerFilter(createParser(inputStream), false));
    }

    public ObjectReader with(JsonFactory jsonFactory) {
        if (jsonFactory == this._parserFactory) {
            return this;
        }
        ObjectReader objectReader_new = _new(this, jsonFactory);
        if (jsonFactory.getCodec() == null) {
            jsonFactory.setCodec(objectReader_new);
        }
        return objectReader_new;
    }

    public <T> b readValues(InputStream inputStream) throws IOException {
        z50 z50Var = this._dataFormatReaders;
        if (z50Var != null) {
            return _detectBindAndReadValues(z50Var.b(inputStream), false);
        }
        return _bindAndReadValues(_considerFilter(createParser(inputStream), true));
    }

    public JsonParser createParser(String str) throws IOException {
        _assertNotNull("content", str);
        return this._config.initialize(this._parserFactory.createParser(str), null);
    }

    protected ObjectReader(ObjectReader objectReader, DeserializationConfig deserializationConfig, JavaType javaType, s51 s51Var, Object obj, ip0 ip0Var, InjectableValues injectableValues, z50 z50Var) {
        this._config = deserializationConfig;
        this._context = objectReader._context;
        this._rootDeserializers = objectReader._rootDeserializers;
        this._parserFactory = objectReader._parserFactory;
        this._valueType = javaType;
        this._rootDeserializer = s51Var;
        this._valueToUpdate = obj;
        this._injectableValues = injectableValues;
        this._unwrapRoot = deserializationConfig.useRootWrapping();
        this._dataFormatReaders = z50Var;
        this._filter = objectReader._filter;
    }

    public JsonNode readTree(byte[] bArr) throws IOException {
        _assertNotNull("json", bArr);
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(bArr);
        }
        return _bindAndCloseAsTree(_considerFilter(createParser(bArr), false));
    }

    public <T> T readValue(InputStream inputStream, Class<T> cls) throws IOException {
        return (T) forType((Class<?>) cls).readValue(inputStream);
    }

    public JsonParser createParser(char[] cArr) throws IOException {
        _assertNotNull("content", cArr);
        return this._config.initialize(this._parserFactory.createParser(cArr), null);
    }

    public <T> T readValue(Reader reader) throws IOException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(reader);
        }
        return (T) _bindAndClose(_considerFilter(createParser(reader), false));
    }

    public <T> b readValues(Reader reader) throws IOException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(reader);
        }
        JsonParser jsonParser_considerFilter = _considerFilter(createParser(reader), true);
        DefaultDeserializationContext defaultDeserializationContextCreateDeserializationContext = createDeserializationContext(jsonParser_considerFilter);
        _initForMultiRead(defaultDeserializationContextCreateDeserializationContext, jsonParser_considerFilter);
        jsonParser_considerFilter.n1();
        return _newIterator(jsonParser_considerFilter, defaultDeserializationContextCreateDeserializationContext, _findRootDeserializer(defaultDeserializationContextCreateDeserializationContext), true);
    }

    public ObjectReader with(ip0 ip0Var) {
        if (ip0Var == null) {
            return this;
        }
        _verifySchemaType(ip0Var);
        return _new(this, this._config, this._valueType, this._rootDeserializer, this._valueToUpdate, ip0Var, this._injectableValues, this._dataFormatReaders);
    }

    public JsonParser createParser(char[] cArr, int i, int i2) throws IOException {
        _assertNotNull("content", cArr);
        return this._config.initialize(this._parserFactory.createParser(cArr, i, i2), null);
    }

    public ObjectReader with(Locale locale) {
        return _with(this._config.with(locale));
    }

    public JsonNode readTree(byte[] bArr, int i, int i2) throws IOException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(bArr);
        }
        return _bindAndCloseAsTree(_considerFilter(createParser(bArr, i, i2), false));
    }

    public <T> T readValue(Reader reader, Class<T> cls) throws IOException {
        return (T) forType((Class<?>) cls).readValue(reader);
    }

    public ObjectReader with(TimeZone timeZone) {
        return _with(this._config.with(timeZone));
    }

    public JsonParser createParser(DataInput dataInput) throws IOException {
        _assertNotNull("content", dataInput);
        return this._config.initialize(this._parserFactory.createParser(dataInput), null);
    }

    public <T> T readValue(String str) throws JsonProcessingException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(str);
        }
        try {
            return (T) _bindAndClose(_considerFilter(createParser(str), false));
        } catch (JsonProcessingException e) {
            throw e;
        } catch (IOException e2) {
            throw JsonMappingException.fromUnexpectedIOE(e2);
        }
    }

    public ObjectReader with(Base64Variant base64Variant) {
        return _with(this._config.with(base64Variant));
    }

    public ObjectReader with(ContextAttributes contextAttributes) {
        return _with(this._config.with(contextAttributes));
    }

    public JsonNode readTree(DataInput dataInput) throws IOException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(dataInput);
        }
        return _bindAndCloseAsTree(_considerFilter(createParser(dataInput), false));
    }

    public <T> b readValues(String str) throws IOException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(str);
        }
        JsonParser jsonParser_considerFilter = _considerFilter(createParser(str), true);
        DefaultDeserializationContext defaultDeserializationContextCreateDeserializationContext = createDeserializationContext(jsonParser_considerFilter);
        _initForMultiRead(defaultDeserializationContextCreateDeserializationContext, jsonParser_considerFilter);
        jsonParser_considerFilter.n1();
        return _newIterator(jsonParser_considerFilter, defaultDeserializationContextCreateDeserializationContext, _findRootDeserializer(defaultDeserializationContextCreateDeserializationContext), true);
    }

    public <T> T readValue(String str, Class<T> cls) throws IOException {
        return (T) forType((Class<?>) cls).readValue(str);
    }

    public <T> T readValue(byte[] bArr) throws IOException {
        if (this._dataFormatReaders != null) {
            return (T) _detectBindAndClose(bArr, 0, bArr.length);
        }
        return (T) _bindAndClose(_considerFilter(createParser(bArr), false));
    }

    protected ObjectReader(ObjectReader objectReader, DeserializationConfig deserializationConfig) {
        this._config = deserializationConfig;
        this._context = objectReader._context;
        this._rootDeserializers = objectReader._rootDeserializers;
        this._parserFactory = objectReader._parserFactory;
        this._valueType = objectReader._valueType;
        this._rootDeserializer = objectReader._rootDeserializer;
        this._valueToUpdate = objectReader._valueToUpdate;
        this._injectableValues = objectReader._injectableValues;
        this._unwrapRoot = deserializationConfig.useRootWrapping();
        this._dataFormatReaders = objectReader._dataFormatReaders;
        this._filter = objectReader._filter;
    }

    public <T> T readValue(byte[] bArr, Class<T> cls) throws IOException {
        return (T) forType((Class<?>) cls).readValue(bArr);
    }

    public <T> T readValue(byte[] bArr, int i, int i2) throws IOException {
        if (this._dataFormatReaders != null) {
            return (T) _detectBindAndClose(bArr, i, i2);
        }
        return (T) _bindAndClose(_considerFilter(createParser(bArr, i, i2), false));
    }

    public <T> b readValues(byte[] bArr, int i, int i2) throws IOException {
        z50 z50Var = this._dataFormatReaders;
        if (z50Var != null) {
            return _detectBindAndReadValues(z50Var.c(bArr, i, i2), false);
        }
        return _bindAndReadValues(_considerFilter(createParser(bArr, i, i2), true));
    }

    public <T> T readValue(byte[] bArr, int i, int i2, Class<T> cls) throws IOException {
        return (T) forType((Class<?>) cls).readValue(bArr, i, i2);
    }

    public final <T> b readValues(byte[] bArr) throws IOException {
        _assertNotNull("src", bArr);
        return readValues(bArr, 0, bArr.length);
    }

    public <T> T readValue(File file) throws IOException {
        z50 z50Var = this._dataFormatReaders;
        if (z50Var != null) {
            return (T) _detectBindAndClose(z50Var.b(_inputStream(file)), true);
        }
        return (T) _bindAndClose(_considerFilter(createParser(file), false));
    }

    public <T> b readValues(File file) throws IOException {
        z50 z50Var = this._dataFormatReaders;
        if (z50Var != null) {
            return _detectBindAndReadValues(z50Var.b(_inputStream(file)), false);
        }
        return _bindAndReadValues(_considerFilter(createParser(file), true));
    }

    public <T> T readValue(File file, Class<T> cls) throws IOException {
        return (T) forType((Class<?>) cls).readValue(file);
    }

    public <T> T readValue(URL url) throws IOException {
        z50 z50Var = this._dataFormatReaders;
        if (z50Var != null) {
            return (T) _detectBindAndClose(z50Var.b(_inputStream(url)), true);
        }
        return (T) _bindAndClose(_considerFilter(createParser(url), false));
    }

    protected ObjectReader(ObjectReader objectReader, JsonFactory jsonFactory) {
        this._config = objectReader._config.with(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, jsonFactory.requiresPropertyOrdering());
        this._context = objectReader._context;
        this._rootDeserializers = objectReader._rootDeserializers;
        this._parserFactory = jsonFactory;
        this._valueType = objectReader._valueType;
        this._rootDeserializer = objectReader._rootDeserializer;
        this._valueToUpdate = objectReader._valueToUpdate;
        this._injectableValues = objectReader._injectableValues;
        this._unwrapRoot = objectReader._unwrapRoot;
        this._dataFormatReaders = objectReader._dataFormatReaders;
        this._filter = objectReader._filter;
    }

    public <T> b readValues(URL url) throws IOException {
        z50 z50Var = this._dataFormatReaders;
        if (z50Var != null) {
            return _detectBindAndReadValues(z50Var.b(_inputStream(url)), true);
        }
        return _bindAndReadValues(_considerFilter(createParser(url), true));
    }

    public <T> T readValue(URL url, Class<T> cls) throws IOException {
        return (T) forType((Class<?>) cls).readValue(url);
    }

    public <T> T readValue(JsonNode jsonNode) throws IOException {
        _assertNotNull("content", jsonNode);
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(jsonNode);
        }
        return (T) _bindAndClose(_considerFilter(treeAsTokens(jsonNode), false));
    }

    public <T> b readValues(DataInput dataInput) throws IOException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(dataInput);
        }
        return _bindAndReadValues(_considerFilter(createParser(dataInput), true));
    }

    public <T> T readValue(JsonNode jsonNode, Class<T> cls) throws IOException {
        return (T) forType((Class<?>) cls).readValue(jsonNode);
    }

    public <T> T readValue(DataInput dataInput) throws IOException {
        if (this._dataFormatReaders != null) {
            _reportUndetectableSource(dataInput);
        }
        return (T) _bindAndClose(_considerFilter(createParser(dataInput), false));
    }

    public <T> T readValue(DataInput dataInput, Class<T> cls) throws IOException {
        return (T) forType((Class<?>) cls).readValue(dataInput);
    }

    protected ObjectReader(ObjectReader objectReader, TokenFilter tokenFilter) {
        this._config = objectReader._config;
        this._context = objectReader._context;
        this._rootDeserializers = objectReader._rootDeserializers;
        this._parserFactory = objectReader._parserFactory;
        this._valueType = objectReader._valueType;
        this._rootDeserializer = objectReader._rootDeserializer;
        this._valueToUpdate = objectReader._valueToUpdate;
        this._injectableValues = objectReader._injectableValues;
        this._unwrapRoot = objectReader._unwrapRoot;
        this._dataFormatReaders = objectReader._dataFormatReaders;
        this._filter = tokenFilter;
    }
}
