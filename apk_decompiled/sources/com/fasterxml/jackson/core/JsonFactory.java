package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.core.io.InputDecorator;
import com.fasterxml.jackson.core.io.OutputDecorator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import defpackage.c41;
import defpackage.dd2;
import defpackage.e83;
import defpackage.f83;
import defpackage.fx;
import defpackage.h83;
import defpackage.hp0;
import defpackage.io;
import defpackage.ip0;
import defpackage.ir1;
import defpackage.jo;
import defpackage.jr1;
import defpackage.jt1;
import defpackage.kl3;
import defpackage.m21;
import defpackage.mp;
import defpackage.np;
import defpackage.oy0;
import defpackage.vm2;
import defpackage.wy1;
import java.io.CharArrayReader;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.Writer;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class JsonFactory extends TokenStreamFactory implements Serializable {
    public static final char DEFAULT_QUOTE_CHAR = '\"';
    public static final String FORMAT_NAME_JSON = "JSON";
    private static final long serialVersionUID = 2;
    protected final transient mp _byteSymbolCanonicalizer;
    protected CharacterEscapes _characterEscapes;
    protected int _factoryFeatures;
    protected int _generatorFeatures;
    protected InputDecorator _inputDecorator;
    protected int _maximumNonEscapedChar;
    protected jt1 _objectCodec;
    protected OutputDecorator _outputDecorator;
    protected int _parserFeatures;
    protected final char _quoteChar;
    protected final transient fx _rootCharSymbols;
    protected vm2 _rootValueSeparator;
    protected static final int DEFAULT_FACTORY_FEATURE_FLAGS = Feature.collectDefaults();
    protected static final int DEFAULT_PARSER_FEATURE_FLAGS = JsonParser.Feature.collectDefaults();
    protected static final int DEFAULT_GENERATOR_FEATURE_FLAGS = JsonGenerator.Feature.collectDefaults();
    public static final vm2 DEFAULT_ROOT_VALUE_SEPARATOR = DefaultPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;

    public enum Feature implements c41 {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true),
        FAIL_ON_SYMBOL_HASH_OVERFLOW(true),
        USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING(true);

        private final boolean _defaultState;

        Feature(boolean z) {
            this._defaultState = z;
        }

        public static int collectDefaults() {
            int mask = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    mask |= feature.getMask();
                }
            }
            return mask;
        }

        @Override // defpackage.c41
        public boolean enabledByDefault() {
            return this._defaultState;
        }

        @Override // defpackage.c41
        public boolean enabledIn(int i) {
            return (i & getMask()) != 0;
        }

        @Override // defpackage.c41
        public int getMask() {
            return 1 << ordinal();
        }
    }

    public JsonFactory() {
        this((jt1) null);
    }

    private final boolean _isJSONFactory() {
        return getFormatName() == FORMAT_NAME_JSON;
    }

    private final void _requireJSONFactory(String str) {
        if (!_isJSONFactory()) {
            throw new UnsupportedOperationException(String.format(str, getFormatName()));
        }
    }

    public static c builder() {
        return new b();
    }

    protected void _checkInvalidCopy(Class<?> cls) {
        if (getClass() == cls) {
            return;
        }
        throw new IllegalStateException("Failed copy(): " + getClass().getName() + " (version: " + version() + ") does not override copy(); it has to");
    }

    protected ContentReference _createContentReference(Object obj) {
        return ContentReference.construct(!canHandleBinaryNatively(), obj);
    }

    protected oy0 _createContext(ContentReference contentReference, boolean z) {
        if (contentReference == null) {
            contentReference = ContentReference.unknown();
        }
        return new oy0(_getBufferRecycler(), contentReference, z);
    }

    protected JsonGenerator _createGenerator(Writer writer, oy0 oy0Var) throws IOException {
        kl3 kl3Var = new kl3(oy0Var, this._generatorFeatures, this._objectCodec, writer, this._quoteChar);
        int i = this._maximumNonEscapedChar;
        if (i > 0) {
            kl3Var.A0(i);
        }
        CharacterEscapes characterEscapes = this._characterEscapes;
        if (characterEscapes != null) {
            kl3Var.w0(characterEscapes);
        }
        vm2 vm2Var = this._rootValueSeparator;
        if (vm2Var != DEFAULT_ROOT_VALUE_SEPARATOR) {
            kl3Var.G0(vm2Var);
        }
        return kl3Var;
    }

    protected oy0 _createNonBlockingContext(Object obj) {
        return new oy0(_getBufferRecycler(), _createContentReference(obj), false);
    }

    protected JsonParser _createParser(InputStream inputStream, oy0 oy0Var) throws IOException {
        try {
            return new np(oy0Var, inputStream).c(this._parserFeatures, this._objectCodec, this._byteSymbolCanonicalizer, this._rootCharSymbols, this._factoryFeatures);
        } catch (IOException | RuntimeException e) {
            if (oy0Var.n()) {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    e.addSuppressed(e2);
                }
            }
            throw e;
        }
    }

    protected JsonGenerator _createUTF8Generator(OutputStream outputStream, oy0 oy0Var) throws IOException {
        f83 f83Var = new f83(oy0Var, this._generatorFeatures, this._objectCodec, outputStream, this._quoteChar);
        int i = this._maximumNonEscapedChar;
        if (i > 0) {
            f83Var.A0(i);
        }
        CharacterEscapes characterEscapes = this._characterEscapes;
        if (characterEscapes != null) {
            f83Var.w0(characterEscapes);
        }
        vm2 vm2Var = this._rootValueSeparator;
        if (vm2Var != DEFAULT_ROOT_VALUE_SEPARATOR) {
            f83Var.G0(vm2Var);
        }
        return f83Var;
    }

    protected Writer _createWriter(OutputStream outputStream, JsonEncoding jsonEncoding, oy0 oy0Var) throws IOException {
        return jsonEncoding == JsonEncoding.UTF8 ? new h83(oy0Var, outputStream) : new OutputStreamWriter(outputStream, jsonEncoding.getJavaName());
    }

    protected final InputStream _decorate(InputStream inputStream, oy0 oy0Var) throws IOException {
        InputStream inputStreamDecorate;
        InputDecorator inputDecorator = this._inputDecorator;
        return (inputDecorator == null || (inputStreamDecorate = inputDecorator.decorate(oy0Var, inputStream)) == null) ? inputStream : inputStreamDecorate;
    }

    public io _getBufferRecycler() {
        return Feature.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.enabledIn(this._factoryFeatures) ? jo.a() : new io();
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public boolean canHandleBinaryNatively() {
        return false;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public boolean canParseAsync() {
        return _isJSONFactory();
    }

    public boolean canUseCharArrays() {
        return true;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public boolean canUseSchema(ip0 ip0Var) {
        String formatName;
        return (ip0Var == null || (formatName = getFormatName()) == null || !formatName.equals(ip0Var.a())) ? false : true;
    }

    @Deprecated
    public final JsonFactory configure(Feature feature, boolean z) {
        return z ? enable(feature) : disable(feature);
    }

    public JsonFactory copy() {
        _checkInvalidCopy(JsonFactory.class);
        return new JsonFactory(this, (jt1) null);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonGenerator createGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException {
        oy0 oy0Var_createContext = _createContext(_createContentReference(outputStream), false);
        oy0Var_createContext.u(jsonEncoding);
        return jsonEncoding == JsonEncoding.UTF8 ? _createUTF8Generator(_decorate(outputStream, oy0Var_createContext), oy0Var_createContext) : _createGenerator(_decorate(_createWriter(outputStream, jsonEncoding, oy0Var_createContext), oy0Var_createContext), oy0Var_createContext);
    }

    @Deprecated
    public JsonGenerator createJsonGenerator(OutputStream outputStream, JsonEncoding jsonEncoding) throws IOException {
        return createGenerator(outputStream, jsonEncoding);
    }

    @Deprecated
    public JsonParser createJsonParser(File file) throws IOException {
        return createParser(file);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createNonBlockingByteArrayParser() throws IOException {
        _requireJSONFactory("Non-blocking source not (yet?) supported for this format (%s)");
        return new jr1(_createNonBlockingContext(null), this._parserFeatures, this._byteSymbolCanonicalizer.A(this._factoryFeatures));
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createNonBlockingByteBufferParser() throws IOException {
        _requireJSONFactory("Non-blocking source not (yet?) supported for this format (%s)");
        return new ir1(_createNonBlockingContext(null), this._parserFeatures, this._byteSymbolCanonicalizer.A(this._factoryFeatures));
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(File file) throws IOException {
        oy0 oy0Var_createContext = _createContext(_createContentReference(file), true);
        return _createParser(_decorate(_fileInputStream(file), oy0Var_createContext), oy0Var_createContext);
    }

    @Deprecated
    public JsonFactory disable(Feature feature) {
        this._factoryFeatures = (~feature.getMask()) & this._factoryFeatures;
        return this;
    }

    @Deprecated
    public JsonFactory enable(Feature feature) {
        this._factoryFeatures = feature.getMask() | this._factoryFeatures;
        return this;
    }

    public CharacterEscapes getCharacterEscapes() {
        return this._characterEscapes;
    }

    public jt1 getCodec() {
        return this._objectCodec;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public int getFormatGeneratorFeatures() {
        return 0;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public String getFormatName() {
        if (getClass() == JsonFactory.class) {
            return FORMAT_NAME_JSON;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public int getFormatParserFeatures() {
        return 0;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public Class<? extends hp0> getFormatReadFeatureType() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public Class<? extends hp0> getFormatWriteFeatureType() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public final int getGeneratorFeatures() {
        return this._generatorFeatures;
    }

    public InputDecorator getInputDecorator() {
        return this._inputDecorator;
    }

    public OutputDecorator getOutputDecorator() {
        return this._outputDecorator;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public final int getParserFeatures() {
        return this._parserFeatures;
    }

    public String getRootValueSeparator() {
        vm2 vm2Var = this._rootValueSeparator;
        if (vm2Var == null) {
            return null;
        }
        return vm2Var.getValue();
    }

    public MatchStrength hasFormat(m21 m21Var) throws IOException {
        if (getClass() == JsonFactory.class) {
            return hasJSONFormat(m21Var);
        }
        return null;
    }

    protected MatchStrength hasJSONFormat(m21 m21Var) throws IOException {
        return np.h(m21Var);
    }

    public final boolean isEnabled(Feature feature) {
        return (feature.getMask() & this._factoryFeatures) != 0;
    }

    protected Object readResolve() {
        return new JsonFactory(this, this._objectCodec);
    }

    public c rebuild() {
        _requireJSONFactory("Factory implementation for format (%s) MUST override `rebuild()` method");
        return new b(this);
    }

    public boolean requiresCustomCodec() {
        return false;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public boolean requiresPropertyOrdering() {
        return false;
    }

    public JsonFactory setCharacterEscapes(CharacterEscapes characterEscapes) {
        this._characterEscapes = characterEscapes;
        return this;
    }

    public JsonFactory setCodec(jt1 jt1Var) {
        this._objectCodec = jt1Var;
        return this;
    }

    @Deprecated
    public JsonFactory setInputDecorator(InputDecorator inputDecorator) {
        this._inputDecorator = inputDecorator;
        return this;
    }

    @Deprecated
    public JsonFactory setOutputDecorator(OutputDecorator outputDecorator) {
        this._outputDecorator = outputDecorator;
        return this;
    }

    public JsonFactory setRootValueSeparator(String str) {
        this._rootValueSeparator = str == null ? null : new SerializedString(str);
        return this;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public Version version() {
        return wy1.a;
    }

    public JsonFactory(jt1 jt1Var) {
        this._rootCharSymbols = fx.j();
        this._byteSymbolCanonicalizer = mp.u();
        this._factoryFeatures = DEFAULT_FACTORY_FEATURE_FLAGS;
        this._parserFeatures = DEFAULT_PARSER_FEATURE_FLAGS;
        this._generatorFeatures = DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._rootValueSeparator = DEFAULT_ROOT_VALUE_SEPARATOR;
        this._objectCodec = jt1Var;
        this._quoteChar = DEFAULT_QUOTE_CHAR;
    }

    protected ContentReference _createContentReference(Object obj, int i, int i2) {
        return ContentReference.construct(!canHandleBinaryNatively(), obj, i, i2);
    }

    public final JsonFactory configure(JsonParser.Feature feature, boolean z) {
        return z ? enable(feature) : disable(feature);
    }

    @Deprecated
    public JsonGenerator createJsonGenerator(Writer writer) throws IOException {
        return createGenerator(writer);
    }

    @Deprecated
    public JsonParser createJsonParser(URL url) throws IOException {
        return createParser(url);
    }

    public JsonFactory disable(JsonParser.Feature feature) {
        this._parserFeatures = (~feature.getMask()) & this._parserFeatures;
        return this;
    }

    public JsonFactory enable(JsonParser.Feature feature) {
        this._parserFeatures = feature.getMask() | this._parserFeatures;
        return this;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public final boolean isEnabled(JsonParser.Feature feature) {
        return (feature.getMask() & this._parserFeatures) != 0;
    }

    @Deprecated
    protected oy0 _createContext(Object obj, boolean z) {
        return new oy0(_getBufferRecycler(), _createContentReference(obj), z);
    }

    protected final Reader _decorate(Reader reader, oy0 oy0Var) throws IOException {
        Reader readerDecorate;
        InputDecorator inputDecorator = this._inputDecorator;
        return (inputDecorator == null || (readerDecorate = inputDecorator.decorate(oy0Var, reader)) == null) ? reader : readerDecorate;
    }

    public final JsonFactory configure(JsonGenerator.Feature feature, boolean z) {
        return z ? enable(feature) : disable(feature);
    }

    @Deprecated
    public JsonGenerator createJsonGenerator(OutputStream outputStream) throws IOException {
        return createGenerator(outputStream, JsonEncoding.UTF8);
    }

    @Deprecated
    public JsonParser createJsonParser(InputStream inputStream) throws IOException {
        return createParser(inputStream);
    }

    public JsonFactory disable(JsonGenerator.Feature feature) {
        this._generatorFeatures = (~feature.getMask()) & this._generatorFeatures;
        return this;
    }

    public JsonFactory enable(JsonGenerator.Feature feature) {
        this._generatorFeatures = feature.getMask() | this._generatorFeatures;
        return this;
    }

    public final boolean isEnabled(StreamReadFeature streamReadFeature) {
        return (streamReadFeature.mappedFeature().getMask() & this._parserFeatures) != 0;
    }

    @Deprecated
    public JsonParser createJsonParser(Reader reader) throws IOException {
        return createParser(reader);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(URL url) throws IOException {
        oy0 oy0Var_createContext = _createContext(_createContentReference(url), true);
        return _createParser(_decorate(_optimizedStreamFromURL(url), oy0Var_createContext), oy0Var_createContext);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public final boolean isEnabled(JsonGenerator.Feature feature) {
        return (feature.getMask() & this._generatorFeatures) != 0;
    }

    protected final DataInput _decorate(DataInput dataInput, oy0 oy0Var) throws IOException {
        DataInput dataInputDecorate;
        InputDecorator inputDecorator = this._inputDecorator;
        return (inputDecorator == null || (dataInputDecorate = inputDecorator.decorate(oy0Var, dataInput)) == null) ? dataInput : dataInputDecorate;
    }

    @Deprecated
    public JsonParser createJsonParser(byte[] bArr) throws IOException {
        return createParser(bArr);
    }

    public final boolean isEnabled(StreamWriteFeature streamWriteFeature) {
        return (streamWriteFeature.mappedFeature().getMask() & this._generatorFeatures) != 0;
    }

    protected JsonParser _createParser(Reader reader, oy0 oy0Var) throws IOException {
        return new dd2(oy0Var, this._parserFeatures, reader, this._objectCodec, this._rootCharSymbols.n(this._factoryFeatures));
    }

    @Deprecated
    public JsonParser createJsonParser(byte[] bArr, int i, int i2) throws IOException {
        return createParser(bArr, i, i2);
    }

    protected final OutputStream _decorate(OutputStream outputStream, oy0 oy0Var) throws IOException {
        OutputStream outputStreamDecorate;
        OutputDecorator outputDecorator = this._outputDecorator;
        return (outputDecorator == null || (outputStreamDecorate = outputDecorator.decorate(oy0Var, outputStream)) == null) ? outputStream : outputStreamDecorate;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonGenerator createGenerator(OutputStream outputStream) throws IOException {
        return createGenerator(outputStream, JsonEncoding.UTF8);
    }

    @Deprecated
    public JsonParser createJsonParser(String str) throws IOException {
        return createParser(str);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(InputStream inputStream) throws IOException {
        oy0 oy0Var_createContext = _createContext(_createContentReference(inputStream), false);
        return _createParser(_decorate(inputStream, oy0Var_createContext), oy0Var_createContext);
    }

    protected JsonParser _createParser(char[] cArr, int i, int i2, oy0 oy0Var, boolean z) throws IOException {
        return new dd2(oy0Var, this._parserFeatures, null, this._objectCodec, this._rootCharSymbols.n(this._factoryFeatures), cArr, i, i + i2, z);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonGenerator createGenerator(Writer writer) throws IOException {
        oy0 oy0Var_createContext = _createContext(_createContentReference(writer), false);
        return _createGenerator(_decorate(writer, oy0Var_createContext), oy0Var_createContext);
    }

    protected final Writer _decorate(Writer writer, oy0 oy0Var) throws IOException {
        Writer writerDecorate;
        OutputDecorator outputDecorator = this._outputDecorator;
        return (outputDecorator == null || (writerDecorate = outputDecorator.decorate(oy0Var, writer)) == null) ? writer : writerDecorate;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(Reader reader) throws IOException {
        oy0 oy0Var_createContext = _createContext(_createContentReference(reader), false);
        return _createParser(_decorate(reader, oy0Var_createContext), oy0Var_createContext);
    }

    protected JsonParser _createParser(byte[] bArr, int i, int i2, oy0 oy0Var) throws IOException {
        return new np(oy0Var, bArr, i, i2).c(this._parserFeatures, this._objectCodec, this._byteSymbolCanonicalizer, this._rootCharSymbols, this._factoryFeatures);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonGenerator createGenerator(File file, JsonEncoding jsonEncoding) throws IOException {
        OutputStream outputStream_fileOutputStream = _fileOutputStream(file);
        oy0 oy0Var_createContext = _createContext(_createContentReference(outputStream_fileOutputStream), true);
        oy0Var_createContext.u(jsonEncoding);
        if (jsonEncoding == JsonEncoding.UTF8) {
            return _createUTF8Generator(_decorate(outputStream_fileOutputStream, oy0Var_createContext), oy0Var_createContext);
        }
        return _createGenerator(_decorate(_createWriter(outputStream_fileOutputStream, jsonEncoding, oy0Var_createContext), oy0Var_createContext), oy0Var_createContext);
    }

    protected JsonFactory(JsonFactory jsonFactory, jt1 jt1Var) {
        this._rootCharSymbols = fx.j();
        this._byteSymbolCanonicalizer = mp.u();
        this._factoryFeatures = DEFAULT_FACTORY_FEATURE_FLAGS;
        this._parserFeatures = DEFAULT_PARSER_FEATURE_FLAGS;
        this._generatorFeatures = DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._rootValueSeparator = DEFAULT_ROOT_VALUE_SEPARATOR;
        this._objectCodec = jt1Var;
        this._factoryFeatures = jsonFactory._factoryFeatures;
        this._parserFeatures = jsonFactory._parserFeatures;
        this._generatorFeatures = jsonFactory._generatorFeatures;
        this._inputDecorator = jsonFactory._inputDecorator;
        this._outputDecorator = jsonFactory._outputDecorator;
        this._characterEscapes = jsonFactory._characterEscapes;
        this._rootValueSeparator = jsonFactory._rootValueSeparator;
        this._maximumNonEscapedChar = jsonFactory._maximumNonEscapedChar;
        this._quoteChar = jsonFactory._quoteChar;
    }

    protected JsonParser _createParser(DataInput dataInput, oy0 oy0Var) throws IOException {
        _requireJSONFactory("InputData source not (yet?) supported for this format (%s)");
        int iL = np.l(dataInput);
        return new e83(oy0Var, this._parserFeatures, dataInput, this._objectCodec, this._byteSymbolCanonicalizer.A(this._factoryFeatures), iL);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(byte[] bArr) throws IOException {
        InputStream inputStreamDecorate;
        oy0 oy0Var_createContext = _createContext(_createContentReference(bArr), true);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null && (inputStreamDecorate = inputDecorator.decorate(oy0Var_createContext, bArr, 0, bArr.length)) != null) {
            return _createParser(inputStreamDecorate, oy0Var_createContext);
        }
        return _createParser(bArr, 0, bArr.length, oy0Var_createContext);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(byte[] bArr, int i, int i2) throws IOException {
        InputStream inputStreamDecorate;
        _checkRangeBoundsForByteArray(bArr, i, i2);
        oy0 oy0Var_createContext = _createContext(_createContentReference(bArr, i, i2), true);
        InputDecorator inputDecorator = this._inputDecorator;
        if (inputDecorator != null && (inputStreamDecorate = inputDecorator.decorate(oy0Var_createContext, bArr, i, i2)) != null) {
            return _createParser(inputStreamDecorate, oy0Var_createContext);
        }
        return _createParser(bArr, i, i2, oy0Var_createContext);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonGenerator createGenerator(DataOutput dataOutput, JsonEncoding jsonEncoding) throws IOException {
        return createGenerator(_createDataOutputWrapper(dataOutput), jsonEncoding);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonGenerator createGenerator(DataOutput dataOutput) throws IOException {
        return createGenerator(_createDataOutputWrapper(dataOutput), JsonEncoding.UTF8);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(String str) throws IOException {
        int length = str.length();
        if (this._inputDecorator == null && length <= 32768 && canUseCharArrays()) {
            oy0 oy0Var_createContext = _createContext(_createContentReference(str), true);
            char[] cArrI = oy0Var_createContext.i(length);
            str.getChars(0, length, cArrI, 0);
            return _createParser(cArrI, 0, length, oy0Var_createContext, true);
        }
        return createParser(new StringReader(str));
    }

    public JsonFactory(b bVar) {
        this._rootCharSymbols = fx.j();
        this._byteSymbolCanonicalizer = mp.u();
        this._factoryFeatures = DEFAULT_FACTORY_FEATURE_FLAGS;
        this._parserFeatures = DEFAULT_PARSER_FEATURE_FLAGS;
        this._generatorFeatures = DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._rootValueSeparator = DEFAULT_ROOT_VALUE_SEPARATOR;
        this._objectCodec = null;
        this._factoryFeatures = bVar.a;
        this._parserFeatures = bVar.b;
        this._generatorFeatures = bVar.c;
        this._inputDecorator = bVar.d;
        this._outputDecorator = bVar.e;
        this._characterEscapes = bVar.i;
        this._rootValueSeparator = bVar.j;
        this._maximumNonEscapedChar = bVar.k;
        this._quoteChar = bVar.l;
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(char[] cArr) throws IOException {
        return createParser(cArr, 0, cArr.length);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(char[] cArr, int i, int i2) throws IOException {
        _checkRangeBoundsForCharArray(cArr, i, i2);
        if (this._inputDecorator != null) {
            return createParser(new CharArrayReader(cArr, i, i2));
        }
        return _createParser(cArr, i, i2, _createContext(_createContentReference(cArr, i, i2), true), false);
    }

    @Override // com.fasterxml.jackson.core.TokenStreamFactory
    public JsonParser createParser(DataInput dataInput) throws IOException {
        oy0 oy0Var_createContext = _createContext(_createContentReference(dataInput), false);
        return _createParser(_decorate(dataInput, oy0Var_createContext), oy0Var_createContext);
    }

    protected JsonFactory(c cVar, boolean z) {
        this._rootCharSymbols = fx.j();
        this._byteSymbolCanonicalizer = mp.u();
        this._factoryFeatures = DEFAULT_FACTORY_FEATURE_FLAGS;
        this._parserFeatures = DEFAULT_PARSER_FEATURE_FLAGS;
        this._generatorFeatures = DEFAULT_GENERATOR_FEATURE_FLAGS;
        this._rootValueSeparator = DEFAULT_ROOT_VALUE_SEPARATOR;
        this._objectCodec = null;
        this._factoryFeatures = cVar.a;
        this._parserFeatures = cVar.b;
        this._generatorFeatures = cVar.c;
        this._inputDecorator = cVar.d;
        this._outputDecorator = cVar.e;
        this._characterEscapes = null;
        this._rootValueSeparator = null;
        this._maximumNonEscapedChar = 0;
        this._quoteChar = DEFAULT_QUOTE_CHAR;
    }
}
