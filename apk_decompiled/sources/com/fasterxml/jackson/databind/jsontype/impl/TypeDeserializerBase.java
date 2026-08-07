package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.NullifyingDeserializer;
import defpackage.ay;
import defpackage.m63;
import defpackage.n63;
import defpackage.s51;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class TypeDeserializerBase extends m63 implements Serializable {
    private static final long serialVersionUID = 1;
    protected final JavaType _baseType;
    protected final JavaType _defaultImpl;
    protected s51 _defaultImplDeserializer;
    protected final Map<String, s51> _deserializers;
    protected final n63 _idResolver;
    protected final BeanProperty _property;
    protected final boolean _typeIdVisible;
    protected final String _typePropertyName;

    protected TypeDeserializerBase(JavaType javaType, n63 n63Var, String str, boolean z, JavaType javaType2) {
        this._baseType = javaType;
        this._idResolver = n63Var;
        this._typePropertyName = ay.Z(str);
        this._typeIdVisible = z;
        this._deserializers = new ConcurrentHashMap(16, 0.75f, 2);
        this._defaultImpl = javaType2;
        this._property = null;
    }

    @Deprecated
    protected Object _deserializeWithNativeTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserializeWithNativeTypeId(jsonParser, deserializationContext, jsonParser.X0());
    }

    protected final s51 _findDefaultImplDeserializer(DeserializationContext deserializationContext) throws IOException {
        s51 s51Var;
        JavaType javaType = this._defaultImpl;
        if (javaType == null) {
            if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE)) {
                return null;
            }
            return NullifyingDeserializer.instance;
        }
        if (ay.J(javaType.getRawClass())) {
            return NullifyingDeserializer.instance;
        }
        synchronized (this._defaultImpl) {
            try {
                if (this._defaultImplDeserializer == null) {
                    this._defaultImplDeserializer = deserializationContext.findContextualValueDeserializer(this._defaultImpl, this._property);
                }
                s51Var = this._defaultImplDeserializer;
            } catch (Throwable th) {
                throw th;
            }
        }
        return s51Var;
    }

    protected final s51 _findDeserializer(DeserializationContext deserializationContext, String str) throws IOException {
        s51 s51VarFindContextualValueDeserializer;
        s51 s51Var_findDefaultImplDeserializer = this._deserializers.get(str);
        if (s51Var_findDefaultImplDeserializer == null) {
            JavaType javaTypeD = this._idResolver.d(deserializationContext, str);
            if (javaTypeD == null) {
                s51Var_findDefaultImplDeserializer = _findDefaultImplDeserializer(deserializationContext);
                if (s51Var_findDefaultImplDeserializer == null) {
                    JavaType javaType_handleUnknownTypeId = _handleUnknownTypeId(deserializationContext, str);
                    if (javaType_handleUnknownTypeId == null) {
                        return NullifyingDeserializer.instance;
                    }
                    s51VarFindContextualValueDeserializer = deserializationContext.findContextualValueDeserializer(javaType_handleUnknownTypeId, this._property);
                }
                this._deserializers.put(str, s51Var_findDefaultImplDeserializer);
            } else {
                JavaType javaType = this._baseType;
                if (javaType != null && javaType.getClass() == javaTypeD.getClass() && !javaTypeD.hasGenericTypes()) {
                    try {
                        javaTypeD = deserializationContext.constructSpecializedType(this._baseType, javaTypeD.getRawClass());
                    } catch (IllegalArgumentException e) {
                        throw deserializationContext.invalidTypeIdException(this._baseType, str, e.getMessage());
                    }
                }
                s51VarFindContextualValueDeserializer = deserializationContext.findContextualValueDeserializer(javaTypeD, this._property);
            }
            s51Var_findDefaultImplDeserializer = s51VarFindContextualValueDeserializer;
            this._deserializers.put(str, s51Var_findDefaultImplDeserializer);
        }
        return s51Var_findDefaultImplDeserializer;
    }

    protected JavaType _handleMissingTypeId(DeserializationContext deserializationContext, String str) throws IOException {
        return deserializationContext.handleMissingTypeId(this._baseType, this._idResolver, str);
    }

    protected JavaType _handleUnknownTypeId(DeserializationContext deserializationContext, String str) throws IOException {
        String str2;
        String strB = this._idResolver.b();
        if (strB == null) {
            str2 = "type ids are not statically known";
        } else {
            str2 = "known type ids = " + strB;
        }
        BeanProperty beanProperty = this._property;
        if (beanProperty != null) {
            str2 = String.format("%s (for POJO property '%s')", str2, beanProperty.getName());
        }
        return deserializationContext.handleUnknownTypeId(this._baseType, str, this._idResolver, str2);
    }

    public JavaType baseType() {
        return this._baseType;
    }

    public String baseTypeName() {
        return this._baseType.getRawClass().getName();
    }

    @Override // defpackage.m63
    public abstract m63 forProperty(BeanProperty beanProperty);

    @Override // defpackage.m63
    public Class<?> getDefaultImpl() {
        return ay.d0(this._defaultImpl);
    }

    @Override // defpackage.m63
    public final String getPropertyName() {
        return this._typePropertyName;
    }

    @Override // defpackage.m63
    public n63 getTypeIdResolver() {
        return this._idResolver;
    }

    @Override // defpackage.m63
    public abstract JsonTypeInfo.As getTypeInclusion();

    @Override // defpackage.m63
    public boolean hasDefaultImpl() {
        return this._defaultImpl != null;
    }

    public String toString() {
        return '[' + getClass().getName() + "; base-type:" + this._baseType + "; id-resolver: " + this._idResolver + ']';
    }

    protected Object _deserializeWithNativeTypeId(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        s51 s51Var_findDeserializer;
        if (obj == null) {
            s51Var_findDeserializer = _findDefaultImplDeserializer(deserializationContext);
            if (s51Var_findDeserializer == null) {
                return deserializationContext.reportInputMismatch(baseType(), "No (native) type id found when one was expected for polymorphic type handling", new Object[0]);
            }
        } else {
            s51Var_findDeserializer = _findDeserializer(deserializationContext, obj instanceof String ? (String) obj : String.valueOf(obj));
        }
        return s51Var_findDeserializer.deserialize(jsonParser, deserializationContext);
    }

    protected TypeDeserializerBase(TypeDeserializerBase typeDeserializerBase, BeanProperty beanProperty) {
        this._baseType = typeDeserializerBase._baseType;
        this._idResolver = typeDeserializerBase._idResolver;
        this._typePropertyName = typeDeserializerBase._typePropertyName;
        this._typeIdVisible = typeDeserializerBase._typeIdVisible;
        this._deserializers = typeDeserializerBase._deserializers;
        this._defaultImpl = typeDeserializerBase._defaultImpl;
        this._defaultImplDeserializer = typeDeserializerBase._defaultImplDeserializer;
        this._property = beanProperty;
    }
}
