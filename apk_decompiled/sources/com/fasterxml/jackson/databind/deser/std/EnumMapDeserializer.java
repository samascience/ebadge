package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.b;
import com.fasterxml.jackson.databind.type.LogicalType;
import defpackage.a91;
import defpackage.ag2;
import defpackage.ay;
import defpackage.gs1;
import defpackage.m63;
import defpackage.s51;
import defpackage.v30;
import java.io.IOException;
import java.util.EnumMap;

/* JADX INFO: loaded from: classes.dex */
public class EnumMapDeserializer extends ContainerDeserializerBase<EnumMap<?, ?>> implements v30, ag2 {
    private static final long serialVersionUID = 1;
    protected s51 _delegateDeserializer;
    protected final Class<?> _enumClass;
    protected a91 _keyDeserializer;
    protected PropertyBasedCreator _propertyBasedCreator;
    protected s51 _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;
    protected final m63 _valueTypeDeserializer;

    public EnumMapDeserializer(JavaType javaType, ValueInstantiator valueInstantiator, a91 a91Var, s51 s51Var, m63 m63Var, gs1 gs1Var) {
        super(javaType, gs1Var, (Boolean) null);
        this._enumClass = javaType.mo16getKeyType().getRawClass();
        this._keyDeserializer = a91Var;
        this._valueDeserializer = s51Var;
        this._valueTypeDeserializer = m63Var;
        this._valueInstantiator = valueInstantiator;
    }

