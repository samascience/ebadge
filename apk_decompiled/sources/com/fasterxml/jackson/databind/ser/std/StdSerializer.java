package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tencent.open.SocialConstants;
import defpackage.an2;
import defpackage.ay;
import defpackage.f40;
import defpackage.f71;
import defpackage.i82;
import defpackage.kn0;
import defpackage.tk2;
import defpackage.y51;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class StdSerializer<T> extends f71 implements tk2, Serializable {
    private static final Object KEY_CONTENT_CONVERTER_LOCK = new Object();
    private static final long serialVersionUID = 1;
    protected final Class<T> _handledType;

    protected StdSerializer(Class<T> cls) {
        this._handledType = cls;
    }

    protected static final boolean _neitherNull(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? false : true;
    }

    protected static final boolean _nonEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty()) ? false : true;
    }

    @Override // defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        y51Var.e(javaType);
    }

    protected ObjectNode createSchemaNode(String str) {
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        objectNode.put(SocialConstants.PARAM_TYPE, str);
        return objectNode;
    }

    protected f71 findAnnotatedContentSerializer(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        Object objFindContentSerializer;
        if (beanProperty == null) {
            return null;
        }
        AnnotatedMember member = beanProperty.getMember();
        AnnotationIntrospector annotationIntrospector = an2Var.getAnnotationIntrospector();
        if (member == null || (objFindContentSerializer = annotationIntrospector.findContentSerializer(member)) == null) {
            return null;
        }
        return an2Var.serializerInstance(member, objFindContentSerializer);
    }

    protected f71 findContextualConvertingSerializer(an2 an2Var, BeanProperty beanProperty, f71 f71Var) throws JsonMappingException {
        Object obj = KEY_CONTENT_CONVERTER_LOCK;
        Map identityHashMap = (Map) an2Var.getAttribute(obj);
        if (identityHashMap == null) {
            identityHashMap = new IdentityHashMap();
            an2Var.m0setAttribute(obj, (Object) identityHashMap);
        } else if (identityHashMap.get(beanProperty) != null) {
            return f71Var;
        }
        identityHashMap.put(beanProperty, Boolean.TRUE);
        try {
            f71 f71VarFindConvertingContentSerializer = findConvertingContentSerializer(an2Var, beanProperty, f71Var);
            return f71VarFindConvertingContentSerializer != null ? an2Var.handleSecondaryContextualization(f71VarFindConvertingContentSerializer, beanProperty) : f71Var;
        } finally {
            identityHashMap.remove(beanProperty);
        }
    }

    @Deprecated
    protected f71 findConvertingContentSerializer(an2 an2Var, BeanProperty beanProperty, f71 f71Var) throws JsonMappingException {
        AnnotatedMember member;
        Object objFindSerializationContentConverter;
        AnnotationIntrospector annotationIntrospector = an2Var.getAnnotationIntrospector();
        if (!_neitherNull(annotationIntrospector, beanProperty) || (member = beanProperty.getMember()) == null || (objFindSerializationContentConverter = annotationIntrospector.findSerializationContentConverter(member)) == null) {
            return f71Var;
        }
        f40 f40VarConverterInstance = an2Var.converterInstance(beanProperty.getMember(), objFindSerializationContentConverter);
        JavaType javaTypeB = f40VarConverterInstance.b(an2Var.getTypeFactory());
        if (f71Var == null && !javaTypeB.isJavaLangObject()) {
            f71Var = an2Var.findValueSerializer(javaTypeB);
        }
        return new StdDelegatingSerializer(f40VarConverterInstance, javaTypeB, f71Var);
    }

    protected Boolean findFormatFeature(an2 an2Var, BeanProperty beanProperty, Class<?> cls, JsonFormat.Feature feature) {
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(an2Var, beanProperty, cls);
        if (valueFindFormatOverrides != null) {
            return valueFindFormatOverrides.getFeature(feature);
        }
        return null;
    }

    protected JsonFormat.Value findFormatOverrides(an2 an2Var, BeanProperty beanProperty, Class<?> cls) {
        return beanProperty != null ? beanProperty.findPropertyFormat(an2Var.getConfig(), cls) : an2Var.getDefaultPropertyFormat(cls);
    }

    protected JsonInclude.Value findIncludeOverrides(an2 an2Var, BeanProperty beanProperty, Class<?> cls) {
        return beanProperty != null ? beanProperty.findPropertyInclusion(an2Var.getConfig(), cls) : an2Var.getDefaultPropertyInclusion(cls);
    }

    protected i82 findPropertyFilter(an2 an2Var, Object obj, Object obj2) throws JsonMappingException {
        kn0 filterProvider = an2Var.getFilterProvider();
        if (filterProvider != null) {
            return filterProvider.findPropertyFilter(obj, obj2);
        }
        return (i82) an2Var.reportBadDefinition((Class<?>) handledType(), "Cannot resolve PropertyFilter with id '" + obj + "'; no FilterProvider configured");
    }

    public JsonNode getSchema(an2 an2Var, Type type) throws JsonMappingException {
        return createSchemaNode("string");
    }

    @Override // defpackage.f71
    public Class<T> handledType() {
        return this._handledType;
    }

    protected boolean isDefaultSerializer(f71 f71Var) {
        return ay.O(f71Var);
    }

    @Override // defpackage.f71
    public abstract void serialize(T t, JsonGenerator jsonGenerator, an2 an2Var) throws IOException;

    protected void visitArrayFormat(y51 y51Var, JavaType javaType, f71 f71Var, JavaType javaType2) throws JsonMappingException {
        y51Var.i(javaType);
        if (_neitherNull(null, f71Var)) {
            throw null;
        }
    }

    protected void visitFloatFormat(y51 y51Var, JavaType javaType, JsonParser.NumberType numberType) throws JsonMappingException {
        y51Var.f(javaType);
    }

    protected void visitIntFormat(y51 y51Var, JavaType javaType, JsonParser.NumberType numberType) throws JsonMappingException {
        y51Var.c(javaType);
        if (_neitherNull(null, numberType)) {
            throw null;
        }
    }

    protected void visitStringFormat(y51 y51Var, JavaType javaType) throws JsonMappingException {
        y51Var.d(javaType);
    }

    public void wrapAndThrow(an2 an2Var, Throwable th, Object obj, String str) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        ay.h0(th);
        boolean z = an2Var == null || an2Var.isEnabled(SerializationFeature.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z || !(th instanceof JacksonException)) {
                throw ((IOException) th);
            }
        } else if (!z) {
            ay.j0(th);
        }
        throw JsonMappingException.wrapWithPath(th, obj, str);
    }

    public JsonNode getSchema(an2 an2Var, Type type, boolean z) throws JsonMappingException {
        ObjectNode objectNode = (ObjectNode) getSchema(an2Var, type);
        if (!z) {
            objectNode.put("required", !z);
        }
        return objectNode;
    }

    protected void visitStringFormat(y51 y51Var, JavaType javaType, JsonValueFormat jsonValueFormat) throws JsonMappingException {
        y51Var.d(javaType);
    }

    protected StdSerializer(JavaType javaType) {
        this._handledType = (Class<T>) javaType.getRawClass();
    }

    protected ObjectNode createSchemaNode(String str, boolean z) {
        ObjectNode objectNodeCreateSchemaNode = createSchemaNode(str);
        if (!z) {
            objectNodeCreateSchemaNode.put("required", !z);
        }
        return objectNodeCreateSchemaNode;
    }

    protected void visitArrayFormat(y51 y51Var, JavaType javaType, JsonFormatTypes jsonFormatTypes) throws JsonMappingException {
        y51Var.i(javaType);
    }

    protected void visitIntFormat(y51 y51Var, JavaType javaType, JsonParser.NumberType numberType, JsonValueFormat jsonValueFormat) throws JsonMappingException {
        y51Var.c(javaType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected StdSerializer(Class<?> cls, boolean z) {
        this._handledType = cls;
    }

    protected StdSerializer(StdSerializer<?> stdSerializer) {
        this._handledType = (Class<T>) stdSerializer._handledType;
    }

    public void wrapAndThrow(an2 an2Var, Throwable th, Object obj, int i) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        ay.h0(th);
        boolean z = an2Var == null || an2Var.isEnabled(SerializationFeature.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z || !(th instanceof JacksonException)) {
                throw ((IOException) th);
            }
        } else if (!z) {
            ay.j0(th);
        }
        throw JsonMappingException.wrapWithPath(th, obj, i);
    }
}
