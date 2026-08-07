package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import defpackage.an2;
import defpackage.ay;
import defpackage.d71;
import defpackage.e41;
import defpackage.f71;
import defpackage.tk2;
import defpackage.w30;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
@e41
public class JsonValueSerializer extends StdSerializer<Object> implements w30, tk2 {
    protected final AnnotatedMember _accessor;
    protected transient com.fasterxml.jackson.databind.ser.impl.a _dynamicSerializers;
    protected final boolean _forceTypeInformation;
    protected final BeanProperty _property;
    protected final f71 _valueSerializer;
    protected final JavaType _valueType;
    protected final z63 _valueTypeSerializer;

    static class a extends z63 {
        protected final z63 a;
        protected final Object b;

        public a(z63 z63Var, Object obj) {
            this.a = z63Var;
            this.b = obj;
        }

        @Override // defpackage.z63
        public z63 a(BeanProperty beanProperty) {
            throw new UnsupportedOperationException();
        }

        @Override // defpackage.z63
        public String b() {
            return this.a.b();
        }

        @Override // defpackage.z63
        public JsonTypeInfo.As c() {
            return this.a.c();
        }

        @Override // defpackage.z63
        public WritableTypeId g(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) {
            writableTypeId.a = this.b;
            return this.a.g(jsonGenerator, writableTypeId);
        }

        @Override // defpackage.z63
        public WritableTypeId h(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) {
            return this.a.h(jsonGenerator, writableTypeId);
        }
    }

    public JsonValueSerializer(AnnotatedMember annotatedMember, z63 z63Var, f71 f71Var) {
        super(annotatedMember.getType());
        this._accessor = annotatedMember;
        this._valueType = annotatedMember.getType();
        this._valueTypeSerializer = z63Var;
        this._valueSerializer = f71Var;
        this._property = null;
        this._forceTypeInformation = true;
        this._dynamicSerializers = com.fasterxml.jackson.databind.ser.impl.a.c();
    }

    private static final Class<Object> _notNullClass(Class<?> cls) {
        return cls == null ? Object.class : cls;
    }

    protected boolean _acceptJsonFormatVisitorForEnum(y51 y51Var, JavaType javaType, Class<?> cls) throws JsonMappingException {
        y51Var.d(javaType);
        return true;
    }

    protected f71 _findDynamicSerializer(an2 an2Var, Class<?> cls) throws JsonMappingException {
        f71 f71VarK = this._dynamicSerializers.k(cls);
        if (f71VarK != null) {
            return f71VarK;
        }
        if (!this._valueType.hasGenericTypes()) {
            f71 f71VarFindPrimaryPropertySerializer = an2Var.findPrimaryPropertySerializer(cls, this._property);
            this._dynamicSerializers = this._dynamicSerializers.b(cls, f71VarFindPrimaryPropertySerializer).b;
            return f71VarFindPrimaryPropertySerializer;
        }
        JavaType javaTypeConstructSpecializedType = an2Var.constructSpecializedType(this._valueType, cls);
        f71 f71VarFindPrimaryPropertySerializer2 = an2Var.findPrimaryPropertySerializer(javaTypeConstructSpecializedType, this._property);
        this._dynamicSerializers = this._dynamicSerializers.a(javaTypeConstructSpecializedType, f71VarFindPrimaryPropertySerializer2).b;
        return f71VarFindPrimaryPropertySerializer2;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        Class<?> declaringClass = this._accessor.getDeclaringClass();
        if (declaringClass != null && ay.L(declaringClass) && _acceptJsonFormatVisitorForEnum(y51Var, javaType, declaringClass)) {
            return;
        }
        f71 f71VarFindTypedValueSerializer = this._valueSerializer;
        if (f71VarFindTypedValueSerializer == null && (f71VarFindTypedValueSerializer = y51Var.b().findTypedValueSerializer(this._valueType, false, this._property)) == null) {
            y51Var.e(javaType);
        } else {
            f71VarFindTypedValueSerializer.acceptJsonFormatVisitor(y51Var, this._valueType);
        }
    }