    public EnumMap<?, ?> _deserializeUsingProperties(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String strC;
        Object objDeserialize;
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        b bVarG = propertyBasedCreator.g(jsonParser, deserializationContext, null);
        if (jsonParser.j1()) {
            strC = jsonParser.l1();
        } else {
            strC = jsonParser.d1(JsonToken.FIELD_NAME) ? jsonParser.C() : null;
        }
        while (strC != null) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            SettableBeanProperty settableBeanPropertyE = propertyBasedCreator.e(strC);
            if (settableBeanPropertyE == null) {
                Enum r5 = (Enum) this._keyDeserializer.deserializeKey(strC, deserializationContext);
                if (r5 != null) {
                    try {
                        if (jsonTokenN1 != JsonToken.VALUE_NULL) {
                            m63 m63Var = this._valueTypeDeserializer;
                            objDeserialize = m63Var == null ? this._valueDeserializer.deserialize(jsonParser, deserializationContext) : this._valueDeserializer.deserializeWithType(jsonParser, deserializationContext, m63Var);
                        } else if (!this._skipNullValues) {
                            objDeserialize = this._nullProvider.getNullValue(deserializationContext);
                        }
                        bVarG.d(r5, objDeserialize);
                    } catch (Exception e) {
                        wrapAndThrow(deserializationContext, e, this._containerType.getRawClass(), strC);
                        return null;
                    }
                } else {
                    if (!deserializationContext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                        return (EnumMap) deserializationContext.handleWeirdStringValue(this._enumClass, strC, "value not one of declared Enum instance names for %s", this._containerType.mo16getKeyType());
                    }
                    jsonParser.n1();
                    jsonParser.v1();
                }
            } else if (bVarG.b(settableBeanPropertyE, settableBeanPropertyE.deserialize(jsonParser, deserializationContext))) {
                jsonParser.n1();
                try {
                    return deserialize(jsonParser, deserializationContext, (EnumMap) propertyBasedCreator.a(deserializationContext, bVarG));
                } catch (Exception e2) {
                    return (EnumMap) wrapAndThrow(deserializationContext, e2, this._containerType.getRawClass(), strC);
                }
            }
            strC = jsonParser.l1();
        }
        try {
            return (EnumMap) propertyBasedCreator.a(deserializationContext, bVarG);
        } catch (Exception e3) {
            wrapAndThrow(deserializationContext, e3, this._containerType.getRawClass(), strC);
            return null;
        }
    }

    protected EnumMap<?, ?> constructMap(DeserializationContext deserializationContext) throws JsonMappingException {
        ValueInstantiator valueInstantiator = this._valueInstantiator;
        if (valueInstantiator == null) {
            return new EnumMap<>(this._enumClass);
        }
        try {
            return !valueInstantiator.canCreateUsingDefault() ? (EnumMap) deserializationContext.handleMissingInstantiator(handledType(), getValueInstantiator(), null, "no default constructor found", new Object[0]) : (EnumMap) this._valueInstantiator.createUsingDefault(deserializationContext);
        } catch (IOException e) {
            return (EnumMap) ay.g0(deserializationContext, e);
        }
    }

    @Override // defpackage.v30
    public s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        a91 a91VarFindKeyDeserializer = this._keyDeserializer;
        if (a91VarFindKeyDeserializer == null) {
            a91VarFindKeyDeserializer = deserializationContext.findKeyDeserializer(this._containerType.mo16getKeyType(), beanProperty);
        }
        s51 s51Var = this._valueDeserializer;
        JavaType javaTypeMo15getContentType = this._containerType.mo15getContentType();
        s51 s51VarFindContextualValueDeserializer = s51Var == null ? deserializationContext.findContextualValueDeserializer(javaTypeMo15getContentType, beanProperty) : deserializationContext.handleSecondaryContextualization(s51Var, beanProperty, javaTypeMo15getContentType);
        m63 m63VarForProperty = this._valueTypeDeserializer;
        if (m63VarForProperty != null) {
            m63VarForProperty = m63VarForProperty.forProperty(beanProperty);
        }
        return withResolved(a91VarFindKeyDeserializer, s51VarFindContextualValueDeserializer, m63VarForProperty, findContentNullProvider(deserializationContext, beanProperty, s51VarFindContextualValueDeserializer));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return m63Var.deserializeTypedFromObject(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public s51 getContentDeserializer() {
        return this._valueDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, defpackage.s51
    public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return constructMap(deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // defpackage.s51
    public boolean isCachable() {
        return this._valueDeserializer == null && this._keyDeserializer == null && this._valueTypeDeserializer == null;
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return LogicalType.Map;
    }

    @Override // defpackage.ag2
    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        ValueInstantiator valueInstantiator = this._valueInstantiator;
        if (valueInstantiator != null) {
            if (valueInstantiator.canCreateUsingDelegate()) {
                JavaType delegateType = this._valueInstantiator.getDelegateType(deserializationContext.getConfig());
                if (delegateType == null) {
                    JavaType javaType = this._containerType;
                    deserializationContext.reportBadDefinition(javaType, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", javaType, this._valueInstantiator.getClass().getName()));
                }
                this._delegateDeserializer = findDeserializer(deserializationContext, delegateType, null);
                return;
            }
            if (!this._valueInstantiator.canCreateUsingArrayDelegate()) {
                if (this._valueInstantiator.canCreateFromObjectWith()) {
                    this._propertyBasedCreator = PropertyBasedCreator.c(deserializationContext, this._valueInstantiator, this._valueInstantiator.getFromObjectArguments(deserializationContext.getConfig()), deserializationContext.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
                    return;
                }
                return;
            }
            JavaType arrayDelegateType = this._valueInstantiator.getArrayDelegateType(deserializationContext.getConfig());
            if (arrayDelegateType == null) {
                JavaType javaType2 = this._containerType;
                deserializationContext.reportBadDefinition(javaType2, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", javaType2, this._valueInstantiator.getClass().getName()));
            }
            this._delegateDeserializer = findDeserializer(deserializationContext, arrayDelegateType, null);
        }
    }

    public EnumMapDeserializer withResolved(a91 a91Var, s51 s51Var, m63 m63Var, gs1 gs1Var) {
        return (a91Var == this._keyDeserializer && gs1Var == this._nullProvider && s51Var == this._valueDeserializer && m63Var == this._valueTypeDeserializer) ? this : new EnumMapDeserializer(this, a91Var, s51Var, m63Var, gs1Var);
    }

    @Override // defpackage.s51
    public EnumMap<?, ?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingProperties(jsonParser, deserializationContext);
        }
        s51 s51Var = this._delegateDeserializer;
        if (s51Var != null) {
            return (EnumMap) this._valueInstantiator.createUsingDelegate(deserializationContext, s51Var.deserialize(jsonParser, deserializationContext));
        }
        int iV = jsonParser.V();
        if (iV != 1 && iV != 2) {
            if (iV == 3) {
                return _deserializeFromArray(jsonParser, deserializationContext);
            }
            if (iV != 5) {
                if (iV != 6) {
                    return (EnumMap) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                }
                return _deserializeFromString(jsonParser, deserializationContext);
            }
        }
        return deserialize(jsonParser, deserializationContext, (EnumMap) constructMap(deserializationContext));
    }

    protected EnumMapDeserializer(EnumMapDeserializer enumMapDeserializer, a91 a91Var, s51 s51Var, m63 m63Var, gs1 gs1Var) {
        super(enumMapDeserializer, gs1Var, enumMapDeserializer._unwrapSingle);
        this._enumClass = enumMapDeserializer._enumClass;
        this._keyDeserializer = a91Var;
        this._valueDeserializer = s51Var;
        this._valueTypeDeserializer = m63Var;
        this._valueInstantiator = enumMapDeserializer._valueInstantiator;
        this._delegateDeserializer = enumMapDeserializer._delegateDeserializer;
        this._propertyBasedCreator = enumMapDeserializer._propertyBasedCreator;
    }

    @Override // defpackage.s51
    public EnumMap<?, ?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, EnumMap enumMap) throws IOException {
        String strC;
        Object objDeserializeWithType;
        jsonParser.s1(enumMap);
        s51 s51Var = this._valueDeserializer;
        m63 m63Var = this._valueTypeDeserializer;
        if (jsonParser.j1()) {
            strC = jsonParser.l1();
        } else {
            JsonToken jsonTokenD = jsonParser.D();
            JsonToken jsonToken = JsonToken.FIELD_NAME;
            if (jsonTokenD != jsonToken) {
                if (jsonTokenD == JsonToken.END_OBJECT) {
                    return enumMap;
                }
                deserializationContext.reportWrongTokenException(this, jsonToken, (String) null, new Object[0]);
            }
            strC = jsonParser.C();
        }
        while (strC != null) {
            Enum r3 = (Enum) this._keyDeserializer.deserializeKey(strC, deserializationContext);
            JsonToken jsonTokenN1 = jsonParser.n1();
            if (r3 == null) {
                if (!deserializationContext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                    return (EnumMap) deserializationContext.handleWeirdStringValue(this._enumClass, strC, "value not one of declared Enum instance names for %s", this._containerType.mo16getKeyType());
                }
                jsonParser.v1();
            } else {
                try {
                    if (jsonTokenN1 == JsonToken.VALUE_NULL) {
                        if (!this._skipNullValues) {
                            objDeserializeWithType = this._nullProvider.getNullValue(deserializationContext);
                        }
                    } else if (m63Var == null) {
                        objDeserializeWithType = s51Var.deserialize(jsonParser, deserializationContext);
                    } else {
                        objDeserializeWithType = s51Var.deserializeWithType(jsonParser, deserializationContext, m63Var);
                    }
                    enumMap.put(r3, objDeserializeWithType);
                } catch (Exception e) {
                    return (EnumMap) wrapAndThrow(deserializationContext, e, enumMap, strC);
                }
            }
            strC = jsonParser.l1();
        }
        return enumMap;
    }

    @Deprecated
    public EnumMapDeserializer(JavaType javaType, a91 a91Var, s51 s51Var, m63 m63Var) {
        this(javaType, null, a91Var, s51Var, m63Var, null);
    }
}
