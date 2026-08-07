package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.NullsAsEmptyProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsFailProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.tencent.connect.common.Constants;
import defpackage.a91;
import defpackage.ay;
import defpackage.f40;
import defpackage.gs1;
import defpackage.hs1;
import defpackage.m63;
import defpackage.s51;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class StdDeserializer<T> extends s51 implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Class<?> _valueClass;
    protected final JavaType _valueType;
    protected static final int F_MASK_INT_COERCIONS = DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.getMask() | DeserializationFeature.USE_LONG_FOR_INTS.getMask();

    @Deprecated
    protected static final int F_MASK_ACCEPT_ARRAYS = DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS.getMask() | DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT.getMask();

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CoercionAction.values().length];
            a = iArr;
            try {
                iArr[CoercionAction.AsEmpty.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CoercionAction.AsNull.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CoercionAction.TryConvert.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[CoercionAction.Fail.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    protected StdDeserializer(Class<?> cls) {
        this._valueClass = cls;
        this._valueType = null;
    }

    protected static final boolean _isBlank(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) > ' ') {
                return false;
            }
        }
        return true;
    }

    protected static final boolean _neitherNull(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? false : true;
    }

    protected static final double _parseDouble(String str) throws NumberFormatException {
        return _parseDouble(str, false);
    }

    protected final boolean _byteOverflow(int i) {
        return i < -128 || i > 255;
    }

    protected CoercionAction _checkBooleanToStringCoercion(JsonParser jsonParser, DeserializationContext deserializationContext, Class<?> cls) throws IOException {
        return _checkToStringCoercion(jsonParser, deserializationContext, cls, Boolean.valueOf(jsonParser.k0()), CoercionInputShape.Boolean);
    }

    protected CoercionAction _checkCoercionFail(DeserializationContext deserializationContext, CoercionAction coercionAction, Class<?> cls, Object obj, String str) throws IOException {
        if (coercionAction == CoercionAction.Fail) {
            deserializationContext.reportBadCoercion(this, cls, obj, "Cannot coerce %s to %s (but could if coercion was enabled using `CoercionConfig`)", str, _coercedTypeDesc());
        }
        return coercionAction;
    }

    protected Double _checkDoubleSpecialValue(String str) {
        if (str.isEmpty()) {
            return null;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == '-') {
            if (_isNegInf(str)) {
                return Double.valueOf(Double.NEGATIVE_INFINITY);
            }
            return null;
        }
        if (cCharAt == 'I') {
            if (_isPosInf(str)) {
                return Double.valueOf(Double.POSITIVE_INFINITY);
            }
            return null;
        }
        if (cCharAt == 'N' && _isNaN(str)) {
            return Double.valueOf(Double.NaN);
        }
        return null;
    }

    protected Float _checkFloatSpecialValue(String str) {
        if (str.isEmpty()) {
            return null;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == '-') {
            if (_isNegInf(str)) {
                return Float.valueOf(Float.NEGATIVE_INFINITY);
            }
            return null;
        }
        if (cCharAt == 'I') {
            if (_isPosInf(str)) {
                return Float.valueOf(Float.POSITIVE_INFINITY);
            }
            return null;
        }
        if (cCharAt == 'N' && _isNaN(str)) {
            return Float.valueOf(Float.NaN);
        }
        return null;
    }

    protected CoercionAction _checkFloatToIntCoercion(JsonParser jsonParser, DeserializationContext deserializationContext, Class<?> cls) throws IOException {
        CoercionAction coercionActionFindCoercionAction = deserializationContext.findCoercionAction(LogicalType.Integer, cls, CoercionInputShape.Float);
        if (coercionActionFindCoercionAction != CoercionAction.Fail) {
            return coercionActionFindCoercionAction;
        }
        return _checkCoercionFail(deserializationContext, coercionActionFindCoercionAction, cls, jsonParser.M0(), "Floating-point value (" + jsonParser.S0() + ")");
    }

    protected CoercionAction _checkFloatToStringCoercion(JsonParser jsonParser, DeserializationContext deserializationContext, Class<?> cls) throws IOException {
        return _checkToStringCoercion(jsonParser, deserializationContext, cls, jsonParser.M0(), CoercionInputShape.Float);
    }

    protected CoercionAction _checkFromStringCoercion(DeserializationContext deserializationContext, String str) throws IOException {
        return _checkFromStringCoercion(deserializationContext, str, logicalType(), handledType());
    }

    protected CoercionAction _checkIntToFloatCoercion(JsonParser jsonParser, DeserializationContext deserializationContext, Class<?> cls) throws IOException {
        CoercionAction coercionActionFindCoercionAction = deserializationContext.findCoercionAction(LogicalType.Float, cls, CoercionInputShape.Integer);
        if (coercionActionFindCoercionAction != CoercionAction.Fail) {
            return coercionActionFindCoercionAction;
        }
        return _checkCoercionFail(deserializationContext, coercionActionFindCoercionAction, cls, jsonParser.M0(), "Integer value (" + jsonParser.S0() + ")");
    }

    protected CoercionAction _checkIntToStringCoercion(JsonParser jsonParser, DeserializationContext deserializationContext, Class<?> cls) throws IOException {
        return _checkToStringCoercion(jsonParser, deserializationContext, cls, jsonParser.M0(), CoercionInputShape.Integer);
    }

    protected boolean _checkTextualNull(DeserializationContext deserializationContext, String str) throws JsonMappingException {
        if (!_hasTextualNull(str)) {
            return false;
        }
        MapperFeature mapperFeature = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        if (!deserializationContext.isEnabled(mapperFeature)) {
            _reportFailedNullCoerce(deserializationContext, true, mapperFeature, "String \"null\"");
        }
        return true;
    }

    protected CoercionAction _checkToStringCoercion(JsonParser jsonParser, DeserializationContext deserializationContext, Class<?> cls, Object obj, CoercionInputShape coercionInputShape) throws IOException {
        CoercionAction coercionActionFindCoercionAction = deserializationContext.findCoercionAction(LogicalType.Textual, cls, coercionInputShape);
        if (coercionActionFindCoercionAction != CoercionAction.Fail) {
            return coercionActionFindCoercionAction;
        }
        return _checkCoercionFail(deserializationContext, coercionActionFindCoercionAction, cls, obj, coercionInputShape.name() + " value (" + jsonParser.S0() + ")");
    }

    protected Boolean _coerceBooleanFromInt(JsonParser jsonParser, DeserializationContext deserializationContext, Class<?> cls) throws IOException {
        CoercionAction coercionActionFindCoercionAction = deserializationContext.findCoercionAction(LogicalType.Boolean, cls, CoercionInputShape.Integer);
        int i = a.a[coercionActionFindCoercionAction.ordinal()];
        if (i == 1) {
            return Boolean.FALSE;
        }
        if (i == 2) {
            return null;
        }
        if (i != 4) {
            if (jsonParser.L0() == JsonParser.NumberType.INT) {
                return Boolean.valueOf(jsonParser.J0() != 0);
            }
            return Boolean.valueOf(!"0".equals(jsonParser.S0()));
        }
        _checkCoercionFail(deserializationContext, coercionActionFindCoercionAction, cls, jsonParser.M0(), "Integer value (" + jsonParser.S0() + ")");
        return Boolean.FALSE;
    }

    @Deprecated
    protected Object _coerceEmptyString(DeserializationContext deserializationContext, boolean z) throws JsonMappingException {
        boolean z2;
        DeserializationFeature deserializationFeature;
        MapperFeature mapperFeature = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        if (deserializationContext.isEnabled(mapperFeature)) {
            if (z) {
                DeserializationFeature deserializationFeature2 = DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
                if (deserializationContext.isEnabled(deserializationFeature2)) {
                    z2 = false;
                    deserializationFeature = deserializationFeature2;
                }
            }
            return getNullValue(deserializationContext);
        }
        z2 = true;
        deserializationFeature = mapperFeature;
        _reportFailedNullCoerce(deserializationContext, z2, deserializationFeature, "empty String (\"\")");
        return null;
    }

    protected Object _coerceIntegral(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
            return jsonParser.e0();
        }
        return deserializationContext.isEnabled(DeserializationFeature.USE_LONG_FOR_INTS) ? Long.valueOf(jsonParser.K0()) : jsonParser.M0();
    }

    @Deprecated
    protected Object _coerceNullToken(DeserializationContext deserializationContext, boolean z) throws JsonMappingException {
        if (z) {
            _verifyNullForPrimitive(deserializationContext);
        }
        return getNullValue(deserializationContext);
    }

    @Deprecated
    protected Object _coerceTextualNull(DeserializationContext deserializationContext, boolean z) throws JsonMappingException {
        MapperFeature mapperFeature = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        if (!deserializationContext.isEnabled(mapperFeature)) {
            _reportFailedNullCoerce(deserializationContext, true, mapperFeature, "String \"null\"");
        }
        return getNullValue(deserializationContext);
    }

    protected String _coercedTypeDesc() {
        String strY;
        JavaType valueType = getValueType();
        boolean z = true;
        if (valueType == null || valueType.isPrimitive()) {
            Class<?> clsHandledType = handledType();
            if (!clsHandledType.isArray() && !Collection.class.isAssignableFrom(clsHandledType) && !Map.class.isAssignableFrom(clsHandledType)) {
                z = false;
            }
            strY = ay.y(clsHandledType);
        } else {
            if (!valueType.isContainerType() && !valueType.isReferenceType()) {
                z = false;
            }
            strY = ay.G(valueType);
        }
        if (z) {
            return "element of " + strY;
        }
        return strY + " value";
    }

    protected T _deserializeFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        CoercionAction coercionAction_findCoercionFromEmptyArray = _findCoercionFromEmptyArray(deserializationContext);
        boolean zIsEnabled = deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (zIsEnabled || coercionAction_findCoercionFromEmptyArray != CoercionAction.Fail) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            if (jsonTokenN1 == jsonToken) {
                int i = a.a[coercionAction_findCoercionFromEmptyArray.ordinal()];
                if (i == 1) {
                    return (T) getEmptyValue(deserializationContext);
                }
                if (i == 2 || i == 3) {
                    return (T) getNullValue(deserializationContext);
                }
            } else if (zIsEnabled) {
                T t_deserializeWrappedValue = _deserializeWrappedValue(jsonParser, deserializationContext);
                if (jsonParser.n1() != jsonToken) {
                    handleMissingEndArrayForSingle(jsonParser, deserializationContext);
                }
                return t_deserializeWrappedValue;
            }
        }
        return (T) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), JsonToken.START_ARRAY, jsonParser, (String) null, new Object[0]);
    }

    @Deprecated
    protected T _deserializeFromEmpty(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (!jsonParser.d1(JsonToken.START_ARRAY) || !deserializationContext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)) {
            return (T) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
        }
        if (jsonParser.n1() == JsonToken.END_ARRAY) {
            return null;
        }
        return (T) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
    }

    protected Object _deserializeFromEmptyString(JsonParser jsonParser, DeserializationContext deserializationContext, CoercionAction coercionAction, Class<?> cls, String str) throws IOException {
        int i = a.a[coercionAction.ordinal()];
        if (i == 1) {
            return getEmptyValue(deserializationContext);
        }
        if (i != 4) {
            return null;
        }
        _checkCoercionFail(deserializationContext, coercionAction, cls, Constants.STR_EMPTY, "empty String (\"\")");
        return null;
    }

    protected T _deserializeFromString(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ValueInstantiator valueInstantiator = getValueInstantiator();
        Class<?> clsHandledType = handledType();
        String strA1 = jsonParser.a1();
        if (valueInstantiator != null && valueInstantiator.canCreateFromString()) {
            return (T) valueInstantiator.createFromString(deserializationContext, strA1);
        }
        if (strA1.isEmpty()) {
            return (T) _deserializeFromEmptyString(jsonParser, deserializationContext, deserializationContext.findCoercionAction(logicalType(), clsHandledType, CoercionInputShape.EmptyString), clsHandledType, "empty String (\"\")");
        }
        if (_isBlank(strA1)) {
            return (T) _deserializeFromEmptyString(jsonParser, deserializationContext, deserializationContext.findCoercionFromBlankString(logicalType(), clsHandledType, CoercionAction.Fail), clsHandledType, "blank String (all whitespace)");
        }
        if (valueInstantiator != null) {
            strA1 = strA1.trim();
            if (valueInstantiator.canCreateFromInt() && deserializationContext.findCoercionAction(LogicalType.Integer, Integer.class, CoercionInputShape.String) == CoercionAction.TryConvert) {
                return (T) valueInstantiator.createFromInt(deserializationContext, _parseIntPrimitive(deserializationContext, strA1));
            }
            if (valueInstantiator.canCreateFromLong() && deserializationContext.findCoercionAction(LogicalType.Integer, Long.class, CoercionInputShape.String) == CoercionAction.TryConvert) {
                return (T) valueInstantiator.createFromLong(deserializationContext, _parseLongPrimitive(deserializationContext, strA1));
            }
            if (valueInstantiator.canCreateFromBoolean() && deserializationContext.findCoercionAction(LogicalType.Boolean, Boolean.class, CoercionInputShape.String) == CoercionAction.TryConvert) {
                String strTrim = strA1.trim();
                if ("true".equals(strTrim)) {
                    return (T) valueInstantiator.createFromBoolean(deserializationContext, true);
                }
                if ("false".equals(strTrim)) {
                    return (T) valueInstantiator.createFromBoolean(deserializationContext, false);
                }
            }
        }
        return (T) deserializationContext.handleMissingInstantiator(clsHandledType, valueInstantiator, deserializationContext.getParser(), "no String-argument constructor/factory method to deserialize from String value ('%s')", strA1);
    }

    protected T _deserializeWrappedValue(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return jsonParser.d1(JsonToken.START_ARRAY) ? (T) handleNestedArrayForSingle(jsonParser, deserializationContext) : (T) deserialize(jsonParser, deserializationContext);
    }

    @Deprecated
    protected void _failDoubleToIntCoercion(JsonParser jsonParser, DeserializationContext deserializationContext, String str) throws IOException {
        deserializationContext.reportInputMismatch(handledType(), "Cannot coerce a floating-point value ('%s') into %s (enable `DeserializationFeature.ACCEPT_FLOAT_AS_INT` to allow)", jsonParser.a1(), str);
    }

    protected CoercionAction _findCoercionFromBlankString(DeserializationContext deserializationContext) {
        return deserializationContext.findCoercionFromBlankString(logicalType(), handledType(), CoercionAction.Fail);
    }

    protected CoercionAction _findCoercionFromEmptyArray(DeserializationContext deserializationContext) {
        return deserializationContext.findCoercionAction(logicalType(), handledType(), CoercionInputShape.EmptyArray);
    }

    protected CoercionAction _findCoercionFromEmptyString(DeserializationContext deserializationContext) {
        return deserializationContext.findCoercionAction(logicalType(), handledType(), CoercionInputShape.EmptyString);
    }

    protected final gs1 _findNullProvider(DeserializationContext deserializationContext, BeanProperty beanProperty, Nulls nulls, s51 s51Var) throws JsonMappingException {
        if (nulls == Nulls.FAIL) {
            if (beanProperty == null) {
                return NullsFailProvider.constructForRootValue(deserializationContext.constructType((Class<?>) (s51Var == null ? Object.class : s51Var.handledType())));
            }
            return NullsFailProvider.constructForProperty(beanProperty);
        }
        if (nulls != Nulls.AS_EMPTY) {
            if (nulls == Nulls.SKIP) {
                return NullsConstantProvider.skipper();
            }
            return null;
        }
        if (s51Var == null) {
            return null;
        }
        if (s51Var instanceof BeanDeserializerBase) {
            BeanDeserializerBase beanDeserializerBase = (BeanDeserializerBase) s51Var;
            if (!beanDeserializerBase.getValueInstantiator().canCreateUsingDefault()) {
                JavaType valueType = beanProperty == null ? beanDeserializerBase.getValueType() : beanProperty.getType();
                return (gs1) deserializationContext.reportBadDefinition(valueType, String.format("Cannot create empty instance of %s, no default Creator", valueType));
            }
        }
        AccessPattern emptyAccessPattern = s51Var.getEmptyAccessPattern();
        if (emptyAccessPattern == AccessPattern.ALWAYS_NULL) {
            return NullsConstantProvider.nuller();
        }
        return emptyAccessPattern == AccessPattern.CONSTANT ? NullsConstantProvider.forValue(s51Var.getEmptyValue(deserializationContext)) : new NullsAsEmptyProvider(s51Var);
    }

    protected boolean _hasTextualNull(String str) {
        return "null".equals(str);
    }

    protected final boolean _intOverflow(long j) {
        return j < -2147483648L || j > 2147483647L;
    }

    @Deprecated
    protected boolean _isEmptyOrTextualNull(String str) {
        return str.isEmpty() || "null".equals(str);
    }

    protected boolean _isFalse(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == 'f') {
            return "false".equals(str);
        }
        if (cCharAt == 'F') {
            return "FALSE".equals(str) || "False".equals(str);
        }
        return false;
    }

    protected final boolean _isIntNumber(String str) {
        int i;
        int length = str.length();
        if (length <= 0) {
            return false;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt != '-' && cCharAt != '+') {
            i = 0;
        } else {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        while (i < length) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                return false;
            }
            i++;
        }
        return true;
    }

    protected final boolean _isNaN(String str) {
        return "NaN".equals(str);
    }

    protected final boolean _isNegInf(String str) {
        return "-Infinity".equals(str) || "-INF".equals(str);
    }

    protected final boolean _isPosInf(String str) {
        return "Infinity".equals(str) || "INF".equals(str);
    }

    protected boolean _isTrue(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == 't') {
            return "true".equals(str);
        }
        if (cCharAt == 'T') {
            return "TRUE".equals(str) || "True".equals(str);
        }
        return false;
    }

    protected Number _nonNullNumber(Number number) {
        if (number == null) {
            return 0;
        }
        return number;
    }

    protected final Boolean _parseBoolean(JsonParser jsonParser, DeserializationContext deserializationContext, Class<?> cls) throws IOException {
        String strExtractScalarFromObject;
        int iV = jsonParser.V();
        if (iV == 1) {
            strExtractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, cls);
        } else {
            if (iV == 3) {
                return (Boolean) _deserializeFromArray(jsonParser, deserializationContext);
            }
            if (iV != 6) {
                if (iV == 7) {
                    return _coerceBooleanFromInt(jsonParser, deserializationContext, cls);
                }
                switch (iV) {
                    case 9:
                        return Boolean.TRUE;
                    case 10:
                        return Boolean.FALSE;
                    case 11:
                        return null;
                    default:
                        return (Boolean) deserializationContext.handleUnexpectedToken(cls, jsonParser);
                }
            }
            strExtractScalarFromObject = jsonParser.S0();
        }
        CoercionAction coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, strExtractScalarFromObject, LogicalType.Boolean, cls);
        if (coercionAction_checkFromStringCoercion == CoercionAction.AsNull) {
            return null;
        }
        if (coercionAction_checkFromStringCoercion == CoercionAction.AsEmpty) {
            return Boolean.FALSE;
        }
        String strTrim = strExtractScalarFromObject.trim();
        int length = strTrim.length();
        if (length == 4) {
            if (_isTrue(strTrim)) {
                return Boolean.TRUE;
            }
        } else if (length == 5 && _isFalse(strTrim)) {
            return Boolean.FALSE;
        }
        if (_checkTextualNull(deserializationContext, strTrim)) {
            return null;
        }
        return (Boolean) deserializationContext.handleWeirdStringValue(cls, strTrim, "only \"true\" or \"false\" recognized", new Object[0]);
    }

    @Deprecated
    protected boolean _parseBooleanFromInt(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        _verifyNumberForScalarCoercion(deserializationContext, jsonParser);
        return !"0".equals(jsonParser.S0());
    }

    @Deprecated
    protected final boolean _parseBooleanPrimitive(DeserializationContext deserializationContext, JsonParser jsonParser, Class<?> cls) throws IOException {
        return _parseBooleanPrimitive(jsonParser, deserializationContext);
    }

    protected final byte _parseBytePrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String strExtractScalarFromObject;
        int iV = jsonParser.V();
        if (iV != 1) {
            if (iV != 3) {
                if (iV == 11) {
                    _verifyNullForPrimitive(deserializationContext);
                    return (byte) 0;
                }
                if (iV == 6) {
                    strExtractScalarFromObject = jsonParser.S0();
                } else {
                    if (iV == 7) {
                        return jsonParser.m0();
                    }
                    if (iV == 8) {
                        CoercionAction coercionAction_checkFloatToIntCoercion = _checkFloatToIntCoercion(jsonParser, deserializationContext, Byte.TYPE);
                        if (coercionAction_checkFloatToIntCoercion == CoercionAction.AsNull || coercionAction_checkFloatToIntCoercion == CoercionAction.AsEmpty) {
                            return (byte) 0;
                        }
                        return jsonParser.m0();
                    }
                }
            } else if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (jsonParser.n1() == JsonToken.START_ARRAY) {
                    return ((Byte) handleNestedArrayForSingle(jsonParser, deserializationContext)).byteValue();
                }
                byte b_parseBytePrimitive = _parseBytePrimitive(jsonParser, deserializationContext);
                _verifyEndArrayForSingle(jsonParser, deserializationContext);
                return b_parseBytePrimitive;
            }
            return ((Byte) deserializationContext.handleUnexpectedToken(deserializationContext.constructType(Byte.TYPE), jsonParser)).byteValue();
        }
        strExtractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, Byte.TYPE);
        CoercionAction coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, strExtractScalarFromObject, LogicalType.Integer, Byte.TYPE);
        if (coercionAction_checkFromStringCoercion == CoercionAction.AsNull) {
            _verifyNullForPrimitive(deserializationContext);
            return (byte) 0;
        }
        if (coercionAction_checkFromStringCoercion == CoercionAction.AsEmpty) {
            return (byte) 0;
        }
        String strTrim = strExtractScalarFromObject.trim();
        if (_hasTextualNull(strTrim)) {
            _verifyNullForPrimitiveCoercion(deserializationContext, strTrim);
            return (byte) 0;
        }
        try {
            int iM = hs1.m(strTrim);
            return _byteOverflow(iM) ? ((Byte) deserializationContext.handleWeirdStringValue(this._valueClass, strTrim, "overflow, value cannot be represented as 8-bit value", new Object[0])).byteValue() : (byte) iM;
        } catch (IllegalArgumentException unused) {
            return ((Byte) deserializationContext.handleWeirdStringValue(this._valueClass, strTrim, "not a valid `byte` value", new Object[0])).byteValue();
        }
    }

    protected Date _parseDate(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String strExtractScalarFromObject;
        long jLongValue;
        int iV = jsonParser.V();
        if (iV == 1) {
            strExtractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
        } else {
            if (iV == 3) {
                return _parseDateFromArray(jsonParser, deserializationContext);
            }
            if (iV == 11) {
                return (Date) getNullValue(deserializationContext);
            }
            if (iV != 6) {
                if (iV != 7) {
                    return (Date) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser);
                }
                try {
                    jLongValue = jsonParser.K0();
                } catch (StreamReadException unused) {
                    jLongValue = ((Number) deserializationContext.handleWeirdNumberValue(this._valueClass, jsonParser.M0(), "not a valid 64-bit `long` for creating `java.util.Date`", new Object[0])).longValue();
                }
                return new Date(jLongValue);
            }
            strExtractScalarFromObject = jsonParser.S0();
        }
        return _parseDate(strExtractScalarFromObject.trim(), deserializationContext);
    }

    protected Date _parseDateFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        CoercionAction coercionAction_findCoercionFromEmptyArray = _findCoercionFromEmptyArray(deserializationContext);
        boolean zIsEnabled = deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (zIsEnabled || coercionAction_findCoercionFromEmptyArray != CoercionAction.Fail) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            if (jsonTokenN1 == JsonToken.END_ARRAY) {
                int i = a.a[coercionAction_findCoercionFromEmptyArray.ordinal()];
                if (i == 1) {
                    return (Date) getEmptyValue(deserializationContext);
                }
                if (i == 2 || i == 3) {
                    return (Date) getNullValue(deserializationContext);
                }
            } else if (zIsEnabled) {
                if (jsonTokenN1 == JsonToken.START_ARRAY) {
                    return (Date) handleNestedArrayForSingle(jsonParser, deserializationContext);
                }
                Date date_parseDate = _parseDate(jsonParser, deserializationContext);
                _verifyEndArrayForSingle(jsonParser, deserializationContext);
                return date_parseDate;
            }
        }
        return (Date) deserializationContext.handleUnexpectedToken(this._valueClass, JsonToken.START_ARRAY, jsonParser, (String) null, new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
    
        if (r0 != 8) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final double _parseDoublePrimitive(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r6.V()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L69
            r1 = 3
            if (r0 == r1) goto L39
            r1 = 11
            if (r0 == r1) goto L35
            r1 = 6
            if (r0 == r1) goto L30
            r1 = 7
            if (r0 == r1) goto L1b
            r1 = 8
            if (r0 == r1) goto L2b
            goto L5c
        L1b:
            java.lang.Class r0 = java.lang.Double.TYPE
            com.fasterxml.jackson.databind.cfg.CoercionAction r7 = r5._checkIntToFloatCoercion(r6, r7, r0)
            com.fasterxml.jackson.databind.cfg.CoercionAction r0 = com.fasterxml.jackson.databind.cfg.CoercionAction.AsNull
            if (r7 != r0) goto L26
            return r2
        L26:
            com.fasterxml.jackson.databind.cfg.CoercionAction r0 = com.fasterxml.jackson.databind.cfg.CoercionAction.AsEmpty
            if (r7 != r0) goto L2b
            return r2
        L2b:
            double r6 = r6.G0()
            return r6
        L30:
            java.lang.String r0 = r6.S0()
            goto L6f
        L35:
            r5._verifyNullForPrimitive(r7)
            return r2
        L39:
            com.fasterxml.jackson.databind.DeserializationFeature r0 = com.fasterxml.jackson.databind.DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS
            boolean r0 = r7.isEnabled(r0)
            if (r0 == 0) goto L5c
            com.fasterxml.jackson.core.JsonToken r0 = r6.n1()
            com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.START_ARRAY
            if (r0 != r1) goto L54
            java.lang.Object r6 = r5.handleNestedArrayForSingle(r6, r7)
            java.lang.Double r6 = (java.lang.Double) r6
            double r6 = r6.doubleValue()
            return r6
        L54:
            double r0 = r5._parseDoublePrimitive(r6, r7)
            r5._verifyEndArrayForSingle(r6, r7)
            return r0
        L5c:
            java.lang.Class r0 = java.lang.Double.TYPE
            java.lang.Object r6 = r7.handleUnexpectedToken(r0, r6)
            java.lang.Number r6 = (java.lang.Number) r6
            double r6 = r6.doubleValue()
            return r6
        L69:
            java.lang.Class r0 = java.lang.Double.TYPE
            java.lang.String r0 = r7.extractScalarFromObject(r6, r5, r0)
        L6f:
            java.lang.Double r1 = r5._checkDoubleSpecialValue(r0)
            if (r1 == 0) goto L7a
            double r6 = r1.doubleValue()
            return r6
        L7a:
            com.fasterxml.jackson.databind.type.LogicalType r1 = com.fasterxml.jackson.databind.type.LogicalType.Integer
            java.lang.Class r4 = java.lang.Double.TYPE
            com.fasterxml.jackson.databind.cfg.CoercionAction r1 = r5._checkFromStringCoercion(r7, r0, r1, r4)
            com.fasterxml.jackson.databind.cfg.CoercionAction r4 = com.fasterxml.jackson.databind.cfg.CoercionAction.AsNull
            if (r1 != r4) goto L8a
            r5._verifyNullForPrimitive(r7)
            return r2
        L8a:
            com.fasterxml.jackson.databind.cfg.CoercionAction r4 = com.fasterxml.jackson.databind.cfg.CoercionAction.AsEmpty
            if (r1 != r4) goto L8f
            return r2
        L8f:
            java.lang.String r0 = r0.trim()
            boolean r1 = r5._hasTextualNull(r0)
            if (r1 == 0) goto L9d
            r5._verifyNullForPrimitiveCoercion(r7, r0)
            return r2
        L9d:
            double r6 = r5._parseDoublePrimitive(r6, r7, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdDeserializer._parseDoublePrimitive(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):double");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0017, code lost:
    
        if (r0 != 8) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final float _parseFloatPrimitive(com.fasterxml.jackson.core.JsonParser r5, com.fasterxml.jackson.databind.DeserializationContext r6) throws java.io.IOException {
        /*
            r4 = this;
            int r0 = r5.V()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L68
            r1 = 3
            if (r0 == r1) goto L38
            r1 = 11
            if (r0 == r1) goto L34
            r1 = 6
            if (r0 == r1) goto L2f
            r1 = 7
            if (r0 == r1) goto L1a
            r1 = 8
            if (r0 == r1) goto L2a
            goto L5b
        L1a:
            java.lang.Class r0 = java.lang.Float.TYPE
            com.fasterxml.jackson.databind.cfg.CoercionAction r6 = r4._checkIntToFloatCoercion(r5, r6, r0)
            com.fasterxml.jackson.databind.cfg.CoercionAction r0 = com.fasterxml.jackson.databind.cfg.CoercionAction.AsNull
            if (r6 != r0) goto L25
            return r2
        L25:
            com.fasterxml.jackson.databind.cfg.CoercionAction r0 = com.fasterxml.jackson.databind.cfg.CoercionAction.AsEmpty
            if (r6 != r0) goto L2a
            return r2
        L2a:
            float r5 = r5.I0()
            return r5
        L2f:
            java.lang.String r0 = r5.S0()
            goto L6e
        L34:
            r4._verifyNullForPrimitive(r6)
            return r2
        L38:
            com.fasterxml.jackson.databind.DeserializationFeature r0 = com.fasterxml.jackson.databind.DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS
            boolean r0 = r6.isEnabled(r0)
            if (r0 == 0) goto L5b
            com.fasterxml.jackson.core.JsonToken r0 = r5.n1()
            com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.START_ARRAY
            if (r0 != r1) goto L53
            java.lang.Object r5 = r4.handleNestedArrayForSingle(r5, r6)
            java.lang.Float r5 = (java.lang.Float) r5
            float r5 = r5.floatValue()
            return r5
        L53:
            float r0 = r4._parseFloatPrimitive(r5, r6)
            r4._verifyEndArrayForSingle(r5, r6)
            return r0
        L5b:
            java.lang.Class r0 = java.lang.Float.TYPE
            java.lang.Object r5 = r6.handleUnexpectedToken(r0, r5)
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            return r5
        L68:
            java.lang.Class r0 = java.lang.Float.TYPE
            java.lang.String r0 = r6.extractScalarFromObject(r5, r4, r0)
        L6e:
            java.lang.Float r1 = r4._checkFloatSpecialValue(r0)
            if (r1 == 0) goto L79
            float r5 = r1.floatValue()
            return r5
        L79:
            com.fasterxml.jackson.databind.type.LogicalType r1 = com.fasterxml.jackson.databind.type.LogicalType.Integer
            java.lang.Class r3 = java.lang.Float.TYPE
            com.fasterxml.jackson.databind.cfg.CoercionAction r1 = r4._checkFromStringCoercion(r6, r0, r1, r3)
            com.fasterxml.jackson.databind.cfg.CoercionAction r3 = com.fasterxml.jackson.databind.cfg.CoercionAction.AsNull
            if (r1 != r3) goto L89
            r4._verifyNullForPrimitive(r6)
            return r2
        L89:
            com.fasterxml.jackson.databind.cfg.CoercionAction r3 = com.fasterxml.jackson.databind.cfg.CoercionAction.AsEmpty
            if (r1 != r3) goto L8e
            return r2
        L8e:
            java.lang.String r0 = r0.trim()
            boolean r1 = r4._hasTextualNull(r0)
            if (r1 == 0) goto L9c
            r4._verifyNullForPrimitiveCoercion(r6, r0)
            return r2
        L9c:
            float r5 = r4._parseFloatPrimitive(r5, r6, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StdDeserializer._parseFloatPrimitive(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):float");
    }

    protected final int _parseIntPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String strExtractScalarFromObject;
        int iV = jsonParser.V();
        if (iV != 1) {
            if (iV != 3) {
                if (iV == 11) {
                    _verifyNullForPrimitive(deserializationContext);
                    return 0;
                }
                if (iV == 6) {
                    strExtractScalarFromObject = jsonParser.S0();
                } else {
                    if (iV == 7) {
                        return jsonParser.J0();
                    }
                    if (iV == 8) {
                        CoercionAction coercionAction_checkFloatToIntCoercion = _checkFloatToIntCoercion(jsonParser, deserializationContext, Integer.TYPE);
                        if (coercionAction_checkFloatToIntCoercion == CoercionAction.AsNull || coercionAction_checkFloatToIntCoercion == CoercionAction.AsEmpty) {
                            return 0;
                        }
                        return jsonParser.Y0();
                    }
                }
            } else if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (jsonParser.n1() == JsonToken.START_ARRAY) {
                    return ((Integer) handleNestedArrayForSingle(jsonParser, deserializationContext)).intValue();
                }
                int i_parseIntPrimitive = _parseIntPrimitive(jsonParser, deserializationContext);
                _verifyEndArrayForSingle(jsonParser, deserializationContext);
                return i_parseIntPrimitive;
            }
            return ((Number) deserializationContext.handleUnexpectedToken(Integer.TYPE, jsonParser)).intValue();
        }
        strExtractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, Integer.TYPE);
        CoercionAction coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, strExtractScalarFromObject, LogicalType.Integer, Integer.TYPE);
        if (coercionAction_checkFromStringCoercion == CoercionAction.AsNull) {
            _verifyNullForPrimitive(deserializationContext);
            return 0;
        }
        if (coercionAction_checkFromStringCoercion == CoercionAction.AsEmpty) {
            return 0;
        }
        String strTrim = strExtractScalarFromObject.trim();
        if (!_hasTextualNull(strTrim)) {
            return _parseIntPrimitive(deserializationContext, strTrim);
        }
        _verifyNullForPrimitiveCoercion(deserializationContext, strTrim);
        return 0;
    }

    protected final Integer _parseInteger(JsonParser jsonParser, DeserializationContext deserializationContext, Class<?> cls) throws IOException {
        String strExtractScalarFromObject;
        int iV = jsonParser.V();
        if (iV == 1) {
            strExtractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, cls);
        } else {
            if (iV == 3) {
                return (Integer) _deserializeFromArray(jsonParser, deserializationContext);
            }
            if (iV == 11) {
                return (Integer) getNullValue(deserializationContext);
            }
            if (iV != 6) {
                if (iV == 7) {
                    return Integer.valueOf(jsonParser.J0());
                }
                if (iV != 8) {
                    return (Integer) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                }
                CoercionAction coercionAction_checkFloatToIntCoercion = _checkFloatToIntCoercion(jsonParser, deserializationContext, cls);
                if (coercionAction_checkFloatToIntCoercion == CoercionAction.AsNull) {
                    return (Integer) getNullValue(deserializationContext);
                }
                return coercionAction_checkFloatToIntCoercion == CoercionAction.AsEmpty ? (Integer) getEmptyValue(deserializationContext) : Integer.valueOf(jsonParser.Y0());
            }
            strExtractScalarFromObject = jsonParser.S0();
        }
        CoercionAction coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, strExtractScalarFromObject);
        if (coercionAction_checkFromStringCoercion == CoercionAction.AsNull) {
            return (Integer) getNullValue(deserializationContext);
        }
        if (coercionAction_checkFromStringCoercion == CoercionAction.AsEmpty) {
            return (Integer) getEmptyValue(deserializationContext);
        }
        String strTrim = strExtractScalarFromObject.trim();
        return _checkTextualNull(deserializationContext, strTrim) ? (Integer) getNullValue(deserializationContext) : _parseInteger(deserializationContext, strTrim);
    }

    protected final Long _parseLong(JsonParser jsonParser, DeserializationContext deserializationContext, Class<?> cls) throws IOException {
        String strExtractScalarFromObject;
        int iV = jsonParser.V();
        if (iV == 1) {
            strExtractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, cls);
        } else {
            if (iV == 3) {
                return (Long) _deserializeFromArray(jsonParser, deserializationContext);
            }
            if (iV == 11) {
                return (Long) getNullValue(deserializationContext);
            }
            if (iV != 6) {
                if (iV == 7) {
                    return Long.valueOf(jsonParser.K0());
                }
                if (iV != 8) {
                    return (Long) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                }
                CoercionAction coercionAction_checkFloatToIntCoercion = _checkFloatToIntCoercion(jsonParser, deserializationContext, cls);
                if (coercionAction_checkFloatToIntCoercion == CoercionAction.AsNull) {
                    return (Long) getNullValue(deserializationContext);
                }
                return coercionAction_checkFloatToIntCoercion == CoercionAction.AsEmpty ? (Long) getEmptyValue(deserializationContext) : Long.valueOf(jsonParser.Z0());
            }
            strExtractScalarFromObject = jsonParser.S0();
        }
        CoercionAction coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, strExtractScalarFromObject);
        if (coercionAction_checkFromStringCoercion == CoercionAction.AsNull) {
            return (Long) getNullValue(deserializationContext);
        }
        if (coercionAction_checkFromStringCoercion == CoercionAction.AsEmpty) {
            return (Long) getEmptyValue(deserializationContext);
        }
        String strTrim = strExtractScalarFromObject.trim();
        return _checkTextualNull(deserializationContext, strTrim) ? (Long) getNullValue(deserializationContext) : _parseLong(deserializationContext, strTrim);
    }

    protected final long _parseLongPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String strExtractScalarFromObject;
        int iV = jsonParser.V();
        if (iV != 1) {
            if (iV != 3) {
                if (iV == 11) {
                    _verifyNullForPrimitive(deserializationContext);
                    return 0L;
                }
                if (iV == 6) {
                    strExtractScalarFromObject = jsonParser.S0();
                } else {
                    if (iV == 7) {
                        return jsonParser.K0();
                    }
                    if (iV == 8) {
                        CoercionAction coercionAction_checkFloatToIntCoercion = _checkFloatToIntCoercion(jsonParser, deserializationContext, Long.TYPE);
                        if (coercionAction_checkFloatToIntCoercion == CoercionAction.AsNull || coercionAction_checkFloatToIntCoercion == CoercionAction.AsEmpty) {
                            return 0L;
                        }
                        return jsonParser.Z0();
                    }
                }
            } else if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (jsonParser.n1() == JsonToken.START_ARRAY) {
                    return ((Long) handleNestedArrayForSingle(jsonParser, deserializationContext)).longValue();
                }
                long j_parseLongPrimitive = _parseLongPrimitive(jsonParser, deserializationContext);
                _verifyEndArrayForSingle(jsonParser, deserializationContext);
                return j_parseLongPrimitive;
            }
            return ((Number) deserializationContext.handleUnexpectedToken(Long.TYPE, jsonParser)).longValue();
        }
        strExtractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, Long.TYPE);
        CoercionAction coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, strExtractScalarFromObject, LogicalType.Integer, Long.TYPE);
        if (coercionAction_checkFromStringCoercion == CoercionAction.AsNull) {
            _verifyNullForPrimitive(deserializationContext);
            return 0L;
        }
        if (coercionAction_checkFromStringCoercion == CoercionAction.AsEmpty) {
            return 0L;
        }
        String strTrim = strExtractScalarFromObject.trim();
        if (!_hasTextualNull(strTrim)) {
            return _parseLongPrimitive(deserializationContext, strTrim);
        }
        _verifyNullForPrimitiveCoercion(deserializationContext, strTrim);
        return 0L;
    }

    protected final short _parseShortPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String strExtractScalarFromObject;
        int iV = jsonParser.V();
        if (iV != 1) {
            if (iV != 3) {
                if (iV == 11) {
                    _verifyNullForPrimitive(deserializationContext);
                    return (short) 0;
                }
                if (iV == 6) {
                    strExtractScalarFromObject = jsonParser.S0();
                } else {
                    if (iV == 7) {
                        return jsonParser.R0();
                    }
                    if (iV == 8) {
                        CoercionAction coercionAction_checkFloatToIntCoercion = _checkFloatToIntCoercion(jsonParser, deserializationContext, Short.TYPE);
                        if (coercionAction_checkFloatToIntCoercion == CoercionAction.AsNull || coercionAction_checkFloatToIntCoercion == CoercionAction.AsEmpty) {
                            return (short) 0;
                        }
                        return jsonParser.R0();
                    }
                }
            } else if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (jsonParser.n1() == JsonToken.START_ARRAY) {
                    return ((Short) handleNestedArrayForSingle(jsonParser, deserializationContext)).shortValue();
                }
                short s_parseShortPrimitive = _parseShortPrimitive(jsonParser, deserializationContext);
                _verifyEndArrayForSingle(jsonParser, deserializationContext);
                return s_parseShortPrimitive;
            }
            return ((Short) deserializationContext.handleUnexpectedToken(deserializationContext.constructType(Short.TYPE), jsonParser)).shortValue();
        }
        strExtractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, Short.TYPE);
        LogicalType logicalType = LogicalType.Integer;
        Class<?> cls = Short.TYPE;
        CoercionAction coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, strExtractScalarFromObject, logicalType, cls);
        if (coercionAction_checkFromStringCoercion == CoercionAction.AsNull) {
            _verifyNullForPrimitive(deserializationContext);
            return (short) 0;
        }
        if (coercionAction_checkFromStringCoercion == CoercionAction.AsEmpty) {
            return (short) 0;
        }
        String strTrim = strExtractScalarFromObject.trim();
        if (_hasTextualNull(strTrim)) {
            _verifyNullForPrimitiveCoercion(deserializationContext, strTrim);
            return (short) 0;
        }
        try {
            int iM = hs1.m(strTrim);
            return _shortOverflow(iM) ? ((Short) deserializationContext.handleWeirdStringValue(cls, strTrim, "overflow, value cannot be represented as 16-bit value", new Object[0])).shortValue() : (short) iM;
        } catch (IllegalArgumentException unused) {
            return ((Short) deserializationContext.handleWeirdStringValue(Short.TYPE, strTrim, "not a valid `short` value", new Object[0])).shortValue();
        }
    }

    @Deprecated
    protected final String _parseString(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _parseString(jsonParser, deserializationContext, NullsConstantProvider.nuller());
    }

    protected void _reportFailedNullCoerce(DeserializationContext deserializationContext, boolean z, Enum<?> r5, String str) throws JsonMappingException {
        deserializationContext.reportInputMismatch(this, "Cannot coerce %s to Null value as %s (%s `%s.%s` to allow)", str, _coercedTypeDesc(), z ? "enable" : "disable", r5.getDeclaringClass().getSimpleName(), r5.name());
    }

    protected final boolean _shortOverflow(int i) {
        return i < -32768 || i > 32767;
    }

    protected void _verifyEndArrayForSingle(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.n1() != JsonToken.END_ARRAY) {
            handleMissingEndArrayForSingle(jsonParser, deserializationContext);
        }
    }

    protected final void _verifyNullForPrimitive(DeserializationContext deserializationContext) throws JsonMappingException {
        if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
            deserializationContext.reportInputMismatch(this, "Cannot coerce `null` to %s (disable `DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES` to allow)", _coercedTypeDesc());
        }
    }

    protected final void _verifyNullForPrimitiveCoercion(DeserializationContext deserializationContext, String str) throws JsonMappingException {
        boolean z;
        DeserializationFeature deserializationFeature;
        MapperFeature mapperFeature = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        if (deserializationContext.isEnabled(mapperFeature)) {
            DeserializationFeature deserializationFeature2 = DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
            if (!deserializationContext.isEnabled(deserializationFeature2)) {
                return;
            }
            z = false;
            deserializationFeature = deserializationFeature2;
        } else {
            z = true;
            deserializationFeature = mapperFeature;
        }
        _reportFailedNullCoerce(deserializationContext, z, deserializationFeature, str.isEmpty() ? "empty String (\"\")" : String.format("String \"%s\"", str));
    }

    @Deprecated
    protected final void _verifyNullForScalarCoercion(DeserializationContext deserializationContext, String str) throws JsonMappingException {
        MapperFeature mapperFeature = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        if (deserializationContext.isEnabled(mapperFeature)) {
            return;
        }
        _reportFailedNullCoerce(deserializationContext, true, mapperFeature, str.isEmpty() ? "empty String (\"\")" : String.format("String \"%s\"", str));
    }

    @Deprecated
    protected void _verifyNumberForScalarCoercion(DeserializationContext deserializationContext, JsonParser jsonParser) throws IOException {
        MapperFeature mapperFeature = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        if (deserializationContext.isEnabled(mapperFeature)) {
            return;
        }
        deserializationContext.reportInputMismatch(this, "Cannot coerce Number (%s) to %s (enable `%s.%s` to allow)", jsonParser.S0(), _coercedTypeDesc(), mapperFeature.getDeclaringClass().getSimpleName(), mapperFeature.name());
    }

    @Deprecated
    protected void _verifyStringForScalarCoercion(DeserializationContext deserializationContext, String str) throws JsonMappingException {
        MapperFeature mapperFeature = MapperFeature.ALLOW_COERCION_OF_SCALARS;
        if (deserializationContext.isEnabled(mapperFeature)) {
            return;
        }
        deserializationContext.reportInputMismatch(this, "Cannot coerce String \"%s\" to %s (enable `%s.%s` to allow)", str, _coercedTypeDesc(), mapperFeature.getDeclaringClass().getSimpleName(), mapperFeature.name());
    }

    @Override // defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return m63Var.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    protected gs1 findContentNullProvider(DeserializationContext deserializationContext, BeanProperty beanProperty, s51 s51Var) throws JsonMappingException {
        Nulls nullsFindContentNullStyle = findContentNullStyle(deserializationContext, beanProperty);
        if (nullsFindContentNullStyle == Nulls.SKIP) {
            return NullsConstantProvider.skipper();
        }
        if (nullsFindContentNullStyle != Nulls.FAIL) {
            gs1 gs1Var_findNullProvider = _findNullProvider(deserializationContext, beanProperty, nullsFindContentNullStyle, s51Var);
            return gs1Var_findNullProvider != null ? gs1Var_findNullProvider : s51Var;
        }
        if (beanProperty != null) {
            return NullsFailProvider.constructForProperty(beanProperty, beanProperty.getType().mo15getContentType());
        }
        JavaType javaTypeConstructType = deserializationContext.constructType((Class<?>) s51Var.handledType());
        if (javaTypeConstructType.isContainerType()) {
            javaTypeConstructType = javaTypeConstructType.mo15getContentType();
        }
        return NullsFailProvider.constructForRootValue(javaTypeConstructType);
    }

    protected Nulls findContentNullStyle(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        return beanProperty != null ? beanProperty.getMetadata().getContentNulls() : deserializationContext.getConfig().getDefaultSetterInfo().getContentNulls();
    }

    protected s51 findConvertingContentDeserializer(DeserializationContext deserializationContext, BeanProperty beanProperty, s51 s51Var) throws JsonMappingException {
        AnnotatedMember member;
        Object objFindDeserializationContentConverter;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (!_neitherNull(annotationIntrospector, beanProperty) || (member = beanProperty.getMember()) == null || (objFindDeserializationContentConverter = annotationIntrospector.findDeserializationContentConverter(member)) == null) {
            return s51Var;
        }
        f40 f40VarConverterInstance = deserializationContext.converterInstance(beanProperty.getMember(), objFindDeserializationContentConverter);
        JavaType javaTypeA = f40VarConverterInstance.a(deserializationContext.getTypeFactory());
        if (s51Var == null) {
            s51Var = deserializationContext.findContextualValueDeserializer(javaTypeA, beanProperty);
        }
        return new StdDelegatingDeserializer(f40VarConverterInstance, javaTypeA, s51Var);
    }

    protected s51 findDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        return deserializationContext.findContextualValueDeserializer(javaType, beanProperty);
    }

    protected Boolean findFormatFeature(DeserializationContext deserializationContext, BeanProperty beanProperty, Class<?> cls, JsonFormat.Feature feature) {
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(deserializationContext, beanProperty, cls);
        if (valueFindFormatOverrides != null) {
            return valueFindFormatOverrides.getFeature(feature);
        }
        return null;
    }

    protected JsonFormat.Value findFormatOverrides(DeserializationContext deserializationContext, BeanProperty beanProperty, Class<?> cls) {
        return beanProperty != null ? beanProperty.findPropertyFormat(deserializationContext.getConfig(), cls) : deserializationContext.getDefaultPropertyFormat(cls);
    }

    protected final gs1 findValueNullProvider(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty, PropertyMetadata propertyMetadata) throws JsonMappingException {
        if (settableBeanProperty != null) {
            return _findNullProvider(deserializationContext, settableBeanProperty, propertyMetadata.getValueNulls(), settableBeanProperty.getValueDeserializer());
        }
        return null;
    }

    @Deprecated
    public final Class<?> getValueClass() {
        return this._valueClass;
    }

    public ValueInstantiator getValueInstantiator() {
        return null;
    }

    public JavaType getValueType() {
        return this._valueType;
    }

    protected void handleMissingEndArrayForSingle(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        deserializationContext.reportWrongTokenException(this, JsonToken.END_ARRAY, "Attempted to unwrap '%s' value from an array (with `DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS`) but it contains more than one value", handledType().getName());
    }

    protected Object handleNestedArrayForSingle(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser.D(), jsonParser, String.format("Cannot deserialize instance of %s out of %s token: nested Arrays not allowed with %s", ay.X(this._valueClass), JsonToken.START_ARRAY, "DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS"), new Object[0]);
    }

    protected void handleUnknownProperty(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException {
        if (obj == null) {
            obj = handledType();
        }
        if (deserializationContext.handleUnknownProperty(jsonParser, this, obj, str)) {
            return;
        }
        jsonParser.v1();
    }

    @Override // defpackage.s51
    public Class<?> handledType() {
        return this._valueClass;
    }

    protected boolean isDefaultDeserializer(s51 s51Var) {
        return ay.O(s51Var);
    }

    protected boolean isDefaultKeyDeserializer(a91 a91Var) {
        return ay.O(a91Var);
    }

    protected static final double _parseDouble(String str, boolean z) throws NumberFormatException {
        return hs1.j(str, z);
    }

    protected CoercionAction _checkFromStringCoercion(DeserializationContext deserializationContext, String str, LogicalType logicalType, Class<?> cls) throws IOException {
        if (str.isEmpty()) {
            return _checkCoercionFail(deserializationContext, deserializationContext.findCoercionAction(logicalType, cls, CoercionInputShape.EmptyString), cls, str, "empty String (\"\")");
        }
        if (_isBlank(str)) {
            return _checkCoercionFail(deserializationContext, deserializationContext.findCoercionFromBlankString(logicalType, cls, CoercionAction.Fail), cls, str, "blank String (all whitespace)");
        }
        if (deserializationContext.isEnabled(StreamReadCapability.UNTYPED_SCALARS)) {
            return CoercionAction.TryConvert;
        }
        CoercionAction coercionActionFindCoercionAction = deserializationContext.findCoercionAction(logicalType, cls, CoercionInputShape.String);
        if (coercionActionFindCoercionAction == CoercionAction.Fail) {
            deserializationContext.reportInputMismatch(this, "Cannot coerce String value (\"%s\") to %s (but might if coercion using `CoercionConfig` was enabled)", str, _coercedTypeDesc());
        }
        return coercionActionFindCoercionAction;
    }

    protected final boolean _parseBooleanPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String strExtractScalarFromObject;
        int iV = jsonParser.V();
        if (iV != 1) {
            if (iV != 3) {
                if (iV == 6) {
                    strExtractScalarFromObject = jsonParser.S0();
                } else {
                    if (iV == 7) {
                        return Boolean.TRUE.equals(_coerceBooleanFromInt(jsonParser, deserializationContext, Boolean.TYPE));
                    }
                    switch (iV) {
                        case 9:
                            return true;
                        case 11:
                            _verifyNullForPrimitive(deserializationContext);
                        case 10:
                            return false;
                    }
                }
            } else if (deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
                if (jsonParser.n1() == JsonToken.START_ARRAY) {
                    return ((Boolean) handleNestedArrayForSingle(jsonParser, deserializationContext)).booleanValue();
                }
                boolean z_parseBooleanPrimitive = _parseBooleanPrimitive(jsonParser, deserializationContext);
                _verifyEndArrayForSingle(jsonParser, deserializationContext);
                return z_parseBooleanPrimitive;
            }
            return ((Boolean) deserializationContext.handleUnexpectedToken(Boolean.TYPE, jsonParser)).booleanValue();
        }
        strExtractScalarFromObject = deserializationContext.extractScalarFromObject(jsonParser, this, Boolean.TYPE);
        LogicalType logicalType = LogicalType.Boolean;
        Class<?> cls = Boolean.TYPE;
        CoercionAction coercionAction_checkFromStringCoercion = _checkFromStringCoercion(deserializationContext, strExtractScalarFromObject, logicalType, cls);
        if (coercionAction_checkFromStringCoercion == CoercionAction.AsNull) {
            _verifyNullForPrimitive(deserializationContext);
            return false;
        }
        if (coercionAction_checkFromStringCoercion == CoercionAction.AsEmpty) {
            return false;
        }
        String strTrim = strExtractScalarFromObject.trim();
        int length = strTrim.length();
        if (length == 4) {
            if (_isTrue(strTrim)) {
                return true;
            }
        } else if (length == 5 && _isFalse(strTrim)) {
            return false;
        }
        if (_hasTextualNull(strTrim)) {
            _verifyNullForPrimitiveCoercion(deserializationContext, strTrim);
            return false;
        }
        return Boolean.TRUE.equals((Boolean) deserializationContext.handleWeirdStringValue(cls, strTrim, "only \"true\"/\"True\"/\"TRUE\" or \"false\"/\"False\"/\"FALSE\" recognized", new Object[0]));
    }

    public JavaType getValueType(DeserializationContext deserializationContext) {
        JavaType javaType = this._valueType;
        return javaType != null ? javaType : deserializationContext.constructType(this._valueClass);
    }

    protected final String _parseString(JsonParser jsonParser, DeserializationContext deserializationContext, gs1 gs1Var) throws IOException {
        String strA1;
        CoercionAction coercionAction_checkIntToStringCoercion = CoercionAction.TryConvert;
        int iV = jsonParser.V();
        if (iV == 1) {
            return deserializationContext.extractScalarFromObject(jsonParser, this, this._valueClass);
        }
        if (iV != 12) {
            switch (iV) {
                case 6:
                    return jsonParser.S0();
                case 7:
                    coercionAction_checkIntToStringCoercion = _checkIntToStringCoercion(jsonParser, deserializationContext, this._valueClass);
                    break;
                case 8:
                    coercionAction_checkIntToStringCoercion = _checkFloatToStringCoercion(jsonParser, deserializationContext, this._valueClass);
                    break;
                case 9:
                case 10:
                    coercionAction_checkIntToStringCoercion = _checkBooleanToStringCoercion(jsonParser, deserializationContext, this._valueClass);
                    break;
            }
            if (coercionAction_checkIntToStringCoercion == CoercionAction.AsNull) {
                return (String) gs1Var.getNullValue(deserializationContext);
            }
            if (coercionAction_checkIntToStringCoercion == CoercionAction.AsEmpty) {
                return Constants.STR_EMPTY;
            }
            return (!jsonParser.D().isScalarValue() || (strA1 = jsonParser.a1()) == null) ? (String) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser) : strA1;
        }
        Object objH0 = jsonParser.H0();
        if (objH0 instanceof byte[]) {
            return deserializationContext.getBase64Variant().encode((byte[]) objH0, false);
        }
        if (objH0 == null) {
            return null;
        }
        return objH0.toString();
    }

    protected StdDeserializer(JavaType javaType) {
        this._valueClass = javaType == null ? Object.class : javaType.getRawClass();
        this._valueType = javaType;
    }

    protected StdDeserializer(StdDeserializer<?> stdDeserializer) {
        this._valueClass = stdDeserializer._valueClass;
        this._valueType = stdDeserializer._valueType;
    }

    protected Date _parseDate(String str, DeserializationContext deserializationContext) throws IOException {
        try {
            if (str.isEmpty()) {
                if (a.a[_checkFromStringCoercion(deserializationContext, str).ordinal()] != 1) {
                    return null;
                }
                return new Date(0L);
            }
            if (_hasTextualNull(str)) {
                return null;
            }
            return deserializationContext.parseDate(str);
        } catch (IllegalArgumentException e) {
            return (Date) deserializationContext.handleWeirdStringValue(this._valueClass, str, "not a valid representation (error: %s)", ay.o(e));
        }
    }

    protected final Integer _parseInteger(DeserializationContext deserializationContext, String str) throws IOException {
        try {
            if (str.length() > 9) {
                long jO = hs1.o(str);
                if (_intOverflow(jO)) {
                    return (Integer) deserializationContext.handleWeirdStringValue(Integer.class, str, "Overflow: numeric value (%s) out of range of `java.lang.Integer` (%d -%d)", str, Integer.MIN_VALUE, Integer.MAX_VALUE);
                }
                return Integer.valueOf((int) jO);
            }
            return Integer.valueOf(hs1.m(str));
        } catch (IllegalArgumentException unused) {
            return (Integer) deserializationContext.handleWeirdStringValue(Integer.class, str, "not a valid `java.lang.Integer` value", new Object[0]);
        }
    }

    protected final Long _parseLong(DeserializationContext deserializationContext, String str) throws IOException {
        try {
            return Long.valueOf(hs1.o(str));
        } catch (IllegalArgumentException unused) {
            return (Long) deserializationContext.handleWeirdStringValue(Long.class, str, "not a valid `java.lang.Long` value", new Object[0]);
        }
    }

    protected final int _parseIntPrimitive(DeserializationContext deserializationContext, String str) throws IOException {
        try {
            if (str.length() > 9) {
                long jO = hs1.o(str);
                return _intOverflow(jO) ? _nonNullNumber((Number) deserializationContext.handleWeirdStringValue(Integer.TYPE, str, "Overflow: numeric value (%s) out of range of int (%d -%d)", str, Integer.MIN_VALUE, Integer.MAX_VALUE)).intValue() : (int) jO;
            }
            return hs1.m(str);
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) deserializationContext.handleWeirdStringValue(Integer.TYPE, str, "not a valid `int` value", new Object[0])).intValue();
        }
    }

    protected final long _parseLongPrimitive(DeserializationContext deserializationContext, String str) throws IOException {
        try {
            return hs1.o(str);
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) deserializationContext.handleWeirdStringValue(Long.TYPE, str, "not a valid `long` value", new Object[0])).longValue();
        }
    }

    protected final double _parseDoublePrimitive(DeserializationContext deserializationContext, String str) throws IOException {
        try {
            return _parseDouble(str);
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) deserializationContext.handleWeirdStringValue(Double.TYPE, str, "not a valid `double` value (as String to convert)", new Object[0])).doubleValue();
        }
    }

    protected final float _parseFloatPrimitive(DeserializationContext deserializationContext, String str) throws IOException {
        try {
            return hs1.k(str);
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) deserializationContext.handleWeirdStringValue(Float.TYPE, str, "not a valid `float` value", new Object[0])).floatValue();
        }
    }

    protected final double _parseDoublePrimitive(JsonParser jsonParser, DeserializationContext deserializationContext, String str) throws IOException {
        try {
            return _parseDouble(str, jsonParser.g1(StreamReadFeature.USE_FAST_DOUBLE_PARSER));
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) deserializationContext.handleWeirdStringValue(Double.TYPE, str, "not a valid `double` value (as String to convert)", new Object[0])).doubleValue();
        }
    }

    protected final float _parseFloatPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext, String str) throws IOException {
        try {
            return hs1.l(str, jsonParser.g1(StreamReadFeature.USE_FAST_DOUBLE_PARSER));
        } catch (IllegalArgumentException unused) {
            return _nonNullNumber((Number) deserializationContext.handleWeirdStringValue(Float.TYPE, str, "not a valid `float` value", new Object[0])).floatValue();
        }
    }
}