    @Override // defpackage.w30
    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        z63 z63VarA = this._valueTypeSerializer;
        if (z63VarA != null) {
            z63VarA = z63VarA.a(beanProperty);
        }
        f71 f71Var = this._valueSerializer;
        if (f71Var != null) {
            return withResolved(beanProperty, z63VarA, an2Var.handlePrimaryContextualization(f71Var, beanProperty), this._forceTypeInformation);
        }
        if (!an2Var.isEnabled(MapperFeature.USE_STATIC_TYPING) && !this._valueType.isFinal()) {
            return beanProperty != this._property ? withResolved(beanProperty, z63VarA, f71Var, this._forceTypeInformation) : this;
        }
        f71 f71VarFindPrimaryPropertySerializer = an2Var.findPrimaryPropertySerializer(this._valueType, beanProperty);
        return withResolved(beanProperty, z63VarA, f71VarFindPrimaryPropertySerializer, isNaturalTypeWithStdHandling(this._valueType.getRawClass(), f71VarFindPrimaryPropertySerializer));
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    public JsonNode getSchema(an2 an2Var, Type type) throws JsonMappingException {
        Object obj = this._valueSerializer;
        return obj instanceof tk2 ? ((tk2) obj).getSchema(an2Var, null) : d71.a();
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, Object obj) {
        Object value = this._accessor.getValue(obj);
        if (value == null) {
            return true;
        }
        f71 f71Var_findDynamicSerializer = this._valueSerializer;
        if (f71Var_findDynamicSerializer == null) {
            try {
                f71Var_findDynamicSerializer = _findDynamicSerializer(an2Var, value.getClass());
            } catch (JsonMappingException e) {
                throw new RuntimeJsonMappingException(e);
            }
        }
        return f71Var_findDynamicSerializer.isEmpty(an2Var, value);
    }

    protected boolean isNaturalTypeWithStdHandling(Class<?> cls, f71 f71Var) {
        if (cls.isPrimitive()) {
            if (cls != Integer.TYPE && cls != Boolean.TYPE && cls != Double.TYPE) {
                return false;
            }
        } else if (cls != String.class && cls != Integer.class && cls != Boolean.class && cls != Double.class) {
            return false;
        }
        return isDefaultSerializer(f71Var);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        Object value;
        try {
            value = this._accessor.getValue(obj);
        } catch (Exception e) {
            wrapAndThrow(an2Var, e, obj, this._accessor.getName() + "()");
            value = null;
        }
        if (value == null) {
            an2Var.defaultSerializeNull(jsonGenerator);
            return;
        }
        f71 f71Var_findDynamicSerializer = this._valueSerializer;
        if (f71Var_findDynamicSerializer == null) {
            f71Var_findDynamicSerializer = _findDynamicSerializer(an2Var, value.getClass());
        }
        z63 z63Var = this._valueTypeSerializer;
        if (z63Var != null) {
            f71Var_findDynamicSerializer.serializeWithType(value, jsonGenerator, an2Var, z63Var);
        } else {
            f71Var_findDynamicSerializer.serialize(value, jsonGenerator, an2Var);
        }
    }

    @Override // defpackage.f71
    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        Object value;
        try {
            value = this._accessor.getValue(obj);
        } catch (Exception e) {
            wrapAndThrow(an2Var, e, obj, this._accessor.getName() + "()");
            value = null;
        }
        if (value == null) {
            an2Var.defaultSerializeNull(jsonGenerator);
            return;
        }
        f71 f71Var_findDynamicSerializer = this._valueSerializer;
        if (f71Var_findDynamicSerializer == null) {
            f71Var_findDynamicSerializer = _findDynamicSerializer(an2Var, value.getClass());
        } else if (this._forceTypeInformation) {
            WritableTypeId writableTypeIdG = z63Var.g(jsonGenerator, z63Var.d(obj, JsonToken.VALUE_STRING));
            f71Var_findDynamicSerializer.serialize(value, jsonGenerator, an2Var);
            z63Var.h(jsonGenerator, writableTypeIdG);
            return;
        }
        f71Var_findDynamicSerializer.serializeWithType(value, jsonGenerator, an2Var, new a(z63Var, obj));
    }

    public String toString() {
        return "(@JsonValue serializer for method " + this._accessor.getDeclaringClass() + "#" + this._accessor.getName() + ")";
    }

    protected JsonValueSerializer withResolved(BeanProperty beanProperty, z63 z63Var, f71 f71Var, boolean z) {
        return (this._property == beanProperty && this._valueTypeSerializer == z63Var && this._valueSerializer == f71Var && z == this._forceTypeInformation) ? this : new JsonValueSerializer(this, beanProperty, z63Var, f71Var, z);
    }

    @Deprecated
    public JsonValueSerializer(AnnotatedMember annotatedMember, f71 f71Var) {
        this(annotatedMember, null, f71Var);
    }

    public JsonValueSerializer(JsonValueSerializer jsonValueSerializer, BeanProperty beanProperty, z63 z63Var, f71 f71Var, boolean z) {
        super(_notNullClass(jsonValueSerializer.handledType()));
        this._accessor = jsonValueSerializer._accessor;
        this._valueType = jsonValueSerializer._valueType;
        this._valueTypeSerializer = z63Var;
        this._valueSerializer = f71Var;
        this._property = beanProperty;
        this._forceTypeInformation = z;
        this._dynamicSerializers = com.fasterxml.jackson.databind.ser.impl.a.c();
    }
}
