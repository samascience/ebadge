package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import defpackage.m63;
import defpackage.s51;
import defpackage.v30;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class ReferenceTypeDeserializer<T> extends StdDeserializer<T> implements v30 {
    private static final long serialVersionUID = 2;
    protected final JavaType _fullType;
    protected final s51 _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;
    protected final m63 _valueTypeDeserializer;

    public ReferenceTypeDeserializer(JavaType javaType, ValueInstantiator valueInstantiator, m63 m63Var, s51 s51Var) {
        super(javaType);
        this._valueInstantiator = valueInstantiator;
        this._fullType = javaType;
        this._valueDeserializer = s51Var;
        this._valueTypeDeserializer = m63Var;
    }

    @Override // defpackage.v30
    public s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        s51 s51Var = this._valueDeserializer;
        s51 s51VarFindContextualValueDeserializer = s51Var == null ? deserializationContext.findContextualValueDeserializer(this._fullType.getReferencedType(), beanProperty) : deserializationContext.handleSecondaryContextualization(s51Var, beanProperty, this._fullType.getReferencedType());
        m63 m63VarForProperty = this._valueTypeDeserializer;
        if (m63VarForProperty != null) {
            m63VarForProperty = m63VarForProperty.forProperty(beanProperty);
        }
        return (s51VarFindContextualValueDeserializer == this._valueDeserializer && m63VarForProperty == this._valueTypeDeserializer) ? this : withResolved(m63VarForProperty, s51VarFindContextualValueDeserializer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.s51
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ValueInstantiator valueInstantiator = this._valueInstantiator;
        if (valueInstantiator != null) {
            return (T) deserialize(jsonParser, deserializationContext, valueInstantiator.createUsingDefault(deserializationContext));
        }
        m63 m63Var = this._valueTypeDeserializer;
        return (T) referenceValue(m63Var == null ? this._valueDeserializer.deserialize(jsonParser, deserializationContext) : this._valueDeserializer.deserializeWithType(jsonParser, deserializationContext, m63Var));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        if (jsonParser.d1(JsonToken.VALUE_NULL)) {
            return getNullValue(deserializationContext);
        }
        m63 m63Var2 = this._valueTypeDeserializer;
        return m63Var2 == null ? deserialize(jsonParser, deserializationContext) : referenceValue(m63Var2.deserializeTypedFromAny(jsonParser, deserializationContext));
    }

    @Override // defpackage.s51
    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.DYNAMIC;
    }

    @Override // defpackage.s51
    public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return getNullValue(deserializationContext);
    }

    @Override // defpackage.s51
    public AccessPattern getNullAccessPattern() {
        return AccessPattern.DYNAMIC;
    }

    @Override // defpackage.s51, defpackage.gs1
    public abstract T getNullValue(DeserializationContext deserializationContext) throws JsonMappingException;

    public abstract Object getReferenced(T t);

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public JavaType getValueType() {
        return this._fullType;
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        s51 s51Var = this._valueDeserializer;
        return s51Var != null ? s51Var.logicalType() : super.logicalType();
    }

    public abstract T referenceValue(Object obj);

    @Override // defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        s51 s51Var = this._valueDeserializer;
        if (s51Var == null) {
            return null;
        }
        return s51Var.supportsUpdate(deserializationConfig);
    }

    public abstract T updateReference(T t, Object obj);

    protected abstract ReferenceTypeDeserializer<T> withResolved(m63 m63Var, s51 s51Var);

    @Deprecated
    public ReferenceTypeDeserializer(JavaType javaType, m63 m63Var, s51 s51Var) {
        this(javaType, null, m63Var, s51Var);
    }

    @Override // defpackage.s51
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, T t) throws IOException {
        Object objDeserializeWithType;
        Object objDeserializeWithType2;
        if (!this._valueDeserializer.supportsUpdate(deserializationContext.getConfig()).equals(Boolean.FALSE) && this._valueTypeDeserializer == null) {
            Object referenced = getReferenced(t);
            if (referenced == null) {
                m63 m63Var = this._valueTypeDeserializer;
                if (m63Var == null) {
                    objDeserializeWithType2 = this._valueDeserializer.deserialize(jsonParser, deserializationContext);
                } else {
                    objDeserializeWithType2 = this._valueDeserializer.deserializeWithType(jsonParser, deserializationContext, m63Var);
                }
                return referenceValue(objDeserializeWithType2);
            }
            objDeserializeWithType = this._valueDeserializer.deserialize(jsonParser, deserializationContext, referenced);
        } else {
            m63 m63Var2 = this._valueTypeDeserializer;
            if (m63Var2 == null) {
                objDeserializeWithType = this._valueDeserializer.deserialize(jsonParser, deserializationContext);
            } else {
                objDeserializeWithType = this._valueDeserializer.deserializeWithType(jsonParser, deserializationContext, m63Var2);
            }
        }
        return updateReference(t, objDeserializeWithType);
    }
}
