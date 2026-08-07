package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.type.LogicalType;
import defpackage.m63;
import defpackage.s51;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class TypeWrappedDeserializer extends s51 implements Serializable {
    private static final long serialVersionUID = 1;
    protected final s51 _deserializer;
    protected final m63 _typeDeserializer;

    public TypeWrappedDeserializer(m63 m63Var, s51 s51Var) {
        this._typeDeserializer = m63Var;
        this._deserializer = s51Var;
    }

    @Override // defpackage.s51
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return this._deserializer.deserializeWithType(jsonParser, deserializationContext, this._typeDeserializer);
    }

    @Override // defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
    }

    @Override // defpackage.s51
    public s51 getDelegatee() {
        return this._deserializer.getDelegatee();
    }

    @Override // defpackage.s51
    public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return this._deserializer.getEmptyValue(deserializationContext);
    }

    @Override // defpackage.s51
    public Collection<Object> getKnownPropertyNames() {
        return this._deserializer.getKnownPropertyNames();
    }

    @Override // defpackage.s51, defpackage.gs1
    public Object getNullValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return this._deserializer.getNullValue(deserializationContext);
    }

    @Override // defpackage.s51
    public Class<?> handledType() {
        return this._deserializer.handledType();
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return this._deserializer.logicalType();
    }

    @Override // defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return this._deserializer.supportsUpdate(deserializationConfig);
    }

    @Override // defpackage.s51
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        return this._deserializer.deserialize(jsonParser, deserializationContext, obj);
    }
}
