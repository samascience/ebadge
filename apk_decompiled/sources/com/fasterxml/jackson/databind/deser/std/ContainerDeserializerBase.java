package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.AccessPattern;
import defpackage.ay;
import defpackage.gs1;
import defpackage.s51;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContainerDeserializerBase<T> extends StdDeserializer<T> {
    protected final JavaType _containerType;
    protected final gs1 _nullProvider;
    protected final boolean _skipNullValues;
    protected final Boolean _unwrapSingle;

    protected ContainerDeserializerBase(JavaType javaType, gs1 gs1Var, Boolean bool) {
        super(javaType);
        this._containerType = javaType;
        this._unwrapSingle = bool;
        this._nullProvider = gs1Var;
        this._skipNullValues = NullsConstantProvider.isSkipper(gs1Var);
    }

    @Override // defpackage.s51
    public SettableBeanProperty findBackReference(String str) {
        s51 contentDeserializer = getContentDeserializer();
        if (contentDeserializer != null) {
            return contentDeserializer.findBackReference(str);
        }
        throw new IllegalArgumentException(String.format("Cannot handle managed/back reference '%s': type: container deserializer of type %s returned null for 'getContentDeserializer()'", str, getClass().getName()));
    }

    public abstract s51 getContentDeserializer();

    public JavaType getContentType() {
        JavaType javaType = this._containerType;
        return javaType == null ? TypeFactory.unknownType() : javaType.mo15getContentType();
    }

    @Override // defpackage.s51
    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.DYNAMIC;
    }

    @Override // defpackage.s51
    public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        ValueInstantiator valueInstantiator = getValueInstantiator();
        if (valueInstantiator == null || !valueInstantiator.canCreateUsingDefault()) {
            JavaType valueType = getValueType();
            deserializationContext.reportBadDefinition(valueType, String.format("Cannot create empty instance of %s, no default Creator", valueType));
        }
        try {
            return valueInstantiator.createUsingDefault(deserializationContext);
        } catch (IOException e) {
            return ay.g0(deserializationContext, e);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public JavaType getValueType() {
        return this._containerType;
    }

    @Override // defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return Boolean.TRUE;
    }

    @Deprecated
    protected <BOGUS> BOGUS wrapAndThrow(Throwable th, Object obj, String str) throws IOException {
        return (BOGUS) wrapAndThrow(null, th, obj, str);
    }

    protected <BOGUS> BOGUS wrapAndThrow(DeserializationContext deserializationContext, Throwable th, Object obj, String str) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        ay.h0(th);
        if (deserializationContext != null && !deserializationContext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS)) {
            ay.j0(th);
        }
        if (!(th instanceof IOException) || (th instanceof JsonMappingException)) {
            throw JsonMappingException.wrapWithPath(th, obj, (String) ay.Y(str, "N/A"));
        }
        throw ((IOException) th);
    }

    protected ContainerDeserializerBase(JavaType javaType) {
        this(javaType, (gs1) null, (Boolean) null);
    }

    protected ContainerDeserializerBase(ContainerDeserializerBase<?> containerDeserializerBase) {
        this(containerDeserializerBase, containerDeserializerBase._nullProvider, containerDeserializerBase._unwrapSingle);
    }

    protected ContainerDeserializerBase(ContainerDeserializerBase<?> containerDeserializerBase, gs1 gs1Var, Boolean bool) {
        super(containerDeserializerBase._containerType);
        this._containerType = containerDeserializerBase._containerType;
        this._nullProvider = gs1Var;
        this._unwrapSingle = bool;
        this._skipNullValues = NullsConstantProvider.isSkipper(gs1Var);
    }
}
