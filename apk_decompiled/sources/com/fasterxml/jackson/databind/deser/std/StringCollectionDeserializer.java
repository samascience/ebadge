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
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.type.LogicalType;
import defpackage.e41;
import defpackage.gs1;
import defpackage.m63;
import defpackage.s51;
import defpackage.v30;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@e41
public final class StringCollectionDeserializer extends ContainerDeserializerBase<Collection<String>> implements v30 {
    private static final long serialVersionUID = 1;
    protected final s51 _delegateDeserializer;
    protected final s51 _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;

    public StringCollectionDeserializer(JavaType javaType, s51 s51Var, ValueInstantiator valueInstantiator) {
        this(javaType, valueInstantiator, null, s51Var, s51Var, null);
    }

    private Collection<String> deserializeUsingCustom(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection, s51 s51Var) throws IOException {
        String str;
        while (true) {
            try {
                if (jsonParser.m1() == null) {
                    JsonToken jsonTokenD = jsonParser.D();
                    if (jsonTokenD == JsonToken.END_ARRAY) {
                        return collection;
                    }
                    if (jsonTokenD != JsonToken.VALUE_NULL) {
                        str = (String) s51Var.deserialize(jsonParser, deserializationContext);
                    } else if (!this._skipNullValues) {
                        str = (String) this._nullProvider.getNullValue(deserializationContext);
                    }
                } else {
                    str = (String) s51Var.deserialize(jsonParser, deserializationContext);
                }
                collection.add(str);
            } catch (Exception e) {
                throw JsonMappingException.wrapWithPath(e, collection, collection.size());
            }
        }
    }

