package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import defpackage.e41;
import defpackage.gs1;
import defpackage.it1;
import defpackage.m63;
import defpackage.s51;
import defpackage.v30;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@e41
public class ObjectArrayDeserializer extends ContainerDeserializerBase<Object[]> implements v30 {
    private static final long serialVersionUID = 1;
    protected final Class<?> _elementClass;
    protected s51 _elementDeserializer;
    protected final m63 _elementTypeDeserializer;
    protected final Object[] _emptyValue;
    protected final boolean _untyped;

    public ObjectArrayDeserializer(JavaType javaType, s51 s51Var, m63 m63Var) {
        super(javaType, (gs1) null, (Boolean) null);
        ArrayType arrayType = (ArrayType) javaType;
        Class<?> rawClass = arrayType.mo15getContentType().getRawClass();
        this._elementClass = rawClass;
        this._untyped = rawClass == Object.class;
        this._elementDeserializer = s51Var;
        this._elementTypeDeserializer = m63Var;
        this._emptyValue = arrayType.getEmptyArray();
    }

    @Override // defpackage.v30
    public s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        s51 s51Var = this._elementDeserializer;
        Boolean boolFindFormatFeature = findFormatFeature(deserializationContext, beanProperty, this._containerType.getRawClass(), JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        s51 s51VarFindConvertingContentDeserializer = findConvertingContentDeserializer(deserializationContext, beanProperty, s51Var);
        JavaType javaTypeMo15getContentType = this._containerType.mo15getContentType();
        s51 s51VarFindContextualValueDeserializer = s51VarFindConvertingContentDeserializer == null ? deserializationContext.findContextualValueDeserializer(javaTypeMo15getContentType, beanProperty) : deserializationContext.handleSecondaryContextualization(s51VarFindConvertingContentDeserializer, beanProperty, javaTypeMo15getContentType);
        m63 m63VarForProperty = this._elementTypeDeserializer;
        if (m63VarForProperty != null) {
            m63VarForProperty = m63VarForProperty.forProperty(beanProperty);
        }
        return withResolved(m63VarForProperty, s51VarFindContextualValueDeserializer, findContentNullProvider(deserializationContext, beanProperty, s51VarFindContextualValueDeserializer), boolFindFormatFeature);
    }

    protected Byte[] deserializeFromBase64(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        byte[] bArrJ0 = jsonParser.j0(deserializationContext.getBase64Variant());
        Byte[] bArr = new Byte[bArrJ0.length];
        int length = bArrJ0.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = Byte.valueOf(bArrJ0[i]);
        }
        return bArr;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public s51 getContentDeserializer() {
        return this._elementDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, defpackage.s51
    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.CONSTANT;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, defpackage.s51
    public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return this._emptyValue;
    }

    protected Object[] handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objDeserialize;
        Boolean bool = this._unwrapSingle;
        if (bool != Boolean.TRUE && (bool != null || !deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            if (jsonParser.d1(JsonToken.VALUE_STRING)) {
                return this._elementClass == Byte.class ? deserializeFromBase64(jsonParser, deserializationContext) : _deserializeFromString(jsonParser, deserializationContext);
            }
            return (Object[]) deserializationContext.handleUnexpectedToken(this._containerType, jsonParser);
        }
        if (!jsonParser.d1(JsonToken.VALUE_NULL)) {
            if (jsonParser.d1(JsonToken.VALUE_STRING)) {
                String strS0 = jsonParser.S0();
                if (strS0.isEmpty()) {
                    CoercionAction coercionActionFindCoercionAction = deserializationContext.findCoercionAction(logicalType(), handledType(), CoercionInputShape.EmptyString);
                    if (coercionActionFindCoercionAction != CoercionAction.Fail) {
                        return (Object[]) _deserializeFromEmptyString(jsonParser, deserializationContext, coercionActionFindCoercionAction, handledType(), "empty String (\"\")");
                    }
                } else if (StdDeserializer._isBlank(strS0)) {
                    LogicalType logicalType = logicalType();
                    Class<?> clsHandledType = handledType();
                    CoercionAction coercionAction = CoercionAction.Fail;
                    CoercionAction coercionActionFindCoercionFromBlankString = deserializationContext.findCoercionFromBlankString(logicalType, clsHandledType, coercionAction);
                    if (coercionActionFindCoercionFromBlankString != coercionAction) {
                        return (Object[]) _deserializeFromEmptyString(jsonParser, deserializationContext, coercionActionFindCoercionFromBlankString, handledType(), "blank String (all whitespace)");
                    }
                }
            }
            m63 m63Var = this._elementTypeDeserializer;
            objDeserialize = m63Var == null ? this._elementDeserializer.deserialize(jsonParser, deserializationContext) : this._elementDeserializer.deserializeWithType(jsonParser, deserializationContext, m63Var);
        } else {
            if (this._skipNullValues) {
                return this._emptyValue;
            }
            objDeserialize = this._nullProvider.getNullValue(deserializationContext);
        }
        Object[] objArr = this._untyped ? new Object[1] : (Object[]) Array.newInstance(this._elementClass, 1);
        objArr[0] = objDeserialize;
        return objArr;
    }

    @Override // defpackage.s51
    public boolean isCachable() {
        return this._elementDeserializer == null && this._elementTypeDeserializer == null;
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return LogicalType.Array;
    }

