package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import defpackage.ag2;
import defpackage.ay;
import defpackage.f40;
import defpackage.gs1;
import defpackage.m63;
import defpackage.s51;
import defpackage.v30;
import java.io.IOException;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class StdDelegatingDeserializer<T> extends StdDeserializer<T> implements v30, ag2 {
    private static final long serialVersionUID = 1;
    protected final f40 _converter;
    protected final s51 _delegateDeserializer;
    protected final JavaType _delegateType;

    public StdDelegatingDeserializer(f40 f40Var) {
        super((Class<?>) Object.class);
        this._converter = f40Var;
        this._delegateType = null;
        this._delegateDeserializer = null;
    }

    protected T _convertIfNonNull(Object obj) {
        if (obj == null) {
            return null;
        }
        return (T) this._converter.convert(obj);
    }

    protected Object _handleIncompatibleUpdateValue(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        throw new UnsupportedOperationException(String.format("Cannot update object of type %s (using deserializer for type %s)" + obj.getClass().getName(), this._delegateType));
    }

    protected T convertValue(Object obj) {
        return (T) this._converter.convert(obj);
    }

    @Override // defpackage.v30
    public s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        s51 s51Var = this._delegateDeserializer;
        if (s51Var != null) {
            s51 s51VarHandleSecondaryContextualization = deserializationContext.handleSecondaryContextualization(s51Var, beanProperty, this._delegateType);
            return s51VarHandleSecondaryContextualization != this._delegateDeserializer ? withDelegate(this._converter, this._delegateType, s51VarHandleSecondaryContextualization) : this;
        }
        JavaType javaTypeA = this._converter.a(deserializationContext.getTypeFactory());
        return withDelegate(this._converter, javaTypeA, deserializationContext.findContextualValueDeserializer(javaTypeA, beanProperty));
    }

    @Override // defpackage.s51
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objDeserialize = this._delegateDeserializer.deserialize(jsonParser, deserializationContext);
        if (objDeserialize == null) {
            return null;
        }
        return convertValue(objDeserialize);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        Object objDeserialize = this._delegateDeserializer.deserialize(jsonParser, deserializationContext);
        if (objDeserialize == null) {
            return null;
        }
        return convertValue(objDeserialize);
    }

    @Override // defpackage.s51, defpackage.gs1
    public Object getAbsentValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return _convertIfNonNull(this._delegateDeserializer.getAbsentValue(deserializationContext));
    }

    @Override // defpackage.s51
    public s51 getDelegatee() {
        return this._delegateDeserializer;
    }

    @Override // defpackage.s51
    public AccessPattern getEmptyAccessPattern() {
        return this._delegateDeserializer.getEmptyAccessPattern();
    }

    @Override // defpackage.s51
    public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return _convertIfNonNull(this._delegateDeserializer.getEmptyValue(deserializationContext));
    }

    @Override // defpackage.s51
    public Collection<Object> getKnownPropertyNames() {
        return this._delegateDeserializer.getKnownPropertyNames();
    }

    @Override // defpackage.s51
    public AccessPattern getNullAccessPattern() {
        return this._delegateDeserializer.getNullAccessPattern();
    }

    @Override // defpackage.s51, defpackage.gs1
    public T getNullValue(DeserializationContext deserializationContext) throws JsonMappingException {
        return _convertIfNonNull(this._delegateDeserializer.getNullValue(deserializationContext));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Class<?> handledType() {
        return this._delegateDeserializer.handledType();
    }

    @Override // defpackage.s51
    public boolean isCachable() {
        s51 s51Var = this._delegateDeserializer;
        return s51Var != null && s51Var.isCachable();
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return this._delegateDeserializer.logicalType();
    }

    @Override // defpackage.ag2
    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        gs1 gs1Var = this._delegateDeserializer;
        if (gs1Var == null || !(gs1Var instanceof ag2)) {
            return;
        }
        ((ag2) gs1Var).resolve(deserializationContext);
    }

    @Override // defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return this._delegateDeserializer.supportsUpdate(deserializationConfig);
    }

    protected StdDelegatingDeserializer<T> withDelegate(f40 f40Var, JavaType javaType, s51 s51Var) {
        ay.n0(StdDelegatingDeserializer.class, this, "withDelegate");
        return new StdDelegatingDeserializer<>(f40Var, javaType, s51Var);
    }

    @Override // defpackage.s51
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        if (this._delegateType.getRawClass().isAssignableFrom(obj.getClass())) {
            return (T) this._delegateDeserializer.deserialize(jsonParser, deserializationContext, obj);
        }
        return (T) _handleIncompatibleUpdateValue(jsonParser, deserializationContext, obj);
    }

    public StdDelegatingDeserializer(f40 f40Var, JavaType javaType, s51 s51Var) {
        super(javaType);
        this._converter = f40Var;
        this._delegateType = javaType;
        this._delegateDeserializer = s51Var;
    }

    protected StdDelegatingDeserializer(StdDelegatingDeserializer<T> stdDelegatingDeserializer) {
        super(stdDelegatingDeserializer);
        this._converter = stdDelegatingDeserializer._converter;
        this._delegateType = stdDelegatingDeserializer._delegateType;
        this._delegateDeserializer = stdDelegatingDeserializer._delegateDeserializer;
    }
}