    private final Collection<String> handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection) throws IOException {
        String str_parseString;
        Boolean bool = this._unwrapSingle;
        if (bool != Boolean.TRUE && (bool != null || !deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            return jsonParser.d1(JsonToken.VALUE_STRING) ? _deserializeFromString(jsonParser, deserializationContext) : (Collection) deserializationContext.handleUnexpectedToken(this._containerType, jsonParser);
        }
        s51 s51Var = this._valueDeserializer;
        if (jsonParser.D() != JsonToken.VALUE_NULL) {
            if (jsonParser.d1(JsonToken.VALUE_STRING)) {
                String strS0 = jsonParser.S0();
                if (strS0.isEmpty()) {
                    CoercionAction coercionActionFindCoercionAction = deserializationContext.findCoercionAction(logicalType(), handledType(), CoercionInputShape.EmptyString);
                    if (coercionActionFindCoercionAction != CoercionAction.Fail) {
                        return (Collection) _deserializeFromEmptyString(jsonParser, deserializationContext, coercionActionFindCoercionAction, handledType(), "empty String (\"\")");
                    }
                } else if (StdDeserializer._isBlank(strS0)) {
                    LogicalType logicalType = logicalType();
                    Class<?> clsHandledType = handledType();
                    CoercionAction coercionAction = CoercionAction.Fail;
                    CoercionAction coercionActionFindCoercionFromBlankString = deserializationContext.findCoercionFromBlankString(logicalType, clsHandledType, coercionAction);
                    if (coercionActionFindCoercionFromBlankString != coercionAction) {
                        return (Collection) _deserializeFromEmptyString(jsonParser, deserializationContext, coercionActionFindCoercionFromBlankString, handledType(), "blank String (all whitespace)");
                    }
                }
            }
            try {
                str_parseString = s51Var == null ? _parseString(jsonParser, deserializationContext, this._nullProvider) : (String) s51Var.deserialize(jsonParser, deserializationContext);
            } catch (Exception e) {
                throw JsonMappingException.wrapWithPath(e, collection, collection.size());
            }
        } else {
            if (this._skipNullValues) {
                return collection;
            }
            str_parseString = (String) this._nullProvider.getNullValue(deserializationContext);
        }
        collection.add(str_parseString);
        return collection;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0031  */
    @Override // defpackage.v30
    public s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        s51 s51VarFindDeserializer;
        s51 s51VarHandleSecondaryContextualization;
        ValueInstantiator valueInstantiator = this._valueInstantiator;
        if (valueInstantiator == null) {
            s51VarFindDeserializer = null;
        } else if (valueInstantiator.getArrayDelegateCreator() != null) {
            s51VarFindDeserializer = findDeserializer(deserializationContext, this._valueInstantiator.getArrayDelegateType(deserializationContext.getConfig()), beanProperty);
        } else if (this._valueInstantiator.getDelegateCreator() != null) {
            s51VarFindDeserializer = findDeserializer(deserializationContext, this._valueInstantiator.getDelegateType(deserializationContext.getConfig()), beanProperty);
        } else {
            s51VarFindDeserializer = null;
        }
        s51 s51Var = this._valueDeserializer;
        JavaType javaTypeMo15getContentType = this._containerType.mo15getContentType();
        if (s51Var == null) {
            s51VarHandleSecondaryContextualization = findConvertingContentDeserializer(deserializationContext, beanProperty, s51Var);
            if (s51VarHandleSecondaryContextualization == null) {
                s51VarHandleSecondaryContextualization = deserializationContext.findContextualValueDeserializer(javaTypeMo15getContentType, beanProperty);
            }
        } else {
            s51VarHandleSecondaryContextualization = deserializationContext.handleSecondaryContextualization(s51Var, beanProperty, javaTypeMo15getContentType);
        }
        return withResolved(s51VarFindDeserializer, isDefaultDeserializer(s51VarHandleSecondaryContextualization) ? null : s51VarHandleSecondaryContextualization, findContentNullProvider(deserializationContext, beanProperty, s51VarHandleSecondaryContextualization), findFormatFeature(deserializationContext, beanProperty, Collection.class, JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return m63Var.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public s51 getContentDeserializer() {
        return this._valueDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // defpackage.s51
    public boolean isCachable() {
        return this._valueDeserializer == null && this._delegateDeserializer == null;
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return LogicalType.Collection;
    }

    protected StringCollectionDeserializer withResolved(s51 s51Var, s51 s51Var2, gs1 gs1Var, Boolean bool) {
        return (Objects.equals(this._unwrapSingle, bool) && this._nullProvider == gs1Var && this._valueDeserializer == s51Var2 && this._delegateDeserializer == s51Var) ? this : new StringCollectionDeserializer(this._containerType, this._valueInstantiator, s51Var, s51Var2, gs1Var, bool);
    }

    protected StringCollectionDeserializer(JavaType javaType, ValueInstantiator valueInstantiator, s51 s51Var, s51 s51Var2, gs1 gs1Var, Boolean bool) {
        super(javaType, gs1Var, bool);
        this._valueDeserializer = s51Var2;
        this._valueInstantiator = valueInstantiator;
        this._delegateDeserializer = s51Var;
    }

    @Override // defpackage.s51
    public Collection<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        s51 s51Var = this._delegateDeserializer;
        if (s51Var != null) {
            return (Collection) this._valueInstantiator.createUsingDelegate(deserializationContext, s51Var.deserialize(jsonParser, deserializationContext));
        }
        return deserialize(jsonParser, deserializationContext, (Collection<String>) this._valueInstantiator.createUsingDefault(deserializationContext));
    }

    @Override // defpackage.s51
    public Collection<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection) throws IOException {
        String str_parseString;
        if (!jsonParser.i1()) {
            return handleNonArray(jsonParser, deserializationContext, collection);
        }
        s51 s51Var = this._valueDeserializer;
        if (s51Var != null) {
            return deserializeUsingCustom(jsonParser, deserializationContext, collection, s51Var);
        }
        while (true) {
            try {
                String strM1 = jsonParser.m1();
                if (strM1 != null) {
                    collection.add(strM1);
                } else {
                    JsonToken jsonTokenD = jsonParser.D();
                    if (jsonTokenD == JsonToken.END_ARRAY) {
                        return collection;
                    }
                    if (jsonTokenD == JsonToken.VALUE_NULL) {
                        if (!this._skipNullValues) {
                            str_parseString = (String) this._nullProvider.getNullValue(deserializationContext);
                        }
                    } else {
                        str_parseString = _parseString(jsonParser, deserializationContext, this._nullProvider);
                    }
                    collection.add(str_parseString);
                }
            } catch (Exception e) {
                throw JsonMappingException.wrapWithPath(e, collection, collection.size());
            }
        }
    }
}
