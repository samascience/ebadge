package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.a;
import defpackage.an2;
import defpackage.d71;
import defpackage.f71;
import defpackage.tk2;
import defpackage.w30;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class AsArraySerializerBase<T> extends ContainerSerializer<T> implements w30 {
    protected a _dynamicSerializers;
    protected final f71 _elementSerializer;
    protected final JavaType _elementType;
    protected final BeanProperty _property;
    protected final boolean _staticTyping;
    protected final Boolean _unwrapSingle;
    protected final z63 _valueTypeSerializer;

    protected AsArraySerializerBase(Class<?> cls, JavaType javaType, boolean z, z63 z63Var, f71 f71Var) {
        this(cls, javaType, z, z63Var, null, f71Var, null);
    }

    protected final f71 _findAndAddDynamic(a aVar, Class<?> cls, an2 an2Var) throws JsonMappingException {
        a.d dVarI = aVar.i(cls, an2Var, this._property);
        a aVar2 = dVarI.b;
        if (aVar != aVar2) {
            this._dynamicSerializers = aVar2;
        }
        return dVarI.a;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        f71 f71VarFindContentValueSerializer = this._elementSerializer;
        if (f71VarFindContentValueSerializer == null && this._elementType != null) {
            f71VarFindContentValueSerializer = y51Var.b().findContentValueSerializer(this._elementType, this._property);
        }
        visitArrayFormat(y51Var, javaType, f71VarFindContentValueSerializer, this._elementType);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    @Override // defpackage.w30
    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarSerializerInstance;
        JavaType javaType;
        Object objFindContentSerializer;
        z63 z63VarA = this._valueTypeSerializer;
        if (z63VarA != null) {
            z63VarA = z63VarA.a(beanProperty);
        }
        if (beanProperty != null) {
            AnnotationIntrospector annotationIntrospector = an2Var.getAnnotationIntrospector();
            AnnotatedMember member = beanProperty.getMember();
            if (member == null || (objFindContentSerializer = annotationIntrospector.findContentSerializer(member)) == null) {
                f71VarSerializerInstance = null;
            } else {
                f71VarSerializerInstance = an2Var.serializerInstance(member, objFindContentSerializer);
            }
        } else {
            f71VarSerializerInstance = null;
        }
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(an2Var, beanProperty, handledType());
        Boolean feature = valueFindFormatOverrides != null ? valueFindFormatOverrides.getFeature(JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
        if (f71VarSerializerInstance == null) {
            f71VarSerializerInstance = this._elementSerializer;
        }
        f71 f71VarFindContextualConvertingSerializer = findContextualConvertingSerializer(an2Var, beanProperty, f71VarSerializerInstance);
        if (f71VarFindContextualConvertingSerializer == null && (javaType = this._elementType) != null && this._staticTyping && !javaType.isJavaLangObject()) {
            f71VarFindContextualConvertingSerializer = an2Var.findContentValueSerializer(this._elementType, beanProperty);
        }
        return (f71VarFindContextualConvertingSerializer == this._elementSerializer && beanProperty == this._property && this._valueTypeSerializer == z63VarA && Objects.equals(this._unwrapSingle, feature)) ? this : withResolved(beanProperty, z63VarA, f71VarFindContextualConvertingSerializer, feature);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public f71 getContentSerializer() {
        return this._elementSerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public JavaType getContentType() {
        return this._elementType;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    public JsonNode getSchema(an2 an2Var, Type type) throws JsonMappingException {
        ObjectNode objectNodeCreateSchemaNode = createSchemaNode("array", true);
        Object obj = this._elementSerializer;
        if (obj != null) {
            JsonNode schema = obj instanceof tk2 ? ((tk2) obj).getSchema(an2Var, null) : null;
            if (schema == null) {
                schema = d71.a();
            }
            objectNodeCreateSchemaNode.set("items", schema);
        }
        return objectNodeCreateSchemaNode;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(T t, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        if (an2Var.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && hasSingleElement(t)) {
            serializeContents(t, jsonGenerator, an2Var);
            return;
        }
        jsonGenerator.q1(t);
        serializeContents(t, jsonGenerator, an2Var);
        jsonGenerator.R0();
    }

    protected abstract void serializeContents(T t, JsonGenerator jsonGenerator, an2 an2Var) throws IOException;

    @Override // defpackage.f71
    public void serializeWithType(T t, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        WritableTypeId writableTypeIdG = z63Var.g(jsonGenerator, z63Var.d(t, JsonToken.START_ARRAY));
        jsonGenerator.y0(t);
        serializeContents(t, jsonGenerator, an2Var);
        z63Var.h(jsonGenerator, writableTypeIdG);
    }

    @Deprecated
    public final AsArraySerializerBase<T> withResolved(BeanProperty beanProperty, z63 z63Var, f71 f71Var) {
        return withResolved(beanProperty, z63Var, f71Var, this._unwrapSingle);
    }

    public abstract AsArraySerializerBase<T> withResolved(BeanProperty beanProperty, z63 z63Var, f71 f71Var, Boolean bool);

    @Deprecated
    protected AsArraySerializerBase(Class<?> cls, JavaType javaType, boolean z, z63 z63Var, BeanProperty beanProperty, f71 f71Var) {
        this(cls, javaType, z, z63Var, beanProperty, f71Var, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected AsArraySerializerBase(Class<?> cls, JavaType javaType, boolean z, z63 z63Var, BeanProperty beanProperty, f71 f71Var, Boolean bool) {
        super(cls, false);
        boolean z2 = false;
        this._elementType = javaType;
        if (z || (javaType != null && javaType.isFinal())) {
            z2 = true;
        }
        this._staticTyping = z2;
        this._valueTypeSerializer = z63Var;
        this._property = beanProperty;
        this._elementSerializer = f71Var;
        this._dynamicSerializers = a.c();
        this._unwrapSingle = bool;
    }

    protected final f71 _findAndAddDynamic(a aVar, JavaType javaType, an2 an2Var) throws JsonMappingException {
        a.d dVarH = aVar.h(javaType, an2Var, this._property);
        a aVar2 = dVarH.b;
        if (aVar != aVar2) {
            this._dynamicSerializers = aVar2;
        }
        return dVarH.a;
    }

    protected AsArraySerializerBase(AsArraySerializerBase<?> asArraySerializerBase, BeanProperty beanProperty, z63 z63Var, f71 f71Var, Boolean bool) {
        super(asArraySerializerBase);
        this._elementType = asArraySerializerBase._elementType;
        this._staticTyping = asArraySerializerBase._staticTyping;
        this._valueTypeSerializer = z63Var;
        this._property = beanProperty;
        this._elementSerializer = f71Var;
        this._dynamicSerializers = a.c();
        this._unwrapSingle = bool;
    }

    @Deprecated
    protected AsArraySerializerBase(AsArraySerializerBase<?> asArraySerializerBase, BeanProperty beanProperty, z63 z63Var, f71 f71Var) {
        this(asArraySerializerBase, beanProperty, z63Var, f71Var, asArraySerializerBase._unwrapSingle);
    }
}
