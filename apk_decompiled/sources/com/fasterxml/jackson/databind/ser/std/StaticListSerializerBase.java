package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import defpackage.an2;
import defpackage.f71;
import defpackage.m51;
import defpackage.w30;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class StaticListSerializerBase<T extends Collection<?>> extends StdSerializer<T> implements w30 {
    protected final Boolean _unwrapSingle;

    protected StaticListSerializerBase(Class<?> cls) {
        super(cls, false);
        this._unwrapSingle = null;
    }

    public abstract f71 _withResolved(BeanProperty beanProperty, Boolean bool);

    protected abstract void acceptContentVisitor(m51 m51Var) throws JsonMappingException;

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        y51Var.i(javaType);
    }

    protected abstract JsonNode contentSchema();

    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // defpackage.w30
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
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(an2Var, beanProperty, handledType());
        Boolean feature = valueFindFormatOverrides != null ? valueFindFormatOverrides.getFeature(JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
        f71 f71VarFindContextualConvertingSerializer = findContextualConvertingSerializer(an2Var, beanProperty, f71VarSerializerInstance);
        if (f71VarFindContextualConvertingSerializer == null) {
            f71VarFindContextualConvertingSerializer = an2Var.findContentValueSerializer(String.class, beanProperty);
        }
        if (isDefaultSerializer(f71VarFindContextualConvertingSerializer)) {
            return Objects.equals(feature, this._unwrapSingle) ? this : _withResolved(beanProperty, feature);
        }
        return new CollectionSerializer(an2Var.constructType(String.class), true, null, f71VarFindContextualConvertingSerializer);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    public JsonNode getSchema(an2 an2Var, Type type) {
        return createSchemaNode("array", true).set("items", contentSchema());
    }

    @Override // defpackage.f71
    public abstract void serializeWithType(T t, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException;

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, T t) {
        return t == null || t.isEmpty();
    }

    protected StaticListSerializerBase(StaticListSerializerBase<?> staticListSerializerBase, Boolean bool) {
        super(staticListSerializerBase);
        this._unwrapSingle = bool;
    }
}
