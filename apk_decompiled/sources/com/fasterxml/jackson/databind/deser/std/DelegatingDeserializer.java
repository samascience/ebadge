package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import defpackage.ag2;
import defpackage.gs1;
import defpackage.m63;
import defpackage.s51;
import defpackage.v30;
import java.io.IOException;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class DelegatingDeserializer extends StdDeserializer<Object> implements v30, ag2 {
    private static final long serialVersionUID = 1;
    protected final s51 _delegatee;

    public DelegatingDeserializer(s51 s51Var) {
        super((Class<?>) s51Var.handledType());
        this._delegatee = s51Var;
    }

    @Override // defpackage.v30
    public s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        s51 s51VarHandleSecondaryContextualization = deserializationContext.handleSecondaryContextualization(this._delegatee, beanProperty, deserializationContext.constructType((Class<?>) this._delegatee.handledType()));
        return s51VarHandleSecondaryContextualization == this._delegatee ? this : newDelegatingInstance(s51VarHandleSecondaryContextualization);
    }

    @Override // defpackage.s51
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return this._delegatee.deserialize(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return this._delegatee.deserializeWithType(jsonParser, deserializationContext, m63Var);
    }

    @Override // defpackage.s51
    public SettableBeanProperty findBackReference(String str) {
        return this._delegatee.findBackReference(str);
    }

    @Override // defpackage.s51
    public s51 getDelegatee() {
        return this._delegatee;
    }

    @Override // defpackage.s51
    public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return this._delegatee.getEmptyValue(deserializationContext);
    }

    @Override // defpackage.s51
    public Collection<Object> getKnownPropertyNames() {
        return this._delegatee.getKnownPropertyNames();
    }

    @Override // defpackage.s51
    public AccessPattern getNullAccessPattern() {
        return this._delegatee.getNullAccessPattern();
    }

    @Override // defpackage.s51, defpackage.gs1
    public Object getNullValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return this._delegatee.getNullValue(deserializationContext);
    }

    @Override // defpackage.s51
    public ObjectIdReader getObjectIdReader() {
        return this._delegatee.getObjectIdReader();
    }

    @Override // defpackage.s51
    public boolean isCachable() {
        return this._delegatee.isCachable();
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return this._delegatee.logicalType();
    }

    protected abstract s51 newDelegatingInstance(s51 s51Var);

    @Override // defpackage.s51
    public s51 replaceDelegatee(s51 s51Var) {
        return s51Var == this._delegatee ? this : newDelegatingInstance(s51Var);
    }

    @Override // defpackage.ag2
    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        gs1 gs1Var = this._delegatee;
        if (gs1Var instanceof ag2) {
            ((ag2) gs1Var).resolve(deserializationContext);
        }
    }

    @Override // defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return this._delegatee.supportsUpdate(deserializationConfig);
    }

    @Override // defpackage.s51
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        return this._delegatee.deserialize(jsonParser, deserializationContext, obj);
    }
}
