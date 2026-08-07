package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import defpackage.e41;
import defpackage.gs1;
import defpackage.it1;
import defpackage.m63;
import defpackage.s51;
import defpackage.v30;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@e41
public final class StringArrayDeserializer extends StdDeserializer<String[]> implements v30 {
    private static final String[] NO_STRINGS = new String[0];
    public static final StringArrayDeserializer instance = new StringArrayDeserializer();
    private static final long serialVersionUID = 2;
    protected s51 _elementDeserializer;
    protected final gs1 _nullProvider;
    protected final boolean _skipNullValues;
    protected final Boolean _unwrapSingle;

    public StringArrayDeserializer() {
        this(null, null, null);
    }

    private final String[] handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String str_parseString;
        Boolean bool = this._unwrapSingle;
        if (bool != Boolean.TRUE && (bool != null || !deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            return jsonParser.d1(JsonToken.VALUE_STRING) ? _deserializeFromString(jsonParser, deserializationContext) : (String[]) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser);
        }
        if (jsonParser.d1(JsonToken.VALUE_NULL)) {
            str_parseString = (String) this._nullProvider.getNullValue(deserializationContext);
        } else {
            if (jsonParser.d1(JsonToken.VALUE_STRING)) {
                String strS0 = jsonParser.S0();
                if (strS0.isEmpty()) {
                    CoercionAction coercionActionFindCoercionAction = deserializationContext.findCoercionAction(logicalType(), handledType(), CoercionInputShape.EmptyString);
                    if (coercionActionFindCoercionAction != CoercionAction.Fail) {
                        return (String[]) _deserializeFromEmptyString(jsonParser, deserializationContext, coercionActionFindCoercionAction, handledType(), "empty String (\"\")");
                    }
                } else if (StdDeserializer._isBlank(strS0)) {
                    LogicalType logicalType = logicalType();
                    Class<?> clsHandledType = handledType();
                    CoercionAction coercionAction = CoercionAction.Fail;
                    CoercionAction coercionActionFindCoercionFromBlankString = deserializationContext.findCoercionFromBlankString(logicalType, clsHandledType, coercionAction);
                    if (coercionActionFindCoercionFromBlankString != coercionAction) {
                        return (String[]) _deserializeFromEmptyString(jsonParser, deserializationContext, coercionActionFindCoercionFromBlankString, handledType(), "blank String (all whitespace)");
                    }
                }
            }
            str_parseString = _parseString(jsonParser, deserializationContext, this._nullProvider);
        }
        return new String[]{str_parseString};
    }

    protected final String[] _deserializeCustom(JsonParser jsonParser, DeserializationContext deserializationContext, String[] strArr) throws IOException {
        int length;
        Object[] objArrJ;
        String str;
        int i;
        it1 it1VarLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        if (strArr == null) {
            objArrJ = it1VarLeaseObjectBuffer.i();
            length = 0;
        } else {
            length = strArr.length;
            objArrJ = it1VarLeaseObjectBuffer.j(strArr, length);
        }
        s51 s51Var = this._elementDeserializer;
        while (true) {
            try {
                try {
                    if (jsonParser.m1() == null) {
                        JsonToken jsonTokenD = jsonParser.D();
                        if (jsonTokenD == JsonToken.END_ARRAY) {
                            String[] strArr2 = (String[]) it1VarLeaseObjectBuffer.g(objArrJ, length, String.class);
                            deserializationContext.returnObjectBuffer(it1VarLeaseObjectBuffer);
                            return strArr2;
                        }
                        if (jsonTokenD != JsonToken.VALUE_NULL) {
                            str = (String) s51Var.deserialize(jsonParser, deserializationContext);
                        } else if (!this._skipNullValues) {
                            str = (String) this._nullProvider.getNullValue(deserializationContext);
                        }
                    } else {
                        str = (String) s51Var.deserialize(jsonParser, deserializationContext);
                    }
                    objArrJ[length] = str;
                    length = i;
                } catch (Exception e) {
                    e = e;
                    length = i;
                    throw JsonMappingException.wrapWithPath(e, String.class, length);
                }
                if (length >= objArrJ.length) {
                    objArrJ = it1VarLeaseObjectBuffer.c(objArrJ);
                    length = 0;
                }
                i = length + 1;
            } catch (Exception e2) {
                e = e2;
            }
        }
    }

    @Override // defpackage.v30
    public s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        s51 s51VarFindConvertingContentDeserializer = findConvertingContentDeserializer(deserializationContext, beanProperty, this._elementDeserializer);
        JavaType javaTypeConstructType = deserializationContext.constructType(String.class);
        s51 s51VarFindContextualValueDeserializer = s51VarFindConvertingContentDeserializer == null ? deserializationContext.findContextualValueDeserializer(javaTypeConstructType, beanProperty) : deserializationContext.handleSecondaryContextualization(s51VarFindConvertingContentDeserializer, beanProperty, javaTypeConstructType);
        Boolean boolFindFormatFeature = findFormatFeature(deserializationContext, beanProperty, String[].class, JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        gs1 gs1VarFindContentNullProvider = findContentNullProvider(deserializationContext, beanProperty, s51VarFindContextualValueDeserializer);
        if (s51VarFindContextualValueDeserializer != null && isDefaultDeserializer(s51VarFindContextualValueDeserializer)) {
            s51VarFindContextualValueDeserializer = null;
        }
        return (this._elementDeserializer == s51VarFindContextualValueDeserializer && Objects.equals(this._unwrapSingle, boolFindFormatFeature) && this._nullProvider == gs1VarFindContentNullProvider) ? this : new StringArrayDeserializer(s51VarFindContextualValueDeserializer, gs1VarFindContentNullProvider, boolFindFormatFeature);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return m63Var.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    @Override // defpackage.s51
    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.CONSTANT;
    }

    @Override // defpackage.s51
    public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return NO_STRINGS;
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return LogicalType.Array;
    }

    @Override // defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return Boolean.TRUE;
    }

    protected StringArrayDeserializer(s51 s51Var, gs1 gs1Var, Boolean bool) {
        super((Class<?>) String[].class);
        this._elementDeserializer = s51Var;
        this._nullProvider = gs1Var;
        this._unwrapSingle = bool;
        this._skipNullValues = NullsConstantProvider.isSkipper(gs1Var);
    }

    @Override // defpackage.s51
    public String[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        int i;
        if (!jsonParser.i1()) {
            return handleNonArray(jsonParser, deserializationContext);
        }
        if (this._elementDeserializer != null) {
            return _deserializeCustom(jsonParser, deserializationContext, null);
        }
        it1 it1VarLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object[] objArrI = it1VarLeaseObjectBuffer.i();
        int i2 = 0;
        while (true) {
            try {
                String strM1 = jsonParser.m1();
                try {
                    if (strM1 == null) {
                        JsonToken jsonTokenD = jsonParser.D();
                        if (jsonTokenD == JsonToken.END_ARRAY) {
                            String[] strArr = (String[]) it1VarLeaseObjectBuffer.g(objArrI, i2, String.class);
                            deserializationContext.returnObjectBuffer(it1VarLeaseObjectBuffer);
                            return strArr;
                        }
                        if (jsonTokenD == JsonToken.VALUE_NULL) {
                            if (!this._skipNullValues) {
                                strM1 = (String) this._nullProvider.getNullValue(deserializationContext);
                            }
                        } else {
                            strM1 = _parseString(jsonParser, deserializationContext, this._nullProvider);
                        }
                    }
                    objArrI[i2] = strM1;
                    i2 = i;
                } catch (Exception e) {
                    e = e;
                    i2 = i;
                    throw JsonMappingException.wrapWithPath(e, objArrI, it1VarLeaseObjectBuffer.d() + i2);
                }
                if (i2 >= objArrI.length) {
                    objArrI = it1VarLeaseObjectBuffer.c(objArrI);
                    i2 = 0;
                }
                i = i2 + 1;
            } catch (Exception e2) {
                e = e2;
            }
        }
    }

    @Override // defpackage.s51
    public String[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, String[] strArr) throws IOException {
        if (!jsonParser.i1()) {
            String[] strArrHandleNonArray = handleNonArray(jsonParser, deserializationContext);
            if (strArrHandleNonArray == null) {
                return strArr;
            }
            int length = strArr.length;
            String[] strArr2 = new String[strArrHandleNonArray.length + length];
            System.arraycopy(strArr, 0, strArr2, 0, length);
            System.arraycopy(strArrHandleNonArray, 0, strArr2, length, strArrHandleNonArray.length);
            return strArr2;
        }
        if (this._elementDeserializer != null) {
            return _deserializeCustom(jsonParser, deserializationContext, strArr);
        }
        it1 it1VarLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        int length2 = strArr.length;
        Object[] objArrJ = it1VarLeaseObjectBuffer.j(strArr, length2);
        while (true) {
            try {
                String strM1 = jsonParser.m1();
                if (strM1 == null) {
                    JsonToken jsonTokenD = jsonParser.D();
                    if (jsonTokenD == JsonToken.END_ARRAY) {
                        String[] strArr3 = (String[]) it1VarLeaseObjectBuffer.g(objArrJ, length2, String.class);
                        deserializationContext.returnObjectBuffer(it1VarLeaseObjectBuffer);
                        return strArr3;
                    }
                    if (jsonTokenD == JsonToken.VALUE_NULL) {
                        if (this._skipNullValues) {
                            return NO_STRINGS;
                        }
                        strM1 = (String) this._nullProvider.getNullValue(deserializationContext);
                    } else {
                        strM1 = _parseString(jsonParser, deserializationContext, this._nullProvider);
                    }
                    throw JsonMappingException.wrapWithPath(e, objArrJ, it1VarLeaseObjectBuffer.d() + length2);
                }
                if (length2 >= objArrJ.length) {
                    objArrJ = it1VarLeaseObjectBuffer.c(objArrJ);
                    length2 = 0;
                }
                int i = length2 + 1;
                try {
                    objArrJ[length2] = strM1;
                    length2 = i;
                } catch (Exception e) {
                    e = e;
                    length2 = i;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
    }
}
