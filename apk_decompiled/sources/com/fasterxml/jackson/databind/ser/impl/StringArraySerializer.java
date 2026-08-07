package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.ArraySerializerBase;
import com.fasterxml.jackson.databind.type.TypeFactory;
import defpackage.an2;
import defpackage.e41;
import defpackage.f71;
import defpackage.w30;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@e41
public class StringArraySerializer extends ArraySerializerBase<String[]> implements w30 {
    private static final JavaType VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(String.class);
    public static final StringArraySerializer instance = new StringArraySerializer();
    protected final f71 _elementSerializer;

    protected StringArraySerializer() {
        super(String[].class);
        this._elementSerializer = null;
    }

    private void serializeContentsSlow(String[] strArr, JsonGenerator jsonGenerator, an2 an2Var, f71 f71Var) throws IOException {
        for (String str : strArr) {
            if (str == null) {
                an2Var.defaultSerializeNull(jsonGenerator);
            } else {
                f71Var.serialize(str, jsonGenerator, an2Var);
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
    public f71 _withResolved(BeanProperty beanProperty, Boolean bool) {
        return new StringArraySerializer(this, beanProperty, this._elementSerializer, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public ContainerSerializer<?> _withValueTypeSerializer(z63 z63Var) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        visitArrayFormat(y51Var, javaType, JsonFormatTypes.STRING);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, defpackage.w30
    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarSerializerInstance;
        Object objFindContentSerializer;
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
        Boolean boolFindFormatFeature = findFormatFeature(an2Var, beanProperty, String[].class, JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
        if (f71VarSerializerInstance == null) {
            f71VarSerializerInstance = this._elementSerializer;
        }
        f71 f71VarFindContextualConvertingSerializer = findContextualConvertingSerializer(an2Var, beanProperty, f71VarSerializerInstance);
        if (f71VarFindContextualConvertingSerializer == null) {
            f71VarFindContextualConvertingSerializer = an2Var.findContentValueSerializer(String.class, beanProperty);
        }
        f71 f71Var = isDefaultSerializer(f71VarFindContextualConvertingSerializer) ? null : f71VarFindContextualConvertingSerializer;
        return (f71Var == this._elementSerializer && Objects.equals(boolFindFormatFeature, this._unwrapSingle)) ? this : new StringArraySerializer(this, beanProperty, f71Var, boolFindFormatFeature);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public f71 getContentSerializer() {
        return this._elementSerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public JavaType getContentType() {
        return VALUE_TYPE;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    public JsonNode getSchema(an2 an2Var, Type type) {
        return createSchemaNode("array", true).set("items", createSchemaNode("string"));
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(String[] strArr) {
        return strArr.length == 1;
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, String[] strArr) {
        return strArr.length == 0;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public final void serialize(String[] strArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        int length = strArr.length;
        if (length == 1 && ((this._unwrapSingle == null && an2Var.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            serializeContents(strArr, jsonGenerator, an2Var);
            return;
        }
        jsonGenerator.r1(strArr, length);
        serializeContents(strArr, jsonGenerator, an2Var);
        jsonGenerator.R0();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
    public void serializeContents(String[] strArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        if (strArr.length == 0) {
            return;
        }
        f71 f71Var = this._elementSerializer;
        if (f71Var != null) {
            serializeContentsSlow(strArr, jsonGenerator, an2Var, f71Var);
            return;
        }
        for (String str : strArr) {
            if (str == null) {
                jsonGenerator.W0();
            } else {
                jsonGenerator.w1(str);
            }
        }
    }

    public StringArraySerializer(StringArraySerializer stringArraySerializer, BeanProperty beanProperty, f71 f71Var, Boolean bool) {
        super(stringArraySerializer, beanProperty, bool);
        this._elementSerializer = f71Var;
    }
}