    public ObjectArrayDeserializer withDeserializer(m63 m63Var, s51 s51Var) {
        return withResolved(m63Var, s51Var, this._nullProvider, this._unwrapSingle);
    }

    public ObjectArrayDeserializer withResolved(m63 m63Var, s51 s51Var, gs1 gs1Var, Boolean bool) {
        return (Objects.equals(bool, this._unwrapSingle) && gs1Var == this._nullProvider && s51Var == this._elementDeserializer && m63Var == this._elementTypeDeserializer) ? this : new ObjectArrayDeserializer(this, s51Var, m63Var, gs1Var, bool);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object[] deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return (Object[]) m63Var.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    @Override // defpackage.s51
    public Object[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object[] objArrG;
        Object objDeserializeWithType;
        int i;
        if (!jsonParser.i1()) {
            return handleNonArray(jsonParser, deserializationContext);
        }
        it1 it1VarLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object[] objArrI = it1VarLeaseObjectBuffer.i();
        m63 m63Var = this._elementTypeDeserializer;
        int i2 = 0;
        while (true) {
            try {
                JsonToken jsonTokenN1 = jsonParser.n1();
                if (jsonTokenN1 == JsonToken.END_ARRAY) {
                    break;
                }
                try {
                    if (jsonTokenN1 == JsonToken.VALUE_NULL) {
                        if (!this._skipNullValues) {
                            objDeserializeWithType = this._nullProvider.getNullValue(deserializationContext);
                        }
                    } else if (m63Var == null) {
                        objDeserializeWithType = this._elementDeserializer.deserialize(jsonParser, deserializationContext);
                    } else {
                        objDeserializeWithType = this._elementDeserializer.deserializeWithType(jsonParser, deserializationContext, m63Var);
                    }
                    objArrI[i2] = objDeserializeWithType;
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
        if (this._untyped) {
            objArrG = it1VarLeaseObjectBuffer.f(objArrI, i2);
        } else {
            objArrG = it1VarLeaseObjectBuffer.g(objArrI, i2, this._elementClass);
        }
        deserializationContext.returnObjectBuffer(it1VarLeaseObjectBuffer);
        return objArrG;
    }

    protected ObjectArrayDeserializer(ObjectArrayDeserializer objectArrayDeserializer, s51 s51Var, m63 m63Var, gs1 gs1Var, Boolean bool) {
        super(objectArrayDeserializer, gs1Var, bool);
        this._elementClass = objectArrayDeserializer._elementClass;
        this._untyped = objectArrayDeserializer._untyped;
        this._emptyValue = objectArrayDeserializer._emptyValue;
        this._elementDeserializer = s51Var;
        this._elementTypeDeserializer = m63Var;
    }

    @Override // defpackage.s51
    public Object[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object[] objArr) throws IOException {
        Object[] objArrG;
        Object objDeserializeWithType;
        int i;
        if (!jsonParser.i1()) {
            Object[] objArrHandleNonArray = handleNonArray(jsonParser, deserializationContext);
            if (objArrHandleNonArray == null) {
                return objArr;
            }
            int length = objArr.length;
            Object[] objArr2 = new Object[objArrHandleNonArray.length + length];
            System.arraycopy(objArr, 0, objArr2, 0, length);
            System.arraycopy(objArrHandleNonArray, 0, objArr2, length, objArrHandleNonArray.length);
            return objArr2;
        }
        it1 it1VarLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        int length2 = objArr.length;
        Object[] objArrJ = it1VarLeaseObjectBuffer.j(objArr, length2);
        m63 m63Var = this._elementTypeDeserializer;
        while (true) {
            try {
                JsonToken jsonTokenN1 = jsonParser.n1();
                if (jsonTokenN1 == JsonToken.END_ARRAY) {
                    break;
                }
                try {
                    if (jsonTokenN1 == JsonToken.VALUE_NULL) {
                        if (!this._skipNullValues) {
                            objDeserializeWithType = this._nullProvider.getNullValue(deserializationContext);
                        }
                    } else if (m63Var == null) {
                        objDeserializeWithType = this._elementDeserializer.deserialize(jsonParser, deserializationContext);
                    } else {
                        objDeserializeWithType = this._elementDeserializer.deserializeWithType(jsonParser, deserializationContext, m63Var);
                    }
                    objArrJ[length2] = objDeserializeWithType;
                    length2 = i;
                } catch (Exception e) {
                    e = e;
                    length2 = i;
                    throw JsonMappingException.wrapWithPath(e, objArrJ, it1VarLeaseObjectBuffer.d() + length2);
                }
                if (length2 >= objArrJ.length) {
                    objArrJ = it1VarLeaseObjectBuffer.c(objArrJ);
                    length2 = 0;
                }
                i = length2 + 1;
            } catch (Exception e2) {
                e = e2;
            }
        }
        if (this._untyped) {
            objArrG = it1VarLeaseObjectBuffer.f(objArrJ, length2);
        } else {
            objArrG = it1VarLeaseObjectBuffer.g(objArrJ, length2, this._elementClass);
        }
        deserializationContext.returnObjectBuffer(it1VarLeaseObjectBuffer);
        return objArrG;
    }
}
